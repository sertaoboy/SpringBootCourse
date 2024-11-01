package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //construtor default
@AllArgsConstructor
@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco endereco) {
        this.logradouro=endereco.logradouro();
        this.bairro=endereco.bairro();
        this.cep=endereco.cep();
        this.uf=endereco.uf();
        this.cidade=endereco.cidade();
        this.complemento=endereco.complemento();
        this.numero=endereco.numero();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.logradouro()!=null) {
            this.logradouro=endereco.logradouro();
        }
        if(endereco.bairro()!=null) {
            this.bairro=endereco.bairro();
        }
        if(endereco.cep()!=null) {
            this.cep=endereco.cep();
        }
        if(endereco.complemento()!=null) {
            this.complemento=endereco.complemento();
        }
        if(endereco.cidade()!=null) {
            this.cidade=endereco.cidade();
        }
        if(endereco.uf()!=null) {
            this.uf=endereco.uf();
        }
        if(endereco.numero()!=null) {
            this.numero=endereco.numero();
        }
    }
}
