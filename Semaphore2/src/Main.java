import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        int perm =  1;
        Semaphore semaforo = new Semaphore(perm);
        for (int prato = 0 ; prato < 5 ; prato++){
                    Thread overcooked = new Overcooked(prato, semaforo);
                    overcooked.start();

        }

    }
}
