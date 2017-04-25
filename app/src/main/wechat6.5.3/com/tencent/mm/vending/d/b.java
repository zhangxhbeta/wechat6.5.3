package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> phc;

    public static final class a<T> {
        private ArrayList<T> phd = new ArrayList();

        private void bof() {
            if (this.phd == null) {
                throw new IllegalAccessError();
            }
        }

        public final a<T> q(T... tArr) {
            bof();
            for (int i = 0; i <= 0; i++) {
                this.phd.add(tArr[0]);
            }
            return this;
        }

        public final b<T> bKH() {
            bof();
            List list = this.phd;
            this.phd = null;
            return new b(list);
        }
    }

    private b(List list) {
        this.phc = list;
    }

    public final int size() {
        return this.phc.size();
    }

    public final T get(int i) {
        return this.phc.get(i);
    }
}
