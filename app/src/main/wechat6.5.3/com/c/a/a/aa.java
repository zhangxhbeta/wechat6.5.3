package com.c.a.a;

import java.util.TimeZone;

final class aa {
    static long p(long j) {
        return (((long) TimeZone.getDefault().getOffset(j)) + j) / 1000;
    }
}
