package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.common.c.c;

public final class j {
    public static boolean QW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("client_");
    }

    public static int bPQ() {
        int i = 0;
        try {
            return a.bPi().gLN;
        } catch (Exception e) {
            c.i("tagorewang:VoiceGroupUtil", "getActiveRoomId err: ", e);
            return i;
        }
    }

    public static long bPR() {
        try {
            return a.bPi().pIi;
        } catch (Exception e) {
            c.i("tagorewang:VoiceGroupUtil", "getActiveRoomKey err: ", e);
            return 0;
        }
    }
}
