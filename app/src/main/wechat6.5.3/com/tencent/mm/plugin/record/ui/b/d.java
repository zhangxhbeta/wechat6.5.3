package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.d.e;

public final class d implements b {
    public final View cq(Context context) {
        return View.inflate(context, 2130904259, null);
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(2131758844);
        textView.setText(bVar.bdE.desc);
        e.e(textView, 1);
    }

    public final void destroy() {
    }
}
