package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.v.d.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class v {
    private static v kQt = null;
    static ArrayList<g> kQu = null;
    b eWu = new b(this) {
        final /* synthetic */ v kQv;

        {
            this.kQv = r1;
        }

        public final void a(a aVar) {
            String a = m.a(aVar.czu.mbW);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletPushNotifyManager", "PayMsg:" + a);
            Map q = bf.q(a, "sysmsg");
            int i = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            if (!v.a(this.kQv, i, q)) {
                ad.o(new Runnable(i, q) {
                    public final void run() {
                        if (v.kQu != null) {
                            Iterator it = v.kQu.iterator();
                            while (it.hasNext()) {
                                g gVar = (g) it.next();
                                if (gVar != null) {
                                    gVar.mO(r1);
                                }
                            }
                        }
                    }
                });
            }
        }
    };

    static /* synthetic */ boolean a(v vVar, int i, Map map) {
        if (map == null) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            return true;
        } else if (i < 0) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            return true;
        } else if (i != 12) {
            return false;
        } else {
            final int i2 = be.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            final long j = be.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            final long j2 = be.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200);
            final int i3 = i;
            final Map map2 = map;
            e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a(vVar) {
                final /* synthetic */ v kQv;

                public final void B(Map<String, Object> map) {
                    if (map != null) {
                        long a = be.a((Long) map.get("wallet_balance_version"), -1);
                        long a2 = be.a((Long) map.get("wallet_balance_last_update_time"), -1);
                        if (a2 < 0 || a < 0 || a2 + j2 > be.Nj() || j >= a) {
                            e.a(new c("wallet_balance_version", Long.valueOf(j)), new c("wallet_balance_last_update_time", Long.valueOf(be.Nj())), new c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                            ad.o(/* anonymous class already generated */);
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                    }
                }
            });
            return true;
        }
    }

    private v() {
    }

    public static v bgk() {
        if (kQt == null) {
            kQt = new v();
        }
        return kQt;
    }

    public static boolean a(g gVar) {
        if (gVar == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
            return false;
        }
        if (kQu == null) {
            kQu = new ArrayList();
        }
        kQu.add(gVar);
        return true;
    }

    public static boolean b(g gVar) {
        if (kQu == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            return false;
        }
        kQu.remove(gVar);
        return true;
    }
}
