package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.e.a.lb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.d.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends k implements j {
    public static int fdO = 0;
    public static int fdP = 1;
    public final b cif;
    private com.tencent.mm.v.e cii;
    private ArrayList<String> fdN = new ArrayList();
    private HashMap<String, nu> fdQ = new HashMap();
    public int fdR = 0;
    private LinkedList<String> fdS = new LinkedList();
    private int mIndex = 0;

    public e() {
        a aVar = new a();
        aVar.czn = new ex();
        aVar.czo = new ey();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.czm = 697;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.mIndex = 0;
        this.fdR = fdO;
        this.fdS = new LinkedList();
    }

    public e(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.czn = new ex();
        aVar.czo = new ey();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.czm = 697;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.mIndex = 0;
        this.fdR = fdP;
        this.fdS = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        ey eyVar;
        if (this.fdR == fdO) {
            if (i2 == 0 && i3 == 0) {
                eyVar = (ey) this.cif.czl.czs;
                ex exVar = (ex) this.cif.czk.czs;
                if (eyVar.mfh == 0 && (eyVar.meA == null || eyVar.meA.size() <= 0)) {
                    this.cii.a(i2, i3, str, this);
                    v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    g.iuh.a(164, 0, 1, false);
                    return;
                } else if (eyVar.mfh == 1) {
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.fdQ == null ? 0 : this.fdQ.size());
                    v.i(str2, str3, objArr);
                    this.cii.a(i2, i3, str, this);
                    ak.yW();
                    c.vf().a(t.a.noN, Long.valueOf(System.currentTimeMillis()));
                    a(eyVar);
                    List<String> list = this.fdN;
                    if (list == null || list.size() <= 0) {
                        v.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        ak.yW();
                        c.vf().a(t.a.noC, Boolean.valueOf(false));
                    } else {
                        long er;
                        String str4;
                        if (list.size() < o.afk()) {
                            ak.yW();
                            c.vf().a(t.a.noC, Boolean.valueOf(false));
                        }
                        ak.yW();
                        boolean booleanValue = ((Boolean) c.vf().get(t.a.noF, Boolean.valueOf(true))).booleanValue();
                        f fVar = com.tencent.mm.plugin.emoji.model.g.afx().fch;
                        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
                        } else {
                            com.tencent.mm.bg.g gVar;
                            if (fVar.cie instanceof com.tencent.mm.bg.g) {
                                com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) fVar.cie;
                                er = gVar2.er(Thread.currentThread().getId());
                                gVar = gVar2;
                            } else {
                                gVar = null;
                                er = -1;
                            }
                            int i4 = 1;
                            for (String str5 : list) {
                                com.tencent.mm.storage.a.c NF = fVar.NF(str5);
                                if (NF == null || be.kS(NF.EB()) || !NF.bxE()) {
                                    NF = new com.tencent.mm.storage.a.c();
                                    NF.field_md5 = str5;
                                    NF.field_catalog = 85;
                                    NF.field_source = com.tencent.mm.storage.a.c.nxe;
                                    NF.field_lastUseTime = System.currentTimeMillis();
                                } else {
                                    NF.field_source = com.tencent.mm.storage.a.c.nxe;
                                    if (NF.field_catalog == com.tencent.mm.storage.a.c.nwM) {
                                        NF.field_catalog = com.tencent.mm.storage.a.c.nwR;
                                    }
                                }
                                NF.field_reserved3 = i4;
                                if (booleanValue) {
                                    v.d("MicroMsg.emoji.EmojiInfoStorage", "need repair");
                                    NF.field_temp = 2;
                                }
                                if (NF.bxE()) {
                                    com.tencent.mm.e.a.ak akVar = new com.tencent.mm.e.a.ak();
                                    akVar.aYa.type = 0;
                                    akVar.aYa.aYc = NF;
                                    com.tencent.mm.sdk.c.a.nhr.z(akVar);
                                    if (!akVar.aYb.aXR) {
                                        v.d("MicroMsg.emoji.EmojiInfoStorage", "decode failed re download.");
                                        NF.field_temp = 2;
                                    }
                                } else {
                                    v.d("MicroMsg.emoji.EmojiInfoStorage", "file don't exist");
                                    NF.field_temp = 2;
                                }
                                r4 = i4 + 1;
                                if (fVar.cie.replace("EmojiInfo", "md5", NF.py()) < 0) {
                                    if (gVar != null) {
                                        gVar.es(er);
                                    }
                                    v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                } else {
                                    i4 = r4;
                                }
                            }
                            if (gVar != null) {
                                gVar.es(er);
                            }
                            str4 = "MicroMsg.emoji.EmojiInfoStorage";
                            str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            objArr2[1] = Integer.valueOf(list == null ? 0 : list.size());
                            v.i(str4, str2, objArr2);
                        }
                        ak.yW();
                        c.vf().a(t.a.noF, Boolean.valueOf(false));
                        f fVar2 = com.tencent.mm.plugin.emoji.model.g.afx().fch;
                        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        er = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> bxO = fVar2.bxO();
                            if (bxO.size() <= 0) {
                                v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                Object arrayList = new ArrayList();
                                for (String str52 : bxO) {
                                    if (!list.contains(str52.toLowerCase())) {
                                        arrayList.add(str52);
                                        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[]{str52});
                                    }
                                }
                                fVar2.ci(arrayList);
                                v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - er), Integer.valueOf(arrayList.size())});
                            }
                        }
                        ArrayList arrayList2 = (ArrayList) com.tencent.mm.plugin.emoji.model.g.afx().fch.bxP();
                        if (arrayList2.size() > 0) {
                            v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                            ArrayList arrayList3 = new ArrayList();
                            int size = arrayList2.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                str4 = ((String) arrayList2.get(i5)).toLowerCase();
                                if (this.fdQ == null || !this.fdQ.containsKey(str4) || this.fdQ.get(str4) == null) {
                                    v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "emoji info list no contains md5:%s", new Object[]{str4});
                                } else {
                                    nu nuVar = (nu) this.fdQ.get(str4);
                                    arrayList3.add(new com.tencent.mm.plugin.emoji.g.a.a(str4, nuVar.glb, nuVar.hOx, nuVar.mpD, nuVar.mpE, nuVar.mpF, nuVar.mdM));
                                }
                            }
                            com.tencent.mm.plugin.emoji.model.g.afu().feA.feL = list.size();
                            com.tencent.mm.plugin.emoji.model.g.afu().w(arrayList3);
                            com.tencent.mm.plugin.emoji.model.g.afu().feA.afU();
                            g.iuh.h(11595, new Object[]{Integer.valueOf(2)});
                            if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                g.iuh.h(11595, new Object[]{Integer.valueOf(3)});
                            }
                        } else {
                            ak.yW();
                            c.vf().a(t.a.noK, Boolean.valueOf(false));
                            v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        com.tencent.mm.sdk.c.a.nhr.z(new lb());
                    }
                    g.iuh.a(164, 0, 1, false);
                    return;
                } else {
                    v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[]{Integer.valueOf(exVar.mfJ), Integer.valueOf(eyVar.meA.size())});
                    this.cii.a(i2, i3, str, this);
                    exVar.mfJ = eyVar.mfJ;
                    this.mIndex = exVar.mfJ;
                    a(eyVar);
                    r4 = a(this.czE, this.cii);
                    if (i < 0) {
                        v.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[]{Integer.valueOf(r4)});
                        return;
                    }
                    return;
                }
            }
            this.cii.a(i2, i3, str, this);
            g.iuh.a(164, 1, 1, false);
            ak.yW();
            c.vf().a(t.a.noN, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
        } else if (i2 == 0 && i3 == 0) {
            eyVar = (ey) this.cif.czl.czs;
            if (eyVar.mfM == null || eyVar.mfM.size() <= 0) {
                v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                com.tencent.mm.plugin.emoji.model.g.afx().fch.ck(eyVar.mfM);
            }
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    private void a(ey eyVar) {
        if (eyVar == null) {
            v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
        } else if (eyVar.mfM == null || eyVar.mfM.size() <= 0) {
            v.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
        } else {
            Iterator it = eyVar.mfM.iterator();
            while (it.hasNext()) {
                nu nuVar = (nu) it.next();
                String toLowerCase = nuVar.mpC.toLowerCase();
                this.fdN.add(toLowerCase);
                this.fdQ.put(toLowerCase, nuVar);
            }
        }
    }

    public final int getType() {
        return 697;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        ex exVar = (ex) this.cif.czk.czs;
        exVar.mfJ = this.mIndex;
        exVar.mfK = this.fdR;
        exVar.mfL = this.fdS;
        return a(eVar, this.cif, this);
    }

    protected final int ul() {
        return 20;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }
}
