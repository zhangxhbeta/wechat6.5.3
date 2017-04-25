package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bf.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;
import com.tencent.mm.sdk.platformtools.aa;

public class c {
    Context fda;
    int fmc;
    int fmd;
    boolean lsn = false;
    b lsp;
    a lsq;

    public final a blQ() {
        if (this.lsp == null) {
            this.lsp = new b();
            this.lsp.fda = this.fda;
            this.lsp.a(this);
        }
        return this.lsp;
    }

    public static int[] ahP() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public e Tg() {
        return e.buQ();
    }
}
