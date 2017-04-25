package com.tencent.mm.plugin.sns.e;

import android.database.Cursor;
import com.tencent.mm.e.a.nx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.j.q.h;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class at implements h, e {
    public static int jiE = 0;
    private String bYE = "";
    public Set<a> cbh = new HashSet();
    private q jnI = null;
    public com.tencent.mm.plugin.sns.e.z.a jnJ = new com.tencent.mm.plugin.sns.e.z.a(this) {
        final /* synthetic */ at jnK;

        {
            this.jnK = r1;
        }

        public final void fS(boolean z) {
            if (!z) {
                this.jnK.aTe();
            }
        }
    };

    public interface a {
        void J(int i, boolean z);

        void aTh();
    }

    public enum b {
        ;

        static {
            jnW = 1;
            jnX = 2;
            jnY = 3;
            jnZ = new int[]{jnW, jnX, jnY};
        }
    }

    static /* synthetic */ void a(at atVar) {
        if (ad.aSo() != null && !ad.aSn()) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                ad.aSo().post(new Runnable(atVar) {
                    final /* synthetic */ at jnK;

                    {
                        this.jnK = r1;
                    }

                    public final void run() {
                        k kVar = null;
                        if (ad.aSn()) {
                            v.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                            return;
                        }
                        this.jnK.aTf();
                        if (ad.aSn()) {
                            v.e("MicroMsg.UploadManager", "is invalid after checkTLE");
                            return;
                        }
                        l aSE = ad.aSE();
                        k kVar2 = new k();
                        String str = "select *,rowid from SnsInfo  where " + l.jCd + " order by SnsInfo.rowid" + " asc ";
                        Cursor rawQuery = aSE.cie.rawQuery(str, null);
                        v.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
                        if (rawQuery.getCount() == 0) {
                            rawQuery.close();
                        } else {
                            rawQuery.moveToFirst();
                            kVar2.b(rawQuery);
                            rawQuery.close();
                            kVar = kVar2;
                        }
                        if (kVar == null) {
                            v.d("MicroMsg.UploadManager", "All has post");
                        } else if (ad.aSD().pY(kVar.jBI)) {
                            v.d("MicroMsg.UploadManager", "checking isPosting " + kVar.jBI);
                        } else {
                            v.d("MicroMsg.UploadManager", "checking startPost " + kVar.aUL());
                            this.jnK.t(kVar);
                        }
                    }
                });
            }
        }
    }

    public final String aSk() {
        if (this.bYE == null || this.bYE.equals("")) {
            ak.yW();
            this.bYE = (String) c.vf().get(2, null);
        }
        return this.bYE;
    }

    private void a(k kVar, int i, int i2, String str) {
        int i3;
        nx nxVar;
        v.i("MicroMsg.UploadManager", "localId " + kVar.aUL() + "processError " + i2 + " errMsg: " + str);
        g.iuh.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((aie) new aie().az(ad.aSt().de((long) i).jCs)).mIt;
                try {
                    aic aUD = kVar.aUD();
                    if (aUD != null) {
                        aUD.mIt = i3;
                        kVar.field_postBuf = aUD.toByteArray();
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    v.d("MicroMsg.UploadManager", "post error " + i3);
                    kVar.aUP();
                    ad.aSE().b(kVar.jBI, kVar);
                    v.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + kVar.jBI);
                    nxVar = new nx();
                    nxVar.boT.boU = (long) kVar.jBI;
                    com.tencent.mm.sdk.c.a.nhr.z(nxVar);
                    switch (i2) {
                        case 1:
                            v.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                            break;
                        case 2:
                            v.e("MicroMsg.UploadManager", "parser protobuf error");
                            break;
                        case 3:
                            v.e("MicroMsg.UploadManager", "local id is not in db");
                            break;
                        case 4:
                            v.e("MicroMsg.UploadManager", "arg is error");
                            break;
                        case 5:
                            v.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                            break;
                        case 6:
                            v.e("MicroMsg.UploadManager", "errtle  error");
                            break;
                    }
                    I(kVar.jBI, false);
                }
            } catch (Exception e2) {
                i3 = 0;
                v.e("MicroMsg.UploadManager", "parse uploadInfo error");
                v.d("MicroMsg.UploadManager", "post error " + i3);
                kVar.aUP();
                ad.aSE().b(kVar.jBI, kVar);
                v.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + kVar.jBI);
                nxVar = new nx();
                nxVar.boT.boU = (long) kVar.jBI;
                com.tencent.mm.sdk.c.a.nhr.z(nxVar);
                switch (i2) {
                    case 1:
                        v.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                        break;
                    case 2:
                        v.e("MicroMsg.UploadManager", "parser protobuf error");
                        break;
                    case 3:
                        v.e("MicroMsg.UploadManager", "local id is not in db");
                        break;
                    case 4:
                        v.e("MicroMsg.UploadManager", "arg is error");
                        break;
                    case 5:
                        v.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                        break;
                    case 6:
                        v.e("MicroMsg.UploadManager", "errtle  error");
                        break;
                }
                I(kVar.jBI, false);
            }
        }
        aic aUD2 = kVar.aUD();
        i3 = aUD2 != null ? aUD2.mIt : 0;
        v.d("MicroMsg.UploadManager", "post error " + i3);
        kVar.aUP();
        ad.aSE().b(kVar.jBI, kVar);
        v.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + kVar.jBI);
        nxVar = new nx();
        nxVar.boT.boU = (long) kVar.jBI;
        com.tencent.mm.sdk.c.a.nhr.z(nxVar);
        switch (i2) {
            case 1:
                v.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                v.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                v.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                v.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                v.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                v.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        I(kVar.jBI, false);
    }

    private void b(k kVar, int i, String str) {
        a(kVar, 0, i, str);
    }

    private static int qi(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean cD(String str, String str2) {
        v.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = ad.xi() + com.tencent.mm.a.g.m(str.getBytes());
        FileOp.p(str, str3);
        au auVar = new au(1);
        auVar.AG(str2);
        auVar.qo(6);
        List linkedList = new LinkedList();
        linkedList.add(new com.tencent.mm.plugin.sns.data.h(str3, 2));
        auVar.bp(linkedList);
        if (auVar.commit() > 0) {
            return true;
        }
        return false;
    }

    public static au a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        v.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        v.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        com.tencent.mm.sdk.modelmsg.WXMediaMessage.b bVar = wXMediaMessage.mediaObject;
        switch (bVar.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        au auVar = new au(i);
        auVar.AM(be.ah(str2, "")).AN(be.ah(str3, ""));
        auVar.qo(5);
        v.d("MicroMsg.UploadManager", "TimeLineType " + i);
        if (i == -1) {
            v.d("MicroMsg.UploadManager", "timeLineType is invalid");
            return null;
        }
        if (!be.kS(str)) {
            auVar.AG(str);
        }
        auVar.AL(be.ah(wXMediaMessage.title, "")).AJ(be.ah(wXMediaMessage.description, ""));
        int qi;
        switch (bVar.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) bVar;
                auVar.AJ("");
                auVar.AG(wXTextObject.text);
                return auVar;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) bVar;
                if (be.bl(wXImageObject.imageData)) {
                    if (be.kS(wXImageObject.imagePath)) {
                        v.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        return null;
                    } else if (auVar.cF(wXImageObject.imagePath, "")) {
                        return auVar;
                    } else {
                        return null;
                    }
                } else if (auVar.a(wXImageObject.imageData, "", "")) {
                    return auVar;
                } else {
                    return null;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) bVar;
                String ah = be.ah(!be.kS(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String ah2 = be.ah(!be.kS(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                auVar.AL("").AJ("");
                qi = qi(3);
                if (qi == -1) {
                    v.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (auVar.a(wXMediaMessage.thumbData, ah, be.ah(!be.kS(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), ah2, qi, be.ah(wXMediaMessage.title, ""), be.ah(wXMediaMessage.description, ""))) {
                    return auVar;
                }
                return null;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) bVar;
                auVar.AL("").AJ("");
                qi = qi(4);
                if (qi == -1) {
                    v.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (auVar.a(wXMediaMessage.thumbData, be.ah(!be.kS(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, qi, be.ah(wXMediaMessage.title, ""), be.ah(wXMediaMessage.description, ""))) {
                    return auVar;
                }
                return null;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) bVar;
                if (!be.bl(wXMediaMessage.thumbData)) {
                    auVar.a(wXMediaMessage.thumbData, be.ah(wXMediaMessage.description, ""), be.ah(wXMediaMessage.title, ""));
                }
                auVar.AJ(wXWebpageObject.webpageUrl).AK(wXWebpageObject.webpageUrl);
                auVar.bpt.mWq.glb = wXWebpageObject.webpageUrl;
                auVar.AI(wXWebpageObject.canvasPageXml);
                return auVar;
            case 6:
                v.e("MicroMsg.UploadManager", "file is not support!");
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) bVar;
                if (be.kS(wXAppExtendObject.filePath) || !wXAppExtendObject.filePath.startsWith("http")) {
                    v.e("MicroMsg.UploadManager", "appdata is not support!");
                    return null;
                }
                auVar.AL(wXAppExtendObject.filePath);
                auVar.AJ(wXAppExtendObject.filePath);
                return auVar;
            default:
                v.e("MicroMsg.UploadManager", "none type not support!");
                return null;
        }
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        au a = a(wXMediaMessage, str, str2, str3);
        if (a == null) {
            return false;
        }
        a.AH(wXMediaMessage.mediaTagName);
        a.N(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.b.a.jdC) {
            a.qk(1);
        }
        v.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + a.commit());
        return true;
    }

    private boolean q(k kVar) {
        if (kVar == null) {
            return false;
        }
        azr aUp = kVar.aUp();
        if (aUp.mWq.mol == 8) {
            return true;
        }
        if (aUp.mWq.mol == 2) {
            return true;
        }
        if (aUp == null || aUp.mWq.mom == null) {
            b(kVar, 1, "timeline or timelineObjList is null");
            return false;
        } else if (aUp.mWq.mom.size() == 0) {
            return true;
        } else {
            try {
                boolean z;
                boolean z2;
                aic com_tencent_mm_protocal_c_aic = (aic) new aic().az(kVar.field_postBuf);
                if (aUp.mWq.mol != 1) {
                    z = true;
                } else if (com_tencent_mm_protocal_c_aic.mIn.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (aUp.mWq.mol == 21) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (aUp.mWq.mol == 15) {
                    Iterator it = com_tencent_mm_protocal_c_aic.mIn.iterator();
                    while (it.hasNext()) {
                        ago com_tencent_mm_protocal_c_ago = (ago) it.next();
                        int qj = qj(com_tencent_mm_protocal_c_ago.mGh);
                        if (qj == b.jnW) {
                            a(kVar, com_tencent_mm_protocal_c_ago.mGh, 2, "upload has set it fail");
                            return false;
                        } else if (qj == b.jnY) {
                            return false;
                        }
                    }
                    return true;
                }
                Iterator it2 = com_tencent_mm_protocal_c_aic.mIn.iterator();
                while (it2.hasNext()) {
                    ago com_tencent_mm_protocal_c_ago2 = (ago) it2.next();
                    int a = a(com_tencent_mm_protocal_c_ago2.mGh, z2, com_tencent_mm_protocal_c_aic, aUp.mWq.mol);
                    if (a == b.jnW) {
                        a(kVar, com_tencent_mm_protocal_c_ago2.mGh, 2, "upload has set it fail");
                        return false;
                    } else if (a == b.jnY) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + kVar.aUL());
                b(kVar, 2, "mediaPostInfo parser error " + e.getMessage());
                return false;
            }
        }
    }

    public final void r(k kVar) {
        if (kVar != null) {
            aic com_tencent_mm_protocal_c_aic;
            v.i("MicroMsg.UploadManager", "cancel snsinfo " + kVar.aUL());
            try {
                com_tencent_mm_protocal_c_aic = (aic) new aic().az(kVar.field_postBuf);
            } catch (Exception e) {
                v.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + kVar.aUL());
                b(kVar, 2, "mediaPostInfo parser error " + e.getMessage());
                com_tencent_mm_protocal_c_aic = null;
            }
            if (!(com_tencent_mm_protocal_c_aic == null || com_tencent_mm_protocal_c_aic.mIn == null)) {
                Iterator it = com_tencent_mm_protocal_c_aic.mIn.iterator();
                while (it.hasNext()) {
                    ago com_tencent_mm_protocal_c_ago = (ago) it.next();
                    int qe = ad.aSD().qe(com_tencent_mm_protocal_c_ago.mGh);
                    ad.aSD().qd(com_tencent_mm_protocal_c_ago.mGh);
                    v.i("MicroMsg.UploadManager", "cancel upload %d", new Object[]{Integer.valueOf(qe)});
                    if (kVar.field_type != 15 && qe >= 0) {
                        ak.vy().cancel(qe);
                        ad.aSD().qc(com_tencent_mm_protocal_c_ago.mGh);
                    }
                }
            }
            if (ad.aSD().pY(kVar.jBI) && this.jnI != null) {
                v.i("MicroMsg.UploadManager", "cancel post");
                this.jnI.eRm = true;
                ak.vy().c(this.jnI);
                ad.aSD().qa(kVar.jBI);
            }
            k qG = ad.aSE().qG(kVar.jBI);
            if (!(qG == null || qG.field_snsId == 0)) {
                ad.aSD().cP(qG.field_snsId);
                ak.vy().a(new p(qG.field_snsId, 1), 0);
            }
            ad.aSE().qH(kVar.jBI);
            if (kVar.field_type == 21) {
                o.aRh().aRj();
            }
            v.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + kVar.aUL());
            nx nxVar = new nx();
            nxVar.boT.boU = (long) kVar.jBI;
            com.tencent.mm.sdk.c.a.nhr.z(nxVar);
        }
    }

    public final void aTe() {
        ad.aqz().postDelayed(new Runnable(this) {
            final /* synthetic */ at jnK;

            {
                this.jnK = r1;
            }

            public final void run() {
                at.a(this.jnK);
            }
        }, 1000);
    }

    private boolean aTf() {
        l aSE = ad.aSE();
        String str = "select *,rowid from SnsInfo  where " + l.jCd + " order by SnsInfo.rowid" + " asc ";
        Cursor rawQuery = aSE.cie.rawQuery(str, null);
        v.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        k kVar = new k();
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        do {
            kVar.b(rawQuery);
            try {
                aic com_tencent_mm_protocal_c_aic = (aic) new aic().az(kVar.field_postBuf);
                int i = com_tencent_mm_protocal_c_aic.cxZ;
                if (k.db(com_tencent_mm_protocal_c_aic.mIq)) {
                    a(com_tencent_mm_protocal_c_aic);
                    b(kVar, 6, "snsinfo is tle");
                    v.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + kVar.aUL() + " is die ");
                }
            } catch (Exception e) {
                v.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                b(kVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return true;
    }

    private static azr s(k kVar) {
        azr aUp = kVar.aUp();
        agp com_tencent_mm_protocal_c_agp = aUp.mWo;
        String str = aUp.mWn;
        String str2 = aUp.lJi;
        String str3 = aUp.lJj;
        String str4 = aUp.mWq.gkC;
        String str5 = aUp.mWq.aXz;
        String str6 = aUp.mWq.glb;
        cl clVar = aUp.mWp;
        bgx com_tencent_mm_protocal_c_bgx = aUp.mWw;
        int i = aUp.mWq.mol;
        azr JI = d.JI();
        JI.gln = kVar.field_userName;
        JI.mHR = kVar.field_pravited;
        JI.mWn = str;
        JI.lJi = be.ma(str2);
        JI.lJj = be.ma(str3);
        JI.mWs = aUp.mWs;
        JI.mWt = aUp.mWt;
        JI.cog = aUp.cog;
        JI.mWu = aUp.mWu;
        JI.jYp = aUp.jYp;
        JI.mWq.gkC = str4;
        JI.mWq.aXz = str5;
        JI.mWq.mol = i;
        JI.mWq.glb = str6;
        JI.mWo = com_tencent_mm_protocal_c_agp;
        JI.mWv = aUp.mWv;
        JI.jGu = aUp.jGu;
        if (aUp.joj != null) {
            JI.joj = aUp.joj;
        }
        if (clVar != null) {
            JI.mWp = clVar;
        }
        if (com_tencent_mm_protocal_c_bgx != null) {
            JI.mWw = com_tencent_mm_protocal_c_bgx;
        }
        Iterator it = aUp.mWq.mom.iterator();
        while (it.hasNext()) {
            aib com_tencent_mm_protocal_c_aib = (aib) it.next();
            if (com_tencent_mm_protocal_c_aib.mHV == 1) {
                JI.mWq.mom.add(com_tencent_mm_protocal_c_aib);
            }
        }
        return JI;
    }

    private boolean t(k kVar) {
        try {
            aic com_tencent_mm_protocal_c_aic = (aic) new aic().az(kVar.field_postBuf);
            com_tencent_mm_protocal_c_aic.cxZ++;
            kVar.field_postBuf = com_tencent_mm_protocal_c_aic.toByteArray();
            ad.aSE().b(kVar.jBI, kVar);
            int i = com_tencent_mm_protocal_c_aic.cxZ;
            if (k.db(com_tencent_mm_protocal_c_aic.mIq)) {
                b(kVar, 6, "this item isTimeLimit");
                v.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + kVar.aUL() + " is die ");
                return false;
            }
            v.i("MicroMsg.UploadManager", "try start post " + kVar.aUL());
            if (q(kVar)) {
                final List linkedList;
                Iterator it;
                final String a;
                azr aUp = kVar.aUp();
                azr s = s(kVar);
                int i2 = 0;
                while (i2 < com_tencent_mm_protocal_c_aic.mIn.size()) {
                    i = ((ago) com_tencent_mm_protocal_c_aic.mIn.get(i2)).mGh;
                    com.tencent.mm.plugin.sns.storage.o de = ad.aSt().de((long) i);
                    if (de == null) {
                        b(kVar, 3, "can not get the media from db ,localMediaId: " + i);
                        return false;
                    }
                    try {
                        aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
                        if (com_tencent_mm_protocal_c_aie.mIF == null || com_tencent_mm_protocal_c_aie.mIH.size() <= 0) {
                            v.e("MicroMsg.UploadManager", "item with not url" + kVar.field_type);
                            if (kVar.field_type != 3) {
                                b(kVar, 4, "buf url is null");
                                return false;
                            }
                            if (ad.aSD().pZ(kVar.jBI)) {
                                v.d("MicroMsg.UploadManager", "this snsinfo is posting");
                                return false;
                            }
                            linkedList = new LinkedList();
                            it = com_tencent_mm_protocal_c_aic.mIo.iterator();
                            while (it.hasNext()) {
                                linkedList.add(((axj) it.next()).gln);
                            }
                            a = j.a(s);
                            v.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.mWt + " contentDescShowType: " + s.mWs);
                            if (kVar.field_pravited != 1) {
                                v.i("MicroMsg.UploadManager", "content private xml is null ? " + be.kS(a));
                            } else {
                                v.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{a});
                            }
                            if (a != null || a.equals("")) {
                                b(kVar, 5, "content is error");
                                ad.aSD().qa(kVar.jBI);
                                return false;
                            }
                            boolean z;
                            if (com_tencent_mm_protocal_c_aic.mIv == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            final int i3 = kVar.jBI;
                            final LinkedList linkedList2 = com_tencent_mm_protocal_c_aic.mIw;
                            final com.tencent.mm.ba.b bVar = s.mWo.mGm;
                            final String str = s.mWq.aXz;
                            final aic com_tencent_mm_protocal_c_aic2 = com_tencent_mm_protocal_c_aic;
                            final azr com_tencent_mm_protocal_c_azr = aUp;
                            ad.aqz().post(new Runnable(this) {
                                final /* synthetic */ at jnK;

                                public final void run() {
                                    if (ad.aSn()) {
                                        v.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                        return;
                                    }
                                    this.jnK.jnI = new q(a, com_tencent_mm_protocal_c_aic2.mHR, com_tencent_mm_protocal_c_aic2.mIm, linkedList, com_tencent_mm_protocal_c_azr, i3, com_tencent_mm_protocal_c_aic2.mbN, com_tencent_mm_protocal_c_aic2.mIr, com_tencent_mm_protocal_c_aic2.mIs, com_tencent_mm_protocal_c_aic2.jJL, com_tencent_mm_protocal_c_aic2, z, linkedList2, com_tencent_mm_protocal_c_aic2.mIx, bVar, str);
                                    ak.vy().a(this.jnK.jnI, 0);
                                }
                            });
                        } else {
                            aib a2;
                            aib com_tencent_mm_protocal_c_aib;
                            a = com_tencent_mm_protocal_c_aie.mIF.glb;
                            String str2 = ((ahz) com_tencent_mm_protocal_c_aie.mIH.get(0)).glb;
                            int i4 = com_tencent_mm_protocal_c_aie.mIF.efm;
                            int i5 = ((ahz) com_tencent_mm_protocal_c_aie.mIH.get(0)).efm;
                            String str3 = com_tencent_mm_protocal_c_aie.aZy;
                            aid com_tencent_mm_protocal_c_aid = null;
                            if (i2 < aUp.mWq.mom.size()) {
                                com_tencent_mm_protocal_c_aid = ((aib) aUp.mWq.mom.get(i2)).mHS;
                            }
                            if (aUp.mWq.mol != 4 && aUp.mWq.mol != 5) {
                                a2 = d.a(de.jCr, de.type, a, str2, i4, i5, com_tencent_mm_protocal_c_aie.mHR, "", com_tencent_mm_protocal_c_aid);
                            } else if (i2 < aUp.mWq.mom.size()) {
                                com_tencent_mm_protocal_c_aib = (aib) aUp.mWq.mom.get(i2);
                                com_tencent_mm_protocal_c_aib.mHP = str2;
                                com_tencent_mm_protocal_c_aib.mHQ = i5;
                                a2 = com_tencent_mm_protocal_c_aib;
                            } else {
                                a2 = null;
                            }
                            if (a2 != null && s.mWq.mol == 1) {
                                a2.aZy = str3;
                            }
                            if (a2 != null && s.mWq.mol == 15) {
                                a2.aZy = com_tencent_mm_protocal_c_aie.aZy;
                                a2.mIk = com_tencent_mm_protocal_c_aie.mIk;
                            }
                            if (i2 < aUp.mWq.mom.size()) {
                                com_tencent_mm_protocal_c_aib = (aib) aUp.mWq.mom.get(i2);
                                a2.aXz = com_tencent_mm_protocal_c_aib.aXz;
                                a2.gkC = com_tencent_mm_protocal_c_aib.gkC;
                                a2.aYp = com_tencent_mm_protocal_c_aib.aYp;
                                a2.jFe = com_tencent_mm_protocal_c_aib.jFe;
                            }
                            if (a2 == null) {
                                b(kVar, 3, "make media error");
                                return false;
                            }
                            s.mWq.mom.add(a2);
                            i2++;
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        b(kVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        return false;
                    }
                }
                if (ad.aSD().pZ(kVar.jBI)) {
                    linkedList = new LinkedList();
                    it = com_tencent_mm_protocal_c_aic.mIo.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((axj) it.next()).gln);
                    }
                    a = j.a(s);
                    v.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.mWt + " contentDescShowType: " + s.mWs);
                    if (kVar.field_pravited != 1) {
                        v.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{a});
                    } else {
                        v.i("MicroMsg.UploadManager", "content private xml is null ? " + be.kS(a));
                    }
                    if (a != null) {
                    }
                    b(kVar, 5, "content is error");
                    ad.aSD().qa(kVar.jBI);
                    return false;
                }
                v.d("MicroMsg.UploadManager", "this snsinfo is posting");
                return false;
            }
            v.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + kVar.aUL());
            return true;
        } catch (Exception e2) {
            v.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            b(kVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            return false;
        }
    }

    private void I(final int i, final boolean z) {
        ad.aqz().post(new Runnable(this) {
            final /* synthetic */ at jnK;

            public final void run() {
                if (ad.aSn()) {
                    v.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    return;
                }
                for (a aVar : this.jnK.cbh) {
                    if (aVar != null) {
                        aVar.J(i, z);
                    }
                }
            }
        });
    }

    private int a(int i, boolean z, aic com_tencent_mm_protocal_c_aic, int i2) {
        if (i == -1) {
            v.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            return b.jnW;
        }
        com.tencent.mm.plugin.sns.storage.o de = ad.aSt().de((long) i);
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            v.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_aie.mII + " pic isMuti: " + z);
            if (com_tencent_mm_protocal_c_aie.mII == 1) {
                return b.jnW;
            }
            String str = al.cA(ad.xh(), de.jCo) + i.zN(de.jCo);
            if (FileOp.jP(str) == 0) {
                v.i("MicroMsg.UploadManager", "path not exist  " + str);
                return b.jnW;
            } else if (com_tencent_mm_protocal_c_aie.mII == 0) {
                return b.jnX;
            } else {
                if (ad.aSD().qb(i)) {
                    ad.aSt().a(i, de);
                    final String m = com.tencent.mm.a.g.m((be.Nj() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final aic com_tencent_mm_protocal_c_aic2 = com_tencent_mm_protocal_c_aic;
                    final int i4 = i2;
                    ad.aqz().post(new Runnable(this) {
                        final /* synthetic */ at jnK;

                        public final void run() {
                            if (ad.aSn()) {
                                v.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                return;
                            }
                            w wVar = new w(i3, m, z2, i4);
                            ad.aSD().cr(i3, wVar.hashCode());
                            ak.vy().a(wVar, 0);
                        }
                    });
                }
                return b.jnY;
            }
        } catch (Exception e) {
            v.e("MicroMsg.UploadManager", "parse uploadInfo error");
            return b.jnW;
        }
    }

    private static void a(aic com_tencent_mm_protocal_c_aic) {
        if (com_tencent_mm_protocal_c_aic != null) {
            Iterator it = com_tencent_mm_protocal_c_aic.mIn.iterator();
            while (it.hasNext()) {
                ad.aSD().qc(((ago) it.next()).mGh);
            }
        }
    }

    private int qj(int i) {
        if (i == -1) {
            v.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            return b.jnW;
        }
        com.tencent.mm.plugin.sns.storage.o de = ad.aSt().de((long) i);
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            v.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_aie.mII + " doUploadSight, serverErr:" + com_tencent_mm_protocal_c_aie.mIt);
            if (com_tencent_mm_protocal_c_aie.mII == 1) {
                return b.jnW;
            }
            if (FileOp.jP(com_tencent_mm_protocal_c_aie.bou) == 0) {
                v.i("MicroMsg.UploadManager", "path not fileexist  " + com_tencent_mm_protocal_c_aie.bou);
                return b.jnW;
            } else if (FileOp.jP(com_tencent_mm_protocal_c_aie.mIK) == 0) {
                v.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + com_tencent_mm_protocal_c_aie.mIK);
                return b.jnW;
            } else if (com_tencent_mm_protocal_c_aie.mII == 0) {
                return b.jnX;
            } else {
                if (ad.aSD().qb(i)) {
                    ad.aSt().a(i, de);
                    new z(i, de, com_tencent_mm_protocal_c_aie.bou, com_tencent_mm_protocal_c_aie.mIK, this.jnJ).aSe();
                }
                return b.jnY;
            }
        } catch (Exception e) {
            v.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            return b.jnW;
        }
    }

    public final void aTg() {
        for (a aVar : this.cbh) {
            if (aVar != null) {
                aVar.aTh();
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        switch (kVar.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    aTe();
                    break;
                }
            case 209:
                q qVar = (q) kVar;
                int i3 = qVar.jdV;
                if (qVar.eRm) {
                    long j = qVar.jkk;
                    v.i("MicroMsg.UploadManager", "get the del post come back %d " + j, new Object[]{Integer.valueOf(i3)});
                    if (j != 0) {
                        ad.aSD().cP(j);
                        ak.vy().a(new p(j, 1), 0);
                    }
                    ad.aSE().qH(i3);
                    if (j != 0) {
                        ad.aSH().cX(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    I(qVar.jdV, true);
                    ai.cT(qVar.jkk);
                } else {
                    I(qVar.jdV, false);
                }
                this.jnI = null;
                break;
        }
        if (i != 0 || i2 != 0) {
        }
    }
}
