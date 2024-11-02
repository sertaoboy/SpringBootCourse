package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta (Long idMedico,
                                        @NotNull
                                        Long idPaciente,

                                        @NotNull
                                        @Future //para explicitar ao Spring que a data TEM QUE SER NO futuro
                                        LocalDateTime data,
                                        Especialidade especialidade){
}
