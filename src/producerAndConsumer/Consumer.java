package producerAndConsumer;

/**
 * @author YoSaukit
 * @date 2020/4/1 23:23
 */
public class Consumer implements Runnable {
    private ProductorAndConsumer clothesFactory;

    public Consumer(ProductorAndConsumer clothesFactory) {
        this.clothesFactory = clothesFactory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                clothesFactory.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
