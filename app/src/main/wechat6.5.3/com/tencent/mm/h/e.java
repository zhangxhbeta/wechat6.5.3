package com.tencent.mm.h;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.g;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class e implements h, g {
    private f cgR = new f();
    private c cgS = new c();

    public final f sU() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.cgR;
    }

    public final c sV() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.cgS;
    }

    public final void a(a aVar) {
    }

    public final void a(a aVar, boolean z) {
        if (z) {
            c cVar = this.cgS;
            File file = new File(com.tencent.mm.compatible.util.e.cnj + "configlist/");
            if (file.exists()) {
                File file2 = new File(c.cgM);
                if (!file2.exists()) {
                    v.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar.renameTo(file, file2);
                }
            }
        }
        this.cgR.sW();
        this.cgS.init();
    }
}
