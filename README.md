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
- Documentacao - Application Properties SpringBoot:
> https://docs.spring.io/spring-boot/appendix/application-properties/index.html <br>
- Documentacao - JPA; Spring Data:
> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html <br>
- CSRF Attacks:
> https://owasp.org/www-community/attacks/csrf <br>
- JWT Tokens:
> https://jwt.io/ <br>
- Open API Initiative:
> https://www.openapis.org/ <br>

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

# Aula 7
- Criar uma classe para isolar o tratamento de exceptions da API, com a utilização da anotação `@RestControllerAdvice`
- Utilizar a anotacao `@ExceptionHandler`, do Spring, para indicar qual exception um determinado método da classe de tratamento de erros deve capturar;
- Tratar erros do tipo 404 (Not Found) na classe de tratamento de erros;
- Tratar erros do tipo 400 (Bad Request), para erros de validação do Bean Validation, na classe de tratamento de erros;
- Simplificar o JSON devolvido pela API em casos de erro de validação do Bean Validation.

# Aula 8
- Como funciona o processo de autenticação e autorização em uma API Rest;
- Como adicionar o Spring Security ao projeto;
- Como funciona o comportamento padrão do Spring Security em uma aplicação;
- Implementar o processo de autenticação na API, de maneira Stateless, utilizando as classes e configurações do Spring Security.

# Aula 9
- Adicionar a biblioteca `Auth0 java-jwt` como dependência do projeto;
- Utilizar essa biblioteca para realizar a geração de um token na API;
- Injetar uma propriedade do arquivo `application.properties` em uma classe gerenciada pelo Spring, utilizando a anotação `@Value`;
- Devolver um token gerado na API quando um usuário se autenticar nela.

# Aula 10
- Funcionamento de `Filters` em uma requisicao;
- Implementar um *filter* criando uma classe que herda da classe `OncePerRequestFilter`, do Spring;
- Utilizar a biblioteca ***Auth0 java-jwt*** para realizar a validação dos tokens recebidos na API;
- Realizar o processo de autenticação da requisição, utilizando a classe `SecurityContextHolder`, do Spring;
- Liberar e restringir requisições, de acordo com a URL e o verbo do protocolo HTTP.

## Aula 11
- Implementar uma nova funcionalidade no projeto;
- Avaliar quando é necessário criar uma classe Service na aplicação;
- Criar uma classe **Service**, com o objetivo de isolar códigos de regras de negócio, utilizando para isso a anotação `@Service`;
- Implementar um algoritmo para a funcionalidade de agendamento de consultas;
- Realizar validações de integridade das informações que chegam na API;
- Implementar uma consulta JPQL (Java Persistence Query Language) complexa em uma interface repository, utilizando para isso a anotação `@Query`.

## Aula 12
- Isolar os códigos de validações de regras de negócio em classes separadas, utilizando nelas a anotação `@Component` do Spring;
- Finalizar a implementação do algoritmo de agendamento de consultas;
- Utilizar os princípios **SOLID** para deixar o código da funcionalidade de agendamento de consultas mais fácil de entender, evoluir e testar.

## Aula 13
- Adicionar a biblioteca **SpringDoc** no projeto para que ela faça a geração automatizada da documentação da API;
- Analisar a documentação do SpringDoc para entender como realizar a sua configuração em um projeto;
- Acessar os endereços que disponibilizam a documentação da API nos formatos yaml e html;
- Utilizar o **Swagger UI** para visualizar e testar uma API Rest;
- Configurar o JWT na documentação gerada pelo SpringDoc.

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

## Para saber mais: propriedades do Spring Boot
- Ao longo dos cursos, tivemos que adicionar algumas propriedades no arquivo `application.properties` para realizar configurações no projeto, como, por exemplo, as configurações de acesso ao banco de dados.
- O Spring Boot possui centenas de propriedades que podemos incluir nesse arquivo, sendo impossível memorizar todas elas. Sendo assim, é importante conhecer a documentação que lista todas essas propriedades, pois eventualmente precisaremos consultá-la.

