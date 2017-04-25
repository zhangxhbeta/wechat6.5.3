package com.tencent.mm.console.a;

import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.pluginsdk.a.b;

public final class f implements a {
    static {
        b.a(new f(), "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert");
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r7, java.lang.String[] r8) {
        /*
        r6 = this;
        r4 = 2;
        r3 = -1;
        r1 = 0;
        r0 = 1;
        r2 = r8[r1];
        r5 = r2.hashCode();
        switch(r5) {
            case -2061874877: goto L_0x001e;
            case -1869906331: goto L_0x0034;
            case -1794206389: goto L_0x0029;
            case 918688960: goto L_0x003f;
            case 1957466406: goto L_0x0013;
            default: goto L_0x000d;
        };
    L_0x000d:
        r2 = r3;
    L_0x000e:
        switch(r2) {
            case 0: goto L_0x004a;
            case 1: goto L_0x006f;
            case 2: goto L_0x0076;
            case 3: goto L_0x007a;
            case 4: goto L_0x007e;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r1;
    L_0x0012:
        return r0;
    L_0x0013:
        r5 = "//assert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x000d;
    L_0x001c:
        r2 = r1;
        goto L_0x000e;
    L_0x001e:
        r5 = "//netassert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x000d;
    L_0x0027:
        r2 = r0;
        goto L_0x000e;
    L_0x0029:
        r5 = "//jniassert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x000d;
    L_0x0032:
        r2 = r4;
        goto L_0x000e;
    L_0x0034:
        r5 = "//jnipushassert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x000d;
    L_0x003d:
        r2 = 3;
        goto L_0x000e;
    L_0x003f:
        r5 = "//pushassert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x000d;
    L_0x0048:
        r2 = 4;
        goto L_0x000e;
    L_0x004a:
        r2 = new java.lang.StringBuilder;
        r3 = "test errlog ";
        r2.<init>(r3);
        r3 = new java.text.SimpleDateFormat;
        r4 = "yyyy-MM-dd HH:mm:ss";
        r3.<init>(r4);
        r4 = new java.util.Date;
        r4.<init>();
        r3 = r3.format(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        junit.framework.Assert.assertTrue(r2, r1);
        goto L_0x0012;
    L_0x006f:
        r2 = "NetsceneQueue forbid in ";
        junit.framework.Assert.assertTrue(r2, r1);
        goto L_0x0012;
    L_0x0076:
        com.tencent.mm.protocal.MMProtocalJni.setClientPackVersion(r3);
        goto L_0x0012;
    L_0x007a:
        com.tencent.mm.modelstat.WatchDogPushReceiver.gs(r4);
        goto L_0x0012;
    L_0x007e:
        com.tencent.mm.modelstat.WatchDogPushReceiver.gs(r0);
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.a.f.a(android.content.Context, java.lang.String[]):boolean");
    }
}
