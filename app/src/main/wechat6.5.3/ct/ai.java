package ct;

public final class ai implements Runnable {
    private ag a;

    public ai(ag agVar) {
        this.a = agVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r2 = 0;
        r1 = 1;
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        if (r0 == 0) goto L_0x0025;
    L_0x0006:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = java.net.InetAddress.getByName(r0);	 Catch:{ Exception -> 0x01e0 }
        r3 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x01e0 }
        r3.v = r0;	 Catch:{ Exception -> 0x01e0 }
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r3 = new ct.s;	 Catch:{ Exception -> 0x01e0 }
        r4 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r4 = r4.v;	 Catch:{ Exception -> 0x01e0 }
        r5 = 80;
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x01e0 }
        r0.h = r3;	 Catch:{ Exception -> 0x01e0 }
    L_0x0025:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.n;	 Catch:{ Exception -> 0x01e0 }
        r3 = -9;
        if (r0 >= r3) goto L_0x003c;
    L_0x002d:
        r0 = "info.3g.qq.com";
        r0 = ct.i.b(r0);	 Catch:{ Exception -> 0x01e0 }
        if (r0 != 0) goto L_0x003c;
    L_0x0036:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r3 = -17;
        r0.n = r3;	 Catch:{ Exception -> 0x01e0 }
    L_0x003c:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.n;	 Catch:{ Exception -> 0x01e0 }
        if (r0 != 0) goto L_0x0077;
    L_0x0042:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        r3 = r0.h;	 Catch:{ Exception -> 0x01e0 }
        if (r3 == 0) goto L_0x01cb;
    L_0x0048:
        r3 = r0.h;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.i;	 Catch:{ Exception -> 0x01e0 }
        r0 = r3.a(r0);	 Catch:{ Exception -> 0x01e0 }
        if (r0 == 0) goto L_0x01cb;
    L_0x0052:
        r0 = r1;
    L_0x0053:
        if (r0 != 0) goto L_0x0077;
    L_0x0055:
        r0 = r10.a;	 Catch:{ Exception -> 0x01e0 }
        if (r0 == 0) goto L_0x0077;
    L_0x0059:
        r3 = ct.u.a();	 Catch:{ Exception -> 0x01e0 }
        r4 = r0.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.h;	 Catch:{ Exception -> 0x01e0 }
        r5 = ct.bc.a();	 Catch:{ Exception -> 0x01e0 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x01e0 }
        if (r6 != 0) goto L_0x0074;
    L_0x006b:
        r6 = "unknown";
        r6 = r5.equals(r6);	 Catch:{ Exception -> 0x01e0 }
        if (r6 == 0) goto L_0x01ce;
    L_0x0074:
        ct.bd.c();	 Catch:{ Exception -> 0x01e0 }
    L_0x0077:
        r0 = r10.a;	 Catch:{ Exception -> 0x01ee }
        r0 = r0.w;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x00c1;
    L_0x007d:
        r3 = r10.a;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.h.a();	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01e3;
    L_0x0085:
        r4 = r0.a();	 Catch:{ Exception -> 0x01ee }
        if (r4 == 0) goto L_0x01e3;
    L_0x008b:
        r0 = r4.a;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01e3;
    L_0x008f:
        r0 = r4.a;	 Catch:{ Exception -> 0x01ee }
        r5 = r3.n;	 Catch:{ Exception -> 0x01ee }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x01ee }
        r0 = r0.get(r5);	 Catch:{ Exception -> 0x01ee }
        r0 = (java.lang.Byte) r0;	 Catch:{ Exception -> 0x01ee }
        if (r0 != 0) goto L_0x00a6;
    L_0x009f:
        r0 = r4.b;	 Catch:{ Exception -> 0x01ee }
        r0 = (byte) r0;	 Catch:{ Exception -> 0x01ee }
        r0 = java.lang.Byte.valueOf(r0);	 Catch:{ Exception -> 0x01ee }
    L_0x00a6:
        if (r3 == 0) goto L_0x00ae;
    L_0x00a8:
        r4 = r0.byteValue();	 Catch:{ Exception -> 0x01ee }
        r3.u = r4;	 Catch:{ Exception -> 0x01ee }
    L_0x00ae:
        r4 = java.lang.Math.random();	 Catch:{ Exception -> 0x01ee }
        r6 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r4 = r4 * r6;
        r0 = r0.floatValue();	 Catch:{ Exception -> 0x01ee }
        r6 = (double) r0;	 Catch:{ Exception -> 0x01ee }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x01e3;
    L_0x00be:
        r0 = r2;
    L_0x00bf:
        if (r0 != 0) goto L_0x00c7;
    L_0x00c1:
        r0 = ct.p.a();	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01ca;
    L_0x00c7:
        r3 = r10.a;	 Catch:{ Exception -> 0x01ee }
        r4 = new ct.ap;	 Catch:{ Exception -> 0x01ee }
        r4.<init>();	 Catch:{ Exception -> 0x01ee }
        r0 = ct.p.b;	 Catch:{ Exception -> 0x01ee }
        r4.a = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.p.c;	 Catch:{ Exception -> 0x01ee }
        r4.b = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.p.d;	 Catch:{ Exception -> 0x01ee }
        r4.c = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.p.g;	 Catch:{ Exception -> 0x01ee }
        r4.d = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.p.e;	 Catch:{ Exception -> 0x01ee }
        r4.e = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.bc.c();	 Catch:{ Exception -> 0x01ee }
        r4.h = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r4.h;	 Catch:{ Exception -> 0x01ee }
        if (r0 != r1) goto L_0x01e6;
    L_0x00ec:
        r0 = ct.bc.a();	 Catch:{ Exception -> 0x01ee }
        r4.g = r0;	 Catch:{ Exception -> 0x01ee }
    L_0x00f2:
        r0 = ct.bc.d();	 Catch:{ Exception -> 0x01ee }
        r4.i = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.bc.e();	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01f0;
    L_0x00fe:
        r0 = r1;
    L_0x00ff:
        r4.m = r0;	 Catch:{ Exception -> 0x01ee }
        if (r3 == 0) goto L_0x01bb;
    L_0x0103:
        r0 = r3.a;	 Catch:{ Exception -> 0x01ee }
        r4.j = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ee }
        r0.<init>();	 Catch:{ Exception -> 0x01ee }
        r5 = r3.h;	 Catch:{ Exception -> 0x01ee }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x01ee }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01ee }
        r4.k = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.n;	 Catch:{ Exception -> 0x01ee }
        r4.n = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.q;	 Catch:{ Exception -> 0x01ee }
        r4.o = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.p;	 Catch:{ Exception -> 0x01ee }
        r4.p = r0;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.G;	 Catch:{ Exception -> 0x01ee }
        r4.y = r6;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.H;	 Catch:{ Exception -> 0x01ee }
        r4.z = r6;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.I;	 Catch:{ Exception -> 0x01ee }
        r4.A = r6;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.J;	 Catch:{ Exception -> 0x01ee }
        r4.B = r6;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.K;	 Catch:{ Exception -> 0x01ee }
        r4.C = r6;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.L;	 Catch:{ Exception -> 0x01ee }
        r4.E = r6;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.l;	 Catch:{ Exception -> 0x01ee }
        if (r0 <= 0) goto L_0x01f3;
    L_0x0140:
        r6 = r3.E;	 Catch:{ Exception -> 0x01ee }
        r8 = r3.F;	 Catch:{ Exception -> 0x01ee }
        r6 = r6 - r8;
        r4.D = r6;	 Catch:{ Exception -> 0x01ee }
    L_0x0147:
        r6 = r3.c;	 Catch:{ Exception -> 0x01ee }
        r4.q = r6;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.f;	 Catch:{ Exception -> 0x01ee }
        r4.F = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.b;	 Catch:{ Exception -> 0x01ee }
        r4.G = r0;	 Catch:{ Exception -> 0x01ee }
        r6 = r3.o;	 Catch:{ Exception -> 0x01ee }
        r4.r = r6;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.k;	 Catch:{ Exception -> 0x01ee }
        r4.M = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.r;	 Catch:{ Exception -> 0x01ee }
        r4.P = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.v;	 Catch:{ Exception -> 0x01ee }
        r4.O = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.t;	 Catch:{ Exception -> 0x01ee }
        r4.Q = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ee }
        r0.<init>();	 Catch:{ Exception -> 0x01ee }
        r5 = r3.u;	 Catch:{ Exception -> 0x01ee }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x01ee }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01ee }
        r4.K = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.l;	 Catch:{ Exception -> 0x01ee }
        r6 = (long) r0;	 Catch:{ Exception -> 0x01ee }
        r4.s = r6;	 Catch:{ Exception -> 0x01ee }
        r0 = 1;
        r4.H = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.m;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01f9;
    L_0x0184:
        r0 = r2;
    L_0x0185:
        r4.I = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = ct.h.a;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01fb;
    L_0x018b:
        r0 = r1;
    L_0x018c:
        r4.J = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.e;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01fd;
    L_0x0192:
        r0 = r1;
    L_0x0193:
        r4.R = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.s;	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01ff;
    L_0x0199:
        r0 = r1;
    L_0x019a:
        r4.S = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.g;	 Catch:{ Exception -> 0x01ee }
        r4.L = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ee }
        r0.<init>();	 Catch:{ Exception -> 0x01ee }
        r1 = r3.i;	 Catch:{ Exception -> 0x01ee }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ee }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01ee }
        r4.l = r0;	 Catch:{ Exception -> 0x01ee }
        r0 = r3.d;	 Catch:{ Exception -> 0x01ee }
        r4.N = r0;	 Catch:{ Exception -> 0x01ee }
        r4.toString();	 Catch:{ Exception -> 0x01ee }
        ct.bd.a();	 Catch:{ Exception -> 0x01ee }
    L_0x01bb:
        r0 = ct.r.a();	 Catch:{ Exception -> 0x01ee }
        if (r0 == 0) goto L_0x01c7;
    L_0x01c1:
        ct.r.a();	 Catch:{ Exception -> 0x01ee }
        ct.r.a(r4);	 Catch:{ Exception -> 0x01ee }
    L_0x01c7:
        ct.bd.b();	 Catch:{ Exception -> 0x01ee }
    L_0x01ca:
        return;
    L_0x01cb:
        r0 = r2;
        goto L_0x0053;
    L_0x01ce:
        r6 = r3.a;	 Catch:{ Exception -> 0x01e0 }
        r0 = r0.a();	 Catch:{ Exception -> 0x01e0 }
        r6.a(r5, r4, r0);	 Catch:{ Exception -> 0x01e0 }
        r0 = 1;
        r3.a(r0);	 Catch:{ Exception -> 0x01e0 }
        ct.bd.b();	 Catch:{ Exception -> 0x01e0 }
        goto L_0x0077;
    L_0x01e0:
        r0 = move-exception;
        goto L_0x0077;
    L_0x01e3:
        r0 = r1;
        goto L_0x00bf;
    L_0x01e6:
        r0 = ct.bc.a();	 Catch:{ Exception -> 0x01ee }
        r4.f = r0;	 Catch:{ Exception -> 0x01ee }
        goto L_0x00f2;
    L_0x01ee:
        r0 = move-exception;
        goto L_0x01ca;
    L_0x01f0:
        r0 = r2;
        goto L_0x00ff;
    L_0x01f3:
        r6 = r4.E;	 Catch:{ Exception -> 0x01ee }
        r4.D = r6;	 Catch:{ Exception -> 0x01ee }
        goto L_0x0147;
    L_0x01f9:
        r0 = r1;
        goto L_0x0185;
    L_0x01fb:
        r0 = r2;
        goto L_0x018c;
    L_0x01fd:
        r0 = r2;
        goto L_0x0193;
    L_0x01ff:
        r0 = r2;
        goto L_0x019a;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.ai.run():void");
    }
}
