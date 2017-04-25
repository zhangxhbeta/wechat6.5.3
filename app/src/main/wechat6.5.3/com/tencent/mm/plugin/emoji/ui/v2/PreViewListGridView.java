package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ac;

public class PreViewListGridView extends ListView {
    private int Wj;
    private WindowManager fjE;
    private PopEmojiView fmP;
    private LayoutParams fmQ;
    private int fmR;
    private int fmS;
    private boolean fmT;
    private boolean fqI = true;
    private int fqO;
    private volatile int fqP = -1;
    private String fqQ;
    private d fqR;
    private ac mHandler = new ac();

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.fmP = new PopEmojiView(getContext());
        this.fqO = context.getResources().getDimensionPixelSize(2131493444);
        this.fjE = (WindowManager) context.getSystemService("window");
        this.fmQ = new LayoutParams(-1, -1, 2, 8, 1);
        this.fmQ.width = this.fqO;
        this.fmQ.height = this.fqO;
        this.fmQ.gravity = 17;
        this.Wj = getResources().getConfiguration().orientation;
        if (this.Wj == 2) {
            this.fmR = this.fjE.getDefaultDisplay().getHeight();
            this.fmS = this.fjE.getDefaultDisplay().getWidth();
            return;
        }
        this.fmR = this.fjE.getDefaultDisplay().getWidth();
        this.fmS = this.fjE.getDefaultDisplay().getHeight();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.fqR = (d) listAdapter;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.fmT) {
                    aik();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void aik() {
        if (this.fmT) {
            this.fjE.removeView(this.fmP);
            this.fmT = false;
        }
        this.fqQ = "";
    }
}
