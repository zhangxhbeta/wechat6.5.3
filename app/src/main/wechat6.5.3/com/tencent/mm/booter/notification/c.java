package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.w.d;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.e.a.t;
import com.tencent.mm.h.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public static String bZg = "com.tencent.preference.notification.key.unread.msg";
    public static String bZh = "com.tencent.preference.notification.key.unread.talker";
    public static String bZi = "com.tencent.preference.notification.key.all.notified.msgid";
    g aRL = new g(this.mContext);
    Context mContext = aa.getContext();

    private static class a implements Serializable {
        public int bZj;
        public String userName;

        private a() {
        }

        public final String toString() {
            return "[" + this.userName + "(" + this.bZj + ")]";
        }
    }

    static Notification qw() {
        Notification notification = new Notification();
        notification.icon = 2130838373;
        notification.ledARGB = -16711936;
        notification.ledOnMS = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
        notification.ledOffMS = 1000;
        return notification;
    }

    public static boolean a(String str, at atVar, int i, boolean z) {
        v.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
        if (!ak.uz()) {
            v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            return false;
        } else if (atVar != null && F(atVar.field_msgSvrId) && !z) {
            v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", Long.valueOf(atVar.field_msgSvrId));
            return false;
        } else if ((i & 1) == 0) {
            v.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
            return false;
        } else {
            ak.yW();
            if (com.tencent.mm.model.c.wC() && !k.eF(k.xL())) {
                r4 = new Object[4];
                ak.yW();
                r4[2] = Boolean.valueOf(com.tencent.mm.model.c.wC());
                r4[3] = Boolean.valueOf(k.eF(k.xL()));
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", r4);
                return false;
            } else if (m.ey(str)) {
                b hoVar = new ho();
                hoVar.bhk.bdf = 3;
                com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                if (!hoVar.bhl.aYN) {
                    hoVar = new ho();
                    hoVar.bhk.bdf = 1;
                    hoVar.bhk.bhm = str;
                    hoVar.bhk.bhn = 3;
                    com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                }
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                return false;
            } else if (!m.fs(str) && (!m.dE(str) || m.fr(str) || atVar == null || atVar.Mw(k.xF()) || atVar.field_type == 64 || atVar == null || atVar.Mx(k.xF()))) {
                return true;
            } else {
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i));
                return false;
            }
        }
    }

    public final int a(NotificationItem notificationItem, g gVar) {
        if (!(l.dI(this.mContext) || VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.sf == null)) {
            notificationItem.sf.priority = 1;
            if (!com.tencent.mm.h.a.ss()) {
                notificationItem.sf.vibrate = new long[0];
                if (!(gVar.cam || gVar.cal)) {
                    notificationItem.sf.priority = 0;
                }
            }
        }
        return super.a(notificationItem, gVar);
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i3, String str4, PendingIntent pendingIntent2, int i4, String str5, PendingIntent pendingIntent3, String str6) {
        if (VERSION.SDK_INT < 11) {
            return notification;
        }
        d dVar = new d(this.mContext);
        if (i == -1) {
            i = com.tencent.mm.ax.a.bmo();
        }
        dVar.sf.ledARGB = -16711936;
        dVar.sf.ledOnMS = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
        dVar.sf.ledOffMS = 1000;
        Object obj = (dVar.sf.ledOnMS == 0 || dVar.sf.ledOffMS == 0) ? null : 1;
        dVar.sf.flags = (obj != null ? 1 : 0) | (dVar.sf.flags & -2);
        dVar.L(i).c(str3).rI = pendingIntent;
        dVar.rZ = true;
        if (str != null) {
            dVar.a(str);
        }
        if (str2 != null) {
            dVar.b((CharSequence) str2);
        }
        dVar.sf.defaults = i2;
        if ((i2 & 4) != 0) {
            Notification notification2 = dVar.sf;
            notification2.flags |= 1;
        }
        if (bitmap != null) {
            dVar.rL = bitmap;
        }
        if (notification != null) {
            if (notification.sound != null) {
                dVar.sf.sound = notification.sound;
                dVar.sf.audioStreamType = -1;
            }
            if (notification.vibrate != null) {
                dVar.sf.vibrate = notification.vibrate;
            }
        }
        if (VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                dVar.a(i3, str4, pendingIntent2);
            }
            if (str5 != null) {
                dVar.a(i4, str5, pendingIntent3);
            }
        }
        if (VERSION.SDK_INT >= 21) {
            dVar.sa = "msg";
            b tVar = new t();
            tVar.aXg.username = str6;
            tVar.aXg.title = str;
            com.tencent.mm.sdk.c.a.nhr.z(tVar);
            if (tVar.aXg.aXh != null) {
                tVar.aXg.aXh.a(dVar);
            }
        }
        return dVar.getNotification();
    }

    public final void a(long j, String str, String str2, String str3, String str4, boolean z, int i) {
        Context context = aa.getContext();
        v.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", Boolean.valueOf(e.qK()), Boolean.valueOf(e.qI()));
        if (j != 0) {
            if (be.kS(str) || be.kS(str2) || be.kS(str3)) {
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
            } else if (i.sY() && !i.sZ()) {
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
            } else if (!com.tencent.mm.h.a.st()) {
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
            } else if (F(j)) {
                v.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
            } else {
                boolean z2;
                boolean z3;
                com.tencent.mm.booter.notification.queue.b.qC().restore();
                int qx = qx() + 1;
                a a = a(qy(), str);
                int i2 = (a == null ? 0 : a.bZj) + 1;
                List qy = qy();
                if (qy == null) {
                    qy = new ArrayList();
                }
                a a2 = a(qy, str);
                if (a2 == null) {
                    a2 = new a();
                    a2.userName = str;
                    a2.bZj = 1;
                    qy.add(a2);
                } else {
                    a2.bZj++;
                }
                d(qy);
                dC(qx() + 1);
                int size = qy.size();
                if (e.qH()) {
                    z2 = false;
                    z3 = false;
                } else {
                    z2 = r7;
                    z3 = r8;
                }
                Notification qw = qw();
                int de = com.tencent.mm.booter.notification.queue.b.qC().de(str);
                this.aRL.cag = qx;
                this.aRL.caf = size;
                this.aRL.cam = z3;
                this.aRL.cal = z2;
                boolean su = com.tencent.mm.h.a.su();
                int bmo = com.tencent.mm.ax.a.bmo();
                g gVar = this.aRL;
                gVar.bZY.a(gVar.mContext, z2, z3, qw);
                int i3 = gVar.bZY.bZO;
                Intent intent = new Intent(context, LauncherUI.class);
                intent.putExtra("nofification_type", "new_msg_nofification");
                intent.putExtra("Main_User", str);
                intent.putExtra("MainUI_User_Last_Msg_Type", i);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                if (su) {
                    intent.putExtra("talkerCount", 1);
                    intent.putExtra("Intro_Is_Muti_Talker", false);
                } else {
                    if (size <= 1) {
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                    }
                    intent.putExtra("talkerCount", size);
                }
                intent.putExtra("pushcontent_unread_count", qx);
                NotificationItem notificationItem = new NotificationItem(de, str, a(qw, bmo, i3, com.tencent.mm.booter.notification.a.d.a(context, de, intent), h.b(context, str2, su), h.a(context, str3, size, qx, i2, su), h.c(context, str3, su), com.tencent.mm.h.a.su() ? com.tencent.mm.booter.notification.a.a.b(context, com.tencent.mm.booter.notification.a.a.u(str, str4)) : null, str));
                notificationItem.bZz = j;
                notificationItem.bZA = i2;
                a(notificationItem, this.aRL);
                d.dD(this.aRL.cag);
                d.l(str, i2);
            }
        }
    }

    private static a a(List<a> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private static int qx() {
        return com.tencent.mm.h.a.sr().getInt(bZg, 0);
    }

    public static ArrayList<a> qy() {
        try {
            ArrayList<a> arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.df(com.tencent.mm.h.a.sr().getString(bZh, SQLiteDatabase.KeyEmpty));
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.Notification.AppMsg.Handle", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return new ArrayList();
        } catch (Throwable e2) {
            v.a("MicroMsg.Notification.AppMsg.Handle", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            return new ArrayList();
        }
    }

    public static void d(ArrayList<a> arrayList) {
        if (arrayList == null) {
            com.tencent.mm.h.a.sr().edit().putString(bZh, SQLiteDatabase.KeyEmpty).commit();
        } else {
            try {
                com.tencent.mm.h.a.sr().edit().putString(bZh, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).commit();
            } catch (Throwable e) {
                v.a("MicroMsg.Notification.AppMsg.Handle", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                com.tencent.mm.h.a.sr().edit().putString(bZh, SQLiteDatabase.KeyEmpty).commit();
            }
        }
        String str = "MicroMsg.Notification.AppMsg.Handle";
        String str2 = "saveTotalUnreadTalker %s";
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? "null" : arrayList.toString();
        v.i(str, str2, objArr);
    }

    public static void dC(int i) {
        com.tencent.mm.h.a.sr().edit().putInt(bZg, Math.max(0, i)).commit();
        v.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", Integer.valueOf(r0));
    }

    public static void E(long j) {
        if (j != 0) {
            String qz = qz();
            if (qz.length() > 3000) {
                qz = qz.substring(qz.length() / 2, qz.length());
            }
            if (!F(j)) {
                com.tencent.mm.h.a.sr().edit().putString(bZi, qz + j + "%").commit();
                v.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", qz);
            }
        }
    }

    private static boolean F(long j) {
        if (j == 0) {
            return false;
        }
        v.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", qz(), Long.valueOf(j));
        if (qz().contains(j + "%")) {
            return true;
        }
        return false;
    }

    private static String qz() {
        return com.tencent.mm.h.a.sr().getString(bZi, SQLiteDatabase.KeyEmpty);
    }

    public static void qv() {
        com.tencent.mm.h.a.sr().edit().putString(bZi, SQLiteDatabase.KeyEmpty).commit();
    }
}
