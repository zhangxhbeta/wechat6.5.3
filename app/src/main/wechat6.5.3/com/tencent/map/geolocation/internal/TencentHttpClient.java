package com.tencent.map.geolocation.internal;

import android.util.Pair;

public interface TencentHttpClient {
    Pair<byte[], String> postSync(String str, byte[] bArr);
}
