### Conteudos complementares:
- Anotacoes do Bean Validation:
> https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints <br>
- Metodologias para o desenvolvimento de SaaS:
> https://12factor.net/ <br>
- Documentacao - Classes Record:
> https://docs.oracle.com/en/java/javase/16/language/records.html <br>
- Design Pattern DTO (Data Transfer Object):
> https://pt.stackoverflow.com/questions/31362/o-que-%C3%A9-um-dto <br>
- Vulnerabilidade Mass Assignment:
> https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html <br>
- Erros requisicao HTTP:
> https://http.cat/ <br>
> https://http.dog/ <br>
- Fundamentos de REST:
> https://www.alura.com.br/artigos/rest-conceito-e-fundamentos <br>

# Aula 1
- Criar um projeto Spring Boot utilizando o site Spring Initializr;
- Importar o projeto no IntelliJ e executar uma aplicacao Spring Boot pela classe contendo o metodo `main`;
- Criar uma classe Controller e mapear uma URL nela utilizando anotacoes `@RestController` e `@RequestMapping`;
- Realizar uma requisicao de teste no navegador acessando a URL mapeada no Controller.
  
# Aula 2
- Mapear requisicoes POST em uma classe Controller;
- Enviar requisicoes POST para a API usando o postman;
- Enviar dados para a API no formato JSON;
- Utilizar a anotacao `@RequestBody` para receber os dados do `body` da requisicao em um parametro no Controller;
- Utilizar o padrao DTO **(Data Transfer Object)**, por meio de *Java Records*, para representar os dados recebidos em uma requisicao POST.

# Aula 3
- Adicionar novas dependências no projeto;
- Mapear uma entidade JPA e criar uma interface Repository para ela;
- Utilizar o Flyway como ferramenta de Migrations do projeto;
- Realizar validações com Bean Validation utilizando algumas de suas anotações, como a `@NotBlank`.

# Aula 4
- Utilizar a anotacao `@GetMapping` para mapear os metodos em Controllers que produzem dados;
- Utilizar a interface `Pageable` do Spring para realizar consultas com paginacao;
- Controlar a paginação e a ordenação dos dados devolvidos pela API com os parâmetros `page`, `size` e `sort`;
- Configurar o projeto para que os comandos SQL sejam exibidos no console.

# Aula 5
- Mapear requisições PUT com a anotação `@PutMapping`;
- Escrever um código para atualizar informações de um registro no banco de dados;
- Mapear requisições DELETE com a anotação `@DeleteMapping`;
- Mapear parâmetros dinâmicos em URL com a anotação `@PathVariable`;
- Implementar o conceito de exclusão lógica com o uso de um atributo booleano.

# Aula 6
- Utilizar a classe `ResponseEntity`, do Spring, para personalizar os reetornos dos metodos de uma classe Controller;
- Modificar o codigo HTTP devolvido nas respostas API;
- Adicionar cabecalhos nas respostas da API;
- Utilizar os codigos HTTP mais apropriados para cada operacao realizada na API.

> Regras de negocio seguidos no curso: https://trello.com/b/O0lGCsKb/api-voll-med <br>



## Para saber mais: classes DAO
- Em alguns projetos em Java, dependendo da tecnologia escolhida, é comum encontrarmos classes que seguem o padrão DAO, utilizado para isolar o acesso aos dados. Entretanto, neste curso utilizaremos um outro padrão, conhecido como Repository.
> Mas aí podem surgir algumas dúvidas: qual a diferença entre as duas abordagens e o porquê dessa escolha? <br>
### Padrao DAO
- O padrão de projeto DAO, conhecido também por **Data Access Object**, é utilizado para persistência de dados, onde seu principal objetivo é separar regras de negócio de regras de acesso a banco de dados. 
- Nas classes que seguem esse padrão, isolamos todos os códigos que lidam com conexões, comandos SQLs e funções diretas ao banco de dados, para que assim tais códigos não se espalhem por outros pontos da aplicação, algo que dificultaria a manutenção do código e também a troca das tecnologias e do mecanismo de persistência.

