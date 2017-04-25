package android.support.v4.e;

public final class e<E> implements Cloneable {
    public static final Object vB = new Object();
    public int hO;
    public boolean vC;
    public long[] vD;
    public Object[] vE;

    public final /* synthetic */ Object clone() {
        return bI();
    }

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.vC = false;
        int R = b.R(10);
        this.vD = new long[R];
        this.vE = new Object[R];
        this.hO = 0;
    }

    private e<E> bI() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.vD = (long[]) this.vD.clone();
                eVar.vE = (Object[]) this.vE.clone();
                return eVar;
            } catch (CloneNotSupportedException e) {
                return eVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(long j) {
        int a = b.a(this.vD, this.hO, j);
        return (a < 0 || this.vE[a] == vB) ? null : this.vE[a];
    }

    private void gc() {
        int i = this.hO;
        long[] jArr = this.vD;
        Object[] objArr = this.vE;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != vB) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.vC = false;
        this.hO = i2;
    }

    public final void put(long j, E e) {
        int a = b.a(this.vD, this.hO, j);
        if (a >= 0) {
            this.vE[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hO || this.vE[a] != vB) {
            if (this.vC && this.hO >= this.vD.length) {
                gc();
                a = b.a(this.vD, this.hO, j) ^ -1;
            }
            if (this.hO >= this.vD.length) {
                int R = b.R(this.hO + 1);
                Object obj = new long[R];
                Object obj2 = new Object[R];
                System.arraycopy(this.vD, 0, obj, 0, this.vD.length);
                System.arraycopy(this.vE, 0, obj2, 0, this.vE.length);
                this.vD = obj;
                this.vE = obj2;
            }
            if (this.hO - a != 0) {
                System.arraycopy(this.vD, a, this.vD, a + 1, this.hO - a);
                System.arraycopy(this.vE, a, this.vE, a + 1, this.hO - a);
            }
            this.vD[a] = j;
            this.vE[a] = e;
            this.hO++;
            return;
        }
        this.vD[a] = j;
        this.vE[a] = e;
    }

    public final int size() {
        if (this.vC) {
            gc();
        }
        return this.hO;
    }

    private long keyAt(int i) {
        if (this.vC) {
            gc();
        }
        return this.vD[i];
    }

    public final E valueAt(int i) {
        if (this.vC) {
            gc();
        }
        return this.vE[i];
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hO * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hO; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            e valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
