package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.u;

public abstract class ProfileItemView extends FrameLayout {
    public u fnD;

    public abstract int aGY();

    public abstract boolean aGZ();

    public abstract void init();

    public ProfileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(aGY(), this);
        init();
    }

    public boolean H(u uVar) {
        this.fnD = uVar;
        return aGZ();
    }
}
