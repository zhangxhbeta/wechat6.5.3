package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.a.a.d;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMListPopupWindow;

public abstract class q implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private int Qp;
    private ViewTreeObserver Qt;
    private ViewGroup Qu;
    private int dividerHeight;
    private BaseAdapter eGK;
    private View hy;
    protected Context mContext;
    private boolean nWy = false;
    private OnCancelListener oUU;
    private OnDismissListener oUV;
    private boolean oUW = false;
    private boolean oUX = true;
    private View oUY;
    private int oUZ;
    private int oVa = 0;
    private int oVb = 0;
    private int oVc = 0;
    private float oVd = 0.0f;
    private float oVe = 0.0f;
    private MMListPopupWindow omc;
    private int omd = 2131558668;

    public abstract BaseAdapter YP();

    public q(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.Qp = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(d.Ia));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hy = viewGroup.getChildAt(0);
            } else {
                this.hy = viewGroup;
            }
        }
        this.dividerHeight = b.a(this.mContext, 1.0f);
        this.oVa = resources.getDimensionPixelSize(2131493168) * 2;
        this.oVb = resources.getDimensionPixelSize(2131493198);
        this.oVc = b.a(this.mContext, 36.0f);
        this.eGK = YP();
    }

    public final void kk(boolean z) {
        this.nWy = z;
        if (z) {
            this.omd = 2131558624;
        } else {
            this.omd = 2131558668;
        }
    }

    public boolean dQ() {
        int height;
        Rect rect = new Rect();
        if (this.mContext instanceof ActionBarActivity) {
            height = ((ActionBarActivity) this.mContext).cU().cV().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? b.a(this.mContext, 40.0f) : b.a(this.mContext, 49.0f);
        }
        int dimensionPixelSize = height - this.mContext.getResources().getDimensionPixelSize(2131493168);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= 200) {
                height = rect.top + dimensionPixelSize;
            } else {
                height = (height2 - rect.height()) + dimensionPixelSize;
            }
        } else {
            height = dimensionPixelSize;
        }
        this.oUW = azQ();
        if (this.omc == null || true == this.oUX) {
            this.omc = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.omc.setOnDismissListener(this);
        this.omc.Xp = this;
        this.omc.setAdapter(this.eGK);
        this.omc.fi();
        this.omc.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838811));
        this.omc.setAnimationStyle(this.omd);
        this.omc.Xd = 0;
        this.omc.Xn = this.hy;
        if (this.hy != null) {
            boolean z;
            z = this.Qt == null;
            this.Qt = this.hy.getViewTreeObserver();
            v.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.Qt.addOnGlobalLayoutListener(this);
            }
        }
        this.omc.setVerticalOffset(height);
        this.omc.nWy = this.nWy;
        this.omc.setContentWidth(Math.min(b(this.eGK), this.Qp));
        this.omc.fj();
        if (!(this.oVd == 0.0f || this.oVe == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            z = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int height3 = height > rect2.height() ? rect2.height() : height;
            v.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.oVd), Float.valueOf(this.oVe), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(z ? (int) (this.oVe * ((float) height3)) : (int) (this.oVd * ((float) height3))));
            height = Math.round((float) (height / this.oVb));
            if (height <= 0 || this.eGK == null) {
                v.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                dimensionPixelSize = (this.oVb * height) + this.oVa;
                if (dimensionPixelSize == 0 || dimensionPixelSize >= this.eGK.getCount() * this.oVb) {
                    v.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(dimensionPixelSize), Integer.valueOf(this.eGK.getCount() * this.oVb));
                } else {
                    this.omc.Xc = (((height - 1) * this.oVb) + this.oVa) + this.oVc;
                }
            }
        }
        if (!(this.omc == null || this.oUY == null)) {
            MMListPopupWindow mMListPopupWindow = this.omc;
            View view = this.oUY;
            boolean isShowing = mMListPopupWindow.eLp.isShowing();
            if (isShowing) {
                mMListPopupWindow.bCg();
            }
            mMListPopupWindow.Xk = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.omc.Xl = this.oUZ;
        }
        this.omc.show();
        this.omc.nWt.setOnKeyListener(this);
        this.omc.nWt.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131690078)));
        this.omc.nWt.setDividerHeight(0);
        this.omc.nWt.setVerticalScrollBarEnabled(true);
        this.omc.nWt.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean azQ() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.omc.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.Qu == null) {
                this.Qu = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.Qu);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        this.omc = null;
        if (this.Qt != null) {
            if (!this.Qt.isAlive()) {
                this.Qt = this.hy.getViewTreeObserver();
            }
            this.Qt.removeGlobalOnLayoutListener(this);
            this.Qt = null;
        }
        if (this.oUU != null) {
            this.oUU.onCancel(null);
        }
        if (this.oUV != null) {
            this.oUV.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.omc != null && this.omc.eLp.isShowing();
    }

    public void onGlobalLayout() {
        v.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.hy.isShown()));
        if (isShowing()) {
            View view = this.hy;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.oUW != azQ()) {
                this.omc.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        v.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
