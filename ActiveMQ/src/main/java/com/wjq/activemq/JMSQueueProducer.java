package com.wjq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @author wu-junqiang
 * @date 2019/6/22
 */
public class JMSQueueProducer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.180.128:61616");
        Connection connection = null;
        try {
            connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Destination queue = session.createQueue("myQueue");
            MessageProducer producer = session.createProducer(queue);
            int i = 0;
            while (i++ <= Integer.MAX_VALUE){
                TextMessage msg = session.createTextMessage("你好世界"+i);
                producer.send(msg);
//                System.out.println("发送消息成功："+msg.getText());
                session.commit();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
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
