import java.util.*;
public class main {
    //static int n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=1;
        int n=0;
        while (t<=10) {
            System.out.println("option 1: park");
            System.out.println("option 2: exit");
            System.out.println("option 3: show");
            String s=sc.next();
            
            if(s.equals("park")){
                if(n<6){
                    n+=1;
                    System.out.println("car is parked");
                }
                else System.out.println("parking is over loded");
                
            }
            if(s.equals("exit")){
                n-=1;
                System.out.println("car is exit succesfully");
            }
            if(s.equals("show")){
                if(n<6){
                    System.out.println("parking is avalible"+" ");
                    System.out.println(6-n);
                }
                else if(n>=6) System.out.println("Parking is full no more parking");
            }
            t++;
        }
        
    }
    
}
