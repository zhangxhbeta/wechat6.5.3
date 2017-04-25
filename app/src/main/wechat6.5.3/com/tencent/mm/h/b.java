package com.tencent.mm.h;

import com.tencent.mm.sdk.platformtools.be;

public final class b {
    public static int sD() {
        return be.getInt(j.sU().getValue("InputLimitSessionTextMsg"), 8192) * 2;
    }

    public static int sE() {
        return be.getInt(j.sU().getValue("InputLimitSNSObjectText"), 2000) * 2;
    }

    public static int sF() {
        return be.getInt(j.sU().getValue("SnsCommentMaxSize"), 1000) * 2;
    }

    public static int sG() {
        return be.getInt(j.sU().getValue("InputLimitFavText"), 100000) * 2;
    }

    public static int sH() {
        return be.getInt(j.sU().getValue("InputLimitSendEmotionBufSize"), 1048576);
    }

    public static int sI() {
        return be.getInt(j.sU().getValue("InputLimitSendEmotionWidth"), 1024);
    }

    public static int sJ() {
        return be.getInt(j.sU().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
    }

    public static int sK() {
        return be.getInt(j.sU().getValue("InputLimitFavImageSize"), 26214400);
    }

    public static String sL() {
        return j.sU().getValue("InputLimitForbiddenChar");
    }
}
