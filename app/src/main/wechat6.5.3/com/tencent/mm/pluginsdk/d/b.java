package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.e.a.il;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import java.util.ArrayList;

public abstract class b extends c<il> {
    protected ArrayList<String> lyH;

    public abstract void a(int i, int i2, String str, com.tencent.mm.sdk.c.b bVar);

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        il ilVar = (il) bVar;
        if ((ilVar instanceof il) && ilVar.biR.biT != null && this.lyH.contains(ilVar.biR.biT.getClass().getName())) {
            a(ilVar.biR.errType, ilVar.biR.errCode, ilVar.biR.biS, ilVar.biR.biT);
        }
        return false;
    }

    public b(int i) {
        super(0);
        this.lyH = new ArrayList(3);
        this.nhz = il.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.lyH.contains(str)) {
            bVar.lyH.add(str);
        }
        a.nhr.e(bVar);
        e.Gk(str);
    }

    public static void b(String str, b bVar) {
        e.Gl(str);
        a.nhr.f(bVar);
        if (bVar.lyH.contains(str)) {
            bVar.lyH.remove(str);
        }
    }
}
