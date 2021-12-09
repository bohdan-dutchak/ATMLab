package atm;

import java.util.Scanner;
import java.util.Scanner.*;

public class Main {
    public static void fillATM(int amount){
        System.out.println("Filled ATM with "+amount+" of each bill...");
        Tray1.getExample(amount);
        Tray2.getExample(amount);
        Tray5.getExample(amount);
        Tray10.getExample(amount);
        Tray20.getExample(amount);
        Tray50.getExample(amount);
        Tray100.getExample(amount);
        Tray200.getExample(amount);
        Tray500.getExample(amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fillATM(1);
        System.out.println("How many UAH do you want to cashup?");
        int toCash = sc.nextInt();
        Tray500.getExample(-1).process(toCash);
    }
}
