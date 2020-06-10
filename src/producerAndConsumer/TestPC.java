package producerAndConsumer;

/**
 * @author YoSaukit
 * @date 2020/4/1 23:25
 */
public class TestPC {
    public static void main(String[] args) {
        ProductorAndConsumer clothesFactory = new ProductorAndConsumer();
        Thread p1 = new Thread(new Producer(clothesFactory),"生产者1");
        Thread p2 = new Thread(new Producer(clothesFactory),"生产者2");
        Thread p3 = new Thread(new Producer(clothesFactory),"生产者3");

        Thread c1 = new Thread(new Consumer(clothesFactory),"消费者1");
        Thread c2 = new Thread(new Consumer(clothesFactory),"消费者2");
        Thread c3 = new Thread(new Consumer(clothesFactory),"消费者3");

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();

    }
}
