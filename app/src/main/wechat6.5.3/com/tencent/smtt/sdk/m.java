package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.t;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class m {
    private static final Lock pwA = new ReentrantLock();
    public static ThreadLocal<Integer> pwC = new ThreadLocal<Integer>() {
        public final /* synthetic */ Object initialValue() {
            return Integer.valueOf(0);
        }
    };
    private static Handler pwD = null;
    private static final Long[][] pwE;
    static boolean pwF = false;
    private static boolean pwG = false;
    private static m pwu = null;
    private static final Lock pwz = new ReentrantLock();
    private boolean pwB = false;
    private int pwv = 0;
    private FileLock pww;
    private FileOutputStream pwx;
    private boolean pwy = false;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        pwE = r0;
    }

    private m() {
        if (pwD == null) {
            pwD = new Handler(this, k.bNl().getLooper()) {
                final /* synthetic */ m pwH;

                public final void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    Object[] objArr;
                    switch (message.what) {
                        case 1:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            m.a(this.pwH, (Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 2:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            m.a(this.pwH, (Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 3:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                            objArr = (Object[]) message.obj;
                            this.pwH.e((Context) objArr[0], (Bundle) objArr[1]);
                            break;
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    super.handleMessage(message);
                }
            };
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.smtt.sdk.m r12, android.content.Context r13, android.content.Context r14, int r15) {
        /*
        r3 = 1;
        r4 = 0;
        r0 = com.tencent.smtt.sdk.i.fb(r13);
        r1 = -524; // 0xfffffffffffffdf4 float:NaN double:NaN;
        r0.yL(r1);
        r0 = r12.fg(r14);
        if (r0 != 0) goto L_0x0058;
    L_0x0011:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread start!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0059;
    L_0x0020:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);
    L_0x0028:
        r1 = "tbs_precheck_disable_version";
        r2 = -1;
        r0 = r0.getInt(r1, r2);
        if (r0 != r15) goto L_0x0061;
    L_0x0032:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r2 = "TbsInstaller-copyTbsCoreInThread -- version:";
        r1.<init>(r2);
        r1 = r1.append(r15);
        r2 = " is disabled by preload_x5_check!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
        r0 = com.tencent.smtt.sdk.i.fb(r13);
        r1 = -525; // 0xfffffffffffffdf3 float:NaN double:NaN;
        r0.yL(r1);
    L_0x0058:
        return;
    L_0x0059:
        r0 = "tbs_preloadx5_check_cfg_file";
        r0 = r14.getSharedPreferences(r0, r4);
        goto L_0x0028;
    L_0x0061:
        r0 = r12.fw(r14);
        if (r0 != 0) goto L_0x0071;
    L_0x0067:
        r0 = com.tencent.smtt.sdk.i.fb(r13);
        r1 = -526; // 0xfffffffffffffdf2 float:NaN double:NaN;
        r0.yL(r1);
        goto L_0x0058;
    L_0x0071:
        r0 = pwA;
        r0 = r0.tryLock();
        if (r0 == 0) goto L_0x04dc;
    L_0x0079:
        r0 = pwz;
        r0.lock();
        r0 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r1 = "copy_core_ver";
        r1 = r0.Qj(r1);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r2 = "copy_status";
        r0 = r0.Qi(r2);	 Catch:{ Exception -> 0x031a }
        if (r1 != r15) goto L_0x00b4;
    L_0x0096:
        r0 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ Exception -> 0x031a }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.hq(r1);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
    L_0x00b0:
        r12.bNo();
        goto L_0x0058;
    L_0x00b4:
        r2 = r12.fl(r14);	 Catch:{ Exception -> 0x031a }
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r7 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x031a }
        r6 = r6.append(r2);	 Catch:{ Exception -> 0x031a }
        r6 = r6.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Exception -> 0x031a }
        if (r2 != r15) goto L_0x00eb;
    L_0x00d0:
        r0 = com.tencent.smtt.sdk.QbSdk.puW;	 Catch:{ Exception -> 0x031a }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.hq(r1);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x00eb:
        r5 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r6 = "install_core_ver";
        r5 = r5.Qj(r6);	 Catch:{ Exception -> 0x031a }
        if (r5 <= 0) goto L_0x00fa;
    L_0x00f8:
        if (r15 > r5) goto L_0x00fe;
    L_0x00fa:
        if (r1 <= 0) goto L_0x0101;
    L_0x00fc:
        if (r15 <= r1) goto L_0x0101;
    L_0x00fe:
        fq(r14);	 Catch:{ Exception -> 0x031a }
    L_0x0101:
        r1 = 3;
        if (r0 != r1) goto L_0x011b;
    L_0x0104:
        if (r2 <= 0) goto L_0x011b;
    L_0x0106:
        if (r15 > r2) goto L_0x010d;
    L_0x0108:
        r1 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
        if (r15 != r1) goto L_0x011b;
    L_0x010d:
        r0 = -1;
        fq(r14);	 Catch:{ Exception -> 0x031a }
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.i(r1, r2, r5);	 Catch:{ Exception -> 0x031a }
    L_0x011b:
        r1 = com.tencent.smtt.utils.e.fZ(r14);	 Catch:{ Exception -> 0x031a }
        if (r1 != 0) goto L_0x0166;
    L_0x0121:
        r0 = com.tencent.smtt.utils.t.bOj();	 Catch:{ Exception -> 0x031a }
        r2 = com.tencent.smtt.sdk.i.fb(r14);	 Catch:{ Exception -> 0x031a }
        r2 = r2.bMY();	 Catch:{ Exception -> 0x031a }
        r4 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r5 = -529; // 0xfffffffffffffdef float:NaN double:NaN;
        r4.yL(r5);	 Catch:{ Exception -> 0x031a }
        r4 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r7 = "rom is not enough when copying tbs core! curAvailROM=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x031a }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x031a }
        r1 = ",minReqRom=";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x031a }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x031a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x031a }
        r4.aA(r5, r0);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x0166:
        if (r0 <= 0) goto L_0x0174;
    L_0x0168:
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x0174:
        if (r0 != 0) goto L_0x01b2;
    L_0x0176:
        r0 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r1 = "copy_retry_num";
        r0 = r0.Qj(r1);	 Catch:{ Exception -> 0x031a }
        r1 = 10;
        if (r0 <= r1) goto L_0x01a6;
    L_0x0185:
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r2 = "exceed copy retry num!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -530; // 0xfffffffffffffdee float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x01a6:
        r1 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r2 = "copy_retry_num";
        r0 = r0 + 1;
        r1.cq(r2, r0);	 Catch:{ Exception -> 0x031a }
    L_0x01b2:
        r0 = fr(r13);	 Catch:{ Exception -> 0x031a }
        r5 = fv(r14);	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x04ac;
    L_0x01bc:
        if (r5 == 0) goto L_0x04ac;
    L_0x01be:
        r1 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r2 = 0;
        r1.dG(r15, r2);	 Catch:{ Exception -> 0x031a }
        r1 = new com.tencent.smtt.utils.r;	 Catch:{ Exception -> 0x031a }
        r1.<init>();	 Catch:{ Exception -> 0x031a }
        r2 = new com.tencent.smtt.utils.r$b;	 Catch:{ Exception -> 0x031a }
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x031a }
        r1.pzI = r2;	 Catch:{ Exception -> 0x031a }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x031a }
        r2 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r8 = -551; // 0xfffffffffffffdd9 float:NaN double:NaN;
        r2.yL(r8);	 Catch:{ Exception -> 0x031a }
        r2 = com.tencent.smtt.utils.e.f(r0, r5);	 Catch:{ Exception -> 0x031a }
        r8 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r10 = "TbsInstaller-copyTbsCoreInThread time=";
        r9.<init>(r10);	 Catch:{ Exception -> 0x031a }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x031a }
        r6 = r10 - r6;
        r6 = r9.append(r6);	 Catch:{ Exception -> 0x031a }
        r6 = r6.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.i(r8, r6);	 Catch:{ Exception -> 0x031a }
        if (r2 == 0) goto L_0x0481;
    L_0x0201:
        r2 = new com.tencent.smtt.utils.r$b;	 Catch:{ Exception -> 0x031a }
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x031a }
        r1.pzJ = r2;	 Catch:{ Exception -> 0x031a }
        r0 = r1.pzJ;	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x0210;
    L_0x020c:
        r0 = r1.pzI;	 Catch:{ Exception -> 0x031a }
        if (r0 != 0) goto L_0x0241;
    L_0x0210:
        r0 = r4;
    L_0x0211:
        if (r0 != 0) goto L_0x0261;
    L_0x0213:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x031a }
        r0 = 1;
        com.tencent.smtt.utils.e.d(r5, r0);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify fail after copying tbs core!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -531; // 0xfffffffffffffded float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x0241:
        r0 = r1.pzJ;	 Catch:{ Exception -> 0x031a }
        r0 = r0.pzN;	 Catch:{ Exception -> 0x031a }
        r0 = r0.size();	 Catch:{ Exception -> 0x031a }
        r2 = r1.pzI;	 Catch:{ Exception -> 0x031a }
        r2 = r2.pzN;	 Catch:{ Exception -> 0x031a }
        r2 = r2.size();	 Catch:{ Exception -> 0x031a }
        if (r0 != r2) goto L_0x025f;
    L_0x0253:
        r0 = r1.pzI;	 Catch:{ Exception -> 0x031a }
        r1 = r1.pzJ;	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.utils.r.a(r0, r1);	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x025f;
    L_0x025d:
        r0 = r3;
        goto L_0x0211;
    L_0x025f:
        r0 = r4;
        goto L_0x0211;
    L_0x0261:
        r2 = 0;
        r1 = 0;
        r6 = new java.io.File;	 Catch:{ Exception -> 0x0307, all -> 0x0313 }
        r0 = "1";
        r6.<init>(r5, r0);	 Catch:{ Exception -> 0x0307, all -> 0x0313 }
        r0 = new java.util.Properties;	 Catch:{ Exception -> 0x0307, all -> 0x0313 }
        r0.<init>();	 Catch:{ Exception -> 0x0307, all -> 0x0313 }
        r1 = r6.exists();	 Catch:{ Exception -> 0x04f7, all -> 0x0313 }
        if (r1 == 0) goto L_0x0303;
    L_0x0276:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x04f7, all -> 0x0313 }
        r1.<init>(r6);	 Catch:{ Exception -> 0x04f7, all -> 0x0313 }
        r0.load(r1);	 Catch:{ Exception -> 0x04fb, all -> 0x04f3 }
        r2 = r3;
    L_0x027f:
        if (r1 == 0) goto L_0x0284;
    L_0x0281:
        r1.close();	 Catch:{ IOException -> 0x04f0 }
    L_0x0284:
        r1 = r0;
    L_0x0285:
        if (r2 == 0) goto L_0x035f;
    L_0x0287:
        r6 = r5.listFiles();	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r7 = -552; // 0xfffffffffffffdd8 float:NaN double:NaN;
        r0.yL(r7);	 Catch:{ Exception -> 0x031a }
        r0 = r4;
    L_0x0295:
        r7 = r6.length;	 Catch:{ Exception -> 0x031a }
        if (r0 >= r7) goto L_0x035f;
    L_0x0298:
        r7 = r6[r0];	 Catch:{ Exception -> 0x031a }
        r8 = "1";
        r9 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x031a }
        if (r8 != 0) goto L_0x0300;
    L_0x02a7:
        r8 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r9 = ".dex";
        r8 = r8.endsWith(r9);	 Catch:{ Exception -> 0x031a }
        if (r8 != 0) goto L_0x0300;
    L_0x02b4:
        r8 = "tbs.conf";
        r9 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x031a }
        if (r8 != 0) goto L_0x0300;
    L_0x02c1:
        r8 = com.tencent.smtt.utils.a.C(r7);	 Catch:{ Exception -> 0x031a }
        r9 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r10 = "";
        r9 = r1.getProperty(r9, r10);	 Catch:{ Exception -> 0x031a }
        r10 = "";
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x031a }
        if (r10 != 0) goto L_0x033d;
    L_0x02d9:
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x031a }
        if (r8 == 0) goto L_0x033d;
    L_0x02df:
        r8 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r10 = "md5_check_success for (";
        r9.<init>(r10);	 Catch:{ Exception -> 0x031a }
        r7 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r7 = r9.append(r7);	 Catch:{ Exception -> 0x031a }
        r9 = ")";
        r7 = r7.append(r9);	 Catch:{ Exception -> 0x031a }
        r7 = r7.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.i(r8, r7);	 Catch:{ Exception -> 0x031a }
    L_0x0300:
        r0 = r0 + 1;
        goto L_0x0295;
    L_0x0303:
        r1 = r2;
        r2 = r4;
        goto L_0x027f;
    L_0x0307:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
    L_0x030a:
        if (r1 == 0) goto L_0x030f;
    L_0x030c:
        r1.close();	 Catch:{ IOException -> 0x04ea }
    L_0x030f:
        r1 = r0;
        r2 = r3;
        goto L_0x0285;
    L_0x0313:
        r0 = move-exception;
    L_0x0314:
        if (r2 == 0) goto L_0x0319;
    L_0x0316:
        r2.close();	 Catch:{ IOException -> 0x04ed }
    L_0x0319:
        throw r0;	 Catch:{ Exception -> 0x031a }
    L_0x031a:
        r0 = move-exception;
        r1 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ all -> 0x044d }
        r2 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x044d }
        r1.aA(r2, r0);	 Catch:{ all -> 0x044d }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ all -> 0x044d }
        r1 = -537; // 0xfffffffffffffde7 float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ all -> 0x044d }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x033d:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r3 = "md5_check_failure for (";
        r1.<init>(r3);	 Catch:{ Exception -> 0x031a }
        r3 = r7.getName();	 Catch:{ Exception -> 0x031a }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x031a }
        r3 = ")";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x031a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x031a }
        r3 = r4;
    L_0x035f:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r4 = "copyTbsCoreInThread - md5_check_success:";
        r1.<init>(r4);	 Catch:{ Exception -> 0x031a }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x031a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x031a }
        if (r2 == 0) goto L_0x03a7;
    L_0x0377:
        if (r3 != 0) goto L_0x03a7;
    L_0x0379:
        r0 = "TbsInstaller";
        r1 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x031a }
        r0 = 1;
        com.tencent.smtt.utils.e.d(r5, r0);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify md5 fail after copying tbs core!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -532; // 0xfffffffffffffdec float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x03a7:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread success!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x031a }
        r1 = com.tencent.smtt.sdk.f.eY(r13);	 Catch:{ Exception -> 0x031a }
        if (r1 == 0) goto L_0x03cd;
    L_0x03b6:
        r0 = r1.exists();	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x03cd;
    L_0x03bc:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.j.fe(r14);	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x043c;
    L_0x03c4:
        r0 = "x5.oversea.tbs.org";
    L_0x03c7:
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.sdk.f.a(r2, r14);	 Catch:{ Exception -> 0x031a }
    L_0x03cd:
        r0 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 1;
        r0.dG(r15, r1);	 Catch:{ Exception -> 0x031a }
        r0 = r12.pwB;	 Catch:{ Exception -> 0x031a }
        if (r0 == 0) goto L_0x0440;
    L_0x03d9:
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "continueInstallWithout core success";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
    L_0x03e5:
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -533; // 0xfffffffffffffdeb float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r2 = "TbsInstaller-copyTbsCoreInThread success -- version:";
        r1.<init>(r2);	 Catch:{ Exception -> 0x031a }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x031a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x031a }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x031a }
        r1 = 11;
        if (r0 < r1) goto L_0x045c;
    L_0x040a:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x031a }
    L_0x0412:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x0465 }
        r1 = "tbs_preload_x5_counter";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0465 }
        r1 = "tbs_preload_x5_recorder";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0465 }
        r1 = "tbs_preload_x5_version";
        r0.putInt(r1, r15);	 Catch:{ Throwable -> 0x0465 }
        r0.commit();	 Catch:{ Throwable -> 0x0465 }
    L_0x042d:
        com.tencent.smtt.utils.t.gg(r14);	 Catch:{ Exception -> 0x031a }
    L_0x0430:
        r0 = pwz;
        r0.unlock();
        r0 = pwA;
        r0.unlock();
        goto L_0x00b0;
    L_0x043c:
        r0 = "x5.tbs.org";
        goto L_0x03c7;
    L_0x0440:
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "success";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        goto L_0x03e5;
    L_0x044d:
        r0 = move-exception;
        r1 = pwz;
        r1.unlock();
        r1 = pwA;
        r1.unlock();
        r12.bNo();
        throw r0;
    L_0x045c:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 0;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x031a }
        goto L_0x0412;
    L_0x0465:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x031a }
        r3 = "Init tbs_preload_x5_counter#2 exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x031a }
        r0 = android.util.Log.getStackTraceString(r0);	 Catch:{ Exception -> 0x031a }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x031a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x031a }
        com.tencent.smtt.utils.TbsLog.e(r1, r0);	 Catch:{ Exception -> 0x031a }
        goto L_0x042d;
    L_0x0481:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.h.fa(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 2;
        r0.dG(r15, r1);	 Catch:{ Exception -> 0x031a }
        r0 = 0;
        com.tencent.smtt.utils.e.d(r5, r0);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -534; // 0xfffffffffffffdea float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r2 = "copy fail!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        goto L_0x0430;
    L_0x04ac:
        if (r0 != 0) goto L_0x04c3;
    L_0x04ae:
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "src-dir is null when copying tbs core!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -535; // 0xfffffffffffffde9 float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
    L_0x04c3:
        if (r5 != 0) goto L_0x0430;
    L_0x04c5:
        r0 = com.tencent.smtt.sdk.o.fx(r14);	 Catch:{ Exception -> 0x031a }
        r1 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r2 = "dst-dir is null when copying tbs core!";
        r0.aA(r1, r2);	 Catch:{ Exception -> 0x031a }
        r0 = com.tencent.smtt.sdk.i.fb(r13);	 Catch:{ Exception -> 0x031a }
        r1 = -536; // 0xfffffffffffffde8 float:NaN double:NaN;
        r0.yL(r1);	 Catch:{ Exception -> 0x031a }
        goto L_0x0430;
    L_0x04dc:
        r12.bNo();
        r0 = com.tencent.smtt.sdk.i.fb(r13);
        r1 = -538; // 0xfffffffffffffde6 float:NaN double:NaN;
        r0.yL(r1);
        goto L_0x0058;
    L_0x04ea:
        r1 = move-exception;
        goto L_0x030f;
    L_0x04ed:
        r1 = move-exception;
        goto L_0x0319;
    L_0x04f0:
        r1 = move-exception;
        goto L_0x0284;
    L_0x04f3:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0314;
    L_0x04f7:
        r1 = move-exception;
        r1 = r2;
        goto L_0x030a;
    L_0x04fb:
        r2 = move-exception;
        goto L_0x030a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.m.a(com.tencent.smtt.sdk.m, android.content.Context, android.content.Context, int):void");
    }

    static /* synthetic */ void a(m mVar, Context context, String str, int i) {
        int i2 = 200;
        int i3 = 0;
        i.fb(context).yL(-501);
        if (mVar.fg(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            i.fb(context).yL(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            i.fb(context).yL(-503);
        } else if (!e.fZ(context)) {
            long bOj = t.bOj();
            long bMY = i.fb(context).bMY();
            i.fb(context).yL(-504);
            o.fx(context).aA(210, "rom is not enough when installing tbs core! curAvailROM=" + bOj + ",minReqRom=" + bMY);
        } else if (mVar.fw(context)) {
            boolean tryLock = pwA.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                boolean z;
                int i4;
                i.fb(context).yL(-507);
                pwz.lock();
                int Qj = h.fa(context).Qj("copy_core_ver");
                int Qj2 = h.fa(context).Qj("install_core_ver");
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + Qj);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + Qj2);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                if ((Qj2 > 0 && i > Qj2) || (Qj > 0 && i > Qj)) {
                    fq(context);
                }
                Qj = h.fa(context).Qi("install_status");
                Qj2 = mVar.fl(context);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + Qj);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + Qj2);
                if (Qj < 0 || Qj >= 2) {
                    if (Qj == 3 && Qj2 > 0 && (i > Qj2 || i == 88888888)) {
                        Qj = -1;
                        fq(context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                    }
                    z = false;
                    i4 = Qj;
                } else {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                    z = true;
                    i4 = Qj;
                }
                i.fb(context).yL(-508);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i4);
                if (i4 <= 0) {
                    String Qk;
                    TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                    i.fb(context).yL(-509);
                    if (z) {
                        Qj = h.fa(context).Qj("unzip_retry_num");
                        if (Qj > 10) {
                            o.fx(context).aA(201, "exceed unzip retry num!");
                            fp(context);
                            i.fb(context).yL(-510);
                            pwz.unlock();
                            pwA.unlock();
                            mVar.bNo();
                            return;
                        }
                        h.fa(context).cq("unzip_retry_num", Qj + 1);
                    }
                    if (str == null) {
                        Qk = h.fa(context).Qk("install_apk_path");
                        if (Qk == null) {
                            o.fx(context).aA(202, "apk path is null!");
                            i.fb(context).yL(-511);
                            pwz.unlock();
                            pwA.unlock();
                            mVar.bNo();
                            return;
                        }
                    }
                    Qk = str;
                    try {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + Qk);
                        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(Qk, 0);
                        int i5 = packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
                        if (i5 == 0) {
                            i.fb(context).yL(-512);
                            o.fx(context).aA(203, "apk version is 0!");
                            pwz.unlock();
                            pwA.unlock();
                            mVar.bNo();
                            return;
                        }
                        h.fa(context).ee("install_apk_path", Qk);
                        h.fa(context).dH(i5, 0);
                        i.fb(context).yL(-548);
                        if (a(context, new File(Qk))) {
                            if (z) {
                                Qj = h.fa(context).Qi("unlzma_status");
                                if (Qj > 5) {
                                    o.fx(context).aA(223, "exceed unlzma retry num!");
                                    i.fb(context).yL(-553);
                                    fp(context);
                                    f.eZ(context);
                                    i.fb(context).pwb.put("tbs_needdownload", Boolean.valueOf(true));
                                    i.fb(context).pwb.put("request_full_package", Boolean.valueOf(true));
                                    i.fb(context).commit();
                                    pwz.unlock();
                                    pwA.unlock();
                                    mVar.bNo();
                                    return;
                                }
                                h.fa(context).cq("unlzma_status", Qj + 1);
                            }
                            TbsLog.i("TbsInstaller", "unlzma begin");
                            Qj2 = i.bMV().pwc.getInt("tbs_responsecode", 0);
                            if (mVar.fl(context) != 0) {
                                Object c = QbSdk.c(context, "can_unlzma", null);
                                tryLock = (c == null || !(c instanceof Boolean)) ? false : ((Boolean) c).booleanValue();
                                if (tryLock) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("responseCode", Qj2);
                                    bundle.putString("unzip_temp_path", fu(context).getAbsolutePath());
                                    c = QbSdk.c(context, "unlzma", bundle);
                                    if (c == null) {
                                        TbsLog.i("TbsInstaller", "unlzma return null");
                                        o.fx(context).aA(222, "unlzma is null");
                                    } else if (c instanceof Boolean) {
                                        if (((Boolean) c).booleanValue()) {
                                            TbsLog.i("TbsInstaller", "unlzma success");
                                            i3 = 1;
                                        } else {
                                            TbsLog.i("TbsInstaller", "unlzma return false");
                                            o.fx(context).aA(222, "unlzma return false");
                                        }
                                    } else if (c instanceof Bundle) {
                                        i3 = 1;
                                    } else if (c instanceof Throwable) {
                                        TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) c));
                                        o.fx(context).a(222, (Throwable) c);
                                    }
                                    if (i3 == 0) {
                                        pwz.unlock();
                                        pwA.unlock();
                                        mVar.bNo();
                                        return;
                                    }
                                }
                            }
                            TbsLog.i("TbsInstaller", "unlzma finished");
                            h.fa(context).dH(i5, 1);
                            Qj = i5;
                        } else {
                            o.fx(context).aA(207, "unzipTbsApk failed");
                            pwz.unlock();
                            pwA.unlock();
                            mVar.bNo();
                            return;
                        }
                    } catch (Throwable th) {
                        pwz.unlock();
                        pwA.unlock();
                        mVar.bNo();
                    }
                } else {
                    Qj = 0;
                }
                if (i4 < 2) {
                    if (z) {
                        Qj2 = h.fa(context).Qj("dexopt_retry_num");
                        if (Qj2 > 10) {
                            o.fx(context).aA(208, "exceed dexopt retry num!");
                            i.fb(context).yL(-514);
                            fp(context);
                            pwz.unlock();
                            pwA.unlock();
                            mVar.bNo();
                            return;
                        }
                        h.fa(context).cq("dexopt_retry_num", Qj2 + 1);
                    }
                    i.fb(context).yL(-549);
                    mVar.fh(context);
                    h.fa(context).dH(Qj, 2);
                    TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                    TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                    i.fb(context).yL(-516);
                    Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                    edit.putInt("tbs_preload_x5_counter", 0);
                    edit.putInt("tbs_preload_x5_recorder", 0);
                    edit.putInt("tbs_preload_x5_version", i);
                    edit.commit();
                    i.fb(context).yL(-517);
                    if (i == 88888888) {
                        new File(str).delete();
                        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
                        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                        if (file.canRead()) {
                            File file2 = new File(file, "tbs.conf");
                            Properties properties = new Properties();
                            try {
                                properties.load(new FileInputStream(file2));
                                OutputStream fileOutputStream = new FileOutputStream(file2);
                                properties.setProperty("tbs_local_installation", "true");
                                properties.store(fileOutputStream, null);
                                TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                            } catch (Throwable th2) {
                            }
                        }
                    }
                    if (mVar.pwB) {
                        o fx = o.fx(context);
                        if (h.fa(context).Qi("incrupdate_status") == 1) {
                            i2 = 221;
                        }
                        fx.aA(i2, "continueInstallWithout core success");
                    } else {
                        o.fx(context).aA(h.fa(context).Qi("incrupdate_status") == 1 ? 221 : 200, "success");
                    }
                } else if (i4 == 2) {
                    QbSdk.puW.hq(200);
                }
                pwz.unlock();
                pwA.unlock();
                mVar.bNo();
                return;
            }
            i.fb(context).yL(-519);
            mVar.bNo();
        } else {
            i.fb(context).yL(-505);
        }
    }

    private static boolean a(Context context, File file) {
        boolean z = true;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (e.G(file)) {
            File file2;
            try {
                file2 = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                if (file2.exists()) {
                    e.F(file2);
                }
            } catch (Throwable th) {
                TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            file2 = fu(context);
            if (file2 == null) {
                o.fx(context).aA(205, "tmp unzip dir is null!");
                i.fb(context).yL(-521);
                return false;
            }
            boolean e;
            try {
                e.E(file2);
                e = e.e(file, file2);
                if (!e) {
                    e.F(file2);
                    i.fb(context).yL(-522);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + file2.exists());
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                return e;
            } catch (Throwable th2) {
                i.fb(context).yL(-523);
                o.fx(context).a(206, th2);
                e = file2 != null && file2.exists();
                if (e && file2 != null) {
                    e.F(file2);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + file2.exists());
                }
            } catch (Throwable th22) {
                i.fb(context).yL(-523);
                o.fx(context).a(207, th22);
                if (file2 == null || !file2.exists()) {
                    z = false;
                }
                if (z && file2 != null) {
                    e.F(file2);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + file2.exists());
                }
            } catch (Throwable th222) {
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th222));
            }
        } else {
            o.fx(context).aA(204, "apk is invalid!");
            i.fb(context).yL(-520);
            return false;
        }
        String str = "TbsInstaller";
        String str2 = "TbsInstaller-unzipTbs done";
        TbsLog.i(str, str2);
        return false;
        str = "TbsInstaller";
        str2 = "TbsInstaller-unzipTbs done";
        TbsLog.i(str, str2);
        return false;
    }

    private Context ad(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] bNu = q.bNu();
        int i2 = 0;
        while (i2 < 4) {
            if (!context.getPackageName().equalsIgnoreCase(bNu[i2]) && bq(context, bNu[i2])) {
                Context br = br(context, bNu[i2]);
                if (br == null) {
                    continue;
                } else if (fi(br)) {
                    int fl = fl(br);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + fl);
                    if (fl != 0 && fl == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + bNu[i2]);
                        return br;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + bNu[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        return null;
    }

    static synchronized m bNm() {
        m mVar;
        synchronized (m.class) {
            if (pwu == null) {
                pwu = new m();
            }
            mVar = pwu;
        }
        return mVar;
    }

    private synchronized boolean bNn() {
        return false;
    }

    private static boolean bp(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        return file.exists() && new File(file, "tbs.conf").exists();
    }

    private static boolean bq(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static Context br(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean fh(Context context) {
        TbsLog.i("TbsInstaller", new StringBuilder("TbsInstaller-doTbsDexOpt start - dirMode: 0").toString());
        try {
            File fu = fu(context);
            File[] listFiles = fu.listFiles(new FileFilter(this) {
                final /* synthetic */ m pwH;

                {
                    this.pwH = r1;
                }

                public final boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase("com.tencent.x5sdk.demo")) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), fu.getAbsolutePath(), null, classLoader);
            }
        } catch (Exception e2) {
            o.fx(context).aA(209, e2.toString());
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        return true;
    }

    static boolean fi(Context context) {
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals("com.tencent.mtt")) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mobileqq")) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.x5sdk.demo")) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.qzone")) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    private void fj(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        y.bNJ();
        if (y.bNI() == null && y.bNJ().fK(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromUnzip -- failed to get rename fileLock#2!");
            return;
        }
        try {
            fo(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
            File fu = fu(context);
            File fr = fr(context);
            if (!(fu == null || fr == null)) {
                fu.renameTo(fr);
            }
            if (!q.fz(context)) {
                q.fy(context);
            }
            h.fa(context).cq("dexopt_retry_num", 0);
            h.fa(context).cq("unzip_retry_num", 0);
            h.fa(context).cq("unlzma_status", 0);
            h.fa(context).dH(0, 3);
            h.fa(context).ee("install_apk_path", SQLiteDatabase.KeyEmpty);
            h.fa(context).cq("incrupdate_status", -1);
            if (q.fz(context)) {
                q.c(context, fn(context), true);
            }
            pwC.set(Integer.valueOf(0));
        } catch (Throwable th) {
            o.fx(context).aA(219, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
    }

    private void fk(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        y.bNJ();
        if (y.bNI() == null && y.bNJ().fK(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromCopy -- failed to get rename fileLock#2!");
            return;
        }
        try {
            fo(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
            File fv = fv(context);
            File fr = fr(context);
            if (!(fv == null || fr == null)) {
                fv.renameTo(fr);
            }
            q.fy(context);
            h.fa(context).dG(0, 3);
            pwC.set(Integer.valueOf(0));
        } catch (Exception e) {
            o.fx(context).aA(219, "exception when renameing from copy:" + e.toString());
        }
    }

    private void fo(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        e.d(fr(context), false);
    }

    private static void fp(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File fu = fu(context);
        if (fu != null) {
            e.d(fu, false);
        }
        h.fa(context).dH(0, 5);
        h.fa(context).cq("incrupdate_status", -1);
        QbSdk.bo(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static void fq(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        h.fa(context).cq("dexopt_retry_num", 0);
        h.fa(context).cq("unzip_retry_num", 0);
        h.fa(context).cq("unlzma_status", 0);
        h.fa(context).dH(0, -1);
        h.fa(context).ee("install_apk_path", SQLiteDatabase.KeyEmpty);
        h.fa(context).cq("copy_retry_num", 0);
        h.fa(context).dG(0, -1);
        h.fa(context).cq("incrupdate_status", -1);
        e.d(fu(context), true);
        e.d(fv(context), true);
    }

    static File fr(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File fs(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File ft(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File fu(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File fv(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static void l(Context context, String str, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        pwD.sendMessage(message);
    }

    private synchronized boolean q(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (fw(context)) {
                    boolean tryLock = pwz.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int Qi = h.fa(context).Qi("copy_status");
                        int a = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + Qi);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + a);
                        if (Qi == 1) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                fk(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                fk(context);
                            }
                            pwz.unlock();
                            z2 = z3;
                        }
                        z3 = false;
                        try {
                            pwz.unlock();
                            z2 = z3;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            z2 = z3;
                            th = th3;
                            o.fx(context).aA(215, th.toString());
                            QbSdk.bo(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                            return z2;
                        }
                    }
                    bNo();
                }
            } catch (Throwable th4) {
                th = th4;
                o.fx(context).aA(215, th.toString());
                QbSdk.bo(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                return z2;
            }
        }
        return z2;
    }

    private synchronized boolean r(Context context, boolean z) {
        Object obj;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            try {
                if (fw(context)) {
                    boolean tryLock = pwz.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int Qi = h.fa(context).Qi("install_status");
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + Qi);
                        int a = a(false, context);
                        if (Qi == 2) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                fj(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                fj(context);
                            }
                            pwz.unlock();
                            z3 = z2;
                        }
                        z2 = false;
                        try {
                            pwz.unlock();
                            z3 = z2;
                        } catch (Exception e) {
                            Exception exception = e;
                            z3 = z2;
                            Exception exception2 = exception;
                            QbSdk.bo(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                            return z3;
                        }
                    }
                    bNo();
                }
            } catch (Exception e2) {
                obj = e2;
                QbSdk.bo(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                return z3;
            } catch (Throwable th) {
                pwz.unlock();
            }
        }
        return z3;
    }

    public final int a(boolean z, Context context) {
        if (z || ((Integer) pwC.get()).intValue() <= 0) {
            pwC.set(Integer.valueOf(fl(context)));
        }
        return ((Integer) pwC.get()).intValue();
    }

    final boolean ac(Context context, int i) {
        if (j.fe(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (ad(context, i) != null) {
            Object obj = new Object[]{ad(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            pwD.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    final synchronized void bNo() {
        int i = this.pwv;
        this.pwv = i - 1;
        if (i > 1 || !this.pwy) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            e.a(this.pww, this.pwx);
            this.pwy = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void e(android.content.Context r10, android.os.Bundle r11) {
        /*
        r9 = this;
        r8 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        r7 = -546; // 0xfffffffffffffdde float:NaN double:NaN;
        r2 = 2;
        r5 = 0;
        r3 = 1;
        r0 = r9.fg(r10);
        if (r0 == 0) goto L_0x0017;
    L_0x000d:
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r1 = -539; // 0xfffffffffffffde5 float:NaN double:NaN;
        r0.yL(r1);
    L_0x0016:
        return;
    L_0x0017:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        if (r11 == 0) goto L_0x0016;
    L_0x0022:
        if (r10 == 0) goto L_0x0016;
    L_0x0024:
        r0 = com.tencent.smtt.utils.e.fZ(r10);
        if (r0 != 0) goto L_0x0064;
    L_0x002a:
        r0 = com.tencent.smtt.utils.t.bOj();
        r2 = com.tencent.smtt.sdk.i.fb(r10);
        r2 = r2.bMY();
        r4 = com.tencent.smtt.sdk.o.fx(r10);
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r6 = new java.lang.StringBuilder;
        r7 = "rom is not enough when patching tbs core! curAvailROM=";
        r6.<init>(r7);
        r0 = r6.append(r0);
        r1 = ",minReqRom=";
        r0 = r0.append(r1);
        r0 = r0.append(r2);
        r0 = r0.toString();
        r4.aA(r5, r0);
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r1 = -540; // 0xfffffffffffffde4 float:NaN double:NaN;
        r0.yL(r1);
        goto L_0x0016;
    L_0x0064:
        r0 = r9.fw(r10);
        if (r0 != 0) goto L_0x0074;
    L_0x006a:
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r1 = -541; // 0xfffffffffffffde3 float:NaN double:NaN;
        r0.yL(r1);
        goto L_0x0016;
    L_0x0074:
        r0 = pwA;
        r0 = r0.tryLock();
        r1 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r6 = "TbsInstaller-installLocalTesCoreExInThread locked=";
        r4.<init>(r6);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r4);
        if (r0 == 0) goto L_0x0200;
    L_0x0092:
        r1 = 0;
        r0 = 1;
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r0 = r9.fl(r10);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r0 <= 0) goto L_0x00aa;
    L_0x009d:
        r0 = com.tencent.smtt.sdk.h.fa(r10);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r4 = "incrupdate_status";
        r0 = r0.Qi(r4);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r0 != r3) goto L_0x00c4;
    L_0x00aa:
        r0 = 0;
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r0 = pwA;
        r0.unlock();
        r9.bNo();
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
    L_0x00bf:
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r5);
        goto L_0x0016;
    L_0x00c4:
        r0 = com.tencent.smtt.sdk.i.fb(r10);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r0 = r0.pwc;	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r4 = "tbs_responsecode";
        r6 = 0;
        r0 = r0.getInt(r4, r6);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r0 == r3) goto L_0x00d9;
    L_0x00d4:
        if (r0 == r2) goto L_0x00d9;
    L_0x00d6:
        r4 = 4;
        if (r0 != r4) goto L_0x0149;
    L_0x00d9:
        r0 = r3;
    L_0x00da:
        if (r0 != 0) goto L_0x02b0;
    L_0x00dc:
        r0 = ft(r10);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r0 == 0) goto L_0x02b0;
    L_0x00e2:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r6 = "x5.tbs";
        r4.<init>(r0, r6);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r0 = r4.exists();	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r0 == 0) goto L_0x02b0;
    L_0x00f0:
        r0 = com.tencent.smtt.sdk.i.fb(r10);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r4 = -550; // 0xfffffffffffffdda float:NaN double:NaN;
        r0.yL(r4);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        r1 = com.tencent.smtt.sdk.QbSdk.d(r10, r11);	 Catch:{ Exception -> 0x0153, all -> 0x01b2 }
        if (r1 != 0) goto L_0x014b;
    L_0x00ff:
        r0 = r3;
    L_0x0100:
        r4 = pwA;
        r4.unlock();
        r9.bNo();
        if (r0 != 0) goto L_0x0259;
    L_0x010a:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r2 = -544; // 0xfffffffffffffde0 float:NaN double:NaN;
        r0.yL(r2);
        r0 = com.tencent.smtt.sdk.h.fa(r10);
        r2 = -1;
        r0.dH(r5, r2);
        r0 = com.tencent.smtt.sdk.h.fa(r10);
        r2 = "incrupdate_status";
        r0.cq(r2, r3);
        r0 = "apk_path";
        r0 = r1.getString(r0);
        r2 = new java.io.File;
        r2.<init>(r0);
        com.tencent.smtt.sdk.f.a(r2, r10);
        r2 = "tbs_core_ver";
        r1 = r1.getInt(r2);
        l(r10, r0, r1);
        goto L_0x00bf;
    L_0x0149:
        r0 = r5;
        goto L_0x00da;
    L_0x014b:
        r0 = "patch_result";
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x0153, all -> 0x02a6 }
        goto L_0x0100;
    L_0x0153:
        r0 = move-exception;
        r4 = com.tencent.smtt.sdk.i.fb(r10);	 Catch:{ all -> 0x02ab }
        r6 = -543; // 0xfffffffffffffde1 float:NaN double:NaN;
        r4.yL(r6);	 Catch:{ all -> 0x02ab }
        r4 = com.tencent.smtt.sdk.o.fx(r10);	 Catch:{ all -> 0x02ab }
        r6 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x02ab }
        r4.aA(r6, r0);	 Catch:{ all -> 0x02ab }
        r0 = pwA;
        r0.unlock();
        r9.bNo();
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r0.yL(r7);
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r0 = r0.pwb;
        r1 = "tbs_needdownload";
        r2 = java.lang.Boolean.valueOf(r3);
        r0.put(r1, r2);
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r0.commit();
        r0 = com.tencent.smtt.sdk.o.fx(r10);
        r1 = new java.lang.StringBuilder;
        r2 = "incrUpdate fail! patch ret=";
        r1.<init>(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.aA(r8, r1);
        goto L_0x00bf;
    L_0x01b2:
        r0 = move-exception;
        r4 = r1;
        r1 = r2;
    L_0x01b5:
        r6 = pwA;
        r6.unlock();
        r9.bNo();
        if (r1 != 0) goto L_0x020e;
    L_0x01bf:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        r1 = com.tencent.smtt.sdk.i.fb(r10);
        r2 = -544; // 0xfffffffffffffde0 float:NaN double:NaN;
        r1.yL(r2);
        r1 = com.tencent.smtt.sdk.h.fa(r10);
        r2 = -1;
        r1.dH(r5, r2);
        r1 = com.tencent.smtt.sdk.h.fa(r10);
        r2 = "incrupdate_status";
        r1.cq(r2, r3);
        r1 = "apk_path";
        r1 = r4.getString(r1);
        r2 = new java.io.File;
        r2.<init>(r1);
        com.tencent.smtt.sdk.f.a(r2, r10);
        r2 = "tbs_core_ver";
        r2 = r4.getInt(r2);
        l(r10, r1, r2);
    L_0x01fc:
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r5);
        throw r0;
    L_0x0200:
        r0 = com.tencent.smtt.sdk.i.fb(r10);
        r1 = -547; // 0xfffffffffffffddd float:NaN double:NaN;
        r0.yL(r1);
        r9.bNo();
        goto L_0x0016;
    L_0x020e:
        if (r1 != r2) goto L_0x021a;
    L_0x0210:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        goto L_0x01fc;
    L_0x021a:
        r2 = com.tencent.smtt.sdk.i.fb(r10);
        r2.yL(r7);
        r2 = "TbsInstaller";
        r4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        r2 = com.tencent.smtt.sdk.i.fb(r10);
        r2 = r2.pwb;
        r4 = "tbs_needdownload";
        r3 = java.lang.Boolean.valueOf(r3);
        r2.put(r4, r3);
        r2 = com.tencent.smtt.sdk.i.fb(r10);
        r2.commit();
        r2 = com.tencent.smtt.sdk.o.fx(r10);
        r3 = new java.lang.StringBuilder;
        r4 = "incrUpdate fail! patch ret=";
        r3.<init>(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        r2.aA(r8, r1);
        goto L_0x01fc;
    L_0x0259:
        if (r0 != r2) goto L_0x0266;
    L_0x025b:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        goto L_0x00bf;
    L_0x0266:
        r1 = com.tencent.smtt.sdk.i.fb(r10);
        r1.yL(r7);
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        r1 = com.tencent.smtt.sdk.i.fb(r10);
        r1 = r1.pwb;
        r2 = "tbs_needdownload";
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r1 = com.tencent.smtt.sdk.i.fb(r10);
        r1.commit();
        r1 = com.tencent.smtt.sdk.o.fx(r10);
        r2 = new java.lang.StringBuilder;
        r3 = "incrUpdate fail! patch ret=";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.aA(r8, r0);
        goto L_0x00bf;
    L_0x02a6:
        r0 = move-exception;
        r4 = r1;
        r1 = r2;
        goto L_0x01b5;
    L_0x02ab:
        r0 = move-exception;
        r4 = r1;
        r1 = r3;
        goto L_0x01b5;
    L_0x02b0:
        r0 = r2;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.m.e(android.content.Context, android.os.Bundle):void");
    }

    final boolean fg(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        boolean z = false;
        File file = new File(fr(context), "tbs.conf");
        if (file.exists()) {
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    z = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return z;
    }

    final int fl(Context context) {
        FileInputStream fileInputStream;
        String property;
        String str;
        Exception e;
        Throwable th;
        int i = 0;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(fr(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                str = "TbsInstaller";
                                property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString();
                                TbsLog.i(str, property);
                                return i;
                            }
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            str = "TbsInstaller";
                            property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString();
                            TbsLog.i(str, property);
                            return i;
                        }
                    }
                    return i;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222) {
                                str = "TbsInstaller";
                                property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString();
                                TbsLog.i(str, property);
                                return i;
                            }
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2222) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2222.toString());
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e22222) {
                    str = "TbsInstaller";
                    property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22222.toString();
                    TbsLog.i(str, property);
                    return i;
                }
            }
            return i;
        } catch (Exception e4) {
            e = e4;
            fileInputStream = fileInputStream2;
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    final boolean fm(Context context) {
        return new File(fr(context), "tbs.conf").exists();
    }

    final int fn(Context context) {
        Exception e;
        Throwable th;
        if (!fw(context)) {
            return -1;
        }
        boolean tryLock = pwz.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                File file = new File(fr(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                }
                            }
                            pwz.unlock();
                            bNo();
                            return 0;
                        }
                        pwC.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) pwC.get()).intValue();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                            }
                        }
                        pwz.unlock();
                        bNo();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e22) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                                }
                            }
                            pwz.unlock();
                            bNo();
                            return 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e32) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                                }
                            }
                            pwz.unlock();
                            bNo();
                            throw th;
                        }
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                    }
                }
                pwz.unlock();
                bNo();
                return 0;
            } catch (Exception e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                pwz.unlock();
                bNo();
                return 0;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                pwz.unlock();
                bNo();
                throw th;
            }
        }
        bNo();
        return 0;
    }

    final synchronized boolean fw(Context context) {
        boolean z = true;
        synchronized (this) {
            this.pwv++;
            if (this.pwy) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            } else {
                this.pwx = e.b(context, true, "tbslock.txt");
                if (this.pwx != null) {
                    this.pww = e.a(this.pwx);
                    if (this.pww == null) {
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.pwy = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    final void s(Context context, boolean z) {
        boolean z2 = false;
        if (z) {
            this.pwB = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentThreadName=");
        int name = Thread.currentThread().getName();
        TbsLog.i("TbsInstaller", stringBuilder.append(name).toString());
        if (fw(context)) {
            int Qi;
            int Qj;
            int i = 0;
            String tryLock = pwz.tryLock();
            if (tryLock == true) {
                try {
                    Qi = h.fa(context).Qi("install_status");
                    name = h.fa(context).Qj("install_core_ver");
                    tryLock = h.fa(context).Qk("install_apk_path");
                    Qj = h.fa(context).Qj("copy_core_ver");
                    i = h.fa(context).Qi("copy_status");
                } finally {
                    z2 = pwz;
                    z2.unlock();
                }
            } else {
                tryLock = i;
                name = 0;
                Qi = -1;
                i = -1;
                Qj = 0;
            }
            bNo();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + Qi);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + name);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + tryLock);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + Qj);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i);
            if (q.fz(context)) {
                Qj = q.bNz();
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
                if (Qj > 0) {
                    int fl = fl(context);
                    if (fl != Qj && fl <= 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                        QbSdk.bo(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = i.fb(context).pwc.getInt("tbs_responsecode", z2);
            boolean z3 = (i2 == 1 || i2 == 2 || i2 == 4) ? true : z2;
            if (!z3) {
                new Bundle().putInt("operation", CdnLogic.MediaType_FAVORITE_FILE);
                if (context != null) {
                    Object obj = new Object[]{context, r6};
                    Message message = new Message();
                    message.what = 3;
                    message.obj = obj;
                    pwD.sendMessage(message);
                }
            }
            if (Qi >= 0 && Qi < 2) {
                l(context, tryLock, name);
            }
            if (i == 0) {
                ac(context, Qj);
            }
        }
    }

    final void t(Context context, boolean z) {
        boolean z2 = false;
        if (!QbSdk.puC) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            boolean z3 = bp(context, "core_copy_tmp");
            boolean z4 = bp(context, "core_unzip_tmp");
            if (bp(context, "core_share_backup_tmp")) {
                z2 = true;
            }
            if (z2) {
                bNn();
            }
            if ((z3 && q(context, z)) || (z4 && r(context, z))) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, SUCCESS!!", true);
            }
        }
    }
}
