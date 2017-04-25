package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class k extends l {
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

    public k(Context context) {
        super(context);
        this.guX = 2130903740;
    }

    protected final void a(c cVar, b bVar, int i) {
        bVar.gvi.setText(cVar.position);
        bVar.gvi.setVisibility(this.guZ ? 0 : 8);
        Bitmap un = un(cVar.field_appId);
        if (un == null || un.isRecycled()) {
            bVar.goy.setImageResource(2130838303);
        } else {
            bVar.goy.setImageBitmap(un);
        }
        bVar.goz.setText(cVar.field_appName);
        if (be.kS(cVar.ghm)) {
            bVar.gvl.setVisibility(8);
        } else {
            bVar.gvl.setVisibility(0);
            bVar.gvl.setText(cVar.ghm);
        }
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
                    v.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    v.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
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
        bVar.gvq.removeAllViews();
        View view = (View) this.gvd.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.gvq.addView(view);
        }
    }

    protected final void a(c cVar, b bVar) {
        bVar.gvr.removeAllViews();
        if (!be.kS(cVar.ghq)) {
            View inflate = View.inflate(this.mContext, 2130903724, null);
            ImageView imageView = (ImageView) inflate.findViewById(2131757313);
            com.tencent.mm.ae.a.a GL = n.GL();
            String str = cVar.ghq;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPr = true;
            GL.a(str, imageView, aVar.GU());
            bVar.gvr.addView(inflate, new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 100)));
        }
    }
}
