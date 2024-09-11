package app.services;

import app.entities.LeitoEntity;
import app.entities.PacienteEntity;
import app.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteEntity save(PacienteEntity pacienteEntity){
        return this.pacienteRepository.save(pacienteEntity);
    }

    public PacienteEntity update(PacienteEntity pacienteEntity, Long id){
        pacienteEntity.setId(id);
        return this.pacienteRepository.save(pacienteEntity);
    }

    public boolean delete(Long id){
        this.pacienteRepository.deleteById(id);
        return true;
    }

    public PacienteEntity findById(Long id){
        PacienteEntity paciente = this.pacienteRepository.findById(id).get();
        return paciente;
    }

    public List<PacienteEntity> findAll(){
        List<PacienteEntity> list = this.pacienteRepository.findAll();
        return list;
    }
}
