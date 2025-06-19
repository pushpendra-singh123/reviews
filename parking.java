import java.util.*;
public class parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 3;
        int a=0;
        int occupied=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(a<10){
            System.out.println("What do you want in Parking System");
            System.out.println("option 1: Park");
            System.out.println("option 2: Exit");
            System.out.println("option 3: Show Vacancy");
            System.out.println("Quit");
            System.out.print("Enter the option: ");
            int n = sc.nextInt();
            if(n==1 && occupied<total){
                System.out.print("Enter Your car number: ");
                int b = sc.nextInt();
                hm.put(b,1);
                System.out.println("Your car has been PARKED successfully");
                occupied++;
            }
            else if(n==1 && occupied==total){
                System.out.println("There is no empty Space");
            }
            if(n==2 && occupied>0){
                System.out.print("Enter Your car number: ");
                int b = sc.nextInt();
                if(hm.containsKey(b)){
                    hm.put(b,0);
                    System.out.println("Your car has been UNPARKED successfully");
                    occupied--;
                }
                else{
                    System.out.println("There is no car with this number");

                }

            }
            else if(n==2 && occupied==0){
                System.out.println("There is no car at this time in parking area");
            }
            if(n==3){
                System.out.print("There are total empty spaces are : ");
                System.out.println(total-occupied);
            }
            if(n==4){
                break;
            }
            System.out.println();


        }



    }
} 
