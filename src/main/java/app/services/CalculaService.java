package app.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculaService {

    public int soma(List<Integer> numeros){
        int soma = 0;
        for (Integer numero : numeros){
            soma += numero;
        }
        return soma;
    }

    public double media(List<Integer> numeros){
        if (numeros.isEmpty()){
            return 0.0;
        }
        int soma = soma(numeros);
        return (double) soma / numeros.size();
    }

    public int encontrarMaior(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            System.out.println("A lista está vazia.");
        }

        int maior = numeros.get(0);
        for (Integer numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }

    public int encontrarMenor(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            System.out.println("A lista está vazia.");
        }

        int menor = numeros.get(0);
        for (Integer numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }
        return menor;
    }

    public List<Integer> encontrarNumerosRepetidos(List<Integer> numeros) {
        List<Integer> repetidos = new ArrayList<>();
        List<Integer> jaVistos = new ArrayList<>();

        for (Integer numero : numeros) {
            if (jaVistos.contains(numero) && !repetidos.contains(numero)) {
                repetidos.add(numero);
            } else {
                jaVistos.add(numero);
            }
        }

        return repetidos;
    }
}
