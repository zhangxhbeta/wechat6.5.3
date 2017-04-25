package com.tencent.mm.plugin.favorite.ui.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;

public final class n extends a {
    public n(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        return new View(viewGroup.getContext());
    }

    public final void bS(View view) {
        if (view != null) {
            Toast.makeText(view.getContext(), 2131232749, 0).show();
        }
    }
}
