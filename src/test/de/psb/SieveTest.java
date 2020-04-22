package de.psb;


import de.psb.sieve.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SieveTest {

    private static IPrimeSieve[] primeSieve;
    private static Map<Integer, Integer> primeSieveTest;

    @BeforeAll
    static void initialize() {
        primeSieve = new IPrimeSieve[]{
                new EratosthenesSieve(),
                new EratosthenesSieveCycleOptimized(),
                new EratosthenesSieveFullOptimized(),
                new BytePrimeSieveFullOptimized()
        };

        primeSieveTest = new HashMap<>();
        primeSieveTest.put(         10,       4);
        primeSieveTest.put(         13,       6);
        primeSieveTest.put(        100,      25);
        primeSieveTest.put(        743,     132);
        primeSieveTest.put(      1_000,     168);
        primeSieveTest.put(     10_000,    1229);
        primeSieveTest.put(     85_147,    8292);
        primeSieveTest.put(    100_000,    9592);
        primeSieveTest.put(  1_000_000,   78498);
        primeSieveTest.put( 10_000_000,  664579);
        primeSieveTest.put(100_000_000, 5761455);
//        primeSieveTest.put(1_000_000_000, 50847534);
//        primeSieveTest.put(2_000_000_000, 98222287);
        primeSieveTest.put(Integer.MAX_VALUE - 3, 105097564);
    }

    @Test
    public void testEratosthenesSieve() {
        for (int key : primeSieveTest.keySet()) {
            Assertions.assertEquals((int) primeSieveTest.get(key), primeSieve[0].computePrimes(key).size());
        }
    }

    @Test
    public void testEratosthenesSieveCycleOptimized() {
        for (int key : primeSieveTest.keySet()) {
            Assertions.assertEquals((int) primeSieveTest.get(key), primeSieve[1].computePrimes(key).size());
        }
    }

    @Test
    public void testEratosthenesSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            Assertions.assertEquals((int) primeSieveTest.get(key), primeSieve[2].computePrimes(key).size());
        }
    }

    @Test
    public void testBytePrimeSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            Assertions.assertEquals((int) primeSieveTest.get(key), primeSieve[3].computePrimes(key).size());
        }
    }

}
