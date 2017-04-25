package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.as;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.j;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class c extends com.tencent.mm.sdk.c.c<as> {
    public c() {
        this.nhz = as.class.getName().hashCode();
    }

    private static boolean a(as asVar) {
        if (asVar.aYs.aYo == 37) {
            if (asVar.aYs.aYp == 5 && asVar.aYs.aYt == 2) {
                j aff = j.aff();
                v.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xp()).append("eggingfo.ini").toString());
                    e.e(new File(j.afg(), j.fbm));
                } catch (Throwable e) {
                    v.a("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                aff.fbD = null;
            }
            if (asVar.aYs.aYt == 0) {
                v.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[]{Integer.valueOf(asVar.aYs.aYo), Integer.valueOf(asVar.aYs.aYp)});
            }
        }
        return false;
    }
}
