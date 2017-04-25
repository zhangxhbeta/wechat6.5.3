package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.v;

public class QbarNative {
    public byte[] data = new byte[3000];
    public byte[] ptp = new byte[100];
    public byte[] ptq = new byte[100];
    public int[] ptr = new int[4];
    public byte[] pts = new byte[300];
    public int[] ptt = new int[2];
    public int ptu = -1;

    private static class a {
    }

    private native int DetectCode(byte[] bArr, int i, int i2, int i3, int i4);

    private static native int Encode(byte[] bArr, int[] iArr, String str, int i, int i2, String str2, int i3);

    private static native int EncodeBitmap(String str, Bitmap bitmap, int i, int i2, int i3, int i4, String str2, int i5);

    public static native int FocusInit(int i, int i2, boolean z, int i3, int i4);

    public static native boolean FocusPro(byte[] bArr, boolean z, boolean[] zArr);

    public static native int FocusRelease();

    private native int GetOneResult(byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, int i);

    private native int GetOneResultReport(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int[] iArr, int[] iArr2, int i);

    private native int GetResults(byte[] bArr, byte[] bArr2, byte[] bArr3, Point[] pointArr, int[] iArr, a aVar, int i);

    private static native String GetVersion();

    public static native int QIPUtilYUVCrop(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private native int ScanImage(byte[] bArr, int i, int i2, int i3, int i4);

    public static native int focusedEngineForBankcardInit(int i, int i2, int i3, boolean z);

    public static native int focusedEngineGetVersion();

    public static native int focusedEngineProcess(byte[] bArr);

    public static native int focusedEngineRelease();

    private static native int nativeArrayConvert(int i, int i2, byte[] bArr, int[] iArr);

    private static native int nativeCropGray2(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private static native int nativeGrayRotateCropSub(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int[] iArr, int i7, int i8);

    public static native int nativeRelease();

    private static native int nativeTransBytes(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeTransPixels(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeYUVrotate(byte[] bArr, byte[] bArr2, int i, int i2);

    private static native int nativeYUVrotateLess(byte[] bArr, int i, int i2);

    private static native int nativeYuvToCropIntArray(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int Init(int i, int i2, int i3, String str, String str2);

    public native int Release(int i);

    public native int SetReaders(int[] iArr, int i, int i2);

    static {
        k.b("wechatQrMod", QbarNative.class.getClassLoader());
    }

    public static String getVersion() {
        return GetVersion();
    }

    public static int a(byte[] bArr, int[] iArr, String str, int i, int i2, String str2) {
        return Encode(bArr, iArr, str, i, i2, str2, -1);
    }

    public final int g(byte[] bArr, int i, int i2) {
        return ScanImage(bArr, i, i2, 0, this.ptu);
    }

    public final int a(StringBuilder stringBuilder, StringBuilder stringBuilder2, StringBuilder stringBuilder3, StringBuilder stringBuilder4, int[] iArr) {
        int GetOneResultReport = GetOneResultReport(this.ptp, this.data, this.ptq, this.pts, this.ptt, this.ptr, this.ptu);
        try {
            iArr[0] = this.ptt[0];
            iArr[1] = this.ptt[1];
            String str = new String(this.ptq, 0, this.ptr[2], "UTF-8");
            stringBuilder3.append(str);
            if (str.equals("ANY")) {
                stringBuilder.append(new String(this.ptp, 0, this.ptr[0], "UTF-8"));
                stringBuilder2.append(new String(this.data, 0, this.ptr[1], "UTF-8"));
                stringBuilder4.append(new String(this.pts, 0, this.ptr[3], "UTF-8"));
                if (stringBuilder2.length() == 0) {
                    stringBuilder.append(new String(this.ptp, 0, this.ptr[0], "ASCII"));
                    stringBuilder2.append(new String(this.data, 0, this.ptr[1], "ASCII"));
                    stringBuilder4.append(new String(this.pts, 0, this.ptr[3], "ASCII"));
                }
            } else {
                stringBuilder.append(new String(this.ptp, 0, this.ptr[0], str));
                stringBuilder2.append(new String(this.data, 0, this.ptr[1], str));
                stringBuilder4.append(new String(this.pts, 0, this.ptr[3], str));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.QbarNative", e, "", new Object[0]);
        }
        return GetOneResultReport;
    }

    public static int a(byte[] bArr, int[] iArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (bArr == null || bArr2 == null) {
            return -1;
        }
        return nativeGrayRotateCropSub(bArr2, i, i2, i3, i4, i5, i6, bArr, iArr, i7, 0);
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr2 == null) {
            return -1;
        }
        return nativeYUVrotate(bArr, bArr2, i, i2);
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        if (bArr == null || bArr2 == null) {
            return -1;
        }
        return nativeCropGray2(bArr, bArr2, i, i2, i3);
    }

    public static int a(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (bArr == null) {
            return -1;
        }
        return nativeYuvToCropIntArray(bArr, iArr, i, i2, i3, i4, i5, i6);
    }
}
