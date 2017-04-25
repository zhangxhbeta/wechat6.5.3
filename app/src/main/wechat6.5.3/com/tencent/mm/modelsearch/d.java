package com.tencent.mm.modelsearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class d {
    public static final int[] cVA = new int[27];
    public static final Pattern cVB = Pattern.compile(";");
    public static final Pattern cVC = Pattern.compile(" ");
    public static final Pattern cVD = Pattern.compile("​");
    public static final Pattern cVE = Pattern.compile("\\s+");
    public static final Pattern cVF = Pattern.compile(",");
    public static final int[] cVi = new int[]{65536};
    public static final int[] cVj = new int[]{196608};
    public static final int[] cVk = new int[]{262144};
    public static final int[] cVl = new int[]{327680};
    public static final int[] cVm = new int[]{131072, 131075, 131076, 131073, 131074};
    public static final int[] cVn = new int[]{131072, 131075, 131076};
    public static final int[] cVo = new int[]{131072};
    public static final int[] cVp = new int[]{131073, 131074};
    public static final int[] cVq = new int[]{131077, 131078};
    public static final int[] cVr = new int[]{131079, 131080};
    public static final Map<Integer, Integer> cVs;
    public static final int[] cVt = new int[]{37, 34, 29, 35, 36, 30, 31, 33};
    public static final int[] cVu = new int[]{15, 1, 2, 3, 5, 6, 7};
    public static final int[] cVv = new int[]{37, 29, 30, 31, 34, 35, 36, 33, 32};
    public static final int[] cVw = new int[]{16, 12, 13, 14, 34, 35, 36};
    public static final int[] cVx;
    public static final int[] cVy;
    public static final int[] cVz = new int[43];
    public static final int[] ldi = new int[]{393216};

    static {
        int i;
        int i2 = 0;
        int[] iArr = new int[]{8, 9, 10};
        cVx = iArr;
        cVy = iArr;
        int[] iArr2 = new int[]{131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = new int[]{1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        Map hashMap = new HashMap();
        for (i = 0; i < 9; i++) {
            hashMap.put(Integer.valueOf(iArr2[i]), Integer.valueOf(i));
        }
        cVs = Collections.unmodifiableMap(hashMap);
        for (i = 0; i < 43; i++) {
            cVz[iArr3[i]] = i;
        }
        while (i2 < 27) {
            cVA[iArr4[i2]] = i2;
            i2++;
        }
    }
}
