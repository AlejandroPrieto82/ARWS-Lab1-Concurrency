
package eci.edu.arsw.threads;

public class CountThreadsMain {
    
    public static void main(String a[]){
        CountThread count1 = new CountThread(0, 99);
        CountThread count2 = new CountThread(99, 199);
        CountThread count3 = new CountThread(200, 299);
        count1.start();
        count2.start();
        count3.start();
    }
    
}
