package yuanjun.chen.design.iterator;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        String[] initNames = new String[] {"Robert", "John", "Julie", "Lora"};
        NameRepository namesRepository = new NameRepository(initNames);

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
