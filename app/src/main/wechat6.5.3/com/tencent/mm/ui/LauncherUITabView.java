package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.e.a.hw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class LauncherUITabView extends RelativeLayout implements c {
    protected int fWe = 0;
    private long gvY = 0;
    private com.tencent.mm.ui.c.a nCS;
    private Matrix nDA = new Matrix();
    protected a nDB;
    protected a nDC;
    protected a nDD;
    protected a nDE;
    private int nDi = -1;
    protected OnClickListener nDj = new OnClickListener(this) {
        private final long jUw = 300;
        final /* synthetic */ LauncherUITabView nDF;

        {
            this.nDF = r3;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.nDF.nDi == intValue && intValue == 0 && System.currentTimeMillis() - this.nDF.gvY <= 300) {
                v.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                this.nDF.nDk.removeMessages(0);
                com.tencent.mm.sdk.c.a.nhr.z(new hw());
                this.nDF.gvY = System.currentTimeMillis();
                this.nDF.nDi = intValue;
                return;
            }
            if (this.nDF.nCS != null) {
                if (intValue == 0 && this.nDF.nDi == 0) {
                    this.nDF.nDk.sendEmptyMessageDelayed(0, 300);
                } else {
                    this.nDF.gvY = System.currentTimeMillis();
                    this.nDF.nDi = intValue;
                    this.nDF.nCS.kh(intValue);
                    return;
                }
            }
            this.nDF.gvY = System.currentTimeMillis();
            this.nDF.nDi = intValue;
            v.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
        }
    };
    private ac nDk = new ac(this) {
        final /* synthetic */ LauncherUITabView nDF;

        {
            this.nDF = r1;
        }

        public final void handleMessage(Message message) {
            v.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            this.nDF.nCS.kh(0);
        }
    };
    private int nDl = 0;
    private int nDm = 0;
    private int nDn = 0;
    private boolean nDo = false;
    private int nDp = 0;
    private boolean nDq = false;
    private int nDx;
    private Bitmap nDy;
    private ImageView nDz;

    protected class a {
        final /* synthetic */ LauncherUITabView nDF;
        MMTabView nDG;

        protected a(LauncherUITabView launcherUITabView) {
            this.nDF = launcherUITabView;
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.nCS = aVar;
    }

    private a vz(int i) {
        a aVar = new a(this);
        aVar.nDG = new MMTabView(getContext(), i);
        aVar.nDG.setTag(Integer.valueOf(i));
        aVar.nDG.setOnClickListener(this.nDj);
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(2131690127);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.nDz = new ImageView(getContext());
        this.nDz.setImageMatrix(this.nDA);
        this.nDz.setScaleType(ScaleType.MATRIX);
        this.nDz.setId(2307142);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.nDz, layoutParams);
        a vz = vz(0);
        vz.nDG.setText(2131233694);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(vz.nDG, layoutParams2);
        this.nDB = vz;
        vz = vz(1);
        vz.nDG.setText(2131233695);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(vz.nDG, layoutParams2);
        this.nDC = vz;
        vz = vz(2);
        vz.nDG.setText(2131233693);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(vz.nDG, layoutParams2);
        this.nDD = vz;
        vz = vz(3);
        vz.nDG.setText(2131233722);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131493586));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(vz.nDG, layoutParams2);
        this.nDE = vz;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[]{Integer.valueOf(i3 - i)});
        this.nDx = (i3 - i) / 4;
        int i5 = this.nDx;
        if (this.nDy == null || this.nDy.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.nDy == null ? -1 : this.nDy.getWidth());
            objArr[1] = Integer.valueOf(i5);
            v.w(str, str2, objArr);
            this.nDy = Bitmap.createBitmap(i5, com.tencent.mm.bd.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.nDy).drawColor(getResources().getColor(2131690123));
            f(this.fWe, 0.0f);
            this.nDz.setImageBitmap(this.nDy);
        }
        kg(this.fWe);
    }

    public final void vq(int i) {
        v.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.nDl = i;
        if (i <= 0) {
            this.nDB.nDG.Ob(null);
        } else if (i > 99) {
            this.nDB.nDG.Ob(getContext().getString(2131235710));
        } else {
            this.nDB.nDG.Ob(String.valueOf(i));
        }
    }

    public final void byF() {
        if (this.nDB != null && this.nDC != null && this.nDD != null && this.nDE != null) {
            this.nDB.nDG.bAt();
            this.nDC.nDG.bAt();
            this.nDD.nDG.bAt();
            this.nDE.nDG.bAt();
        }
    }

    public final void vr(int i) {
        this.nDm = i;
        if (i <= 0) {
            this.nDC.nDG.Ob(null);
        } else if (i > 99) {
            this.nDC.nDG.Ob(getContext().getString(2131235710));
        } else {
            this.nDC.nDG.Ob(String.valueOf(i));
        }
    }

    public final void vs(int i) {
        this.nDn = i;
        if (i <= 0) {
            this.nDD.nDG.Ob(null);
        } else if (i > 99) {
            this.nDD.nDG.Ob(getContext().getString(2131235710));
        } else {
            this.nDD.nDG.Ob(String.valueOf(i));
        }
    }

    public final void vt(int i) {
        this.nDp = i;
        if (i <= 0) {
            this.nDE.nDG.Ob(null);
        } else if (i > 99) {
            this.nDE.nDG.Ob(getContext().getString(2131235710));
        } else {
            this.nDE.nDG.Ob(String.valueOf(i));
        }
    }

    public final void iG(boolean z) {
        this.nDo = z;
        this.nDD.nDG.iZ(z);
    }

    public final void iH(boolean z) {
        this.nDq = z;
        this.nDE.nDG.iZ(z);
    }

    public final void f(int i, float f) {
        this.nDA.setTranslate(((float) this.nDx) * (((float) i) + f), 0.0f);
        this.nDz.setImageMatrix(this.nDA);
    }

    public final int byM() {
        return this.fWe;
    }

    public final void kg(int i) {
        this.fWe = i;
        this.nDB.nDG.setTextColor(i == 0 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
        this.nDC.nDG.setTextColor(i == 1 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
        this.nDD.nDG.setTextColor(i == 2 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
        this.nDE.nDG.setTextColor(i == 3 ? getResources().getColorStateList(2131690123) : getResources().getColorStateList(2131690152));
        this.gvY = System.currentTimeMillis();
        this.nDi = this.fWe;
    }

    public final int byG() {
        return this.nDl;
    }

    public final int byH() {
        return this.nDm;
    }

    public final int byI() {
        return this.nDn;
    }

    public final int byJ() {
        return this.nDp;
    }

    public final boolean byK() {
        return this.nDo;
    }

    public final boolean byL() {
        return this.nDq;
    }
}
