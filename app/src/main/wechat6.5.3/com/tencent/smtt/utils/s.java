package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class s {
    static String dnU = null;
    static s pzQ = null;
    static File pzR = null;
    static byte[] pzT = null;
    TextView Ux;
    private SimpleDateFormat pzS = null;

    private class a implements Runnable {
        String pzU = null;
        final /* synthetic */ s pzV;

        a(s sVar, String str) {
            this.pzV = sVar;
            this.pzU = str;
        }

        public final void run() {
            if (this.pzV.Ux != null) {
                this.pzV.Ux.append(this.pzU + "\n");
            }
        }
    }

    public s(Context context) {
        try {
            this.pzS = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception e) {
            this.pzS = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
        try {
            if (pzR != null) {
                return;
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                String ae = e.ae(context, 6);
                if (ae == null) {
                    pzR = null;
                    return;
                }
                pzR = new File(ae, "tbslog.txt");
                dnU = g.bNV();
                pzT = g.ei(pzR.getName(), dnU);
                return;
            }
            pzR = null;
        } catch (SecurityException e2) {
        } catch (NullPointerException e3) {
        }
    }

    public final void aC(String str) {
        if (pzR != null) {
            g.a(pzR, dnU, pzT, this.pzS.format(Long.valueOf(System.currentTimeMillis())) + " pid=" + Process.myPid() + " tid=" + Process.myTid() + str + "\n");
        }
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void ot(String str) {
        if (this.Ux != null) {
            this.Ux.post(new a(this, str));
        }
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }
}
