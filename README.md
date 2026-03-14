# Proyecto Reserva Coworking

Aplicación web para gestionar reservas de espacios de coworking. Permite registrar, listar y eliminar reservas de manera sencilla, usando arquitectura **MVC** con soporte de **JPA/Hibernate** para persistencia.

---

## 📂 Estructura del Proyecto

El proyecto sigue una arquitectura en capas organizada de la siguiente manera:

### 1. Capa Modelo (`src/main/java/model`)
- Contiene las clases que representan los datos de la aplicación.
- Ejemplo: `Reserva.java` representa una reserva con atributos como `id`, `nombre`, `espacio`, `duracion` y `fecha`.
- Se encarga de la lógica de negocio y validaciones básicas.

### 2. Capa Config (`src/main/java/config`)
- Contiene clases de **configuración del sistema**, principalmente `JPAUtil.java`.
- `JPAUtil.java` crea y gestiona la **factoría de EntityManager**, permitiendo a los repositorios interactuar con la base de datos mediante JPA.

### 3. Capa Repository (`src/main/java/repository`)
- Contiene las clases que interactúan directamente con la base de datos.
- Ejemplo: `ReservaRepository.java` → implementa operaciones CRUD sobre la entidad `Reserva` usando JPA.
- Esta capa abstrae la persistencia del resto de la aplicación.

### 4. Capa Controlador (`src/main/java/servlet`)
- Contiene los **Servlets** que gestionan las solicitudes HTTP.
- Ejemplos:
  - `GuardarReservaServlet` → recibe los datos del formulario y los guarda.
  - `ListarReservasServlet` → obtiene todas las reservas y las pasa a la vista.
  - `EliminarReservaServlet` → elimina una reserva por ID.
- Intermedia entre la vista y el modelo/repository.

### 5. Capa Vista (`src/main/webapp`)
- Contiene los **JSP** que muestran la interfaz al usuario:
  - `index.jsp` → formulario para registrar reservas.
  - `listar-reservas.jsp` → lista de reservas en tabla con estilo.
- Carpeta `css/` → contiene los estilos de la aplicación.
- Los JSP usan CSS moderno y colores azul, blanco y negro.

### 6. Recursos (`src/main/resources`)
- `META-INF/persistence.xml` → configuración de JPA/Hibernate (datasource, entidades, provider).
- Otros recursos como archivos de propiedades o configuración adicional.

---

## 🛠 Requisitos

- Java JDK 11 o superior  
- Apache Tomcat 10 o superior  
- Maven 3 o superior  

---

## 🌐 URLs y Rutas

- **URL principal de la aplicación**:  
http://localhost:8080/reserva-1.0-SNAPSHOT/

Redirige al formulario de registro de reservas (`index.jsp`).

- **Formularios y JSPs**:
  - `/index.jsp` → Formulario de registro de reservas.
  - `/listar-reservas` → Lista de reservas (Servlet + JSP).

- **Servlets**:
  - `/guardar-reserva` → Guarda los datos enviados desde `index.jsp`.
  - `/eliminar-reserva?id={id}` → Elimina la reserva con el ID especificado y redirige a listar reservas.

---

## ⚡ Ejecutar la Aplicación

1. **Compilar y generar WAR**

```bash
mvn clean package
