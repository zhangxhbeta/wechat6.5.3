package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.util.Iterator;

public final class a implements com.tencent.mm.pluginsdk.a.a {
    static {
        b.a(new a(), "//fts");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (v.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -1778527343:
                if (str.equals("hotworderror")) {
                    obj = 2;
                    break;
                }
                break;
            case -975027188:
                if (str.equals("templatetest")) {
                    obj = null;
                    break;
                }
                break;
            case 104187309:
                if (str.equals("msbiz")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                com.tencent.mm.sdk.c.b arVar = new ar();
                arVar.aYn.aYo = 27;
                arVar.aYn.aYo = 1;
                arVar.aYn.filePath = "/sdcard/fts_template.zip";
                com.tencent.mm.sdk.c.a.nhr.z(arVar);
                break;
            case 1:
                ajo Ik = i.Ik();
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = Ik.eeu.iterator();
                while (it.hasNext()) {
                    ajn com_tencent_mm_protocal_c_ajn = (ajn) it.next();
                    stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{l.er(com_tencent_mm_protocal_c_ajn.mdw), Double.valueOf(com_tencent_mm_protocal_c_ajn.mJT), o.F("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_ajn.mJU / 1000)}));
                    stringBuilder.append("\n");
                }
                View textView = new TextView(context);
                textView.setText(stringBuilder.toString());
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16711936);
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493135);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                g.a(context, null, textView, null);
                break;
            case 2:
                ak.yW();
                c.vf().set(87, Long.valueOf(System.currentTimeMillis()));
                break;
        }
        return true;
    }
}
