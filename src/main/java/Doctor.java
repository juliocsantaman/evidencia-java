
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Doctor {
    // Atributos.
    private String nombre;
    private String especialidad;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);
    // Métodos.
    
    // Método para pedir los datos.
    public void pedirDatos() {
        System.out.println("Ingresa el nombre del doctor: ");
        this.nombre = scanner.nextLine();
        System.out.println("Ingresa la especialidad del doctor: ");
        this.especialidad = scanner.nextLine();
    }
    
    // Método que da de alta a un doctor con su nombre y especialidad.
    public void darAltaDoctor() {
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            
            if(conexion != null) {
                System.out.println("Conectado.");
            }
            
            // Crear enunciado.
            Statement enunciado;
            enunciado = conexion.createStatement();
            
            // Insertar datos.
            enunciado.execute("INSERT INTO Doctores (nombre, especialidad) VALUES('"+this.nombre+"','"+this.especialidad+"');'");
            
            System.out.println("Se ha registrado un doctor correctamente.");
            
            enunciado.close();
            conexion.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método que muestra la lista de doctores.
    public void mostrarDoctores() {
        ResultSet resultado = null;
        
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            
            if(conexion != null) {
                System.out.println("Conectado.");
            }
            
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Doctores");
            
            resultado = query.executeQuery();
            
            while(resultado.next()) {
                System.out.print("ID: ");
                System.out.println(resultado.getInt("id"));
                
                System.out.print("Nombre: ");
                System.out.println(resultado.getString("nombre"));
                
                System.out.print("Especialidad: ");
                System.out.println(resultado.getString("especialidad"));
                
                System.out.println("==========");
            }
            
            query.close();
            conexion.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
