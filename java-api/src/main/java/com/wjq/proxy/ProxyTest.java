package com.wjq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wu-junqiang
 * @date 2019/7/7
 */
public class ProxyTest {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Person proxyWorker = (Person) Proxy.newProxyInstance(worker.getClass().getClassLoader(), worker.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前");
                        Object val = method.invoke(worker, args);
                        System.out.println("代理后");
                        System.out.println();
                        return val;
                    }
                }
        );
        proxyWorker.eat();
        proxyWorker.sleep();

        System.out.println("cglib代理................");
        Worker cglibWorker = (Worker) new CglibProxy().getInstance(worker);
        cglibWorker.sleep();
        cglibWorker.eat();
    }
}
