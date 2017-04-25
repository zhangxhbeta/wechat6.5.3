package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.aa;

public class TMAssistantProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":TMAssistantDownloadSDKService");

    public final void onCreate() {
        a.b(aa.getContext(), true);
        i.bk(aQE);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.nhg, TMAssistantProfile.class.getClassLoader());
        k.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return aQE;
    }
}
