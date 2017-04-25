package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;

public class TinkerPatchService extends IntentService {
    private static int bZH = -1119860829;
    private static a pFF = null;
    private static Class<? extends AbstractResultService> pFG = null;

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.bZH, new Notification());
            } catch (Throwable th) {
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[]{th});
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

    public TinkerPatchService() {
        super(TinkerPatchService.class.getSimpleName());
    }

    public static void bz(Context context, String str) {
        try {
            Intent intent = new Intent(context, TinkerPatchService.class);
            intent.putExtra("patch_path_extra", str);
            intent.putExtra("patch_result_class", pFG.getName());
            context.startService(intent);
        } catch (Throwable th) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchService", "start patch service fail, exception:" + th, new Object[0]);
        }
    }

    public static void a(a aVar, Class<? extends AbstractResultService> cls) {
        pFF = aVar;
        pFG = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    public static String ab(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.g(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    protected void onHandleIntent(Intent intent) {
        boolean z = false;
        Context applicationContext = getApplicationContext();
        com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(applicationContext);
        gh.pFM.z(intent);
        if (intent == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[z]);
            return;
        }
        String ab = ab(intent);
        if (ab == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[z]);
            return;
        }
        File file = new File(ab);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th = null;
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[z]);
        try {
            Notification notification = new Notification();
            if (VERSION.SDK_INT < 18) {
                startForeground(bZH, notification);
            } else {
                startForeground(bZH, notification);
                startService(new Intent(this, InnerService.class));
            }
        } catch (Throwable th2) {
            com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:" + th2, new Object[z]);
        }
        a aVar = new a();
        try {
            if (pFF == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z = pFF.a(applicationContext, ab, aVar);
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            gh.pFM.a(file, z, elapsedRealtime);
            aVar.bbq = z;
            aVar.pFD = ab;
            aVar.fVN = elapsedRealtime;
            aVar.puh = th;
            if (intent == null) {
                throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
            }
            AbstractResultService.a(applicationContext, aVar, ShareIntentUtil.g(intent, "patch_result_class"));
        } catch (Throwable th3) {
            th = th3;
            gh.pFM.a(file, th);
        }
    }
}
