package app.controllers;

import app.services.CalculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calcula")
public class CalculaController {

    @Autowired
    private CalculaService calculaService;

    @PostMapping("/soma")
    public ResponseEntity<Integer> calcularSoma(@RequestBody List<Integer> numeros) {
        try {
            int soma = calculaService.soma(numeros);
            return new ResponseEntity<>(soma, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/media")
    public ResponseEntity<Double> calcularMedia(@RequestBody List<Integer> numeros) {
        try {
            double media = calculaService.media(numeros);
            return new ResponseEntity<>(media, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/maior-menor")
    public ResponseEntity<String> encontrarMaiorMenor(@RequestBody List<Integer> numeros) {
        int maior = calculaService.encontrarMaior(numeros);
        int menor = calculaService.encontrarMenor(numeros);
        return ResponseEntity.ok("Maior: " + maior + ", Menor: " + menor);
    }
}
