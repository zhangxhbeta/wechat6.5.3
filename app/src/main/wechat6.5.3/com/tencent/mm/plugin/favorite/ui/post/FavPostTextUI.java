package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.l;
import com.tencent.mm.plugin.favorite.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class FavPostTextUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return 2130903595;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232703);
    }

    protected final void s(CharSequence charSequence) {
        if (charSequence == null || be.kS(charSequence.toString())) {
            v.w("MicroMsg.MMTextInputUI", "text is null");
            return;
        }
        String charSequence2 = charSequence.toString();
        if (be.kS(charSequence2) || charSequence2.trim().length() == 0) {
            v.e("MicroMsg.FavPostLogic", "postText text null");
            return;
        }
        i iVar = new i();
        iVar.field_type = 1;
        iVar.field_sourceType = 6;
        iVar.field_favProto.Jm(charSequence2);
        l.f(iVar);
        a.u(iVar);
        g.iuh.h(10648, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
    }
}
