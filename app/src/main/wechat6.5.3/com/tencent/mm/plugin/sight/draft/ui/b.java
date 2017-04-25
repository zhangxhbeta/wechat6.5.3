package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.g;
import com.tencent.mm.as.k;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.j;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b extends j<com.tencent.mm.as.f> {
    private int eLQ;
    private int eOr;
    a iVW = new a();
    private b iVX = new b();
    private c iVY = new c();
    Set<e> iVZ = new HashSet();
    d iWa = d.NORMAL;
    a iWb;
    public int iWc = 2131235334;
    int iWd = 0;
    private int iWe;
    private int iWf;
    c iWg = new c(this) {
        final /* synthetic */ b iWi;

        {
            this.iWi = r1;
        }

        public final void p(String str, Bitmap bitmap) {
            for (e eVar : this.iWi.iVZ) {
                if (eVar.dgO != null && be.ah(str, SQLiteDatabase.KeyEmpty).equals(eVar.dgO.field_fileName)) {
                    eVar.iWn.s(bitmap);
                    return;
                }
            }
        }
    };
    e iWh;

    private class a implements OnClickListener {
        final /* synthetic */ b iWi;

        private a(b bVar) {
            this.iWi = bVar;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (eVar.dgO == null) {
                    v.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", this.iWi.iWa);
                    aPF();
                    this.iWi.iWh = null;
                    return;
                }
                if (this.iWi.iWh != eVar) {
                    aPF();
                    String kV = g.kV(eVar.dgO.field_fileName);
                    eVar.iWn.fy(true);
                    eVar.iWn.ag(kV, false);
                    eVar.fSE.setBackgroundResource(2130839164);
                    View view2 = eVar.iWm;
                    if (!(view2 == null || com.tencent.mm.compatible.util.d.dX(11))) {
                        Animator animator = (Animator) view2.getTag(2131755064);
                        if (animator != null) {
                            animator.cancel();
                        }
                        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), 2131034114);
                        animatorSet.setTarget(view2);
                        animatorSet.start();
                        view2.setTag(2131755064, animatorSet);
                    }
                    this.iWi.a(eVar);
                    this.iWi.iWh = eVar;
                }
                if (this.iWi.iWb != null) {
                    this.iWi.iWb.a(eVar.dgO);
                }
            }
        }

        public final boolean aPF() {
            if (this.iWi.iWh == null) {
                return false;
            }
            this.iWi.iWh.dMQ.setVisibility(8);
            this.iWi.iWh.iWn.fy(false);
            this.iWi.iWh.iWn.ag(null, false);
            this.iWi.iWh.iWn.s(this.iWi.iWg.l(this.iWi.iWh.dgO.field_fileName, g.kW(this.iWi.iWh.dgO.field_fileName), true));
            this.iWi.iWh.fSE.setBackgroundResource(2130839163);
            com.tencent.mm.ui.tools.j.l(this.iWi.iWh.iWm, 1.0f);
            this.iWi.iWh = null;
            return true;
        }
    }

    private class b implements OnLongClickListener {
        final /* synthetic */ b iWi;

        private b(b bVar) {
            this.iWi = bVar;
        }

        public final boolean onLongClick(View view) {
            if (view.getTag() instanceof e) {
                e eVar = (e) view.getTag();
                if (!(eVar.dgO == null || -1 == eVar.dgO.field_fileStatus)) {
                    this.iWi.a(d.EDIT, true);
                }
            }
            return true;
        }
    }

    private class c implements OnClickListener {
        final /* synthetic */ b iWi;

        private c(b bVar) {
            this.iWi = bVar;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof e) {
                this.iWi.iVW.aPF();
                e eVar = (e) view.getTag();
                if (eVar.dgO == null) {
                    v.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                    return;
                }
                eVar.dgO.field_fileStatus = 6;
                k.KX().a(eVar.dgO, "localId");
                this.iWi.a(null, null);
            }
        }
    }

    public enum d {
        NORMAL,
        EDIT
    }

    private static final class e {
        TextView dMQ;
        com.tencent.mm.as.f dgO;
        View fDt;
        ImageView fSE;
        ImageView iNg;
        View iWm;
        com.tencent.mm.plugin.sight.decode.a.a iWn;
        View iWo;

        private e() {
        }
    }

    private static final class f {
        List<e> iWp;

        private f() {
            this.iWp = new LinkedList();
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.as.f) obj;
        if (obj == null) {
            obj = new com.tencent.mm.as.f();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, a aVar) {
        super(context, null);
        this.iWb = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493571) * 2;
        this.iWe = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.eOr = this.iWe - dimensionPixelSize;
        this.eLQ = (this.eOr * 3) / 4;
        this.iWf = dimensionPixelSize + this.eLQ;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            f fVar2 = new f();
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130904397, view, false);
                e eVar = new e();
                eVar.fDt = inflate;
                eVar.fDt.setTag(eVar);
                eVar.iWm = inflate.findViewById(2131759201);
                eVar.iWn = (com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(2131759202);
                eVar.fSE = (ImageView) inflate.findViewById(2131759203);
                eVar.iWo = inflate.findViewById(2131759205);
                eVar.dMQ = (TextView) inflate.findViewById(2131759204);
                eVar.dMQ.setText(this.iWc);
                eVar.iNg = (ImageView) inflate.findViewById(2131759206);
                fVar2.iWp.add(eVar);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.iWf;
                view.addView(inflate);
                inflate.setOnClickListener(this.iVW);
                eVar.iNg.setTag(eVar);
                eVar.iNg.setOnClickListener(this.iVY);
            }
            view.setTag(fVar2);
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
        }
        for (int i3 = 0; i3 < fVar.iWp.size(); i3++) {
            int i4 = (i * 3) + i3;
            e eVar2 = (e) fVar.iWp.get(i3);
            this.iVZ.add(eVar2);
            eVar2.iWo.setVisibility(8);
            eVar2.dMQ.setVisibility(8);
            eVar2.fSE.setBackgroundResource(2130839163);
            eVar2.iWn.ag(null, false);
            eVar2.iWn.fy(false);
            eVar2.iWn.aPb();
            ((ImageView) eVar2.iWn).setBackgroundResource(0);
            if (i4 >= aij()) {
                eVar2.dgO = null;
                eVar2.fDt.setVisibility(4);
                com.tencent.mm.ui.tools.j.l(eVar2.iWm, 1.0f);
            } else {
                this.iWd--;
                com.tencent.mm.as.f fVar3 = (com.tencent.mm.as.f) getItem(i4);
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    boolean z;
                    eVar2.dgO = fVar3;
                    c cVar = this.iWg;
                    String str = fVar3.field_fileName;
                    String kW = g.kW(fVar3.field_fileName);
                    if (this.iWd <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap l = cVar.l(str, kW, z);
                    ((ImageView) eVar2.iWn).setScaleType(ScaleType.CENTER_CROP);
                    eVar2.iWn.s(l);
                } else {
                    eVar2.dgO = null;
                    eVar2.iWn.aOX();
                }
                if (d.EDIT == this.iWa) {
                    eVar2.iNg.setVisibility(0);
                    com.tencent.mm.ui.tools.j.l(eVar2.iWm, 0.95f);
                } else {
                    eVar2.iNg.setVisibility(8);
                    com.tencent.mm.ui.tools.j.l(eVar2.iWm, 1.0f);
                }
                eVar2.fDt.setVisibility(0);
            }
        }
        return view;
    }

    final void a(e eVar) {
        if (eVar == null) {
            for (e eVar2 : this.iVZ) {
                eVar2.iWo.setVisibility(8);
            }
            return;
        }
        for (e eVar22 : this.iVZ) {
            eVar22.iWo.setVisibility(eVar == eVar22 ? 8 : 0);
        }
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == this.iWa) {
            if (z && this.iWb != null) {
                this.iWb.a(dVar);
            }
            return false;
        }
        this.iWa = dVar;
        this.iVW.aPF();
        notifyDataSetChanged();
        if (z && this.iWb != null) {
            this.iWb.a(dVar);
        }
        return true;
    }

    public final void a(String str, i iVar) {
        this.iVZ.clear();
        super.a(str, iVar);
    }

    public final void Ol() {
        Om();
        super.notifyDataSetChanged();
    }

    protected final void Om() {
        setCursor(k.KX().cie.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"}));
    }

    public final int getCount() {
        return (super.getCount() / 3) + 1;
    }
}
