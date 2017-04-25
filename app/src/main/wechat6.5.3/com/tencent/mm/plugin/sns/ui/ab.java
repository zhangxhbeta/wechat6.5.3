package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public final class ab implements w {
    private MMActivity aWn;
    private String appName = "";
    private String bmJ = "";
    private int jEZ;
    private a jFg = null;
    private boolean jGx = false;
    private boolean jGy = false;
    private WXMediaMessage jGz = null;
    private String jHt = "";
    private boolean jHu = false;

    public ab(MMActivity mMActivity, boolean z) {
        this.aWn = mMActivity;
        this.jHu = z;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.jHt = this.aWn.getIntent().getStringExtra("Kdescription");
        this.bmJ = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.jGx = this.aWn.getIntent().getBooleanExtra("KThrid_app", false);
        this.jGy = this.aWn.getIntent().getBooleanExtra("KSnsAction", false);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.aWn.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.jGz = new c.a(bundleExtra).nhM;
        }
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return this.jHu;
    }

    public final View aVz() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.aWn.isFinishing()) {
            return false;
        }
        au auVar = new au(2);
        pInt.value = auVar.job;
        if (i3 > com.tencent.mm.plugin.sns.b.a.jdC) {
            auVar.qk(2);
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
        if (z) {
            auVar.qp(1);
        } else {
            auVar.qp(0);
        }
        if (iVar != null) {
            auVar.cE(iVar.token, iVar.mIu);
        }
        auVar.qo(this.jEZ);
        if (this.jGx) {
            auVar.qo(5);
        }
        if (this.jGy && this.jGz != null) {
            auVar.AH(this.jGz.mediaTagName);
            auVar.N(this.bmJ, this.jGz.messageExt, this.jGz.messageAction);
        }
        auVar.d(null, null, null, i4, i5);
        auVar.AG(str).a(com_tencent_mm_protocal_c_agp).Y(linkedList).qm(i).qn(i2).bo(list2);
        int commit = auVar.commit();
        if (this.jFg != null) {
            this.jFg.gj(commit);
            e.jtT.c(this.jFg);
        }
        this.aWn.setResult(-1);
        ad.aSA().aTe();
        this.aWn.finish();
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        return false;
    }
}
