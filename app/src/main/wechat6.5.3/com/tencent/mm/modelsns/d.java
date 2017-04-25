package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class d {
    private static float km(String str) {
        if (str == null) {
            return 0.0f;
        }
        return be.getFloat(str, 0.0f);
    }

    private static String kn(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static azr JI() {
        azr com_tencent_mm_protocal_c_azr = new azr();
        lo loVar = new lo();
        com_tencent_mm_protocal_c_azr.mWp = new cl();
        com_tencent_mm_protocal_c_azr.mWq = loVar;
        com_tencent_mm_protocal_c_azr.mHR = 0;
        com_tencent_mm_protocal_c_azr.hNS = 0;
        com_tencent_mm_protocal_c_azr.gID = "";
        agp com_tencent_mm_protocal_c_agp = new agp();
        com_tencent_mm_protocal_c_agp.mjN = 0.0f;
        com_tencent_mm_protocal_c_agp.mjM = 0.0f;
        com_tencent_mm_protocal_c_azr.mWo = com_tencent_mm_protocal_c_agp;
        com_tencent_mm_protocal_c_azr.jYp = "";
        com_tencent_mm_protocal_c_azr.mWw = new bgx();
        return com_tencent_mm_protocal_c_azr;
    }

    public static aib JJ() {
        aib com_tencent_mm_protocal_c_aib = new aib();
        com_tencent_mm_protocal_c_aib.gkC = "";
        com_tencent_mm_protocal_c_aib.mHR = 0;
        return com_tencent_mm_protocal_c_aib;
    }

    public static aib a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        aib com_tencent_mm_protocal_c_aib = new aib();
        com_tencent_mm_protocal_c_aib.gID = str;
        com_tencent_mm_protocal_c_aib.efm = i;
        com_tencent_mm_protocal_c_aib.glb = str2;
        com_tencent_mm_protocal_c_aib.mHP = str3;
        com_tencent_mm_protocal_c_aib.mHO = i2;
        com_tencent_mm_protocal_c_aib.mHQ = i3;
        com_tencent_mm_protocal_c_aib.gkC = str4;
        aid com_tencent_mm_protocal_c_aid = new aid();
        com_tencent_mm_protocal_c_aid.lHK = 0.0f;
        com_tencent_mm_protocal_c_aid.mID = 0.0f;
        com_tencent_mm_protocal_c_aid.mIE = 0.0f;
        com_tencent_mm_protocal_c_aib.mHS = com_tencent_mm_protocal_c_aid;
        com_tencent_mm_protocal_c_aib.mId = g.m(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_aib;
    }

    public static aib a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, aid com_tencent_mm_protocal_c_aid) {
        aib com_tencent_mm_protocal_c_aib = new aib();
        com_tencent_mm_protocal_c_aib.gID = kn(str);
        com_tencent_mm_protocal_c_aib.efm = i;
        com_tencent_mm_protocal_c_aib.gkC = kn(str4);
        com_tencent_mm_protocal_c_aib.glb = kn(str2);
        com_tencent_mm_protocal_c_aib.mHO = i2;
        com_tencent_mm_protocal_c_aib.mHP = kn(str3);
        com_tencent_mm_protocal_c_aib.mHQ = i3;
        com_tencent_mm_protocal_c_aib.mHR = i4;
        com_tencent_mm_protocal_c_aib.mHS = com_tencent_mm_protocal_c_aid;
        com_tencent_mm_protocal_c_aib.mId = g.m(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_aib;
    }

    public static azr ko(String str) {
        Map q = bf.q(str, "TimelineObject");
        azr JI = JI();
        if (q != null) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            cl clVar;
            bgx com_tencent_mm_protocal_c_bgx;
            ayj com_tencent_mm_protocal_c_ayj;
            avy com_tencent_mm_protocal_c_avy;
            al alVar;
            int i;
            int i2;
            aj ajVar;
            int i3;
            ce ceVar;
            cn cnVar;
            JI.gID = kn((String) q.get(".TimelineObject.id"));
            JI.gln = kn((String) q.get(".TimelineObject.username"));
            JI.mHR = be.getInt((String) q.get(".TimelineObject.private"), 0);
            JI.hNS = be.getInt((String) q.get(".TimelineObject.createTime"), 0);
            JI.mWn = kn((String) q.get(".TimelineObject.contentDesc"));
            JI.mWs = be.getInt((String) q.get(".TimelineObject.contentDescShowType"), 0);
            JI.mWt = be.getInt((String) q.get(".TimelineObject.contentDescScene"), 0);
            JI.jGu = kn((String) q.get(".TimelineObject.statExtStr"));
            JI.mWx = be.getInt((String) q.get(".TimelineObject.sightFolded"), 0);
            agp com_tencent_mm_protocal_c_agp = new agp();
            com_tencent_mm_protocal_c_agp.mjM = km((String) q.get(".TimelineObject.location.$longitude"));
            com_tencent_mm_protocal_c_agp.mjN = km((String) q.get(".TimelineObject.location.$latitude"));
            com_tencent_mm_protocal_c_agp.cHe = kn((String) q.get(".TimelineObject.location.$city"));
            com_tencent_mm_protocal_c_agp.mGk = be.getInt((String) q.get(".TimelineObject.location.$poiScale"), 0);
            com_tencent_mm_protocal_c_agp.mGi = kn((String) q.get(".TimelineObject.location.$poiClassifyId"));
            com_tencent_mm_protocal_c_agp.jGT = be.getInt((String) q.get(".TimelineObject.location.$poiClassifyType"), 0);
            com_tencent_mm_protocal_c_agp.jGR = kn((String) q.get(".TimelineObject.location.$poiAddress"));
            com_tencent_mm_protocal_c_agp.gUr = kn((String) q.get(".TimelineObject.location.$poiName"));
            com_tencent_mm_protocal_c_agp.mGl = be.getInt((String) q.get(".TimelineObject.location.$poiClickableStatus"), 0);
            JI.mWo = com_tencent_mm_protocal_c_agp;
            String str7 = ".TimelineObject.ContentObject.description";
            String str8 = ".TimelineObject.ContentObject.contentStyle";
            String str9 = ".TimelineObject.ContentObject.title";
            String str10 = ".TimelineObject.ContentObject.contentUrl";
            if (JI.mWq == null) {
                JI.mWq = new lo();
            }
            JI.mWq.gkC = kn((String) q.get(str7));
            JI.mWq.mol = be.getInt((String) q.get(str8), 0);
            JI.mWq.aXz = kn((String) q.get(str9));
            JI.mWq.glb = kn((String) q.get(str10));
            int i4 = 0;
            while (true) {
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                String str16;
                String str17;
                String str18;
                String str19;
                String str20;
                String str21;
                String str22;
                String str23;
                String str24;
                Object obj;
                String str25;
                String str26;
                String str27;
                String str28;
                String str29;
                String str30;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                Object obj6;
                Object obj7;
                Object obj8;
                Object obj9;
                Object obj10;
                Object obj11;
                if (i4 != 0) {
                    str11 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".id";
                    str12 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".type";
                    str13 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".title";
                    str14 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".description";
                    str15 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url";
                    str16 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb";
                    str17 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$type";
                    str18 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$type";
                    str19 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".private";
                    str20 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".subType";
                    str21 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".userData";
                    str22 = ".TimelineObject.ContentObject.mediaList.media" + i4;
                    str23 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".lowBandUrl";
                    str24 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".lowBandUrl.$type";
                    obj = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachUrl";
                    str25 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachUrl.$md5";
                    str26 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$md5";
                    str27 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".videosize.$attachTotalTime";
                    str28 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachThumbUrl";
                    str2 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".attachShareTitle";
                    str3 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".enc";
                    str4 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".enc.$key";
                    str5 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$token";
                    str6 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$enc_idx";
                    str10 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".url.$key";
                    str9 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$token";
                    str8 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$enc_idx";
                    str29 = str14;
                    str30 = str21;
                    str21 = str15;
                    str14 = ".TimelineObject.ContentObject.mediaList.media" + i4 + ".thumb.$key";
                    str7 = str22;
                    str15 = str8;
                    str22 = str28;
                    obj2 = str23;
                    str23 = str27;
                    obj3 = str24;
                    str24 = str26;
                    obj4 = str20;
                    str20 = str25;
                    obj5 = str16;
                    str16 = str9;
                    String str31 = str3;
                    obj6 = str17;
                    str17 = str10;
                    obj7 = str13;
                    str13 = str4;
                    obj8 = str11;
                    str11 = str6;
                    obj9 = str12;
                    str12 = str5;
                    obj10 = str19;
                    str19 = str2;
                    obj11 = str18;
                    str18 = str31;
                } else {
                    obj = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                    str29 = ".TimelineObject.ContentObject.mediaList.media.description";
                    str30 = ".TimelineObject.ContentObject.mediaList.media.userData";
                    str21 = ".TimelineObject.ContentObject.mediaList.media.url";
                    str14 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                    str7 = ".TimelineObject.ContentObject.mediaList.media";
                    str15 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                    str22 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                    str28 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                    str23 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                    str27 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                    str24 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                    str26 = ".TimelineObject.ContentObject.mediaList.media.subType";
                    str20 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                    str25 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                    str16 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                    str3 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                    str17 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                    str10 = ".TimelineObject.ContentObject.mediaList.media.title";
                    str13 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                    str4 = ".TimelineObject.ContentObject.mediaList.media.id";
                    str11 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                    str6 = ".TimelineObject.ContentObject.mediaList.media.type";
                    str12 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                    str5 = ".TimelineObject.ContentObject.mediaList.media.private";
                    str19 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                    str2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                    str18 = ".TimelineObject.ContentObject.mediaList.media.enc";
                }
                str8 = str7 + ".size.$width";
                str9 = str7 + ".size.$height";
                String str32 = str7 + ".size.$totalSize";
                str7 = (String) q.get(str8);
                str8 = (String) q.get(str9);
                str9 = (String) q.get(str32);
                aid com_tencent_mm_protocal_c_aid = new aid();
                com_tencent_mm_protocal_c_aid.lHK = 0.0f;
                com_tencent_mm_protocal_c_aid.mID = 0.0f;
                com_tencent_mm_protocal_c_aid.mIE = 0.0f;
                if (str7 != null) {
                    com_tencent_mm_protocal_c_aid.mID = km(str7);
                }
                if (str8 != null) {
                    com_tencent_mm_protocal_c_aid.lHK = km(str8);
                }
                if (str9 != null) {
                    com_tencent_mm_protocal_c_aid.mIE = km(str9);
                }
                str7 = (String) q.get(obj8);
                str8 = (String) q.get(obj9);
                str9 = (String) q.get(obj7);
                str10 = (String) q.get(str29);
                str6 = (String) q.get(str21);
                str5 = (String) q.get(obj10);
                str4 = (String) q.get(obj5);
                str3 = (String) q.get(obj6);
                str2 = (String) q.get(obj11);
                str28 = (String) q.get(obj2);
                str27 = (String) q.get(obj3);
                str26 = (String) q.get(obj4);
                str25 = (String) q.get(str30);
                String str33 = (String) q.get(obj);
                str20 = (String) q.get(str20);
                str24 = (String) q.get(str24);
                str23 = (String) q.get(str23);
                str22 = (String) q.get(str22);
                str19 = (String) q.get(str19);
                str18 = (String) q.get(str18);
                str13 = (String) q.get(str13);
                str12 = (String) q.get(str12);
                str11 = (String) q.get(str11);
                str17 = (String) q.get(str17);
                str16 = (String) q.get(str16);
                str15 = (String) q.get(str15);
                str14 = (String) q.get(str14);
                if (str8 == null || str7 == null) {
                    clVar = new cl();
                    str9 = kn((String) q.get(".TimelineObject.appInfo.id"));
                    str10 = kn((String) q.get(".TimelineObject.appInfo.version"));
                    str6 = kn((String) q.get(".TimelineObject.appInfo.appName"));
                    str5 = kn((String) q.get(".TimelineObject.appInfo.installUrl "));
                    str7 = kn((String) q.get(".TimelineObject.appInfo.fromUrl "));
                    clVar.gID = str9;
                    clVar.hNZ = str6;
                    clVar.mcF = str5;
                    clVar.mcG = str7;
                    clVar.efc = str10;
                    JI.mWp = clVar;
                    com_tencent_mm_protocal_c_bgx = new bgx();
                    str9 = kn((String) q.get(".TimelineObject.weappInfo.appUserName"));
                    str7 = kn((String) q.get(".TimelineObject.weappInfo.pagePath"));
                    com_tencent_mm_protocal_c_bgx.username = str9;
                    com_tencent_mm_protocal_c_bgx.path = str7;
                    JI.mWw = com_tencent_mm_protocal_c_bgx;
                    com_tencent_mm_protocal_c_ayj = new ayj();
                    str9 = kn((String) q.get(".TimelineObject.streamvideo.streamvideotitle"));
                    str10 = kn((String) q.get(".TimelineObject.streamvideo.streamvideototaltime"));
                    str6 = kn((String) q.get(".TimelineObject.streamvideo.streamvideourl"));
                    str5 = kn((String) q.get(".TimelineObject.streamvideo.streamvideoweburl"));
                    str4 = kn((String) q.get(".TimelineObject.streamvideo.streamvideowording"));
                    str3 = kn((String) q.get(".TimelineObject.streamvideo.streamvideothumburl"));
                    str2 = kn((String) q.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
                    str7 = kn((String) q.get(".TimelineObject.streamvideo.streamvideopublishid"));
                    com_tencent_mm_protocal_c_ayj.cqi = str9;
                    com_tencent_mm_protocal_c_ayj.cqh = be.KL(str10);
                    com_tencent_mm_protocal_c_ayj.cqg = str6;
                    com_tencent_mm_protocal_c_ayj.cqk = str5;
                    com_tencent_mm_protocal_c_ayj.cqj = str4;
                    com_tencent_mm_protocal_c_ayj.cql = str3;
                    com_tencent_mm_protocal_c_ayj.cqm = str2;
                    com_tencent_mm_protocal_c_ayj.cqn = str7;
                    JI.mWv = com_tencent_mm_protocal_c_ayj;
                    com_tencent_mm_protocal_c_avy = new avy();
                    str9 = kn((String) q.get(".TimelineObject.redEnvelopesInfo.sendId"));
                    str7 = kn((String) q.get(".TimelineObject.redEnvelopesInfo.ticket"));
                    com_tencent_mm_protocal_c_avy.haB = str9;
                    com_tencent_mm_protocal_c_avy.bax = str7;
                    alVar = new al();
                    i = be.getInt((String) q.get(".TimelineObject.actionInfo.scene"), 0);
                    str10 = kn((String) q.get(".TimelineObject.actionInfo.appid"));
                    i2 = be.getInt((String) q.get(".TimelineObject.actionInfo.type"), 0);
                    str5 = kn((String) q.get(".TimelineObject.actionInfo.url"));
                    str4 = kn((String) q.get(".TimelineObject.actionInfo.mediaTagName"));
                    str7 = kn((String) q.get(".TimelineObject.actionInfo.wordingKey"));
                    alVar.maH = str10;
                    alVar.maG = i;
                    alVar.efm = i2;
                    alVar.glb = str5;
                    alVar.maI = str4;
                    alVar.maJ = str7;
                    ajVar = new aj();
                    str10 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.appid"));
                    str6 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
                    str5 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.messageExt"));
                    str7 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.messageAction"));
                    ajVar.glj = str10;
                    ajVar.maD = str6;
                    ajVar.maE = str5;
                    ajVar.maF = str7;
                    alVar.maK = ajVar;
                    i = be.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
                    i3 = be.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
                    str6 = kn((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
                    str5 = kn((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
                    alVar.maL = kn((String) q.get(".TimelineObject.actionInfo.newWordingKey"));
                    ceVar = new ce();
                    ceVar.mcx = i;
                    ceVar.mcy = i3;
                    cnVar = new cn();
                    cnVar.mcK = str6;
                    cnVar.mcL = str5;
                    alVar.maM = ceVar;
                    alVar.maN = cnVar;
                    alVar.maO = kp((String) q.get(".TimelineObject.actionInfo.installedWording"));
                    alVar.maP = kp((String) q.get(".TimelineObject.actionInfo.uninstalledWording"));
                    JI.joj = alVar;
                    JI.lJi = kn((String) q.get(".TimelineObject.sourceUserName"));
                    JI.lJj = kn((String) q.get(".TimelineObject.sourceNickName"));
                    JI.mWr = kn((String) q.get(".TimelineObject.publicUserName"));
                    JI.mWu = kn((String) q.get(".TimelineObject.statisticsData"));
                    JI.jYp = kn((String) q.get(".TimelineObject.canvasInfoXml"));
                    JI.cog = be.getInt((String) q.get(".TimelineObject.contentattr"), 0);
                } else {
                    aib com_tencent_mm_protocal_c_aib = new aib();
                    com_tencent_mm_protocal_c_aib.gID = kn(str7);
                    com_tencent_mm_protocal_c_aib.efm = be.getInt(str8, 0);
                    com_tencent_mm_protocal_c_aib.aXz = kn(str9);
                    com_tencent_mm_protocal_c_aib.gkC = kn(str10);
                    com_tencent_mm_protocal_c_aib.glb = kn(str6);
                    com_tencent_mm_protocal_c_aib.mHO = be.getInt(str3, 0);
                    com_tencent_mm_protocal_c_aib.mHP = kn(str4);
                    com_tencent_mm_protocal_c_aib.mHQ = be.getInt(str2, 0);
                    com_tencent_mm_protocal_c_aib.mHR = be.getInt(str5, 0);
                    com_tencent_mm_protocal_c_aib.mHS = com_tencent_mm_protocal_c_aid;
                    com_tencent_mm_protocal_c_aib.mHT = kn(str28);
                    com_tencent_mm_protocal_c_aib.mHU = be.getInt(str27, 0);
                    com_tencent_mm_protocal_c_aib.jFe = kn(str25);
                    com_tencent_mm_protocal_c_aib.aYp = be.getInt(str26, 0);
                    com_tencent_mm_protocal_c_aib.mHW = kn(str33);
                    com_tencent_mm_protocal_c_aib.mHY = kn(str20);
                    com_tencent_mm_protocal_c_aib.mHX = kn(str24);
                    com_tencent_mm_protocal_c_aib.jZD = be.getInt(str23, 0);
                    com_tencent_mm_protocal_c_aib.mHZ = kn(str22);
                    com_tencent_mm_protocal_c_aib.mIa = kn(str19);
                    com_tencent_mm_protocal_c_aib.mIb = be.getInt(str18, 0);
                    com_tencent_mm_protocal_c_aib.mIc = be.getLong(str13, 0);
                    com_tencent_mm_protocal_c_aib.mId = g.m(com_tencent_mm_protocal_c_aib.glb == null ? "".getBytes() : com_tencent_mm_protocal_c_aib.glb.getBytes());
                    com_tencent_mm_protocal_c_aib.mIe = str12;
                    com_tencent_mm_protocal_c_aib.mIf = be.getInt(str11, 0);
                    com_tencent_mm_protocal_c_aib.mIg = str17;
                    com_tencent_mm_protocal_c_aib.mIh = str16;
                    com_tencent_mm_protocal_c_aib.mIi = be.getInt(str15, 0);
                    com_tencent_mm_protocal_c_aib.mIj = str14;
                    JI.mWq.mom.add(com_tencent_mm_protocal_c_aib);
                    i4++;
                }
            }
            clVar = new cl();
            str9 = kn((String) q.get(".TimelineObject.appInfo.id"));
            str10 = kn((String) q.get(".TimelineObject.appInfo.version"));
            str6 = kn((String) q.get(".TimelineObject.appInfo.appName"));
            str5 = kn((String) q.get(".TimelineObject.appInfo.installUrl "));
            str7 = kn((String) q.get(".TimelineObject.appInfo.fromUrl "));
            clVar.gID = str9;
            clVar.hNZ = str6;
            clVar.mcF = str5;
            clVar.mcG = str7;
            clVar.efc = str10;
            JI.mWp = clVar;
            com_tencent_mm_protocal_c_bgx = new bgx();
            str9 = kn((String) q.get(".TimelineObject.weappInfo.appUserName"));
            str7 = kn((String) q.get(".TimelineObject.weappInfo.pagePath"));
            com_tencent_mm_protocal_c_bgx.username = str9;
            com_tencent_mm_protocal_c_bgx.path = str7;
            JI.mWw = com_tencent_mm_protocal_c_bgx;
            com_tencent_mm_protocal_c_ayj = new ayj();
            str9 = kn((String) q.get(".TimelineObject.streamvideo.streamvideotitle"));
            str10 = kn((String) q.get(".TimelineObject.streamvideo.streamvideototaltime"));
            str6 = kn((String) q.get(".TimelineObject.streamvideo.streamvideourl"));
            str5 = kn((String) q.get(".TimelineObject.streamvideo.streamvideoweburl"));
            str4 = kn((String) q.get(".TimelineObject.streamvideo.streamvideowording"));
            str3 = kn((String) q.get(".TimelineObject.streamvideo.streamvideothumburl"));
            str2 = kn((String) q.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
            str7 = kn((String) q.get(".TimelineObject.streamvideo.streamvideopublishid"));
            com_tencent_mm_protocal_c_ayj.cqi = str9;
            com_tencent_mm_protocal_c_ayj.cqh = be.KL(str10);
            com_tencent_mm_protocal_c_ayj.cqg = str6;
            com_tencent_mm_protocal_c_ayj.cqk = str5;
            com_tencent_mm_protocal_c_ayj.cqj = str4;
            com_tencent_mm_protocal_c_ayj.cql = str3;
            com_tencent_mm_protocal_c_ayj.cqm = str2;
            com_tencent_mm_protocal_c_ayj.cqn = str7;
            JI.mWv = com_tencent_mm_protocal_c_ayj;
            com_tencent_mm_protocal_c_avy = new avy();
            str9 = kn((String) q.get(".TimelineObject.redEnvelopesInfo.sendId"));
            str7 = kn((String) q.get(".TimelineObject.redEnvelopesInfo.ticket"));
            com_tencent_mm_protocal_c_avy.haB = str9;
            com_tencent_mm_protocal_c_avy.bax = str7;
            alVar = new al();
            i = be.getInt((String) q.get(".TimelineObject.actionInfo.scene"), 0);
            str10 = kn((String) q.get(".TimelineObject.actionInfo.appid"));
            i2 = be.getInt((String) q.get(".TimelineObject.actionInfo.type"), 0);
            str5 = kn((String) q.get(".TimelineObject.actionInfo.url"));
            str4 = kn((String) q.get(".TimelineObject.actionInfo.mediaTagName"));
            str7 = kn((String) q.get(".TimelineObject.actionInfo.wordingKey"));
            alVar.maH = str10;
            alVar.maG = i;
            alVar.efm = i2;
            alVar.glb = str5;
            alVar.maI = str4;
            alVar.maJ = str7;
            ajVar = new aj();
            str10 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.appid"));
            str6 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
            str5 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.messageExt"));
            str7 = kn((String) q.get(".TimelineObject.actionInfo.appMsg.messageAction"));
            ajVar.glj = str10;
            ajVar.maD = str6;
            ajVar.maE = str5;
            ajVar.maF = str7;
            alVar.maK = ajVar;
            i = be.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
            i3 = be.getInt((String) q.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
            str6 = kn((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
            str5 = kn((String) q.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
            alVar.maL = kn((String) q.get(".TimelineObject.actionInfo.newWordingKey"));
            ceVar = new ce();
            ceVar.mcx = i;
            ceVar.mcy = i3;
            cnVar = new cn();
            cnVar.mcK = str6;
            cnVar.mcL = str5;
            alVar.maM = ceVar;
            alVar.maN = cnVar;
            alVar.maO = kp((String) q.get(".TimelineObject.actionInfo.installedWording"));
            alVar.maP = kp((String) q.get(".TimelineObject.actionInfo.uninstalledWording"));
            JI.joj = alVar;
            JI.lJi = kn((String) q.get(".TimelineObject.sourceUserName"));
            JI.lJj = kn((String) q.get(".TimelineObject.sourceNickName"));
            JI.mWr = kn((String) q.get(".TimelineObject.publicUserName"));
            JI.mWu = kn((String) q.get(".TimelineObject.statisticsData"));
            JI.jYp = kn((String) q.get(".TimelineObject.canvasInfoXml"));
            JI.cog = be.getInt((String) q.get(".TimelineObject.contentattr"), 0);
        }
        return JI;
    }

    private static cm kp(String str) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        Map q = bf.q("<root>" + stringBuilder.toString() + "</root>", "root");
        cm cmVar = new cm();
        cmVar.mcH = kn((String) q.get(".root.en"));
        cmVar.mcI = kn((String) q.get(".root.zh-CN"));
        cmVar.mcJ = kn((String) q.get(".root.zh-TW"));
        return cmVar;
    }

    public static Pair<Integer, Integer> a(azr com_tencent_mm_protocal_c_azr, Context context, boolean z) {
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        int i4;
        int fromDPToPix;
        int fromDPToPix2;
        if (!(com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.mWq == null || com_tencent_mm_protocal_c_azr.mWq.mom == null || com_tencent_mm_protocal_c_azr.mWq.mom.size() <= 0)) {
            aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
            if (com_tencent_mm_protocal_c_aib != null && com_tencent_mm_protocal_c_aib.mHS != null && com_tencent_mm_protocal_c_aib.mHS.mID > 0.0f && com_tencent_mm_protocal_c_aib.mHS.lHK > 0.0f) {
                i = (int) com_tencent_mm_protocal_c_aib.mHS.mID;
                i2 = (int) com_tencent_mm_protocal_c_aib.mHS.lHK;
                if (i <= 0) {
                    i = 320;
                }
                if (i2 > 0) {
                    i3 = 240;
                } else {
                    i3 = i2;
                }
                if (context != null) {
                    v.e("MicroMsg.TimeLineHelper", "the context is null");
                    return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
                }
                displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics == null) {
                    i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
                } else {
                    i2 = i;
                }
                i4 = (i2 >> 5) << 5;
                if (i < i3 && context != null) {
                    i4 = Math.min(b.a(context, 160.0f), i4);
                }
                i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
                if (!z) {
                    fromDPToPix = a.fromDPToPix(context, 200);
                    fromDPToPix2 = a.fromDPToPix(context, 44);
                    if (i2 < i4) {
                        if (i2 > fromDPToPix) {
                            i2 = fromDPToPix;
                        }
                        i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                        if (i4 < fromDPToPix2) {
                            i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                            v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                        }
                    }
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i5 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i5;
                        v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                fromDPToPix2 = i4;
                v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
            }
        }
        i2 = 0;
        i = 0;
        if (i <= 0) {
            i = 320;
        }
        if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = 240;
        }
        if (context != null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                i2 = i;
            } else {
                i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
            }
            i4 = (i2 >> 5) << 5;
            i4 = Math.min(b.a(context, 160.0f), i4);
            i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
            if (z) {
                fromDPToPix = a.fromDPToPix(context, 200);
                fromDPToPix2 = a.fromDPToPix(context, 44);
                if (i2 < i4) {
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i52 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i52;
                        v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                if (i2 > fromDPToPix) {
                    i2 = fromDPToPix;
                }
                i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                if (i4 < fromDPToPix2) {
                    i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                    v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                    return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                }
            }
            fromDPToPix2 = i4;
            v.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
        }
        v.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
    }
}
