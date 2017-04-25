package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.io.File;

public final class m {
    public static String as(String str, boolean z) {
        String str2 = t.cng;
        v.i("MicroMsg.VoicePrintLogic", "dbCachePath " + str2);
        str2 = str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str;
        v.i("MicroMsg.VoicePrintLogic", "genpath " + str2);
        if (be.kS(str2)) {
            return null;
        }
        return (z || !new File(str2).exists()) ? str2 : str2;
    }
}
