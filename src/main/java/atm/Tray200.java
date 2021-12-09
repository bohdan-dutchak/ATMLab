package atm;

public class Tray200 implements Tray {
    private static final int VALUE = 200;
    private static Tray200 example = null;
    private int bills;

    private Tray200(int bills){
        this.bills = bills;
    }

    public static Tray200 getExample(int bills){
        if(example == null){
            example = new Tray200(bills);
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
        Tray100.getExample(-1).process(rest);
    }
}