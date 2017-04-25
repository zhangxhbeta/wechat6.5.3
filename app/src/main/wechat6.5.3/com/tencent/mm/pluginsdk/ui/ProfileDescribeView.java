package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ba;

public class ProfileDescribeView extends ProfileItemView {
    public TextView lHp;
    public TextView lHq;

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aGY() {
        return 2130904195;
    }

    public final void init() {
        this.lHp = (TextView) findViewById(2131758659);
        this.lHq = (TextView) findViewById(2131758658);
        setClickable(true);
    }

    public final boolean aGZ() {
        if (this.lHq != null) {
            LayoutParams layoutParams = this.lHq.getLayoutParams();
            layoutParams.width = a.N(getContext(), 2131493077);
            this.lHq.setLayoutParams(layoutParams);
        }
        if (this.fnD == null) {
            setVisibility(8);
            return false;
        }
        String str = this.fnD.bCt;
        if (be.kS(this.fnD.bCu)) {
            boolean z = false;
        } else {
            int i = 1;
        }
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
            if (Nw == null || be.kS(Nw.field_conDescription)) {
                setVisibility(8);
                return false;
            }
            this.lHp.setText(e.a(getContext(), be.ma(Nw.field_conDescription), this.lHp.getTextSize()));
            return true;
        } else if (!be.kS(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(2131165368);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(r0);
            eVar.pbC = (int) ((((float) r0.getIntrinsicHeight()) - this.lHp.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + str);
            r0.setSpan(eVar, 0, 1, 33);
            this.lHp.setText(e.a(getContext(), r0, this.lHp.getTextSize()));
            return true;
        } else if (!be.kS(str) && r0 == 0) {
            this.lHp.setText(e.a(getContext(), be.ma(str), this.lHp.getTextSize()));
            return true;
        } else if (be.kS(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(2131165368);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            com.tencent.mm.ui.widget.e eVar2 = new com.tencent.mm.ui.widget.e(r0);
            eVar2.pbC = (int) ((((float) r0.getIntrinsicHeight()) - this.lHp.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + getContext().getString(2131232142));
            r0.setSpan(eVar2, 0, 1, 33);
            this.lHp.setText(e.a(getContext(), r0, this.lHp.getTextSize()));
            return true;
        } else if (be.kS(str) && r0 == 0) {
            setVisibility(8);
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }
}
