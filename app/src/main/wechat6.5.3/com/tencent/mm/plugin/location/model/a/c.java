package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    private Runnable cZn;
    public final b cif;
    private e cii;
    public String gTq;
    public int gTr;
    public azu gTs = null;
    public List<bda> gTt = null;
    public aqa gTu;
    public int gTv;
    private String gTw;

    public c(String str, int i, bda com_tencent_mm_protocal_c_bda, int i2, azu com_tencent_mm_protocal_c_azu) {
        a aVar = new a();
        aVar.czn = new apz();
        aVar.czo = new aqa();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.czm = 492;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        apz com_tencent_mm_protocal_c_apz = (apz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_apz.mrc = str;
        com_tencent_mm_protocal_c_apz.efm = i;
        com_tencent_mm_protocal_c_apz.mPs = com_tencent_mm_protocal_c_bda;
        com_tencent_mm_protocal_c_apz.glx = i2;
        com_tencent_mm_protocal_c_apz.mPt = com_tencent_mm_protocal_c_azu;
        this.gTw = str;
        this.gTv = com_tencent_mm_protocal_c_apz.efm;
        v.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + com_tencent_mm_protocal_c_bda.mdw + " " + com_tencent_mm_protocal_c_bda.mZb.mhZ + " " + com_tencent_mm_protocal_c_bda.mZb.mhY + " heading:" + com_tencent_mm_protocal_c_bda.mZb.mNp);
        v.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + com_tencent_mm_protocal_c_azu.mhZ + " " + com_tencent_mm_protocal_c_azu.mhY + " " + com_tencent_mm_protocal_c_azu.gkB);
        v.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
    }

    public final int getType() {
        return 492;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gTu = (aqa) ((b) pVar).czl.czs;
        if (this.gTu != null) {
            this.gTq = this.gTu.mjZ;
        }
        if (i2 == 0 && i3 == 0) {
            this.gTr = this.gTu.mFg;
            this.gTs = this.gTu.mPv;
            this.gTt = this.gTu.mPu;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.gTu.eet)}));
            if (this.gTs != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.gTs.mhZ), Double.valueOf(this.gTs.mhY), this.gTs.gkB}));
            }
            v.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            List linkedList = new LinkedList();
            Iterator it = this.gTu.mPu.iterator();
            while (it.hasNext()) {
                bda com_tencent_mm_protocal_c_bda = (bda) it.next();
                if (com_tencent_mm_protocal_c_bda == null) {
                    linkedList.add(com_tencent_mm_protocal_c_bda);
                } else {
                    if (com_tencent_mm_protocal_c_bda.mZb == null) {
                        linkedList.add(com_tencent_mm_protocal_c_bda);
                    }
                    if (Math.abs(com_tencent_mm_protocal_c_bda.mZb.mhY) > 180.0d || Math.abs(com_tencent_mm_protocal_c_bda.mZb.mhZ) > 90.0d) {
                        v.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[]{com_tencent_mm_protocal_c_bda.mdw, Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhY), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mNp)});
                        linkedList.add(com_tencent_mm_protocal_c_bda);
                    }
                }
            }
            this.gTu.eet = this.gTu.mPu.size();
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
        if (this.cZn != null) {
            this.cZn.run();
        }
    }
}
