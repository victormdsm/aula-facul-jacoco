package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoEntity medico;

    @OneToOne
    @JoinColumn(name = "leito_id")
    private LeitoEntity leito;

}