### Padrao Repository
- De acordo com o famoso livro Domain-Driven Design, de Eric Evans: 
> "O repositório é um mecanismo para encapsular armazenamento, recuperação e comportamento de pesquisa, que emula uma coleção de objetos." <br>
- Simplificando, um repositório também lida com dados e oculta consultas semelhantes ao DAO. No entanto, ele fica em um nível mais alto, mais próximo da lógica de negócios de uma aplicação. Um repositório está vinculado à regra de negócio da aplicação e está associado ao agregado dos seus objetos de negócio, retornando-os quando preciso.
- Só que devemos ficar atentos, pois assim como no padrão DAO, regras de negócio que estão envolvidas com processamento de informações não devem estar presentes nos repositórios. Os repositórios não devem ter a responsabilidade de tomar decisões, aplicar algoritmos de transformação de dados ou prover serviços diretamente a outras camadas ou módulos da aplicação.
- Mapear entidades de domínio e prover as funcionalidades da aplicação são responsabilidades muito distintas.
- Um repositório fica entre as regras de negócio e a camada de persistência:
- I. Ele provê uma interface para as regras de negócio onde os objetos são acessados como em uma coleção;
- II. Ele usa a camada de persistência para gravar e recuperar os dados necessários para persistir e recuperar os objetos de negócio.

### Por que o padrão repository ao invés do DAO utilizando Spring?
- O padrão de repositório incentiva um design orientado a domínio, fornecendo uma compreensão mais fácil do domínio e da estrutura de dados.
- Além disso, utilizando o repository do Spring não temos que nos preocupar em utilizar diretamente a API da JPA, bastando apenas criar os métodos que o Spring cria a implementação em tempo de execução, deixando o código muito mais simples, menor e legível.

## Para saber mais: Erro na `migration`
- Conforme orientado ao longo dessa aula é importante sempre **parar** o projeto ao criar os arquivos de **migrations**  para evitar que o Flyway os execute antes da hora, com o código ainda incompleto, causando com isso problemas.
- Entretanto, eventualmente pode acontecer de esquecermos de parar o projeto e algum erro acontecer ao tentar inicializar a aplicação. Nesse caso será exibido o seguinte erro ao tentar inicializar a aplicação:
```shell
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Validate failed: Migrations have failed validation
```
- Perceba na mensagem de erro que é indicado que alguma migration falhou, impedindo assim que o projeto seja inicializado corretamente. Esse erro também pode acontecer se o código da migration estiver inválido, contendo algum trecho de SQL digitado de maneira incorreta.
- Para resolver esse problema será necessário acessar o banco de dados da aplicação e executar o seguinte comando sql:
> `delete from flyway_schema_history where success = 0;` <br>
- O comando anterior serve para apagar na tabela do Flyway todas as migrations cuja execução falhou. Após isso, basta corrigir o código da migration e executar novamente o projeto.
- Obs: Pode acontecer de alguma migration ter criado uma tabela e/ou colunas e com isso o problema vai persistir, pois o flyway não vai apagar as tabelas/colunas criadas em migrations que falharam. Nesse caso você pode apagar o banco de dados e criá-lo novamente:
```sql
drop database vollmed_api;
create database vollmed_api; 
```

