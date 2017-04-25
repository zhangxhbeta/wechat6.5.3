package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.h.b;
import com.tencent.mm.plugin.h.c;
import com.tencent.mm.plugin.h.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            return;
        }
        c cVar = new c();
        b dVar = new d();
        cVar.iTp.put(dVar.getType(), dVar);
        int a = r.a(intent, "type", 0);
        if (intent != null) {
            b bVar = (b) cVar.iTp.get(a);
            if (bVar != null) {
                bVar.p(this, intent);
            }
        }
        finish();
    }
}
