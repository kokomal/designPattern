/**
 * @Title: RealBigVideo.java
 * @Package: yuanjun.chen.design.proxy.lazyload
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月10日 下午12:55:36
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.lazyload;

/**
 * @ClassName: RealBigVideo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月10日 下午12:55:36
 */
public class RealBigVideo implements Video {
    private String fileName;

    public RealBigVideo() {}

    public RealBigVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void playVideo() {
        System.out.println("after loading i am play video now...hmm, " + fileName + " is impressive");
    }

    public void loadFromDisk(String fileName) {
        /* slowly.... */
        System.out.println("I am loading " + fileName + " from local disk very very slowly!");
    }
}
