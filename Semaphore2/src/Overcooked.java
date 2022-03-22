import java.util.concurrent.Semaphore;

public class Overcooked extends Thread {

    private int prato;
    private Semaphore semaforo;

    public Overcooked(int prato, Semaphore semaforo) {
        this.prato = prato;
        this.semaforo = semaforo;

    }

    public void run() {
        if (prato % 2 == 1) {
            sopaCebola();
        } else {
            lasanha();
        }
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            entrega();
        }
        semaforo.release();
    }


    private void sopaCebola() {
        int aux = 0;
        double tempofinal = (double) ((Math.random() * 301) + 500);
        double tempoinicial = 0;
        System.out.println("thread# " + prato + " Sopa Iniciada");
        while (tempoinicial < tempofinal) {
            aux = (int) ((tempoinicial * 100) / tempofinal);
            System.out.println("thread# " + prato + " Cozinhando Sopa de Cebola, " + aux + "% feita");
            tempoinicial += 100;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread# " + prato + " Sopa de Cebola Finalizada Encaminhando para Entrega");
    }

    private void lasanha() {
        int aux = 0;
        double tempofinal = (double) ((Math.random() * 601) + 600);
        double tempoinicial = 0;
        System.out.println("thread# " + prato + " Lasanha Iniciada");
        while (tempoinicial < tempofinal) {
            aux = (int) ((tempoinicial * 100) / tempofinal);
            System.out.println("thread# " + prato + " Cozinhando Lasanha, " + aux + "% feita");
            tempoinicial += 100;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread# " + prato + " Lasanha a Bolonhesa Finalizada Encaminhando para Entrega");
    }

    private void entrega() {
        if (prato % 2 == 1) {
            System.out.println("thread# " + prato + " O Prato de Sopa de Cebola está Sendo Entregue");
        } else {
            System.out.println("thread# " + prato + " O Prato de Lasanha a Bolonhesa está Sendo Entregue");
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
