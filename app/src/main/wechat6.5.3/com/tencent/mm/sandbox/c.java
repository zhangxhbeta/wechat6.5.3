package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.recovery.b;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c nfe = null;
    private static Map<Integer, Boolean> nff = new HashMap();

    public static void e(int i, Object obj) {
        v.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        nff.put(Integer.valueOf(i), Boolean.valueOf(true));
        v.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + nff.size());
    }

    public static void f(int i, Object obj) {
        v.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        nff.remove(Integer.valueOf(i));
        v.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + nff.size());
        if (nff.size() == 0) {
            int myPid = Process.myPid();
            b.yH(13);
            Process.killProcess(myPid);
            v.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            v.btb();
        }
    }
}
