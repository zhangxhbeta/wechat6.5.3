package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.i;

public final class a extends i {
    private a dty;

    public interface a {
        void ND();
    }

    public a(a aVar) {
        super(2, null);
        this.dty = aVar;
    }

    public final void onClick(View view) {
        if (this.dty != null) {
            this.dty.ND();
        }
    }
}
