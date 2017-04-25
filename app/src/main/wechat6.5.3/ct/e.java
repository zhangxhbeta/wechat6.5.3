package ct;

import android.content.SharedPreferences;
import ct.b.a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class e implements a, n, Runnable {
    private Set a = null;
    private BlockingQueue b = null;
    private q c;

    public e() {
        bd.a();
        this.a = new CopyOnWriteArraySet();
        this.a.add("dispatcher.3g.qq.com");
        this.b = new ArrayBlockingQueue(10);
        this.c = r.a();
        try {
            if (c()) {
                a(true);
            } else {
                a(false);
            }
        } catch (Exception e) {
        }
        j.a().a((n) this);
    }

    private void a(boolean z) {
        try {
            new StringBuilder("before add, queue size:").append(this.b.size());
            bd.a();
            this.b.add(new i(z));
            bd.a();
        } catch (Throwable th) {
            bd.d();
        }
        new StringBuilder("after add, queue size:").append(this.b.size());
        bd.a();
    }

    private static boolean c() {
        try {
            SharedPreferences sharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
            if (sharedPreferences == null) {
                return false;
            }
            if (System.currentTimeMillis() - sharedPreferences.getLong("lastScheduleTime", 0) <= 86400000) {
                return false;
            }
            sharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
            bd.a();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final ao a() {
        return a.b().b.f;
    }

    public final t.a a(String str) {
        if (this.a.contains(str)) {
            t.a a = u.a().a(str);
            if (a != null) {
                if (!a.b()) {
                    return a;
                }
                bd.c();
                a(true);
            }
        }
        return null;
    }

    public final void a(List list) {
        if (list != null) {
            try {
                for (String add : list) {
                    this.a.add(add);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void b() {
        bd.b();
        a(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r7 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        ct.bd.b();
        ct.u.a();	 Catch:{ Throwable -> 0x003f }
    L_0x000b:
        ct.bd.a();	 Catch:{ Throwable -> 0x003f }
        r0 = r8.b;	 Catch:{ Throwable -> 0x003f }
        r0 = r0.take();	 Catch:{ Throwable -> 0x003f }
        r0 = (ct.i) r0;	 Catch:{ Throwable -> 0x003f }
        ct.bd.a();	 Catch:{ Throwable -> 0x003f }
        r0 = r0.a;	 Catch:{ Throwable -> 0x003f }
        ct.bd.b();	 Catch:{ Exception -> 0x0035 }
        r1 = ct.bc.a();	 Catch:{ Exception -> 0x0035 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0035 }
        if (r2 != 0) goto L_0x0031;
    L_0x0028:
        r2 = "unknown";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0035 }
        if (r1 == 0) goto L_0x0037;
    L_0x0031:
        ct.bd.c();	 Catch:{ Exception -> 0x0035 }
        goto L_0x000b;
    L_0x0035:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0037:
        r1 = ct.h.a;	 Catch:{ Exception -> 0x0035 }
        if (r1 != 0) goto L_0x0041;
    L_0x003b:
        ct.bd.b();	 Catch:{ Exception -> 0x0035 }
        goto L_0x000b;
    L_0x003f:
        r0 = move-exception;
        return;
    L_0x0041:
        if (r0 != 0) goto L_0x005e;
    L_0x0043:
        r0 = ct.u.a();	 Catch:{ Exception -> 0x0035 }
        r1 = r8.a;	 Catch:{ Exception -> 0x0035 }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x0035 }
        r1 = c();	 Catch:{ Exception -> 0x0035 }
        if (r0 != 0) goto L_0x0055;
    L_0x0053:
        if (r1 == 0) goto L_0x005c;
    L_0x0055:
        r0 = 1;
    L_0x0056:
        if (r0 != 0) goto L_0x005e;
    L_0x0058:
        ct.bd.b();	 Catch:{ Exception -> 0x0035 }
        goto L_0x000b;
    L_0x005c:
        r0 = 0;
        goto L_0x0056;
    L_0x005e:
        r0 = new ct.f;	 Catch:{ Exception -> 0x0035 }
        r0.<init>();	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.b;	 Catch:{ Exception -> 0x0035 }
        r0.b = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.c;	 Catch:{ Exception -> 0x0035 }
        r0.c = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.d;	 Catch:{ Exception -> 0x0035 }
        r0.d = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.g;	 Catch:{ Exception -> 0x0035 }
        r0.a = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.f;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.p.e;	 Catch:{ Exception -> 0x0035 }
        r0.e = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = r8.a;	 Catch:{ Exception -> 0x0035 }
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0035 }
        r2.<init>();	 Catch:{ Exception -> 0x0035 }
        r0.h = r2;	 Catch:{ Exception -> 0x0035 }
        r2 = r0.h;	 Catch:{ Exception -> 0x0035 }
        r2.addAll(r1);	 Catch:{ Exception -> 0x0035 }
        r1 = ct.bc.a();	 Catch:{ Exception -> 0x0035 }
        r0.g = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.bc.c();	 Catch:{ Exception -> 0x0035 }
        r0.i = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = ct.bc.d();	 Catch:{ Exception -> 0x0035 }
        r0.j = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = r0.a();	 Catch:{ Exception -> 0x0035 }
        if (r1 == 0) goto L_0x011a;
    L_0x009f:
        r2 = ct.u.a();	 Catch:{ Exception -> 0x0035 }
        r3 = r1.a;	 Catch:{ Exception -> 0x0035 }
        r2.a(r3);	 Catch:{ Exception -> 0x0035 }
        r2 = ct.b.a.b();	 Catch:{ Exception -> 0x0035 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0035 }
        if (r3 == 0) goto L_0x010b;
    L_0x00b0:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
        r5 = "updateSdkCfInfo...SdkCfgInfo:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0035 }
        r4.append(r3);	 Catch:{ Exception -> 0x0035 }
        ct.bd.b();	 Catch:{ Exception -> 0x0035 }
        r4 = r3.a;	 Catch:{ Exception -> 0x0035 }
        if (r4 < r6) goto L_0x00c6;
    L_0x00c2:
        r4 = r3.a;	 Catch:{ Exception -> 0x0035 }
        if (r4 <= r7) goto L_0x00e1;
    L_0x00c6:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
        r5 = "updateSdkCfInfo...connectTimeout:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0035 }
        r5 = r3.a;	 Catch:{ Exception -> 0x0035 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0035 }
        r5 = " is checked to 20s";
        r4.append(r5);	 Catch:{ Exception -> 0x0035 }
        ct.bd.c();	 Catch:{ Exception -> 0x0035 }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r3.a = r4;	 Catch:{ Exception -> 0x0035 }
    L_0x00e1:
        r4 = r3.b;	 Catch:{ Exception -> 0x0035 }
        if (r4 < r6) goto L_0x00e9;
    L_0x00e5:
        r4 = r3.b;	 Catch:{ Exception -> 0x0035 }
        if (r4 <= r7) goto L_0x0104;
    L_0x00e9:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
        r5 = "updateSdkCfInfo...readTimeout:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0035 }
        r5 = r3.b;	 Catch:{ Exception -> 0x0035 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0035 }
        r5 = " is checked to 20s";
        r4.append(r5);	 Catch:{ Exception -> 0x0035 }
        ct.bd.c();	 Catch:{ Exception -> 0x0035 }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r3.b = r4;	 Catch:{ Exception -> 0x0035 }
    L_0x0104:
        r2.b = r3;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.b;	 Catch:{ Exception -> 0x0035 }
        r2.b();	 Catch:{ Exception -> 0x0035 }
    L_0x010b:
        r2 = ct.b.a.b();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.c;	 Catch:{ Exception -> 0x0035 }
        if (r1 == 0) goto L_0x011a;
    L_0x0113:
        r2.a = r1;	 Catch:{ Exception -> 0x0035 }
        r1 = r2.a;	 Catch:{ Exception -> 0x0035 }
        r1.b();	 Catch:{ Exception -> 0x0035 }
    L_0x011a:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
        r2 = "scheduler...end. apn:";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = r0.g;	 Catch:{ Exception -> 0x0035 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = ", retCode:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = r0.k;	 Catch:{ Exception -> 0x0035 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = ",failInfo:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = r0.l;	 Catch:{ Exception -> 0x0035 }
        r1.append(r2);	 Catch:{ Exception -> 0x0035 }
        ct.bd.b();	 Catch:{ Exception -> 0x0035 }
        r1 = r8.c;	 Catch:{ Exception -> 0x0035 }
        r1.a(r0);	 Catch:{ Exception -> 0x0035 }
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.e.run():void");
    }
}
