/**
 * @Title: StaticProxyVideo.java
 * @Package: yuanjun.chen.design.proxy.lazyload
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月10日 下午2:41:07
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.lazyload;

/**
 * @ClassName: StaticProxyVideo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月10日 下午2:41:07
 */
public class StaticProxyVideo implements Video {
    /** 持有一个具体的被代理类对象. */
    private RealBigVideo realVideo;
    private String fileName;

    public StaticProxyVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void playVideo() {
        if (this.realVideo == null) { // 在此实现懒加载
            realVideo = new RealBigVideo(fileName); // 冗长的加载，可以按需执行
        }
        System.out.println("proxy prepare to display real image"); // 一些装饰
        realVideo.playVideo();
        System.out.println("proxy finished displaying real image"); // 一些装饰
    }

    public static void main(String[] args) {
        StaticProxyVideo prox = new StaticProxyVideo("the Godfather III");
        // 在显式调用display前，没有任何动静，只是一个空壳
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prox.playVideo(); // 第一次触发冗长加载
        prox.playVideo(); // 第二次直接使用
    }
}
