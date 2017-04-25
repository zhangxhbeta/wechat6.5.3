package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.List;

public final class a extends n {
    private String biB;
    private List<String> dum = ak.yW().wO().LF(this.biB);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        this.biB = str;
        v.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        if (this.dum == null) {
            this.dum = new ArrayList();
        }
    }

    protected final com.tencent.mm.ui.contact.a.a gK(int i) {
        String str = (String) this.dum.get(i);
        ak.yW();
        u LX = c.wH().LX(str);
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.euW = LX;
        aVar.oHa = aQk();
        return aVar;
    }

    public final int getCount() {
        return this.dum.size();
    }
}
