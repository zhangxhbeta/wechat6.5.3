package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {
    private static Map<Integer, List<Integer>> gEL = new HashMap();
    public int gEK = -1;

    public final boolean lV(int i) {
        int i2 = this.gEK == -1 ? 1 : (gEL.containsKey(Integer.valueOf(this.gEK)) && ((List) gEL.get(Integer.valueOf(this.gEK))).contains(Integer.valueOf(i))) ? 1 : 0;
        if (i2 != 0) {
            v.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", new Object[]{stateToString(this.gEK), stateToString(i)});
            this.gEK = i;
            return true;
        }
        v.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", new Object[]{stateToString(i.auq().gEK), stateToString(i)});
        return false;
    }

    public final boolean aug() {
        return this.gEK == 1 || this.gEK == 3 || this.gEK == 4 || this.gEK == 5;
    }

    public final boolean auh() {
        return this.gEK == 4 || this.gEK == 5;
    }

    public final boolean aui() {
        return this.gEK == 5;
    }

    public final boolean auj() {
        return this.gEK == 5;
    }

    public static String stateToString(int i) {
        switch (i) {
            case -1:
                return "RESET_STATE";
            case 1:
                return "START_INVITE";
            case 2:
                return "INVITE_FAILED";
            case 3:
                return "INVITE_SUCCESS";
            case 4:
                return "RING_ING";
            case 5:
                return "USER_ACCEPT";
            case 8:
                return "USER_CANCEL";
            case 9:
                return "USER_SELF_SHUTDOWN";
            case 10:
                return "OTHER_SIDE_USER_SHUTDOWN";
            case 11:
                return "USER_SELF_SHUTDOWN_BY_ERR";
            case 12:
                return "CANCEL_BY_ERR";
            default:
                return String.valueOf(i);
        }
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(3));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        gEL.put(Integer.valueOf(1), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(12));
        arrayList.add(Integer.valueOf(8));
        gEL.put(Integer.valueOf(2), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(4));
        arrayList.add(Integer.valueOf(5));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        gEL.put(Integer.valueOf(3), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(5));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        gEL.put(Integer.valueOf(4), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(9));
        arrayList.add(Integer.valueOf(10));
        arrayList.add(Integer.valueOf(11));
        gEL.put(Integer.valueOf(5), arrayList);
    }
}
