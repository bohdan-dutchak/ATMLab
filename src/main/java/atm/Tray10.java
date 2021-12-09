package atm;

public class Tray10 implements Tray {
    private static final int VALUE = 10;
    private static Tray10 example = null;
    private int bills;

    private Tray10(int bills){
        this.bills = bills;
    }

    public static Tray10 getExample(int bills){
        if(example == null){
            example = new Tray10(bills);
        }
        return example;
    }

    @Override
    public void process(int amount) {
        int papers = amount / VALUE;
        papers = Math.min(papers, this.bills);
        this.bills -= papers;
        int rest = amount - papers * VALUE;
        if (papers != 0) {
            System.out.println("Extracted " + papers + " " + VALUE + "UAH bills");
        }
        Tray5.getExample(-1).process(rest);
    }
}
