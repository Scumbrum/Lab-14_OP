import java.util.ArrayList;
import java.util.function.LongBinaryOperator;

public class Counter {
    public static long countSumByFunction(long first,long number,long step){
        LongBinaryOperator last = (l1, l2) -> l1*(l2-1);
        LongBinaryOperator sum = (l1,l2) -> 2*l1+l2;
        LongBinaryOperator sumOfSequence = (l1,l2) -> l1*l2/2;
        long finish = last.applyAsLong(step,number);
        long leftOperand = sum.applyAsLong(first,finish);
        return sumOfSequence.applyAsLong(leftOperand,number);
    }

    public static long countSumByLoop(long first,long count,long step, Integer number) throws InterruptedException {
        long range = count/number;
        ArrayList<ArithmeticSequenceCounter> partitions = new ArrayList<>(number);
        long result = 0;
        long currElem =first;
        for (int i=0;i<number;i++){
            if(i==number-1){
                range=count-range*(number-1);
                partitions.add(new ArithmeticSequenceCounter(currElem,range-1,step));
                currElem+=range*step;
                continue;
            }
            partitions.add(new ArithmeticSequenceCounter(currElem,range-1,step));
            currElem+=range*step;
        }
        ArrayList<Thread> threads = new ArrayList<>(number);
        for (ArithmeticSequenceCounter partition:partitions){
            threads.add(new Thread(partition));
        }
        for (Thread thread:threads){
            thread.start();
        }
        for (Thread thread:threads){
            thread.join();
        }
        for (ArithmeticSequenceCounter partition:partitions){
            result+=partition.getResult();
        }
        return result;
    }
}
