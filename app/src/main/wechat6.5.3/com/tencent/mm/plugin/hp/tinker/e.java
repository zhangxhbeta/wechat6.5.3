package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class e {
    private static e gEg;
    Context context = null;
    boolean gEd = false;
    File gEe = null;
    File gEf = null;

    static class a {
        String aZy;
        String gEh;

        a(String str, String str2) {
            this.aZy = str;
            this.gEh = str2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.tencent.mm.plugin.hp.tinker.e.a v(java.io.File r5) {
            /*
            r0 = 0;
            r3 = new java.util.Properties;
            r3.<init>();
            r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0025, all -> 0x002c }
            r2.<init>(r5);	 Catch:{ IOException -> 0x0025, all -> 0x002c }
            r3.load(r2);	 Catch:{ IOException -> 0x0035, all -> 0x0033 }
            r1 = "md5";
            r1 = r3.getProperty(r1);	 Catch:{ IOException -> 0x0035, all -> 0x0033 }
            r4 = "times";
            r0 = r3.getProperty(r4);	 Catch:{ IOException -> 0x0038, all -> 0x0033 }
            com.tencent.tinker.loader.shareutil.SharePatchFileUtil.c(r2);
        L_0x001f:
            r2 = new com.tencent.mm.plugin.hp.tinker.e$a;
            r2.<init>(r1, r0);
            return r2;
        L_0x0025:
            r1 = move-exception;
            r2 = r0;
            r1 = r0;
        L_0x0028:
            com.tencent.tinker.loader.shareutil.SharePatchFileUtil.c(r2);
            goto L_0x001f;
        L_0x002c:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
        L_0x002f:
            com.tencent.tinker.loader.shareutil.SharePatchFileUtil.c(r2);
            throw r0;
        L_0x0033:
            r0 = move-exception;
            goto L_0x002f;
        L_0x0035:
            r1 = move-exception;
            r1 = r0;
            goto L_0x0028;
        L_0x0038:
            r3 = move-exception;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.tinker.e.a.v(java.io.File):com.tencent.mm.plugin.hp.tinker.e$a");
        }
    }

    private e(Context context) {
        this.context = context;
        this.gEe = new File(SharePatchFileUtil.gp(context), "patch.retry");
        this.gEf = new File(SharePatchFileUtil.gp(context), "temp.apk");
    }

    public static e cd(Context context) {
        if (gEg == null) {
            gEg = new e(context);
        }
        return gEg;
    }

    final void u(File file) {
        if (!file.getAbsolutePath().equals(this.gEf.getAbsolutePath())) {
            com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.gEf.getAbsolutePath()});
            try {
                SharePatchFileUtil.h(file, this.gEf);
            } catch (IOException e) {
            }
        }
    }
}
