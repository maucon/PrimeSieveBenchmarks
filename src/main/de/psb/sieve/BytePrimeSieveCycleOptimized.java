package de.psb.sieve;

import java.util.ArrayList;
import java.util.List;

public class BytePrimeSieveCycleOptimized implements IPrimeSieve {

    @Override
    public List<Integer> computePrimes(int limit) {
        List<Integer> primeList = new ArrayList<>();

        byte[] byteSieve = new byte[limit / 8 + 1];
        int sqrt = (int) Math.sqrt(limit);

        if (limit >= 2) primeList.add(2);

        for (int i = 3; i <= sqrt; i += 2)
            if ((byteSieve[i / 8] & (1 << (i % 8))) == 0) {
                primeList.add(i);
                for (long j = i * i; j <= limit; j += i << 1)
                    byteSieve[(int) j / 8] = (byte) (byteSieve[(int) j / 8] | (1 << (j % 8)));
            }

        for (int i = (sqrt & 1) == 0 ? sqrt + 1 : sqrt + 2; i <= limit; i += 2)
            if ((byteSieve[i / 8] & (1 << (i % 8))) == 0)
                primeList.add(i);

        return primeList;
    }

}
// MemoryUsage (array only)     : (limit/8+1)/1000000 MB
// Example (Integer.MAX_VALUE-3): 268,4 MB -> 0,3 GB