## Para saber mais: mensagens de erro em português
- Por padrão o Bean Validation devolve as mensagens de erro em inglês, entretanto existe uma tradução dessas mensagens para o português já implementada nessa especificação.
- No protocolo HTTP existe um cabeçalho chamado Accept-Language, que serve para indicar ao servidor o idioma de preferência do cliente disparando a requisição. Podemos utilizar esse cabeçalho para indicar ao Spring o idioma desejado, para que então na integração com o Bean Validation ele busque as mensagens de acordo com o idioma indicado.
- No Insomnia, e também nas outras ferramentas similares, existe uma opção chamada Header que podemos incluir cabeçalhos a serem enviados na requisição. Se adicionarmos o header Accept-Language com o valor pt-br, as mensagens de erro do Bean Validation serão automaticamente devolvidas em português.
- Obs: O Bean Validation tem tradução das mensagens de erro apenas para alguns poucos idiomas.

## Para saber mais: personalizando mensagens de erro
- Você deve ter notado que o Bean Validation possui uma mensagem de erro para cada uma de suas anotações. Por exemplo, quando a validação falha em algum atributo anotado com @NotBlank, a mensagem de erro será: *must not be blank*.
- Essas mensagens de erro não foram definidas na aplicação, pois são mensagens de erro padrão do próprio Bean Validation. Entretanto, caso você queira, pode personalizar tais mensagens.
- Uma das maneiras de personalizar as mensagens de erro é adicionar o atributo message nas próprias anotações de validação:
```java
public record DadosCadastroMedico(
    @NotBlank(message = "Nome é obrigatório")
    String nome,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato do email é inválido")
    String email,

    @NotBlank(message = "Telefone é obrigatório")
    String telefone,

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")
    String crm,

    @NotNull(message = "Especialidade é obrigatória")
    Especialidade especialidade,

    @NotNull(message = "Dados do endereço são obrigatórios")
    @Valid DadosEndereco endereco) {}
```
- Outra maneira é isolar as mensagens em um arquivo de propriedades, que deve possuir o nome `ValidationMessages.properties` e ser criado no diretório `src/main/resources`:
```properties
nome.obrigatorio=Nome é obrigatório
email.obrigatorio=Email é obrigatório
email.invalido=Formato do email é inválido
telefone.obrigatorio=Telefone é obrigatório
crm.obrigatorio=CRM é obrigatório
crm.invalido=Formato do CRM é inválido
especialidade.obrigatoria=Especialidade é obrigatória
endereco.obrigatorio=Dados do endereço são obrigatórios
```
- E, nas anotações, indicar a chave das propriedades pelo próprio atributo `message`, delimitando com os caracteres `{` e `}`:
```java
public record DadosCadastroMedico(
    @NotBlank(message = "{nome.obrigatorio}")
    String nome,

    @NotBlank(message = "{email.obrigatorio}")
    @Email(message = "{email.invalido}")
    String email,

    @NotBlank(message = "{telefone.obrigatorio}")
    String telefone,

    @NotBlank(message = "{crm.obrigatorio}")
    @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
    String crm,

    @NotNull(message = "{especialidade.obrigatoria}")
    Especialidade especialidade,

    @NotNull(message = "{endereco.obrigatorio}")
    @Valid DadosEndereco endereco) {}
```

## Para saber mais: tipos de autenticação em APIs Rest
- Existem diversas formas de se realizar o processo de autenticação e autorização em aplicações Web e APIs Rest, sendo que no curso utilizaremos Tokens JWT.
- Você pode conferir as principais formas de autenticação lendo este artigo: https://www.alura.com.br/artigos/tipos-de-autenticacao

## Para saber mais: hashing de senha
- Ao implementar uma funcionalidade de autenticação em uma aplicação, independente da linguagem de programação utilizada, você terá que lidar com os dados de login e senha dos usuários, sendo que eles precisarão ser armazenados em algum local, como, por exemplo, um banco de dados.
- Senhas são informações sensíveis e não devem ser armazenadas em texto aberto, pois se uma pessoa mal intencionada conseguir obter acesso ao banco de dados, ela conseguirá ter acesso às senhas de todos os usuários. Para evitar esse problema, você deve sempre utilizar algum algoritmo de hashing nas senhas antes de armazená-las no banco de dados.
- Hashing nada mais é do que uma função matemática que converte um texto em outro texto totalmente diferente e de difícil dedução. Por exemplo, o texto Meu nome é Rodrigo pode ser convertido para o texto 8132f7cb860e9ce4c1d9062d2a5d1848, utilizando o algoritmo de hashing MD5.
- Um detalhe importante é que os algoritmos de hashing devem ser de mão única, ou seja, não deve ser possível obter o texto original a partir de um hash. Dessa forma, para saber se um usuário digitou a senha correta ao tentar se autenticar em uma aplicação, devemos pegar a senha que foi digitada por ele e gerar o hash dela, para então realizar a comparação com o hash que está armazenado no banco de dados.
- Existem diversos algoritmos de hashing que podem ser utilizados para fazer essa transformação nas senhas dos usuários, sendo que alguns são mais antigos e não mais considerados seguros hoje em dia, como o MD5 e o SHA1. Os principais algoritmos recomendados atualmente são:
1. Bcrypt
2. Scrypt
3. Argon2
4. PBKDF2
- Ao longo do curso utilizaremos o algoritmo BCrypt, que é bastante popular atualmente. Essa opção também leva em consideração o fato de que o Spring Security já nos fornece uma classe que o implementa.

