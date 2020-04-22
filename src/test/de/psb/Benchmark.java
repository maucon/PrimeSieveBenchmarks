package de.psb;

import de.psb.sieve.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Benchmark {

    private static IPrimeSieve[] primeSieve;
    private static Map<Integer, Integer> primeSieveTest;

    @BeforeAll
    public static void initialize() {
        primeSieve = new IPrimeSieve[]{
                new EratosthenesSieve(),
                new EratosthenesSieveCycleOptimized(),
                new EratosthenesSieveMemoryOptimized(),
                new BytePrimeSieveCycleOptimized(),
                new BytePrimeSieveMemoryOptimized(),
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

    @AfterEach
    public void garbageCollect() {
        System.gc();
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Tests with small numbers (10.000)")
    class Small {

        private static final int limit = 10_000;

        @Order(0)
        @RepeatedTest(5)
        public void EratosthenesSieve() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @Order(1)
        @RepeatedTest(5)
        public void EratosthenesSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @Order(2)
        @RepeatedTest(5)
        public void EratosthenesSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @Order(3)
        @RepeatedTest(5)
        public void BytePrimeSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @Order(4)
        @RepeatedTest(5)
        public void BytePrimeSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Tests with medium numbers (100.000.000)")
    class Medium {

        private static final int limit = 100_000_000;

        @Order(0)
        @RepeatedTest(5)
        public void EratosthenesSieve() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @Order(1)
        @RepeatedTest(5)
        public void EratosthenesSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @Order(2)
        @RepeatedTest(5)
        public void EratosthenesSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @Order(3)
        @RepeatedTest(5)
        public void BytePrimeSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @Order(4)
        @RepeatedTest(5)
        public void BytePrimeSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Tests with big numbers (Integer.MAX_VALUE - 3)")
    class Large {

        private static final int limit = Integer.MAX_VALUE - 3;

        @Order(0)
        @RepeatedTest(5)
        public void EratosthenesSieve() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[0].computePrimes(limit).size());
        }

        @Order(1)
        @RepeatedTest(5)
        public void EratosthenesSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[1].computePrimes(limit).size());
        }

        @Order(2)
        @RepeatedTest(5)
        public void EratosthenesSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[2].computePrimes(limit).size());
        }

        @Order(3)
        @RepeatedTest(5)
        public void BytePrimeSieveCycleOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[3].computePrimes(limit).size());
        }

        @Order(4)
        @RepeatedTest(5)
        public void BytePrimeSieveMemoryOptimized() {
            assertEquals((int) primeSieveTest.get(limit), primeSieve[4].computePrimes(limit).size());
        }

    }

}
