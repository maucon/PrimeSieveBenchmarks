package de.psb.sieve;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve implements IPrimeSieve {

    @Override
    public List<Integer> computePrimes(int limit) {
        boolean[] sieve = new boolean[limit + 1];
        sieve[0] = sieve[1] = true;

        int sqrt = (int) Math.sqrt(limit);
        for (int i = 0; i <= sqrt; i++)
            if (!sieve[i])
                for (long j = i * 2; j <= limit; j += i)
                    sieve[(int) j] = true;

        List<Integer> primeList = new ArrayList<>();

        for (int i = 0; i <= limit; i++)
            if (!sieve[i])
                primeList.add(i);

        return primeList;
    }

}
// MemoryUsage (array only)     : limit+1/1000000 MB
// Example (Integer.MAX_VALUE-3): 2147,5 MB -> 2,1 GB