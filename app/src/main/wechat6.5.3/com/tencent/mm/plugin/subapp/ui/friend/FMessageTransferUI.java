package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.ui.MMActivity;

public class FMessageTransferUI extends MMActivity {
    private int aRH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        l.KD().kA(stringExtra);
        l.KD().Kt();
        String action = getIntent().getAction();
        String str = "friend_message_accept_" + stringExtra;
        this.aRH = 2130706432 | (Integer.MAX_VALUE & stringExtra.hashCode());
        ak.oH().cancel(this.aRH);
        if (str.equals(action)) {
            a.e(this.nDR.nEl, stringExtra, true);
        }
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
