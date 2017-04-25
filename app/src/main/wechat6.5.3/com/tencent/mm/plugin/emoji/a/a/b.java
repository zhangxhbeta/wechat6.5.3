package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.model.f.a;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static void a(c cVar, a aVar) {
        if (k.xS() && cVar != null && cVar.size() > 0 && aVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.fah == f.a.faq)) {
                    ol olVar = fVar.fai;
                    boolean b = e.b(olVar);
                    boolean a = e.a(olVar);
                    if (!(b || a)) {
                        arrayList.add(olVar.mdM);
                        ah rb = cVar.rb(olVar.mdM);
                        if (rb != null) {
                            rb.nvd = 11;
                        }
                    }
                }
            }
            Context context = aa.getContext();
            if (arrayList.size() > 0) {
                f.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
        }
    }

    public static void a(ArrayList<o> arrayList, c cVar) {
        if (k.xS() && cVar != null && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o oVar = (o) it.next();
                if (oVar != null) {
                    ah rb = cVar.rb(oVar.aZD);
                    if (rb != null) {
                        int i;
                        if (oVar.lzM == 10232) {
                            rb.nvf = oVar.lzJ;
                            rb.nvd = 12;
                            i = rb.nvb;
                            if (!(jI(i) || jJ(i))) {
                                rb.ve(4);
                            }
                        } else {
                            rb.nvd = 10;
                            rb.nve = oVar.lzM;
                            i = rb.nvb;
                            if (!(jI(i) || jJ(i))) {
                                if ((i == 3 ? 1 : null) == null) {
                                    rb.ve(10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean jI(int i) {
        return i == 7;
    }

    private static boolean jJ(int i) {
        return i == 6;
    }
}
