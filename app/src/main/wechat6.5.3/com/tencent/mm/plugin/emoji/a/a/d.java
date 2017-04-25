package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.List;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(e eVar) {
        super(eVar);
    }

    public final synchronized void notifyDataSetChanged() {
        List<a> bxC = g.afx().fci.bxC();
        boolean agV = com.tencent.mm.plugin.emoji.h.a.agV();
        this.mItemList = new ArrayList();
        v.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (a bxk : bxC) {
            ol bxk2 = bxk.bxk();
            f fVar = new f(bxk2);
            if (com.tencent.mm.plugin.emoji.h.a.d(bxk2) && agV) {
                this.fae.put(bxk2.mdM, new ah(bxk2.mdM));
            }
            fVar.dh(9);
            this.mItemList.add(fVar);
        }
    }

    public final void clear() {
        super.clear();
    }

    public final void aeO() {
    }
}
