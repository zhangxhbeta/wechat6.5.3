package com.tencent.mm.plugin.c.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public String eqO;
    public int eqP;
    public long eqh;

    public abstract byte[] Xt();

    public static a ab(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            v.e(TAG, "data input error");
            return null;
        }
        Object an = b.an(bArr);
        if (an != null && (an instanceof a)) {
            return (a) an;
        }
        v.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
