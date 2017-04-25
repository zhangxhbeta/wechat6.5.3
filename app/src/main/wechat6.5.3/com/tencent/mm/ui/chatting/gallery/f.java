package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.LinkedList;

public final class f {
    private ap cDc = new ap(1, "chatting-image-gallery-preload-loader");
    protected com.tencent.mm.a.f<String, Bitmap> ggr = new com.tencent.mm.a.f(4, new b<String, Bitmap>(this) {
        final /* synthetic */ f oBt;

        {
            this.oBt = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            this.oBt.oBs.remove((String) obj);
        }
    });
    private boolean ggu = false;
    protected HashMap<String, Long> oBs = new HashMap();
    public LinkedList<String> sR = new LinkedList();
    private int xe = 0;

    private static final class a {
        public static f oBu = new f();
    }

    public final void aqU() {
        this.ggr.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
            final /* synthetic */ f oBt;

            {
                this.oBt = r1;
            }
        });
    }
}
