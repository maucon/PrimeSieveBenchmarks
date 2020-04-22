package de.psb.sieve;

import java.util.ArrayList;
import java.util.List;

public class BytePrimeSieveMemoryOptimized implements IPrimeSieve {

    @Override
    public List<Integer> computePrimes(int limit) {
        List<Integer> primeList = new ArrayList<>();

        byte[] byteSieve = new byte[limit / 16 + 1];
        int sqrt = (int) Math.sqrt(limit);

        if (limit >= 2) primeList.add(2);

        for (int i = 3; i <= sqrt; i += 2)
            if ((byteSieve[i / 16] & (1 << ((i / 2) % 8))) == 0) {
                primeList.add(i);
                for (long j = i * i; j <= limit; j += i << 1)
                    byteSieve[(int) j / 16] = (byte) (byteSieve[(int) j / 16] | (1 << ((j / 2) % 8)));
            }

        for (int i = (sqrt & 1) == 0 ? sqrt + 1 : sqrt + 2; i <= limit; i += 2)
            if ((byteSieve[i / 16] & (1 << ((i / 2) % 8))) == 0)
                primeList.add(i);

        return primeList;
    }

}
// MemoryUsage (array only)     : (limit/16+1)/1000000 MB
// Example (Integer.MAX_VALUE-3): 134,2 MB -> 0,1 GB