/**
 * @Title: LobsterPlaza.java
 * @Package: yuanjun.chen.concurrent.consumerproducer
 * @Description: 主调度类
 * @author: 陈元俊
 * @date: 2018年8月2日 下午2:51:57
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.consumerproducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: LobsterPlaza
 * @Description: 主调度类
 * @author: 陈元俊
 * @date: 2018年8月2日 下午2:51:57
 */
public class LobsterPlaza {
    private static BlockingQueue<Lobster> coldChain;
    private static ExecutorService es;

    public static void init(int chainSize, int consumerSize, int producerSize) {
        coldChain = new ArrayBlockingQueue<>(chainSize);
        es = Executors.newCachedThreadPool();
        for (int i = 0; i < consumerSize; i++) {
            es.submit(new ConsumerTask(coldChain));
        }
        for (int i = 0; i < producerSize; i++) {
            es.submit(new ProducerTask(coldChain));
        }
    }

    public static void finish() {
        es.shutdown();
        while (true) {
            if (es.isTerminated()) {
                break;
            }
        }
        System.out.println("finished");
    }

    public static void stopProducingUsingStaticVar() throws Exception {
        Thread.sleep(4000);
        Lobster.shouldStopHarvesting = true;
    }

    /**
     * 可以采用全局静态变量来控制生产者的生产启停 不采用全局静态变量中断消费者任务的原因在于，
     * 可能队列中还有残留的任务，如果一刀切，会导致任务不能全部完成
     */
    public static void stopUsingPoisonPill() throws Exception {
        Thread.sleep(4000);
        for (int i = 0; i < 10; i++) {
            Lobster poison = new Lobster();
            poison.setPoisonous(true);
            coldChain.put(poison); // 直接向blockingQueue里面塞poisonPill
        }
    }

    public static void main(String[] args) throws Exception {
        init(5, 10, 10);
        stopProducingUsingStaticVar();
        stopUsingPoisonPill();

        finish();
    }
}
