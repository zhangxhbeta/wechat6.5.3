package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c extends com.tencent.mm.plugin.brandservice.ui.base.b {
    protected int cVh;
    protected String exS;
    protected int exU;
    private List<a> exX = new ArrayList();
    private int exY;
    private boolean exZ;
    protected boolean eya;
    protected boolean eyb;
    int eyc;
    protected long[] eyd;
    protected b eye;

    protected static class a {
        public long aXq;
        public int count;
        public int eyf;
        public List<String> eyg;
        public List<id> eyh;
        public boolean eyi;
        public boolean eyj;
        public List<hy> eyk;

        protected a() {
        }
    }

    public interface b {
        void a(c cVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar, int i, String str, int i2, int i3);
    }

    public c(Context context) {
        super(context);
        h(true, true);
        this.exZ = true;
        c(1);
    }

    public void c(String str, List<hy> list) {
        this.exX.clear();
        this.ezI.clear();
        ad.o(this.ezJ);
        this.exY = 0;
        this.exS = str;
        if (list != null) {
            this.eyc = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                hy hyVar = (hy) list.get(i);
                if (!(hyVar == null || hyVar.miT == null || hyVar.miT.size() <= 0)) {
                    a a = a(hyVar);
                    this.exY += a(a);
                    this.exX.add(a);
                    v.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[]{Long.valueOf(a.aXq), Integer.valueOf(a.count), Integer.valueOf(this.exY)});
                }
            }
            Yp();
        }
        ad.o(this.ezJ);
    }

    private a a(hy hyVar) {
        a aVar = new a();
        aVar.eyk = new LinkedList();
        aVar.eyk.add(hyVar);
        aVar.aXq = hyVar.miQ;
        aVar.count = hyVar.miT.size();
        aVar.eyf = hyVar.miR;
        aVar.eyh = new LinkedList();
        aVar.eyh.addAll(hyVar.miT);
        aVar.eyg = hyVar.miS;
        aVar.eyi = this.eyb;
        boolean z = this.eya && aVar.eyf != 0;
        aVar.eyj = z;
        return aVar;
    }

    public void a(hy hyVar, boolean z) {
        if ((this.exZ && hyVar == null) || hyVar.miT == null) {
            v.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            return;
        }
        if (isEmpty()) {
            this.eyc = (int) (System.currentTimeMillis() / 1000);
        }
        a aM = aM(hyVar.miQ);
        if (aM != null) {
            if (aM.eyh == null) {
                aM.eyh = new LinkedList();
            }
            aM.eyh.addAll(hyVar.miT);
            if (aM.eyk == null) {
                aM.eyk = new LinkedList();
            }
            aM.eyk.add(hyVar);
            aM.count += hyVar.miT.size();
            this.exY += hyVar.miT.size();
        } else if (z) {
            this.exX.add(a(hyVar));
            Yp();
        } else {
            v.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[]{Long.valueOf(hyVar.miQ)});
            return;
        }
        ad.o(this.ezJ);
    }

    final a aM(long j) {
        int i = 0;
        while (i < this.exX.size()) {
            if (((a) this.exX.get(i)).aXq == j) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return (a) this.exX.get(i);
        }
        return null;
    }

    protected final a iG(int i) {
        if (i >= 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.exX.size(); i3++) {
                a aVar = (a) this.exX.get(i3);
                i2 += a(aVar);
                if (i < i2) {
                    return aVar;
                }
            }
        }
        return null;
    }

    protected final hy iH(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.exX.size()) {
                a aVar = (a) this.exX.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.eyi ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.eyk.size()) {
                        hy hyVar = (hy) aVar.eyk.get(i2);
                        i4 += hyVar.miT.size();
                        if (i < i4) {
                            return hyVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.eyi ? 1 : 0) + aVar.count;
        if (!aVar.eyj) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void Yp() {
        boolean z = true;
        synchronized (this) {
            Map hashMap = new HashMap();
            for (int i = 0; i < this.exX.size(); i++) {
                a aVar = (a) this.exX.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.aXq), aVar);
                }
            }
            this.exX.clear();
            this.exY = 0;
            for (long valueOf : this.eyd) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.exX.add(aVar);
                    this.exY = a(aVar) + this.exY;
                }
            }
            if (this.exX.size() > 0) {
                aVar = (a) this.exX.get(this.exX.size() - 1);
                if (aVar.eyj == this.exZ) {
                    this.exY = (aVar.eyj ? -1 : 1) + this.exY;
                    if (this.exZ) {
                        z = false;
                    }
                    aVar.eyj = z;
                }
            }
            hashMap.clear();
        }
    }

    public final void h(boolean z, boolean z2) {
        this.eyb = z;
        this.eya = z2;
    }

    public final void iI(int i) {
        this.cVh = i;
    }

    public final void iJ(int i) {
        this.exU = i;
    }

    public final void c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.eyd = jArr;
        }
    }

    public int getCount() {
        return this.exY;
    }

    public void Yq() {
        c(null, null);
        this.eyc = 0;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final com.tencent.mm.plugin.brandservice.ui.base.a iK(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.exX.size(); i4++) {
            a aVar = (a) this.exX.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.eyi && i == i3 - a) {
                hy hyVar = aVar.eyk.size() == 0 ? null : (hy) aVar.eyk.get(0);
                if (hyVar != null) {
                    return new d(hyVar.aXz);
                }
            } else if (aVar.eyj && i == i3 - 1) {
                return new e(null, aVar.aXq, aVar.count, this.exS);
            } else {
                if (i < i3) {
                    i4 = (i - i3) + aVar.count;
                    if (aVar.eyj) {
                        i2 = 1;
                    }
                    i2 += i4;
                    id idVar = (id) aVar.eyh.get(i2);
                    long j = aVar.aXq;
                    b bVar = this.eye;
                    if (idVar == null) {
                        v.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                        return null;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar2;
                    if (j == 1) {
                        v.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                        aVar2 = new a(idVar);
                    } else {
                        aVar2 = j == 4 ? new g(idVar) : j == 1073741824 ? new g(idVar) : new g(idVar);
                    }
                    if (!(aVar2 instanceof com.tencent.mm.plugin.brandservice.ui.base.c)) {
                        return aVar2;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.c cVar = (com.tencent.mm.plugin.brandservice.ui.base.c) aVar2;
                    cVar.iN(i2);
                    cVar.iO(i);
                    cVar.a(bVar);
                    return aVar2;
                }
            }
        }
        return new g(null);
    }

    protected Object[] iL(int i) {
        a iG = iG(i);
        hy iH = iH(i);
        if (iH != null) {
            Object obj = iH.miU;
        } else {
            String str = "";
        }
        if (iG == null) {
            return null;
        }
        return new Object[]{this, iG.eyg, Integer.valueOf(this.exU), obj};
    }

    public final void a(b bVar) {
        this.eye = bVar;
    }
}
