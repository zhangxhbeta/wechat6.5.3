package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class p implements a {
    private final Context context;

    public p(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(2131232046);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.eO(true);
    }
}
