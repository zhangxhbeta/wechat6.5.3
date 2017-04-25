package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sight.draft.ui.b.d;
import com.tencent.mm.ui.base.g;

public class SightDraftContainerView extends ListView {
    private boolean iWq;
    private a iWr;
    public b iWs;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightDraftContainerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(2131689547));
        setSelector(2131690078);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493199);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493135);
        View textView = new TextView(getContext());
        textView.setText(2131235338);
        textView.setTextSize(0, (float) a.N(getContext(), 2131493128));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(2131689793));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SightDraftContainerView iWt;

            {
                this.iWt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.iWt.aPI();
                return false;
            }
        });
    }

    public final void aPG() {
        if (this.iWq) {
            this.iWs.iWd = 12;
            this.iWs.a(d.NORMAL, false);
            this.iWs.a(null, null);
            setSelection(0);
            return;
        }
        this.iWq = true;
        this.iWs = new b(getContext(), this.iWr);
        this.iWs.iWd = 12;
        setAdapter(this.iWs);
    }

    public final void clearCache() {
        if (this.iWs != null) {
            b bVar = this.iWs;
            c cVar = bVar.iWg;
            cVar.iWv = null;
            cVar.iWu.clear();
            bVar.iVZ.clear();
        }
    }

    public final void aPH() {
        clearAnimation();
        startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968670));
    }

    public final void a(a aVar) {
        this.iWr = aVar;
        if (this.iWs != null) {
            this.iWs.iWb = aVar;
        }
    }

    public final boolean aPI() {
        if (this.iWs == null) {
            return false;
        }
        b bVar = this.iWs;
        bVar.a(null);
        return bVar.iVW.aPF();
    }

    private boolean aPJ() {
        int i;
        Cursor rawQuery = k.KX().cie.rawQuery("SELECT COUNT(localId) FROM SightDraftInfo WHERE fileStatus = 6", null);
        if (rawQuery == null) {
            i = 0;
        } else {
            i = rawQuery.moveToFirst() ? rawQuery.getInt(0) : 0;
            rawQuery.close();
        }
        if (i <= 0) {
            return false;
        }
        k.KX().KQ();
        this.iWs.a(null, null);
        g.bf(getContext(), getResources().getString(2131235340));
        return true;
    }

    public final void aPK() {
        if (this.iWs != null) {
            d dVar;
            if (d.NORMAL == this.iWs.iWa) {
                dVar = d.EDIT;
            } else {
                dVar = d.NORMAL;
            }
            b(dVar);
        }
    }

    private boolean b(d dVar) {
        if (this.iWs == null) {
            return false;
        }
        return this.iWs.a(dVar, true);
    }

    public final boolean fG(boolean z) {
        if (z) {
            aPJ();
            b(d.NORMAL);
        } else if (aPJ() || b(d.NORMAL)) {
            return true;
        } else {
            if (aPI()) {
                return true;
            }
        }
        return false;
    }
}
