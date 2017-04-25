package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter {
    public int dWc;
    public int exY;
    public f fks;
    public int fkt;
    public int fku;
    public int fkv;
    public String fkw;
    public int fkx;
    public int fky;
    public Context mContext;

    public a(Context context, f fVar) {
        this.mContext = context;
        this.fks = fVar;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.fkt = i;
        this.exY = i2;
        this.dWc = i3;
        this.fku = i4;
        this.fkv = i5;
        this.fkx = i6;
        this.fky = i7;
    }
}
