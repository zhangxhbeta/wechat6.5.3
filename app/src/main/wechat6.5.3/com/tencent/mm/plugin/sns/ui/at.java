package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.i.a;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.ak;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.widget.c;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.vending.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class at extends b<av, k> {
    private boolean DEBUG = false;
    aa cvg;
    volatile String fHQ = "";
    volatile String jJv = "";
    String jUP;
    as jWb;
    private int jWc = ((int) (System.currentTimeMillis() / 1000));
    private a jWd;
    private boolean jWe = false;
    volatile boolean jWf = false;
    protected HashMap<String, String> jWg = new HashMap();
    public HashMap<String, Boolean> jWh = new HashMap();
    private String jWi = "";
    private String jWj = "";
    Context mContext;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (k) obj;
        if (obj == null) {
            obj = new k();
        }
        obj.b(cursor);
        return obj;
    }

    protected final /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        avc();
        this.Ay = cursor;
    }

    public final /* synthetic */ Object rh(int i) {
        return rg(i);
    }

    public at() {
        super(new k());
        bKw();
    }

    public final void aXn() {
        long j;
        looperCheckForVending();
        if (this.mCount == 0) {
            j = 0;
        } else {
            k kVar;
            int i = this.mCount - 1;
            int i2 = 0;
            while (true) {
                kVar = (k) getItem(i);
                if (!kVar.qC(32) && kVar.field_snsId != 0) {
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            v.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[]{Long.valueOf(kVar.field_snsId), kVar.field_stringSeq});
            j = r4;
        }
        this.jWf = true;
        this.fHQ = k(j, this.fHQ);
    }

    String k(long j, String str) {
        v.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", new Object[]{Integer.valueOf(ad.aSu().aTa()), str});
        String cF = i.cF(ad.aSE().d(j, str.equals("") ? ad.aSu().aTa() / 2 : ad.aSu().aTa(), false));
        String str2 = this.jJv;
        if (!str2.equals("") && cF.compareTo(str2) >= 0) {
            cF = str2;
        }
        pu aUA = ad.aSG().Bu("@__weixintimtline").aUA();
        if (aUA.mrG == 0) {
            return cF;
        }
        str2 = i.cF(aUA.mrG);
        if (cF.equals("")) {
            return str2;
        }
        if (str2.compareTo(cF) > 0) {
            return str2;
        }
        return cF;
    }

    private av rg(int i) {
        if (i < 0) {
            return null;
        }
        v.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[]{Integer.valueOf(i)});
        long currentTimeMillis = System.currentTimeMillis();
        av avVar = new av();
        k kVar = (k) super.getItem(i);
        if (kVar == null) {
            v.a("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCount)});
            return avVar;
        }
        com.tencent.mm.plugin.sns.storage.b aUm;
        int width;
        f vL;
        String str;
        u LW;
        a aVar;
        String tU;
        com.tencent.mm.plugin.sns.storage.b aUm2;
        com.tencent.mm.plugin.sns.storage.a aUo;
        boolean z;
        Iterator it;
        StringBuffer stringBuffer;
        Iterator it2;
        Object obj;
        avr com_tencent_mm_protocal_c_avr;
        u LW2;
        com.tencent.mm.vending.d.b.a aVar2;
        avx com_tencent_mm_protocal_c_avx;
        u LW3;
        com.tencent.mm.vending.d.b.a aVar3;
        Iterator it3;
        a LW4;
        Object tU2;
        Context context;
        al alVar;
        com.tencent.mm.pluginsdk.model.app.f aC;
        com.tencent.mm.plugin.sns.storage.a aVar4;
        aic aUD;
        long currentTimeMillis2;
        azr aUp = kVar.aUp();
        awa n = ah.n(kVar);
        int c = as.c(aUp);
        avVar.aeu = c;
        avVar.jWv = kVar.field_snsId;
        avVar.jWz = kVar.field_likeFlag;
        avVar.jWA = kVar.aUH();
        avVar.jWB = kVar.aUQ();
        avVar.jaC = kVar;
        avVar.jaG = aUp;
        avVar.jaB = n;
        String str2 = avVar.jaG.mWn;
        Context context2 = this.mContext;
        c.aYt();
        CharSequence a = d.a(context2, str2, c.getTextSize());
        avVar.jWs = a;
        int aYv = c.aYt().aYv();
        if (i < this.jWb.getCount()) {
            k kVar2 = (k) super.getItem(i);
            if (kVar2 != null && kVar2.qC(32)) {
                aUm = kVar2.aUm();
                if (aUm != null && aUm.juO == 1) {
                    width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12);
                    if (this.DEBUG) {
                        v.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
                    }
                    vL = com.tencent.mm.kiss.widget.textview.d.a(a, width, c.aYt().aYs()).vL();
                    com.tencent.mm.kiss.widget.textview.c.clL.a(c.aYt().aYs(), vL);
                    if (vL.cmq.getLineCount() > 6) {
                        com.tencent.mm.kiss.widget.textview.c.clL.a(c.aYt().aYu(), com.tencent.mm.kiss.widget.textview.d.a(a, width, c.aYt().aYu()).vL());
                    }
                    a(i, avVar);
                    if (avVar.jaC.qC(32)) {
                        ad.aSB().a(kVar, null);
                    } else {
                        ad.aSB().b(kVar, null);
                    }
                    e(avVar.jaG);
                    str = kVar.field_userName;
                    LW = this.cvg.LW(str);
                    if (str != null) {
                        if (str.equals(this.jUP)) {
                            aVar = LW;
                        } else if (this.jWd != null) {
                            this.jWd = LW;
                            aVar = LW;
                        } else {
                            aVar = this.jWd;
                        }
                        tU = aVar != null ? str : aVar.tU();
                        if (kVar.qC(32) && be.kS(tU)) {
                            aUm2 = kVar.aUm();
                            if (!(aUm2 == null || be.kS(aUm2.cID))) {
                                tU = aUm2.cID;
                            }
                        }
                        avVar.dRA = str;
                        avVar.jWJ = tU;
                        avVar.jEb = kVar.qC(32);
                        avVar.jFt = kVar.aUL();
                        avVar.jWK = ((int) aVar.chr) != 0;
                        avVar.jWt = aVar;
                    }
                    avVar.jWu = kVar.aUq();
                    avVar.jWw = aUp.mWn;
                    avVar.jWx = aUp.mWs;
                    avVar.jWy = kVar.field_createTime;
                    avVar.jWC = aw.f(this.mContext, ((long) avVar.jWy) * 1000);
                    avVar.jWM = false;
                    if (!(c != 11 || com.tencent.mm.model.k.xF().equals(aUp.gln) || n.mTz == null || n.mTz.mTY == 0)) {
                        avVar.jWN = n.mTz.mTY;
                        avVar.jWM = true;
                    }
                    if (avVar.jEb) {
                        tU = aUp.mWo != null ? null : aUp.mWo.cHe;
                        str = aUp.mWo != null ? null : aUp.mWo.gUr;
                        if (be.kS(str)) {
                            if (kVar.field_snsId == 0 || be.kS(tU)) {
                                avVar.jWP = str;
                            } else {
                                avVar.jWP = tU + "·" + str;
                            }
                            avVar.jWQ = true;
                        } else {
                            avVar.jWP = tU;
                            avVar.jWQ = false;
                        }
                    } else {
                        aUo = kVar.aUo();
                        if (aUo != null) {
                            avVar.jWP = aUo.juh;
                            if (be.kS(aUo.jui)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            avVar.jWQ = z;
                        }
                    }
                    str2 = e(aUp);
                    if (!com.tencent.mm.plugin.sns.b.a.drq.bo(str2) && f(aUp)) {
                        avVar.jWR = true;
                        boolean z2 = true;
                        if (aUp.mWp == null) {
                            z = false;
                        } else {
                            if (!this.jWh.containsKey(aUp.mWp.gID)) {
                                z = g.Gw(aUp.mWp.gID);
                                if (!z) {
                                    z2 = false;
                                }
                                this.jWh.put(aUp.mWp.gID, Boolean.valueOf(z));
                            } else if (!((Boolean) this.jWh.get(aUp.mWp.gID)).booleanValue()) {
                                z = false;
                            }
                            z = z2;
                        }
                        avVar.dFj = str2;
                        avVar.jWT = z;
                    } else if (be.kS(aUp.mWr) && f(aUp)) {
                        avVar.dFj = str2;
                        avVar.jWS = true;
                        avVar.jWV = aUp.lJj;
                        avVar.jWU = aUp.mWr;
                    } else {
                        avVar.jWR = false;
                        avVar.jWS = false;
                    }
                    z = avVar.dRA == null && avVar.dRA.equals(this.jUP);
                    avVar.jWL = z;
                    avVar.jWX = kVar.aUN();
                    avVar.jWY = kVar.aUD().mIt;
                    avVar.jWZ = false;
                    if (n != null && avVar.jWL) {
                        width = n.mTr;
                        if (width == 3 || width == 5) {
                            avVar.jWZ = true;
                        }
                    }
                    if (n != null) {
                        if (n.mTq.size() > 0) {
                            if (this.jUP.equals(n.mdw)) {
                                it = n.mTq.iterator();
                                while (it.hasNext()) {
                                    if (this.jUP.equals(((avr) it.next()).mdw)) {
                                        avVar.jXa = true;
                                        avVar.jXc = true;
                                        break;
                                    }
                                }
                            }
                            avVar.jXa = true;
                            stringBuffer = new StringBuffer();
                            it2 = n.mTq.iterator();
                            obj = null;
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_avr = (avr) it2.next();
                                if (obj != null) {
                                    obj = 1;
                                    stringBuffer.append("  ");
                                } else {
                                    stringBuffer.append(",  ");
                                }
                                if (com_tencent_mm_protocal_c_avr.mGq == null) {
                                    stringBuffer.append(com_tencent_mm_protocal_c_avr.mGq);
                                } else {
                                    LW2 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                                    stringBuffer.append(LW2 != null ? com_tencent_mm_protocal_c_avr.mdw : LW2.tU());
                                }
                            }
                            avVar.jXb = stringBuffer.toString();
                        } else {
                            avVar.jXa = false;
                        }
                        if (n.mTz != null && com.tencent.mm.model.k.xF().equals(aUp.gln) && n.mTz.mTY > 0) {
                            avVar.jXf = ((double) x.b(kVar, n)) * 1.0d;
                            avVar.jXe = n.mTz.mTY;
                            avVar.jXd = true;
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.mTz.mTZ.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_avx = (avx) it2.next();
                                LW3 = this.cvg.LW(com_tencent_mm_protocal_c_avx.mdw);
                                if (LW3 == null) {
                                    obj = be.ma(LW3.tU());
                                } else {
                                    obj = be.ma(com_tencent_mm_protocal_c_avx.mdw);
                                }
                                aVar2.q(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.t(com_tencent_mm_protocal_c_avx.mdw, obj)});
                            }
                            avVar.jXg = aVar2.bKH();
                        }
                        if (n.mTk.size() > 0) {
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.mTk.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_avr = (avr) it2.next();
                                LW3 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                                if (LW3 == null) {
                                    obj = be.ma(LW3.tU());
                                } else {
                                    obj = be.ma(com_tencent_mm_protocal_c_avr.mdw);
                                }
                                aVar2.q(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.t(com_tencent_mm_protocal_c_avr.mdw, obj)});
                            }
                            avVar.jXh = aVar2.bKH();
                        }
                        if (n.mTn.size() > 0) {
                            aVar3 = new com.tencent.mm.vending.d.b.a();
                            it3 = n.mTn.iterator();
                            while (it3.hasNext()) {
                                com_tencent_mm_protocal_c_avr = (avr) it3.next();
                                long j = com_tencent_mm_protocal_c_avr.mSN == 0 ? (long) com_tencent_mm_protocal_c_avr.mSN : com_tencent_mm_protocal_c_avr.mSQ;
                                String str3 = com_tencent_mm_protocal_c_avr.mdw;
                                if (com_tencent_mm_protocal_c_avr.mdw.equals(this.jUP)) {
                                    LW4 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                                } else if (this.jWd != null) {
                                    LW4 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                                    this.jWd = LW4;
                                } else {
                                    LW4 = this.jWd;
                                }
                                if (LW4 != null) {
                                    tU2 = LW4.tU();
                                } else {
                                    str2 = com_tencent_mm_protocal_c_avr.mGq == null ? com_tencent_mm_protocal_c_avr.mGq : com_tencent_mm_protocal_c_avr.mdw;
                                }
                                String str4 = com_tencent_mm_protocal_c_avr.hQP;
                                CharSequence charSequence = (CharSequence) avVar.jWr.jdM.get(com_tencent_mm_protocal_c_avr.mSN + "-" + com_tencent_mm_protocal_c_avr.mSQ + "-" + com_tencent_mm_protocal_c_avr.hQP);
                                com.tencent.mm.vending.j.f[] fVarArr = new com.tencent.mm.vending.j.a[1];
                                Long valueOf = Long.valueOf(j);
                                com.tencent.mm.vending.j.f fVar = new com.tencent.mm.vending.j.f();
                                fVar.pik = new Object[]{valueOf, str3, tU2, str4, charSequence};
                                fVarArr[0] = fVar;
                                aVar3.q(fVarArr);
                            }
                            avVar.jXi = aVar3.bKH();
                        }
                    }
                    context = this.mContext;
                    alVar = aUp.joj;
                    if (!(alVar == null || alVar.maK == null)) {
                        tU = alVar.maK.glj;
                        if (be.kS(tU)) {
                            aC = g.aC(tU, true);
                            if (aC != null || be.kS(aC.field_appId)) {
                                z = false;
                            } else {
                                z = (aC.field_appInfoFlag & 32) > 0;
                                v.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[]{aC.field_appId, Boolean.valueOf(z)});
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            avVar.jXj = false;
                            str = "";
                            if (alVar.maO != null || alVar.maP == null) {
                                tU = alVar != null ? "" : alVar.efm != 6 ? alVar.maN != null ? "" : com.tencent.mm.plugin.sns.b.a.drq.o(context, alVar.maK.glj) ? alVar.maN.mcK : alVar.maN.mcL : alVar.maL;
                                try {
                                    if (!be.kS(tU)) {
                                        width = context.getResources().getIdentifier(tU, "string", context.getPackageName());
                                        if (width > 0) {
                                            tU = context.getString(width);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                tU = str;
                            } else {
                                cm cmVar = com.tencent.mm.plugin.sns.b.a.drq.o(context, alVar.maK.glj) ? alVar.maO : alVar.maP;
                                str = com.tencent.mm.sdk.platformtools.u.bsY();
                                tU = str.equals("zh_CN") ? cmVar.mcI : (str.equals("zh_TW") || str.equals("zh_HK")) ? cmVar.mcJ : cmVar.mcH;
                            }
                            switch (alVar.efm) {
                                case 4:
                                    avVar.jXk = tU;
                                    avVar.jXj = true;
                                    break;
                                case 5:
                                    if (alVar.maG == 1) {
                                        avVar.jXk = tU;
                                        avVar.jXj = true;
                                        break;
                                    }
                                    break;
                                case 6:
                                    avVar.jXk = tU;
                                    avVar.jXj = true;
                                    break;
                                default:
                                    avVar.jXj = false;
                                    break;
                            }
                            if (be.kS(tU)) {
                                v.e("MicroMsg.OpenActionContent", "text can not load ?");
                                avVar.jXj = false;
                            }
                            if (avVar.jEb) {
                                avVar.jWD = kVar.aUo();
                                avVar.jWE = kVar.aUm();
                                aUm = kVar.aUm();
                                avVar.jWF = aUm != null ? aUm.jur : "";
                            }
                            if (avVar.jEb) {
                                aVar4 = avVar.jWD;
                                if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                                    avVar.jWG = aVar4.juk;
                                } else if (aVar4.juj == com.tencent.mm.plugin.sns.storage.a.jtW && !be.kS(aVar4.juk)) {
                                    str = "";
                                    it2 = aVar4.jum.iterator();
                                    while (it2.hasNext()) {
                                        tU = (String) it2.next();
                                        LW2 = ad.aSs().LW(tU);
                                        if (LW2 != null) {
                                            str = str + LW2.tU();
                                        } else {
                                            str = str + tU;
                                        }
                                        if (aVar4.jum.getLast() != tU) {
                                            str = str + ",";
                                        }
                                    }
                                    avVar.jWI = str;
                                    avVar.jWH = String.format(aVar4.juk, new Object[]{str});
                                }
                            }
                            aUD = kVar.aUD();
                            avVar.jXl = aUD;
                            if (!(aUD == null || com.tencent.mm.model.k.xF().equals(aUp.gln) || !x.a(kVar, n))) {
                                avVar.jWO = true;
                            }
                            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            v.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                            return avVar;
                        }
                    }
                    avVar.jXj = false;
                    if (avVar.jEb) {
                        avVar.jWD = kVar.aUo();
                        avVar.jWE = kVar.aUm();
                        aUm = kVar.aUm();
                        if (aUm != null) {
                        }
                        avVar.jWF = aUm != null ? aUm.jur : "";
                    }
                    if (avVar.jEb) {
                        aVar4 = avVar.jWD;
                        if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                            str = "";
                            it2 = aVar4.jum.iterator();
                            while (it2.hasNext()) {
                                tU = (String) it2.next();
                                LW2 = ad.aSs().LW(tU);
                                if (LW2 != null) {
                                    str = str + tU;
                                } else {
                                    str = str + LW2.tU();
                                }
                                if (aVar4.jum.getLast() != tU) {
                                    str = str + ",";
                                }
                            }
                            avVar.jWI = str;
                            avVar.jWH = String.format(aVar4.juk, new Object[]{str});
                        } else {
                            avVar.jWG = aVar4.juk;
                        }
                    }
                    aUD = kVar.aUD();
                    avVar.jXl = aUD;
                    avVar.jWO = true;
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    v.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                    return avVar;
                }
            }
        }
        width = aYv;
        if (this.DEBUG) {
            v.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
        }
        vL = com.tencent.mm.kiss.widget.textview.d.a(a, width, c.aYt().aYs()).vL();
        com.tencent.mm.kiss.widget.textview.c.clL.a(c.aYt().aYs(), vL);
        if (vL.cmq.getLineCount() > 6) {
            com.tencent.mm.kiss.widget.textview.c.clL.a(c.aYt().aYu(), com.tencent.mm.kiss.widget.textview.d.a(a, width, c.aYt().aYu()).vL());
        }
        a(i, avVar);
        if (avVar.jaC.qC(32)) {
            ad.aSB().a(kVar, null);
        } else {
            ad.aSB().b(kVar, null);
        }
        e(avVar.jaG);
        str = kVar.field_userName;
        LW = this.cvg.LW(str);
        if (str != null) {
            if (str.equals(this.jUP)) {
                aVar = LW;
            } else if (this.jWd != null) {
                aVar = this.jWd;
            } else {
                this.jWd = LW;
                aVar = LW;
            }
            if (aVar != null) {
            }
            aUm2 = kVar.aUm();
            tU = aUm2.cID;
            avVar.dRA = str;
            avVar.jWJ = tU;
            avVar.jEb = kVar.qC(32);
            avVar.jFt = kVar.aUL();
            if (((int) aVar.chr) != 0) {
            }
            avVar.jWK = ((int) aVar.chr) != 0;
            avVar.jWt = aVar;
        }
        avVar.jWu = kVar.aUq();
        avVar.jWw = aUp.mWn;
        avVar.jWx = aUp.mWs;
        avVar.jWy = kVar.field_createTime;
        avVar.jWC = aw.f(this.mContext, ((long) avVar.jWy) * 1000);
        avVar.jWM = false;
        avVar.jWN = n.mTz.mTY;
        avVar.jWM = true;
        if (avVar.jEb) {
            if (aUp.mWo != null) {
            }
            if (aUp.mWo != null) {
            }
            if (be.kS(str)) {
                avVar.jWP = tU;
                avVar.jWQ = false;
            } else {
                if (kVar.field_snsId == 0) {
                }
                avVar.jWP = str;
                avVar.jWQ = true;
            }
        } else {
            aUo = kVar.aUo();
            if (aUo != null) {
                avVar.jWP = aUo.juh;
                if (be.kS(aUo.jui)) {
                    z = false;
                } else {
                    z = true;
                }
                avVar.jWQ = z;
            }
        }
        str2 = e(aUp);
        if (!com.tencent.mm.plugin.sns.b.a.drq.bo(str2)) {
        }
        if (be.kS(aUp.mWr)) {
        }
        avVar.jWR = false;
        avVar.jWS = false;
        if (avVar.dRA == null) {
        }
        avVar.jWL = z;
        avVar.jWX = kVar.aUN();
        avVar.jWY = kVar.aUD().mIt;
        avVar.jWZ = false;
        width = n.mTr;
        avVar.jWZ = true;
        if (n != null) {
            if (n.mTq.size() > 0) {
                avVar.jXa = false;
            } else if (this.jUP.equals(n.mdw)) {
                it = n.mTq.iterator();
                while (it.hasNext()) {
                    if (this.jUP.equals(((avr) it.next()).mdw)) {
                        avVar.jXa = true;
                        avVar.jXc = true;
                        break;
                    }
                }
            } else {
                avVar.jXa = true;
                stringBuffer = new StringBuffer();
                it2 = n.mTq.iterator();
                obj = null;
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it2.next();
                    if (obj != null) {
                        stringBuffer.append(",  ");
                    } else {
                        obj = 1;
                        stringBuffer.append("  ");
                    }
                    if (com_tencent_mm_protocal_c_avr.mGq == null) {
                        LW2 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                        if (LW2 != null) {
                        }
                        stringBuffer.append(LW2 != null ? com_tencent_mm_protocal_c_avr.mdw : LW2.tU());
                    } else {
                        stringBuffer.append(com_tencent_mm_protocal_c_avr.mGq);
                    }
                }
                avVar.jXb = stringBuffer.toString();
            }
            avVar.jXf = ((double) x.b(kVar, n)) * 1.0d;
            avVar.jXe = n.mTz.mTY;
            avVar.jXd = true;
            aVar2 = new com.tencent.mm.vending.d.b.a();
            it2 = n.mTz.mTZ.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_avx = (avx) it2.next();
                LW3 = this.cvg.LW(com_tencent_mm_protocal_c_avx.mdw);
                if (LW3 == null) {
                    obj = be.ma(com_tencent_mm_protocal_c_avx.mdw);
                } else {
                    obj = be.ma(LW3.tU());
                }
                aVar2.q(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.t(com_tencent_mm_protocal_c_avx.mdw, obj)});
            }
            avVar.jXg = aVar2.bKH();
            if (n.mTk.size() > 0) {
                aVar2 = new com.tencent.mm.vending.d.b.a();
                it2 = n.mTk.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it2.next();
                    LW3 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                    if (LW3 == null) {
                        obj = be.ma(com_tencent_mm_protocal_c_avr.mdw);
                    } else {
                        obj = be.ma(LW3.tU());
                    }
                    aVar2.q(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.t(com_tencent_mm_protocal_c_avr.mdw, obj)});
                }
                avVar.jXh = aVar2.bKH();
            }
            if (n.mTn.size() > 0) {
                aVar3 = new com.tencent.mm.vending.d.b.a();
                it3 = n.mTn.iterator();
                while (it3.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it3.next();
                    if (com_tencent_mm_protocal_c_avr.mSN == 0) {
                    }
                    String str32 = com_tencent_mm_protocal_c_avr.mdw;
                    if (com_tencent_mm_protocal_c_avr.mdw.equals(this.jUP)) {
                        LW4 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                    } else if (this.jWd != null) {
                        LW4 = this.jWd;
                    } else {
                        LW4 = this.cvg.LW(com_tencent_mm_protocal_c_avr.mdw);
                        this.jWd = LW4;
                    }
                    if (LW4 != null) {
                        tU2 = LW4.tU();
                    } else if (com_tencent_mm_protocal_c_avr.mGq == null) {
                    }
                    String str42 = com_tencent_mm_protocal_c_avr.hQP;
                    CharSequence charSequence2 = (CharSequence) avVar.jWr.jdM.get(com_tencent_mm_protocal_c_avr.mSN + "-" + com_tencent_mm_protocal_c_avr.mSQ + "-" + com_tencent_mm_protocal_c_avr.hQP);
                    com.tencent.mm.vending.j.f[] fVarArr2 = new com.tencent.mm.vending.j.a[1];
                    Long valueOf2 = Long.valueOf(j);
                    com.tencent.mm.vending.j.f fVar2 = new com.tencent.mm.vending.j.f();
                    fVar2.pik = new Object[]{valueOf2, str32, tU2, str42, charSequence2};
                    fVarArr2[0] = fVar2;
                    aVar3.q(fVarArr2);
                }
                avVar.jXi = aVar3.bKH();
            }
        }
        context = this.mContext;
        alVar = aUp.joj;
        tU = alVar.maK.glj;
        if (be.kS(tU)) {
            aC = g.aC(tU, true);
            if (aC != null) {
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            avVar.jXj = false;
            str = "";
            if (alVar.maO != null) {
            }
            if (alVar != null) {
                if (alVar.efm != 6) {
                }
            }
            if (be.kS(tU)) {
                width = context.getResources().getIdentifier(tU, "string", context.getPackageName());
                if (width > 0) {
                    tU = context.getString(width);
                    switch (alVar.efm) {
                        case 4:
                            avVar.jXk = tU;
                            avVar.jXj = true;
                            break;
                        case 5:
                            if (alVar.maG == 1) {
                                avVar.jXk = tU;
                                avVar.jXj = true;
                                break;
                            }
                            break;
                        case 6:
                            avVar.jXk = tU;
                            avVar.jXj = true;
                            break;
                        default:
                            avVar.jXj = false;
                            break;
                    }
                    if (be.kS(tU)) {
                        v.e("MicroMsg.OpenActionContent", "text can not load ?");
                        avVar.jXj = false;
                    }
                    if (avVar.jEb) {
                        avVar.jWD = kVar.aUo();
                        avVar.jWE = kVar.aUm();
                        aUm = kVar.aUm();
                        if (aUm != null) {
                        }
                        avVar.jWF = aUm != null ? aUm.jur : "";
                    }
                    if (avVar.jEb) {
                        aVar4 = avVar.jWD;
                        if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                            avVar.jWG = aVar4.juk;
                        } else {
                            str = "";
                            it2 = aVar4.jum.iterator();
                            while (it2.hasNext()) {
                                tU = (String) it2.next();
                                LW2 = ad.aSs().LW(tU);
                                if (LW2 != null) {
                                    str = str + LW2.tU();
                                } else {
                                    str = str + tU;
                                }
                                if (aVar4.jum.getLast() != tU) {
                                    str = str + ",";
                                }
                            }
                            avVar.jWI = str;
                            avVar.jWH = String.format(aVar4.juk, new Object[]{str});
                        }
                    }
                    aUD = kVar.aUD();
                    avVar.jXl = aUD;
                    avVar.jWO = true;
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    v.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                    return avVar;
                }
            }
            tU = str;
            switch (alVar.efm) {
                case 4:
                    avVar.jXk = tU;
                    avVar.jXj = true;
                    break;
                case 5:
                    if (alVar.maG == 1) {
                        avVar.jXk = tU;
                        avVar.jXj = true;
                        break;
                    }
                    break;
                case 6:
                    avVar.jXk = tU;
                    avVar.jXj = true;
                    break;
                default:
                    avVar.jXj = false;
                    break;
            }
            if (be.kS(tU)) {
                v.e("MicroMsg.OpenActionContent", "text can not load ?");
                avVar.jXj = false;
            }
            if (avVar.jEb) {
                avVar.jWD = kVar.aUo();
                avVar.jWE = kVar.aUm();
                aUm = kVar.aUm();
                if (aUm != null) {
                }
                avVar.jWF = aUm != null ? aUm.jur : "";
            }
            if (avVar.jEb) {
                aVar4 = avVar.jWD;
                if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                    str = "";
                    it2 = aVar4.jum.iterator();
                    while (it2.hasNext()) {
                        tU = (String) it2.next();
                        LW2 = ad.aSs().LW(tU);
                        if (LW2 != null) {
                            str = str + tU;
                        } else {
                            str = str + LW2.tU();
                        }
                        if (aVar4.jum.getLast() != tU) {
                            str = str + ",";
                        }
                    }
                    avVar.jWI = str;
                    avVar.jWH = String.format(aVar4.juk, new Object[]{str});
                } else {
                    avVar.jWG = aVar4.juk;
                }
            }
            aUD = kVar.aUD();
            avVar.jXl = aUD;
            avVar.jWO = true;
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            v.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
            return avVar;
        }
        avVar.jXj = false;
        if (avVar.jEb) {
            avVar.jWD = kVar.aUo();
            avVar.jWE = kVar.aUm();
            aUm = kVar.aUm();
            if (aUm != null) {
            }
            avVar.jWF = aUm != null ? aUm.jur : "";
        }
        if (avVar.jEb) {
            aVar4 = avVar.jWD;
            if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                avVar.jWG = aVar4.juk;
            } else {
                str = "";
                it2 = aVar4.jum.iterator();
                while (it2.hasNext()) {
                    tU = (String) it2.next();
                    LW2 = ad.aSs().LW(tU);
                    if (LW2 != null) {
                        str = str + LW2.tU();
                    } else {
                        str = str + tU;
                    }
                    if (aVar4.jum.getLast() != tU) {
                        str = str + ",";
                    }
                }
                avVar.jWI = str;
                avVar.jWH = String.format(aVar4.juk, new Object[]{str});
            }
        }
        aUD = kVar.aUD();
        avVar.jXl = aUD;
        avVar.jWO = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        v.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
        return avVar;
    }

    private String e(azr com_tencent_mm_protocal_c_azr) {
        if (com_tencent_mm_protocal_c_azr.mWp == null) {
            return "";
        }
        if (be.kS(com_tencent_mm_protocal_c_azr.mWp.gID)) {
            return "";
        }
        if (this.jWg.containsKey(com_tencent_mm_protocal_c_azr.mWp.gID)) {
            return (String) this.jWg.get(com_tencent_mm_protocal_c_azr.mWp.gID);
        }
        String a = g.a(this.mContext, g.bA(com_tencent_mm_protocal_c_azr.mWp.gID, be.getInt(com_tencent_mm_protocal_c_azr.mWp.efc, 0)), null);
        if (be.kS(a)) {
            return a;
        }
        this.jWg.put(com_tencent_mm_protocal_c_azr.mWp.gID, a);
        return a;
    }

    private static boolean f(azr com_tencent_mm_protocal_c_azr) {
        if (!be.kS(com_tencent_mm_protocal_c_azr.mWr) && (ak.a.aTb() & 2) > 0) {
            return false;
        }
        return true;
    }

    private void a(int i, av avVar) {
        List<avr> list = avVar.jaB.mTn;
        com.tencent.mm.kiss.widget.textview.a.a aYs = com.tencent.mm.plugin.sns.ui.widget.a.aYr().aYs();
        avVar.jWr = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            v.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + list.size() + " commentData:" + avVar.jWr.jdM.size());
        }
        for (avr com_tencent_mm_protocal_c_avr : list) {
            String str;
            Object obj;
            com.tencent.mm.plugin.sns.ui.widget.a aYr;
            int i2;
            com.tencent.mm.kiss.widget.textview.c cVar = com.tencent.mm.kiss.widget.textview.c.clL;
            Context context = this.mContext;
            String str2 = "";
            String a = com.tencent.mm.plugin.sns.ui.widget.b.a(com_tencent_mm_protocal_c_avr);
            if (be.kS(com_tencent_mm_protocal_c_avr.mTc)) {
                str = a;
            } else {
                u LW = ad.aSs().LW(com_tencent_mm_protocal_c_avr.mTc);
                str = (a + context.getString(2131235510)) + (LW == null ? com_tencent_mm_protocal_c_avr.mTc : LW.tU());
            }
            CharSequence charSequence = (str2 + str + ": ") + com_tencent_mm_protocal_c_avr.hQP;
            if (aYs != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.clM.get(Integer.valueOf(com.tencent.mm.kiss.widget.textview.c.a(aYs)));
                if (bVar != null) {
                    LinkedList linkedList = (LinkedList) bVar.clK.get(charSequence.toString());
                    obj = (linkedList == null || linkedList.size() == 0) ? null : 1;
                    if (obj == null) {
                        avVar.jWr.a(com_tencent_mm_protocal_c_avr, com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_avr, this.jWb, avVar.jaC.field_type));
                    } else {
                        charSequence = com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_avr, this.jWb, avVar.jaC.field_type);
                        avVar.jWr.a(com_tencent_mm_protocal_c_avr, charSequence);
                        aYr = com.tencent.mm.plugin.sns.ui.widget.a.aYr();
                        if (aYr.kcf <= 0) {
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) com.tencent.mm.sdk.platformtools.aa.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            i2 = displayMetrics.widthPixels;
                            int dimension = (int) (com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168) + com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168));
                            int dimension2 = (int) com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493579);
                            int dimension3 = (int) com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168);
                            aYr.kcf = ((i2 - dimension2) - dimension) - dimension3;
                            v.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + aYr.kcf + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
                        }
                        i2 = aYr.kcf;
                        if (i2 > 0) {
                            com.tencent.mm.kiss.widget.textview.c.clL.a(aYs, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, aYs).vL());
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                charSequence = com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_avr, this.jWb, avVar.jaC.field_type);
                avVar.jWr.a(com_tencent_mm_protocal_c_avr, charSequence);
                aYr = com.tencent.mm.plugin.sns.ui.widget.a.aYr();
                if (aYr.kcf <= 0) {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    ((WindowManager) com.tencent.mm.sdk.platformtools.aa.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    int dimension4 = (int) (com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168) + com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168));
                    int dimension22 = (int) com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493579);
                    int dimension32 = (int) com.tencent.mm.sdk.platformtools.aa.getResources().getDimension(2131493168);
                    aYr.kcf = ((i2 - dimension22) - dimension4) - dimension32;
                    v.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + aYr.kcf + " padding: " + dimension4 + " marginLeft: " + dimension22 + " thisviewPadding: " + dimension32);
                }
                i2 = aYr.kcf;
                if (i2 > 0) {
                    com.tencent.mm.kiss.widget.textview.c.clL.a(aYs, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, aYs).vL());
                }
            } else {
                avVar.jWr.a(com_tencent_mm_protocal_c_avr, com.tencent.mm.plugin.sns.ui.widget.b.a(this.mContext, com_tencent_mm_protocal_c_avr, this.jWb, avVar.jaC.field_type));
            }
        }
    }

    protected final Cursor aXW() {
        if (!this.jWe) {
            this.fHQ = k(0, this.fHQ);
            this.jWe = true;
        }
        int BE = ad.aSE().BE(this.fHQ);
        v.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[]{Integer.valueOf(this.jWc), Integer.valueOf(BE), this.fHQ});
        if (this.jWc != BE) {
            com.tencent.mm.plugin.sns.storage.d aSF = ad.aSF();
            String str = ("select *,rowid from AdSnsInfo  where createTime > " + BE + " and createTime <= " + this.jWc) + " order by  createTime desc";
            v.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
            Cursor rawQuery = aSF.cie.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                do {
                    int i;
                    com.tencent.mm.plugin.sns.storage.c cVar = new com.tencent.mm.plugin.sns.storage.c();
                    cVar.b(rawQuery);
                    k aUr = cVar.aUr();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    com.tencent.mm.plugin.sns.storage.c aUS = aUr.aUS();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(aUr.field_stringSeq);
                    stringBuffer.append(aUS.field_adxml);
                    stringBuffer.append(" <createtime " + aUr.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + aUS.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + aUS.field_createAdTime + "> ");
                    stringBuffer.append(aUS.aUp().mWn);
                    v.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a aUo = aUr.aUo();
                    int i2 = aUr.field_createTime;
                    boolean aUH = aUr.aUH();
                    if (aUo == null) {
                        i = i2;
                    } else if (aUH) {
                        j = 60 * aUo.jtZ;
                        i = cVar.field_exposureTime;
                    } else {
                        j = 60 * aUo.jtY;
                        i = cVar.field_createAdTime;
                    }
                    long ax = be.ax((long) i);
                    if (ax >= j) {
                        Object obj;
                        awa n = ah.n(aUr);
                        if (aUr.field_likeFlag == 0) {
                            Iterator it = n.mTn.iterator();
                            while (it.hasNext()) {
                                avr com_tencent_mm_protocal_c_avr = (avr) it.next();
                                if (com_tencent_mm_protocal_c_avr == null || be.kS(com_tencent_mm_protocal_c_avr.mdw) || !com_tencent_mm_protocal_c_avr.mdw.equals(this.jUP)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                ad.aSF().delete(aUr.field_snsId);
                                v.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + aUr.field_snsId + " exposureTime: " + j + " field_createTime: " + aUr.field_createTime + " checktime: " + ax + " gettime: " + i + " isexposure " + aUH + " exposureTime " + cVar.field_exposureTime + " adCreateTIme:" + cVar.field_createAdTime);
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            ad.aSF().delete(aUr.field_snsId);
                            v.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + aUr.field_snsId + " exposureTime: " + j + " field_createTime: " + aUr.field_createTime + " checktime: " + ax + " gettime: " + i + " isexposure " + aUH + " exposureTime " + cVar.field_exposureTime + " adCreateTIme:" + cVar.field_createAdTime);
                        }
                    }
                    long j2 = aUr.field_snsId;
                    v.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + j2);
                    if (com.tencent.mm.plugin.sns.e.k.cH(j2)) {
                        com.tencent.mm.model.ak.vy().a(new com.tencent.mm.plugin.sns.e.k(j2, 1), 0);
                    }
                } while (rawQuery.moveToNext());
                if (rawQuery != null) {
                    v.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                v.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                rawQuery.close();
            }
        }
        this.jWc = BE;
        Cursor aX = ad.aSE().aX(this.fHQ, BE);
        v.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(500);
        if (gh.JB()) {
            int i3 = this.mCount;
            if (i3 == 0) {
                gh.gk(0).gk(0).gk(0);
                gh.JF();
            } else {
                int i4 = i3 - 1;
                String g = i.g((k) getItem(1));
                String g2 = i.g((k) getItem(i4));
                if (!(g.equals(this.jWi) && g2.equals(this.jWj))) {
                    this.jWi = g;
                    this.jWj = g2;
                    gh.gk(i3).kj(g).kj(g2);
                    gh.JF();
                }
            }
        }
        return aX;
    }

    public final void destroyAsynchronous() {
        super.destroyAsynchronous();
        com.tencent.mm.kiss.widget.textview.c.clL.vK();
        this.jWh.clear();
    }
}
