package med.voll.api.domain.medico;

public record DadosListagemMedico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  Long id) {

    public DadosListagemMedico(Medico medico){
        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade(),medico.getId());
    }
}
