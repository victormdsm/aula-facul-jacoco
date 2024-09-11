package app.repositories;

import app.entities.LeitoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeitoRepository extends JpaRepository<LeitoEntity, Long> {

    List<LeitoEntity> findByOcupado(boolean ocupado);
}