## Para saber mais: DTOs ou Entidades?
- Estamos utilizando DTOs para representar os dados que recebemos e devolvemos pela API, mas você provavelmente deve estar se perguntando “Por que ao invés de criar um DTO não devolvemos diretamente a entidade JPA no Controller?”. Para fazer isso, bastaria alterar o método `listar` no Controller para:
```java
@GetMapping
public List<Medico> listar() {
    return repository.findAll();
} 
```
- Desse jeito o código ficaria mais enxuto e não precisaríamos criar o DTO no projeto. Mas, será que isso realmente é uma boa ideia?
### Os problemas de receber/devolver entidades JPA
- De fato é muito mais simples e cômodo não utilizar DTOs e sim lidar diretamente com as entidades JPA nos controllers. Porém, essa abordagem tem algumas desvantagens, inclusive causando vulnerabilidade na aplicação para ataques do tipo **Mass Assignmnent**.
- Um dos problemas consiste no fato de que, ao retornar uma entidade JPA em um método de um Controller, o Spring vai gerar o JSON contendo todos os atributos dela, sendo que nem sempre esse é o comportamento que desejamos.
- Eventualmente podemos ter atributos que não desejamos que sejam devolvidos no JSON, seja por motivos de segurança, no caso de dados sensíveis, ou mesmo por não serem utilizados pelos clientes da API.
### Utilizacao da anotacao `@JsonIgnore`
- Nessa situação, poderíamos utilizar a anotação `@JsonIgnore`, que nos ajuda a ignorar certas propriedades de uma classe Java quando ela for serializada para um objeto JSON.
- Sua utilização consiste em adicionar a anotação nos atributos que desejamos ignorar quando o JSON for gerado. Por exemplo, suponha que em um projeto exista uma entidade JPA `Funcionario`, na qual desejamos ignorar o atributo `salario`:
```java
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Funcionario")
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @JsonIgnore
    private BigDecimal salario;

    //restante do código omitido…
}
```
- Neste exemplo, o atributo `salario` nao sera exibido nas respostas JSON e o problema pode ser solucionado.
- Entretanto, pode acontecer de existir algum outro endpoint da API na qual precisamos enviar no JSON o salário dos funcionários, sendo que nesse caso teríamos problemas, pois com a anotação `@JsonIgnore` tal atributo nunca será enviado no JSON, e ao remover a anotação o atributo sempre será enviado. Perdemos, com isso, a flexibilidade de controlar quando determinados atributos devem ser enviados no JSON e quando não.
### DTO
- O padrão DTO (Data Transfer Object) é um padrão de arquitetura que era bastante utilizado antigamente em aplicações Java distribuídas (arquitetura cliente/servidor) para representar os dados que eram enviados e recebidos entre as aplicações cliente e servidor.
- O padrão DTO pode (e deve) ser utilizado quando não queremos expor todos os atributos de alguma entidade do nosso projeto, situação igual a dos salários dos funcionários mostrado no exemplo de código anterior. Além disso, com a flexibilidade e a opção de filtrar quais dados serão transmitidos, podemos poupar tempo de processamento.
### Loop infinito causando `StackOverflowError`
- Outro problema muito recorrente ao se trabalhar diretamente com entidades JPA acontece quando uma entidade possui algum autorrelacionamento ou relacionamento bidirecional. Por exemplo, considere as seguintes entidades JPA:
```java
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = “id_categoria”)
    private Categoria categoria;

    //restante do código omitido…
}
```
```java
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Categoria")
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = “categoria”)
    private List<Produto> produtos = new ArrayList<>();

    //restante do código omitido…
}
```
- Ao retornar um objeto do tipo `Produto` no Controller, o Spring teria problemas para gerar o JSON desse objeto, causando uma exception do tipo `StackOverflowError`. Esse problema ocorre porque o objeto produto tem um atributo do tipo `Categoria` , que por sua vez tem um atributo do tipo `List<Produto>`, causando assim um loop infinito no processo de serialização para JSON.
- Tal problema pode ser resolvido com a utilizacao da anotacao `@JsonIgnore` ou com a utilizacao das anotacoes `@JsonBackReference` e `@JsonManagedReference`, mas também poderia ser evitado com a **utilização de um DTO** que representa apenas os dados que devem ser devolvidos no JSON.

## Para saber mais: parametros de paginacao
- Conforme aprendemos nos vídeos anteriores, por padrão, os parâmetros utilizados para realizar a paginação e a ordenação devem se chamar `page`, `size` e `sort`. Entretanto, o Spring Boot permite que os nomes de tais parâmetros sejam modificados via configuração no arquivo `application.properties`.
- Por exemplo, poderíamos traduzir para português os nomes desses parâmetros com as seguintes propriedades:
```properties
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem
```
- Com isso, nas requisições que utilizam paginação, devemos utilizar esses nomes que foram definidos. Por exemplo, para listar os médicos de nossa API trazendo apenas 5 registros da página 2, ordenados pelo e-mail e de maneira decrescente, a URL da requisição deve ser:
`http://localhost:8080/medicos?tamanho=5&pagina=1&ordem=email,desc`

## Para saber mais: Mass Assignment Attack
- Mass Assignment Attack ou Ataque de Atribuição em Massa, em português, ocorre quando um usuário é capaz de inicializar ou substituir parâmetros que não deveriam ser modificados na aplicação. Ao incluir parâmetros adicionais em uma requisição, sendo tais parâmetros válidos, um usuário mal-intencionado pode gerar um efeito colateral indesejado na aplicação.
- O conceito desse ataque refere-se a quando você injeta um conjunto de valores diretamente em um objeto, daí o nome atribuição em massa, que sem a devida validação pode causar sérios problemas.
- Vamos a um exemplo prático. Suponha que você tem o seguinte método, em uma classe Controller, utilizado para cadastrar um usuário na aplicação:
```java
@PostMapping
@Transactional
public void cadastrar(@RequestBody @Valid Usuario usuario) {
    repository.save(usuario);
}
```
- E a entidade JPA que representa o usuario:
```java
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Boolean admin = false;

    //restante do código omitido…
}
```
- Repare que o atributo `admin` da classe `Usuario` e iniciado como `false`, indicando que um usuario deve sempre ser cadastrado como nao sendo um administrador. Porem, se na requisicao for enviado o seguinte JSON:
```
{
  “nome” : “Rodrigo”,
  “email” : “rodrigo@email.com”,
  “admin” : true
}
```
- O usuario sera cadastrado com o atributo `admin` preenchido como `true`. Isso acontece porque o atributo enviado no JSON existe na classe que esta sendo recebida no Controller, sendo considerado entao um atributo valido e que sera preenchido no objeto `Usuario` que sera instanciado pelo Spring.
### Prevencao
- O uso do padrão DTO nos ajuda a evitar esse problema, pois ao criar um DTO definimos nele apenas os campos que podem ser recebidos na API, e no exemplo anterior o DTO não teria o atributo `admin`.
- Novamente, vemos mais uma vantagem de se utilizar o padrão DTO para representar os dados que chegam e saem da API.

