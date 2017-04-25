package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.ac;

public class MMCallBackScrollView extends ScrollView {
    private int hYN;
    public a hYO;
    private ac mHandler = new ac(this) {
        final /* synthetic */ MMCallBackScrollView hYP;

        {
            this.hYP = r1;
        }

        public final void handleMessage(Message message) {
            int scrollY = this.hYP.getScrollY();
            if (scrollY == this.hYP.hYN) {
                this.hYP.ot(0);
                return;
            }
            this.hYP.hYN = scrollY;
            this.hYP.mHandler.sendMessageDelayed(this.hYP.mHandler.obtainMessage(), 5);
            this.hYP.ot(1);
        }
    };
    private int mState = 0;

    public interface a {
        void ba(int i);
    }

    private void ot(int i) {
        if (this.hYO != null && this.mState != i) {
            this.mState = i;
            this.hYO.ba(i);
        }
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.hYN = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                ot(1);
                break;
        }
        return onTouchEvent;
    }
}
