package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.pluginsdk.ui.tools.SightParams;
import com.tencent.mm.storage.t.a;

public final class i {
    private static i hoG = new i();
    public SightParams hoH;

    public static i aAw() {
        return hoG;
    }

    public static c c(VideoTransPara videoTransPara) {
        switch (g.hns.ceR) {
            case 1:
                return new j(videoTransPara);
            case 2:
                return new l(videoTransPara);
            default:
                return null;
        }
    }

    public static int aAx() {
        return g.hns.cGx;
    }

    public static int aAy() {
        return g.hns.hme;
    }

    public static boolean aAz() {
        return ((Integer) CaptureMMProxy.getInstance().get(a.ntB, Integer.valueOf(0))).intValue() == 1;
    }

    public static String aAA() {
        switch (g.hns.ceR) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
