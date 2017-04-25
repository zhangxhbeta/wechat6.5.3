package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m extends k implements j {
    private final int cVh;
    private final b cif;
    private e cii;
    public byte[] fek;
    public int fem;
    private boolean fen;
    private ArrayList<ol> feo;
    public final int mType;

    public m(int i, int i2) {
        this(i, null, i2);
    }

    public m(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public m(int i, byte[] bArr, int i2, boolean z) {
        this.fen = false;
        this.feo = new ArrayList();
        this.fek = null;
        a aVar = new a();
        aVar.czn = new vs();
        aVar.czo = new vt();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.czm = 411;
        aVar.czp = 210;
        aVar.czq = 1000000210;
        this.cif = aVar.Bv();
        this.fek = bArr;
        this.mType = i;
        this.cVh = i2;
        this.fen = z;
    }

    public final int getType() {
        return 411;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        vs vsVar = (vs) this.cif.czk.czs;
        if (this.fek != null) {
            vsVar.mcz = com.tencent.mm.platformtools.m.H(this.fek);
        } else {
            vsVar.mcz = new are();
        }
        v.d("MicroMsg.emoji.NetSceneGetEmotionList", vsVar.mcz == null ? "Buf is NULL" : vsVar.mcz.toString());
        vsVar.mfK = this.mType;
        vsVar.maG = this.cVh;
        if (this.mType == 7) {
            vsVar.myg = this.fem;
        }
        return a(eVar, this.cif, this);
    }

    public final vt afP() {
        return this.cif == null ? null : (vt) this.cif.czl.czs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                ak.yW();
                c.vf().a(t.a.noE, Long.valueOf(System.currentTimeMillis()));
            } else {
                ak.yW();
                c.vf().a(t.a.noE, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                ak.yW();
                c.vf().a(t.a.noI, Long.valueOf(System.currentTimeMillis()));
            } else {
                ak.yW();
                c.vf().a(t.a.noI, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            g.afx().fck.a(this.mType, afP());
        }
        if (i2 == 0 || i2 == 4) {
            vt vtVar = (vt) ((b) pVar).czl.czs;
            if (vtVar.mcz != null) {
                this.fek = com.tencent.mm.platformtools.m.a(vtVar.mcz);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    afQ();
                    v(this.feo);
                    ak.yW();
                    c.vf().a(t.a.noE, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    afQ();
                    ((vs) ((b) pVar).czk.czs).mcz = ((vt) ((b) pVar).czl.czs).mcz;
                    a(this.czE, this.cii);
                } else if (i3 == 3) {
                    if (this.feo != null) {
                        this.feo.clear();
                    }
                    ((vs) ((b) pVar).czk.czs).mcz = new are();
                    a(this.czE, this.cii);
                }
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public static com.tencent.mm.plugin.emoji.model.e a(vt vtVar) {
        v.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (vtVar == null) {
            return null;
        }
        com.tencent.mm.plugin.emoji.model.e eVar = new com.tencent.mm.plugin.emoji.model.e();
        if (vtVar != null) {
            eVar.fcS = vtVar.myh;
            List arrayList = new ArrayList();
            if (!(vtVar.myi == null || vtVar.myi.isEmpty())) {
                Object[] toArray = vtVar.myi.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof ol)) {
                            ol olVar = (ol) obj;
                            if (!(olVar == null || be.kS(olVar.mdM))) {
                                arrayList.add(new f(olVar));
                            }
                        }
                    }
                }
            }
            eVar.fcT = arrayList;
            eVar.fcU = vtVar.myj;
            eVar.fcV = vtVar.myl;
            Collection collection = vtVar.myt;
            if (eVar.fcX == null) {
                eVar.fcX = new LinkedList();
                eVar.fcX.addAll(collection);
            }
            eVar.fcW = vtVar.myp;
        }
        return eVar;
    }

    protected final int ul() {
        return 100;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    private void afQ() {
        vt afP = afP();
        if (afP == null || afP.myi == null || afP.myi.size() <= 0) {
            v.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
        } else {
            this.feo.addAll(afP.myi);
        }
    }

    private void v(ArrayList<ol> arrayList) {
        com.tencent.mm.storage.a.b bVar = g.afx().fci;
        if (bVar == null) {
            v.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            return;
        }
        long j;
        com.tencent.mm.bg.g gVar;
        ol olVar;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (bVar.cie instanceof com.tencent.mm.bg.g) {
            com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) bVar.cie;
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[]{Long.valueOf(gVar2.er(Thread.currentThread().getId()))});
            j = r4;
            gVar = gVar2;
        } else {
            j = -1;
            gVar = null;
        }
        Iterator it;
        com.tencent.mm.storage.a.a aVar;
        if (arrayList == null || arrayList.size() <= 0) {
            it = bVar.bxq().iterator();
            while (it.hasNext()) {
                aVar = (com.tencent.mm.storage.a.a) it.next();
                if (aVar.field_sync > 0) {
                    v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[]{aVar.field_productID});
                    bVar.NA(aVar.field_productID);
                }
            }
            bVar.NA("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            Map bxp = bVar.bxp();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[]{Integer.valueOf(arrayList.size())});
            for (int i = 0; i < r13; i++) {
                olVar = (ol) arrayList.get(i);
                if (olVar == null || be.kS(olVar.mdM)) {
                    v.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    com.tencent.mm.storage.a.a aVar2;
                    v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[]{olVar.mdM});
                    arrayList2.add(olVar.mdM);
                    if (bxp.containsKey(olVar.mdM)) {
                        aVar2 = (com.tencent.mm.storage.a.a) bxp.get(olVar.mdM);
                        if (aVar2 == null) {
                            aVar2 = new com.tencent.mm.storage.a.a();
                        }
                        aVar2.field_productID = olVar.mdM;
                    } else if (olVar.mdM.equals("com.tencent.xin.emoticon.tusiji")) {
                        aVar2 = (com.tencent.mm.storage.a.a) bxp.get(String.valueOf(com.tencent.mm.storage.a.a.nwJ));
                        if (aVar2 == null) {
                            aVar2 = new com.tencent.mm.storage.a.a();
                        }
                        aVar2.field_productID = String.valueOf(com.tencent.mm.storage.a.a.nwJ);
                    } else {
                        aVar2 = new com.tencent.mm.storage.a.a();
                        aVar2.field_productID = olVar.mdM;
                    }
                    if (olVar.mdM.equals("com.tencent.xin.emoticon.tusiji")) {
                        aVar2.field_flag = 0;
                        aVar2.field_packName = "emoji_custom_all";
                        aVar2.field_type = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
                    } else {
                        aVar2.field_packName = olVar.mqd;
                        aVar2.field_type = com.tencent.mm.storage.a.a.nwG;
                    }
                    aVar2.field_packIconUrl = olVar.gnp;
                    aVar2.field_packGrayIconUrl = olVar.mqq;
                    aVar2.field_packCoverUrl = olVar.mql;
                    aVar2.field_packDesc = olVar.mqe;
                    aVar2.field_packAuthInfo = olVar.mqf;
                    aVar2.field_packPrice = olVar.mqg;
                    aVar2.field_packType = olVar.mqh;
                    aVar2.field_packFlag = olVar.mqi;
                    aVar2.field_packExpire = (long) olVar.mqm;
                    aVar2.field_packTimeStamp = (long) olVar.mqK;
                    aVar2.field_sort = 1;
                    aVar2.field_idx = i;
                    if (aVar2.field_sync == 0) {
                        if (aVar2.field_status == 7 && aVar2.field_packStatus == 1) {
                            aVar2.field_sync = 2;
                        } else {
                            aVar2.field_sync = 1;
                        }
                    }
                    if (aVar2.field_sync == 2) {
                        aVar2.field_status = 7;
                    }
                    if (aVar2.field_sync == 2 && !olVar.mdM.equals("com.tencent.xin.emoticon.tusiji")) {
                        com.tencent.mm.e.a.ak akVar = new com.tencent.mm.e.a.ak();
                        akVar.aYa.type = 1;
                        akVar.aYa.aYd = olVar.mdM;
                        com.tencent.mm.sdk.c.a.nhr.z(akVar);
                        if (!akVar.aYb.aXR) {
                            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[]{olVar.mdM});
                            aVar2.field_sync = 1;
                        }
                    }
                    v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[]{aVar2.field_productID, Long.valueOf(aVar2.field_lastUseTime), Integer.valueOf(aVar2.field_sort)});
                    bVar.a(aVar2);
                }
            }
            for (com.tencent.mm.storage.a.a aVar3 : bxp.values()) {
                if (!(aVar3 == null || be.kS(aVar3.field_productID) || aVar3.field_productID.equals(String.valueOf(com.tencent.mm.storage.a.a.nwK)))) {
                    if (aVar3.field_productID.equals(String.valueOf(com.tencent.mm.storage.a.a.nwJ))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{"com.tencent.xin.emoticon.tusiji"});
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(aVar3.field_productID)) {
                        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{aVar3.field_productID});
                        arrayList3.add(aVar3.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    bVar.NA((String) it.next());
                }
            }
            bVar.a("event_update_group", 0, be.bur().toString());
        }
        if (gVar != null) {
            gVar.es(j);
            v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        bVar.a("event_update_group", 0, be.bur().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.fen) {
            ArrayList arrayList5 = (ArrayList) bVar.bxA();
            if (arrayList5.size() > 0) {
                v.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[]{Integer.valueOf(arrayList5.size())});
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!be.kS(str)) {
                        if (str.equals(String.valueOf(com.tencent.mm.storage.a.a.nwJ))) {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.g.a.c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.g.a.b(str));
                        }
                    }
                }
                g.afu().x(arrayList4);
                if (!g.afu().feA.feQ) {
                    g.afu().feA.afU();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            v.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[]{Integer.valueOf(arrayList.size())});
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                olVar = (ol) it2.next();
                if (!(olVar == null || be.kS(olVar.mdM))) {
                    if (olVar.mdM.equals(String.valueOf(com.tencent.mm.storage.a.a.nwJ))) {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.g.a.c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.g.a.b(olVar.mdM, (byte) 0));
                    }
                }
            }
            g.afu().x(arrayList4);
            if (!g.afu().feA.feQ) {
                g.afu().feA.afU();
            }
        }
    }
}
