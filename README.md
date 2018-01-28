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

## Subindo a aplicação
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin.permitida=http://localhost:4200

## Subindo a aplicação com oauth
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin-permitida=http://localhost:4200 --spring.profiles.active=oauth-security
