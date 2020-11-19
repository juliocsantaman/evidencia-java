
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class Usuario {

    // Atributos.
    String user;
    String password;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);

    // Métodos.
    // Método que va a extraer la información del Administrador.
    public void buscarDatosAdmin() {
        ResultSet resultado = null;

        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");

            if (conexion != null) {
                System.out.println("Conectado.");
            }

            PreparedStatement query = conexion.prepareStatement("SELECT user, password FROM Usuarios WHERE id = 1");

            resultado = query.executeQuery();
            this.user = resultado.getString("user");
            this.password = resultado.getString("password");
                
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Métodos getters.
    public String getUser() {
        return this.user;
    }
    
    public String getPassword() {
        return this.password;
    }

}
