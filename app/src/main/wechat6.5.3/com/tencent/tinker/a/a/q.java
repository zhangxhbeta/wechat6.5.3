package com.tencent.tinker.a.a;

import java.io.UTFDataFormatException;

public final class q {
    public static long Qu(String str) {
        int length = str.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\u0000' && charAt <= '') {
                j++;
            } else if (charAt <= '߿') {
                j += 2;
            } else {
                j += 3;
            }
            if (j > 65535) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return j;
    }
}
