package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class h<T> extends a<T> {
    private boolean ank = false;
    private ArrayList<Integer> anl;

    public h(DataHolder dataHolder) {
        super(dataHolder);
    }

    private int bM(int i) {
        if (i >= 0 && i < this.anl.size()) {
            return ((Integer) this.anl.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    private void jJ() {
        synchronized (this) {
            if (!this.ank) {
                int i = this.amM.amX;
                this.anl = new ArrayList();
                if (i > 0) {
                    this.anl.add(Integer.valueOf(0));
                    String jI = jI();
                    String b = this.amM.b(jI, 0, this.amM.bL(0));
                    int i2 = 1;
                    while (i2 < i) {
                        int bL = this.amM.bL(i2);
                        String b2 = this.amM.b(jI, i2, bL);
                        if (b2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + jI + ", at row: " + i2 + ", for window: " + bL);
                        }
                        if (b2.equals(b)) {
                            b2 = b;
                        } else {
                            this.anl.add(Integer.valueOf(i2));
                        }
                        i2++;
                        b = b2;
                    }
                }
                this.ank = true;
            }
        }
    }

    public abstract T ad(int i, int i2);

    public final T get(int i) {
        int i2;
        jJ();
        int bM = bM(i);
        if (i < 0 || i == this.anl.size()) {
            i2 = 0;
        } else {
            i2 = i == this.anl.size() + -1 ? this.amM.amX - ((Integer) this.anl.get(i)).intValue() : ((Integer) this.anl.get(i + 1)).intValue() - ((Integer) this.anl.get(i)).intValue();
            if (i2 == 1) {
                this.amM.bL(bM(i));
            }
        }
        return ad(bM, i2);
    }

    public final int getCount() {
        jJ();
        return this.anl.size();
    }

    public abstract String jI();
}
