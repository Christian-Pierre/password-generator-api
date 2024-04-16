CREATE TABLE tab_user 
( 
 user_id INT PRIMARY KEY AUTO_INCREMENT,  
 user_name VARCHAR(250) NOT NULL,  
 user_pass VARCHAR(250) NOT NULL,  
 user_pass_auth VARCHAR(250)  
); 

CREATE TABLE tab_Password 
( 
 user_id INT NOT NULL,  
 password_origin VARCHAR(250) NOT NULL,  
 password_contents VARCHAR(250) NOT NULL,  
 password_id INT PRIMARY KEY AUTO_INCREMENT
); 

ALTER TABLE tab_Password ADD FOREIGN KEY(user_id) REFERENCES tab_user (user_id)
