package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.List;

public final class d extends n {
    private String biB;
    private List<String> dum = ak.yW().wO().LF(this.biB);

    public d(l lVar, String str) {
        super(lVar, null, true, true);
        this.biB = str;
        v.i("MicroMsg.AASelectInitAdapter", "resetData");
        if (this.dum == null) {
            this.dum = new ArrayList();
        }
    }

    protected final a gK(int i) {
        String str = (String) this.dum.get(i);
        ak.yW();
        u LX = c.wH().LX(str);
        c cVar = new c(i);
        cVar.aYF = this.biB;
        cVar.euW = LX;
        cVar.oHa = true;
        return cVar;
    }

    public final int getCount() {
        return this.dum.size();
    }
}
