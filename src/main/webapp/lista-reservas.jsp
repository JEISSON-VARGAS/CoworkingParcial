<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Reserva" %>

<html>
<head>
    <title>Lista de Reservas</title>
    <link rel="stylesheet" type="text/css" href="css/listar-reservas.css">
</head>
<body>

<h2>Reservas Registradas</h2>

<a class="nueva-reserva"href="index.jsp">Nueva Reserva</a>

<br><br>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Espacio</th>
        <th>Duración</th>
        <th>Fecha</th>
        <th>Acción</th>
    </tr>

<%
    List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");

    if(reservas != null){
        for(Reserva r : reservas){
%>

<tr>
    <td><%= r.getId() %></td>
    <td><%= r.getNombre() %></td>
    <td><%= r.getEspacio() %></td>
    <td><%= r.getDuracion() %></td>
    <td><%= r.getFecha() %></td>
    <td>
        <a href="eliminar-reserva?id=<%= r.getId() %>">Eliminar</a>
    </td>
</tr>

<%
        }
    }
%>

</table>

</body>
</html>