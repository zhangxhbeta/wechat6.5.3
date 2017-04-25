package com.tencent.mm.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.hw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int fWe = 0;
    private long gvY = 0;
    private com.tencent.mm.ui.c.a nCS;
    protected a nCT;
    protected a nCU;
    protected a nCV;
    protected a nCW;
    private int nCX = 0;
    private int nCY;
    private int nCZ;
    private int nDa;
    private int nDb = 0;
    private int nDc;
    private int nDd;
    private int nDe;
    private int nDf;
    private int nDg;
    private int nDh;
    private int nDi = -1;
    protected OnClickListener nDj = new OnClickListener(this) {
        private final long jUw = 300;
        final /* synthetic */ LauncherUIBottomTabView nDr;

        {
            this.nDr = r3;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.nDr.nDi == intValue && intValue == 0 && System.currentTimeMillis() - this.nDr.gvY <= 300) {
                v.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                this.nDr.nDk.removeMessages(0);
                com.tencent.mm.sdk.c.a.nhr.z(new hw());
                this.nDr.gvY = System.currentTimeMillis();
                this.nDr.nDi = intValue;
                return;
            }
            if (this.nDr.nCS != null) {
                if (intValue == 0 && this.nDr.nDi == 0) {
                    v.v("MicroMsg.LauncherUITabView", "do double click check");
                    this.nDr.nDk.sendEmptyMessageDelayed(0, 300);
                } else {
                    v.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    this.nDr.gvY = System.currentTimeMillis();
                    this.nDr.nDi = intValue;
                    this.nDr.nCS.kh(intValue);
                    return;
                }
            }
            this.nDr.gvY = System.currentTimeMillis();
            this.nDr.nDi = intValue;
            v.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
        }
    };
    private ac nDk = new ac(this) {
        final /* synthetic */ LauncherUIBottomTabView nDr;

        {
            this.nDr = r1;
        }

        public final void handleMessage(Message message) {
            v.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            this.nDr.nCS.kh(0);
        }
    };
    private int nDl = 0;
    private int nDm = 0;
    private int nDn = 0;
    private boolean nDo = false;
    private int nDp = 0;
    private boolean nDq = false;

    protected class a {
        final /* synthetic */ LauncherUIBottomTabView nDr;
        View nDs;
        TabIconView nDt;
        TextView nDu;
        TextView nDv;
        ImageView nDw;

        protected a(LauncherUIBottomTabView launcherUIBottomTabView) {
            this.nDr = launcherUIBottomTabView;
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.nCS = aVar;
    }

    private a a(int i, ViewGroup viewGroup) {
        a aVar = new a(this);
        aVar.nDs = q.em(getContext()).inflate(2130903977, viewGroup, false);
        if (com.tencent.mm.bd.a.dt(getContext())) {
            aVar.nDs = q.em(getContext()).inflate(2130903978, viewGroup, false);
        } else {
            aVar.nDs = q.em(getContext()).inflate(2130903977, viewGroup, false);
        }
        aVar.nDt = (TabIconView) aVar.nDs.findViewById(2131756771);
        aVar.nDu = (TextView) aVar.nDs.findViewById(2131758220);
        aVar.nDv = (TextView) aVar.nDs.findViewById(2131758218);
        aVar.nDv.setBackgroundResource(s.eN(getContext()));
        aVar.nDw = (ImageView) aVar.nDs.findViewById(2131758219);
        aVar.nDs.setTag(Integer.valueOf(i));
        aVar.nDs.setOnClickListener(this.nDj);
        return aVar;
    }

    private void init() {
        ViewGroup linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        a a = a(0, linearLayout);
        a.nDu.setText(2131233727);
        a.nDu.setTextColor(getResources().getColor(2131689898));
        a.nDt.g(2131165752, 2131165753, 2131165754, com.tencent.mm.bd.a.dt(getContext()));
        a.nDv.setVisibility(4);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.N(getContext(), 2131493016));
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.nDs, layoutParams);
        this.nCT = a;
        a = a(1, linearLayout);
        a.nDu.setText(2131233695);
        a.nDu.setTextColor(getResources().getColor(2131689899));
        a.nDt.g(2131165749, 2131165750, 2131165751, com.tencent.mm.bd.a.dt(getContext()));
        a.nDv.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.N(getContext(), 2131493016));
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.nDs, layoutParams);
        this.nCV = a;
        a = a(2, linearLayout);
        a.nDu.setText(2131233693);
        a.nDu.setTextColor(getResources().getColor(2131689899));
        a.nDt.g(2131165755, 2131165756, 2131165757, com.tencent.mm.bd.a.dt(getContext()));
        a.nDv.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.N(getContext(), 2131493016));
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.nDs, layoutParams);
        this.nCU = a;
        a = a(3, linearLayout);
        a.nDu.setText(2131233722);
        a.nDu.setTextColor(getResources().getColor(2131689899));
        a.nDt.g(2131165758, 2131165759, 2131165760, com.tencent.mm.bd.a.dt(getContext()));
        a.nDv.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.N(getContext(), 2131493016));
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.nDs, layoutParams);
        this.nCW = a;
        this.nCX = getResources().getColor(2131689898);
        this.nCY = (this.nCX & 16711680) >> 16;
        this.nCZ = (this.nCX & 65280) >> 8;
        this.nDa = this.nCX & WebView.NORMAL_MODE_ALPHA;
        this.nDb = getResources().getColor(2131689899);
        this.nDc = (this.nDb & 16711680) >> 16;
        this.nDd = (this.nDb & 65280) >> 8;
        this.nDe = this.nDb & WebView.NORMAL_MODE_ALPHA;
        this.nDf = this.nCY - this.nDc;
        this.nDg = this.nCZ - this.nDd;
        this.nDh = this.nDa - this.nDe;
    }

    public final void vq(int i) {
        v.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.nDl = i;
        if (i <= 0) {
            this.nCT.nDv.setText(SQLiteDatabase.KeyEmpty);
            this.nCT.nDv.setVisibility(4);
        } else if (i > 99) {
            this.nCT.nDv.setText(getContext().getString(2131235710));
            this.nCT.nDv.setVisibility(0);
            this.nCT.nDw.setVisibility(4);
        } else {
            this.nCT.nDv.setText(String.valueOf(i));
            this.nCT.nDv.setVisibility(0);
            this.nCT.nDw.setVisibility(4);
        }
    }

    public final void byF() {
        if (this.nCT != null && this.nCV != null && this.nCU != null) {
        }
    }

    public final void vr(int i) {
        this.nDm = i;
        if (i <= 0) {
            this.nCV.nDv.setText(SQLiteDatabase.KeyEmpty);
            this.nCV.nDv.setVisibility(4);
        } else if (i > 99) {
            this.nCV.nDv.setText(getContext().getString(2131235710));
            this.nCV.nDv.setVisibility(0);
            this.nCV.nDw.setVisibility(4);
        } else {
            this.nCV.nDv.setText(String.valueOf(i));
            this.nCV.nDv.setVisibility(0);
            this.nCV.nDw.setVisibility(4);
        }
    }

    public final void vs(int i) {
        this.nDn = i;
        if (i <= 0) {
            this.nCU.nDv.setText(SQLiteDatabase.KeyEmpty);
            this.nCU.nDv.setVisibility(4);
        } else if (i > 99) {
            this.nCU.nDv.setText(getContext().getString(2131235710));
            this.nCU.nDv.setVisibility(0);
            this.nCU.nDw.setVisibility(4);
        } else {
            this.nCU.nDv.setText(String.valueOf(i));
            this.nCU.nDv.setVisibility(0);
            this.nCU.nDw.setVisibility(4);
        }
    }

    public final void iG(boolean z) {
        int i = 4;
        this.nDo = z;
        this.nCU.nDv.setVisibility(4);
        ImageView imageView = this.nCU.nDw;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void vt(int i) {
        this.nDp = i;
        if (i <= 0) {
            this.nCW.nDv.setText(SQLiteDatabase.KeyEmpty);
            this.nCW.nDv.setVisibility(4);
        } else if (i > 99) {
            this.nCW.nDv.setText(getContext().getString(2131235710));
            this.nCW.nDv.setVisibility(0);
            this.nCW.nDw.setVisibility(4);
        } else {
            this.nCW.nDv.setText(String.valueOf(i));
            this.nCW.nDv.setVisibility(0);
            this.nCW.nDw.setVisibility(4);
        }
    }

    public final void iH(boolean z) {
        int i = 4;
        this.nDq = z;
        this.nCW.nDv.setVisibility(4);
        ImageView imageView = this.nCW.nDw;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void f(int i, float f) {
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.nDf) * f) + ((float) this.nDc))) << 16) + (((int) ((((float) this.nDg) * f) + ((float) this.nDd))) << 8)) + ((int) ((((float) this.nDh) * f) + ((float) this.nDe)))) + WebView.NIGHT_MODE_COLOR;
        int i5 = (((((int) ((((float) this.nDf) * (1.0f - f)) + ((float) this.nDc))) << 16) + (((int) ((((float) this.nDg) * (1.0f - f)) + ((float) this.nDd))) << 8)) + ((int) ((((float) this.nDh) * (1.0f - f)) + ((float) this.nDe)))) + WebView.NIGHT_MODE_COLOR;
        switch (i) {
            case 0:
                this.nCT.nDt.vR(i3);
                this.nCV.nDt.vR(i2);
                this.nCT.nDu.setTextColor(i5);
                this.nCV.nDu.setTextColor(i4);
                return;
            case 1:
                this.nCV.nDt.vR(i3);
                this.nCU.nDt.vR(i2);
                this.nCV.nDu.setTextColor(i5);
                this.nCU.nDu.setTextColor(i4);
                return;
            case 2:
                this.nCU.nDt.vR(i3);
                this.nCW.nDt.vR(i2);
                this.nCU.nDu.setTextColor(i5);
                this.nCW.nDu.setTextColor(i4);
                return;
            default:
                return;
        }
    }

    public final int byM() {
        return this.fWe;
    }

    public final void kg(int i) {
        this.fWe = i;
        switch (i) {
            case 0:
                this.nCT.nDt.vR(WebView.NORMAL_MODE_ALPHA);
                this.nCU.nDt.vR(0);
                this.nCV.nDt.vR(0);
                this.nCW.nDt.vR(0);
                this.nCT.nDu.setTextColor(this.nCX);
                this.nCU.nDu.setTextColor(this.nDb);
                this.nCV.nDu.setTextColor(this.nDb);
                this.nCW.nDu.setTextColor(this.nDb);
                break;
            case 1:
                this.nCT.nDt.vR(0);
                this.nCU.nDt.vR(0);
                this.nCV.nDt.vR(WebView.NORMAL_MODE_ALPHA);
                this.nCW.nDt.vR(0);
                this.nCT.nDu.setTextColor(this.nDb);
                this.nCU.nDu.setTextColor(this.nDb);
                this.nCV.nDu.setTextColor(this.nCX);
                this.nCW.nDu.setTextColor(this.nDb);
                break;
            case 2:
                this.nCT.nDt.vR(0);
                this.nCU.nDt.vR(WebView.NORMAL_MODE_ALPHA);
                this.nCV.nDt.vR(0);
                this.nCW.nDt.vR(0);
                this.nCT.nDu.setTextColor(this.nDb);
                this.nCU.nDu.setTextColor(this.nCX);
                this.nCV.nDu.setTextColor(this.nDb);
                this.nCW.nDu.setTextColor(this.nDb);
                break;
            case 3:
                this.nCT.nDt.vR(0);
                this.nCU.nDt.vR(0);
                this.nCV.nDt.vR(0);
                this.nCW.nDt.vR(WebView.NORMAL_MODE_ALPHA);
                this.nCT.nDu.setTextColor(this.nDb);
                this.nCU.nDu.setTextColor(this.nDb);
                this.nCV.nDu.setTextColor(this.nDb);
                this.nCW.nDu.setTextColor(this.nCX);
                break;
        }
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
