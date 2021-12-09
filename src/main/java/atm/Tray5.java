package atm;

public class Tray5 implements Tray {
    private static final int VALUE = 5;
    private static Tray5 example = null;
    private int bills;

    private Tray5(int bills){
        this.bills = bills;
    }

    public static Tray5 getExample(int bills){
        if(example == null){
            example = new Tray5(bills);
        }
        return example;
    }

    @Override
    public void process(int amount) {
        int papers = amount / VALUE;
        papers = Math.min(papers, this.bills);
        this.bills -=papers;
        int rest = amount - papers * VALUE;
        if (papers != 0) {
            System.out.println("Extracted " + papers + " " + VALUE + "UAH bills");
        }
        Tray2.getExample(-1).process(rest);
    }
}
