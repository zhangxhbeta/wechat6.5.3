package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.h;

public class ThrowBottleUI extends FrameLayout implements OnClickListener, a {
    private static final int[] ewE = new int[]{0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100};
    private static final int[] ewF = new int[]{2130837635, 2130837638, 2130837639, 2130837640, 2130837641, 2130837642, 2130837643, 2130837644, 2130837645, 2130837636, 2130837637};
    ImageView evI;
    BottleBeachUI evl;
    boolean ewA = true;
    d ewG;
    ToneGenerator ewH;
    private long ewI = -1;
    Toast ewJ;
    Vibrator ewK;
    ThrowBottleAnimUI ewL;
    AnimationDrawable ewM;
    ImageView ewN;
    TextView ewO;
    ImageView ewP;
    MMEditText ewQ;
    View ewR;
    Button ewS;
    ImageButton ewT;
    ThrowBottleFooter ewU;
    boolean ewV = false;
    boolean ewW;
    LayoutParams ewX = null;
    private int ewY = 0;
    int ewZ = 0;
    private ThrowBottleAnimUI.a exa = new ThrowBottleAnimUI.a(this) {
        final /* synthetic */ ThrowBottleUI exg;

        {
            this.exg = r1;
        }

        public final void XX() {
            this.exg.ewL.setVisibility(8);
            this.exg.evl.iA(0);
        }
    };
    final ah exb = new ah(new ah.a(this) {
        final /* synthetic */ ThrowBottleUI exg;

        {
            this.exg = r1;
        }

        public final boolean oU() {
            int i = 0;
            if (this.exg.ewG == null) {
                v.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
                return false;
            }
            int maxAmplitude = this.exg.ewG.getMaxAmplitude();
            while (i < ThrowBottleUI.ewF.length) {
                if (maxAmplitude >= ThrowBottleUI.ewE[i] && maxAmplitude < ThrowBottleUI.ewE[i + 1]) {
                    this.exg.ewN.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.exg.evl, ThrowBottleUI.ewF[i]));
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    final ah exc = new ah(new ah.a(this) {
        int count = 0;
        final /* synthetic */ ThrowBottleUI exg;

        {
            this.exg = r2;
        }

        public final boolean oU() {
            if (this.exg.ewI == -1) {
                this.exg.ewI = be.Nj();
            }
            if (this.count % 3 == 2) {
                this.exg.ewO.setWidth(this.exg.ewO.getWidth() + 1);
            }
            this.count++;
            this.count %= 3;
            long az = be.az(this.exg.ewI);
            if (az >= 50000 && az <= 60000) {
                int i;
                if (this.exg.ewJ == null) {
                    i = (int) ((60000 - az) / 1000);
                    this.exg.ewJ = Toast.makeText(this.exg.evl, this.exg.evl.getResources().getQuantityString(2131361794, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - az) / 1000);
                    this.exg.ewJ.setText(this.exg.evl.getResources().getQuantityString(2131361794, i, new Object[]{Integer.valueOf(i)}));
                }
                this.exg.ewJ.show();
            }
            if (az < 60000) {
                return true;
            }
            v.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
            this.exg.ewW = true;
            this.exg.Yg();
            this.exg.ewV = false;
            ao.T(this.exg.evl, 2131235667);
            return false;
        }
    }, true);
    boolean exd = false;
    @SuppressLint({"HandlerLeak"})
    private final ac exe = new ac(this) {
        final /* synthetic */ ThrowBottleUI exg;

        {
            this.exg = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.exg.ewS.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.exg.evl, 2130839043));
            this.exg.ewS.setEnabled(true);
        }
    };
    final h.a exf = new h.a(this) {
        final /* synthetic */ ThrowBottleUI exg;

        {
            this.exg = r1;
        }

        public final void onError() {
            this.exg.ewG.reset();
            this.exg.exb.QI();
            this.exg.exc.QI();
            ab.Kj("keep_app_silent");
            this.exg.ewV = false;
            v.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
            Toast.makeText(this.exg.evl, this.exg.evl.getString(2131231870), 0).show();
        }
    };
    ac handler = new ac();

    public ThrowBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evl = (BottleBeachUI) context;
    }

