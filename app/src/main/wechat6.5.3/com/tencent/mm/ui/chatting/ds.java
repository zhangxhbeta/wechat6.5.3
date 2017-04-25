package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

public final class ds {
    private static ds oyG;
    Object oyF;

    @TargetApi(14)
    public static class a implements OnHoverListener {
        private b oyH;

        public a(b bVar) {
            this.oyH = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            if (this.oyH != null) {
                return this.oyH.d(view, motionEvent);
            }
            return false;
        }
    }

    public interface b {
        boolean d(View view, MotionEvent motionEvent);
    }

    public static synchronized ds bGo() {
        ds dsVar;
        synchronized (ds.class) {
            if (oyG == null) {
                oyG = new ds();
            }
            dsVar = oyG;
        }
        return dsVar;
    }
}
