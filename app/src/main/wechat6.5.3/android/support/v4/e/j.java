package android.support.v4.e;

public final class j<E> implements Cloneable {
    private static final Object vB = new Object();
    private int hO;
    private boolean vC;
    private Object[] vE;
    private int[] vV;

    public final /* synthetic */ Object clone() {
        return bL();
    }

    public j() {
        this(10);
    }

    public j(int i) {
        this.vC = false;
        if (i == 0) {
            this.vV = b.vx;
            this.vE = b.vz;
        } else {
            int Q = b.Q(i);
            this.vV = new int[Q];
            this.vE = new Object[Q];
        }
        this.hO = 0;
    }

    private j<E> bL() {
        try {
            j<E> jVar = (j) super.clone();
            try {
                jVar.vV = (int[]) this.vV.clone();
                jVar.vE = (Object[]) this.vE.clone();
                return jVar;
            } catch (CloneNotSupportedException e) {
                return jVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E get(int i) {
        int a = b.a(this.vV, this.hO, i);
        return (a < 0 || this.vE[a] == vB) ? null : this.vE[a];
    }

    public final void remove(int i) {
        int a = b.a(this.vV, this.hO, i);
        if (a >= 0 && this.vE[a] != vB) {
            this.vE[a] = vB;
            this.vC = true;
        }
    }

    public final void removeAt(int i) {
        if (this.vE[i] != vB) {
            this.vE[i] = vB;
            this.vC = true;
        }
    }

    private void gc() {
        int i = this.hO;
        int[] iArr = this.vV;
        Object[] objArr = this.vE;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != vB) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.vC = false;
        this.hO = i2;
    }

    public final void put(int i, E e) {
        int a = b.a(this.vV, this.hO, i);
        if (a >= 0) {
            this.vE[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.hO || this.vE[a] != vB) {
            if (this.vC && this.hO >= this.vV.length) {
                gc();
                a = b.a(this.vV, this.hO, i) ^ -1;
            }
            if (this.hO >= this.vV.length) {
                int Q = b.Q(this.hO + 1);
                Object obj = new int[Q];
                Object obj2 = new Object[Q];
                System.arraycopy(this.vV, 0, obj, 0, this.vV.length);
                System.arraycopy(this.vE, 0, obj2, 0, this.vE.length);
                this.vV = obj;
                this.vE = obj2;
            }
            if (this.hO - a != 0) {
                System.arraycopy(this.vV, a, this.vV, a + 1, this.hO - a);
                System.arraycopy(this.vE, a, this.vE, a + 1, this.hO - a);
            }
            this.vV[a] = i;
            this.vE[a] = e;
            this.hO++;
            return;
        }
        this.vV[a] = i;
        this.vE[a] = e;
    }

    public final int size() {
        if (this.vC) {
            gc();
        }
        return this.hO;
    }

    public final int keyAt(int i) {
        if (this.vC) {
            gc();
        }
        return this.vV[i];
    }

    public final E valueAt(int i) {
        if (this.vC) {
            gc();
        }
        return this.vE[i];
    }

    public final int indexOfKey(int i) {
        if (this.vC) {
            gc();
        }
        return b.a(this.vV, this.hO, i);
    }

    public final void clear() {
        int i = this.hO;
        Object[] objArr = this.vE;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.hO = 0;
        this.vC = false;
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
            j valueAt = valueAt(i);
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
