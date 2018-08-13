/**
 * @Title: Resume.java
 * @Package: yuanjun.chen.design.visitor.resumedemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:10:31
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.visitor.resumedemo;

/**
 * @ClassName: Resume
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:10:31
 */
public class Resume implements ResumeBlock {
    private ResumeBlock[] blocks;

    public ResumeBlock[] getBlocks() {
        return blocks;
    }

    public void init() {
        this.blocks = new ResumeBlock[] {new HealthResumeBlock(170.1, 89.2, 88.22), new SalaryResumeBlock(330000d)};
    }

    /**
     * 通常的做法是object structure进行accept的时候，进行对各个部件的遍历次序
     * 从object structure进行遍历，和从viewer进行遍历，二者只能选一个 
     */
    @Override
    public void accept(Viewer viewer) {
        viewer.view(this); // 先view自己全局
        for (ResumeBlock block : this.blocks) {
            block.accept(viewer); // 再view子部件
        }
    }
}
