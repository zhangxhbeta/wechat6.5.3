package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;

public final class x implements w {
    final MMActivity aWn;
    private String appId;
    private String appName;
    private String bnR;
    private String bnW;
    private String bnX;
    String cZp = "";
    public String cqm = "";
    public String cqn = "";
    private Bitmap cxY = null;
    private TextView dtB = null;
    private View edj = null;
    private int h = -1;
    private String jEW = "";
    private byte[] jEX = null;
    private String jEY;
    private int jEZ;
    private CdnImageView jFa = null;
    private TextView jFb = null;
    private boolean jFc = false;
    private a jFg = null;
    private String jGA = "";
    private String jGB = "";
    private String jGC;
    private String jGD;
    private String jGE;
    private int jGF = 0;
    private a jGG = null;
    private int jGH = 0;
    private String jGI = "";
    private String jGJ = "";
    private int jGK = 0;
    private String jGL = "";
    private String jGM = "";
    private boolean jGs = false;
    private String jGt;
    private String jGu;
    private boolean jGv = false;
    private boolean jGw = false;
    private boolean jGx = false;
    private boolean jGy = false;
    private WXMediaMessage jGz = null;
    private String title = "";
    private String videoUrl = "";
    private int w = -1;

    public x(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.jGH = this.aWn.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.jGK = this.aWn.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.jGL = be.ah(this.aWn.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.jGM = be.ah(this.aWn.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.cqm = be.ah(this.aWn.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.cqn = be.ah(this.aWn.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.aWn.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.aWn.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.jGu = be.ah(this.aWn.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.cZp = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.jEW = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.jEX = this.aWn.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.jEX == null && this.jGz != null && this.jGz.mediaObject != null && (this.jGz.mediaObject instanceof WXImageObject)) {
            this.jEX = ((WXImageObject) this.jGz.mediaObject).imageData;
        }
        this.jFc = this.aWn.getIntent().getBooleanExtra("ksnsis_video", false);
        this.jGv = this.aWn.getIntent().getBooleanExtra("ksnsis_music", false);
        this.jGw = this.aWn.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.bnR = be.ah(this.aWn.getIntent().getStringExtra("src_username"), "");
        this.jEY = be.ah(this.aWn.getIntent().getStringExtra("src_displayname"), "");
        this.appId = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.jGx = this.aWn.getIntent().getBooleanExtra("KThrid_app", false);
        this.jGy = this.aWn.getIntent().getBooleanExtra("KSnsAction", false);
        this.jGC = be.ah(this.aWn.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.jGD = be.ah(this.aWn.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.bnW = be.ah(this.aWn.getIntent().getStringExtra("JsAppId"), "");
        this.bnX = be.ah(this.aWn.getIntent().getStringExtra("KPublisherId"), "");
        this.jGE = be.ah(this.aWn.getIntent().getStringExtra("reportSessionId"), "");
        this.jGF = this.aWn.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.jGI = be.ah(this.aWn.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.jGJ = be.ah(this.aWn.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.jGt = be.ah(this.aWn.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.jGt.startsWith("http://mmsns.qpic.cn") || this.jGt.startsWith("https://mmsns.qpic.cn")) {
            this.jEW = this.jGt;
            this.jEX = null;
            v.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[]{this.jGt});
        }
        Bundle bundleExtra = this.aWn.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.jGz = new c.a(bundleExtra).nhM;
            if (be.kS(this.title)) {
                this.title = this.jGz.title;
            }
            if (be.kS(this.jGB)) {
                this.jGB = this.jGz.description;
            }
            if (be.bl(this.jEX)) {
                this.jEX = this.jGz.thumbData;
            }
        }
        String stringExtra = this.aWn.getIntent().getStringExtra("KSnsStrId");
        k Bq = ad.aSE().Bq(be.ah(this.aWn.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!be.kS(stringExtra)) {
            this.jGG = a.gh(706);
            this.jGG.gl(this.jGG.cZD).kk(System.currentTimeMillis()).gl(this.jGG.cZF).gl(1).kk(stringExtra);
            if (Bq != null) {
                this.jGG.gk(Bq.field_type);
                this.jGG.bg(Bq.qC(32)).kj(Bq.aUR()).kj(this.cZp);
            }
            f.jtT.b(this.jGG);
        }
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return true;
    }

    public final View aVz() {
        this.edj = q.em(this.aWn).inflate(2130904562, null);
        if (!be.kS(this.cZp)) {
            this.edj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ x jGN;

                {
                    this.jGN = r1;
                }

                public final void onClick(View view) {
                    v.i("MicroMsg.LinkWidget", "adlink url " + this.jGN.cZp);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.jGN.cZp);
                    com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.jGN.aWn);
                }
            });
        }
        this.jFa = (CdnImageView) this.edj.findViewById(2131759412);
        this.dtB = (TextView) this.edj.findViewById(2131759414);
        this.jFb = (TextView) this.edj.findViewById(2131759415);
        if (this.jFc || this.jGv) {
            this.edj.findViewById(2131757389).setVisibility(0);
        } else {
            this.edj.findViewById(2131757389).setVisibility(8);
        }
        if (be.kS(this.title)) {
            this.dtB.setText(as.Cf(this.cZp));
        } else {
            this.dtB.setText(this.title);
        }
        if (!be.kS(this.jEW)) {
            this.jFa.setVisibility(0);
            this.jFa.G(this.jEW, 0, 0);
        } else if (be.bl(this.jEX)) {
            this.jFa.setImageResource(2131165247);
            this.jFa.setVisibility(0);
        } else {
            this.jFa.setVisibility(0);
            this.cxY = d.bc(this.jEX);
            this.jFa.setImageBitmap(this.cxY);
            this.jGs = true;
        }
        i.b(this.jFa, this.aWn);
        return this.edj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r11, int r12, b.a.d.i r13, java.lang.String r14, java.util.List<java.lang.String> r15, com.tencent.mm.protocal.c.agp r16, int r17, boolean r18, java.util.List<java.lang.String> r19, com.tencent.mm.pointers.PInt r20, java.lang.String r21, int r22, int r23) {
        /*
        r10 = this;
        r1 = r10.jGv;
        if (r1 == 0) goto L_0x00f3;
    L_0x0004:
        r1 = new com.tencent.mm.plugin.sns.e.au;
        r2 = 4;
        r1.<init>(r2);
    L_0x000a:
        r2 = r1.job;
        r0 = r20;
        r0.value = r2;
        r2 = com.tencent.mm.plugin.sns.b.a.jdC;
        r0 = r17;
        if (r0 <= r2) goto L_0x001a;
    L_0x0016:
        r2 = 4;
        r1.qk(r2);
    L_0x001a:
        r2 = r10.jEX;
        if (r2 != 0) goto L_0x0061;
    L_0x001e:
        com.tencent.mm.ae.n.GG();
        r2 = r10.jEW;
        r2 = com.tencent.mm.ae.b.gu(r2);
        if (r2 == 0) goto L_0x0061;
    L_0x0029:
        r3 = r2.isRecycled();
        if (r3 != 0) goto L_0x0061;
    L_0x002f:
        r3 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r5 = 0;
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.d.a(r2, r3, r4, r5, r6);
        r3 = "MicroMsg.LinkWidget";
        r4 = "create bitmap %d %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r2.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r2.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
        r2 = com.tencent.mm.sdk.platformtools.d.E(r2);
        r10.jEX = r2;
    L_0x0061:
        r2 = r10.title;
        r2 = r1.AL(r2);
        r3 = r10.cZp;
        r2 = r2.AJ(r3);
        r3 = r10.cZp;
        r2 = r2.AK(r3);
        r2.AG(r14);
        r2 = r10.jGv;
        if (r2 == 0) goto L_0x015e;
    L_0x007a:
        r2 = r10.jEX;
        r3 = r10.cZp;
        r4 = r10.cZp;
        r5 = r10.cZp;
        r6 = 3;
        r7 = "";
        r8 = "";
        r2 = r1.a(r2, r3, r4, r5, r6, r7, r8);
        if (r2 != 0) goto L_0x008f;
    L_0x008f:
        r2 = r10.jEZ;
        r1.qo(r2);
        r2 = r10.bnR;
        r1.AO(r2);
        r2 = r10.jEY;
        r1.AP(r2);
        r2 = r10.jGu;
        r3 = r1.bpt;
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r2);
        r3.jGu = r4;
        r3 = "MicroMsg.UploadPackHelper";
        r4 = "setStatExtStr:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
        if (r18 == 0) goto L_0x0254;
    L_0x00b9:
        r2 = 1;
        r1.qp(r2);
    L_0x00bd:
        r0 = r19;
        r1.bo(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        if (r15 == 0) goto L_0x025a;
    L_0x00c9:
        r2 = new java.util.LinkedList;
        r2.<init>();
        r4 = com.tencent.mm.model.m.yv();
        r5 = r15.iterator();
    L_0x00d6:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x025a;
    L_0x00dc:
        r2 = r5.next();
        r2 = (java.lang.String) r2;
        r6 = r4.contains(r2);
        if (r6 != 0) goto L_0x00d6;
    L_0x00e8:
        r6 = new com.tencent.mm.protocal.c.axj;
        r6.<init>();
        r6.gln = r2;
        r3.add(r6);
        goto L_0x00d6;
    L_0x00f3:
        r1 = r10.jFc;
        if (r1 == 0) goto L_0x00ff;
    L_0x00f7:
        r1 = new com.tencent.mm.plugin.sns.e.au;
        r2 = 5;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x00ff:
        r1 = r10.jGw;
        if (r1 == 0) goto L_0x011c;
    L_0x0103:
        r1 = new com.tencent.mm.plugin.sns.e.au;
        r2 = 25;
        r1.<init>(r2);
        r2 = r10.jGI;
        r3 = r1.bpt;
        r3 = r3.mWw;
        r3.username = r2;
        r2 = r10.jGJ;
        r3 = r1.bpt;
        r3 = r3.mWw;
        r3.path = r2;
        goto L_0x000a;
    L_0x011c:
        r1 = r10.jGH;
        r2 = 11;
        if (r1 != r2) goto L_0x0156;
    L_0x0122:
        r1 = new com.tencent.mm.plugin.sns.e.au;
        r2 = 18;
        r1.<init>(r2);
        r2 = new com.tencent.mm.protocal.c.ayj;
        r2.<init>();
        r3 = r10.jGL;
        r2.cqj = r3;
        r3 = r10.title;
        r2.cqi = r3;
        r3 = r10.cZp;
        r2.cqg = r3;
        r3 = r10.jGM;
        r2.cqk = r3;
        r3 = r10.jGK;
        r2.cqh = r3;
        r3 = r10.jEW;
        r2.cql = r3;
        r3 = r10.cqm;
        r2.cqm = r3;
        r3 = r10.cqn;
        r2.cqn = r3;
        r1.jok = r2;
        r3 = r1.bpt;
        r3.mWv = r2;
        goto L_0x000a;
    L_0x0156:
        r1 = new com.tencent.mm.plugin.sns.e.au;
        r2 = 3;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x015e:
        r2 = r10.jFc;
        if (r2 == 0) goto L_0x01a4;
    L_0x0162:
        r2 = 0;
        r3 = r10.jGz;
        if (r3 == 0) goto L_0x030a;
    L_0x0167:
        r2 = r10.jGz;
        r2 = r2.mediaObject;
        r2 = (com.tencent.mm.sdk.modelmsg.WXVideoObject) r2;
        r5 = r2;
    L_0x016e:
        r2 = r10.jEX;
        r3 = r10.cZp;
        if (r5 != 0) goto L_0x0192;
    L_0x0174:
        r4 = r10.cZp;
    L_0x0176:
        if (r5 != 0) goto L_0x019b;
    L_0x0178:
        r5 = r10.cZp;
    L_0x017a:
        r6 = 4;
        r7 = r10.title;
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.be.ah(r7, r8);
        r8 = r10.jGB;
        r9 = "";
        r8 = com.tencent.mm.sdk.platformtools.be.ah(r8, r9);
        r1.a(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x008f;
    L_0x0192:
        r4 = r5.videoLowBandUrl;
        r6 = r10.cZp;
        r4 = com.tencent.mm.sdk.platformtools.be.ah(r4, r6);
        goto L_0x0176;
    L_0x019b:
        r5 = r5.videoUrl;
        r6 = r10.cZp;
        r5 = com.tencent.mm.sdk.platformtools.be.ah(r5, r6);
        goto L_0x017a;
    L_0x01a4:
        r2 = r10.jGt;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x01fa;
    L_0x01ac:
        r2 = r10.jGt;
        r3 = "";
        r4 = "";
        r5 = r10.w;
        r6 = r10.h;
        r7 = "";
        r2 = com.tencent.mm.plugin.sns.e.au.O(r7, r2, r2);
        if (r2 != 0) goto L_0x01cc;
    L_0x01c1:
        r2 = "MicroMsg.UploadPackHelper";
        r3 = "share img o.url is null!";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
        goto L_0x008f;
    L_0x01cc:
        r2.gkC = r3;
        if (r5 <= 0) goto L_0x01df;
    L_0x01d0:
        if (r6 <= 0) goto L_0x01df;
    L_0x01d2:
        r7 = new com.tencent.mm.protocal.c.aid;
        r7.<init>();
        r6 = (float) r6;
        r7.lHK = r6;
        r5 = (float) r5;
        r7.mID = r5;
        r2.mHS = r7;
    L_0x01df:
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r5 != 0) goto L_0x01e7;
    L_0x01e5:
        r2.aXz = r4;
    L_0x01e7:
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r4 != 0) goto L_0x01ef;
    L_0x01ed:
        r2.gkC = r3;
    L_0x01ef:
        r3 = r1.bpt;
        r3 = r3.mWq;
        r3 = r3.mom;
        r3.add(r2);
        goto L_0x008f;
    L_0x01fa:
        r2 = r10.jEX;
        if (r2 == 0) goto L_0x008f;
    L_0x01fe:
        r2 = r10.jGw;
        if (r2 == 0) goto L_0x022c;
    L_0x0202:
        r4 = r10.jEX;
        if (r4 != 0) goto L_0x0239;
    L_0x0206:
        r2 = 0;
    L_0x0207:
        if (r2 == 0) goto L_0x022c;
    L_0x0209:
        r2 = "MicroMsg.LinkWidget";
        r3 = "isPngThumbData";
        com.tencent.mm.sdk.platformtools.v.i(r2, r3);
        r2 = r10.jEX;
        r2 = com.tencent.mm.plugin.sns.ui.d.aD(r2);
        if (r2 == 0) goto L_0x022c;
    L_0x021a:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x022c;
    L_0x021d:
        r3 = "MicroMsg.LinkWidget";
        r4 = "use covert data";
        com.tencent.mm.sdk.platformtools.v.i(r3, r4);
        r2 = com.tencent.mm.plugin.sns.ui.d.aD(r2);
        r10.jEX = r2;
    L_0x022c:
        r2 = r10.jEX;
        r3 = "";
        r4 = "";
        r1.a(r2, r3, r4);
        goto L_0x008f;
    L_0x0239:
        r2 = r4.length;
        r3 = 4;
        if (r2 >= r3) goto L_0x023f;
    L_0x023d:
        r2 = 0;
        goto L_0x0207;
    L_0x023f:
        r2 = 1;
        r3 = 4;
        r5 = new byte[r3];
        r5 = {-119, 80, 78, 71};
        r3 = 0;
    L_0x0247:
        r6 = 4;
        if (r3 >= r6) goto L_0x0207;
    L_0x024a:
        r6 = r4[r3];
        r7 = r5[r3];
        if (r6 == r7) goto L_0x0251;
    L_0x0250:
        r2 = 0;
    L_0x0251:
        r3 = r3 + 1;
        goto L_0x0247;
    L_0x0254:
        r2 = 0;
        r1.qp(r2);
        goto L_0x00bd;
    L_0x025a:
        if (r13 == 0) goto L_0x0263;
    L_0x025c:
        r2 = r13.token;
        r4 = r13.mIu;
        r1.cE(r2, r4);
    L_0x0263:
        r1.Y(r3);
        r2 = r10.appId;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x0273;
    L_0x026e:
        r2 = r10.appId;
        r1.AM(r2);
    L_0x0273:
        r2 = r10.appName;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x0287;
    L_0x027b:
        r2 = r10.appName;
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.be.ah(r2, r3);
        r1.AN(r2);
    L_0x0287:
        r2 = r10.jGx;
        if (r2 == 0) goto L_0x028f;
    L_0x028b:
        r2 = 5;
        r1.qo(r2);
    L_0x028f:
        r0 = r16;
        r1.a(r0);
        r2 = r10.jGy;
        if (r2 == 0) goto L_0x02b0;
    L_0x0298:
        r2 = r10.jGz;
        if (r2 == 0) goto L_0x02b0;
    L_0x029c:
        r2 = r10.jGz;
        r2 = r2.mediaTagName;
        r1.AH(r2);
        r2 = r10.appId;
        r3 = r10.jGz;
        r3 = r3.messageExt;
        r4 = r10.jGz;
        r4 = r4.messageAction;
        r1.N(r2, r3, r4);
    L_0x02b0:
        r0 = r21;
        r1.AI(r0);
        r2 = r10.jGC;
        r3 = r10.jGD;
        r4 = r10.bnW;
        r5 = r22;
        r6 = r23;
        r1.d(r2, r3, r4, r5, r6);
        r2 = r10.bnX;
        r3 = r1.jog;
        r3.bnX = r2;
        r2 = r10.jGE;
        r1.AQ(r2);
        r2 = r10.jGF;
        r3 = r1.bpt;
        r3.cog = r2;
        r1 = r1.commit();
        r2 = r10.jFg;
        if (r2 == 0) goto L_0x02e7;
    L_0x02db:
        r2 = r10.jFg;
        r2.gj(r1);
        r2 = com.tencent.mm.plugin.sns.i.e.jtT;
        r3 = r10.jFg;
        r2.c(r3);
    L_0x02e7:
        r2 = r10.jGG;
        if (r2 == 0) goto L_0x02fc;
    L_0x02eb:
        r2 = r10.jGG;
        r2.gj(r1);
        r1 = com.tencent.mm.plugin.sns.i.f.jtT;
        r2 = r10.jGG;
        r1.c(r2);
        r1 = r10.jGG;
        r1.JF();
    L_0x02fc:
        r1 = com.tencent.mm.plugin.sns.e.ad.aSA();
        r1.aTe();
        r1 = r10.aWn;
        r1.finish();
        r1 = 0;
        return r1;
    L_0x030a:
        r5 = r2;
        goto L_0x016e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.x.a(int, int, b.a.d.i, java.lang.String, java.util.List, com.tencent.mm.protocal.c.agp, int, boolean, java.util.List, com.tencent.mm.pointers.PInt, java.lang.String, int, int):boolean");
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        if (!(this.cxY == null || this.cxY.isRecycled() || !this.jGs)) {
            this.cxY.recycle();
        }
        return false;
    }
}
