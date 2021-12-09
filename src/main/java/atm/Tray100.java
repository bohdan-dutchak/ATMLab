package atm;

public class Tray100 implements Tray {
    private static final int VALUE = 100;
    private static Tray100 example = null;
    private int bills;

    private Tray100(int bills){
        this.bills = bills;
    }

    public static Tray100 getExample(int bills){
        if(example == null){
            example = new Tray100(bills);
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
        Tray50.getExample(-1).process(rest);
    }
}
