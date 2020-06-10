package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YoSaukit
 * @date 2020/4/13 16:23
 */
public class AlternationDemo {
    private int number = 1;//当前正在执行的线程的标记
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            if (number != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void loopB(){
        lock.lock();
        try {
            if (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void loopC(){
        lock.lock();
        try {
            if (number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
