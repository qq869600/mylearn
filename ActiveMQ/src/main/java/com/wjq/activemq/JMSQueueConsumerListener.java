package com.wjq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wu-junqiang
 * @date 2019/6/22
 */
public class JMSQueueConsumerListener {
    public static volatile int i = 0;
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.180.128:61616");
        Connection connection = null;
        try {
            connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Destination queue = session.createQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(queue);
            MessageListener listener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("收到消息"+(i++)+"："+((TextMessage)message).getText());
                        session.commit();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };
            consumer.setMessageListener(listener);
            System.out.println("监听程序启动完成。。。");
            synchronized (JMSQueueConsumerListener.class){
                JMSQueueConsumerListener.class.wait();
            }
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
