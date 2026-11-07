<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.telenetcrud.beans.Plan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
ArrayList<Plan> lista = (ArrayList<Plan>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="es"><head><meta charset="UTF-8"><title>TeleNet — Planes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head><body><main class="container mt-5">
<h1>Planes de Internet — TeleNet</h1>
<a class="btn btn-primary my-3" href="<%=request.getContextPath()%>/PlanServlet?action=formCrear">Crear nuevo plan</a>
<table class="table table-bordered table-striped">
<thead class="table-dark"><tr><th>ID</th><th>Nombre</th><th>Mbps</th><th>Precio S/</th><th>Estado</th><th>Acciones</th></tr></thead>
<tbody>
<% for (Plan plan : lista) { %>
<tr>
<td><%=plan.getIdPlan()%></td>
<td><%=plan.getNombre()%></td>
<td><%=plan.getVelocidadMbps()%></td>
<td><%=plan.getPrecio()%></td>
<td><%=plan.getEstado()%></td>
<td>
<a class="btn btn-warning btn-sm" href="<%=request.getContextPath()%>/PlanServlet?action=editar&id=<%=plan.getIdPlan()%>">Editar</a>
<form class="d-inline" action="<%=request.getContextPath()%>/PlanServlet?action=eliminar" method="post" onsubmit="return confirm('¿Eliminar este plan?')">
<input type="hidden" name="id" value="<%=plan.getIdPlan()%>">
<button class="btn btn-danger btn-sm" type="submit">Eliminar</button></form>
</td></tr>
<% } %>
</tbody></table></main></body></html>
