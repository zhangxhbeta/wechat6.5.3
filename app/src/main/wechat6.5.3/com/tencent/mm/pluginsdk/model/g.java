package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public final class g implements s {
    public static boolean lze = false;
    private static g lzf;
    public a lzg;

    public interface a {
        void a(k kVar);
    }

    public static class b {
        public String lzh;
    }

    private g() {
    }

    public static g bmQ() {
        if (lzf == null) {
            lzf = new g();
        }
        return lzf;
    }

    public final void bmR() {
        if (ak.uz()) {
            am.ash().a(14, (s) this);
            lze = true;
        }
    }

    public final void a(int i, int i2, String str, v vVar) {
        if (ak.uz()) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (vVar == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (vVar.getType()) {
                    case 14:
                        if (aa.getContext() == null || com.tencent.mm.pluginsdk.j.a.lxJ == null) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i), Integer.valueOf(i2));
                        k kVar = (k) vVar;
                        if (this.lzg != null) {
                            this.lzg.a(kVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static b Gp(String str) {
        if (str == null) {
            return null;
        }
        Map q = bf.q(str, "PersonalAppSetting");
        if (q == null) {
            return null;
        }
        String str2 = (String) q.get(".PersonalAppSetting.OpenID");
        if (be.kS(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.lzh = str2;
        return bVar;
    }
}
