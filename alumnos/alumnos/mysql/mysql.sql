-- Crea la base de datos dbalumnos
drop database IF EXISTS dbalumnos;
CREATE DATABASE dbalumnos;
USE dbalumnos;

-- Crea la tabla alumnos con varios campos
CREATE TABLE alumnos (
  -- ID único para cada alumnos, que se autoincrementa
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  telefono VARCHAR(50) NOT NULL,
  correo VARCHAR(50) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  -- La fecha de nacimiento se almacena en formato de fecha
  PRIMARY KEY (id) -- Define el ID como clave primaria
);


INSERT INTO alumnos (nombre, apellido, telefono, correo, direccion) VALUES
('Juan', 'Pérez', '555-1234', 'juan.perez@example.com', 'Calle Falsa 123'),
('María', 'López', '555-5678', 'maria.lopez@example.com', 'Avenida Siempre Viva 456'),
('Carlos', 'Martínez', '555-9101', 'carlos.martinez@example.com', 'Ruta 78 Km 5'),
('Ana', 'González', '555-1122', 'ana.gonzalez@example.com', 'Boulevard Los Olivos 789'),
('Luis', 'García', '555-3344', 'luis.garcia@example.com', 'Callejón Quito 101'),
('Lucía', 'Fernández', '555-5566', 'lucia.fernandez@example.com', 'Alameda Norte 234'),
('Roberto', 'Hernández', '555-7788', 'roberto.hernandez@example.com', 'Camino Largo 567'),
('Patricia', 'Sánchez', '555-9900', 'patricia.sanchez@example.com', 'Sendero de la Luna 890'),
('Jorge', 'Ramírez', '555-2233', 'jorge.ramirez@example.com', 'Plaza Central 345');

SELECT * FROM alumnos;
/*
  Este es un comentario de múltiples líneas.
  Puedes usarlo para explicar secciones más grandes de tu código
  o para dejar notas más detalladas.
  Por ejemplo, este script SQL crea una base de datos para alumnos
  y una tabla para almacenar sus datos, incluyendo nombre, apellido,
  contacto, y fecha de nacimiento.
*/
