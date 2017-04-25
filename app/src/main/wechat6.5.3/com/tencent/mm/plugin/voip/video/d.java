package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class d {
    private static final HashMap<String, Integer> kAA;
    public static Context mContext;
    public Object kAB = new Object();
    public ToneGenerator kAC;
    private final int kAD = 250;

    static {
        HashMap hashMap = new HashMap();
        kAA = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        kAA.put("2", Integer.valueOf(2));
        kAA.put("3", Integer.valueOf(3));
        kAA.put("4", Integer.valueOf(4));
        kAA.put("5", Integer.valueOf(5));
        kAA.put("6", Integer.valueOf(6));
        kAA.put("7", Integer.valueOf(7));
        kAA.put("8", Integer.valueOf(8));
        kAA.put("9", Integer.valueOf(9));
        kAA.put("0", Integer.valueOf(0));
        kAA.put("#", Integer.valueOf(11));
        kAA.put("*", Integer.valueOf(10));
    }

    public d(Context context) {
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.kAB) {
                    if (bdL() && this.kAC == null) {
                        this.kAC = new ToneGenerator(3, 66);
                    }
                }
            } catch (Exception e) {
                v.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                v.d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.kAC = null;
            }
        }
    }

    private d() {
    }

    public static boolean bdL() {
        return System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
    }

    public static int CQ(String str) {
        if (str == null || str.equals("") || !kAA.containsKey(str)) {
            return -1;
        }
        return ((Integer) kAA.get(str)).intValue();
    }
}
