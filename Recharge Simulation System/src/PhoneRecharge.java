import java.util.*;

public class PhoneRecharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalRecharge = 0;
        boolean nextRecharge = true;
        System.out.println("Welcome to Recharge Simulation System");

        while (true) {
            while (nextRecharge) {
                System.out.println("Choose Your Recharge");
                System.out.println("1 " + "JIO");
                System.out.println("2 " + "Airtel");
                System.out.println("3 " + "BSNL");
                System.out.println("4 " + " Show Balance");
//                System.out.println("You want to recharge write  your response as true or false");

                System.out.println("Choose your Recharge ");
                int choice = sc.nextInt();
                int amount = 0;
                if (choice == 1) {
                    amount = 399;
                    System.out.println("JIO Recharge of amount Rs : " + amount + " is Successfu");
                    totalRecharge += amount;

                } else if (choice == 2) {
                    amount = 299;
                    System.out.println("Airtel Recharge of amount Rs : " + amount + " is Successfu");
                    totalRecharge += amount;
                } else if (choice == 3) {
                    amount = 199;
                    System.out.println("BSNL Recharge of amount Rs : " + amount + " is Successfu");
                    totalRecharge += amount;
                }
                else if (choice == 4) {
                    System.out.println("Your balance amount till now is Rs : " + totalRecharge);
                }

                System.out.println("Want to recharge? (true/false)");
            nextRecharge = sc.nextBoolean();
            if (nextRecharge == false) {
                System.out.println("Don't want to recharge");
                break;
            }

        }
            if (!nextRecharge) {
                break;
            }
        }
//        System.out.println("Total amount for Recharge is RS : "+totalRecharge);


    }
}