## Para saber mais: documentação Spring Data
- Conforme aprendido em vídeos anteriores, o Spring Data utiliza um padrão próprio de nomenclatura de métodos que devemos seguir para que ele consiga gerar as queries SQL de maneira correta.
- Existem algumas palavras reservadas que devemos utilizar nos nomes dos métodos, como o `findBy` e o `existsby`, para indicar ao Spring Data como ele deve montar a consulta que desejamos.Esse recurso é bastante flexível, podendo ser um pouco complexo devido às diversas possibilidades existentes.

## Para saber mais: JSON Web Token
- JSON Web Token, ou JWT, é um padrão utilizado para a geração de tokens, que nada mais são do que Strings, representando, de maneira segura, informações que serão compartilhadas entre dois sistemas.
- Explicacao: https://www.alura.com.br/artigos/o-que-e-json-web-tokens

## Para saber mais: Outras informações no token
- Além do Issuer, Subject e data de expiração, podemos incluir outras informações no token JWT, de acordo com as necessidades da aplicação. Por exemplo, podemos incluir o id do usuário no token, para isso basta utilizar o método `withClaim`:
```java
return JWT.create()
    .withIssuer("API Voll.med")
    .withSubject(usuario.getLogin())

    .withClaim("id", usuario.getId())

    .withExpiresAt(dataExpiracao())
    .sign(algoritmo);
```
- O método `withClaim` recebe dois parâmetros, sendo o primeiro uma String que identifica o nome do claim (propriedade armazenada no token), e o segundo a informação que se deseja armazenar.

## Para saber mais: Filters
- Filter é um dos recursos que fazem parte da especificação de Servlets, a qual padroniza o tratamento de requisições e respostas em aplicações Web no Java. Ou seja, tal recurso não é específico do Spring, podendo assim ser utilizado em qualquer aplicação Java.
- É um recurso muito útil para isolar códigos de infraestrutura da aplicação, como, por exemplo, segurança, logs e auditoria, para que tais códigos não sejam duplicados e misturados aos códigos relacionados às regras de negócio da aplicação.
- Para criar um Filter, basta criar uma classe e implementar nela a interface `Filter` (pacote jakarta.servlet). Por exemplo:
```java
@WebFilter(urlPatterns = "/api/**")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Requisição recebida em: " + LocalDateTime.now());
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
```
- O método `doFilter` é chamado pelo servidor automaticamente, sempre que esse filter tiver que ser executado, e a chamada ao método `filterChain.doFilter` indica que os próximos filters, caso existam outros, podem ser executados. A anotação @`WebFilter`, adicionada na classe, indica ao servidor em quais requisições esse filter deve ser chamado, baseando-se na URL da requisição.
- No curso, utilizaremos outra maneira de implementar um filter, usando recursos do Spring que facilitam sua implementação.

## Para saber mais: controle de acesso por anotacoes
- Outra maneira de restringir o acesso a determinadas funcionalidades, com base no perfil dos usuários, é com a utilização de um recurso do Spring Security conhecido como Method Security, que funciona com a utilização de anotações em métodos:
```java
@GetMapping("/{id}")
@Secured("ROLE_ADMIN")
public ResponseEntity detalhar(@PathVariable Long id) {
    var medico = repository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
}
```
- No exemplo de código anterior o método foi anotado com `@Secured("ROLE_ADMIN")`, para que apenas usuários com o perfil **ADMIN** possam disparar requisições para detalhar um médico. A anotação `@Secured` pode ser adicionada em métodos individuais ou mesmo na classe, que seria o equivalente a adicioná-la em todos os métodos.
- Atenção! Por padrão esse recurso vem desabilitado no spring Security, sendo que para o utilizar devemos adicionar a seguinte anotação na classe `Securityconfigurations` do projeto:
```java
@EnableMethodSecurity(securedEnabled = true)
```
- Mais detalhes sobre o recurso de method security na documentação do Spring Security, disponível em: https://docs.spring.io/spring-security/reference/servlet/authorization/method-security.html

