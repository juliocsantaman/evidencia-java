
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Paciente {

    // Atributos.
    private String nombre;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);
    
    // Métodos.
    
    // Método para pedir los datos.
    public void pedirDatos() {
        System.out.println("Ingresa el nombre del paciente: ");
        this.nombre = scanner.next();
    }
    
    // Método que da de alta a un paciente con su nombre.
    public void darAltaPaciente() {
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");

            if (conexion != null) {
                System.out.println("Conectado.");
            }

            // Crear enunciado.
            Statement enunciado;
            enunciado = conexion.createStatement();

            // Insertar datos.
            enunciado.execute("INSERT INTO Pacientes (nombre) VALUES('" + this.nombre + "');'");
            
            System.out.println("Se ha registrado un paciente correctamente.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
