DROP DATABASE BProveedores;
CREATE DATABASE BProveedores;
USE BProveedores;


CREATE TABLE TProductos  (
Id   		 INT   AUTO_INCREMENT PRIMARY KEY,
Nombre           VARCHAR(20) NOT NULL,
Descripcion      VARCHAR(20) NOT NULL
);
 
CREATE TABLE TProveedores  (
Id  		 INT  AUTO_INCREMENT PRIMARY KEY,
Nombre           VARCHAR(20)  NOT  NULL,
Telefono 	 VARCHAR(15)  NOT  NULL,
Contacto	 VARCHAR(20)  NOT NULL
);
 

CREATE TABLE TCompras  (
Id   		 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
IdProducto	 INT NOT NULL,
IdProveedor	 INT NOT NULL,
Cantidad         INT NOT NULL,
Precio		 DECIMAL(6,2) NOT NULL,
Fecha        DATE NOT NULL,
FOREIGN KEY (IdProducto)  REFERENCES TProductos (Id),
FOREIGN KEY (IdProveedor) REFERENCES TProveedores (Id)
);

CREATE TABLE TUsuarios  (
Id   		 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Login		 VARCHAR(15) NOT NULL,
Pass		 VARCHAR(15) NOT NULL
);

INSERT INTO TUsuarios (Login, Pass) VALUES 
	('Gerente','gerentePWD'),
	('Empleado','empleadoPWD')
;


