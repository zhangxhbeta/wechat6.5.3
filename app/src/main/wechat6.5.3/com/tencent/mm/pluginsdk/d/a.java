package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.e.a.hv;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import java.util.ArrayList;

public abstract class a extends c<hv> {
    protected ArrayList<String> lyH;

    public abstract void w(b bVar);

    public a() {
        this.lyH = new ArrayList(3);
        this.nhz = hv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hv hvVar = (hv) bVar;
        if ((hvVar instanceof hv) && hvVar.bhI.bhJ != null && this.lyH.contains(hvVar.bhI.bhJ.getClass().getName())) {
            w(hvVar.bhI.bhJ);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.lyH.contains(str)) {
            aVar.lyH.add(str);
        }
        com.tencent.mm.sdk.c.a.nhr.e(aVar);
        e.Gk(str);
    }

    public static void b(String str, a aVar) {
        e.Gl(str);
        com.tencent.mm.sdk.c.a.nhr.f(aVar);
        if (aVar.lyH.contains(str)) {
            aVar.lyH.remove(str);
        }
    }
}
