CREATE TABLE tab_user 
( 
 user_id INT PRIMARY KEY AUTO_INCREMENT,  
 user_name VARCHAR(250) NOT NULL,  
 user_pass VARCHAR(250) NOT NULL,  
 user_pass_auth VARCHAR(250)  
); 

CREATE TABLE tab_password 
( 
 user_id INT NOT NULL,  
 password_origin VARCHAR(250) NOT NULL,  
 password_contents VARCHAR(250) NOT NULL,  
 password_id INT PRIMARY KEY AUTO_INCREMENT
); 

ALTER TABLE tab_password ADD FOREIGN KEY(user_id) REFERENCES tab_user (user_id)

INSERT INTO tab_user (user_name,user_pass,user_pass_auth) 
VALUES("name generic", "Passgeneric*123", "passAuthGeneric");

SELECT * FROM tab_user;