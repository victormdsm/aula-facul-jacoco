package app.services;

import app.entities.MedicoEntity;
import app.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoEntity save(MedicoEntity medicoEntity){
        return this.medicoRepository.save(medicoEntity);
    }

    public MedicoEntity update(MedicoEntity medicoEntity, Long id){
        medicoEntity.setId(id);
        return this.medicoRepository.save(medicoEntity);
    }

    public boolean delete(Long id){
        this.medicoRepository.deleteById(id);
        return true;
    }

    public MedicoEntity findById(Long id){
        MedicoEntity medico = this.medicoRepository.findById(id).get();
        return medico;
    }

    public List<MedicoEntity> findAll(){
        List<MedicoEntity> list = this.medicoRepository.findAll();
        return list;
    }

}
