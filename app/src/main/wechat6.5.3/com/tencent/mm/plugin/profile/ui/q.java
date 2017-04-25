package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class q implements a {
    private Context context;

    public q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(2131232034);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.eO((k.xQ() & 8192) == 0);
    }
}
