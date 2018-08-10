/**
 * @Title: CglibImageProxy.java
 * @Package: yuanjun.chen.design.proxy.cglib
 * @Description: 采用Cglib的动态代理类
 * @author: 陈元俊
 * @date: 2018年8月10日 上午10:15:15
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import yuanjun.chen.design.proxy.lazyload.Image;
import yuanjun.chen.design.proxy.lazyload.Media;
import yuanjun.chen.design.proxy.lazyload.RealBigImage;
import yuanjun.chen.design.proxy.lazyload.RealBigVideo;
import yuanjun.chen.design.proxy.lazyload.Video;

/**
 * @ClassName: CglibImageProxy
 * @Description: 采用Cglib的动态代理类
 * @author: 陈元俊
 * @date: 2018年8月10日 上午10:15:15
 */
public class CglibMediaProxy<T extends Media> implements MethodInterceptor {
    private T target;

    /** 根据传入的target，生成一个enhancer，并返回enhancer包装的类实例. */
    @SuppressWarnings("unchecked")
    public T getInstance(final T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass()); // 仍然是接口
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy prepare to prepare display"); // 一些装饰
        Object result = methodProxy.invoke(target, args); // 注意这里的obj，method似乎没有用上，obj会自我调用直到StackOverflow
        System.out.println("proxy finished displaying"); // 一些装饰
        return result;
    }

    public static void main(String[] args) {
        RealBigImage img = new RealBigImage("Playboy");
        CglibMediaProxy<Image> proxy = new CglibMediaProxy<>();
        Image p = proxy.getInstance(img); // 不需要强制转置
        p.showImage();
        p.showImage();

        RealBigVideo rv = new RealBigVideo("the Godfather I");
        CglibMediaProxy<Video> proxy2 = new CglibMediaProxy<>();
        Video v = proxy2.getInstance(rv); // 比jdk的reflect类型更加安全
        v.playVideo();
        v.playVideo();
    }
}
