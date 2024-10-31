package med.voll.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Essa anotação indica ao Spring que a classe é responsável por lidar com requisições HTTP e retornar respostas em formato JSON.
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "hello world!!";
    }
}
