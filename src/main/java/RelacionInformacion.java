
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
    private Connection conexion;

    // Métodos.
    // Método que relaciona la información, doctor, paciente y cita.
    public void relacionarInformacion(int idDoctor, int idPaciente, int idCita) {
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
            enunciado.execute("INSERT INTO RelacionInformacion (idDoctor, idPaciente, idCita) VALUES('" + idDoctor + "','" + idPaciente + "','" + idCita + "');'");

            System.out.println("Se ha relacionado la información correctamente.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
