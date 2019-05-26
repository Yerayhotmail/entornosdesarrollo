
package basesDeDatos;

import java.sql.*;

/**
 *
 * @author Yeray
 */
public class Coche {
    
   
    public void obtenerModeloCoche(String matricula){
      //creamos un objeto de la clase conexion  
        Conexion conexion = new Conexion();
        try{
      // creamos una variable con la consulta SQL 
            String consulta = "SELECT modelo FROM coches WHERE matricula = ?";
      /*preparamos la consulta, la conexion creada al inicio, llamamos a genConnection para obtener la conexion
           y al preparedStatemen para compilar la consulta 
       */
            PreparedStatement pstm = conexion.getConnection().prepareStatement(consulta);
        // asignamos al pstm el valor que recibiremos desde el main
            pstm.setString(1, matricula);
        // creamos un resultSet que guarda la ejecucion de la consulta
            ResultSet resultado = pstm.executeQuery();
        // recorremos la consulta y mientras haya una linea seguira ejecutandose
            while(resultado.next()){
                System.out.println("Modelo: " +resultado.getString("modelo")+ ", corresponde con la matricula introducida " + matricula);
            }
       //cerramos la consulta y la conexion a la base de datos         
           pstm.close();
           conexion.cerrar();
      //excepciones
        }catch (SQLException sqle){
            sqle.printStackTrace();
            
        } 
    }
    
    
    
}
