package com.tencent.mm.storage.a;

import com.tencent.mm.bg.f.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class h extends f<g> implements a {
    public static final String[] cic = new String[]{f.a(g.chq, "EmojiSuggestDescInfo")};
    private d cie;

    public h(d dVar) {
        this(dVar, g.chq, "EmojiSuggestDescInfo");
    }

    private h(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean aa(ArrayList<ArrayList<String>> arrayList) {
        if (arrayList.isEmpty()) {
            v.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
        } else {
            long er;
            g gVar;
            if (this.cie instanceof g) {
                g gVar2 = (g) this.cie;
                er = gVar2.er(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                er = -1;
                gVar = null;
            }
            this.cie.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                ArrayList arrayList2 = (ArrayList) it.next();
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    i2 = i;
                } else {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!be.kS(str)) {
                            v.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[]{String.valueOf(i), str});
                            b(new g(String.valueOf(i), str));
                        }
                    }
                    i2 = i + 1;
                }
                i = i2;
            }
            if (gVar != null) {
                gVar.es(er);
            }
        }
        return false;
    }
}
