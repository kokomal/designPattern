package yuanjun.chen.design.flyweight.wiki;

public class BMWSerieCarCustomisation implements BMWCarCustomisation {

    private int tireSize;
    private String laserSignature;

    public BMWSerieCarCustomisation(int tireSize, String laserSignature) {
        this.tireSize = tireSize;
        this.laserSignature = laserSignature;
    }

    public int getTireSize() {
        return tireSize;
    }

    public String getLaserSignature() {
        return laserSignature;
    }

    @Override
    public void printCustomisations() {
        System.out.println("Tire Size:" + getTireSize());
        System.out.println("LaserSignature:" + getLaserSignature());
        System.out.println("LaserSignature Size:" + getLaserSignature().length());
    }
}
