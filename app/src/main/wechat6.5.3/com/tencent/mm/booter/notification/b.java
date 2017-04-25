package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ad;
import com.tencent.mm.ax.a;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.h.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.bbom.l;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class b implements aa, ac {
    private String bYT;
    private String bYU;
    String bYV;
    Intent bYW;
    private int bYX;
    private boolean bYY;
    private long bYZ;
    f bZa = a.bZF;
    private e bZb;
    @SuppressLint({"HandlerLeak"})
    com.tencent.mm.sdk.platformtools.ac bZc = new com.tencent.mm.sdk.platformtools.ac(this, Looper.getMainLooper()) {
        final /* synthetic */ b bZf;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).commit();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            v.i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    b.a(this.bZf, string, string2, i, i2, true);
                } else {
                    b.a(this.bZf, string, string2, i, i2, false);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
            }
        }
    };
    private final c bZd = new c<ly>(this) {
        final /* synthetic */ b bZf;

        {
            this.bZf = r2;
            this.nhz = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ly lyVar = (ly) bVar;
            if (lyVar != null && (lyVar instanceof ly)) {
                bx bxVar = lyVar.bnd.bmk;
                if (bxVar != null) {
                    b bVar2 = this.bZf;
                    if (bxVar.field_isSend == 1) {
                        v.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(bxVar.field_msgSvrId));
                    } else {
                        bVar2.bmk = bxVar;
                        int b = i.b(bxVar);
                        bVar2.bdo = bxVar.field_talker;
                        String str = bxVar.field_content;
                        int i = bxVar.field_type;
                        bVar2.bYV = SQLiteDatabase.KeyEmpty;
                        bVar2.bYW = null;
                        v.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", bVar2.bdo, Long.valueOf(bxVar.field_msgSvrId), Integer.valueOf(i), Integer.valueOf(b), be.KW(str));
                        if (bVar2.bZa.a(bVar2.bdo, bVar2.bmk, b, true)) {
                            bVar2.bZc.sendMessageDelayed(b.a(bVar2.bdo, str, i, b, 1), 200);
                        } else {
                            v.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                        }
                    }
                }
            }
            return false;
        }
    };
    private final c bZe = new c<mt>(this) {
        final /* synthetic */ b bZf;

        {
            this.bZf = r2;
            this.nhz = mt.class.getName().hashCode();
        }

        private boolean a(mt mtVar) {
            if (mtVar != null && (mtVar instanceof mt)) {
                String str = mtVar.bod.bmE;
                int i = mtVar.bod.msgType;
                b bVar = this.bZf;
                try {
                    v.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i));
                    if (!ChattingUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) bVar.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                        Intent intent = new Intent(bVar.context, ChattingUI.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.addFlags(67108864);
                        Notification notification = new Builder(bVar.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(bVar.context.getString(2131231134)).setContentText(bVar.context.getString(2131233837)).setContentIntent(PendingIntent.getActivity(bVar.context, 35, intent, 1073741824)).getNotification();
                        notification.icon = a.bmo();
                        notification.defaults |= 1;
                        notification.flags |= 16;
                        bVar.a(35, notification, true);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.MMNotification", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            return false;
        }
    };
    String bdo;
    at bmk;
    Context context = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.booter.notification.b r28, java.lang.String r29, java.lang.String r30, int r31, int r32, boolean r33) {
        /*
        r4 = "MicroMsg.MMNotification";
        r5 = "jacks dealNotify, talker:%s, msgtype:%d, tipsFlag:%d, isRevokeMesasge:%B content:%s";
        r6 = 5;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r29;
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r31);
        r6[r7] = r8;
        r7 = 2;
        r8 = java.lang.Integer.valueOf(r32);
        r6[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r33);
        r6[r7] = r8;
        r7 = 4;
        r8 = com.tencent.mm.sdk.platformtools.be.KW(r30);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        if (r33 == 0) goto L_0x00f2;
    L_0x002d:
        r4 = 2;
        r4 = new boolean[r4];
        r4 = {0, 0};
    L_0x0033:
        r5 = 0;
        r17 = r4[r5];
        r5 = 1;
        r18 = r4[r5];
        if (r17 != 0) goto L_0x0206;
    L_0x003b:
        if (r18 != 0) goto L_0x0206;
    L_0x003d:
        r4 = 1;
    L_0x003e:
        r5 = "MicroMsg.MMNotification";
        r6 = new java.lang.StringBuilder;
        r7 = "updateNotifyInfo: silent = ";
        r6.<init>(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.v.d(r5, r6);
        r5 = 1;
        r0 = r28;
        r0.bYY = r5;
        if (r4 != 0) goto L_0x007d;
    L_0x005b:
        r4 = "MicroMsg.MMNotification";
        r5 = new java.lang.StringBuilder;
        r6 = "updateNotifyInfo : modify lastNotSilentTime = ";
        r5.<init>(r6);
        r0 = r28;
        r6 = r0.bYZ;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.d(r4, r5);
        r4 = java.lang.System.currentTimeMillis();
        r0 = r28;
        r0.bYZ = r4;
    L_0x007d:
        r0 = r28;
        r4 = r0.bZa;
        r0 = r28;
        r5 = r0.bYT;
        r4 = r4.bZE;
        r4 = r4.bZw;
        r6 = "MicroMsg.Notification.AppMsg.Handle";
        r7 = "dealCurChattingTalker, talker: %s, curChattingTalker: %s, needSound: %B, needShake: %B";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r29;
        r9 = 1;
        r8[r9] = r5;
        r9 = 2;
        r10 = java.lang.Boolean.valueOf(r17);
        r8[r9] = r10;
        r9 = 3;
        r10 = java.lang.Boolean.valueOf(r18);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.d(r6, r7, r8);
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r29);
        if (r6 != 0) goto L_0x0262;
    L_0x00af:
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r6 != 0) goto L_0x0262;
    L_0x00b5:
        r0 = r29;
        r6 = r0.equals(r5);
        if (r6 == 0) goto L_0x0262;
    L_0x00bd:
        if (r18 != 0) goto L_0x0209;
    L_0x00bf:
        if (r17 != 0) goto L_0x0209;
    L_0x00c1:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is current talker chatroom & no shake & no sound";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
        r4 = 1;
    L_0x00cb:
        if (r4 == 0) goto L_0x0265;
    L_0x00cd:
        r4 = "MicroMsg.MMNotification";
        r5 = "[no notificaion], iscurrent Chatting Talker true, talker[%s] curChattingTalker[%s] needSound[%B] needShake[%B]";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r29;
        r7 = 1;
        r0 = r28;
        r8 = r0.bYT;
        r6[r7] = r8;
        r7 = 2;
        r8 = java.lang.Boolean.valueOf(r17);
        r6[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r18);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.w(r4, r5, r6);
    L_0x00f1:
        return;
    L_0x00f2:
        r0 = r28;
        r6 = r0.bZb;
        r0 = r28;
        r7 = r0.bmk;
        r0 = r28;
        r8 = r0.bYY;
        r0 = r28;
        r10 = r0.bYZ;
        r4 = 2;
        r5 = new boolean[r4];
        r5 = {1, 1};
        r4 = com.tencent.mm.booter.notification.a.e.qI();
        r9 = com.tencent.mm.booter.notification.a.e.qK();
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01ae;
    L_0x0116:
        r4 = com.tencent.mm.booter.notification.a.e.qH();
        if (r4 != 0) goto L_0x01d1;
    L_0x011c:
        r4 = 1;
    L_0x011d:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01ae;
    L_0x0123:
        r4 = com.tencent.mm.booter.notification.a.e.dh(r29);
        if (r4 != 0) goto L_0x01d4;
    L_0x0129:
        r4 = 1;
    L_0x012a:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01ae;
    L_0x0130:
        r4 = com.tencent.mm.booter.notification.a.e.dH(r32);
        r9 = com.tencent.mm.booter.notification.a.e.dI(r32);
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01ae;
    L_0x013e:
        r4 = 0;
        r6.bZR = r4;
        r4 = "keep_app_silent";
        r4 = com.tencent.mm.sdk.platformtools.ab.Kk(r4);
        if (r4 == 0) goto L_0x01d7;
    L_0x014a:
        r4 = 1;
        r6.bZR = r4;
    L_0x014d:
        r8 = "MicroMsg.Notification.Silent.Handle";
        r9 = "check Refresh Keep is NOT Silent: %B";
        r4 = 1;
        r10 = new java.lang.Object[r4];
        r11 = 0;
        r4 = r6.bZR;
        if (r4 != 0) goto L_0x01f9;
    L_0x015b:
        r4 = 1;
    L_0x015c:
        r4 = java.lang.Boolean.valueOf(r4);
        r10[r11] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r8, r9, r10);
        r4 = r6.bZR;
        if (r4 != 0) goto L_0x01fc;
    L_0x0169:
        r4 = 1;
    L_0x016a:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01ae;
    L_0x0170:
        r0 = r29;
        r4 = com.tencent.mm.booter.notification.a.e.a(r0, r7);
        if (r4 != 0) goto L_0x01ff;
    L_0x0178:
        r4 = 1;
    L_0x0179:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01ae;
    L_0x017f:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x0191;
    L_0x0184:
        r6 = 0;
        r7 = r5[r6];
        r4 = com.tencent.mm.booter.notification.a.e.dg(r29);
        if (r4 != 0) goto L_0x0202;
    L_0x018d:
        r4 = 1;
    L_0x018e:
        r4 = r4 & r7;
        r5[r6] = r4;
    L_0x0191:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x01a4;
    L_0x0196:
        r4 = 0;
        r6 = r5[r4];
        r0 = r31;
        r1 = r30;
        r7 = com.tencent.mm.booter.notification.a.e.l(r0, r1);
        r6 = r6 & r7;
        r5[r4] = r6;
    L_0x01a4:
        r4 = com.tencent.mm.booter.notification.a.e.qJ();
        if (r4 != 0) goto L_0x0204;
    L_0x01aa:
        r4 = 1;
    L_0x01ab:
        com.tencent.mm.booter.notification.a.e.a(r5, r4);
    L_0x01ae:
        r4 = "MicroMsg.Notification.Silent.Handle";
        r6 = "finally silent, sound: %B, shake: %B";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = 0;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        r8 = 1;
        r9 = 1;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r4, r6, r7);
        r4 = r5;
        goto L_0x0033;
    L_0x01d1:
        r4 = 0;
        goto L_0x011d;
    L_0x01d4:
        r4 = 0;
        goto L_0x012a;
    L_0x01d7:
        r12 = 0;
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r4 > 0) goto L_0x01e2;
    L_0x01dd:
        r4 = 0;
        r6.bZR = r4;
        goto L_0x014d;
    L_0x01e2:
        r12 = java.lang.System.currentTimeMillis();
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x014d;
    L_0x01ea:
        r12 = java.lang.System.currentTimeMillis();
        r14 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r10 = r10 + r14;
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x014d;
    L_0x01f5:
        r6.bZR = r8;
        goto L_0x014d;
    L_0x01f9:
        r4 = 0;
        goto L_0x015c;
    L_0x01fc:
        r4 = 0;
        goto L_0x016a;
    L_0x01ff:
        r4 = 0;
        goto L_0x0179;
    L_0x0202:
        r4 = 0;
        goto L_0x018e;
    L_0x0204:
        r4 = 0;
        goto L_0x01ab;
    L_0x0206:
        r4 = 0;
        goto L_0x003e;
    L_0x0209:
        r6 = "MicroMsg.Notification.AppMsg.Handle";
        r7 = "notification.shake: curChatting needShake~: %B";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = java.lang.Boolean.valueOf(r18);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);
        r6 = r4.mContext;
        r0 = r18;
        com.tencent.mm.sdk.platformtools.be.j(r6, r0);
        if (r17 == 0) goto L_0x023f;
    L_0x0225:
        r6 = com.tencent.mm.h.a.sw();
        r7 = "MicroMsg.Notification.AppMsg.Handle";
        r8 = "notification.playSound: curChattingTalker: %s";
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r9[r10] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r7, r8, r9);
        r4 = r4.aRL;
        r4 = r4.cac;
        r4.di(r6);
    L_0x023f:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r6 = "[NO NOTIFICATION] is current talker end. talker[%s], current ChattingTalker[%s]. shake %B, sound: %B";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r29;
        r8 = 1;
        r7[r8] = r5;
        r5 = 2;
        r8 = java.lang.Boolean.valueOf(r18);
        r7[r5] = r8;
        r5 = 3;
        r8 = java.lang.Boolean.valueOf(r17);
        r7[r5] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r4, r6, r7);
        r4 = 1;
        goto L_0x00cb;
    L_0x0262:
        r4 = 0;
        goto L_0x00cb;
    L_0x0265:
        r4 = 436207665; // 0x1a000031 float:2.6469934E-23 double:2.155152217E-315;
        r0 = r31;
        if (r0 != r4) goto L_0x0311;
    L_0x026c:
        r4 = com.tencent.mm.sdk.platformtools.be.KK(r30);
        r4 = com.tencent.mm.q.a.a.dV(r4);
        if (r4 == 0) goto L_0x028e;
    L_0x0276:
        r5 = "MicroMsg.MMNotification";
        r6 = new java.lang.StringBuilder;
        r7 = "ljd:c2c hongbao message for c2cShowNotification is ";
        r6.<init>(r7);
        r7 = r4.cpR;
        r6 = r6.append(r7);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.v.e(r5, r6);
    L_0x028e:
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new com.tencent.mars.smc.SmcLogic$IDKey;
        r6.<init>();
        r7 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r6.SetID(r7);
        r7 = 0;
        r6.SetKey(r7);
        r7 = 1;
        r6.SetValue(r7);
        r5.add(r6);
        if (r4 == 0) goto L_0x02e0;
    L_0x02aa:
        r6 = "1002";
        r7 = r4.cpJ;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x02e0;
    L_0x02b5:
        r6 = r4.cpR;
        r7 = 1;
        if (r6 != r7) goto L_0x02e0;
    L_0x02ba:
        r4 = new com.tencent.mars.smc.SmcLogic$IDKey;
        r4.<init>();
        r6 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r6);
        r6 = 1;
        r4.SetKey(r6);
        r6 = 1;
        r4.SetValue(r6);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 1;
        com.tencent.mm.plugin.report.service.g.d(r5, r4);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is hide!";
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        goto L_0x00f1;
    L_0x02e0:
        if (r4 == 0) goto L_0x0311;
    L_0x02e2:
        r6 = "1002";
        r4 = r4.cpJ;
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x0311;
    L_0x02ed:
        r4 = new com.tencent.mars.smc.SmcLogic$IDKey;
        r4.<init>();
        r6 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r6);
        r6 = 2;
        r4.SetKey(r6);
        r6 = 1;
        r4.SetValue(r6);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 1;
        com.tencent.mm.plugin.report.service.g.d(r5, r4);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is show!";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
    L_0x0311:
        r4 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r31;
        if (r0 != r4) goto L_0x0333;
    L_0x0318:
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.vf();
        r5 = com.tencent.mm.storage.t.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r6 = 1;
        r4 = r4.b(r5, r6);
        if (r4 != 0) goto L_0x0333;
    L_0x0328:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a service notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
        goto L_0x00f1;
    L_0x0333:
        r0 = r28;
        r4 = r0.bmk;
        if (r4 == 0) goto L_0x0360;
    L_0x0339:
        r0 = r28;
        r4 = r0.bmk;
        r4 = r4.field_talker;
        r4 = com.tencent.mm.q.a.a.dW(r4);
        if (r4 == 0) goto L_0x0360;
    L_0x0345:
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.vf();
        r5 = com.tencent.mm.storage.t.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r6 = 1;
        r4 = r4.b(r5, r6);
        if (r4 != 0) goto L_0x0360;
    L_0x0355:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a wxa custom session notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
        goto L_0x00f1;
    L_0x0360:
        r0 = r28;
        r6 = r0.bZa;
        r0 = r28;
        r4 = r0.bmk;
        if (r4 != 0) goto L_0x03f2;
    L_0x036a:
        r4 = 0;
        r14 = r4;
    L_0x036d:
        r0 = r28;
        r0 = r0.bYV;
        r16 = r0;
        r0 = r28;
        r8 = r0.bYW;
        r4 = r6.bZE;
        r5 = com.tencent.mm.h.a.su();
        if (r5 != 0) goto L_0x0382;
    L_0x037f:
        com.tencent.mm.booter.notification.e.cancel();
    L_0x0382:
        r4 = r4.bZw;
        r5 = "MicroMsg.Notification.AppMsg.Handle";
        r6 = "in sample Notify: needSound: %B, needShake: %B, msgContent: ==, msgType: %d, talker: %s, customNotify: %s, isRevokeMessage:%b";
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r9 = 0;
        r10 = java.lang.Boolean.valueOf(r17);
        r7[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r18);
        r7[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r31);
        r7[r9] = r10;
        r9 = 3;
        r7[r9] = r29;
        r9 = 4;
        r7[r9] = r16;
        r9 = 5;
        r10 = java.lang.Boolean.valueOf(r33);
        r7[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r7);
        r5 = com.tencent.mm.h.a.st();
        if (r5 != 0) goto L_0x03fb;
    L_0x03b8:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION]new MsgNotification setting no notification";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
    L_0x03c1:
        r5 = new com.tencent.mm.e.a.in;
        r5.<init>();
        r4 = r5.biX;
        r0 = r29;
        r4.bdo = r0;
        r6 = r5.biX;
        if (r17 != 0) goto L_0x09f3;
    L_0x03d0:
        r4 = 1;
    L_0x03d1:
        r6.biY = r4;
        r4 = r5.biX;
        r0 = r18;
        r4.biZ = r0;
        r4 = r5.biX;
        r6 = com.tencent.mm.h.i.dC(r29);
        r4.aWI = r6;
        r4 = com.tencent.mm.sdk.c.a.nhr;
        r4.z(r5);
        r4 = com.tencent.mm.model.m.crA;
        r4 = com.tencent.mm.model.n.fw(r4);
        r0 = r28;
        r0.bYX = r4;
        goto L_0x00f1;
    L_0x03f2:
        r0 = r28;
        r4 = r0.bmk;
        r4 = r4.field_msgSvrId;
        r14 = r4;
        goto L_0x036d;
    L_0x03fb:
        r5 = com.tencent.mm.h.i.dD(r29);
        if (r5 == 0) goto L_0x0446;
    L_0x0401:
        r13 = "@bottle";
    L_0x0404:
        r6 = r4.aRL;
        r5 = com.tencent.mm.h.i.dD(r13);
        if (r5 == 0) goto L_0x0449;
    L_0x040c:
        r5 = com.tencent.mm.h.i.te();
    L_0x0410:
        r6.cah = r5;
        r5 = com.tencent.mm.h.i.tb();
        r6.caf = r5;
        r5 = com.tencent.mm.h.i.td();
        r6.cag = r5;
        r5 = com.tencent.mm.h.i.dC(r13);
        r6.cae = r5;
        if (r33 == 0) goto L_0x044b;
    L_0x0426:
        r5 = r4.aRL;
        r5 = r5.caf;
        if (r5 > 0) goto L_0x044b;
    L_0x042c:
        r5 = r4.aRL;
        r5 = r5.cag;
        if (r5 > 0) goto L_0x044b;
    L_0x0432:
        r5 = r4.aRL;
        r5 = r5.cai;
        if (r5 != 0) goto L_0x044b;
    L_0x0438:
        r5 = 1;
    L_0x0439:
        if (r5 == 0) goto L_0x044d;
    L_0x043b:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] no refresh notify by revoke";
        com.tencent.mm.sdk.platformtools.v.i(r4, r5);
        goto L_0x03c1;
    L_0x0446:
        r13 = r29;
        goto L_0x0404;
    L_0x0449:
        r5 = 0;
        goto L_0x0410;
    L_0x044b:
        r5 = 0;
        goto L_0x0439;
    L_0x044d:
        r5 = com.tencent.mm.booter.notification.c.qw();
        r0 = r4.aRL;
        r19 = r0;
        r0 = r19;
        r6 = r0.cah;
        r7 = -1;
        if (r6 != r7) goto L_0x046a;
    L_0x045c:
        r6 = com.tencent.mm.h.i.dD(r13);
        if (r6 == 0) goto L_0x0653;
    L_0x0462:
        r6 = com.tencent.mm.h.i.te();
    L_0x0466:
        r0 = r19;
        r0.cah = r6;
    L_0x046a:
        r0 = r19;
        r6 = r0.caf;
        r7 = -1;
        if (r6 != r7) goto L_0x0479;
    L_0x0471:
        r6 = com.tencent.mm.h.i.tb();
        r0 = r19;
        r0.caf = r6;
    L_0x0479:
        r0 = r19;
        r6 = r0.cag;
        r7 = -1;
        if (r6 != r7) goto L_0x0488;
    L_0x0480:
        r6 = com.tencent.mm.h.i.td();
        r0 = r19;
        r0.cag = r6;
    L_0x0488:
        r0 = r19;
        r6 = r0.cae;
        r7 = -1;
        if (r6 != r7) goto L_0x0497;
    L_0x048f:
        r6 = com.tencent.mm.h.i.dC(r13);
        r0 = r19;
        r0.cae = r6;
    L_0x0497:
        r6 = com.tencent.mm.h.a.su();
        r0 = r19;
        r0.cai = r6;
        r0 = r17;
        r1 = r19;
        r1.cal = r0;
        r0 = r18;
        r1 = r19;
        r1.cam = r0;
        r0 = r19;
        r6 = r0.bZY;
        r0 = r19;
        r7 = r0.mContext;
        r0 = r17;
        r1 = r18;
        r6.a(r7, r0, r1, r5);
        r0 = r19;
        r6 = r0.bZZ;
        r0 = r30;
        r1 = r31;
        r6.n(r0, r1);
        r0 = r19;
        r9 = r0.caa;
        r0 = r19;
        r10 = r0.mContext;
        r0 = r19;
        r7 = r0.caf;
        r0 = r19;
        r6 = r0.cah;
        r0 = r19;
        r11 = r0.cai;
        if (r8 == 0) goto L_0x0656;
    L_0x04db:
        r9.OH = r8;
    L_0x04dd:
        r0 = r19;
        r6 = r0.cai;
        if (r6 == 0) goto L_0x0931;
    L_0x04e3:
        r0 = r19;
        r11 = r0.cab;
        r0 = r19;
        r0 = r0.mContext;
        r20 = r0;
        r0 = r19;
        r6 = r0.cah;
        r0 = r19;
        r0 = r0.cae;
        r21 = r0;
        r9 = "";
        r7 = com.tencent.mm.h.i.dD(r13);
        if (r6 < 0) goto L_0x06d1;
    L_0x0500:
        if (r7 == 0) goto L_0x06d7;
    L_0x0502:
        r7 = 1;
        r7 = java.lang.Math.max(r7, r6);
        r6 = 2131233300; // 0x7f080a14 float:1.8082734E38 double:1.052969157E-314;
        r0 = r20;
        r6 = r0.getString(r6);
        r8 = r20.getResources();
        r10 = 2131361812; // 0x7f0a0014 float:1.8343387E38 double:1.05303265E-314;
        r12 = 1;
        r12 = new java.lang.Object[r12];
        r22 = 0;
        r23 = java.lang.Integer.valueOf(r7);
        r12[r22] = r23;
        r7 = r8.getQuantityString(r10, r7, r12);
        r8 = r7;
    L_0x0527:
        com.tencent.mm.model.ak.yW();
        r10 = com.tencent.mm.model.c.wJ();
        r22 = r10.MI(r13);
        r23 = com.tencent.mm.h.i.dE(r13);
        r12 = 0;
        if (r23 == 0) goto L_0x09fc;
    L_0x0539:
        r10 = com.tencent.mm.h.i.dG(r13);
        r24 = com.tencent.mm.h.i.dF(r13);
        if (r10 <= 0) goto L_0x09fc;
    L_0x0543:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r25 = 2131233697; // 0x7f080ba1 float:1.8083539E38 double:1.052969353E-314;
        r0 = r20;
        r1 = r25;
        r25 = r0.getString(r1);
        r0 = r25;
        r10 = r10.append(r0);
        if (r24 != 0) goto L_0x07b4;
    L_0x055b:
        r24 = 1;
        r0 = r21;
        r1 = r24;
        if (r0 <= r1) goto L_0x079e;
    L_0x0563:
        r8 = r10.append(r8);
        r8 = r8.toString();
        r10 = r8;
    L_0x056c:
        if (r33 == 0) goto L_0x07b9;
    L_0x056e:
        r8 = 0;
        r9 = r12;
    L_0x0570:
        if (r33 == 0) goto L_0x0927;
    L_0x0572:
        if (r23 == 0) goto L_0x091c;
    L_0x0574:
        r7 = r30;
    L_0x0576:
        r12 = 1;
        r0 = r21;
        if (r0 <= r12) goto L_0x092a;
    L_0x057b:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = r20.getResources();
        r12 = 2131361813; // 0x7f0a0015 float:1.8343389E38 double:1.0530326507E-314;
        r16 = 1;
        r0 = r16;
        r0 = new java.lang.Object[r0];
        r16 = r0;
        r20 = 0;
        r22 = java.lang.Integer.valueOf(r21);
        r16[r20] = r22;
        r0 = r21;
        r1 = r16;
        r10 = r10.getQuantityString(r12, r0, r1);
        r9 = r9.append(r10);
        r7 = r9.append(r7);
        r7 = r7.toString();
    L_0x05ab:
        r11.mTitle = r6;
        r11.can = r7;
        r6 = r11;
    L_0x05b0:
        r6.cao = r8;
        r0 = r19;
        r7 = r0.cad;
        r0 = r19;
        r6 = r0.cai;
        if (r6 != 0) goto L_0x05da;
    L_0x05bc:
        r8 = r7.bZN;
        if (r8 == 0) goto L_0x05da;
    L_0x05c0:
        r8 = "MicroMsg.NotificationAvatar";
        r9 = "recycle bitmap:%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = r7.bZN;
        r12 = r12.toString();
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.v.i(r8, r9, r10);
        r8 = r7.bZN;
        r8.recycle();
    L_0x05da:
        r8 = 0;
        r7.bZN = r8;
        r8 = com.tencent.mm.sdk.platformtools.aa.getContext();
        if (r6 == 0) goto L_0x05f4;
    L_0x05e3:
        r6 = com.tencent.mm.h.i.dD(r13);
        if (r6 != 0) goto L_0x05f4;
    L_0x05e9:
        if (r8 == 0) goto L_0x05f1;
    L_0x05eb:
        r6 = com.tencent.mm.platformtools.t.kS(r13);
        if (r6 == 0) goto L_0x09d8;
    L_0x05f1:
        r6 = 0;
    L_0x05f2:
        r7.bZN = r6;
    L_0x05f4:
        r6 = com.tencent.mm.booter.notification.queue.b.qC();
        r16 = r6.de(r13);
        r6 = r4.aRL;
        r6 = r6.bZZ;
        r6 = r6.bZP;
        r7 = r4.aRL;
        r7 = r7.bZY;
        r7 = r7.bZO;
        r8 = r4.aRL;
        r9 = r8.caa;
        r8 = r8.mContext;
        r10 = r9.OH;
        if (r10 != 0) goto L_0x09e9;
    L_0x0612:
        r8 = 0;
    L_0x0613:
        r9 = r4.aRL;
        r9 = r9.cab;
        r9 = r9.mTitle;
        r10 = r4.aRL;
        r10 = r10.cab;
        r10 = r10.can;
        r11 = r4.aRL;
        r11 = r11.cab;
        r11 = r11.cao;
        r12 = r4.aRL;
        r12 = r12.cad;
        r12 = r12.bZN;
        r5 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13);
        r6 = new com.tencent.mm.booter.notification.NotificationItem;
        r0 = r16;
        r6.<init>(r0, r13, r5);
        r6.bZz = r14;
        r5 = com.tencent.mm.h.i.dC(r13);
        r6.bZA = r5;
        r5 = r4.aRL;
        r4.a(r6, r5);
        r4 = r4.aRL;
        r5 = -1;
        r4.cah = r5;
        r5 = -1;
        r4.caf = r5;
        r5 = -1;
        r4.cag = r5;
        r5 = -1;
        r4.cae = r5;
        goto L_0x03c1;
    L_0x0653:
        r6 = 0;
        goto L_0x0466;
    L_0x0656:
        r8 = com.tencent.mm.h.i.dF(r13);
        if (r6 < 0) goto L_0x06a4;
    L_0x065c:
        r12 = new android.content.Intent;
        r20 = com.tencent.mm.ui.LauncherUI.class;
        r0 = r20;
        r12.<init>(r10, r0);
        r10 = "nofification_type";
        r20 = "new_msg_nofification";
        r0 = r20;
        r12.putExtra(r10, r0);
        r10 = "Main_User";
        r12.putExtra(r10, r13);
        r10 = "MainUI_User_Last_Msg_Type";
        r0 = r31;
        r12.putExtra(r10, r0);
        r10 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r12.addFlags(r10);
        r10 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r12.addFlags(r10);
        if (r11 == 0) goto L_0x06a9;
    L_0x068a:
        r7 = "talkerCount";
        r10 = 1;
        r12.putExtra(r7, r10);
        if (r8 != 0) goto L_0x06a0;
    L_0x0693:
        r7 = "Intro_Is_Muti_Talker";
        r8 = 0;
        r12.putExtra(r7, r8);
        r7 = "Intro_Bottle_unread_count";
        r12.putExtra(r7, r6);
    L_0x06a0:
        r9.OH = r12;
        goto L_0x04dd;
    L_0x06a4:
        r6 = com.tencent.mm.h.i.te();
        goto L_0x065c;
    L_0x06a9:
        if (r7 < 0) goto L_0x06c4;
    L_0x06ab:
        r10 = 1;
        if (r7 > r10) goto L_0x06c9;
    L_0x06ae:
        if (r8 != 0) goto L_0x06c9;
    L_0x06b0:
        r8 = "Intro_Is_Muti_Talker";
        r10 = 0;
        r12.putExtra(r8, r10);
        r8 = "Intro_Bottle_unread_count";
        r12.putExtra(r8, r6);
    L_0x06bd:
        r6 = "talkerCount";
        r12.putExtra(r6, r7);
        goto L_0x06a0;
    L_0x06c4:
        r7 = com.tencent.mm.h.i.tb();
        goto L_0x06ab;
    L_0x06c9:
        r6 = "Intro_Is_Muti_Talker";
        r8 = 1;
        r12.putExtra(r6, r8);
        goto L_0x06bd;
    L_0x06d1:
        r6 = com.tencent.mm.h.i.te();
        goto L_0x0500;
    L_0x06d7:
        r6 = 0;
        r7 = android.text.TextUtils.isEmpty(r13);
        if (r7 == 0) goto L_0x0709;
    L_0x06de:
        r6 = 0;
    L_0x06df:
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r7 == 0) goto L_0x06f4;
    L_0x06e5:
        r6 = com.tencent.mm.h.i.dE(r13);
        if (r6 == 0) goto L_0x0793;
    L_0x06eb:
        r6 = 2131231879; // 0x7f080487 float:1.8079851E38 double:1.0529684547E-314;
        r0 = r20;
        r6 = r0.getString(r6);
    L_0x06f4:
        r7 = com.tencent.mm.bf.b.buL();
        r6 = r7.Lk(r6);
    L_0x06fc:
        r0 = r20;
        r1 = r30;
        r2 = r31;
        r7 = com.tencent.mm.booter.notification.a.h.a(r0, r1, r13, r2);
        r8 = r7;
        goto L_0x0527;
    L_0x0709:
        com.tencent.mm.model.ak.yW();
        r7 = com.tencent.mm.model.c.wH();
        r7 = r7.LX(r13);
        if (r7 != 0) goto L_0x0718;
    L_0x0716:
        r6 = 0;
        goto L_0x06df;
    L_0x0718:
        r8 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r31;
        if (r0 != r8) goto L_0x0731;
    L_0x071f:
        r8 = android.text.TextUtils.isEmpty(r30);
        if (r8 != 0) goto L_0x0731;
    L_0x0725:
        r0 = r30;
        r6 = com.tencent.mm.q.a.a.C(r0, r13);
        r8 = android.text.TextUtils.isEmpty(r6);
        if (r8 == 0) goto L_0x06df;
    L_0x0731:
        r8 = com.tencent.mm.model.m.fk(r13);
        if (r8 == 0) goto L_0x073c;
    L_0x0737:
        r6 = r7.tT();
        goto L_0x06df;
    L_0x073c:
        r8 = com.tencent.mm.storage.u.ew(r13);
        if (r8 == 0) goto L_0x075a;
    L_0x0742:
        r6 = 2131231515; // 0x7f08031b float:1.8079113E38 double:1.052968275E-314;
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r10 = 0;
        r7 = com.tencent.mm.booter.notification.a.h.b(r7);
        r8[r10] = r7;
        r0 = r20;
        r6 = r0.getString(r6, r8);
        r6 = r6.trim();
        goto L_0x06df;
    L_0x075a:
        r8 = com.tencent.mm.h.i.dE(r13);
        if (r8 == 0) goto L_0x077d;
    L_0x0760:
        r8 = r7.field_nickname;
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r8 == 0) goto L_0x077d;
    L_0x0768:
        r7 = com.tencent.mm.model.ak.yW();
        r7 = r7.wO();
        r7 = r7.er(r13);
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r7);
        if (r8 != 0) goto L_0x06df;
    L_0x077a:
        r6 = r7;
        goto L_0x06df;
    L_0x077d:
        r8 = r7.tU();
        if (r8 == 0) goto L_0x06df;
    L_0x0783:
        r8 = r7.tU();
        r8 = r8.length();
        if (r8 <= 0) goto L_0x06df;
    L_0x078d:
        r6 = r7.tU();
        goto L_0x06df;
    L_0x0793:
        r6 = 2131233300; // 0x7f080a14 float:1.8082734E38 double:1.052969157E-314;
        r0 = r20;
        r6 = r0.getString(r6);
        goto L_0x06fc;
    L_0x079e:
        r8 = new java.lang.StringBuilder;
        r24 = " ";
        r0 = r24;
        r8.<init>(r0);
        r0 = r30;
        r8 = r8.append(r0);
        r8 = r8.toString();
        goto L_0x0563;
    L_0x07b4:
        r8 = "";
        goto L_0x0563;
    L_0x07b9:
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r16);
        if (r8 != 0) goto L_0x07c4;
    L_0x07bf:
        r9 = r12;
        r8 = r16;
        goto L_0x0570;
    L_0x07c4:
        if (r22 == 0) goto L_0x08a3;
    L_0x07c6:
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r26 = -1;
        r8 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1));
        if (r8 == 0) goto L_0x08a3;
    L_0x07d2:
        r8 = com.tencent.mm.modelbiz.e.hC(r13);
        if (r8 == 0) goto L_0x08a3;
    L_0x07d8:
        r12 = 1;
        r8 = com.tencent.mm.modelbiz.u.DA();
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r0 = r24;
        r8 = r8.Z(r0);
        r16 = r8.DN();
        if (r16 == 0) goto L_0x0864;
    L_0x07ef:
        r9 = r8.field_chatName;
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r9 == 0) goto L_0x0845;
    L_0x07f7:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r16 = 2131234604; // 0x7f080f2c float:1.8085378E38 double:1.052969801E-314;
        r0 = r16;
        r9 = r9.getString(r0);
        r8 = r8.append(r9);
        r9 = ": ";
        r8 = r8.append(r9);
        r9 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r8 = r8.append(r9);
        r8 = r8.toString();
    L_0x0820:
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r9 == 0) goto L_0x0842;
    L_0x0826:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r8 = r8.append(r6);
        r9 = ": ";
        r8 = r8.append(r9);
        r7 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r7 = r8.append(r7);
        r8 = r7.toString();
    L_0x0842:
        r9 = r12;
        goto L_0x0570;
    L_0x0845:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r8 = r8.field_chatName;
        r8 = r9.append(r8);
        r9 = ": ";
        r8 = r8.append(r9);
        r9 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r8 = r8.append(r9);
        r8 = r8.toString();
        goto L_0x0820;
    L_0x0864:
        r8 = com.tencent.mm.modelbiz.u.DC();
        r0 = r22;
        r0 = r0.field_bizChatUserId;
        r16 = r0;
        r0 = r16;
        r8 = r8.ig(r0);
        if (r8 == 0) goto L_0x09f9;
    L_0x0876:
        r9 = r8.field_userName;
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r9 == 0) goto L_0x0883;
    L_0x087e:
        r8 = com.tencent.mm.booter.notification.a.h.dl(r7);
        goto L_0x0820;
    L_0x0883:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r8 = r8.field_userName;
        r8 = r9.append(r8);
        r9 = ": ";
        r8 = r8.append(r9);
        r9 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r8 = r8.append(r9);
        r8 = r8.toString();
        goto L_0x0820;
    L_0x08a3:
        if (r23 != 0) goto L_0x08c4;
    L_0x08a5:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r8 = r8.append(r6);
        r9 = ": ";
        r8 = r8.append(r9);
        r7 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r7 = r8.append(r7);
        r8 = r7.toString();
        r9 = r12;
        goto L_0x0570;
    L_0x08c4:
        r8 = ":\n";
        r8 = r7.contains(r8);
        if (r8 == 0) goto L_0x0915;
    L_0x08cd:
        r8 = com.tencent.mm.model.aw.fM(r7);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r16 = ":\n";
        r0 = r16;
        r16 = r7.contains(r0);
        if (r16 == 0) goto L_0x090e;
    L_0x08e1:
        r16 = 0;
        r22 = ":\n";
        r0 = r22;
        r22 = r7.indexOf(r0);
        r0 = r16;
        r1 = r22;
        r7 = r7.substring(r0, r1);
    L_0x08f4:
        r7 = r9.append(r7);
        r9 = ": ";
        r7 = r7.append(r9);
        r8 = com.tencent.mm.booter.notification.a.h.dl(r8);
        r7 = r7.append(r8);
        r8 = r7.toString();
        r9 = r12;
        goto L_0x0570;
    L_0x090e:
        r0 = r20;
        r7 = com.tencent.mm.booter.notification.a.h.f(r0, r13, r7);
        goto L_0x08f4;
    L_0x0915:
        r8 = com.tencent.mm.booter.notification.a.h.dl(r7);
        r9 = r12;
        goto L_0x0570;
    L_0x091c:
        r7 = 2131234103; // 0x7f080d37 float:1.8084362E38 double:1.0529695535E-314;
        r0 = r20;
        r7 = r0.getString(r7);
        goto L_0x0576;
    L_0x0927:
        r7 = r8;
        goto L_0x0576;
    L_0x092a:
        if (r23 != 0) goto L_0x05ab;
    L_0x092c:
        if (r9 == 0) goto L_0x09f6;
    L_0x092e:
        r7 = r8;
        goto L_0x05ab;
    L_0x0931:
        r0 = r19;
        r7 = r0.cab;
        r0 = r19;
        r10 = r0.mContext;
        r0 = r19;
        r9 = r0.caf;
        r0 = r19;
        r6 = r0.cag;
        r0 = r19;
        r8 = r0.cah;
        if (r9 < 0) goto L_0x09a0;
    L_0x0947:
        if (r6 < 0) goto L_0x09a5;
    L_0x0949:
        r11 = 1;
        r9 = java.lang.Math.max(r11, r9);
        r11 = 1;
        r11 = java.lang.Math.max(r11, r6);
        if (r8 < 0) goto L_0x09aa;
    L_0x0955:
        r6 = r8;
    L_0x0956:
        r8 = 1;
        if (r9 != r8) goto L_0x09af;
    L_0x0959:
        if (r6 <= 0) goto L_0x09af;
    L_0x095b:
        r8 = r10.getResources();
        r9 = 2131361812; // 0x7f0a0014 float:1.8343387E38 double:1.05303265E-314;
        r11 = 1;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r16 = java.lang.Integer.valueOf(r6);
        r11[r12] = r16;
        r6 = r8.getQuantityString(r9, r6, r11);
    L_0x0970:
        r8 = 0;
        r8 = com.tencent.mm.h.i.dG(r8);
        if (r8 <= 0) goto L_0x098f;
    L_0x0977:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = 2131233697; // 0x7f080ba1 float:1.8083539E38 double:1.052969353E-314;
        r9 = r10.getString(r9);
        r8 = r8.append(r9);
        r6 = r8.append(r6);
        r6 = r6.toString();
    L_0x098f:
        r7.can = r6;
        r6 = 2131233300; // 0x7f080a14 float:1.8082734E38 double:1.052969157E-314;
        r6 = r10.getString(r6);
        r7.mTitle = r6;
        if (r33 == 0) goto L_0x09ce;
    L_0x099c:
        r8 = 0;
        r6 = r7;
        goto L_0x05b0;
    L_0x09a0:
        r9 = com.tencent.mm.h.i.tb();
        goto L_0x0947;
    L_0x09a5:
        r6 = com.tencent.mm.h.i.td();
        goto L_0x0949;
    L_0x09aa:
        r6 = com.tencent.mm.h.i.te();
        goto L_0x0956;
    L_0x09af:
        r6 = r10.getResources();
        r8 = 2131361814; // 0x7f0a0016 float:1.834339E38 double:1.053032651E-314;
        r12 = 2;
        r12 = new java.lang.Object[r12];
        r16 = 0;
        r20 = java.lang.Integer.valueOf(r9);
        r12[r16] = r20;
        r16 = 1;
        r11 = java.lang.Integer.valueOf(r11);
        r12[r16] = r11;
        r6 = r6.getQuantityString(r8, r9, r12);
        goto L_0x0970;
    L_0x09ce:
        r6 = 2131234104; // 0x7f080d38 float:1.8084364E38 double:1.052969554E-314;
        r8 = r10.getString(r6);
        r6 = r7;
        goto L_0x05b0;
    L_0x09d8:
        r6 = 0;
        r9 = -1;
        r6 = com.tencent.mm.u.b.a(r13, r6, r9);
        if (r6 != 0) goto L_0x09e3;
    L_0x09e0:
        r6 = 0;
        goto L_0x05f2;
    L_0x09e3:
        r6 = com.tencent.mm.booter.notification.a.a.b(r8, r6);
        goto L_0x05f2;
    L_0x09e9:
        r9 = r9.OH;
        r0 = r16;
        r8 = com.tencent.mm.booter.notification.a.d.a(r8, r0, r9);
        goto L_0x0613;
    L_0x09f3:
        r4 = 0;
        goto L_0x03d1;
    L_0x09f6:
        r7 = r10;
        goto L_0x05ab;
    L_0x09f9:
        r8 = r9;
        goto L_0x0820;
    L_0x09fc:
        r10 = r8;
        goto L_0x056c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.b.a(com.tencent.mm.booter.notification.b, java.lang.String, java.lang.String, int, int, boolean):void");
    }

    public b(Context context) {
        this.context = context;
        this.bdo = SQLiteDatabase.KeyEmpty;
        this.bYV = SQLiteDatabase.KeyEmpty;
        this.bYT = SQLiteDatabase.KeyEmpty;
        this.bYZ = 0;
        this.bYY = false;
        this.bYW = null;
        this.bZb = new e();
        l.a(this);
        com.tencent.mm.modelvoice.e.a((ac) this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        com.tencent.mm.sdk.c.a.nhr.e(this.bZe);
        com.tencent.mm.sdk.c.a.nhr.e(this.bZd);
    }

    public final void db(String str) {
        this.bYT = str;
    }

    public final String qr() {
        return this.bYT;
    }

    public final void cancelNotification(String str) {
        Object obj = 1;
        v.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.bYU + "  curChattingTalker:" + this.bYT + " talker count:" + this.bYX);
        if (this.bYY) {
            if (!(this.bYU != null && this.bYU.equals(this.bYT) && this.bYX == 1)) {
                obj = null;
            }
            if (obj != null) {
                cancel();
                return;
            }
            ak.yW();
            af Mh = com.tencent.mm.model.c.wK().Mh(str);
            if (Mh != null && Mh.field_unReadCount != 0) {
                cancel();
            } else if (n.fv(m.crA) == 0) {
                cancel();
            }
        }
    }

    public final void qs() {
        try {
            String string = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String KL : string.split(",")) {
                    int KL2 = be.KL(KL);
                    if (KL2 > 0) {
                        ak.oH().cancel(KL2);
                    }
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.MMNotification", e, "try cancel notification fail: %s", e.getMessage());
        }
    }

    public final void oz() {
        v.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
    }

    private void cancel() {
        this.bYY = false;
        e.cancel();
    }

    public final void a(at atVar) {
        if (atVar != null) {
            if (atVar.field_isSend == 1) {
                v.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(atVar.field_msgSvrId));
                return;
            }
            com.tencent.mm.model.aw.b fP = aw.fP(atVar.bNo);
            if (fP == null || fP.scene != 1) {
                int b = i.b(atVar);
                this.bmk = atVar;
                this.bdo = atVar.field_talker;
                String str = atVar.field_content;
                int i = atVar.field_type;
                this.bYV = SQLiteDatabase.KeyEmpty;
                this.bYW = null;
                v.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.bdo, Long.valueOf(atVar.field_msgSvrId), Integer.valueOf(i), Integer.valueOf(b), be.KW(str));
                if (this.bZa.a(this.bdo, this.bmk, b, false)) {
                    this.bZc.sendMessageDelayed(a(this.bdo, str, i, b, 0), 200);
                } else {
                    v.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                }
            }
        }
    }

    static Message a(String str, String str2, int i, int i2, int i3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        return obtain;
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void q(List<at> list) {
        int i;
        if (list == null || list.size() <= 0) {
            String str = "MicroMsg.MMNotification";
            String str2 = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            if (list == null) {
                i = -1;
            } else {
                i = list.size();
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        bx bxVar;
        int size = list.size() - 1;
        i = 0;
        while (size >= 0) {
            bx bxVar2 = (at) list.get(size);
            int b = i.b(bxVar2);
            if (this.bZa.a(bxVar2.field_talker, bxVar2, b, false)) {
                int i2 = b;
                bxVar = bxVar2;
                i = i2;
                break;
            }
            size--;
            i = b;
        }
        bxVar = null;
        if (bxVar == null) {
            v.w("MicroMsg.MMNotification", "notifyOther msg == null");
            return;
        }
        this.bYV = SQLiteDatabase.KeyEmpty;
        this.bdo = bxVar.field_talker;
        str2 = bxVar.field_content;
        size = bxVar.field_type;
        this.bmk = bxVar;
        v.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.bdo, Long.valueOf(bxVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(i), be.KW(str2));
        this.bZc.sendMessageDelayed(a(this.bdo, str2, size, i, 0), 200);
    }

    public final void dc(String str) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.putExtra("Intro_Notify_User", this.bdo);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        if (!be.kS(str) && str.startsWith("autoauth_errmsg_")) {
            str = str.substring(16);
        }
        if (!be.kS(str) && str.startsWith("<")) {
            Map q = bf.q(str, "e");
            if (!(q == null || be.kS((String) q.get(".e.Content")))) {
                str = (String) q.get(".e.Content");
            }
        }
        Notification notification = new Builder(this.context).setContentTitle(str).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        notification.icon = a.bmo();
        notification.flags = 16;
        a(notification, true);
    }

    public final void dz(int i) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        intent.putExtra("nofification_type", "update_nofification");
        intent.putExtra("show_update_dialog", true);
        intent.putExtra("update_type", i);
        Notification notification = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(2131231170)).setContentText(this.context.getString(2131231137)).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 0)).getNotification();
        notification.flags |= 16;
        a(34, notification, false);
    }

    @TargetApi(16)
    public final boolean qt() {
        boolean z = true;
        v.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", ((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName());
        if (MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
            z = false;
        }
        if (z) {
            Notification build;
            Intent intent = new Intent(this.context, MobileVerifyUI.class);
            intent.addFlags(2);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(67108864);
            intent.putExtra("nofification_type", "no_reg_notification");
            PendingIntent activity = PendingIntent.getActivity(this.context, 36, intent, 1073741824);
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(this.context);
                builder.setContentTitle(this.context.getString(2131231134));
                builder.setSmallIcon(a.bmo());
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                build = new BigTextStyle(builder).bigText(this.context.getString(2131233836)).build();
                build.defaults |= 1;
                build.flags |= 16;
            } else {
                build = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(2131231134)).setContentText(this.context.getString(2131233836)).setContentIntent(activity).getNotification();
                build.icon = a.bmo();
                build.defaults |= 1;
                build.flags |= 16;
            }
            a(36, build, false);
        }
        return z;
    }

    public final void qu() {
        cancel(36);
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        com.tencent.mm.ay.c.a("webview", new com.tencent.mm.platformtools.k.AnonymousClass1(str3, str4, bundle, str, str2, i), new com.tencent.mm.ay.b() {
            public final void b(Exception exception) {
                v.e("MiroMsg.NotificationUtil", "Load plugin failed");
            }
        });
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6) {
        return a.bZF.bZE.bZw.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, 2130838805, str4, pendingIntent2, 2130838804, str5, pendingIntent3, str6);
    }

    public final void k(int i, String str) {
        a.bZF.k(i, str);
    }

    public final void qv() {
        a.bZF;
        c.qv();
    }

    public final void dA(int i) {
        d.dD(i);
    }

    public final void k(String str, int i) {
        d.l(str, i);
    }

    public final void aq(boolean z) {
        d.ar(z);
    }

    public final void dB(int i) {
        a.bZF;
        if (i != 0) {
            List<Integer> dE = com.tencent.mm.booter.notification.queue.b.qC().bZL.dE(i);
            if (!dE.isEmpty()) {
                ad h = ad.h(com.tencent.mm.sdk.platformtools.aa.getContext());
                for (Integer intValue : dE) {
                    com.tencent.mm.booter.notification.queue.b.qC().a(h, intValue.intValue());
                }
            }
        }
    }

    public final void notify(int i, Notification notification) {
        a(i, notification, true);
    }

    public final void a(int i, Notification notification, boolean z) {
        a.bZF.a(new NotificationItem(i, notification, z));
    }

    public final int a(Notification notification, boolean z) {
        return a.bZF.a(new NotificationItem(notification, z));
    }

    public final int b(Notification notification) {
        return a(notification, true);
    }

    public final void cancel(int i) {
        a.bZF;
        com.tencent.mm.booter.notification.queue.b.qC().cancel(i);
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a.bZF.bZE.bZw.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
    }
}
