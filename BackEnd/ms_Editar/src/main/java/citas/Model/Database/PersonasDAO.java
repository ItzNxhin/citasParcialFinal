package citas.Model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import citas.Model.Buscadores;
import citas.Model.Postulantes;

public class PersonasDAO {
    private Connection con; // Objeto de conexión a la base de datos

    // Constructor
    public PersonasDAO() {
        // Inicialización de la los objetos como nulos
        con = null;

    }

    public void modificarBuscador(Buscadores obj) throws SQLException {
        String consulta = "UPDATE buscadores SET nombre=?, apellido=?, edad=?, estatura=?, profesion=?, contextura=? , estadocivil=?, identidadgenero=?, correo=?, telefono=?, g_contextura=?, g_interes=?, g_estatura=?, g_identidad=?, g_edad=?, pago=? WHERE cedula=?";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        PreparedStatement ps = con.prepareStatement(consulta);
        // Toma los datos para encontrar la papa a modificar y para modificar cada campo
        // de la papa
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
        ps.setBoolean(16, obj.isPago());
        ps.setString(17, obj.getCedula());
        // Ejecuta la consulta
        ps.executeUpdate();
        // Cierra la conexion para proteger la base de datos
        ps.close();
        con.close();

    }

    public void modificarPostulante(Postulantes obj) throws SQLException {
        String consulta = "UPDATE postulantes SET nombre=?, apellido=?, edad=?, estatura=?, profesion=?, contextura=? , estadocivil=?, identidadgenero=?, correo=?, telefono=?, interesprincipal=?, disponibilidad=?, pago=? WHERE cedula=?";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        PreparedStatement ps = con.prepareStatement(consulta);
        // Toma los datos para encontrar la papa a modificar y para modificar cada campo
        // de la papa
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
        ps.setString(11, obj.getInteres());
        ps.setString(12, obj.getDisponibilidad());
        ps.setBoolean(13, obj.isPago());
        ps.setString(14, obj.getCedula());
        // Ejecuta la consulta
        ps.executeUpdate();
        // Cierra la conexion para proteger la base de datos
        ps.close();
        con.close();

    }

}
