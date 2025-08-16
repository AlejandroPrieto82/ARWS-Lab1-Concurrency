
package eci.edu.arsw.threads;

public class CountThread extends Thread{
    private int A;
    private int B;

    public CountThread(int a, int b) {
        if(a < b){
            A = a;
            B = b;
        }else{
            A = b;
            B = a;
        }
    }

    public void run(){
        for (int i = A; i <= B; i++) {
            System.out.println(i);
        }
        System.out.println("");
    }
}