## Para saber mais: anotacoes `@JsonAlias`
- Aprendemos que os nomes dos campos enviados no JSON para a API devem ser idênticos aos nomes dos atributos das classes DTO, pois assim o Spring consegue preencher corretamente as informações recebidas.
- Entretanto, pode acontecer de um campo ser enviado no JSON com um nome diferente do atributo definido na classe DTO. Por exemplo, imagine que o seguinte JSON seja enviado para a API:
``
{
    “produto_id” : 12,
    “data_da_compra” : “01/01/2022”
}
``
- E a classe DTO criada para receber tais informações seja definida da seguinte maneira:
```java
public record DadosCompra(
    Long idProduto,
    LocalDate dataCompra
){}
```
- Se isso ocorrer, teremos problemas, pois o Spring vai instanciar um objeto do tipo `DadosCompra`, mas seus atributos não serão preenchidos e ficarão como `null` em razão de seus nomes serem diferentes dos nomes dos campos recebidos no JSON.
- Temos duas possíveis soluções para essa situação:
1. Renomear os atributos no DTO para terem o mesmo nome dos campos do JSON;
2. Solicitar que a aplicacao cliente, que esta disparando requisicoes para a API, altere os nomes dos campos no JSON enviado.

- A primeira alternativa citada anteriormente não é recomendada, pois os nomes dos campos no JSON não estão de acordo com o padrão de nomenclatura de atributos utilizado na linguagem Java.
- A segunda alternativa seria a mais indicada, porém, nem sempre será possível “obrigar” os clientes da API a alterarem o padrão de nomenclatura utilizado nos nomes dos campos no JSON.
- Para essa situação existe ainda uma terceira alternativa, na qual nenhum dos lados (cliente e API) precisam alterar os nomes dos campos/atributos. Basta, para isso, utilizar a anotação @JsonAlias:
```java
public record DadosCompra(
    @JsonAlias(“produto_id”) Long idProduto,
    @JsonAlias(“data_da_compra”) LocalDate dataCompra
){}
```
- A anotacao `@JsonAlias` serve para mapear "apelidos" alternativos para os campos que serao recebidos do JSON, sendo possivel atribuir multiplos *alias*:
```java
public record DadosCompra(
    @JsonAlias({“produto_id”, “id_produto”}) Long idProduto,
    @JsonAlias({“data_da_compra”, “data_compra”}) LocalDate dataCompra
){}
```
- Dessa forma resolvemos o problema, pois o Spring, ao receber o JSON na requisição, vai procurar os campos considerando todos os *alias* declarados na anotação `@JsonAlias`.

##  Para saber mais: formatação de datas
- Como foi demonstrado no vídeo anterior, o Spring tem um padrão de formatação para campos do tipo data quando esses são mapeados em atributos do tipo `LocalDateTime`. Entretanto, é possível personalizar tal padrão para utilizar outras formatações de nossa preferência.
- Por exemplo, imagine que precisamos receber a data/hora da consulta no seguinte formato: ***dd/mm/yyyy hh:mm***. Para que isso seja possível, precisamos indicar ao Spring que esse será o formato ao qual a data/hora será recebida na API, sendo que isso pode ser feito diretamente no DTO, com a utilização da anotação `@JsonFormat`:
```java
@NotNull
@Future
@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
LocalDateTime data
```
- No atributo ****pattern**** indicamos o padrão de formatação esperado, seguindo as regras definidas pelo padrão de datas do Java. Mais detalhes: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
- Essa anotação também pode ser utilizada nas classes DTO que representam as informações que a API devolve, para que assim o JSON devolvido seja formatado de acordo com o pattern configurado. Além disso, ela não se restringe apenas à classe `LocalDateTime`, podendo também ser utilizada em atributos do tipo `LocalDate` e `LocalTime`.

