package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.f.a.a.a;
import com.tencent.mm.ui.f.a.a.b;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;

public final class d extends b {
    public o iIT;

    public d(int i) {
        super(i);
    }

    public final void a(Context context, a aVar) {
        CharSequence KU;
        boolean z;
        Object obj;
        Object string;
        boolean z2;
        boolean z3;
        this.username = this.eAt.cWv;
        ak.yW();
        this.euW = c.wH().LX(this.username);
        this.iIT = new o();
        ah.FT().b(this.eAt.cWu, this.iIT);
        if (TextUtils.isEmpty(this.iIT.field_googlename)) {
            KU = be.KU(this.iIT.field_googlegmail);
        } else {
            KU = this.iIT.field_googlename;
        }
        switch (this.eAt.cWt) {
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                z = false;
                obj = this.iIT.field_googlegmail;
                string = context.getString(2131234833);
                z2 = true;
                z3 = false;
                break;
            case bv.CTRL_INDEX /*27*/:
                z3 = false;
                break;
            case p.CTRL_INDEX /*28*/:
                z3 = true;
                break;
            default:
                z2 = false;
                z = false;
                CharSequence charSequence = null;
                CharSequence charSequence2 = null;
                z3 = false;
                break;
        }
        obj = this.iIT.field_googlegmail;
        string = context.getString(2131234833);
        z2 = false;
        z = true;
        if (z) {
            this.eAu = e.a(context, KU, h.cVN);
            if (z3) {
                this.eAu = h.a(this.eAu, this.ezU, false, this.bkC);
            } else {
                this.eAu = h.a(context, this.eAu, this.ezU);
            }
        } else {
            this.eAu = e.a(context, KU, h.cVN);
        }
        if (z2) {
            this.eAv = e.a(context, charSequence, h.cVN);
            if (z3) {
                this.eAv = h.a(this.eAv, this.ezU, false, this.bkC);
            } else {
                this.eAv = h.a(context, this.eAv, this.ezU);
            }
            this.eAv = TextUtils.concat(new CharSequence[]{charSequence2, this.eAv});
        }
    }

    public final b YL() {
        return null;
    }
}
