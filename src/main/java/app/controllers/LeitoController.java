package app.controllers;

import app.entities.LeitoEntity;
import app.entities.PacienteEntity;
import app.services.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leitos")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @PostMapping("/save")
    public ResponseEntity<LeitoEntity> save(@RequestBody LeitoEntity leitoEntity){
        try {
            this.leitoService.save(leitoEntity);
            return new ResponseEntity<>(leitoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LeitoEntity> update(@RequestBody LeitoEntity leitoEntity,@PathVariable Long id){
        try {
            this.leitoService.update(leitoEntity, id);
            return new ResponseEntity<>(leitoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        try {
            this.leitoService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<LeitoEntity> findById(@PathVariable Long id){
        try {
            LeitoEntity leito = this.leitoService.findById(id);
            return new ResponseEntity<>(leito,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findall")
    public ResponseEntity<List<LeitoEntity>>findAll(){
        try {
            List<LeitoEntity> list = this.leitoService.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/leitosdiponiveis")
    public ResponseEntity<List<LeitoEntity>> leitosDisponiveis(){
        try {
            List<LeitoEntity> list = this.leitoService.listarLeitosDisponiveis();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


}
