package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.pluginsdk.j.y;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<y> bXt = new LinkedList();
    ac handler = new ac(Looper.getMainLooper());

    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String gTn;
        final /* synthetic */ String gTo;
        final /* synthetic */ i kll;

        AnonymousClass10(i iVar, String str, String str2) {
            this.kll = iVar;
            this.gTn = str;
            this.gTo = str2;
        }

        public final void run() {
            synchronized (this.kll.bXt) {
                for (y bZ : this.kll.bXt) {
                    bZ.bZ(this.gTn, this.gTo);
                }
            }
        }
    }

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String kjF;
        final /* synthetic */ i kll;

        AnonymousClass11(i iVar, String str) {
            this.kll = iVar;
            this.kjF = str;
        }

        public final void run() {
            synchronized (this.kll.bXt) {
                Iterator it = this.kll.bXt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public final void awP() {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ i kll;

            {
                this.kll = r1;
            }

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (y awP : this.kll.bXt) {
                        awP.awP();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass1.run();
        } else {
            this.handler.post(anonymousClass1);
        }
    }

    public final void A(final String str, final int i, final int i2) {
        Runnable anonymousClass5 = new Runnable(this) {
            final /* synthetic */ i kll;

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (y A : this.kll.bXt) {
                        A.A(str, i, i2);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
        } else {
            this.handler.post(anonymousClass5);
        }
    }

    public final void mq(final int i) {
        Runnable anonymousClass7 = new Runnable(this) {
            final /* synthetic */ i kll;

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (y mq : this.kll.bXt) {
                        mq.mq(i);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass7.run();
        } else {
            this.handler.post(anonymousClass7);
        }
    }

    public final void vT(final String str) {
        Runnable anonymousClass8 = new Runnable(this) {
            final /* synthetic */ i kll;

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (y vT : this.kll.bXt) {
                        vT.vT(str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass8.run();
        } else {
            this.handler.post(anonymousClass8);
        }
    }

    public final void g(final int i, final int i2, final String str) {
        Runnable anonymousClass9 = new Runnable(this) {
            final /* synthetic */ i kll;

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (y g : this.kll.bXt) {
                        g.g(i, i2, str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass9.run();
        } else {
            this.handler.post(anonymousClass9);
        }
    }
}
