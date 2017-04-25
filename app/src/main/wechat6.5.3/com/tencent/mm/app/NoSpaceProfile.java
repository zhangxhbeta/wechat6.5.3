package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;

public class NoSpaceProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":nospace");

    public final void onCreate() {
        k.b(a.nhg, NoSpaceProfile.class.getClassLoader());
        i.bk(aQE);
        k.setupBrokenLibraryHandler();
        be.ed(aa.getContext());
        k.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
