package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.Map;

public final class x extends k implements j {
    public long bao = -1;
    private final long cZm = 60000;
    private Runnable cZn;
    public com.tencent.mm.v.b cif;
    private e cii;
    public int errCode;
    public int errType;

    public static final class a {
        public String cZo = "";
        public String cZp = "";
        public String desc = "";
        public int type = 5;
    }

    public static final class b {
        public LinkedList<a> cZq;
        public String desc;
        public String title;

        public static LinkedList<a> e(Map<String, String> map, String str) {
            LinkedList<a> linkedList = new LinkedList();
            int i = 0;
            while (i < BaseReportManager.MAX_READ_COUNT) {
                String str2 = str + ".action" + (i > 0 ? Integer.valueOf(i) : "");
                try {
                    int intValue = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                    a aVar = new a();
                    if (intValue != 5) {
                        return linkedList;
                    }
                    aVar.cZo = be.ma((String) map.get(str2 + ".iconurl"));
                    aVar.desc = be.ma((String) map.get(str2 + ".desc"));
                    aVar.cZp = be.ma((String) map.get(str2 + ".link"));
                    if (be.kS(aVar.cZo) && be.kS(aVar.desc) && be.kS(aVar.cZp)) {
                        return linkedList;
                    }
                    linkedList.add(aVar);
                    i++;
                } catch (Exception e) {
                    v.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                    return linkedList;
                }
            }
            return linkedList;
        }
    }

    public x(float f, float f2, long j) {
        amz com_tencent_mm_protocal_c_amz = new amz();
        com_tencent_mm_protocal_c_amz.mjM = f;
        com_tencent_mm_protocal_c_amz.mjN = f2;
        com_tencent_mm_protocal_c_amz.mrD = 1;
        com_tencent_mm_protocal_c_amz.mrA = 0;
        a(com_tencent_mm_protocal_c_amz, 1, -10000.0f, -10000.0f);
        this.bao = j;
    }

    public x(arl com_tencent_mm_protocal_c_arl) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = com_tencent_mm_protocal_c_arl;
        aVar.czo = new arm();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.czm = 424;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public x(amz com_tencent_mm_protocal_c_amz, float f, float f2) {
        a(com_tencent_mm_protocal_c_amz, 0, f, f2);
    }

    private void a(amz com_tencent_mm_protocal_c_amz, int i, float f, float f2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new arl();
        aVar.czo = new arm();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.czm = 424;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        arl com_tencent_mm_protocal_c_arl = (arl) this.cif.czk.czs;
        com_tencent_mm_protocal_c_arl.mQD = com_tencent_mm_protocal_c_amz;
        com_tencent_mm_protocal_c_arl.maG = i;
        com_tencent_mm_protocal_c_arl.mQE = f;
        com_tencent_mm_protocal_c_arl.mQF = f2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        if (((arl) ((com.tencent.mm.v.b) pVar).czk.czs).mQD != null) {
            return com.tencent.mm.v.k.b.czU;
        }
        v.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
        return com.tencent.mm.v.k.b.czV;
    }

    public final arm Jw() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (arm) this.cif.czl.czs;
    }

    protected final int ul() {
        return 10;
    }

    protected final void a(com.tencent.mm.v.k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        } else {
            v.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        v.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[]{Jw().mii});
        if (this.cZn != null) {
            this.cZn.run();
        }
    }

    public final int getType() {
        return 424;
    }

    public static String ki(String str) {
        Map q = bf.q(str, "streetview");
        if (q == null) {
            return null;
        }
        return (String) q.get(".streetview.link");
    }
}
