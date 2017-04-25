package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.h.i;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static boolean bZk = true;
    private static boolean bZl = true;
    private static boolean bZm = false;
    private static int bZn = -1;
    private static int bZo = -1;
    private static boolean bZp = true;
    private static String bZq = "samsung";
    public static boolean bZr = true;
    public static boolean bZs = false;
    private static int bZt = -1;
    private static boolean bZu = true;
    private static Uri bZv = Uri.parse("content://com.android.badge/badge");

    public static void dD(int i) {
        boolean z;
        if (aa.getContext() != null && qA()) {
            Context context = aa.getContext();
            int td = i == -1 ? i.td() : i;
            if (!(context == null || !qA() || bZt == td)) {
                bZt = td;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", td);
                intent.putExtra("badge_count_package_name", aa.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                v.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(td), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (bZp) {
            if (VERSION.SDK_INT < 11) {
                bZp = false;
            } else if (bZo != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", aa.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    bZp = aa.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    v.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i), Boolean.valueOf(bZp));
                } catch (Throwable e) {
                    v.a("MicroMsg.BusinessNotification", e, "no huawei badge", new Object[0]);
                    bZp = false;
                }
            }
        }
        if (bZm) {
            z = bZl;
        } else {
            bZm = true;
            if (Build.BRAND.equals("vivo")) {
                bZl = true;
                z = true;
            } else {
                bZl = false;
                z = false;
            }
        }
        if (z && bZn != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra("packageName", aa.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                aa.getContext().sendBroadcast(intent2);
                v.i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i));
            } catch (Throwable e2) {
                bZl = false;
                v.a("MicroMsg.BusinessNotification", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        m(null, i);
    }

    public static void l(String str, int i) {
        if (t.kS(str)) {
            v.a("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            return;
        }
        String pr = c.pr(str);
        if (!t.kS(pr)) {
            m(pr, i);
        }
    }

    public static void ar(boolean z) {
        if (bZu) {
            Context context = aa.getContext();
            if (context != null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    try {
                        v.i("MicroMsg.BusinessNotification", "sync all user badge");
                        Bundle call = contentResolver.call(bZv, "getShortcutList", null, null);
                        if (call == null) {
                            v.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                            return;
                        }
                        String string = call.getString("shortcut_list");
                        if (string != null) {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                                if (!(string == null || string.equalsIgnoreCase("null"))) {
                                    String pq = c.pq(string);
                                    l(pq, z ? 0 : i.dC(pq));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                    }
                }
            }
        }
    }

    public static int a(Notification notification, g gVar) {
        int i;
        if (notification == null || !bZk) {
            return 0;
        }
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.cag;
            NotificationQueue notificationQueue = b.qC().bZK;
            if (notificationQueue.bZJ == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.bZJ.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).bZD + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            v.i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i));
            return i;
        } catch (NoSuchFieldException e) {
            bZk = false;
            return i;
        } catch (IllegalArgumentException e2) {
            bZk = false;
            return i;
        } catch (IllegalAccessException e3) {
            bZk = false;
            return i;
        } catch (ClassNotFoundException e4) {
            bZk = false;
            return i;
        } catch (InstantiationException e5) {
            bZk = false;
            return i;
        } catch (Exception e6) {
            bZk = false;
            return i;
        }
    }

    private static boolean qA() {
        if (bZs) {
            return bZr;
        }
        bZs = true;
        if (Build.BRAND.equals(bZq)) {
            bZr = true;
            return true;
        }
        bZr = false;
        return false;
    }

    private static void m(String str, int i) {
        if (aa.getContext() == null) {
            v.a("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            return;
        }
        Context context = aa.getContext();
        if (i < 0) {
            i = i.td();
        }
        a(context, str, i);
    }

    private static boolean a(Context context, String str, int i) {
        boolean z = true;
        if (!bZu) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
            } else {
                bundle.putStringArrayList("app_shortcut_custom_id", null);
            }
            bundle.putInt("app_badge_count", i);
            bundle.putString("app_shortcut_class_name", aa.bth() + ".ui.LauncherUI");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || contentResolver.call(bZv, "setAppBadgeCount", null, bundle) == null) {
                z = false;
            }
            v.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
            return z;
        } catch (Throwable e) {
            bZu = false;
            v.a("MicroMsg.BusinessNotification", e, "no support normal badge", new Object[0]);
            return false;
        }
    }
}
