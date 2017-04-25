package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements f {
    private TextWatcher lNy = new TextWatcher(this) {
        final /* synthetic */ ActionBarSearchView oQD;

        {
            this.oQD = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oQD.bIR();
            t b = this.oQD.oQw;
            if (b.oVm) {
                EditText editText = (EditText) b.oVk.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.dVK == null || b.dVK.length() == 0)) || (b.dVK != null && b.dVK.equals(charSequence.toString()))) {
                        v.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.dVK);
                    } else {
                        b.dVK = charSequence != null ? charSequence.toString() : SQLiteDatabase.KeyEmpty;
                        b.oVj = t.h(b.dVK, b.oVl);
                        if (t.a(editText, b.oVl)) {
                            v.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (this.oQD.oQx != null) {
                this.oQD.oQx.Ht(charSequence == null ? SQLiteDatabase.KeyEmpty : charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private OnFocusChangeListener oQA;
    private OnClickListener oQB = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView oQD;

        {
            this.oQD = r1;
        }

        public final void onClick(View view) {
            if (c.oQF == this.oQD.oQu) {
                v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                this.oQD.kg(true);
                if (this.oQD.oQx != null) {
                    this.oQD.oQx.Oh();
                    return;
                }
                return;
            }
            v.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (this.oQD.oQx != null) {
                this.oQD.oQx.bIW();
            }
        }
    };
    private OnClickListener oQC = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView oQD;

        {
            this.oQD = r1;
        }

        public final void onClick(View view) {
            if (this.oQD.oQy != null) {
                this.oQD.oQy.bIV();
            }
        }
    };
    private View oQr;
    private ActionBarEditText oQs;
    private ImageButton oQt;
    private int oQu = c.oQF;
    private boolean oQv = false;
    private t oQw;
    private b oQx;
    private a oQy;
    private OnFocusChangeListener oQz = new OnFocusChangeListener(this) {
        final /* synthetic */ ActionBarSearchView oQD;

        {
            this.oQD = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            v.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (this.oQD.oQA != null) {
                this.oQD.oQA.onFocusChange(view, z);
            }
        }
    };

    public interface a {
        void bIV();
    }

    public interface b {
        void Ht(String str);

        void Oh();

        void bIW();
    }

    private enum c {
        ;

        static {
            oQF = 1;
            oQG = 2;
            oQH = new int[]{oQF, oQG};
        }
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        ActionBarSearchView oQE;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        v.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.oQE.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ActionBarSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903075, this, true);
        this.oQr = findViewById(2131755276);
        this.oQr.setOnClickListener(this.oQC);
        this.oQs = (ActionBarEditText) findViewById(2131755280);
        this.oQw = new t(this.oQs);
        this.oQs.oQE = this;
        this.oQs.post(new Runnable(this) {
            final /* synthetic */ ActionBarSearchView oQD;

            {
                this.oQD = r1;
            }

            public final void run() {
                this.oQD.oQs.setText(SQLiteDatabase.KeyEmpty);
            }
        });
        this.oQt = (ImageButton) findViewById(2131755281);
        this.oQs.addTextChangedListener(this.lNy);
        this.oQs.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ActionBarSearchView oQD;

            {
                this.oQD = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67) {
                    return false;
                }
                v.d("MicroMsg.ActionBarSearchView", "on back key click.");
                t b = this.oQD.oQw;
                if (b.oVm) {
                    EditText editText = (EditText) b.oVk.get();
                    if (!(editText == null || b.oVj == null)) {
                        CharSequence text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            b yf = b.yf(selectionStart);
                            if (yf != null && yf.oVu) {
                                text.delete(yf.start, yf.start + yf.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(yf.start);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        });
        this.oQs.oYW = new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a(this) {
            final /* synthetic */ ActionBarSearchView oQD;

            {
                this.oQD = r1;
            }

            public final void a(EditText editText, int i, int i2) {
                v.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                t b = this.oQD.oQw;
                if (b.oVm) {
                    EditText editText2 = (EditText) b.oVk.get();
                    if (editText2 != null && editText == editText2) {
                        CharSequence text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart >= 0 && selectionEnd >= selectionStart) {
                            if (selectionStart == selectionEnd) {
                                b yf = b.yf(selectionStart);
                                if (yf != null && yf.oVu) {
                                    editText2.setTextKeepState(text);
                                    editText2.setSelection(yf.length + yf.start);
                                    return;
                                }
                                return;
                            }
                            b yf2 = b.yf(selectionStart);
                            if (yf2 != null && yf2.oVu) {
                                selectionStart = yf2.start + yf2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                return;
                            }
                            b yf3 = b.yf(selectionEnd);
                            if (yf3 != null && yf3.oVu) {
                                int i3 = yf3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                        }
                    }
                }
            }
        };
        this.oQs.setOnFocusChangeListener(this.oQz);
        com.tencent.mm.ui.tools.a.c.b(this.oQs).yn(100).a(null);
        this.oQt.setOnClickListener(this.oQB);
    }

    public final String boJ() {
        if (this.oQs.getEditableText() != null) {
            return this.oQs.getEditableText().toString();
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void a(b bVar) {
        this.oQx = bVar;
    }

    public final void a(a aVar) {
        this.oQy = aVar;
    }

    public final void Pw(String str) {
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        this.oQs.setText(str);
        this.oQs.setSelection(str.length());
    }

    public final void setHint(CharSequence charSequence) {
        this.oQs.setHint(charSequence);
    }

    public final void kd(boolean z) {
        this.oQv = z;
        bIR();
    }

    public final void ke(boolean z) {
        this.oQs.setEnabled(z);
    }

    public final void kf(boolean z) {
        this.oQt.setEnabled(z);
    }

    private void ds(int i, int i2) {
        this.oQt.setImageResource(i);
        this.oQt.setBackgroundResource(0);
        if (i == 2130839416) {
            this.oQt.setContentDescription(getContext().getString(2131235807));
        } else {
            this.oQt.setContentDescription(getContext().getString(2131231938));
        }
        LayoutParams layoutParams = this.oQt.getLayoutParams();
        layoutParams.width = i2;
        this.oQt.setLayoutParams(layoutParams);
    }

    private void bIR() {
        if (this.oQs.getEditableText() != null && !be.kS(this.oQs.getEditableText().toString())) {
            ds(2130839084, getResources().getDimensionPixelSize(2131493166));
            this.oQu = c.oQF;
        } else if (this.oQv) {
            ds(2130839416, getResources().getDimensionPixelSize(2131493166));
            this.oQu = c.oQG;
        } else {
            ds(0, 0);
            this.oQu = c.oQF;
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.oQs.setOnEditorActionListener(onEditorActionListener);
    }

    public final void kg(boolean z) {
        if (z) {
            this.oQs.setText(SQLiteDatabase.KeyEmpty);
            return;
        }
        this.oQs.removeTextChangedListener(this.lNy);
        this.oQs.setText(SQLiteDatabase.KeyEmpty);
        this.oQs.addTextChangedListener(this.lNy);
    }

    public final void bIS() {
        this.oQs.clearFocus();
    }

    public final void a(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean bIT() {
        if (this.oQs != null) {
            return this.oQs.hasFocus();
        }
        return false;
    }

    public final boolean bIU() {
        if (this.oQs != null) {
            return this.oQs.requestFocus();
        }
        return false;
    }

    public final void ad(ArrayList<String> arrayList) {
        if (this.oQw != null) {
            t tVar = this.oQw;
            tVar.oVl = arrayList;
            if (tVar.oVm) {
                EditText editText = (EditText) tVar.oVk.get();
                if (editText != null) {
                    t.a(editText, tVar.oVl);
                }
            }
        }
    }

    public final void kh(boolean z) {
        if (this.oQw != null) {
            this.oQw.oVm = z;
        }
    }

    public final void yd(int i) {
        if (this.oQs != null) {
            this.oQs.setCompoundDrawables(aa.getResources().getDrawable(i), null, null, null);
        }
    }
}
