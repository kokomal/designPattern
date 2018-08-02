/**
 * @Title: LobsterPlaza.java
 * @Package: yuanjun.chen.concurrent.consumerproducer
 * @Description: TODO(用一句话描述该文件做什么)
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
        es.shutdown();
        while (true) {
            if (es.isTerminated()) {
                break;
            }
        }
        System.out.println("finished");
    }

    public static void main(String[] args) {
        init(5, 20, 10);
    }
}
