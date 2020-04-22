package de.psb.sieve;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve implements IPrimeSieve {

    @Override
    public List<Integer> computePrimes(int limit) {
        boolean[] sieve = new boolean[limit + 1];
        sieve[0] = sieve[1] = true;

        for (int i = 0; i * i <= limit; i++)
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
