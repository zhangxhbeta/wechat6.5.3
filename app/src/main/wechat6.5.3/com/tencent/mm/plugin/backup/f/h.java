package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.v;

public final class h {
    public static int ehO;
    public static int ehP;
    public static int ehQ;
    public static int ehR;
    public static int ehS;
    public static int ehT;
    public static int ehU;
    public static long ehV;
    public static long ehW;
    public static long ehX;

    public static void reset() {
        ehO = 0;
        ehP = 0;
        ehQ = 0;
        ehR = 0;
        ehS = 0;
        ehT = 0;
        ehU = 0;
        long currentTimeMillis = System.currentTimeMillis();
        ehV = currentTimeMillis;
        ehX = currentTimeMillis - ehW;
    }

    public static void ie(int i) {
        switch (i) {
            case 1:
                ehQ++;
                break;
            case 3:
                ehO++;
                break;
            case 34:
                ehS++;
                break;
            case 37:
            case 40:
            case 42:
            case 48:
            case 10000:
                ehP++;
                break;
            case 43:
                ehR++;
                break;
            case 49:
                ehT++;
                break;
        }
        ehU++;
    }

    public static void UH() {
        v.d("MicroMsg.TestInfo", "total_count: " + ehU + "text_count: " + ehQ + "normal_count : " + ehP + " image_count: " + ehO + " voice_count : " + ehS + " video_count " + ehR + " app_count : " + ehT + " time: " + (System.currentTimeMillis() - ehV) + " net: " + ehX);
    }

    public static void UI() {
        v.d("MicroMsg.TestInfo", "netTime" + (System.currentTimeMillis() - ehW));
    }
}
