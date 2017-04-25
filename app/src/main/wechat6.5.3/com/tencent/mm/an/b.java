package com.tencent.mm.an;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class b extends k implements j {
    private String bhr;
    public String cUH;
    private com.tencent.mm.v.b cif;
    private e cii;
    private String clientId;
    private int cyu;
    private int cyv;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.bhr = str2;
    }

    private b(String str) {
        this.username = str;
        this.cyu = 0;
        this.cyv = 0;
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        this.clientId = stringBuilder.append(c.ww()).append(System.currentTimeMillis()).toString();
    }

    public final int getType() {
        return 575;
    }

    protected final int a(p pVar) {
        if (this.bhr == null || this.bhr.length() == 0) {
            return b.czV;
        }
        return b.czU;
    }

    protected final int ul() {
        return 100;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.bhr == null || this.bhr.length() == 0) {
            v.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            return -1;
        } else if (com.tencent.mm.a.e.aR(this.bhr)) {
            if (this.cyu == 0) {
                this.cyu = (int) new File(this.bhr).length();
            }
            a aVar = new a();
            aVar.czn = new bbq();
            aVar.czo = new bbr();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.czm = 575;
            aVar.czp = 0;
            aVar.czq = 0;
            this.cif = aVar.Bv();
            byte[] c = com.tencent.mm.a.e.c(this.bhr, this.cyv, Math.min(this.cyu - this.cyv, WXMediaMessage.THUMB_LENGTH_LIMIT));
            if (c == null) {
                v.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                return -1;
            }
            v.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(c.length), Integer.valueOf(this.cyu));
            bbq com_tencent_mm_protocal_c_bbq = (bbq) this.cif.czk.czs;
            com_tencent_mm_protocal_c_bbq.mpa = this.username;
            com_tencent_mm_protocal_c_bbq.mdz = this.cyu;
            com_tencent_mm_protocal_c_bbq.mdA = this.cyv;
            com_tencent_mm_protocal_c_bbq.mfg = new are().ba(c);
            com_tencent_mm_protocal_c_bbq.mdB = com_tencent_mm_protocal_c_bbq.mfg.mQu;
            com_tencent_mm_protocal_c_bbq.mbN = this.clientId;
            return a(eVar, this.cif, this);
        } else {
            v.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.bhr);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bbr com_tencent_mm_protocal_c_bbr = (bbr) ((com.tencent.mm.v.b) pVar).czl.czs;
            this.cUH = com_tencent_mm_protocal_c_bbr.mJn;
            this.cyv = com_tencent_mm_protocal_c_bbr.mdA;
            if (this.cyv < this.cyu) {
                if (a(this.czE, this.cii) < 0) {
                    v.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                }
                v.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                return;
            }
            if (!be.kS(this.cUH)) {
                ak.yW();
                ab LX = c.wH().LX(this.username);
                if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                    LX.cn(this.cUH);
                    ak.yW();
                    c.wH().a(this.username, LX);
                }
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.cii.a(i2, i3, str, this);
    }
}
