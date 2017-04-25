package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    public int cmH = -1;
    public Typeface cmI = null;
    public int cmJ = -1;
    public float cmK = -1.0f;
    public Alignment cme = Alignment.ALIGN_NORMAL;
    public TruncateAt cmf = null;
    public TextDirectionHeuristic cmh = null;
    public float cmi = 0.0f;
    public float cmj = 1.0f;
    public boolean cmk = false;
    public TextPaint cmp = null;
    public int gravity = 51;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.cmp}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.cme}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.cmf}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.cmH)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.cmh}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.cmi), Float.valueOf(this.cmj)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.cmk)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.cmI}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.cmJ)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.cmK)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.cmp != null) {
            i += this.cmp.hashCode() * 31;
        }
        i += this.cme.hashCode() * 31;
        if (this.cmf != null) {
            i += this.cmf.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.cmH * 31);
        if (this.cmh != null) {
            i += this.cmh.hashCode() * 31;
        }
        i = ((this.cmk ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.cmi * 31.0f)))) + (this.cmj * 31.0f)));
        if (this.cmI != null) {
            i += this.cmI.hashCode() * 31;
        }
        return (((int) (((float) (i + (this.cmJ * 31))) + (this.cmK * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
    }
}
