package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.h;

public final class b extends h implements com.tencent.mm.u.d.a {

    public static class a {
        static com.tencent.mm.pluginsdk.ui.h.a hXG;

        public static void m(ImageView imageView, String str) {
            b bVar;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str);
            } else {
                bVar = (b) drawable;
            }
            bVar.Ho(str);
            imageView.setImageDrawable(bVar);
        }
    }

    private b(String str) {
        super(a.hXG, str);
    }

    public final void gM(String str) {
        super.gM(str);
    }
}
