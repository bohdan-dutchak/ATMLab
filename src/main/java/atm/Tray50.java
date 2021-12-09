package atm;

public class Tray50 implements Tray {
    private static final int VALUE = 50;
    private static Tray50 example = null;
    private int bills;

    private Tray50(int bills){
        this.bills = bills;
    }

    public static Tray50 getExample(int bills){
        if(example == null){
            example = new Tray50(bills);
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
        Tray20.getExample(-1).process(rest);
    }
}
