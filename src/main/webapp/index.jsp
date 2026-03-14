<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reserva Coworking</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

<h2>Registrar Reserva</h2>

<form action="guardar-reserva" method="post">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" required><br><br>

    <label>Espacio:</label><br>
    <select name="espacio" required>
        <option value="Sala Reuniones">Sala Reuniones</option>
        <option value="Escritorio Individual">Escritorio Individual</option>
        <option value="Oficina Privada">Oficina Privada</option>
    </select><br><br>

    <label>Duracion-Tiempo (horas):</label><br>
    <input type="number" name="duracion" min="1" required><br><br>

    <label>Fecha:</label><br>
    <input type="date" name="fecha" required><br><br>

    <button type="submit">Guardar Reserva</button>

</form>

<br><br>

<a href="listar-reservas">Ver Reservas</a>

</body>
</html>