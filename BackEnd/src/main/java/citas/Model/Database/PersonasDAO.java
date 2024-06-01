package citas.Model.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import citas.Model.Buscadores;

public class PersonasDAO {
    private Connection con; // Objeto de conexión a la base de datos
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    // Constructor
    public PersonasDAO() {
        // Inicialización de la los objetos como nulos
        con = null;
        st = null;
        rs = null;
    }
    public void agregarBuscadores(Buscadores obj) throws SQLException {
        String insert = "INSERT INTO buscadores VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // Establece la conexión con la base de datos
        con = (Connection) DatabaseConnection.getConexion();
        // Prepara la sentencia SQL
        ps = con.prepareStatement(insert);
        // Establece los parámetros de la sentencia SQL
        ps.setString(1, obj.getName());
        ps.setString(2, obj.getLastname());
        ps.setInt(3, obj.getAge());
        ps.setFloat(4, obj.getHeight());
        ps.setString(5, obj.getJob());
        ps.setString(6, obj.getPhysique());
        ps.setString(7, obj.getC_status());
        ps.setString(8, obj.getGender());
        ps.setString(9, obj.getEmail());
        ps.setString(10, obj.getPhone());
        ps.setString(11, obj.getG_contextura());
        ps.setString(12, obj.getG_Interes());
        ps.setString(13, obj.getG_estatura());
        ps.setString(14, obj.getG_Identidad());
        ps.setString(15, obj.getG_Edad());
        ps.setString(16, obj.getCedula());
        // Ejecuta la sentencia SQL para insertar el usuario en la base de datos
        ps.executeUpdate();
        // Cierra la sentencia preparada y desconecta de la base de datos
        ps.close();
        DatabaseConnection.desconectar();
    }
}
