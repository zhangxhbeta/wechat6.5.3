package com.tencent.mm.plugin.safedevice.a;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import java.util.LinkedList;
import java.util.List;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "SafeDeviceInfo")};
    g iuw = null;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((c) cVar);
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "SafeDeviceInfo", null);
        if (dVar instanceof g) {
            this.iuw = (g) dVar;
        }
    }

    public final boolean a(c cVar) {
        return super.b(cVar);
    }

    public final List<c> aKF() {
        List<c> linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor Kp = super.Kp();
            while (Kp.moveToNext()) {
                c cVar = new c();
                cVar.b(Kp);
                linkedList.add(cVar);
            }
            Kp.close();
        }
        return linkedList;
    }

    public final void aKG() {
        long auU;
        if (this.iuw != null) {
            auU = this.iuw.auU();
        } else {
            auU = 0;
        }
        List<c> aKF = aKF();
        if (aKF.size() > 0) {
            for (c c : aKF) {
                c(c, new String[0]);
            }
        }
        if (this.iuw != null) {
            this.iuw.es(auU);
        }
    }
}
