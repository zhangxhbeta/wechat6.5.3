package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class d {
    private HashMap<String, c> cJv;
    public String dzc;
    public String dzd;

    private static class a {
        private static d dze = new d();
    }

    private d() {
        this.cJv = new HashMap();
    }

    public final boolean ao(String str, String str2) {
        if (str2.equalsIgnoreCase("play")) {
            v.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[]{str, this.dzc});
            return true;
        }
        if (str.equalsIgnoreCase(this.dzc)) {
            ajr HE = b.HE();
            if (HE != null && HE.mJW.equals(this.dzd)) {
                return true;
            }
        }
        return false;
    }

    public final void a(c cVar, String str) {
        if (this.cJv.get(str) != null) {
            v.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.c.a.nhr.e(cVar);
        this.cJv.put(str, cVar);
    }

    public final void oL(String str) {
        if (this.cJv.get(str) == null) {
            v.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.c.a.nhr.f((c) this.cJv.remove(str));
    }
}
