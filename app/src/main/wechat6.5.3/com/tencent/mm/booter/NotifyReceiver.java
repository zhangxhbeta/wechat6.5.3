package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.modelmulti.g;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock bXE = null;
    private static WakerLock bXU = null;
    private static Set<Long> bXV = new HashSet();
    private static Lock bXW = new ReentrantLock(false);
    private static byte[] bXX = new byte[0];
    private static byte[] bXY = new byte[0];
    private static a bXZ;
    private static boolean bYa = true;

    public static class NotifyService extends Service {
        Boolean bYc = null;

        public static class InnerService extends Service {
            public void onCreate() {
                super.onCreate();
                try {
                    startForeground(-1212, new Notification());
                } catch (NullPointerException e) {
                    v.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", e);
                }
                stopSelf();
            }

            public void onDestroy() {
                stopForeground(true);
                super.onDestroy();
            }

            public IBinder onBind(Intent intent) {
                return null;
            }
        }

        private void j(android.content.Intent r14) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:90:0x0342
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r13 = this;
            if (r14 != 0) goto L_0x000c;
        L_0x0002:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp receiveIntent == null";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        L_0x000b:
            return;
        L_0x000c:
            r0 = 0;
            r1 = com.tencent.mm.kernel.g.vr();
            if (r1 == 0) goto L_0x003f;
        L_0x0013:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "kernel is null, appcreate %d";
            r2 = 1;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
            r0 = -1;
        L_0x0028:
            if (r0 >= 0) goto L_0x005d;
        L_0x002a:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "status %s";
            r2 = 1;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = -1;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
            goto L_0x000b;
        L_0x003f:
            r1 = com.tencent.mm.kernel.g.vx();
            r1 = r1.ckH;
            if (r1 != 0) goto L_0x0028;
        L_0x0047:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "WorkerProfile not has create, status %d";
            r2 = 1;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
            r0 = -1;
            goto L_0x0028;
        L_0x005d:
            r0 = "notify_option_type";
            r1 = 0;
            r2 = r14.getIntExtra(r0, r1);
            if (r2 != 0) goto L_0x0071;
        L_0x0067:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp invalid opcode.";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x0071:
            r0 = com.tencent.mm.kernel.a.uM();
            if (r0 == 0) goto L_0x0085;
        L_0x0077:
            com.tencent.mm.kernel.g.vx();
            r0 = com.tencent.mm.kernel.g.vu();
            r0 = r0.cjo;
            if (r0 != 0) goto L_0x00bc;
        L_0x0082:
            com.tencent.mm.kernel.a.uO();
        L_0x0085:
            r0 = com.tencent.mm.kernel.g.uz();
            if (r0 == 0) goto L_0x0091;
        L_0x008b:
            r0 = com.tencent.mm.kernel.a.uG();
            if (r0 == 0) goto L_0x00c6;
        L_0x0091:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp hasSetuin:%b  isHold:%b  opcode:%d";
            r3 = 3;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = com.tencent.mm.kernel.g.uz();
            r5 = java.lang.Boolean.valueOf(r5);
            r3[r4] = r5;
            r4 = 1;
            r5 = com.tencent.mm.kernel.a.uG();
            r5 = java.lang.Boolean.valueOf(r5);
            r3[r4] = r5;
            r4 = 2;
            r2 = java.lang.Integer.valueOf(r2);
            r3[r4] = r2;
            com.tencent.mm.sdk.platformtools.v.e(r0, r1, r3);
            goto L_0x000b;
        L_0x00bc:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp uinHasDefaultButNoAcc but accInitializing true so not setup!";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            goto L_0x0085;
        L_0x00c6:
            r0 = com.tencent.mm.kernel.g.vy();
            r0 = r0.cAa;
            if (r0 != 0) goto L_0x00e9;
        L_0x00ce:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp  opcode:%d  getDispatcher == null";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = java.lang.Integer.valueOf(r2);
            r3[r4] = r5;
            com.tencent.mm.sdk.platformtools.v.w(r0, r1, r3);
            r0 = com.tencent.mm.kernel.g.vy();
            r1 = 1;
            r0.aQ(r1);
        L_0x00e9:
            r0 = r13.bYc;
            if (r0 != 0) goto L_0x00fe;
        L_0x00ed:
            r0 = com.tencent.mm.sdk.b.b.bsI();
            if (r0 == 0) goto L_0x0139;
        L_0x00f3:
            r0 = r13;
        L_0x00f4:
            r1 = 0;
            r12 = r1;
            r1 = r0;
            r0 = r12;
        L_0x00f8:
            r0 = java.lang.Boolean.valueOf(r0);
            r1.bYc = r0;
        L_0x00fe:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "handleCommand useOld:%s status:%d operCode:%d";
            r3 = 3;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = r13.bYc;
            r3[r4] = r5;
            r4 = 1;
            r5 = 0;
            r5 = java.lang.Integer.valueOf(r5);
            r3[r4] = r5;
            r4 = 2;
            r5 = java.lang.Integer.valueOf(r2);
            r3[r4] = r5;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r3);
            switch(r2) {
                case 1: goto L_0x0165;
                case 2: goto L_0x0209;
                default: goto L_0x0121;
            };
        L_0x0121:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r3 = "invald opCode:";
            r1.<init>(r3);
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x0139:
            r0 = com.tencent.mm.h.h.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.h.h) r0;
            r0 = r0.sU();
            r1 = "AndroidOldNotifyReceiver";
            r0 = r0.getValue(r1);
            r1 = 0;
            r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r1);
            com.tencent.mm.kernel.g.vx();
            r1 = com.tencent.mm.kernel.g.vu();
            r1 = r1.uin;
            r3 = 100;
            r1 = com.tencent.mm.a.h.aq(r1, r3);
            if (r0 <= r1) goto L_0x06ae;
        L_0x0162:
            r0 = 1;
            r1 = r13;
            goto L_0x00f8;
        L_0x0165:
            r0 = r13.bYc;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x0177;
        L_0x016d:
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
            r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE";
            t(r0, r1);
        L_0x0177:
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
            r1 = "MicroMsg.NotifyReceiver";
            r2 = "dealWithLooper";
            com.tencent.mm.sdk.platformtools.v.i(r1, r2);
            r1 = com.tencent.mm.kernel.g.uz();
            if (r1 == 0) goto L_0x0190;
        L_0x018a:
            r1 = com.tencent.mm.kernel.a.uG();
            if (r1 == 0) goto L_0x01bb;
        L_0x0190:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "receiveImp hasSetuin:";
            r1.<init>(r2);
            r2 = com.tencent.mm.kernel.g.uz();
            r1 = r1.append(r2);
            r2 = " isHold:";
            r1 = r1.append(r2);
            r2 = com.tencent.mm.kernel.a.uG();
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.w(r0, r1);
            goto L_0x000b;
        L_0x01bb:
            r1 = com.tencent.mm.kernel.g.vy();
            r1 = r1.foreground;
            if (r1 != 0) goto L_0x01ce;
        L_0x01c3:
            if (r0 == 0) goto L_0x01f9;
        L_0x01c5:
            r0 = com.tencent.mm.sdk.platformtools.ak.isWap(r0);
            if (r0 != 0) goto L_0x01f9;
        L_0x01cb:
            r0 = 1;
        L_0x01cc:
            if (r0 != 0) goto L_0x01fb;
        L_0x01ce:
            r0 = com.tencent.mm.plugin.zero.a.d.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;
            r0 = r0.Ho();
            r1 = 2;
            r0.fP(r1);
        L_0x01de:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            if (r0 == 0) goto L_0x000b;
        L_0x01ea:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            r0.WZ();
            goto L_0x000b;
        L_0x01f9:
            r0 = 0;
            goto L_0x01cc;
        L_0x01fb:
            r0 = com.tencent.mm.kernel.g.vy();
            r1 = new com.tencent.mm.modelmulti.j;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x01de;
        L_0x0209:
            r0 = r13.bYc;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x04ed;
        L_0x0211:
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
            r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY";
            t(r0, r1);
            r0 = "notify_respType";
            r1 = 0;
            r1 = r14.getIntExtra(r0, r1);
            r0 = "notify_respBuf";
            r3 = r14.getByteArrayExtra(r0);
            r0 = "notify_skey";
            r2 = r14.getByteArrayExtra(r0);
            r0 = "notfiy_recv_time";
            r4 = -1;
            r4 = r14.getLongExtra(r0, r4);
            r6 = "MicroMsg.NotifyReceiver";
            r7 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            r0 = 4;
            r8 = new java.lang.Object[r0];
            r0 = 0;
            r9 = java.lang.Integer.valueOf(r1);
            r8[r0] = r9;
            r0 = 1;
            r9 = java.lang.Long.valueOf(r4);
            r8[r0] = r9;
            r9 = 2;
            if (r3 != 0) goto L_0x0287;
        L_0x0254:
            r0 = -1;
        L_0x0255:
            r0 = java.lang.Integer.valueOf(r0);
            r8[r9] = r0;
            r0 = 3;
            r9 = com.tencent.mm.sdk.platformtools.be.bn(r2);
            r9 = com.tencent.mm.sdk.platformtools.be.KW(r9);
            r8[r0] = r9;
            com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);
            switch(r1) {
                case 39: goto L_0x0477;
                case 138: goto L_0x034a;
                case 268369921: goto L_0x0289;
                case 1000000205: goto L_0x03dd;
                case 2147480001: goto L_0x0486;
                default: goto L_0x026c;
            };
        L_0x026c:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            if (r0 == 0) goto L_0x000b;
        L_0x0278:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            r0.b(r1, r3, r2);
            goto L_0x000b;
        L_0x0287:
            r0 = r3.length;
            goto L_0x0255;
        L_0x0289:
            r0 = com.tencent.mm.sdk.platformtools.be.bl(r2);
            if (r0 == 0) goto L_0x02a7;
        L_0x028f:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r3 = "dkpush dealWithNotify session:";
            r1.<init>(r3);
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x02a7:
            r0 = com.tencent.mm.sdk.platformtools.be.bl(r3);
            if (r0 != 0) goto L_0x02b2;
        L_0x02ad:
            r0 = r3.length;
            r1 = 8;
            if (r0 > r1) goto L_0x02bd;
        L_0x02b2:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush dealWithNotify respBuf error ";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x02bd:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r3, r0);
            r1 = 4;
            r1 = com.tencent.mm.a.n.c(r3, r1);
            r6 = r3.length;
            r6 = r6 + -8;
            if (r1 == r6) goto L_0x02e5;
        L_0x02cc:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush: respBuf length error len:";
            r1.<init>(r2);
            r2 = r3.length;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x02e5:
            r6 = new byte[r1];
            r7 = 8;
            r8 = 0;
            java.lang.System.arraycopy(r3, r7, r6, r8, r1);
            r7 = "MicroMsg.NotifyReceiver";
            r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
            r9 = 4;
            r9 = new java.lang.Object[r9];
            r10 = 0;
            r11 = java.lang.Integer.valueOf(r0);
            r9[r10] = r11;
            r10 = 1;
            r1 = java.lang.Integer.valueOf(r1);
            r9[r10] = r1;
            r1 = 2;
            r3 = r3.length;
            r3 = java.lang.Integer.valueOf(r3);
            r9[r1] = r3;
            r1 = 3;
            r3 = java.lang.Long.valueOf(r4);
            r9[r1] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r7, r8, r9);
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ all -> 0x0341 }
            r1.lock();	 Catch:{ all -> 0x0341 }
            com.tencent.mm.modelmulti.l.a(r0, r6, r2, r4);	 Catch:{ all -> 0x0341 }
            r0 = com.tencent.mm.booter.NotifyReceiver.bXV;	 Catch:{ all -> 0x0341 }
            r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0341 }
            r0.add(r1);	 Catch:{ all -> 0x0341 }
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ all -> 0x0341 }
            r1 = "NotifyReceiver.NotifyData";	 Catch:{ all -> 0x0341 }
            u(r0, r1);	 Catch:{ all -> 0x0341 }
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;
            r0.unlock();
            goto L_0x000b;
        L_0x033e:
            r0 = move-exception;
            goto L_0x000b;
        L_0x0341:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x06ab }
            r1.unlock();	 Catch:{ Exception -> 0x06ab }
        L_0x0349:
            throw r0;
        L_0x034a:
            if (r3 != 0) goto L_0x03c8;
        L_0x034c:
            r0 = 7;
            r2 = r0;
        L_0x034e:
            if (r3 != 0) goto L_0x03cf;
        L_0x0350:
            r0 = 2;
            r1 = r0;
        L_0x0352:
            r4 = "MicroMsg.NotifyReceiver";
            r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
            r0 = 3;
            r6 = new java.lang.Object[r0];
            r0 = 0;
            r7 = java.lang.Integer.valueOf(r2);
            r6[r0] = r7;
            r0 = 1;
            r7 = java.lang.Integer.valueOf(r1);
            r6[r0] = r7;
            r7 = 2;
            if (r3 != 0) goto L_0x03d2;
        L_0x036c:
            r0 = -1;
        L_0x036d:
            r0 = java.lang.Integer.valueOf(r0);
            r6[r7] = r0;
            com.tencent.mm.sdk.platformtools.v.d(r4, r5, r6);
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ all -> 0x03d4 }
            r0.lock();	 Catch:{ all -> 0x03d4 }
            r0 = com.tencent.mm.plugin.zero.a.d.class;	 Catch:{ all -> 0x03d4 }
            r0 = com.tencent.mm.kernel.g.f(r0);	 Catch:{ all -> 0x03d4 }
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;	 Catch:{ all -> 0x03d4 }
            r0 = r0.Ho();	 Catch:{ all -> 0x03d4 }
            r2 = (long) r2;	 Catch:{ all -> 0x03d4 }
            r4 = "";	 Catch:{ all -> 0x03d4 }
            r0 = r0.a(r2, r1, r4);	 Catch:{ all -> 0x03d4 }
            if (r0 <= 0) goto L_0x03bc;	 Catch:{ all -> 0x03d4 }
        L_0x0393:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x03d4 }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x03d4 }
            r3 = 1;	 Catch:{ all -> 0x03d4 }
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x03d4 }
            r4 = 0;	 Catch:{ all -> 0x03d4 }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x03d4 }
            r3[r4] = r5;	 Catch:{ all -> 0x03d4 }
            com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);	 Catch:{ all -> 0x03d4 }
            r1 = com.tencent.mm.booter.NotifyReceiver.bXV;	 Catch:{ all -> 0x03d4 }
            r2 = (long) r0;	 Catch:{ all -> 0x03d4 }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x03d4 }
            r1.add(r0);	 Catch:{ all -> 0x03d4 }
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ all -> 0x03d4 }
            r1 = "NotifyReceiver.dealWithNotify:MMFunc_NewSync";	 Catch:{ all -> 0x03d4 }
            u(r0, r1);	 Catch:{ all -> 0x03d4 }
        L_0x03bc:
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;
            r0.unlock();
            goto L_0x000b;
        L_0x03c5:
            r0 = move-exception;
            goto L_0x000b;
        L_0x03c8:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r3, r0);
            r2 = r0;
            goto L_0x034e;
        L_0x03cf:
            r0 = 1;
            r1 = r0;
            goto L_0x0352;
        L_0x03d2:
            r0 = r3.length;
            goto L_0x036d;
        L_0x03d4:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x06a8 }
            r1.unlock();	 Catch:{ Exception -> 0x06a8 }
        L_0x03dc:
            throw r0;
        L_0x03dd:
            r1 = "MicroMsg.NotifyReceiver";
            r2 = new java.lang.StringBuilder;
            r0 = "oreh on newsynccheck2 notify, notify=";
            r2.<init>(r0);
            if (r3 == 0) goto L_0x0453;
        L_0x03ea:
            r0 = 1;
        L_0x03eb:
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.v.d(r1, r0);
            r1 = new com.tencent.mm.protocal.ab$b;
            r1.<init>();
            r1.y(r3);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0.lock();	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = com.tencent.mm.plugin.zero.a.d.class;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = com.tencent.mm.kernel.g.f(r0);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = r0.Ho();	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r2 = r1.lXy;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r4 = 1;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r1 = r1.brF();	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = r0.a(r2, r4, r1);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            if (r0 <= 0) goto L_0x0447;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
        L_0x041e:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r3 = 1;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r4 = 0;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r3[r4] = r5;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r1 = com.tencent.mm.booter.NotifyReceiver.bXV;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r2 = (long) r0;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r1.add(r0);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r1 = "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP";	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            u(r0, r1);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
        L_0x0447:
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x0450 }
            r0.unlock();	 Catch:{ Exception -> 0x0450 }
            goto L_0x000b;
        L_0x0450:
            r0 = move-exception;
            goto L_0x000b;
        L_0x0453:
            r0 = 0;
            goto L_0x03eb;
        L_0x0455:
            r0 = move-exception;
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r2 = "";	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r3 = 0;	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0455, all -> 0x046e }
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;
            r0.unlock();
            goto L_0x000b;
        L_0x046b:
            r0 = move-exception;
            goto L_0x000b;
        L_0x046e:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x06a5 }
            r1.unlock();	 Catch:{ Exception -> 0x06a5 }
        L_0x0476:
            throw r0;
        L_0x0477:
            r0 = com.tencent.mm.kernel.g.vy();
            r1 = new com.tencent.mm.modelmulti.j;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x000b;
        L_0x0486:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush GCM Notify";
            com.tencent.mm.sdk.platformtools.v.d(r0, r1);
            r0 = com.tencent.mm.plugin.zero.a.d.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;
            r0 = r0.Ho();
            r2 = 7;
            r1 = 13;
            r4 = "";
            r0 = r0.a(r2, r1, r4);
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ all -> 0x04e4 }
            r1.lock();	 Catch:{ all -> 0x04e4 }
            if (r0 <= 0) goto L_0x04d8;	 Catch:{ all -> 0x04e4 }
        L_0x04af:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x04e4 }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x04e4 }
            r3 = 1;	 Catch:{ all -> 0x04e4 }
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x04e4 }
            r4 = 0;	 Catch:{ all -> 0x04e4 }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x04e4 }
            r3[r4] = r5;	 Catch:{ all -> 0x04e4 }
            com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);	 Catch:{ all -> 0x04e4 }
            r1 = com.tencent.mm.booter.NotifyReceiver.bXV;	 Catch:{ all -> 0x04e4 }
            r2 = (long) r0;	 Catch:{ all -> 0x04e4 }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x04e4 }
            r1.add(r0);	 Catch:{ all -> 0x04e4 }
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ all -> 0x04e4 }
            r1 = "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY";	 Catch:{ all -> 0x04e4 }
            u(r0, r1);	 Catch:{ all -> 0x04e4 }
        L_0x04d8:
            r0 = com.tencent.mm.booter.NotifyReceiver.bXW;
            r0.unlock();
            goto L_0x000b;
        L_0x04e1:
            r0 = move-exception;
            goto L_0x000b;
        L_0x04e4:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.bXW;	 Catch:{ Exception -> 0x06a2 }
            r1.unlock();	 Catch:{ Exception -> 0x06a2 }
        L_0x04ec:
            throw r0;
        L_0x04ed:
            r0 = "notify_respType";
            r1 = 0;
            r1 = r14.getIntExtra(r0, r1);
            r0 = "notify_respBuf";
            r3 = r14.getByteArrayExtra(r0);
            r0 = "notify_skey";
            r2 = r14.getByteArrayExtra(r0);
            r0 = "notfiy_recv_time";
            r4 = -1;
            r4 = r14.getLongExtra(r0, r4);
            r6 = "MicroMsg.NotifyReceiver";
            r7 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            r0 = 4;
            r8 = new java.lang.Object[r0];
            r0 = 0;
            r9 = java.lang.Integer.valueOf(r1);
            r8[r0] = r9;
            r0 = 1;
            r9 = java.lang.Long.valueOf(r4);
            r8[r0] = r9;
            r9 = 2;
            if (r3 != 0) goto L_0x0559;
        L_0x0526:
            r0 = -1;
        L_0x0527:
            r0 = java.lang.Integer.valueOf(r0);
            r8[r9] = r0;
            r0 = 3;
            r9 = com.tencent.mm.sdk.platformtools.be.bn(r2);
            r9 = com.tencent.mm.sdk.platformtools.be.KW(r9);
            r8[r0] = r9;
            com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);
            switch(r1) {
                case 39: goto L_0x0693;
                case 138: goto L_0x05ed;
                case 268369921: goto L_0x055b;
                case 1000000205: goto L_0x065b;
                case 2147480001: goto L_0x063a;
                default: goto L_0x053e;
            };
        L_0x053e:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            if (r0 == 0) goto L_0x000b;
        L_0x054a:
            r0 = com.tencent.mm.plugin.zero.b.class;
            r0 = com.tencent.mm.kernel.g.g(r0);
            r0 = (com.tencent.mm.plugin.zero.b) r0;
            r0 = r0.lxm;
            r0.c(r1, r3, r2);
            goto L_0x000b;
        L_0x0559:
            r0 = r3.length;
            goto L_0x0527;
        L_0x055b:
            r0 = com.tencent.mm.sdk.platformtools.be.bl(r2);
            if (r0 == 0) goto L_0x0579;
        L_0x0561:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r3 = "dkpush dealWithNotify session:";
            r1.<init>(r3);
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x0579:
            r0 = com.tencent.mm.sdk.platformtools.be.bl(r3);
            if (r0 != 0) goto L_0x0584;
        L_0x057f:
            r0 = r3.length;
            r1 = 8;
            if (r0 > r1) goto L_0x058f;
        L_0x0584:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush dealWithNotify respBuf error ";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x058f:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r3, r0);
            r1 = 4;
            r1 = com.tencent.mm.a.n.c(r3, r1);
            r6 = r3.length;
            r6 = r6 + -8;
            if (r1 == r6) goto L_0x05b7;
        L_0x059e:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush: respBuf length error len:";
            r1.<init>(r2);
            r2 = r3.length;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x000b;
        L_0x05b7:
            r6 = new byte[r1];
            r7 = 8;
            r8 = 0;
            java.lang.System.arraycopy(r3, r7, r6, r8, r1);
            r7 = "MicroMsg.NotifyReceiver";
            r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
            r9 = 4;
            r9 = new java.lang.Object[r9];
            r10 = 0;
            r11 = java.lang.Integer.valueOf(r0);
            r9[r10] = r11;
            r10 = 1;
            r1 = java.lang.Integer.valueOf(r1);
            r9[r10] = r1;
            r1 = 2;
            r3 = r3.length;
            r3 = java.lang.Integer.valueOf(r3);
            r9[r1] = r3;
            r1 = 3;
            r3 = java.lang.Long.valueOf(r4);
            r9[r1] = r3;
            com.tencent.mm.sdk.platformtools.v.i(r7, r8, r9);
            com.tencent.mm.modelmulti.l.a(r0, r6, r2, r4);
            goto L_0x000b;
        L_0x05ed:
            if (r3 != 0) goto L_0x062e;
        L_0x05ef:
            r0 = 7;
            r2 = r0;
        L_0x05f1:
            if (r3 != 0) goto L_0x0635;
        L_0x05f3:
            r0 = 2;
            r1 = r0;
        L_0x05f5:
            r4 = "MicroMsg.NotifyReceiver";
            r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
            r0 = 3;
            r6 = new java.lang.Object[r0];
            r0 = 0;
            r7 = java.lang.Integer.valueOf(r2);
            r6[r0] = r7;
            r0 = 1;
            r7 = java.lang.Integer.valueOf(r1);
            r6[r0] = r7;
            r7 = 2;
            if (r3 != 0) goto L_0x0638;
        L_0x060f:
            r0 = -1;
        L_0x0610:
            r0 = java.lang.Integer.valueOf(r0);
            r6[r7] = r0;
            com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
            r0 = com.tencent.mm.plugin.zero.a.d.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;
            r0 = r0.Ho();
            r2 = (long) r2;
            r4 = "";
            r0.a(r2, r1, r4);
            goto L_0x000b;
        L_0x062e:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r3, r0);
            r2 = r0;
            goto L_0x05f1;
        L_0x0635:
            r0 = 1;
            r1 = r0;
            goto L_0x05f5;
        L_0x0638:
            r0 = r3.length;
            goto L_0x0610;
        L_0x063a:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush GCM Notify";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = com.tencent.mm.plugin.zero.a.d.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;
            r0 = r0.Ho();
            r2 = 7;
            r1 = 13;
            r4 = "";
            r0.a(r2, r1, r4);
            goto L_0x000b;
        L_0x065b:
            r1 = "MicroMsg.NotifyReceiver";
            r2 = new java.lang.StringBuilder;
            r0 = "oreh on newsynccheck2 notify, notify=";
            r2.<init>(r0);
            if (r3 == 0) goto L_0x0691;
        L_0x0668:
            r0 = 1;
        L_0x0669:
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.v.i(r1, r0);
            r1 = new com.tencent.mm.protocal.ab$b;
            r1.<init>();
            r0 = com.tencent.mm.plugin.zero.a.d.class;
            r0 = com.tencent.mm.kernel.g.f(r0);
            r0 = (com.tencent.mm.plugin.zero.a.d) r0;
            r0 = r0.Ho();
            r2 = r1.lXy;
            r4 = 1;
            r1 = r1.brF();
            r0.a(r2, r4, r1);
            goto L_0x000b;
        L_0x0691:
            r0 = 0;
            goto L_0x0669;
        L_0x0693:
            r0 = com.tencent.mm.kernel.g.vy();
            r1 = new com.tencent.mm.modelmulti.j;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x000b;
        L_0x06a2:
            r1 = move-exception;
            goto L_0x04ec;
        L_0x06a5:
            r1 = move-exception;
            goto L_0x0476;
        L_0x06a8:
            r1 = move-exception;
            goto L_0x03dc;
        L_0x06ab:
            r1 = move-exception;
            goto L_0x0349;
        L_0x06ae:
            r0 = r13;
            goto L_0x00f4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.NotifyReceiver.NotifyService.j(android.content.Intent):void");
        }

        public void onStart(Intent intent, int i) {
            j(intent);
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            v.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
            j(intent);
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        public void onCreate() {
            super.onCreate();
            if (VERSION.SDK_INT < 24) {
                if (VERSION.SDK_INT < 18) {
                    startForeground(-1212, new Notification());
                } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                    startForeground(-1212, new Notification());
                    startService(new Intent(this, InnerService.class));
                    v.i("MicroMsg.NotifyReceiver", "set service for mm.");
                }
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ NotifyService bYd;

                    {
                        this.bYd = r1;
                    }

                    public final void run() {
                        this.bYd.stopForeground(true);
                    }
                }, aa.btk().getLong("mm_stop_service_time", 86400000));
            }
        }

        public static void cT(String str) {
            synchronized (NotifyReceiver.bXX) {
                if (NotifyReceiver.bXE == null) {
                    NotifyReceiver.bXE = new WakerLock(aa.getContext());
                }
            }
            NotifyReceiver.bXE.lock(5000, str);
        }

        private static void t(Context context, String str) {
            synchronized (NotifyReceiver.bXX) {
                if (NotifyReceiver.bXE == null) {
                    NotifyReceiver.bXE = new WakerLock(context);
                }
            }
            NotifyReceiver.bXE.lock(14000, str);
        }

        private static void u(Context context, String str) {
            synchronized (NotifyReceiver.bXY) {
                if (NotifyReceiver.bXU == null) {
                    NotifyReceiver.bXU = new WakerLock(context);
                }
            }
            NotifyReceiver.bXU.lock(60000, str);
        }
    }

    public static class a implements e {
        public final void a(int i, int i2, String str, k kVar) {
            long j;
            long hashCode = (long) kVar.hashCode();
            if (kVar.getType() == 268369922) {
                j = ((g) kVar).cQV;
            } else {
                j = hashCode;
            }
            try {
                NotifyReceiver.bXW.lock();
                String str2 = "MicroMsg.NotifyReceiver";
                String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(kVar.getType());
                objArr[1] = Long.valueOf(j);
                objArr[2] = Boolean.valueOf(NotifyReceiver.bXV.contains(Long.valueOf(j)));
                objArr[3] = Boolean.valueOf(NotifyReceiver.bXU != null ? NotifyReceiver.bXU.isLocking() : false);
                v.i(str2, str3, objArr);
                NotifyReceiver.bXV.remove(Long.valueOf(j));
                if (NotifyReceiver.bXV.isEmpty()) {
                    synchronized (NotifyReceiver.bXY) {
                        if (NotifyReceiver.bXU != null) {
                            NotifyReceiver.bXU.unLock();
                        }
                    }
                    v.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                } else {
                    v.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.bXV.size()));
                }
                switch (kVar.getType()) {
                    case 138:
                        if (com.tencent.mm.kernel.g.uz() && i == 0 && i2 == 0 && com.tencent.mm.model.a.wu()) {
                            try {
                                com.tencent.mm.kernel.g.vx();
                                com.tencent.mm.model.a aVar = com.tencent.mm.kernel.g.vu().cjr;
                                if (aVar.cqT > -1) {
                                    aVar.cqT++;
                                }
                                v.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(aVar.cqT));
                                if (aVar.cqT == 2 || aVar.cqT == 5) {
                                    b.itm.a(226, aVar.cqT == 2 ? 37 : 38, 1, false);
                                    b.itm.h(11098, Integer.valueOf(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.cqT));
                                }
                            } catch (Throwable th) {
                                v.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", be.e(th));
                            }
                        }
                        if (((com.tencent.mm.plugin.zero.b) com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.zero.b.class)).lxm != null) {
                            ((com.tencent.mm.plugin.zero.b) com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.zero.b.class)).lxm.a(this, i, i2, str);
                            break;
                        }
                        break;
                }
                C(7000);
            } finally {
                try {
                    NotifyReceiver.bXW.unlock();
                } catch (Exception e) {
                }
            }
        }

        public final void C(long j) {
            if (z.Mq().getBoolean("is_in_notify_mode", false)) {
                new ac(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ a bYb;

                    {
                        this.bYb = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.NotifyReceiver", "checkKillPorcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.bYa));
                        synchronized (NotifyReceiver.bXX) {
                            if (NotifyReceiver.bXE != null) {
                                NotifyReceiver.bXE.unLock();
                            }
                            NotifyReceiver.bXE = null;
                        }
                        if (NotifyReceiver.bYa) {
                            if (((com.tencent.mm.plugin.zero.b) com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.zero.b.class)).lxm != null) {
                                ((com.tencent.mm.plugin.zero.b) com.tencent.mm.kernel.g.g(com.tencent.mm.plugin.zero.b.class)).lxm.Xa();
                            }
                            v.btb();
                            int myPid = Process.myPid();
                            com.tencent.recovery.b.yH(13);
                            Process.killProcess(myPid);
                        }
                    }
                }, j);
            }
        }
    }

    public static void pY() {
        v.i("MicroMsg.NotifyReceiver", "markUIShow");
        bYa = false;
        z.Mq().edit().putBoolean("is_in_notify_mode", false).commit();
    }

    public static void pZ() {
        com.tencent.mm.kernel.g.vy().b(138, bXZ);
        com.tencent.mm.kernel.g.vy().b(39, bXZ);
        com.tencent.mm.kernel.g.vy().b(268369922, bXZ);
        if (bXZ == null) {
            bXZ = new a();
        }
        com.tencent.mm.kernel.g.vy().a(138, bXZ);
        com.tencent.mm.kernel.g.vy().a(39, bXZ);
        com.tencent.mm.kernel.g.vy().a(268369922, bXZ);
    }

    public void onReceive(Context context, Intent intent) {
        v.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        if (intent != null) {
            if (context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
                v.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
                return;
            }
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            context.startService(intent2);
        }
    }
}
