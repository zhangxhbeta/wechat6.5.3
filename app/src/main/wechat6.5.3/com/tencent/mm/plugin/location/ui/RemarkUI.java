package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return 2130904274;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233534);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (be.kS(stringExtra)) {
            findViewById(2131757708).setVisibility(8);
        } else {
            ((TextView) findViewById(2131757709)).setText(stringExtra);
        }
    }

    protected final void s(CharSequence charSequence) {
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            v.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[]{charSequence2});
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                bp bpVar = new bp();
                bpVar.aZd.type = -2;
                bpVar.aZd.aZh = Long.toString(longExtra);
                bpVar.aZd.desc = charSequence2;
                v.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[]{bpVar.aZd.aZh, bpVar.aZd.desc});
                a.nhr.z(bpVar);
            }
        }
    }
}
