package com.tencent.mm.kiss.widget.textview;

import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    public static c clL = new c();
    public ConcurrentHashMap<Integer, b> clM = new ConcurrentHashMap();

    public final void a(a aVar, f fVar) {
        if (aVar != null) {
            b bVar = (b) this.clM.get(Integer.valueOf(aVar.hashCode()));
            if (bVar != null) {
                bVar.a(fVar);
                this.clM.put(Integer.valueOf(aVar.hashCode()), bVar);
                return;
            }
            bVar = new b();
            bVar.a(fVar);
            this.clM.put(Integer.valueOf(aVar.hashCode()), bVar);
        }
    }

    public final f a(a aVar, CharSequence charSequence) {
        if (aVar != null) {
            b bVar = (b) this.clM.get(Integer.valueOf(aVar.hashCode()));
            if (bVar != null) {
                return bVar.n(charSequence);
            }
        }
        return null;
    }

    public final void vK() {
        for (b bVar : this.clM.values()) {
            bVar.clK.clear();
        }
        this.clM.clear();
    }

    public static int a(a aVar) {
        return aVar.hashCode();
    }
}
