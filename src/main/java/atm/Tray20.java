package atm;

public class Tray20 implements Tray {
    private static final int VALUE = 20;
    private static Tray20 example = null;
    private int bills;

    private Tray20(int bills){
        this.bills = bills;
    }

    public static Tray20 getExample(int bills){
        if(example == null){
            example = new Tray20(bills);
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
        Tray10.getExample(-1).process(rest);
    }
}

