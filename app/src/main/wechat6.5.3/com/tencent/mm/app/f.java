package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class f {

    static class AnonymousClass1 implements d {
        final /* synthetic */ Application aQF;
        final /* synthetic */ String aQG;

        AnonymousClass1(Application application, String str) {
            this.aQF = application;
            this.aQG = str;
        }

        public final void a(ag agVar, String str, Throwable th) {
            f.a(this.aQF, this.aQG, str, th);
        }
    }

    public static void a(Context context, String str, String str2, Throwable th) {
        try {
            StringBuilder stringBuilder = new StringBuilder(2560);
            StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
            stringBuilderPrinter.println("#client.version=" + BaseBuildInfo.cmV);
            stringBuilderPrinter.println("#accinfo.revision=" + BaseBuildInfo.vX());
            String A = c.cnl.A("last_login_uin", "0");
            if (A == null || A.equals("0")) {
                A = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
            }
            stringBuilderPrinter.println("#accinfo.uin=" + A);
            StringBuilder append = new StringBuilder("#accinfo.runtime=").append(System.currentTimeMillis() - MMApplicationLike.sAppStartTime).append("(");
            if (str == null) {
                str = SQLiteDatabase.KeyEmpty;
            }
            stringBuilderPrinter.println(append.append(str).append(") by cup").toString());
            stringBuilderPrinter.println("#accinfo.build=" + BaseBuildInfo.cmX + ":" + BaseBuildInfo.cmY + ":0");
            String str3 = SQLiteDatabase.KeyEmpty;
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                StatFs statFs2 = new StatFs(a.cni);
                int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
                int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
                A = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), a.cni, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
            } catch (Exception e) {
                A = str3;
            }
            l.b(th);
            stringBuilderPrinter.println("#accinfo.data=" + A);
            Date date = new Date();
            stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
            stringBuilderPrinter.println("#crashContent=");
            if (d.ae(aa.getContext()) == 1) {
                str2 = str2.substring(0, d.af(aa.getContext()));
            }
            d.d(aa.getContext(), aa.getProcessName(), "first");
            stringBuilderPrinter.println(str2);
            v.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:" + str2);
            Intent intent = new Intent();
            intent.setAction("INTENT_ACTION_UNCATCH");
            intent.putExtra("INTENT_EXTRA_USER_NAME", c.cnl.A("login_user_name", "never_login_crash"));
            intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
            intent.putExtra("INTENT_EXTRA_DATA_PATH", a.cng + "crash/");
            intent.putExtra("INTENT_EXTRA_SDCARD_PATH", a.cnk);
            intent.putExtra("INTENT_EXTRA_UIN", c.cnl.A("last_login_uin", "0"));
            intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", BaseBuildInfo.cmV);
            intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", BaseBuildInfo.cmW);
            intent.putExtra("INTENT_EXTRA_TAG", "exception");
            String str4 = "INTENT_EXTRA_HOST";
            intent.putExtra(str4, "http://" + context.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com"));
            intent.setClassName(context, context.getPackageName() + ".crash.CrashUploaderService");
            aa.getContext().startService(intent);
        } catch (Exception e2) {
        }
    }
}
