package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import java.util.LinkedList;

public class NotifyFreqLimit extends BroadcastReceiver {
    private static long beginTime = 0;
    private static byte[] cGJ = new byte[0];
    private static a cRU = null;
    private static m cRV = null;
    private static int cRW = 0;
    private static long[] cRX = null;
    private static LinkedList<Object> cRY = new LinkedList();
    private static int cRZ = 0;
    private static Boolean cSa = null;
    private static Boolean cSb = null;
    private static long cSc = 0;
    private static PendingIntent cSd = null;

    public interface a {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r23, android.content.Intent r24) {
        /*
        r22 = this;
        r11 = cGJ;	 Catch:{ Throwable -> 0x00fb }
        monitor-enter(r11);	 Catch:{ Throwable -> 0x00fb }
        if (r24 == 0) goto L_0x0012;
    L_0x0005:
        r2 = "com.tencent.mm.NotifyFreqLimit.AlarmReceiver";
        r3 = r24.getAction();	 Catch:{ all -> 0x00f8 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x00f8 }
        if (r2 != 0) goto L_0x002d;
    L_0x0012:
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver onReceive intent:%s";
        r2 = 1;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        if (r24 != 0) goto L_0x0028;
    L_0x001e:
        r2 = "intent is null";
    L_0x0021:
        r5[r6] = r2;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
        monitor-exit(r11);	 Catch:{ all -> 0x00f8 }
    L_0x0027:
        return;
    L_0x0028:
        r2 = r24.getAction();	 Catch:{ all -> 0x00f8 }
        goto L_0x0021;
    L_0x002d:
        r2 = "hashCode";
        r4 = 0;
        r0 = r24;
        r12 = r0.getLongExtra(r2, r4);	 Catch:{ all -> 0x00f8 }
        r2 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ all -> 0x00f8 }
        r14 = r2 - r12;
        r2 = "pid";
        r3 = 0;
        r0 = r24;
        r2 = r0.getIntExtra(r2, r3);	 Catch:{ all -> 0x00f8 }
        r3 = "delaySecond";
        r4 = 0;
        r0 = r24;
        r4 = r0.getLongExtra(r3, r4);	 Catch:{ all -> 0x00f8 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r4 * r6;
        r18 = android.os.Process.myPid();	 Catch:{ all -> 0x00f8 }
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x00f8 }
        r20 = r3.getId();	 Catch:{ all -> 0x00f8 }
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 2;
        r7 = java.lang.Integer.valueOf(r18);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 3;
        r7 = java.lang.Long.valueOf(r20);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 4;
        r7 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 5;
        r7 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 6;
        r7 = cSd;	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 7;
        r7 = cRU;	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
        r3 = cSd;	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0120;
    L_0x00a8:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x00f8 }
        r4 = 99;
        r6 = 156; // 0x9c float:2.19E-43 double:7.7E-322;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x00f8 }
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r2;	 Catch:{ all -> 0x00f8 }
        r2 = 2;
        r6 = java.lang.Integer.valueOf(r18);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 3;
        r6 = java.lang.Long.valueOf(r20);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 4;
        r6 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 5;
        r6 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 6;
        r6 = cSd;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 7;
        r6 = cRU;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
        monitor-exit(r11);	 Catch:{ all -> 0x00f8 }
        goto L_0x0027;
    L_0x00f8:
        r2 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x00f8 }
        throw r2;	 Catch:{ Throwable -> 0x00fb }
    L_0x00fb:
        r2 = move-exception;
        r3 = 0;
        cSd = r3;
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 99;
        r6 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver onReceive e:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.e(r2);
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
        goto L_0x0027;
    L_0x0120:
        r3 = 0;
        cSd = r3;	 Catch:{ all -> 0x00f8 }
        r0 = r18;
        if (r0 == r2) goto L_0x0177;
    L_0x0127:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x00f8 }
        r4 = 99;
        r6 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x00f8 }
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r2;	 Catch:{ all -> 0x00f8 }
        r2 = 2;
        r6 = java.lang.Integer.valueOf(r18);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 3;
        r6 = java.lang.Long.valueOf(r20);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 4;
        r6 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 5;
        r6 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 6;
        r6 = cSd;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 7;
        r6 = cRU;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
        monitor-exit(r11);	 Catch:{ all -> 0x00f8 }
        goto L_0x0027;
    L_0x0177:
        r4 = 5;
        r4 = r4 * r16;
        r3 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r3 < 0) goto L_0x0188;
    L_0x017f:
        r4 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r4 = r4 + r16;
        r3 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r3 >= 0) goto L_0x0240;
    L_0x0188:
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 2;
        r7 = java.lang.Integer.valueOf(r18);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 3;
        r7 = java.lang.Long.valueOf(r20);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 4;
        r7 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 5;
        r7 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 6;
        r7 = cSd;	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 7;
        r7 = cRU;	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x00f8 }
        cSb = r3;	 Catch:{ all -> 0x00f8 }
        r3 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ all -> 0x00f8 }
        r4 = "NOTIFY_FREQ_LIMIT_INFO";
        r5 = 0;
        r3 = r3.getSharedPreferences(r4, r5);	 Catch:{ all -> 0x00f8 }
        r4 = "NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY";
        r5 = "";
        r4 = r3.getString(r4, r5);	 Catch:{ all -> 0x00f8 }
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r4);	 Catch:{ all -> 0x00f8 }
        r3 = r3.edit();	 Catch:{ all -> 0x00f8 }
        r5 = "NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r6.<init>();	 Catch:{ all -> 0x00f8 }
        r8 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ all -> 0x00f8 }
        r6 = r6.append(r8);	 Catch:{ all -> 0x00f8 }
        r7 = ",";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00f8 }
        r6 = r6.append(r4);	 Catch:{ all -> 0x00f8 }
        r6 = r6.toString();	 Catch:{ all -> 0x00f8 }
        r3.putString(r5, r6);	 Catch:{ all -> 0x00f8 }
        r3.commit();	 Catch:{ all -> 0x00f8 }
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r4);	 Catch:{ all -> 0x00f8 }
        if (r3 == 0) goto L_0x022c;
    L_0x0219:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x00f8 }
        r5 = 11098; // 0x2b5a float:1.5552E-41 double:5.483E-320;
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00f8 }
        r7 = 0;
        r8 = 3103; // 0xc1f float:4.348E-42 double:1.533E-320;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ all -> 0x00f8 }
        r3.h(r5, r6);	 Catch:{ all -> 0x00f8 }
    L_0x022c:
        r3 = "MicroMsg.NotifyFreqLimit";
        r5 = "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00f8 }
        r7 = 0;
        r8 = cSb;	 Catch:{ all -> 0x00f8 }
        r6[r7] = r8;	 Catch:{ all -> 0x00f8 }
        r7 = 1;
        r6[r7] = r4;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r5, r6);	 Catch:{ all -> 0x00f8 }
    L_0x0240:
        r3 = cRU;	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0291;
    L_0x0244:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x00f8 }
        r4 = 99;
        r6 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x00f8 }
        r3 = "MicroMsg.NotifyFreqLimit";
        r4 = "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f8 }
        r6 = 0;
        r7 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x00f8 }
        r6 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00f8 }
        r5[r6] = r2;	 Catch:{ all -> 0x00f8 }
        r2 = 2;
        r6 = java.lang.Integer.valueOf(r18);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 3;
        r6 = java.lang.Long.valueOf(r20);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 4;
        r6 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 5;
        r6 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 6;
        r6 = cSd;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        r2 = 7;
        r6 = cRU;	 Catch:{ all -> 0x00f8 }
        r5[r2] = r6;	 Catch:{ all -> 0x00f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00f8 }
    L_0x0291:
        monitor-exit(r11);	 Catch:{ all -> 0x00f8 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelmulti.NotifyFreqLimit.onReceive(android.content.Context, android.content.Intent):void");
    }
}
