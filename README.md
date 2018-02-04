# algamoney-api

## 1.1 Introdução ao curso 
* Habilitando o flash para rodar o video:
https://docs.google.com/document/d/1JwLx3Shjm7pGqyqbhErSoPkOz67mrlLqgB41hzZPyDs/edit

## 1.3 SOFEA => Service Oriented Front-End Architecture
Remover toda a lógica de apresentação do servidor e levar para o cliente

### Beneficios
* Desenvolvimento assíncrono entre front-end e back-end
* Escalabilidade
* Interoperabilidade
* Melhor experiência do cliente e baixa latência

## 1.4 REST
Restful -> Implementação da arquitetura REST
API Rest -> exposição dos serviços Restful

## 1.7 Testando APIs com Postman
Simulador de Resposta REST: www.mocky.io

## 2.3 Modelo de maturidade Richardson
Nível 0 -> Não é REST -> HTTP só para transporte
* Usa somente o verbo POST
* Não utiliza recursos
* Nãu utiliza os retornos de uma forma legal -> Retorna Status 200 OK com corpo informando falha na requisição

Nível 1 -> Ainda não é REST
* Utiliza recursos
* Usa somente o verbo POST
* Nãu utiliza os retornos de uma forma legal

Nível 2 -> Já pode ser considerado REST
* Utiliza recursos
* Utiliza os verbos HTTP
* Utiliza os retornos dos status de forma correta

Nível 3 -> REST completo
* Utiliza recursos
* Utiliza os verbos HTTP
* Utiliza os retornos dos status de forma correta
* Resposta indica quais ações podem ser realizadas para a requisição lançada

## 2.7. HATEOAS -> Hypertext As The Engine Of Application State
* É a implementação adicional do nível 3 de maturidade de Richardson
* Facilita o desenvolvimento do front-end, deixando a lógica de implementação do negócio somente no back-end
* HAL -> https://en.wikipedia.org/wiki/Hypertext_Application_Language

## 2.9. Idempotência
Um método idempotente é executado várias vezes e o resultado por ele produzido é sempre o mesmo

## 3.3. Migração de dados com Flyway
* Não usar ORM em produção:
http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#schema-generation
* Incluir no pom.xml
* Criar estrutura de diretorios: src/main/resources/db/migration

## 3.4. Consultando primeiro recurso com GET
Estruturando melhor os pacotes java:
Painel Package Explorer > Seta apontando para baixo (superior direita) > Package Presentation > Hierarchical

## 3.8. Validando atributos desconhecidos
Jackson
* biblioteca q converte objetos java em json e vice-versa
* Incluidos dois parametros no application.properties

## 3.9. Tratando erros com ExceptionHandler
Criado o arquivo messages.properties
-> conteudo lido através da implementação messageSource.getMessage(nome_propriedade,parametro passado para a propriedade,lingua nativa da mensagem)

## 3.10. Validando valores inválidos com Bean Validation
Criado o arquivo ValidationMessages.properties
-> para descobrir a propriedade que será tratada, basta clicar no nome da anotação e depois CTRL+clique do mouse
-> vai abrir a implementação da anotação e o valor estará no metodo message:
String message() default "{javax.validation.constraints.Size.message}"
-> conteudo lido através da implementação messageSource.getMessage(nome_propriedade,parametro passado para a propriedade,lingua nativa da mensagem)
-> Em messages.properties foram incluídos os nomes "apresentáveis" para o usuário através das propriedades <classe>.<atributo>
 
## 3.12. Usando eventos para adicionar header Location
Criado event e listener para tratar algum comportamento comum a um recurso criado, no caso o header location, que contem
o retorno da URI do recurso que foi criado (http://localhost:8080/categorias/15)

## 4.3. Atualizando pessoa com PUT
Criou-se uma classe Service para que as regras de negócio se concentrem nela (no caso, tratou pessoa = null qdo a chamada rest for para um recurso não existente no banco)

## 5.4. Validando inconsistências
Biblioteca commons.lang3 (maven) possui um metodo que traz a causa raiz de uma exceção: ExceptionUtils.getRootCauseMessage(exception)

## 5.6 Regra para não salvar pessoa inativa
* Criou-se uma classe Service para que as regras de negócio se concentrem nela (não salvar lançamento para pessoa inativa)
* Utilizar @JsonIgnore e/ou @Transient qdo um metodo numa entidade nao precisar ser serializada pelo Jackson ou pelo Hibernate

## 5.7. Implementando pesquisa de lançamento com Metamodel
* Metamodels são classes que criam atributos estáticos que representam os atributos das classes de entidades de banco de dados, para quando eles forem usados nas criterias de banco de dados, nao haja erro na digitação do nome das colunas.
* Uso: Lancamento_.descricao
* Sempre que uma propriedade de uma entidade de banco for alterada, o metamodel faz a adequação nas classes que referenciam aquele metamodel
* Habilitar Metamodel: Clicar no projeto -> botao direito do mouse -> propriedades -> Java Compiler -> Annotation Processing -> Clicar em Enable project Specific settings -> Generated source directory -> Preencher src/main/java -> Clicar na seta ao lado de Annotation Processing ->Clicar em Factory Path -> Clicar em Enable project Specific settings -> Clicar no botão Add External Java -> Selecionar em home do usuário a estrutura .m2 > repository > org > hibernate > hibernate-jpamodelgen > versão final (5.0.12.Final) > seleciona o jar (Se não encontrar, baixar do repositorio do maven inserindo a dependencia no pom.xml - depois q baixar nao precisa mais dessa dependencia no maven) -> desmarcar a opção org.eclipse.jst.ws.annotations.core -> Clicar no botão OK -> Clicar no botão Yes para fazer rebuild no projeto  
* Criou uma classe de filtro para trabalhar com os filtros na pesquisa de lançamento via rest (descrição, dataVencimentoDe e Ate)
* Criou uma classe de Query para trabalhar com as consultas no banco que necessitam de implementação de alguns critérios.

## 5.9. Implementando a paginação de lançamentos
Uso da interface Pageable nas classes que implementam o uso de paginação nas consultas rest

## 6.2. Fluxo básico do OAuth
https://www.digitalocean.com/community/tutorials/an-introduction-to-oauth-2
* No pacote config estão as configurações de segurança oAuth e token, como tempo de expiração, usuario e senha do cliente, etc..
* Recursos oauth implementado pelo Spring Security

## 6.4. JSON Web Tokens - JWT
https://jwt.io
Devolve um token mais completo, com trecho JSON onde pode-se passar o usuario e informações referentes a ele e as permissões dele.

## 6.7. Movendo o refresh token para o cookie
Configuração necessária para que o javascript nao tenha acesso ao refresh token, uma vez q ele nao consegue ler dados do cookies
Configurado no pacote token

## 6.9. O que é CORS? (Cross Origin HTTP Request)
https://spring.io/guides/gs/rest-service-cors/
* Os navegadores nao permitem q codigo javascript façam requisição a um destino diferente da origem

## 6.10. Criando filtro para CORS
Criado um pacote cors e dentro dele feita uma classe de filtro

## 6.12. Adicionando permissões de acesso
@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') => permissao do usuario no banco =< 
and #oauth2.hasScope('read') => permissao conforme scope do cliente ")

## 6.14. Implementando o logout
* Implementado na classe TokenResource
* Spring security nao tem implementação para remover o refresh token

## Subindo a aplicação
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin.permitida=http://localhost:4200

## Subindo a aplicação com oauth
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin-permitida=http://localhost:4200 --spring.profiles.active=oauth-security
