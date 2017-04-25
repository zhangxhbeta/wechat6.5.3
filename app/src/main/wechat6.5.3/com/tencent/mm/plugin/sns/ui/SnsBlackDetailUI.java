package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements b, e {
    public final void aWw() {
        v.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        ak.yW();
        c.wH().a(this);
    }

    protected final void aWx() {
        v.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        if (ak.uz()) {
            ak.yW();
            c.wH().b(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    }

    public void onDestroy() {
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        ak.vy().b(290, this);
        ak.vy().b(291, this);
        ak.vy().b(292, this);
        ak.vy().b(293, this);
        if (ak.uz()) {
            ak.yW();
            c.wH().b(this);
        }
        super.onDestroy();
    }

    protected final void aWy() {
    }

    protected final void axe() {
        if ((this.jTD + " " + be.b(this.jTC, ",")).equals(this.aZy) && this.jkF != 0) {
            finish();
        } else if (ad.aSI().j(this.jkF, this.jTD)) {
            g.A(this, getString(2131235525, new Object[]{this.jTD}), getString(2131231164));
        } else {
            List<String> aWz = aWz();
            List<String> linkedList = new LinkedList();
            List<String> linkedList2 = new LinkedList();
            for (String str : aWz) {
                if (!this.jTC.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.jTC) {
                if (!aWz.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str22 : linkedList) {
                m.k(str22, false);
            }
            for (String str222 : linkedList2) {
                m.k(str222, true);
            }
            a.drq.ow();
            finish();
        }
    }

    protected final List<String> aWz() {
        List<String> linkedList = new LinkedList();
        if (this.jkF != 4) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        return m.yv();
    }

    protected final void qM(String str) {
        super.qM(str);
    }

    protected final void bx(List<String> list) {
        aa aSs = ad.aSs();
        String xF = k.xF();
        for (String str : list) {
            if (!(this.jTC.contains(str) || !com.tencent.mm.i.a.ei(aSs.LX(str).field_type) || xF.equals(str))) {
                this.jTC.add(str);
            }
        }
        if (this.ePg != null) {
            this.ePg.aH(this.jTC);
        }
        adg();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
    }
}
