package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final Drawable jP;
    final int jQ;
    final CharSequence mText;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap a = ap.a(context, attributeSet, i.cN);
        this.mText = a.getText(i.cQ);
        this.jP = a.getDrawable(i.cO);
        this.jQ = a.getResourceId(i.cP, 0);
        a.adM.recycle();
    }
}
