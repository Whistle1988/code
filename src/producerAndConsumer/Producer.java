package producerAndConsumer;

/**
 * @author YoSaukit
 * @date 2020/4/1 23:21
 */
public class Producer implements Runnable {
    private ProductorAndConsumer clothFactory;
    public Producer(ProductorAndConsumer clothFactory){
        this.clothFactory = clothFactory;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                clothFactory.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
