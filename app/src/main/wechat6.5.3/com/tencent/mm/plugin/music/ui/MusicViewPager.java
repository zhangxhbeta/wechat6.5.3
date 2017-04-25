package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager extends CustomViewPager {
    private GestureDetector hDG;

    public class a extends Scroller {
        private int duration = 1000;
        final /* synthetic */ MusicViewPager hEB;

        public a(MusicViewPager musicViewPager, Context context) {
            this.hEB = musicViewPager;
            super(context);
        }

        public final void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.duration);
        }

        public final void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.duration);
        }
    }

    private class b extends SimpleOnGestureListener {
        final /* synthetic */ MusicViewPager hEB;

        private b(MusicViewPager musicViewPager) {
            this.hEB = musicViewPager;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) < Math.abs(f)) {
                return true;
            }
            return false;
        }
    }

    public MusicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hDG = new GestureDetector(getContext(), new b());
        this.xF = new a(this, getContext());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.hDG.onTouchEvent(motionEvent);
    }
}
