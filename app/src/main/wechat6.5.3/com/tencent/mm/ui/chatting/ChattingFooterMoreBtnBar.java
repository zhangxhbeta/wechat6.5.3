package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton fPN;
    private LayoutParams gut;
    private ImageButton onu;
    private ImageButton onv;
    private ImageButton onw;
    private ImageButton onx;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(2130837784);
        this.gut = new LayoutParams(0, getResources().getDimensionPixelSize(2131493198), 1.0f);
        this.gut.topMargin = a.fromDPToPix(getContext(), 0);
        this.onu = new ImageButton(getContext());
        this.onu.setImageResource(2130837930);
        this.onu.setScaleType(ScaleType.CENTER);
        this.onu.setBackgroundResource(0);
        this.onu.setContentDescription(context.getString(2131231847));
        this.onx = new ImageButton(getContext());
        this.onx.setImageResource(2130837928);
        this.onx.setScaleType(ScaleType.CENTER);
        this.onx.setBackgroundResource(0);
        this.onx.setContentDescription(context.getString(2131231846));
        this.fPN = new ImageButton(getContext());
        this.fPN.setImageResource(2130837926);
        this.fPN.setScaleType(ScaleType.CENTER);
        this.fPN.setBackgroundResource(0);
        this.fPN.setContentDescription(context.getString(2131231844));
        this.onw = new ImageButton(getContext());
        this.onw.setImageResource(2130837929);
        this.onw.setScaleType(ScaleType.CENTER);
        this.onw.setBackgroundResource(0);
        this.onw.setContentDescription(context.getString(2131231843));
        this.onv = new ImageButton(getContext());
        this.onv.setImageResource(2130837927);
        this.onv.setScaleType(ScaleType.CENTER);
        this.onv.setBackgroundResource(0);
        this.onv.setContentDescription(context.getString(2131231845));
        bEv();
    }

    public final void bEv() {
        removeAllViews();
        addView(this.onu, this.gut);
        addView(this.onx, this.gut);
        addView(this.fPN, this.gut);
        if (x.bEe().size() > 0) {
            addView(this.onw, this.gut);
        } else {
            addView(this.onv, this.gut);
        }
    }

    public final void xa(int i) {
        boolean z = i > 0;
        this.onu.setClickable(z);
        this.onu.setEnabled(z);
        if (x.bEe().size() > 0) {
            this.onw.setClickable(z);
            this.onw.setEnabled(z);
        } else {
            this.onv.setClickable(z);
            this.onv.setEnabled(z);
        }
        this.fPN.setClickable(z);
        this.fPN.setEnabled(z);
        this.onx.setClickable(z);
        this.onx.setEnabled(z);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.onu.setOnClickListener(onClickListener);
                return;
            case 1:
                this.onv.setOnClickListener(onClickListener);
                return;
            case 2:
                this.onw.setOnClickListener(onClickListener);
                return;
            case 3:
                this.fPN.setOnClickListener(onClickListener);
                return;
            case 4:
                this.onx.setOnClickListener(onClickListener);
                return;
            default:
                v.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                return;
        }
    }
}
