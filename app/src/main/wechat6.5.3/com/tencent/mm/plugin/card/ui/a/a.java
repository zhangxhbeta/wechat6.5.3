package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class a implements g {
    protected b eBg;
    protected MMActivity eBk;
    protected com.tencent.mm.plugin.card.ui.d.a eIB;
    boolean eMj = false;
    private boolean eMk = false;
    private boolean eMl = false;
    private boolean eMm = false;
    private boolean eMn = false;
    private boolean eMo = false;
    private boolean eMp = false;
    private boolean eMq = false;
    private boolean eMr = false;
    private boolean eMs = false;

    public a(MMActivity mMActivity) {
        this.eBk = mMActivity;
    }

    public final void a(b bVar, com.tencent.mm.plugin.card.ui.d.a aVar) {
        this.eBg = bVar;
        this.eIB = aVar;
        acd();
    }

    public final void release() {
        this.eBg = null;
        this.eIB = null;
        this.eBk = null;
    }

    public final String abX() {
        String str = "";
        if (!TextUtils.isEmpty(this.eBg.Zv().mll)) {
            return this.eBg.Zv().mll;
        }
        if (this.eBg.Zw().mkp == 0) {
            return getString(2131231660);
        }
        if (this.eBg.Zw().mkq != 0) {
            return str;
        }
        if (TextUtils.isEmpty(this.eBg.Zv().mkS)) {
            return getString(2131231581);
        }
        return this.eBg.Zv().mkS;
    }

    private String getString(int i) {
        return this.eBk.getString(i);
    }

    public final boolean abY() {
        return this.eBg.Zw().status == 0 || this.eBg.Zw().status == 1 || this.eBg.Zw().status == 2;
    }

    public final boolean abZ() {
        return this.eIB.exT == 3 || ((this.eIB.exT == 6 && this.eBg.Zw().mkm == 0) || this.eIB.exT == 4 || this.eIB.exT == 5 || this.eIB.exT == 15);
    }

    private boolean aca() {
        return !TextUtils.isEmpty(this.eBg.Zw().code);
    }

    protected final boolean acb() {
        return !this.eBg.isAcceptable() && (j.jj(this.eIB.exT) || j.jk(this.eIB.exT) || this.eIB.exT == 23);
    }

    protected final boolean acc() {
        return !this.eBg.Zs() && this.eIB.exT == 6;
    }

    protected void acd() {
        v.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (j.jj(this.eIB.exT) || j.jk(this.eIB.exT)) {
            if (this.eBg.isAcceptable()) {
                this.eMk = true;
                this.eMl = true;
                this.eMq = true;
                this.eMo = true;
                this.eMp = true;
            } else if (this.eBg.isAcceptable()) {
                this.eMk = false;
                this.eMl = false;
                this.eMo = false;
            } else {
                this.eMk = true;
                this.eMl = false;
                if (this.eBg.Zq()) {
                    this.eMr = true;
                    this.eMo = true;
                    this.eMn = true;
                } else {
                    this.eMo = false;
                }
                this.eMp = true;
            }
        } else if (this.eIB.exT == 6) {
            if (this.eBg.Zs()) {
                this.eMk = true;
                this.eMl = true;
                this.eMo = false;
            } else if (this.eBg.Zr()) {
                this.eMr = true;
                this.eMo = true;
                this.eMm = true;
                this.eMn = true;
            } else {
                this.eMk = false;
                this.eMl = false;
                this.eMo = false;
                this.eMm = true;
            }
        } else if (j.jl(this.eIB.exT)) {
            this.eMk = false;
            this.eMl = false;
            this.eMm = true;
            if (this.eBg.Zr()) {
                this.eMr = true;
                this.eMo = true;
                this.eMn = true;
            } else {
                this.eMs = true;
            }
        } else if (this.eIB.exT == 23) {
            if (this.eBg.isAcceptable()) {
                this.eMk = true;
                this.eMl = true;
                this.eMo = false;
                this.eMp = true;
            } else {
                this.eMk = true;
                this.eMl = false;
                this.eMo = false;
                this.eMp = true;
            }
            if (!(TextUtils.isEmpty(this.eIB.eHL) || this.eIB.eHL.equals(k.xF()) || this.eBg.Zu())) {
                v.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.eMk = false;
                this.eMl = false;
                this.eMm = true;
                if (this.eBg.Zr()) {
                    this.eMr = true;
                    this.eMo = true;
                    this.eMn = true;
                }
            }
        }
        if (this.eBg.Zq()) {
            this.eMk = false;
            this.eMl = false;
            v.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            v.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.eMj) {
            this.eMk = false;
            this.eMl = false;
            v.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.eMk) {
            this.eMj = false;
            v.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.eMj = true;
            v.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        v.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.eMj);
    }

    public final boolean abC() {
        return this.eMj;
    }

    public boolean ace() {
        return this.eMk;
    }

    public final boolean acf() {
        return this.eMl;
    }

    public final boolean acg() {
        return this.eMm;
    }

    public final boolean ach() {
        return this.eMn;
    }

    public final boolean aci() {
        return this.eMo;
    }

    public final boolean acj() {
        return this.eMq;
    }

    public final boolean ack() {
        return this.eMr;
    }

    public final boolean acl() {
        return this.eMs;
    }

    public boolean acm() {
        return true;
    }

    public boolean acn() {
        return false;
    }

    public boolean aco() {
        return false;
    }

    public boolean acp() {
        return (this.eIB.exT == 6 && (!this.eBg.Zr() || this.eBg.Zs())) || this.eIB.exT == 5 || (this.eIB.exT == 23 && this.eBg.Zu());
    }

    public boolean acq() {
        return false;
    }

    public boolean acr() {
        return true;
    }

    public boolean acs() {
        return (aca() && abY() && abZ()) || this.eMj;
    }

    public boolean act() {
        return false;
    }

    public boolean acu() {
        return !this.eBg.Zr();
    }

    public boolean acv() {
        return (this.eBg.Zv().mlf == null || this.eBg.Zv().mlf.mpb == null || this.eBg.Zv().mlf.mpb.size() <= 0 || TextUtils.isEmpty((CharSequence) this.eBg.Zv().mlf.mpb.get(0))) ? false : true;
    }

    public boolean acw() {
        if (this.eBg.Zw().mko == null || this.eBg.Zw().mko.size() <= 0 || ((!abY() || !abZ()) && !this.eMj)) {
            return false;
        }
        return true;
    }

    public boolean acx() {
        return false;
    }

    public final boolean acy() {
        return (this.eBg.Zw().mks == null || TextUtils.isEmpty(this.eBg.Zw().mks.title)) ? false : true;
    }

    public boolean acz() {
        return (this.eBg.Zw().mkv == null || TextUtils.isEmpty(this.eBg.Zw().mkv.title)) ? false : true;
    }

    public boolean acA() {
        return this.eBg.Zv().mlb != null;
    }

    public boolean acB() {
        if (TextUtils.isEmpty(this.eBg.Zv().mkY)) {
            return false;
        }
        return true;
    }

    public boolean acC() {
        return false;
    }

    public boolean acD() {
        return false;
    }

    public final void acE() {
        int i;
        int i2 = 1;
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (aca()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = abX();
        objArr[2] = Integer.valueOf(this.eMj ? 1 : 0);
        objArr[3] = Integer.valueOf(ace() ? 1 : 0);
        objArr[4] = Integer.valueOf(this.eMl ? 1 : 0);
        objArr[5] = Integer.valueOf(this.eMm ? 1 : 0);
        objArr[6] = Integer.valueOf(this.eMn ? 1 : 0);
        objArr[7] = Integer.valueOf(this.eMo ? 1 : 0);
        objArr[8] = Integer.valueOf(this.eMp ? 1 : 0);
        objArr[9] = Integer.valueOf(this.eMq ? 1 : 0);
        objArr[10] = Integer.valueOf(this.eMr ? 1 : 0);
        if (!this.eMs) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        v.i(str, str2, objArr);
    }
}
