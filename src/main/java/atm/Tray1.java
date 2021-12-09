package atm;

public class Tray1 implements Tray {
    private static final int VALUE = 1;
    private static Tray1 example = null;
    private int bills;

    private Tray1(int bills){
        this.bills = bills;
    }

    public static Tray1 getExample(int bills){
        if(example == null){
            example = new Tray1(bills);
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

        if (rest!=0){
            System.out.println("Error. Not enough bills in the ATM. "+amount+"UAH left uncashed");
        }
    }
}
