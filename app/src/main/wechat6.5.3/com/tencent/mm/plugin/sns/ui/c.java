package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public abstract class c<T> {
    private ac handler;
    List<Integer> jDg;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ c jDi;
        final /* synthetic */ boolean jDk;

        AnonymousClass3(c cVar, boolean z) {
            this.jDi = cVar;
            this.jDk = z;
        }

        public final void run() {
            if (this.jDk) {
                c cVar = this.jDi;
                if (cVar.jDg.size() > 1) {
                    cVar.jDg.remove(0);
                }
            }
        }
    }

    public abstract List<T> aVk();

    public abstract void bu(List<T> list);

    public c() {
        this.handler = null;
        this.jDg = new LinkedList();
        this.handler = ad.aqz();
        this.jDg.clear();
    }

    protected final void gn(final boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            boolean z2;
            for (Integer intValue : this.jDg) {
                if (intValue.intValue() == 1) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                v.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            v.d("MicroMsg.AdapterLoader", "thread load" + this.jDg.size());
        } else {
            v.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.jDg.size() <= 1) {
            this.jDg.add(Integer.valueOf(i));
            if (z) {
                ad.aSo().post(new Runnable(this) {
                    final /* synthetic */ c jDi;

                    public final void run() {
                        this.jDi.b(true, this.jDi.aVk());
                    }
                });
            } else {
                b(true, aVk());
            }
        }
    }

    final void b(boolean z, final List<T> list) {
        this.handler.post(new Runnable(this, true) {
            final /* synthetic */ c jDi;

            public final void run() {
                this.jDi.bu(list);
                ad.aSo().post(new AnonymousClass3(this.jDi, true));
            }
        });
    }
}
