package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.le;
import com.tencent.mm.plugin.sns.e.y;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends c<le> {
    public h() {
        this.nhz = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        le leVar = (le) bVar;
        if (leVar instanceof le) {
            if (leVar.bmz.state == 0) {
                v.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                y.gTV = true;
                y yVar = new y();
                yVar.jkZ = System.currentTimeMillis();
                if (!yVar.jkY) {
                    new a(yVar).l("");
                }
            } else {
                v.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                y.gTV = false;
            }
            return true;
        }
        v.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        return false;
    }
}
