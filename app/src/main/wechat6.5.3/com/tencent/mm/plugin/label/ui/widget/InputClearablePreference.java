package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String dHa;
    private String dVK;
    private ImageView gRA;
    public TextView gRB;
    private int gRC;
    public a gRD;
    public String gRu;
    public String gRv;
    public int gRw;
    private int gRx;
    public boolean gRy;
    public MMEditText gRz;

    public interface a {
        void dR(boolean z);

        void vC(String str);
    }

    class b implements InputFilter {
        final /* synthetic */ InputClearablePreference gRE;
        public final char[] gRF = new char[]{'\n', ',', ';', '、', '，', '；'};

        b(InputClearablePreference inputClearablePreference) {
            this.gRE = inputClearablePreference;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            v.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)});
            int i5 = i;
            while (i5 < i2) {
                char[] cArr = new char[(i2 - i)];
                TextUtils.getChars(charSequence, i, i2, cArr, 0);
                for (char c : this.gRF) {
                    if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                        return "";
                    }
                    if (cArr[i5] == c) {
                        this.gRE.dT(true);
                        return "";
                    }
                }
                i5++;
            }
            return null;
        }
    }

    static /* synthetic */ void a(InputClearablePreference inputClearablePreference, boolean z) {
        if (inputClearablePreference.gRA == null) {
            return;
        }
        if (z) {
            inputClearablePreference.gRA.setVisibility(0);
        } else {
            inputClearablePreference.gRA.setVisibility(8);
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        this.dVK = str;
        if (this.gRz != null && !be.kS(str)) {
            this.gRz.setText(e.a(this.mContext, this.dVK, this.gRC));
            vE(this.dVK);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.gRC = com.tencent.mm.bd.a.N(this.mContext, 2131493128);
        this.gRz = (MMEditText) view.findViewById(2131755280);
        this.gRA = (ImageView) view.findViewById(2131758283);
        this.gRB = (TextView) view.findViewById(2131758284);
        if (this.gRz != null) {
            if (this.gRx > 0) {
                this.gRz.setFilters(new InputFilter[]{new LengthFilter(this.gRx), new b(this)});
            } else {
                this.gRz.setFilters(new InputFilter[]{new b(this)});
            }
        }
        this.gRz.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InputClearablePreference gRE;

            {
                this.gRE = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    v.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[]{charSequence.toString()});
                    if (this.gRE.gRD != null) {
                        this.gRE.gRD.vC(charSequence.toString());
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                if (editable != null) {
                    String obj = editable.toString();
                    this.gRE.vE(obj);
                    InputClearablePreference inputClearablePreference = this.gRE;
                    if (!be.kS(obj)) {
                        z = true;
                    }
                    InputClearablePreference.a(inputClearablePreference, z);
                    this.gRE.dVK = obj;
                    return;
                }
                InputClearablePreference.a(this.gRE, false);
            }
        });
        v.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[]{this.dVK});
        setText(this.dVK);
        if (!be.kS(this.dVK)) {
            this.gRz.setSelection(this.dVK.length());
        }
        if (this.gRy) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ InputClearablePreference gRE;

                {
                    this.gRE = r1;
                }

                public final void run() {
                    if (this.gRE.gRz != null) {
                        ((InputMethodManager) this.gRE.gRz.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
                        this.gRE.gRz.requestFocus();
                        this.gRE.gRz.setCursorVisible(false);
                        this.gRE.gRz.setCursorVisible(true);
                    }
                }
            }, 0);
        }
        this.gRz.setHint(this.gRu);
        this.gRA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputClearablePreference gRE;

            {
                this.gRE = r1;
            }

            public final void onClick(View view) {
                if (this.gRE.gRz != null) {
                    this.gRE.gRz.setText("");
                    this.gRE.dVK = "";
                }
            }
        });
        if (this.gRB != null) {
            this.gRB.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ InputClearablePreference gRE;

                {
                    this.gRE = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.gRE.gRz != null) {
                        this.gRE.gRz.clearFocus();
                    }
                    return false;
                }
            });
        }
    }

    private void vE(String str) {
        boolean z = true;
        if (!be.kS(str)) {
            int PC = h.PC(str);
            boolean z2 = PC > this.gRw;
            int aw = h.aw(this.gRw, "");
            int ax = h.ax(this.gRw, str);
            if (this.gRB != null) {
                if (z2) {
                    this.gRB.setText(String.format(this.dHa, new Object[]{Integer.valueOf(aw), Integer.valueOf(ax)}));
                    this.gRB.setVisibility(0);
                } else {
                    this.gRB.setVisibility(8);
                }
            }
            if (this.gRD != null) {
                a aVar = this.gRD;
                if (PC > this.gRw) {
                    z = false;
                }
                aVar.dR(z);
            }
        }
    }

    public final void dT(boolean z) {
        if (this.gRB == null) {
            return;
        }
        if (z) {
            this.gRB.setText(this.gRv);
            this.gRB.setVisibility(0);
            return;
        }
        this.gRB.setVisibility(8);
    }
}
