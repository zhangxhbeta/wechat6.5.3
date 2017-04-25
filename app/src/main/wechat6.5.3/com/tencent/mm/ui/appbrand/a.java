package com.tencent.mm.ui.appbrand;

import android.content.Context;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class a {
    public static void i(final Context context, final String str, final boolean z) {
        int i = 1;
        b pzVar = new pz();
        pzVar.brl.aWH = str;
        pzVar.brl.action = z ? 2 : 1;
        pzVar.brl.brn = 2;
        com.tencent.mm.sdk.c.a.nhr.z(pzVar);
        LinkedList linkedList = new LinkedList();
        ayy com_tencent_mm_protocal_c_ayy = new ayy();
        com_tencent_mm_protocal_c_ayy.mWa = str;
        if (!z) {
            i = 0;
        }
        com_tencent_mm_protocal_c_ayy.mVZ = i;
        com_tencent_mm_protocal_c_ayy.efm = 3;
        linkedList.add(com_tencent_mm_protocal_c_ayy);
        ak.vy().a(1176, new e() {
            public final void a(int i, int i2, String str, k kVar) {
                int i3 = 1;
                ak.vy().b(1176, (e) this);
                v.d("MicroMsg.AppBrandHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                if (i != 0 || i2 != 0) {
                    s.makeText(context, 2131234125, 0).show();
                    b pzVar = new pz();
                    pzVar.brl.aWH = str;
                    com.tencent.mm.e.a.pz.a aVar = pzVar.brl;
                    if (!z) {
                        i3 = 2;
                    }
                    aVar.action = i3;
                    pzVar.brl.brn = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                }
            }
        });
        ak.vy().a(new d(linkedList), 0);
    }
}
