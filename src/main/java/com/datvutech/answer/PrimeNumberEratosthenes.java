package com.datvutech.answer;

public class PrimeNumberEratosthenes {
    private boolean[] primes;
    private int n;
    private boolean sieved = false;

    public PrimeNumberEratosthenes(int n) {
        this.n = n;
        primes = new boolean[n + 1];
    }

    private void sieve() {
        for (int i = 0; i <= n; ++i) {
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i <= this.n; ++i) {
            if (primes[i]) {
                for (int j = i * i; j <= this.n; j += i)
                    primes[j] = false;
            }
        }
        sieved = true;
    }

    public boolean isPrime(int x) {
        if (!sieved) {
            sieve();
        }
        return x < 0 ? false : primes[x];
    }
}
