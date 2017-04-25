package com.tencent.tinker.a.a.a;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] pAT = new short[0];
    public ByteBuffer hua;
    public int pBT;
    private boolean pBU;

    public a() {
        this.hua = ByteBuffer.allocate(512);
        this.hua.order(ByteOrder.LITTLE_ENDIAN);
        this.pBT = this.hua.position();
        this.hua.limit(this.hua.capacity());
        this.pBU = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.hua = byteBuffer;
        this.hua.order(ByteOrder.LITTLE_ENDIAN);
        this.pBT = byteBuffer.limit();
        this.pBU = false;
    }

    public final void yV(int i) {
        if (this.hua.position() + i > this.hua.limit() && this.pBU) {
            Object array = this.hua.array();
            Object obj = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, obj, 0, this.hua.position());
            int position = this.hua.position();
            this.hua = ByteBuffer.wrap(obj);
            this.hua.order(ByteOrder.LITTLE_ENDIAN);
            this.hua.position(position);
            this.hua.limit(this.hua.capacity());
        }
    }

    public final byte readByte() {
        return this.hua.get();
    }

    private int readUnsignedShort() {
        return this.hua.getShort() & 65535;
    }

    public final byte[] yW(int i) {
        byte[] bArr = new byte[i];
        this.hua.get(bArr);
        return bArr;
    }

    private short[] yX(int i) {
        if (i == 0) {
            return pAT;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.hua.getShort();
        }
        return sArr;
    }

    private int bON() {
        return o.b(this);
    }

    private int bOO() {
        return o.b(this) - 1;
    }

    private int bOP() {
        return o.a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tinker.a.a.s bOn() {
        /*
        r9 = this;
        r0 = 0;
        r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r9.hua;
        r2 = r1.position();
        r3 = com.tencent.tinker.a.a.o.b(r9);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4 = new char[r3];	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x000f:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1 & 255;
        r5 = (char) r1;	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r5 != 0) goto L_0x0050;
    L_0x0018:
        r1 = new java.lang.String;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r5 = 0;
        r1.<init>(r4, r5, r0);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r0 == r3) goto L_0x00be;
    L_0x0024:
        r0 = new com.tencent.tinker.a.a.j;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4 = "Declared length ";
        r2.<init>(r4);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r3 = " doesn't match decoded length of ";
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r2.append(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = r1.toString();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        r1 = new com.tencent.tinker.a.a.j;
        r1.<init>(r0);
        throw r1;
    L_0x0050:
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        if (r5 >= r8) goto L_0x0057;
    L_0x0054:
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0057:
        r1 = r5 & 224;
        r6 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        if (r1 != r6) goto L_0x007e;
    L_0x005d:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r6 = r1 & 255;
        r1 = r6 & 192;
        if (r1 == r8) goto L_0x0070;
    L_0x0067:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad second byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x0070:
        r1 = r0 + 1;
        r5 = r5 & 31;
        r5 = r5 << 6;
        r6 = r6 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1;
        goto L_0x000f;
    L_0x007e:
        r1 = r5 & 240;
        r6 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r1 != r6) goto L_0x00b5;
    L_0x0084:
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r6 = r1 & 255;
        r1 = r9.readByte();	 Catch:{ UTFDataFormatException -> 0x0049 }
        r7 = r1 & 255;
        r1 = r6 & 192;
        if (r1 != r8) goto L_0x0098;
    L_0x0094:
        r1 = r7 & 192;
        if (r1 == r8) goto L_0x00a1;
    L_0x0098:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad second or third byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x00a1:
        r1 = r0 + 1;
        r5 = r5 & 15;
        r5 = r5 << 12;
        r6 = r6 & 63;
        r6 = r6 << 6;
        r5 = r5 | r6;
        r6 = r7 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0 = r1;
        goto L_0x000f;
    L_0x00b5:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r1 = "bad byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0049 }
    L_0x00be:
        r0 = new com.tencent.tinker.a.a.s;	 Catch:{ UTFDataFormatException -> 0x0049 }
        r0.<init>(r2, r1);	 Catch:{ UTFDataFormatException -> 0x0049 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.a.a.a.a.bOn():com.tencent.tinker.a.a.s");
    }

    public u bOo() {
        return new u(this.hua.position(), yX(this.hua.getInt()));
    }

    public n bOp() {
        return new n(this.hua.position(), readUnsignedShort(), readUnsignedShort(), this.hua.getInt());
    }

    public p bOq() {
        return new p(this.hua.position(), readUnsignedShort(), readUnsignedShort(), this.hua.getInt());
    }

    public r bOr() {
        return new r(this.hua.position(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt());
    }

    public f bOs() {
        return new f(this.hua.position(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt(), this.hua.getInt());
    }

    public g bOt() {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        g.b[] bVarArr;
        int position = this.hua.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.hua.getInt();
        short[] yX = yX(this.hua.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            int i2;
            if (yX.length % 2 == 1) {
                this.hua.getShort();
            }
            int position3 = this.hua.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.hua.position();
            int b = o.b(this);
            aVarArr = new com.tencent.tinker.a.a.g.a[b];
            for (int i3 = 0; i3 < b; i3++) {
                position2 = this.hua.position() - position4;
                a = o.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = o.b(this);
                    iArr2[i2] = o.b(this);
                }
                aVarArr[i3] = new com.tencent.tinker.a.a.g.a(iArr, iArr2, a <= 0 ? o.b(this) : -1, position2);
            }
            position4 = this.hua.position();
            this.hua.position(position3);
            bVarArr = new g.b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.hua.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < aVarArr.length) {
                    if (aVarArr[i2].offset == a) {
                        bVarArr[position3] = new g.b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.hua.position(position4);
        } else {
            bVarArr = new g.b[0];
            aVarArr = new com.tencent.tinker.a.a.g.a[0];
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, yX, bVarArr, aVarArr);
    }

    public h bOu() {
        Throwable th;
        int position = this.hua.position();
        int b = o.b(this);
        int b2 = o.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = o.b(this) - 1;
        }
        final ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            b anonymousClass1 = new b(this) {
                final /* synthetic */ a pBW;

                public final void writeByte(int i) {
                    byteArrayOutputStream.write(i);
                }
            };
            while (true) {
                byte b3 = this.hua.get();
                byteArrayOutputStream.write(b3);
                switch (b3) {
                    case (byte) 0:
                        h hVar = new h(position, b, iArr, byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                        return hVar;
                    case (byte) 1:
                        o.a(anonymousClass1, bON());
                        break;
                    case (byte) 2:
                        try {
                            o.c(anonymousClass1, bOP());
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            break;
                        }
                    case (byte) 3:
                    case (byte) 4:
                        o.a(anonymousClass1, bON());
                        o.b(anonymousClass1, bOO());
                        o.b(anonymousClass1, bOO());
                        if (b3 != (byte) 4) {
                            break;
                        }
                        o.b(anonymousClass1, bOO());
                        break;
                    case (byte) 5:
                    case (byte) 6:
                        o.a(anonymousClass1, bON());
                        break;
                    case (byte) 9:
                        o.b(anonymousClass1, bOO());
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public e bOv() {
        return new e(this.hua.position(), yY(o.b(this)), yY(o.b(this)), yZ(o.b(this)), yZ(o.b(this)));
    }

    private com.tencent.tinker.a.a.e.a[] yY(int i) {
        int i2 = 0;
        com.tencent.tinker.a.a.e.a[] aVarArr = new com.tencent.tinker.a.a.e.a[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            aVarArr[i2] = new com.tencent.tinker.a.a.e.a(i3, o.b(this));
            i2++;
        }
        return aVarArr;
    }

    private e.b[] yZ(int i) {
        int i2 = 0;
        e.b[] bVarArr = new e.b[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            bVarArr[i2] = new e.b(i3, o.b(this), o.b(this));
            i2++;
        }
        return bVarArr;
    }

    private byte[] za(int i) {
        byte[] bArr = new byte[(this.hua.position() - i)];
        this.hua.position(i);
        this.hua.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a bOw() {
        int position = this.hua.position();
        byte b = this.hua.get();
        int position2 = this.hua.position();
        new m((com.tencent.tinker.a.a.b.a) this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b, new k(position2, za(position2)));
    }

    public com.tencent.tinker.a.a.b bOx() {
        int position = this.hua.position();
        int i = this.hua.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.hua.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c bOy() {
        int position = this.hua.position();
        int i = this.hua.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.hua.getInt();
        }
        return new c(position, iArr);
    }

    public d bOz() {
        int i;
        int position = this.hua.position();
        int i2 = this.hua.getInt();
        int i3 = this.hua.getInt();
        int i4 = this.hua.getInt();
        int i5 = this.hua.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.hua.getInt();
            iArr[i][1] = this.hua.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.hua.getInt();
            iArr2[i][1] = this.hua.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.hua.getInt();
            iArr3[i][1] = this.hua.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k bOA() {
        int position = this.hua.position();
        new m((com.tencent.tinker.a.a.b.a) this, 28).skipValue();
        return new k(position, za(position));
    }

    private void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.hua.position(this.hua.position() + i);
    }

    public final void writeByte(int i) {
        yV(1);
        this.hua.put((byte) i);
        if (this.hua.position() > this.pBT) {
            this.pBT = this.hua.position();
        }
    }

    public final void writeShort(short s) {
        yV(2);
        this.hua.putShort(s);
        if (this.hua.position() > this.pBT) {
            this.pBT = this.hua.position();
        }
    }

    private void zb(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        yV(4);
        this.hua.putInt(i);
        if (this.hua.position() > this.pBT) {
            this.pBT = this.hua.position();
        }
    }

    public final void write(byte[] bArr) {
        yV(bArr.length * 1);
        this.hua.put(bArr);
        if (this.hua.position() > this.pBT) {
            this.pBT = this.hua.position();
        }
    }

    public int a(s sVar) {
        int position = this.hua.position();
        try {
            o.a(this, sVar.value.length());
            String str = sVar.value;
            byte[] bArr = new byte[((int) q.Qu(str))];
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt != '\u0000' && charAt <= '') {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) charAt;
                } else if (charAt <= '߿') {
                    int i4 = i2 + 1;
                    bArr[i2] = (byte) (((charAt >> 6) & 31) | 192);
                    i3 = i4 + 1;
                    bArr[i4] = (byte) ((charAt & 63) | 128);
                } else {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) (((charAt >> 12) & 15) | 224);
                    i2 = i3 + 1;
                    bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                    i3 = i2 + 1;
                    bArr[i2] = (byte) ((charAt & 63) | 128);
                }
                i++;
                i2 = i3;
            }
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(u uVar) {
        int position = this.hua.position();
        short[] sArr = uVar.pBS;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.hua.position();
        zb(nVar.pBj);
        zb(nVar.pAw);
        writeInt(nVar.pBk);
        return position;
    }

    public int a(p pVar) {
        int position = this.hua.position();
        zb(pVar.pBj);
        zb(pVar.pBl);
        writeInt(pVar.pBk);
        return position;
    }

    public int a(r rVar) {
        int position = this.hua.position();
        writeInt(rVar.pBm);
        writeInt(rVar.pBn);
        writeInt(rVar.pBo);
        return position;
    }

    public int a(f fVar) {
        int position = this.hua.position();
        writeInt(fVar.pAw);
        writeInt(fVar.pAt);
        writeInt(fVar.pAx);
        writeInt(fVar.pAy);
        writeInt(fVar.pAz);
        writeInt(fVar.pAA);
        writeInt(fVar.pAB);
        writeInt(fVar.pAC);
        return position;
    }

    public int a(g gVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.hua.position();
        zb(gVar.pAD);
        zb(gVar.pAE);
        zb(gVar.pAF);
        zb(gVar.pAI.length);
        writeInt(gVar.pAG);
        writeInt(gVar.pAH.length);
        short[] sArr = gVar.pAH;
        yV(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.hua.position() > this.pBT) {
            this.pBT = this.hua.position();
        }
        if (gVar.pAI.length > 0) {
            if ((gVar.pAH.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.hua.position();
            length = gVar.pAI.length * 8;
            yV(length * 1);
            skip(length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.pAJ;
            int position3 = this.hua.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (length = 0; length < aVarArr.length; length++) {
                iArr[length] = this.hua.position() - position3;
                com.tencent.tinker.a.a.g.a aVar = aVarArr[length];
                int i2 = aVar.pAM;
                int[] iArr2 = aVar.pAK;
                int[] iArr3 = aVar.pAL;
                if (i2 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    o.a(this, iArr2[i3]);
                    o.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    o.a(this, i2);
                }
            }
            length = this.hua.position();
            this.hua.position(position);
            g.b[] bVarArr = gVar.pAI;
            position = bVarArr.length;
            while (i < position) {
                g.b bVar = bVarArr[i];
                writeInt(bVar.pAN);
                zb(bVar.pAO);
                zb(iArr[bVar.pAP]);
                i++;
            }
            this.hua.position(length);
        }
        return position2;
    }

    public int a(h hVar) {
        int position = this.hua.position();
        o.a(this, hVar.pAQ);
        o.a(this, r2);
        for (int i : hVar.pAR) {
            o.a(this, i + 1);
        }
        write(hVar.pAS);
        return position;
    }

    public int a(e eVar) {
        int position = this.hua.position();
        o.a(this, eVar.pAo.length);
        o.a(this, eVar.pAp.length);
        o.a(this, eVar.pAq.length);
        o.a(this, eVar.pAr.length);
        b(eVar.pAo);
        b(eVar.pAp);
        b(eVar.pAq);
        b(eVar.pAr);
        return position;
    }

    private void b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        int i = 0;
        int length = aVarArr.length;
        int i2 = 0;
        while (i < length) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            o.a(this, aVar.pAs - i2);
            i2 = aVar.pAs;
            o.a(this, aVar.pAt);
            i++;
        }
    }

    private void b(e.b[] bVarArr) {
        int i = 0;
        int length = bVarArr.length;
        int i2 = 0;
        while (i < length) {
            e.b bVar = bVarArr[i];
            o.a(this, bVar.pAu - i2);
            i2 = bVar.pAu;
            o.a(this, bVar.pAt);
            o.a(this, bVar.pAv);
            i++;
        }
    }

    public int a(com.tencent.tinker.a.a.a aVar) {
        int position = this.hua.position();
        writeByte(aVar.pAg);
        a(aVar.pAh);
        return position;
    }

    public int a(com.tencent.tinker.a.a.b bVar) {
        int position = this.hua.position();
        writeInt(bVar.pAi.length);
        for (int writeInt : bVar.pAi) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.hua.position();
        writeInt(cVar.pAj.length);
        for (int writeInt : cVar.pAj) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.hua.position();
        writeInt(dVar.pAk);
        writeInt(dVar.pAl.length);
        writeInt(dVar.pAm.length);
        writeInt(dVar.pAn.length);
        for (int[] iArr : dVar.pAl) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : dVar.pAm) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : dVar.pAn) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.hua.position();
        write(kVar.data);
        return position;
    }
}
