package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.c.c.c;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.e.a.qx;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ayg;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {

    private static class a extends d {
        private bii lcd;

        public a(bii com_tencent_mm_protocal_c_bii) {
            this.lcd = com_tencent_mm_protocal_c_bii;
        }

        protected final void execute() {
            String lE = q.lE(this.lcd.ncy);
            v.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[]{lE});
            v.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[]{q.G(lE, false)});
            InputStream byteArrayInputStream = new ByteArrayInputStream(this.lcd.mdy.toByteArray());
            c cVar = new c(8000, 16000);
            cVar.bA(r0);
            byte[] bArr = new byte[320];
            int i = 0;
            while (true) {
                try {
                    i = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e) {
                }
                if (i > 0) {
                    cVar.a(new com.tencent.mm.c.b.g.a(bArr, i), 0);
                } else {
                    cVar.pv();
                    v.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    q.g(lE, (int) this.lcd.ncU, 0);
                    com.tencent.mm.modelvoice.m.LB().run();
                    v.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mj(this.lcd.ncy);
                    return;
                }
            }
        }

        public final String getName() {
            return "SendVioceMsgTask";
        }
    }

    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11022));
        arrayList.add(Integer.valueOf(11023));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(11024));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        return arrayList;
    }

    protected final boolean sA(int i) {
        switch (i) {
            case 11023:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11022:
                bii com_tencent_mm_protocal_c_bii = new bii();
                try {
                    com_tencent_mm_protocal_c_bii.az(bArr);
                } catch (IOException e) {
                }
                com.tencent.mm.plugin.wear.model.a.bhH().laX.a(new a(com_tencent_mm_protocal_c_bii));
                com.tencent.mm.plugin.wear.model.a.bhH().laT.DJ(com_tencent_mm_protocal_c_bii.ncy);
                com.tencent.mm.plugin.wear.model.c.a.cL(2, com_tencent_mm_protocal_c_bii.maG);
                com.tencent.mm.plugin.wear.model.c.a.sy(2);
                break;
            case 11023:
                bih com_tencent_mm_protocal_c_bih = new bih();
                try {
                    com_tencent_mm_protocal_c_bih.az(bArr);
                } catch (IOException e2) {
                }
                com.tencent.mm.pluginsdk.j.a.bmt().x(com_tencent_mm_protocal_c_bih.ncy, com_tencent_mm_protocal_c_bih.mzO, com.tencent.mm.model.m.fp(com_tencent_mm_protocal_c_bih.ncy));
                ak.yW();
                com.tencent.mm.model.c.wK().Mj(com_tencent_mm_protocal_c_bih.ncy);
                com.tencent.mm.plugin.wear.model.c.a.cL(3, com_tencent_mm_protocal_c_bih.maG);
                com.tencent.mm.plugin.wear.model.c.a.sy(5);
                break;
            case 11024:
                bif com_tencent_mm_protocal_c_bif = new bif();
                try {
                    com_tencent_mm_protocal_c_bif.az(bArr);
                } catch (IOException e3) {
                }
                com.tencent.mm.pluginsdk.j.a.bmr().l(aa.getContext(), com_tencent_mm_protocal_c_bif.ncy, com_tencent_mm_protocal_c_bif.mpI);
                ak.yW();
                com.tencent.mm.model.c.wK().Mj(com_tencent_mm_protocal_c_bif.ncy);
                com.tencent.mm.plugin.wear.model.c.a.cL(7, com_tencent_mm_protocal_c_bif.maG);
                com.tencent.mm.plugin.wear.model.c.a.sy(3);
                break;
            case 11025:
                big com_tencent_mm_protocal_c_big = new big();
                try {
                    com_tencent_mm_protocal_c_big.az(bArr);
                } catch (IOException e4) {
                }
                com.tencent.mm.pluginsdk.j.a.bmt().x(com_tencent_mm_protocal_c_big.ncy, com_tencent_mm_protocal_c_big.mzO, com.tencent.mm.model.m.fp(com_tencent_mm_protocal_c_big.ncy));
                com.tencent.mm.pluginsdk.j.a.bmr().l(aa.getContext(), com_tencent_mm_protocal_c_big.ncy, com_tencent_mm_protocal_c_big.mpI);
                ak.yW();
                com.tencent.mm.model.c.wK().Mj(com_tencent_mm_protocal_c_big.ncy);
                com.tencent.mm.plugin.wear.model.c.a.cL(8, com_tencent_mm_protocal_c_big.maG);
                com.tencent.mm.plugin.wear.model.c.a.sy(4);
                break;
            case 11026:
                bim com_tencent_mm_protocal_c_bim = new bim();
                try {
                    com_tencent_mm_protocal_c_bim.az(bArr);
                } catch (IOException e5) {
                }
                com.tencent.mm.plugin.wear.model.a.bhH();
                bhl com_tencent_mm_protocal_c_bhl = com.tencent.mm.plugin.wear.model.a.bhH().laR.lbj.lcb;
                if (com_tencent_mm_protocal_c_bhl != null) {
                    v.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bim.ncZ), o.F("yyyy-MM-dd HH:mm:ss", com_tencent_mm_protocal_c_bim.nda / 1000)});
                    biu com_tencent_mm_protocal_c_biu = new biu();
                    ayg com_tencent_mm_protocal_c_ayg = new ayg();
                    com_tencent_mm_protocal_c_ayg.efk = com_tencent_mm_protocal_c_bim.ncZ > 0 ? com_tencent_mm_protocal_c_bim.ncZ : 0;
                    com_tencent_mm_protocal_c_ayg.mqK = (int) (com_tencent_mm_protocal_c_bim.nda / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(com_tencent_mm_protocal_c_bim.nda);
                    com_tencent_mm_protocal_c_ayg.mVJ = instance.get(1);
                    com_tencent_mm_protocal_c_ayg.mVK = instance.get(2) + 1;
                    com_tencent_mm_protocal_c_ayg.mVL = instance.get(5);
                    com_tencent_mm_protocal_c_ayg.mVM = instance.get(11);
                    com_tencent_mm_protocal_c_ayg.mVN = instance.get(12);
                    com_tencent_mm_protocal_c_ayg.mVO = instance.get(13);
                    com_tencent_mm_protocal_c_biu.ndm.add(com_tencent_mm_protocal_c_ayg);
                    qx qxVar = new qx();
                    try {
                        qxVar.bsC.data = com_tencent_mm_protocal_c_biu.toByteArray();
                    } catch (IOException e6) {
                    }
                    qxVar.bsC.aYt = 4;
                    qxVar.bsC.aRh = com_tencent_mm_protocal_c_bhl.ncr;
                    qxVar.bsC.aZN = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.c.a.nhr.z(qxVar);
                    break;
                }
                v.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (com.tencent.mm.plugin.wear.model.a.bhH().laR.bhM() && j.sU().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    qv qvVar = new qv();
                    qvVar.bsq.action = 1;
                    qvVar.bsq.aYG = j;
                    com.tencent.mm.sdk.c.a.nhr.a(qvVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.cL(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.sy(11);
                    break;
                }
                return null;
                break;
        }
        return null;
    }
}
