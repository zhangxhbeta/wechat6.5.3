package android.support.v4.e;

import java.util.Map;

public class i<K, V> {
    static Object[] vP;
    static int vQ;
    static Object[] vR;
    static int vS;
    int hO;
    int[] vT;
    Object[] vU;

    private int indexOf(Object obj, int i) {
        int i2 = this.hO;
        if (i2 == 0) {
            return -1;
        }
        int a = b.a(this.vT, i2, i);
        if (a < 0 || obj.equals(this.vU[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.vT[i3] == i) {
            if (obj.equals(this.vU[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.vT[a] == i) {
            if (obj.equals(this.vU[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int bK() {
        int i = this.hO;
        if (i == 0) {
            return -1;
        }
        int a = b.a(this.vT, i, 0);
        if (a < 0 || this.vU[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.vT[i2] == 0) {
            if (this.vU[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.vT[a] == 0) {
            if (this.vU[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void U(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (vR != null) {
                    objArr = vR;
                    this.vU = objArr;
                    vR = (Object[]) objArr[0];
                    this.vT = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    vS--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (vP != null) {
                    objArr = vP;
                    this.vU = objArr;
                    vP = (Object[]) objArr[0];
                    this.vT = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    vQ--;
                    return;
                }
            }
        }
        this.vT = new int[i];
        this.vU = new Object[(i << 1)];
    }

    static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (vS < 10) {
                    objArr[0] = vR;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    vR = objArr;
                    vS++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (vQ < 10) {
                    objArr[0] = vP;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    vP = objArr;
                    vQ++;
                }
            }
        }
    }

    public i() {
        this.vT = b.vx;
        this.vU = b.vz;
        this.hO = 0;
    }

    public i(int i) {
        if (i == 0) {
            this.vT = b.vx;
            this.vU = b.vz;
        } else {
            U(i);
        }
        this.hO = 0;
    }

    public void clear() {
        if (this.hO != 0) {
            a(this.vT, this.vU, this.hO);
            this.vT = b.vx;
            this.vU = b.vz;
            this.hO = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? bK() : indexOf(obj, obj.hashCode());
    }

    final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.hO * 2;
        Object[] objArr = this.vU;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.vU[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.vU[i << 1];
    }

    public final V valueAt(int i) {
        return this.vU[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.vU[i2];
        this.vU[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.hO <= 0;
    }

    public V put(K k, V v) {
        int bK;
        int i;
        int i2 = 8;
        if (k == null) {
            bK = bK();
            i = 0;
        } else {
            i = k.hashCode();
            bK = indexOf(k, i);
        }
        if (bK >= 0) {
            int i3 = (bK << 1) + 1;
            V v2 = this.vU[i3];
            this.vU[i3] = v;
            return v2;
        }
        bK ^= -1;
        if (this.hO >= this.vT.length) {
            if (this.hO >= 8) {
                i2 = this.hO + (this.hO >> 1);
            } else if (this.hO < 4) {
                i2 = 4;
            }
            Object obj = this.vT;
            Object obj2 = this.vU;
            U(i2);
            if (this.vT.length > 0) {
                System.arraycopy(obj, 0, this.vT, 0, obj.length);
                System.arraycopy(obj2, 0, this.vU, 0, obj2.length);
            }
            a(obj, obj2, this.hO);
        }
        if (bK < this.hO) {
            System.arraycopy(this.vT, bK, this.vT, bK + 1, this.hO - bK);
            System.arraycopy(this.vU, bK << 1, this.vU, (bK + 1) << 1, (this.hO - bK) << 1);
        }
        this.vT[bK] = i;
        this.vU[bK << 1] = k;
        this.vU[(bK << 1) + 1] = v;
        this.hO++;
        return null;
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2 = 8;
        V v = this.vU[(i << 1) + 1];
        if (this.hO <= 1) {
            a(this.vT, this.vU, this.hO);
            this.vT = b.vx;
            this.vU = b.vz;
            this.hO = 0;
        } else if (this.vT.length <= 8 || this.hO >= this.vT.length / 3) {
            this.hO--;
            if (i < this.hO) {
                System.arraycopy(this.vT, i + 1, this.vT, i, this.hO - i);
                System.arraycopy(this.vU, (i + 1) << 1, this.vU, i << 1, (this.hO - i) << 1);
            }
            this.vU[this.hO << 1] = null;
            this.vU[(this.hO << 1) + 1] = null;
        } else {
            if (this.hO > 8) {
                i2 = this.hO + (this.hO >> 1);
            }
            Object obj = this.vT;
            Object obj2 = this.vU;
            U(i2);
            this.hO--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.vT, 0, i);
                System.arraycopy(obj2, 0, this.vU, 0, i << 1);
            }
            if (i < this.hO) {
                System.arraycopy(obj, i + 1, this.vT, i, this.hO - i);
                System.arraycopy(obj2, (i + 1) << 1, this.vU, i << 1, (this.hO - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.hO;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.hO) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.vT;
        Object[] objArr = this.vU;
        int i = this.hO;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hO * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hO; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            i keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
