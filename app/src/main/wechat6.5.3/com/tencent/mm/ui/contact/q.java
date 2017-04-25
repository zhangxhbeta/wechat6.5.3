package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.p.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class q extends p {
    private String bkC;
    private ac handler = new ac(Looper.getMainLooper());
    private Map<String, String> oHG = new HashMap();
    private List<String> oHH = new ArrayList();
    private List<String> oHq;
    private a oHr;

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        this.oHq = list;
        if (!be.kS(str)) {
            this.oHH = be.g(str.split(","));
            if (this.oHH != null) {
                for (String str2 : this.oHH) {
                    String er = l.er(str2);
                    if (!be.kS(er)) {
                        this.oHG.put(er, str2);
                    }
                }
            }
        }
        NH();
    }

    public final void a(a aVar) {
        this.oHr = aVar;
    }

    public final void aR(String str, boolean z) {
        if (this.oHr != null) {
            this.oHr.n(str, getCount(), z);
        }
    }

    private void NH() {
        this.bkC = null;
        clearCache();
    }

    public final int getCount() {
        return this.oHH == null ? 0 : this.oHH.size();
    }

    protected final com.tencent.mm.ui.contact.a.a gK(int i) {
        com.tencent.mm.ui.contact.a.a dVar = new d(i);
        dVar.bkC = this.bkC;
        ak.yW();
        dVar.euW = c.wH().LV((String) this.oHH.get(i));
        dVar.oHa = aQk();
        return dVar;
    }

    public final void finish() {
        super.finish();
        NH();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
