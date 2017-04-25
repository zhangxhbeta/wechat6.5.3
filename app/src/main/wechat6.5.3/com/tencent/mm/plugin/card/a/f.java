package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public b eBg;
    public MMActivity eBk;
    public List<com.tencent.mm.plugin.card.model.b> eBl = new ArrayList();
    public com.tencent.mm.plugin.card.model.b eBm;
    public ArrayList<ix> eBn;
    public int exT = 3;

    public f(MMActivity mMActivity) {
        this.eBk = mMActivity;
    }

    public final com.tencent.mm.plugin.card.model.b ZU() {
        boolean z;
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.eBU = 1;
        if (j.jj(this.exT) || j.jk(this.exT) || this.exT == 23) {
            if (!(!this.eBg.isAcceptable() || this.eBg.Zv().mlh == null || TextUtils.isEmpty(this.eBg.Zv().mlh.text) || TextUtils.isEmpty(this.eBg.Zv().mkK))) {
                z = true;
            }
            z = false;
        } else {
            if (!(this.exT != 6 || !this.eBg.Zs() || this.eBg.Zv().mlh == null || TextUtils.isEmpty(this.eBg.Zv().mlh.text) || TextUtils.isEmpty(this.eBg.Zv().mkK))) {
                z = true;
            }
            z = false;
        }
        bVar.eBW = z;
        if (!bVar.eBW && !TextUtils.isEmpty(this.eBg.Zv().mla)) {
            bVar.title = this.eBg.Zv().mla;
        } else if (m.eC(this.eBg.Zv().mkK)) {
            bVar.title = getString(2131231653);
            bVar.eBW = false;
        } else {
            bVar.title = getString(2131231652);
            if (this.eBg.Zv().mlh == null || this.eBg.Zv().mlh.muE != 1) {
                bVar.eBX = false;
            } else {
                bVar.eBX = true;
            }
        }
        if (!TextUtils.isEmpty(this.eBg.Zv().mlc)) {
            bVar.eBN = this.eBg.Zv().mlc;
        }
        bVar.eEL = "";
        bVar.url = "card://jump_service";
        this.eBm = bVar;
        return this.eBm;
    }

    public final String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.eBg.Zv().eCC)) {
            stringBuilder.append(this.eBg.Zv().eCC);
        } else if (this.eBg.Zc()) {
            stringBuilder.append(getString(2131231648));
        } else if (this.eBg.Zd()) {
            stringBuilder.append(getString(2131231606));
        } else if (this.eBg.Ze()) {
            stringBuilder.append(getString(2131231593));
        } else if (this.eBg.Zf()) {
            stringBuilder.append(getString(2131231614));
        } else if (this.eBg.Zg()) {
            stringBuilder.append(getString(2131231635));
        }
        return stringBuilder.toString();
    }

    public final String getString(int i) {
        return this.eBk.getString(i);
    }
}
