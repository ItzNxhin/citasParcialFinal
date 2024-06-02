package citas.Model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import citas.Model.Buscadores;
import citas.Model.Postulantes;

public class PersonasDAO {
    private Connection con; // Objeto de conexión a la base de datos
    private Statement st;
    private ResultSet rs;

    // Constructor
    public PersonasDAO() {
        // Inicialización de la los objetos como nulos
        con = null;
        st = null;
        rs = null;
    }

    public void eliminarPostulante(String cedula) throws SQLException {
        String consulta = "DELETE FROM postulantes WHERE cedula = ?";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        Connection con = DatabaseConnection.getConexion();
        PreparedStatement ps = con.prepareStatement(consulta);
        // Completa los parmetros de la consulta
        ps.setString(1, cedula);
        // Ejecuta la consulta
        ps.executeUpdate();

        // Cierra la conexion para proteger la base de datos
        ps.close();
        con.close();
        DatabaseConnection.desconectar();
    }

    public void eliminarBuscador(String cedula) throws SQLException {
        String consulta = "DELETE FROM buscadores WHERE cedula = ?";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        Connection con = DatabaseConnection.getConexion();
        PreparedStatement ps = con.prepareStatement(consulta);
        // Completa los parmetros de la consulta
        ps.setString(1, cedula);
        // Ejecuta la consulta
        ps.executeUpdate();

        // Cierra la conexion para proteger la base de datos
        ps.close();
        con.close();
        DatabaseConnection.desconectar();
    }

    

}
