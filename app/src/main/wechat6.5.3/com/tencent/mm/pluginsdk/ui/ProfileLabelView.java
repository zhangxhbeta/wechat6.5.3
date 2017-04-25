package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ba;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView hUO;
    public TextView lHz;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aGY() {
        return 2130904198;
    }

    public final void init() {
        this.hUO = (TextView) findViewById(2131758663);
        this.lHz = (TextView) findViewById(2131758662);
        setClickable(true);
    }

    public final boolean aGZ() {
        if (this.lHz != null) {
            LayoutParams layoutParams = this.lHz.getLayoutParams();
            layoutParams.width = a.N(getContext(), 2131493077);
            this.lHz.setLayoutParams(layoutParams);
        }
        String str;
        ArrayList arrayList;
        if (!com.tencent.mm.i.a.ei(this.fnD.field_type)) {
            ba Nw;
            String str2 = this.fnD.field_encryptUsername;
            if (be.kS(str2)) {
                ak.yW();
                Nw = c.wI().Nw(this.fnD.field_username);
            } else {
                ak.yW();
                Nw = c.wI().Nw(str2);
            }
            if (Nw != null) {
                str = Nw.field_contactLabels;
                arrayList = (ArrayList) j.a.bmu().vw(str);
                if (!(be.kS(str) || arrayList == null || arrayList.size() <= 0)) {
                    this.hUO.setText(e.a(getContext(), be.b(arrayList, getContext().getResources().getString(2131231967))));
                    return true;
                }
            }
            setVisibility(8);
            return false;
        } else if (k.eo(this.fnD.field_username)) {
            setVisibility(8);
            return false;
        } else {
            str = this.fnD.field_contactLabelIds;
            arrayList = (ArrayList) j.a.bmu().vx(str);
            if (be.kS(str) || arrayList == null || arrayList.size() <= 0) {
                setVisibility(8);
                return false;
            }
            this.hUO.setText(e.a(getContext(), be.b(arrayList, getContext().getResources().getString(2131231967))));
            return true;
        }
    }
}
