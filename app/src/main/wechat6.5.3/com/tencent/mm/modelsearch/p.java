package com.tencent.mm.modelsearch;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p {
    public static final b cWn = new b();
    private static g cWo = new g();

    public static class a implements Comparator<h> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            int i = hVar2.cWz - hVar.cWz;
            if (i != 0) {
                return i;
            }
            if (hVar2.cWz >= 10 && hVar.cWz >= 10) {
                i = FTSUtils.b(d.cVz, hVar.cWt, hVar2.cWt);
                if (i != 0) {
                    return i;
                }
            }
            if (hVar2.timestamp > hVar.timestamp) {
                return 1;
            }
            return hVar2.timestamp < hVar.timestamp ? -1 : 0;
        }
    }

    public static class b implements Comparator<h> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            int i = hVar2.cWz - hVar.cWz;
            if (i != 0) {
                return i;
            }
            i = FTSUtils.a(d.cVs, hVar.type, hVar2.type);
            if (i != 0) {
                return i;
            }
            i = FTSUtils.b(d.cVz, hVar.cWt, hVar2.cWt);
            if (i != 0) {
                return i;
            }
            a Iy = hVar.Iy();
            a Iy2 = hVar2.Iy();
            i = Iy.cWE - Iy2.cWE;
            if (i != 0) {
                return i;
            }
            if (hVar.cWt != 11 && hVar.cWt != 17 && hVar.cWt != 18) {
                return hVar.cWw[Iy.cWD].compareToIgnoreCase(hVar2.cWw[Iy2.cWD]);
            }
            if (be.kS(hVar.cWC)) {
                hVar.cWC = com.tencent.mm.model.l.es(hVar.cWv);
                hVar.cWC = hVar.cWC.toLowerCase();
                if (!e(hVar.cWC.charAt(0))) {
                    hVar.cWC = "~" + hVar.cWC;
                }
            }
            if (be.kS(hVar2.cWC)) {
                hVar2.cWC = com.tencent.mm.model.l.es(hVar2.cWv);
                hVar2.cWC = hVar2.cWC.toLowerCase();
                if (!e(hVar2.cWC.charAt(0))) {
                    hVar2.cWC = "~" + hVar2.cWC;
                }
            }
            return hVar.cWC.compareToIgnoreCase(hVar2.cWC);
        }

        private static boolean e(char c) {
            return c >= 'a' && c <= 'z';
        }
    }

    public static class c implements Comparator<h> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            if (hVar.timestamp > hVar2.timestamp) {
                return -1;
            }
            if (hVar.timestamp < hVar2.timestamp) {
                return 1;
            }
            if (hVar.cWt < hVar2.cWt) {
                return 1;
            }
            return hVar.cWt <= hVar2.cWt ? 0 : -1;
        }
    }

    public static class d implements Comparator<h> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            if (hVar.cWt < hVar2.cWt) {
                return 1;
            }
            return hVar.cWt > hVar2.cWt ? -1 : 0;
        }
    }

    public static class e implements Comparator<h> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    }

    public static class f implements Comparator<h> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            if (hVar2.timestamp < hVar.timestamp) {
                return -1;
            }
            return hVar2.timestamp == hVar.timestamp ? 0 : 1;
        }
    }

    public static class g {
        m cWp;
        r cWq;
        LinkedList<n> cWr = new LinkedList();
        SparseArray<o> cWs = new SparseArray();
    }

    public static class h {
        public int cWA;
        public boolean cWB;
        public String cWC;
        public int cWt;
        public long cWu;
        public String cWv;
        public String[] cWw = null;
        public int[] cWx = null;
        public List<a>[] cWy = null;
        public int cWz;
        public String content;
        public long timestamp;
        public int type;
        public Object userData = null;

        public static class a {
            public int cWD = -1;
            public int cWE = -1;
            public int cWF = -1;
            public int end;
            public int start;

            public a(int i, int i2) {
                this.start = i;
                this.end = i2;
            }

            public final String toString() {
                return "(" + this.start + ',' + this.end + ')';
            }
        }

        public final a Iy() {
            return (a) this.cWy[0].get(0);
        }
    }

    public static class i {
        public int cWG;
        public int cWH;
        public String cWI;
        public String cWJ;
        public boolean cWK = false;
        public boolean cWL = false;
        public int cWt;
        public int cWz;
        public String content;
        public int end;
        public int start;

        public i(int i, int i2, int i3, String str, int i4, int i5) {
            this.cWG = i;
            this.cWH = i2;
            this.cWt = i3;
            this.content = str;
            this.start = i4;
            this.end = i5;
        }
    }

    public static class j {
        public String bdo;
        public String bkC;
        public k cUP;
        public HashSet<String> cUR;
        public int cUS;
        public int[] cWM;
        public int[] cWN;
        public Comparator<h> cWO;
        public ac handler;
        public int scene;

        public static j a(String str, int i, HashSet<String> hashSet, Comparator<h> comparator, k kVar, ac acVar) {
            return a(str, null, null, null, i, hashSet, comparator, kVar, acVar);
        }

        public static j b(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<h> comparator, k kVar, ac acVar) {
            return a(str, null, iArr, iArr2, i, hashSet, comparator, kVar, acVar);
        }

        public static j a(String str, String str2, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<h> comparator, k kVar, ac acVar) {
            j jVar = new j();
            jVar.bkC = str;
            jVar.bdo = str2;
            jVar.cWM = iArr;
            jVar.cWN = iArr2;
            jVar.cUS = i;
            jVar.cUR = hashSet;
            jVar.cWO = comparator;
            jVar.cUP = kVar;
            jVar.handler = acVar;
            return jVar;
        }
    }

    public interface k {
        void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str);

        void jI(String str);
    }

    public static abstract class l {
        public Object cWP;
    }

    public static class m implements Comparator<h> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            h hVar = (h) obj;
            h hVar2 = (h) obj2;
            if (hVar.timestamp > hVar2.timestamp) {
                return -1;
            }
            if (hVar.timestamp < hVar2.timestamp) {
                return 1;
            }
            if (hVar.cWt < hVar2.cWt) {
                return 1;
            }
            return hVar.cWt <= hVar2.cWt ? 0 : -1;
        }
    }

    public static void a(m mVar, r rVar) {
        g gVar = cWo;
        if (mVar != null && rVar != null) {
            gVar.cWp = mVar;
            gVar.cWq = rVar;
        }
    }

    public static void Ir() {
        g gVar = cWo;
        Iterator it = gVar.cWr.iterator();
        while (it.hasNext()) {
            ((n) it.next()).destroy();
        }
        gVar.cWr.clear();
        v.i("MicroMsg.FTS.IFTSPlugin", "Destroy Native Logic");
        for (int i = 0; i < gVar.cWs.size(); i++) {
            try {
                ((o) gVar.cWs.get(gVar.cWs.keyAt(i))).destroy();
            } catch (Throwable e) {
                v.e("MicroMsg.FTS.IFTSPlugin", "Destroy Native Logic name=%s \nexception=%s", r0.getName(), be.e(e));
            }
        }
        gVar.cWs.clear();
        gVar.cWp = null;
        gVar.cWq = null;
    }

    public static m Is() {
        return cWo.cWp;
    }

    public static r It() {
        return cWo.cWq;
    }

    public static boolean Iu() {
        g gVar = cWo;
        return (gVar.cWp == null || gVar.cWq == null) ? false : true;
    }

    private static boolean Iv() {
        if (!Iu()) {
            v.e("MicroMsg.FTS.IFTSPlugin", "FTSContext is not ready %s", be.bur().toString());
            return false;
        } else if (cWo.cWq.Iz()) {
            return true;
        } else {
            cWo.cWq.start();
            v.w("MicroMsg.FTS.IFTSPlugin", "start fts task daemon on IFTSPlugin");
            return true;
        }
    }

    public static void a(int i, o oVar) {
        g gVar = cWo;
        if (gVar.cWs.indexOfKey(i) >= 0) {
            v.w("MicroMsg.FTS.IFTSPlugin", "Aready Exist Logic, type=%d, name=%s", Integer.valueOf(i), oVar.getName());
        } else {
            v.i("MicroMsg.FTS.IFTSPlugin", "Register Logic type=%d, name=%s", Integer.valueOf(i), oVar.getName());
        }
        gVar.cWs.put(i, oVar);
    }

    public static void Iw() {
        g gVar = cWo;
        v.i("MicroMsg.FTS.IFTSPlugin", "Create Native Logic");
        for (int i = 0; i < gVar.cWs.size(); i++) {
            try {
                ((o) gVar.cWs.get(gVar.cWs.keyAt(i))).create();
            } catch (Throwable e) {
                v.e("MicroMsg.FTS.IFTSPlugin", "Create Native Logic name=%s \nexception=%s", r0.getName(), be.e(e));
            }
        }
    }

    public static void gb(int i) {
        g gVar = cWo;
        if (gVar.cWs.indexOfKey(i) >= 0) {
            try {
                ((o) gVar.cWs.get(i)).destroy();
            } catch (Throwable e) {
                v.e("MicroMsg.FTS.IFTSPlugin", "Destroy Native Logic name=%s \nexception=%s", r0.getName(), be.e(e));
            }
        }
        gVar.cWs.remove(i);
    }

    public static void a(n nVar) {
        g gVar = cWo;
        gVar.cWr.add(nVar);
        Collections.sort(gVar.cWr);
    }

    public static void gc(int i) {
        g gVar = cWo;
        n nVar = null;
        Iterator it = gVar.cWr.iterator();
        while (it.hasNext()) {
            n nVar2 = (n) it.next();
            if (nVar2.getType() != i) {
                nVar2 = nVar;
            }
            nVar = nVar2;
        }
        if (nVar != null) {
            nVar.destroy();
            gVar.cWr.remove(nVar);
        }
    }

    public static n gd(int i) {
        n nVar = null;
        Iterator it = cWo.cWr.iterator();
        while (it.hasNext()) {
            n nVar2 = (n) it.next();
            if (nVar2.getType() != i) {
                nVar2 = nVar;
            }
            nVar = nVar2;
        }
        return nVar;
    }

    public static LinkedList<n> Ix() {
        return cWo.cWr;
    }

    public static l a(String str, int[] iArr, k kVar, ac acVar, int i, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(1) >= 0) {
            o oVar = (o) cWo.cWs.get(1);
            if (oVar.HW()) {
                j jVar = new j();
                jVar.bkC = str;
                jVar.cWM = iArr;
                jVar.cUS = 3;
                jVar.cUP = kVar;
                jVar.handler = acVar;
                jVar.scene = i;
                jVar.cUR = hashSet;
                return oVar.a(jVar);
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found TopHits Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l d(String str, Comparator<h> comparator, k kVar, ac acVar, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(7) >= 0) {
            o oVar = (o) cWo.cWs.get(7);
            if (oVar.HW()) {
                return oVar.b(j.a(str, 0, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Game Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, Comparator<h> comparator, k kVar, ac acVar, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(5) >= 0) {
            o oVar = (o) cWo.cWs.get(5);
            if (oVar.HW()) {
                return oVar.b(j.a(str, 0, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Game Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l b(String str, Comparator<h> comparator, k kVar, ac acVar, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(6) >= 0) {
            o oVar = (o) cWo.cWs.get(6);
            if (oVar.HW()) {
                return oVar.b(j.a(str, 0, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Favorite Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l c(String str, Comparator<h> comparator, k kVar, ac acVar, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(4) >= 0) {
            o oVar = (o) cWo.cWs.get(4);
            if (oVar.HW()) {
                return oVar.b(j.a(str, 0, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Feature Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, Comparator<h> comparator, int i, k kVar, ac acVar, HashSet<String> hashSet) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(3) >= 0) {
            o oVar = (o) cWo.cWs.get(3);
            if (oVar.HW()) {
                return oVar.b(j.a(str, i, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Message Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, int[] iArr, int i, Comparator<h> comparator, k kVar, ac acVar) {
        return a(str, iArr, null, i, new HashSet(), comparator, kVar, acVar);
    }

    public static l a(String str, int[] iArr, int i, Comparator<h> comparator, k kVar, ac acVar, HashSet<String> hashSet) {
        return a(str, iArr, null, i, hashSet, comparator, kVar, acVar);
    }

    public static l a(String str, int[] iArr, int[] iArr2, Comparator<h> comparator, k kVar, ac acVar) {
        return a(str, iArr, iArr2, 0, new HashSet(), comparator, kVar, acVar);
    }

    public static l a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<h> comparator, k kVar, ac acVar) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(2) >= 0) {
            o oVar = (o) cWo.cWs.get(2);
            if (oVar.HW()) {
                return oVar.b(j.b(str, iArr, iArr2, i, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Contact Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, int[] iArr, int i, HashSet<String> hashSet, Comparator<h> comparator, k kVar, ac acVar) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(2) >= 0) {
            o oVar = (o) cWo.cWs.get(2);
            if (oVar.HW()) {
                return oVar.c(j.b(str, iArr, null, i, hashSet, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Contact Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, int i, HashSet<String> hashSet, k kVar, ac acVar) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(2) >= 0) {
            o oVar = (o) cWo.cWs.get(2);
            if (oVar.HW()) {
                return oVar.d(j.a(str, i, hashSet, new a(), kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Contact Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static l a(String str, String str2, Comparator<h> comparator, k kVar, ac acVar) {
        Runnable gVar = new g(str, new HashSet(), kVar, acVar);
        if (!Iv()) {
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else if (cWo.cWs.indexOfKey(3) >= 0) {
            o oVar = (o) cWo.cWs.get(3);
            if (oVar.HW()) {
                return oVar.e(j.a(str, str2, null, null, 0, null, comparator, kVar, acVar));
            }
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        } else {
            v.e("MicroMsg.FTS.IFTSPlugin", "Not Found Message Logic, LogicArraySize=%d", Integer.valueOf(cWo.cWs.size()));
            com.tencent.mm.sdk.i.e.a(gVar, "FTSExceptionHandler");
            return gVar;
        }
    }

    public static void a(l lVar) {
        if (Iv() && (lVar instanceof com.tencent.mm.modelsearch.r.a)) {
            cWo.cWq.a((com.tencent.mm.modelsearch.r.a) lVar);
        }
    }

    public static void b(String str, h hVar, int i) {
        if (Iv() && cWo.cWs.indexOfKey(1) >= 0) {
            ((o) cWo.cWs.get(1)).a(str, hVar, i);
        }
    }
}
