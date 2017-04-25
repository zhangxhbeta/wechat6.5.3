package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.mm.e.a.in;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.e.a.jl;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.plugin.wear.model.f.g;
import com.tencent.mm.plugin.wear.model.f.h;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class e {
    c bZd = new c<ly>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ly lyVar = (ly) bVar;
            if ((lyVar instanceof ly) && e.a(this.lbu)) {
                ak.yW();
                ab Mh = com.tencent.mm.model.c.wK().Mh(lyVar.bnd.bmk.field_talker);
                if (Mh != null) {
                    int i = Mh.field_unReadCount;
                    f DH = a.bhH().laT.DH(lyVar.bnd.bmk.field_talker);
                    if (i - DH.lbA > 0) {
                        e.k(lyVar.bnd.bmk.field_talker, i, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(DH.id));
                        a.bhH().laX.a(new i(arrayList));
                    }
                }
            }
            return false;
        }
    };
    ah dwn = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r1;
        }

        public final boolean oU() {
            a.bhH().laX.a(new com.tencent.mm.plugin.wear.model.f.a());
            return true;
        }
    }, true);
    au.a fGy = new au.a(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r1;
        }

        public final void a(au auVar, au.c cVar) {
            if (cVar != null && cVar.nwv > 0 && a.bhH().laR.lbk.lcc.equals(cVar.bdo)) {
                a.bhH().laX.a(new com.tencent.mm.plugin.wear.model.f.c(this) {
                    final /* synthetic */ AnonymousClass2 lbv;

                    {
                        this.lbv = r1;
                    }

                    protected final void send() {
                        try {
                            a.bhH();
                            r.a(20007, a.bhH().laR.lbk.lcc.getBytes("utf8"), false);
                        } catch (UnsupportedEncodingException e) {
                        }
                    }

                    public final String getName() {
                        return "SendMsgSyncTask";
                    }
                });
            }
        }
    };
    c hcA = new c<qv>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = qv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qv qvVar = (qv) bVar;
            if (qvVar instanceof qv) {
                switch (qvVar.bsq.action) {
                    case 2:
                        a.bhH().laX.a(new h(qvVar.bsr.aYG, qvVar.bsr.bst, qvVar.bsr.bsu, qvVar.bsr.bsv));
                        break;
                    case 4:
                        if (j.sU().getInt("WearPayBlock", 0) == 0) {
                            a.bhH().laX.a(new k(qvVar.bsq.bss, qvVar.bsq.content));
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };
    c jUY = new c<in>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            in inVar = (in) bVar;
            if ((inVar instanceof in) && e.a(this.lbu) && !"gh_3dfda90e39d6".equals(inVar.biX.bdo)) {
                ak.yW();
                at MI = com.tencent.mm.model.c.wJ().MI(inVar.biX.bdo);
                boolean z = j.sU().getInt("WearLuckyBlock", 0) == 0 && (MI.bwc() || MI.bwd());
                if (z) {
                    a.bhH().laX.a(new g(MI));
                    if (inVar.biX.aWI > 1) {
                        e.k(inVar.biX.bdo, inVar.biX.aWI, false);
                    }
                } else {
                    e.k(inVar.biX.bdo, inVar.biX.aWI, true);
                }
            }
            return false;
        }
    };
    private PowerManager lbm;
    private KeyguardManager lbn;
    c lbo = new c<com.tencent.mm.e.a.k>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = com.tencent.mm.e.a.k.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.e.a.k kVar = (com.tencent.mm.e.a.k) bVar;
            if (kVar.aWD.aWE) {
                a.bhH().laX.a(new i());
            }
            j jVar = a.bhH().laX;
            boolean z = kVar.aWD.aWE;
            if (jVar.lbP > 0) {
                if (z) {
                    Process.setThreadPriority(jVar.lbP, 10);
                    v.i("MicroMsg.Wear.WearWorker", "switch low priority");
                } else {
                    Process.setThreadPriority(jVar.lbP, -2);
                    v.i("MicroMsg.Wear.WearWorker", "switch high priority");
                }
            }
            return false;
        }
    };
    c lbp = new c<jl>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = jl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jl jlVar = (jl) bVar;
            if (jlVar instanceof jl) {
                a.bhH().laT.DI(jlVar.bjQ.bdo);
                f DH = a.bhH().laT.DH(jlVar.bjQ.bdo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(DH.id));
                a.bhH().laX.a(new i(arrayList));
                if (jlVar.bjQ.bdo.equals("gh_43f2581f6fd6")) {
                    bhl com_tencent_mm_protocal_c_bhl = a.bhH().laR.lbj.lcb;
                    if (com_tencent_mm_protocal_c_bhl != null) {
                        boolean z = com_tencent_mm_protocal_c_bhl != null && a.bhH().laU.lbb && b.DG(com_tencent_mm_protocal_c_bhl.ncr);
                        if (z) {
                            a.bhH();
                            b.a(com_tencent_mm_protocal_c_bhl);
                        } else {
                            a.bhH().laU.connect();
                        }
                    }
                }
            }
            return false;
        }
    };
    c lbq = new c<qi>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = qi.class.getName().hashCode();
        }

        private static boolean a(qi qiVar) {
            if (qiVar instanceof qi) {
                switch (qiVar.brC.bdn) {
                    case 3:
                        Object obj = qiVar.brC.brw;
                        if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                            bfj com_tencent_mm_protocal_c_bfj;
                            Object obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            try {
                                com_tencent_mm_protocal_c_bfj = (bfj) new bfj().az(obj2);
                            } catch (IOException e) {
                                com_tencent_mm_protocal_c_bfj = null;
                            }
                            if (com_tencent_mm_protocal_c_bfj != null) {
                                String str = com_tencent_mm_protocal_c_bfj.naR;
                                int i = com_tencent_mm_protocal_c_bfj.naJ;
                                v.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[]{str, Integer.valueOf(i)});
                                a.bhH().laX.a(new l(20010, str));
                                break;
                            }
                        }
                        break;
                }
            }
            return false;
        }
    };
    c lbr = new c<qy>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = qy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qy qyVar = (qy) bVar;
            if (qyVar instanceof qy) {
                switch (qyVar.bsD.aYt) {
                    case 5:
                        a.bhH().laX.a(new l(20011, ""));
                        break;
                    case 6:
                    case 7:
                        a.bhH().laX.a(new l(20012, ""));
                        break;
                }
            }
            return false;
        }
    };
    c lbs = new c<iv>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = iv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iv ivVar = (iv) bVar;
            if ((ivVar instanceof iv) && e.a(this.lbu)) {
                a.bhH().laX.a(new f(ivVar.bjm.userName, ivVar.bjm.aGX, ivVar.bjm.type));
            }
            return false;
        }
    };
    c lbt = new c<ms>(this) {
        final /* synthetic */ e lbu;

        {
            this.lbu = r2;
            this.nhz = ms.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if ((((ms) bVar) instanceof ms) && e.a(this.lbu)) {
                a.bhH().laX.a(new com.tencent.mm.plugin.wear.model.f.e());
            }
            return false;
        }
    };

    static /* synthetic */ boolean a(e eVar) {
        return eVar.lbn.inKeyguardRestrictedInputMode() || !eVar.lbm.isScreenOn();
    }

    public e() {
        v.i("MicroMsg.Wear.WearLogic", "Create!");
        com.tencent.mm.sdk.c.a.nhr.e(this.jUY);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbo);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbp);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbq);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbr);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbs);
        com.tencent.mm.sdk.c.a.nhr.e(this.lbt);
        com.tencent.mm.sdk.c.a.nhr.e(this.bZd);
        com.tencent.mm.sdk.c.a.nhr.e(this.hcA);
        this.dwn.ea(1800000);
        this.lbm = (PowerManager) aa.getContext().getSystemService("power");
        this.lbn = (KeyguardManager) aa.getContext().getSystemService("keyguard");
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this.fGy, null);
    }

    public static void k(String str, int i, boolean z) {
        a.bhH().laX.a(new com.tencent.mm.plugin.wear.model.f.j(str, i, z));
    }
}
