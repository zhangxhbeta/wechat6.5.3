package com.tencent.mm.plugin.favorite;

import com.tencent.mm.a.n;
import com.tencent.mm.e.a.ey;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ab;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends c<ey> {
    public e() {
        this.nhz = ey.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ey eyVar = (ey) bVar;
        v.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (h.alk().aVu) {
            v.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
        } else {
            byte[] bArr = eyVar.bdO.bdP;
            ak.vy().a(new ab(bArr == null ? 1 : n.c(bArr, 0)), 0);
        }
        return false;
    }
}
