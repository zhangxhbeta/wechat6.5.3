package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ah;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMCenterCropImageView;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements com.tencent.mm.pluginsdk.j.q.c {
    private static int jjt = 0;
    private Map<Integer, WeakReference<Object>> cMe = new HashMap();
    public boolean jiL = true;
    private long jiW = 0;
    private long jiX = 0;
    public x<String, n> jiY;
    private aj<String, WeakReference<Bitmap>> jiZ;
    private Map<String, LinkedList<WeakReference<c>>> jja = new HashMap();
    private ConcurrentHashMap<Integer, String> jjb = new ConcurrentHashMap();
    private LinkedList<b> jjc = new LinkedList();
    private boolean jjd = false;
    private HashSet<c> jje = new HashSet();
    public HashMap<String, Integer> jjf = new HashMap();
    private int jjg = 4;
    public v jjh;
    public long jji = 0;
    public long jjj = 0;
    private int jjk = 0;
    private int jjl = 0;
    private HashMap<Long, Integer> jjm = new HashMap();
    private HashMap<Integer, Boolean> jjn = new HashMap();
    private HashMap<Integer, Boolean> jjo = new HashMap();
    private int jjp = 0;
    private int jjq = 0;
    private HashMap<Long, Integer> jjr = new HashMap();
    protected Set<String> jjs = new HashSet();

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ g jju;
        final /* synthetic */ int jjv = 0;
        final /* synthetic */ String jjw;
        final /* synthetic */ n jjx;

        AnonymousClass2(g gVar, int i, String str, n nVar) {
            this.jju = gVar;
            this.jjw = str;
            this.jjx = nVar;
        }

        public final void run() {
            this.jju.a(this.jjv + "-" + this.jjw, this.jjx);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ g jju;
        final /* synthetic */ int jjv = 0;
        final /* synthetic */ List jjy;
        final /* synthetic */ ak jjz;

        AnonymousClass4(g gVar, List list, int i, ak akVar) {
            this.jju = gVar;
            this.jjy = list;
            this.jjz = akVar;
        }

        public final void run() {
            long Nj = be.Nj();
            e eVar = new e(this.jjy);
            eVar.jdN = i.bl(this.jjy);
            eVar.jdO = this.jjv;
            int i = 0;
            int i2 = 1;
            while (i < this.jjy.size() && i < 4) {
                int i3;
                aib com_tencent_mm_protocal_c_aib = (aib) this.jjy.get(i);
                b aSz = ad.aSz();
                String str = com_tencent_mm_protocal_c_aib.gID;
                int i4 = aSz.jiN.containsKey(i.ac(1, str)) ? 1 : aSz.jiN.containsKey(i.ac(5, str)) ? 1 : 0;
                if (i4 != 0) {
                    i3 = 0;
                } else if (FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib)) || FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.k(com_tencent_mm_protocal_c_aib)) || FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.l(com_tencent_mm_protocal_c_aib))) {
                    i3 = i2;
                } else {
                    ad.aSz().a(com_tencent_mm_protocal_c_aib, 1, eVar, this.jjz);
                    i3 = 0;
                }
                i++;
                i2 = i3;
            }
            Nj = be.az(Nj);
            if (Nj > 100) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + Nj + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.cni + " " + ad.aSP() + " " + eVar.jdN);
            }
            if (be.az(this.jju.jiW) > 60000) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11696, new Object[]{Integer.valueOf(1), Long.valueOf(Nj), Integer.valueOf(0), Thread.currentThread().getName(), ad.aSP(), com.tencent.mm.compatible.util.e.cni});
                this.jju.jiW = be.Nj();
            }
            final String bl = i.bl(this.jjy);
            if (i2 != 0) {
                ad.aqz().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jjA;

                    public final void run() {
                        new i(i.ab(0, bl), bl, this.jjA.jjy).l("");
                    }
                });
            }
        }
    }

    class AnonymousClass9 implements Runnable {
        final /* synthetic */ aib jiR;
        final /* synthetic */ g jju;

        AnonymousClass9(g gVar, aib com_tencent_mm_protocal_c_aib) {
            this.jju = gVar;
            this.jiR = com_tencent_mm_protocal_c_aib;
        }

        public final void run() {
            g.a(this.jju, 1, this.jiR);
        }
    }

    public enum a {
        ;

        static {
            jjD = 1;
            jjE = 2;
            jjF = new int[]{jjD, jjE};
        }
    }

    static class c {
        public int aJW;
        public String id;
        public int jjI;
        public boolean jjJ;

        public c(String str, int i, int i2, boolean z) {
            this.id = str;
            this.aJW = i;
            this.jjI = i2;
            this.jjJ = z;
        }

        public final int hashCode() {
            return this.aJW;
        }

        public final boolean equals(Object obj) {
            return obj != null && obj.hashCode() == this.aJW;
        }
    }

    class b extends h<String, Integer, Boolean> {
        String apU = "";
        private aib boL;
        private n cnP = null;
        private String jjG;
        private int jjH = 0;
        final /* synthetic */ g jju;
        private String path;

        public final /* synthetic */ Object aRX() {
            this.jju.jjd = true;
            System.currentTimeMillis();
            if (!this.jju.jiL) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
                return Boolean.valueOf(false);
            } else if (this.jju.jiY.aI(this.apU)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
                return Boolean.valueOf(false);
            } else {
                FileOp.jU(this.jjG);
                long currentTimeMillis = System.currentTimeMillis();
                if (!FileOp.aR(this.path)) {
                    K(i.c(this.boL), i.k(this.boL), i.d(this.boL));
                }
                long Nj = be.Nj();
                if (this.jjH == 5) {
                    if (!FileOp.aR(this.path)) {
                        K(i.c(this.boL), i.k(this.boL), i.d(this.boL));
                    }
                    boolean aR = FileOp.aR(this.jjG + i.c(this.boL));
                    boolean aR2 = FileOp.aR(this.jjG + i.k(this.boL));
                    boolean aR3 = FileOp.aR(this.jjG + i.d(this.boL));
                    this.cnP = i.zQ(this.path);
                    if (this.cnP == null) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                        this.cnP = com.tencent.mm.plugin.sns.lucky.b.a.cw(this.jjG + i.d(this.boL), this.path);
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "abc a" + aR + " b" + aR2 + " c" + aR3 + " d" + FileOp.aR(this.path));
                    }
                } else if (this.jjH == 4) {
                    this.cnP = i.zQ(this.path);
                    if (this.cnP == null) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                        this.cnP = com.tencent.mm.plugin.sns.lucky.b.a.cw(this.jjG + i.c(this.boL), this.path);
                    }
                } else {
                    this.cnP = i.zS(this.path);
                }
                long az = be.az(Nj);
                int jP = (int) FileOp.jP(this.path);
                if (be.az(this.jju.jiX) > 60000) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11696, new Object[]{Integer.valueOf(4), Long.valueOf(az), Integer.valueOf(jP), Thread.currentThread().getName(), ad.aSP(), com.tencent.mm.compatible.util.e.cni});
                    this.jju.jiX = be.Nj();
                }
                if (this.cnP == null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[]{this.boL.gID});
                    FileOp.deleteFile(this.jjG + i.d(this.boL));
                    FileOp.deleteFile(this.path);
                    com.tencent.mm.plugin.report.service.g.iuh.a(150, 2, 1, true);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 0, 1, true);
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 1, currentTimeMillis, true);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.cnP == null) + " " + this.cnP + " %d ", new Object[]{this.path, Long.valueOf(System.currentTimeMillis() - Nj)});
                return Boolean.valueOf(true);
            }
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            g.aRV();
            this.jju.jjs.remove(this.apU);
            this.jju.b(this.apU, this.cnP);
            this.jju.jjd = false;
            this.jju.aRS();
        }

        public b(g gVar, String str, String str2, String str3, aib com_tencent_mm_protocal_c_aib, int i) {
            this.jju = gVar;
            gVar.jjs.add(str);
            this.apU = str;
            this.path = str2;
            this.jjG = str3;
            this.boL = com_tencent_mm_protocal_c_aib;
            this.jjH = i;
            g.aRU();
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[]{Integer.valueOf(g.jjt)});
        }

        private void K(String str, String str2, String str3) {
            FileOp.aR(this.jjG + str3);
            if (!FileOp.aR(this.jjG + str)) {
                if (!FileOp.aR(this.jjG + str2)) {
                    str2 = i.l(this.boL);
                }
                if (!p.a(this.jjG, str2, str, (float) ad.aSL())) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ImageLoader", "delete %s", new Object[]{str2});
                    FileOp.deleteFile(this.jjG + str2);
                }
            }
            p.b(this.jjG, str, str3, (float) ad.aSK());
        }

        public final ac aRW() {
            return ad.aqy();
        }
    }

    static /* synthetic */ boolean a(g gVar, int i, aib com_tencent_mm_protocal_c_aib) {
        if (gVar.jiL) {
            final String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
            String e = i == 4 ? i.e(com_tencent_mm_protocal_c_aib) : i == 5 ? i.f(com_tencent_mm_protocal_c_aib) : i == 0 ? i.d(com_tencent_mm_protocal_c_aib) : i.c(com_tencent_mm_protocal_c_aib);
            String c = i.c(com_tencent_mm_protocal_c_aib);
            if (!com.tencent.mm.plugin.sns.e.a.b.AR(com_tencent_mm_protocal_c_aib.gID)) {
                long Nj = be.Nj();
                boolean aR = FileOp.aR(cA + c);
                if (!aR) {
                    aR = FileOp.aR(cA + i.k(com_tencent_mm_protocal_c_aib));
                }
                if (!aR) {
                    FileOp.aR(cA + i.l(com_tencent_mm_protocal_c_aib));
                }
                Nj = be.az(Nj);
                if (Nj > 100) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "fileexist check  endtime " + Nj + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.cni + " " + ad.aSP() + " " + com_tencent_mm_protocal_c_aib.gID);
                }
                if (be.az(gVar.jiW) > 60000) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11696, new Object[]{Integer.valueOf(1), Long.valueOf(Nj), Integer.valueOf(0), Thread.currentThread().getName(), ad.aSP(), com.tencent.mm.compatible.util.e.cni});
                    gVar.jiW = be.Nj();
                }
                if (FileOp.aR(cA + c) || FileOp.aR(cA + i.k(com_tencent_mm_protocal_c_aib)) || FileOp.aR(cA + i.l(com_tencent_mm_protocal_c_aib))) {
                    final int i2 = i;
                    final aib com_tencent_mm_protocal_c_aib2 = com_tencent_mm_protocal_c_aib;
                    ad.aqz().post(new Runnable(gVar) {
                        final /* synthetic */ g jju;

                        public final void run() {
                            while (this.jju.jjc.size() >= 60) {
                                this.jju.jjs.remove(((b) this.jju.jjc.removeFirst()).apU);
                            }
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + this.jju.jjc.size());
                            b bVar = new b(this.jju, i.ab(i2, com_tencent_mm_protocal_c_aib2.gID), cA + e, cA, com_tencent_mm_protocal_c_aib2, i2);
                            if (this.jju.jiY.aI(bVar.apU)) {
                                this.jju.jjs.remove(bVar.apU);
                            } else {
                                this.jju.jjc.add(bVar);
                            }
                            this.jju.aRS();
                        }
                    });
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        if (gVar.jje == null || gVar.jje.size() == 0) {
            return true;
        }
        for (Integer intValue : gVar.cMe.keySet()) {
            int intValue2 = intValue.intValue();
            if (((WeakReference) gVar.cMe.get(Integer.valueOf(intValue2))).get() == null) {
                Iterator it = gVar.jje.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.aJW == intValue2) {
                        gVar.jje.remove(cVar);
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "remove code ok rCode: " + intValue2);
                        break;
                    }
                }
            }
        }
        Iterator it2 = gVar.jje.iterator();
        while (it2.hasNext()) {
            cVar = (c) it2.next();
            if (str != null && str.equals(cVar.id)) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ int aRU() {
        int i = jjt;
        jjt = i + 1;
        return i;
    }

    static /* synthetic */ int aRV() {
        int i = jjt;
        jjt = i - 1;
        return i;
    }

    public final void start() {
        this.jiL = true;
        aRS();
        b aSz = ad.aSz();
        aSz.jiL = true;
        aSz.Ge();
    }

    public final void pause() {
        this.jiL = false;
        b aSz = ad.aSz();
        aSz.jiL = false;
        LinkedList linkedList = new LinkedList();
        Iterator it = aSz.caF.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.requestType != 6) {
                aSz.jiO.remove(fVar.apU);
                linkedList.add(fVar);
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            aSz.caF.remove((f) it2.next());
        }
    }

    public g() {
        int i;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[]{Integer.valueOf(((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass())});
        if (((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            i = 10485760;
        } else {
            i = 5242880;
        }
        this.jiY = new x<String, n>(this, i) {
            final /* synthetic */ g jju;

            protected final /* bridge */ /* synthetic */ Object create(Object obj) {
                return (n) super.create((String) obj);
            }

            protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str = (String) obj;
                n nVar = (n) obj2;
                n nVar2 = (n) obj3;
                super.entryRemoved(z, str, nVar, nVar2);
                if (!(nVar == null || nVar.isRecycled() || nVar.equals(nVar2))) {
                    nVar.wo();
                }
                int i = 0;
                if (nVar2 != null) {
                    i = nVar2.getAllocationByteCount();
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "evicted: " + z + " key: " + str + " result:" + i + " " + (nVar.bitmap.getRowBytes() * nVar.bitmap.getHeight()) + " " + nVar.bitmap.getWidth() + " " + nVar.bitmap.getHeight() + " oldValue " + (nVar == null ? "NULL" : nVar.wq()) + " newValue: " + (nVar2 == null ? "NULL" : nVar2.wq()));
            }

            protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                String str = (String) obj;
                n nVar = (n) obj2;
                int allocationByteCount = nVar != null ? nVar.getAllocationByteCount() : 0;
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "key: %s, size: %s", new Object[]{str, Integer.valueOf(allocationByteCount)});
                if (allocationByteCount != 0 || (nVar != null && !nVar.isRecycled())) {
                    return allocationByteCount;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "size of error  " + nVar);
                return 0;
            }

            public final void trimToSize(int i) {
                try {
                    super.trimToSize(i);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LazyerImageLoader2", "trimToSize error: %s", new Object[]{e.getMessage()});
                }
            }
        };
        this.jiZ = new aj(this.jjg, new com.tencent.mm.plugin.sns.e.aj.a(this) {
            final /* synthetic */ g jju;

            {
                this.jju = r1;
            }

            public final boolean aV(Object obj) {
                String str = (String) obj;
                if (!g.a(this.jju, str)) {
                    return false;
                }
                aj a = this.jju.jiZ;
                try {
                    Bitmap bitmap;
                    Object obj2 = ((com.tencent.mm.plugin.sns.e.aj.b) a.jmW.get(str)).obj;
                    if (obj2 instanceof Bitmap) {
                        bitmap = (Bitmap) obj2;
                    } else {
                        WeakReference weakReference = (WeakReference) ((com.tencent.mm.plugin.sns.e.aj.b) a.jmW.get(str)).obj;
                        bitmap = weakReference != null ? (Bitmap) weakReference.get() : null;
                    }
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SnsLRUMap", "remove key:" + str);
                        bitmap.recycle();
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.SnsLRUMap", e, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SnsLRUMap", "internalMap " + a.jmW.size() + " bfSize :" + a.jmW.size() + " o == null " + (a.jmW.remove(str) != null));
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + this.jju.jiZ.jmW.size() + " listPaitSize:" + this.jju.jje.size());
                return true;
            }
        });
    }

    public final void aRR() {
        if (this.jiY != null) {
            this.cMe.clear();
            this.jiZ.jmW.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.jiY.putCount() + ";");
            stringBuffer.append("missCount:" + this.jiY.missCount() + ";");
            stringBuffer.append("hitCount:" + this.jiY.hitCount() + ";");
            stringBuffer.append("createCount:" + this.jiY.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.jiY.evictionCount() + ";");
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.jiY.trimToSize(-1);
        }
        this.jiZ.aSY();
        System.gc();
    }

    public final Bitmap a(aib com_tencent_mm_protocal_c_aib, View view, int i, ak akVar) {
        return a(com_tencent_mm_protocal_c_aib, view, i, true, akVar);
    }

    private boolean z(View view, int i) {
        if (view.hashCode() == i) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!z(viewGroup.getChildAt(childCount), i));
            return true;
        }
        return false;
    }

    public final void M(Activity activity) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.cMe.size());
        List<Integer> linkedList = new LinkedList();
        Iterator it = this.jje.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (z(activity.getWindow().getDecorView(), cVar.aJW)) {
                linkedList.add(Integer.valueOf(cVar.aJW));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.cMe.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.jje.iterator();
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.aJW == intValue2) {
                    this.jje.remove(cVar);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.jje.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.jjI == activity.hashCode()) {
                linkedList.add(Integer.valueOf(cVar.aJW));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.cMe.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.jje.iterator();
            while (it3.hasNext()) {
                cVar = (c) it3.next();
                if (cVar.aJW == intValue4) {
                    this.jje.remove(cVar);
                    break;
                }
            }
        }
        this.jiZ.aSY();
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.cMe.size());
    }

    public final void ca(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
        }
    }

    public final Bitmap r(aib com_tencent_mm_protocal_c_aib) {
        if (com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return null;
        }
        String ab = i.ab(1, com_tencent_mm_protocal_c_aib.gID);
        String str = com_tencent_mm_protocal_c_aib.gID;
        n Ai = Ai(ab);
        if (i.b(Ai)) {
            return Ai.wm();
        }
        str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
        str = str + i.c(com_tencent_mm_protocal_c_aib);
        if (!FileOp.aR(str)) {
            return null;
        }
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_extend_pic")) {
            Ai = n.f(p.BI(str));
        } else {
            Ai = i.zS(str);
        }
        if (!i.b(Ai)) {
            return null;
        }
        a(ab, Ai);
        return Ai.wm();
    }

    public final String s(aib com_tencent_mm_protocal_c_aib) {
        String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
        return cA + i.c(com_tencent_mm_protocal_c_aib);
    }

    public final void b(aib com_tencent_mm_protocal_c_aib, View view, int i, ak akVar) {
        b(com_tencent_mm_protocal_c_aib, view, -1, i, akVar);
    }

    public final void a(aib com_tencent_mm_protocal_c_aib, View view, int i, int i2, ak akVar) {
        a(com_tencent_mm_protocal_c_aib, view, -1, i, i2, akVar);
    }

    public final n Ai(String str) {
        n nVar = (n) this.jiY.get(str);
        if (nVar != null && !nVar.isRecycled()) {
            return nVar;
        }
        this.jiY.remove(str);
        return null;
    }

    public final void b(aib com_tencent_mm_protocal_c_aib, View view, int i, int i2, ak akVar) {
        a(com_tencent_mm_protocal_c_aib, view, i, i2, a.jjD, akVar);
    }

    public final void a(aib com_tencent_mm_protocal_c_aib, View view, int i, int i2, int i3, ak akVar) {
        if (com_tencent_mm_protocal_c_aib != null && com_tencent_mm_protocal_c_aib.gID != null && !com_tencent_mm_protocal_c_aib.gID.equals("")) {
            view.setDrawingCacheEnabled(false);
            String ab = i.ab(0, com_tencent_mm_protocal_c_aib.gID);
            a((Object) view, ab, i, i2, i3);
            String str = com_tencent_mm_protocal_c_aib.gID;
            n Ai = Ai(ab);
            if (i.b(Ai)) {
                a((Object) view, ab, Ai);
                return;
            }
            if (i == -1) {
                cb(view);
            }
            if (!this.jjs.contains(ab)) {
                a(0, com_tencent_mm_protocal_c_aib, akVar);
            }
        }
    }

    private static void a(Object obj, String str, n nVar) {
        long j = 0;
        if (obj != null) {
            if (nVar != null) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[]{obj, str, nVar.wq()});
            }
            Drawable drawable;
            if (obj instanceof QFadeImageView) {
                long j2;
                QFadeImageView qFadeImageView = (QFadeImageView) obj;
                drawable = qFadeImageView.mDrawable;
                if (!be.kS(qFadeImageView.apU) && qFadeImageView.apU.equals(str)) {
                    j = qFadeImageView.ghc;
                }
                if (drawable == null || !(drawable instanceof ag)) {
                    j2 = j;
                } else {
                    j2 = ((ag) drawable).ghc;
                }
                ag agVar = new ag(str, nVar, j2);
                qFadeImageView.ghc = agVar.ghc;
                qFadeImageView.apU = str;
                qFadeImageView.setImageDrawable(agVar);
                agVar.invalidateSelf();
            } else if (obj instanceof QDisFadeImageView) {
                QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
                com.tencent.mm.memory.a.a aVar = new com.tencent.mm.memory.a.a(str, nVar);
                qDisFadeImageView.setImageDrawable(aVar);
                aVar.invalidateSelf();
            } else if (obj instanceof MMCenterCropImageView) {
                r7 = (ImageView) obj;
                ab.a(r7.getResources(), nVar, r7);
            } else if (obj instanceof ImageView) {
                r7 = (ImageView) obj;
                drawable = r7.getDrawable();
                if (drawable == null || !(drawable instanceof ag)) {
                    drawable = new ag(str, nVar, 0);
                } else {
                    drawable = new ag(str, nVar, ((ag) drawable).ghc);
                }
                r7.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "update sight thumb " + str);
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.mDrawable;
                    if (drawable == null || !(drawable instanceof ag)) {
                        drawable = new ag(str, nVar, 0);
                    } else {
                        drawable = new ag(str, nVar, ((ag) drawable).ghc);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
        }
    }

    public static String t(aib com_tencent_mm_protocal_c_aib) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return null;
        }
        String str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib);
        if (FileOp.aR(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_aib.mHP;
    }

    public static String u(aib com_tencent_mm_protocal_c_aib) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return null;
        }
        String str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.b(com_tencent_mm_protocal_c_aib);
        if (FileOp.aR(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_aib.glb;
    }

    public final void c(aib com_tencent_mm_protocal_c_aib, View view, int i, ak akVar) {
        c(com_tencent_mm_protocal_c_aib, view, -1, i, akVar);
    }

    public final boolean a(k kVar, final aib com_tencent_mm_protocal_c_aib, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, final ak akVar, boolean z) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return false;
        }
        String ab = i.ab(1, com_tencent_mm_protocal_c_aib.gID);
        a((Object) aVar, ab, -1, i);
        if (!FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib))) {
            e eVar = new e(com_tencent_mm_protocal_c_aib);
            eVar.jdO = 1;
            eVar.jdN = com_tencent_mm_protocal_c_aib.gID;
            ad.aSz().a(com_tencent_mm_protocal_c_aib, 1, eVar, akVar);
        }
        String str = "";
        if (z) {
            if (!w(com_tencent_mm_protocal_c_aib)) {
                str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                String i3 = i.i(com_tencent_mm_protocal_c_aib);
                if (FileOp.aR(str + i3)) {
                    str = str + i3;
                } else if (FileOp.aR(str + i.o(com_tencent_mm_protocal_c_aib)) && com_tencent_mm_protocal_c_aib.gID != null && com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path")) {
                    str = str + i.o(com_tencent_mm_protocal_c_aib);
                } else if (this.jiL) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "push sight loader " + com_tencent_mm_protocal_c_aib.gID + " url: " + com_tencent_mm_protocal_c_aib.glb);
                    if (!z) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
                    } else if (b(kVar, null) == 5) {
                        ad.aqz().postDelayed(new Runnable(this) {
                            final /* synthetic */ g jju;

                            public final void run() {
                                ad.aSz().a(com_tencent_mm_protocal_c_aib, 4, null, akVar);
                            }
                        }, 0);
                    }
                }
            }
            str = "";
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[]{ab, str, Boolean.valueOf(z)});
        if (be.kS(str) || w(com_tencent_mm_protocal_c_aib)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[]{str});
            aVar.ag(null, !this.jiL);
            str = com_tencent_mm_protocal_c_aib.gID;
            n Ai = Ai(ab);
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[]{Boolean.valueOf(i.b(Ai))});
            if (i.b(Ai)) {
                a((Object) aVar, ab, Ai);
                return true;
            }
            if ((aVar instanceof ImageView) || (aVar instanceof QFadeImageView)) {
                cb((View) aVar);
            } else if (aVar instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                aVar.ag(null, !this.jiL);
                aVar.iO(0);
                aVar.s(null);
            }
            if (this.jjs.contains(ab)) {
                return false;
            }
            a(1, com_tencent_mm_protocal_c_aib, akVar);
            return false;
        }
        if (!str.equals(aVar.aOV())) {
            aVar.s(null);
        }
        aVar.ag(str, !this.jiL);
        aVar.iO(i2);
        return true;
    }

    public final void d(aib com_tencent_mm_protocal_c_aib, View view, int i, ak akVar) {
        if (com_tencent_mm_protocal_c_aib != null && com_tencent_mm_protocal_c_aib.gID != null && !com_tencent_mm_protocal_c_aib.gID.equals("")) {
            String ab = i.ab(4, com_tencent_mm_protocal_c_aib.gID);
            a((Object) view, ab, -1, i);
            String str = com_tencent_mm_protocal_c_aib.gID;
            n Ai = Ai(ab);
            boolean b = i.b(Ai);
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b);
            if (b) {
                a((Object) view, ab, Ai);
                return;
            }
            cb(view);
            if (!this.jjs.contains(ab)) {
                a(4, com_tencent_mm_protocal_c_aib, akVar);
            }
        }
    }

    public final boolean c(aib com_tencent_mm_protocal_c_aib, View view, int i, int i2, ak akVar) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return false;
        }
        String ab = i.ab(1, com_tencent_mm_protocal_c_aib.gID);
        a((Object) view, ab, i, i2);
        String str = com_tencent_mm_protocal_c_aib.gID;
        n Ai = Ai(ab);
        boolean b = i.b(Ai);
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b + ab);
        if (b) {
            a((Object) view, ab, Ai);
            return true;
        }
        if (i == -1) {
            cb(view);
        }
        if (this.jjs.contains(ab)) {
            return true;
        }
        a(1, com_tencent_mm_protocal_c_aib, akVar);
        return false;
    }

    private static void cb(View view) {
        if (view instanceof QImageView) {
            ((QImageView) view).a(com.tencent.mm.ui.widget.QImageView.a.pee);
            ((QImageView) view).setImageResource(2130838266);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(2130838266);
        }
    }

    public final void a(Object obj, String str, int i, int i2) {
        a(obj, str, true, i, i2, -1, -1, a.jjD);
    }

    private void a(Object obj, String str, int i, int i2, int i3) {
        a(obj, str, true, i, i2, -1, -1, i3);
    }

    private void a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, int i5) {
        if (obj != null) {
            int hashCode = obj.hashCode();
            this.jje.remove(new c(null, hashCode, 0, false));
            c cVar = new c(str, hashCode, i2, z);
            this.jje.add(cVar);
            LinkedList linkedList = (LinkedList) this.jja.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.jja.put(str, linkedList);
            }
            linkedList.add(new WeakReference(cVar));
            String str2 = (String) ((View) obj).getTag(2130706432);
            if (str2 != null) {
                LinkedList linkedList2 = (LinkedList) this.jja.get(str2);
                if (linkedList2 != null) {
                    int i6 = 0;
                    while (i6 < linkedList2.size()) {
                        c cVar2 = (c) ((WeakReference) linkedList2.get(i6)).get();
                        if (cVar2 != null && cVar2.aJW == hashCode) {
                            break;
                        }
                        i6++;
                    }
                    i6 = -1;
                    if (i6 != -1) {
                        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[]{str2});
                        linkedList2.remove(i6);
                    }
                }
            }
            ((View) obj).setTag(2130706432, str);
            this.cMe.put(Integer.valueOf(hashCode), new WeakReference(obj));
            if (i != -1) {
                if (obj instanceof QFadeImageView) {
                    ((QFadeImageView) obj).setImageResource(i);
                } else if (obj instanceof ImageView) {
                    ((ImageView) obj).setImageDrawable(com.tencent.mm.bd.a.a(((ImageView) obj).getContext(), i));
                } else {
                    ((com.tencent.mm.plugin.sight.decode.a.a) obj).ag(null, !this.jiL);
                }
            }
            if (i5 == a.jjE && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
                com.tencent.mm.sdk.platformtools.k.bw((View) obj);
            } else if (str != null && str.startsWith("3")) {
                if ((obj instanceof ImageView) || (obj instanceof QFadeImageView)) {
                    com.tencent.mm.sdk.platformtools.k.h((View) obj, i3, i4);
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
                }
            }
        }
    }

    public final boolean cc(View view) {
        int hashCode = view.hashCode();
        Iterator it = this.jje.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (hashCode == cVar.aJW) {
                this.jje.remove(cVar);
                break;
            }
        }
        this.cMe.remove(Integer.valueOf(hashCode));
        return true;
    }

    private boolean aRS() {
        if (this.jjd) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            return false;
        }
        ad.aqz().postDelayed(new Runnable(this) {
            final /* synthetic */ g jju;

            {
                this.jju = r1;
            }

            public final void run() {
                if (this.jju.jjd) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
                } else if (this.jju.jjc.size() > 0) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + this.jju.jjc.size());
                    ((b) this.jju.jjc.removeLast()).l("");
                }
            }
        }, 0);
        return true;
    }

    private boolean a(final int i, final aib com_tencent_mm_protocal_c_aib, final ak akVar) {
        if (!this.jiL) {
            return false;
        }
        ad.aSr().post(new Runnable(this) {
            final /* synthetic */ g jju;

            public final void run() {
                if (!g.a(this.jju, i, com_tencent_mm_protocal_c_aib)) {
                    e eVar = new e(com_tencent_mm_protocal_c_aib);
                    eVar.jdO = i;
                    eVar.jdN = com_tencent_mm_protocal_c_aib.gID;
                    ad.aSz().a(com_tencent_mm_protocal_c_aib, 1, eVar, akVar);
                }
            }
        });
        return true;
    }

    public static boolean v(aib com_tencent_mm_protocal_c_aib) {
        String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
        if (FileOp.aR(cA + i.i(com_tencent_mm_protocal_c_aib))) {
            return true;
        }
        if (FileOp.aR(cA + i.o(com_tencent_mm_protocal_c_aib)) && !be.kS(com_tencent_mm_protocal_c_aib.gID) && com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path")) {
            return true;
        }
        return false;
    }

    public final int k(k kVar) {
        return a(kVar, null);
    }

    public final int a(k kVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || be.az(this.jji) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            com.tencent.mm.modelcontrol.c.Eg();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2, pInt3)) {
                this.jjk = 5;
            } else {
                this.jjk = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.jjl = pInt.value;
            this.jji = be.Nj();
        }
        if (this.jjl == 0 || kVar == null) {
            return this.jjk;
        }
        if (this.jjm.containsKey(Long.valueOf(kVar.field_snsId))) {
            return ((Integer) this.jjm.get(Long.valueOf(kVar.field_snsId))).intValue();
        }
        awi com_tencent_mm_protocal_c_awi = new awi();
        try {
            awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(kVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_awa.mTy == null) {
                return this.jjk;
            }
            com_tencent_mm_protocal_c_awi.az(com_tencent_mm_protocal_c_awa.mTy.mQw.lVU);
            if (com_tencent_mm_protocal_c_awi.mTL == null || com_tencent_mm_protocal_c_awi.mTL.info == null) {
                return this.jjk;
            }
            String str = com_tencent_mm_protocal_c_awi.mTL.info;
            int hashCode = str.hashCode();
            if (this.jjl == 1) {
                if (!this.jjo.containsKey(Integer.valueOf(hashCode))) {
                    this.jjo.put(Integer.valueOf(hashCode), Boolean.valueOf(aQ(str, this.jjl)));
                }
                i = ((Boolean) this.jjo.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.jjn.containsKey(Integer.valueOf(hashCode))) {
                    this.jjn.put(Integer.valueOf(hashCode), Boolean.valueOf(aQ(str, this.jjl)));
                }
                if (!((Boolean) this.jjn.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(kVar.field_snsId), Integer.valueOf(i)});
            this.jjm.put(Long.valueOf(kVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.jjk;
        }
    }

    public final int l(k kVar) {
        return b(kVar, null);
    }

    public final int b(k kVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || be.az(this.jjj) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            com.tencent.mm.modelcontrol.c.Eg();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2)) {
                this.jjp = 5;
            } else {
                this.jjp = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
            }
            this.jjq = pInt.value;
            this.jjj = be.Nj();
        }
        if (this.jjq == 0 || kVar == null) {
            return this.jjp;
        }
        if (this.jjr.containsKey(Long.valueOf(kVar.field_snsId))) {
            return ((Integer) this.jjr.get(Long.valueOf(kVar.field_snsId))).intValue();
        }
        awi com_tencent_mm_protocal_c_awi = new awi();
        try {
            awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(kVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_awa.mTy == null) {
                return this.jjp;
            }
            com_tencent_mm_protocal_c_awi.az(com_tencent_mm_protocal_c_awa.mTy.mQw.lVU);
            if (com_tencent_mm_protocal_c_awi.mTL == null || com_tencent_mm_protocal_c_awi.mTL.info == null) {
                return this.jjk;
            }
            String str = com_tencent_mm_protocal_c_awi.mTL.info;
            int hashCode = str.hashCode();
            if (this.jjq == 1) {
                if (!this.jjo.containsKey(Integer.valueOf(hashCode))) {
                    this.jjo.put(Integer.valueOf(hashCode), Boolean.valueOf(aQ(str, this.jjq)));
                }
                i = ((Boolean) this.jjo.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.jjn.containsKey(Integer.valueOf(hashCode))) {
                    this.jjn.put(Integer.valueOf(hashCode), Boolean.valueOf(aQ(str, this.jjq)));
                }
                if (!((Boolean) this.jjn.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(kVar.field_snsId), Integer.valueOf(i)});
            this.jjr.put(Long.valueOf(kVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.jjp;
        }
    }

    private static boolean aQ(String str, int i) {
        Map q = bf.q(str, "SightDownloadControl");
        if (q == null || q.isEmpty()) {
            return true;
        }
        return i == 1 ? be.getInt((String) q.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1 : be.getInt((String) q.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1;
    }

    public final boolean w(aib com_tencent_mm_protocal_c_aib) {
        if (!this.jjf.containsKey(com_tencent_mm_protocal_c_aib.gID)) {
            return false;
        }
        if (((Integer) this.jjf.get(com_tencent_mm_protocal_c_aib.gID)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean x(aib com_tencent_mm_protocal_c_aib) {
        if (this.jjf.containsKey(com_tencent_mm_protocal_c_aib.gID)) {
            return ((Integer) this.jjf.get(com_tencent_mm_protocal_c_aib.gID)).intValue() == 2;
        } else {
            return false;
        }
    }

    public final boolean y(aib com_tencent_mm_protocal_c_aib) {
        if (this.jjf.containsKey(com_tencent_mm_protocal_c_aib.gID)) {
            return ((Integer) this.jjf.get(com_tencent_mm_protocal_c_aib.gID)).intValue() == 3;
        } else {
            return false;
        }
    }

    public final void z(aib com_tencent_mm_protocal_c_aib) {
        this.jjf.put(com_tencent_mm_protocal_c_aib.gID, Integer.valueOf(1));
    }

    public final void A(aib com_tencent_mm_protocal_c_aib) {
        this.jjf.put(com_tencent_mm_protocal_c_aib.gID, Integer.valueOf(2));
    }

    public final void B(aib com_tencent_mm_protocal_c_aib) {
        this.jjf.put(com_tencent_mm_protocal_c_aib.gID, Integer.valueOf(3));
    }

    public final boolean cy(String str, String str2) {
        if (this.jjf.containsKey(str) && 3 == ((Integer) this.jjf.get(str)).intValue()) {
            this.jjf.remove(str);
        }
        String ab = i.ab(1, str);
        Iterator it = ((LinkedList) this.jja.get(ab)).iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && cVar.jjJ && ab != null && ab.equals(cVar.id)) {
                WeakReference weakReference = (WeakReference) this.cMe.get(Integer.valueOf(cVar.aJW));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[]{str, str2});
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.aOY() instanceof ah) {
                            ah ahVar = (ah) aVar.aOY();
                            if (ahVar == null) {
                                aVar.ag(str2, !this.jiL);
                            } else if (FileOp.aR(str2)) {
                                aVar.ag(str2, !this.jiL);
                                aVar.iO(ahVar.position);
                                ahVar.jzr.setVisibility(8);
                                ahVar.jzs.setVisibility(8);
                                ahVar.jzt.setVisibility(8);
                                if (this.jjf.containsKey(str) && 4 == ((Integer) this.jjf.get(str)).intValue()) {
                                    this.jjf.remove(str);
                                }
                            } else {
                                this.jjf.put(str, Integer.valueOf(4));
                                ahVar.jzr.setVisibility(8);
                                ahVar.jzs.setImageResource(2130839161);
                                ahVar.jzs.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(String str, n nVar, int i) {
        a(i + "-" + str, nVar);
        return true;
    }

    private boolean a(String str, n nVar) {
        if (!(nVar == null || str == null)) {
            this.jiY.put(str, nVar);
        }
        return true;
    }

    public final void Aj(String str) {
        b(str, null);
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, ak akVar) {
        if (!z && be.kS(str)) {
            return null;
        }
        aib a = d.a(str3, 2, str2, str2, 1, 1, "");
        i.ab(2, str3);
        Bitmap zR;
        if (str3.equals("")) {
            zR = i.zR(str);
            if (i.i(zR)) {
                return zR;
            }
            return null;
        } else if (i.i(null)) {
            return null;
        } else {
            zR = i.zR(al.cA(ad.xh(), str3) + i.k(a));
            if (!i.i(zR)) {
                zR = i.zR(str);
            }
            if (zR == null && z && !be.kS(str2)) {
                ad.aSz().a(a, 3, null, akVar);
            }
            if (i.i(zR)) {
                return zR;
            }
            return null;
        }
    }

    public static boolean a(aib com_tencent_mm_protocal_c_aib, ak akVar) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return false;
        }
        String str;
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path")) {
            str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.l(com_tencent_mm_protocal_c_aib);
        } else {
            str = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.b(com_tencent_mm_protocal_c_aib);
        }
        if (FileOp.aR(str)) {
            return true;
        }
        ad.aSz().a(com_tencent_mm_protocal_c_aib, 2, null, akVar);
        return false;
    }

    public static String C(aib com_tencent_mm_protocal_c_aib) {
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_sns_pic")) {
            return ad.xi() + com_tencent_mm_protocal_c_aib.gID;
        }
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path")) {
            return al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.l(com_tencent_mm_protocal_c_aib);
        }
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_extend_pic")) {
            return com_tencent_mm_protocal_c_aib.gID.substring(19);
        }
        return al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.b(com_tencent_mm_protocal_c_aib);
    }

    public final Bitmap a(aib com_tencent_mm_protocal_c_aib, View view, int i, boolean z, ak akVar) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return null;
        }
        String ab = i.ab(3, com_tencent_mm_protocal_c_aib.gID);
        String C = C(com_tencent_mm_protocal_c_aib);
        int i2 = -1;
        int i3 = -1;
        try {
            Options JS = com.tencent.mm.sdk.platformtools.d.JS(C);
            i2 = JS.outWidth;
            i3 = JS.outHeight;
        } catch (Exception e) {
        }
        a(view, ab, false, -1, i, i2, i3, a.jjD);
        if ((ad.aSz().jiN.containsKey(i.ac(2, com_tencent_mm_protocal_c_aib.gID)) ? 1 : null) != null) {
            return null;
        }
        Object obj;
        aj ajVar = this.jiZ;
        com.tencent.mm.plugin.sns.e.aj.b bVar = (com.tencent.mm.plugin.sns.e.aj.b) ajVar.jmW.get(ab);
        if (bVar == null) {
            obj = null;
        } else {
            ((com.tencent.mm.plugin.sns.e.aj.b) ajVar.jmW.get(ab)).aSZ();
            obj = bVar.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + ab + "  " + (weakReference == null));
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (i.i(bitmap)) {
            return bitmap;
        }
        Bitmap BI;
        if (com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_extend_pic")) {
            BI = p.BI(C);
        } else {
            BI = i.zR(C);
        }
        aj ajVar2 = this.jiZ;
        WeakReference weakReference2 = new WeakReference(BI);
        if (((com.tencent.mm.plugin.sns.e.aj.b) ajVar2.jmW.get(ab)) == null) {
            ajVar2.jmW.put(ab, new com.tencent.mm.plugin.sns.e.aj.b(ajVar2, weakReference2));
            ajVar2.aSY();
        } else {
            ((com.tencent.mm.plugin.sns.e.aj.b) ajVar2.jmW.get(ab)).aSZ();
            ((com.tencent.mm.plugin.sns.e.aj.b) ajVar2.jmW.get(ab)).obj = weakReference2;
        }
        if (i.i(BI)) {
            return BI;
        }
        if (z) {
            ad.aSz().a(com_tencent_mm_protocal_c_aib, 2, null, akVar);
        }
        return null;
    }

    public final n a(aib com_tencent_mm_protocal_c_aib, ImageView imageView, int i, ak akVar) {
        if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || com_tencent_mm_protocal_c_aib.gID.equals("")) {
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String ab = i.ab(0, com_tencent_mm_protocal_c_aib.gID);
        a((Object) imageView, ab, -1, i);
        String str = com_tencent_mm_protocal_c_aib.gID;
        n Ai = Ai(ab);
        if (i.b(Ai)) {
            return Ai;
        }
        a(0, com_tencent_mm_protocal_c_aib, akVar);
        return null;
    }

    public final void a(View view, int i, int i2, int i3) {
        a(view, null, true, -1, i3, -1, -1, a.jjD);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.bd.a.a(view.getContext(), i2));
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(2130838266);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(2130838266);
        }
    }

    public final void a(List<aib> list, View view, int i, int i2, a aVar) {
        a((List) list, view, i, i2, (ak) aVar, false);
    }

    public final void a(List<aib> list, View view, int i, int i2, a aVar, boolean z) {
        if (list != null && list.size() != 0) {
            String ab;
            n Ai;
            if (list.size() != 1) {
                ab = i.ab(0, i.bl(list));
                a(view, ab, true, -1, i, -1, -1, i2);
                Ai = Ai(ab);
                boolean b = i.b(Ai);
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LazyerImageLoader2", "set Sns GridList " + b);
                if (b) {
                    a((Object) view, ab, Ai);
                    return;
                }
                cb(view);
                if (!this.jjs.contains(ab)) {
                    WeakReference weakReference = new WeakReference(view);
                    ad.aSr().post(new AnonymousClass4(this, list, 0, aVar));
                }
            } else if (z) {
                aib com_tencent_mm_protocal_c_aib = (aib) list.get(0);
                int i3 = a.jjE;
                if (com_tencent_mm_protocal_c_aib != null && com_tencent_mm_protocal_c_aib.gID != null && !com_tencent_mm_protocal_c_aib.gID.equals("")) {
                    view.setDrawingCacheEnabled(false);
                    ab = i.ab(5, com_tencent_mm_protocal_c_aib.gID);
                    a((Object) view, ab, -1, i, i3);
                    String str = com_tencent_mm_protocal_c_aib.gID;
                    Ai = Ai(ab);
                    if (i.b(Ai)) {
                        a((Object) view, ab, Ai);
                        return;
                    }
                    cb(view);
                    if (!this.jjs.contains(ab)) {
                        a(5, com_tencent_mm_protocal_c_aib, (ak) aVar);
                    }
                }
            } else {
                b((aib) list.get(0), view, i, aVar);
            }
        }
    }

    protected final void b(String str, n nVar) {
        if (!i.b(nVar)) {
            n nVar2 = (n) this.jiY.get(str);
            if (nVar2 == null || nVar2.isRecycled()) {
                this.jiY.remove(str);
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (i.b(nVar)) {
            if (!(this.jiY == null || nVar == null || str == null)) {
                this.jiY.put(str, nVar);
            }
            LinkedList linkedList = (LinkedList) this.jja.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((WeakReference) it.next()).get();
                    if (cVar != null && cVar.jjJ && str != null && str.equals(cVar.id)) {
                        WeakReference weakReference = (WeakReference) this.cMe.get(Integer.valueOf(cVar.aJW));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.jjh != null && (qFadeImageView instanceof TagImageView)) {
                                        int i = ((TagImageView) qFadeImageView).position;
                                        if (!(i == -1 || this.jjh.qL(i))) {
                                        }
                                    }
                                }
                                if (!i.b(nVar) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(nVar == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(i.b(nVar));
                                    com.tencent.mm.sdk.platformtools.v.d(str2, str3, objArr);
                                } else {
                                    a(obj, str, nVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void aRT() {
        aRR();
        this.jji = 0;
        this.jjj = 0;
        this.jjc.clear();
        this.jjd = false;
    }
}
