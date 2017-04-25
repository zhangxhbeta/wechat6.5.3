package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public final class f {
    private int background = -1;
    boolean ePp;
    int index;
    OnClickListener iqU = new OnClickListener(this) {
        final /* synthetic */ f lKI;

        {
            this.lKI = r1;
        }

        public final void onClick(View view) {
        }
    };
    e lJM;
    a lJT;
    private final OnTouchListener lKB = new OnTouchListener(this) {
        final /* synthetic */ f lKI;

        {
            this.lKI = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    int lKG;
    b lKH;
    int row;

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ int kz;
        final /* synthetic */ f lKI;
        final /* synthetic */ ViewGroup lKJ;

        AnonymousClass3(f fVar, ViewGroup viewGroup, int i) {
            this.lKI = fVar;
            this.lKJ = viewGroup;
            this.kz = i;
        }

        public final void onClick(View view) {
            this.lKI.lJT.tU(this.kz);
        }
    }

    class AnonymousClass4 implements OnLongClickListener {
        final /* synthetic */ int kz;
        final /* synthetic */ f lKI;
        final /* synthetic */ ViewGroup lKJ;

        AnonymousClass4(f fVar, ViewGroup viewGroup, int i) {
            this.lKI = fVar;
            this.lKJ = viewGroup;
            this.kz = i;
        }

        public final boolean onLongClick(View view) {
            return this.lKI.lKH.jn(this.kz);
        }
    }

    public interface a {
        void tU(int i);
    }

    public interface b {
        boolean jn(int i);
    }
}
