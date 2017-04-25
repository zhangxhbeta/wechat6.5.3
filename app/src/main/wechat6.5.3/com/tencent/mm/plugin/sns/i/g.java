package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.modelsns.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Vector;

public abstract class g {
    private Vector<a> jtU = new Vector();

    public final a b(a aVar) {
        this.jtU.add(aVar);
        return aVar;
    }

    public final boolean c(a aVar) {
        boolean z;
        Iterator it = this.jtU.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (aVar2.cZF == aVar.cZF) {
                this.jtU.remove(aVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.jtU.add(aVar);
        return z;
    }

    public final a aX(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.jtU.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (obj.equals(aVar.cZC)) {
                    this.jtU.remove(aVar);
                    return aVar;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
