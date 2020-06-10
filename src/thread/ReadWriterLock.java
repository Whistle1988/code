package thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author YoSaukit
 * @date 2020/4/13 16:37
 */
public class ReadWriterLock {
    private int number = 0;
    private ReentrantReadWriteLock readWriterLock = new ReentrantReadWriteLock();
    //读（可以多个线程同时操作）
    public void get(){
        readWriterLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":"+number);
        } finally {
            readWriterLock.readLock().unlock();
        }
    }
    public void set(int number){
        readWriterLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            readWriterLock.writeLock().unlock();
        }
    }

}
