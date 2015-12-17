package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import vistas.nuevoIngreso;

public class StartTime extends Thread {

    String palabra;
    nuevoIngreso ref;
    int hora, minutos, segundos;
    Calendar calendario;

    public StartTime(nuevoIngreso app) {
        ref = app;
    }

    public void run() {
        while (true) {
            calendario = new GregorianCalendar();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            ref.getTxtHoraInicio().setText(hora + ":" + minutos + ":" + segundos);
        }
    }
}