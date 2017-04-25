package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.v;

class g extends a {
    private final ac handler = new ac(Looper.getMainLooper());
    private final v2engine kjr = new v2engine();

    static {
        int rx = l.rx();
        v.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(rx)});
        if ((rx & 1024) != 0) {
            d.v(aa.getContext(), "libvoipCodec_v7a.so");
        } else if ((rx & 512) != 0) {
            d.v(aa.getContext(), "libvoipCodec.so");
        } else {
            d.v(aa.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", g.class.getClassLoader());
    }

    public final int uninitLive() {
        return ((Integer) new az<Integer>(this, Integer.valueOf(-99999)) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.kjv.kjr.uninitLive());
            }
        }.c(this.handler)).intValue();
    }

    public final int SetCurrentMicId(final int i) {
        return ((Integer) new az<Integer>(this, Integer.valueOf(-99999)) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.kjv.kjr.SetCurrentMicId(i));
            }
        }.c(this.handler)).intValue();
    }

    public final int Close() {
        return ((Integer) new az<Integer>(this, Integer.valueOf(-99999)) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.kjv.kjr.Close());
            }
        }.c(this.handler)).intValue();
    }

    public final int aZP() {
        return ((Integer) new az<Integer>(this, Integer.valueOf(-99999)) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                v.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(l.rx())});
                v.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", new Object[]{Integer.valueOf(this.kjv.kjr.initLive(r0, e.cnf + "app_lib/"))});
                return Integer.valueOf(this.kjv.kjr.initLive(r0, e.cnf + "app_lib/"));
            }
        }.c(this.handler)).intValue();
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        final short[] sArr = new short[iArr2.length];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        final b bVar2 = bVar;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final long j2 = j;
        final int[] iArr3 = iArr;
        final int i9 = i4;
        return ((Integer) new az<Integer>(this, Integer.valueOf(-99999)) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.kjv.kjr.Open(bVar2, i6, i7, i8, j2, iArr3, sArr, i9));
            }
        }.c(this.handler)).intValue();
    }

    public final byte[] c(final int[] iArr, final String str) {
        return (byte[]) new az<byte[]>(this) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                PByteArray pByteArray = new PByteArray();
                iArr[0] = this.kjv.kjr.GetStatis(pByteArray, str);
                return pByteArray.value;
            }
        }.c(this.handler);
    }

    public final e a(final c cVar) {
        return (e) new az<e>(this) {
            final /* synthetic */ g kjv;

            protected final /* synthetic */ Object run() {
                return new h(this.kjv.kjr, cVar);
            }
        }.c(this.handler);
    }

    public final d aZQ() {
        return (d) new az<d>(this) {
            final /* synthetic */ g kjv;

            {
                this.kjv = r4;
            }

            protected final /* synthetic */ Object run() {
                return new f(this.kjv.kjr);
            }
        }.c(this.handler);
    }
}
