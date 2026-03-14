package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ReservaRepository;

import java.io.IOException;

/**
 * Servlet que permite eliminar una reserva existente.
 * Recibe el ID de la reserva como parámetro y la borra de la base de datos.
 */
@WebServlet("/eliminar-reserva") // Define la URL por la que se accede al servlet
public class EliminarReservaServlet extends HttpServlet {

    // Instancia del repository para interactuar con la base de datos
    private ReservaRepository repository = new ReservaRepository();

    /**
     * Maneja peticiones GET para eliminar una reserva.
     *
     * @param request  Objeto HttpServletRequest que contiene los parámetros de la petición
     * @param response Objeto HttpServletResponse para enviar la respuesta al cliente
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Obtiene el parámetro "id" de la URL y lo convierte a Long
        // Ejemplo de URL: /eliminar-reserva?id=3
        Long id = Long.parseLong(request.getParameter("id"));

        // Llama al repository para eliminar la reserva con ese ID
        repository.eliminar(id);

        // Redirige a la lista de reservas después de eliminar
        response.sendRedirect("listar-reservas");
    }
}