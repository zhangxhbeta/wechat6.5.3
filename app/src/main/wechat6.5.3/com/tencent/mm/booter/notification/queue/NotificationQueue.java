package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.h.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue {
    public ParcelNotificationQueue bZJ;

    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Creator<ParcelNotificationQueue> CREATOR = new Creator<ParcelNotificationQueue>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                return parcelNotificationQueue;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelNotificationQueue[i];
            }
        };

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
        }
    }

    private void save() {
        if (this.bZJ != null) {
            v.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.bZJ.size()));
            if (this.bZJ.isEmpty()) {
                a.sr().edit().putString("com.tencent.preference.notification.queue", SQLiteDatabase.KeyEmpty).commit();
                if (this.bZJ == null) {
                    restore();
                }
                v.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.bZJ.size()));
            }
        }
    }

    public final synchronized void restore() {
        v.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.bZJ == null) {
            this.bZJ = new ParcelNotificationQueue();
        }
        v.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.bZJ.size()));
    }

    public final synchronized boolean c(NotificationItem notificationItem) {
        boolean remove;
        if (this.bZJ == null) {
            restore();
        }
        remove = this.bZJ.remove(notificationItem);
        if (remove) {
            save();
        }
        return remove;
    }

    public final synchronized NotificationItem dF(int i) {
        NotificationItem notificationItem;
        if (this.bZJ == null) {
            restore();
        }
        Iterator it = this.bZJ.iterator();
        while (it.hasNext()) {
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i) {
                break;
            }
        }
        notificationItem = null;
        if (notificationItem != null && this.bZJ.remove(notificationItem)) {
            save();
        }
        return notificationItem;
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean add;
        if (this.bZJ == null) {
            restore();
        }
        add = this.bZJ.add(notificationItem);
        if (add) {
            save();
        }
        return add;
    }
}
