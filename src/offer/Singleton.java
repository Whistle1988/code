package offer;

/**
 * 单例模式
 * @author YoSaukit
 * @date 2020/4/25 21:31
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
 * 优化实现
 * 传统实现方式，每次获取实例都要被synchronized关键字串行化（即时已经生成了实例）
 * 而我们加锁的目的是为了防止生成多个实例，因此只需要对生成实例的代码加锁，生成实例后，可支持并发访问。
 * 由于检查了两次对象是否已实例化，该方法又称“双检锁”，能够同时保证性能及线程安全。
 */
class Singleton{
    private Singleton(){};
    private volatile static Singleton obj;
    public static Singleton getInstance(){
        if (obj == null){
            //仅在没生成实例时加锁控制，使并发访问串行化
            synchronized (Singleton.class){
                if (obj == null){
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}













