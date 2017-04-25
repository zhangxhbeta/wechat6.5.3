package com.tencent.mm.b;

public final class j {
    public static int bf(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                }
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }
}
