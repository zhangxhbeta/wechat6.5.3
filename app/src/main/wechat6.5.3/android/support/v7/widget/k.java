package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k extends j {
    private static final int[] Pf = new int[]{16843074};
    private final SeekBar Ue;

    k(SeekBar seekBar, h hVar) {
        super(seekBar, hVar);
        this.Ue = seekBar;
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ap a = ap.a(this.Ue.getContext(), attributeSet, Pf, i);
        Drawable by = a.by(0);
        if (by != null) {
            this.Ue.setThumb(by);
        }
        a.adM.recycle();
    }
}
