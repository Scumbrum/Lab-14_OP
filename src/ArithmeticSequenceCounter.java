public class ArithmeticSequenceCounter implements Runnable{
    private Long begin;
    private Long number;
    private Long step;
    private Long result;
    public ArithmeticSequenceCounter(Long begin,Long number,Long step){
        this.begin=begin;
        this.number=number;
        this.step=step;
    }
    @Override
    public void run() {
        long curr=begin;
        long result=begin;
        for(long i=0;i<number;i++){
            curr+=step;
            result+=curr;

        }
        this.result=result;
    }

    public Long getResult() {
        return result;
    }
}
