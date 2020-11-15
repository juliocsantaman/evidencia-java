
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class Conector {
    // Atributos.
    Connection conexion;
    
    // Métodos.
    
    // Método para realizar la conexión a la base de datos.
    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            if(conexion != null) {
                System.out.println("Conectado.");
            }
        } catch (Exception e) {
            System.err.println("No se ha podido conectar con la base de datos. " + e.getMessage());
        }
    }
    
    public void cerrar() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
