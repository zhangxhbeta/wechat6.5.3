package com.tencent.mm.plugin.c.a.b.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.c.a.b.h;
import com.tencent.mm.sdk.platformtools.v;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String erT = h.eqw;
    public static String erU = h.eqx;
    public int erV;
    public int erW;
    public int erX;
    public long erY;
    public long erZ;

    public f() {
        this.eqO = null;
        this.eqP = 8;
        this.eqh = 1;
        this.erV = -1;
        this.erW = -1;
        this.erX = -1;
        this.erY = 0;
        this.erZ = 0;
    }

    public final byte[] Xt() {
        if (this.erV < 0) {
            v.e(TAG, "stepCount is invalid");
            return null;
        }
        int i;
        if (this.erW >= 0) {
            i = 7;
        } else {
            i = 4;
        }
        if (this.erX >= 0) {
            i += 3;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) 1;
        i = 1;
        int i2 = 0;
        while (i2 < 3) {
            bArr[i] = (byte) ((this.erV >> (i2 * 8)) & 255);
            i2++;
            i++;
        }
        if (this.erW >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            i2 = 0;
            while (i2 < 3) {
                bArr[i] = (byte) ((this.erW >> (i2 * 8)) & 255);
                i2++;
                i++;
            }
        }
        if (this.erX >= 0) {
            bArr[0] = (byte) 4;
            int i3 = i;
            for (i = 0; i < 3; i++) {
                bArr[i3] = (byte) ((this.erX >> (i * 8)) & 255);
                i3++;
            }
        }
        return bArr;
    }
}
