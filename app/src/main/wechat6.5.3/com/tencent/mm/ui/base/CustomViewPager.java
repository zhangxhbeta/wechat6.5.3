package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager extends WxViewPager {
    public boolean CM = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.CM) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.CM) {
            try {
                z = super.onTouchEvent(motionEvent);
            } catch (Throwable e) {
                v.a("MicroMsg.CustomViewPager", e, "get a Exception", new Object[z]);
            }
        }
        return z;
    }
}
