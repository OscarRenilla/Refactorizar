package refactor01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    // Menu
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean exit;
        do {
            exit = false;
            System.out.println("\n====== GESTIÓN DE ALUMNOS =====" +
                    "\n1. Insertar Alumno" +
                    "\n2. Listar alumnos" +
                    "\n3. Salir" +
                    "\nIngrese una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    insertarAlumno(sc, alumnos);
                    break;
                case 2:
                    listarAlumnos(alumnos);
                    break;
                case 3:
                    System.out.println("Saliendo .....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (!exit);
    }

    static class Alumno {
        String nombre, apellido, correo;
        int edad;

        Alumno(String nombre, String apellido, int edad, String correo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad + ", Correo: " + correo;
        }
    }

    public static void insertarAlumno(Scanner sc, ArrayList<Alumno> alumnos) {
        String nombre = leerNombre(sc);
        String apellido = leerApellido(sc);
        int edad = leerEntero(sc, "Edad: ", 18, 100);
        String correo = leerCorreo(sc);

        alumnos.add(new Alumno(nombre, apellido, edad, correo));
        System.out.println("Alumno guardado correctamente");
    }

    // Lecturas
    private static String leerNombre(Scanner sc) {
        return leerCampoTexto(sc, "Nombre; ", 2);
    }

    private static String leerApellido(Scanner sc) {
        return leerCampoTexto(sc, "Apellido: ", 2);
    }

    private static String leerCorreo(Scanner sc) {
        while (true) {
            System.out.println("Correo: ");
            String correo = sc.next();
            if (validarCorreo(correo)) return correo;
            System.out.println("Correo invalido");
        }
    }

    private static String leerCampoTexto(Scanner sc, String mensaje, int minLen) {
        while (true) {
            System.out.println(mensaje);
            String valor = sc.next();
            if (valor.length() > minLen) return valor;
            System.out.println("Deben tener al menos " + minLen + " caracteres");
        }
    }

    // VALIDACIONES
    private static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            if (!sc.hasNextInt()) {
                System.out.println("Debe ser un número.");
                sc.next();
                continue;
            }
            int valor = sc.nextInt();
            if (valor >= min && valor <= max) return valor;
            System.out.println("Rango permitido: " + min + "-" + max);
        }
    }

    // Listado
    private static void listarAlumnos(ArrayList<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos.");
            return;
        }
        alumnos.forEach(System.out::println);
    }

    private static boolean validarCorreo(String correo) {
        return correo.contains("@") && correo.contains(".");
    }
}