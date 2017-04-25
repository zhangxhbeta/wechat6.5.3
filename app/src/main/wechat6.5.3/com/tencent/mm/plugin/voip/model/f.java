package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class f {
    private static f ksu = new f();
    private ReentrantLock aPI = new ReentrantLock();
    private e ksv;

    private f() {
    }

    public static e bbN() {
        if (ksu.ksv == null) {
            ksu.aPI.lock();
            try {
                if (ksu.ksv == null) {
                    ksu.ksv = new e();
                }
                ksu.aPI.unlock();
            } catch (Throwable th) {
                ksu.aPI.unlock();
            }
        }
        return ksu.ksv;
    }
}
