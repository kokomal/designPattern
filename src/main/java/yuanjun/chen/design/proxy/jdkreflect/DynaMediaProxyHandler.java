/**
 * @Title: DynaImageProxy.java
 * @Package: yuanjun.chen.design.proxy.jdkreflect
 * @Description: 泛型多功能动态代理Handler
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:52:23
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.jdkreflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import yuanjun.chen.design.proxy.lazyload.Image;
import yuanjun.chen.design.proxy.lazyload.Media;
import yuanjun.chen.design.proxy.lazyload.RealBigImage;
import yuanjun.chen.design.proxy.lazyload.RealBigVideo;
import yuanjun.chen.design.proxy.lazyload.Video;

/**
 * @ClassName: DynaProxyHandler
 * @Description: 泛型多功能动态代理Handler
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:52:23
 */
public class DynaMediaProxyHandler<T extends Media> implements InvocationHandler {
    private T obj;

    public DynaMediaProxyHandler(T obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy prepare to do something"); // 一些装饰
        method.invoke(obj, args);
        System.out.println("proxy finished displaying"); // 一些装饰
        return null; // 对返回不感兴趣
    }

    @SuppressWarnings({"unchecked"})
    public <E extends Media> E getInstance(Class<E> clazz) { // clazz一定要是接口
        return (E) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, this);
    }

    public Image fetchDynamicImage() {
        return getInstance(Image.class);
    }

    public Video fetchDynamicVideo() {
        return getInstance(Video.class);
    }

    public static void main(String[] args) {
        RealBigImage real = new RealBigImage("Playboy");
        DynaMediaProxyHandler<Image> imagehandler = new DynaMediaProxyHandler<>(real);
        Image imgProxy = imagehandler.fetchDynamicImage();
        imgProxy.showImage();
        imgProxy.showImage(); // 第二次不需要再初始化
        Image imgProxy2 = imagehandler.fetchDynamicImage();
        imgProxy2.showImage(); // 这次也不需要初始化
        imgProxy2.showImage(); // 更加不需要再初始化
        RealBigVideo rv = new RealBigVideo("the Godfather I");
        DynaMediaProxyHandler<Video> videohandler = new DynaMediaProxyHandler<>(rv);
        Video videoProxy = videohandler.fetchDynamicVideo();
        videoProxy.playVideo();
        videoProxy.playVideo();
        Image im = videohandler.fetchDynamicImage(); // danger!
        try {
            im.showImage();
        } catch (Exception e) {
            System.out.println(e);
        }
        RealBigVideo rv2 = new RealBigVideo("the Godfather II");
        DynaMediaProxyHandler<Video> videohandler2 = new DynaMediaProxyHandler<>(rv2);
        Video videoInstance = videohandler2.getInstance(Video.class);
        videoInstance.playVideo();
        videoInstance.playVideo();
    }
}
