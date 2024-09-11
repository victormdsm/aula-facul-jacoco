package app.services;

import app.entities.LeitoEntity;
import app.repositories.LeitoRepository;
import jakarta.persistence.JoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    public LeitoEntity save(LeitoEntity leitoEntity){
        return this.leitoRepository.save(leitoEntity);
    }

    public LeitoEntity update(LeitoEntity leitoEntity, Long id){
        leitoEntity.setId(id);
        return this.leitoRepository.save(leitoEntity);
    }

    public boolean delete(Long id){
        this.leitoRepository.deleteById(id);
        return true;
    }

    public LeitoEntity findById(Long id){
        LeitoEntity leito = this.leitoRepository.findById(id).get();
        return leito;
    }

    public List<LeitoEntity> findAll(){
        List<LeitoEntity> lista = this.leitoRepository.findAll();
        return lista;
    }

    public List<LeitoEntity> listarLeitosDisponiveis() {
        List<LeitoEntity> lista = this.leitoRepository.findByOcupado(false);
        return lista;
    }

}
