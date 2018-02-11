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
* Estruturando melhor os pacotes java:
- Painel Package Explorer > Seta apontando para baixo (superior direita) > Package Presentation > Hierarchical
* Alterando author e commiter:
- Click Preferences > Team > Git > Configuration
- Click New Entry and enter the key value pairs:

Key: user.name
Value: YourUsernameHere

And

Key: user.email
Value: YourEmailHere

* Mostrar numero de linhas e trocar tab por espaço:
 Window → Preferences → General → Editors → Text Editors → Show line numbers/Insert space in tab

* Alterando o java de jre para jdk
On your Eclipse IDE, go into Window > Preferences > Java > Installed JREs > and check your installed JREs. You should have an entry with a JDK there.
Select the Execution Env as show below. Click OK
Then Right-Click on your Project -> Maven -> Update Project

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
* Habilitar Metamodel: Clicar no projeto -> botao direito do mouse -> propriedades -> Java Compiler -> Annotation Processing -> Clicar em Enable project Specific settings -> Generated source directory -> Preencher src/main/java -> Clicar na seta ao lado de Annotation Processing ->Clicar em Factory Path -> Clicar em Enable project Specific settings -> Clicar no botão Add External Java -> Selecionar em home do usuário a estrutura .m2 > repository > org > hibernate > hibernate-jpamodelgen > versão final (5.0.12.Final) > seleciona o jar (Se não encontrar, baixar do repositorio do maven inserindo a dependencia no pom.xml - DEPOIS Q BAIXAR DEVE RETIRAR ESSA DEPENDENCIA DO POM.XML) -> desmarcar a opção org.eclipse.jst.ws.annotations.core -> Clicar no botão OK -> Clicar no botão Yes para fazer rebuild no projeto  
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
* Configuração necessária para que o javascript nao tenha acesso ao refresh token, uma vez q ele nao consegue ler dados do cookies
Configurado no pacote token
* Primeiro buscar o access token com usuario e senha da aplicação, o cliente (API) e o refresh token estará no cookie
* as próximas requisições do access token podem ser uma chamada na api com refresh token, buscando ele no cookiee

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

## 7.1. Implementando projeção de lançamento
* Implementação do parametro resumo de lançamento na url get rest
* Criada uma classe no pacote projection em lancamento e implementado na classe que implementa o RepositoryQuery 

## 7.2. Profiles do Spring
* Encontrar TODO nos codigos: Window > Show View > Other > General > Tasks
* Criada a classe AlgamoneyApiProperty no pacote config > property para definir as propriedades que variam de ambiente para ambiente, por exemplo origem permitida e acesso https da aplicação
* Criada a classe estatica apenas para agrupar as propriedades
* Para habilitar a chamada das propriedades externamente (arquivo application.properties por exemplo) é necessário incluir a anotação @EnableConfigurationProperties(AlgamoneyApiProperty.class) na classe AlgamoneyApiApplication
* Criado o arquivo application-prod.properties para incluir a propriedade algamoney.seguranca.enable-https=true. No ambiente de produção esse arquivo de propriedades será invocado

## 7.3. Criando a conta no Heroku
Instalar o heroku cli e digitar heroku login informando usuario e senha cadastrados no site do heroku

## 7.4. Deploy da API na nuvemm
* acesse o diretório onde estão os arquivos da aplicação (src/, target/, pom.xml, mvnw e mvnw.cmd)
* heroku loginn
* git init (para que o projeto seja gerenciado pelo git)
* Confirmar se no .gitignore tem o diretório target/
* git add .
* git commit -m "Primeira Versão"
* criar aplicação no heroku: 
- heroku create algamoney-api (nome da aplicação precisa ser único e disponível)heroku create algamoney-api-vz
Creating ⬢ algamoney-api-vz... done
https://algamoney-api-vz.herokuapp.com/ | https://git.heroku.com/algamoney-api-vz.git

- heroku addons:create heroku-postgresql:hobby-devvCreating heroku-postgresql:hobby-dev on algamoney-api-vz... free
Database has been created and is available
 ! This database is empty. If upgrading, you can transfer
 ! data from another database with pg:copy
Created postgresql-curved-33244 as DATABASE_URL
Use heroku addons:docs heroku-postgresql to view documentation

