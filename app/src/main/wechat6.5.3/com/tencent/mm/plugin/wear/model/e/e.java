package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11013));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(11015));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11013:
                a.nhr.z(new jc());
                break;
            case 11014:
                List bwW = ((d) g.f(d.class)).azI().bwW();
                if (bwW.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    v.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    c.a(aa.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((at) bwW.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                v.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[]{str});
                c.a(aa.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case 11015:
                a.nhr.z(new ln());
                break;
        }
        return null;
    }
}
