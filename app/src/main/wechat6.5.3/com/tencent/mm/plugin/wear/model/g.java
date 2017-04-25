package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class g {
    private static int lbH = 0;
    private HashMap<String, f> lbI = new HashMap();

    public final synchronized f DH(String str) {
        f fVar;
        if (this.lbI.containsKey(str)) {
            fVar = (f) ((f) this.lbI.get(str)).clone();
        } else {
            lbH++;
            fVar = new f();
            fVar.bdo = str;
            fVar.id = lbH;
            fVar.lbB = a.INIT;
            this.lbI.put(str, fVar);
            fVar = (f) fVar.clone();
        }
        return fVar;
    }

    public final synchronized void DI(String str) {
        v.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[]{str});
        if (this.lbI.containsKey(str)) {
            ((f) this.lbI.get(str)).lbB = a.INIT;
            ((f) this.lbI.get(str)).lbA = 0;
        }
    }

    public final synchronized void a(f fVar) {
        v.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[]{fVar});
        this.lbI.put(fVar.bdo, fVar);
    }

    public final synchronized void DJ(String str) {
        if (this.lbI.containsKey(str)) {
            f fVar = (f) this.lbI.get(str);
            fVar.lbB = a.REPLY;
            fVar.lbA = 0;
            v.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void bj(String str, int i) {
        if (this.lbI.containsKey(str)) {
            f fVar = (f) this.lbI.get(str);
            fVar.lbB = a.IGNORE;
            fVar.lbA = i;
            v.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void DK(String str) {
        if (this.lbI.containsKey(str)) {
            ((f) this.lbI.get(str)).lbB = a.SHOWING;
            v.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[]{r0});
        }
    }
}
