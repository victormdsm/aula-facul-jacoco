package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leitos")
public class LeitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TipoLeito;
    private boolean ocupado;

    @OneToOne(mappedBy = "leito")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private SaudeUnidadeEntity unidadeSaude;


}
