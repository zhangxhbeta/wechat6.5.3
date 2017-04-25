package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.dk;

public final class a extends b<dk> {

    static class a {
        public TextView goA;
        public ImageView goy;
        public TextView goz;

        a() {
        }
    }

    public a(Context context) {
        super(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        dk dkVar = (dk) getItem(i);
        if (view == null) {
            view = View.inflate(this.mContext, 2130903139, null);
            a aVar2 = new a();
            aVar2.goy = (ImageView) view.findViewById(2131755481);
            aVar2.goA = (TextView) view.findViewById(2131755493);
            aVar2.goz = (TextView) view.findViewById(2131755483);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Bitmap un = un(dkVar.gkz);
        if (un == null) {
            aVar.goy.setImageResource(2130837663);
        } else {
            aVar.goy.setImageBitmap(un);
        }
        aVar.goz.setText(g.n(this.mContext, dkVar.gkz));
        if (g.Gv(dkVar.gkz)) {
            aVar.goA.setText(2131233130);
        } else {
            aVar.goA.setText(2131233131);
        }
        return view;
    }
}
