package com.google.android.gms.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.c.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
    private static boolean aeZ = false;
    h aeT;
    d aeU;
    boolean aeV;
    Object aeW = new Object();
    b aeX;
    final long aeY;
    private final Context mContext;

    public static final class a {
        public final String afa;
        public final boolean afb;

        public a(String str, boolean z) {
            this.afa = str;
            this.afb = z;
        }

        public final String toString() {
            return "{" + this.afa + "}" + this.afb;
        }
    }

    static class b extends Thread {
        private WeakReference<a> afc;
        private long afd;
        CountDownLatch afe = new CountDownLatch(1);
        boolean aff = false;

        public b(a aVar, long j) {
            this.afc = new WeakReference(aVar);
            this.afd = j;
            start();
        }

        private void disconnect() {
            a aVar = (a) this.afc.get();
            if (aVar != null) {
                aVar.finish();
                this.aff = true;
            }
        }

        public final void run() {
            try {
                if (!this.afe.await(this.afd, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    private a(Context context) {
        w.Z(context);
        this.mContext = context;
        this.aeV = false;
        this.aeY = -1;
    }

    private static d a(h hVar) {
        try {
            return com.google.android.gms.c.d.a.n(hVar.kt());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void hh() {
        w.W("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.aeV) {
                finish();
            }
            this.aeT = p(this.mContext);
            this.aeU = a(this.aeT);
            this.aeV = true;
        }
    }

    private a hi() {
        a aVar;
        w.W("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.aeV) {
                synchronized (this.aeW) {
                    if (this.aeX == null || !this.aeX.aff) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    hh();
                    if (!this.aeV) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            w.Z(this.aeT);
            w.Z(this.aeU);
            aVar = new a(this.aeU.getId(), this.aeU.ac(true));
        }
        synchronized (this.aeW) {
            if (this.aeX != null) {
                this.aeX.afe.countDown();
                try {
                    this.aeX.join();
                } catch (InterruptedException e3) {
                }
            }
            if (this.aeY > 0) {
                this.aeX = new b(this, this.aeY);
            }
        }
        return aVar;
    }

    private static h p(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (aeZ) {
                com.google.android.gms.common.b.iZ();
                switch (com.google.android.gms.common.b.v(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                e.x(context);
            } catch (c e) {
                throw new IOException(e);
            }
            h hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.stats.b.kr().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                IOException iOException = new IOException(th);
            }
        } catch (NameNotFoundException e2) {
            throw new c(9);
        }
    }

    public static a q(Context context) {
        a aVar = new a(context);
        try {
            aVar.hh();
            a hi = aVar.hi();
            return hi;
        } finally {
            aVar.finish();
        }
    }

    protected final void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.w.W(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r3.aeT;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.aeV;	 Catch:{ IllegalArgumentException -> 0x002e }
        if (r0 == 0) goto L_0x0020;
    L_0x0015:
        r0 = com.google.android.gms.common.stats.b.kr();	 Catch:{ IllegalArgumentException -> 0x002e }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002e }
        r2 = r3.aeT;	 Catch:{ IllegalArgumentException -> 0x002e }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002e }
    L_0x0020:
        r0 = 0;
        r3.aeV = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aeU = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aeT = r0;	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.a.a.finish():void");
    }
}
