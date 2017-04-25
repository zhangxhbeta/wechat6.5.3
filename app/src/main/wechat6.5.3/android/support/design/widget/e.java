package android.support.design.widget;

import android.graphics.Outline;

final class e extends d {
    e() {
    }

    public final void getOutline(Outline outline) {
        copyBounds(this.fu);
        outline.setOval(this.fu);
    }
}
