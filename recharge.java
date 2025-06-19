import java.util.*;
public class recharge{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        boolean next = true;
        
        while(true){
            while(next){
            System.out.println("1. jio recharge");
            System.out.println("2. airtel recharge");
            System.out.println("3. bsnl recharge");
            System.out.println("4. total balance check");
            System.out.println("Enter your sim : " );
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("jio recharge successfull");
                total += 399;
            }
            if(choice == 2){
                System.out.println("airtel recharge successfull");
                total += 299;
            }
            if(choice == 3){
                System.out.println("bsnl recharge successfull");
                total += 199;
            }
            if(choice == 4){
                System.out.println("your total balance till ="+ total);
                
            }
            next = scanner.nextBoolean();
            if(next == false){
                System.out.println("not want to recharge");
                break;
            }
            
            

            

            }
            
        }
         
    }
}
