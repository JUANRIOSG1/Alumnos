package com.ilerna.alumnos.service;
import com.ilerna.alumnos.database.Conexion;
import com.ilerna.alumnos.entity.Alumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorAlumnos {
    Conexion c = new Conexion();
    public void alta(Alumnos p) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        String cadena = "INSERT INTO alumnos(nombre, apellido, telefono, correo, direccion) VALUES ('"
                + p.getNombre() + "','"
                + p.getApellido() + "','"
                + p.getTelefono() + "','"
                + p.getCorreo() + "','"
                + p.getDireccion() + "');";
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public List<Alumnos> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM alumnos");
        List<Alumnos> lista = new ArrayList<>();

        while (rs.next()) {
            Alumnos p = new Alumnos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion")
            );
            lista.add(p);
        }
        rs.close();
        consulta.close();
        return lista;
    }
    public Object buscar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM alumnos WHERE id = " + id);
        Alumnos p = null;
        if (rs.next()) {
            p = new Alumnos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion")
            );
        }
        rs.close();
        consulta.close();
        return p;
    }
    public void modificar(Alumnos p) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        String cadena = "UPDATE alumnos SET "
                + "nombre = '" + p.getNombre() + "', "
                + "apellido = '" + p.getApellido() + "', "
                + "telefono = '" + p.getTelefono() + "', "
                + "correo = '" + p.getCorreo() + "', "
                + "direccion = '" + p.getDireccion() + "' "
                + "WHERE id = " + p.getId();
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public void eliminar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        consulta.executeUpdate("DELETE FROM alumnos WHERE id = " + id);
        consulta.close();
    }


}
