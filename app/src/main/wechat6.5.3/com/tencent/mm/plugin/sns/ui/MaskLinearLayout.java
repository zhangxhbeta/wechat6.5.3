package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    boolean aZw = false;
    private List<MaskImageView> gKQ = new LinkedList();
    private ac jDU = new ac();
    private Runnable jDV = new Runnable(this) {
        final /* synthetic */ MaskLinearLayout jHe;

        {
            this.jHe = r1;
        }

        public final void run() {
            this.jHe.setPressed(false);
            MaskLinearLayout.a(this.jHe);
            this.jHe.invalidate();
        }
    };

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(2130839230);
        } else {
            maskLinearLayout.setBackgroundResource(0);
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskLinearLayout jHe;

            {
                this.jHe = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                v.e("test", "touch: " + motionEvent.getAction());
                if (this.jHe.aZw) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            MaskLinearLayout.a(this.jHe);
                            view.invalidate();
                            this.jHe.jDU.removeCallbacks(this.jHe.jDV);
                            break;
                        case 1:
                        case 3:
                            this.jHe.jDU.post(this.jHe.jDV);
                            break;
                    }
                    if (this.jHe.gKQ != null) {
                        for (MaskImageView maskImageView : this.jHe.gKQ) {
                            maskImageView.b(maskImageView, motionEvent);
                        }
                    }
                }
                return false;
            }
        });
    }

    public final void b(MaskImageView maskImageView) {
        this.gKQ.add(maskImageView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
