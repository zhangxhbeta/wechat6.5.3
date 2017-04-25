package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity aWn;
    private ImageButton hhJ;
    private MMEditText hhK;
    private Button hhL;
    private ChatFooterPanel hhM;
    boolean hhN = false;
    public boolean hhO = false;
    private boolean hhP = true;
    boolean hhQ = true;
    private TextWatcher hhR = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyWishFooter hhS;

        {
            this.hhS = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.hhS.hhK.getText() != null) {
                this.hhS.hhK.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && this.hhS.hhQ) {
                    this.hhS.ee(true);
                    this.hhS.hhQ = false;
                }
                if (!z) {
                    this.hhS.ee(false);
                    this.hhS.hhQ = true;
                }
            }
        }
    };
    private int state = 0;

    public interface a {
        void we(String str);
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        ak.yW();
        c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        c.vf().set(-29414083, Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) inflate(this.aWn, 2130903904, this);
        this.hhL = (Button) viewGroup.findViewById(2131757944);
        ee(false);
        this.hhJ = (ImageButton) viewGroup.findViewById(2131757943);
        this.hhJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter hhS;

            {
                this.hhS = r1;
            }

            public final void onClick(View view) {
                this.hhS.hhN = true;
                v.i("MicroMsg.SnsCommentFooter", "state onClick" + this.hhS.state);
                if (this.hhS.state == 0) {
                    this.hhS.aWn.axg();
                    this.hhS.hhK.requestFocus();
                    this.hhS.Tj();
                    this.hhS.hhJ.setImageResource(2131165971);
                    this.hhS.state = 1;
                    this.hhS.hhP = false;
                    return;
                }
                this.hhS.hhP = false;
                this.hhS.hhK.requestFocus();
                this.hhS.hhM.setVisibility(8);
                this.hhS.aWn.aJs();
                this.hhS.hhJ.setImageResource(2131165970);
                this.hhS.state = 0;
            }
        });
        this.hhK = (MMEditText) viewGroup.findViewById(2131757942);
        this.hhK.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter hhS;

            {
                this.hhS = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.hhS.hhP = false;
                this.hhS.hhM.setVisibility(8);
                this.hhS.hhM.onPause();
                this.hhS.hhJ.setImageResource(2130838010);
                this.hhS.state = 0;
                return false;
            }
        });
        if (f.lNK == null) {
            this.hhM = new e(this.aWn);
            return;
        }
        this.hhM = f.lNK.bC(getContext());
        this.hhM.jT(ChatFooterPanel.lGp);
        this.hhM.setVisibility(8);
        this.hhM.setBackgroundResource(2130837784);
        ((LinearLayout) findViewById(2131755452)).addView(this.hhM, -1, 0);
        this.hhM.ahm();
        this.hhM.ahn();
        this.hhM.lGm = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ LuckyMoneyWishFooter hhS;

            {
                this.hhS = r1;
            }

            public final void ayC() {
            }

            public final void ef(boolean z) {
            }

            public final void Tm() {
                this.hhS.hhK.pcq.sendKeyEvent(new KeyEvent(0, 67));
                this.hhS.hhK.pcq.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    this.hhS.hhK.PL(str);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z;
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.hhM != null) {
            v.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    this.aWn.aJs();
                    this.hhK.requestFocus();
                    this.hhM.setVisibility(8);
                } else {
                    this.aWn.axg();
                    this.hhK.requestFocus();
                    Tj();
                }
                this.hhP = false;
            } else {
                this.hhM.setVisibility(8);
                this.hhJ.setImageResource(2131165970);
                this.aWn.axg();
                requestLayout();
            }
        }
        super.setVisibility(i);
    }

    private void Tj() {
        this.hhM.onResume();
        this.hhM.setVisibility(0);
        LayoutParams layoutParams = this.hhM.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && j.aF(getContext()) && this.hhP)) {
            layoutParams.height = j.aD(getContext());
            this.hhM.setLayoutParams(layoutParams);
            this.hhP = false;
        }
    }

    public final void ayz() {
        this.hhK.setFilters(new InputFilter[]{new LengthFilter(25)});
    }

    public final boolean a(com.tencent.mm.ui.widget.MMEditText.a aVar) {
        if (this.hhK == null) {
            return false;
        }
        this.hhK.pcr = aVar;
        return true;
    }

    public final void a(final a aVar) {
        this.hhL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyWishFooter hhS;

            public final void onClick(View view) {
                aVar.we(this.hhS.hhK.getText().toString());
                this.hhS.hhK.setText("");
            }
        });
    }

    protected final void mC(int i) {
        super.mC(i);
        switch (i) {
            case -3:
                this.hhO = true;
                return;
            default:
                this.hhO = false;
                return;
        }
    }

    public final void ayA() {
        if (this.hhM != null) {
            v.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.hhM.ahl();
            this.hhM.destroy();
        }
    }

    private void ee(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968641);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130968642);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.hhL != null) {
            if (z) {
                if (this.hhL.getVisibility() != 8 && this.hhL.getVisibility() != 4) {
                    this.hhL.startAnimation(loadAnimation2);
                    this.hhL.setVisibility(8);
                }
            } else if (this.hhL.getVisibility() != 0 && this.hhL.getVisibility() != 0) {
                this.hhL.startAnimation(loadAnimation);
                this.hhL.setVisibility(0);
            }
        }
    }

    protected final View ayB() {
        return this.hhM;
    }
}
