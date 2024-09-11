package app.services;

import app.entities.SaudeUnidadeEntity;
import app.repositories.SaudeUnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaudeUnidadeService {

    @Autowired
    private SaudeUnidadeRepository saudeUnidadeRepository;

    public SaudeUnidadeEntity save(SaudeUnidadeEntity saudeUnidadeEntity){
        return this.saudeUnidadeRepository.save(saudeUnidadeEntity);
    }

    public SaudeUnidadeEntity update(SaudeUnidadeEntity saudeUnidadeEntity, Long id){
        saudeUnidadeEntity.setId(id);
        return this.saudeUnidadeRepository.save(saudeUnidadeEntity);
    }

    public boolean delete(Long id){
        this.saudeUnidadeRepository.deleteById(id);
        return true;
    }

    public SaudeUnidadeEntity findById(Long id){
        SaudeUnidadeEntity unidade = this.saudeUnidadeRepository.findById(id).get();
        return unidade;
    }

    public List<SaudeUnidadeEntity> findAll(){
        List<SaudeUnidadeEntity> list = this.saudeUnidadeRepository.findAll();
        return list;
    }
}
