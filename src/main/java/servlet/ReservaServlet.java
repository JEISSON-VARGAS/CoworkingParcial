package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reserva;
import repository.ReservaRepository;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet que recibe los datos del formulario de reserva
 * y los guarda en la base de datos.
 */
@WebServlet("/guardar-reserva") // URL a la que se envía el formulario desde index.jsp
public class ReservaServlet extends HttpServlet {

    // Instancia del repository para acceder a la base de datos
    private ReservaRepository repository = new ReservaRepository();

    /**
     * Maneja peticiones POST desde el formulario de registro de reservas.
     *
     * @param request  Objeto HttpServletRequest que contiene los datos enviados desde el formulario
     * @param response Objeto HttpServletResponse para enviar la respuesta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String espacio = request.getParameter("espacio");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));

        // Crear un objeto Reserva con los datos recibidos
        Reserva reserva = new Reserva(nombre, espacio, duracion, fecha);

        // Guardar la reserva en la base de datos mediante el repository
        repository.guardar(reserva);

        // Redirigir al servlet que lista las reservas para mostrar la nueva reserva agregada
        response.sendRedirect("listar-reservas");
    }
}