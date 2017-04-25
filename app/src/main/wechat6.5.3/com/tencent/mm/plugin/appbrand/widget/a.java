package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.q;

public final class a extends LinearLayout {
    public View dUU;
    public TextView dUV;
    public TextView dUW;
    private ImageView dUX;
    private View dUY;
    private View dUZ;
    private ImageButton dVa;
    public ProgressBar dVb;
    public e dVc;
    private boolean dVd = true;
    private boolean dVe = false;
    public OnClickListener dVf = null;
    public OnClickListener dVg = null;
    private long dVh = 0;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ a dVi;
        final /* synthetic */ OnClickListener dVj;

        public AnonymousClass2(a aVar, OnClickListener onClickListener) {
            this.dVi = aVar;
            this.dVj = onClickListener;
        }

        public final void onClick(View view) {
            if (System.currentTimeMillis() - this.dVi.dVh > 250) {
                this.dVj.onClick(view);
                this.dVi.dVh = 0;
            }
            this.dVi.dVh = System.currentTimeMillis();
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.dVe) {
            if (aVar.dVf != null) {
                aVar.dVf.onClick(aVar.dUY);
            }
        } else if (aVar.dVg != null) {
            aVar.dVg.onClick(aVar.dUY);
        }
    }

    public a(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, b.bv(getContext())));
        setGravity(19);
        setBackgroundResource(2131689495);
        addView(q.em(getContext()).inflate(2130903099, this, false));
        this.dUU = findViewById(2131755353);
        this.dUV = (TextView) findViewById(2131755355);
        this.dUW = (TextView) findViewById(2131755356);
        this.dUX = (ImageView) findViewById(2131755351);
        this.dUY = findViewById(2131755350);
        this.dUZ = findViewById(2131755352);
        this.dVa = (ImageButton) findViewById(2131755358);
        this.dVb = (ProgressBar) findViewById(2131755357);
        this.dVc = new e();
        this.dUY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a dVi;

            {
                this.dVi = r1;
            }

            public final void onClick(View view) {
                a.a(this.dVi);
            }
        });
    }

    public final void a(OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.dVa.setVisibility(8);
            return;
        }
        this.dVa.setVisibility(0);
        this.dVa.setOnClickListener(onClickListener);
    }

    public final void Ri(String str) {
        if ("white".equals(str)) {
            this.dVd = true;
        } else if ("black".equals(str)) {
            this.dVd = false;
        }
        if (this.dVd) {
            this.dUX.setImageDrawable(hy(2131165256));
            this.dUZ.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
            this.dUV.setTextColor(-1);
            this.dUW.setTextColor(-1);
            this.dVa.setImageDrawable(hy(2131165201));
            this.dVc.setStrokeColor(-1);
            this.dVb.setLayerType(1, null);
            this.dVb.setIndeterminateDrawable(this.dVc);
            return;
        }
        this.dUX.setImageDrawable(hx(2131165256));
        this.dUZ.setBackgroundColor(Color.parseColor("#4D000000"));
        this.dUV.setTextColor(-16777216);
        this.dUW.setTextColor(-16777216);
        this.dVa.setImageDrawable(hx(2131165201));
        this.dVc.setStrokeColor(-16777216);
        this.dVb.setLayerType(1, null);
        this.dVb.setIndeterminateDrawable(this.dVc);
    }

    public final void bE(boolean z) {
        if (this.dVd) {
            if (z) {
                this.dUX.setImageDrawable(hy(2131165256));
            } else {
                this.dUX.setImageDrawable(hy(2131165257));
            }
        } else if (z) {
            this.dUX.setImageDrawable(hx(2131165256));
        } else {
            this.dUX.setImageDrawable(hx(2131165257));
        }
        this.dVe = z;
    }

    public final void bF(boolean z) {
        this.dUY.setVisibility(z ? 8 : 0);
    }

    private Drawable hx(int i) {
        Drawable c = com.tencent.mm.svg.b.a.c(getResources(), i);
        c.setColorFilter(-16777216, Mode.SRC_ATOP);
        return c;
    }

    private Drawable hy(int i) {
        return com.tencent.mm.svg.b.a.c(getResources(), i);
    }
}
