package com.tencent.mm.plugin.card.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public final class s extends k implements j {
    private byte[] cRq;
    private final b cif;
    private e cii;
    private int eDx = 0;

    public s(int i) {
        v.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[]{Integer.valueOf(1)});
        a aVar = new a();
        aVar.czn = new ja();
        aVar.czo = new jb();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.czm = 558;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        afr com_tencent_mm_protocal_c_afr = new afr();
        ak.yW();
        com_tencent_mm_protocal_c_afr.eEw = (String) c.vf().get(t.a.npC, null);
        com_tencent_mm_protocal_c_afr.latitude = (double) af.aaq().bYf;
        com_tencent_mm_protocal_c_afr.longitude = (double) af.aaq().bYg;
        ja jaVar = (ja) this.cif.czk.czs;
        jaVar.mkE = 1;
        jaVar.mkG = com_tencent_mm_protocal_c_afr;
        jaVar.mkH = i;
        this.eDx = i;
    }

    public final int getType() {
        return 558;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        ja jaVar = (ja) this.cif.czk.czs;
        ak.yW();
        this.cRq = be.KG(be.ma((String) c.vf().get(282880, null)));
        if (this.cRq == null || this.cRq.length == 0) {
            v.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        jaVar.mkF = m.H(this.cRq);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.cRq == null ? 0 : this.cRq.length);
        v.i(str, str2, objArr);
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            jb jbVar = (jb) this.cif.czl.czs;
            if (jbVar.mkJ == 1) {
                v.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.cRq = m.a(jbVar.mkF, new byte[0]);
            List<kz> list = jbVar.mkI == null ? null : jbVar.mkI.eeu;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.cRq == null ? 0 : this.cRq.length);
            objArr[2] = Integer.valueOf(jbVar.miR);
            v.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                v.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.a.b aaj = af.aaj();
                v.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (aaj.cGJ) {
                    aaj.eAO.addAll(aaj.eAP);
                    aaj.eAP.clear();
                }
                aaj.ZI();
            } else {
                int i4 = 0;
                for (kz a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                v.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[]{Integer.valueOf(i4)});
                af.aaj().ZI();
            }
            ak.yW();
            c.vf().set(282880, be.bn(this.cRq));
            if (jbVar.miR > 0) {
                v.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(jbVar.miR)});
                if (a(this.czE, this.cii) <= 0) {
                    v.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[]{Integer.valueOf(a(this.czE, this.cii))});
                    this.cii.a(3, -1, str, this);
                    return;
                }
                return;
            }
            this.cii.a(0, 0, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }

    private static boolean a(kz kzVar) {
        if (kzVar == null) {
            v.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            return false;
        }
        byte[] a = m.a(kzVar.mnB);
        if (a == null || a.length == 0) {
            v.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            return false;
        }
        v.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(kzVar.bkM)});
        try {
            switch (kzVar.bkM) {
                case 1:
                    je jeVar = (je) new je().az(a);
                    v.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[]{Integer.valueOf(jeVar.eeO)});
                    switch (jeVar.eeO) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            com.tencent.mm.plugin.card.a.b aaj = af.aaj();
                            if (jeVar != null) {
                                long j;
                                CardInfo pQ = af.aak().pQ(jeVar.mls);
                                String str = "MicroMsg.BatchGetCardMgr";
                                String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = jeVar.mls;
                                if (pQ == null) {
                                    j = 0;
                                } else {
                                    j = pQ.field_updateSeq;
                                }
                                objArr[1] = Long.valueOf(j);
                                objArr[2] = Long.valueOf(jeVar.mlt);
                                v.i(str, str2, objArr);
                                if (pQ != null && pQ.field_updateSeq == jeVar.mlt) {
                                    v.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
                                    break;
                                }
                                ad a2 = ad.a(jeVar);
                                synchronized (aaj.cGJ) {
                                    if (!aaj.eAO.contains(a2)) {
                                        if (!aaj.eAP.contains(a2)) {
                                            aaj.eAO.add(a2);
                                            boolean b = af.aal().b(a2);
                                            v.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[]{Boolean.valueOf(b)});
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            v.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
                            break;
                            break;
                        case 6:
                            break;
                        default:
                            v.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(jeVar.mlu)});
                            return false;
                    }
                    return true;
                default:
                    v.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[]{Integer.valueOf(kzVar.bkM)});
                    return false;
            }
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
        v.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
        return false;
    }
}
