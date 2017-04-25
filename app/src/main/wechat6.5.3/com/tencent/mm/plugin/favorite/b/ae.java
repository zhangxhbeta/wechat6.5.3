package com.tencent.mm.plugin.favorite.b;

import android.util.SparseArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.aus;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class ae extends k implements j {
    private final b cif;
    private e cii = null;
    private List<Integer> fMf;
    private a fMg = null;
    private SparseArray<String> fMh = new SparseArray();
    private int scene;
    private String toUser;

    public interface a {
        void a(SparseArray<String> sparseArray);
    }

    public ae(String str, List<Integer> list, a aVar) {
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new aus();
        aVar2.czo = new aut();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.czm = 608;
        aVar2.czp = 246;
        aVar2.czq = 1000000246;
        this.cif = aVar2.Bv();
        this.toUser = str;
        this.scene = 2;
        this.fMf = list;
        this.fMg = aVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.fMh.clear();
        if (i2 == 0 && i3 == 0) {
            aut com_tencent_mm_protocal_c_aut = (aut) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_aut.mBn != this.fMf.size()) {
                v.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[]{Integer.valueOf(this.fMf.size()), Integer.valueOf(com_tencent_mm_protocal_c_aut.mBn)});
            }
            int i4 = 0;
            while (i4 < com_tencent_mm_protocal_c_aut.mSl.size() && i4 < this.fMf.size()) {
                v.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[]{this.fMf.get(i4), com_tencent_mm_protocal_c_aut.mSl.get(i4)});
                this.fMh.put(((Integer) this.fMf.get(i4)).intValue(), ((arf) com_tencent_mm_protocal_c_aut.mSl.get(i4)).mQy);
                i4++;
            }
        }
        this.cii.a(i2, i3, str, this);
        if (this.fMg != null) {
            this.fMg.a(this.fMh);
        }
    }

    public final int getType() {
        return 608;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        aus com_tencent_mm_protocal_c_aus = (aus) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aus.mSk = this.toUser;
        com_tencent_mm_protocal_c_aus.maG = this.scene;
        com_tencent_mm_protocal_c_aus.mfI = new LinkedList(this.fMf);
        com_tencent_mm_protocal_c_aus.eet = com_tencent_mm_protocal_c_aus.mfI.size();
        v.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[]{com_tencent_mm_protocal_c_aus.mSk, Integer.valueOf(com_tencent_mm_protocal_c_aus.maG), com_tencent_mm_protocal_c_aus.mfI, Integer.valueOf(com_tencent_mm_protocal_c_aus.eet)});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
