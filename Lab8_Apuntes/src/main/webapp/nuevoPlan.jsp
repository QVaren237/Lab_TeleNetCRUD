<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es"><head><meta charset="UTF-8"><title>Crear plan</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"></head>
<body><main class="container mt-5"><h1>Registrar nuevo plan</h1>
<form action="<%=request.getContextPath()%>/PlanServlet?action=crear" method="post">
<div class="mb-3"><label class="form-label">Nombre</label><input class="form-control" name="nombre" maxlength="100" required></div>
<div class="mb-3"><label class="form-label">Velocidad (Mbps)</label><input class="form-control" type="number" min="1" name="velocidad" required></div>
<div class="mb-3"><label class="form-label">Precio S/</label><input class="form-control" type="number" min="0" step="0.01" name="precio" required></div>
<div class="mb-3"><label class="form-label">Estado</label><select class="form-select" name="estado"><option value="Activo">Activo</option><option value="Inactivo">Inactivo</option></select></div>
<button class="btn btn-success" type="submit">Guardar</button>
<a class="btn btn-secondary" href="<%=request.getContextPath()%>/PlanServlet">Cancelar</a>
</form></main></body></html>
