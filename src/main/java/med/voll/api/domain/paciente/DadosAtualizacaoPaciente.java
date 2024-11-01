package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(@NotNull Long id,
                                       String telefone,
                                       DadosEndereco endereco,
                                       String nome) {
}
