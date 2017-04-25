package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.d.b;
import com.tencent.mm.sdk.platformtools.v;

public final class l {
    public int cGx;
    public int ceR = 1;
    public int fWf = -1;
    public int hme = -1;
    public VideoTransPara hnB;
    public boolean hnC = false;
    public boolean hnD = false;
    public boolean hnE = true;
    b hnF;
    public boolean hnq = false;

    public static l a(int i, VideoTransPara videoTransPara) {
        l lVar;
        switch (i) {
            case 1:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
                lVar = new l(2, videoTransPara);
                lVar.hnD = false;
                break;
            case 2:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
                lVar = new l(2, videoTransPara);
                lVar.hnD = false;
                lVar = lVar.aAb().aAa();
                break;
            case 3:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
                lVar = new l(1, videoTransPara);
                lVar.hnD = false;
                break;
            case 4:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
                lVar = new l(1, videoTransPara);
                lVar.hnD = false;
                lVar = lVar.aAb().aAa();
                break;
            case 5:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
                lVar = new l(2, videoTransPara);
                lVar.hnD = false;
                lVar = lVar.aAa();
                break;
            case 6:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
                lVar = new l(1, videoTransPara);
                lVar.hnD = false;
                lVar = lVar.aAa();
                break;
            case 7:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
                lVar = new l(2, videoTransPara);
                lVar.hnD = true;
                lVar = lVar.aAc();
                lVar.hnC = false;
                break;
            case 8:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
                lVar = new l(2, videoTransPara);
                lVar.hnD = true;
                lVar = lVar.aAc();
                lVar.hnC = true;
                break;
            case 9:
                lVar = new l(1, videoTransPara);
                lVar.hnD = true;
                lVar = lVar.aAc();
                lVar.hnC = false;
                break;
            case 10:
                v.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                lVar = new l(1, videoTransPara);
                lVar.hnD = true;
                lVar = lVar.aAc();
                lVar.hnC = true;
                break;
            default:
                return null;
        }
        if (lVar == null) {
            return lVar;
        }
        lVar.fWf = i;
        return lVar;
    }

    private l(int i, VideoTransPara videoTransPara) {
        this.hnB = videoTransPara;
        this.ceR = i;
        this.cGx = videoTransPara.cGx;
        this.hme = videoTransPara.width;
    }

    public final l aAa() {
        this.hme = 720;
        return this;
    }

    public final l aAb() {
        this.cGx = this.hnB.cGx * 2;
        return this;
    }

    public final l aAc() {
        this.hme = this.hnB.width * 2;
        return this;
    }

    public final boolean aAd() {
        return this.hnB.width < this.hme;
    }

    public final String toString() {
        return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.ceR), Integer.valueOf(this.cGx), Boolean.valueOf(this.hnq), Boolean.valueOf(this.hnC), Boolean.valueOf(this.hnD), Integer.valueOf(this.hme), this.hnB});
    }
}
