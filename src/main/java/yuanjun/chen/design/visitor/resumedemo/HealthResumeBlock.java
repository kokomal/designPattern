/**
 * @Title: HealthResumeBlock.java
 * @Package: yuanjun.chen.design.visitor.resumedemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:06:31
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.visitor.resumedemo;

/**
 * @ClassName: HealthResumeBlock
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:06:31
 */
public class HealthResumeBlock implements ResumeBlock {

    private Double height;
    private Double weight;
    private Double bloodPressure;

    public HealthResumeBlock(Double height, Double weight, Double bloodPressure) {
        super();
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public void accept(Viewer viewer) { // 无法放到抽象类里面，因为这是根据具体的类型进行分类的，抽象类无法进行抽取
        viewer.viewHealth(this);
    }

}
