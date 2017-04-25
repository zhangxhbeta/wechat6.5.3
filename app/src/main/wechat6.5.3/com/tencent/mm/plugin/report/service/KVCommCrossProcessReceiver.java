package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.protocal.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.recovery.b;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = SQLiteDatabase.KeyEmpty;
    private static int itK = 10000;
    private static int itL = 1;
    private static long itM = ((long) itK);
    private static ac itN = new ac(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == KVCommCrossProcessReceiver.itL) {
                Parcelable broadCastData;
                synchronized (KVCommCrossProcessReceiver.lock) {
                    broadCastData = new BroadCastData(KVCommCrossProcessReceiver.itO);
                    BroadCastData aKz = KVCommCrossProcessReceiver.itO;
                    aKz.itB.clear();
                    aKz.itC.clear();
                    aKz.itD.clear();
                }
                ArrayList arrayList = broadCastData.itD;
                ArrayList arrayList2 = broadCastData.itC;
                ArrayList arrayList3 = broadCastData.itB;
                if (e.dr(aa.getContext()) || !aa.bts()) {
                    v.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                        e.c(groupIDKeyDataInfo.itE, groupIDKeyDataInfo.itF);
                    }
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                        e.e((int) stIDKeyDataInfo.iuq, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.itF);
                    }
                    it = arrayList3.iterator();
                    while (it.hasNext()) {
                        KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                        e.b((int) kVReportDataInfo.itT, kVReportDataInfo.value, kVReportDataInfo.itU, kVReportDataInfo.itF);
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
                intent.setComponent(new ComponentName(aa.getPackageName(), KVCommCrossProcessReceiver.getClassName()));
                intent.putExtra("type", 1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
                intent.putExtra("INTENT_IDKEYGROUP", bundle);
                v.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                aa.getContext().sendBroadcast(intent);
            }
        }
    };
    private static BroadCastData itO = new BroadCastData();
    private static Object lock = new Object();

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
            return;
        }
        try {
            switch (r.a(intent, "type", 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.itD;
                        ArrayList arrayList2 = broadCastData.itC;
                        v.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.itB.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            d.b(groupIDKeyDataInfo.itE, groupIDKeyDataInfo.itF);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            d.b(stIDKeyDataInfo.iuq, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.itF);
                        }
                        it = r7.iterator();
                        while (it.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                            d.a(kVReportDataInfo.itT, kVReportDataInfo.value, kVReportDataInfo.itU, kVReportDataInfo.itF);
                        }
                        break;
                    }
                    break;
                case 2:
                    v.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (e.dr(aa.getContext())) {
                new ac(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ KVCommCrossProcessReceiver itP;

                    {
                        this.itP = r1;
                    }

                    public final void run() {
                        if (e.dr(aa.getContext())) {
                            v.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            v.btb();
                            BaseEvent.onSingalCrash(0);
                            int myPid = Process.myPid();
                            b.yH(13);
                            Process.killProcess(myPid);
                        }
                    }
                }, 5000);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ReportManagerKvCheck", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void cv(long j) {
        if (j >= 0) {
            itM = j;
        }
    }

    private static String getClassName() {
        if (be.kS(className)) {
            className = aa.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        return className;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        v.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", Long.valueOf(kVReportDataInfo.itT), Boolean.valueOf(kVReportDataInfo.itF), Boolean.valueOf(kVReportDataInfo.itU));
        synchronized (lock) {
            itO.itB.add(kVReportDataInfo);
        }
        if (!itN.hasMessages(itL)) {
            itN.sendEmptyMessageDelayed(itL, itM);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        v.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.iuq), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.itF));
        synchronized (lock) {
            itO.itC.add(stIDKeyDataInfo);
        }
        if (!itN.hasMessages(itL)) {
            itN.sendEmptyMessageDelayed(itL, itM);
        }
    }

    public static void a(ArrayList<IDKey> arrayList, boolean z) {
        v.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.valueOf(z));
        synchronized (lock) {
            BroadCastData broadCastData = itO;
            broadCastData.itD.add(new GroupIDKeyDataInfo(arrayList, z));
        }
        if (!itN.hasMessages(itL)) {
            itN.sendEmptyMessageDelayed(itL, itM);
        }
    }

    public static void aKx() {
        if (e.dr(aa.getContext()) || !aa.bts()) {
            v.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
        intent.putExtra("type", 2);
        aa.getContext().sendBroadcast(intent);
    }
}
