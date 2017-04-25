package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class p extends m {
    private String bkC;
    private String[] cUQ;
    private int count = 0;
    private Comparator<h> eAz = new b();
    private ac handler = new ac(Looper.getMainLooper());
    private List<h> hjK = null;
    private l lcS;
    private int oEL = Integer.MAX_VALUE;
    private int oEM = Integer.MAX_VALUE;
    private List<h> oHA = null;
    private List<Integer> oHB;
    private Comparator<h> oHC = new com.tencent.mm.modelsearch.p.a();
    private k oHD = new k(this) {
        final /* synthetic */ p oHF;

        {
            this.oHF = r1;
        }

        public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
            if (this.oHF.lcS != null && this.oHF.lcS.equals(lVar)) {
                this.oHF.bHO();
                this.oHF.cUQ = strArr;
                p.a(this.oHF, (List) list);
                this.oHF.oHy = list;
                this.oHF.d(str, p.c(this.oHF), true);
            }
        }

        public final void jI(String str) {
            if (str.equals(this.oHF.bkC)) {
                p.c(this.oHF);
            }
        }
    };
    private k oHE = new k(this) {
        final /* synthetic */ p oHF;

        {
            this.oHF = r1;
        }

        public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
            if (this.oHF.lcS != null && this.oHF.lcS.equals(lVar)) {
                this.oHF.cUQ = strArr;
                p.a(this.oHF, (List) list);
                if (list.size() > 0) {
                    switch (((h) list.get(0)).type) {
                        case 131072:
                            this.oHF.hjK = list;
                            break;
                        case 131075:
                            this.oHF.oHz = list;
                            break;
                        case 131076:
                            this.oHF.oHA = list;
                            break;
                        default:
                            v.i("MicroMsg.MMSearchContactAdapter", "not support search");
                            break;
                    }
                }
                this.oHF.d(str, p.c(this.oHF), true);
            }
        }

        public final void jI(String str) {
            if (str.equals(this.oHF.bkC)) {
                p.c(this.oHF);
            }
        }
    };
    private List<String> oHq;
    private a oHr;
    private int oHs = Integer.MAX_VALUE;
    private int oHt = Integer.MAX_VALUE;
    private boolean oHu = true;
    private int oHv = Integer.MAX_VALUE;
    private boolean oHw = true;
    private int oHx = Integer.MAX_VALUE;
    private List<h> oHy = null;
    private List<h> oHz = null;

    public interface a {
        void n(String str, int i, boolean z);
    }

    static /* synthetic */ void a(p pVar, List list) {
        if (pVar.oHq != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                h hVar = (h) list.get(size);
                if (!pVar.oHq.contains(hVar.cWv)) {
                    int i = hVar.type;
                    Object obj = (i == 131072 || i == 131075 || i == 131076) ? 1 : null;
                    if (obj != null) {
                    }
                }
                list.remove(size);
            }
        }
    }

    static /* synthetic */ boolean c(p pVar) {
        if (pVar.oHB.size() <= 0) {
            return true;
        }
        HashSet hashSet = new HashSet();
        if (pVar.oHy != null) {
            for (h hVar : pVar.oHy) {
                hashSet.add(hVar.cWv);
            }
        }
        int intValue = ((Integer) pVar.oHB.remove(0)).intValue();
        if (intValue == 131075) {
            pVar.lcS = com.tencent.mm.modelsearch.p.a(pVar.bkC, -1, hashSet, pVar.oHE, pVar.handler);
        } else if (intValue == 131076) {
            pVar.lcS = com.tencent.mm.modelsearch.p.a(pVar.bkC, new int[]{intValue}, null, -1, hashSet, pVar.eAz, pVar.oHE, pVar.handler);
        } else {
            pVar.lcS = com.tencent.mm.modelsearch.p.a(pVar.bkC, new int[]{intValue}, -1, hashSet, pVar.eAz, pVar.oHE, pVar.handler);
        }
        return false;
    }

    public p(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        this.oHq = list;
        this.oHB = new ArrayList();
        v.i("MicroMsg.MMSearchContactAdapter", "Create!");
        NH();
    }

    public void a(a aVar) {
        this.oHr = aVar;
    }

    public void aR(String str, boolean z) {
        if (this.oHr != null) {
            this.oHr.n(str, getCount(), z);
        }
    }

    public void a(String str, int[] iArr, boolean z) {
        clearTask();
        this.bkC = str;
        this.oHB.clear();
        for (int valueOf : iArr) {
            this.oHB.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        v.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.bkC);
        this.lcS = com.tencent.mm.modelsearch.p.a(this.bkC, iArr, this.oHD, this.handler, 1, hashSet);
    }

    private void clearTask() {
        if (this.lcS != null) {
            com.tencent.mm.modelsearch.p.a(this.lcS);
            this.lcS = null;
        }
    }

    private void bHO() {
        this.oHs = Integer.MAX_VALUE;
        this.oHt = Integer.MAX_VALUE;
        this.oHu = true;
        this.oHv = Integer.MAX_VALUE;
        this.oEL = Integer.MAX_VALUE;
        this.oHw = true;
        this.oHx = Integer.MAX_VALUE;
        this.oEM = Integer.MAX_VALUE;
        this.oHy = null;
        this.hjK = null;
        this.oHz = null;
        this.oHA = null;
        this.cUQ = null;
        clearCache();
        notifyDataSetChanged();
    }

    final void NH() {
        v.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.bkC = null;
        bHO();
        clearTask();
        clearCache();
    }

    private void d(String str, boolean z, boolean z2) {
        int cD = cD(this.oHy);
        int cD2 = cD(this.hjK);
        int cD3 = cD(this.oHz);
        int cD4 = cD(this.oHA);
        if (cD > 0) {
            this.oHs = 0;
            cD = (cD + 1) + 0;
        } else {
            this.oHs = Integer.MAX_VALUE;
            cD = 0;
        }
        if (cD2 > 0) {
            this.oHt = cD;
            if (cD2 <= 3 || (cD3 <= 0 && cD4 <= 0)) {
                this.oHv = Integer.MAX_VALUE;
                cD += cD2 + 1;
            } else if (this.oHu) {
                cD += 4;
                this.oHv = cD;
                cD++;
            } else {
                cD += cD2 + 1;
                this.oHv = cD;
                cD++;
            }
        } else {
            this.oHt = Integer.MAX_VALUE;
        }
        if (cD3 > 0) {
            this.oEL = cD;
            if (cD3 <= 3 || cD4 <= 0) {
                this.oHx = Integer.MAX_VALUE;
                cD += cD3 + 1;
            } else if (this.oHw) {
                cD += 4;
                this.oHx = cD;
                cD++;
            } else {
                cD += cD3 + 1;
                this.oHx = cD;
                cD++;
            }
        } else {
            this.oEL = Integer.MAX_VALUE;
        }
        if (cD4 > 0) {
            this.oEM = cD;
            cD += cD4 + 1;
        } else {
            this.oEM = Integer.MAX_VALUE;
        }
        v.i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(cD));
        this.count = cD;
        if (z2) {
            aR(str, z);
        }
        clearCache();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.count;
    }

    private static int cD(List<? extends Object> list) {
        return list == null ? 0 : list.size();
    }

    public com.tencent.mm.ui.contact.a.a gK(int i) {
        com.tencent.mm.ui.contact.a.a dm;
        if (i == this.oHs) {
            dm = dm(2131234828, i);
        } else if (i == this.oHt) {
            dm = dm(2131234813, i);
        } else if (i == this.oEL) {
            dm = dm(2131234812, i);
        } else if (i == this.oEM) {
            dm = dm(2131234811, i);
        } else if (i == this.oHv) {
            dm = m(2131234813, i, this.oHu);
        } else if (i == this.oHx) {
            dm = m(2131234812, i, this.oHw);
        } else if (i > this.oEM) {
            r2 = (i - this.oEM) - 1;
            r1 = new d(i);
            r1.eAt = (h) this.oHA.get(r2);
            r1.cUQ = this.cUQ;
            r1.oHa = aQk();
            r1.oJi = true;
            r1.oJg = r2 + 1;
            r1.dp(r1.eAt.type, r1.eAt.cWt);
            dm = r1;
        } else if (i > this.oEL) {
            r2 = (i - this.oEL) - 1;
            r1 = new c(i);
            r1.eAt = (h) this.oHz.get(r2);
            r1.cUQ = this.cUQ;
            r1.oHa = aQk();
            r1.oJi = true;
            r1.oJg = r2 + 1;
            r1.dp(r1.eAt.type, r1.eAt.cWt);
            dm = r1;
        } else if (i > this.oHt) {
            r2 = (i - this.oHt) - 1;
            r1 = new d(i);
            r1.eAt = (h) this.hjK.get(r2);
            r1.cUQ = this.cUQ;
            r1.oHa = aQk();
            r1.oJi = true;
            r1.oJg = r2 + 1;
            r1.dp(r1.eAt.type, r1.eAt.cWt);
            dm = r1;
        } else if (i > this.oHs) {
            r2 = (i - this.oHs) - 1;
            h hVar = (h) this.oHy.get(r2);
            if (hVar.type == 131072 || hVar.type == 131076) {
                r1 = new d(i);
                r1.eAt = hVar;
                r1.cUQ = this.cUQ;
                r1.oHa = aQk();
                r1.oJh = true;
                r1.oJi = true;
                r1.oJg = r2 + 1;
                r1.dp(r1.eAt.type, r1.eAt.cWt);
                dm = r1;
            } else if (hVar.type == 131075) {
                r1 = new c(i);
                r1.eAt = hVar;
                r1.cUQ = this.cUQ;
                r1.oHa = aQk();
                r1.oJh = true;
                r1.oJi = true;
                r1.oJg = r2 + 1;
                r1.dp(r1.eAt.type, r1.eAt.cWt);
                dm = r1;
            } else {
                v.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(hVar.type));
                dm = null;
            }
        } else {
            v.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i));
            dm = null;
        }
        if (dm != null) {
            dm.bkC = this.bkC;
            dm.scene = this.scene;
        }
        return dm;
    }

    private static com.tencent.mm.ui.contact.a.a m(int i, int i2, boolean z) {
        com.tencent.mm.ui.contact.a.a gVar = new g(i2);
        gVar.kCd = i;
        gVar.oJB = z;
        return gVar;
    }

    private com.tencent.mm.ui.contact.a.a dm(int i, int i2) {
        com.tencent.mm.ui.contact.a.a fVar = new f(i2);
        fVar.oJx = this.oGZ.getActivity().getResources().getString(i);
        return fVar;
    }

    public void finish() {
        super.finish();
        v.i("MicroMsg.MMSearchContactAdapter", "finish!");
        NH();
    }

    protected boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.oHs, this.oHt, this.oEL, this.oEM};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean xT(int i) {
        int headerViewsCount = i - this.oGZ.aQr().getHeaderViewsCount();
        if (headerViewsCount == this.oHv) {
            if (this.oHu) {
                headerViewsCount = this.oGZ.aQr().getSelectedItemPosition();
                this.oHu = false;
                d(this.bkC, true, false);
                this.oGZ.aQr().setSelection(headerViewsCount);
                return true;
            }
            this.oHu = true;
            d(this.bkC, true, false);
            this.oGZ.aQr().setSelection(this.oHv);
            return true;
        } else if (headerViewsCount != this.oHx) {
            return false;
        } else {
            if (this.oHw) {
                headerViewsCount = this.oGZ.aQr().getSelectedItemPosition();
                this.oHw = false;
                d(this.bkC, true, false);
                this.oGZ.aQr().setSelection(headerViewsCount);
                return true;
            }
            this.oHw = true;
            d(this.bkC, true, false);
            this.oGZ.aQr().setSelection(this.oHx);
            return true;
        }
    }
}
