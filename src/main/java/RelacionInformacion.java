
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
public class RelacionInformacion {

    // Atributos.
    private int idDoctor;
    private int idPaciente;
    private int idCita;
    private Connection conexion;
    private Scanner scanner = new Scanner(System.in);

    // Métodos.
    
    // Método para pedir los datos.
    public void pedirDatos() {
        System.out.println("Ingresa el ID del doctor: ");
        this.idDoctor = scanner.nextInt();
        System.out.println("Ingresa el ID del paciente: ");
        this.idPaciente = scanner.nextInt();
        System.out.println("Ingresa el ID de la cita: ");
        this.idCita = scanner.nextInt();
    }
    
    // Método que relaciona la información, doctor, paciente y cita.
    public void relacionarInformacion() {
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
            enunciado.execute("INSERT INTO RelacionInformacion (idDoctor, idPaciente, idCita) VALUES('" + this.idDoctor + "','" + this.idPaciente + "','" + this.idCita + "');'");

            System.out.println("Se ha relacionado la información correctamente.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método que muestra la lista de doctores.
    public void mostrarRelacionesInformacion() {
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
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
