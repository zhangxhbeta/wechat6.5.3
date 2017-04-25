package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.ab.d;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.en;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.pluginsdk.j.al;
import com.tencent.mm.pluginsdk.j.s;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements ag, ah {
    private Map<String, ag> cvs = new HashMap();
    private a ker;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] kes = new int[a.aZa().length];

        static {
            try {
                kes[a.keI - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kes[a.keJ - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kes[a.keK - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kes[a.keL - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kes[a.keM - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                kes[a.keO - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                kes[a.keN - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static class a extends c<en> implements e {
        boolean keA;
        private com.tencent.mm.sdk.platformtools.ah keB;
        private en keC;
        private boolean keD;
        private int keE;
        private Map<String, String> keF;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.a ket;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.c keu;
        private b kev;
        private com.tencent.mm.modelvoice.b kew;
        private p kex;
        private volatile boolean kez;

        private enum a {
            ;

            public static int[] aZa() {
                return (int[]) keP.clone();
            }

            static {
                keI = 1;
                keJ = 2;
                keK = 3;
                keL = 4;
                keM = 5;
                keN = 6;
                keO = 7;
                keP = new int[]{keI, keJ, keK, keL, keM, keN, keO};
            }
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            en enVar = (en) bVar;
            if (enVar instanceof en) {
                this.keC = enVar;
                if (this.keC.bdc.bdf == 2) {
                    rm(a.keO);
                    this.keF.clear();
                    v.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                    return true;
                } else if (this.keC.bdc.bdf == 1) {
                    rm(a.keO);
                    v.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                    return true;
                } else if (this.keC.bdc.bdf != 0) {
                    v.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.keC.bdc.bdf));
                    return false;
                } else if (this.keD) {
                    v.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                    return false;
                } else if (m.Lz() == null) {
                    v.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + be.bur());
                    return false;
                } else {
                    String str = this.keC.bdc.bde;
                    String str2 = this.keC.bdc.aST;
                    if (be.kS(str) || be.kS(str2)) {
                        v.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                        rm(a.keN);
                        return false;
                    }
                    String str3 = (String) this.keF.get(str2);
                    if (be.kS(str3)) {
                        this.kex = m.Lz().lJ(str2);
                        if (this.kex == null) {
                            v.i("MicroMsg.SubCoreSubapp", "The VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                            this.kex = new p();
                            this.kex.aST = str2;
                            this.kex.dhH = System.currentTimeMillis() / 1000;
                            this.kex.clientId = str2;
                            this.kex.dhI = System.currentTimeMillis() / 1000;
                            this.kex.status = 1;
                            v.i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(o.le(str2)));
                            this.kex.cyu = r0;
                        }
                        this.kew = q.lC(this.kex.aST);
                        this.keD = true;
                        this.keE = 20;
                        rm(a.keI);
                        return true;
                    }
                    Cr(str3);
                    return true;
                }
            }
            v.f("MicroMsg.SubCoreSubapp", "mismatched event");
            return false;
        }

        public a() {
            this.kez = false;
            this.keA = false;
            this.keF = new HashMap();
            this.nhz = en.class.getName().hashCode();
        }

        final void rm(int i) {
            switch (AnonymousClass1.kes[i - 1]) {
                case 1:
                    v.i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.kex.bmL > 0) {
                        v.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.kex.bmL));
                        this.ket = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.kex.clientId, this.kex.cyu, this.kew.getFormat(), this.kex.bmL, this.kex.aST);
                    } else {
                        v.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.kex.bmL));
                        this.ket = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.kex.clientId, this.kex.cyu, this.kex.aST);
                    }
                    ak.vy().a(this.ket, 0);
                    ak.vy().a(this.ket.getType(), (e) this);
                    return;
                case 2:
                    v.i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.ket == null) {
                        v.d("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        return;
                    }
                    this.keu = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.kex.clientId, this.ket.kic, this.kew.getFormat(), this.kex.aST);
                    ak.vy().a(this.keu, 0);
                    ak.vy().a(this.keu.getType(), (e) this);
                    return;
                case 3:
                    v.i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.keu == null) {
                        v.d("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        return;
                    }
                    this.keu = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.keu);
                    ak.vy().a(this.keu, 0);
                    ak.vy().a(this.keu.getType(), (e) this);
                    return;
                case 4:
                    if (this.kez) {
                        v.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        return;
                    }
                    v.i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.ket == null) {
                        v.d("MicroMsg.SubCoreSubapp", "request get must after check!");
                        return;
                    }
                    this.kez = true;
                    this.kev = new b(this.kex.clientId);
                    ak.vy().a(this.kev, 0);
                    ak.vy().a(this.kev.getType(), (e) this);
                    return;
                case 5:
                    this.keA = true;
                    return;
                case 6:
                    ak.vy().c(this.ket);
                    ak.vy().c(this.keu);
                    ak.vy().c(this.kev);
                    break;
                case 7:
                    break;
                default:
                    return;
            }
            Cr(null);
        }

        private void Cr(String str) {
            if (this.keB != null) {
                this.keB.QI();
            }
            ak.vy().b(546, (e) this);
            ak.vy().b(547, (e) this);
            ak.vy().b(548, (e) this);
            if (this.keC != null) {
                if (!be.kS(str)) {
                    this.keF.put(this.keC.bdc.aST, str);
                }
                this.keC.bdd.baS = true;
                this.keC.bdd.content = str;
                v.i("MicroMsg.SubCoreSubapp", "result : %s", str);
                if (this.keC.bdc.bdg != null) {
                    this.keC.bdc.bdg.run();
                }
            }
            this.ket = null;
            this.keu = null;
            this.kev = null;
            this.keC = null;
            this.keD = false;
            this.keA = false;
            this.kez = false;
            this.keE = 20;
        }

        public final void a(int i, int i2, String str, k kVar) {
            String str2 = null;
            v.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                int i3;
                switch (kVar.getType()) {
                    case 546:
                        if (this.ket.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.kia) {
                            v.i("MicroMsg.SubCoreSubapp", "check result: done");
                            rm(a.keM);
                            if (this.ket.aZF()) {
                                str2 = this.ket.kib.mZM;
                            }
                            Cr(str2);
                            return;
                        } else if (this.ket.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.khZ) {
                            if (this.ket.kib != null) {
                                be.kS(this.ket.kib.mZM);
                            }
                            v.i("MicroMsg.SubCoreSubapp", "check result: processing");
                            rm(a.keL);
                            return;
                        } else if (this.ket.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.khY) {
                            v.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            rm(a.keJ);
                            return;
                        } else if (this.ket.kid != null) {
                            i3 = this.ket.kid.mOA;
                            return;
                        } else {
                            return;
                        }
                    case 547:
                        if (this.keu.aZH()) {
                            v.i("MicroMsg.SubCoreSubapp", "succeed upload");
                            rm(a.keL);
                            return;
                        }
                        v.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.keu.kic.mdA), Integer.valueOf(this.keu.kic.mdB));
                        rm(a.keK);
                        return;
                    case 548:
                        final int i4 = this.kev.kif;
                        this.kez = false;
                        if (!this.kev.isComplete() && this.kev.aZF()) {
                            v.d("MicroMsg.SubCoreSubapp", "result valid:%s", this.kev.kib.mZM);
                        } else if (!this.kev.aZF()) {
                            v.d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.kev.isComplete()) {
                            v.i("MicroMsg.SubCoreSubapp", "succeed get");
                            if (this.kev.aZF()) {
                                str2 = this.kev.kib.mZM;
                            }
                            rm(a.keM);
                            Cr(str2);
                            return;
                        }
                        v.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i4));
                        if (!this.keA) {
                            i3 = this.keE - 1;
                            this.keE = i3;
                            if (i3 < 0) {
                                v.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", Integer.valueOf(20));
                                rm(a.keN);
                                return;
                            }
                            if (this.keB == null) {
                                this.keB = new com.tencent.mm.sdk.platformtools.ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                                    final /* synthetic */ a keH;

                                    public final boolean oU() {
                                        if (!this.keH.keA) {
                                            v.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i4));
                                            this.keH.rm(a.keL);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            this.keB.ea((long) (i4 * 1000));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            rm(a.keN);
        }
    }

    public a() {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        this.cvs = oK();
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, g.c> ti() {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, g.c> hashMap = new HashMap();
        for (Entry entry : this.cvs.entrySet()) {
            if (((ag) entry.getValue()).ti() != null) {
                hashMap.putAll(((ag) entry.getValue()).ti());
            }
        }
        return hashMap;
    }

    public final void ed(int i) {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.cvs.entrySet()) {
            ((ag) value.getValue()).ed(i);
        }
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.cvs.entrySet()) {
            ((ag) value.getValue()).aG(z);
        }
        if (this.ker == null) {
            this.ker = new a();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.ker);
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.cvs.entrySet()) {
            ((ag) value.getValue()).aH(z);
        }
    }

    public final void th() {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.cvs.entrySet()) {
            ((ag) value.getValue()).th();
        }
        if (this.ker != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.ker);
        }
    }

    public final Map<String, ag> oK() {
        v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        Map<String, ag> hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        ab.g dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.model.ab.a.csd = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        s cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        al.lyl = cVar;
        return hashMap;
    }

    public final ag Cq(String str) {
        return (ag) this.cvs.get(str);
    }

    public final void b(String str, ag agVar) {
        this.cvs.put(str, agVar);
    }
}
