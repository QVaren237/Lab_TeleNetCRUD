package org.example.telenetcrud.daos;

import org.example.telenetcrud.beans.Plan;
import java.sql.*;
import java.util.ArrayList;

public class PlanDao {
    private final String url = "jdbc:mysql://localhost:3306/lab_telenet";
    private final String usuario = "root";
    private final String password = System.getenv().getOrDefault("TELENET_DB_PASSWORD", "");

    public ArrayList<Plan> obtenerListaPlanes() throws SQLException {
        ArrayList<Plan> lista = new ArrayList<>();
        String sql = "SELECT id_plan, nombre, velocidad_mbps, precio, estado FROM planes ORDER BY id_plan";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) lista.add(leerPlan(rs));
        }
        return lista;
    }

    public Plan obtenerPlan(int id) throws SQLException {
        String sql = "SELECT id_plan, nombre, velocidad_mbps, precio, estado FROM planes WHERE id_plan = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? leerPlan(rs) : null;
            }
        }
    }

    private Plan leerPlan(ResultSet rs) throws SQLException {
        Plan plan = new Plan();
        plan.setIdPlan(rs.getInt("id_plan"));
        plan.setNombre(rs.getString("nombre"));
        plan.setVelocidadMbps(rs.getInt("velocidad_mbps"));
        plan.setPrecio(rs.getBigDecimal("precio"));
        plan.setEstado(rs.getString("estado"));
        return plan;
    }

    public void crearPlan(Plan plan) throws SQLException {
        String sql = "INSERT INTO planes (nombre, velocidad_mbps, precio, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, plan.getNombre());
            pstmt.setInt(2, plan.getVelocidadMbps());
            pstmt.setBigDecimal(3, plan.getPrecio());
            pstmt.setString(4, plan.getEstado());
            pstmt.executeUpdate();
        }
    }

    public void actualizarPlan(Plan plan) throws SQLException {
        String sql = "UPDATE planes SET nombre=?, velocidad_mbps=?, precio=?, estado=? WHERE id_plan=?";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, plan.getNombre());
            pstmt.setInt(2, plan.getVelocidadMbps());
            pstmt.setBigDecimal(3, plan.getPrecio());
            pstmt.setString(4, plan.getEstado());
            pstmt.setInt(5, plan.getIdPlan());
            pstmt.executeUpdate();
        }
    }

    public void eliminarPlan(int id) throws SQLException {
        String sql = "DELETE FROM planes WHERE id_plan=?";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
