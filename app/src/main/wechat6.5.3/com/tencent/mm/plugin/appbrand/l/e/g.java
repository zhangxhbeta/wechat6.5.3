package com.tencent.mm.plugin.appbrand.l.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> dUM = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public final Iterator<String> SF() {
        return Collections.unmodifiableSet(this.dUM.keySet()).iterator();
    }

    public final String oC(String str) {
        String str2 = (String) this.dUM.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final byte[] SG() {
        return this.content;
    }

    public final void K(byte[] bArr) {
        this.content = bArr;
    }

    public final void put(String str, String str2) {
        this.dUM.put(str, str2);
    }

    public final boolean oD(String str) {
        return this.dUM.containsKey(str);
    }
}