##  Para saber mais: Service Pattern
- O `Padrão Service` é muito utilizado na programação e seu nome é muito comentado. Mas apesar de ser um nome único, Service pode ser interpretado de várias maneiras: pode ser um _Use Case_ (_Application Service_); um _Domain Service_, que possui regras do seu domínio; um _Infrastructure Service_, que usa algum pacote externo para realizar tarefas; etc. 
- pesar da interpretação ocorrer de várias formas, a ideia por trás do padrão é separar as regras de negócio, as regras da aplicação e as regras de apresentação para que elas possam ser facilmente testadas e reutilizadas em outras partes do sistema.
- Existem duas formas mais utilizadas para criar Services. Você pode criar Services mais genéricos, responsáveis por todas as atribuições de um Controller; ou ser ainda mais específico, aplicando assim o **S** do **SOLID: Single Responsibility Principle (Princípio da Responsabilidade Única)**. Esse princípio nos diz que uma classe/função/arquivo deve ter apenas uma **única responsabilidade**.
- Pense em um sistema de vendas, no qual provavelmente teríamos algumas funções como: _Cadastrar usuário_, _Efetuar login_, _Buscar produtos_, _Buscar produto por nome_, etc. Logo, poderíamos criar os seguintes Services: `CadastroDeUsuarioService`, `EfetuaLoginService`, `BuscaDeProdutosService`, etc.
- Mas é importante ficarmos atentos, pois muitas vezes não é necessário criar um Service e, consequentemente, adicionar mais uma camada e complexidade desnecessária à nossa aplicação. Uma regra que podemos utilizar é a seguinte: se não houverem regras de negócio, podemos simplesmente realizar a comunicação direta entre os controllers e os repositories da aplicação.

## Para saber mais: princípios SOLID
- SOLID é uma sigla que representa cinco princípios de programação:
1. _**S**ingle Responsability Principle_ (Princípio da Responsabilidade Única)
2. _**O**pen-Closed Principle_ (Princípio Aberto-Fechado)
3. _**L**iskov Substitution Principle_ (Princípio da Substituição de Liskov)
4. _**I**nterface Segregation Principle_ (Princípio da Segregação de Interface)
5. _**D**ependency Inversion Principle_ (Princípio da Inversão de Dependência)
- Cada princípio representa uma boa prática de programação, que quando aplicadas facilita muito a sua manutenção e extensão. Tais princípios foram criados por Robert Martin, conhecido como Uncle Bob, em seu artigo _Design Principles and Design Patterns_: https://staff.cs.utu.fi/~jounsmed/doos_06/material/DesignPrinciplesAndPatterns.pdf
- https://cursos.alura.com.br/extra/hipsterstech/praticas-de-orientacao-a-objetos-hipsters-129-a453
- https://cursos.alura.com.br/extra/hipsterstech/solid-codigo-bom-e-bonito-hipsters-ponto-tech-219-a649

## Para saber mais: OpenAPI Initiative
- A documentação é algo muito importante em um projeto, principalmente se ele for uma API Rest, pois nesse caso podemos ter vários clientes que vão precisar se comunicar com ela, necessitando então de uma documentação que os ensinem como realizar essa comunicação de maneira corret
- Por muito tempo não existia um formato padrão de se documentar uma API Rest, até que em 2010 surgiu um projeto conhecido como Swagger, cujo objetivo era ser uma especificação open source para design de APIs Rest. Depois de um tempo, foram desenvolvidas algumas ferramentas para auxiliar pessoas desenvolvedoras a implementar, visualizar e testar suas APIs, como o Swagger UI, Swagger Editor e Swagger Codegen, tornando-se assim muito popular e utilizado ao redor do mundo.
- A OpenAPI é hoje a especificação mais utilizada, e também a principal, para documentar uma API Rest. A documentação segue um padrão que pode ser descrito no formato yaml ou JSON, facilitando a criação de ferramentas que consigam ler tais arquivos e automatizar a criação de documentações, bem como a geração de códigos para consumo de uma API.

## Para saber mais: personalizando a documentação
- Vimos no vídeo anterior que é possível personalizar a documentação gerada pelo SpringDoc para a inclusão do token de autenticação. Além do token, podemos incluir outras informações na documentação que fazem parte da especificação OpenAPI, como, por exemplo, a descrição da API, informações de contato e de sua licença de uso.
- Tais configurações devem ser feitas no objeto `OpenAPI`, que foi configurado na classe `SpringDocConfigurations` de nosso projeto:
```java
@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components()
                    .addSecuritySchemes("bearer-key",
                            new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")))
                    .info(new Info()
                            .title("Voll.med API")
                            .description("API Rest da aplicação Voll.med, contendo as funcionalidades de CRUD de médicos e de pacientes, além de agendamento e cancelamento de consultas")
                            .contact(new Contact()
                                    .name("Time Backend")
                                    .email("backend@voll.med"))
                    .license(new License()
                            .name("Apache 2.0")
                            .url("http://voll.med/api/licenca")));
}
```
- imports:
```java
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
```
- https://spec.openapis.org/oas/latest.html#schema 

