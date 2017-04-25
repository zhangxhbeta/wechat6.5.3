package com.tencent.mm.plugin.record.a;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azv;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends k implements j {
    private final b cif;
    private e cii = null;
    private int fLK = 0;
    private int fLO = 0;
    String ipk = "";
    k ipl = null;
    private SparseArray<pw> ipm = new SparseArray();
    private SparseBooleanArray ipn = new SparseBooleanArray();

    public a(k kVar) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new fs();
        aVar.czo = new ft();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.czm = 632;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.ipl = kVar;
    }

    private void aJy() {
        this.ipk = com.tencent.mm.q.a.a.b(m.a(this.ipl.field_title, this.ipl.field_desc, this.ipl.field_dataProto.mtR));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fLO), Integer.valueOf(this.fLK), str});
        if (i2 == 3 && this.fLO == -100) {
            aJy();
            this.cii.a(0, 0, str, this);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((ft) ((b) pVar).czl.czs).eeu.iterator();
            while (it.hasNext()) {
                azv com_tencent_mm_protocal_c_azv = (azv) it.next();
                pw pwVar = (pw) this.ipm.get(com_tencent_mm_protocal_c_azv.mWB);
                if (pwVar != null) {
                    if (this.ipn.get(com_tencent_mm_protocal_c_azv.mWB)) {
                        v.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azv.mWB), pwVar.luu, pwVar.coj, com_tencent_mm_protocal_c_azv.mjV, Long.valueOf(pwVar.msy), Long.valueOf(com_tencent_mm_protocal_c_azv.mWD)});
                        pwVar.Iy(com_tencent_mm_protocal_c_azv.mjV);
                        pwVar.Iz(com_tencent_mm_protocal_c_azv.mpF);
                        if (be.kS(com_tencent_mm_protocal_c_azv.mjV) || be.kS(com_tencent_mm_protocal_c_azv.mpF) || com_tencent_mm_protocal_c_azv.mWD <= 0) {
                            v.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            pwVar.dR(com_tencent_mm_protocal_c_azv.mWD);
                        }
                    } else {
                        v.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azv.mWB), pwVar.luu, pwVar.mrS, com_tencent_mm_protocal_c_azv.mjV, Long.valueOf(pwVar.msn), Long.valueOf(com_tencent_mm_protocal_c_azv.mWD)});
                        pwVar.IA(com_tencent_mm_protocal_c_azv.mjV);
                        pwVar.IB(com_tencent_mm_protocal_c_azv.mpF);
                        if (be.kS(com_tencent_mm_protocal_c_azv.mjV) || be.kS(com_tencent_mm_protocal_c_azv.mpF) || com_tencent_mm_protocal_c_azv.mWD <= 0) {
                            v.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            pwVar.dQ(com_tencent_mm_protocal_c_azv.mWD);
                        }
                    }
                }
            }
            v.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(this.fLK < this.ipl.field_dataProto.mtR.size())});
            if (this.fLK < this.ipl.field_dataProto.mtR.size()) {
                obj = a(this.czE, this.cii) == -100 ? 1 : null;
            } else {
                int i4 = 1;
            }
            if (obj != null) {
                v.i("MicroMsg.NetSceneTransCDN", "do callback");
                aJy();
                this.cii.a(i2, i3, str, this);
            }
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 632;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        fs fsVar = (fs) this.cif.czk.czs;
        this.ipm.clear();
        this.ipn.clear();
        if (this.ipl.field_dataProto.mtR.size() == 0) {
            v.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.fLO = -100;
            return -100;
        }
        Collection linkedList = new LinkedList();
        int i = this.fLK;
        while (i < this.ipl.field_dataProto.mtR.size()) {
            pw pwVar = (pw) this.ipl.field_dataProto.mtR.get(i);
            if (this.ipl.field_type == 14 && pwVar.aKG == 3) {
                v.w("MicroMsg.NetSceneTransCDN", "match voice type, clear cdn info");
                pwVar.IB("");
                pwVar.IA("");
                pwVar.Iz("");
                pwVar.Iy("");
            } else {
                azv com_tencent_mm_protocal_c_azv;
                if (!be.kS(pwVar.mrS)) {
                    com_tencent_mm_protocal_c_azv = new azv();
                    com_tencent_mm_protocal_c_azv.mjV = pwVar.mrS;
                    com_tencent_mm_protocal_c_azv.mpF = pwVar.mrU;
                    com_tencent_mm_protocal_c_azv.mWC = pwVar.aKG;
                    com_tencent_mm_protocal_c_azv.mWD = (long) ((int) pwVar.msn);
                    com_tencent_mm_protocal_c_azv.mWB = be.ah(pwVar.luu, "").hashCode();
                    v.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azv.mWB), pwVar.luu, Integer.valueOf(com_tencent_mm_protocal_c_azv.mWC), pwVar.mrS, Long.valueOf(pwVar.msn)});
                    linkedList.add(com_tencent_mm_protocal_c_azv);
                    this.ipm.put(com_tencent_mm_protocal_c_azv.mWB, pwVar);
                    this.ipn.put(com_tencent_mm_protocal_c_azv.mWB, false);
                }
                if (!be.kS(pwVar.coj)) {
                    com_tencent_mm_protocal_c_azv = new azv();
                    com_tencent_mm_protocal_c_azv.mjV = pwVar.coj;
                    com_tencent_mm_protocal_c_azv.mpF = pwVar.mrO;
                    com_tencent_mm_protocal_c_azv.mWC = 2;
                    com_tencent_mm_protocal_c_azv.mWD = (long) ((int) pwVar.msy);
                    com_tencent_mm_protocal_c_azv.mWB = (be.ah(pwVar.luu, "") + "@thumb").hashCode();
                    v.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azv.mWB), pwVar.luu, Integer.valueOf(com_tencent_mm_protocal_c_azv.mWC), pwVar.coj, Long.valueOf(pwVar.msy)});
                    linkedList.add(com_tencent_mm_protocal_c_azv);
                    this.ipm.put(com_tencent_mm_protocal_c_azv.mWB, pwVar);
                    this.ipn.put(com_tencent_mm_protocal_c_azv.mWB, true);
                }
                if (linkedList.size() >= 20) {
                    break;
                }
            }
            i++;
        }
        this.fLK = i + 1;
        fsVar.eet = linkedList.size();
        fsVar.eeu.clear();
        fsVar.eeu.addAll(linkedList);
        v.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[]{Integer.valueOf(this.ipl.field_dataProto.mtR.size()), Integer.valueOf(this.ipm.size()), Integer.valueOf(this.fLK)});
        if (fsVar.eet > 0) {
            return a(eVar, this.cif, this);
        }
        v.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.fLO = -100;
        return -100;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 10;
    }
}
