package thread;

/**
 * @author YoSaukit
 * @date 2020/4/13 16:44
 */
public class ThreadPoolDemo implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        while (i < 100) {
            System.out.println(Thread.currentThread().getName()+":"+(i++));
        }
    }
}
