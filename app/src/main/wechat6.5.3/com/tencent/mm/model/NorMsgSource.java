package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Set;

public final class NorMsgSource {

    public static final class a {
        public static boolean checkMsgLevel() {
            long nanoTime = System.nanoTime();
            boolean zu = NorMsgSource.checkMsgLevel();
            v.i("MicroMsg.NorMsgSource", "call checkMsgLevel, duration: %d ns", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            b.itm.c(415, 1, 2, (int) r8, false);
            return zu;
        }

        public static byte[] checkSoftType(String str, int i) {
            long nanoTime = System.nanoTime();
            byte[] p = NorMsgSource.checkSoftType(str, i);
            v.i("MicroMsg.NorMsgSource", "call checkSoftType, duration: %d ns", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            b.itm.c(415, 4, 5, (int) r8, false);
            return p;
        }

        public static byte[] checkSoftType2(Context context, String str, int i) {
            long nanoTime = System.nanoTime();
            byte[] b = NorMsgSource.checkSoftType2(context, str, i);
            v.i("MicroMsg.NorMsgSource", "call checkSoftType2, duration: %d ns", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            b.itm.c(415, 7, 8, (int) r8, false);
            return b;
        }

        public static byte[] checkSoftType3(Context context) {
            long nanoTime = System.nanoTime();
            byte[] aH = NorMsgSource.checkSoftType3(context);
            v.i("MicroMsg.NorMsgSource", "call checkSoftType3, duration: %d ns", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            b.itm.c(415, 10, 11, (int) r8, false);
            return aH;
        }

        public static void checkSoftType4(Context context, Set<String> set) {
            long nanoTime = System.nanoTime();
            NorMsgSource.checkSoftType4(context, set);
            v.i("MicroMsg.NorMsgSource", "call checkSoftType4, duration: %d ns", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            b.itm.c(415, 13, 14, (int) r6, false);
        }
    }

    private static native boolean checkMsgLevel();

    private static native byte[] checkSoftType(String str, int i);

    private static native byte[] checkSoftType2(Context context, String str, int i);

    private static native byte[] checkSoftType3(Context context);

    private static native void checkSoftType4(Context context, Set<String> set);

    private static native int getCrc(String str, int i);

    private static native int norMsgSourceGet(String str, String str2);

    public static native int setLog(int i);

    private NorMsgSource() {
    }
}
