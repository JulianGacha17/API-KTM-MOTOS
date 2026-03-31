# 🏍️ API KTM MOTOS

API REST desarrollada en **Spring Boot** para la gestión de usuarios en un aplicativo de negocio de motos.

---

## 📌 Información del proyecto

- 👤 Autor: Julian Gacha
- 🎓 Programa: Técnico en Programación de Software
- 📚 Ficha: 3236085
- 🧪 Evidencia: GA4-220501096-AA1-EV01

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL
- Postman / Hoppscotch
- IntelliJ IDEA

---

## 🧱 Arquitectura

El proyecto está desarrollado bajo una arquitectura en capas:

- Controller → Manejo de endpoints REST  
- Service → Lógica de negocio  
- Repository → Acceso a datos  
- Model → Entidades  

---

## 🗄️ Base de datos

Base de datos: **motos_db**  
Tabla: **usuarios**

---

## ⚙️ Configuración

Archivo `application.properties`:
        spring.datasource.url=jdbc:mysql://localhost:3306/motos_db
        spring.datasource.username=root
        spring.datasource.password=TU_PASSWORD
        
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true


---

## 🌐 Endpoints

### 👤 Usuarios

- GET `/usuarios` → Listar usuarios  
- GET `/usuarios/{id}` → Obtener usuario  
- POST `/usuarios` → Crear usuario  
- PUT `/usuarios/{id}` → Actualizar usuario  
- DELETE `/usuarios/{id}` → Eliminar usuario  

---

### 🔐 Autenticación

- POST `/auth/login` → Login de usuario  


### Crear usuario

```json
{
  "nombre": "Julian Gacha",
  "correo": "julian@gmail.com",
  "password": "123456",
  "rol": "admin"
}
