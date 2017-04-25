package com.tencent.mm.modelfriend;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.az.a;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.ge;
import com.tencent.mm.e.a.gm;
import com.tencent.mm.e.a.h;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ah implements ag {
    private static HashMap<Integer, c> bXq;
    private c cIM;
    private i cIN;
    private l cIO;
    private ae cIP;
    private ag cIQ;
    private r cIR;
    private p cIS;
    private e cIT = new e();
    private LinkedList<agl> cIU = null;
    private d cIV = new d();
    private f cIW = new f();
    private g cIX = new g();
    private com.tencent.mm.sdk.c.c cIY = new com.tencent.mm.sdk.c.c<aj>(this) {
        final /* synthetic */ ah cJe;

        {
            this.cJe = r2;
            this.nhz = aj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            aj ajVar = (aj) bVar;
            if (ajVar instanceof aj) {
                ajVar.aXZ.aXR = m.Fb();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c cIZ = new com.tencent.mm.sdk.c.c<gm>(this) {
        final /* synthetic */ ah cJe;

        {
            this.cJe = r2;
            this.nhz = gm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gm gmVar = (gm) bVar;
            if (gmVar instanceof gm) {
                int i = gmVar.bfY.scene;
                k xVar = new x();
                ((xe) xVar.cif.czk.czs).maG = i;
                ak.vy().a(xVar, 0);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c cJa = new com.tencent.mm.sdk.c.c<ge>(this) {
        final /* synthetic */ ah cJe;

        {
            this.cJe = r2;
            this.nhz = ge.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ge geVar = (ge) bVar;
            if (geVar instanceof ge) {
                String str = geVar.bfG.bfI;
                if (be.kS(str)) {
                    v.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor rawQuery = ah.FL().cuX.rawQuery("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = " + str, null);
                    List linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        linkedList.add(rawQuery.getString(0));
                    }
                    rawQuery.close();
                    v.i("MicroMsg.SubCoreFriend", "hy: username: %s", linkedList.size() == 0 ? SQLiteDatabase.KeyEmpty : (String) linkedList.get(0));
                    geVar.bfH.userName = str;
                }
            }
            return false;
        }
    };
    private t cJb;
    private com.tencent.mm.sdk.c.c cJc = new com.tencent.mm.sdk.c.c<mv>(this) {
        final /* synthetic */ ah cJe;

        {
            this.cJe = r2;
            this.nhz = mv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mv mvVar = (mv) bVar;
            Intent intent = mvVar.bof.intent;
            String str = mvVar.bof.username;
            if (intent == null || str == null || str.length() == 0) {
                v.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                af iM = ah.FQ().iM(str);
                if (iM != null) {
                    intent.putExtra("Contact_Uin", iM.cIA);
                    intent.putExtra("Contact_QQNick", iM.getDisplayName());
                }
                b iA = ah.FL().iA(str);
                if (iA != null) {
                    intent.putExtra("Contact_Mobile_MD5", iA.EB());
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c cJd = new com.tencent.mm.sdk.c.c<h>(this) {
        final /* synthetic */ ah cJe;

        {
            this.cJe = r2;
            this.nhz = h.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a.uy(((h) bVar).aWw.scene);
            return false;
        }
    };

    private static ah FK() {
        ah ahVar = (ah) ak.yP().fY(ah.class.getName());
        if (ahVar != null) {
            return ahVar;
        }
        Object ahVar2 = new ah();
        ak.yP().a(ah.class.getName(), ahVar2);
        return ahVar2;
    }

    public static c FL() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIM == null) {
            ah FK = FK();
            ak.yW();
            FK.cIM = new c(com.tencent.mm.model.c.wE());
        }
        return FK().cIM;
    }

    public static i FM() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIN == null) {
            ah FK = FK();
            ak.yW();
            FK.cIN = new i(com.tencent.mm.model.c.wE());
        }
        return FK().cIN;
    }

    public static l FN() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIO == null) {
            ah FK = FK();
            ak.yW();
            FK.cIO = new l(com.tencent.mm.model.c.wE());
        }
        return FK().cIO;
    }

    public static ae FO() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIP == null) {
            ah FK = FK();
            ak.yW();
            FK.cIP = new ae(com.tencent.mm.model.c.wE());
        }
        return FK().cIP;
    }

    public static r FP() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIR == null) {
            ah FK = FK();
            ak.yW();
            FK.cIR = new r(com.tencent.mm.model.c.wE());
        }
        return FK().cIR;
    }

    public static ag FQ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIQ == null) {
            ah FK = FK();
            ak.yW();
            FK.cIQ = new ag(com.tencent.mm.model.c.wE());
        }
        return FK().cIQ;
    }

    public static void g(LinkedList<agl> linkedList) {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        FK().cIU = linkedList;
    }

    public static LinkedList<agl> FR() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return FK().cIU;
        }
        throw new com.tencent.mm.model.b();
    }

    public static void FS() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        FK().cIU = null;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.cJc);
        com.tencent.mm.sdk.c.a.nhr.f(this.cJd);
        com.tencent.mm.sdk.c.a.nhr.f(this.cJa);
        com.tencent.mm.sdk.c.a.nhr.f(this.cIV);
        com.tencent.mm.sdk.c.a.nhr.f(this.cIW);
        com.tencent.mm.sdk.c.a.nhr.f(this.cIX);
        com.tencent.mm.sdk.c.a.nhr.f(this.cIY);
        com.tencent.mm.sdk.c.a.nhr.f(this.cIZ);
        d.c.aw(Integer.valueOf(42));
        this.cIU = null;
        j.a.lxY = null;
    }

    public final void ed(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return c.cic;
            }
        });
        bXq.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
        bXq.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        bXq.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return ae.cic;
            }
        });
        bXq.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return ag.cic;
            }
        });
        bXq.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return r.cic;
            }
        });
        bXq.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return p.cic;
            }
        });
        bXq.put(Integer.valueOf("LINKEDIN_FRIEND_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return t.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(42), this.cIT);
        com.tencent.mm.sdk.c.a.nhr.e(this.cJc);
        com.tencent.mm.sdk.c.a.nhr.e(this.cJd);
        com.tencent.mm.sdk.c.a.nhr.e(this.cJa);
        com.tencent.mm.sdk.c.a.nhr.e(this.cIV);
        com.tencent.mm.sdk.c.a.nhr.e(this.cIW);
        com.tencent.mm.sdk.c.a.nhr.e(this.cIX);
        com.tencent.mm.sdk.c.a.nhr.e(this.cIY);
        com.tencent.mm.sdk.c.a.nhr.e(this.cIZ);
        j.a.lxY = FL();
    }

    public final void aH(boolean z) {
    }

    public static p FT() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cIS == null) {
            ah FK = FK();
            ak.yW();
            FK.cIS = new p(com.tencent.mm.model.c.wE());
        }
        return FK().cIS;
    }

    public static t FU() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (FK().cJb == null) {
            ah FK = FK();
            ak.yW();
            FK.cJb = new t(com.tencent.mm.model.c.wE());
        }
        return FK().cJb;
    }
}
