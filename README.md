
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