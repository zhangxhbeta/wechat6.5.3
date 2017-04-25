package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class r {
    private static r ceN;
    public a ceO;

    public interface a {
        void ar(int i, int i2);

        int getInt(int i, int i2);

        long getLong(int i, long j);

        String getString(int i, String str);

        void i(int i, long j);

        void i(int i, String str);
    }

    public static r rZ() {
        if (ceN == null) {
            ceN = new r();
        }
        return ceN;
    }

    public final void a(a aVar) {
        v.d("MicroMsg.ExdeviceCfgHelper", "setCfgAccessible, process : %s", aa.getProcessName());
        this.ceO = aVar;
    }

    private r() {
    }

    public static void ar(int i, int i2) {
        v.d("MicroMsg.ExdeviceCfgHelper", "putInt(%s, %s), process : %s", Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName());
        if (rZ().ceO != null) {
            rZ().ceO.ar(i, i2);
        }
    }

    public static int getInt(int i, int i2) {
        v.d("MicroMsg.ExdeviceCfgHelper", "getInt(%s, %s), process : %s", Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName());
        if (rZ().ceO != null) {
            return rZ().ceO.getInt(i, i2);
        }
        return i2;
    }

    public static void i(int i, long j) {
        v.d("MicroMsg.ExdeviceCfgHelper", "putLong(%s, %s), process : %s", Integer.valueOf(i), Long.valueOf(j), aa.getProcessName());
        if (rZ().ceO != null) {
            rZ().ceO.i(i, j);
        }
    }

    public static long getLong(int i, long j) {
        v.d("MicroMsg.ExdeviceCfgHelper", "getLong(%s, %s), process : %s", Integer.valueOf(i), Long.valueOf(j), aa.getProcessName());
        if (rZ().ceO != null) {
            return rZ().ceO.getLong(i, j);
        }
        return j;
    }
}
