CREATE DATABASE rh_db;

-- Cree un utilisateur pour etre utiliser par java
CREATE USER 'java'@'localhost' IDENTIFIED BY '4LbfnsYOwXvHbonoaICiYmgoMRtEyf';
GRANT ALL PRIVILEGES ON * . * TO 'java'@'localhost';
FLUSH PRIVILEGES;

-- Les tables sont creer automatiquement par JPA