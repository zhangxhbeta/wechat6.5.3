package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.d.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.protocal.c.nx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class q extends k implements j {
    private c aYc;
    private long cLC;
    private final b cif;
    private e cii;
    private boolean fdT;

    public q(String str, String str2, c cVar, long j) {
        this(str, str2, cVar, j, (byte) 0);
    }

    private q(String str, String str2, c cVar, long j, byte b) {
        int i = 1;
        this.fdT = true;
        this.cLC = 0;
        boolean z = (str2 == null || str2.length() <= 0 || cVar == null) ? false : true;
        Assert.assertTrue(z);
        this.cLC = j;
        this.aYc = cVar;
        a aVar = new a();
        aVar.czn = new bbw();
        aVar.czo = new bbx();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.czm = 175;
        aVar.czp = 68;
        aVar.czq = 1000000068;
        this.cif = aVar.Bv();
        g.afx().fch.a(aa.getContext(), cVar);
        bbw com_tencent_mm_protocal_c_bbw = (bbw) this.cif.czk.czs;
        nw nwVar = new nw();
        nwVar.mpI = cVar.EB();
        nwVar.mpM = str;
        nwVar.gom = str2;
        nwVar.mdz = cVar.field_size;
        nwVar.mpK = cVar.pO();
        nwVar.efm = cVar.field_type;
        nwVar.mbZ = ax.zr();
        nwVar.mpN = 0;
        if (str2.endsWith("@chatroom")) {
            i = 2;
        }
        if (cVar.field_catalog == c.nwQ) {
            nwVar.mpL = "56,2," + i;
        } else if (cVar.field_catalog == c.nwP) {
            nwVar.mpL = "56,1," + i;
        }
        com_tencent_mm_protocal_c_bbw.mpP.add(nwVar);
        com_tencent_mm_protocal_c_bbw.mXG = com_tencent_mm_protocal_c_bbw.mpP.size();
    }

    public final int getType() {
        return 175;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        this.cii = eVar2;
        nw nwVar = (nw) ((bbw) this.cif.czk.czs).mpP.get(0);
        if (this.fdT) {
            v.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + nwVar.mpI);
            nwVar.mpJ = new are();
            nwVar.mdA = 0;
            return a(eVar, this.cif, this);
        }
        byte[] a;
        int i2 = this.aYc.field_size - this.aYc.field_start;
        if (i2 <= 8192) {
            i = i2;
        }
        if ((this.aYc.field_reserved4 & c.nxh) == c.nxh) {
            a = f.aeV().a(this.aYc);
        } else {
            a = this.aYc.cZ(this.aYc.field_start, i);
        }
        if (EmojiLogic.ae(a) == c.nwI && this.fdT) {
            v.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.aYc.bxF();
            return -1;
        } else if (a == null || a.length <= 0) {
            v.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            return -1;
        } else {
            i2 = a.length;
            nwVar.mdA = this.aYc.field_start;
            nwVar.mpJ = new are().c(com.tencent.mm.ba.b.aT(a));
            if (com.tencent.mm.modelbiz.e.hC(nwVar.gom)) {
                ak.yW();
                nwVar.mbZ = com.tencent.mm.modelbiz.a.e.hY(com.tencent.mm.model.c.wJ().ek(this.cLC).bNo);
                v.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[]{nwVar.mbZ});
            }
            v.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.aYc.field_start + ", total:" + this.aYc.field_size + ", len:" + i2);
            return a(eVar, this.cif, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bbw com_tencent_mm_protocal_c_bbw = (bbw) ((b) pVar).czk.czs;
            bbx com_tencent_mm_protocal_c_bbx = (bbx) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_bbw.mpP.size() != com_tencent_mm_protocal_c_bbx.mpP.size()) {
                v.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + com_tencent_mm_protocal_c_bbx.mpP.size() + ", resp size:" + com_tencent_mm_protocal_c_bbw.mpP.size());
                this.cii.a(i2, i3, str, this);
                return;
            }
            nx nxVar = (nx) com_tencent_mm_protocal_c_bbx.mpP.get(0);
            if (nxVar.mpI == null || !nxVar.mpI.equals(this.aYc.EB()) || nxVar.mdA < this.aYc.field_start) {
                v.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + nxVar.mdA + ", size=" + this.aYc.field_size);
                this.cii.a(4, -2, "", this);
                this.aYc.field_start = 0;
                g.afx().fch.s(this.aYc);
                return;
            } else if (com_tencent_mm_protocal_c_bbx.mQl.mcj != 0) {
                v.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbx.mQl.mcj)});
                this.cii.a(4, -2, "", this);
                return;
            } else {
                if (this.fdT) {
                    this.fdT = false;
                }
                if (nxVar.mdA >= nxVar.mdz) {
                    v.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + nxVar.mpO);
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(this.cLC);
                    v.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Integer.valueOf(nxVar.mpO), Integer.valueOf(com.tencent.mm.platformtools.q.dqk)});
                    if (10007 == com.tencent.mm.platformtools.q.dqj && com.tencent.mm.platformtools.q.dqk != 0) {
                        nxVar.mpO = com.tencent.mm.platformtools.q.dqk;
                        com.tencent.mm.platformtools.q.dqk = 0;
                    }
                    ek.y((long) nxVar.mpO);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(this.cLC, ek);
                    this.aYc.field_start = 0;
                    this.aYc.field_lastUseTime = System.currentTimeMillis();
                    this.aYc.field_state = c.nxa;
                    g.afx().fch.s(this.aYc);
                    com.tencent.mm.modelstat.b.daJ.p(ek);
                    this.cii.a(i2, i3, "", this);
                    return;
                }
                this.aYc.field_start = nxVar.mdA;
                this.aYc.field_lastUseTime = System.currentTimeMillis();
                g.afx().fch.s(this.aYc);
                if (a(this.czE, this.cii) < 0) {
                    this.cii.a(3, -1, "", this);
                    return;
                }
                return;
            }
        }
        v.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    protected final int ul() {
        return 256;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }
}
