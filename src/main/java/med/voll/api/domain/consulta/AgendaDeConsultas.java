package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsultas;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if(!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente inserido nao existe");
        }else if (dados.idMedico()!=null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico inserido nao existe");
        }

        validadores.forEach(v -> v.validar(dados));

        Medico medico = escolherMedico(dados);
        if(medico == null) {
            throw new ValidacaoException("Nao existe medico disponivel nessa data.");
        }
        Paciente paciente=pacienteRepository.findById(dados.idPaciente()).get();
        Consulta consulta = new Consulta(null,medico,paciente,dados.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados){
        if(dados.idMedico()!= null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }else if(dados.especialidade()==null){
            throw new ValidacaoException("Especialidade obrigatoria quando medico nao for escolhido.");
        }else{
            return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());
        }
    }

}
