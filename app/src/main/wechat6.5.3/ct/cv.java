package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tencentmap.lbssdk.service.e.a;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class cv implements UncaughtExceptionHandler {
    private static final String a = TencentLocation.class.getPackage().getName();
    private final Context b;
    private final String c;
    private final String d;
    private final UncaughtExceptionHandler e = Thread.getDefaultUncaughtExceptionHandler();

    private cv(Context context, String str, String str2) {
        this.b = context;
        this.c = str;
        this.d = str2;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th instanceof a) {
            if (!bk.a(this.b).a("so").b(bu.a)) {
                b.a.a("UNHANDLED_EXCEPTION", "PluginLoadSo load failed");
            } else {
                return;
            }
        }
        if (bk.a(this.b).g().s) {
            try {
                b.a.a(a(this.b, thread, th), new File(this.c + "/" + UUID.randomUUID()), Charset.defaultCharset());
            } catch (IOException e) {
            }
        }
        if (a(th)) {
            String str = (new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss_", Locale.ENGLISH).format(new Date()) + ((int) (Math.random() * 10000.0d))) + ".stacktrace";
            String a = a(this.b, thread, th);
            if (this.d != null) {
                try {
                    cw.a(bk.a(this.b), "http://lstest.map.qq.com/stat", a, this.c + "/" + str).await(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                }
            }
        }
        this.e.uncaughtException(thread, th);
    }

    private boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        if (!bk.a(this.b).g().r) {
            return true;
        }
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if ("TL".equals(stackTraceElement.getFileName()) || stackTraceElement.getClassName().contains(a)) {
                    return true;
                }
            }
            th = th.getCause();
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static String a(Context context, Thread thread, Throwable th) {
        PackageInfo packageInfo;
        String deviceId;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = new PackageInfo();
        }
        bl a = bk.a(context).a(1000);
        String d = a != null ? a.d() : "None";
        String e2 = a != null ? a.e() : "None";
        StringBuilder stringBuilder = new StringBuilder("SDK_V" + d + "_Errlog|");
        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date())).append("|");
        String str = SQLiteDatabase.KeyEmpty;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            deviceId = telephonyManager.getDeviceId();
        } else {
            deviceId = str;
        }
        stringBuilder.append(deviceId).append("|");
        stringBuilder.append(d).append("|");
        stringBuilder.append(e2).append("|");
        stringBuilder.append(context.getPackageName()).append("|");
        stringBuilder.append(packageInfo.versionName).append("|");
        stringBuilder.append(packageInfo.versionCode).append("|");
        stringBuilder.append(VERSION.RELEASE).append("|");
        stringBuilder.append(Build.MODEL).append("|");
        stringBuilder.append("android-").append(VERSION.SDK_INT).append("|");
        stringBuilder.append(thread.getName()).append("|");
        stringBuilder.append("ExceptionClass:").append(th.getClass()).append("|");
        stringBuilder.append("ExceptionMessage:").append(th.getMessage()).append("|");
        stringBuilder.append("ExceptionDetails:");
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        deviceId = stringWriter.toString().replaceAll("\r|\n", "__");
        printWriter.close();
        stringBuilder.append(deviceId);
        if (th instanceof LinkageError) {
            File file;
            stringBuilder.append("|").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append("|");
            if (VERSION.SDK_INT > 8) {
                file = new File(context.getApplicationInfo().nativeLibraryDir);
            } else {
                file = context.getDir("lib", 0);
            }
            if (file != null && file.isDirectory()) {
                stringBuilder.append(file.getAbsolutePath()).append("|").append(Arrays.toString(file.list()));
            }
            stringBuilder.append("|");
            file = new File(context.getFilesDir(), "libtencentloc.so");
            if (file.exists()) {
                stringBuilder.append(file.length());
            } else {
                stringBuilder.append(0);
            }
        }
        return stringBuilder.toString();
    }

    public static void a(Context context) {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof cv)) {
            File file = new File(context.getDir("txsdklog", 0), "raw");
            if (!file.exists()) {
                file.mkdirs();
            }
            Thread.setDefaultUncaughtExceptionHandler(new cv(context, file.getAbsolutePath(), "http://lstest.map.qq.com/stat"));
        }
    }
}
