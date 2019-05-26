package basesDeDatos;

import java.sql.*;


public class Conexion {
    private static final String DRIVERMYSQL = "com.mysql.jdbc.Driver";
    private static final String BD = "programacionud8";
    private static final String URL = "jdbc:mysql://localhost:3306/"+BD;
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static Connection conexion;
    
    //Constructor que crea la conexion a la base de datos
    public Conexion(){
         try{
        //Cargamos el driver JDBC para mysql
        Class.forName(DRIVERMYSQL);
        //Creamos la conexion
        conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        System.out.println("Conectado correctamente con la Base de Datos: " + BD + "\n");
        // Excepciones
        }catch(ClassNotFoundException cnfe){
            System.out.println("No se ha encontrado el driver " +cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("No se ha podido realizar la conexión con la base de datos " +sqle.getMessage());
        }
    }
   
   // Metodo que recupera la conexion
   public Connection getConnection(){
       return conexion;
   }
   // Metodo que permite cerrar la conexion una vez realizadas las consultas
   public void cerrar(){
        try {
            conexion.close();
            System.out.println("Se ha cerrado la conexion con " + BD + "\n");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido cerrar la conexion"  + sqle.getMessage());
        }
   }
   }
    


