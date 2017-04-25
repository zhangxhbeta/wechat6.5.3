package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.ac.b;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends l {
    private int gpT;
    private OnClickListener gpU;

    public final /* bridge */ /* synthetic */ void H(LinkedList linkedList) {
        super.H(linkedList);
    }

    public final /* bridge */ /* synthetic */ void I(LinkedList linkedList) {
        super.I(linkedList);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void b(SparseArray sparseArray) {
        super.b(sparseArray);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(i, view, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final /* bridge */ /* synthetic */ void lu(int i) {
        super.lu(i);
    }

    public final /* bridge */ /* synthetic */ void lx(int i) {
        super.lx(i);
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public final /* bridge */ /* synthetic */ void u(View view, int i) {
        super.u(view, i);
    }

    public final /* bridge */ /* synthetic */ void uo(String str) {
        super.uo(str);
    }

    public final /* bridge */ /* synthetic */ void up(String str) {
        super.up(str);
    }

    public final /* bridge */ /* synthetic */ void uq(String str) {
        super.uq(str);
    }

    public f(Context context) {
        super(context);
        this.gpT = 1;
        this.gpU = new OnClickListener(this) {
            final /* synthetic */ f gpV;

            {
                this.gpV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null && (view.getTag() instanceof b)) {
                    b bVar = (b) view.getTag();
                    c.n(this.gpV.mContext, bVar.gjN.gkT, "game_center_area_recommend");
                    af.a(this.gpV.mContext, bVar.scene, bVar.gjO, bVar.position, 7, null, this.gpV.gjl, bVar.gjN.gkx, null);
                }
            }
        };
        this.guX = 2130903704;
    }

    protected final void a(com.tencent.mm.plugin.game.c.c cVar, b bVar, int i) {
        bVar.gvi.setText(cVar.position);
        Bitmap un = un(cVar.field_appId);
        if (un == null || un.isRecycled()) {
            bVar.goy.setImageResource(2130838303);
        } else {
            bVar.goy.setImageBitmap(un);
        }
        bVar.goz.setText(cVar.field_appName);
        if (be.kS(cVar.ghn)) {
            bVar.gvm.setVisibility(8);
        } else {
            bVar.gvm.setVisibility(0);
            bVar.gvm.setText(cVar.ghn);
        }
        if (be.bP(cVar.ghx)) {
            if (!be.kS(cVar.ghA)) {
                bVar.gvk.setVisibility(0);
                bVar.gvk.setText(cVar.ghA);
                try {
                    bVar.gvk.setBackgroundDrawable(e.bs(Color.parseColor(cVar.ghB), com.tencent.mm.bd.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    v.e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    v.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
                }
            }
            bVar.gvk.setVisibility(8);
        } else {
            bVar.gvk.setVisibility(0);
            bVar.gvk.setText((CharSequence) cVar.ghx.get(0));
        }
        bVar.gvo.lI(this.grA);
        bVar.gvn.setOnClickListener(this.gsq);
        bVar.gvo.setOnClickListener(this.gsq);
        bVar.gvn.setTag(cVar);
        bVar.gvo.setTag(cVar);
        this.grF.a(bVar.gvo, bVar.gvn, cVar, (j) this.gvc.get(cVar.field_appId));
        bVar.gvp.B(cVar.ghv);
    }

    protected final void a(com.tencent.mm.plugin.game.c.c cVar, b bVar) {
        bVar.gvr.removeAllViews();
        if (be.bP(cVar.ghG)) {
            bVar.gvr.setVisibility(8);
            return;
        }
        LayoutParams layoutParams;
        int screenWidth = c.getScreenWidth(this.mContext);
        int size = cVar.ghG.size();
        int paddingLeft = (screenWidth - (bVar.gvr.getPaddingLeft() * 2)) - ((size - 1) * com.tencent.mm.bd.a.fromDPToPix(this.mContext, this.gpT));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        if (paddingLeft <= 0 || size == 0) {
            layoutParams = layoutParams2;
        } else {
            int round = Math.round(((float) paddingLeft) / ((float) size));
            paddingLeft = 0;
            switch (size) {
                case 1:
                    paddingLeft = Math.round(((float) (round * 230)) / 690.0f);
                    break;
                case 2:
                    paddingLeft = Math.round(((float) (round * 230)) / 344.0f);
                    break;
                case 3:
                    paddingLeft = Math.round(((float) (round * 230)) / 230.0f);
                    break;
            }
            if (paddingLeft > 0) {
                layoutParams2 = new LinearLayout.LayoutParams(round, paddingLeft);
            }
            layoutParams = layoutParams2;
        }
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.tencent.mm.bd.a.fromDPToPix(this.mContext, this.gpT), -1);
        Iterator it = cVar.ghG.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            View inflate = View.inflate(this.mContext, 2130903724, null);
            com.tencent.mm.plugin.game.e.e.asK().e((ImageView) inflate.findViewById(2131757313), bVar2.gjN.gmN);
            inflate.setTag(bVar2);
            inflate.setOnClickListener(this.gpU);
            bVar.gvr.addView(inflate, layoutParams);
            View textView = new TextView(this.mContext);
            textView.setBackgroundColor(com.tencent.mm.bd.a.b(this.mContext, 2131690078));
            bVar.gvr.addView(textView, layoutParams3);
        }
        if (bVar.gvr.getChildCount() > 0) {
            bVar.gvr.removeViewAt(bVar.gvr.getChildCount() - 1);
        }
    }
}
