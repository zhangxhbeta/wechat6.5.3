package com.tencent.mm.plugin.notification.c;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends a<at> {
    private com.tencent.mm.sdk.c.c hIP = new com.tencent.mm.sdk.c.c<ms>(this) {
        final /* synthetic */ c hIR;

        {
            this.hIR = r2;
            this.nhz = ms.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ms msVar = (ms) bVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hIT;

                public final void run() {
                    at atVar = msVar.boc.aXd;
                    if (c.xo(atVar.field_talker)) {
                        this.hIT.hIR.aO(atVar);
                    }
                }
            });
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hIQ = new com.tencent.mm.sdk.c.c<mu>(this) {
        final /* synthetic */ c hIR;

        {
            this.hIR = r2;
            this.nhz = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final mu muVar = (mu) bVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hIV;

                public final void run() {
                    at atVar = muVar.boe.aXd;
                    if (c.xo(atVar.field_talker)) {
                        this.hIV.hIR.aP(atVar);
                    }
                }
            });
            return false;
        }
    };

    static /* synthetic */ boolean xo(String str) {
        return !(u.LH(str) || u.LJ(str)) || u.ew(str);
    }

    protected final /* bridge */ /* synthetic */ long aQ(Object obj) {
        return ((at) obj).field_msgId;
    }

    protected final /* synthetic */ ArrayList aR(Object obj) {
        return e.G((at) obj);
    }

    public final void aEt() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hIP);
    }

    public final void aEu() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hIQ);
    }

    public final void cn(final long j) {
        ak.yW();
        final at ek = com.tencent.mm.model.c.wJ().ek(j);
        ad.o(new Runnable(this) {
            final /* synthetic */ c hIR;

            public final void run() {
                v.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[]{Long.valueOf(j)});
                lp lpVar = new lp();
                lpVar.bmS.aXd = ek;
                com.tencent.mm.sdk.c.a.nhr.z(lpVar);
            }
        });
    }

    public final void aEv() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hIP);
    }

    public final void aEw() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hIQ);
    }

    protected final void aEo() {
        v.d("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size())});
        if (this.hIy.hIJ.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            v.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.ay.c.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        } else if (this.hIy.hIJ.size() == 1) {
            long j = this.hIy.get(0);
            ak.yW();
            String str = com.tencent.mm.model.c.wJ().ek(j).field_talker;
            Intent intent2 = new Intent();
            intent2.putExtra("Main_User", str);
            intent2.putExtra("From_fail_notify", true);
            intent2.addFlags(67108864);
            intent2.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent2.putExtra("resend_fail_messages", true);
            }
            com.tencent.mm.ay.c.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
        }
    }

    protected final int getType() {
        return 1;
    }

    protected final void K(ArrayList<Long> arrayList) {
        ak.yW();
        au wJ = com.tencent.mm.model.c.wJ();
        long auU = wJ.cuX.auU();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                at ek = wJ.ek(longValue);
                ek.ds(ek.bNn | 32);
                v.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[]{Long.valueOf(longValue)});
                wJ.a(longValue, ek);
            }
        } finally {
            wJ.cuX.es(auU);
        }
    }

    protected final String nG(int i) {
        return this.mContext.getString(2131234067, new Object[]{Integer.valueOf(i)});
    }

    protected final String ca(int i, int i2) {
        return this.mContext.getString(2131234099, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String H(int i, int i2, int i3) {
        return this.mContext.getString(2131234100, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String cb(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(2131234097, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(2131234096, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean co(long j) {
        ak.yW();
        v.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(com.tencent.mm.model.c.wJ().ek(j).field_msgId)});
        if (com.tencent.mm.model.c.wJ().ek(j).field_msgId != 0) {
            return true;
        }
        return false;
    }
}
