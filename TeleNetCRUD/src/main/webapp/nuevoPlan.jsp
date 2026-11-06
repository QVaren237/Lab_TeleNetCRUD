<%--
  Created by IntelliJ IDEA.
  User: gersm
  Date: 06/11/2026
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

    <h1>Registrar nuevo plan</h1>

    <form action="PlanServlet?action=crear" method="post">

        <label>Nombre del plan:</label>
        <input type="text" name="nombre" required>

        <label>Velocidad (Mbps):</label>
        <input type="number" name="velocidad" required min="1">

        <label>Precio mensual:</label>
        <input type="number" name="precio"
             step="0.01" min="0" required>

        <label>Estado:</label>
        <select name="estado">
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
    </select>

        <button type="submit">Guardar plan</button>

    </form>

  
  </body>
</html>
