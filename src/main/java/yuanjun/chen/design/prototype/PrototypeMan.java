package yuanjun.chen.design.prototype;

// Prototype pattern
public abstract class PrototypeMan implements Cloneable {
    private String name;
    private int age;
    private Purse purse;

    public Purse getPurse() {
        return purse;
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Prototype [name=" + name + ", age=" + age + ", purse=" + purse + "]";
    }

    public PrototypeMan clone() throws CloneNotSupportedException {
        return (PrototypeMan) super.clone();
    }
}
