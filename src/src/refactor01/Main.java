package refactor01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<String> nombres = new ArrayList<>();
    private static ArrayList<String> apellidos = new ArrayList<>();
    private static ArrayList<Integer> edades = new ArrayList<>();
    private static ArrayList<String> correos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            System.out.println("====== GESTIÓN DE ALUMNOS =====" +
                    "\n1. Insertar Alumno" +
                    "\n2. Listar alumnos" +
                    "\n3. Salir" +
                    "\nIngrese una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    insertarAlumno();
                    break;
                case 2:
//                    listarAlumnos();
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

    public static void insertarAlumno() {

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n1 Insertar alumno");
            System.out.println("2 Listar alumnos");
            System.out.println("0 Salir");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Debes introducir un número");
                sc.next(); // limpiar basura
                opcion = -1;
                continue;
            }
            if (opcion == 1) {
                // ===== NOMBRE =====
                System.out.print("Nombre: ");
                String nombre = sc.next();
                validarTexto(nombre);

                // ===== APELLIDO =====
                System.out.print("Apellido: ");
                String apellido = sc.next();

                if (apellido.length() < 2) {
                    System.out.println("Apellido inválido, solo se permite texto con mínimo dos letras");
                    continue;
                }
                // ===== EDAD =====
                System.out.print("Edad (Entre 18 y 100): ");
                if (!sc.hasNextInt()) {
                    System.out.println("Edad debe ser número");
                    sc.next();
                    continue;
                }
                int edad = sc.nextInt();
                if (edad < 18 || edad > 100) {
                    System.out.println("Edad fuera de rango (18-100)");
                    continue;
                }
                // ===== CORREO =====
                System.out.print("Correo: ");
                String correo = sc.next();
                // validación simple (mala a propósito)
                if (!correo.contains("@") || !correo.contains(".")) {
                    System.out.println("Correo inválido");
                    continue;
                }
                // guardar
                nombres.add(nombre);
                apellidos.add(apellido);
                edades.add(edad);
                correos.add(correo);
                System.out.println("Alumno guardado correctamente");
            } else if (opcion == 2) {
                if (nombres.size() == 0) {
                    System.out.println("No hay alumnos");
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println(
                                nombres.get(i) + " " +
                                        apellidos.get(i) + " | " +
                                        edades.get(i) + " | " +
                                        correos.get(i)
                        );
                    }
                }
            } else if (opcion != 0) {
                System.out.println("Opción incorrecta");
            }
        }
        sc.close();
    }


    // VALIDACIONES
    public static void validarTexto(String texto) {
        if (texto.length() < 2) {
            System.out.println("Nombre inválido, solo se permite texto con mínimo dos letras");
        }
    }
}