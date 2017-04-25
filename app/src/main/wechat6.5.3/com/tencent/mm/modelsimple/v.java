package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.network.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class v extends k implements j {
    private final long bao;
    private final b cQA;
    private final String cZl;
    private e cii;

    public v(at atVar, String str) {
        int i;
        ak.yW();
        Object obj = c.vf().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = be.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.bao = atVar.field_msgId;
        this.cZl = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (atVar.field_createTime / 1000);
        long j = atVar.field_msgSvrId;
        String xF = com.tencent.mm.model.k.xF();
        String str3 = atVar.field_talker;
        if (atVar.bNs != 1) {
            String str4;
            switch (atVar.field_type) {
                case 1:
                case 42:
                case 48:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", Integer.valueOf(com.tencent.mm.model.j.f(com.tencent.mm.model.k.xF(), atVar.field_createTime).hashCode()));
                    i2 = r2;
                    break;
                case 3:
                    d ai = n.GH().ai(atVar.field_msgId);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", atVar.field_talker, Integer.valueOf(ai.cLE), Long.valueOf(ai.cLu), atVar.bNv);
                    str2 = str4;
                    break;
                case 34:
                    p lJ = m.Lz().lJ(atVar.field_imgPath);
                    if (lJ != null) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", lJ.clientId);
                        str2 = str4;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", atVar.field_imgPath);
                    str2 = str4;
                    break;
                case 47:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", String.valueOf(ag.Mv(atVar.field_content).time));
                    str2 = str4;
                    break;
                case 49:
                case 1048625:
                case 268435505:
                    com.tencent.mm.pluginsdk.model.app.b dy = am.Wf().dy(atVar.field_msgId);
                    if (dy != null) {
                        str4 = dy.field_clientAppDataId;
                    } else {
                        str4 = atVar.field_talker + atVar.field_msgId + "T" + atVar.field_createTime;
                    }
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", str4);
                    str2 = str4;
                    break;
            }
        }
        a aVar = new a();
        aVar.czn = new arb();
        aVar.czo = new arc();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.czm = 594;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        arb com_tencent_mm_protocal_c_arb = (arb) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_arb.mcN = str2;
        com_tencent_mm_protocal_c_arb.mQo = i2;
        com_tencent_mm_protocal_c_arb.mQp = 0;
        com_tencent_mm_protocal_c_arb.mQr = j;
        com_tencent_mm_protocal_c_arb.hNS = i3;
        com_tencent_mm_protocal_c_arb.gon = xF;
        com_tencent_mm_protocal_c_arb.gom = str3;
        com_tencent_mm_protocal_c_arb.mQq = i;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", com_tencent_mm_protocal_c_arb.mcN, Integer.valueOf(com_tencent_mm_protocal_c_arb.mQo), Integer.valueOf(com_tencent_mm_protocal_c_arb.mQp), Integer.valueOf(com_tencent_mm_protocal_c_arb.hNS), com_tencent_mm_protocal_c_arb.gon, com_tencent_mm_protocal_c_arb.gom, Integer.valueOf(com_tencent_mm_protocal_c_arb.mQq));
    }

    public final int getType() {
        return 594;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            at ek = c.wJ().ek(this.bao);
            if (ek.field_msgId == this.bao) {
                arc Ju = Ju();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", Long.valueOf(ek.field_msgId), Long.valueOf(ek.field_msgSvrId), Ju.mQt);
                ek.setContent(this.cZl);
                int i4 = ek.field_type;
                ek.setType(10000);
                ek.di(0);
                ek.ds(ek.bNn | 4);
                com.tencent.mm.sdk.c.b lzVar = new lz();
                lzVar.bnh.bao = this.bao;
                com.tencent.mm.sdk.c.a.nhr.z(lzVar);
                ak.yW();
                c.wJ().a(ek.field_msgId, ek);
                int i5 = 0;
                ak.yW();
                Object obj = c.vf().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i5 = be.getInt(obj.toString(), 0);
                }
                i5++;
                ak.yW();
                c.vf().set(290818, Integer.valueOf(i5));
                ek.setType(i4);
                com.tencent.mm.modelstat.b bVar = com.tencent.mm.modelstat.b.daJ;
                if (bVar.JV()) {
                    bVar.a(ek, com.tencent.mm.modelstat.b.b.revoke);
                }
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", Long.valueOf(this.bao));
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final arc Ju() {
        return (arc) this.cQA.czl.czs;
    }
}
