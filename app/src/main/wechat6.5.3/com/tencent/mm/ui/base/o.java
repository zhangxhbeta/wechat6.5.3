package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class o extends PopupWindow {
    private Context mContext = null;
    private OnTouchListener nWM;

    private class a extends FrameLayout {
        final /* synthetic */ o nWN;

        public a(o oVar, Context context) {
            this.nWN = oVar;
            super(context);
        }

        protected final int[] onCreateDrawableState(int i) {
            return super.onCreateDrawableState(i);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1) {
                keyDispatcherState = getKeyDispatcherState();
                if (!(keyDispatcherState == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled())) {
                    this.nWN.dismiss();
                    return true;
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.nWN.nWM == null || !this.nWN.nWM.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                this.nWN.dismiss();
                return true;
            } else if (motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            } else {
                this.nWN.dismiss();
                return true;
            }
        }

        public final void sendAccessibilityEvent(int i) {
            if (getChildCount() == 1) {
                getChildAt(0).sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
            super.sendAccessibilityEvent(i);
        }
    }

    public o(Context context) {
        super(context);
        this.mContext = context;
        super.setBackgroundDrawable(null);
    }

    public o(View view) {
        super(view);
        super.setBackgroundDrawable(null);
    }

    public o(View view, int i, int i2) {
        super(view, i, i2);
        super.setBackgroundDrawable(null);
    }

    public o(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        super.setBackgroundDrawable(null);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + e.getMessage());
        }
    }

    public Drawable getBackground() {
        View contentView = getContentView();
        if (contentView != null && (contentView instanceof a)) {
            return contentView.getBackground();
        }
        return null;
    }

    public void setContentView(View view) {
        int i = -2;
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof a) {
            a aVar = (a) contentView;
            aVar.removeAllViews();
            if (view == null) {
                super.setContentView(aVar);
                return;
            }
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            aVar.addView(view, new FrameLayout.LayoutParams(-1, i));
            super.setContentView(aVar);
            return;
        }
        super.setContentView(view);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i = -2;
        View contentView = getContentView();
        if (contentView != null) {
            Context context = contentView.getContext();
            if (contentView instanceof a) {
                contentView.setBackgroundDrawable(drawable);
                return;
            }
            LayoutParams layoutParams = contentView.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            View aVar = new a(this, context);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
            aVar.setBackgroundDrawable(drawable);
            aVar.addView(contentView, layoutParams2);
            super.setContentView(aVar);
        } else if (drawable != null) {
            Context context2;
            if (this.mContext != null) {
                context2 = this.mContext;
            } else {
                context2 = aa.getContext();
            }
            View aVar2 = new a(this, context2);
            aVar2.setBackgroundDrawable(drawable);
            super.setContentView(aVar2);
        }
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.nWM = onTouchListener;
    }
}
