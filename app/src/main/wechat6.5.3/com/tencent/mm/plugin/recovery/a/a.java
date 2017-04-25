package com.tencent.mm.plugin.recovery.a;

import android.content.Context;
import com.tencent.mm.plugin.recovery.service.RecoveryTinkerResultService;
import com.tencent.recovery.c.b;
import com.tencent.tinker.lib.b.f;
import com.tencent.tinker.loader.app.ApplicationLike;

public final class a {
    private static boolean gEb = false;

    public static void a(ApplicationLike applicationLike) {
        if (!gEb) {
            b.i("MicroMsg.Recovery.RecoveryTinkerManager", "install tinker manager", new Object[0]);
            com.tencent.tinker.lib.e.a.a(new com.tencent.tinker.lib.e.a.a() {
                public final void i(String str, String str2, Object... objArr) {
                    b.i(str, str2, objArr);
                }

                public final void w(String str, String str2, Object... objArr) {
                    b.w(str, str2, objArr);
                }

                public final void e(String str, String str2, Object... objArr) {
                    b.e(str, str2, objArr);
                }

                public final void a(String str, Throwable th, String str2, Object... objArr) {
                    b.a(str, th, str2, objArr);
                }
            });
            com.tencent.tinker.lib.d.a bOZ = new com.tencent.tinker.lib.d.a.a(applicationLike.getApplication()).zx(applicationLike.getTinkerFlags()).bOZ();
            com.tencent.tinker.lib.d.a.a(bOZ);
            bOZ.a(applicationLike.getTinkerResultIntent(), RecoveryTinkerResultService.class, new f());
            gEb = true;
        }
    }

    public static int am(Context context, String str) {
        b.i("MicroMsg.Recovery.RecoveryTinkerManager", "onReceiveUpgradePatch %s", new Object[]{str});
        return com.tencent.tinker.lib.d.a.gh(context).pFK.Qw(str);
    }
}
