package com.tencent.mm.ar;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    public static long h(String str, long j) {
        long j2 = 0;
        if (str != null) {
            f kG = l.KC().kG(str);
            if (kG != null) {
                j2 = kG.field_createTime + 1;
            }
        }
        return j2 > j * 1000 ? j2 : j * 1000;
    }

    public static void kE(String str) {
        boolean z;
        v.d("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, talker = " + str);
        v.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + l.KD().kD(str));
        g KC = l.KC();
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
            z = false;
        } else {
            z = KC.cie.dF("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + be.lZ(str) + "'");
        }
        v.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + z);
    }
}
