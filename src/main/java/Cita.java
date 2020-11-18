
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
public class Cita {

    // Atributos.
    private String fecha;
    private String hora;
    private String motivoCita;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);

    // Métodos.
    
    // Método para pedir los datos.
    public void pedirDatos() {
        System.out.println("Ingresa la fecha de la cita formato(dd/mm/yyyy): ");
        this.fecha = scanner.nextLine();
        System.out.println("Ingresa la hora de la cita: ");
        this.hora = scanner.nextLine();
        System.out.println("Ingresa el motivo de la cita: ");
        this.motivoCita = scanner.nextLine();
    }
    
    // Método que da de alta una cita con fecha, hora y motivo.
    public void crearCita() {
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
            enunciado.execute("INSERT INTO Citas (fecha, hora, motivo_cita) VALUES('" + this.fecha + "','" + this.hora + "','" + this.motivoCita + "');'");

            System.out.println("Se ha registrado una cita correctamente.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método que muestra la lista de citas.
    public void mostrarCitas() {
        ResultSet resultado = null;
        
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            
            if(conexion != null) {
                System.out.println("Conectado.");
            }
            
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM Citas");
            
            resultado = query.executeQuery();
            
            while(resultado.next()) {
                System.out.print("ID: ");
                System.out.println(resultado.getInt("id"));
                
                System.out.print("Fecha: ");
                System.out.println(resultado.getString("fecha"));
                
                System.out.print("Hora: ");
                System.out.println(resultado.getString("hora"));
                
                System.out.print("Motivo de la cita: ");
                System.out.println(resultado.getString("motivo_cita"));
                
                System.out.println("==========");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    

}
