package timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class MainTimer {

    // Formato bonito para fechas
    private static final DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        // Tiempos pedidos
        ejecutarConRetraso("1 minuto",      LocalDateTime.now().plusMinutes(1));
        ejecutarConRetraso("2 horas",       LocalDateTime.now().plusHours(2));
        ejecutarConRetraso("1 día",         LocalDateTime.now().plusDays(1));
        ejecutarConRetraso("1 semana",      LocalDateTime.now().plusWeeks(1));
        ejecutarConRetraso("1 mes",         LocalDateTime.now().plusMonths(1));
        ejecutarConRetraso("1 año",         LocalDateTime.now().plusYears(1));
    }

    private static void ejecutarConRetraso(String nombre, LocalDateTime fechaObjetivo) {
        Timer timer = new Timer();

        LocalDateTime ahora = LocalDateTime.now();

        // Mostrar inicio
        System.out.println("\n----------------------------------------");
        System.out.println("Inicio (" + nombre + ")");
        System.out.println("AHORA: " + ahora.format(formato));
        System.out.println("HORA ESPERADA: " + fechaObjetivo.format(formato));

        long delay = java.time.Duration.between(ahora, fechaObjetivo).toMillis();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\n¡Ha pasado " + nombre + "!");
                System.out.println("HORA DE EJECUCIÓN: " +
                        LocalDateTime.now().format(formato));
                timer.cancel();
            }
        };

        timer.schedule(tarea, delay);
    }
}