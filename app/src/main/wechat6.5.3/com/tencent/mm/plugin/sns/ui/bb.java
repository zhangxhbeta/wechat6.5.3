package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.at;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public final class bb implements w {
    private MMActivity aWn;
    private String appName = "";
    private String bmJ = "";
    private int jEZ;
    private a jFg = null;
    private boolean jGx = false;
    private boolean jGy = false;
    private WXMediaMessage jGz = null;
    private String jHt = "";

    public bb(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.jHt = this.aWn.getIntent().getStringExtra("Kdescription");
        this.bmJ = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = be.ah(this.aWn.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.jGx = this.aWn.getIntent().getBooleanExtra("KThrid_app", false);
        this.jGy = this.aWn.getIntent().getBooleanExtra("KSnsAction", false);
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.jGz = new c.a(this.aWn.getIntent().getBundleExtra("Ksnsupload_timeline")).nhM;
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return true;
    }

    public final View aVz() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ad.aSA();
        au a = at.a(this.jGz, str, this.bmJ, this.appName);
        if (a == null) {
            v.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[]{this.bmJ, this.appName});
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
        return false;
    }
}
