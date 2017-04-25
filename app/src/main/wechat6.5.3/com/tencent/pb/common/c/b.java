package com.tencent.pb.common.c;

import java.util.HashMap;
import java.util.Map;

public final class b {
    public static <E> Map<E, E> u(E... eArr) {
        if (eArr.length % 2 != 0) {
            throw new IllegalArgumentException("length of map is " + eArr.length);
        }
        Map<E, E> hashMap = new HashMap();
        for (int i = 0; i < eArr.length; i += 2) {
            hashMap.put(eArr[i], eArr[i + 1]);
        }
        return hashMap;
    }
}
