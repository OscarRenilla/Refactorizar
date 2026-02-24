/**
 * Clase Fecha.java
 *
 * @author Alumno - Óscar Renilla
 * @version 1.1
 */
package fecha;

import java.time.*;

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

    // 1- Comprueba si hoy es el día del partido.
    public static void matchDay() {
        LocalDate fecha = LocalDate.now();
        LocalDate fecha_partido = LocalDate.parse("2026-02-12");

        if (fecha == fecha_partido)
            System.out.println("El partido es hoy");
        else {
            System.out.println("El partido no es hoy");
        }
    }

    // 2- Calcula cuántos días faltan desde hoy hasta el partido.
    public static void cuentaAtras() {
        LocalDate hoy = LocalDate.now();
        LocalDate fecha_partido =  LocalDate.parse("2026-02-12");

        Period p = Period.between(hoy, fecha_partido);
        int dias = p.getDays();

        System.out.println("Quedan " + dias + " días para el comienzo del partido");
    }

    // 3- Obtén el instante actual en UTC para guardar un registro del sistema.
    public static void registroDeLogs() {
        Instant ahora = Instant.now();
        System.out.println("Instante actual en UTC: " + ahora);
    }

    // 4- Muestra la fecha y hora actual en la zona "Europe/Madrid".
    public static void horaInternacional() {
        ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        System.out.println(madrid);
    }

    // 5- Crea una fecha y hora fija para un evento
    public static void creacionDeEvento() {
        LocalDateTime evento = LocalDateTime.of(2026, 2, 12, 10, 30);
        System.out.println(evento);
    }

    // 6- Indica si el evento (2026-02-12) ya ocurrió, es hoy o será en el futuro.
    public static void eventoPasadoOFuturo() {
        LocalDate hoy = LocalDate.now();
        LocalDate evento = LocalDate.of(2026, 2, 12);
        if (hoy.isBefore(evento)) {
            System.out.println("El evento es en el futuro.");
        } else if (hoy.isAfter(evento)) {
            System.out.println("El evento ya ocurrió.");
        } else {
            System.out.println("El evento es hoy.");
        }
    }

    // 7-A partir de la fecha 2026-02-14, indica si cae en sábado o domingo.
    public static void finDeSemana() {
        LocalDate d = LocalDate.of(2026, 2, 14);
        DayOfWeek dow = d.getDayOfWeek();
        boolean finDeSemana = (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY);
        System.out.println("¿Fin de semana? " + finDeSemana);
    }

    // 8- A la fecha 2026-02-12 súmale 7 días y muestra la nueva fecha.
    public static void sumarDias() {
        LocalDate d = LocalDate.of(2026, 2, 12);
        LocalDate resultado = d.plusDays(7);
        System.out.println(resultado);
    }

    // 9- A la fecha 2026-02-12 réstale 2 meses.
    public static void restarMeses() {
        LocalDate d = LocalDate.of(2026, 2, 12);
        LocalDate resultado = d.minusMonths(2);
        System.out.println(resultado);
    }

    // 10- Convierte la fecha y hora 2026-02-12T10:30 en un Instant usando la zona "Europe/Madrid".
    public static void conversionUniversal() {
        LocalDateTime ldt = LocalDateTime.of(2026, 2, 12, 10, 30);
        ZoneId madrid = ZoneId.of("Europe/Madrid");

        Instant instant = ldt.atZone(madrid).toInstant();
        System.out.println(instant);
    }
}

