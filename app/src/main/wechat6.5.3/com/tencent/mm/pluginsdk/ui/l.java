package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.bf.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l {
    private StringBuilder lIk;
    private SpannableStringBuilder lIl = new SpannableStringBuilder();
    private SpannableString lIm;
    private SpannableStringBuilder lIn = new SpannableStringBuilder();
    private CharacterStyle lIo = new ForegroundColorSpan(-5066062);
    private int lIp;
    private int lIq;
    public int lIr = 3;
    private Context mContext;

    public l(Context context) {
        this.mContext = context;
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        int i = 0;
        if (mMEditText != null) {
            if (this.lIk == null) {
                throw new IllegalStateException("You should saveHistory before setText");
            }
            this.lIl.clear();
            this.lIn.clear();
            if (z) {
                CharSequence charSequence;
                this.lIm = g.buU().c(this.mContext, this.lIk.subSequence(0, this.lIp), mMEditText.getTextSize());
                SpannableStringBuilder append = this.lIl.append(this.lIm);
                SpannableStringBuilder spannableStringBuilder = this.lIn;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length;
                    if (str.length() < this.lIr) {
                        length = str.length();
                    } else {
                        length = str.length();
                        i = length - this.lIr;
                    }
                    spannableStringBuilder.append(str).setSpan(this.lIo, i, length, 33);
                    Object obj = spannableStringBuilder;
                }
                append.append(charSequence).append(this.lIk.subSequence(this.lIq, this.lIk.length()));
            } else {
                this.lIm = g.buU().c(this.mContext, str, mMEditText.getTextSize());
                this.lIl.append(this.lIm);
            }
            mMEditText.setText(this.lIl);
            mMEditText.setSelection(this.lIl.length());
        }
    }

    public final void a(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.lIr = 0;
            this.lIm = g.buU().c(this.mContext, mMEditText.getText().toString(), mMEditText.getTextSize());
            mMEditText.setText(this.lIm);
            mMEditText.setSelection(this.lIm.length());
        }
    }

    public final void b(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.lIp = mMEditText.getSelectionStart();
            this.lIq = mMEditText.getSelectionEnd();
            this.lIk = new StringBuilder(mMEditText.getText());
            if (mMEditText.getText().toString().equalsIgnoreCase(SQLiteDatabase.KeyEmpty)) {
                this.lIl.clear();
            }
        }
    }
}
