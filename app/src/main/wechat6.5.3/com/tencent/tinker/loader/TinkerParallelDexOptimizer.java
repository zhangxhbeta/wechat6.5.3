package com.tencent.tinker.loader;

import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public final class TinkerParallelDexOptimizer {

    private static class OptimizeWorker implements Runnable {
        private final File pGr;
        private final File pGs;
        private final AtomicInteger pGt;
        private final CountDownLatch pGu;
        private final ResultCallback pGv;

        OptimizeWorker(File file, File file2, AtomicInteger atomicInteger, CountDownLatch countDownLatch, ResultCallback resultCallback) {
            this.pGr = file;
            this.pGs = file2;
            this.pGt = atomicInteger;
            this.pGu = countDownLatch;
            this.pGv = resultCallback;
        }

        public void run() {
            try {
                if ((this.pGr == null || !this.pGr.exists()) && this.pGv != null) {
                    this.pGv.b(this.pGr, new IOException("dex file " + this.pGr.getAbsolutePath() + " is not exist!"));
                }
                if (this.pGv != null) {
                    this.pGv.J(this.pGr);
                }
                DexFile.loadDex(this.pGr.getAbsolutePath(), SharePatchFileUtil.i(this.pGr, this.pGs), 0);
                this.pGt.incrementAndGet();
                if (this.pGv != null) {
                    this.pGv.K(this.pGr);
                }
                this.pGu.countDown();
            } catch (Throwable e) {
                new StringBuilder("Failed to optimize dex: ").append(this.pGr.getAbsolutePath());
                if (this.pGv != null) {
                    this.pGv.b(this.pGr, e);
                }
                this.pGu.countDown();
            } catch (Throwable th) {
                this.pGu.countDown();
            }
        }
    }

    public interface ResultCallback {
        void J(File file);

        void K(File file);

        void b(File file, Throwable th);
    }

    public static synchronized boolean a(File[] fileArr, File file, ResultCallback resultCallback) {
        boolean a;
        synchronized (TinkerParallelDexOptimizer.class) {
            a = a(Arrays.asList(fileArr), file, new AtomicInteger(0), resultCallback);
        }
        return a;
    }

    public static synchronized boolean a(Collection<File> collection, File file, ResultCallback resultCallback) {
        boolean a;
        synchronized (TinkerParallelDexOptimizer.class) {
            a = a(collection, file, new AtomicInteger(0), resultCallback);
        }
        return a;
    }

    private static boolean a(Collection<File> collection, File file, AtomicInteger atomicInteger, ResultCallback resultCallback) {
        CountDownLatch countDownLatch = new CountDownLatch(collection.size());
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        long nanoTime = System.nanoTime();
        for (File optimizeWorker : collection) {
            newCachedThreadPool.submit(new OptimizeWorker(optimizeWorker, file, atomicInteger, countDownLatch, resultCallback));
        }
        try {
            countDownLatch.await();
            long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
            if (atomicInteger.get() == collection.size()) {
                new StringBuilder("All dexes are optimized successfully, cost: ").append(nanoTime2).append(" ms.");
                return true;
            }
            newCachedThreadPool.shutdown();
            return false;
        } catch (InterruptedException e) {
            return false;
        } finally {
            newCachedThreadPool.shutdown();
        }
    }
}
