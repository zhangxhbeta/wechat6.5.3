package com.tencent.smtt.sdk.a;

import com.tencent.mmdb.FileUtils;
import java.lang.reflect.Array;

public final class a {
    private static final int[] pyn = new int[]{58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private static final int[] pyo = new int[]{40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    private static final int[] pyp = new int[]{57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    private static final int[] pyq = new int[]{14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
    private static final int[] pyr = new int[]{32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
    private static final int[] pys = new int[]{16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
    private static final int[][][] pyt;
    private static final int[] pyu = new int[]{1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    public static final byte[] pyv = new byte[]{(byte) 98, (byte) -24, (byte) 57, (byte) -84, (byte) -115, (byte) 117, (byte) 55, (byte) 121};
    public static final byte[] pyw = new byte[]{(byte) -25, (byte) -101, (byte) -115, (byte) 1, (byte) 47, (byte) 7, (byte) -27, (byte) -59, (byte) 18, Byte.MIN_VALUE, (byte) 123, (byte) 79, (byte) -44, (byte) 37, (byte) 46, (byte) 115};
    public static final byte[] pyx = new byte[]{(byte) 37, (byte) -110, (byte) 60, Byte.MAX_VALUE, (byte) 42, (byte) -27, (byte) -17, (byte) -110};
    public static final byte[] pyy = new byte[]{(byte) -122, (byte) -8, (byte) -23, (byte) -84, (byte) -125, (byte) 113, (byte) 84, (byte) 99};
    public static final byte[] pyz = "AL!#$AC9Ahg@KLJ1".getBytes();

    static {
        r0 = new int[8][][];
        r0[0] = new int[][]{new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
        r0[1] = new int[][]{new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
        r0[2] = new int[][]{new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
        r0[3] = new int[][]{new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
        r0[4] = new int[][]{new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
        r0[5] = new int[][]{new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
        r0[6] = new int[][]{new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
        r0[7] = new int[][]{new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
        pyt = r0;
    }

    private static int[] bw(byte[] bArr) {
        int i;
        int[] iArr = new int[8];
        for (i = 0; i < 8; i++) {
            iArr[i] = bArr[i];
            if (iArr[i] < 0) {
                iArr[i] = iArr[i] + FileUtils.S_IRUSR;
                iArr[i] = iArr[i] % FileUtils.S_IRUSR;
            }
        }
        int[] iArr2 = new int[64];
        for (i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                iArr2[((i * 8) + 7) - i2] = iArr[i] % 2;
                iArr[i] = iArr[i] / 2;
            }
        }
        return iArr2;
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr == null) {
            return bArr2;
        }
        try {
            int i;
            Object obj = new byte[8];
            for (i = 0; i < 8; i++) {
                obj[i] = (byte) 0;
            }
            if (bArr.length > 8) {
                System.arraycopy(bArr, 0, obj, 0, 8);
            } else {
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
            }
            i = bArr2.length;
            int i2 = 8 - (i % 8);
            int i3 = i + i2;
            Object obj2 = new byte[i3];
            System.arraycopy(bArr2, 0, obj2, 0, i);
            while (i < i3) {
                obj2[i] = (byte) i2;
                i++;
            }
            int i4 = i3 / 8;
            Object obj3 = new byte[i3];
            for (int i5 = 0; i5 < i4; i5++) {
                int[] iArr;
                int[] iArr2;
                int[] iArr3;
                int[] iArr4;
                int i6;
                Object obj4 = new byte[8];
                Object obj5 = new byte[8];
                System.arraycopy(obj, 0, obj4, 0, 8);
                System.arraycopy(obj2, i5 * 8, obj5, 0, 8);
                int[][] iArr5 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{16, 48});
                int[] bw = bw(obj4);
                int[] bw2 = bw(obj5);
                int[] iArr6 = new int[56];
                for (i = 0; i < 56; i++) {
                    iArr6[i] = bw[pyp[i] - 1];
                }
                for (i = 0; i < 16; i++) {
                    int i7 = pyu[i];
                    iArr = new int[28];
                    iArr2 = new int[28];
                    iArr3 = new int[28];
                    iArr4 = new int[28];
                    for (i6 = 0; i6 < 28; i6++) {
                        iArr[i6] = iArr6[i6];
                        iArr2[i6] = iArr6[i6 + 28];
                    }
                    if (i7 == 1) {
                        for (i6 = 0; i6 < 27; i6++) {
                            iArr3[i6] = iArr[i6 + 1];
                            iArr4[i6] = iArr2[i6 + 1];
                        }
                        iArr3[27] = iArr[0];
                        iArr4[27] = iArr2[0];
                    } else if (i7 == 2) {
                        for (i6 = 0; i6 < 26; i6++) {
                            iArr3[i6] = iArr[i6 + 2];
                            iArr4[i6] = iArr2[i6 + 2];
                        }
                        iArr3[26] = iArr[0];
                        iArr4[26] = iArr2[0];
                        iArr3[27] = iArr[1];
                        iArr4[27] = iArr2[1];
                    }
                    for (i6 = 0; i6 < 28; i6++) {
                        iArr6[i6] = iArr3[i6];
                        iArr6[i6 + 28] = iArr4[i6];
                    }
                    for (i6 = 0; i6 < 48; i6++) {
                        iArr5[i][i6] = iArr6[pyq[i6] - 1];
                    }
                }
                Object obj6 = new byte[8];
                iArr = new int[64];
                iArr2 = new int[64];
                for (i = 0; i < 64; i++) {
                    iArr[i] = bw2[pyn[i] - 1];
                }
                for (i6 = 0; i6 < 16; i6++) {
                    int i8;
                    iArr3 = new int[32];
                    iArr4 = new int[32];
                    int[] iArr7 = new int[32];
                    int[] iArr8 = new int[32];
                    int[] iArr9 = new int[48];
                    int[][] iArr10 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{8, 6});
                    int[] iArr11 = new int[8];
                    int[] iArr12 = new int[32];
                    int[] iArr13 = new int[32];
                    for (i8 = 0; i8 < 32; i8++) {
                        iArr3[i8] = iArr[i8];
                        iArr4[i8] = iArr[i8 + 32];
                    }
                    for (i8 = 0; i8 < 48; i8++) {
                        iArr9[i8] = iArr4[pyr[i8] - 1];
                        iArr9[i8] = iArr9[i8] + iArr5[i6][i8];
                        if (iArr9[i8] == 2) {
                            iArr9[i8] = 0;
                        }
                    }
                    for (i8 = 0; i8 < 8; i8++) {
                        int i9;
                        for (i9 = 0; i9 < 6; i9++) {
                            iArr10[i8][i9] = iArr9[(i8 * 6) + i9];
                        }
                        iArr11[i8] = pyt[i8][(iArr10[i8][0] << 1) + iArr10[i8][5]][(((iArr10[i8][1] << 3) + (iArr10[i8][2] << 2)) + (iArr10[i8][3] << 1)) + iArr10[i8][4]];
                        for (i9 = 0; i9 < 4; i9++) {
                            iArr12[((i8 * 4) + 3) - i9] = iArr11[i8] % 2;
                            iArr11[i8] = iArr11[i8] / 2;
                        }
                    }
                    for (i = 0; i < 32; i++) {
                        iArr13[i] = iArr12[pys[i] - 1];
                        iArr7[i] = iArr4[i];
                        iArr8[i] = iArr3[i] + iArr13[i];
                        if (iArr8[i] == 2) {
                            iArr8[i] = 0;
                        }
                        if (i6 == 15) {
                            iArr[i] = iArr8[i];
                            iArr[i + 32] = iArr7[i];
                        } else {
                            iArr[i] = iArr7[i];
                            iArr[i + 32] = iArr8[i];
                        }
                    }
                }
                for (i = 0; i < 64; i++) {
                    iArr2[i] = iArr[pyo[i] - 1];
                }
                for (i2 = 0; i2 < 8; i2++) {
                    for (i = 0; i < 8; i++) {
                        obj6[i2] = (byte) (obj6[i2] + (iArr2[(i2 << 3) + i] << (7 - i)));
                    }
                }
                System.arraycopy(obj6, 0, obj3, i5 * 8, 8);
            }
            return obj3;
        } catch (Exception e) {
            return bArr2;
        }
    }
}
