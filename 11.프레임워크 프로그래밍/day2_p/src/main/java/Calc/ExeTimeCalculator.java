package Calc;

//얘가 proxy 이다
public class ExeTimeCalculator implements Calculator{

    private Calculator delegate;

    public ExeTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.printf("실행시간 %d%n", end - start);
        return result;
    }
}
