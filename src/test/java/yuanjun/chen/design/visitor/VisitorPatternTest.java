/**
 * @Title: VisitorPatternTest.java
 * @Package: yuanjun.chen.design.visitor
 * @Description: 访问者模式测试
 * @author: 陈元俊
 * @date: 2018年8月13日 下午1:35:44
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.visitor;

import org.junit.Test;
import yuanjun.chen.design.visitor.resumedemo.HealthResumeViewer;
import yuanjun.chen.design.visitor.resumedemo.Resume;
import yuanjun.chen.design.visitor.resumedemo.SalaryResumeViewer;
import yuanjun.chen.design.visitor.resumedemo.Viewer;
import yuanjun.chen.design.visitor.wikidemo.Car;
import yuanjun.chen.design.visitor.wikidemo.CarElementDoVisitor;
import yuanjun.chen.design.visitor.wikidemo.CarElementPrintVisitor;

/**
 * @ClassName: VisitorPatternTest
 * @Description: 访问者模式测试
 * @author: 陈元俊
 * @date: 2018年8月13日 下午1:35:44
 */
public class VisitorPatternTest {
    @Test
    public void wikiTest() {
        final Car car = new Car();
        car.accept(new CarElementPrintVisitor()); // 应该由数据本体来接收数据
        System.out.println("---------------------------------");
        car.accept(new CarElementDoVisitor());
        System.out.println("---------------------------------");
        new CarElementDoVisitor().visit(car); // 不推荐访问者主动访问数据
    }

    @Test
    public void resumeTest() {
        Resume rsm = new Resume(); // Resume里面封装了各个部件细节
        rsm.init(); // 初始化
        Viewer hr = new SalaryResumeViewer("HR-马化腾");
        Viewer doctor = new HealthResumeViewer("DOCTOR-白求恩");
        rsm.accept(hr); // 同样一份数据，不同的访问者有不同的动机和目的，因此视角也不一样
        System.out.println("---------------------");
        rsm.accept(doctor);
        // hr.view(rsm); // 这个只是一个壳子， 跨包将无法访问view方法，也就间接拒绝访问者主动访问数据
        // doctor.view(rsm); // 同上
    }
}
