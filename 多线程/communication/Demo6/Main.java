package 多线程.communication.Demo6;

/**
 * @Author: ruan
 * Date: 2021/7/3 21:35
 * @Description: 主方法
 */
public class Main {
    public static void main(String[] args) {
        Medium medium = new Medium();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();

        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
    }
}
