package com.google.android.gms.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bb implements Cloneable {
    private az<?, ?> aAR;
    private Object aAS;
    List<bg> aAT = new ArrayList();

    bb() {
    }

    private byte[] toByteArray() {
        byte[] bArr = new byte[kF()];
        a(ax.b(bArr, 0, bArr.length));
        return bArr;
    }

    final void a(ax axVar) {
        if (this.aAS != null) {
            this.aAR.a(this.aAS, axVar);
            return;
        }
        for (bg bgVar : this.aAT) {
            axVar.cd(bgVar.tag);
            axVar.f(bgVar.aAW);
        }
    }

    public final /* synthetic */ Object clone() {
        return lt();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.aAS != null && bbVar.aAS != null) {
            return this.aAR == bbVar.aAR ? !this.aAR.aAL.isArray() ? this.aAS.equals(bbVar.aAS) : this.aAS instanceof byte[] ? Arrays.equals((byte[]) this.aAS, (byte[]) bbVar.aAS) : this.aAS instanceof int[] ? Arrays.equals((int[]) this.aAS, (int[]) bbVar.aAS) : this.aAS instanceof long[] ? Arrays.equals((long[]) this.aAS, (long[]) bbVar.aAS) : this.aAS instanceof float[] ? Arrays.equals((float[]) this.aAS, (float[]) bbVar.aAS) : this.aAS instanceof double[] ? Arrays.equals((double[]) this.aAS, (double[]) bbVar.aAS) : this.aAS instanceof boolean[] ? Arrays.equals((boolean[]) this.aAS, (boolean[]) bbVar.aAS) : Arrays.deepEquals((Object[]) this.aAS, (Object[]) bbVar.aAS) : false;
        } else {
            if (this.aAT != null && bbVar.aAT != null) {
                return this.aAT.equals(bbVar.aAT);
            }
            try {
                return Arrays.equals(toByteArray(), bbVar.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final int kF() {
        if (this.aAS != null) {
            return this.aAR.ad(this.aAS);
        }
        int i = 0;
        for (bg bgVar : this.aAT) {
            i = (bgVar.aAW.length + (ax.ce(bgVar.tag) + 0)) + i;
        }
        return i;
    }

    public final bb lt() {
        int i = 0;
        bb bbVar = new bb();
        try {
            bbVar.aAR = this.aAR;
            if (this.aAT == null) {
                bbVar.aAT = null;
            } else {
                bbVar.aAT.addAll(this.aAT);
            }
            if (this.aAS != null) {
                if (this.aAS instanceof be) {
                    bbVar.aAS = ((be) this.aAS).lr();
                } else if (this.aAS instanceof byte[]) {
                    bbVar.aAS = ((byte[]) this.aAS).clone();
                } else if (this.aAS instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.aAS;
                    Object obj = new byte[bArr.length][];
                    bbVar.aAS = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.aAS instanceof boolean[]) {
                    bbVar.aAS = ((boolean[]) this.aAS).clone();
                } else if (this.aAS instanceof int[]) {
                    bbVar.aAS = ((int[]) this.aAS).clone();
                } else if (this.aAS instanceof long[]) {
                    bbVar.aAS = ((long[]) this.aAS).clone();
                } else if (this.aAS instanceof float[]) {
                    bbVar.aAS = ((float[]) this.aAS).clone();
                } else if (this.aAS instanceof double[]) {
                    bbVar.aAS = ((double[]) this.aAS).clone();
                } else if (this.aAS instanceof be[]) {
                    be[] beVarArr = (be[]) this.aAS;
                    Object obj2 = new be[beVarArr.length];
                    bbVar.aAS = obj2;
                    while (i < beVarArr.length) {
                        obj2[i] = beVarArr[i].lr();
                        i++;
                    }
                }
            }
            return bbVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
