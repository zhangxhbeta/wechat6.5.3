package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public class a {
    private static a pHG = null;
    private f pHH = null;

    public static a bPh() {
        if (pHG == null) {
            synchronized (a.class) {
                if (pHG == null) {
                    pHG = new a();
                }
            }
        }
        return pHG;
    }

    public static f bPi() {
        a bPh = bPh();
        if (bPh.pHH == null) {
            synchronized (a.class) {
                if (bPh.pHH == null) {
                    bPh.pHH = new f();
                }
            }
        }
        return bPh.pHH;
    }

    public static void bPj() {
        c.d("MicroMsg.Voip", "registerEvents");
        bPi();
    }
}
