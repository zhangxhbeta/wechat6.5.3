package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.d;
import android.support.v7.a.a.k;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ai extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator aaY = new DecelerateInterpolator();
    private int QG;
    Runnable aaR;
    private LinearLayoutCompat aaS;
    private Spinner aaT;
    boolean aaU;
    int aaV;
    int aaW;
    private int aaX;

    private class a extends BaseAdapter {
        final /* synthetic */ ai aba;

        private a(ai aiVar) {
            this.aba = aiVar;
        }

        public final int getCount() {
            return this.aba.aaS.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) this.aba.aaS.getChildAt(i)).abc;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ai.a(this.aba, (android.support.v7.app.ActionBar.a) getItem(i));
            }
            b bVar = (b) view;
            bVar.abc = (android.support.v7.app.ActionBar.a) getItem(i);
            bVar.update();
            return view;
        }
    }

    private class b extends LinearLayoutCompat implements OnLongClickListener {
        final /* synthetic */ ai aba;
        private final int[] abb = new int[]{16842964};
        android.support.v7.app.ActionBar.a abc;
        private View kC;
        private TextView kG;
        private ImageView kH;

        public b(ai aiVar, Context context, android.support.v7.app.ActionBar.a aVar, boolean z) {
            this.aba = aiVar;
            super(context, null, android.support.v7.a.a.a.actionBarTabStyle);
            this.abc = aVar;
            ap a = ap.a(context, null, this.abb, android.support.v7.a.a.a.actionBarTabStyle);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.adM.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
            }
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.aba.aaV > 0 && getMeasuredWidth() > this.aba.aaV) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.aba.aaV, 1073741824), i2);
            }
        }

        public final void update() {
            android.support.v7.app.ActionBar.a aVar = this.abc;
            View customView = aVar.getCustomView();
            if (customView != null) {
                b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.kC = customView;
                if (this.kG != null) {
                    this.kG.setVisibility(8);
                }
                if (this.kH != null) {
                    this.kH.setVisibility(8);
                    this.kH.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.kC != null) {
                removeView(this.kC);
                this.kC = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.kH == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.kH = imageView;
                }
                this.kH.setImageDrawable(icon);
                this.kH.setVisibility(0);
            } else if (this.kH != null) {
                this.kH.setVisibility(8);
                this.kH.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.kG == null) {
                    imageView = new AppCompatTextView(getContext(), null, android.support.v7.a.a.a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                    this.kG = imageView;
                }
                this.kG.setText(text);
                this.kG.setVisibility(0);
            } else if (this.kG != null) {
                this.kG.setVisibility(8);
                this.kG.setText(null);
            }
            if (this.kH != null) {
                this.kH.setContentDescription(aVar.getContentDescription());
            }
            if (z || TextUtils.isEmpty(aVar.getContentDescription())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.abc.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    static /* synthetic */ b a(ai aiVar, android.support.v7.app.ActionBar.a aVar) {
        b bVar = new b(aiVar, aiVar.getContext(), aVar, true);
        bVar.setBackgroundDrawable(null);
        bVar.setLayoutParams(new AbsListView.LayoutParams(-1, aiVar.QG));
        return bVar;
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.aaS.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.aaV = -1;
        } else {
            if (childCount > 2) {
                this.aaV = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.aaV = MeasureSpec.getSize(i) / 2;
            }
            this.aaV = Math.min(this.aaV, this.aaW);
        }
        mode = MeasureSpec.makeMeasureSpec(this.QG, 1073741824);
        if (z || !this.aaU) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.aaS.measure(0, mode);
            if (this.aaS.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                gw();
            } else if (!gv()) {
                if (this.aaT == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, android.support.v7.a.a.a.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.aaT = appCompatSpinner;
                }
                removeView(this.aaS);
                addView(this.aaT, new LayoutParams(-2, -1));
                if (this.aaT.getAdapter() == null) {
                    this.aaT.setAdapter(new a());
                }
                if (this.aaR != null) {
                    removeCallbacks(this.aaR);
                    this.aaR = null;
                }
                this.aaT.setSelection(this.aaX);
            }
        } else {
            gw();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            bh(this.aaX);
        }
    }

    private boolean gv() {
        return this.aaT != null && this.aaT.getParent() == this;
    }

    private boolean gw() {
        if (gv()) {
            removeView(this.aaT);
            addView(this.aaS, new LayoutParams(-2, -1));
            bh(this.aaT.getSelectedItemPosition());
        }
        return false;
    }

    private void bh(int i) {
        this.aaX = i;
        int childCount = this.aaS.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.aaS.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.aaS.getChildAt(i);
                if (this.aaR != null) {
                    removeCallbacks(this.aaR);
                }
                this.aaR = new Runnable(this) {
                    final /* synthetic */ ai aba;

                    public final void run() {
                        this.aba.smoothScrollTo(childAt2.getLeft() - ((this.aba.getWidth() - childAt2.getWidth()) / 2), 0);
                        this.aba.aaR = null;
                    }
                };
                post(this.aaR);
            }
        }
        if (this.aaT != null && i >= 0) {
            this.aaT.setSelection(i);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a m = android.support.v7.view.a.m(getContext());
        TypedArray obtainStyledAttributes = m.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(k.Kp, 0);
        Resources resources = m.mContext.getResources();
        if (!m.dj()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.HY));
        }
        obtainStyledAttributes.recycle();
        this.QG = layoutDimension;
        requestLayout();
        this.aaW = m.mContext.getResources().getDimensionPixelSize(d.HZ);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aaR != null) {
            post(this.aaR);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aaR != null) {
            removeCallbacks(this.aaR);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
