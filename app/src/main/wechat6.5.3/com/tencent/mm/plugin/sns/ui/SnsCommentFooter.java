package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
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
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

public class SnsCommentFooter extends BasePanelKeybordLayout {
    private MMActivity aWn;
    private ImageButton hhJ;
    MMEditText hhK;
    private Button hhL;
    private ChatFooterPanel hhM;
    boolean hhN = false;
    public boolean hhO = false;
    private boolean hhP = true;
    boolean hhQ = true;
    private TextWatcher hhR = new TextWatcher(this) {
        final /* synthetic */ SnsCommentFooter jOa;

        {
            this.jOa = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.jOa.hhK.getText() != null) {
                this.jOa.hhK.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && this.jOa.hhQ) {
                    this.jOa.ee(true);
                    this.jOa.hhQ = false;
                }
                if (!z) {
                    this.jOa.ee(false);
                    this.jOa.hhQ = true;
                }
            }
        }
    };
    ImageView jNT;
    Button jNU;
    private String jNV = "";
    private boolean jNW = false;
    a jNX;
    d jNY;
    private bf jNZ;
    avr jkg = null;
    int state = 0;

    class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ SnsCommentFooter jOa;
        final /* synthetic */ b jOe;

        AnonymousClass7(SnsCommentFooter snsCommentFooter, b bVar) {
            this.jOa = snsCommentFooter;
            this.jOe = bVar;
        }

        public final void onClick(View view) {
            this.jOa.jNT.setImageResource(2130838014);
            Animation scaleAnimation = new ScaleAnimation(0.9f, 1.3f, 0.9f, 1.3f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400);
            scaleAnimation.setStartOffset(100);
            scaleAnimation.setRepeatCount(0);
            this.jOa.jNT.startAnimation(scaleAnimation);
            scaleAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ AnonymousClass7 jOf;

                {
                    this.jOf = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    this.jOf.jOa.jNT.setImageResource(2130838011);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            this.jOe.aWI();
        }
    }

    interface a {
        void aWH();
    }

    interface b {
        void aWI();
    }

    interface c {
        void BP(String str);
    }

    interface d {
        void aEU();
    }

    public final boolean aWJ() {
        if (this.hhK.getText() == null || be.kS(this.hhK.getText().toString())) {
            return true;
        }
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
    }

    public final void aWK() {
        ak.yW();
        com.tencent.mm.model.c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        com.tencent.mm.model.c.vf().set(-29414083, Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) inflate(this.aWn, 2130904446, this);
        this.jNT = (ImageView) viewGroup.findViewById(2131759331);
        this.hhL = (Button) viewGroup.findViewById(2131759333);
        this.jNU = (Button) viewGroup.findViewById(2131759334);
        this.hhK = (MMEditText) viewGroup.findViewById(2131759332);
        ee(false);
        this.hhJ = (ImageButton) viewGroup.findViewById(2131757969);
        this.hhJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentFooter jOa;

            {
                this.jOa = r1;
            }

            public final void onClick(View view) {
                this.jOa.hhN = true;
                v.i("MicroMsg.SnsCommentFooter", "state onClick" + this.jOa.state);
                if (this.jOa.state == 0) {
                    this.jOa.aWn.axg();
                    this.jOa.hhK.requestFocus();
                    this.jOa.Tj();
                    this.jOa.hhJ.setImageResource(2130838015);
                    this.jOa.state = 1;
                    this.jOa.hhP = false;
                    return;
                }
                this.jOa.hhP = false;
                this.jOa.hhK.requestFocus();
                this.jOa.aWn.aJs();
                this.jOa.hhJ.setImageResource(2130838010);
                this.jOa.state = 0;
            }
        });
        this.hhK.setHint(this.aWn.getString(2131235571));
        this.hhK.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsCommentFooter jOa;

            {
                this.jOa = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.jOa.hhP = false;
                this.jOa.hhM.setVisibility(8);
                this.jOa.hhM.onPause();
                this.jOa.hhJ.setImageResource(2130838010);
                if (this.jOa.jNX != null) {
                    this.jOa.jNX.aWH();
                }
                this.jOa.state = 0;
                return false;
            }
        });
        if (f.lNK == null) {
            this.hhM = new e(this.aWn);
            return;
        }
        this.hhM = f.lNK.bC(getContext());
        this.hhM.jT(ChatFooterPanel.SCENE_SNS);
        this.hhM.setVisibility(8);
        this.hhM.setBackgroundResource(2130837784);
        ((LinearLayout) findViewById(2131755452)).addView(this.hhM, -1, 0);
        this.hhM.ahm();
        this.hhM.ahn();
        this.hhM.lGm = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ SnsCommentFooter jOa;

            {
                this.jOa = r1;
            }

            public final void ayC() {
            }

            public final void ef(boolean z) {
            }

            public final void Tm() {
                if (this.jOa.hhK != null && this.jOa.hhK.pcq != null) {
                    this.jOa.hhK.pcq.sendKeyEvent(new KeyEvent(0, 67));
                    this.jOa.hhK.pcq.sendKeyEvent(new KeyEvent(1, 67));
                }
            }

            public final void append(String str) {
                try {
                    this.jOa.hhK.PL(str);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z = false;
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        gu(z);
        super.setVisibility(i);
    }

    public final void gu(boolean z) {
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
                return;
            }
            this.hhM.setVisibility(8);
            this.hhJ.setImageResource(2131165970);
            this.aWn.axg();
            requestLayout();
        }
    }

    private void Tj() {
        this.hhM.onResume();
        this.hhM.setVisibility(0);
        if (this.jNY != null) {
            this.jNY.aEU();
        }
        LayoutParams layoutParams = this.hhM.getLayoutParams();
        if (layoutParams != null && j.aF(getContext()) && this.hhP) {
            layoutParams.height = j.aD(getContext());
            this.hhM.setLayoutParams(layoutParams);
            this.hhP = false;
        }
    }

    public final void aWL() {
        if (this.hhK == null) {
            v.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            return;
        }
        this.hhK.removeTextChangedListener(this.hhR);
        this.hhK.addTextChangedListener(this.hhR);
    }

    public final void f(final List<j> list, String str) {
        this.jNV = str;
        if (this.hhK != null) {
            String ah;
            String str2 = "";
            for (j jVar : list) {
                if (str.equals(jVar.apU)) {
                    list.remove(jVar);
                    ah = be.ah(jVar.text, "");
                    break;
                }
            }
            ah = str2;
            if (be.kS(ah)) {
                this.hhK.setText("");
            } else {
                this.jNU.setVisibility(0);
                this.hhL.setVisibility(8);
                this.hhK.setText("");
                this.hhK.PL(ah);
            }
            if (!this.jNW) {
                this.hhK.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ SnsCommentFooter jOa;

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        if (this.jOa.hhK.getText() != null) {
                            j jVar;
                            boolean z;
                            v.d("MicroMsg.SnsCommentFooter", "update commentkey:" + this.jOa.jNV);
                            for (j jVar2 : list) {
                                if (this.jOa.jNV.equals(jVar2.apU)) {
                                    v.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    jVar2.text = this.jOa.hhK.getText().toString();
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                v.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                jVar2 = new j();
                                jVar2.apU = this.jOa.jNV;
                                jVar2.text = this.jOa.hhK.getText().toString();
                                if (jVar2.text != null && jVar2.text.length() > 0) {
                                    list.add(jVar2);
                                }
                            }
                            if (list.size() > 5) {
                                v.d("MicroMsg.SnsCommentFooter", "comments remove");
                                list.remove(0);
                            }
                            this.jOa.hhK.requestFocus();
                            z = editable.length() > 0 && editable.toString().trim().length() > 0;
                            if (z && this.jOa.hhQ) {
                                this.jOa.ee(z);
                                this.jOa.hhQ = false;
                            }
                            if (!z) {
                                this.jOa.ee(z);
                                this.jOa.hhQ = true;
                            }
                        }
                    }
                });
            }
            this.jNW = true;
        }
    }

    public final void a(String str, avr com_tencent_mm_protocal_c_avr) {
        if (be.kS(str)) {
            this.hhK.setHint("");
        } else {
            this.hhK.setHint(com.tencent.mm.pluginsdk.ui.d.e.a(getContext(), str + this.aWn.getString(2131235372, new Object[]{Float.valueOf(this.hhK.getTextSize())})));
        }
        this.jkg = com_tencent_mm_protocal_c_avr;
    }

    public final void aWM() {
        this.hhK.setText("");
        this.hhK.setHint("");
        this.jkg = null;
    }

    public final void BZ(String str) {
        this.hhK.setHint(com.tencent.mm.pluginsdk.ui.d.e.a(getContext(), str, this.hhK.getTextSize()));
    }

    public final avr aWN() {
        if (this.jkg == null) {
            return new avr();
        }
        return this.jkg;
    }

    public final void a(final c cVar) {
        this.jNU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentFooter jOa;

            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.jOa.hhK).yn(com.tencent.mm.h.b.sF());
                yn.oWy = true;
                yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass6 jOd;

                    {
                        this.jOd = r1;
                    }

                    public final void qK(String str) {
                        cVar.BP(this.jOd.jOa.hhK.getText().toString());
                        this.jOd.jOa.hhK.setText("");
                    }

                    public final void adq() {
                    }

                    public final void adr() {
                        g.f(this.jOd.jOa.aWn, 2131235575, 2131235576);
                    }
                });
            }
        });
    }

    public final void aWO() {
        this.jNT.setVisibility(8);
    }

    protected final void mC(int i) {
        super.mC(i);
        switch (i) {
            case -3:
                this.hhO = true;
                if (getVisibility() == 0 && this.jNZ != null) {
                    v.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
                    this.jNZ.aYn();
                    return;
                }
                return;
            default:
                this.hhO = false;
                return;
        }
    }

    public final void ayA() {
        this.jNZ = null;
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
        if (this.hhL != null && this.jNU != null) {
            if (z) {
                if (this.hhL.getVisibility() != 8 && this.hhL.getVisibility() != 4) {
                    this.jNU.startAnimation(loadAnimation);
                    this.jNU.setVisibility(0);
                    this.hhL.startAnimation(loadAnimation2);
                    this.hhL.setVisibility(8);
                } else {
                    return;
                }
            } else if (this.hhL.getVisibility() != 0 && this.hhL.getVisibility() != 0) {
                this.hhL.startAnimation(loadAnimation);
                this.hhL.setVisibility(0);
                this.jNU.startAnimation(loadAnimation2);
                this.jNU.setVisibility(8);
            } else {
                return;
            }
            this.jNU.getParent().requestLayout();
        }
    }

    protected final View ayB() {
        return this.hhM;
    }
}
