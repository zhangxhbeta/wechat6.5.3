package com.tencent.mm.modelsearch;

import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.j;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public abstract class a implements o {
    private boolean cUN;
    private boolean cUO;

    public static abstract class a extends com.tencent.mm.modelsearch.r.a {
        public String bkC;
        private k cUP;
        private String[] cUQ;
        private HashSet<String> cUR;
        private int cUS;
        public int cUT;
        public Comparator<h> cUU = null;
        private ac handler;

        public abstract List<h> a(String[] strArr, HashSet<String> hashSet, int i);

        public abstract String getName();

        public a(String str, int i, HashSet<String> hashSet, k kVar, ac acVar) {
            this.bkC = str;
            this.cUP = kVar;
            this.handler = acVar;
            this.cUS = i;
            this.cUQ = d.cVE.split(str.replace('*', ' '));
            if (hashSet != null) {
                this.cUR = hashSet;
            } else {
                this.cUR = new HashSet();
            }
        }

        public final boolean execute() {
            try {
                final List a = a(this.cUQ, this.cUR, this.cUS);
                this.cUT = a.size();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                if (this.handler == null) {
                    this.cUP.a(this, a, this.cUR, this.cUQ, this.bkC);
                } else {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ a cUW;

                        public final void run() {
                            this.cUW.cUP.a(this.cUW, a, this.cUW.cUR, this.cUW.cUQ, this.cUW.bkC);
                        }
                    });
                }
                return true;
            } catch (Exception e) {
                if (!(e instanceof InterruptedException)) {
                    if (this.handler == null) {
                        this.cUP.jI(this.bkC);
                    } else {
                        this.handler.post(new Runnable(this) {
                            final /* synthetic */ a cUW;

                            {
                                this.cUW = r1;
                            }

                            public final void run() {
                                this.cUW.cUP.jI(this.cUW.bkC);
                            }
                        });
                    }
                }
                throw e;
            }
        }

        public String toString() {
            return String.format("%s[%s]: %d", new Object[]{getName(), this.bkC, Integer.valueOf(this.cUT)});
        }
    }

    public abstract boolean HX();

    public abstract boolean onCreate();

    public a() {
        v.i("MicroMsg.FTS.BaseFTSNativeLogic", "Create %s", new Object[]{getName()});
    }

    public final boolean HW() {
        return this.cUN;
    }

    public final void create() {
        v.i("MicroMsg.FTS.BaseFTSNativeLogic", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.cUN)});
        if (!this.cUN && onCreate()) {
            v.i("MicroMsg.FTS.BaseFTSNativeLogic", "SetCreated");
            this.cUN = true;
        }
    }

    public final void destroy() {
        v.i("MicroMsg.FTS.BaseFTSNativeLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.cUO), Boolean.valueOf(this.cUN)});
        if (!this.cUO && this.cUN) {
            HX();
            v.i("MicroMsg.FTS.BaseFTSNativeLogic", "SetDestroyed");
            this.cUO = true;
        }
    }

    public void a(String str, h hVar, int i) {
    }

    public com.tencent.mm.modelsearch.r.a a(j jVar) {
        return null;
    }

    public com.tencent.mm.modelsearch.r.a b(j jVar) {
        return null;
    }

    public com.tencent.mm.modelsearch.r.a c(j jVar) {
        return null;
    }

    public com.tencent.mm.modelsearch.r.a d(j jVar) {
        return null;
    }

    public com.tencent.mm.modelsearch.r.a e(j jVar) {
        return null;
    }
}
