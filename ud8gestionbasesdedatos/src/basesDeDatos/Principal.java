package basesDeDatos;



/**
 *
 * @author Yeray
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Empleado em1 = new Empleado();
    
        em1.basicInfoEmpleados();
        em1.empleadosPorCiudad("arguineguin");
        em1.actualizarSueldo(10);
        em1.basicInfoEmpleados();
        em1.previsualizarIncremento(5);
        em1.basicInfoEmpleados();
       
    Coche coche1 = new Coche();
    
        coche1.obtenerModeloCoche("4356GHY");
    }  

}