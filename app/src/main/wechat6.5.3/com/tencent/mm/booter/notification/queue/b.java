package com.tencent.mm.booter.notification.queue;

import android.os.Build.VERSION;
import android.support.v4.app.ad;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue bZK;
    public a bZL;
    public int mark;

    private static final class a {
        private static final b bZM = new b();
    }

    public static final b qC() {
        return a.bZM;
    }

    private b() {
        this.mark = -1;
        this.bZK = new NotificationQueue();
        this.bZL = new a();
        restore();
    }

    public final void restore() {
        this.bZK.restore();
        this.bZL.restore();
    }

    public final int size() {
        NotificationQueue notificationQueue = this.bZK;
        if (notificationQueue.bZJ == null) {
            notificationQueue.restore();
        }
        return notificationQueue.bZJ.size();
    }

    public final NotificationItem qD() {
        for (int i = 0; i < size(); i++) {
            NotificationQueue notificationQueue = this.bZK;
            if (notificationQueue.bZJ == null) {
                notificationQueue.restore();
            }
            NotificationItem notificationItem = (NotificationItem) notificationQueue.bZJ.get(i);
            if (notificationItem.bZB) {
                if (this.bZL.aM(notificationItem.id)) {
                    v.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.bZK.c(notificationItem);
                return notificationItem;
            }
        }
        return null;
    }

    public final void remove(int i) {
        this.bZL.aM(i);
        NotificationItem dF = this.bZK.dF(i);
        if (dF != null) {
            dF.clear();
        }
    }

    public final Queue<Integer> qE() {
        Queue<Integer> linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(qF());
        return linkedList;
    }

    private Queue<Integer> qF() {
        Queue<Integer> linkedList = new LinkedList();
        Queue<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.bZK;
        if (notificationQueue.bZJ == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.bZJ);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.bZB) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                v.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.id));
            }
        }
        linkedList2.clear();
        Queue<com.tencent.mm.booter.notification.queue.a.a> linkedList3 = new LinkedList();
        a aVar = this.bZL;
        if (aVar.bZG == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.bZG);
        for (com.tencent.mm.booter.notification.queue.a.a aVar2 : linkedList3) {
            if (aVar2.bZB) {
                linkedList.add(Integer.valueOf(aVar2.bZH));
                v.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(aVar2.bZH));
            }
        }
        linkedList3.clear();
        return linkedList;
    }

    public final int getId(String str) {
        if (t.kS(str)) {
            return -1;
        }
        Iterator it = this.bZL.iterator();
        while (it.hasNext()) {
            com.tencent.mm.booter.notification.queue.a.a aVar = (com.tencent.mm.booter.notification.queue.a.a) it.next();
            if (aVar.userName.equals(str)) {
                return aVar.bZH;
            }
        }
        return -1;
    }

    public final void cancel(int i) {
        a(ad.h(aa.getContext()), i);
    }

    public final void a(ad adVar, int i) {
        ad.sH.a(adVar.sF, null, i);
        if (VERSION.SDK_INT <= 19) {
            adVar.a(new a(adVar.mContext.getPackageName(), i, null));
        }
        remove(i);
    }

    public final int de(String str) {
        int id = getId(str);
        return id > 0 ? id : as(true);
    }

    public final int as(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = SQLiteDatabase.KeyEmpty;
        Iterator it = this.bZL.iterator();
        String str2 = str;
        while (it.hasNext()) {
            str2 = str2 + ((com.tencent.mm.booter.notification.queue.a.a) it.next()).bZH + ",";
        }
        int i = z ? 4097 : 4102;
        while (str2.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        v.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        NotificationQueue notificationQueue = this.bZK;
        if (notificationQueue.bZJ == null) {
            notificationQueue.restore();
        }
        return notificationQueue.bZJ.iterator();
    }
}
