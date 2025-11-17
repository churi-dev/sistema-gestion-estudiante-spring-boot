# sistema-gestion-estudiante-spring-boot
Proyecto de gestión de estudiantes desarrollado con Spring Boot, ejecutado desde consola e implementando operaciones CRUD (Crear, Leer, Actualizar y Eliminar).
Se utiliza una arquitectura basada en capas (model, repository, service).

## Modelo de datos

```sql
CREATE DATABASE bd_estudiante;

USE bd_estudiante;

CREATE TABLE estudiante (
  id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  telefono VARCHAR(20),
  email VARCHAR(100)
);
```
## Configuración del entorno
- Java 21 o superior
- Maven 3+
- MySQL Server 8+
- Spring Boot +3
- IDE recomendado: IntelliJ IDEA

---

##  < Autor />

Desarrollado por: churi-dev

---
