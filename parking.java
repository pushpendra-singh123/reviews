import java.util.*;
public class parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 3;
        int a=0;
        int occupied=0;
        int [] arr = new int [total];
        while(a<10){
            System.out.println("What do you want in Parking System: ");
            System.out.println("option 1: Park");
            System.out.println("option 2: Exit");
            System.out.println("option 3: Show Vacancy");
            System.out.println("option 4: Quit");
            System.out.println("option 5:  Show Last Parked Car");
            System.out.print("Choose Your option: ");
            int n = sc.nextInt();
            if(n==1 && occupied<total){
                System.out.print("Enter your Car number: ");
                int b = sc.nextInt();
                arr[occupied]=b;
                System.out.println("Your car has been PARKED successfully");
                occupied++;
            }
            else if(n==1 && occupied==total){
                System.out.println("There is no empty Space");
            }
            if(n==2 && occupied>0){
                System.out.print("Enter Your car number: ");
                int b = sc.nextInt();
                // if(hm.containsKey(b)){
                //     hm.put(b,0);
                //     System.out.println("Your car has been UNPARKED successfully");
                //     occupied--;
                // }
                // else{
                //     System.out.println("There is No car with this number");

                // }
                arr[--occupied]=0;
                
                System.out.println("Your car has been UNPARKED successfully");

            }
            else if(n==2 && occupied==0){
                System.out.println("There is No car at this time in Parking Area");
            }
            if(n==3){
                System.out.print("There are Total Vacancies of Cars at this time is : ");
                System.out.println(total-occupied);
            }
            if(n==4){
                break;
            }
            if(n==5 && occupied>0){
                System.out.println("Last car parked is : " + arr[occupied-1]);
            }
            else if(n==5 && occupied==0){
                System.out.println("There is No car at this time in Parking Area");
            }
            System.out.println();


        }



    }
} 
