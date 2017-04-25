package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.bf.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMEditText extends EditText {
    int lGY = 0;
    public InputConnection pcq;
    public a pcr;

    public interface a {
        void ayj();
    }

    public interface b {
        void aKK();
    }

    public static class c implements TextWatcher {
        private final int aGx;
        private EditText idd;
        private TextView pcs;
        public b pct = null;
        private boolean pcu = false;

        public c(EditText editText, TextView textView, int i) {
            this.idd = editText;
            this.pcs = textView;
            this.aGx = i;
        }

        public final void afterTextChanged(Editable editable) {
            int i;
            int i2 = 0;
            String obj = editable.toString();
            CharSequence charSequence = SQLiteDatabase.KeyEmpty;
            int i3 = 0;
            for (i = 0; i < obj.length(); i++) {
                if (be.d(obj.charAt(i))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.aGx) {
                    break;
                }
                charSequence = charSequence + obj.charAt(i);
            }
            if (i3 > this.aGx) {
                try {
                    this.idd.setText(charSequence);
                    if (this.pcu) {
                        this.idd.setSelection(0);
                    } else {
                        this.idd.setSelection(this.idd.getText().toString().length());
                    }
                    this.pcu = false;
                } catch (Exception e) {
                    this.pcu = true;
                    v.e("MicroMsg.MMEditText", "error " + e.getMessage());
                    this.idd.setText(charSequence);
                    this.idd.setSelection(0);
                }
            }
            i = this.aGx - i3;
            if (i >= 0) {
                i2 = i;
            }
            if (this.pcs != null) {
                this.pcs.setText((i2 / 2));
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.pct != null) {
                this.pct.aKK();
            }
        }
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.pcq = super.onCreateInputConnection(editorInfo);
        return this.pcq;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void PL(String str) {
        g.buU();
        getContext();
        int bK = g.bK(getText().toString(), getSelectionStart());
        g.buU();
        getContext();
        int bK2 = g.bK(getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        setText(g.buU().c(getContext(), stringBuffer.substring(0, bK) + str + stringBuffer.substring(bK2, stringBuffer.length()), getTextSize()));
        setSelection(bK + str.length());
    }

    public boolean onTextContextMenuItem(int i) {
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i != 16908322) {
                return onTextContextMenuItem;
            }
            this.lGY = 0;
            String obj = getText().toString();
            try {
                Hp(obj);
                return onTextContextMenuItem;
            } catch (IndexOutOfBoundsException e) {
                v.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.lGY));
                if (this.lGY < 3) {
                    this.lGY++;
                    Hp(" " + obj);
                    return onTextContextMenuItem;
                }
                throw e;
            }
        } catch (NullPointerException e2) {
            v.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
    }

    private void Hp(String str) {
        int selectionStart = getSelectionStart();
        setText(g.buU().c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        String str = "MicroMsg.MMEditText";
        String str2 = "on onKeyPreIme, listener null ? %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.pcr == null);
        v.v(str, str2, objArr);
        if (this.pcr != null && i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                v.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                v.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    v.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.pcr.ayj();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager == null) {
                        return true;
                    }
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}
