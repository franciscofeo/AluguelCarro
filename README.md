
# Aluguel de Carros 🚗 

Essa é uma API Rest para um sistema de gerenciamento de aluguel de carros, foram criadas duas tabelas "Clientes" e "Carros" onde existe um relacionamento unidirecional entre elas. Para o desenvolvimento, utilizei o padrão MVC.

## Acessando a API

Para utilizar a API é necessário escrever o seguinte comando para o container docker instalar o Redis:

```java
docker run -it --name redis -p 6379:6379 redis:5.0.3
```

Com o comando acima funcionando, basta entrar na pasta raiz do projeto e escrever (lembre-se de ter o Maven instalado):

```java
mvn spring-boot:run
```

Agora temos a aplicação Spring Boot funcionando, acesse a url https://localhost:8080/swagger-ui.html e encontrará a página principal do projeto com a interface oferecida pelo Swagger, facilitando a utilização dos endpoints.


## Tecnologias Utilizadas

 - [Spring Framework](https://spring.io/)
 - [JPA](https://spring.io/projects/spring-data-jpa)
 - [Hibernate](https://hibernate.org/)
 - [H2 Database](https://www.h2database.com/html/main.html)
 - [Swagger](https://swagger.io/)
 - [Redis](https://redis.io/)

## Licença

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)


## ❓ FAQ ❓ 

#### Se eu quiser, posso utilizar livremente/gratuitamente a API?

Sim! Só lembre-se de dar os devidos créditos.

#### Encontrei um erro ou tenho alguma dúvida, posso entrar em contato com você?

Claro que sim, se tiver alguma dúvida pode mandar um email para _franciscoangelo.feo@gmail.com_, se encontrou algum bug pode indicar aqui mesmo através da plataforma do GitHub. 


![Logo](https://user-images.githubusercontent.com/64324517/134450660-c91a9d0b-8247-4d17-af24-e834a59d4226.png)

