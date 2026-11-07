# Lab8_Apuntes — CRUD TeleNet

Resolucionario de práctica académica basado en las clases **6.5 JDBC**, **7.2 MVC Parte 1** y **7.3 MVC Parte 2** de Ingeniería Web para Telecomunicaciones.

## Tecnologías
Java 17, Maven, Jakarta Servlet 6, JSP (scriptlets), Apache Tomcat 10.1 y MySQL 8.

## Instalar
1. Ejecutar `database.sql` en MySQL Workbench (solo una vez los INSERT).
2. Abrir la carpeta **Lab8_Apuntes** como proyecto Maven en IntelliJ.
3. Revisar usuario y contraseña en `PlanDao.java`. Por defecto el usuario es `root` y la contraseña se toma de la variable de entorno `TELENET_DB_PASSWORD` (si está vacía, se intenta sin contraseña).
4. Recargar Maven y configurar Apache Tomcat **10.1.x** y el artefacto **WAR exploded**.
5. Desplegar, abrir `http://localhost:8080/TeleNetCRUD/` (ajustar contexto y puerto si difieren).
6. Probar crear, listar, editar y eliminar un plan.

## Organización MVC
- `beans/Plan.java`: representa las columnas de `planes`.
- `daos/PlanDao.java`: acceso JDBC con PreparedStatement.
- `servlets/PlanServlet.java`: acciones GET y POST.
- `webapp/*.jsp`: vistas HTML/JSP.

## Flujo del CRUD
- GET `/PlanServlet` o `?action=lista`: lista.
- GET `?action=formCrear`: formulario de creación.
- POST `?action=crear`: insertar y redirigir.
- GET `?action=editar&id=1`: cargar formulario de edición.
- POST `?action=actualizar`: actualizar y redirigir.
- POST `?action=eliminar`: eliminar y redirigir.

Se usa POST para eliminar porque GET no debe modificar recursos. Se conserva el estilo pedagógico de los PPT, con RequestDispatcher, setAttribute, getParameter, Beans, DAO y scriptlets JSP. Esta es una demostración académica, no una aplicación lista para producción; faltan autenticación, protección CSRF y escape HTML formal.
