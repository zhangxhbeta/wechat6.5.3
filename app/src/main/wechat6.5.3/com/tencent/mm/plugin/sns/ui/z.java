package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.at;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.LinkedList;
import java.util.List;

public final class z implements w {
    MMActivity aWn;
    private String appName = "";
    String bmJ = "";
    private c dHB = new c<id>(this) {
        final /* synthetic */ z jHh;

        {
            this.jHh = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((id) bVar).bif.action) {
                case 0:
                case 1:
                    this.jHh.jHf.setImageResource(2130838733);
                    break;
                case 2:
                case 3:
                case 4:
                    this.jHh.jHf.setImageResource(2130838735);
                    break;
            }
            return false;
        }
    };
    private TextView dtB = null;
    private View edj;
    boolean iyR = false;
    private int jEZ;
    private CdnImageView jFa = null;
    private TextView jFb = null;
    private a jFg = null;
    private boolean jGx = false;
    private boolean jGy = false;
    WXMediaMessage jGz = null;
    ImageView jHf;
    private Bitmap jHg;
    String mediaId;

    public z(MMActivity mMActivity) {
        this.aWn = mMActivity;
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
    }

    public final void v(Bundle bundle) {
        this.jGz = new com.tencent.mm.sdk.modelmsg.c.a(this.aWn.getIntent().getBundleExtra("Ksnsupload_timeline")).nhM;
        this.mediaId = this.aWn.getIntent().getStringExtra("Ksnsupload_musicid");
        this.jFg = a.m(this.aWn.getIntent());
        this.bmJ = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.jGx = this.aWn.getIntent().getBooleanExtra("KThrid_app", false);
        this.jGy = this.aWn.getIntent().getBooleanExtra("KSnsAction", false);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return true;
    }

    final void aVS() {
        new ac(this.aWn.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ z jHh;

            {
                this.jHh = r1;
            }

            public final void run() {
                com.tencent.mm.ai.b.HB();
                this.jHh.iyR = false;
            }
        });
    }

    public final View aVz() {
        this.edj = q.em(this.aWn).inflate(2130904563, null);
        this.jFa = (CdnImageView) this.edj.findViewById(2131759412);
        this.dtB = (TextView) this.edj.findViewById(2131759414);
        this.jFb = (TextView) this.edj.findViewById(2131759415);
        this.edj.findViewById(2131757389).setVisibility(8);
        this.dtB.setText(this.jGz.title);
        if (this.jGz.thumbData != null) {
            this.jHg = d.bc(this.jGz.thumbData);
        }
        this.jFa.setImageBitmap(this.jHg);
        if (be.kS(this.jGz.description)) {
            this.jFb.setVisibility(8);
        } else {
            this.jFb.setText(this.jGz.description);
            this.jFb.setVisibility(0);
        }
        this.jHf = (ImageView) this.edj.findViewById(2131757389);
        this.jHf.setVisibility(0);
        if (com.tencent.mm.ai.b.HC() && this.iyR) {
            this.jHf.setImageResource(2130838733);
        } else {
            this.jHf.setImageResource(2130838735);
        }
        this.jHf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ z jHh;

            {
                this.jHh = r1;
            }

            public final void onClick(View view) {
                if (com.tencent.mm.ai.b.HC()) {
                    this.jHh.aVS();
                    return;
                }
                z zVar = this.jHh;
                if (zVar.jGz == null) {
                    v.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
                } else {
                    new ac(zVar.aWn.getMainLooper()).post(new Runnable(zVar) {
                        final /* synthetic */ z jHh;

                        {
                            this.jHh = r1;
                        }

                        public final void run() {
                            if (3 == this.jHh.jGz.getType()) {
                                this.jHh.iyR = true;
                                WXMusicObject wXMusicObject = (WXMusicObject) this.jHh.jGz.mediaObject;
                                String ah = be.ah(!be.kS(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                                String ah2 = be.ah(!be.kS(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                                if (be.kS(this.jHh.mediaId)) {
                                    this.jHh.mediaId = System.currentTimeMillis();
                                }
                                ajr com_tencent_mm_protocal_c_ajr = new ajr();
                                com_tencent_mm_protocal_c_ajr.mJV = 1;
                                com_tencent_mm_protocal_c_ajr.mJW = this.jHh.mediaId;
                                com_tencent_mm_protocal_c_ajr.mJX = 0.0f;
                                com_tencent_mm_protocal_c_ajr.mKa = "";
                                com_tencent_mm_protocal_c_ajr.mKg = null;
                                com_tencent_mm_protocal_c_ajr.mfh = 1;
                                com_tencent_mm_protocal_c_ajr.mKf = null;
                                com_tencent_mm_protocal_c_ajr.mJY = this.jHh.jGz.title;
                                com_tencent_mm_protocal_c_ajr.mJZ = this.jHh.jGz.description;
                                com_tencent_mm_protocal_c_ajr.mKe = ah;
                                com_tencent_mm_protocal_c_ajr.mKd = ah2;
                                com_tencent_mm_protocal_c_ajr.mKc = ah2;
                                com_tencent_mm_protocal_c_ajr.mfo = "";
                                com_tencent_mm_protocal_c_ajr.mKh = ad.xq();
                                com_tencent_mm_protocal_c_ajr.glj = this.jHh.bmJ;
                                com.tencent.mm.ai.b.b(com_tencent_mm_protocal_c_ajr);
                            }
                        }
                    });
                }
            }
        });
        i.b(this.jFa, this.aWn);
        return this.edj;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ad.aSA();
        au a = at.a(this.jGz, str, this.bmJ, this.appName);
        if (a == null) {
            v.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[]{this.bmJ, this.appName});
            return false;
        }
        pInt.value = a.job;
        if (i3 > com.tencent.mm.plugin.sns.b.a.jdC) {
            a.qk(4);
        }
        a.qo(this.jEZ);
        if (this.jGx) {
            a.qo(5);
        }
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List yv = m.yv();
            for (String str3 : list) {
                if (!yv.contains(str3)) {
                    axj com_tencent_mm_protocal_c_axj = new axj();
                    com_tencent_mm_protocal_c_axj.gln = str3;
                    linkedList.add(com_tencent_mm_protocal_c_axj);
                }
            }
        }
        a.Y(linkedList);
        if (iVar != null) {
            a.cE(iVar.token, iVar.mIu);
        }
        a.a(com_tencent_mm_protocal_c_agp);
        if (z) {
            a.qp(1);
        } else {
            a.qp(0);
        }
        a.bo(list2);
        a.d(null, null, null, i4, i5);
        if (this.jGy && this.jGz != null) {
            a.AH(this.jGz.mediaTagName);
            a.N(this.bmJ, this.jGz.messageExt, this.jGz.messageAction);
        }
        int commit = a.commit();
        if (this.jFg != null) {
            this.jFg.gj(commit);
            e.jtT.c(this.jFg);
        }
        ad.aSA().aTe();
        this.aWn.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        if (!(this.jHg == null || this.jHg.isRecycled())) {
            this.jHg.recycle();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        if (com.tencent.mm.ai.b.HC() && this.iyR) {
            aVS();
        }
        return com.tencent.mm.ai.b.HC();
    }
}
