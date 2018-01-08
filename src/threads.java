import java.lang.*;
public class threads
{
    public static class PrimeCalculator extends Thread
    {
        int offset;
        int threads;

        public PrimeCalculator(int offset, int threads)
        {
            this.offset = offset;
            this.threads = threads;
        }

        public void run()
        {
            System.out.print("< ");
            int primeCounter = 0;
            boolean isPrime;
            for (int i = 3 + offset; i < 10000000; i += threads * 2)
            {
                isPrime = true;

                for (int j = 3; j < Math.sqrt(i); j++)
                {
                    if (i % j == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) primeCounter++;
            }
            System.out.print("> ");
        }
    }

    public static void main(String[] args)
    {
        int noOfThreads =3;

        PrimeCalculator pc[] = new PrimeCalculator[noOfThreads];

        double start = System.currentTimeMillis();

        for (int t = 0; t < noOfThreads; t++)
        {
            pc[t] = new PrimeCalculator(t * 2, noOfThreads);
            pc[t].start();
        }

        try
        {
            for(int t = 0; t < noOfThreads; t++)
            {
                pc[t].join();
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        System.out.println(((System.currentTimeMillis() - start) / 1000) + " seconds");
    }
}
