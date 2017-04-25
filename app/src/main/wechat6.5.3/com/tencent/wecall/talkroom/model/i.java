package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public final class i {
    public int QW;
    public int Zx;
    public int pJM;
    public int pJN;
    public int pJO;
    public int pJP;
    public int pJQ;
    public int pJR;
    public int pJS;
    public int pJT;
    public int pJU;
    public int ppk;

    public i(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.pJM = i;
        this.Zx = i2;
        this.QW = i3;
        this.pJN = i4;
        this.pJO = i5;
        this.pJP = i6;
        this.pJQ = i7;
        this.ppk = i8;
        this.pJR = i9;
        this.pJS = i10;
        this.pJT = i11;
        this.pJU = i12;
        c.d("VoiceEngineConf", "mDisableVideo: ", Integer.valueOf(i), " mWidth: ", Integer.valueOf(i2), " mHeight: ", Integer.valueOf(i3), " mInFPS: ", Integer.valueOf(i4), " mOutFmt: ", Integer.valueOf(i5), " mOSType: ", Integer.valueOf(i6), " mNetKbps: ", Integer.valueOf(i7), " mNetType: ", Integer.valueOf(i8), " mMTUSize: ", Integer.valueOf(i9), " mCPUFlag: ", Integer.valueOf(i10), " mDispRate: ", Integer.valueOf(i11), " mVCodecType: ", Integer.valueOf(i12));
    }
}
