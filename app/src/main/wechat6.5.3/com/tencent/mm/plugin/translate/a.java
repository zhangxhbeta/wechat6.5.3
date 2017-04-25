package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.e.a.pj;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.v.e;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements ag {
    ac handler = new ac(Looper.getMainLooper());
    c knC = b.knR;
    ap knD = new ap(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private com.tencent.mm.plugin.translate.a.c.a knE = new com.tencent.mm.plugin.translate.a.c.a(this) {
        final /* synthetic */ a knH;

        {
            this.knH = r1;
        }

        public final void a(final int i, SparseArray<c.c> sparseArray) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                final c.c cVar = (c.c) sparseArray.valueAt(i2);
                if (cVar != null) {
                    this.knH.knD.c(new com.tencent.mm.sdk.platformtools.ap.a(this) {
                        final /* synthetic */ AnonymousClass1 knJ;

                        public final boolean Ba() {
                            int i = i != 0 ? i : cVar.ret;
                            pk pkVar = new pk();
                            pkVar.bqM.ret = i;
                            pkVar.bqM.bqH = cVar.bqH;
                            pkVar.bqM.id = cVar.id;
                            pkVar.bqM.bqN = cVar.bqN;
                            pkVar.bqM.type = cVar.type;
                            pkVar.bqM.aHM = cVar.aHM;
                            pkVar.bqM.bpg = cVar.bpg;
                            com.tencent.mm.sdk.c.a.nhr.z(pkVar);
                            return false;
                        }

                        public final boolean AZ() {
                            v.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[]{cVar.id});
                            if (i != 0) {
                                v.e("MicroMsg.SubCoreTranslate", "translate error");
                            } else if (cVar.ret != 0) {
                                v.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[]{Integer.valueOf(cVar.ret)});
                            } else if (be.kS(cVar.bqN)) {
                                v.e("MicroMsg.SubCoreTranslate", "translate return null");
                            } else if (cVar.type == 0 || cVar.type == 1) {
                                v.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                String str = cVar.id;
                                String str2 = cVar.aHM;
                                String str3 = cVar.bqN;
                                String str4 = cVar.bpg;
                                ak.yW();
                                au wJ = com.tencent.mm.model.c.wJ();
                                wJ.cuX.dF(null, "UPDATE " + wJ.Ne(str2) + " SET transContent = '" + be.lZ(str3) + "', transBrandWording = '" + be.lZ(be.ma(str4)) + "' WHERE msgId = " + be.KM(str));
                            }
                            return true;
                        }
                    });
                }
            }
        }
    };
    private com.tencent.mm.sdk.c.c knF = new com.tencent.mm.sdk.c.c<pi>(this) {
        final /* synthetic */ a knH;

        {
            this.knH = r2;
            this.nhz = pi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final pi piVar = (pi) bVar;
            v.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            this.knH.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 knL;

                public final void run() {
                    c cVar = this.knL.knH.knC;
                    String str = piVar.bqG.bqH;
                    String str2 = piVar.bqG.id;
                    int i = piVar.bqG.type;
                    String str3 = piVar.bqG.aHM;
                    boolean z = piVar.bqG.bqI;
                    v.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[]{str2, Integer.valueOf(i)});
                    if (cVar.CI(str2)) {
                        v.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[]{str2});
                        return;
                    }
                    c.c cVar2 = new c.c(str, str2, i, str3);
                    if (z) {
                        ((LinkedList) cVar.knP).add(0, cVar2);
                    } else {
                        cVar.knP.add(cVar2);
                    }
                    cVar.knQ.put(cVar2.id, Integer.valueOf(cVar2.knS));
                    v.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[]{Integer.valueOf(cVar.knN)});
                    cVar.baN();
                }
            });
            return true;
        }
    };
    private com.tencent.mm.sdk.c.c knG = new com.tencent.mm.sdk.c.c<pj>(this) {
        final /* synthetic */ a knH;

        {
            this.knH = r2;
            this.nhz = pj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pj pjVar = (pj) bVar;
            pjVar.bqK.bqL = this.knH.knC.CI(pjVar.bqJ.id);
            return true;
        }
    };

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        c cVar = this.knC;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.knE;
        if (!(aVar == null || cVar.cis.contains(aVar))) {
            cVar.cis.add(aVar);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.knF);
        com.tencent.mm.sdk.c.a.nhr.e(this.knG);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.knF);
        com.tencent.mm.sdk.c.a.nhr.f(this.knG);
        c cVar = this.knC;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.knE;
        if (aVar != null && cVar.cis.contains(aVar)) {
            cVar.cis.remove(aVar);
        }
        c cVar2 = this.knC;
        if (cVar2.knO != null) {
            for (e eVar : cVar2.knO) {
                if (eVar != null) {
                    ak.vy().b(631, eVar);
                    if (eVar.knX != null) {
                        eVar.knZ.QI();
                        ak.vy().c(eVar.knX);
                    }
                    eVar.baO();
                    eVar.knV = null;
                }
            }
        }
        cVar2.knQ.clear();
        cVar2.knP.clear();
        cVar2.cis.clear();
        cVar2.knN = 0;
    }
}
