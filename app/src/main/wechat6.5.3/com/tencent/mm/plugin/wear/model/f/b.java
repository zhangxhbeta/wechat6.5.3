package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.at;

public abstract class b extends c {
    protected final String b(String str, at atVar) {
        if (m.dE(str)) {
            String c = c(str, atVar);
            return String.format(aa.getContext().getString(2131234089), new Object[]{h.DM(c), Character.valueOf('​'), h.H(atVar).hQP});
        }
        return String.format(aa.getContext().getString(2131234090), new Object[]{h.H(atVar).hQP});
    }

    protected static String c(String str, at atVar) {
        if (!m.dE(str)) {
            return str;
        }
        int fK = aw.fK(atVar.field_content);
        if (fK == -1) {
            return str;
        }
        String trim = atVar.field_content.substring(0, fK).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
