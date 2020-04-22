package de.psb.test;


import de.psb.sieve.*;

import java.util.HashMap;
import java.util.Map;

public class Test {

    private IPrimeSieve[] primeSieve;
    private Map<Integer, Integer> primeSieveTest;

    public void initialize() {
        primeSieve = new IPrimeSieve[]{
                new EratosthenesSieve(),
                new EratosthenesSieveCycleOptimized(),
                new EratosthenesSieveFullOptimized(),
                new BytePrimeSieveFullOptimized()
        };

        primeSieveTest = new HashMap<>();
        primeSieveTest = new HashMap<>();
        primeSieveTest.put(           10,        4);
        primeSieveTest.put(           13,        6);
        primeSieveTest.put(          100,       25);
        primeSieveTest.put(          743,      132);
        primeSieveTest.put(        1_000,      168);
        primeSieveTest.put(       10_000,     1229);
        primeSieveTest.put(       85_147,     8292);
        primeSieveTest.put(      100_000,     9592);
        primeSieveTest.put(    1_000_000,    78498);
        primeSieveTest.put(   10_000_000,   664579);
        primeSieveTest.put(  100_000_000,  5761455);
    }

    public void testEratosthenesSieve() {
        for (int key : primeSieveTest.keySet()) {
            //Assert.assertEquals(primeSieve[0].computePrimes(key).size(), (int) primeSieveTest.get(key));
        }
    }

    public void testEratosthenesSieveCycleOptimized() {
        for (int key : primeSieveTest.keySet()) {
            //Assert.assertEquals(primeSieve[1].computePrimes(key).size(), (int) primeSieveTest.get(key));
        }
    }

    public void testEratosthenesSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            //Assert.assertEquals(primeSieve[2].computePrimes(key).size(), (int) primeSieveTest.get(key));
        }
    }

    public void testBytePrimeSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            //Assert.assertEquals(primeSieve[3].computePrimes(key).size(), (int) primeSieveTest.get(key));
        }
    }

}
