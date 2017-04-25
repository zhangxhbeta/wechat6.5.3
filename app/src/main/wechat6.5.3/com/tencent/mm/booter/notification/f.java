package com.tencent.mm.booter.notification;

import com.tencent.mm.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public e bZE;

    private static class a {
        private static final f bZF = new f();
    }

    private f() {
        this.bZE = new e();
    }

    public final boolean a(String str, at atVar, int i, boolean z) {
        if (be.kS(str)) {
            return false;
        }
        return c.a(str, atVar, i, z);
    }

    public final int a(NotificationItem notificationItem) {
        return this.bZE.a(notificationItem, null);
    }

    public final void k(int i, String str) {
        ArrayList arrayList;
        v.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i), str);
        if (i == -1) {
            i = i.td();
        }
        c.dC(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List tc = i.tc();
            if (tc == null) {
                tc = new ArrayList();
            }
            for (String str2 : r0) {
                a aVar = new a();
                aVar.userName = str2;
                aVar.bZj = i.dC(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList qy = c.qy();
            arrayList = qy == null ? new ArrayList() : qy;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a();
            }
            aVar2.userName = str;
            aVar2.bZj = i.dC(str);
            if (aVar2.bZj == 0 && arrayList.isEmpty()) {
                c.d(null);
                return;
            } else if (aVar2.bZj > 0) {
                arrayList.add(aVar2);
            }
        }
        c.d(arrayList);
    }
}
