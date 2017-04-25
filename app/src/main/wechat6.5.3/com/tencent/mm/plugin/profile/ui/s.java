package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class s implements a {
    private Context context;

    public s(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(2131232079);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.eO((k.xQ() & 16777216) == 0);
    }
}
