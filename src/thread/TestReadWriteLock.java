package thread;

/**
 * @author YoSaukit
 * @date 2020/4/13 16:37
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriterLock rw = new ReadWriterLock();
        new Thread(new Runnable() {//一个线程写
            @Override
            public void run() {
                rw.set((int) (Math.random()*101));
            }
        },"write:").start();
        for (int i = 0; i < 100; i++) {//一百个线程读
            Runnable runnable = ()-> rw.get();
            Thread thread = new Thread(runnable);
            thread.start();
        }
//        new Thread(new Runnable() {//一个线程写
//            @Override
//            public void run() {
//                rw.set((int) (Math.random()*101));
//            }
//        },"read:").start();
    }
}
