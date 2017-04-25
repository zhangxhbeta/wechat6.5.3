package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector hDG;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ MusicItemLayout hDU;

        private a(MusicItemLayout musicItemLayout) {
            this.hDU = musicItemLayout;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > Math.abs(f)) {
                com.tencent.mm.plugin.music.ui.a.a aVar = (com.tencent.mm.plugin.music.ui.a.a) this.hDU.getTag();
                if (f2 > 0.0f) {
                    aVar.aDp();
                } else {
                    aVar.aDo();
                }
            }
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            com.tencent.mm.plugin.music.ui.a.a aVar = (com.tencent.mm.plugin.music.ui.a.a) this.hDU.getTag();
            if (aVar.aDn()) {
                if (motionEvent.getY() <= ((float) aVar.hEg.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                    aVar.aDq();
                }
            } else if (motionEvent.getY() >= aVar.hEi.getY() - 100.0f && motionEvent.getY() < ((float) aVar.hEi.getMeasuredHeight()) + aVar.hEi.getY()) {
                aVar.aDq();
            }
            return false;
        }
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    private void NI() {
        this.hDG = new GestureDetector(getContext(), new a());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.plugin.music.ui.a.a aVar = (com.tencent.mm.plugin.music.ui.a.a) getTag();
        if (!aVar.aDn()) {
            Object obj;
            if (aVar.hEh.getX() <= motionEvent.getX() && motionEvent.getX() <= aVar.hEh.getX() + ((float) aVar.hEh.getMeasuredWidth()) && aVar.hEh.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) aVar.hEh.getMeasuredHeight()) + aVar.hEh.getY()) {
                    obj = 1;
                    if (obj == null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.hDG.onTouchEvent(motionEvent);
        return true;
    }
}
