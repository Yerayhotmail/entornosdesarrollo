package basesDeDatos;

import java.sql.*;

/**
 *
 * @author Yeray
 */
public class Empleado {
    
    public Empleado(){}
       
    public void empleadosPorCiudad(String ciudad){
        //creamos un objeto de la clase conexion
            Conexion conexion = new Conexion();
         try{
        // creamos una variable con la consulta SQL
            String consulta = "SELECT id_empleados, nif, nombre, apellido1, apellido2, ciudad, telefono, email, sueldo FROM empleados WHERE ciudad = ?";
        /*preparamos la consulta, la conexion creada al inicio, llamamos a genConnection para obtener la conexion
           y al preparedStatemen para compilar la consulta 
        */
            PreparedStatement pstm = conexion.getConnection().prepareStatement(consulta);
        // asignamos al pstm el valor que recibiremos desde el main
            pstm.setString(1, ciudad);
        // creamos un resultSet que guarda la ejecucion de la consulta
            ResultSet resultado = pstm.executeQuery();
        // recorremos la consulta y mientras haya una linea seguira ejecutandose
            while(resultado.next()){
                System.out.println("ID: " + resultado.getInt("id_empleados")+ " " +
                                   "Nif: "+ resultado.getString("nif") + " " +
                                   "Nombre: " + resultado.getString("nombre")+ " " +
                                   "Apellidos: " + resultado.getString("apellido1")  + resultado.getString("apellido2") + " " +
                                   "Ciudad: " + resultado.getString("ciudad")+ " " +
                                   "Telefono: " + resultado.getString("telefono")+ " " +
                                   "Email: " + resultado.getString("email")+ " " +
                                   "Sueldo: " + resultado.getString("sueldo"));
            }
        //cerramos la consulta y la conexion a la base de datos
            pstm.close();
            conexion.cerrar();
        // excepciones
        }catch(SQLException e){
            System.out.println("no se ha podido ejecutar la consulta " + e.getMessage());
            
        }catch(NullPointerException npe){
            System.out.println(npe);
        }
    }
    public void basicInfoEmpleados(){
        //creamos un objeto de la clase conexion
         Conexion conexion = new Conexion();
        try{ 
        // creamos una variable con la consulta SQL    
            String consulta = "SELECT nif, nombre, ciudad, sueldo FROM empleados";
        /*preparamos la consulta, la conexion creada al inicio, llamamos a genConnection para obtener la conexion
           y al preparedStatemen para compilar la consulta 
        */
            Statement stm = conexion.getConnection().createStatement();
       // creamos un resultSet que guarda la ejecucion de la consulta
            ResultSet resultado = stm.executeQuery(consulta);
        // recorremos la consulta y mientras haya una linea seguira ejecutandose
            while (resultado.next()){
                System.out.println("Nif: " + resultado.getString("nif") + " " +
                                   "Nombre: " + resultado.getString("nombre") + " " +
                                   "Ciudad: " + resultado.getString("ciudad") + " " +
                                   "Sueldo: " + resultado.getString("sueldo") );
            }
       //cerramos la consulta y la conexion a la base de datos
         stm.close();
         conexion.cerrar();
      // excepciones
        }catch(SQLException e){
            System.out.println("No se ha podido realizar la conexión" +e);
        }catch(NullPointerException npe){
            System.out.println("error " +npe.toString());
        }
    
    }
    public void actualizarSueldo(int porcentaje){
        //creamos un objeto de la clase conexion
        Conexion conexion = new Conexion();
        boolean resultado = true;
        try{
        // creamos una variable con la consulta SQL  
           String consulta = "UPDATE programacionud8.empleados SET sueldo = sueldo + ((sueldo * ?)/100)";
       /*preparamos la consulta, la conexion creada al inicio, llamamos a genConnection para obtener la conexion
           y al preparedStatemen para compilar la consulta 
       */
           PreparedStatement pstm = conexion.getConnection().prepareStatement(consulta);
       // asignamos al pstm el valor que recibiremos desde el main
           pstm.setInt(1, porcentaje);
       // creamos una variable que guaradara el resultado de ejecutar la actualizacion
           pstm.executeUpdate();
           if(resultado == true){
               System.out.println("Actualizacion realizada con éxitos");
           }else{
               System.out.println("No se ha podido actualizar ");
           }
        //cerramos la consulta y la conexion a la base de datos
           pstm.close();
           conexion.cerrar();
        //excepciones
        }catch(SQLException e){
            System.out.println("No se ha podido realizar la conexión" +e);
        }catch(NullPointerException npe){
            System.out.println("error " +npe.toString());
        }
    }
    public void previsualizarIncremento(int porcentaje){
      //creamos un objeto de la clase conexion  
        Conexion conexion = new Conexion();
        try{
      // creamos una variable con la consulta SQL  
          String consulta = " SELECT nombre, sueldo, (sueldo +((sueldo * ?)/100)) AS subida_sueldo   FROM empleados";
      /*preparamos la consulta, la conexion creada al inicio, llamamos a genConnection para obtener la conexion
           y al preparedStatemen para compilar la consulta 
       */
          PreparedStatement pstm = conexion.getConnection().prepareStatement(consulta);
      // asignamos al pstm el valor que recibiremos desde el main
          pstm.setInt(1, porcentaje);
       // creamos un resultSet que guarda la ejecucion de la consulta
          ResultSet resultado = pstm.executeQuery();
       // recorremos la consulta y mientras haya una linea seguira ejecutandose
          while (resultado.next()){
              System.out.println("Nombre " + resultado.getString("nombre") + " " 
                                 + "Sueldo: " + resultado.getString("sueldo") + " "
                                 + "Sueldo modificado " + resultado.getString("subida_sueldo"));
          }
      //cerramos la consulta y la conexion a la base de datos          
        pstm.close();
        conexion.cerrar();
      //excepciones
        }catch(SQLException e){
            System.out.println("No se ha podido realizar la conexión" +e);
        }catch(NullPointerException npe){
            System.out.println("error " +npe.toString());
        }
    }
}

   