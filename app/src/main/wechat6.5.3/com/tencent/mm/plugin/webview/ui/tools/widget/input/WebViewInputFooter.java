package com.tencent.mm.plugin.webview.ui.tools.widget.input;

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
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    public MMActivity aWn;
    private ImageButton dYv;
    private boolean hhP = true;
    public c lrR;
    public a lrS;
    public b lrT;
    private WebViewSmileyPanel lrU;
    public View lrV;
    private View lrW;
    private View lrX;
    public MMEditText lrY;
    public LinearLayout lrZ;
    public boolean lsa;
    public int lsb = Integer.MAX_VALUE;
    public int state = 0;

    public interface a {
        boolean oI(String str);
    }

    public interface b {
        void bkD();

        void bkE();
    }

    public interface c {
        void Fq(String str);
    }

    static /* synthetic */ void a(WebViewInputFooter webViewInputFooter, boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), 2130968641);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), 2130968642);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (webViewInputFooter.lrW != null && webViewInputFooter.lrX != null) {
            if (z) {
                if (webViewInputFooter.lrW.getVisibility() != 8 && webViewInputFooter.lrW.getVisibility() != 4) {
                    webViewInputFooter.lrX.startAnimation(loadAnimation);
                    webViewInputFooter.lrX.setVisibility(0);
                    webViewInputFooter.lrW.startAnimation(loadAnimation2);
                    webViewInputFooter.lrW.setVisibility(8);
                } else {
                    return;
                }
            } else if (webViewInputFooter.lrW.getVisibility() != 0 && webViewInputFooter.lrW.getVisibility() != 0) {
                webViewInputFooter.lrW.startAnimation(loadAnimation);
                webViewInputFooter.lrW.setVisibility(0);
                webViewInputFooter.lrX.startAnimation(loadAnimation2);
                webViewInputFooter.lrX.setVisibility(8);
            } else {
                return;
            }
            webViewInputFooter.lrX.getParent().requestLayout();
        }
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.aWn, 2130904707, this);
        this.lrZ = (LinearLayout) viewGroup.findViewById(2131760075);
        this.lrW = viewGroup.findViewById(2131760079);
        this.lrX = viewGroup.findViewById(2131760080);
        this.lrV = viewGroup.findViewById(2131760078);
        this.lrY = (MMEditText) viewGroup.findViewById(2131760076);
        this.dYv = (ImageButton) viewGroup.findViewById(2131760077);
        this.dYv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewInputFooter lsc;

            {
                this.lsc = r1;
            }

            public final void onClick(View view) {
                if (this.lsc.state == 0) {
                    this.lsc.aWn.axg();
                    if (!this.lsc.lsa) {
                        this.lsc.lrY.requestFocus();
                    }
                    this.lsc.blH();
                    this.lsc.dYv.setImageResource(2131165971);
                    this.lsc.state = 1;
                    this.lsc.hhP = false;
                    return;
                }
                this.lsc.hhP = false;
                this.lsc.lrY.requestFocus();
                this.lsc.aWn.aJs();
                this.lsc.SR();
                this.lsc.state = 0;
            }
        });
        this.lrY.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewInputFooter lsc;

            {
                this.lsc = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lsc.hhP = false;
                this.lsc.lrU.setVisibility(8);
                this.lsc.dYv.setImageResource(2130838010);
                this.lsc.state = 0;
                return false;
            }
        });
        this.lrU = new WebViewSmileyPanel(getContext());
        this.lrU.setVisibility(8);
        this.lrU.setBackgroundResource(2130837784);
        this.lrU.a(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a(this) {
            final /* synthetic */ WebViewInputFooter lsc;

            {
                this.lsc = r1;
            }

            public final void append(String str) {
                try {
                    if (this.lsc.lsa) {
                        this.lsc.lrS.oI(str);
                    } else {
                        this.lsc.lrY.PL(str);
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
                }
            }

            public final void Tm() {
                if (this.lsc.lsa && this.lsc.lrS != null) {
                    this.lsc.lrS.oI("[DELETE_EMOTION]");
                } else if (this.lsc.lrY != null) {
                    MMEditText d = this.lsc.lrY;
                    if (d.pcq != null) {
                        d.pcq.sendKeyEvent(new KeyEvent(0, 67));
                        d.pcq.sendKeyEvent(new KeyEvent(1, 67));
                        return;
                    }
                    d.dispatchKeyEvent(new KeyEvent(0, 67));
                    d.dispatchKeyEvent(new KeyEvent(1, 67));
                }
            }
        });
        ((LinearLayout) findViewById(2131755452)).addView(this.lrU, -1, 0);
        this.lrX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewInputFooter lsc;

            {
                this.lsc = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.lsc.lrY).yn(this.lsc.lsb);
                yn.oSS = com.tencent.mm.ui.tools.h.a.oST;
                yn.oWy = true;
                yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass4 lsd;

                    {
                        this.lsd = r1;
                    }

                    public final void qK(String str) {
                        if (this.lsd.lsc.lrR != null) {
                            this.lsd.lsc.lrR.Fq(this.lsd.lsc.lrY.getText().toString());
                        }
                        WebViewInputFooter webViewInputFooter = this.lsd.lsc;
                        webViewInputFooter.lrY.clearComposingText();
                        webViewInputFooter.lrY.setText("");
                    }

                    public final void adq() {
                    }

                    public final void adr() {
                        if (this.lsd.lsc.aWn != null) {
                            Toast.makeText(this.lsd.lsc.aWn, "exceed max-length", 0).show();
                        }
                    }
                });
            }
        });
        this.lrY.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ WebViewInputFooter lsc;

            {
                this.lsc = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (this.lsc.lrY.getText() != null) {
                    this.lsc.lrY.requestFocus();
                    boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                    WebViewInputFooter.a(this.lsc, z);
                }
            }
        });
    }

    public final int blH() {
        if (this.lrT != null) {
            this.lrT.bkD();
        }
        if (this.lrY != null) {
            this.aWn.cx(this.lrY);
        }
        this.lrU.setVisibility(0);
        this.lrU.blN();
        LayoutParams layoutParams = this.lrU.getLayoutParams();
        if (layoutParams != null && this.hhP) {
            layoutParams.height = j.aD(getContext());
            this.lrU.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    public final void SR() {
        if (this.lrT != null) {
            this.lrT.bkE();
        }
        this.lrU.setVisibility(8);
        this.dYv.setImageResource(2131165970);
        this.state = 0;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        blI();
        if (!(this.lrY == null || this.aWn == null)) {
            this.aWn.cx(this.lrY);
        }
        this.lrY = null;
        this.lrU.onDestroy();
        removeAllViews();
        this.aWn = null;
        this.lrR = null;
    }

    private void blI() {
        if (this.lrY != null) {
            this.lrY.clearFocus();
            this.lrY.setFocusable(false);
            this.lrY.setFocusableInTouchMode(false);
        }
    }

    public final void hide() {
        setVisibility(8);
        if (this.aWn != null) {
            if (this.lrY != null) {
                this.aWn.cx(this.lrY);
            }
            this.aWn.axg();
        }
        this.state = 0;
        SR();
        blI();
    }

    public final boolean isShown() {
        return getVisibility() == 0;
    }
}
