/**
 * @Title: ParcelDTO.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: 具体包裹类dto，无逻辑
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:15:38
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: ParcelDTO
 * @Description: 具体包裹类dto，无逻辑
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:15:38
 */
public class ParcelDTO extends ProtoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Date date;
    private Double price;

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
        return "ParcelDTO [name=" + name + ", date=" + date + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ParcelDTO other = (ParcelDTO) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
}
