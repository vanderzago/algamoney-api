# algamoney-api

## 1.0 Habilitando o flash para rodar o video
https://docs.google.com/document/d/1JwLx3Shjm7pGqyqbhErSoPkOz67mrlLqgB41hzZPyDs/edit

## SOFEA => Service Oriented Front-End Architecture
Remover toda a lógica de apresentação do servidor e levar para o cliente

### Beneficios
* Desenvolvimento assíncrono entre front-end e back-end
* Escalabilidade
* Interoperabilidade
* Melhor experiência do cliente e baixa latência

## REST
Restful -> Implementação da arquitetura REST
API Rest -> exposição dos serviços Restful

## Testando APIs com Postman
www.mocky.io

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


## Subindo a aplicação
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin.permitida=http://localhost:4200

## Subindo a aplicação com oauth
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin-permitida=http://localhost:4200 --spring.profiles.active=oauth-security
