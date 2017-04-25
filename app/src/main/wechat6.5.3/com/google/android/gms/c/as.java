package com.google.android.gms.c;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public final class as {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private final String aql;
    public final WakeLock azQ;
    private WorkSource azR;
    private final int azS;
    private final String azT;
    private boolean azU;
    private int azV;
    private int azW;
    private final Context mContext;

    private as(Context context, int i, String str) {
        this.azU = true;
        w.i(str, "Wake lock name can NOT be empty");
        this.azS = 1;
        this.aql = str;
        this.azT = null;
        this.mContext = context.getApplicationContext();
        this.azQ = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        if (ac.K(this.mContext)) {
            String str2;
            if (!ab.ah(null)) {
                str2 = null;
            } else if (f.aob && j.isInitialized()) {
                new StringBuilder("callingPackage is not supposed to be empty for wakelock ").append(this.aql).append("!");
                str2 = "com.google.android.gms";
            } else {
                str2 = context.getPackageName();
            }
            this.azR = ac.i(context, str2);
            WorkSource workSource = this.azR;
            if (ac.K(this.mContext) && workSource != null) {
                if (this.azR != null) {
                    this.azR.add(workSource);
                } else {
                    this.azR = workSource;
                }
                this.azQ.setWorkSource(this.azR);
            }
        }
    }

    public as(Context context, String str) {
        this(context, 1, str);
    }

    private boolean ai(String str) {
        Object obj = null;
        return (TextUtils.isEmpty(obj) || obj.equals(this.azT)) ? false : true;
    }

    private String g(String str, boolean z) {
        return this.azU ? z ? null : this.azT : this.azT;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lc() {
        /*
        r7 = this;
        r3 = 0;
        r0 = 14;
        r0 = com.google.android.gms.c.z.bR(r0);
        if (r0 != 0) goto L_0x0024;
    L_0x0009:
        r0 = r7.azU;
        if (r0 == 0) goto L_0x0024;
    L_0x000d:
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
        r1.<init>(r2);
        r2 = r7.aql;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.wtf(r0, r1);
    L_0x0024:
        r0 = r7.ai(r3);
        r4 = r7.g(r3, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0085;
    L_0x0030:
        r1 = new java.lang.StringBuilder;
        r2 = "Acquire:\n mWakeLockName: ";
        r1.<init>(r2);
        r2 = r7.aql;
        r1 = r1.append(r2);
        r2 = "\n mSecondaryName: ";
        r1 = r1.append(r2);
        r2 = r7.azT;
        r1 = r1.append(r2);
        r2 = "\nmReferenceCounted: ";
        r1 = r1.append(r2);
        r2 = r7.azU;
        r1 = r1.append(r2);
        r2 = "\nreason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = "\nmOpenEventCount";
        r1 = r1.append(r2);
        r2 = r7.azW;
        r1 = r1.append(r2);
        r2 = "\nuseWithReason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = "\ntrackingName: ";
        r1 = r1.append(r2);
        r1.append(r4);
    L_0x0085:
        monitor-enter(r7);
        r1 = r7.azU;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x0094;
    L_0x008a:
        r1 = r7.azV;	 Catch:{ all -> 0x00c4 }
        r2 = r1 + 1;
        r7.azV = r2;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x009c;
    L_0x0092:
        if (r0 != 0) goto L_0x009c;
    L_0x0094:
        r0 = r7.azU;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x00bb;
    L_0x0098:
        r0 = r7.azW;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x00bb;
    L_0x009c:
        com.google.android.gms.common.stats.h.ks();	 Catch:{ all -> 0x00c4 }
        r0 = r7.mContext;	 Catch:{ all -> 0x00c4 }
        r1 = r7.azQ;	 Catch:{ all -> 0x00c4 }
        r1 = com.google.android.gms.common.stats.f.a(r1, r4);	 Catch:{ all -> 0x00c4 }
        r2 = 7;
        r3 = r7.aql;	 Catch:{ all -> 0x00c4 }
        r5 = r7.azS;	 Catch:{ all -> 0x00c4 }
        r6 = r7.azR;	 Catch:{ all -> 0x00c4 }
        r6 = com.google.android.gms.c.ac.b(r6);	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.common.stats.h.a(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00c4 }
        r0 = r7.azW;	 Catch:{ all -> 0x00c4 }
        r0 = r0 + 1;
        r7.azW = r0;	 Catch:{ all -> 0x00c4 }
    L_0x00bb:
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r7.azQ;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.acquire(r2);
        return;
    L_0x00c4:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.as.lc():void");
    }

    public final void ld() {
        this.azQ.setReferenceCounted(false);
        this.azU = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r7 = this;
        r3 = 0;
        r0 = r7.ai(r3);
        r4 = r7.g(r3, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0062;
    L_0x000d:
        r1 = new java.lang.StringBuilder;
        r2 = "Release:\n mWakeLockName: ";
        r1.<init>(r2);
        r2 = r7.aql;
        r1 = r1.append(r2);
        r2 = "\n mSecondaryName: ";
        r1 = r1.append(r2);
        r2 = r7.azT;
        r1 = r1.append(r2);
        r2 = "\nmReferenceCounted: ";
        r1 = r1.append(r2);
        r2 = r7.azU;
        r1 = r1.append(r2);
        r2 = "\nreason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = "\n mOpenEventCount";
        r1 = r1.append(r2);
        r2 = r7.azW;
        r1 = r1.append(r2);
        r2 = "\nuseWithReason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = "\ntrackingName: ";
        r1 = r1.append(r2);
        r1.append(r4);
    L_0x0062:
        monitor-enter(r7);
        r1 = r7.azU;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0071;
    L_0x0067:
        r1 = r7.azV;	 Catch:{ all -> 0x00a1 }
        r1 = r1 + -1;
        r7.azV = r1;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x007a;
    L_0x006f:
        if (r0 != 0) goto L_0x007a;
    L_0x0071:
        r0 = r7.azU;	 Catch:{ all -> 0x00a1 }
        if (r0 != 0) goto L_0x009a;
    L_0x0075:
        r0 = r7.azW;	 Catch:{ all -> 0x00a1 }
        r1 = 1;
        if (r0 != r1) goto L_0x009a;
    L_0x007a:
        com.google.android.gms.common.stats.h.ks();	 Catch:{ all -> 0x00a1 }
        r0 = r7.mContext;	 Catch:{ all -> 0x00a1 }
        r1 = r7.azQ;	 Catch:{ all -> 0x00a1 }
        r1 = com.google.android.gms.common.stats.f.a(r1, r4);	 Catch:{ all -> 0x00a1 }
        r2 = 8;
        r3 = r7.aql;	 Catch:{ all -> 0x00a1 }
        r5 = r7.azS;	 Catch:{ all -> 0x00a1 }
        r6 = r7.azR;	 Catch:{ all -> 0x00a1 }
        r6 = com.google.android.gms.c.ac.b(r6);	 Catch:{ all -> 0x00a1 }
        com.google.android.gms.common.stats.h.a(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00a1 }
        r0 = r7.azW;	 Catch:{ all -> 0x00a1 }
        r0 = r0 + -1;
        r7.azW = r0;	 Catch:{ all -> 0x00a1 }
    L_0x009a:
        monitor-exit(r7);	 Catch:{ all -> 0x00a1 }
        r0 = r7.azQ;
        r0.release();
        return;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00a1 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.as.release():void");
    }
}
