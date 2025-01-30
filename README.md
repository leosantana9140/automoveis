# Como rodar o projeto localmente:

- Após baixar o projeto, configurar a JDK 11 no Intellij.

- Rodar o comando `mvn clean install`, para garantir que todas as dependências necessárias para o projeto funcionar sejam baixadas corretamente.

- Inicializar o projeto normalmente.

# CURLs de apoio para requisições no Postman:

## Cadastro de automóvel:
~~~
curl --location 'http://localhost:8080/cadastroAutomoveis' \
--header 'Content-Type: application/json' \
--data '{
    "marca": "Hyundai",
    "modelo" : "HB20",
    "valor" : 80000
}'
~~~

## Listagem de todos automóveis cadastrados:
~~~
curl --location 'http://localhost:8080/automoveis'
~~~

## Busca de automóvel por ID
~~~
curl --location 'http://localhost:8080/automoveis/1'
~~~

# Como visualizar as informações salvas no Banco de Dados H2:

- Acessar a seguinte URL: http://localhost:8080/h2-console

- Preencher os seguintes campos:
  - Driver Class: org.h2.Driver
  - JDBC URL: jdbc:h2:mem:automovel
  - User Name: sa
  - Password: (não precisa de senha, pode deixar em branco)