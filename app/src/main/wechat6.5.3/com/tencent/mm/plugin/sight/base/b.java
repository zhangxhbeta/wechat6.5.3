package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    private static long iTA = 0;
    public static int iTs = 1;
    public static int iTt = 1;
    public static int iTu = 640000;
    public static float iTv = 24.0f;
    private static int iTw = 8000;
    private static int iTx = 16000;
    private static int iTy = 44100;
    private static int iTz = 64000;

    private static void aON() {
        if (be.ay(iTA) > 300000) {
            iTy = j.sU().getInt("SightEncodeAudioSampleRate", 44100);
            iTz = j.sU().getInt("SightEncodeAudioBitRate", 64000);
            iTA = System.currentTimeMillis();
        }
    }

    public static int aOO() {
        aON();
        v.i("MicroMsg.SightConstants", "sight sampleRate is %s", Integer.valueOf(iTy));
        return iTy;
    }

    public static int aOP() {
        aON();
        v.i("MicroMsg.SightConstants", "sight bitRate is %s", Integer.valueOf(iTz));
        return iTz;
    }
}
