package app.controllers;

import app.entities.LeitoEntity;
import app.entities.SaudeUnidadeEntity;
import app.services.PacienteService;
import app.services.SaudeUnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadesaude")
public class SaudeUnidadeController {
    @Autowired
    private SaudeUnidadeService saudeUnidadeService;

    @PostMapping("/save")
    public ResponseEntity<SaudeUnidadeEntity> save(@RequestBody SaudeUnidadeEntity saudeUnidadeEntity){
        try {
            this.saudeUnidadeService.save(saudeUnidadeEntity);
            return new ResponseEntity<>(saudeUnidadeEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SaudeUnidadeEntity> update(@RequestBody SaudeUnidadeEntity saudeUnidadeEntity,@PathVariable Long id){
        try {
            this.saudeUnidadeService.update(saudeUnidadeEntity, id);
            return new ResponseEntity<>(saudeUnidadeEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        try {
            this.saudeUnidadeService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<SaudeUnidadeEntity> findById(@PathVariable Long id){
        try {
            SaudeUnidadeEntity saudeUnidadeEntity = this.saudeUnidadeService.findById(id);
            return new ResponseEntity<>(saudeUnidadeEntity,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findall")
    public ResponseEntity<List<SaudeUnidadeEntity>>findAll(){
        try {
            List<SaudeUnidadeEntity> list = this.saudeUnidadeService.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
