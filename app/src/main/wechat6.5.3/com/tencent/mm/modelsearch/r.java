package com.tencent.mm.modelsearch;

import com.tencent.mm.modelsearch.p.l;

public interface r {

    public static abstract class a extends l implements Comparable<a> {
        public boolean ik = false;
        public int mPriority = Integer.MAX_VALUE;

        public abstract boolean execute();

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.mPriority - ((a) obj).mPriority;
        }

        public int getId() {
            return -1;
        }
    }

    boolean Iz();

    a a(int i, a aVar);

    void a(a aVar);

    void start();
}
