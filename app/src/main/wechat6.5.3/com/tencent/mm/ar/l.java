package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.eq;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.d;
import java.util.HashMap;
import java.util.List;

public class l implements ag {
    private static HashMap<Integer, c> bXq;
    public static int[] ded = new int[1000];
    public static int dee = 0;
    private final int aRF = 0;
    private n ddV = new n();
    private g ddW;
    private c ddX;
    private d ddY = new d();
    private i ddZ;
    private k dea;
    private final long deb = 259200000;
    private final int dec = 2;
    private com.tencent.mm.sdk.c.c def = new com.tencent.mm.sdk.c.c<eq>(this) {
        final /* synthetic */ l deg;

        {
            this.deg = r2;
            this.nhz = eq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            eq eqVar = (eq) bVar;
            int i = eqVar.bdl.bdn;
            String str = eqVar.bdl.bdo;
            int i2 = eqVar.bdl.state;
            if (i == 1) {
                c KD = l.KD();
                b bVar2 = new b();
                bVar2.field_state = -1;
                Cursor rawQuery = KD.cie.rawQuery(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", g.dM(str)}), null);
                if (rawQuery.getCount() != 0) {
                    rawQuery.moveToFirst();
                    bVar2.b(rawQuery);
                }
                rawQuery.close();
                i2 = bVar2.field_state;
            } else if (i == 0) {
                if (i2 == 2) {
                    l.KD().A(str, 2);
                } else if (i2 == 1) {
                    l.KD().A(str, 1);
                } else {
                    l.KD().A(str, 0);
                }
            }
            eqVar.bdm.state = i2;
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
        bXq.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return k.cic;
            }
        });
        bXq.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return m.cic;
            }
        });
        bXq.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return g.cic;
            }
        });
        bXq.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return c.cic;
            }
        });
    }

    private static l KB() {
        l lVar = (l) ak.yP().fY(l.class.getName());
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        ak.yP().a(l.class.getName(), lVar2);
        return lVar2;
    }

    public static g KC() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (KB().ddW == null) {
            l KB = KB();
            ak.yW();
            KB.ddW = new g(com.tencent.mm.model.c.wE());
            KB().ddW.a(KD(), ak.vA().htb.getLooper());
        }
        return KB().ddW;
    }

    public static c KD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (KB().ddX == null) {
            l KB = KB();
            ak.yW();
            KB.ddX = new c(com.tencent.mm.model.c.wE());
        }
        return KB().ddX;
    }

    public static i KE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (KB().ddZ == null) {
            l KB = KB();
            ak.yW();
            KB.ddZ = new i(com.tencent.mm.model.c.wE());
        }
        return KB().ddZ;
    }

    public static k KF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (KB().dea == null) {
            l KB = KB();
            ak.yW();
            KB.dea = new k(com.tencent.mm.model.c.wE());
        }
        return KB().dea;
    }

    public final void th() {
        d.c.aw(Integer.valueOf(37));
        d.c.aw(Integer.valueOf(40));
        a.nhr.f(this.def);
        ak.oH().qs();
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(37), this.ddV);
        d.c.a(Integer.valueOf(40), this.ddY);
        a.nhr.e(this.def);
        int Kr = KD().Kr();
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        if (currentTimeMillis - be.a((Long) com.tencent.mm.model.c.vf().get(340225, null), 0) > 259200000 && Kr > 0) {
            List Ks = KD().Ks();
            int size = Ks.size();
            String str = (String) Ks.get(0);
            Kr = 1;
            while (Kr < size) {
                String str2 = str + ", " + ((String) Ks.get(Kr));
                Kr++;
                str = str2;
            }
            b ivVar = new iv();
            ivVar.bjm.userName = null;
            ivVar.bjm.aGX = str;
            ivVar.bjm.type = 0;
            a.nhr.z(ivVar);
            ak.yW();
            com.tencent.mm.model.c.vf().set(340225, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void aH(boolean z) {
    }
}
