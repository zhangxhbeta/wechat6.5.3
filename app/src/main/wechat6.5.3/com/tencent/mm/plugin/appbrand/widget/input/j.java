package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public final class j extends EditText implements com.tencent.mm.plugin.appbrand.widget.input.b.a {
    InputConnection dYG;
    private int dYH = 0;
    private int dYI = 0;
    private int dYJ = 0;
    private int dYK = 0;
    private boolean dYL = true;
    boolean dYM = false;
    boolean dYN = false;
    private boolean dYO = false;
    private int dYP = 0;
    private int dYQ = 0;
    private final Runnable dYR = new Runnable(this) {
        final /* synthetic */ j dYU;

        {
            this.dYU = r1;
        }

        public final void run() {
            this.dYU.setPadding(this.dYU.dYP + this.dYU.dYH, this.dYU.dYQ + this.dYU.dYJ, this.dYU.dYI, this.dYU.dYK);
        }
    };
    private boolean dYi = false;
    final PasswordTransformationMethod fVJ = new c();
    private final ac ihw = new ac(Looper.getMainLooper());
    boolean lUT = false;
    private boolean lqT = true;
    private final b pQX = new b();
    private boolean pQY;

    private static final class a implements CharSequence {
        private CharSequence dYX;

        a(CharSequence charSequence) {
            this.dYX = charSequence;
        }

        public final int length() {
            return this.dYX.length();
        }

        public final char charAt(int i) {
            return '●';
        }

        public final CharSequence subSequence(int i, int i2) {
            return this.dYX.subSequence(i, i2);
        }
    }

    private final class b implements TextWatcher {
        final /* synthetic */ j dYU;
        final Set<TextWatcher> pQZ;

        private b(j jVar) {
            this.dYU = jVar;
            this.pQZ = new HashSet();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.dYU.dYM) {
                for (TextWatcher beforeTextChanged : this.pQZ) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.dYU.dYM) {
                for (TextWatcher onTextChanged : this.pQZ) {
                    onTextChanged.onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void afterTextChanged(final Editable editable) {
            if (a.SJ()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a = j.a(editable, pBool, pInt);
                final int i = pInt.value;
                if (pBool.value && !be.kS(a)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean z = this.dYU.dYM;
                    this.dYU.post(new Runnable(this) {
                        final /* synthetic */ b dZb;

                        public final void run() {
                            if (z) {
                                this.dZb.dYU.I(a);
                            } else {
                                this.dZb.dYU.setText(a);
                            }
                            try {
                                this.dZb.dYU.setSelection(Math.min(selectionEnd + i, a.length()));
                            } catch (Exception e) {
                                v.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[]{e});
                            }
                        }
                    });
                    return;
                }
            }
            if (!this.dYU.dYM) {
                if (be.D(editable)) {
                    this.dYU.lqT = true;
                } else if (this.dYU.lqT) {
                    this.dYU.lqT = false;
                    if (this.dYU.lUT) {
                        this.dYU.ihw.postAtFrontOfQueueV2(new Runnable(this) {
                            final /* synthetic */ b dZb;

                            public final void run() {
                                this.dZb.dYU.I(editable);
                            }
                        });
                    }
                }
                for (TextWatcher afterTextChanged : this.pQZ) {
                    afterTextChanged.afterTextChanged(editable);
                }
            }
        }
    }

    private static final class c extends PasswordTransformationMethod {
        private c() {
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            return new a(charSequence);
        }
    }

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            com.tencent.mm.bf.c vb = com.tencent.mm.bf.b.buL().vb(codePointAt);
            if (vb == null || vb.nnp == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(vb.nnp) + (vb.nnq != 0 ? Character.toChars(vb.nnq) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    public j(Context context) {
        super(context);
        setIncludeFontPadding(false);
        hL(3);
        setSingleLine(true);
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(2130837655));
        } catch (Throwable e) {
            v.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[]{be.e(e)});
        }
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(getLineSpacingExtra(), 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.pQX);
        this.pQY = true;
    }

    final void hL(int i) {
        setGravity(((this.dYL ? 16 : 48) | (-8388614 & (getGravity() & -8388612))) | i);
    }

    public final void setSelection(int i) {
        super.setSelection(i);
    }

    public final void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.dYG = super.onCreateInputConnection(editorInfo);
        return this.dYG;
    }

    public final void setText(CharSequence charSequence, BufferType bufferType) {
        if (!this.pQY) {
            super.setText(charSequence, bufferType);
        } else if ((charSequence == null || charSequence.length() <= 0) && getEditableText() != null) {
            getEditableText().clear();
        } else {
            super.setText(charSequence, bufferType);
            try {
                setSelection(getEditableText().length());
            } catch (Exception e) {
            }
        }
    }

    final void I(CharSequence charSequence) {
        this.dYM = true;
        setText(charSequence);
        this.dYM = false;
    }

    public final boolean SK() {
        return this.dYN;
    }

    public final void setSingleLine(boolean z) {
        if (z != this.dYL) {
            super.setSingleLine(z);
            this.dYL = z;
            if (this.dYL) {
                setVerticalScrollBarEnabled(true);
                setVerticalScrollbarPosition(2);
            }
        }
    }

    public final void setTextSize(float f) {
        this.dYO = false;
        super.setTextSize(f);
    }

    public final void setTextSize(int i, float f) {
        this.dYO = false;
        super.setTextSize(i, f);
    }

    public final void setTypeface(Typeface typeface) {
        this.dYO = false;
        super.setTypeface(typeface);
    }

    public final void setTypeface(Typeface typeface, int i) {
        this.dYO = false;
        super.setTypeface(typeface, i);
    }

    protected final void onDraw(Canvas canvas) {
        if (!this.dYO) {
            float height = ((float) (getHeight() - getBaseline())) - ((((float) getHeight()) - getTextSize()) / 2.0f);
            v.v("MicroMsg.AppBrand.WebEditText", "height = %d, baseline = %d, textSize = %f, yOffset = %f", new Object[]{Integer.valueOf(getHeight()), Integer.valueOf(getBaseline()), Float.valueOf(getTextSize()), Float.valueOf(height)});
            this.dYP = 0;
            this.dYQ = 0;
            post(this.dYR);
            this.dYO = true;
        }
        super.onDraw(canvas);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dYi = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dYi = false;
    }

    final boolean Tf() {
        if (VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return this.dYi;
    }

    public final void addTextChangedListener(final TextWatcher textWatcher) {
        post(new Runnable(this) {
            final /* synthetic */ j dYU;

            public final void run() {
                if (textWatcher != null) {
                    this.dYU.pQX.pQZ.add(textWatcher);
                }
            }
        });
    }

    public final void removeTextChangedListener(final TextWatcher textWatcher) {
        post(new Runnable(this) {
            final /* synthetic */ j dYU;

            public final void run() {
                if (textWatcher != null) {
                    this.dYU.pQX.pQZ.remove(textWatcher);
                }
            }
        });
    }

    public final void setLayoutParams(LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }
}
