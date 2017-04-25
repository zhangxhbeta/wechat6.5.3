package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.i.e;
import java.util.Arrays;

public final class t {
    public int fileSize;
    public final a pBA = new a(8192, false);
    public final a pBB = new a(8193, true);
    public final a pBC = new a(8194, false);
    public final a pBD = new a(8195, false);
    public final a pBE = new a(8196, false);
    public final a pBF = new a(8197, false);
    public final a pBG = new a(8198, true);
    public final a[] pBH = new a[]{this.pBp, this.pBq, this.pBr, this.pBs, this.pBt, this.pBu, this.pBv, this.pBw, this.pBx, this.pBy, this.pBz, this.pBA, this.pBB, this.pBC, this.pBD, this.pBE, this.pBF, this.pBG};
    public int pBI;
    public int pBJ;
    public int pBK;
    public int pBL;
    public int pBM;
    public byte[] pBd = new byte[20];
    public final a pBp = new a(0, true);
    public final a pBq = new a(1, true);
    public final a pBr = new a(2, true);
    public final a pBs = new a(3, true);
    public final a pBt = new a(4, true);
    public final a pBu = new a(5, true);
    public final a pBv = new a(6, true);
    public final a pBw = new a(4096, true);
    public final a pBx = new a(4097, true);
    public final a pBy = new a(4098, true);
    public final a pBz = new a(4099, true);

    public static class a implements Comparable<a> {
        public final short pBN;
        public boolean pBO;
        public int pBP = -1;
        public int pBQ = 0;
        public int size = 0;

        public static abstract class a<T> implements Comparable<T> {
            public int pBP;

            public a(int i) {
                this.pBP = i;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (this.pBP != aVar.pBP) {
                return this.pBP < aVar.pBP ? -1 : 1;
            } else {
                int yU = yU(this.pBN);
                int yU2 = yU(aVar.pBN);
                if (yU != yU2) {
                    return yU >= yU2 ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }

        public a(int i, boolean z) {
            this.pBN = (short) i;
            this.pBO = z;
            if (i == 0) {
                this.pBP = 0;
                this.size = 1;
                this.pBQ = 112;
            } else if (i == 4096) {
                this.size = 1;
            }
        }

        public final boolean exists() {
            return this.size > 0;
        }

        private static int yU(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 4096:
                    return 17;
                case 4097:
                    return 8;
                case 4098:
                    return 11;
                case 4099:
                    return 10;
                case 8192:
                    return 15;
                case 8193:
                    return 14;
                case 8194:
                    return 7;
                case 8195:
                    return 13;
                case 8196:
                    return 9;
                case 8197:
                    return 16;
                case 8198:
                    return 12;
                default:
                    throw new IllegalArgumentException("unknown section type: " + i);
            }
        }

        public final String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.pBN), Integer.valueOf(this.pBP), Integer.valueOf(this.size)});
        }
    }

    final void a(e eVar) {
        int i = eVar.hua.getInt();
        int i2 = 0;
        a aVar = null;
        while (i2 < i) {
            int i3;
            short s = eVar.hua.getShort();
            eVar.hua.getShort();
            for (a aVar2 : this.pBH) {
                if (aVar2.pBN == s) {
                    i3 = eVar.hua.getInt();
                    int i4 = eVar.hua.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i3) && (aVar2.pBP == -1 || aVar2.pBP == i4)) {
                        aVar2.size = i3;
                        aVar2.pBP = i4;
                        if (aVar == null || aVar.pBP <= aVar2.pBP) {
                            i2++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.pBp.pBP = 0;
        Arrays.sort(this.pBH);
        for (i3 = 1; i3 < this.pBH.length; i3++) {
            if (this.pBH[i3].pBP == -1) {
                this.pBH[i3].pBP = this.pBH[i3 - 1].pBP;
            }
        }
    }

    public final void bOM() {
        int i = this.fileSize;
        for (int length = this.pBH.length - 1; length >= 0; length--) {
            a aVar = this.pBH[length];
            if (aVar.pBP != -1) {
                if (aVar.pBP > i) {
                    throw new j("Map is unsorted at " + aVar);
                }
                aVar.pBQ = i - aVar.pBP;
                i = aVar.pBP;
            }
        }
        this.pBM = (((((this.pBp.pBQ + this.pBq.pBQ) + this.pBr.pBQ) + this.pBs.pBQ) + this.pBt.pBQ) + this.pBu.pBQ) + this.pBv.pBQ;
        this.pBL = this.fileSize - this.pBM;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.pBH) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.pBH) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.pBN);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.pBP);
            }
        }
    }
}
