package com.tencent.mm.plugin.emoji.e;

import android.content.ContentValues;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private final b cif;
    private e cxf;
    private String feg;

    public i(String str) {
        a aVar = new a();
        aVar.czn = new vk();
        aVar.czo = new vl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.czm = 239;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.feg = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.storage.a.j jVar = g.afx().fcn;
            String str2 = this.feg;
            vl afL = afL();
            if (be.kS(str2) || afL == null) {
                v.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    com.tencent.mm.storage.a.i iVar = new com.tencent.mm.storage.a.i();
                    iVar.field_designerIDAndType = str2 + com.tencent.mm.storage.a.j.a.DesignerSimpleInfo.value;
                    iVar.field_content = afL.toByteArray();
                    ContentValues py = iVar.py();
                    new String[1][0] = str2 + com.tencent.mm.storage.a.j.a.DesignerSimpleInfo.value;
                    if (jVar.cie.replace("EmotionDesignerInfo", "designerIDAndType", py) > 0) {
                        v.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[]{str2});
                    } else {
                        v.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{be.e(e)});
                }
            }
        }
        this.cxf.a(i2, i3, str, this);
    }

    public final vl afL() {
        return this.cif == null ? null : (vl) this.cif.czl.czs;
    }

    public final int getType() {
        return 239;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        ((vk) this.cif.czk.czs).mpD = this.feg;
        return a(eVar, this.cif, this);
    }
}
