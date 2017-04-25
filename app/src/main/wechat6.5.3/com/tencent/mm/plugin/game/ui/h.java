package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;

public final class h extends BaseAdapter {
    int CC;
    int gjl;
    private aa gqY;
    private Context mContext;

    private class a {
        public ImageView cHH;
        final /* synthetic */ h gqZ;
        public TextView gra;
        public TextView grb;
        public TextView grc;
        public TextView grd;
        GameDetailRankLikeView gre;

        private a(h hVar) {
            this.gqZ = hVar;
        }
    }

    public h(Context context) {
        this.mContext = context;
    }

    public final void a(aa aaVar) {
        this.gqY = aaVar;
        ad.o(new Runnable(this) {
            final /* synthetic */ h gqZ;

            {
                this.gqZ = r1;
            }

            public final void run() {
                this.gqZ.notifyDataSetChanged();
            }
        });
    }

    public final int getCount() {
        return this.gqY == null ? 0 : this.gqY.gju.size();
    }

    public final Object getItem(int i) {
        return this.gqY.gju.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.CC, viewGroup, false);
            a aVar2 = new a();
            aVar2.gra = (TextView) inflate.findViewById(2131757278);
            aVar2.cHH = (ImageView) inflate.findViewById(2131757279);
            aVar2.grb = (TextView) inflate.findViewById(2131757280);
            aVar2.grc = (TextView) inflate.findViewById(2131757281);
            aVar2.grd = (TextView) inflate.findViewById(2131757282);
            aVar2.gre = (GameDetailRankLikeView) inflate.findViewById(2131757283);
            aVar2.gre.gjl = this.gjl;
            d((ViewGroup) inflate);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.c.aa.a aVar3 = (com.tencent.mm.plugin.game.c.aa.a) getItem(i);
        aVar.gra.setText(aVar3.gjv);
        b.a(aVar.cHH, aVar3.ble, 0.5f, false);
        ak.yW();
        u LX = c.wH().LX(aVar3.ble);
        if (LX != null) {
            aVar.grb.setText(new SpannableString(e.a(this.mContext, LX.tU(), aVar.grb.getTextSize())));
        } else {
            aVar.grb.setText("");
        }
        if (be.kS(aVar3.tag)) {
            aVar.grc.setVisibility(8);
        } else {
            aVar.grc.setVisibility(0);
            aVar.grc.setText(aVar3.tag);
        }
        if (be.kS(aVar3.gjy)) {
            aVar.grd.setText(aVar3.cWZ);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.gre;
            aa aaVar = this.gqY;
            gameDetailRankLikeView.grf = aaVar;
            gameDetailRankLikeView.dzg = aaVar.dzg;
            gameDetailRankLikeView.grg = (com.tencent.mm.plugin.game.c.aa.a) aaVar.gju.get(i);
            gameDetailRankLikeView.asq();
            aVar.gre.setVisibility(0);
        } else {
            aVar.grd.setText(aVar3.gjy);
            aVar.gre.setVisibility(8);
        }
        return view;
    }

    private void d(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                d((ViewGroup) childAt);
            }
        }
    }
}
