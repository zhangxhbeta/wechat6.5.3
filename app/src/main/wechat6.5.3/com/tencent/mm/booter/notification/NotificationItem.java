package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.ad;
import android.support.v4.app.w;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new Creator<NotificationItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NotificationItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }
    };
    private final String TAG;
    private Bitmap b;
    public int bZA;
    public boolean bZB;
    public int bZC;
    public int bZD;
    PendingIntent bZx;
    public String bZy;
    public long bZz;
    public int id;
    Notification sf;

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.bZz = 0;
        this.bZA = 0;
        this.bZB = true;
        this.bZC = 0;
        this.bZD = 0;
        this.id = i;
        this.bZy = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.sf = notification;
        this.bZB = z;
        this.bZC = 0;
    }

    public final synchronized void clear() {
        if (!(this.b == null || this.b.isRecycled())) {
            v.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.b.toString());
            this.b.recycle();
        }
        this.sf = null;
        this.b = null;
        this.bZx = null;
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            this.id = this.id == -1 ? b.qC().as(this.bZB) : this.id;
            Context context = aa.getContext();
            if (context == null) {
                v.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                i = -1;
            } else if (this.sf == null) {
                v.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b qC = b.qC();
                String str = this.bZy;
                if (t.kS(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = qC.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.bZy != null && notificationItem2.bZy.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b qC2 = b.qC();
                    v.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.id));
                    qC2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.sf.tickerText == null || this.sf.tickerText == null || !notificationItem2.sf.tickerText.equals(this.sf.tickerText))) {
                    this.sf.tickerText += " ";
                }
                qC = b.qC();
                if (this == null) {
                    v.e("MicroMsg.Notification.Queue", "notification item null when put");
                } else if (this.id == -1) {
                    v.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (qC.mark > 0) {
                        if (qC.mark == this.id) {
                            v.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(qC.mark));
                            qC.remove(qC.mark);
                        }
                        qC.mark = -1;
                    }
                    qC.remove(this.id);
                    if (qC.size() >= 5) {
                        notificationItem = qC.qD();
                    }
                    qC.bZK.d(this);
                    qC.bZL.b(this);
                    v.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", Integer.valueOf(this.id), Integer.valueOf(qC.size()));
                }
                if (notificationItem != null) {
                    b.qC().cancel(notificationItem.id);
                }
                this.bZD = d.a(this.sf, gVar);
                if (context != null) {
                    if (this.sf == null) {
                        v.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = aa.getContext();
                        if (context2 == null) {
                            v.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.sf == null) {
                            v.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.sf.icon) == null) {
                                this.sf.icon = 2130838373;
                            }
                        }
                        v.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.sf.defaults), this.sf.sound, g.a(this.sf.vibrate));
                        try {
                            if (e.qL() == 1 && this.sf.defaults != 2 && this.sf.vibrate == null) {
                                this.sf.defaults = 0;
                                this.sf.sound = null;
                                v.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            ad h = ad.h(aa.getContext());
                            int i2 = this.id;
                            Notification notification = this.sf;
                            Bundle a = w.a(notification);
                            Object obj = (a == null || !a.getBoolean("android.support.useSideChannel")) ? null : 1;
                            if (obj != null) {
                                h.a(new f(h.mContext.getPackageName(), i2, null, notification));
                                ad.sH.a(h.sF, null, i2);
                            } else {
                                ad.sH.a(h.sF, null, i2, notification);
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.bZz != 0) {
                            c.E(this.bZz);
                        }
                    }
                }
                i = this.id;
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.bZz = 0;
        this.bZA = 0;
        this.bZB = true;
        this.bZC = 0;
        this.bZD = 0;
        if (parcel != null) {
            boolean z;
            this.id = parcel.readInt();
            this.bZy = parcel.readString();
            this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.sf = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
            this.bZx = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.bZB = z;
            this.bZz = parcel.readLong();
            this.bZA = parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.bZy == null ? SQLiteDatabase.KeyEmpty : this.bZy);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.sf, 0);
        parcel.writeParcelable(this.bZx, 0);
        if (this.bZB) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.bZz);
        parcel.writeInt(this.bZA);
    }

    public String toString() {
        return "id: " + this.id + ",msgId: " + this.bZz + ",userName: " + this.bZy + ",unreadCount: " + this.bZA;
    }
}
