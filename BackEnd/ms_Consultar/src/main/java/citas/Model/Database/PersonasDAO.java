package citas.Model.Database;

import java.sql.Connection;
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

    public ArrayList<String> cedulaDePostulantes() throws SQLException {
        ArrayList<String> cedulas = new ArrayList<String>();
        String consulta = "SELECT * FROM postulantes";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        st = con.createStatement();
        // Ejecuta la consulta
        rs = st.executeQuery(consulta);
        // Verifica que la base no ese vacia
        while (rs.next()) {
            // toma los parametros de cada papa para añadirlos en un arreglo de datos
            cedulas.add(rs.getString("cedula"));
        }
        // Cierra la conexion para proteger la base de datos
        st.close();
        DatabaseConnection.desconectar();
        return cedulas;
    }

    public ArrayList<String> cedulaDeBuscadores() throws SQLException {
        ArrayList<String> cedulas = new ArrayList<String>();
        String consulta = "SELECT * FROM buscadores";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        st = con.createStatement();
        // Ejecuta la consulta
        rs = st.executeQuery(consulta);
        // Verifica que la base no ese vacia
        while (rs.next()) {
            // toma los parametros de cada papa para añadirlos en un arreglo de datos
            cedulas.add(rs.getString("cedula"));
        }
        // Cierra la conexion para proteger la base de datos
        st.close();
        DatabaseConnection.desconectar();
        return cedulas;
    }

    // Realiza la consulta dado el nombre de una papa
    public Buscadores consultarBuscadore(String cedula) {
        Buscadores p = null;
        String consulta = "SELECT * FROM buscadores WHERE cedula ='" + cedula + "'";
        try {
            // inicializa la conexion para poder ejecutar una peticion a la base de datos
            con = DatabaseConnection.getConexion();
            st = con.createStatement();
            // Ejecuta la consulta
            rs = st.executeQuery(consulta);
            // Verifica que almenos halla alguna papa en la base de datos
            if (rs.next()) {
                // Asigna los parametros para devolver la papa que esta en nuestra base de datos
                p = new Buscadores();
                p.setName(rs.getString("nombre"));
                p.setLastname(rs.getString("apellido"));
                p.setAge(rs.getInt("edad"));
                p.setHeight(rs.getFloat("estatura"));
                p.setJob(rs.getString("profesion"));
                p.setPhysique(rs.getString("contextura"));
                p.setC_status(rs.getString("estadocivil"));
                p.setGender(rs.getString("identidadgenero"));
                p.setEmail(rs.getString("correo"));
                p.setPhone(rs.getString("telefono"));
                p.setG_contextura(rs.getString("g_contextura"));
                p.setG_Interes(rs.getString("g_interes"));
                p.setG_estatura(rs.getString("g_estatura"));
                p.setG_Identidad(rs.getString("g_identidad"));
                p.setG_Edad(rs.getString("g_edad"));
                p.setCedula(rs.getString("cedula"));
                p.setPago(rs.getBoolean("pago"));

            } else {
                // JOptionPane con el mensaje "No se encontro ninguna papa con este nombre"
            }
            // Cierra la conexion con la base de datos para protegerla
            st.close();
            DatabaseConnection.desconectar();
        } catch (SQLException ex) {
            // JOptionPane con el mensaje "No se pudo realizar la consulta"
        }
        return p;
    }

    public Postulantes consultarPostulante(String cedula) {
        Postulantes p = null;
        String consulta = "SELECT * FROM postulantes WHERE cedula ='" + cedula + "'";
        try {
            // inicializa la conexion para poder ejecutar una peticion a la base de datos
            con = DatabaseConnection.getConexion();
            st = con.createStatement();
            // Ejecuta la consulta
            rs = st.executeQuery(consulta);
            // Verifica que almenos halla alguna papa en la base de datos
            if (rs.next()) {
                // Asigna los parametros para devolver la papa que esta en nuestra base de datos
                p = new Postulantes();
                p.setCedula(rs.getString("cedula"));
                p.setName(rs.getString("nombre"));
                p.setLastname(rs.getString("apellido"));
                p.setAge(rs.getInt("edad"));
                p.setHeight(rs.getFloat("estatura"));
                p.setJob(rs.getString("profesion"));
                p.setPhysique(rs.getString("contextura"));
                p.setC_status(rs.getString("estadocivil"));
                p.setGender(rs.getString("identidadgenero"));
                p.setEmail(rs.getString("correo"));
                p.setPhone(rs.getString("telefono"));
                p.setInteres(rs.getString("interesprincipal"));
                p.setDisponibilidad(rs.getString("disponibilidad"));
                p.setPago(rs.getBoolean("pago"));

            } else {
                // JOptionPane con el mensaje "No se encontro ninguna papa con este nombre"
            }
            // Cierra la conexion con la base de datos para protegerla
            st.close();
            DatabaseConnection.desconectar();
        } catch (SQLException ex) {
            // JOptionPane con el mensaje "No se pudo realizar la consulta"
        }
        return p;
    }

}
