package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.e.a.ly;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends c<ly> {
    public d() {
        this.nhz = ly.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ly lyVar = (ly) bVar;
        if (lyVar instanceof ly) {
            if (lyVar.bnd.bao == 0) {
                com.tencent.mm.plugin.emoji.model.c afr = g.afr();
                long j = lyVar.bnd.bng;
                afr.fcJ.put(Long.valueOf(j), lyVar.bnd.bne);
            } else {
                v.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        return false;
    }
}
