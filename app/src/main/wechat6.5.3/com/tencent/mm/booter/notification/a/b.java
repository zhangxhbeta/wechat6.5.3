package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.h.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.d.c;
import java.io.File;

public final class b {
    public int bZO = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification) {
        int i;
        String sw;
        if (a.ss()) {
            i = 0;
            if (notification == null) {
                notification = new Notification();
            }
            v.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound);
            if (z2) {
                notification.vibrate = be.drm;
            }
            if (z) {
                sw = a.sw();
                if (av(context)) {
                    i = 0;
                    notification.sound = null;
                    a.bZX.di(sw);
                    v.i("MicroMsg.NotificationDefaults", "initDefaults, wireOn & playSound by ourselves: %s(if null play follow system notification sound)", sw);
                } else if (sw == null || sw == c.cgI) {
                    i = 1;
                } else {
                    i = 0;
                    notification.sound = Uri.parse(sw);
                }
            }
            v.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", Integer.valueOf(i), g.a(notification.vibrate), notification.sound);
            this.bZO = i;
            return this.bZO;
        }
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        v.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound);
        if (!z) {
            z3 = false;
            i = 0;
        } else if (av(context)) {
            z3 = true;
            i = 0;
        } else {
            z3 = false;
            i = 1;
        }
        if (z2) {
            i |= 2;
        }
        sw = a.sw();
        if (sw != null && new File(sw).exists()) {
            sw = c.cgI;
        }
        if (p.ceJ.cdH != 2) {
            if (((i & 2) > 0 ? 1 : null) != null) {
                i2 = i & -3;
                be.j(context, true);
                z4 = true;
            } else {
                i2 = i;
                z4 = false;
            }
            if (!dG(i2) || z3) {
                z5 = z4;
                z4 = false;
            } else {
                int i3 = i2 & -2;
                a.bZX.di(sw);
                i2 = i3;
                z5 = z4;
                z4 = true;
            }
        } else {
            z5 = false;
            i2 = i;
            z4 = false;
        }
        if (z3) {
            i2 &= -2;
            a.bZX.di(sw);
            z4 = true;
        } else if (dG(i2) && sw != null) {
            i2 &= -2;
            notification.sound = Uri.parse(sw);
        }
        this.bZO = i2;
        v.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound, sw, Boolean.valueOf(z3), Boolean.valueOf(r5), Boolean.valueOf(z5), Boolean.valueOf(z4));
        return this.bZO;
    }

    private static boolean dG(int i) {
        return (i & 1) > 0;
    }

    private static boolean av(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return audioManager == null ? false : audioManager.isWiredHeadsetOn();
    }
}