    public void setVisibility(int i) {
        this.evI.setVisibility(8);
        if (i == 0) {
            this.ewA = true;
            this.ewN.setVisibility(8);
            this.ewO.setVisibility(8);
            this.ewO.setWidth(b.a(this.evl, 120.0f));
            this.ewP.setVisibility(0);
            ((View) this.ewQ.getParent()).setVisibility(8);
            this.ewQ.setText("");
            this.ewU.setVisibility(0);
            c.b(this.ewQ).yn(com.tencent.mm.h.b.sD()).a(null);
            this.ewT.setImageDrawable(com.tencent.mm.bd.a.a(this.evl, 2130838015));
            this.ewS.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.evl, 2130839043));
            this.ewS.setText(this.ewA ? 2131231543 : 2131231540);
            ((LinearLayout) this.evl.findViewById(2131755677)).setVisibility(0);
            this.evl.getWindow().clearFlags(1024);
        } else {
            this.evl.getWindow().setFlags(1024, 1024);
        }
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (2131755685 != view.getId()) {
            this.evl.iA(0);
        } else if (this.ewA || this.ewQ.getText().toString().trim().length() <= 0) {
            Ye();
        } else {
            g.a(this.evl, getResources().getString(2131231537), null, getResources().getString(2131231538), new g.c(this) {
                final /* synthetic */ ThrowBottleUI exg;

                {
                    this.exg = r1;
                }

                public final void gT(int i) {
                    if (i == 0) {
                        this.exg.ewQ.setText("");
                        this.exg.Ye();
                    }
                }
            }, null);
        }
    }

    private void Ye() {
        boolean z;
        int i = 8;
        this.ewO.setVisibility(8);
        this.ewP.setVisibility(this.ewA ? 8 : 0);
        View view = (View) this.ewQ.getParent();
        if (this.ewA) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.ewA) {
            this.ewQ.requestFocus();
        }
        if (this.ewA) {
            z = false;
        } else {
            z = true;
        }
        this.ewA = z;
        this.ewT.setImageDrawable(this.ewA ? com.tencent.mm.bd.a.a(this.evl, 2130838015) : com.tencent.mm.bd.a.a(this.evl, 2130838016));
        if (this.ewA) {
            cb(false);
        } else {
            cb(true);
        }
        this.ewS = (Button) this.evl.findViewById(2131755687);
        this.ewS.setText(this.ewA ? 2131231543 : 2131231540);
    }

    private void Yf() {
        int left;
        int width;
        int i;
        if (this.ewA) {
            left = this.ewO.getLeft();
            int top = this.ewO.getTop();
            width = this.ewO.getWidth();
            i = left;
            left = top;
        } else {
            i = this.ewQ.getLeft();
            width = 0;
            left = this.ewQ.getTop();
        }
        this.ewL = (ThrowBottleAnimUI) this.evl.findViewById(2131755654);
        this.ewL.ewz = this.exa;
        ThrowBottleAnimUI throwBottleAnimUI = this.ewL;
        throwBottleAnimUI.ewA = this.ewA;
        throwBottleAnimUI.VD = i;
        throwBottleAnimUI.VE = left;
        throwBottleAnimUI.ewy = width;
        throwBottleAnimUI.setVisibility(0);
        ad.g(new Runnable(throwBottleAnimUI) {
            final /* synthetic */ ThrowBottleAnimUI ewC;

            {
                this.ewC = r1;
            }

            public final void run() {
                if (this.ewC.evl != null && !this.ewC.evl.isFinishing() && this.ewC.ewr != null && this.ewC.ews != null) {
                    this.ewC.ewr.setVisibility(0);
                    this.ewC.evl.etS = false;
                    this.ewC.evl.iA(-1);
                    this.ewC.Yc();
                    this.ewC.Ya();
                    ThrowBottleAnimUI.f(this.ewC);
                    this.ewC.ews.startAnimation(this.ewC.ewt);
                }
            }
        }, 100);
    }

    private void cb(boolean z) {
        if (z) {
            ((InputMethodManager) this.evl.getSystemService("input_method")).showSoftInput(this.ewQ, 0);
        } else {
            ((InputMethodManager) this.evl.getSystemService("input_method")).hideSoftInputFromWindow(this.ewQ.getWindowToken(), 2);
        }
    }

    public final boolean Yg() {
        v.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
        if (this.exd) {
            boolean ph;
            this.evl.getWindow().getDecorView().setKeepScreenOn(false);
            if (this.ewM != null) {
                this.ewM.stop();
            }
            if (this.ewG != null) {
                ph = this.ewG.ph();
                ab.Kj("keep_app_silent");
                this.exb.QI();
                this.exc.QI();
                this.ewI = -1;
            } else {
                ph = false;
            }
            if (ph) {
                Yf();
            } else {
                this.ewS.setEnabled(false);
                this.ewS.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.evl, 2130839042));
                this.ewN.setVisibility(8);
                this.ewO.setVisibility(8);
                this.exe.sendEmptyMessageDelayed(0, 500);
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    this.evl.iz(2131231539);
                }
            }
        }
        this.exd = false;
        return false;
    }

    public final void bo(int i, int i2) {
        if (i2 == -2002) {
            this.evl.iA(0);
            this.evl.iz(2131231508);
        }
    }
}
