package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

public class MailMMWebView extends MMWebViewWithJsApi {
    private float evM;
    private float evN;
    boolean ifX;
    View ifY;
    View ifZ;
    private boolean iga;
    private boolean igb;

    private class a extends FrameLayout {
        final /* synthetic */ MailMMWebView igc;

        public a(MailMMWebView mailMMWebView, Context context) {
            this.igc = mailMMWebView;
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!this.igc.iga && !this.igc.igb) {
                return false;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    this.igc.iga = false;
                    this.igc.igb = false;
                    break;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }

        protected final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this == this.igc.ifY && this.igc.getTitleHeight() > 0) {
                this.igc.aIr();
            } else if (this == this.igc.ifZ && this.igc.aIq() > 0) {
                this.igc.aIs();
            }
        }
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.ifX = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.evM = x;
                this.evN = y;
                if (this.ifY == null || ((int) this.evN) >= aIp()) {
                    if (this.ifZ != null && this.ifZ.getVisibility() == 0 && this.evN + ((float) aIq()) > ((float) getHeight())) {
                        this.igb = true;
                        break;
                    }
                }
                this.iga = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.evN) > 50.0f && this.iga) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.evM, this.evN + ((float) webScrollY));
                    this.ifY.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.evM, this.evN);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.iga) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            return this.ifY.dispatchTouchEvent(motionEvent);
        } else if (!this.igb) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setLocation(x, (y + ((float) aIq())) - ((float) getHeight()));
            return this.ifZ.dispatchTouchEvent(motionEvent);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onScrollChanged(i, i2, i3, i4);
        if (contentHeight - height < aIq()) {
            if (Math.abs(contentHeight - height) > 20) {
                aIs();
                eV(false);
            } else {
                eV(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            aIr();
        }
    }

    protected int computeVerticalScrollExtent() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        return height - aIp();
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(getWebScrollY() - getTitleHeight(), 0);
    }

    private int aIp() {
        return Math.max(getTitleHeight() - getWebScrollY(), 0);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.ifY) {
            return super.drawChild(canvas, view, j);
        }
        int webScrollY = getWebScrollY();
        canvas.save();
        canvas.translate(0.0f, (float) (-webScrollY));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public final int getTitleHeight() {
        if (this.ifY != null) {
            return this.ifY.getHeight();
        }
        return 0;
    }

    public final int aIq() {
        if (this.ifZ != null) {
            return this.ifZ.getHeight();
        }
        return 0;
    }

    public final void aIr() {
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
    }

    public final void aIs() {
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) aIq()) / getScale())) + ");", null);
    }

    public final void eV(boolean z) {
        if (this.ifZ == null) {
            return;
        }
        if (z) {
            this.ifZ.setVisibility(0);
        } else {
            this.ifZ.setVisibility(4);
        }
    }
}
