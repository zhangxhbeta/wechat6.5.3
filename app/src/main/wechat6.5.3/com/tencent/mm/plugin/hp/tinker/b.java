package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    public final void a(Throwable th, int i) {
        super.a(th, i);
        com.tencent.mm.plugin.hp.a.b.a(th, i);
    }

    public final void a(File file, int i) {
        super.a(file, i);
        com.tencent.mm.plugin.hp.a.b.lS(i);
    }

    public final void a(File file, int i, boolean z) {
        super.a(file, i, z);
        com.tencent.mm.plugin.hp.a.b.lR(i);
    }

    public final void b(File file, int i) {
        super.b(file, i);
        com.tencent.mm.plugin.hp.a.b.g(aa.niD, i);
    }

    public final void a(String str, String str2, File file) {
        super.a(str, str2, file);
        com.tencent.mm.plugin.hp.a.b.atD();
    }

    public final void a(String str, String str2, File file, String str3) {
        super.a(str, str2, file, str3);
        com.tencent.mm.plugin.hp.a.b.atE();
    }

    public final void a(File file, int i, long j) {
        super.a(file, i, j);
        switch (i) {
            case 0:
                com.tencent.mm.plugin.hp.a.b.g(j, com.tencent.tinker.lib.d.a.gh(this.context).pFP);
                break;
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ b gEa;

            {
                this.gEa = r1;
            }

            public final boolean queueIdle() {
                e cd = e.cd(this.gEa.context);
                if (!cd.gEd) {
                    com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
                } else if (!com.tencent.tinker.lib.d.a.gh(cd.context).pFP) {
                    com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
                } else if (!cd.gEe.exists()) {
                    com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
                } else if (com.tencent.tinker.lib.e.b.gj(cd.context)) {
                    com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
                } else {
                    String absolutePath = cd.gEf.getAbsolutePath();
                    if (absolutePath == null || !new File(absolutePath).exists()) {
                        com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
                    } else {
                        com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[]{absolutePath});
                        c.bA(cd.context, absolutePath);
                        com.tencent.mm.plugin.hp.a.b.atz();
                    }
                }
                return false;
            }
        });
    }

    public final void c(File file, int i) {
        super.c(file, i);
        if (i == -12) {
            ShareTinkerInternals.gt(this.context);
            com.tencent.tinker.lib.d.a.gh(this.context).tinkerFlags = 0;
        }
        com.tencent.mm.plugin.hp.a.b.lO(i);
    }
}
