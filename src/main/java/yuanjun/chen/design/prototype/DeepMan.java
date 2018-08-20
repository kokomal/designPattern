package yuanjun.chen.design.prototype;

public class DeepMan extends PrototypeMan {
    @Override
    public PrototypeMan clone() throws CloneNotSupportedException {
        DeepMan p =  (DeepMan) super.clone();
        Purse pp = p.getPurse();
        Purse newP = new Purse();
        newP.setMoney(pp.getMoney());
        newP.setOwner(pp.getOwner());
        p.setPurse(newP);
        return p;
    }
}
