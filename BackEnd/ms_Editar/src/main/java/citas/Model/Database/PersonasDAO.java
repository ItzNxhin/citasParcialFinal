package citas.Model.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import citas.Model.Buscadores;
import citas.Model.Postulantes;

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

    public void agregarPostulantes(Postulantes obj) throws SQLException {
        String insert = "INSERT INTO postulantes VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // Establece la conexión con la base de datos
        con = (Connection) DatabaseConnection.getConexion();
        // Prepara la sentencia SQL
        ps = con.prepareStatement(insert);
        // Establece los parámetros de la sentencia SQL
        ps.setString(1, obj.getCedula());
        ps.setString(2, obj.getName());
        ps.setString(3, obj.getLastname());
        ps.setInt(4, obj.getAge());
        ps.setFloat(5, obj.getHeight());
        ps.setString(6, obj.getJob());
        ps.setString(7, obj.getPhysique());
        ps.setString(8, obj.getC_status());
        ps.setString(9, obj.getGender());
        ps.setString(10, obj.getEmail());
        ps.setString(11, obj.getPhone());
        ps.setString(12, obj.getInteres());
        ps.setString(13, obj.getDisponibilidad());

        // Ejecuta la sentencia SQL para insertar el usuario en la base de datos
        ps.executeUpdate();
        // Cierra la sentencia preparada y desconecta de la base de datos
        ps.close();
        DatabaseConnection.desconectar();
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

    public ArrayList<Postulantes> listaDePostulantes() throws SQLException {
        ArrayList<Postulantes> post = new ArrayList<Postulantes>();
        String consulta = "SELECT * FROM postulantes";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        st = con.createStatement();
        // Ejecuta la consulta
        rs = st.executeQuery(consulta);
        // Verifica que la base no ese vacia
        while (rs.next()) {
            // toma los parametros de cada papa para añadirlos en un arreglo de datos
            Postulantes p = new Postulantes();
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
            post.add(p);
        }
        // Cierra la conexion para proteger la base de datos
        st.close();
        DatabaseConnection.desconectar();
        return post;
    }

    public ArrayList<Buscadores> listaDeBuscadores() throws SQLException {
        ArrayList<Buscadores> post = new ArrayList<Buscadores>();
        String consulta = "SELECT * FROM buscadores";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        st = con.createStatement();
        // Ejecuta la consulta
        rs = st.executeQuery(consulta);
        // Verifica que la base no ese vacia
        while (rs.next()) {
            // toma los parametros de cada papa para añadirlos en un arreglo de datos
            Buscadores p = new Buscadores();
            
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
            p.setG_estatura(rs.getString("g_identidad"));
            p.setG_Identidad(rs.getString("g_identidad"));
            p.setG_Edad(rs.getString("g_edad"));
            p.setCedula(rs.getString("cedula"));
            post.add(p);
        }
        // Cierra la conexion para proteger la base de datos
        st.close();
        DatabaseConnection.desconectar();
        return post;
    }
}
