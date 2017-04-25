package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public interface b {

    public static class a {
        public int aJW;
        public String biS;

        a() {
            this.aJW = 0;
        }

        a(byte b) {
            this.aJW = 0;
            this.aJW = 131072;
        }
    }

    byte[] a(Asset asset);

    HashSet<String> bhS();

    boolean bhT();

    void finish();

    boolean g(Uri uri);

    boolean isAvailable();

    a r(String str, byte[] bArr);

    a s(String str, byte[] bArr);
}
