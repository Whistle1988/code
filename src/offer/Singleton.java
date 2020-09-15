package offer;

/**
 * 单例模式:整个系统中只能出现类的一个实例，即一个类只有一个对象
 *
 * @author YoSaukit
 * @date 2020/4/25 21:31
 * <p>
 * 懒汉式单例
 * 当需要使用对象的时候才进行实例化，需要考虑线程安全问题（防止并发访问时生成多个实例）
 * 因此需要加锁，用时间换空间
 * <p>
 * 饿汉式
 */

/**
 * 懒汉式单例
 * 当需要使用对象的时候才进行实例化，需要考虑线程安全问题（防止并发访问时生成多个实例）
 * 因此需要加锁，用时间换空间
 */
//public class Singleton {
//    private Singleton(){};
//    private static Singleton obj;
//
//    //加锁保证obj只实例化一次，时间换空间
//    public static synchronized Singleton getInstance(){
//        if (obj == null) {
//            obj = new Singleton();
//        }
//        return obj;
//    }
//}

/**
 * 饿汉式
 */
//class Singleton{
//    private static Singleton obj = new Singleton();
//    private Singleton(){};//私有化构造方法
//    public static Singleton getInstance(){
//        return obj;
//    }
//}

/**
 * 优化实现：双检锁
 *
 * 传统实现方式，每次获取实例都要被synchronized关键字串行化（即时已经生成了实例）
 * 而我们加锁的目的是为了防止生成多个实例，因此只需要对生成实例的代码加锁，生成实例后，可支持并发访问。
 * 由于检查了两次对象是否已实例化，该方法又称“双检锁”，能够同时保证性能及线程安全。
 */
//class Singleton {
//    private volatile static Singleton instance;//如果singleton没有初始化完毕，B线程访问的将是个还没初始化完毕的对象
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (instance == null) {//性能优化，同步会造成性能下降，在同步前通过判读singleton是否初始化，减少不必要的同步开销
//            synchronized (Singleton.class) {//同步，线程安全,注意静态变量singleton使用volatile修饰
//                if (instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}
/**
 * 静态内部类
 * 效果类似双检锁，但实现更简单。但这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用
 */
//public class Singleton {
//    private static class SingletonHandler {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton(){}
//    public static final Singleton getInstance(){
//        return SingletonHandler.INSTANCE;
//    }
//}
/**
 * 枚举
 * 同样利用静态内部类中讲到类初始化锁，能够在初始化和反射中保证实例的唯一性。
 */
public enum Singleton {
    INSTANCE;
    public void doSomething() {}

}












