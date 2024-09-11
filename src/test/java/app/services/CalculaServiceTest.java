package app.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculaServiceTest {

    @Autowired
    CalculaService calculaService;

    @Test
    @DisplayName("TesteSoma")
    void cenario01() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        int soma = calculaService.soma(numeros);
        assertEquals(15, soma);
    }

    @Test
    @DisplayName("TesteMedia")
    void cenario02() {
        List<Integer> numeros = Arrays.asList(2, 4, 6, 8);
        double media = calculaService.media(numeros);
        assertEquals(5.0, media);
    }

    @Test
    @DisplayName("TesteMaior")
    void cenario03() {
        List<Integer> numeros = Arrays.asList(3, 9, 2, 5, 6);
        int maior = calculaService.encontrarMaior(numeros);
        assertEquals(9, maior);
    }

    @Test
    @DisplayName("TesteMenor")
    void cenari04() {
        List<Integer> numeros = Arrays.asList(3, 9, 2, 5, 6);
        int menor = calculaService.encontrarMenor(numeros);
        assertEquals(2, menor);
    }

    @Test
    @DisplayName("TesteNumerosRepetidos")
    void cenario05() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 4);
        List<Integer> repetidos = calculaService.encontrarNumerosRepetidos(numeros);
        List<Integer> esperado = Arrays.asList(2, 3, 4);
        assertEquals(esperado, repetidos);
    }
}
