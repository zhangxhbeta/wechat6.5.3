package com.tencent.mm.modelsearch;

import com.tencent.mm.modelsearch.p.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FTSUtils {
    static native int countTokens(String str);

    private static native void nativeInitFts(long j, byte[] bArr);

    public static native int stringCompareUtfBinary(String str, String str2);

    public static void a(SQLiteDatabase sQLiteDatabase, byte[] bArr) {
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle(false, false);
        nativeInitFts(acquireNativeConnectionHandle, bArr);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle);
    }

    public static int[] e(String[] strArr) {
        int[] iArr = new int[strArr.length];
        if (strArr.length > 0) {
            iArr[0] = 0;
            for (int i = 1; i < strArr.length; i++) {
                iArr[i] = iArr[i - 1] + countTokens(strArr[i - 1]);
            }
        }
        return iArr;
    }

    public static int b(int[] iArr, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        int i4 = i >= iArr.length ? Integer.MAX_VALUE : iArr[i];
        if (i2 < iArr.length) {
            i3 = iArr[i2];
        }
        return i4 - i3;
    }

    public static int a(Map<Integer, Integer> map, int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        if (i == i2) {
            return 0;
        }
        Integer num = (Integer) map.get(Integer.valueOf(i));
        int intValue = num == null ? Integer.MAX_VALUE : num.intValue();
        num = (Integer) map.get(Integer.valueOf(i2));
        if (num != null) {
            i3 = num.intValue();
        }
        return intValue - i3;
    }

    public static List<h> a(List<h> list, final Map<Integer, Integer> map, int i, int i2) {
        int i3;
        int i4;
        int i5;
        Comparator anonymousClass1 = new Comparator<h>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return FTSUtils.a(map, ((h) obj).type, ((h) obj2).type);
            }
        };
        h hVar = new h();
        hVar.type = i;
        int binarySearch = Collections.binarySearch(list, hVar, anonymousClass1);
        if (i2 == i) {
            i3 = binarySearch;
        } else {
            hVar.type = i2;
            i3 = Collections.binarySearch(list, hVar, anonymousClass1);
        }
        if (binarySearch < 0) {
            i4 = (-binarySearch) - 1;
        } else {
            while (true) {
                i5 = binarySearch - 1;
                if (i5 < 0 || ((h) list.get(i5)).type != i) {
                    i4 = i5 + 1;
                } else {
                    binarySearch = i5;
                }
            }
            i4 = i5 + 1;
        }
        if (i3 < 0) {
            binarySearch = (-i3) - 1;
        } else {
            int size = list.size();
            i5 = i3 + 1;
            while (i5 < size && ((h) list.get(i5)).type == i2) {
                i5++;
            }
            binarySearch = i5;
        }
        return list.subList(i4, binarySearch);
    }

    public static String i(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('(');
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
        return stringBuilder.toString();
    }

    public static String jG(String str) {
        if (str != null) {
            return str.replace('*', ' ').trim();
        }
        return null;
    }
}
