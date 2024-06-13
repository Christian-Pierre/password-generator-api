# Password API

The password management and generation API offers services to securely generate and validate passwords. is a proposal being developed in Java to provide a reliable and easy-to-integrate solution into different applications.

A API de gerenciamento e geração de senhas oferece serviços para gerar e validar senhas de forma segura. é uma proposta sendo desenvolvida em Java para fornecer uma solução confiável e fácil de integrar em diferentes aplicativos.


Project status: `in progress`

### Technologies
- Java 17
- Spring 3.2.4
- MySQL 5.7

### Original development environment
- Windows 11 Home 23H2
- WSL2 (Ubuntu)
- openjdk 18.0.2-ea 2022-07-19
- Apache Maven 3.6.3


## Stack

**Back-end:** Java, Spring-boot, MySQL


## Documentação

#### Deploy Application
 - Docker 
    ```bash
    docker compose up -d
    ```
 - Connect and configure database with Database initializer
    - #### Database connection
    ```yaml
        MYSQL_DATABASE: 'passwordapidb'   
        MYSQL_USER: 'user'
        MYSQL_PASSWORD: 'pass'      
        MYSQL_ROOT_PASSWORD: 'rootpass'
    ```
    - #### Database initializer
    ```sql
    --CRIAÇÃO DAS TABELAS
    CREATE TABLE tab_account
    ( 
    id INT PRIMARY KEY AUTO_INCREMENT,  
    user_name VARCHAR(250) NOT NULL,  
    user_pass VARCHAR(250) NOT NULL,  
    user_pass_auth VARCHAR(250)  
    ); 
    CREATE TABLE tab_system_password 
    ( 
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,  
    system_origin VARCHAR(250) NOT NULL,  
    system_login VARCHAR(250) NOT NULL,  
    system_password VARCHAR(250) NOT NULL
    ); 

    --INSERINDO CHAVES ESTRANGEIRAS
    ALTER TABLE tab_system_password ADD FOREIGN KEY(user_id) REFERENCES tab_account (id)

    --INSERINDO INFORMAÇÃO INICIAL
    INSERT INTO tab_account (user_name,user_pass,user_pass_auth) 
    VALUES("name generic", "Passgeneric*123", "75159535");
    ```
 - Run spring-boot Application
    ```bash
    mvn spring-boot:run
    ```
    
#### Swagger

Documentação da API em ambiente de Desenvolvimento
 - Ex: http://localhost:8080/swagger-ui/index.html#/
## Referência

 - [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
 - [Awesome README](https://github.com/matiassingers/awesome-readme)
 - [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

