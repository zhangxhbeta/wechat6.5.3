package com.tencent.mm.pluginsdk.ui.d;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;

public final class f implements GetChars, Spannable, CharSequence {
    private SpannableString lQT;

    public f() {
        this.lQT = null;
        this.lQT = new SpannableString("");
    }

    public f(CharSequence charSequence) {
        this.lQT = null;
        this.lQT = new SpannableString(charSequence);
    }

    public f(SpannableString spannableString) {
        this.lQT = null;
        this.lQT = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i, int i2) {
        a(obj, i, charSequence.length() + i, 33);
    }

    public final void f(Object obj, CharSequence charSequence) {
        a(obj, charSequence, 0, 33);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        a(obj, i, i2, i3);
    }

    private void a(Object obj, int i, int i2, int i3) {
        if (i >= 0 && i2 <= this.lQT.length()) {
            this.lQT.setSpan(obj, i, i2, i3);
        }
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.lQT.getSpans(i, i2, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.lQT.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.lQT.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.lQT.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.lQT.nextSpanTransition(i, i2, cls);
    }

    public final int length() {
        return this.lQT.length();
    }

    public final char charAt(int i) {
        return this.lQT.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.lQT.subSequence(i, i2);
    }

    public final void removeSpan(Object obj) {
        this.lQT.removeSpan(obj);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        this.lQT.getChars(i, i2, cArr, i3);
    }

    public final String toString() {
        return this.lQT.toString();
    }
}
