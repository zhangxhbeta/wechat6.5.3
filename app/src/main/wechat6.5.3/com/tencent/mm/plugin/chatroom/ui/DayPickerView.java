package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.j;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray eOB;
    private a eOC;
    protected b eQc;
    protected int eQd;
    protected long eQe;
    protected int eQf;
    private j eQg;
    private Collection<com.tencent.mm.plugin.chatroom.c.a> eQh;
    long eQi;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQd = 0;
        this.eQf = 0;
        this.eQi = -1;
        if (!isInEditMode()) {
            this.eOB = context.obtainStyledAttributes(attributeSet, R.b.aPa);
            setLayoutParams(new LayoutParams(-1, -1));
            a(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            this.YT = this.eQg;
            setFadingEdgeLength(0);
            this.eQg = new j(this) {
                final /* synthetic */ DayPickerView eQj;

                {
                    this.eQj = r1;
                }

                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    if (((b) recyclerView.getChildAt(0)) != null) {
                        this.eQj.eQe = (long) i2;
                        this.eQj.eQf = this.eQj.eQd;
                    }
                }
            };
        }
    }

    public final void a(a aVar, Collection<com.tencent.mm.plugin.chatroom.c.a> collection) {
        this.eQh = collection;
        this.eOC = aVar;
        if (this.eQc == null) {
            this.eQc = new b(getContext(), this.eOC, this.eOB, this.eQi, collection);
        }
        a(this.eQc);
        aT(this.eQc.getItemCount() - 1);
        this.eQc.Zi.notifyChanged();
    }
}
