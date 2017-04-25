package com.tencent.mm.bc;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.c.b.a;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d implements a {
    private SimpleDateFormat irc;
    private FileOutputStream nea;

    public final void open() {
        this.irc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        if (this.nea == null) {
            String str = aa.getContext().getCacheDir() + "/recovery/recovery.log";
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                this.nea = new FileOutputStream(str, true);
            } catch (Throwable e) {
                v.a("RECOVERY", e, "", new Object[0]);
            }
        }
    }

    public final void close() {
        if (this.nea != null) {
            try {
                this.nea.close();
            } catch (Throwable e) {
                v.a("RECOVERY", e, "", new Object[0]);
            }
        }
        this.nea = null;
    }

    public final void d(String str, String str2, Object... objArr) {
        V("D", str, String.format(str2, objArr));
    }

    public final void v(String str, String str2, Object... objArr) {
        V("V", str, String.format(str2, objArr));
    }

    public final void i(String str, String str2, Object... objArr) {
        V("I", str, String.format(str2, objArr));
    }

    public final void w(String str, String str2, Object... objArr) {
        V("W", str, String.format(str2, objArr));
    }

    public final void e(String str, String str2, Object... objArr) {
        V("E", str, String.format(str2, objArr));
    }

    public final void a(String str, Throwable th, String str2, Object... objArr) {
        String str3 = "E";
        V(str3, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th));
    }

    private void V(String str, String str2, String str3) {
        if (this.nea != null) {
            try {
                String format = this.irc.format(new Date());
                this.nea.write(String.format("[RECOVERY][%s][%s][%d][%d][%s]:%s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3}).getBytes());
                this.nea.flush();
            } catch (Throwable e) {
                v.a("RECOVERY", e, "", new Object[0]);
            }
        }
    }
}
