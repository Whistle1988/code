package producerAndConsumer;

import java.util.LinkedList;

/**
 * https://baijiahao.baidu.com/s?id=1651415806527193535&wfr=spider&for=pc
 * 当缓冲区已满时，生产者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
 * 当缓冲区已空时，消费者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
 * 当生产者向缓冲区放入一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态；
 * 当消费者从缓冲区取出一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，是自己处于等待状态。
 * @author YoSaukit
 * @date 2020/4/1 22:59
 */
public class ProductorAndConsumer {
    private final int size = 10;
    private LinkedList<Object> list = new LinkedList<>();
    public void produce(){
        synchronized (list){
            while(list.size() >= 10){
                System.out.println("生产者"+Thread.currentThread().getName()+"仓库已满");
                try {
                    list.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            list.addFirst(new Object());
            System.out.println(Thread.currentThread().getName()+"生成衣服，先存储量"+list.size());
            list.notifyAll();
        }
    }
    public void consume(){
        synchronized (list){
            while(list.size() <= 0){
                System.out.println(Thread.currentThread().getName()+"仓库没有衣服了");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.removeLast();
            System.out.println(Thread.currentThread().getName()+"消费衣服，先存储量"+list.size());
            list.notifyAll();
        }
    }
}
