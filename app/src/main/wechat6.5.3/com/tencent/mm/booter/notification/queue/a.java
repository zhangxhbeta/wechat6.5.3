package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> bZG;

    public static class a implements Serializable {
        public boolean bZB = false;
        public int bZH;
        public int bZI = 0;
        public int bZj;
        public long bao = -1;
        public String userName = SQLiteDatabase.KeyEmpty;

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            a(i, j, str, i2, z, i3);
        }

        public a(int i, boolean z) {
            this.bZH = i;
            this.bZB = z;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.bZH = i;
            this.bao = j;
            this.userName = str;
            this.bZj = i2;
            this.bZB = z;
            this.bZI = i3;
        }

        public final String toString() {
            return this.userName + " id:" + this.bao + " unReadCount:" + this.bZj + "　notificationId:" + this.bZH;
        }
    }

    public final String toString() {
        String str = SQLiteDatabase.KeyEmpty;
        Iterator it = this.bZG.iterator();
        String str2 = str;
        while (it.hasNext()) {
            str2 = str2 + ((a) it.next()).toString() + ";  ";
        }
        return str2;
    }

    public final synchronized void restore() {
        try {
            this.bZG = (LinkedList) c.df(com.tencent.mm.h.a.sr().getString("com.tencent.preference.notification.key.queue", SQLiteDatabase.KeyEmpty));
            if (this.bZG == null) {
                this.bZG = new LinkedList();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.NotificationAppMsgQueue", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (this.bZG == null) {
                this.bZG = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.bZG == null) {
                this.bZG = new LinkedList();
            }
        }
        v.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.bZG.size()), toString());
    }

    private synchronized void save() {
        if (this.bZG != null) {
            v.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.bZG.size()));
            if (this.bZG.isEmpty()) {
                com.tencent.mm.h.a.sr().edit().putString("com.tencent.preference.notification.key.queue", SQLiteDatabase.KeyEmpty).commit();
                v.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.bZG.size()), toString());
            } else {
                try {
                    com.tencent.mm.h.a.sr().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.bZG))).commit();
                } catch (Throwable e) {
                    v.a("MicroMsg.NotificationAppMsgQueue", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                v.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.bZG.size()), toString());
            }
        }
    }

    public final synchronized void b(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            if (notificationItem != null) {
                if (this.bZG == null) {
                    restore();
                }
                aM(notificationItem.id);
                if (!notificationItem.bZB || t.kS(notificationItem.bZy)) {
                    this.bZG.add(new a(notificationItem.id, notificationItem.bZB));
                    v.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                } else {
                    Iterator it = this.bZG.iterator();
                    while (it.hasNext()) {
                        Object obj2;
                        a aVar = (a) it.next();
                        if (aVar.userName.equals(notificationItem.bZy)) {
                            aVar.a(notificationItem.id, notificationItem.bZz, notificationItem.bZy, notificationItem.bZA, notificationItem.bZB, notificationItem.bZC);
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.bZG.add(new a(notificationItem.id, notificationItem.bZz, notificationItem.bZy, notificationItem.bZA, notificationItem.bZB, notificationItem.bZC));
                        v.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                    }
                }
                save();
            }
        }
    }

    public final synchronized List<Integer> dE(int i) {
        List<Integer> arrayList;
        if (this.bZG == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.bZI & i) == 0 || arrayList.contains(Integer.valueOf(aVar.bZH)))) {
                arrayList.add(Integer.valueOf(aVar.bZH));
            }
        }
        return arrayList;
    }

    public final synchronized boolean aM(int i) {
        boolean z;
        if (i == -1) {
            z = false;
        } else {
            if (this.bZG == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.bZG.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.bZH != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.bZG = linkedList;
                save();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean dd(String str) {
        boolean z;
        v.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (t.kS(str)) {
            z = false;
        } else {
            if (this.bZG == null) {
                restore();
            }
            Iterator it = this.bZG.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.bZG.remove(aVar);
                    save();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        if (this.bZG == null) {
            restore();
        }
        return this.bZG.iterator();
    }
}
