package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;

public final class g extends f {
    private int eZu = 0;
    private int eZv = 0;
    private int eZw = 0;

    public final /* synthetic */ Object getItem(int i) {
        return super.jG(i);
    }

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        final a aVar = (a) view.getTag();
        if (this.eZu > 0) {
            if (i == 0) {
                aVar.eYS.setVisibility(0);
                aVar.eYS.setText(this.mContext.getString(2131232381));
            } else if (this.eZv > 0 && i == this.eZu) {
                aVar.eYS.setVisibility(0);
                aVar.eYS.setText(this.mContext.getString(2131232393));
            } else if (i == this.eZu + this.eZv) {
                aVar.eYS.setVisibility(0);
                aVar.eYS.setText(this.mContext.getString(2131232367));
            } else {
                aVar.eYS.setVisibility(8);
            }
        } else if (this.eZv > 0) {
            if (i == 0) {
                aVar.eYS.setVisibility(0);
                aVar.eYS.setText(this.mContext.getString(2131232393));
            } else if (i == this.eZu + this.eZv) {
                aVar.eYS.setVisibility(0);
                aVar.eYS.setText(this.mContext.getString(2131232367));
            } else {
                aVar.eYS.setVisibility(8);
            }
        }
        if (aVar.eYU != null) {
            aVar.eYU.postDelayed(new Runnable(this) {
                final /* synthetic */ g eZy;

                public final void run() {
                    aVar.eYU.setPressed(false);
                }
            }, 100);
        }
        return super.b(i, view, viewGroup);
    }

    public final f jG(int i) {
        return super.jG(i);
    }

    public final int aeI() {
        return this.eZu;
    }

    public final void jD(int i) {
        this.eZu = i;
    }

    public final int aeJ() {
        return this.eZv;
    }

    public final void jE(int i) {
        this.eZv = i;
    }

    public final int aeK() {
        return this.eZw;
    }

    public final void jF(int i) {
        this.eZw = i;
    }
}
