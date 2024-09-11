package app.controllers;

import app.entities.LeitoEntity;
import app.entities.PacienteEntity;
import app.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/save")
    public ResponseEntity<PacienteEntity> save(@RequestBody PacienteEntity pacienteEntity){
        try {
            this.pacienteService.save(pacienteEntity);
            return new ResponseEntity<>(pacienteEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PacienteEntity> update(@RequestBody PacienteEntity pacienteEntity,@PathVariable Long id){
        try {
            this.pacienteService.update(pacienteEntity, id);
            return new ResponseEntity<>(pacienteEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        try {
            this.pacienteService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<PacienteEntity> findById(@PathVariable Long id){
        try {
            PacienteEntity paciente = this.pacienteService.findById(id);
            return new ResponseEntity<>(paciente,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findall")
    public ResponseEntity<List<PacienteEntity>>findAll(){
        try {
            List<PacienteEntity> list = this.pacienteService.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
