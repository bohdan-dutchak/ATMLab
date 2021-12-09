package atm;

public class Tray500 implements Tray {
    private static final int VALUE = 500;
    private static Tray500 example = null;
    private int bills;

    private Tray500(int bills){
        this.bills = bills;
    }

    public static Tray500 getExample(int bills){
        if(example == null){
            example = new Tray500(bills);
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
        Tray200.getExample(-1).process(rest);
    }
}