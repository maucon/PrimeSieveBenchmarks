package de.psb;

import de.psb.sieve.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SieveTest {

    private static IPrimeSieve[] primeSieve;
    private static Map<Integer, Integer> primeSieveTest;

    @BeforeAll
    static void initialize() {
        primeSieve = new IPrimeSieve[]{
                new EratosthenesSieve(),
                new EratosthenesSieveCycleOptimized(),
                new EratosthenesSieveMemoryOptimized(),
                new BytePrimeSieveCycleOptimized(),
                new BytePrimeSieveMemoryOptimized(),
        };

        primeSieveTest = new HashMap<>();
        primeSieveTest.put(         10,         4);
        primeSieveTest.put(         13,         6);
        primeSieveTest.put(        100,        25);
        primeSieveTest.put(        743,       132);
        primeSieveTest.put(      1_000,       168);
        primeSieveTest.put(     10_000,      1229);
        primeSieveTest.put(     85_147,      8292);
        primeSieveTest.put(    100_000,      9592);
        primeSieveTest.put(  1_000_000,     78498);
        primeSieveTest.put( 10_000_000,    664579);
        primeSieveTest.put(100_000_000,   5761455);
    }

    @Test
    @Order(1)
    public void EratosthenesSieve() {
        for (int key : primeSieveTest.keySet()) {
            assertEquals((int) primeSieveTest.get(key), primeSieve[0].computePrimes(key).size());
        }
    }

    @Test
    @Order(3)
    public void EratosthenesSieveCycleOptimized() {
        for (int key : primeSieveTest.keySet()) {
            assertEquals((int) primeSieveTest.get(key), primeSieve[1].computePrimes(key).size());
        }
    }

    @Test
    @Order(4)
    public void EratosthenesSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            assertEquals((int) primeSieveTest.get(key), primeSieve[2].computePrimes(key).size());
        }
    }

    @Test
    @Order(5)
    public void BytePrimeSieveCycleOptimized() {
        for (int key : primeSieveTest.keySet()) {
            assertEquals((int) primeSieveTest.get(key), primeSieve[3].computePrimes(key).size());
        }
    }

    @Test
    @Order(6)
    public void BytePrimeSieveFullOptimized() {
        for (int key : primeSieveTest.keySet()) {
            assertEquals((int) primeSieveTest.get(key), primeSieve[4].computePrimes(key).size());
        }
    }

}
