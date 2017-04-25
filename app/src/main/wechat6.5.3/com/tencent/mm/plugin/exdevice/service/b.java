package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.plugin.c.a.b.d;
import com.tencent.mm.plugin.c.a.c.a;
import com.tencent.mm.plugin.c.a.d.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b fwX = null;
    private com.tencent.mm.plugin.c.a.d.b fwT = null;
    private final Vector<r> fwU = new Vector();
    private final HashMap<Long, Integer> fwV = new HashMap();
    private final HashMap<Long, Integer> fwW = new HashMap();
    private CountDownLatch fwY;
    private ac mHandler = new ac(v.ajX().frO.htb.getLooper());

    static /* synthetic */ void a(b bVar, long j, long j2) {
        boolean z = false;
        if (bVar.fwV.containsKey(Long.valueOf(j))) {
            bVar.fwT.c(j, j2, ((Integer) bVar.fwV.get(Long.valueOf(j))).intValue());
            return;
        }
        int intValue;
        v ajX = v.ajX();
        if (ajX.fxA.containsKey(Long.valueOf(j))) {
            intValue = ((Integer) ajX.fxA.get(Long.valueOf(j))).intValue();
        } else {
            v.e("MicroMsg.exdevice.MMExDevicePushCore", "getBluetoothVersionByDeviceId Failed!!! Cannot find BLuetoothVersion by DeviceId(%d)", new Object[]{Long.valueOf(j)});
            intValue = -1;
        }
        Assert.assertTrue(-1 != intValue);
        String br = com.tencent.mm.plugin.exdevice.j.b.br(j);
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "insertDeviceIdTypeMap deviceid = %s, BTVersion = %d", new Object[]{br, Integer.valueOf(intValue)});
        Assert.assertNotNull(br);
        if (1 == intValue || intValue == 0) {
            z = true;
        }
        Assert.assertTrue(z);
        long sE = com.tencent.mm.plugin.exdevice.j.b.sE(br);
        if (!bVar.fwV.containsKey(Long.valueOf(sE))) {
            bVar.fwV.put(Long.valueOf(sE), Integer.valueOf(intValue));
        }
        bVar.fwT.c(j, j2, intValue);
    }

    static /* synthetic */ boolean a(b bVar, int i) {
        boolean a;
        com.tencent.mm.plugin.c.a.d.b bVar2 = bVar.fwT;
        v.i("MicroMsg.exdevice.BluetoothSDKManager", "***stopScan*** aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (bVar2.esK != null) {
                    a = bVar2.esK.a(false, new int[0]);
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                a = false;
                break;
            case 1:
                if (bVar2.esL != null) {
                    a = bVar2.esL.bY(false);
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                a = false;
                break;
            default:
                Assert.assertTrue(false);
                a = false;
                break;
        }
        if (a) {
            return true;
        }
        v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.stopScan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, int i, r rVar, int[] iArr) {
        if (rVar == null) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        if (iArr == null ? bVar.fwT.a(i, new int[0]) : bVar.fwT.a(i, iArr)) {
            bVar.fwU.add(rVar);
            return true;
        }
        v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (rVar == null) {
            return false;
        }
        rVar.pv("scanImp: mBTSDKMrg.scan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, long j) {
        boolean z = true;
        Assert.assertTrue(bVar.fwW.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.c.a.d.b bVar2 = bVar.fwT;
        int intValue = ((Integer) bVar.fwW.get(Long.valueOf(j))).intValue();
        v.i("MicroMsg.exdevice.BluetoothSDKManager", "***connect*** aSessionId = " + j + " aBluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.esK != null) {
                    z = bVar2.esK.connect(j);
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.esL != null) {
                    a aVar = bVar2.esL;
                    v.i("MicroMsg.exdevice.BluetoothChatManager", "connect, session id = %d, secure = %s", new Object[]{Long.valueOf(j), "true"});
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.Xu()) {
                        v.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.c.a.c.b bVar3 = (com.tencent.mm.plugin.c.a.c.b) aVar.epg.get(Long.valueOf(j));
                    Assert.assertTrue(bVar3 != null);
                    v.i("MicroMsg.exdevice.BluetoothChatSession", "connect");
                    if (bVar3.epz != null) {
                        bVar3.mState = 2;
                        if (bVar3.ess != null) {
                            bVar3.ess.disconnect();
                            bVar3.ess = null;
                        }
                        bVar3.ess = new com.tencent.mm.plugin.c.a.c.c.a(bVar3, aVar, bVar3.epz, true);
                        com.tencent.mm.plugin.c.a.c.c.a aVar2 = bVar3.ess;
                        v.i("MicroMsg.exdevice.ConnectThread", "------connect------");
                        if (!aVar2.mHandler.sendMessage(aVar2.mHandler.obtainMessage(0))) {
                            v.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(0)});
                            if (aVar2.esy != null) {
                                aVar2.esy.esn.d(aVar2.esx.epy, false);
                                break;
                            }
                        }
                    }
                    v.e("MicroMsg.exdevice.BluetoothChatSession", "Can not found remote device(" + com.tencent.mm.plugin.c.a.e.a.aL(bVar3.esr) + ")");
                    if (aVar != null) {
                        aVar.esn.b(bVar3.epy, 7, "Device not found");
                    }
                    z = false;
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.connect failed!!!");
            bVar.d(j, false);
        }
        return z;
    }

    static /* synthetic */ boolean a(b bVar, long j, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(bVar.fwW.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.c.a.d.b bVar2 = bVar.fwT;
        int intValue = ((Integer) bVar.fwW.get(Long.valueOf(j))).intValue();
        Assert.assertNotNull(bArr);
        v.i("MicroMsg.exdevice.BluetoothSDKManager", "***SendData*** sessionId = " + j + "bluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.esK != null) {
                    com.tencent.mm.plugin.c.a.b.b bVar3 = bVar2.esK;
                    v.i("MicroMsg.exdevice.BluetoothLEManager", "------writeData------ sessionId = %d, data length = %d", new Object[]{Long.valueOf(j), Integer.valueOf(bArr.length)});
                    Assert.assertTrue(bVar3.mIsInit);
                    if (!bVar3.Xk()) {
                        v.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                        z = false;
                        break;
                    }
                    d dVar = (d) bVar3.epg.get(String.valueOf(j));
                    if (dVar != null) {
                        v.i("MicroMsg.exdevice.BluetoothLESession", "------writeData------length = %d", new Object[]{Integer.valueOf(bArr.length)});
                        v.d("MicroMsg.exdevice.BluetoothLESession", "writeData data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.ak(bArr)});
                        z = dVar.mHandler.sendMessage(dVar.mHandler.obtainMessage(3, bArr));
                        break;
                    }
                    v.w("MicroMsg.exdevice.BluetoothLEManager", "session is null, may be this session is closed");
                    z = false;
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.esL != null) {
                    a aVar = bVar2.esL;
                    v.i("MicroMsg.exdevice.BluetoothChatManager", "writeData to: " + j);
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.Xu()) {
                        v.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.c.a.c.b bVar4 = (com.tencent.mm.plugin.c.a.c.b) aVar.epg.get(Long.valueOf(j));
                    if (bVar4 == null) {
                        z2 = false;
                    }
                    Assert.assertTrue(z2);
                    v.i("MicroMsg.exdevice.BluetoothChatSession", "write");
                    if (bVar4.esu == null) {
                        z = false;
                        break;
                    }
                    z = bVar4.esu.ad(bArr);
                    break;
                }
                v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.sendData failed!!!");
            bVar.e(j, false);
        }
        return z;
    }

    static /* synthetic */ void b(b bVar, long j) {
        boolean z = true;
        if (bVar.fwV.containsKey(Long.valueOf(j))) {
            com.tencent.mm.plugin.c.a.d.b bVar2 = bVar.fwT;
            int intValue = ((Integer) bVar.fwW.get(Long.valueOf(j))).intValue();
            v.i("MicroMsg.exdevice.BluetoothSDKManager", "***Destroy Session*** aSessionId = " + j + " aBluetoothVersion" + intValue);
            switch (intValue) {
                case 0:
                    if (bVar2.esK == null) {
                        v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        return;
                    }
                    com.tencent.mm.plugin.c.a.b.b bVar3 = bVar2.esK;
                    v.i("MicroMsg.exdevice.BluetoothLEManager", "------destroySession------ sessionId = %d", new Object[]{Long.valueOf(j)});
                    Assert.assertTrue(bVar3.mIsInit);
                    if (bVar3.Xk()) {
                        d dVar = (d) bVar3.epg.remove(String.valueOf(j));
                        if (dVar == null) {
                            v.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot find BluetoothLESession by sessionId(%d)", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        dVar.close();
                        return;
                    }
                    v.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                case 1:
                    if (bVar2.esL == null) {
                        v.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        return;
                    }
                    a aVar = bVar2.esL;
                    v.i("MicroMsg.exdevice.BluetoothChatManager", "------destroySession------ sessionId = %d", new Object[]{Long.valueOf(j)});
                    Assert.assertTrue(aVar.mIsInit);
                    if (aVar.Xu()) {
                        com.tencent.mm.plugin.c.a.c.b bVar4 = (com.tencent.mm.plugin.c.a.c.b) aVar.epg.remove(Long.valueOf(j));
                        if (bVar4 == null) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        bVar4.disconnect();
                        return;
                    }
                    v.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                default:
                    Assert.assertTrue(false);
                    return;
            }
        }
        v.w("MicroMsg.exdevice.BluetoothSDKAdapter", "the session not exist");
    }

    public b() {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId())});
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.fwT = new com.tencent.mm.plugin.c.a.d.b(aa.getContext(), this, v.ajX().frO);
        } else if (r0 == r2) {
            v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.fwT = new com.tencent.mm.plugin.c.a.d.b(aa.getContext(), this, v.ajX().frO);
        } else {
            new ac(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable(this) {
                final /* synthetic */ b fwZ;

                {
                    this.fwZ = r1;
                }

                public final void run() {
                    this.fwZ.fwT = new com.tencent.mm.plugin.c.a.d.b(aa.getContext(), this.fwZ, v.ajX().frO);
                    v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
                    this.fwZ.fwY.countDown();
                }
            });
            this.fwY = new CountDownLatch(1);
            try {
                this.fwY.await();
            } catch (InterruptedException e) {
            }
            v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
        }
    }

    private static b ajG() {
        if (fwX != null) {
            return fwX;
        }
        b bVar = new b();
        fwX = bVar;
        return bVar;
    }

    public static boolean a(final int i, final r rVar, final int... iArr) {
        if (rVar == null) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            return false;
        }
        final b ajG = ajG();
        boolean post = ajG.mHandler.post(new Runnable() {
            public final void run() {
                if (!b.a(ajG, i, rVar, iArr)) {
                    v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        return post;
    }

    public static boolean ko(final int i) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[]{Integer.valueOf(i)});
        final b ajG = ajG();
        boolean post = ajG.mHandler.post(new Runnable() {
            public final void run() {
                if (!b.a(ajG, i)) {
                    v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
            }
        });
        if (!post) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void createSession(long j, long j2) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        final b ajG = ajG();
        final long j3 = j;
        final long j4 = j2;
        if (!ajG.mHandler.post(new Runnable() {
            public final void run() {
                b.a(ajG, j3, j4);
            }
        })) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
    }

    public static boolean sendData(final long j, final byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        v.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        final b ajG = ajG();
        boolean post = ajG.mHandler.post(new Runnable() {
            public final void run() {
                if (!b.a(ajG, j, bArr)) {
                    v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
            }
        });
        if (!post) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static boolean connect(final long j) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        final b ajG = ajG();
        boolean post = ajG.mHandler.post(new Runnable() {
            public final void run() {
                if (!b.a(ajG, j)) {
                    v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
            }
        });
        if (!post) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void destroySession(final long j) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        final b ajG = ajG();
        if (!ajG.mHandler.post(new Runnable() {
            public final void run() {
                b.b(ajG, j);
            }
        })) {
            v.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
    }

    public final void d(long j, long j2, long j3) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.fwV.containsKey(Long.valueOf(j2)));
        if (!this.fwW.containsKey(Long.valueOf(j))) {
            this.fwW.put(Long.valueOf(j), this.fwV.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
    }

    public final void ir(int i) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[]{Integer.valueOf(i)});
        if (this.fwU.isEmpty()) {
            v.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.fwU.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.ir(i);
            }
        }
        this.fwU.clear();
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        v.d(str3, str4, objArr);
        if (this.fwU.isEmpty()) {
            v.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.fwU.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
    }

    public final void d(long j, boolean z) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
        } else {
            Java2CExDevice.onBluetoothDisconnected(j);
        }
    }

    public final void b(long j, byte[] bArr) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + j);
        Java2CExDevice.onBluetoothRecvData(j, bArr);
    }

    public final void e(long j, boolean z) {
        v.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
        } else {
            Java2CExDevice.onBluetoothError(j, 0);
        }
    }

    public final void aK(long j) {
        Java2CExDevice.onBluetoothError(j, 0);
    }
}
