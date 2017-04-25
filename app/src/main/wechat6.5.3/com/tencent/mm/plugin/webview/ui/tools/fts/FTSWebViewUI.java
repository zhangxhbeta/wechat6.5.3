package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.modelsearch.l;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        return getString(2131231148);
    }

    protected final void aqj() {
        super.aqj();
        l.fY(this.scene);
    }

    protected void onResume() {
        super.onResume();
        l.Im();
    }

    protected void onPause() {
        super.onPause();
        l.In();
    }

    protected void onDestroy() {
        super.onDestroy();
        l.Io();
        l.Ip();
    }
}
