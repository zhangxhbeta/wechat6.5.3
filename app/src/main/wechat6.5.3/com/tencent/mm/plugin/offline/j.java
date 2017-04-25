package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.qn;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.n.d;
import com.tencent.mm.plugin.offline.a.n.e;
import com.tencent.mm.plugin.offline.a.n.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.d.a;
import java.util.HashMap;
import java.util.Map;

public final class j implements ag {
    private static Map<String, String> hKi = new HashMap();
    private b eWu = new b(this) {
        final /* synthetic */ j hKj;

        {
            this.hKj = r1;
        }

        public final void a(final a aVar) {
            final String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + a);
            this.hKj.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hKk;

                public final void run() {
                    n aEN = j.aEN();
                    String str = a;
                    long j = aVar.czu.mcb;
                    if (!TextUtils.isEmpty(str)) {
                        boolean z;
                        if (aEN.hIJ == null || aEN.hIJ.size() == 0) {
                            v.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
                        } else {
                            for (int i = 0; i < aEN.hIJ.size(); i++) {
                                if (((Long) aEN.hIJ.get(i)).longValue() == j) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            v.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + j);
                            return;
                        }
                        v.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + j);
                        v.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str);
                        Map q = bf.q(str, "sysmsg");
                        if (q != null) {
                            int i2 = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                            v.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + i2);
                            v.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[]{Integer.valueOf(i2), str});
                            if (i2 >= 0 && i2 == 4) {
                                aEN.b(aEN.v(q));
                                com.tencent.mm.plugin.offline.b.a.xq(str);
                            } else if (i2 >= 0 && i2 == 5) {
                                r3 = new d(aEN);
                                r3.hLc = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                                r3.hLd = (String) q.get(".sysmsg.paymsg.cftretcode");
                                r3.hLe = (String) q.get(".sysmsg.paymsg.cftretmsg");
                                r3.hLf = (String) q.get(".sysmsg.paymsg.wxretcode");
                                r3.hLg = (String) q.get(".sysmsg.paymsg.wxretmsg");
                                r3.hLh = (String) q.get(".sysmsg.paymsg.error_detail_url");
                                aEN.b(r3);
                            } else if (i2 >= 0 && i2 == 6) {
                                if (!be.kS((String) q.get(".sysmsg.paymsg.transid"))) {
                                    ak.yW();
                                    c.vf().a(t.a.ntq, Boolean.valueOf(true));
                                }
                                r3 = new e(aEN);
                                r3.hLc = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                                r3.hLi = (String) q.get(".sysmsg.paymsg.transid");
                                r3.hLj = com.tencent.mm.plugin.offline.b.a.w(q);
                                aEN.b(r3);
                            } else if (i2 >= 0 && i2 == 7) {
                                k.bga().amB();
                            } else if (i2 >= 0 && i2 == 8) {
                                n.c fVar = new f(aEN);
                                fVar.hLc = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                                fVar.hLk = (String) q.get(".sysmsg.paymsg.good_name");
                                fVar.hLl = (String) q.get(".sysmsg.paymsg.total_fee");
                                fVar.id = (String) q.get(".sysmsg.paymsg.id");
                                String str2 = (String) q.get(".sysmsg.paymsg.confirm_type");
                                v.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + fVar.hLm);
                                if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
                                    fVar.hLm = 0;
                                } else {
                                    fVar.hLm = 1;
                                }
                                aEN.b(fVar);
                            } else if (i2 >= 0 && i2 == 10) {
                                j.aEM();
                                j.aEP().nL(4);
                            } else if (i2 >= 0 && i2 == 20) {
                                qn qnVar = new qn();
                                qnVar.bsb.bsc = q;
                                com.tencent.mm.sdk.c.a.nhr.z(qnVar);
                            }
                        }
                        if (aEN.hIJ.size() > 10) {
                            aEN.hIJ.remove(aEN.hIJ.size() - 1);
                        }
                        aEN.hIJ.add(0, Long.valueOf(j));
                    }
                }
            });
        }
    };
    private n hKc = null;
    private e hKd = null;
    private h hKe = null;
    private com.tencent.mm.plugin.offline.ui.d hKf = new com.tencent.mm.plugin.offline.ui.d();
    public f hKg = new f();
    private l hKh;
    private ac mHandler = new ac(Looper.getMainLooper());

    static {
        com.tencent.mm.wallet_core.a.b("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.b("OfflineBindCardProcess", c.class);
    }

    public static j aEM() {
        j jVar = (j) ak.yP().fY("plugin.offline");
        if (jVar != null) {
            return jVar;
        }
        v.e("MicroMsg.SubCoreOffline", "not found in MMCore, new one");
        jVar = new j();
        ak.yP().a("plugin.offline", jVar);
        return jVar;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        ak.yU().a("paymsg", this.eWu, true);
        com.tencent.mm.sdk.c.a.nhr.e(this.hKf);
        this.hKc = null;
        this.hKd = null;
        this.hKe = null;
        this.hKh = new l();
    }

    public final void th() {
        ak.yU().b("paymsg", this.eWu, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.hKf);
        if (this.hKh != null) {
            n.a aVar = this.hKh;
            aEM();
            aEN().b(aVar);
            com.tencent.mm.sdk.c.a.nhr.f(aVar.hcA);
        }
        this.hKh = null;
    }

    public static n aEN() {
        ak.yW();
        if (c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aEM().hKc == null) {
            aEM().hKc = new n();
        }
        return aEM().hKc;
    }

    public static e aEO() {
        ak.yW();
        if (c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aEM().hKd == null) {
            aEM().hKd = new e();
        }
        return aEM().hKd;
    }

    public static h aEP() {
        ak.yW();
        if (c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aEM().hKe == null) {
            aEM().hKe = new h();
        }
        return aEM().hKe;
    }

    public static void T(int i, String str) {
        if (str != null) {
            ak.yW();
            c.vf().set(i, str);
            ak.yW();
            c.vf().iB(true);
        }
    }

    public static String nO(int i) {
        ak.yW();
        return (String) c.vf().get(i, null);
    }
}
