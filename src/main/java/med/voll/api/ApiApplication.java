package med.voll.api;

import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	@Autowired
	private MedicoRepository repository; //Injecao de dependencias...

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
