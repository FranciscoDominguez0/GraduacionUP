/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  domin
 * Created: 07/04/2025
 */
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS graduacionUP;
USE graduacionUP;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(100) NOT NULL
);

-- Insertar un usuario de prueba
INSERT INTO usuarios (nombre_usuario, contraseña)
VALUES ('admin', '12345');

-- Tabla de documentos subidos
CREATE TABLE documentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_documento VARCHAR(100) NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    archivo LONGBLOB NOT NULL,
    usuario_id INT NOT NULL,
    fecha_subida DATETIME DEFAULT NOW(),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Tabla de solicitudes de seguimiento
CREATE TABLE solicitudes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descripcion TEXT,
    estado VARCHAR(20) DEFAULT 'Pendiente', -- Aprobado, Rechazado, Pendiente
    fecha DATETIME DEFAULT NOW(),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Tabla de notificaciones
CREATE TABLE notificaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    mensaje TEXT NOT NULL,
    estado VARCHAR(20) DEFAULT 'No leída', -- Leída / No leída
    fecha DATETIME DEFAULT NOW(),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

--------------------------------------------------------------------------------------------------------------

-- Insertar datos
INSERT INTO usuarios (nombre_usuario, contraseña)
VALUES ('marielys', 'clave123');


--  Insertar solicitud de seguimiento
INSERT INTO solicitudes (usuario_id, descripcion, estado)
VALUES (2, 'Solicitud para revisión de documentos finales de graduación.', 'Pendiente');

-- Insertar notificación relacionada
INSERT INTO notificaciones (usuario_id, mensaje, estado)
VALUES (2, 'Tu solicitud ha sido registrada y está pendiente de revisión.', 'No leída');

-- nsertar documentos
INSERT INTO documentos (nombre_documento, tipo_documento, archivo, usuario_id)
VALUES 
('Certificación de inglés', 'Certificado', '', 2),
('Paz y Salvo', 'Paz y Salvo', '', 2),
('Recibo de Inscripción', 'Recibo', '', 2),
('Servicio Social', 'Certificado', '', 2);


