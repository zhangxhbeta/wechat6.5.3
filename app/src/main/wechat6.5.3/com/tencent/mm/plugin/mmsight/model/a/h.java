package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.memory.d;
import com.tencent.mm.memory.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends a<byte[]> {
    private static int hlL = 0;
    public static final h hoF = new h();

    public final /* synthetic */ void ar(Object obj) {
        x((byte[]) obj);
    }

    protected final /* bridge */ /* synthetic */ long as(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    protected final /* synthetic */ Comparable at(Object obj) {
        byte[] bArr = (byte[]) obj;
        return (bArr == null || bArr.length <= 0) ? Integer.valueOf(0) : Integer.valueOf(bArr.length);
    }

    protected final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    public final /* synthetic */ Object c(Integer num) {
        return h(num);
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    public static void bP(int i, int i2) {
        v.i("MicroMsg.MMSightByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
        long Nj = be.Nj();
        for (int i3 = 0; i3 < 3; i3++) {
            hoF.x(new byte[(((i * i2) * 3) / 2)]);
        }
        v.i("MicroMsg.MMSightByteArrayPool", "preloadCameraData used %sms", new Object[]{Long.valueOf(be.az(Nj))});
    }

    private h() {
    }

    public final synchronized void x(byte[] bArr) {
        super.ar(bArr);
    }

    public final synchronized byte[] h(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.c(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        return bArr;
    }

    protected final long wa() {
        if (hlL <= 0) {
            hlL = ((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (hlL >= 512) {
            return 41943040;
        }
        return 20971520;
    }

    protected final long wb() {
        return 10485760;
    }

    public final void wc() {
        super.wc();
    }
}
