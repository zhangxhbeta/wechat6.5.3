package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] eab = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public final com.tencent.tinker.a.a.a.a pDV;
    private short pDW;
    public int pDX;
    private int pDY;
    public int pDZ;
    public int pEa;
    public int pEb;
    public int pEc;
    public int pEd;
    public int pEe;
    public int pEf;
    public int pEg;
    public int pEh;
    public int pEi;
    public int pEj;
    public int pEk;
    public int pEl;
    public int pEm;
    public int pEn;
    public int pEo;
    public int pEp;
    public byte[] pEq;

    public a(InputStream inputStream) {
        this.pDV = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.g(inputStream)));
        byte[] yW = this.pDV.yW(eab.length);
        if (c.m(yW, eab) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(yW));
        }
        this.pDW = this.pDV.hua.getShort();
        if (c.a(this.pDW, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.pDW + ", expected: 2");
        }
        this.pDX = this.pDV.hua.getInt();
        this.pDY = this.pDV.hua.getInt();
        this.pDZ = this.pDV.hua.getInt();
        this.pEa = this.pDV.hua.getInt();
        this.pEb = this.pDV.hua.getInt();
        this.pEc = this.pDV.hua.getInt();
        this.pEd = this.pDV.hua.getInt();
        this.pEe = this.pDV.hua.getInt();
        this.pEf = this.pDV.hua.getInt();
        this.pEg = this.pDV.hua.getInt();
        this.pEh = this.pDV.hua.getInt();
        this.pEi = this.pDV.hua.getInt();
        this.pEj = this.pDV.hua.getInt();
        this.pEk = this.pDV.hua.getInt();
        this.pEl = this.pDV.hua.getInt();
        this.pEm = this.pDV.hua.getInt();
        this.pEn = this.pDV.hua.getInt();
        this.pEo = this.pDV.hua.getInt();
        this.pEp = this.pDV.hua.getInt();
        this.pEq = this.pDV.yW(20);
        com.tencent.tinker.a.a.a.a aVar = this.pDV;
        aVar.hua.position(this.pDY);
    }
}
