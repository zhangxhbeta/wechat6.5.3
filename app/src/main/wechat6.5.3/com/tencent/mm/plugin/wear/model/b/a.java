package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.aa;

public final class a {
    public static void A(Bundle bundle) {
        Intent intent = new Intent();
        intent.setPackage(aa.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        aa.getContext().sendBroadcast(intent);
    }
}
