package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.smtt.sdk.WebView;

public class LabelContainerView extends MMTagPanelScrollView {
    boolean oGL = true;
    boolean oGM = false;
    float oGN;
    float oGO;
    float oGP;
    float oGQ;
    private int oGR;
    boolean oGS = true;
    boolean oGT = false;
    float oGU;
    float oGV;
    float oGW;
    float oGX;
    public a oGY;

    public interface a {
        void aig();

        void aih();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bHG();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bHG();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & WebView.NORMAL_MODE_ALPHA) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.oGS = true;
                this.oGV = f2;
                this.oGU = f2;
                this.oGX = f3;
                this.oGW = f3;
                this.oGT = true;
                break;
            case 1:
            case 3:
                this.oGS = true;
                this.oGT = false;
                break;
            case 2:
                int i2 = (int) (f2 - this.oGU);
                actionIndex = (int) (f3 - this.oGW);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.oGR) {
                    this.oGS = false;
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void bHG() {
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oGR = scaledTouchSlop * scaledTouchSlop;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & WebView.NORMAL_MODE_ALPHA) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.oGL = true;
                this.oGO = f2;
                this.oGN = f2;
                this.oGQ = f3;
                this.oGP = f3;
                this.oGM = true;
                break;
            case 1:
            case 3:
                if ((this.oGL || !this.oGM) && this.oGY != null) {
                    this.oGY.aig();
                }
                this.oGL = true;
                this.oGM = false;
                break;
            case 2:
                if (!this.oGM) {
                    this.oGL = true;
                    this.oGO = f2;
                    this.oGN = f2;
                    this.oGQ = f3;
                    this.oGP = f3;
                    this.oGM = true;
                }
                if (this.oGY != null) {
                    this.oGY.aih();
                }
                int i2 = (int) (f2 - this.oGN);
                actionIndex = (int) (f3 - this.oGP);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.oGR) {
                    this.oGL = false;
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
