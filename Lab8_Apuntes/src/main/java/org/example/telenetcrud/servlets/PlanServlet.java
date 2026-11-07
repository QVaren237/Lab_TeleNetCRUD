package org.example.telenetcrud.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.telenetcrud.beans.Plan;
import org.example.telenetcrud.daos.PlanDao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet(name="PlanServlet", value="/PlanServlet")
public class PlanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "lista";
        PlanDao dao = new PlanDao();
        try {
            switch (action) {
                case "lista":
                    request.setAttribute("lista", dao.obtenerListaPlanes());
                    request.getRequestDispatcher("/listaPlanes.jsp").forward(request, response);
                    break;
                case "formCrear":
                    request.getRequestDispatcher("/nuevoPlan.jsp").forward(request, response);
                    break;
                case "editar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Plan plan = dao.obtenerPlan(id);
                    if (plan == null) {
                        response.sendRedirect(request.getContextPath() + "/PlanServlet");
                    } else {
                        request.setAttribute("plan", plan);
                        request.getRequestDispatcher("/editarPlan.jsp").forward(request, response);
                    }
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/PlanServlet");
            }
        } catch (SQLException ex) {
            throw new ServletException("Error consultando MySQL", ex);
        } catch (NumberFormatException ex) {
            response.sendError(400, "ID de plan invalido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        PlanDao dao = new PlanDao();
        try {
            if ("crear".equals(action) || "actualizar".equals(action)) {
                String nombre = request.getParameter("nombre");
                int velocidad = Integer.parseInt(request.getParameter("velocidad"));
                BigDecimal precio = new BigDecimal(request.getParameter("precio"));
                String estado = request.getParameter("estado");
                if (nombre == null || nombre.trim().isEmpty() || velocidad <= 0 ||
                        precio.signum() < 0 || !("Activo".equals(estado) || "Inactivo".equals(estado))) {
                    response.sendError(400, "Datos invalidos"); return;
                }
                Plan plan = new Plan();
                plan.setNombre(nombre.trim());
                plan.setVelocidadMbps(velocidad);
                plan.setPrecio(precio);
                plan.setEstado(estado);
                if ("crear".equals(action)) {
                    dao.crearPlan(plan);
                } else {
                    plan.setIdPlan(Integer.parseInt(request.getParameter("idPlan")));
                    dao.actualizarPlan(plan);
                }
            } else if ("eliminar".equals(action)) {
                dao.eliminarPlan(Integer.parseInt(request.getParameter("id")));
            } else {
                response.sendError(400, "Accion desconocida"); return;
            }
            response.sendRedirect(request.getContextPath() + "/PlanServlet");
        } catch (SQLException ex) {
            throw new ServletException("Error modificando MySQL", ex);
        } catch (NumberFormatException | NullPointerException ex) {
            response.sendError(400, "Parametros invalidos");
        }
    }
}