## Para saber mais: PUT ou PATCH?
- Escolher entre o método HTTP PUT ou PATCH é uma dúvida comum que surge quando estamos desenvolvendo APIs e precisamos criar um endpoint para atualização de recursos. Vamos entender as diferenças entre as duas opções e quando utilizar cada uma.
### PUT
- O método PUT substitui todos os atuais dados de um recurso pelos dados passados na requisição, ou seja, estamos falando de uma atualização integral. Então, com ele, fazemos a atualização total de um recurso em apenas uma requisição.
### PATCH
- O método PATCH, por sua vez, aplica modificações parciais em um recurso. Logo, é possível modificar apenas uma parte de um recurso. Com o PATCH, então, realizamos atualizações parciais, o que torna as opções de atualização mais flexíveis.
### Qual escolher? 
- Na prática, é difícil saber qual método utilizar, pois nem sempre saberemos se um recurso será atualizado parcialmente ou totalmente em uma requisição - a não ser que realizemos uma verificação quanto a isso, algo que não é recomendado.
- O mais comum então nas aplicações é utilizar o método PUT para requisições de atualização de recursos em uma API, sendo essa a nossa escolha no projeto utilizado ao longo deste curso.

## Para saber mais: codigos do protocolo HTTP
-  protocolo HTTP (Hypertext Transfer Protocol, RFC 2616) é o protocolo responsável por fazer a comunicação entre o cliente, que normalmente é um browser, e o servidor. Dessa forma, a cada “requisição” feita pelo cliente, o servidor responde se ele obteve sucesso ou não. Se não obtiver sucesso, na maioria das vezes, a resposta do servidor será uma sequência numérica acompanhada por uma mensagem. Se não soubermos o que significa o código de resposta, dificilmente saberemos qual o problema que está acontecendo, por esse motivo é muito importante saber quais são os códigos HTTP e o que significam.
### Categorias de codigos
- Os códigos HTTP (ou HTTPS) possuem três dígitos, sendo que o primeiro dígito significa a classificação dentro das possíveis cinco categorias.
- **1XX**: Informativo – a solicitação foi aceita ou o processo continua em andamento;
- **2XX**: Confirmação – a ação foi concluída ou entendida;
- **3XX**: Redirecionamento – indica que algo mais precisa ser feito ou precisou ser feito para completar a solicitação;
- **4XX**: Erro do cliente – indica que a solicitação não pode ser concluída ou contém a sintaxe incorreta;
- **5XX**: Erro no servidor – o servidor falhou ao concluir a solicitação.
### Principais codigos de erro
- Como dito anteriormente, conhecer os principais códigos de erro HTTP vai te ajudar a identificar problemas em suas aplicações, além de permitir que você entenda melhor a comunicação do seu navegador com o servidor da aplicação que está tentando acessar.
### Error 403
- O código 403 é o erro “Proibido”. Significa que o servidor entendeu a requisição do cliente, mas se recusa a processá-la, pois o cliente não possui autorização para isso.
### Error 404
- Quando você digita uma URL e recebe a mensagem Error 404, significa que essa URL não te levou a lugar nenhum. Pode ser que a aplicação não exista mais, a URL mudou ou você digitou a URL errada.
### Error 500
- É um erro menos comum, mas de vez em quando ele aparece. Esse erro significa que há um problema com alguma das bases que faz uma aplicação rodar. Esse erro pode ser, basicamente, no servidor que mantém a aplicação no ar ou na comunicação com o sistema de arquivos, que fornece a infraestrutura para a aplicação.
### Error 503
- O erro 503 significa que o serviço acessado está temporariamente indisponível. Causas comuns são um servidor em manutenção ou sobrecarregado. Ataques maliciosos, como o DDoS, causam bastante esse problema.
