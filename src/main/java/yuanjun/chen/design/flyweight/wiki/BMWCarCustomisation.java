package yuanjun.chen.design.flyweight.wiki;

public interface BMWCarCustomisation {
    // customize Tire size
    int getTireSize();

    String getLaserSignature();

    // a lot of customisation attributes can be in there for a BMW car
    void printCustomisations();
}
