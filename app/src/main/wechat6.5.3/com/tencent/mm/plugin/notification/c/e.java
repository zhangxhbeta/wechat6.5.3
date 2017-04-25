package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.bo;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.jd;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.h.i;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.b.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class e implements ag {
    private static e hJd = null;
    c hJe = null;
    c hJf = null;
    private a hJg = null;
    private boolean hJh = false;
    private com.tencent.mm.sdk.c.c hJi = new com.tencent.mm.sdk.c.c<ln>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = ln.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hJo.hJe.aEf();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hJj = new com.tencent.mm.sdk.c.c<lo>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = lo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hJo.hJf.aEf();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hJk = new com.tencent.mm.sdk.c.c<jc>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hJo.hJe.aEi();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hJl = new com.tencent.mm.sdk.c.c<jd>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = jd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hJo.hJf.aEi();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hJm = new com.tencent.mm.sdk.c.c<bo>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = bo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hJo.hJe.aEk().dismiss();
            this.hJo.hJf.aEk().dismiss();
            v.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hJn = new com.tencent.mm.sdk.c.c<ev>(this) {
        final /* synthetic */ e hJo;

        {
            this.hJo = r2;
            this.nhz = ev.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            this.hJo.hJh = ((ev) bVar).bdB.aWE;
            return false;
        }
    };

    private e() {
        a.init();
        if (this.hJf == null) {
            this.hJf = new d();
        }
        if (this.hJe == null) {
            this.hJe = new c();
        }
    }

    public static FailSendMsgNotification nJ(int i) {
        if (i == 2 && aEy().hJf != null) {
            v.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            return aEy().hJf.aEk();
        } else if (i != 1 || aEy().hJe == null) {
            return null;
        } else {
            v.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            return aEy().hJe.aEk();
        }
    }

    public static e aEy() {
        if (hJd == null) {
            hJd = new e();
            ak.yP().a("plugin.notification", hJd);
        }
        return hJd;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        this.hJe.aEt();
        this.hJe.aEu();
        this.hJf.aEt();
        this.hJf.aEu();
        if (this.hJg == null) {
            this.hJg = new a();
        }
        a aVar = this.hJg;
        if (ak.uz()) {
            v.d("MicroMsg.NotificationObserver", "added");
            try {
                ak.yW();
                com.tencent.mm.model.c.wK().a(aVar);
                aVar.hIq = true;
            } catch (Throwable e) {
                v.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{be.e(e)});
            }
        } else {
            v.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.hJi);
        com.tencent.mm.sdk.c.a.nhr.e(this.hJj);
        com.tencent.mm.sdk.c.a.nhr.e(this.hJk);
        com.tencent.mm.sdk.c.a.nhr.e(this.hJl);
        com.tencent.mm.sdk.c.a.nhr.e(this.hJm);
        com.tencent.mm.sdk.c.a.nhr.e(this.hJn);
        i.ta();
        ak.oH().dA(i.td());
        ak.oH().aq(false);
        v.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        this.hJe.aEv();
        this.hJe.aEw();
        this.hJf.aEv();
        this.hJf.aEw();
        if (this.hJg != null) {
            a aVar = this.hJg;
            if (ak.uz()) {
                try {
                    ak.yW();
                    com.tencent.mm.model.c.wK().b(aVar);
                } catch (Throwable e) {
                    v.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{be.e(e)});
                }
            }
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.hJi);
        com.tencent.mm.sdk.c.a.nhr.f(this.hJj);
        com.tencent.mm.sdk.c.a.nhr.f(this.hJk);
        com.tencent.mm.sdk.c.a.nhr.f(this.hJl);
        com.tencent.mm.sdk.c.a.nhr.f(this.hJm);
        com.tencent.mm.sdk.c.a.nhr.f(this.hJn);
        ak.oH().dA(0);
        ak.oH().aq(true);
        v.d("MicroMsg.SubCoreNotification", "onAccountRelease");
    }

    public static boolean aEz() {
        return aEy().hJh;
    }

    public static ArrayList<Long> G(at atVar) {
        if (atVar == null) {
            return null;
        }
        ak.yW();
        com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
        ArrayList bwW = ((d) com.tencent.mm.kernel.g.f(d.class)).azI().bwW();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = bwW.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((at) it.next()).field_msgId));
        }
        return arrayList;
    }
}
