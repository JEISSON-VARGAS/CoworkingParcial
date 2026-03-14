# Proyecto Reserva Coworking

Aplicación web para gestionar reservas de espacios de coworking. Permite registrar, listar y eliminar reservas de manera sencilla.

---

## 📂 Estructura del Proyecto

El proyecto sigue la arquitectura **MVC (Modelo-Vista-Controlador)**:

### 1. Capa Modelo (`src/main/java/model`)
- Contiene las **clases que representan los datos** de la aplicación.
- Ejemplo: `Reserva.java` representa una reserva con atributos como `id`, `nombre`, `espacio`, `duracion` y `fecha`.
- Se encarga de la lógica de negocio y manipulación de datos.

### 2. Capa Controlador (`src/main/java/servlet`)
- Contiene los **Servlets** que gestionan las solicitudes del cliente.
- Ejemplos:
  - `GuardarReservaServlet` → recibe los datos del formulario y los guarda.
  - `ListarReservasServlet` → obtiene las reservas y las pasa a la vista.
  - `EliminarReservaServlet` → elimina una reserva por ID.
- Intermedia entre la vista y el modelo.

### 3. Capa Vista (`src/main/webapp`)
- Contiene los **JSP** que muestran la interfaz al usuario.
- Ejemplos:
  - `index.jsp` → formulario para registrar reservas.
  - `listar-reservas.jsp` → tabla con todas las reservas registradas.
- Utiliza CSS para estilos (`css/estilos.css` y `css/lista-reservas.css`).

---

## 🛠 Requisitos

- Java JDK 17   
- Apache Tomcat 10   
- Maven 3 o superior  

---

## ⚡ Ejecutar la Aplicación

1. **Compilar el proyecto y generar WAR**

```bash
mvn clean package
