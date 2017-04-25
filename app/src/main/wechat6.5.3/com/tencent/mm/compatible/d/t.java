package com.tencent.mm.compatible.d;

public final class t {
    public int ceR;
    public int ceS;
    public int ceT;
    public int ceU;
    public int ceV;
    public int ceW;
    public int ceX;

    public t() {
        reset();
    }

    public final void reset() {
        this.ceR = -1;
        this.ceS = -1;
        this.ceT = -1;
        this.ceU = -1;
        this.ceV = -1;
        this.ceW = -1;
        this.ceX = -1;
    }

    public final String toString() {
        return String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s", new Object[]{Integer.valueOf(this.ceR), Integer.valueOf(this.ceS), Integer.valueOf(this.ceT), Integer.valueOf(this.ceU), Integer.valueOf(this.ceV), Integer.valueOf(this.ceW), Integer.valueOf(this.ceX)});
    }
}
