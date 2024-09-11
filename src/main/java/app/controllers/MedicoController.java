package app.controllers;

import app.entities.LeitoEntity;
import app.entities.MedicoEntity;
import app.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping("/save")
    public ResponseEntity<MedicoEntity> save(@RequestBody MedicoEntity medicoEntity){
        try {
            this.medicoService.save(medicoEntity);
            return new ResponseEntity<>(medicoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MedicoEntity> update(@RequestBody MedicoEntity medicoEntity,@PathVariable Long id){
        try {
            this.medicoService.update(medicoEntity, id);
            return new ResponseEntity<>(medicoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        try {
            this.medicoService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<MedicoEntity> findById(@PathVariable Long id){
        try {
            MedicoEntity medico = this.medicoService.findById(id);
            return new ResponseEntity<>(medico,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findall")
    public ResponseEntity<List<MedicoEntity>>findAll(){
        try {
            List<MedicoEntity> list = this.medicoService.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
