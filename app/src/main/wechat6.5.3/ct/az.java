package ct;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class az {
    public int a = 1;
    public int b = 1;
    public int c = 20000;
    public ArrayList d = null;
    public ArrayList e = null;
    public String f = "dispatcher.3g.qq.com";
    public Socket g;
    public int h;
    public String i;
    public int j;
    public int k;
    public s l;
    private int m = 3;
    private int n = 0;
    private boolean o = false;
    private int p = 0;
    private boolean q = false;
    private int r;

    public az() {
        int[] iArr = c.a;
        this.g = null;
        this.h = 0;
        this.r = 0;
        this.j = -1;
        this.k = -1;
    }

    private static ArrayList a(ArrayList arrayList, int i, int i2) {
        if (arrayList == null || arrayList.size() <= 0 || i >= arrayList.size()) {
            return arrayList;
        }
        int min = Math.min(i2, arrayList.size() - i);
        if (min <= 0) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(min);
        List subList = arrayList.subList(i, i + min);
        for (int i3 = 0; i3 < min; i3++) {
            s sVar = (s) subList.get(i3);
            arrayList2.add(new s(sVar.a, sVar.b));
        }
        return arrayList2;
    }

    public static void a(int[] iArr) {
        iArr.clone();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = r8.d;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r8.d;
        r0 = r0.size();
        if (r0 > 0) goto L_0x0075;
    L_0x000e:
        r0 = r2;
    L_0x000f:
        r8.o = r0;
        r0 = r8.e;
        if (r0 != 0) goto L_0x0077;
    L_0x0015:
        r0 = r2;
    L_0x0016:
        r8.q = r0;
        ct.bd.a();
    L_0x001b:
        r0 = r8.o;
        if (r0 == 0) goto L_0x0023;
    L_0x001f:
        r0 = r8.q;
        if (r0 != 0) goto L_0x0074;
    L_0x0023:
        r0 = r8.r;
        r3 = r8.m;
        if (r0 > r3) goto L_0x0074;
    L_0x0029:
        r0 = r8.r;
        r0 = r0 + 1;
        r8.r = r0;
        r0 = ct.bc.f();
        if (r0 == 0) goto L_0x0079;
    L_0x0035:
        r0 = r8.f;
        r3 = r8.c;
        r0 = ct.ay.a(r0, r3);
        if (r0 == 0) goto L_0x0047;
    L_0x003f:
        r3 = r0.c;
        r8.g = r3;
        r0 = r0.d;
        r8.i = r0;
    L_0x0047:
        r0 = r8.g;
        if (r0 == 0) goto L_0x0157;
    L_0x004b:
        r0 = r8.g;
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0157;
    L_0x0053:
        r0 = r8.g;
        r0 = r0.isClosed();
        if (r0 != 0) goto L_0x0157;
    L_0x005b:
        r0 = new ct.s;
        r2 = r8.g;
        r2 = r2.getInetAddress();
        r2 = r2.getHostAddress();
        r3 = r8.g;
        r3 = r3.getPort();
        r0.<init>(r2, r3);
        r8.l = r0;
        r8.h = r1;
    L_0x0074:
        return;
    L_0x0075:
        r0 = r1;
        goto L_0x000f;
    L_0x0077:
        r0 = r1;
        goto L_0x0016;
    L_0x0079:
        r0 = r8.o;
        if (r0 != 0) goto L_0x00d5;
    L_0x007d:
        r4 = java.lang.System.currentTimeMillis();
        r0 = r8.d;
        r3 = r8.n;
        r6 = r8.a;
        r0 = a(r0, r3, r6);
        if (r0 == 0) goto L_0x00a6;
    L_0x008d:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x00a6;
    L_0x0093:
        r3 = r8.n;
        r6 = r0.size();
        r3 = r3 + r6;
        r8.n = r3;
        r3 = r8.n;
        r6 = r8.d;
        r6 = r6.size();
        if (r3 < r6) goto L_0x00a8;
    L_0x00a6:
        r8.o = r2;
    L_0x00a8:
        r3 = r8.c;
        r0 = ct.ay.a(r0, r3);
        if (r0 == 0) goto L_0x00b8;
    L_0x00b0:
        r3 = r0.c;
        r8.g = r3;
        r0 = r0.d;
        r8.i = r0;
    L_0x00b8:
        r8.j = r1;
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r0 = (int) r4;
        r8.k = r0;
        r0 = new java.lang.StringBuilder;
        r3 = "use IpList, dnsTime: 0 ,connectTime：";
        r0.<init>(r3);
        r3 = r8.k;
        r0.append(r3);
        ct.bd.a();
        goto L_0x0047;
    L_0x00d5:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r3 = r8.q;
        if (r3 != 0) goto L_0x011b;
    L_0x00de:
        r3 = r8.e;
        if (r3 == 0) goto L_0x0119;
    L_0x00e2:
        r3 = r8.e;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x0119;
    L_0x00ea:
        r3 = r8.p;
        r4 = r8.e;
        r4 = r4.size();
        if (r3 >= r4) goto L_0x0119;
    L_0x00f4:
        r0 = r8.e;
        r3 = r8.p;
        r4 = r8.b;
        r0 = a(r0, r3, r4);
        if (r0 == 0) goto L_0x0154;
    L_0x0100:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0154;
    L_0x0106:
        r3 = r8.p;
        r4 = r0.size();
        r3 = r3 + r4;
        r8.p = r3;
        r3 = r8.p;
        r4 = r8.e;
        r4 = r4.size();
        if (r3 < r4) goto L_0x011b;
    L_0x0119:
        r8.q = r2;
    L_0x011b:
        r3 = r8.f;
        r4 = r8.c;
        r0 = ct.ay.a(r0, r3, r4);
        if (r0 == 0) goto L_0x012d;
    L_0x0125:
        r3 = r0.c;
        r8.g = r3;
        r0 = r0.d;
        r8.i = r0;
    L_0x012d:
        r0 = ct.ay.a;
        r8.j = r0;
        r0 = ct.ay.b;
        r8.k = r0;
        r0 = new java.lang.StringBuilder;
        r3 = "use IpList DNS parallel , dnsTime:";
        r0.<init>(r3);
        r3 = r8.j;
        r0 = r0.append(r3);
        r3 = ",connectTime：";
        r0 = r0.append(r3);
        r3 = r8.k;
        r0.append(r3);
        ct.bd.a();
        goto L_0x0047;
    L_0x0154:
        r8.q = r2;
        goto L_0x011b;
    L_0x0157:
        r0 = ct.bc.e();
        if (r0 == 0) goto L_0x016a;
    L_0x015d:
        r0 = -3;
        r8.h = r0;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x017a }
    L_0x0165:
        r0 = 0;
        r8.g = r0;
        goto L_0x001b;
    L_0x016a:
        r0 = -4;
        r8.h = r0;
        r0 = "netWork  Fail when Connect";
        r8.i = r0;
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x0178 }
        goto L_0x0165;
    L_0x0178:
        r0 = move-exception;
        goto L_0x0165;
    L_0x017a:
        r0 = move-exception;
        goto L_0x0165;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.az.a():void");
    }
}
