package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public final class h extends k implements j {
    private final b cif;
    private e cii;

    public h() {
        a aVar = new a();
        aVar.czn = new auq();
        aVar.czo = new aur();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        aVar.czm = 906;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        auq com_tencent_mm_protocal_c_auq = (auq) this.cif.czk.czs;
        ak.yW();
        com_tencent_mm_protocal_c_auq.mSi = ((Long) c.vf().get(t.a.npM, Long.valueOf(0))).longValue();
    }

    public final int getType() {
        return 906;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aur com_tencent_mm_protocal_c_aur = (aur) this.cif.czl.czs;
            List<aup> list = com_tencent_mm_protocal_c_aur.cqE == null ? null : com_tencent_mm_protocal_c_aur.cqE;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_aur.mSj);
            objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_aur.mSh);
            v.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                v.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a aar = af.aar();
                v.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (aar.cGJ) {
                    aar.eAO.addAll(aar.eAP);
                    aar.eAP.clear();
                }
                aar.ZI();
            } else {
                int i4 = 0;
                for (aup a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                v.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[]{Integer.valueOf(i4)});
                af.aar().ZI();
            }
            ak.yW();
            c.vf().a(t.a.npM, Long.valueOf(com_tencent_mm_protocal_c_aur.mSh));
            af.aar().eEm = com_tencent_mm_protocal_c_aur.eEm;
            if (com_tencent_mm_protocal_c_aur.mSj > 0) {
                v.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aur.mSj)});
                com.tencent.mm.plugin.card.sharecard.a.a aar2 = af.aar();
                aar2.mHandler.post(new Runnable(aar2) {
                    final /* synthetic */ a eEn;

                    {
                        this.eEn = r1;
                    }

                    public final void run() {
                        ak.vy().a(new h(), 0);
                    }
                });
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }

    private static boolean a(aup com_tencent_mm_protocal_c_aup) {
        if (com_tencent_mm_protocal_c_aup == null) {
            v.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            return false;
        }
        v.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[]{com_tencent_mm_protocal_c_aup.bol, Long.valueOf(com_tencent_mm_protocal_c_aup.mSh)});
        try {
            v.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aup.eEu)});
            switch (com_tencent_mm_protocal_c_aup.eEu) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    com.tencent.mm.plugin.card.sharecard.a.a aar = af.aar();
                    if (com_tencent_mm_protocal_c_aup != null) {
                        long j;
                        ShareCardInfo qc = af.aas().qc(com_tencent_mm_protocal_c_aup.bol);
                        String str = "MicroMsg.ShareCardBatchGetCardMgr";
                        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = com_tencent_mm_protocal_c_aup.bol;
                        if (qc == null) {
                            j = 0;
                        } else {
                            j = qc.field_updateSeq;
                        }
                        objArr[1] = Long.valueOf(j);
                        objArr[2] = Long.valueOf(com_tencent_mm_protocal_c_aup.mSh);
                        v.i(str, str2, objArr);
                        if (qc != null && qc.field_updateSeq == com_tencent_mm_protocal_c_aup.mSh) {
                            v.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
                            break;
                        }
                        n b = n.b(com_tencent_mm_protocal_c_aup);
                        synchronized (aar.cGJ) {
                            if (!aar.eAO.contains(b)) {
                                if (!aar.eAP.contains(b)) {
                                    aar.eAO.add(b);
                                    boolean b2 = af.aat().b(b);
                                    v.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[]{Boolean.valueOf(b2)});
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    v.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a aar2 = af.aar();
                    if (com_tencent_mm_protocal_c_aup != null) {
                        com.tencent.mm.plugin.card.base.b qc2 = af.aas().qc(com_tencent_mm_protocal_c_aup.bol);
                        af.aas().qb(com_tencent_mm_protocal_c_aup.bol);
                        v.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + com_tencent_mm_protocal_c_aup.bol);
                        if (qc2 != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(aa.getContext(), qc2);
                        } else {
                            v.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        aar2.Yj();
                        break;
                    }
                    v.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    v.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aup.eEu)});
                    return false;
            }
            if (!(com_tencent_mm_protocal_c_aup.eEu == 0 || com_tencent_mm_protocal_c_aup.eEu == 5)) {
                ak.yW();
                String str3 = (String) c.vf().get(t.a.npU, "");
                ak.yW();
                boolean booleanValue = ((Boolean) c.vf().get(t.a.npV, Boolean.valueOf(false))).booleanValue();
                if (booleanValue && !TextUtils.isEmpty(str3) && str3.equals(com_tencent_mm_protocal_c_aup.bol)) {
                    v.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    i.aaa();
                } else if (booleanValue) {
                    v.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    v.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
