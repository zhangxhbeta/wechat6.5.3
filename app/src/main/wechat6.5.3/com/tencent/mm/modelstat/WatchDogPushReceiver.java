package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = SQLiteDatabase.KeyEmpty;

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            return;
        }
        int intExtra = intent.getIntExtra("type", 0);
        v.d("MicroMsg.WatchDogPushReceiver", "onReceive type:" + intExtra);
        if (intExtra == 1) {
            a aVar = new a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                aVar.dnk = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.dnl = intent.getLongExtra("dataLen", 0);
            }
            aVar.dcx = intent.getLongExtra("cost", 0);
            aVar.dnm = intent.getLongExtra("doSceneCount", 0);
            v.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.dnk + " rx:" + aVar.dnl + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.dnm == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                v.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.dnm + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            }
        } else if (intExtra != 2 && intExtra != 3 && intExtra != 4) {
            if (intExtra == 5 && b.bsI()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                } else {
                    MMProtocalJni.setClientPackVersion(-1);
                }
            } else if (intExtra == 6) {
                v.bta();
            } else if (intExtra == 7) {
                com.tencent.mm.bc.b.JG("com.tencent.mm:push");
            }
        }
    }

    private static String getClassName() {
        if (be.kS(className)) {
            className = aa.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        return className;
    }

    public static void a(g gVar) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
        intent.putExtra("type", 1);
        intent.putExtra("rtType", gVar.rtType);
        intent.putExtra("beginTime", gVar.beginTime);
        intent.putExtra("endTime", gVar.endTime);
        intent.putExtra("rtType", gVar.rtType);
        intent.putExtra("dataLen", gVar.dcv);
        intent.putExtra("isSend", gVar.cFQ);
        intent.putExtra("cost", gVar.dcx);
        intent.putExtra("doSceneCount", gVar.dcw);
        aa.getContext().sendBroadcast(intent);
    }

    public static void Kn() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
        intent.putExtra("type", 3);
        aa.getContext().sendBroadcast(intent);
    }

    public static void gs(int i) {
        if (b.bsI()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
            intent.putExtra("type", 5);
            intent.putExtra("jni", i);
            aa.getContext().sendBroadcast(intent);
        }
    }

    public static void Ko() {
        if (b.bsI()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
            intent.putExtra("type", 7);
            aa.getContext().sendBroadcast(intent);
        }
    }
}
