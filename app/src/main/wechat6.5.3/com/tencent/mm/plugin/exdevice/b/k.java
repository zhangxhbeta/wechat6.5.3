package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.b.bk;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.v.e {
    public static k frj = null;
    private final HashMap<Long, e> fri;
    public HashMap<String, Integer> frk;
    public ac mHandler;

    private class a extends ac {
        final /* synthetic */ k frl;

        public a(k kVar, Looper looper) {
            this.frl = kVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            v.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[]{Integer.valueOf(message.what)});
            e eVar;
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    e eVar2 = (e) this.frl.fri.get(Long.valueOf(longValue));
                    if (eVar2 == null) {
                        v.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[]{Long.valueOf(longValue)});
                        return;
                    }
                    eVar2.aix().b(-1, "", null);
                    u.ajW().a(new h(eVar2.aix()));
                    this.frl.fri.remove(Long.valueOf(longValue));
                    return;
                case 1:
                    f fVar = (f) message.obj;
                    if (!u.ajV().bk(fVar.esP)) {
                        v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(fVar.esP)});
                        fVar.b(-2, "", new byte[0]);
                        u.ajW().a(new h(fVar));
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(message.arg1)});
                        fVar.b(-1, "", new byte[0]);
                        u.ajW().a(new h(fVar));
                        return;
                    } else {
                        bk sp = com.tencent.mm.plugin.exdevice.model.ac.ajq().sp(fVar.esP);
                        if (sp == null) {
                            v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) sp.bKZ)) {
                            v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            fVar.b(-5, "Device Is Block", null);
                            u.ajW().a(new h(fVar));
                            return;
                        }
                        long aiz = f.aiz();
                        com.tencent.mm.plugin.exdevice.e.k kVar = (com.tencent.mm.plugin.exdevice.e.k) fVar.aiu();
                        if (kVar == null) {
                            v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            fVar.b(-4, "Decode failed", null);
                            u.ajW().a(new h(fVar));
                            return;
                        }
                        Integer num = (Integer) this.frl.frk.get(sp.field_deviceID);
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        v.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[]{num});
                        d dVar;
                        e eVar3;
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                com.tencent.mm.plugin.exdevice.model.ac.ajB();
                                com.tencent.mm.plugin.exdevice.model.e.d(sp.field_deviceID, sp.field_brandName, kVar.eew.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                ak.vy().a(new w(fVar.esP, sp.field_deviceType, sp.field_deviceID, aiz, be.Ni(), kVar.eew.toByteArray(), kVar.efm), 0);
                                dVar = new d(this.frl, aiz);
                                this.frl.mHandler.postDelayed(dVar, 30000);
                                eVar3 = new e();
                                eVar3.a(fVar);
                                eVar3.a(dVar);
                                eVar3.frq = 0;
                                this.frl.fri.put(Long.valueOf(aiz), eVar3);
                                return;
                            }
                            return;
                        } else if (kVar.efm == 10001) {
                            com.tencent.mm.plugin.exdevice.model.ac.ajB();
                            com.tencent.mm.plugin.exdevice.model.e.d(sp.field_deviceID, sp.field_brandName, kVar.eew.toByteArray());
                            return;
                        } else {
                            ak.vy().a(new w(fVar.esP, sp.field_deviceType, sp.field_deviceID, aiz, be.Ni(), kVar.eew.toByteArray(), kVar.efm), 0);
                            dVar = new d(this.frl, aiz);
                            this.frl.mHandler.postDelayed(dVar, 30000);
                            eVar3 = new e();
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.frq = 0;
                            this.frl.fri.put(Long.valueOf(aiz), eVar3);
                            return;
                        }
                    }
                case 2:
                    b bVar = (b) message.obj;
                    if (bVar.dLT != 0 || bVar.dLU != 0) {
                        w wVar = (w) bVar.frm;
                        Assert.assertNotNull(wVar.fut);
                        long j = ((asr) wVar.fut.czk.czs).mRm.mDf;
                        eVar = (e) this.frl.fri.get(Long.valueOf(j));
                        if (eVar == null) {
                            v.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        int i;
                        f aix = eVar.aix();
                        switch (bVar.dLU) {
                            case -417:
                                i = -5;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                        aix.b(i, bVar.dLV, null);
                        u.ajW().a(new h(eVar.aix()));
                        this.frl.mHandler.removeCallbacks(eVar.aiy());
                        this.frl.fri.remove(Long.valueOf(j));
                        return;
                    }
                    return;
                case 3:
                    c cVar = (c) message.obj;
                    eVar = (e) this.frl.fri.get(Long.valueOf(cVar.epy));
                    if (eVar == null) {
                        v.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(cVar.epy)});
                        return;
                    }
                    eVar.fro.b(0, "", cVar.epb);
                    u.ajW().a(new h(eVar.aix()));
                    this.frl.mHandler.removeCallbacks(eVar.aiy());
                    this.frl.fri.remove(Long.valueOf(cVar.epy));
                    return;
                default:
                    v.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }
    }

    private static final class b {
        public int dLT;
        public int dLU;
        public String dLV;
        public com.tencent.mm.v.k frm;

        private b() {
            this.dLU = 0;
            this.dLT = 0;
            this.dLV = null;
            this.frm = null;
        }
    }

    private static final class c {
        public byte[] epb;
        public long epy;

        private c() {
            this.epy = 0;
            this.epb = null;
        }
    }

    private final class d implements Runnable {
        final /* synthetic */ k frl;
        private long frn = -1;

        public d(k kVar, long j) {
            this.frl = kVar;
            Assert.assertTrue(j >= 0);
            this.frn = j;
        }

        public final void run() {
            v.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[]{Long.valueOf(this.frn)});
            this.frl.mHandler.obtainMessage(0, Long.valueOf(this.frn)).sendToTarget();
        }
    }

    private static final class e {
        f fro;
        private d frp;
        int frq;

        private e() {
            this.fro = null;
            this.frp = null;
            this.frq = 0;
        }

        public final void a(f fVar) {
            Assert.assertNotNull(fVar);
            this.fro = fVar;
        }

        public final void a(d dVar) {
            Assert.assertNotNull(dVar);
            this.frp = dVar;
        }

        public final f aix() {
            Assert.assertNotNull(this.fro);
            return this.fro;
        }

        public final d aiy() {
            Assert.assertNotNull(this.frp);
            return this.frp;
        }
    }

    public static final class f {
        private static f frs = null;
        private long frr;

        public f() {
            long j = 0;
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                v.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[]{Long.valueOf(j)});
            }
            this.frr = j;
        }

        public static long aiz() {
            if (frs == null) {
                frs = new f();
            }
            f fVar = frs;
            if (Long.MAX_VALUE == fVar.frr) {
                v.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.frr = 0;
            }
            long j = fVar.frr + 1;
            fVar.frr = j;
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                v.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[]{Long.valueOf(j)});
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            return j;
        }
    }

    public static k aiw() {
        if (frj != null) {
            return frj;
        }
        k kVar = new k();
        frj = kVar;
        return kVar;
    }

    private k() {
        this.fri = new HashMap();
        this.mHandler = null;
        this.frk = new HashMap();
        this.mHandler = new a(this, ak.vA().htb.getLooper());
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        b bVar = new b();
        bVar.dLU = i2;
        bVar.dLT = i;
        bVar.dLV = str;
        bVar.frm = kVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
    }
}
