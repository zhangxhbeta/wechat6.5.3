package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class l extends k implements j {
    private static Vector<String> jjX = new Vector();
    final int aYX;
    private b cif;
    public e cii;
    private String desc = "";
    private boolean eDI = false;
    private ArrayList<com.tencent.mm.plugin.sns.storage.k> eEz = new ArrayList();
    private boolean jjU;
    private long jjV = 0;
    private long jjW = 0;
    public int jjY = 0;
    public int jjZ = 0;

    public static synchronized boolean Ak(String str) {
        boolean z;
        synchronized (l.class) {
            if (jjX.contains(str)) {
                z = false;
            } else {
                jjX.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Al(String str) {
        synchronized (l.class) {
            jjX.remove(str);
        }
        return true;
    }

    public l(String str) {
        a aVar = new a();
        aVar.czn = new avp();
        aVar.czo = new avq();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.czm = 601;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.jjV = 0;
        this.jjU = 0 == 0;
        this.aYX = 2;
        avp com_tencent_mm_protocal_c_avp = (avp) this.cif.czk.czs;
        com_tencent_mm_protocal_c_avp.mSV = "";
        com_tencent_mm_protocal_c_avp.mSW = 0;
        com_tencent_mm_protocal_c_avp.mSX = str;
        com_tencent_mm_protocal_c_avp.mSY = 1;
        v.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[]{i.cE(0), str, Integer.valueOf(0)});
    }

    private com.tencent.mm.plugin.sns.storage.k b(awa com_tencent_mm_protocal_c_awa) {
        com.tencent.mm.plugin.sns.storage.k kVar = new com.tencent.mm.plugin.sns.storage.k();
        String str = new String(com_tencent_mm_protocal_c_awa.mTg.mQw.toByteArray());
        v.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq)});
        if (!kVar.Bo(str)) {
            return null;
        }
        com_tencent_mm_protocal_c_awa.mTg.ba(new byte[0]);
        kVar.field_userName = com_tencent_mm_protocal_c_awa.mdw;
        kVar.fw(com_tencent_mm_protocal_c_awa.hNS);
        kVar.field_likeFlag = com_tencent_mm_protocal_c_awa.mTh;
        kVar.cY(com_tencent_mm_protocal_c_awa.mjq);
        kVar.da(com_tencent_mm_protocal_c_awa.mjq);
        kVar.qA(this.aYX);
        try {
            kVar.aC(com_tencent_mm_protocal_c_awa.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
        }
        azr aUp = kVar.aUp();
        aUp.gln = com_tencent_mm_protocal_c_awa.mdw;
        kVar.field_pravited = aUp.mHR;
        v.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + com_tencent_mm_protocal_c_awa.mTr);
        kVar.aUI();
        kVar.b(aUp);
        kVar.field_type = aUp.mWq.mol;
        return kVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        avq com_tencent_mm_protocal_c_avq = (avq) ((b) pVar).czl.czs;
        if (pVar.ze().lWU == 207 || pVar.ze().lWU == 0 || pVar.ze().lWU == 212) {
            this.eDI = pVar.ze().lWU == 212;
            this.jjY = com_tencent_mm_protocal_c_avq.mSZ;
            this.desc = com_tencent_mm_protocal_c_avq.mdJ;
            i.cF(this.jjV);
            v.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avq.mJw), this.desc});
            Iterator it = com_tencent_mm_protocal_c_avq.mfQ.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.k b = b((awa) it.next());
                if (b != null) {
                    this.eEz.add(b);
                }
            }
            Al("@__classify_timeline");
            this.cii.a(i2, i3, str, this);
            return;
        }
        Al("@__classify_timeline");
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 601;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
