package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.LinkedList;
import java.util.List;

public final class l implements w {
    private MMActivity aWn;
    private String appId = "";
    private String appName = "";
    private String bhr = "";
    private String bnR;
    private String cZp = "";
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
    private int jFd;
    private String jFe = "";
    private String jFf = "";
    private a jFg = null;
    private String title = "";
    private int w = -1;

    public l(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.w = this.aWn.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.aWn.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.cZp = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.jEW = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.bhr = this.aWn.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.jFc = this.aWn.getIntent().getBooleanExtra("ksnsis_video", false);
        this.bnR = be.ah(this.aWn.getIntent().getStringExtra("src_username"), "");
        this.jEY = be.ah(this.aWn.getIntent().getStringExtra("src_displayname"), "");
        this.jFf = be.ah(this.aWn.getIntent().getStringExtra("KContentObjDesc"), "");
        this.jFe = be.ah(this.aWn.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.jFd = this.aWn.getIntent().getIntExtra("KUploadProduct_subType", 0);
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return true;
    }

    public final View aVz() {
        this.edj = q.em(this.aWn).inflate(2130904562, null);
        this.jFa = (CdnImageView) this.edj.findViewById(2131759412);
        this.dtB = (TextView) this.edj.findViewById(2131759414);
        this.jFb = (TextView) this.edj.findViewById(2131759415);
        if (this.jFc) {
            this.edj.findViewById(2131757389).setVisibility(0);
        } else {
            this.edj.findViewById(2131757389).setVisibility(8);
        }
        this.dtB.setText(this.title);
        if (!be.kS(this.jEW)) {
            this.jFa.setVisibility(0);
            this.jFa.G(this.jEW, 0, 0);
        } else if (be.bl(this.jEX)) {
            this.jFa.setVisibility(8);
        } else {
            this.jFa.setVisibility(0);
            this.cxY = d.bc(this.jEX);
            this.jFa.setImageBitmap(this.cxY);
        }
        i.b(this.jFa, this.aWn);
        return this.edj;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        au auVar = new au(17);
        pInt.value = auVar.job;
        if (i3 > com.tencent.mm.plugin.sns.b.a.jdC) {
            auVar.qk(2);
        }
        if (iVar != null) {
            auVar.cE(iVar.token, iVar.mIu);
        }
        auVar.AL(this.title).AJ(this.jFf).AK(this.cZp).AG(str);
        boolean z2 = false;
        if (!be.kS(this.bhr)) {
            z2 = auVar.a(FileOp.c(this.bhr, 0, -1), this.jFf, this.title, this.jFd, this.jFe);
        } else if (!(be.kS(this.jEW) || n.GG() == null)) {
            n.GG();
            Bitmap gu = b.gu(this.jEW);
            if (gu != null) {
                z2 = auVar.a(d.F(gu), this.jFf, this.title, this.jFd, this.jFe);
            }
        }
        if (!z2) {
            v.i("MicroMsg.EmojiDesignerShareWidget", "set userData user imgurl ");
            z2 = auVar.a(this.jEW, this.jEW, this.jFf, this.jFd, this.jFe);
        }
        if (!z2) {
            v.e("MicroMsg.EmojiDesignerShareWidget", "set userData faild");
        }
        auVar.qo(this.jEZ);
        auVar.AO(this.bnR);
        auVar.AP(this.jEY);
        auVar.d(null, null, null, i4, i5);
        if (z) {
            auVar.qp(1);
        } else {
            auVar.qp(0);
        }
        auVar.bo(list2);
        if (!be.kS(this.appId)) {
            auVar.AM(this.appId);
            auVar.AN(this.appName);
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
        auVar.Y(linkedList);
        auVar.a(com_tencent_mm_protocal_c_agp);
        int commit = auVar.commit();
        if (this.jFg != null) {
            this.jFg.gj(commit);
            e.jtT.c(this.jFg);
        }
        ad.aSA().aTe();
        this.aWn.finish();
        j.a.bmr().rp(this.jFe);
        j.a.bmr().rq(this.jFe);
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        if (!(this.cxY == null || this.cxY.isRecycled())) {
            this.cxY.recycle();
        }
        return false;
    }
}
