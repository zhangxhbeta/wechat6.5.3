package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface aa {
    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void aq(boolean z);

    int b(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void dA(int i);

    void dB(int i);

    void db(String str);

    void dc(String str);

    void dz(int i);

    void k(int i, String str);

    void k(String str, int i);

    void notify(int i, Notification notification);

    void oz();

    String qr();

    void qs();

    boolean qt();

    void qu();

    void qv();
}
