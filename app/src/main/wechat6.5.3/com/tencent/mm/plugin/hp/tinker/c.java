package com.tencent.mm.plugin.hp.tinker;

import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.lib.a.b;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.lib.b.f;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;

public final class c {
    private static boolean gEb = false;

    public static void a(ApplicationLike applicationLike) {
        v.i("Tinker.TinkerPatchManager", "installing tinker");
        if (gEb) {
            v.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            return;
        }
        com.tencent.tinker.lib.c.c bVar = new b(applicationLike.getApplication());
        d dVar = new d(applicationLike.getApplication());
        b aVar = new a(applicationLike.getApplication());
        Class cls = TinkerPatchResultService.class;
        a fVar = new f();
        com.tencent.tinker.lib.d.a.a zx = new com.tencent.tinker.lib.d.a.a(applicationLike.getApplication()).zx(applicationLike.getTinkerFlags());
        if (zx.pFL != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        zx.pFL = bVar;
        if (zx.pFK != null) {
            throw new TinkerRuntimeException("listener is already set.");
        }
        zx.pFK = aVar;
        if (zx.pFM != null) {
            throw new TinkerRuntimeException("patchReporter is already set.");
        }
        zx.pFM = dVar;
        Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
        if (valueOf == null) {
            throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
        } else if (zx.pFV != null) {
            throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
        } else {
            zx.pFV = valueOf;
            com.tencent.tinker.lib.d.a bOZ = zx.bOZ();
            com.tencent.tinker.lib.d.a.a(bOZ);
            bOZ.a(applicationLike.getTinkerResultIntent(), cls, fVar);
            gEb = true;
        }
    }

    public static void atF() {
        e.cd(MMApplicationLike.getTinkerApplicationLike().getApplication()).gEd = true;
    }

    public static void atG() {
        com.tencent.tinker.lib.e.a.a(new com.tencent.tinker.lib.e.a.a() {
            public final void i(String str, String str2, Object... objArr) {
                v.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                v.w(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                v.e(str, str2, objArr);
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                v.a(str, th, str2, objArr);
            }
        });
    }

    public static void atH() {
        if (gEb) {
            com.tencent.tinker.lib.d.a.gh(MMApplicationLike.getTinkerApplicationLike().getApplication()).atH();
            return;
        }
        throw new RuntimeException("cleanPatch but tinker is not installed");
    }

    public static void uF(String str) {
        if (gEb) {
            com.tencent.tinker.lib.d.c.bA(MMApplicationLike.getTinkerApplicationLike().getApplication(), str);
            return;
        }
        throw new RuntimeException("upgrade patch but tinker is not installed");
    }
}
