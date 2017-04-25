package com.google.android.gms.c;

import com.google.android.gms.common.internal.g;
import java.util.regex.Pattern;

public final class ab {
    private static final Pattern ayB = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean ah(String str) {
        return str == null || g.aoc.l(str);
    }
}
