package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.lib.c.b;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public final class d extends b {
    public d(Context context) {
        super(context);
    }

    public final void z(Intent intent) {
        Closeable fileOutputStream;
        Throwable e;
        super.z(intent);
        com.tencent.mm.plugin.hp.a.b.y(intent);
        e cd = e.cd(this.context);
        if (!cd.gEd) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String ab = TinkerPatchService.ab(intent);
            if (ab == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(ab);
            String Q = SharePatchFileUtil.Q(file);
            if (Q == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            a v;
            if (cd.gEe.exists()) {
                v = a.v(cd.gEe);
                if (v.aZy == null || v.gEh == null || !Q.equals(v.aZy)) {
                    cd.u(file);
                    v.aZy = Q;
                    v.gEh = "1";
                } else {
                    int i = be.getInt(v.gEh, 0);
                    if (i >= 4) {
                        SharePatchFileUtil.P(cd.gEf);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    v.gEh = String.valueOf(i + 1);
                }
            } else {
                cd.u(file);
                v = new a(Q, "1");
            }
            file = cd.gEe;
            if (v != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put("md5", v.aZy);
                properties.put("times", v.gEh);
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, null);
                        SharePatchFileUtil.c(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            a.a("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                            SharePatchFileUtil.c(fileOutputStream);
                        } catch (Throwable th) {
                            e = th;
                            SharePatchFileUtil.c(fileOutputStream);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    a.a("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                    SharePatchFileUtil.c(fileOutputStream);
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    SharePatchFileUtil.c(fileOutputStream);
                    throw e;
                }
            }
        }
    }

    public final void a(File file, File file2, String str, String str2, Throwable th) {
        super.a(file, file2, str, str2, th);
        com.tencent.mm.plugin.hp.a.b.d(th);
    }

    public final void a(File file, Throwable th) {
        super.a(file, th);
        com.tencent.mm.plugin.hp.a.b.c(th);
    }

    public final void a(File file, String str, String str2) {
        super.a(file, str, str2);
        com.tencent.mm.plugin.hp.a.b.atB();
    }

    public final void d(File file, int i) {
        super.d(file, i);
        com.tencent.mm.plugin.hp.a.b.lP(i);
    }

    public final void a(File file, boolean z, long j) {
        super.a(file, z, j);
        com.tencent.mm.plugin.hp.a.b.f(j, z);
        e cd = e.cd(this.context);
        if (!cd.gEd) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
        } else if (cd.gEf.exists()) {
            SharePatchFileUtil.P(cd.gEf);
        }
        v.btb();
    }

    public final void a(File file, File file2, String str, int i) {
        super.a(file, file2, str, i);
        com.tencent.mm.plugin.hp.a.b.lQ(i);
    }

    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        super.a(file, sharePatchInfo, str);
        com.tencent.mm.plugin.hp.a.b.atC();
    }
}
