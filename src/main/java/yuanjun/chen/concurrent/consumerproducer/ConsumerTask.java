/**  
 * @Title: ConsumerTask.java   
 * @Package: yuanjun.chen.concurrent.consumerproducer   
 * @Description: TODO(用一句话描述该文件做什么)   
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
 * @Description: TODO(这里用一句话描述这个类的作用)   
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
                if (lob != null) {
                    System.out.println("delicious loster! " + lob);
                } else {
                    System.out.println("so much time wasted! I cancel it!");
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted! no lobster seen!");
            } 
        }
    }
}
