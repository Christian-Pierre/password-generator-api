-- Active: 1713249654398@@localhost@3306@passwordapidb
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

ALTER TABLE tab_system_password ADD FOREIGN KEY(user_id) REFERENCES tab_account (id)

INSERT INTO tab_account (user_name,user_pass,user_pass_auth) 
VALUES("name generic", "Passgeneric*123", "75159535");

SELECT * FROM tab_account;
SELECT * FROM tab_system_password;