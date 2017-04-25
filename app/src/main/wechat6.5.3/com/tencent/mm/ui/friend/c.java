package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c implements OnClickListener {
    private Context context;
    private a oNW;

    public interface a {
        void ka(boolean z);
    }

    public static class b {
        public String oNY;
        public int position;
    }

    public c(Context context, a aVar) {
        this.context = context;
        this.oNW = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.oNY;
        final int i = bVar.position;
        new g(this.context, new com.tencent.mm.ui.friend.g.a(this) {
            final /* synthetic */ c oNX;

            public final void j(boolean z, String str) {
                this.oNX.oNW.ka(z);
            }
        }).t(new int[]{o.ba(str)});
    }
}
