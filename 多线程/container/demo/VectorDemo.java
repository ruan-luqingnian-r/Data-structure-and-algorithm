package 多线程.container.demo;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Author: ruan
 * Date: 2021/7/4 15:25
 * @Description:
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo"+i);
        }
        //这是一个错误的遍历
//        stringVector.forEach(e->{
//            if (e.equals("demo3")){
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });
//        //单线程正确迭代
        Iterator<String> iterator = stringVector.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next.equals("demo3")){
//                iterator.remove();
//            }
//        }
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                synchronized (iterator) {
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (next.equals("demo3")) {
                            iterator.remove();
                        }
                    }
                }
            }).start();
        }
    }
}
