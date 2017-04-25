package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.LongWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a fwK = null;
    private Object cCN = new Object();
    private final HashMap<Long, Long> fwL = new HashMap();
    private g fwM = null;
    ac mHandler = new a(this, v.ajX().frO.htb.getLooper());

    private final class a extends ac {
        final /* synthetic */ a fwN;

        public a(a aVar, Looper looper) {
            this.fwN = aVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    this.fwN.fwM.a(1, 0, null, cVar.esU, cVar.esV, cVar.esW, cVar.esX);
                    return;
                case 2:
                    this.fwN.fwM.a(2, 0, null, null, null, 0, null);
                    return;
                case 3:
                    e eVar = (e) message.obj;
                    this.fwN.fwM.c(eVar.fwR, eVar.dLT, eVar.dLU, eVar.dLV);
                    return;
                case 4:
                    d dVar = (d) message.obj;
                    this.fwN.fwM.b(dVar.esP, dVar.fwP, dVar.fwQ, dVar.dLU);
                    return;
                case 5:
                    b bVar = (b) message.obj;
                    this.fwN.fwM.a(message.arg1, bVar.esP, bVar.frh, bVar.fwO, bVar.frb);
                    return;
                case 8:
                    g gVar = (g) message.obj;
                    this.fwN.a(gVar.fwR, gVar.fwS);
                    return;
                case 9:
                    a.bd(((Long) message.obj).longValue());
                    return;
                case 10:
                    f fVar = (f) message.obj;
                    a.a(this.fwN, fVar.esP, fVar.epb);
                    return;
                case 11:
                    synchronized (this.fwN.cCN) {
                        a.a(this.fwN, ((Long) message.obj).longValue());
                    }
                    return;
                case 12:
                    synchronized (this.fwN.cCN) {
                        this.fwN.bb(((Long) message.obj).longValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static final class b {
        long esP;
        byte[] frb;
        short frh;
        short fwO;

        private b() {
            this.esP = 0;
            this.frh = (short) 0;
            this.fwO = (short) 0;
            this.frb = null;
        }
    }

    private static final class c {
        String esU;
        String esV;
        int esW;
        byte[] esX;

        public c(String str, String str2, int i, byte[] bArr) {
            this.esU = str;
            this.esV = str2;
            this.esW = i;
            this.esX = bArr;
        }
    }

    private static final class d {
        int dLU;
        long esP;
        int fwP;
        int fwQ;

        private d() {
            this.esP = 0;
            this.fwP = 0;
            this.fwQ = 0;
            this.dLU = 0;
        }
    }

    private static final class e {
        int dLT = 0;
        int dLU = 0;
        String dLV = null;
        long fwR = 0;
    }

    private static final class f {
        byte[] epb;
        long esP;

        public f(long j, byte[] bArr) {
            this.esP = j;
            this.epb = bArr;
        }
    }

    private static final class g {
        long fwR;
        p fwS;

        public g(long j, p pVar) {
            this.fwR = j;
            this.fwS = pVar;
        }
    }

    static /* synthetic */ void a(a aVar, long j, byte[] bArr) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKeyImp------ deviceId = %d", new Object[]{Long.valueOf(j)});
        if (aVar.fwL.containsKey(Long.valueOf(j))) {
            Java2CExDevice.setChannelSessionKey(((Long) aVar.fwL.get(Long.valueOf(j))).longValue(), bArr);
        } else {
            v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        }
    }

    static /* synthetic */ boolean a(a aVar, long j) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "startChannelImp deviceId = %d", new Object[]{Long.valueOf(j)});
        if (com.tencent.mm.plugin.exdevice.h.a.p("conneted_device", j)) {
            v.w("MicroMsg.exdevice.BTDeviceManager", "This deviceId is not call stop channel before startChannel, Call it");
            aVar.bb(j);
        }
        LongWrapper longWrapper = new LongWrapper();
        longWrapper.value = -1;
        int createChannel = Java2CExDevice.createChannel(j, longWrapper);
        if (createChannel != 0) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.createChannel Failed, ret = " + createChannel);
            aVar.fwM.b(j, 1, 4, -1);
            return false;
        }
        v.i("MicroMsg.exdevice.BTDeviceManager", "Create channel id is ok, deviceId = %d, channelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(longWrapper.value)});
        aVar.fwL.put(Long.valueOf(j), Long.valueOf(longWrapper.value));
        v.i("MicroMsg.exdevice.BTDeviceManager", "add the device to connected devices : [%d]", new Object[]{Long.valueOf(j)});
        if (com.tencent.mm.plugin.exdevice.h.a.q("conneted_device", j)) {
            int startChannelService = Java2CExDevice.startChannelService(longWrapper.value);
            if (startChannelService == 0) {
                return true;
            }
            v.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startChannelService Failed, ret = " + startChannelService);
            aVar.fwM.b(j, 1, 4, -1);
            return false;
        }
        v.e("MicroMsg.exdevice.BTDeviceManager", "addToSharedPreferences failed!!!");
        aVar.fwM.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ void bd(long j) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", new Object[]{Long.valueOf(j)});
        Java2CExDevice.stopTask(j);
    }

    public a(g gVar) {
        this.fwM = gVar;
        fwK = this;
    }

    public static boolean ko(int i) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.ko(i)) {
            return true;
        }
        v.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        return false;
    }

    public static long[] ajF() {
        return com.tencent.mm.plugin.exdevice.h.a.so("conneted_device");
    }

    private boolean bb(long j) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + j);
        v.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[]{Long.valueOf(j)});
        if (!com.tencent.mm.plugin.exdevice.h.a.r("conneted_device", j)) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.fwL.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.fwL.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.fwL.get(Long.valueOf(j))).longValue());
            return true;
        }
        v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        return false;
    }

    private int a(long j, p pVar) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", new Object[]{Long.valueOf(j)});
        Assert.assertNotNull(pVar);
        try {
            long ajN = pVar.ajS().ajN();
            if (!com.tencent.mm.plugin.exdevice.h.a.p("conneted_device", ajN)) {
                v.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.fwR = j;
                eVar.dLU = -1;
                eVar.dLT = -1;
                eVar.dLV = "Channel is close aready!!!";
                Assert.assertTrue(fwK.mHandler.sendMessage(fwK.mHandler.obtainMessage(3, 0, 0, eVar)));
                return -1;
            } else if (this.fwL.containsKey(Long.valueOf(ajN))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.fwL.get(Long.valueOf(ajN))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.ajS().ajP();
                    accessoryCmd.respCmdID = pVar.ajS().ajQ();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.ajS().ajR(), accessoryCmd, pVar.ajS().ajO()) != 0) {
                            v.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            return -1;
                        }
                        v.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Long.valueOf(ajN), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.ajS().ajR()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID)});
                        return 0;
                    } catch (Throwable e) {
                        v.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.fwM.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        return -1;
                    }
                } catch (Throwable e2) {
                    v.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", new Object[]{e2.getMessage()});
                    v.a("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.fwM.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    return -1;
                }
            } else {
                v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", new Object[]{Long.valueOf(ajN)});
                this.fwM.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                return -1;
            }
        } catch (Throwable e22) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", new Object[]{e22.getMessage()});
            v.a("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.fwM.c(j, -1, -1, "Remote getDeviceId failed!!!");
            return -1;
        }
    }

    public static void c(long j, int i, int i2, String str) {
        Assert.assertNotNull(fwK);
        v.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.fwR = j;
        eVar.dLU = i2;
        eVar.dLT = i;
        eVar.dLV = str;
        Assert.assertTrue(fwK.mHandler.sendMessage(fwK.mHandler.obtainMessage(3, 0, 0, eVar)));
    }

    public static void b(long j, int i, int i2, int i3) {
        Assert.assertNotNull(fwK);
        v.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long bc = fwK.bc(j);
        if (-1 == bc) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        d dVar = new d();
        dVar.esP = bc;
        dVar.dLU = i3;
        dVar.fwQ = i2;
        dVar.fwP = i;
        Assert.assertTrue(fwK.mHandler.sendMessage(fwK.mHandler.obtainMessage(4, 0, 0, dVar)));
    }

    private long bc(long j) {
        if (this.fwL.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.fwL.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    return ((Long) entry.getKey()).longValue();
                }
            }
            Assert.assertTrue(false);
            return -1;
        }
        v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        v.i(str, str2, objArr);
        Assert.assertNotNull(fwK);
        v.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long bc = fwK.bc(j);
        if (-1 == bc) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        b bVar = new b();
        bVar.esP = bc;
        bVar.frb = bArr;
        bVar.fwO = s2;
        bVar.frh = s;
        Assert.assertTrue(fwK.mHandler.sendMessage(fwK.mHandler.obtainMessage(5, i, 0, bVar)));
    }

    public final void ir(int i) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + i);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        v.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
    }

    public final void pv(String str) {
        v.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[]{Integer.valueOf(-1), Integer.valueOf(-1)});
        if (!this.mHandler.post(new Runnable(this) {
            final /* synthetic */ a fwN;

            {
                this.fwN = r1;
            }

            public final void run() {
                this.fwN.fwM.a(0, -1, "", "", "", 0, null);
            }
        })) {
            v.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
    }
}
