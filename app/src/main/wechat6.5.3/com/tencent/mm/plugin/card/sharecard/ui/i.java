package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    MMActivity eBk;
    private View eEX;
    View eGG;
    TextView eGH;
    TextView eGI;
    private boolean eGJ = false;

    public i(MMActivity mMActivity, View view) {
        this.eBk = mMActivity;
        this.eEX = view;
    }

    public final void av() {
        Integer num = (Integer) af.aap().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || b.aaE()) {
            this.eGG.setVisibility(8);
            return;
        }
        this.eGG.setVisibility(0);
        this.eGH.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.iR(10))) {
            this.eGH.setVisibility(8);
        } else {
            this.eGH.setVisibility(0);
            this.eGH.setText(shareCardInfo.iR(10));
        }
        if (TextUtils.isEmpty("")) {
            this.eGI.setVisibility(8);
            return;
        }
        this.eGI.setVisibility(0);
        this.eGI.setText("");
    }
}
