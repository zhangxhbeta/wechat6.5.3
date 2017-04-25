package com.tencent.qafpapi;

import com.tencent.mm.compatible.util.k;

public class QAFPNative {
    public static native int QAFPGetAudioFingerPrint(byte[] bArr);

    public static native int QAFPGetAudioFingerPrintTV(byte[] bArr);

    public static native int QAFPGetVersion();

    public static native int QAFPInit();

    public static native int QAFPProcess(byte[] bArr, int i);

    public static native int QAFPProcessTV(byte[] bArr, int i);

    public static native int QAFPRelease();

    public static native int QAFPReset();

    static {
        k.b("wechatQAFP", QAFPNative.class.getClassLoader());
    }
}
