/**  
 * @Title: ConsumerTask.java   
 * @Package: yuanjun.chen.concurrent.consumerproducer   
 * @Description: 消费者任务，其从bloclingqueue中轮询获取任务并且解析，与生产者软关联    
 * @author: 陈元俊     
 * @date: 2018年8月2日 下午2:46:31   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.concurrent.consumerproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**   
 * @ClassName: ConsumerTask   
 * @Description: 消费者任务，其从bloclingqueue中轮询获取任务并且解析，与生产者软关联  
 * @author: 陈元俊 
 * @date: 2018年8月2日 下午2:46:31  
 */
public class ConsumerTask implements Runnable{
    private BlockingQueue<Lobster> coldChain;

    public ConsumerTask(BlockingQueue<Lobster> coldChain) {
        super();
        this.coldChain = coldChain;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Lobster lob = coldChain.poll(1, TimeUnit.SECONDS);
                if (lob != null && !lob.isPoisonous()) {
                    System.out.println("delicious loster! " + lob);
                } else if (lob != null && lob.isPoisonous()) {
                    System.out.println("gotta stop eating!");
                    break;
                }
                else {
                    System.out.println("so much time wasted! I cancel it!");
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted! no lobster seen!");
            } 
        }
    }
}
