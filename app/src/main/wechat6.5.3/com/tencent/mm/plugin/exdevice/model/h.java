package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.e.a.dp;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.d.AnonymousClass3;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public class h extends com.tencent.mm.plugin.exdevice.service.s.a {
    protected static final String TAG = h.class.getName();
    private boolean ftU = false;
    f ftV = new f();
    private com.tencent.mm.plugin.exdevice.service.j.a ftW = new com.tencent.mm.plugin.exdevice.service.j.a(this) {
        final /* synthetic */ h ftX;

        {
            this.ftX = r1;
        }

        public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
            v.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), b.ak(bArr)});
            if (1 == i) {
                ac.ajB().g(str3, str2, false);
            } else if (2 == i) {
                ac.ajB().g(str3, str2, true);
            } else {
                v.e(h.TAG, "unknown message type %d", new Object[]{Integer.valueOf(i)});
            }
            if (ac.ajq().bq(b.sE(str2)) != null) {
                v.d(h.TAG, "the founded device hasn't been binded");
            }
        }
    };

    public interface a {
        void a(long j, int i, int i2, int i3, long j2);
    }

    public final void ajg() {
        if (this.ftU) {
            v.d(TAG, "still scanning. return");
            return;
        }
        d ajx = ac.ajx();
        j jVar = this.ftW;
        v.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (ajx.frR == null) {
            ajx.frR = new c();
            ajx.frR.fxm = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass2(ajx, jVar);
            ajx.frR.bD(aa.getContext());
        } else if (u.ajW().frL == null) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!u.ajW().frL.a(jVar)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.ftU = true;
    }

    public final void Xe() {
        if (this.ftU) {
            d ajx = ac.ajx();
            j jVar = this.ftW;
            v.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (ajx.frR == null) {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.ajW().frL == null) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.ajW().frL.b(jVar)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.ftU = false;
            return;
        }
        v.d(TAG, "not yet scan. return");
    }

    public final void a(long j, final a aVar) {
        com.tencent.mm.plugin.exdevice.service.f.a bh = this.ftV.bh(j);
        if (bh == null || 2 != bh.baO) {
            d ajx = ac.ajx();
            k anonymousClass2 = new com.tencent.mm.plugin.exdevice.service.k.a(this) {
                final /* synthetic */ h ftX;

                public final void a(long j, int i, int i2, int i3, long j2) {
                    v.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
                    com.tencent.mm.plugin.exdevice.service.f.a bh = this.ftX.ftV.bh(j);
                    if (bh != null) {
                        bh.baO = i2;
                        bh.eqh = j2;
                    } else {
                        v.i(h.TAG, "get connect state faild : %d", new Object[]{Long.valueOf(j)});
                    }
                    aVar.a(j, i, i2, i3, j2);
                }
            };
            v.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (ajx.frR == null) {
                ajx.frR = new c();
                ajx.frR.fxm = new AnonymousClass3(ajx, j, anonymousClass2);
                ajx.frR.bD(aa.getContext());
                return;
            }
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            m mVar = u.ajW().frL;
            if (mVar == null || !mVar.a(j, anonymousClass2)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
                return;
            }
            return;
        }
        v.d(TAG, "device(" + j + ") has been connected");
        aVar.a(j, 2, 2, 0, bh.eqh);
    }

    public static void aU(long j) {
        d ajx = ac.ajx();
        v.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (ajx.frR == null) {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
        } else if (u.ajW().frL == null) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.ajW().frL.bp(j)) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
        }
    }

    public static boolean a(long j, byte[] bArr, t tVar) {
        boolean z = false;
        if (bArr == null || bArr.length <= 0) {
            v.e(TAG, "no data for transmit");
        } else if (u.ajW().frL == null) {
            v.e(TAG, "can not send data");
        } else {
            z = u.ajW().frL.b(j, bArr, tVar);
            if (!z) {
                v.e(TAG, "simpleBluetoothSendData error");
            }
        }
        return z;
    }

    public final void c(long j, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            v.e(TAG, "data is null or nil");
            return;
        }
        List<e.b> linkedList;
        v.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[]{Long.valueOf(j), b.ak(bArr)});
        e ajB = ac.ajB();
        String br = b.br(j);
        synchronized (ajB.fsj) {
            linkedList = new LinkedList(ajB.fsj);
        }
        for (e.b c : linkedList) {
            c.c(br, bArr, true);
        }
        linkedList.clear();
        for (e.b c2 : ajB.fsk.values()) {
            c2.c(br, bArr, true);
        }
        dp dpVar = new dp();
        dpVar.bbF.mac = br;
        dpVar.bbF.data = bArr;
        com.tencent.mm.sdk.c.a.nhr.a(dpVar, Looper.getMainLooper());
    }
}
