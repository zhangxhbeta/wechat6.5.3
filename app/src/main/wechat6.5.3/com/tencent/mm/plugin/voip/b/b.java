package com.tencent.mm.plugin.voip.b;

import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<Integer, String> kzQ;

    static {
        Map hashMap = new HashMap();
        kzQ = hashMap;
        hashMap.put(Integer.valueOf(0), "CALLING_STATE_VIDEO_INVITING");
        kzQ.put(Integer.valueOf(1), "CALLING_STATE_VOICE_INVITING");
        kzQ.put(Integer.valueOf(2), "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
        kzQ.put(Integer.valueOf(3), "CALLING_STATE_VOICE_WAITTING_ACCEPT");
        kzQ.put(Integer.valueOf(4), "CALLING_STATE_VIDEO_CONNECTING");
        kzQ.put(Integer.valueOf(5), "CALLING_STATE_VOICE_CONNECTING");
        kzQ.put(Integer.valueOf(6), "CALLING_STATE_VIDEO_TALKING");
        kzQ.put(Integer.valueOf(7), "CALLING_STATE_VOICE_TALKING");
        kzQ.put(Integer.valueOf(8), "CALLING_STATE_FINISH");
        kzQ.put(Integer.valueOf(256), "CALLED_STATE_VIDEO_INVITING");
        kzQ.put(Integer.valueOf(257), "CALLED_STATE_VOICE_INVITING");
        kzQ.put(Integer.valueOf(258), "CALLED_STATE_VIDEO_CONNECTING");
        kzQ.put(Integer.valueOf(259), "CALLED_STATE_VOICE_CONNECTING");
        kzQ.put(Integer.valueOf(260), "CALLED_STATE_VIDEO_TALKING");
        kzQ.put(Integer.valueOf(261), "CALLED_STATE_VOICE_TALKING");
        kzQ.put(Integer.valueOf(262), "CALLED_STATE_FINISH");
        kzQ.put(Integer.valueOf(4096), "ACTION_NOP");
        kzQ.put(Integer.valueOf(4097), "ACTION_INVITE_RESPOND");
        kzQ.put(Integer.valueOf(4098), "ACTION_CANCEL_INVITE");
        kzQ.put(Integer.valueOf(4099), "ACTION_REJECT_INVITE");
        kzQ.put(Integer.valueOf(4100), "ACTION_ACCEPT_INVITE");
        kzQ.put(Integer.valueOf(4101), "ACTION_CLOSE_CAMERA");
        kzQ.put(Integer.valueOf(4102), "ACTION_CONNECT_SUCC");
        kzQ.put(Integer.valueOf(4103), "ACTION_SELF_HANGUP");
        kzQ.put(Integer.valueOf(4104), "ACTION_ANOTHER_HANGUP");
        kzQ.put(Integer.valueOf(4105), "ACTION_INVITE_TIMEOUT");
        kzQ.put(Integer.valueOf(4106), "ACTION_SO_SHUTDOWN");
        kzQ.put(Integer.valueOf(4107), "ACTION_PHONE_COMING");
        kzQ.put(Integer.valueOf(4108), "ACTION_IGNORE_INVITE");
        kzQ.put(Integer.valueOf(4109), "ACTION_ON_ERROR");
        kzQ.put(Integer.valueOf(4110), "ACTION_SESSION_CALLED");
    }

    public static String rV(int i) {
        if (kzQ.containsKey(Integer.valueOf(i))) {
            return (String) kzQ.get(Integer.valueOf(i));
        }
        return "no found value";
    }

    public static c rW(int i) {
        c cVar = new c(i);
        cVar.M(256, 4098, 262);
        cVar.M(256, 4099, 262);
        cVar.M(256, 4105, 262);
        cVar.M(256, 4106, 262);
        cVar.M(256, 4107, 262);
        cVar.M(256, 4108, 262);
        cVar.M(256, 4109, 262);
        cVar.M(256, 4100, 258);
        cVar.M(256, 4101, 257);
        cVar.M(257, 4100, 259);
        cVar.M(257, 4098, 262);
        cVar.M(257, 4099, 262);
        cVar.M(257, 4105, 262);
        cVar.M(257, 4106, 262);
        cVar.M(257, 4107, 262);
        cVar.M(257, 4108, 262);
        cVar.M(257, 4109, 262);
        cVar.M(258, 4098, 262);
        cVar.M(258, 4106, 262);
        cVar.M(258, 4107, 262);
        cVar.M(258, 4103, 262);
        cVar.M(258, 4109, 262);
        cVar.M(258, 4102, 260);
        cVar.M(259, 4102, 261);
        cVar.M(259, 4098, 262);
        cVar.M(259, 4106, 262);
        cVar.M(259, 4107, 262);
        cVar.M(259, 4103, 262);
        cVar.M(259, 4109, 262);
        cVar.M(260, 4101, 261);
        cVar.M(260, 4103, 262);
        cVar.M(260, 4104, 262);
        cVar.M(260, 4106, 262);
        cVar.M(260, 4107, 262);
        cVar.M(260, 4109, 262);
        cVar.M(261, 4103, 262);
        cVar.M(261, 4104, 262);
        cVar.M(261, 4106, 262);
        cVar.M(261, 4107, 262);
        cVar.M(261, 4109, 262);
        return cVar;
    }

    public static c rX(int i) {
        c cVar = new c(i);
        cVar.M(0, 4098, 8);
        cVar.M(0, 4106, 8);
        cVar.M(0, 4107, 8);
        cVar.M(0, 4109, 8);
        cVar.M(0, 4097, 2);
        cVar.M(0, 4101, 1);
        cVar.M(1, 4097, 3);
        cVar.M(1, 4098, 8);
        cVar.M(1, 4106, 8);
        cVar.M(1, 4107, 8);
        cVar.M(1, 4109, 8);
        cVar.M(2, 4098, 8);
        cVar.M(2, 4099, 8);
        cVar.M(2, 4105, 8);
        cVar.M(2, 4106, 8);
        cVar.M(2, 4107, 8);
        cVar.M(2, 4109, 8);
        cVar.M(2, 4100, 4);
        cVar.M(2, 4101, 3);
        cVar.M(3, 4100, 5);
        cVar.M(3, 4098, 8);
        cVar.M(3, 4099, 8);
        cVar.M(3, 4105, 8);
        cVar.M(3, 4106, 8);
        cVar.M(3, 4107, 8);
        cVar.M(3, 4109, 8);
        cVar.M(4, 4102, 6);
        cVar.M(4, 4101, 5);
        cVar.M(5, 4102, 7);
        cVar.M(6, 4103, 8);
        cVar.M(6, 4104, 8);
        cVar.M(6, 4106, 8);
        cVar.M(6, 4107, 8);
        cVar.M(6, 4109, 8);
        cVar.M(6, 4101, 7);
        cVar.M(7, 4103, 8);
        cVar.M(7, 4104, 8);
        cVar.M(7, 4106, 8);
        cVar.M(7, 4107, 8);
        cVar.M(7, 4109, 8);
        cVar.M(4, 4098, 8);
        cVar.M(4, 4099, 8);
        cVar.M(4, 4106, 8);
        cVar.M(4, 4107, 8);
        cVar.M(4, 4103, 8);
        cVar.M(4, 4109, 8);
        cVar.M(5, 4098, 8);
        cVar.M(5, 4099, 8);
        cVar.M(5, 4106, 8);
        cVar.M(5, 4107, 8);
        cVar.M(5, 4103, 8);
        cVar.M(5, 4109, 8);
        cVar.M(0, 4110, 4);
        cVar.M(1, 4110, 5);
        return cVar;
    }

    public static boolean rY(int i) {
        return 260 == i || 261 == i || 6 == i || 7 == i;
    }

    public static boolean rZ(int i) {
        return i == 0 || 2 == i || 4 == i || 6 == i || 256 == i || 258 == i || 260 == i;
    }

    public static boolean sa(int i) {
        return 1 == i || i == 0 || 2 == i || 3 == i;
    }

    public static int w(boolean z, boolean z2) {
        if (true == z && true == z2) {
            return 0;
        }
        if (true == z && !z2) {
            return 1;
        }
        if (z || true != z2) {
            return 257;
        }
        return 256;
    }
}
