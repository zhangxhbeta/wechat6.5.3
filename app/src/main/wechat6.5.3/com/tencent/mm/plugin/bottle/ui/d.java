package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public final class d extends Toast {
    Context context;
    private TextView eux = ((TextView) this.view.findViewById(2131755691));
    private View view;

    public d(Context context) {
        super(context);
        this.context = context;
        this.view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130903192, null);
        setGravity(17, 0, 0);
        setDuration(0);
        setView(this.view);
    }

    public final void setText(CharSequence charSequence) {
        this.eux.setText(charSequence);
    }

    public final void setText(int i) {
        setText(this.context.getString(i));
    }

    public final void show() {
        super.show();
    }
}
