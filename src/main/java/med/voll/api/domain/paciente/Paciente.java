package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Entity (name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;

    @Embedded//@Embedded: são usadas para representar um tipo de relacionamento entre entidades chamado composição
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
        this.ativo=true;
        this.nome= dadosCadastroPaciente.nome();
        this.cpf= dadosCadastroPaciente.cpf();
        this.email= dadosCadastroPaciente.email();
        this.telefone= dadosCadastroPaciente.telefone();
        this.endereco= new Endereco(dadosCadastroPaciente.endereco());
    }


    public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente dados) {
        if(dados.nome()!=null) {
            this.nome= dados.nome();
        }
        if(dados.telefone()!= null) {
            this.telefone= dados.telefone();
        }
        if(dados.endereco()!=null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo=false;
    }
}
