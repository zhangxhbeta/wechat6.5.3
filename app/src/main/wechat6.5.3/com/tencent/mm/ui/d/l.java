package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.ScrollAlwaysTextView;

public final class l extends b {
    public ScrollAlwaysTextView nRl;

    public l(Context context) {
        super(context);
        if (this.view != null) {
            this.nRl = (ScrollAlwaysTextView) this.view.findViewById(2131758370);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ l nRm;

                {
                    this.nRm = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    g.iuh.h(11992, Integer.valueOf(1));
                    intent.putExtra("key_scene", 1);
                    c.b((Context) this.nRm.lKT.get(), "music", ".ui.MusicMainUI", intent);
                }
            });
        }
    }

    public final int getLayoutId() {
        return 2130904103;
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(2131758369).setVisibility(i);
        }
    }

    public final void destroy() {
    }
}
