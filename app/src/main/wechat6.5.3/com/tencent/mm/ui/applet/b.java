package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class b {
    int direction = 0;
    private GestureDetector hDG = new GestureDetector(new OnGestureListener(this) {
        final /* synthetic */ b nPN;

        {
            this.nPN = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.nPN.direction = f2 >= 0.0f ? 0 : 1;
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    });
    private IdleHandler nBU;
    private int nPJ;
    private c nPK;
    LinkedList<String> nPL;
    a nPM;

    public interface a {
        Bitmap iG(String str);
    }

    public interface b {
        int EU();

        String fo(int i);
    }

    private class c {
        private LinkedList<String> caF;
        private int maxSize;
        final /* synthetic */ b nPN;

        public c(b bVar, int i) {
            this.nPN = bVar;
            this.caF = null;
            this.maxSize = 40;
            this.caF = new LinkedList();
        }

        final void Ez(String str) {
            if (!this.caF.contains(str)) {
                this.caF.add(str);
                if (this.caF.size() >= this.maxSize) {
                    this.caF.removeFirst();
                }
            }
        }

        final boolean contains(String str) {
            return this.caF.contains(str);
        }
    }

    public b(a aVar) {
        this.nPM = aVar;
        this.nPJ = 15;
        this.nPK = new c(this, 40);
        this.nPL = new LinkedList();
        this.nBU = new IdleHandler(this) {
            final /* synthetic */ b nPN;

            {
                this.nPN = r1;
            }

            public final boolean queueIdle() {
                while (this.nPN.nPL.size() > 0) {
                    this.nPN.nPM.iG((String) this.nPN.nPL.removeFirst());
                }
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.nBU);
    }

    public final void a(int i, b bVar) {
        if (bVar == null) {
            v.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
        } else if (this.nPJ <= 0) {
            v.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
        } else {
            int EU = bVar.EU();
            for (int i2 = 1; i2 <= this.nPJ; i2++) {
                String fo;
                if (this.direction == 1) {
                    if (i - i2 >= 0) {
                        fo = bVar.fo(i - i2);
                        if (!(fo == null || fo.length() == 0 || this.nPK.contains(fo))) {
                            this.nPK.Ez(fo);
                            this.nPL.add(fo);
                        }
                    } else {
                        return;
                    }
                } else if (i + i2 < EU) {
                    fo = bVar.fo(i + i2);
                    if (!(fo == null || fo.length() == 0 || this.nPK.contains(fo))) {
                        this.nPK.Ez(fo);
                        this.nPL.add(fo);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        if (this.hDG != null) {
            this.hDG.onTouchEvent(motionEvent);
        }
    }

    public final void detach() {
        if (this.nBU != null) {
            Looper.myQueue().removeIdleHandler(this.nBU);
        }
    }
}
