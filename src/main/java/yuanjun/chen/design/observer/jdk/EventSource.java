package yuanjun.chen.design.observer.jdk;

import java.util.Observable;
import java.util.UUID;

public class EventSource extends Observable implements Runnable {
    private volatile boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    /** Observable是一个独立的类,内嵌一个vector<Observer>. */
    public void run() {
        do {
            String response = UUID.randomUUID().toString();
            setChanged();
            notifyObservers(response);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        } while (!stop);
    }
}
