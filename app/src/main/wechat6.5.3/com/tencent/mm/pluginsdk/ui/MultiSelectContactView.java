package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.model.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater gwU;
    private HorizontalScrollView lHa;
    private LinearLayout lHb;
    private View lHc;
    public MMEditText lHd;
    private List<String> lHe;
    private Animation lHf;
    private int lHg;
    private View lHh;
    public a lHi;
    public b lHj;
    public c lHk;
    private List<View> lHl;
    boolean lHm;
    private int padding;

    public interface a {
        void mf(String str);
    }

    public interface b {
        void Ht(String str);
    }

    public interface c {
        void boK();
    }

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        if (multiSelectContactView.lHb.getChildCount() != 0) {
            View childAt = multiSelectContactView.lHb.getChildAt(multiSelectContactView.lHb.getChildCount() - 1);
            if (multiSelectContactView.lHm) {
                multiSelectContactView.a(childAt, true, false);
                multiSelectContactView.lHm = false;
            } else {
                multiSelectContactView.lHm = true;
                multiSelectContactView.boH();
                childAt.findViewById(2131759032).setVisibility(0);
            }
            multiSelectContactView.lHd.requestFocus();
        }
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lHg = 0;
        this.padding = 0;
        this.lHm = false;
        this.padding = getResources().getDimensionPixelSize(2131492962);
        this.gwU = LayoutInflater.from(context);
        this.gwU.inflate(2130904106, this, true);
        this.lHa = (HorizontalScrollView) findViewById(2131758382);
        this.lHd = (MMEditText) findViewById(2131756569);
        this.lHb = (LinearLayout) findViewById(2131758383);
        this.lHc = findViewById(2131756568);
        this.lHe = new LinkedList();
        this.lHf = AnimationUtils.loadAnimation(context, 2130968622);
        com.tencent.mm.ui.tools.a.c.b(this.lHd).yn(100).a(null);
        this.lHh = findViewById(2131755452);
        this.lHd.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.lHn.boG();
                if (this.lHn.lHj != null) {
                    this.lHn.lHj.Ht(charSequence.toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.lHd.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0 && this.lHn.lHd.getSelectionStart() == 0 && this.lHn.lHd.getSelectionEnd() == 0) {
                    MultiSelectContactView.d(this.lHn);
                }
                return false;
            }
        });
        this.lHl = new ArrayList();
        this.lHd.clearFocus();
        this.lHd.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.lHn.lHh.setBackgroundResource(2130838423);
                    this.lHn.lHh.setPadding(this.lHn.padding, this.lHn.padding, this.lHn.padding, this.lHn.padding);
                } else {
                    this.lHn.lHh.setBackgroundResource(2130838424);
                    this.lHn.lHh.setPadding(this.lHn.padding, this.lHn.padding, this.lHn.padding, this.lHn.padding);
                }
                if (this.lHn.lHk != null) {
                    this.lHn.lHk.boK();
                }
            }
        });
        setBackgroundColor(-201326593);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final void onClick(View view) {
            }
        });
    }

    public void clearFocus() {
        this.lHd.clearFocus();
        boG();
    }

    public final void Hq(String str) {
        if (!be.kS(str)) {
            if (this.lHe.contains(str)) {
                v.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
                return;
            }
            boG();
            View Hs = Hs(str);
            if (Hs != null) {
                a(Hs, false, false);
            } else {
                aD(str, true);
            }
        }
    }

    public final void Hr(String str) {
        View Hs = Hs(str);
        if (Hs != null) {
            a(Hs, false, false);
        }
    }

    private void boG() {
        if (this.lHb.getChildCount() != 0 && this.lHm) {
            View childAt = this.lHb.getChildAt(this.lHb.getChildCount() - 1);
            this.lHm = false;
            childAt.findViewById(2131759032).setVisibility(8);
        }
    }

    public final void aD(String str, boolean z) {
        tO(this.lHb.getChildCount() + 1);
        View inflate = this.gwU.inflate(2130904322, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(2131756854);
        com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        imageView.setContentDescription(l.er(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final void onClick(View view) {
                this.lHn.a(view, true, true);
            }
        });
        if (z) {
            inflate.startAnimation(this.lHf);
        }
        this.lHb.addView(inflate);
        boI();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(2131493004);
        layoutParams.width = getResources().getDimensionPixelSize(2131493004);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(2131492962);
        inflate.setLayoutParams(layoutParams);
        boH();
    }

    private void a(final View view, boolean z, boolean z2) {
        if (z && this.lHi != null) {
            this.lHi.mf(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968623);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ MultiSelectContactView lHn;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 lHo;

                        {
                            this.lHo = r1;
                        }

                        public final void run() {
                            this.lHo.lHn.lHb.removeView(view);
                            this.lHo.lHn.boI();
                            this.lHo.lHn.tO(this.lHo.lHn.lHb.getChildCount());
                        }
                    });
                }
            });
            view.startAnimation(loadAnimation);
            return;
        }
        this.lHb.removeView(view);
        boI();
        tO(this.lHb.getChildCount());
    }

    private void boH() {
        this.lHb.post(new Runnable(this) {
            final /* synthetic */ MultiSelectContactView lHn;

            {
                this.lHn = r1;
            }

            public final void run() {
                this.lHn.lHa.scrollTo(this.lHn.lHb.getMeasuredWidth(), 0);
            }
        });
    }

    private void tO(int i) {
        if (this.lHg <= 0) {
            this.lHg += getResources().getDimensionPixelSize(2131493138);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 40.0f);
            int measureText = (int) this.lHd.getPaint().measureText(getContext().getString(2131231148));
            this.lHg = Math.max(a, measureText) + this.lHg;
        }
        if (this.lHg > 0) {
            measureText = this.lHh.getWidth();
            v.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(2131493004) + getResources().getDimensionPixelSize(2131492962))), Integer.valueOf(this.lHg));
            LayoutParams layoutParams = (LayoutParams) this.lHa.getLayoutParams();
            if (measureText - (i * (getResources().getDimensionPixelSize(2131493004) + getResources().getDimensionPixelSize(2131492962))) > this.lHg) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = measureText - this.lHg;
            }
        }
    }

    private void boI() {
        if (this.lHb.getChildCount() == 0) {
            this.lHc.setVisibility(0);
        } else {
            this.lHc.setVisibility(8);
        }
    }

    public final String boJ() {
        return this.lHd.getText().toString();
    }

    private View Hs(String str) {
        int childCount = this.lHb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lHb.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                return childAt;
            }
        }
        return null;
    }
}
