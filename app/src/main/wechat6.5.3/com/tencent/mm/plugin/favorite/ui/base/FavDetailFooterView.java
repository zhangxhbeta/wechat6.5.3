package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.s;

public class FavDetailFooterView extends TextView {
    public FavDetailFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void x(i iVar) {
        if (iVar != null) {
            if (iVar.field_edittime > 0) {
                setText(getContext().getString(2131232646) + s.e(getContext(), iVar.field_edittime * 1000));
            } else {
                setText(getContext().getString(2131232746) + s.e(getContext(), iVar.field_updateTime));
            }
        }
    }
}
