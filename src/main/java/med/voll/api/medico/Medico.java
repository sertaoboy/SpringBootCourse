package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor //construtor default
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded   //Embeddable Attributes
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome=dados.nome();
        this.crm=dados.crm();
        this.email=dados.email();
        this.especialidade=dados.especialidade();
        this.endereco= new Endereco(dados.endereco());
        this.telefone=dados.telefone();
    }
}
