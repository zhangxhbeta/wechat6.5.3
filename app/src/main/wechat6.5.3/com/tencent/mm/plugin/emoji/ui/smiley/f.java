package com.tencent.mm.plugin.emoji.ui.smiley;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
    private final String TAG;
    int Wj;
    private Context aHq;
    int cVh;
    int flP;
    int flQ;
    int flR;
    int flS;
    int flT;
    int flU;
    int flV;
    int flW;
    private int flX;
    int flY;
    int flZ;
    int flz;
    int fma;
    int fmb;
    int fmc;
    int fmd;
    int fme;
    int fmf;
    String fmg;
    String fmh;
    int fmi;
    boolean fmj;
    boolean fmk;
    boolean fml;
    boolean fmm;
    boolean fmn;
    boolean fmo;
    boolean fmp;
    boolean fmq;
    public int[] fmr;
    public boolean fms;
    public boolean fmt;
    ArrayList<d> fmu;
    c fmv;
    volatile boolean fmw;

    public enum a {
        RECOMMEND,
        DEFAULT,
        EMOJI
    }

    public f() {
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.flZ = 0;
        this.fma = 0;
        this.Wj = 0;
        this.fmf = 0;
        this.fmh = "";
        this.fmi = 0;
        this.fmp = false;
        this.fmq = false;
        this.fmu = new ArrayList();
        this.fmw = false;
        this.aHq = aa.getContext();
        this.flQ = this.aHq.getResources().getDimensionPixelSize(2131493441);
        this.flP = this.aHq.getResources().getDimensionPixelSize(2131493443);
        this.flR = this.aHq.getResources().getDimensionPixelSize(2131493442);
        this.flW = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 48);
        this.flX = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 43);
        this.flT = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 86);
        this.flU = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 80);
        this.flV = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 65);
        this.flS = com.tencent.mm.bd.a.N(this.aHq, 2131492962);
        this.fme = com.tencent.mm.bd.a.fromDPToPix(this.aHq, 6);
        this.fmh = "TAG_DEFAULT_TAB";
        this.fmi = 0;
        this.flz = com.tencent.mm.bd.a.N(this.aHq, 2131493575);
        this.flY = com.tencent.mm.bd.a.N(this.aHq, 2131492962);
        ahH();
    }

    public static boolean ahD() {
        boolean booleanValue;
        boolean booleanValue2;
        Exception e;
        try {
            ak.yW();
            booleanValue = ((Boolean) com.tencent.mm.model.c.vf().get(208913, Boolean.valueOf(false))).booleanValue();
            try {
                ak.yW();
                booleanValue2 = ((Boolean) com.tencent.mm.model.c.vf().get(208899, Boolean.valueOf(false))).booleanValue();
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
                booleanValue2 = false;
                if (!booleanValue2) {
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            booleanValue = false;
            v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            booleanValue2 = false;
            if (booleanValue2) {
            }
            return true;
        }
        if (booleanValue2 || r3) {
            return true;
        }
        return false;
    }

    public static boolean ahE() {
        boolean ax;
        boolean ax2;
        Exception e;
        try {
            ax = com.tencent.mm.p.c.us().ax(262147, 266244);
            try {
                ax2 = com.tencent.mm.p.c.us().ax(262149, 266244);
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
                ax2 = false;
                if (!ax) {
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            ax = false;
            v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            ax2 = false;
            if (ax) {
            }
            return true;
        }
        if (ax || r2) {
            return true;
        }
        return false;
    }

    public final int rN(String str) {
        if ("TAG_DEFAULT_TAB".equals(str)) {
            return this.flW;
        }
        return this.flT;
    }

    public final void jY(int i) {
        this.fmc = i;
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.fmc)});
    }

    public final int ahF() {
        if (this.fmd <= 1) {
            this.fmd = ahP()[0];
        }
        return this.fmd;
    }

    public final void rO(String str) {
        if (!be.kS(str)) {
            this.fmh = str;
        }
    }

    public final void ahG() {
        if (!be.kS(this.fmh) && !this.fmj) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[]{this.fmh, Integer.valueOf(this.fmi)});
            ak.yW();
            com.tencent.mm.model.c.vf().set(-29414086, this.fmh);
            ak.yW();
            com.tencent.mm.model.c.vf().set(-29414083, Integer.valueOf(this.fmi));
        }
    }

    public final void ahH() {
        if (!this.fmj) {
            ak.yW();
            this.fmh = (String) com.tencent.mm.model.c.vf().get(-29414086, "TAG_DEFAULT_TAB");
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(-29414083, null);
            if (obj == null || !(obj instanceof Integer)) {
                this.fmi = 0;
            } else {
                this.fmi = ((Integer) obj).intValue();
            }
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[]{this.fmh, Integer.valueOf(this.fmi)});
        } else if (!this.fmh.equals("TAG_DEFAULT_TAB")) {
            this.fmh = "TAG_DEFAULT_TAB";
            this.fmi = 0;
        }
    }

    public static com.tencent.mm.storage.a.a ahI() {
        com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
        aVar.field_productID = "TAG_DEFAULT_TAB";
        return aVar;
    }

    public static com.tencent.mm.storage.a.a ahJ() {
        com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
        aVar.field_productID = String.valueOf(com.tencent.mm.storage.a.a.nwK);
        return aVar;
    }

    public static boolean a(com.tencent.mm.storage.a.a aVar) {
        return aVar != null && aVar.field_packStatus == 1;
    }

    public final boolean ahK() {
        ak.yW();
        return ((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue() && !this.fmo;
    }

    public final d rP(String str) {
        if (this.fmu == null || str == null) {
            v.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            return null;
        }
        Iterator it = this.fmu.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar == null) {
                v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (dVar.fdU == null) {
                v.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (dVar.fdU.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public final d jZ(int i) {
        if (this.fmu == null) {
            return null;
        }
        return (d) this.fmu.get(ka(i));
    }

    public final int ka(int i) {
        if (this.fmr == null || i >= this.fmr.length || i <= 0) {
            return 0;
        }
        return this.fmr[i];
    }

    public final int ahL() {
        String str = this.fmh;
        if (this.fmu != null) {
            for (int i = 0; i < this.fmu.size(); i++) {
                d dVar = (d) this.fmu.get(i);
                if (dVar != null && dVar.fdU.equals(str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public final d ahM() {
        return rP(this.fmh);
    }

    public final void ahN() {
        this.fmf = 0;
        if (this.fmu != null) {
            d dVar;
            Iterator it = this.fmu.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.fmf = dVar.aht() + this.fmf;
            }
            if (this.fmu != null) {
                try {
                    this.fmr = new int[this.fmf];
                    int i = 0;
                    int i2 = 0;
                    loop1:
                    while (i < this.fmu.size()) {
                        dVar = (d) this.fmu.get(i);
                        int i3 = i2;
                        i2 = 0;
                        while (i2 < dVar.aht()) {
                            if (i3 >= this.fmf) {
                                break loop1;
                            }
                            int i4 = i3 + 1;
                            this.fmr[i3] = i;
                            i2++;
                            i3 = i4;
                        }
                        i++;
                        i2 = i3;
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
                }
            }
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[]{Integer.valueOf(this.fmf)});
        }
    }

    public final int rQ(String str) {
        int i = 4;
        if (be.kS(str)) {
            return 0;
        }
        if (str.equals("TAG_DEFAULT_TAB")) {
            if (ahO()) {
                return 7;
            }
            return ahF() / this.flX;
        } else if (this.fmc <= 0) {
            return 0;
        } else {
            if (str.equals("TAG_STORE_TAB")) {
                return 3;
            }
            int ahF = ahF() / this.flU;
            if (!ahO()) {
                i = ahF;
            } else if (ahF <= 4) {
                i = ahF;
            }
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[]{Integer.valueOf(i)});
            return i;
        }
    }

    public final int ar(String str, int i) {
        return (this.fmc - (rN(str) * i)) / (i + 1);
    }

    public final boolean ahO() {
        if (this.Wj == 0) {
            int[] ahP = ahP();
            if (ahP[0] < ahP[1]) {
                this.Wj = 1;
            } else {
                this.Wj = 2;
            }
        }
        return this.Wj == 1;
    }

    private int[] ahP() {
        int[] iArr = new int[2];
        if (this.aHq instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.aHq).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.aHq.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public final void ahQ() {
        if (this.fmv != null) {
            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.c.a.nhr.f(this.fmv);
            this.fmv = null;
        }
    }

    public final int getColumnWidth() {
        int i = 4;
        if (this.flZ == 0) {
            int ahF = ahF() / this.flU;
            if (!ahO()) {
                i = ahF;
            } else if (ahF <= 4) {
                i = ahF;
            }
            this.flZ = ahF() / i;
        }
        return this.flZ;
    }
}
