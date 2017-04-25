package com.google.android.gms.c;

final class ba implements Cloneable {
    static final bb aAN = new bb();
    boolean aAO;
    int[] aAP;
    bb[] aAQ;
    int hO;

    public ba() {
        this(10);
    }

    private ba(int i) {
        this.aAO = false;
        int Q = Q(i);
        this.aAP = new int[Q];
        this.aAQ = new bb[Q];
        this.hO = 0;
    }

    static int Q(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public final bb cg(int i) {
        if (this.aAO) {
            gc();
        }
        return this.aAQ[i];
    }

    final int ch(int i) {
        int i2 = 0;
        int i3 = this.hO - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.aAP[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final /* synthetic */ Object clone() {
        return ls();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (size() != baVar.size()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.aAP;
        int[] iArr2 = baVar.aAP;
        int i2 = this.hO;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            bb[] bbVarArr = this.aAQ;
            bb[] bbVarArr2 = baVar.aAQ;
            i2 = this.hO;
            for (i = 0; i < i2; i++) {
                if (!bbVarArr[i].equals(bbVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final void gc() {
        int i = this.hO;
        int[] iArr = this.aAP;
        bb[] bbVarArr = this.aAQ;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            bb bbVar = bbVarArr[i3];
            if (bbVar != aAN) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    bbVarArr[i2] = bbVar;
                    bbVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.aAO = false;
        this.hO = i2;
    }

    public final int hashCode() {
        if (this.aAO) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.hO; i2++) {
            i = (((i * 31) + this.aAP[i2]) * 31) + this.aAQ[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final ba ls() {
        int i = 0;
        int size = size();
        ba baVar = new ba(size);
        System.arraycopy(this.aAP, 0, baVar.aAP, 0, size);
        while (i < size) {
            if (this.aAQ[i] != null) {
                baVar.aAQ[i] = this.aAQ[i].lt();
            }
            i++;
        }
        baVar.hO = size;
        return baVar;
    }

    public final int size() {
        if (this.aAO) {
            gc();
        }
        return this.hO;
    }
}
