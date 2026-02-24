package timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        int xSegundos = 5;
        long delay = xSegundos * 1000;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("AHORA: " + ahora.format(formato));

        LocalDateTime horaEsperada = ahora.plusSeconds(xSegundos);
        System.out.println("HORA ESPERADA: " + horaEsperada.format(formato));

        System.out.println("Dentro de 1 minuto:   " + ahora.plusMinutes(1).format(formato));
        System.out.println("Dentro de 2 horas:    " + ahora.plusHours(2).format(formato));
        System.out.println("Dentro de 1 día:      " + ahora.plusDays(1).format(formato));
        System.out.println("Dentro de 1 semana:   " + ahora.plusWeeks(1).format(formato));
        System.out.println("Dentro de 1 mes:      " + ahora.plusMonths(1).format(formato));
        System.out.println("Dentro de 1 año:      " + ahora.plusYears(1).format(formato));

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime ejecucion = LocalDateTime.now();

                System.out.println("\n¡Ha pasado " + xSegundos + " segundos!");
                System.out.println("HORA DE EJECUCIÓN: " + ejecucion.format(formato));

                timer.cancel();
            }
        };
        timer.schedule(tarea, delay);
    }
}