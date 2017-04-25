package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class r implements a {
    private Context context;

    public r(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(2131232042);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.eO((k.xQ() & 32768) == 0);
    }
}
