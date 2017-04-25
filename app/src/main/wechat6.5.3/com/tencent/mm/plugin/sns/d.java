package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.gr;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.s;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends c<gr> {
    public d() {
        this.nhz = gr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((gr) bVar) instanceof gr) {
            ak.vy().a(new s(), 0);
            return true;
        }
        v.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        return false;
    }
}
