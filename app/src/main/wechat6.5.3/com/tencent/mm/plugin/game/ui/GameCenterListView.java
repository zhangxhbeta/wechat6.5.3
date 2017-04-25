package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;

public class GameCenterListView extends ListView {
    static boolean gqa;
    static int gqc;
    private View PH;
    private boolean gpW;
    private float gpX;
    private int gpY;
    private boolean gpZ;
    private boolean gqb;
    private ImageView gqd;
    private ImageView gqe;
    private Context mContext;
    private Scroller xF;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gpY = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.xF = new Scroller(this.mContext);
        super.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ GameCenterListView gqf;

            {
                this.gqf = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && this.gqf.PH != null && this.gqf.PH.getTop() == 0) {
                    this.gqf.gpZ = true;
                } else {
                    this.gqf.gpZ = false;
                }
            }
        });
    }

    public static void dp(boolean z) {
        gqa = z;
    }

    public static void ly(int i) {
        gqc = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.gpW) {
            this.PH = getChildAt(0);
            this.gqe = (ImageView) this.PH.findViewById(2131757208);
            this.gqd = (ImageView) this.PH.findViewById(2131757207);
            this.gpW = true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!gqa || this.PH == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.gqb = false;
                this.gpX = motionEvent.getRawY();
                break;
            case 2:
                if (this.gpZ) {
                    if (this.gqb) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.gpX);
                    if (this.PH.getPaddingTop() <= gqc + this.gpY) {
                        if (rawY > 0 && Math.abs(rawY) >= this.gpY) {
                            this.gqb = true;
                            this.xF.startScroll(0, this.PH.getPaddingTop(), 0, -this.PH.getPaddingTop(), 500);
                            this.gqd.setClickable(true);
                            invalidate();
                            return true;
                        }
                    } else if (this.PH.getPaddingTop() >= (-this.gpY) && rawY < 0 && Math.abs(rawY) >= this.gpY) {
                        this.gqb = true;
                        this.xF.startScroll(0, 0, 0, gqc, 500);
                        this.gqd.setClickable(false);
                        invalidate();
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gqb) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.PH != null && this.xF.computeScrollOffset()) {
            int currY = this.xF.getCurrY();
            this.PH.setPadding(0, currY, 0, 0);
            float f = (((float) (gqc - currY)) / ((float) gqc)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.gqe.setAlpha(i);
            this.gqd.setAlpha(currY);
            invalidate();
        }
    }
}
