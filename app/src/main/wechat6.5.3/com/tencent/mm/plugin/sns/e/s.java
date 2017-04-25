package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements j {
    private String aZy;
    private int bdf = 1;
    private b cif;
    public e cii;
    private LinkedList<awv> jkD = null;

    public s() {
        String str;
        a aVar = new a();
        aVar.czn = new aww();
        aVar.czo = new awx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.czm = 292;
        aVar.czp = 116;
        aVar.czq = 1000000116;
        this.cif = aVar.Bv();
        String str2 = ad.aSG().Bu("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.aZy = str;
        aww com_tencent_mm_protocal_c_aww = (aww) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aww.lZm = 1;
        com_tencent_mm_protocal_c_aww.mUk = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 292;
    }

    private static q a(q qVar, awv com_tencent_mm_protocal_c_awv) {
        qVar.field_tagId = com_tencent_mm_protocal_c_awv.mUj;
        qVar.field_tagName = be.ah(com_tencent_mm_protocal_c_awv.gmM, "");
        qVar.field_count = com_tencent_mm_protocal_c_awv.eet;
        qVar.bt(com_tencent_mm_protocal_c_awv.eeu);
        v.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + com_tencent_mm_protocal_c_awv.toString());
        return qVar;
    }

    private static boolean a(List<Long> list, Long l) {
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> cN(long j) {
        List<String> linkedList = new LinkedList();
        if (this.jkD == null) {
            return linkedList;
        }
        Iterator it = this.jkD.iterator();
        while (it.hasNext()) {
            awv com_tencent_mm_protocal_c_awv = (awv) it.next();
            if (com_tencent_mm_protocal_c_awv.mUj == j) {
                it = com_tencent_mm_protocal_c_awv.eeu.iterator();
                while (it.hasNext()) {
                    linkedList.add(((arf) it.next()).mQy);
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awx com_tencent_mm_protocal_c_awx = (awx) ((b) pVar).czl.czs;
            this.jkD = com_tencent_mm_protocal_c_awx.eeu;
            String str2 = com_tencent_mm_protocal_c_awx.mUk;
            if (this.aZy.equals(str2)) {
                this.cii.a(i2, i3, str, this);
                return;
            }
            if (this.bdf != 1) {
                this.cii.a(i2, i3, str, this);
            }
            List aVi = ad.aSI().aVi();
            Iterator it = aVi.iterator();
            while (it.hasNext()) {
                Object obj;
                Long l = (Long) it.next();
                Iterator it2 = com_tencent_mm_protocal_c_awx.eeu.iterator();
                while (it2.hasNext()) {
                    if (l.longValue() == ((awv) it2.next()).mUj) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    it.remove();
                    ad.aSI().di(l.longValue());
                }
            }
            Iterator it3 = com_tencent_mm_protocal_c_awx.eeu.iterator();
            while (it3.hasNext()) {
                awv com_tencent_mm_protocal_c_awv = (awv) it3.next();
                q df;
                if (a(aVi, Long.valueOf(com_tencent_mm_protocal_c_awv.mUj))) {
                    df = ad.aSI().df(com_tencent_mm_protocal_c_awv.mUj);
                    if (!df.field_tagName.equals(com_tencent_mm_protocal_c_awv.gmM) || df.field_count != com_tencent_mm_protocal_c_awv.eet || b(df, com_tencent_mm_protocal_c_awv)) {
                        a(df, com_tencent_mm_protocal_c_awv);
                        ad.aSI().a(df);
                    }
                } else {
                    df = new q();
                    a(df, com_tencent_mm_protocal_c_awv);
                    ad.aSI().a(df);
                }
            }
            i Bu = ad.aSG().Bu("@__weixintsnstag");
            Bu.field_md5 = str2;
            ad.aSG().a(Bu);
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    private static boolean b(q qVar, awv com_tencent_mm_protocal_c_awv) {
        String[] split = qVar.field_memberList.split(",");
        Iterator it = com_tencent_mm_protocal_c_awv.eeu.iterator();
        while (it.hasNext()) {
            boolean z;
            arf com_tencent_mm_protocal_c_arf = (arf) it.next();
            for (String equals : split) {
                if (equals.equals(com_tencent_mm_protocal_c_arf)) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
