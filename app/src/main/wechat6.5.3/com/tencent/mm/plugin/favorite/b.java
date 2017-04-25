package com.tencent.mm.plugin.favorite;

import com.tencent.mm.e.a.bm;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends c<bm> {
    public b() {
        this.nhz = bm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        bm bmVar = (bm) bVar;
        v.i("MicroMsg.DelFavoriteItemListener", "do delete favitem, localId %d", new Object[]{Long.valueOf(bmVar.aYY.aZa)});
        bmVar.aYZ.aYN = com.tencent.mm.plugin.favorite.b.v.a(bmVar.aYY.aZa, null);
        return false;
    }
}
