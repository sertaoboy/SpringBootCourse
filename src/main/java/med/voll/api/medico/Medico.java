package med.voll.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome=dados.nome();
        this.crm=dados.crm();
        this.email=dados.email();
        this.especialidade=dados.especialidade();
        this.endereco= new Endereco(dados.endereco());
        this.telefone=dados.telefone();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
        if(dados.nome()!=null) {
            this.nome = dados.nome();
        }
        if(dados.telefone()!=null) {
            this.telefone= dados.telefone();
        }
        if(dados.endereco()!=null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
