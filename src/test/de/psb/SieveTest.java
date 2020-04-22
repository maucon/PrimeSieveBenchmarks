package de.psb;


import de.psb.sieve.*;
import org.junit.jupiter.api.*;

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
                new BytePrimeSieveFullOptimized(),
                new BytePrimeSieveCycleOptimized(),
        };

        primeSieveTest = new HashMap<>();
        primeSieveTest.put(10, 4);
        primeSieveTest.put(13, 6);
        primeSieveTest.put(100, 25);
        primeSieveTest.put(743, 132);
        primeSieveTest.put(1_000, 168);
        primeSieveTest.put(10_000, 1229);
        primeSieveTest.put(85_147, 8292);
        primeSieveTest.put(100_000, 9592);
        primeSieveTest.put(1_000_000, 78498);
        primeSieveTest.put(10_000_000, 664579);
        primeSieveTest.put(100_000_000, 5761455);
        primeSieveTest.put(1_000_000_000, 50847534);
        primeSieveTest.put(2_000_000_000, 98222287);
        primeSieveTest.put(Integer.MAX_VALUE - 3, 105097564);
    }

    @Nested
    @DisplayName("Tests with small numbers (10000)")
    class Small {

        private static final int limit = 10_000;

        @RepeatedTest(5)
        public void testEratosthenesSieve() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }
    }

    @Nested
    @DisplayName("Tests with medium numbers (100_000_000)")
    class Medium {

        private static final int limit = 100_000_000;

        @RepeatedTest(5)
        public void testEratosthenesSieve() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }
    }


    @Disabled
    @Nested
    @DisplayName("Tests with big numbers (Integer.MAX_VALUE - 3)")
    class Large {

        private static final int limit = Integer.MAX_VALUE - 3;

        @RepeatedTest(5)
        public void testEratosthenesSieve() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testEratosthenesSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveFullOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @RepeatedTest(5)
        public void testBytePrimeSieveCycleOptimized() {
            Assertions.assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }
    }
}
