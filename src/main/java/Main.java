
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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        
        System.out.println("Menú");
        System.out.println("1. Dar alta de doctores.");
        System.out.println("2. Dar de alta pacientes.");
        System.out.println("3. Crear una cita con fecha, hora y motivo.");
        System.out.println("4. Relacionar una cita con un doctor y un paciente.");
        System.out.println("5. Mostrar lista de doctores.");
        System.out.println("6. Mostrar lista de pacientes.");
        System.out.println("7. Mostrar lista de citas.");
        System.out.println("8. Mostrar la información relacionada (doctor, paciente, cita).");
        System.out.println("0. Salir.");
        System.out.println("Elige una opción: ");
        opcion = scanner.next();
        
        switch(opcion) {
            case "1":
                Doctor doctor = new Doctor();
                doctor.pedirDatos();
                doctor.darAltaDoctor();
                break;
                
            case "2":
                Paciente paciente = new Paciente();
                paciente.pedirDatos();
                paciente.darAltaPaciente();
                break;
                
            case "3":
                Cita cita = new Cita();
                cita.pedirDatos();
                cita.crearCita();
                break;
                
            case "4":
                RelacionInformacion relacion = new RelacionInformacion();
                relacion.pedirDatos();
                relacion.relacionarInformacion();
                break;
                
            case "5":
                doctor = new Doctor();
                doctor.mostrarDoctores();
                break;
                
            case "6":
                paciente = new Paciente();
                paciente.mostrarPacientes();
                break;
                
            case "7":
                cita = new Cita();
                cita.mostrarCitas();
                break;
                
            case "8":
                relacion = new RelacionInformacion();
                relacion.mostrarRelacionesInformacion();
                break;
                
            case "0":
                System.out.println("Aplicación finalizada.");
                System.exit(0);
                break;
                
        }
    }

}
