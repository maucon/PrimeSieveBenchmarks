package de.psb.sieve;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieveCycleOptimized implements IPrimeSieve {

    @Override
    public List<Integer> computePrimes(int limit) {
        List<Integer> primeList = new ArrayList<>();

        boolean[] sieve = new boolean[limit + 1];
        int sqrt = (int) Math.sqrt(limit);

        if (limit >= 2) primeList.add(2);

        for (int i = 3; i <= sqrt; i += 2)
            if (!sieve[i]) {
                primeList.add(i);
                for (long j = i * i; j <= limit; j += i << 1)
                    sieve[(int) j] = true;
            }

        for (int i = (sqrt & 1) == 0 ? sqrt + 1 : sqrt + 2; i <= limit; i += 2)
            if (!sieve[i])
                primeList.add(i);

        return primeList;
    }

}
// MemoryUsage (array only)     : limit+1/1000000 MB
// Example (Integer.MAX_VALUE-3): 2147,5 MB -> 2,1 GB