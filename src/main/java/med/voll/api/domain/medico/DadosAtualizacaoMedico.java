package med.voll.api.domain.medico;


import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(@NotNull Long id,
                                     String telefone,
                                     DadosEndereco endereco,
                                     String nome) {

}
