package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.g;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ab;

public class PickBottleUI extends FrameLayout implements OnClickListener, OnTouchListener {
    float density;
    SprayLayout evG;
    PickedBottleImageView evH;
    ImageView evI;
    private b evJ;
    Runnable evK = new Runnable(this) {
        final /* synthetic */ PickBottleUI evO;

        {
            this.evO = r1;
        }

        public final void run() {
            this.evO.evJ = new b();
            this.evO.evJ.a(new a(this) {
                final /* synthetic */ AnonymousClass1 evP;

                {
                    this.evP = r1;
                }

                public final void bo(int i, int i2) {
                    if (this.evP.evO.evG != null && this.evP.evO.evH != null) {
                        this.evP.evO.evG.stop();
                        if (i2 == -2002) {
                            this.evP.evO.evJ = null;
                            this.evP.evO.evl.iA(0);
                            this.evP.evO.evl.iz(2131231508);
                        }
                        if (this.evP.evO.evJ == null) {
                            return;
                        }
                        if (i == 0 && i2 == 0 && this.evP.evO.evJ.etd != -10001) {
                            if (19990 == this.evP.evO.evJ.etd) {
                                j.b(this.evP.evO.evJ.eto, this.evP.evO.evJ.iconUrl, 2130838793);
                            }
                            this.evP.evO.evH.evv = this.evP.evO.evJ.eti;
                            this.evP.evO.evH.eto = this.evP.evO.evJ.eto;
                            this.evP.evO.evH.iconUrl = this.evP.evO.evJ.iconUrl;
                            this.evP.evO.evH.density = this.evP.evO.density;
                            this.evP.evO.evH.show(this.evP.evO.evJ.etd);
                            this.evP.evO.evI.setVisibility(0);
                            this.evP.evO.evJ = null;
                            return;
                        }
                        this.evP.evO.evH.evv = null;
                        this.evP.evO.evH.show(-10001);
                        this.evP.evO.handler.postDelayed(this.evP.evO.evL, 2000);
                    }
                }
            });
        }
    };
    Runnable evL = new Runnable(this) {
        final /* synthetic */ PickBottleUI evO;

        {
            this.evO = r1;
        }

        public final void run() {
            if (this.evO.evH != null && this.evO.evH.isShown()) {
                this.evO.evl.iA(0);
            }
        }
    };
    float evM;
    float evN;
    BottleBeachUI evl;
    ac handler = new ac();
    private boolean hasInit = false;

    public PickBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evl = (BottleBeachUI) context;
    }

    public PickBottleUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evl = (BottleBeachUI) context;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        NI();
    }

    public final void NI() {
        if (!this.hasInit) {
            this.evH = (PickedBottleImageView) findViewById(2131755674);
            this.evG = (SprayLayout) this.evl.findViewById(2131755657);
            this.evI = (ImageView) this.evl.findViewById(2131755656);
            this.evH.setOnClickListener(this);
            if (!be.bui()) {
                setBackgroundResource(2130837742);
            }
            setOnClickListener(this);
            setOnTouchListener(this);
            this.hasInit = true;
        }
    }

    public void setVisibility(int i) {
        this.evG.setVisibility(i);
        this.evH.setVisibility(8);
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (2131755674 == view.getId()) {
            if (this.evH.evv != null) {
                ak.yW();
                c.wK().Mj(this.evH.evv);
                ak.yW();
                ab Mh = c.wK().Mh("floatbottle");
                if (!(Mh == null || be.kS(Mh.field_username))) {
                    Mh.df(g.xD());
                    ak.yW();
                    c.wK().a(Mh, Mh.field_username, true);
                }
            }
            this.evl.onClick(view);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.evM = motionEvent.getX();
            this.evN = motionEvent.getY();
        } else if (action == 1) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            action = getHeight();
            int width = getWidth();
            action = (action * 550) / 800;
            int i = (width - ((width * 120) / 480)) / 2;
            width -= i;
            if (y > ((float) action)) {
                z = true;
            } else if (x < ((float) i) - ((((float) i) * y) / ((float) action))) {
                z = true;
            } else {
                z = x > ((((float) i) * y) / ((float) action)) + ((float) width);
            }
            if (z) {
                if (!this.evH.isShown()) {
                    if (this.evJ != null) {
                        b bVar = this.evJ;
                        ak.vy().b(155, bVar);
                        ak.vy().b(156, bVar);
                        ak.vy().c(bVar.etp);
                        this.evJ = null;
                    }
                    this.handler.removeCallbacks(this.evK);
                    this.handler.removeCallbacks(this.evL);
                    this.evl.iA(0);
                } else if (this.evH.evv == null) {
                    this.evl.iA(0);
                }
            } else if (l(x, y) && l(this.evM, this.evN)) {
                if (this.evH.evv != null) {
                    ak.yW();
                    c.wK().Mj(this.evH.evv);
                    ak.yW();
                    ab Mh = c.wK().Mh("floatbottle");
                    if (!(Mh == null || be.kS(Mh.field_username))) {
                        Mh.df(g.xD());
                        ak.yW();
                        c.wK().a(Mh, Mh.field_username, true);
                    }
                }
                this.evl.onClick(this.evH);
            }
        }
        return true;
    }

    private boolean l(float f, float f2) {
        int height = getHeight();
        int width = getWidth();
        int i = (width * 180) / 480;
        int i2 = (height * 75) / 800;
        float f3 = f - ((float) ((width * 240) / 480));
        float f4 = f2 - ((float) ((height * 495) / 800));
        if (((f4 * f4) / ((float) (i2 * i2))) + ((f3 * f3) / ((float) (i * i))) <= 1.0f) {
            return true;
        }
        return false;
    }
}
