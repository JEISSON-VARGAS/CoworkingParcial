package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ReservaRepository;

import java.io.IOException;

/**
 * Servlet que obtiene todas las reservas de la base de datos
 * y las envía a la vista JSP para mostrarlas en una tabla.
 */
@WebServlet("/listar-reservas") // URL por la que se accede al servlet
public class ListarReservasServlet extends HttpServlet {

    // Instancia del repository para acceder a los datos de reservas
    private ReservaRepository repository = new ReservaRepository();

    /**
     * Maneja peticiones GET para listar todas las reservas.
     *
     * @param request  Objeto HttpServletRequest que contiene la información de la petición
     * @param response Objeto HttpServletResponse para enviar la respuesta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Llama al repository para obtener todas las reservas
        // y las almacena como atributo "reservas" para la vista JSP
        request.setAttribute("reservas", repository.listar());

        // Redirige la petición a la JSP "lista-reservas.jsp" para mostrar los datos
        request.getRequestDispatcher("lista-reservas.jsp")
                .forward(request, response);
    }
}