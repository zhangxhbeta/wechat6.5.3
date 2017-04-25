package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.sdk.platformtools.aa;

public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        Object stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        int i = -1;
        switch (this.type) {
            case 1:
                i = 2131234845;
                break;
            case 2:
                i = 2131234844;
                break;
            case 8:
                i = 2131234827;
                break;
            case 16:
                i = 2131234825;
                break;
            case 64:
                i = 2131230936;
                break;
            case 128:
                i = 2131234815;
                break;
            case 256:
            case 384:
                i = 2131234814;
                break;
            case 512:
                i = 2131234823;
                break;
            case 1024:
                i = 2131234824;
                break;
        }
        if (i < 0) {
            return "";
        }
        return aa.getContext().getResources().getString(2131234843, new Object[]{aa.getContext().getResources().getString(i)});
    }

    protected void onResume() {
        super.onResume();
        l.Im();
    }

    protected void onPause() {
        super.onPause();
        l.In();
    }
}
