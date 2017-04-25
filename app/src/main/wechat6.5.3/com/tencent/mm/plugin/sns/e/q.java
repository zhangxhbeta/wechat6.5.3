package com.tencent.mm.plugin.sns.e;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.ku;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.nx;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class q extends k implements j {
    int cNA = 0;
    private c cND = new c<kv>(this) {
        final /* synthetic */ q jkr;

        {
            this.jkr = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        private boolean a(kv kvVar) {
            if (this.jkr.jkq.containsKey(kvVar.bme.filePath)) {
                String encode;
                int intValue = ((Integer) this.jkr.jkq.remove(kvVar.bme.filePath)).intValue();
                String str = "";
                try {
                    encode = URLEncoder.encode(kvVar.bme.bfz, "UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                    encode = str;
                }
                if (this.jkr.cNA != 0) {
                    aib com_tencent_mm_protocal_c_aib = (aib) this.jkr.jkp.get(kvVar.bme.filePath);
                    q qVar = this.jkr;
                    qVar.jko += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s|", new Object[]{Integer.valueOf(intValue), encode, com_tencent_mm_protocal_c_aib.mId, com_tencent_mm_protocal_c_aib.glb});
                }
                if (this.jkr.jkn == 12) {
                    v.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), "2,3,," + encode});
                    g.iuh.Y(13717, str);
                }
                q.a(this.jkr);
            }
            return false;
        }
    };
    private c cNE = new c<ku>(this) {
        final /* synthetic */ q jkr;

        {
            this.jkr = r2;
            this.nhz = ku.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ku kuVar = (ku) bVar;
            if (this.jkr.jkq.containsKey(kuVar.bmd.filePath)) {
                int intValue = ((Integer) this.jkr.jkq.remove(kuVar.bmd.filePath)).intValue();
                if (this.jkr.jkn == 12) {
                    v.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), "2,3,,"});
                    g.iuh.Y(13717, "2,3,,");
                }
                q.a(this.jkr);
            }
            return false;
        }
    };
    private com.tencent.mm.v.b cif;
    public e cii;
    boolean eRm = false;
    int jdV;
    private azr jki;
    private azr jkj;
    long jkk = 0;
    private int jkl = 0;
    private rc jkm;
    int jkn;
    String jko = "";
    HashMap<String, aib> jkp = new HashMap();
    HashMap<String, Integer> jkq = new HashMap();

    static /* synthetic */ void a(q qVar) {
        if (qVar.jkq.isEmpty()) {
            a.nhr.f(qVar.cND);
            a.nhr.f(qVar.cNE);
            if (qVar.cNA != 0 && !be.kS(qVar.jko)) {
                String str = qVar.jkj.mWp == null ? "" : qVar.jkj.mWp.gID;
                int size = qVar.jkj.mWq.mom.size();
                v.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", new Object[]{qVar.jkj.gID, Integer.valueOf(size), qVar.jko, str});
                n.aB(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{qVar.jkj.gID, Integer.valueOf(size), qVar.jko, str}));
            }
        }
    }

    public q(String str, int i, int i2, List<String> list, azr com_tencent_mm_protocal_c_azr, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, aic com_tencent_mm_protocal_c_aic, boolean z, LinkedList<arf> linkedList2, awk com_tencent_mm_protocal_c_awk, com.tencent.mm.ba.b bVar, String str3) {
        int i6;
        this.jki = com_tencent_mm_protocal_c_azr;
        this.jdV = i3;
        this.jkn = i5;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new awl();
        aVar.czo = new awm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.czm = 209;
        aVar.czp = 97;
        aVar.czq = 1000000097;
        this.cif = aVar.Bv();
        awl com_tencent_mm_protocal_c_awl = (awl) this.cif.czk.czs;
        if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_azr.joj.maK.maE)) {
            ir irVar = new ir();
            irVar.mkc = com_tencent_mm_protocal_c_azr.joj.maK.maE;
            com_tencent_mm_protocal_c_awl.mTT = irVar;
        }
        o.b fy = o.yx().fy(com_tencent_mm_protocal_c_aic.aZj);
        if (fy != null) {
            String str4;
            this.jkm = new rc();
            this.jkm.bsP.bsQ = fy.getString("prePublishId", "");
            this.jkm.bsP.url = fy.getString("url", "");
            this.jkm.bsP.bsS = fy.getString("preUsername", "");
            this.jkm.bsP.bsT = fy.getString("preChatName", "");
            this.jkm.bsP.bsU = fy.bf("preMsgIndex");
            this.jkm.bsP.bsY = fy.bf("sendAppMsgScene");
            this.jkm.bsP.bsZ = fy.bf("getA8KeyScene");
            this.jkm.bsP.bta = fy.getString("referUrl", null);
            this.jkm.bsP.btb = fy.getString("adExtStr", null);
            this.jkm.bsP.btc = str3;
            str4 = "";
            if (com_tencent_mm_protocal_c_azr.jGu != null) {
                axz com_tencent_mm_protocal_c_axz = new axz();
                try {
                    com_tencent_mm_protocal_c_axz.az(Base64.decode(com_tencent_mm_protocal_c_azr.jGu, 0));
                    if (com_tencent_mm_protocal_c_axz.mVv != null) {
                        str4 = com_tencent_mm_protocal_c_axz.mVv.ghW;
                    }
                } catch (Exception e) {
                }
            }
            if (be.kS(str4) && com_tencent_mm_protocal_c_azr.mWp != null) {
                str4 = com_tencent_mm_protocal_c_azr.mWp.gID;
            }
            com_tencent_mm_protocal_c_awl.mTS = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.jkm.bsP.bsQ, this.jkm.bsP.bsS, this.jkm.bsP.bsT, Integer.valueOf(com.tencent.mm.model.n.F(this.jkm.bsP.bsS, this.jkm.bsP.bsT)), Integer.valueOf(this.jkm.bsP.bsZ), str4});
        }
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(str.getBytes());
        String str5 = "MicroMsg.NetSceneSnsPost";
        String str6 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_are.mQu);
        if (bVar == null) {
            i6 = 0;
        } else {
            i6 = bVar.lVU.length;
        }
        objArr[2] = Integer.valueOf(i6);
        v.i(str5, str6, objArr);
        com_tencent_mm_protocal_c_awl.mTg = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_awl.mTN = i;
        com_tencent_mm_protocal_c_awl.mIm = i2;
        com_tencent_mm_protocal_c_awl.mbN = str2;
        this.jkl = i;
        if (com.tencent.mm.platformtools.q.dpL) {
            com_tencent_mm_protocal_c_awl.mTg = new are();
            v.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList linkedList3 = new LinkedList();
        if (list != null && list.size() > 0) {
            String str7 = "";
            for (String str42 : list) {
                arf com_tencent_mm_protocal_c_arf = new arf();
                com_tencent_mm_protocal_c_arf.JF(str42);
                linkedList3.add(com_tencent_mm_protocal_c_arf);
                str7 = str7 + "; + " + str42;
            }
            v.d("MicroMsg.NetSceneSnsPost", "post with list : " + str7);
        }
        com_tencent_mm_protocal_c_awl.mTq = linkedList3;
        com_tencent_mm_protocal_c_awl.mTp = linkedList3.size();
        com_tencent_mm_protocal_c_awl.mTO = i4;
        v.d("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s", new Object[]{Integer.valueOf(i5), str2, com_tencent_mm_protocal_c_awl.mTS});
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                com_tencent_mm_protocal_c_awl.mTw = linkedList2;
                com_tencent_mm_protocal_c_awl.mTv = linkedList2.size();
            } else {
                com_tencent_mm_protocal_c_awl.mIw = linkedList2;
                com_tencent_mm_protocal_c_awl.mTx = linkedList2.size();
            }
        }
        v.d("MicroMsg.NetSceneSnsPost", "setObjectSource " + i5);
        com_tencent_mm_protocal_c_awl.mTP = i5;
        bah com_tencent_mm_protocal_c_bah = new bah();
        if (!be.kS(com_tencent_mm_protocal_c_aic.token)) {
            com_tencent_mm_protocal_c_bah.mWT = com_tencent_mm_protocal_c_aic.token;
            com_tencent_mm_protocal_c_bah.mWU = com_tencent_mm_protocal_c_aic.mIu;
            com_tencent_mm_protocal_c_awl.mNq = com_tencent_mm_protocal_c_bah;
        }
        if (!(linkedList == null || linkedList.isEmpty())) {
            com_tencent_mm_protocal_c_awl.mKB = linkedList.size();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                avw com_tencent_mm_protocal_c_avw = new avw();
                com_tencent_mm_protocal_c_avw.mTf = l.longValue();
                com_tencent_mm_protocal_c_awl.mIs.add(com_tencent_mm_protocal_c_avw);
            }
            v.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + com_tencent_mm_protocal_c_awl.mIs.toString());
        }
        com_tencent_mm_protocal_c_awl.mIx = com_tencent_mm_protocal_c_awk;
        if (!be.kS(com_tencent_mm_protocal_c_aic.mIz)) {
            com_tencent_mm_protocal_c_awl.mTz = new awq();
        }
        if (com_tencent_mm_protocal_c_awk != null) {
            v.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{com_tencent_mm_protocal_c_awk.mcR, com_tencent_mm_protocal_c_awk.mcS, com_tencent_mm_protocal_c_awk.mcT});
        }
        if (bVar != null) {
            com_tencent_mm_protocal_c_awl.mTR = new are().c(bVar);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        awm com_tencent_mm_protocal_c_awm = (awm) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (i2 == 4) {
            com.tencent.mm.plugin.sns.storage.k qG = ad.aSE().qG(this.jdV);
            try {
                aic com_tencent_mm_protocal_c_aic = (aic) new aic().az(qG.field_postBuf);
                com_tencent_mm_protocal_c_aic.mIt = i3;
                com_tencent_mm_protocal_c_aic.mIB = com_tencent_mm_protocal_c_awm.mIB;
                com_tencent_mm_protocal_c_aic.mIC = false;
                qG.field_postBuf = com_tencent_mm_protocal_c_aic.toByteArray();
            } catch (Exception e) {
            }
            if (qG != null) {
                qG.aUP();
                ad.aSE().b(this.jdV, qG);
                ad.aSD().qa(this.jdV);
                v.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + qG.aUL());
                nx nxVar = new nx();
                nxVar.boT.boU = (long) this.jdV;
                a.nhr.z(nxVar);
            }
            if (!(this.jki == null || this.jki.mWq == null || this.jki.mWq.mol != 21)) {
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(8);
                switch (i3) {
                    case -1:
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(19);
                        break;
                    case 201:
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(17);
                        break;
                    case 211:
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(20);
                        break;
                }
            }
            this.cii.a(i2, i3, str, this);
        } else if (i3 != 0) {
            ad.aSD().qa(this.jdV);
            if (!(this.jki == null || this.jki.mWq == null || this.jki.mWq.mol != 21)) {
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(8);
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(16);
            }
            this.cii.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_awm.mSF == null || com_tencent_mm_protocal_c_awm.mSF.mTg == null || com_tencent_mm_protocal_c_awm.mSF.mTg.mQw == null) {
            v.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            ad.aSD().qa(this.jdV);
            com.tencent.mm.plugin.sns.storage.k qG2 = ad.aSE().qG(this.jdV);
            qG2.aUO();
            ad.aSE().b(this.jdV, qG2);
            ny nyVar = new ny();
            nyVar.boV.boU = (long) this.jdV;
            a.nhr.z(nyVar);
            this.cii.a(i2, i3, str, this);
        } else {
            String str2 = new String(com_tencent_mm_protocal_c_awm.mSF.mTg.mQw.toByteArray());
            if (this.jkl == 0) {
                v.d("MicroMsg.NetSceneSnsPost", "resp " + str2 + "  ");
            }
            this.jkj = d.ko(str2);
            if (this.jkj.mWv != null) {
                String str3 = this.jkj.gID;
                String str4 = this.jkj.mWv.cqn;
                String str5 = this.jkj.mWv.cqm;
                com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                cVar.n("20CurrPublishId", str3 + ",");
                cVar.n("20SourcePublishId", str4 + ",");
                cVar.n("20SourceAdUxInfo", str5 + ",");
                v.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + cVar.JH());
                g.iuh.h(13004, new Object[]{cVar});
            }
            com.tencent.mm.plugin.sns.storage.k qG3 = ad.aSE().qG(this.jdV);
            if (qG3 == null) {
                v.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                qG3 = new com.tencent.mm.plugin.sns.storage.k();
            }
            qG3.fw(com_tencent_mm_protocal_c_awm.mSF.hNS);
            qG3.Bo(str2);
            qG3.field_localFlag &= -17;
            qG3.cY(com_tencent_mm_protocal_c_awm.mSF.mjq);
            qG3.da(com_tencent_mm_protocal_c_awm.mSF.mjq);
            if ((com_tencent_mm_protocal_c_awm.mSF.mTr & 1) > 0) {
                qG3.aUI();
            }
            this.jkk = com_tencent_mm_protocal_c_awm.mSF.mjq;
            if (this.jkm != null) {
                this.jkm.bsP.bsR = "sns_" + i.cE(this.jkk);
                a.nhr.z(this.jkm);
            }
            awa com_tencent_mm_protocal_c_awa = com_tencent_mm_protocal_c_awm.mSF;
            com_tencent_mm_protocal_c_awa.mTg.ba(new byte[0]);
            try {
                com.tencent.mm.modelsns.a aX;
                ny nyVar2;
                int i4;
                String str6;
                if (com_tencent_mm_protocal_c_awa.mTm == 0 && com_tencent_mm_protocal_c_awa.mTj == 0 && com_tencent_mm_protocal_c_awa.mTp == 0 && com_tencent_mm_protocal_c_awa.mKB == 0) {
                    v.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    qG3.aUO();
                    ad.aSE().b(this.jdV, qG3);
                    ad.aSD().qa(this.jdV);
                    aX = com.tencent.mm.plugin.sns.i.e.jtT.aX(Integer.valueOf(this.jdV));
                    aX.JC();
                    aX.JD();
                    aX.kl(this.jkj.gID);
                    aX.gk(this.jkj.mWq.mol);
                    aX.JF();
                    aX = f.jtT.aX(Integer.valueOf(this.jdV));
                    aX.JC();
                    aX.JD();
                    aX.kl(this.jkj.gID);
                    aX.gk(this.jkj.mWq.mol);
                    aX.JF();
                    nyVar2 = new ny();
                    nyVar2.boV.boU = (long) this.jdV;
                    a.nhr.z(nyVar2);
                    if (qG3.field_type == 21) {
                        if (qG3.field_pravited != 1) {
                            i4 = com_tencent_mm_protocal_c_awm.mSF.mTr;
                        }
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(7);
                        str6 = this.jkj.gID;
                        System.currentTimeMillis();
                    }
                    a(this.jki, this.jkj);
                    aRY();
                    if (ad.aSA() != null) {
                        ad.aSA().aTe();
                    }
                    this.cii.a(i2, i3, str, this);
                }
                qG3.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                qG3.aUO();
                ad.aSE().b(this.jdV, qG3);
                ad.aSD().qa(this.jdV);
                aX = com.tencent.mm.plugin.sns.i.e.jtT.aX(Integer.valueOf(this.jdV));
                if (!(aX == null || this.jkj == null)) {
                    aX.JC();
                    aX.JD();
                    aX.kl(this.jkj.gID);
                    aX.gk(this.jkj.mWq.mol);
                    aX.JF();
                }
                aX = f.jtT.aX(Integer.valueOf(this.jdV));
                if (!(aX == null || this.jkj == null)) {
                    aX.JC();
                    aX.JD();
                    aX.kl(this.jkj.gID);
                    aX.gk(this.jkj.mWq.mol);
                    aX.JF();
                }
                nyVar2 = new ny();
                nyVar2.boV.boU = (long) this.jdV;
                a.nhr.z(nyVar2);
                if (qG3.field_type == 21) {
                    if (qG3.field_pravited != 1) {
                        i4 = com_tencent_mm_protocal_c_awm.mSF.mTr;
                    }
                    com.tencent.mm.plugin.sns.lucky.b.b.kZ(7);
                    str6 = this.jkj.gID;
                    System.currentTimeMillis();
                }
                a(this.jki, this.jkj);
                aRY();
                if (ad.aSA() != null) {
                    ad.aSA().aTe();
                }
                this.cii.a(i2, i3, str, this);
            } catch (Throwable e2) {
                v.a("MicroMsg.NetSceneSnsPost", e2, "", new Object[0]);
            }
        }
    }

    private void aRY() {
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100132");
        if (Ls.isValid()) {
            this.cNA = t.getInt((String) Ls.buX().get("needUploadData"), 1);
        }
        if ((this.jkn == 12 || this.cNA != 0) && this.jkj != null && this.jkj.mWq != null && this.jkj.mWq.mom != null && this.jkj.mWq.mom.size() > 0) {
            LinkedList linkedList = this.jkj.mWq.mom;
            a.nhr.e(this.cND);
            a.nhr.e(this.cNE);
            Iterator it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                aib com_tencent_mm_protocal_c_aib = (aib) it.next();
                if (com_tencent_mm_protocal_c_aib.efm == 2) {
                    String C = g.C(com_tencent_mm_protocal_c_aib);
                    if (!be.kS(C)) {
                        this.jkq.put(C, Integer.valueOf(i));
                        this.jkp.put(C, com_tencent_mm_protocal_c_aib);
                        int i2 = i + 1;
                        kt ktVar = new kt();
                        ktVar.bmc.filePath = C;
                        a.nhr.z(ktVar);
                        i = i2;
                    }
                }
            }
        }
    }

    private static boolean a(azr com_tencent_mm_protocal_c_azr, azr com_tencent_mm_protocal_c_azr2) {
        if (com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr2 == null || com_tencent_mm_protocal_c_azr.mWq == null || com_tencent_mm_protocal_c_azr2.mWq == null) {
            return false;
        }
        String xh = ad.xh();
        int i = 0;
        while (i < com_tencent_mm_protocal_c_azr.mWq.mom.size() && i < com_tencent_mm_protocal_c_azr2.mWq.mom.size()) {
            aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(i);
            aib com_tencent_mm_protocal_c_aib2 = (aib) com_tencent_mm_protocal_c_azr2.mWq.mom.get(i);
            String l = i.l(com_tencent_mm_protocal_c_aib);
            String m = i.m(com_tencent_mm_protocal_c_aib);
            String n = i.n(com_tencent_mm_protocal_c_aib);
            String o = i.o(com_tencent_mm_protocal_c_aib);
            String k = i.k(com_tencent_mm_protocal_c_aib2);
            String c = i.c(com_tencent_mm_protocal_c_aib2);
            String d = i.d(com_tencent_mm_protocal_c_aib2);
            String i2 = i.i(com_tencent_mm_protocal_c_aib2);
            v.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + l + "  - " + k);
            String cA = al.cA(xh, com_tencent_mm_protocal_c_aib.gID);
            String cA2 = al.cA(xh, com_tencent_mm_protocal_c_aib2.gID);
            FileOp.jS(cA2);
            FileOp.ab(cA + l, cA2 + k);
            FileOp.ab(cA + m, cA2 + c);
            FileOp.ab(cA + n, cA2 + d);
            if (FileOp.aR(cA + o)) {
                v.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[]{cA2 + i2});
                FileOp.ab(cA + o, cA2 + i2);
            }
            i++;
        }
        return true;
    }

    public final int getType() {
        return 209;
    }
}
