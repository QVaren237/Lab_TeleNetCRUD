CREATE DATABASE IF NOT EXISTS lab_telenet;
USE lab_telenet;

CREATE TABLE IF NOT EXISTS planes (
  id_plan INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  velocidad_mbps INT NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  estado VARCHAR(20) NOT NULL
);

-- Ejecutar la carga inicial solo una vez:
INSERT INTO planes(nombre, velocidad_mbps, precio, estado) VALUES
('Basico',100,69.90,'Activo'),
('Hogar',200,99.90,'Activo'),
('Premium',500,149.90,'Activo'),
('Empresarial',1000,299.90,'Inactivo');
