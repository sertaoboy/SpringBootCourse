package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.paciente.DadosAtualizacaoPaciente;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PacienteRepositoryTest {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private TestEntityManager em;


    @Test
    @DisplayName("Verificando se o paciente foi salvo corretamente")
    void deveSalvarPacienteComSucesso(){
        //Arrange: Criar um objeto Paciente com dados de teste
        //Act: Salve o paciente no banco de dados:
        Paciente paciente = cadastrarPaciente("João da Silva","joao@email.com","12345678901");
        pacienteRepository.save(paciente);
        //Assert: Verifique se o paciente foi salvo corretamente
        assertThat(paciente.getId()).isNotNull();
        assertThat(paciente.getNome()).isEqualTo("João da Silva");
        assertThat(paciente.getEmail()).isEqualTo("joao@email.com");
        assertThat(paciente.getCpf()).isEqualTo("12345678901");
    }

//    @Test
//    @DisplayName("Deve atualizar um paciente existente")
//    void deveAtualizarPacienteComSucesso() {
//        // Arrange
//        DadosEndereco dadosEndereco = new DadosEndereco("abolicao","meireles","52343525","fortaleza","ce",null,null);
//        Endereco endereco = new Endereco(dadosEndereco);
//        Paciente paciente = cadastrarPaciente(new DadosCadastroPaciente("Mariana","maria@queiroz.com","619943345","0004241",new DadosEndereco("jfd",":fasdf","532453","fasdfwe","ce","dfdf","4123")));
//
//        paciente.atualizarInformacoes();
//        paciente.atualizarDados(dadosAtualizados);
//
//        // Act
//        pacienteRepository.save(paciente);
//
//        // Assert
//        Paciente pacienteAtualizado = pacienteRepository.findById(paciente.getId()).get();
//        assertThat(pacienteAtualizado.getNome()).isEqualTo(dadosAtualizados.nome());
//        assertThat(pacienteAtualizado.getEmail()).isEqualTo(dadosAtualizados.email());
//        assertThat(pacienteAtualizado.getCpf()).isEqualTo(dadosAtualizados.cpf());
//        assertThat(pacienteAtualizado.getTelefone()).isEqualTo(dadosAtualizados.telefone());
//        assertThat(pacienteAtualizado.getEndereco()).isEqualTo(dadosAtualizados.endereco());
//    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new DadosCadastroPaciente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}
