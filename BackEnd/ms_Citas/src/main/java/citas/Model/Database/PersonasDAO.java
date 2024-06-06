package citas.Model.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Timestamp;

import citas.Model.Buscadores;
import citas.Model.Citas;
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
        ps = null;
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
                p.setG_estatura(rs.getString("g_identidad"));
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

    public void crearCita(Citas obj) throws SQLException {
        String insert = "INSERT INTO citas VALUES (?,?,?,?,?,?,?)";
        // Establece la conexión con la base de datos
        con = (Connection) DatabaseConnection.getConexion();
        // Prepara la sentencia SQL
        ps = con.prepareStatement(insert);
        // Establece los parámetros de la sentencia SQL
        ps.setInt(1, obj.getId());
        ps.setString(2, obj.getC_buscador());
        ps.setString(3, obj.getC_postulante());
        ps.setNull(4, Types.VARCHAR);
        ps.setNull(5, Types.VARCHAR);
        ps.setNull(6, Types.VARCHAR);
        ps.setTimestamp(7, new Timestamp(obj.getFecha().getTime()));

        // Ejecuta la sentencia SQL para insertar el usuario en la base de datos
        ps.executeUpdate();
        // Cierra la sentencia preparada y desconecta de la base de datos
        ps.close();
        DatabaseConnection.desconectar();
    }

    public void calificarCita(Citas obj) throws SQLException {
        String consulta = "UPDATE citas SET cal_buscador=?,cal_Postulante=?, cal_Cita=? WHERE idcitas=?";

        // inicializa la conexion para poder ejecutar una peticion a la base de datos
        con = DatabaseConnection.getConexion();
        PreparedStatement ps = con.prepareStatement(consulta);
        // Toma los datos para encontrar la papa a modificar y para modificar cada campo
        // de la papa
        ps.setString(1, obj.getCal_Buscador());
        ps.setString(2, obj.getCal_Postulante());
        ps.setString(3, obj.getCal_Cita());
        ps.setInt(4, obj.getId());
        // Ejecuta la consulta
        ps.executeUpdate();
        // Cierra la conexion para proteger la base de datos
        ps.close();
        con.close();
    }

    public Date ultimaFecha(){
        String query = "SELECT * FROM citas ORDER BY hora DESC LIMIT 1";
        Date fecha = null;
        try {
            // Establece la conexión con la base de datos
            con = DatabaseConnection.getConexion();

            // Prepara la sentencia SQL
            ps = con.prepareStatement(query);

            // Ejecuta la consulta y obtiene el resultado
            rs = ps.executeQuery();

            // Procesa el resultado
            if (rs.next()) {    
                java.sql.Timestamp fecha1 = rs.getTimestamp("hora");
                fecha = new Date(fecha1.getTime());

                
            }

            // Cierra los recursos
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fecha;
    }

    public int ultimoID(){
        String query = "SELECT * FROM citas ORDER BY idcitas DESC LIMIT 1";
        int id = 0;
        try {
            // Establece la conexión con la base de datos
            con = DatabaseConnection.getConexion();

            // Prepara la sentencia SQL
            ps = con.prepareStatement(query);

            // Ejecuta la consulta y obtiene el resultado
            rs = ps.executeQuery();

            // Procesa el resultado
            if (rs.next()) {    
                id = rs.getInt("idcitas");
   
            }

            // Cierra los recursos
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }


}
