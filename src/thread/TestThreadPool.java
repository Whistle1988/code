package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YoSaukit
 * @date 2020/4/13 16:47
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolDemo tp = new ThreadPoolDemo();
        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //2. 为线程池中的线程分配任务
        pool.submit(tp);
        //3. 关闭线程池
        pool.shutdown();
    }
}
