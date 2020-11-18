
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
    
    // Método que muestra la información relacionada (doctor, paciente, cita).
    public void mostrarRelacionesInformacion() {
        ResultSet resultado = null;
        
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            
            if(conexion != null) {
                System.out.println("Conectado.");
            }
            
            PreparedStatement query = conexion.prepareStatement("SELECT Doctores.*, Pacientes.*, Citas.* FROM RelacionInformacion INNER JOIN Doctores "
                    + "ON RelacionInformacion.idDoctor = Doctores.id "
                    + "INNER JOIN Pacientes ON RelacionInformacion.idPaciente = Pacientes.id "
                    + "INNER JOIN Citas ON RelacionInformacion.idCita = Citas.id");
            
            resultado = query.executeQuery();
            
            while(resultado.next()) {
                // Datos del doctor.
                System.out.println("***** DATOS DEL DOCTOR *****");
                System.out.print("ID del doctor: ");
                System.out.println(resultado.getString(1));
                System.out.print("Nombre del doctor: ");
                System.out.println(resultado.getString(2));
                System.out.print("Especialidad del doctor: ");
                System.out.println(resultado.getString(3));
                System.out.println();
                
                // Datos del paciente.
                System.out.println("***** DATOS DEL PACIENTE *****");
                System.out.print("ID del paciente: ");
                System.out.println(resultado.getString(4));
                System.out.print("Nombre del paciente: ");
                System.out.println(resultado.getString(5));
                System.out.println();
                
                // Datos de la cita.
                System.out.println("***** DATOS DE LA CITA *****");
                System.out.print("ID de la cita: ");
                System.out.println(resultado.getString(6));
                System.out.print("Fecha de la cita: ");
                System.out.println(resultado.getString(7));
                System.out.print("Hora de la cita: ");
                System.out.println(resultado.getString(8));
                System.out.print("Motivo de la cita: ");
                System.out.println(resultado.getString(9));
               
                System.out.println("==========");
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
