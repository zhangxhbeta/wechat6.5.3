package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class g implements a {
    static {
        b.a(new g(), "//version");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.lWh, true), Integer.valueOf(d.lWh)}));
        stringBuilder.append(e.bsN());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.aPW)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(h.cVT)}));
        try {
            Map q = bf.q(be.e(context.getAssets().open("merged_features.xml")), "merged");
            if (q != null) {
                for (i = 0; ((String) q.get("merged.feature#" + i)) != null; i++) {
                    stringBuilder.append(String.format("[feature#%02d] %s\n", new Object[]{Integer.valueOf(i), (String) q.get("merged.feature#" + i)}));
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Version", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(2131493135);
        textView.setPadding(i, i, i, i);
        com.tencent.mm.ui.base.g.a(context, null, textView, null);
        return true;
    }
}
