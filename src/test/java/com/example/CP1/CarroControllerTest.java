package com.example.CP1;

import com.example.CP1.controller.CarroController;
import com.example.CP1.model.Carro;
import com.example.CP1.service.CarroService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarroService carroService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class Config {
        @Bean
        public CarroService carroService() {
            return mock(CarroService.class);
        }

        @Bean
        public CarroController carroController(CarroService carroService) {
            return new CarroController(carroService);
        }
    }

    @Test
    public void testGetCarrosPotentes() throws Exception {
        Carro c1 = new Carro("Ferrari", "F8", 2022, 710, 5.0, "combustao", 1500000);
        Carro c2 = new Carro("Lamborghini", "Huracan", 2022, 640, 4.8, "combustao", 1800000);
        when(carroService.listarMaisPotentes()).thenReturn(Arrays.asList(c1, c2));

        mockMvc.perform(get("/carros/potencia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].marca").value("Ferrari"));
    }

    @Test
    public void testGetCarrosEconomicos() throws Exception {
        Carro c1 = new Carro("Tesla", "Model 3", 2022, 300, 15.0, "eletrico", 250000);
        when(carroService.listarMaisEconomicos()).thenReturn(Arrays.asList(c1));

        mockMvc.perform(get("/carros/economia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelo").value("Model 3"));
    }

    @Test
    public void testGetCarrosEletricos() throws Exception {
        Carro c1 = new Carro("Tesla", "Model S", 2023, 670, 18.0, "eletrico", 450000);
        when(carroService.listarPorTipo("eletrico")).thenReturn(Arrays.asList(c1));

        mockMvc.perform(get("/carros/eletricos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipo").value("eletrico"));
    }

    @Test
    public void testGetCarroPorId() throws Exception {
        Carro c1 = new Carro("Toyota", "Corolla", 2022, 140, 12.0, "combustao", 100000);
        when(carroService.buscarPorId(1L)).thenReturn(c1);

        mockMvc.perform(get("/carros/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Corolla"));
    }

    @Test
    public void testCriarCarro() throws Exception {
        Carro carro = new Carro("Hyundai", "HB20", 2023, 120, 13.0, "combustao", 85000);
        when(carroService.salvar(any(Carro.class))).thenReturn(carro);

        mockMvc.perform(post("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("HB20"));
    }

    @Test
    public void testAtualizarCarro() throws Exception {
        Carro atualizado = new Carro("Hyundai", "HB20S", 2023, 130, 14.0, "combustao", 90000);
        when(carroService.atualizar(eq(1L), any(Carro.class))).thenReturn(atualizado);

        mockMvc.perform(put("/carros/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(atualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("HB20S"));
    }
}
