<%@ page import="org.example.telenetcrud.beans.Plan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Plan plan = (Plan) request.getAttribute("plan"); %>
<!DOCTYPE html>
<html lang="es"><head><meta charset="UTF-8"><title>Editar plan</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"></head>
<body><main class="container mt-5"><h1>Editar plan</h1>
<form action="<%=request.getContextPath()%>/PlanServlet?action=actualizar" method="post">
<input type="hidden" name="idPlan" value="<%=plan.getIdPlan()%>">
<div class="mb-3"><label class="form-label">Nombre</label><input class="form-control" name="nombre" maxlength="100" value="<%=plan.getNombre()%>" required></div>
<div class="mb-3"><label class="form-label">Velocidad (Mbps)</label><input class="form-control" name="velocidad" type="number" min="1" value="<%=plan.getVelocidadMbps()%>" required></div>
<div class="mb-3"><label class="form-label">Precio S/</label><input class="form-control" name="precio" type="number" min="0" step="0.01" value="<%=plan.getPrecio()%>" required></div>
<div class="mb-3"><label class="form-label">Estado</label><select class="form-select" name="estado">
<option value="Activo" <%= "Activo".equals(plan.getEstado()) ? "selected" : "" %>>Activo</option>
<option value="Inactivo" <%= "Inactivo".equals(plan.getEstado()) ? "selected" : "" %>>Inactivo</option>
</select></div>
<button class="btn btn-success" type="submit">Actualizar</button>
<a class="btn btn-secondary" href="<%=request.getContextPath()%>/PlanServlet">Cancelar</a>
</form></main></body></html>
