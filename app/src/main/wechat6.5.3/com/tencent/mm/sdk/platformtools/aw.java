package com.tencent.mm.sdk.platformtools;

public class aw<T> {
    public Object[] vN = new Object[20];
    public int vO;

    public aw(int i) {
    }

    public T bJ() {
        if (this.vN == null || this.vO <= 0) {
            return null;
        }
        int i = this.vO - 1;
        T t = this.vN[i];
        this.vN[i] = null;
        this.vO--;
        return t;
    }

    public boolean i(T t) {
        if (this.vN == null) {
            return false;
        }
        int i;
        if (this.vN != null) {
            for (i = 0; i < this.vO; i++) {
                if (this.vN[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            return false;
        }
        if (this.vO >= this.vN.length || this.vO < 0) {
            v.e("MicroMsg.SimpleObjectPool", "error index %d %d", Integer.valueOf(this.vO), Integer.valueOf(this.vN.length));
            return false;
        }
        this.vN[this.vO] = t;
        this.vO++;
        return true;
    }
}
