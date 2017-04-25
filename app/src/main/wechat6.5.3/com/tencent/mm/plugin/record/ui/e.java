package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.plugin.record.ui.a.b;

public final class e extends h implements a {
    public e(Context context, h.a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        this.iqk = aVar;
        this.ipS.clear();
        this.ipS.addAll(aVar.ipS);
        notifyDataSetChanged();
    }

    public final void b(b bVar) {
        bVar.aKG = 0;
        bVar.bao = ((f) this.iqk).bao;
        bVar.bmh = ((f) this.iqk).bmh;
    }

    public final void a(int i, g gVar) {
        aJQ();
    }
}
