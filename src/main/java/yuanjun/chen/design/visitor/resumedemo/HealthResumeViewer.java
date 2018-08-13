/**
 * @Title: HealthResumeViewer.java
 * @Package: yuanjun.chen.design.visitor.resumedemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:09:47
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.visitor.resumedemo;

/**
 * @ClassName: HealthResumeViewer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:09:47
 */
public class HealthResumeViewer extends Viewer {

    public HealthResumeViewer(String viewerRole) {
        super(viewerRole);
    }

    @Override
    protected void viewSalary(SalaryResumeBlock salary) {
        System.out.println(viewerRole + "打开薪酬簿子，发现不感兴趣");
    }

    @Override
    protected void viewHealth(HealthResumeBlock health) {
        System.out.println(viewerRole + "打开病历卡，仔细检查此人的健康情况");
        System.out.println(viewerRole + "看到此人血压: " + health.getBloodPressure() + " 身高： " + health.getHeight() + " 体重： "
                + health.getWeight());
    }

}
