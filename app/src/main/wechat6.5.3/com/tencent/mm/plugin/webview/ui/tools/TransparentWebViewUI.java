package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends WebViewUI {
    protected final void NI() {
        super.NI();
        this.llx.ljL = true;
        this.llx.dCD = false;
        this.llx.hx(true);
        this.llx.sZ(0);
    }

    protected final void bjR() {
        vA(0);
        this.nDR.dtW.setBackgroundResource(0);
        this.igd.setBackgroundResource(17170445);
        this.igd.setBackgroundColor(0);
        findViewById(2131756749).setBackgroundResource(17170445);
    }
}
