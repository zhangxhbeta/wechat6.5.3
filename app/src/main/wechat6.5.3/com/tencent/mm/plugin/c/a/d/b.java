package com.tencent.mm.plugin.c.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.c.a.b.b esK = null;
    public com.tencent.mm.plugin.c.a.c.a esL = null;
    c esM = null;
    final HashSet<String> esN = new HashSet();
    private ac mHandler = null;

    static class c extends ac {
        private WeakReference<b> epQ = null;

        public c(Looper looper, b bVar) {
            super(looper);
            this.epQ = new WeakReference(bVar);
        }

        public final void handleMessage(Message message) {
            b bVar = (b) this.epQ.get();
            if (bVar == null) {
                v.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                return;
            }
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    j jVar = (j) message.obj;
                    bVar.esM.e(jVar.esQ, jVar.esR);
                    return;
                case 1:
                    h hVar = (h) message.obj;
                    bVar.esM.b(hVar.epy, hVar.epb);
                    return;
                case 2:
                    bVar.esM.ir(message.arg1);
                    return;
                case 3:
                    i iVar = (i) message.obj;
                    bVar.esM.a(iVar.esU, iVar.esV, message.arg1, iVar.esW, iVar.esX);
                    return;
                case 4:
                    f fVar = (f) message.obj;
                    bVar.esM.d(fVar.esQ, fVar.esR);
                    return;
                case 5:
                    bVar.esM.aK(((g) message.obj).epy);
                    return;
                case 6:
                    d dVar = (d) message.obj;
                    bVar.esM.d(dVar.epy, dVar.esP, dVar.eps);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class d {
        long eps;
        long epy;
        long esP;

        public d(long j, long j2, long j3) {
            this.epy = j;
            this.esP = j2;
            this.eps = j3;
        }
    }

    private static class e {
        long esQ;
        boolean esR;

        public e(long j, boolean z) {
            this.esQ = j;
            this.esR = z;
        }
    }

    private static final class g {
        long epy;
        private int esS;
        private String esT;

        public g(long j, int i, String str) {
            this.epy = j;
            this.esS = i;
            this.esT = str;
        }
    }

    private static final class h {
        byte[] epb;
        long epy;

        public h(long j, byte[] bArr) {
            this.epy = j;
            this.epb = bArr;
        }
    }

    private static final class i {
        String esU;
        String esV;
        int esW;
        byte[] esX;

        public i(String str, String str2, int i, byte[] bArr) {
            this.esU = str;
            this.esV = str2;
            this.esW = i;
            this.esX = bArr;
        }
    }

    class a extends com.tencent.mm.plugin.c.a.c.a.a {
        final /* synthetic */ b esO;

        a(b bVar) {
            this.esO = bVar;
        }

        public final void d(long j, long j2, long j3) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(6, 1, 0, new d(j, j2, j3))));
        }

        public final void Xl() {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            this.esO.esN.clear();
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(2, 1, 0, null)));
        }

        public final void bb(String str, String str2) {
            int i;
            b bVar = this.esO;
            if (str == null) {
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                i = 0;
            } else if (bVar.esN.contains(str)) {
                i = 0;
            } else {
                bVar.esN.add(str);
                i = 1;
            }
            if (i != 0) {
                v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
                Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(3, 1, 0, new i(str, str2, 0, null))));
            }
        }

        public final void d(long j, boolean z) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(4, 1, 0, new f(j, z))));
        }

        public final void b(long j, byte[] bArr) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + j);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(1, 1, 0, new h(j, bArr))));
        }

        public final void e(long j, boolean z) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(0, 1, 0, new j(j, z))));
        }

        public final void b(long j, int i, String str) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(5, 1, 0, new g(j, i, str))));
        }
    }

    class b extends com.tencent.mm.plugin.c.a.b.b.a {
        final /* synthetic */ b esO;

        b(b bVar) {
            this.esO = bVar;
        }

        public final void d(long j, long j2, long j3) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(6, 0, 0, new d(j, j2, j3))));
        }

        public final void Xl() {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            this.esO.esN.clear();
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(2, 0, 0, null)));
        }

        public final void a(String str, String str2, int i, byte[] bArr) {
            v.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[]{str, str2});
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(3, 0, 0, new i(str, str2, i, bArr))));
        }

        public final void d(long j, boolean z) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(4, 0, 0, new f(j, z))));
        }

        public final void b(long j, byte[] bArr) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + j);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(1, 0, 0, new h(j, bArr))));
        }

        public final void e(long j, boolean z) {
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(this.esO.mHandler.sendMessage(this.esO.mHandler.obtainMessage(0, 0, 0, new j(j, z))));
        }
    }

    private static final class f extends e {
        public f(long j, boolean z) {
            super(j, z);
        }
    }

    private static final class j extends e {
        public j(long j, boolean z) {
            super(j, z);
        }
    }

    public b(Context context, c cVar, ad adVar) {
        this.esL = new com.tencent.mm.plugin.c.a.c.a(adVar);
        if (VERSION.SDK_INT >= 18) {
            this.esK = new com.tencent.mm.plugin.c.a.b.b(adVar);
            com.tencent.mm.plugin.c.a.b.b bVar = this.esK;
            com.tencent.mm.plugin.c.a.b.b.a bVar2 = new b(this);
            v.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.aHq = context;
                bVar.epf = bVar2;
                bVar.epi = com.tencent.mm.plugin.c.a.b.c.Xm();
                if (com.tencent.mm.compatible.util.f.dW(21)) {
                    bVar.epj = com.tencent.mm.plugin.c.a.b.g.Xs();
                }
                if (bVar.Xk()) {
                    bVar.eoz = ((BluetoothManager) bVar.aHq.getSystemService("bluetooth")).getAdapter();
                } else {
                    v.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        com.tencent.mm.plugin.c.a.c.a aVar = this.esL;
        com.tencent.mm.plugin.c.a.c.a.a aVar2 = new a(this);
        v.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.esn = aVar2;
            aVar.eso = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.eso.registerReceiver(aVar.esp, intentFilter);
            aVar.eoz = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(com.tencent.mm.plugin.exdevice.service.v.ajX().frO.htb.getLooper(), this);
        this.esM = cVar;
    }

    public final boolean a(int i, int... iArr) {
        v.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.esK == null) {
                    v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return false;
                } else if (iArr == null) {
                    return this.esK.a(true, new int[0]);
                } else {
                    return this.esK.a(true, iArr);
                }
            case 1:
                if (this.esL != null) {
                    return this.esL.bY(true);
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                return false;
            default:
                Assert.assertTrue(false);
                return false;
        }
    }

    public final void c(long j, long j2, int i) {
        v.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.esK == null) {
                    v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return;
                }
                com.tencent.mm.plugin.c.a.b.b bVar = this.esK;
                v.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.Xk()) {
                    Assert.assertTrue(bVar.mHandler.post(new b(bVar, j, j2)));
                    return;
                } else {
                    v.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                }
            case 1:
                if (this.esL == null) {
                    v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    return;
                }
                com.tencent.mm.plugin.c.a.c.a aVar = this.esL;
                v.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.Xu()) {
                    Assert.assertTrue(aVar.mHandler.post(new b(aVar, j, j2)));
                    return;
                } else {
                    v.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                }
            default:
                Assert.assertTrue(false);
                return;
        }
    }
}
