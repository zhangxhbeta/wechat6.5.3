package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ar extends c<k> {
    private boolean bcR = false;
    private String fHQ = "";
    List<k> gKQ = new ArrayList();
    private int jDn = 0;
    private int jDo = 0;
    private b jSA;
    private a jSB;
    private boolean jSz = false;
    private Comparator<k> jiD = new Comparator<k>(this) {
        final /* synthetic */ ar jSC;

        {
            this.jSC = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            k kVar = (k) obj;
            k kVar2 = (k) obj2;
            if (kVar.jBI == -1) {
                return -1;
            }
            if (kVar2.jBI == -1) {
                return 1;
            }
            if (kVar.field_head != kVar2.field_head) {
                return kVar2.field_head - kVar.field_head;
            }
            return kVar.field_createTime != kVar2.field_createTime ? kVar2.field_createTime - kVar.field_createTime : 0;
        }
    };
    private String userName = "";

    class a {
        final /* synthetic */ ar jSC;
        public int jSD = -1;
        public int jSE = -1;
        public boolean jSF = false;
        public int jSG = -1;
        int jSH = 0;
        public String jSI = "";
        public String jSJ = "";
        public String jSK = "";
        public int jSL = -1;
        int jSM = 0;
        public boolean jSN = false;
        public int jSO = -1;
        public boolean jSP = false;
        public int jSQ = -1;
        int jSR = 0;

        a(ar arVar) {
            this.jSC = arVar;
        }

        public static boolean rd(int i) {
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case am.CTRL_INDEX /*15*/:
                case 18:
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface b {
        void a(List<k> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void aXo();
    }

    public ar(b bVar, String str, boolean z) {
        this.jSA = bVar;
        this.userName = str;
        this.bcR = z;
    }

    public final void bu(List<k> list) {
        if (this.jSA != null) {
            if (list != null) {
                c(true, list);
            }
            this.jSA.aXo();
        }
    }

    public final List<k> aVk() {
        v.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(ah.a(this.userName, this.bcR, this.fHQ, this.jSz).size())});
        return ah.a(this.userName, this.bcR, this.fHQ, this.jSz);
    }

    public final void aXp() {
        Collections.sort(this.gKQ, this.jiD);
    }

    final void aXq() {
        c(false, this.gKQ);
    }

    public final void c(String str, boolean z, boolean z2) {
        v.d("MicroMsg.SnsSelfHelper", "limitSeq " + str);
        this.fHQ = str;
        this.jSz = z;
        gn(z2);
    }

    private void c(boolean z, List<k> list) {
        this.jSB = new a(this);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (z && this.bcR) {
            k kVar = new k((byte) 0);
            kVar.field_snsId = 0;
            kVar.jBI = -1;
            kVar.fw((int) (System.currentTimeMillis() / 1000));
            list.add(0, kVar);
        }
        int size = list.size();
        v.d("MicroMsg.SnsSelfHelper", "initFixType " + size);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5;
            int i6;
            a aVar = this.jSB;
            aVar.jSE = -1;
            aVar.jSO = -1;
            aVar.jSD = -1;
            aVar.jSI = "";
            aVar.jSJ = "";
            aVar.jSK = "";
            aVar.jSN = false;
            aVar.jSF = false;
            aVar.jSP = false;
            aVar.jSQ = -1;
            aVar.jSG = -1;
            aVar.jSL = -1;
            aVar.jSM = 0;
            aVar.jSH = 0;
            aVar.jSR = 0;
            if (this.bcR && i3 == 0) {
                i5 = 1;
            } else {
                azr aUp;
                if (i3 + 1 < size) {
                    kVar = (k) list.get(i3 + 1);
                    this.jSB.jSE = kVar.field_head;
                    aUp = kVar.aUp();
                    this.jSB.jSI = aUp.mWn;
                    this.jSB.jSF = ah.H(kVar.field_localPrivate, this.bcR);
                    this.jSB.jSG = kVar.field_type;
                    if (aUp.mWq != null) {
                        this.jSB.jSH = aUp.mWq.mom.size();
                    } else {
                        this.jSB.jSH = 0;
                    }
                }
                if (i3 + 2 < size) {
                    kVar = (k) list.get(i3 + 2);
                    this.jSB.jSO = kVar.field_head;
                    aUp = kVar.aUp();
                    this.jSB.jSJ = aUp.mWn;
                    this.jSB.jSP = ah.H(kVar.field_localPrivate, this.bcR);
                    this.jSB.jSQ = kVar.field_type;
                    if (aUp.mWq != null) {
                        this.jSB.jSR = aUp.mWq.mom.size();
                    } else {
                        this.jSB.jSR = 0;
                    }
                }
                kVar = (k) list.get(i3);
                this.jSB.jSD = kVar.field_head;
                aUp = kVar.aUp();
                this.jSB.jSK = aUp.mWn;
                this.jSB.jSL = kVar.field_type;
                this.jSB.jSN = ah.H(kVar.field_localPrivate, this.bcR);
                if (aUp.mWq != null) {
                    this.jSB.jSM = aUp.mWq.mom.size();
                } else {
                    this.jSB.jSM = 0;
                }
                aVar = this.jSB;
                Object obj = aVar.jSL == 2 ? 1 : aVar.jSE == -1 ? 1 : aVar.jSL != aVar.jSG ? 1 : a.rd(aVar.jSL) ? 1 : a.rd(aVar.jSG) ? 1 : (aVar.jSM > 1 || aVar.jSH > 1) ? 1 : (aVar.jSK == null || aVar.jSK.equals("")) ? (aVar.jSI == null || aVar.jSI.equals("")) ? aVar.jSD != aVar.jSE ? 1 : null : 1 : 1;
                if (obj != null) {
                    i5 = 1;
                } else {
                    aVar = this.jSB;
                    obj = aVar.jSO == -1 ? 1 : aVar.jSG != aVar.jSQ ? 1 : a.rd(aVar.jSQ) ? 1 : aVar.jSR > 1 ? 1 : (aVar.jSJ == null || aVar.jSJ.equals("")) ? aVar.jSE != aVar.jSO ? 1 : null : 1;
                    i5 = obj != null ? 2 : 3;
                }
            }
            hashMap.put(Integer.valueOf(i4), Integer.valueOf(i2));
            hashMap2.put(Integer.valueOf(i4), Integer.valueOf(i5));
            i2 += i5;
            hashMap3.put(Integer.valueOf(i4), Integer.valueOf(i));
            if (this.bcR && i3 == 0) {
                i6 = 0;
            } else {
                i6 = 0;
                if (i5 > 0 && this.jSB.jSL == 1) {
                    i6 = 1;
                }
                if (i5 >= 2 && this.jSB.jSG == 1) {
                    i6++;
                }
                if (i5 >= 3 && this.jSB.jSQ == 1) {
                    i6++;
                }
            }
            i += i6;
            i3 += i5;
            i4++;
        }
        this.jDn = i4;
        this.jDo = list.size();
        v.d("MicroMsg.SnsSelfHelper", "icount " + this.jDn);
        this.gKQ = list;
        i.x("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.jSA.a(this.gKQ, hashMap, hashMap2, hashMap3, this.jDo, this.jDn);
    }
}
