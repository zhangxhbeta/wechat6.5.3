package com.tencent.mm.bh;

import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.concurrent.Executors;

public final class b {
    private static boolean nyQ = false;

    static /* synthetic */ void jr(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", str);
        } else if (h.sj()) {
            File file = new File(str);
            if (file.exists()) {
                String a = p.a(file, true, null);
                if (a != null) {
                    File file2 = new File(a);
                    if (ak.isWifi(aa.getContext()) || file2.length() <= 5242880) {
                        v.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", Boolean.valueOf(com.tencent.mm.platformtools.p.a(a, k.xF(), true, false)));
                        if (com.tencent.mm.platformtools.p.a(a, k.xF(), true, false)) {
                            e.f(new File(a.nyP));
                            return;
                        }
                        return;
                    }
                    v.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                    return;
                }
                return;
            }
            v.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
        } else {
            v.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
        }
    }

    public static void vp(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        switch (i) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                v.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        v.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                if (b.nyQ) {
                    v.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    return;
                }
                String E;
                if (z4) {
                    E = a.E(true, false);
                } else {
                    E = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = ak.isWifi(aa.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || r0 == null) {
                        E = z ? a.nyP : null;
                    }
                    b.nyQ = true;
                    b.jr(E);
                    b.nyQ = false;
                    return;
                }
                v.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
            }
        });
    }
}
