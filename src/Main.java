import java.util.ArrayList;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int finish=3*10_000_000;
        long result=0;
        System.out.println("За допомогою формули:");
        System.out.println("<----------------------------->");
        long curr = System.currentTimeMillis();
        Counter.countSumByFunction(3,10_000_000_000L,3);
        System.out.print(System.currentTimeMillis()-curr);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("Метод <В лоб>:");
        long time;
        System.out.println("1 Потік:");
        System.out.println("<----------------------------->");
        time=countTime(1);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("2 Потоки:");
        System.out.println("<----------------------------->");
        time=countTime(2);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("4 Потоки:");
        System.out.println("<----------------------------->");
        time=countTime(4);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("8 Потоків:");
        System.out.println("<----------------------------->");
        time=countTime(8);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("16 Потоків:");
        System.out.println("<----------------------------->");
        time=countTime(16);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
        System.out.println("32 Потоки:");
        System.out.println("<----------------------------->");
        time=countTime(32);
        System.out.print(time);
        System.out.println("мс");
        System.out.println("<----------------------------->");
    }
    static long countTime(int number) throws InterruptedException {
        long curr = System.currentTimeMillis();
        Counter.countSumByLoop(3,10_000_000_000L,3,number);
        long result = System.currentTimeMillis()-curr;
        return result;
    }
}
