package atm;

public class Tray2 implements Tray {
    private static final int VALUE = 2;
    private static Tray2 example = null;
    private int bills;

    private Tray2(int bills){
        this.bills = bills;
    }

    public static Tray2 getExample(int bills){
        if(example == null){
            example = new Tray2(bills);
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
        Tray1.getExample(-1).process(rest);
    }
}
