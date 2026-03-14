package servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ReservaRepository;

import java.io.IOException;

@WebServlet("/eliminar-reserva")
public class EliminarReservaServlet extends HttpServlet {

    private ReservaRepository repository = new ReservaRepository();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        repository.eliminar(id);

        response.sendRedirect("listar-reservas");
    }
}
