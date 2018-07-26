package com.solarexsoft.jcip;

import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;

/**
 * Created by houruhou on 2018/7/17.
 */
public class CachedFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void doService(BigInteger req) {
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (req.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }

        if (factors == null) {
            factors = factor(req);
            synchronized (this) {
                lastNumber = req;
                lastFactors = factors.clone();
            }
        }
        WrapperResponse.wrapperResponse(factors);
    }

    private BigInteger[] factor(BigInteger req) {
        return new BigInteger[]{new BigInteger("11111"), new BigInteger("222222")};
    }

    public static class WrapperResponse {
        public static void wrapperResponse(BigInteger[] factors) {
            System.out.println(factors);
        }
    }

}
