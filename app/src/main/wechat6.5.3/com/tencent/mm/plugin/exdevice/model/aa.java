package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends com.tencent.mm.plugin.exdevice.service.j.a implements e {
    static Object cCN = new Object();
    private static final byte[] fuG = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static aa fuH;
    static LinkedList<String> fuL = new LinkedList();
    private static HashMap<String, fp> fuM = new HashMap(32);
    final ah dIO = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ aa fuN;

        {
            this.fuN = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ac.ajx().a(0, this.fuN);
            return true;
        }
    }, true);
    boolean ftU = false;
    volatile String fto;
    a fuI;
    HashMap<String, byte[]> fuJ = new HashMap();
    LinkedList<k> fuK = new LinkedList();

    public interface a {
        void b(String str, byte[] bArr, boolean z);
    }

    public static aa ajn() {
        if (fuH != null) {
            return fuH;
        }
        aa aaVar = new aa();
        fuH = aaVar;
        return aaVar;
    }

    private aa() {
    }

    public final void kn(int i) {
        v.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[]{Integer.valueOf(i)});
        this.dIO.QI();
        if (this.ftU) {
            d ajx = ac.ajx();
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (this == null) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            } else if (ajx.frR == null) {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.ajW().frL == null) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.ajW().frL.c(i, ajx.frX)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.ftU = false;
            this.fto = null;
            this.fuJ.clear();
            ak.vy().b(542, this);
            Iterator it = this.fuK.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null) {
                    ak.vy().c(kVar);
                }
            }
            this.fuK.clear();
            if (this.fuI != null) {
                this.fuI.b(null, null, true);
            }
            this.fuI = null;
        } else {
            v.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (cCN) {
            fuL.clear();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, byte[] r14) {
        /*
        r7 = this;
        r0 = r7.fuJ;
        r0 = r0.containsKey(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        if (r11 != 0) goto L_0x0015;
    L_0x000b:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "deviceMac is null";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x0008;
    L_0x0015:
        r0 = ":";
        r1 = "";
        r1 = r11.replaceAll(r0, r1);
        r2 = fuG;
        r0 = com.tencent.mm.sdk.platformtools.be.bl(r14);
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = com.tencent.mm.sdk.platformtools.be.bl(r2);
        if (r0 != 0) goto L_0x0031;
    L_0x002d:
        r0 = r2.length;
        r3 = r14.length;
        if (r0 <= r3) goto L_0x009b;
    L_0x0031:
        r0 = -1;
    L_0x0032:
        r2 = -1;
        if (r0 == r2) goto L_0x00b1;
    L_0x0035:
        r2 = r0 + 9;
        r3 = r14.length;
        if (r2 > r3) goto L_0x00aa;
    L_0x003a:
        r0 = r0 + 9;
        r0 = new byte[r0];
        r2 = 0;
        r3 = 0;
        r4 = r0.length;
        java.lang.System.arraycopy(r14, r2, r0, r3, r4);
        r2 = "MicroMsg.exdevice.ScanDeviceLogic";
        r3 = "hakon, scanFound mac:%s, realAd:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        r5 = 1;
        r6 = com.tencent.mm.plugin.exdevice.j.b.ak(r0);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = r7.fuJ;
        r2.put(r1, r0);
    L_0x005f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.fto;
        r0 = r0.append(r1);
        r1 = "_";
        r0 = r0.append(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r1 = fuM;
        r1 = r1.containsKey(r0);
        if (r1 != 0) goto L_0x00ed;
    L_0x0081:
        r1 = cCN;
        monitor-enter(r1);
        r2 = fuL;	 Catch:{ all -> 0x0098 }
        r2 = r2.contains(r0);	 Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x00b8;
    L_0x008c:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, already doing";
        com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        goto L_0x0008;
    L_0x0098:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        throw r0;
    L_0x009b:
        r0 = 0;
    L_0x009c:
        r3 = r14.length;
        if (r0 >= r3) goto L_0x00a8;
    L_0x009f:
        r3 = com.tencent.mm.plugin.exdevice.j.b.a(r14, r0, r2);
        if (r3 != 0) goto L_0x0032;
    L_0x00a5:
        r0 = r0 + 1;
        goto L_0x009c;
    L_0x00a8:
        r0 = -1;
        goto L_0x0032;
    L_0x00aa:
        r0 = r7.fuJ;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b1:
        r0 = r7.fuJ;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b8:
        r2 = fuL;	 Catch:{ all -> 0x0098 }
        r2.add(r0);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        r1 = new com.tencent.mm.plugin.exdevice.model.k;
        r2 = 1;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r2[r3] = r11;
        r3 = r7.fto;
        r1.<init>(r2, r3);
        r2 = com.tencent.mm.model.ak.vy();
        r3 = 0;
        r2 = r2.a(r1, r3);
        if (r2 == 0) goto L_0x00dd;
    L_0x00d6:
        r0 = r7.fuK;
        r0.add(r1);
        goto L_0x0008;
    L_0x00dd:
        r1 = fuL;
        r1.remove(r0);
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "MMCore.getNetSceneQueue().doScene failed!!!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0008;
    L_0x00ed:
        r1 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, hit cache %s, %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r7.fto;
        r3[r4] = r5;
        r4 = 1;
        r3[r4] = r11;
        com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);
        r1 = fuM;
        r0 = r1.get(r0);
        r0 = (com.tencent.mm.protocal.c.fp) r0;
        r7.a(r0);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.aa.a(int, int, java.lang.String, java.lang.String, java.lang.String, int, byte[]):void");
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = kVar == null ? "" : Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        v.i(str2, str3, objArr);
        this.fuK.remove(kVar);
        if (i != 0 || i2 != 0 || kVar == null) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        } else if (542 == kVar.getType()) {
            Iterator it = ((k) kVar).aji().mfY.iterator();
            while (it.hasNext()) {
                fp fpVar = (fp) it.next();
                if (be.kS(fpVar.mfU)) {
                    v.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                } else {
                    str3 = this.fto + "_" + fpVar.mfU;
                    synchronized (cCN) {
                        if (fuL.contains(str3)) {
                            fuL.remove(str3);
                        }
                    }
                    if (!fuM.containsKey(str3)) {
                        v.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[]{str3});
                        fuM.put(str3, fpVar);
                    }
                    a(fpVar);
                }
            }
        }
    }

    private void a(fp fpVar) {
        if (fpVar == null) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
        } else if (be.kS(fpVar.mfU)) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        } else if (fpVar.mcj != 0) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[]{fpVar.mfU});
        } else if (fpVar.mgb == null || be.kS(fpVar.mgb.eez)) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[]{fpVar.mfU});
        } else if (be.kS(fpVar.mgb.meq) || !fpVar.mgb.meq.equals(this.fto)) {
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[]{fpVar.eeA, this.fto});
        } else {
            byte[] bArr = (byte[]) this.fuJ.get(fpVar.mfU);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = fpVar.mfU;
            objArr[1] = fpVar.mgb.meq;
            objArr[2] = fpVar.mgb.eez;
            objArr[3] = fpVar.eeA;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            v.i(str, str2, objArr);
            if (this.fuI != null) {
                if (bArr != null) {
                    bArr = aj(bArr);
                } else {
                    bArr = null;
                }
                this.fuI.b(fpVar.mgb.eez, bArr, false);
                return;
            }
            v.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
        }
    }

    private static byte[] aj(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            try {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b != (byte) 0) {
                    int i4 = i3 + 1;
                    switch (bArr[i3]) {
                        case (byte) -1:
                            v.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[]{Integer.valueOf(b)});
                            byte[] bArr3 = new byte[(b - 1)];
                            int i5 = b;
                            i = i4;
                            while (i5 > 1) {
                                int i6;
                                if (i2 >= 32 || i2 >= bArr3.length) {
                                    i6 = i;
                                    i = i2;
                                } else {
                                    i4 = i2 + 1;
                                    i6 = i + 1;
                                    bArr3[i2] = bArr[i];
                                    i = i4;
                                }
                                i5--;
                                i2 = i;
                                i = i6;
                            }
                            v.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.ak(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i = (b - 1) + i4;
                            break;
                    }
                }
                return bArr2;
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                v.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return bArr2;
    }
}
