package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private String nIQ;
    public EditText nKp;
    private int nVb;
    private int[] nVc;
    public EditText nVf;
    private String nVg;
    private final int nVh;
    public a nVi;

    public interface a {
        void Ok(String str);
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.nVb = -1;
        this.nIQ = SQLiteDatabase.KeyEmpty;
        this.nVg = SQLiteDatabase.KeyEmpty;
        this.nVh = 13;
        this.nVi = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPg, i, 0);
        this.nVb = obtainStyledAttributes.getResourceId(2, -1);
        obtainStyledAttributes.recycle();
        q.em(context).inflate(2130903989, this);
        this.mContext = context;
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.nKp = (EditText) findViewById(2131755575);
        this.nVf = (EditText) findViewById(2131758225);
        if (this.nKp == null || this.nVf == null) {
            v.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", this.nKp, this.nVf);
        } else if (this.nVb != -1) {
            this.nVf.setHint(this.nVb);
        }
        if (this.nKp != null && this.nVf != null) {
            if (this.nKp.hasFocus() || this.nVf.hasFocus()) {
                jm(true);
            } else {
                jm(false);
            }
            OnFocusChangeListener anonymousClass1 = new OnFocusChangeListener(this) {
                final /* synthetic */ MMFormMobileInputView nVj;

                {
                    this.nVj = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (view == this.nVj.nKp || view == this.nVj.nVf) {
                        this.nVj.jm(z);
                    }
                }
            };
            this.nKp.setOnFocusChangeListener(anonymousClass1);
            this.nVf.setOnFocusChangeListener(anonymousClass1);
            this.nVf.addTextChangedListener(new c(this.nVf, null, 20));
            this.nVf.addTextChangedListener(new TextWatcher(this) {
                private al gJe = new al();
                final /* synthetic */ MMFormMobileInputView nVj;

                {
                    this.nVj = r2;
                }

                public final void afterTextChanged(Editable editable) {
                    int selectionEnd = this.nVj.nVf.getSelectionEnd();
                    String obj = this.nVj.nVf.getText().toString();
                    String substring = this.nVj.nVf.getText().toString().substring(0, selectionEnd);
                    if (obj != null && !obj.equals(this.nVj.nIQ)) {
                        String obj2 = this.nVj.nKp.getText().toString();
                        this.nVj.nIQ = al.formatNumber(obj2.replace("+", SQLiteDatabase.KeyEmpty), obj);
                        this.nVj.nVg = al.formatNumber(obj2.replace("+", SQLiteDatabase.KeyEmpty), substring);
                        if (!obj.equals(this.nVj.nIQ)) {
                            this.nVj.nVf.setText(this.nVj.nIQ);
                            int length = this.nVj.nVf.getText().toString().length();
                            if (substring != null) {
                                try {
                                    this.nVj.nVg = al.formatNumber(obj2.replace("+", SQLiteDatabase.KeyEmpty), substring);
                                    if (obj.length() > 13 && selectionEnd <= length) {
                                        this.nVj.nVf.setSelection(substring.toString().length());
                                        return;
                                    } else if (selectionEnd > length || this.nVj.nVg.toString().length() > length) {
                                        this.nVj.nVf.setSelection(length - Math.abs(obj.length() - selectionEnd));
                                        return;
                                    } else {
                                        this.nVj.nVf.setSelection(this.nVj.nVg.toString().length());
                                        return;
                                    }
                                } catch (Throwable e) {
                                    v.a("MicroMsg.MMFormMobileInputView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    return;
                                }
                            }
                            this.nVj.nVf.setSelection(0);
                        }
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.nKp.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ MMFormMobileInputView nVj;

                {
                    this.nVj = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    String obj = this.nVj.nKp.getText().toString();
                    if (be.kS(obj)) {
                        this.nVj.nKp.setText("+");
                        this.nVj.nKp.setSelection(this.nVj.nKp.getText().toString().length());
                    } else if (!obj.contains("+")) {
                        obj = "+" + obj;
                        this.nVj.nKp.setText(obj);
                        this.nVj.nKp.setSelection(this.nVj.nKp.getText().toString().length());
                    } else if (obj.length() > 1) {
                        String substring = obj.substring(1);
                        if (substring.length() > 4) {
                            this.nVj.nKp.setText(substring.substring(0, 4));
                            return;
                        }
                    }
                    if (this.nVj.nVi != null) {
                        this.nVj.nVi.Ok(obj);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
    }

    public final void jm(boolean z) {
        cD(this.nKp);
        if (z) {
            this.nKp.setBackgroundResource(2130838423);
        } else {
            this.nKp.setBackgroundResource(2130838424);
        }
        cE(this.nKp);
        cD(this.nVf);
        if (z) {
            this.nVf.setBackgroundResource(2130838423);
        } else {
            this.nVf.setBackgroundResource(2130838424);
        }
        cE(this.nVf);
    }

    private void cD(View view) {
        this.nVc = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
    }

    private void cE(View view) {
        if (this.nVc != null) {
            view.setPadding(this.nVc[0], this.nVc[1], this.nVc[2], this.nVc[3]);
        }
    }

    public final String bBT() {
        if (this.nVf != null) {
            return al.Kq(this.nVf.getText().toString());
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final String getCountryCode() {
        if (this.nKp != null) {
            return this.nKp.getText().toString().trim();
        }
        return SQLiteDatabase.KeyEmpty;
    }
}
