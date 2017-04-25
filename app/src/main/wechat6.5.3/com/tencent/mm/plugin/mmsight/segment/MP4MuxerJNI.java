package com.tencent.mm.plugin.mmsight.segment;

import java.nio.ByteBuffer;

public final class MP4MuxerJNI {
    public static final int SEGMENT_COLOR_FORMAT_YUV420P = 2;
    public static final int SEGMENT_COLOR_FORMAT_YUV420SP = 1;

    public static native boolean ffmpegCheckIfReachEndTimestamp();

    public static native byte[] ffmpegGetNextVideoFrameData(byte[] bArr);

    public static native int ffmpegGetVideoHeight();

    public static native int ffmpegGetVideoWidth();

    public static native int ffmpegOpenAndSeekFile(String str, double d, double d2);

    public static native byte[] getVideoThumb(String str, int i, int i2);

    public static native int initDataBuf(int i);

    public static native int initH264Encoder(int i, int i2, float f, int i3, int i4, int i5, int i6, float f2);

    public static native int muxing(int i, int i2, int i3, int i4, int i5, String str, float f, byte[] bArr, int i6);

    public static native int muxingForX264(int i, int i2, int i3, int i4, String str, float f, int i5, byte[] bArr, int i6);

    public static native void releaseDataBuf(int i);

    public static native int triggerEncodeForSegment(int i, boolean z);

    public static native void writeAACData(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeH264Data(int i, ByteBuffer byteBuffer, int i2);

    public static native int writeYuvDataForSegment(byte[] bArr, int i, int i2, int i3, int i4, int i5);
}
