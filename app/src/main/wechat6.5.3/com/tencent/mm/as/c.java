package com.tencent.mm.as;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c extends k implements j {
    private b cif;
    private e cii;
    private String clientId = SQLiteDatabase.KeyEmpty;
    private long dgv = -1;
    private n dgw = null;
    private keep_SceneResult dgx = null;

    public c(long j, n nVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str) {
        v.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", Long.valueOf(j), str);
        this.dgv = j;
        this.dgw = nVar;
        this.dgx = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.clientId = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new asz();
        aVar.czo = new ata();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.czm = 245;
        this.cif = aVar.Bv();
        asz com_tencent_mm_protocal_c_asz = (asz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_asz.cop = this.dgx.field_aesKey;
        com_tencent_mm_protocal_c_asz.jqw = this.clientId;
        com_tencent_mm_protocal_c_asz.aZy = this.dgw.bov;
        com_tencent_mm_protocal_c_asz.mRu = this.dgw.dhK;
        k.KV();
        Options JS = d.JS(o.ld(this.dgw.getFileName()));
        if (JS != null) {
            com_tencent_mm_protocal_c_asz.coo = JS.outWidth;
            com_tencent_mm_protocal_c_asz.con = JS.outHeight;
        } else {
            v.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", r2);
        }
        com_tencent_mm_protocal_c_asz.dgF = this.dgw.dhG;
        String[] split = be.ah(this.dgw.dhS, SQLiteDatabase.KeyEmpty).split(",");
        if (split == null || split.length <= 0) {
            v.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", Long.valueOf(this.dgv));
            return -1;
        }
        int length = split.length;
        while (i < length) {
            String str = split[i];
            azt com_tencent_mm_protocal_c_azt = new azt();
            com_tencent_mm_protocal_c_azt.username = str;
            com_tencent_mm_protocal_c_asz.mRt.add(com_tencent_mm_protocal_c_azt);
            i++;
        }
        com_tencent_mm_protocal_c_asz.url = this.dgx.field_fileId;
        com_tencent_mm_protocal_c_asz.dhK = this.dgw.cyu;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.dgv);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 245;
    }
}
