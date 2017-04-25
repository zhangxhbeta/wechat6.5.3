package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

public final class f extends c<ar> {
    public f() {
        this.nhz = ar.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ar arVar = (ar) bVar;
        if (arVar.aYn.aYo == 38) {
            String str = arVar.aYn.filePath;
            if (!be.kS(str) || e.aR(str)) {
                boolean z;
                String Pz = Pz();
                if (e.aR(Pz)) {
                    String aX = g.aX(str);
                    z = (be.kS(aX) || aX.equals(g.aX(Pz))) ? false : true;
                } else {
                    z = true;
                }
                if (z) {
                    j.dz(str, Pz);
                }
            }
        }
        return true;
    }

    static String Pz() {
        File file = new File(com.tencent.mm.compatible.util.e.cnh.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "AppService.conf").getAbsolutePath();
    }
}
