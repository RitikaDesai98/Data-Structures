import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Prime
{
   public static void main (String[] args)
   {		
      int i = 0;
      int num = 0;
      int n = 10000;
      double time1 = 0.0;
      double time2 = 0.0;
      double time = 0.0;
      String  primeNumbers = "";
      int no = 0;

      while(n<=100000)
      {

         time1 = Instant.now().getEpochSecond();
         for (i = 2; i <= n; i++)         
         { 		  	  
            int counter = 0; 	  
            
            for(num = i; num >= 1; num--)
            {
               if(i%num == 0)
               {
                  counter = counter + 1;
               }            
            }
            if (counter == 2)
            {
               no++;
               primeNumbers = primeNumbers + i + " ";
            }	
         }
         time2 = Instant.now().getEpochSecond();
         time = time2 - time1;
         System.out.println("Prime numbers from 2 to " + n + " are :" + primeNumbers);
         System.out.println("The number of primes found: "+ no);
         System.out.println("The time taken: "+ time + " seconds");
         n = n + 10000;
         no = 0;
      }
   }
}
