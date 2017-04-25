package com.tencent.mm.q;

import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.f;
import com.tencent.mm.e.b.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a extends o {
    public static com.tencent.mm.sdk.h.c.a chq;

    public static class a {
        private static final f<Integer, a> cqx = new f(100);
        public String aXa;
        public int aXx;
        public String appId;
        public String appName;
        public String bNm;
        public String bXP;
        public String bgD;
        public String bhM;
        public String bnR;
        public String bnS;
        public String bnU;
        public String bnV;
        public String bnW;
        public String bnX;
        public String bnY;
        public int bpy;
        public String canvasPageXml = SQLiteDatabase.KeyEmpty;
        public a cnY;
        public Map<String, String> cnZ;
        public int coA;
        public String coB;
        public String coC;
        public int coD;
        public String coE;
        public String coF;
        public int coG;
        public String coH;
        public String coI;
        public String coJ;
        public String coK;
        public String coL;
        public String coM;
        public String coN;
        public String coO;
        public String coP;
        public String coQ;
        public String coR;
        public String coS;
        public String coT;
        public String coU;
        public String coV;
        public int coW;
        public int coX;
        public int coY;
        public String coZ;
        public String coa;
        public int cob;
        public String coc;
        public String cod;
        public int coe;
        public int cof;
        public int cog;
        public String coh;
        public String coi;
        public String coj;
        public int cok;
        public int col;
        public int com;
        public int con;
        public String content;
        public int coo;
        public String cop;
        public String coq;
        public int cor;
        public String cos;
        public String cot;
        public LinkedList<com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a> cou = null;
        public int cov;
        public int cow;
        public int cox;
        public String coy;
        public String coz;
        public String cpA;
        public String cpB;
        public String cpC;
        public String cpD;
        public String cpE;
        public String cpF;
        public String cpG;
        public String cpH;
        public String cpI;
        public String cpJ;
        public String cpK;
        public int cpL;
        public String cpM;
        public String cpN;
        public String cpO;
        public int cpP;
        public boolean cpQ = false;
        public int cpR = 0;
        public String cpS;
        public int cpT;
        public String cpU;
        public String cpV;
        public String cpW;
        public List<String> cpX;
        public String cpY;
        public List<String> cpZ;
        public String cpa;
        public String cpb;
        public String cpc;
        public int cpd;
        public int cpe;
        public String cpf;
        public String cpg;
        public String cph;
        public int cpi;
        public int cpj;
        public int cpk;
        public String cpl;
        public String cpm;
        public String cpn;
        public int cpo;
        public int cpp;
        public int cpq;
        public String cpr;
        public String cps;
        public String cpt;
        public String cpu;
        public String cpv;
        public String cpw;
        public String cpx;
        public int cpy;
        public String cpz;
        public String cqa;
        public int cqb;
        public String cqc;
        public int cqd;
        public String cqe;
        public String cqf;
        public String cqg;
        public int cqh = 0;
        public String cqi = SQLiteDatabase.KeyEmpty;
        public String cqj = SQLiteDatabase.KeyEmpty;
        public String cqk = SQLiteDatabase.KeyEmpty;
        public String cql = SQLiteDatabase.KeyEmpty;
        public String cqm = SQLiteDatabase.KeyEmpty;
        public String cqn = SQLiteDatabase.KeyEmpty;
        public String cqo;
        public String cqp;
        public String cqq;
        public int cqr;
        public String cqs;
        public int cqt;
        public int cqu;
        public String cqv;
        public String cqw = null;
        public String desc;
        public String description;
        public String designerName;
        public String designerRediretctUrl;
        public String extInfo;
        public String filemd5;
        public int hsN;
        public String iconUrl;
        public String mediaTagName;
        public String messageAction;
        public String messageExt;
        public int pageType;
        public int sdkVer;
        public String secondUrl;
        public String thumburl;
        public int tid;
        public String title;
        public int type;
        public String url;
        public String username;

        public static class a {
            public String bNx;
            public int cqA;
            public int cqB;
            public int cqC = 0;
            public int cqD = 0;
            public int cqy;
            public int cqz;
            public String desc;
            public String title;
        }

        public static final a dV(String str) {
            return B(str, null);
        }

        public static final a B(String str, String str2) {
            if (be.kS(str)) {
                return null;
            }
            String substring;
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                substring = str.substring(indexOf);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            a aVar = (a) cqx.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map q;
            long currentTimeMillis = System.currentTimeMillis();
            Map map = null;
            if (!be.kS(str2)) {
                map = au.Ks(str2);
            }
            if (map == null) {
                q = bf.q(substring, "msg");
            } else {
                q = map;
            }
            if (q == null) {
                v.e("MicroMsg.AppMessage", "parse msg failed");
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                a aVar2 = new a();
                aVar2.cnZ = q;
                aVar2.appId = (String) q.get(".msg.appmsg.$appid");
                aVar2.sdkVer = be.getInt((String) q.get(".msg.appmsg.$sdkver"), 0);
                aVar2.title = be.Kt((String) q.get(".msg.appmsg.title"));
                aVar2.description = (String) q.get(".msg.appmsg.des");
                aVar2.username = (String) q.get(".msg.appmsg.username");
                aVar2.bXP = (String) q.get(".msg.appmsg.action");
                aVar2.type = be.getInt((String) q.get(".msg.appmsg.type"), 0);
                aVar2.content = (String) q.get(".msg.appmsg.content");
                aVar2.url = (String) q.get(".msg.appmsg.url");
                aVar2.coa = (String) q.get(".msg.appmsg.lowurl");
                aVar2.cos = (String) q.get(".msg.appmsg.dataurl");
                aVar2.cot = (String) q.get(".msg.appmsg.lowdataurl");
                aVar2.cob = be.getInt((String) q.get(".msg.appmsg.appattach.totallen"), 0);
                aVar2.aXa = (String) q.get(".msg.appmsg.appattach.attachid");
                aVar2.coc = be.Kt((String) q.get(".msg.appmsg.appattach.fileext"));
                aVar2.cod = (String) q.get(".msg.appmsg.appattach.emoticonmd5");
                aVar2.extInfo = (String) q.get(".msg.appmsg.extinfo");
                aVar2.coe = be.getInt((String) q.get(".msg.appmsg.androidsource"), 0);
                aVar2.bnR = (String) q.get(".msg.appmsg.sourceusername");
                aVar2.bnS = (String) q.get(".msg.appmsg.sourcedisplayname");
                aVar2.bNm = (String) q.get(".msg.commenturl");
                aVar2.thumburl = (String) q.get(".msg.appmsg.thumburl");
                aVar2.mediaTagName = (String) q.get(".msg.appmsg.mediatagname");
                aVar2.messageAction = (String) q.get(".msg.appmsg.messageaction");
                aVar2.messageExt = (String) q.get(".msg.appmsg.messageext");
                aVar2.bpy = be.getInt((String) q.get(".msg.appinfo.version"), 0);
                aVar2.appName = (String) q.get(".msg.appinfo.appname");
                aVar2.bhM = (String) q.get(".msg.fromusername");
                aVar2.coi = (String) q.get(".msg.appmsg.appattach.cdnattachurl");
                aVar2.coj = (String) q.get(".msg.appmsg.appattach.cdnthumburl");
                aVar2.cok = be.getInt((String) q.get(".msg.appmsg.appattach.cdnthumblength"), 0);
                aVar2.col = be.getInt((String) q.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
                aVar2.com = be.getInt((String) q.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
                aVar2.con = be.getInt((String) q.get(".msg.appmsg.appattach.thumbheight"), 0);
                aVar2.coo = be.getInt((String) q.get(".msg.appmsg.appattach.thumbwidth"), 0);
                aVar2.cop = (String) q.get(".msg.appmsg.appattach.aeskey");
                aVar2.cor = be.getInt((String) q.get(".msg.appmsg.appattach.encryver"), 1);
                aVar2.coq = (String) q.get(".msg.appmsg.appattach.cdnthumbaeskey");
                aVar2.cof = be.getInt((String) q.get(".msg.appmsg.appattach.islargefilemsg"), 0);
                if (aVar2.cof == 0 && aVar2.cob > 26214400) {
                    aVar2.cof = 1;
                    v.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", Integer.valueOf(aVar2.cob));
                }
                aVar2.cox = be.getInt((String) q.get(".msg.appmsg.productitem.$type"), 0);
                aVar2.coy = (String) q.get(".msg.appmsg.productitem.productinfo");
                aVar2.coA = be.getInt((String) q.get(".msg.appmsg.emoticongift.packageflag"), 0);
                aVar2.coz = (String) q.get(".msg.appmsg.emoticongift.packageid");
                aVar2.coF = (String) q.get(".msg.appmsg.emoticonshared.packageid");
                aVar2.coG = be.getInt((String) q.get(".msg.appmsg.emoticonshared.packageflag"), 0);
                aVar2.coB = (String) q.get(".msg.appmsg.tvinfo");
                aVar2.coC = (String) q.get(".msg.appmsg.recorditem");
                aVar2.bnU = (String) q.get(".msg.appmsg.webviewshared.shareUrlOriginal");
                aVar2.bnV = (String) q.get(".msg.appmsg.webviewshared.shareUrlOpen");
                aVar2.bnW = (String) q.get(".msg.appmsg.webviewshared.jsAppId");
                aVar2.bnX = (String) q.get(".msg.appmsg.webviewshared.publisherId");
                aVar2.cqd = com.tencent.mm.a.o.ba((String) q.get(".msg.appmsg.designershared.designeruin"));
                aVar2.designerName = (String) q.get(".msg.appmsg.designershared.designername");
                aVar2.designerRediretctUrl = (String) q.get(".msg.appmsg.designershared.designerrediretcturl");
                aVar2.tid = be.KL((String) q.get(".msg.appmsg.emotionpageshared.tid"));
                aVar2.cqe = (String) q.get(".msg.appmsg.emotionpageshared.title");
                aVar2.desc = (String) q.get(".msg.appmsg.emotionpageshared.desc");
                aVar2.iconUrl = (String) q.get(".msg.appmsg.emotionpageshared.iconUrl");
                aVar2.secondUrl = be.ah((String) q.get(".msg.appmsg.emotionpageshared.secondUrl"), SQLiteDatabase.KeyEmpty);
                aVar2.pageType = be.KL((String) q.get(".msg.appmsg.emotionpageshared.pageType"));
                aVar2.cqg = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideourl"), SQLiteDatabase.KeyEmpty);
                aVar2.cqh = be.KL((String) q.get(".msg.appmsg.streamvideo.streamvideototaltime"));
                aVar2.cqi = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideotitle"), SQLiteDatabase.KeyEmpty);
                aVar2.cqj = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideowording"), SQLiteDatabase.KeyEmpty);
                aVar2.cqk = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideoweburl"), SQLiteDatabase.KeyEmpty);
                aVar2.cql = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideothumburl"), SQLiteDatabase.KeyEmpty);
                aVar2.cqm = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), SQLiteDatabase.KeyEmpty);
                aVar2.cqn = be.ah((String) q.get(".msg.appmsg.streamvideo.streamvideopublishid"), SQLiteDatabase.KeyEmpty);
                aVar2.canvasPageXml = be.ah((String) q.get(".msg.appmsg.canvasPageItem.canvasPageXml"), SQLiteDatabase.KeyEmpty);
                aVar2.cqp = (String) q.get(".msg.appmsg.weappinfo.username");
                aVar2.cqo = (String) q.get(".msg.appmsg.weappinfo.pagepath");
                aVar2.cqq = (String) q.get(".msg.appmsg.weappinfo.appid");
                aVar2.cqu = be.getInt((String) q.get(".msg.appmsg.weappinfo.version"), 0);
                aVar2.cqr = be.getInt((String) q.get(".msg.appmsg.weappinfo.type"), 0);
                aVar2.cqt = be.getInt((String) q.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
                aVar2.cqs = (String) q.get(".msg.appmsg.weappinfo.pkginfo.md5");
                aVar2.cqv = (String) q.get(".msg.appmsg.weappinfo.weappiconurl");
                String str3 = "<cache";
                String str4 = "</cache>";
                int indexOf2 = str.indexOf(str3);
                int indexOf3 = str.indexOf(str4);
                if (indexOf3 - indexOf2 > str3.length()) {
                    aVar2.cqw = str.substring(indexOf2, str4.length() + indexOf3);
                }
                switch (aVar2.type) {
                    case 1:
                        if (!(q.get(".msg.alphainfo.url") == null || q.get(".msg.alphainfo.md5") == null)) {
                            aVar2.cpQ = true;
                            break;
                        }
                    case 13:
                        aVar2.coD = be.getInt((String) q.get(".msg.appmsg.mallproductitem.$type"), 0);
                        aVar2.coE = (String) q.get(".msg.appmsg.mallproductitem.mallproductinfo");
                        break;
                    case 16:
                        aVar2.bgD = str;
                        aVar2.cpm = SQLiteDatabase.KeyEmpty;
                        aVar2.cpo = be.getInt((String) q.get(".msg.appmsg.carditem.from_scene"), 2);
                        aVar2.cpn = (String) q.get(".msg.appmsg.carditem.brand_name");
                        aVar2.cpp = be.getInt((String) q.get(".msg.appmsg.carditem.card_type"), -1);
                        break;
                    case 34:
                        aVar2.cpr = be.ah((String) q.get(".msg.appmsg.giftcard_info.order_id"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpq = com.tencent.mm.a.o.ba((String) q.get(".msg.appmsg.giftcard_info.biz_uin"));
                        aVar2.cps = be.ah((String) q.get(".msg.appmsg.giftcard_info.app_name"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpt = be.ah((String) q.get(".msg.appmsg.giftcard_info.recv_digest"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpu = be.ah((String) q.get(".msg.appmsg.giftcard_info.send_digest"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpv = be.ah((String) q.get(".msg.appmsg.giftcard_info.background_pic_url"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpw = be.ah((String) q.get(".msg.appmsg.giftcard_info.title_color"), SQLiteDatabase.KeyEmpty);
                        aVar2.cpx = be.ah((String) q.get(".msg.appmsg.giftcard_info.des_color"), SQLiteDatabase.KeyEmpty);
                        break;
                    case 2000:
                        aVar2.cpe = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                        aVar2.cpf = be.ma((String) q.get(".msg.appmsg.wcpayinfo.feedesc"));
                        aVar2.cpg = be.ma((String) q.get(".msg.appmsg.wcpayinfo.transcationid"));
                        aVar2.cph = be.ma((String) q.get(".msg.appmsg.wcpayinfo.transferid"));
                        aVar2.cpi = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        aVar2.cpj = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                        aVar2.cpk = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                        aVar2.cpl = be.ah((String) q.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                        aVar2.cqf = be.ah((String) q.get(".msg.appmsg.wcpayinfo.pay_memo"), SQLiteDatabase.KeyEmpty);
                        break;
                    case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                        String[] split;
                        aVar2.cpC = be.ma((String) q.get(".msg.appmsg.wcpayinfo.iconurl"));
                        aVar2.cpH = be.ma((String) q.get(".msg.appmsg.wcpayinfo.scenetext"));
                        aVar2.cpB = be.ma((String) q.get(".msg.appmsg.wcpayinfo.url"));
                        aVar2.cpD = be.ma((String) q.get(".msg.appmsg.wcpayinfo.receivertitle"));
                        aVar2.cpE = be.ma((String) q.get(".msg.appmsg.wcpayinfo.sendertitle"));
                        aVar2.cpG = be.ma((String) q.get(".msg.appmsg.wcpayinfo.receiverdes"));
                        aVar2.cpF = be.ma((String) q.get(".msg.appmsg.wcpayinfo.senderdes"));
                        aVar2.cpI = be.ma((String) q.get(".msg.appmsg.wcpayinfo.templateid"));
                        aVar2.cpJ = be.ma((String) q.get(".msg.appmsg.wcpayinfo.sceneid"));
                        aVar2.cpK = be.ma((String) q.get(".msg.appmsg.wcpayinfo.nativeurl"));
                        aVar2.cpL = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                        aVar2.cpM = be.ma((String) q.get(".msg.appmsg.wcpayinfo.paymsgid"));
                        aVar2.cpN = be.ma((String) q.get(".msg.appmsg.wcpayinfo.imageid"));
                        aVar2.cpO = be.ma((String) q.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                        aVar2.cpP = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                        aVar2.cpR = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                        aVar2.cpS = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                        aVar2.cpT = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                        aVar2.cpU = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                        aVar2.cpV = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                        aVar2.cpW = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                        str3 = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                        if (!be.kS(str3)) {
                            split = str3.split("\\|");
                            if (split != null && split.length > 0) {
                                aVar2.cpX = new ArrayList();
                                aVar2.cpX.addAll(Arrays.asList(split));
                            }
                        }
                        aVar2.cpY = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                        str3 = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                        if (!be.kS(str3)) {
                            split = str3.split("\\|");
                            if (split != null && split.length > 0) {
                                aVar2.cpZ = new ArrayList();
                                aVar2.cpZ.addAll(Arrays.asList(split));
                            }
                        }
                        aVar2.cqa = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                        aVar2.cqb = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                        aVar2.cqc = be.ma((String) q.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                        break;
                }
                if (aVar2.type != 21) {
                    if (aVar2.type != MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
                        aVar2.aXx = be.getInt((String) q.get(".msg.appmsg.showtype"), 0);
                        switch (aVar2.aXx) {
                            case 1:
                                if (be.getInt((String) q.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                    aVar2.content = au.U(q);
                                }
                                aVar2.cou = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.k(q);
                                break;
                            case 2:
                                str3 = str.toLowerCase();
                                aVar2.coh = str.substring(str3.indexOf("<ShakePageResult>".toLowerCase()) + 17, str3.indexOf("</ShakePageResult>".toLowerCase()));
                                break;
                            default:
                                break;
                        }
                    }
                    aVar2.aXx = be.getInt((String) q.get(".msg.appmsg.wcpayinfo.innertype"), 0);
                } else {
                    aVar2.aXx = be.getInt((String) q.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                }
                aVar2.bnY = (String) q.get(".msg.appmsg.statextstr");
                aVar2.cov = be.getInt((String) q.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
                if (aVar2.cov == 5 && be.getInt((String) q.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                    aVar2.cov = 0;
                }
                aVar2.cow = be.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
                aVar2.coH = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
                aVar2.coI = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
                if (be.kS(aVar2.coI)) {
                    aVar2.coI = (String) q.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
                }
                aVar2.coJ = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
                aVar2.coK = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
                aVar2.coL = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
                aVar2.coM = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
                aVar2.coN = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
                aVar2.coO = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
                aVar2.coP = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
                aVar2.coR = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
                aVar2.coQ = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
                aVar2.coT = (String) q.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
                aVar2.coS = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
                aVar2.coW = be.getInt((String) q.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                aVar2.coY = be.getInt((String) q.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
                aVar2.coX = be.getInt((String) q.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
                aVar2.coU = (String) q.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
                aVar2.coV = (String) q.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
                str3 = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
                aVar2.cpc = str3;
                aVar2.cpa = str3;
                str3 = (String) q.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
                aVar2.cpb = str3;
                aVar2.coZ = str3;
                aVar2.cpd = be.getInt((String) q.get(".msg.appmsg.template_id"), 0);
                aVar2.filemd5 = (String) q.get(".msg.appmsg.md5");
                aVar2.cpy = be.getInt((String) q.get(".msg.appmsg.jumpcontrol.enable"), 0);
                aVar2.cpz = (String) q.get(".msg.appmsg.jumpcontrol.jumpurl");
                aVar2.cpA = (String) q.get(".msg.appmsg.jumpcontrol.pushcontent");
                cqx.k(Integer.valueOf(hashCode), aVar2);
                Map q2 = bf.q(substring, "msgoperation");
                if (q2 != null) {
                    aVar2.cnY = new a();
                    aVar2.cnY.bNx = (String) q2.get(".msgoperation.expinfo.expidstr");
                    aVar2.cnY.cqy = be.getInt((String) q2.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                    aVar2.cnY.cqz = be.getInt((String) q2.get(".msgoperation.appmsg.isupdatetitle"), 0);
                    aVar2.cnY.title = (String) q2.get(".msgoperation.appmsg.title");
                    aVar2.cnY.cqA = be.getInt((String) q2.get(".msgoperation.appmsg.isupdatedesc"), 0);
                    aVar2.cnY.desc = (String) q2.get(".msgoperation.appmsg.desc");
                    aVar2.cnY.cqB = be.getInt((String) q2.get(".msgoperation.appmsg.ishiddentail"), 0);
                }
                v.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(be.ma(str2).hashCode()));
                return aVar2;
            } catch (Throwable e) {
                v.e("MicroMsg.AppMessage", "parse amessage xml failed");
                v.e("MicroMsg.AppMessage", "exception:%s", be.e(e));
                return null;
            }
        }

        public static String C(String str, String str2) {
            String str3;
            Map q = bf.q(str, "msg");
            if (q == null) {
                v.e("MicroMsg.AppMessage", "getAppMsgDyeingTempFromUser fail, values is null");
                str3 = null;
            } else {
                str3 = (String) q.get(".msg.fromusername");
            }
            if (be.kS(str3) && !m.fc(str2)) {
                str3 = str2;
            }
            if (be.kS(str3)) {
                return SQLiteDatabase.KeyEmpty;
            }
            if (dW(str3)) {
                b mVar = new com.tencent.mm.e.a.m();
                mVar.aWJ.aWH = str3;
                com.tencent.mm.sdk.c.a.nhr.z(mVar);
                if (!TextUtils.isEmpty(mVar.aWK.appName)) {
                    return mVar.aWK.appName;
                }
            }
            return l.er(str3);
        }

        public static boolean dW(String str) {
            return str != null && str.endsWith("@app");
        }

        public static String dX(String str) {
            Map q = bf.q(str, "msg");
            if (q == null) {
                v.e("MicroMsg.AppMessage", "getAppMsgDyeingTempTitle fail, values is null");
                return " ";
            }
            String ma;
            if (be.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0) != 0) {
                ma = be.ma((String) q.get(".msg.appmsg.mmreader.template_header.title"));
            } else {
                ma = (String) q.get(".msg.appmsg.mmreader.category.item.title");
            }
            if (be.kS(ma)) {
                return " ";
            }
            return ma;
        }

        public static String dY(String str) {
            Map Ks = au.Ks(str);
            if (Ks == null) {
                c ea = ea(str);
                StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
                Iterator it = ea.cqE.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (!be.kS(dVar.title)) {
                        stringBuilder.append(dVar.title);
                        break;
                    }
                }
                return stringBuilder.toString();
            }
            String str2 = (String) Ks.get(".msg.appmsg.mmreader.category.item.title");
            return str2 == null ? SQLiteDatabase.KeyEmpty : str2;
        }

        public static c dZ(String str) {
            Map Ks = au.Ks(str);
            if (Ks == null) {
                return ea(str);
            }
            int i = be.getInt((String) Ks.get(".msg.appmsg.mmreader.category.$type"), 0);
            String ma = be.ma((String) Ks.get(".msg.appmsg.mmreader.name"));
            int i2 = be.getInt((String) Ks.get(".msg.appmsg.mmreader.forbid_forward"), 0);
            int i3 = be.getInt((String) Ks.get(".msg.appmsg.mmreader.category.$count"), 0);
            String str2 = (String) Ks.get(".msg.commenturl");
            c cVar = new c();
            cVar.type = i;
            cVar.name = ma;
            cVar.bNm = str2;
            cVar.cqF = i2;
            i = 0;
            while (i < i3) {
                d dVar = new d();
                String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? SQLiteDatabase.KeyEmpty : String.valueOf(i));
                dVar.title = (String) Ks.get(str3 + ".title");
                dVar.url = (String) Ks.get(str3 + ".url");
                dVar.cqG = (String) Ks.get(str3 + ".shorturl");
                dVar.cqH = (String) Ks.get(str3 + ".longurl");
                dVar.time = be.getLong((String) Ks.get(str3 + ".pub_time"), 0);
                dVar.cqJ = (String) Ks.get(str3 + ".tweetid");
                dVar.cqK = (String) Ks.get(str3 + ".digest");
                dVar.type = be.getInt((String) Ks.get(str3 + ".itemshowtype"), 0);
                dVar.cqM = be.getInt((String) Ks.get(str3 + ".play_length"), 0);
                dVar.cqI = (String) Ks.get(str3 + ".cover");
                dVar.cqL = be.getInt((String) Ks.get(str3 + ".del_flag"), 0);
                cVar.cqE.add(dVar);
                i++;
            }
            cVar.cou = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.k(Ks);
            str2 = be.ma((String) Ks.get(".msg.fromusername"));
            if (!be.kS(str2)) {
                ak.yW();
                String tT = c.wH().LX(str2).tT();
                cVar.bnR = str2;
                cVar.bnS = tT;
            }
            return cVar;
        }

        private static c ea(String str) {
            try {
                return (c) new c().az(Base64.decode(str, 0));
            } catch (Exception e) {
                try {
                    return (c) new c().az(be.KG(str));
                } catch (Exception e2) {
                    return new c();
                }
            }
        }

        public static a a(a aVar) {
            a aVar2 = new a();
            if (aVar != null) {
                v.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s]", be.KW(aVar.cop), aVar.filemd5);
                aVar2.bXP = aVar.bXP;
                aVar2.appId = aVar.appId;
                aVar2.appName = aVar.appName;
                aVar2.bpy = aVar.bpy;
                aVar2.aXa = aVar.aXa;
                aVar2.cob = aVar.cob;
                aVar2.content = aVar.content;
                aVar2.description = aVar.description;
                aVar2.username = aVar.username;
                aVar2.extInfo = aVar.extInfo;
                aVar2.mediaTagName = aVar.mediaTagName;
                aVar2.messageAction = aVar.messageAction;
                aVar2.messageExt = aVar.messageExt;
                aVar2.coe = aVar.coe;
                aVar2.coc = aVar.coc;
                aVar2.bhM = aVar.bhM;
                aVar2.coa = aVar.coa;
                aVar2.sdkVer = aVar.sdkVer;
                aVar2.title = aVar.title;
                aVar2.type = aVar.type;
                aVar2.aXx = aVar.aXx;
                aVar2.cov = aVar.cov;
                aVar2.cow = aVar.cow;
                aVar2.url = aVar.url;
                aVar2.cod = aVar.cod;
                aVar2.bnR = aVar.bnR;
                aVar2.bnS = aVar.bnS;
                aVar2.bNm = aVar.bNm;
                aVar2.thumburl = aVar.thumburl;
                aVar2.coh = aVar.coh;
                aVar2.cos = aVar.cos;
                aVar2.cot = aVar.cot;
                aVar2.cox = aVar.cox;
                aVar2.coy = aVar.coy;
                aVar2.coA = aVar.coA;
                aVar2.coz = aVar.coz;
                aVar2.coD = aVar.coD;
                aVar2.coE = aVar.coE;
                aVar2.coG = aVar.coG;
                aVar2.coF = aVar.coF;
                aVar2.coB = aVar.coB;
                aVar2.coC = aVar.coC;
                aVar2.cpd = aVar.cpd;
                aVar2.bgD = aVar.bgD;
                aVar2.cpm = aVar.cpm;
                aVar2.cpn = aVar.cpn;
                aVar2.cpo = aVar.cpo;
                aVar2.cpp = aVar.cpo;
                aVar2.cpf = aVar.cpf;
                aVar2.cpi = aVar.cpi;
                aVar2.cpe = aVar.cpe;
                aVar2.cpg = aVar.cpg;
                aVar2.cph = aVar.cph;
                aVar2.cpy = aVar.cpy;
                aVar2.cpz = aVar.cpz;
                aVar2.cpA = aVar.cpA;
                aVar2.cog = aVar.cog;
                aVar2.bnU = aVar.bnU;
                aVar2.bnV = aVar.bnV;
                aVar2.bnW = aVar.bnW;
                aVar2.bnX = aVar.bnX;
                aVar2.cqf = aVar.cqf;
                aVar2.cqd = aVar.cqd;
                aVar2.designerName = aVar.designerName;
                aVar2.designerRediretctUrl = aVar.designerName;
                aVar2.tid = aVar.tid;
                aVar2.cqe = aVar.cqe;
                aVar2.desc = aVar.desc;
                aVar2.iconUrl = aVar.iconUrl;
                aVar2.secondUrl = aVar.secondUrl;
                aVar2.pageType = aVar.pageType;
                aVar2.cqg = aVar.cqg;
                aVar2.cqh = aVar.cqh;
                aVar2.cqi = aVar.cqi;
                aVar2.cqj = aVar.cqj;
                aVar2.cqk = aVar.cqk;
                aVar2.cql = aVar.cql;
                aVar2.cqm = aVar.cqm;
                aVar2.cqn = aVar.cqn;
                aVar2.canvasPageXml = aVar.canvasPageXml;
                aVar2.bnY = aVar.bnY;
                aVar2.coi = aVar.coi;
                aVar2.cop = aVar.cop;
                aVar2.filemd5 = aVar.filemd5;
                aVar2.cof = aVar.cof;
                aVar2.cnY = aVar.cnY;
                aVar2.cqo = aVar.cqo;
                aVar2.cqp = aVar.cqp;
                aVar2.cqr = aVar.cqr;
                aVar2.cqs = aVar.cqs;
                aVar2.cqt = aVar.cqt;
                aVar2.cqq = aVar.cqq;
                aVar2.cqu = aVar.cqu;
                aVar2.cqv = aVar.cqv;
            }
            return aVar2;
        }

        public static String b(a aVar) {
            v.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", be.KW(aVar.cop), aVar.filemd5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msg>");
            if (aVar.coo == 0 || aVar.con == 0) {
                v.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
                stringBuilder.append(a(aVar, null, null, 0, 0));
            } else {
                v.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", Integer.valueOf(aVar.coo), Integer.valueOf(aVar.con));
                stringBuilder.append(a(aVar, null, null, aVar.coo, aVar.con));
            }
            stringBuilder.append("</msg>");
            cqx.k(Integer.valueOf(stringBuilder.toString().hashCode()), aVar);
            return stringBuilder.toString();
        }

        public static String a(a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
            String str2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<appmsg appid=\"" + be.KJ(aVar.appId) + "\" sdkver=\"" + aVar.sdkVer + "\">");
            stringBuilder.append("<title>" + be.KJ(aVar.title) + "</title>");
            stringBuilder.append("<des>" + be.KJ(aVar.description) + "</des>");
            stringBuilder.append("<username>" + be.KJ(aVar.username) + "</username>");
            StringBuilder stringBuilder2 = new StringBuilder("<action>");
            if (be.kS(aVar.bXP)) {
                str2 = "view";
            } else {
                str2 = be.KJ(aVar.bXP);
            }
            stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
            stringBuilder.append("<type>" + aVar.type + "</type>");
            stringBuilder.append("<showtype>").append(aVar.aXx).append("</showtype>");
            stringBuilder.append("<content>" + be.KJ(aVar.content) + "</content>");
            stringBuilder.append("<url>" + be.KJ(aVar.url) + "</url>");
            stringBuilder.append("<lowurl>" + be.KJ(aVar.coa) + "</lowurl>");
            stringBuilder.append("<dataurl>" + be.KJ(aVar.cos) + "</dataurl>");
            stringBuilder.append("<lowdataurl>" + be.KJ(aVar.cot) + "</lowdataurl>");
            stringBuilder.append("<contentattr>").append(aVar.cog).append("</contentattr>");
            stringBuilder.append("<streamvideo>");
            stringBuilder.append("<streamvideourl>").append(be.KJ(aVar.cqg)).append("</streamvideourl>");
            stringBuilder.append("<streamvideototaltime>").append(aVar.cqh).append("</streamvideototaltime>");
            stringBuilder.append("<streamvideotitle>").append(be.KJ(aVar.cqi)).append("</streamvideotitle>");
            stringBuilder.append("<streamvideowording>").append(be.KJ(aVar.cqj)).append("</streamvideowording>");
            stringBuilder.append("<streamvideoweburl>").append(be.KJ(aVar.cqk)).append("</streamvideoweburl>");
            stringBuilder.append("<streamvideothumburl>").append(be.KJ(aVar.cql)).append("</streamvideothumburl>");
            stringBuilder.append("<streamvideoaduxinfo>").append(be.KJ(aVar.cqm)).append("</streamvideoaduxinfo>");
            stringBuilder.append("<streamvideopublishid>").append(be.KJ(aVar.cqn)).append("</streamvideopublishid>");
            stringBuilder.append("</streamvideo>");
            stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{aVar.canvasPageXml}));
            switch (aVar.type) {
                case 10:
                    stringBuilder.append("<productitem type=\"" + aVar.cox + "\">");
                    stringBuilder.append("<productinfo>" + be.KJ(aVar.coy) + "</productinfo>");
                    stringBuilder.append("</productitem>");
                    break;
                case 13:
                    stringBuilder.append("<mallproductitem type=\"" + aVar.coD + "\">");
                    stringBuilder.append("<mallproductinfo>" + be.KJ(aVar.coE) + "</mallproductinfo>");
                    stringBuilder.append("</mallproductitem>");
                    break;
                case 16:
                    stringBuilder.append("<carditem>" + aVar.cpm + "</carditem>");
                    break;
                case 19:
                case 24:
                    stringBuilder.append("<recorditem>" + be.KJ(aVar.coC) + "</recorditem>");
                    break;
                case 20:
                    stringBuilder.append("<tvinfo>" + be.KJ(aVar.coB) + "</tvinfo>");
                    break;
                case 2000:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<paysubtype>" + aVar.cpe + "</paysubtype>");
                    stringBuilder.append("<feedesc>" + aVar.cpf + "</feedesc>");
                    stringBuilder.append("<transcationid>" + aVar.cpg + "</transcationid>");
                    stringBuilder.append("<transferid>" + aVar.cph + "</transferid>");
                    stringBuilder.append("<invalidtime>" + aVar.cpi + "</invalidtime>");
                    stringBuilder.append("<pay_memo>" + aVar.cqf + "</pay_memo>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<iconurl>" + be.KJ(aVar.cpC) + "</iconurl>");
                    stringBuilder.append("<scenetext>" + be.KJ(aVar.cpH) + "</scenetext>");
                    stringBuilder.append("<url>" + be.KJ(aVar.cpB) + "</url>");
                    stringBuilder.append("<receivertitle>" + be.KJ(aVar.cpD) + "</receivertitle>");
                    stringBuilder.append("<sendertitle>" + be.KJ(aVar.cpE) + "</sendertitle>");
                    stringBuilder.append("<receiverdes>" + be.KJ(aVar.cpG) + "</receiverdes>");
                    stringBuilder.append("<senderdes>" + be.KJ(aVar.cpF) + "</senderdes>");
                    stringBuilder.append("<templateid>" + be.KJ(aVar.cpI) + "</templateid>");
                    stringBuilder.append("<sceneid>" + be.KJ(aVar.cpJ) + "</sceneid>");
                    stringBuilder.append("<nativeurl>" + be.KJ(aVar.cpK) + "</nativeurl>");
                    stringBuilder.append("<innertype>" + be.KJ(aVar.aXx) + "</innertype>");
                    stringBuilder.append("<localtype>" + be.KJ(aVar.cpL) + "</localtype>");
                    stringBuilder.append("<paymsgid>" + be.KJ(aVar.cpM) + "</paymsgid>");
                    stringBuilder.append("<imageid>" + be.KJ(aVar.cpN) + "</imageid>");
                    stringBuilder.append("<imageaeskey>" + be.KJ(aVar.cpO) + "</imageaeskey>");
                    stringBuilder.append("<imagelength>" + be.KJ(aVar.cpP) + "</imagelength>");
                    stringBuilder.append("<droptips>" + be.KJ(aVar.cpR) + "</droptips>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
            }
            stringBuilder.append("<appattach>");
            if (com_tencent_mm_modelcdntran_keep_SceneResult == null || (be.kS(str) && i == 0 && i2 == 0)) {
                stringBuilder.append("<totallen>" + aVar.cob + "</totallen>");
                stringBuilder.append("<attachid>" + be.KJ(aVar.aXa) + "</attachid>");
                stringBuilder.append("<cdnattachurl>" + be.KJ(aVar.coi) + "</cdnattachurl>");
                stringBuilder.append("<emoticonmd5>" + be.KJ(aVar.cod) + "</emoticonmd5>");
                stringBuilder.append("<aeskey>" + be.KJ(aVar.cop) + "</aeskey>");
                if (!(i == 0 || i2 == 0)) {
                    stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                    stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
                }
            } else {
                stringBuilder.append("<attachid>" + be.KJ(str) + "</attachid>");
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0 && !be.kS(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
                    stringBuilder.append("<cdnattachurl>" + be.KJ(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnattachurl>");
                    if (aVar.type == 19 || aVar.type == 24 || aVar.type == 4 || aVar.type == 3 || aVar.type == 7 || aVar.type == 27 || aVar.type == 26) {
                        v.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", Integer.valueOf(aVar.type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength));
                    } else {
                        stringBuilder.append("<totallen>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "</totallen>");
                    }
                }
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                    stringBuilder.append("<cdnthumburl>" + be.KJ(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnthumburl>");
                    if (!be.kS(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5)) {
                        stringBuilder.append("<cdnthumbmd5>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5 + "</cdnthumbmd5>");
                    }
                    stringBuilder.append("<cdnthumblength>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "</cdnthumblength>");
                    stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                    stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                    stringBuilder.append("<cdnthumbaeskey>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "</cdnthumbaeskey>");
                }
                stringBuilder.append("<aeskey>" + be.KJ(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey) + "</aeskey>");
                stringBuilder.append("<encryver>1</encryver>");
            }
            stringBuilder.append("<fileext>" + be.KJ(aVar.coc) + "</fileext>");
            stringBuilder.append("<islargefilemsg>" + aVar.cof + "</islargefilemsg>");
            stringBuilder.append("</appattach>");
            stringBuilder.append("<extinfo>" + be.KJ(aVar.extInfo) + "</extinfo>");
            stringBuilder.append("<androidsource>" + aVar.coe + "</androidsource>");
            if (!be.kS(aVar.bnR)) {
                stringBuilder.append("<sourceusername>" + be.KJ(aVar.bnR) + "</sourceusername>");
                stringBuilder.append("<sourcedisplayname>" + be.KJ(aVar.bnS) + "</sourcedisplayname>");
                stringBuilder.append("<commenturl>" + be.KJ(aVar.bNm) + "</commenturl>");
            }
            stringBuilder.append("<thumburl>" + be.KJ(aVar.thumburl) + "</thumburl>");
            stringBuilder.append("<mediatagname>" + be.KJ(aVar.mediaTagName) + "</mediatagname>");
            stringBuilder.append("<messageaction>" + eb(be.KJ(aVar.messageAction)) + "</messageaction>");
            stringBuilder.append("<messageext>" + eb(be.KJ(aVar.messageExt)) + "</messageext>");
            stringBuilder.append("<emoticongift>");
            stringBuilder.append("<packageflag>" + aVar.coA + "</packageflag>");
            stringBuilder.append("<packageid>" + be.KJ(aVar.coz) + "</packageid>");
            stringBuilder.append("</emoticongift>");
            stringBuilder.append("<emoticonshared>");
            stringBuilder.append("<packageflag>" + aVar.coG + "</packageflag>");
            stringBuilder.append("<packageid>" + be.KJ(aVar.coF) + "</packageid>");
            stringBuilder.append("</emoticonshared>");
            stringBuilder.append("<weappinfo>");
            stringBuilder.append("<pagepath>" + eb(aVar.cqo) + "</pagepath>");
            stringBuilder.append("<username>" + be.KJ(aVar.cqp) + "</username>");
            stringBuilder.append("<appid>" + be.KJ(aVar.cqq) + "</appid>");
            if (aVar.cqu != 0) {
                stringBuilder.append("<version>" + aVar.cqu + "</version>");
            }
            if (aVar.cqr != 0) {
                stringBuilder.append("<type>" + aVar.cqr + "</type>");
            }
            if (be.kS(aVar.cqv)) {
                stringBuilder.append("<weappiconurl>" + eb(aVar.cqv) + "</weappiconurl>");
            }
            if (aVar.cqt == 1 || aVar.cqt == 2) {
                stringBuilder.append("<pkginfo>");
                stringBuilder.append("<type>");
                stringBuilder.append(aVar.cqt);
                stringBuilder.append("</type>");
                stringBuilder.append("<md5>");
                stringBuilder.append(aVar.cqs);
                stringBuilder.append("</md5>");
                stringBuilder.append("</pkginfo>");
            }
            stringBuilder.append("</weappinfo>");
            stringBuilder.append("<designershared>");
            stringBuilder.append("<designeruin>" + aVar.cqd + "</designeruin>");
            stringBuilder.append("<designername>" + aVar.designerName + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + aVar.designerRediretctUrl + "</designerrediretcturl>");
            stringBuilder.append("</designershared>");
            stringBuilder.append("<emotionpageshared>");
            stringBuilder.append("<tid>" + aVar.tid + "</tid>");
            stringBuilder.append("<title>" + aVar.cqe + "</title>");
            stringBuilder.append("<desc>" + aVar.desc + "</desc>");
            stringBuilder.append("<iconUrl>" + aVar.iconUrl + "</iconUrl>");
            stringBuilder.append("<secondUrl>" + aVar.secondUrl + "</secondUrl>");
            stringBuilder.append("<pageType>" + aVar.pageType + "</pageType>");
            stringBuilder.append("</emotionpageshared>");
            stringBuilder.append("<webviewshared>");
            stringBuilder.append("<shareUrlOriginal>" + be.KJ(aVar.bnU) + "</shareUrlOriginal>");
            stringBuilder.append("<shareUrlOpen>" + be.KJ(aVar.bnV) + "</shareUrlOpen>");
            stringBuilder.append("<jsAppId>" + be.KJ(aVar.bnW) + "</jsAppId>");
            stringBuilder.append("<publisherId>" + be.KJ(aVar.bnX) + "</publisherId>");
            stringBuilder.append("</webviewshared>");
            stringBuilder.append("<template_id>" + aVar.cpd + "</template_id>");
            if (!be.kS(aVar.appId)) {
                String str3 = aVar.bnY;
                axz com_tencent_mm_protocal_c_axz = new axz();
                if (str3 != null) {
                    try {
                        com_tencent_mm_protocal_c_axz.az(Base64.decode(str3, 0));
                    } catch (Throwable e) {
                        v.a("MicroMsg.AppMessage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                com_tencent_mm_protocal_c_axz.mVv = new axx();
                com_tencent_mm_protocal_c_axz.mVv.ghW = aVar.appId;
                try {
                    str3 = Base64.encodeToString(com_tencent_mm_protocal_c_axz.toByteArray(), 0);
                    str2 = str3.replace("\n", SQLiteDatabase.KeyEmpty);
                } catch (Throwable e2) {
                    Throwable th = e2;
                    str2 = str3;
                    v.a("MicroMsg.AppMessage", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                aVar.bnY = str2;
            }
            stringBuilder.append("<statextstr>" + be.KJ(aVar.bnY) + "</statextstr>");
            v.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", aVar.filemd5);
            stringBuilder.append("<md5>" + be.KJ(aVar.filemd5) + "</md5>");
            stringBuilder.append("</appmsg>");
            if (2 == aVar.aXx) {
                stringBuilder.append("<ShakePageResult>").append(aVar.coh).append("</ShakePageResult>");
            }
            v.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", stringBuilder.toString());
            return stringBuilder.toString();
        }

        public final void a(a aVar) {
            aVar.field_appId = this.appId;
            aVar.field_title = this.title;
            aVar.field_description = this.description;
            aVar.field_type = this.type;
            aVar.field_source = this.appName;
        }

        private static String eb(String str) {
            return "<![CDATA[" + str + "]]>";
        }

        public final String getTitle() {
            if (this.cnY == null || this.cnY.cqz == 0) {
                return this.title;
            }
            return this.cnY.title;
        }
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgId";
        aVar.nmd.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgId";
        aVar.bXK[1] = "xml";
        aVar.nmd.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = SlookSmartClipMetaTag.TAG_TYPE_TITLE;
        aVar.nmd.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "description";
        aVar.nmd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "source";
        aVar.nmd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "type";
        aVar.nmd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
