package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.c.i;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> bXt = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    class AnonymousClass10 implements Runnable {
        final /* synthetic */ g pJp;
        final /* synthetic */ int pJs;

        AnonymousClass10(g gVar, int i) {
            this.pJp = gVar;
            this.pJs = i;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a zG : this.pJp.bXt) {
                    zG.zG(this.pJs);
                }
            }
        }
    }

    class AnonymousClass12 implements Runnable {
        final /* synthetic */ boolean iZH;
        final /* synthetic */ g pJp;

        AnonymousClass12(g gVar, boolean z) {
            this.pJp = gVar;
            this.iZH = z;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a ew : this.pJp.bXt) {
                    ew.ew(this.iZH);
                }
            }
        }
    }

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String pIU;
        final /* synthetic */ g pJp;
        final /* synthetic */ byte[] pJt;

        AnonymousClass13(g gVar, String str, byte[] bArr) {
            this.pJp = gVar;
            this.pIU = str;
            this.pJt = bArr;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a w : this.pJp.bXt) {
                    w.w(this.pIU, this.pJt);
                }
            }
        }
    }

    class AnonymousClass16 implements Runnable {
        final /* synthetic */ MultiTalkGroup hzB;
        final /* synthetic */ g pJp;

        AnonymousClass16(g gVar, MultiTalkGroup multiTalkGroup) {
            this.pJp = gVar;
            this.hzB = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a b : this.pJp.bXt) {
                    b.b(this.hzB);
                }
            }
        }
    }

    class AnonymousClass18 implements Runnable {
        final /* synthetic */ int aVD;
        final /* synthetic */ g pJp;

        AnonymousClass18(g gVar, int i) {
            this.pJp = gVar;
            this.aVD = i;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a zF : this.pJp.bXt) {
                    zF.zF(this.aVD);
                }
            }
        }
    }

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List pJo;
        final /* synthetic */ g pJp;

        AnonymousClass1(g gVar, List list) {
            this.pJp = gVar;
            this.pJo = list;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a aO : this.pJp.bXt) {
                    aO.aO(this.pJo);
                }
            }
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ MultiTalkGroup hzB;
        final /* synthetic */ g pJp;

        AnonymousClass4(g gVar, MultiTalkGroup multiTalkGroup) {
            this.pJp = gVar;
            this.hzB = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a p : this.pJp.bXt) {
                    p.p(this.hzB);
                }
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ MultiTalkGroup hzB;
        final /* synthetic */ g pJp;

        AnonymousClass5(g gVar, MultiTalkGroup multiTalkGroup) {
            this.pJp = gVar;
            this.hzB = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a q : this.pJp.bXt) {
                    q.q(this.hzB);
                }
            }
        }
    }

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String pIU;
        final /* synthetic */ g pJp;
        final /* synthetic */ boolean pJr;

        AnonymousClass6(g gVar, String str, boolean z) {
            this.pJp = gVar;
            this.pIU = str;
            this.pJr = z;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                List<a> arrayList = new ArrayList(this.pJp.bXt);
            }
            for (a aU : arrayList) {
                aU.aU(this.pIU, this.pJr);
            }
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ int iMy;
        final /* synthetic */ g pJp;

        AnonymousClass7(g gVar, int i) {
            this.pJp = gVar;
            this.iMy = i;
        }

        public final void run() {
            synchronized (this.pJp.bXt) {
                for (a onStateChanged : this.pJp.bXt) {
                    onStateChanged.onStateChanged(this.iMy);
                }
            }
        }
    }

    public interface a {
        void a(int i, MultiTalkGroup multiTalkGroup);

        void aO(List<aj> list);

        void aU(String str, boolean z);

        void awP();

        void b(MultiTalkGroup multiTalkGroup);

        void bPA();

        void bPB();

        void bPC();

        void cL(List<MultiTalkGroup> list);

        void ct(String str, int i);

        void d(int i, Object obj);

        void ew(boolean z);

        void g(MultiTalkGroup multiTalkGroup);

        void onStateChanged(int i);

        void p(MultiTalkGroup multiTalkGroup);

        void q(MultiTalkGroup multiTalkGroup);

        void w(String str, byte[] bArr);

        void zF(int i);

        void zG(int i);
    }

    public final void cL(final List<MultiTalkGroup> list) {
        Runnable anonymousClass15 = new Runnable(this) {
            final /* synthetic */ g pJp;

            public final void run() {
                synchronized (this.pJp.bXt) {
                    for (a cL : this.pJp.bXt) {
                        cL.cL(list);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass15.run();
        } else {
            this.handler.post(anonymousClass15);
        }
    }

    public final void a(final int i, final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass17 = new Runnable(this) {
            final /* synthetic */ g pJp;

            public final void run() {
                synchronized (this.pJp.bXt) {
                    for (a a : this.pJp.bXt) {
                        a.a(i, multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass17.run();
        } else {
            this.handler.post(anonymousClass17);
        }
    }

    public final void d(final int i, final Object obj) {
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ g pJp;

            public final void run() {
                synchronized (this.pJp.bXt) {
                    for (a d : this.pJp.bXt) {
                        d.d(i, obj);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            this.handler.post(anonymousClass2);
        }
    }

    public final void g(final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ g pJp;

            public final void run() {
                synchronized (this.pJp.bXt) {
                    for (a g : this.pJp.bXt) {
                        g.g(multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
        } else {
            this.handler.post(anonymousClass3);
        }
    }

    public final void ct(final String str, final int i) {
        i.S(new Runnable(this) {
            final /* synthetic */ g pJp;

            public final void run() {
                synchronized (this.pJp.bXt) {
                    for (a ct : this.pJp.bXt) {
                        ct.ct(str, i);
                    }
                }
            }
        });
    }
}
