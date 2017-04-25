package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class t {
    s ibD;

    public t() {
        ak.yW();
        String str = (String) c.vf().get(282625, "");
        try {
            this.ibD = new s();
            this.ibD.az(Base64.decode(str, 0));
        } catch (Throwable e) {
            v.a("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            v.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.ibD = new s();
        }
    }

    public final void yd(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            return;
        }
        for (int i = 0; i < this.ibD.hjx.size(); i++) {
            if (((r) this.ibD.hjx.get(i)).iav.equals(str)) {
                this.ibD.hjx.remove(i);
                break;
            }
        }
        save();
    }

    static void ye(String str) {
        at atVar = new at();
        atVar.cH("qqmail");
        atVar.z(aw.fN("qqmail"));
        atVar.di(0);
        atVar.setContent(String.format(aa.getContext().getString(2131234908), new Object[]{str}));
        atVar.setType(1);
        atVar.dh(3);
        ak.yW();
        v.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[]{Long.valueOf(c.wJ().R(atVar))});
    }

    final void save() {
        try {
            v.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[]{Base64.encodeToString(this.ibD.toByteArray(), 0)});
            ak.yW();
            c.vf().set(282625, r0);
        } catch (Throwable e) {
            v.a("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            v.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
        }
    }
}
