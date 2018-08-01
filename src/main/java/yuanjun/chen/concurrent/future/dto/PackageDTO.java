/**
 * @Title: PackageDTO.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: 抽象包裹类
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:55:18
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future.dto;

import java.util.Date;

/**
 * @ClassName: PackageDTO
 * @Description: 抽象包裹类
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:55:18
 */
public abstract class PackageDTO {
    private String name;
    private Date date;
    private Double price;

    abstract String getBrand();
    
    public void brandTag() {
        this.name += "---" + getBrand();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PackageDTO [name=" + name + ", date=" + date + ", price=" + price + "]";
    }

}