- heroku config:get DATABASE_URL>postgres://livwgjqrwozzfw:60d7fe7310729f2e56fa9c0dfeff2c59193b43b140e861cf1ccbd6217fa011d2@ec2-23-21-162-90.compute-1.amazonaws.com:5432/d80lfhqur7gsv9

* pegar as informações de retorno desse comando e atribuir as variaveis correspondentes no application-prod.properties:
- heroku config:set JDBC_DATABASE_URL=jdbc:postgres://URL_DO_FINAL_ATE_@ JDBC_DATABASE_USERNAME=URL_DEPOIS_//_ATE_: JDBC_DATABASE_PASSWORD=URL_DEPOIS_:_ATE_@

heroku config:set JDBC_DATABASE_URL=jdbc:postgres://ec2-23-21-162-90.compute-1.amazonaws.com:5432/d80lfhqur7gsv9 JDBC_DATABASE_USERNAME=livwgjqrwozzfw JDBC_DATABASE_PASSWORD=60d7fe7310729f2e56fa9c0dfeff2c59193b43b140e861cf1ccbd6217fa011d2

Setting JDBC_DATABASE_URL, JDBC_DATABASE_USERNAME, JDBC_DATABASE_PASSWORD and restarting ⬢ algamoney-api-vz... done, v4
JDBC_DATABASE_PASSWORD: 60d7fe7310729f2e56fa9c0dfeff2c59193b43b140e861cf1ccbd6217fa011d2
JDBC_DATABASE_URL:  jdbc:postgres://ec2-23-21-162-90.compute-1.amazonaws.com:5432/d80lfhqur7gsv9
JDBC_DATABASE_USERNAME: livwgjqrwozzfw

- heroku config traz as variaveis configuradas no herokuu=== algamoney-api-vz Config Vars

DATABASE_URL:       postgres://livwgjqrwozzfw:60d7fe7310729f2e56fa9c0dfeff2c59193b43b140e861cf1ccbd6217fa011d2@ec2-23-21-162-90.compute-1.amazonaws.com:5432/d80lfhqur7gsv9
JDBC_DATABASE_PASS:60d7fe7310729f2e56fa9c0dfeff2c59193b43b140e861cf1ccbd6217fa011d2
JDBC_DATABASE_URL:jdbc:postgres://ec2-23-21-162-90.compute-1.amazonaws.com:5432/d80lfhqur7gsv9
JDBC_DATABASE_USER:livwgjqrwozzfw

* inserir algamoney.origin-permitida=https://algamoney-ui.herokuapp.com (URL do angular q tb sera deployada no heroku) no arquivo application-prod.propertiess
* criar arquivo procfile na raiz do projeto:
- -Dspring.profiles.active=prod habilita o uso do arquivo application-prod.propertiess
- -jar target/algamoney*.jar especifica o arquivo jar da aplicaçãoo
* git add e git commit para toda alteraçãoo
* git push heroku master para enviar para o repositorio master do git remotoo
* heroku logs --tail para acompanhar a subida da aplicaçãoo* o comando ps serve para que você veja alguns detalhes sobre a sua hospedagem: heroku ps --app aw-gestao-festa
* You can run a command, typically scripts and applications that are part of your app:
- heroku run bash

* Criar um novo access token - duplicando o original e alterando a url do heroku

## 7.5. Nome do usuário no token JWTT
* Criada classe CustomTokenEnhancer no pacote config > token para incluir o nome do usuario no token
* Essa nova classe é chamada em AuthorizationServerConfig dentro do pacote config

## 7.6. Alternando OAuth 2 e Basic Security com profiles
* Criada a classe BasicSecurityConfig no pacote config com anotação @Profile("basic-security"). Já a classe AuthorizationServerConfig possui a anotação @Profile("oauth-security")
* em application.properties foi inserida a propriedade spring.profiles.active=oauth-security informando neste caso q autenticação será oauth

## Subindo a aplicação
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin.permitida=http://localhost:4200

## Subindo a aplicação com oauth
java -jar algamoney-api-0.0.1-SNAPSHOT.jar --algamoney.origin-permitida=http://localhost:4200 --spring.profiles.active=oauth-security
