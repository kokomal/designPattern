/**
 * @Title: Lobster.java
 * @Package: yuanjun.chen.concurrent.consumerproducer
 * @Description: 简单pojo，无业务
 * @author: 陈元俊
 * @date: 2018年8月2日 下午2:49:26
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.consumerproducer;

/**
 * @ClassName: Lobster
 * @Description: 简单pojo，无业务
 * @author: 陈元俊
 * @date: 2018年8月2日 下午2:49:26
 */
public class Lobster {
    public static volatile boolean shouldStopHarvesting = false;
    private int weight;
    private int size;
    private String taste;
    private String tag;
    private boolean isPoisonous = false;

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean isPoisonous) {
        this.isPoisonous = isPoisonous;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Lobster [weight=" + weight + ", size=" + size + ", taste=" + taste + ", tag=" + tag + ", isPoisonous="
                + isPoisonous + "]";
    }

    /**   
     * @Title: degenerate   
     * @Description: TODO(这里用一句话描述这个方法的作用)         
     * @return: void      
     * @throws   
     */
    public void degenerate() {
        this.taste = "awful";
    }

}
