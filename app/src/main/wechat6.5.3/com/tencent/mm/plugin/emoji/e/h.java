package com.tencent.mm.plugin.emoji.e;

import android.content.ContentValues;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.i;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    public int cKy;
    private final b cif;
    private e cxf;
    private int feb;
    public byte[] fec;
    private int fed;
    private String fee;
    private int fef;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        a aVar = new a();
        aVar.czn = new vi();
        aVar.czo = new vj();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        aVar.czm = 821;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.cKy = i;
        this.feb = i2;
        this.fed = i3;
        this.fee = str;
        this.fec = bArr;
        this.fef = i4;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.fec == null || this.fec.length <= 0) && this.cKy != 3)) {
            com.tencent.mm.storage.a.j jVar = g.afx().fcn;
            String str2 = this.feb;
            vj afK = afK();
            if (be.kS(str2) || afK == null) {
                v.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    i iVar = new i();
                    iVar.field_designerIDAndType = str2 + com.tencent.mm.storage.a.j.a.DesignerEmojiList.value;
                    iVar.field_content = afK.toByteArray();
                    ContentValues py = iVar.py();
                    new String[1][0] = str2 + com.tencent.mm.storage.a.j.a.DesignerEmojiList.value;
                    if (jVar.cie.replace("EmotionDesignerInfo", "designerIDAndType", py) > 0) {
                        v.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[]{str2});
                    } else {
                        v.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{be.e(e)});
                }
            }
        }
        vj vjVar = (vj) ((b) pVar).czl.czs;
        if (vjVar.mxT != null) {
            this.fec = m.a(vjVar.mxT);
        }
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 821;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        vi viVar = (vi) this.cif.czk.czs;
        if (this.fec != null) {
            viVar.mxT = m.H(this.fec);
        } else {
            viVar.mxT = new are();
        }
        v.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", viVar.mxT == null ? "Buf is NULL" : viVar.mxT.toString());
        viVar.mxS = this.feb;
        viVar.lZm = this.cKy;
        viVar.mpG = this.fed;
        viVar.mxU = this.fee;
        viVar.mxV = this.fef;
        return a(eVar, this.cif, this);
    }

    public final vj afK() {
        return this.cif == null ? null : (vj) this.cif.czl.czs;
    }
}
