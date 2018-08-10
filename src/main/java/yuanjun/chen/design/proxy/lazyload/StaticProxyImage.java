/**
 * @Title: ProxyImage.java
 * @Package: yuanjun.chen.design.proxy
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:36:49
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.lazyload;

/**
 * @ClassName: ProxyImage
 * @Description: 静态代理示范，每一个具体的类都需要一个代理来匹配
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:36:49
 */
public class StaticProxyImage implements Image {
    /** 持有一个具体的被代理类对象. */
    private RealBigImage realImage;

    private String fileName;

    public StaticProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showImage() {
        if (this.realImage == null) { // 在此实现懒加载
            realImage = new RealBigImage(fileName); // 冗长的加载，可以按需执行
        }
        System.out.println("proxy prepare to display real image"); // 一些装饰
        realImage.showImage();
        System.out.println("proxy finished displaying real image"); // 一些装饰
    }

    public static void main(String[] args) {
        StaticProxyImage prox = new StaticProxyImage("playboy");
        // 在显式调用display前，没有任何动静，只是一个空壳
        prox.showImage(); // 第一次触发冗长加载
        prox.showImage(); // 第二次直接使用
    }
}
