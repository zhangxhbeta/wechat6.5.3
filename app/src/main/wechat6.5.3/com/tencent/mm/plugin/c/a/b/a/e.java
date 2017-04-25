package com.tencent.mm.plugin.c.a.b.a;

import com.tencent.mm.plugin.c.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String erG = h.eqy;
    public static final String erH = h.eqz;
    public static final String erI = h.eqA;
    public static final String erJ = h.eqB;
    public byte erK;
    public byte erL;
    public byte erM;
    public byte erN;
    public byte[] erO;
    public int erP;
    public byte erQ;
    public byte erR;
    public byte[] erS;

    public e() {
        this.eqO = null;
        this.eqP = 8;
        this.eqh = 16;
        this.erK = (byte) 0;
        this.erL = (byte) 0;
        this.erM = (byte) 0;
        this.erN = (byte) 0;
        this.erO = new byte[]{(byte) 0, (byte) 0};
        this.erP = -1;
        this.erQ = (byte) 0;
        this.erR = (byte) 0;
        this.erS = null;
    }

    public final byte[] Xt() {
        if (this.eqO.equalsIgnoreCase(erG)) {
            Object obj = new byte[3];
            System.arraycopy(Byte.valueOf(this.erK), 0, obj, 0, 1);
            System.arraycopy(Byte.valueOf(this.erL), 0, obj, 1, 1);
            System.arraycopy(Byte.valueOf(this.erM), 0, obj, 2, 1);
            return obj;
        } else if (this.eqO.equalsIgnoreCase(erH)) {
            r0 = new byte[1];
            System.arraycopy(Byte.valueOf(this.erN), 0, r0, 0, 1);
            return r0;
        } else if (!this.eqO.equalsIgnoreCase(erJ)) {
            return null;
        } else {
            r0 = new byte[this.erP];
            byte b = (byte) ((this.erP >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.erP & 255)), 0, r0, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, r0, 1, 1);
            System.arraycopy(Byte.valueOf(this.erQ), 0, r0, 2, 1);
            if (this.erP <= 3) {
                return r0;
            }
            System.arraycopy(this.erS, 0, r0, 3, this.erP - 3);
            return r0;
        }
    }
}
