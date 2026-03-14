package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ReservaRepository;

import java.io.IOException;

@WebServlet("/listar-reservas")
public class ListarReservasServlet extends HttpServlet {

    private ReservaRepository repository = new ReservaRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("reservas", repository.listar());

        request.getRequestDispatcher("lista-reservas.jsp")
                .forward(request, response);
    }
}
