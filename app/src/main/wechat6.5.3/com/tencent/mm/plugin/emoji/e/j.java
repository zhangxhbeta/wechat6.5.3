package com.tencent.mm.plugin.emoji.e;

import android.text.TextUtils;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.c.a;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.d;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.List;

public final class j extends k implements com.tencent.mm.network.j {
    public final b cif;
    private e cxf;
    public String fdK = "";
    private a feh;
    private boolean fei = false;
    private kl fej = null;

    public j(String str) {
        b.a aVar = new b.a();
        aVar.czn = new vm();
        aVar.czo = new vn();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.czm = 521;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fdK = str;
        this.fej = new kl();
    }

    public j(String str, a aVar) {
        b.a aVar2 = new b.a();
        aVar2.czn = new vm();
        aVar2.czo = new vn();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.czm = 521;
        aVar2.czp = 0;
        aVar2.czq = 0;
        this.cif = aVar2.Bv();
        this.fdK = str;
        this.feh = aVar;
        this.fei = true;
        this.fej = new kl();
    }

    public final int getType() {
        return 521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[]{this.fdK});
        this.cxf = eVar2;
        ((vm) this.cif.czk.czs).mdM = this.fdK;
        if (!TextUtils.isEmpty(this.fdK)) {
            return a(eVar, this.cif, this);
        }
        v.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
        return -1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 != 0 || i3 != 0) {
            v.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.fdK});
            if (this.fei) {
                v.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.fei) {
            List<of> list = ((vn) this.cif.czl.czs).eeu;
            com.tencent.mm.storage.a.e eVar = g.afx().fcj;
            String str2 = this.fdK;
            int i4 = ((vn) this.cif.czl.czs).mya;
            int afM = afM();
            if (eVar.nxi != null) {
                eVar.nxi.edit().putLong("274544" + str2, System.currentTimeMillis()).commit();
            }
            if (list != null && list.size() > 0) {
                long er;
                com.tencent.mm.bg.g gVar;
                if (eVar.cie instanceof com.tencent.mm.bg.g) {
                    com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) eVar.cie;
                    er = gVar2.er(Thread.currentThread().getId());
                    gVar = gVar2;
                } else {
                    gVar = null;
                    er = -1;
                }
                eVar.cie.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                d dVar = new d();
                dVar.field_groupId = str2;
                dVar.field_click_flag = i4;
                dVar.field_download_flag = afM;
                for (of ofVar : list) {
                    dVar.field_md5 = ofVar.mpC;
                    Iterator it = ofVar.eeu.iterator();
                    while (it.hasNext()) {
                        afq com_tencent_mm_protocal_c_afq = (afq) it.next();
                        dVar.field_desc = com_tencent_mm_protocal_c_afq.gkC;
                        dVar.field_lang = com_tencent_mm_protocal_c_afq.glC;
                        dVar.field_md5_lang = dVar.field_md5 + dVar.field_lang;
                        if (eVar.cie.replace("EmojiInfoDesc", "md5_lang", dVar.py()) < 0) {
                            if (gVar != null) {
                                gVar.es(er);
                            }
                        }
                    }
                }
                eVar.cie.replace("EmojiInfoDesc", "md5_lang", dVar.py());
                if (gVar != null) {
                    gVar.es(er);
                }
            }
            if (list != null && list.size() > 0) {
                v.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[]{this.fdK});
                this.fej.blI.aZD = this.fdK;
                com.tencent.mm.sdk.c.a.nhr.z(this.fej);
            }
        } else if ((afM() & 1) == 1) {
            c.a(this.feh);
        } else {
            v.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.cxf.a(i2, i3, str, this);
    }

    private int afM() {
        return ((vn) this.cif.czl.czs).myc;
    }

    protected final int ul() {
        return 50;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }
}
