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

@WebServlet("/guardar-reserva")

public class ReservaServlet extends HttpServlet {
    private ReservaRepository repository = new ReservaRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String espacio = request.getParameter("espacio");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));

        Reserva reserva = new Reserva(nombre, espacio, duracion, fecha);

        repository.guardar(reserva);

        response.sendRedirect("listar-reservas");
    }
}
