
CREATE DATABASE TodoList;

CREATE USER tdUser@localhost IDENTIFIED by '12345';
GRANT all privileges on *.* TO tdUser@localhost;

CREATE USER 
'tdUser'@'192.168.0.%';
GRANT ALL privileges ON *.* TO 
'tdUser'@'192.168.0.%';


