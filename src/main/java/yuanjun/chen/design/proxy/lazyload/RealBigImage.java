/**
 * @Title: RealBigImage.java
 * @Package: yuanjun.chen.design.proxy
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:33:54
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.proxy.lazyload;

/**
 * @ClassName: RealBigImage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月10日 上午9:33:54
 */
public class RealBigImage implements Image {
    private String fileName;

    public RealBigImage() {}

    public RealBigImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void showImage() {
        System.out.println("after loading i am displaying it now...hmm, " + fileName + " is impressive");
    }

    public void loadFromDisk(String fileName) {
        /* slowly.... */
        System.out.println("I am loading " + fileName + " from local disk very very slowly!");
    }

    public String getFileName() {
        return fileName;
    }
}
