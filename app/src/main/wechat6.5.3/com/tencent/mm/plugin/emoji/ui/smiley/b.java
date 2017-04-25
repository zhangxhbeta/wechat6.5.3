package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bf.e;
import com.tencent.mm.ui.q;

public final class b extends a {

    class a {
        ImageView eZn;
        final /* synthetic */ b fkz;

        public a(b bVar, View view) {
            this.fkz = bVar;
            this.eZn = (ImageView) view.findViewById(2131759213);
        }
    }

    public b(Context context, f fVar) {
        super(context, fVar);
    }

    public final int getCount() {
        return this.dWc;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = q.em(this.mContext).inflate(2130904409, null);
            f fVar = this.fks;
            if (fVar.fma == 0) {
                fVar.fma = fVar.ahF() / fVar.rQ("TAG_DEFAULT_TAB");
            }
            view.setLayoutParams(new LayoutParams(fVar.fma, this.fks.flW));
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.eZn.setImageResource(2130838085);
            aVar.eZn.setContentDescription(this.mContext.getString(2131232279));
        } else {
            int i2 = ((this.dWc - 1) * this.fkv) + i;
            if (i2 > this.exY - 1) {
                aVar.eZn.setImageDrawable(null);
            } else {
                aVar.eZn.setImageDrawable(e.buQ().hH(i2));
            }
        }
        return view;
    }
}
