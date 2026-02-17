/**
 * Clase Fecha.java
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
package fecha;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class Fecha {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        matchDay();
        cuentaAtras();
        registroDeLogs();
        horaInternacional();
        creacionDeEvento();
        eventoPasadoOFuturo();
        finDeSemana();
        sumarDias();
        restarMeses();
        conversionUniversal();
    }

    // Comprueba si hoy es el día del partido.
    public static void matchDay() {
        LocalDate fecha = LocalDate.now();
        LocalDate fecha_partido = LocalDate.parse("2026-02-12");

        if (fecha == fecha_partido)
            System.out.println("El partido es hoy");
        else {
            System.out.println("El partido no es hoy");
        }
    }

    // Calcula cuántos días faltan desde hoy hasta el partido.
    public static void cuentaAtras() {
        LocalDate hoy = LocalDate.now();
        LocalDate fecha_partido =  LocalDate.parse("2026-02-12");

        Period p = Period.between(hoy, fecha_partido);
        int dias = p.getDays();

        System.out.println("Quedan " + dias + " días para el comienzo del partido");
    }

    // Obtén el instante actual en UTC para guardar un registro del sistema.
    public static void registroDeLogs() {
        return Instant.now();
    }

    public static void horaInternacional() {
    }

    public static void creacionDeEvento() {
    }

    public static void eventoPasadoOFuturo() {
    }

    public static void finDeSemana() {
    }

    public static void sumarDias() {
    }

    public static void restarMeses() {
    }

    public static void conversionUniversal() {
    }
}

