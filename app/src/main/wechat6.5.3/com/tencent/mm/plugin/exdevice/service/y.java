package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.c.a.a.f.AnonymousClass6;
import com.tencent.mm.plugin.c.a.a.f.AnonymousClass7;
import com.tencent.mm.plugin.c.a.b.e.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends com.tencent.mm.plugin.exdevice.service.h.a implements com.tencent.mm.plugin.c.a.a.b, com.tencent.mm.plugin.c.a.d.a.a, g {
    private a fxC;
    private RemoteCallbackList<k> fxD;
    private RemoteCallbackList<p> fxE;
    private RemoteCallbackList<j> fxF;
    private RemoteCallbackList<i> fxG;
    private RemoteCallbackList<q> fxH;
    private RemoteCallbackList<n> fxI;
    private final l fxJ;
    private int fxK;
    private final com.tencent.mm.plugin.c.a.a.f fxL;
    private final com.tencent.mm.plugin.c.a.d.a fxM;
    private RemoteCallbackList<j> fxN;
    private RemoteCallbackList<k> fxO;
    private RemoteCallbackList<s> fxP;
    private RemoteCallbackList<t> fxQ;
    com.tencent.mm.plugin.c.a.b.e fxR;
    private com.tencent.mm.plugin.c.a.b.e.a fxS;
    private com.tencent.mm.plugin.exdevice.devicestep.a fxT;
    private final ac mHandler;

    private final class a extends ac {
        final /* synthetic */ y fxU;

        public a(y yVar, Looper looper) {
            this.fxU = yVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    k kVar = (k) message.obj;
                    if (!this.fxU.b(kVar.fwR, kVar.fyc)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                        return;
                    }
                    return;
                case 1:
                    if (!y.a(this.fxU, ((Long) message.obj).longValue())) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                        return;
                    }
                    return;
                case 2:
                    d dVar = (d) message.obj;
                    this.fxU.d(dVar.fwR, dVar.dLT, dVar.dLU, dVar.dLV);
                    return;
                case 3:
                    j jVar = (j) message.obj;
                    if (!y.a(this.fxU, jVar.esP, jVar.fyb, jVar.fxX)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                        return;
                    }
                    return;
                case 4:
                    if (!y.b(this.fxU, ((Long) message.obj).longValue())) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        return;
                    }
                    return;
                case 5:
                    c cVar = (c) message.obj;
                    y.a(this.fxU, cVar.esP, cVar.fwP, cVar.fwQ, cVar.dLU);
                    return;
                case 6:
                    b bVar = (b) message.obj;
                    y.a(this.fxU, bVar.esS, bVar.esP, bVar.frh, bVar.fwO, bVar.frb);
                    return;
                case 7:
                    e eVar = (e) message.obj;
                    if (!this.fxU.c(eVar.fuw, eVar.fxW, eVar.fxX)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                        return;
                    }
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    y yVar = this.fxU;
                    v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[]{Long.valueOf(longValue)});
                    if (yVar.fxR != null) {
                        com.tencent.mm.plugin.c.a.b.e eVar2 = yVar.fxR;
                        v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[]{Long.valueOf(longValue)});
                        if (eVar2.Xk()) {
                            eVar2.j(new AnonymousClass5(eVar2, longValue));
                            return;
                        } else {
                            v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            return;
                        }
                    }
                    return;
                case 9:
                    c cVar2 = (c) message.obj;
                    if (!this.fxU.b(cVar2.esP, cVar2.fwP, cVar2.fwQ, cVar2.dLU, cVar2.eqh)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                        return;
                    }
                    return;
                case 10:
                    i iVar = (i) message.obj;
                    if (!this.fxU.c(iVar.fuw, iVar.epb, iVar.fya)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                        return;
                    }
                    return;
                case 11:
                    h hVar = (h) message.obj;
                    if (!this.fxU.e(hVar.fuw, hVar.dLT, hVar.dLU, hVar.dLV)) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                        return;
                    }
                    return;
                case 12:
                    f fVar = (f) message.obj;
                    this.fxU.d(fVar.fuw, fVar.epb);
                    return;
                case as.CTRL_INDEX /*13*/:
                    y.a(this.fxU, (g) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class b {
        long esP;
        int esS;
        byte[] frb;
        short frh;
        short fwO;

        private b() {
            this.esP = 0;
            this.frh = (short) 0;
            this.fwO = (short) 0;
            this.frb = null;
            this.esS = 0;
        }
    }

    private static final class c {
        int dLU;
        long eqh;
        long esP;
        int fwP;
        int fwQ;

        private c() {
            this.esP = 0;
            this.fwP = 0;
            this.fwQ = 0;
            this.dLU = 0;
            this.eqh = 0;
        }
    }

    private static final class d {
        int dLT = 0;
        int dLU = 0;
        String dLV = null;
        long fwR = 0;
    }

    private static final class e {
        public long fuw;
        public int fxW;
        public k fxX;

        private e() {
        }
    }

    private static final class f {
        public byte[] epb;
        public long fuw;

        private f() {
        }
    }

    private static final class g {
        String esU;
        String esV;
        int esW;
        boolean fxY;
        byte[] fxZ;

        private g() {
        }
    }

    private static final class h {
        public int dLT;
        public int dLU;
        public String dLV;
        public long fuw;

        private h() {
        }
    }

    private static final class i {
        public byte[] epb;
        public long fuw;
        public t fya;

        private i() {
        }
    }

    private static final class j {
        long esP;
        k fxX;
        int fyb;

        public j(long j, int i, k kVar) {
            this.esP = j;
            this.fyb = i;
            this.fxX = kVar;
        }
    }

    private static final class k {
        long fwR;
        p fyc;

        public k(long j, p pVar) {
            this.fwR = j;
            this.fyc = pVar;
        }
    }

    private static final class l {
        long fwR;

        private l() {
            this.fwR = 0;
        }
    }

    static /* synthetic */ void a(y yVar, int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        int beginBroadcast = yVar.fxG.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                i iVar = (i) yVar.fxG.getBroadcastItem(i2);
                if (iVar != null) {
                    iVar.a(i, j, s, s2, bArr);
                } else {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", new Object[]{Short.valueOf(s2)});
                }
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = " + i2);
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        yVar.fxG.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, long j, int i, int i2, int i3) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChangeImp deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        k kVar = (k) a(j, yVar.fxD, yVar.fxD.beginBroadcast());
        if (kVar == null) {
            v.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            yVar.fxD.finishBroadcast();
            return;
        }
        try {
            kVar.a(j, i, i2, i3, 0);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        yVar.fxD.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, g gVar) {
        int beginBroadcast = yVar.fxN.beginBroadcast();
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnDiscoverCallback size=%d", new Object[]{Integer.valueOf(beginBroadcast)});
        if (beginBroadcast <= 0) {
            v.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "no simpleBTOnDiscoverCallback");
        }
        int i = 0;
        while (i < beginBroadcast) {
            try {
                if (gVar.fxY) {
                    ((j) yVar.fxN.getBroadcastItem(i)).a(2, 0, "scan finish", null, null, 0, null);
                    if (!yVar.fxN.unregister(yVar.fxN.getBroadcastItem(i))) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mSimpleOnScanCallbackList.unregister failed!!!");
                    }
                } else {
                    ((j) yVar.fxN.getBroadcastItem(i)).a(1, 0, "discover device", gVar.esU, gVar.esV, gVar.esW, gVar.fxZ);
                }
                i++;
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception: " + e.toString());
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                return;
            } finally {
                yVar.fxN.finishBroadcast();
            }
        }
        yVar.fxN.finishBroadcast();
    }

    static /* synthetic */ boolean a(y yVar, long j) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp, task id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        }
        int beginBroadcast = yVar.fxE.beginBroadcast();
        IInterface iInterface = (p) a(j, yVar.fxE, beginBroadcast);
        if (iInterface == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask Failed, Cannot find such netCmd in RemoteCallbackList");
            yVar.fxE.finishBroadcast();
            return false;
        }
        a aVar = yVar.fxC;
        v.i("MicroMsg.exdevice.BTDeviceManager", "stopTask taskId = %d", new Object[]{Long.valueOf(j)});
        aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(9, Long.valueOf(j)));
        boolean a = a(yVar.fxE, j, iInterface, beginBroadcast);
        if (!a) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListTask.unregister Failed!!!");
        }
        yVar.fxE.finishBroadcast();
        return a;
    }

    static /* synthetic */ boolean a(y yVar, long j, int i, k kVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        Assert.assertNotNull(kVar);
        v ajX = v.ajX();
        v.i("MicroMsg.exdevice.MMExDevicePushCore", "insertDeviceIdAndBluetoothVersion aDeviceId = %d, aBluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        ajX.fxA.put(Long.valueOf(j), Integer.valueOf(i));
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
        boolean a = a(yVar.fxD, j, (IInterface) kVar);
        if (!a) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnStateChange.register Failed!!!");
        }
        if (a) {
            a aVar = yVar.fxC;
            v.i("MicroMsg.exdevice.BTDeviceManager", "startChannel deviceId = %d", new Object[]{Long.valueOf(j)});
            if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(11, Long.valueOf(j)))) {
                return true;
            }
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startChannel Failed!!!");
            v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
            a = a(yVar.fxD, j, (IInterface) kVar, yVar.fxD.beginBroadcast());
            if (!a) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
            }
            yVar.fxD.finishBroadcast();
            if (!a) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange");
            }
            yVar.b(j, 1, 4, -1);
            return false;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange Failed!!!");
        yVar.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ boolean b(y yVar, long j) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = yVar.fxC;
        v.i("MicroMsg.exdevice.BTDeviceManager", "stopChannel deviceId = " + j);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(12, Long.valueOf(j)))) {
            return true;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopChannel Failed!!!");
        return false;
    }

    public y(com.tencent.mm.plugin.exdevice.devicestep.a aVar) {
        this.fxC = null;
        this.fxD = new RemoteCallbackList();
        this.fxE = new RemoteCallbackList();
        this.fxF = new RemoteCallbackList();
        this.fxG = new RemoteCallbackList();
        this.fxH = new RemoteCallbackList();
        this.fxI = new RemoteCallbackList();
        this.fxJ = new l();
        this.fxK = 0;
        this.fxN = new RemoteCallbackList();
        this.fxO = new RemoteCallbackList();
        this.fxP = new RemoteCallbackList();
        this.fxQ = new RemoteCallbackList();
        this.fxC = new a(this);
        this.mHandler = new a(this, v.ajX().frO.htb.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.fxL = new com.tencent.mm.plugin.c.a.a.f(this);
        } else {
            this.fxL = null;
        }
        this.fxM = new com.tencent.mm.plugin.c.a.d.a(this);
        this.fxT = aVar;
        this.fxS = new com.tencent.mm.plugin.c.a.b.e.a(this) {
            final /* synthetic */ y fxU;

            {
                this.fxU = r1;
            }

            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                objArr[2] = Long.valueOf(j2);
                v.d(str, str2, objArr);
                c cVar = new c();
                cVar.esP = j;
                cVar.fwQ = z ? 2 : 4;
                cVar.fwP = 1;
                cVar.dLU = 0;
                cVar.eqh = j2;
                if (!this.fxU.mHandler.sendMessage(this.fxU.mHandler.obtainMessage(9, cVar))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(9)});
                }
            }

            public final void b(long j, byte[] bArr) {
                f fVar = new f();
                fVar.fuw = j;
                fVar.epb = bArr;
                if (!this.fxU.mHandler.sendMessage(this.fxU.mHandler.obtainMessage(12, fVar))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(12)});
                }
            }

            public final void e(long j, boolean z) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onSend. sessionId=%d, success=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                v.d(str, str2, objArr);
                h hVar = new h();
                hVar.fuw = j;
                if (z) {
                    hVar.dLT = 0;
                    hVar.dLU = 0;
                } else {
                    hVar.dLT = -1;
                    hVar.dLU = -1;
                }
                hVar.dLV = "";
                if (!this.fxU.mHandler.sendMessage(this.fxU.mHandler.obtainMessage(11, hVar))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(11)});
                }
            }

            public final void a(String str, String str2, int i, byte[] bArr) {
                v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[]{str, str2});
                g gVar = new g();
                gVar.fxY = false;
                gVar.esU = str;
                gVar.esV = str2;
                gVar.esW = i;
                gVar.fxZ = bArr;
                if (!this.fxU.mHandler.sendMessage(this.fxU.mHandler.obtainMessage(13, gVar))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
                }
            }

            public final void Xl() {
                v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
                g gVar = new g();
                gVar.fxY = true;
                gVar.esU = null;
                gVar.esV = null;
                gVar.esW = 0;
                gVar.fxZ = null;
                if (!this.fxU.mHandler.sendMessage(this.fxU.mHandler.obtainMessage(13, gVar))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
                }
            }
        };
        com.tencent.mm.compatible.a.a.a(18, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ y fxU;

            {
                this.fxU = r1;
            }

            public final void run() {
                this.fxU.fxR = new com.tencent.mm.plugin.c.a.b.e(this.fxU.fxS);
            }
        });
    }

    private static IInterface a(long j, RemoteCallbackList remoteCallbackList, int i) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                return (IInterface) hashMap.get(Long.valueOf(j));
            }
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        return null;
    }

    private boolean c(j jVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.fxF.unregister(jVar);
        if (unregister) {
            this.fxK--;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        return unregister;
    }

    public final boolean b(final int i, final j jVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable(this) {
            final /* synthetic */ y fxU;

            public final void run() {
                if (!this.fxU.f(i, jVar)) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        return post;
    }

    private boolean f(int i, j jVar) {
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.fxF.register(jVar);
        if (register) {
            this.fxK++;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            r rVar = this.fxC;
            v.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (b.a(i, rVar, new int[0])) {
                z = true;
            } else {
                v.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e.getMessage()});
                    v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!c(jVar)) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            return z;
        }
        try {
            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (Throwable e2) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e2.getMessage()});
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(final int i, final j jVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable(this) {
            final /* synthetic */ y fxU;

            public final void run() {
                if (!this.fxU.g(i, jVar)) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        return post;
    }

    private boolean g(int i, j jVar) {
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean ko = a.ko(i);
        if (!ko) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!c(jVar)) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        return ko;
    }

    public final long[] ajF() {
        return a.ajF();
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[]{Long.valueOf(j)});
        if (remoteCallbackList == null || iInterface == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        do {
            beginBroadcast--;
            if (beginBroadcast < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
        if (beginBroadcast < 0) {
            v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            HashMap hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        return true;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (remoteCallbackList == null || iInterface == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            return false;
        } else if (!hashMap.isEmpty()) {
            return true;
        } else {
            v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (unregister) {
                return unregister;
            }
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            return unregister;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (kVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            return false;
        } else if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j, i, kVar)))) {
                return true;
            }
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(3)});
            return false;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }

    public final boolean bm(long j) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            return true;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(4)});
            return false;
        }
    }

    public final boolean bn(long j) {
        return false;
    }

    private boolean b(long j, p pVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[]{Long.valueOf(j)});
        if (pVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            d(j, -1, -1, "null == aTask");
            return false;
        }
        boolean z;
        a aVar = this.fxC;
        v.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[]{Long.valueOf(j)});
        Assert.assertNotNull(pVar);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new g(j, pVar)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", new StringBuilder("mBTDeviceMrg.startTask Failed ret = -1").toString());
            d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            return false;
        } else if (a(this.fxE, j, (IInterface) pVar)) {
            return true;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            d(j, -1, -1, "registerRemoteCB Fail!!!");
            return false;
        }
    }

    public final long a(p pVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (pVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            return -1;
        }
        l lVar = this.fxJ;
        if (Long.MAX_VALUE == lVar.fwR) {
            v.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            lVar.fwR = 0;
        }
        long j = lVar.fwR;
        lVar.fwR = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j, pVar)))) {
            return j;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[]{Integer.valueOf(0)});
        return -1;
    }

    public final boolean bo(long j) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            return true;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[]{Integer.valueOf(1)});
            return false;
        }
    }

    public final boolean a(i iVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.fxG.register(iVar);
        if (!register) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        return register;
    }

    public final boolean b(i iVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.fxG.unregister(iVar);
        if (!unregister) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        return unregister;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        int beginBroadcast = this.fxF.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((j) this.fxF.getBroadcastItem(i4)).a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.fxF.unregister(this.fxF.getBroadcastItem(i4))) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = " + i4);
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.fxF.finishBroadcast();
    }

    private void d(long j, int i, int i2, String str) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        int beginBroadcast = this.fxE.beginBroadcast();
        IInterface iInterface = (p) a(j, this.fxE, beginBroadcast);
        if (iInterface == null) {
            v.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = " + j);
            this.fxE.finishBroadcast();
            return;
        }
        try {
            iInterface.ajT().a(j, i, i2, str, iInterface);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!a(this.fxE, j, iInterface, beginBroadcast)) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.fxE.finishBroadcast();
    }

    public final void c(long j, int i, int i2, String str) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        d dVar = new d();
        dVar.fwR = j;
        dVar.dLT = i;
        dVar.dLU = i2;
        dVar.dLV = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
    }

    public final void a(int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        b bVar = new b();
        bVar.fwO = s2;
        bVar.frb = bArr;
        bVar.esP = j;
        bVar.frh = s;
        bVar.esS = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(6)});
        }
    }

    public final void b(long j, int i, int i2, int i3) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        c cVar = new c();
        cVar.esP = j;
        cVar.fwP = i;
        cVar.fwQ = i2;
        cVar.dLU = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[]{Integer.valueOf(5)});
        }
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = this.fxC;
        v.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new f(j, bArr)))) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[]{Integer.valueOf(10)});
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        if (VERSION.SDK_INT < 18 || this.fxL == null) {
            return false;
        }
        boolean hasSystemFeature = aa.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            return false;
        }
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (this.fxH.register(qVar)) {
            try {
                UUID fromString = UUID.fromString(str);
                com.tencent.mm.plugin.c.a.a.f fVar = this.fxL;
                com.tencent.mm.plugin.c.a.a.f.eoy = aa.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                v.d(str2, str3, objArr);
                if (fromString == null) {
                    v.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else {
                    hasSystemFeature = z ? fVar.mHandler.post(new AnonymousClass6(fVar, fromString)) : fVar.mHandler.post(new AnonymousClass7(fVar, fromString));
                }
                if (hasSystemFeature) {
                    return true;
                }
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.fxH.unregister(qVar)) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                return false;
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[]{e.getMessage()});
                return false;
            }
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        return false;
    }

    public final void a(double d, com.tencent.mm.plugin.c.a.a.c cVar) {
        if (cVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            return;
        }
        com.tencent.mm.plugin.c.a.a.h hVar = cVar.eoo.eot;
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[]{Double.valueOf(d), com.tencent.mm.plugin.exdevice.j.b.ak(hVar.eoU), Short.valueOf(hVar.eoV), Short.valueOf(hVar.eoW), Integer.valueOf(hVar.eoW & 65535)});
        try {
            int beginBroadcast = this.fxH.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((q) this.fxH.getBroadcastItem(i)).a(d, hVar.eoV, hVar.eoW, hVar.eoU, cVar.eop, cVar.eoo.eot.eoX, cVar.aOw);
                } catch (Throwable e) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[]{Integer.valueOf(i), e.toString()});
                    v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[]{e2.toString()});
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.fxH.finishBroadcast();
        }
    }

    public final void it(int i) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[]{Integer.valueOf(i)});
        for (int beginBroadcast = this.fxI.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((n) this.fxI.getBroadcastItem(beginBroadcast)).d(0, bundle);
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[]{Integer.valueOf(beginBroadcast)});
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.fxI.finishBroadcast();
    }

    public final void a(n nVar) {
        v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.fxI.register(nVar)) {
            v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
    }

    public final int ajM() {
        try {
            if (this.fxT != null) {
                this.fxT.aiA();
            }
            long bul = be.bul() / 10000;
            long j = r.getLong(202, 0);
            int i = r.getInt(201, 0);
            long aiH = com.tencent.mm.plugin.exdevice.devicestep.d.aiH();
            int aiG = com.tencent.mm.plugin.exdevice.devicestep.d.aiG();
            if (aiH == bul) {
                v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[hakon][Step] cacheTime %s cacheStep:%s", new Object[]{Long.valueOf(aiH), Integer.valueOf(aiG)});
                return aiG;
            } else if (j == bul) {
                v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[hakon][Step] saveTime %s saveStep:%s", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                return i;
            } else {
                v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[hakon][Step] getStepCount:0, new day");
                v.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "saveTime:%s, cacheTime: %S, beginOfToday:%s", new Object[]{Long.valueOf(j), Long.valueOf(aiH), Long.valueOf(bul)});
                return 0;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", " exception in :exdevice getStepCount, %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return 0;
        }
    }

    public final boolean d(int i, j jVar) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            return false;
        } else if (i != 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            return false;
        } else {
            boolean register = this.fxN.register(jVar);
            if (register) {
                v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.fxR != null) {
                boolean z;
                com.tencent.mm.plugin.c.a.b.e eVar = this.fxR;
                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                if (eVar.epi != null) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                if (eVar.Xk()) {
                    z = eVar.epi.a(true, eVar.epl);
                    if (z) {
                        eVar.epT.clear();
                    }
                } else {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    z = false;
                }
                if (!z) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (Throwable e) {
                        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (!register) {
                        return false;
                    }
                    this.fxN.unregister(jVar);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean e(int i, j jVar) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            return false;
        } else if (this.fxR == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            return false;
        } else {
            boolean a;
            com.tencent.mm.plugin.c.a.b.e eVar = this.fxR;
            v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(eVar.epi != null);
            if (eVar.Xk()) {
                eVar.mHandler.removeCallbacks(eVar.lv);
                a = eVar.epi.a(false, eVar.epl);
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                    v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            return a;
        }
    }

    public final boolean b(long j, int i, k kVar) {
        if (kVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (i != 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            e eVar = new e();
            eVar.fuw = j;
            eVar.fxW = i;
            eVar.fxX = kVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                return true;
            }
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(7)});
            return false;
        }
    }

    public final boolean bp(long j) {
        if (j < 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            return true;
        } else {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(8)});
            return false;
        }
    }

    public final boolean a(s sVar) {
        if (sVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        }
        boolean register = this.fxP.register(sVar);
        if (register) {
            return register;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        return register;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        if (0 > j) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            return false;
        } else if (tVar == null) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else {
            i iVar = new i();
            iVar.fuw = j;
            iVar.epb = bArr;
            iVar.fya = tVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                return true;
            }
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(10)});
            return false;
        }
    }

    public final boolean c(long j, int i, k kVar) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (a(this.fxO, j, (IInterface) kVar)) {
            try {
                kVar.a(j, -1, 1, -1, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.fxR != null) {
                boolean connect;
                com.tencent.mm.plugin.c.a.b.e eVar = this.fxR;
                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[]{Long.valueOf(j)});
                if (eVar.Xk()) {
                    com.tencent.mm.plugin.c.a.b.f fVar = (com.tencent.mm.plugin.c.a.b.f) eVar.epg.get(Long.valueOf(j));
                    if (fVar != null) {
                        v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = fVar.connect();
                    } else {
                        fVar = new com.tencent.mm.plugin.c.a.b.f(j, eVar.aHq, eVar.epV);
                        if (fVar.connect()) {
                            eVar.j(new com.tencent.mm.plugin.c.a.b.e.AnonymousClass4(eVar, j, fVar));
                            connect = true;
                        } else {
                            v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[]{Long.valueOf(j)});
                    if (kVar != null) {
                        try {
                            kVar.a(j, 1, 4, -1, 0);
                        } catch (Throwable e2) {
                            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            kVar.a(j, -1, 4, -1, 0);
        } catch (Throwable e22) {
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(long j, byte[] bArr, t tVar) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[]{Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.ak(bArr)});
        if (this.fxR != null) {
            boolean z;
            com.tencent.mm.plugin.c.a.b.e eVar = this.fxR;
            v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[]{Long.valueOf(j)});
            if (eVar.Xk()) {
                com.tencent.mm.plugin.c.a.b.f fVar = (com.tencent.mm.plugin.c.a.b.f) eVar.epg.get(Long.valueOf(j));
                if (fVar == null) {
                    v.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
                    z = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                }
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (tVar != null) {
                    try {
                        tVar.b(j, -1, -1, "start write data error");
                    } catch (Throwable e) {
                        v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                return false;
            }
        }
        if (a(this.fxQ, j, (IInterface) tVar)) {
            return true;
        }
        v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        return false;
    }

    public final boolean b(long j, int i, int i2, int i3, long j2) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        k kVar = (k) a(j, this.fxO, this.fxO.beginBroadcast());
        if (kVar == null) {
            v.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.fxO.finishBroadcast();
            return false;
        }
        try {
            kVar.a(j, i, i2, i3, j2);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.fxO.finishBroadcast();
        }
    }

    public final boolean e(long j, int i, int i2, String str) {
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        t tVar = (t) a(j, this.fxQ, this.fxQ.beginBroadcast());
        if (tVar == null) {
            v.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.fxQ.finishBroadcast();
            return false;
        }
        try {
            tVar.b(j, i, i2, str);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.fxQ.finishBroadcast();
        }
        return true;
    }

    public final boolean d(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? "null" : com.tencent.mm.plugin.exdevice.j.b.ak(bArr);
        v.d(str, str2, objArr);
        v.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", new Object[]{Integer.valueOf(this.fxP.beginBroadcast())});
        while (i < r2) {
            try {
                s sVar = (s) this.fxP.getBroadcastItem(i);
                if (sVar != null) {
                    sVar.c(j, bArr);
                } else {
                    v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (Throwable e) {
                v.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                v.a("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            } finally {
                this.fxP.finishBroadcast();
            }
        }
        this.fxP.finishBroadcast();
        return true;
    }

    public final int getInt(int i, int i2) {
        return r.getInt(i, i2);
    }

    public final long getLong(int i, long j) {
        return r.getLong(i, j);
    }

    public final String getString(int i, String str) {
        v.d("MicroMsg.ExdeviceCfgHelper", "getString(%s, %s), process : %s", new Object[]{Integer.valueOf(i), str, aa.getProcessName()});
        return r.rZ().ceO != null ? r.rZ().ceO.getString(i, str) : str;
    }

    public final void ar(int i, int i2) {
        r.ar(i, i2);
    }

    public final void i(int i, long j) {
        r.i(i, j);
    }

    public final void i(int i, String str) {
        v.d("MicroMsg.ExdeviceCfgHelper", "putString(%s, %s), process : %s", new Object[]{Integer.valueOf(i), str, aa.getProcessName()});
        if (r.rZ().ceO != null) {
            r.rZ().ceO.i(i, str);
        }
    }
}
