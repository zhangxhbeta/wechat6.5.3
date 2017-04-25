package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import java.io.FileDescriptor;
import java.io.InputStream;

public class MMGIFJNI {
    static native byte[] decFile(String str, String str2);

    static native boolean drawFrameBitmap(long j, Bitmap bitmap, int[] iArr);

    static native boolean drawFramePixels(long j, int[] iArr, int[] iArr2);

    static native void encFile(String str, String str2);

    static native String encodeString(String str);

    static native int getCurrentFrameDuration(long j);

    static native int getCurrentFrameIndex(long j);

    static native int getHeight(long j);

    static native int getTotalFrameCount(long j);

    static native int getWidth(long j);

    static native void isEncFile(String str);

    static native boolean isGif(long j);

    public static native void lockBitmap(Bitmap bitmap);

    static native long openByByteArray(byte[] bArr, int[] iArr);

    static native long openByFileDescroptor(FileDescriptor fileDescriptor, long j, int[] iArr);

    static native long openByFilePath(String str, int[] iArr);

    static native long openByInputStrem(InputStream inputStream, int[] iArr);

    static native void recycle(long j);

    static native void reset(long j);

    static native void restoreRemainder(long j);

    static native void saveRemainder(long j);
}
