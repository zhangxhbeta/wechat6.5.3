package com.tencent.mm.ui.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.bi.a.b;
import com.tencent.mm.sdk.platformtools.v;

public final class bd extends RelativeLayout {
    private LayoutInflater gwU;
    private int ooB;

    public bd(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        this.gwU = layoutInflater;
        this.ooB = i;
        View inflate = this.gwU.inflate(2130903293, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        inflate.setId(2131755025);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(2131493168), 0, getResources().getDimensionPixelSize(2131493168));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        inflate = new TextView(getContext(), null, 2131558644);
        inflate.setId(2131755027);
        inflate.setTextSize(0, (float) a.N(getContext(), b.peS));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2131755025);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(2131493168), 0, getResources().getDimensionPixelSize(2131493168));
        addView(inflate, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(2130903971, this, false);
        checkBox.setId(2131755022);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(2131492962), getResources().getDimensionPixelSize(2131493199), 0);
        layoutParams2.addRule(3, 2131755027);
        layoutParams2.addRule(11);
        layoutParams2.width = fromDPToPix;
        layoutParams2.height = fromDPToPix;
        addView(checkBox, layoutParams2);
        View inflate2 = this.gwU.inflate(this.ooB, null);
        int id = inflate2.getId();
        if (-1 == id) {
            v.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = 2131755023;
            inflate2.setId(2131755023);
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, 2131755027);
        layoutParams2.addRule(0, 2131755022);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(2131755026);
        inflate2.setVisibility(8);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
    }
}
