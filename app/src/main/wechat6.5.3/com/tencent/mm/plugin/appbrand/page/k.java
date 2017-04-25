package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;

public final class k extends e {
    private h dNm;
    private String mUrl;

    public k(Context context, f fVar) {
        super(context, fVar);
    }

    protected final View getContentView() {
        if (this.dNm == null) {
            this.dNm = Rc();
        }
        return this.dNm;
    }

    public final void loadUrl(String str) {
        if (this.mUrl == null) {
            this.mUrl = str;
            this.dNm.oe(str);
            Rf();
        }
    }

    public final boolean nV(String str) {
        return this.mUrl == null ? false : this.mUrl.equals(str);
    }

    protected final void QY() {
        super.QY();
        this.dNm.onDestroy();
    }

    public final void OE() {
        super.OE();
        this.dNm.OE();
    }

    public final void QW() {
        super.QW();
        this.dNm.Rq();
        Re();
    }

    public final void QX() {
        super.QX();
        this.dNm.Qi();
    }

    public final void b(String str, String str2, int[] iArr) {
        if (e.d(iArr, this.dNm.hashCode())) {
            this.dNm.aP(str, str2);
        }
    }

    public final h QZ() {
        return this.dNm;
    }

    public final String Ra() {
        return this.mUrl;
    }
}
