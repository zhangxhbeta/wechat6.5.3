package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements w {
    private static final boolean Uf;
    private static final boolean Ug;
    private static final int[] Uh = new int[]{16843505};
    private android.support.v7.widget.ListPopupWindow.b OP;
    private Context QD;
    private h Ts;
    private f Tt;
    private SpinnerAdapter Ui;
    private boolean Uj;
    private b Uk;
    private int Ul;
    private final Rect ep;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter Uo;
        private ListAdapter Up;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.Uo = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.Up = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && AppCompatSpinner.Uf && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            return this.Uo == null ? 0 : this.Uo.getCount();
        }

        public final Object getItem(int i) {
            return this.Uo == null ? null : this.Uo.getItem(i);
        }

        public final long getItemId(int i) {
            return this.Uo == null ? -1 : this.Uo.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.Uo == null ? null : this.Uo.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.Uo != null && this.Uo.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Uo != null) {
                this.Uo.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Uo != null) {
                this.Uo.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.Up;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.Up;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class b extends ListPopupWindow {
        private ListAdapter EK;
        final /* synthetic */ AppCompatSpinner Un;
        CharSequence Uq;
        private final Rect Ur = new Rect();

        static /* synthetic */ boolean a(b bVar, View view) {
            return y.ak(view) && view.getGlobalVisibleRect(bVar.Ur);
        }

        public b(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.Un = appCompatSpinner;
            super(context, attributeSet, i);
            this.Xn = appCompatSpinner;
            fi();
            this.Xl = 0;
            this.Xp = new OnItemClickListener(this) {
                final /* synthetic */ b Ut;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.Ut.Un.setSelection(i);
                    if (this.Ut.Un.getOnItemClickListener() != null) {
                        this.Ut.Un.performItemClick(view, i, this.Ut.EK.getItemId(i));
                    }
                    this.Ut.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.EK = listAdapter;
        }

        final void eE() {
            int i;
            int i2;
            Drawable background = this.Xa.getBackground();
            if (background != null) {
                background.getPadding(this.Un.ep);
                i = as.bu(this.Un) ? this.Un.ep.right : -this.Un.ep.left;
            } else {
                Rect b = this.Un.ep;
                this.Un.ep.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.Un.getPaddingLeft();
            int paddingRight = this.Un.getPaddingRight();
            int width = this.Un.getWidth();
            if (this.Un.Ul == -2) {
                int a = this.Un.a((SpinnerAdapter) this.EK, this.Xa.getBackground());
                i2 = (this.Un.getContext().getResources().getDisplayMetrics().widthPixels - this.Un.ep.left) - this.Un.ep.right;
                if (a <= i2) {
                    i2 = a;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.Un.Ul == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(this.Un.Ul);
            }
            if (as.bu(this.Un)) {
                i2 = ((width - paddingRight) - this.Ul) + i;
            } else {
                i2 = i + paddingLeft;
            }
            this.Xd = i2;
        }

        public final void show() {
            boolean isShowing = this.Xa.isShowing();
            eE();
            fj();
            super.show();
            this.Xb.setChoiceMode(1);
            int selectedItemPosition = this.Un.getSelectedItemPosition();
            a aVar = this.Xb;
            if (this.Xa.isShowing() && aVar != null) {
                aVar.Xy = false;
                aVar.setSelection(selectedItemPosition);
                if (VERSION.SDK_INT >= 11 && aVar.getChoiceMode() != 0) {
                    aVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = this.Un.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b Ut;

                        {
                            this.Ut = r1;
                        }

                        public final void onGlobalLayout() {
                            if (b.a(this.Ut, this.Ut.Un)) {
                                this.Ut.eE();
                                super.show();
                                return;
                            }
                            this.Ut.dismiss();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ b Ut;

                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.Ut.Un.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        Uf = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        Ug = z;
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context dVar;
        AppCompatSpinner appCompatSpinner;
        TypedArray obtainStyledAttributes;
        final b bVar;
        ap a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        Throwable th;
        TypedArray typedArray = null;
        super(context, attributeSet, i);
        this.ep = new Rect();
        ap a2 = ap.a(context, attributeSet, k.cL, i);
        this.Ts = h.eD();
        this.Tt = new f(this, this.Ts);
        int resourceId = a2.getResourceId(k.Mq, 0);
        if (resourceId != 0) {
            dVar = new d(context, resourceId);
            appCompatSpinner = this;
        } else if (Uf) {
            dVar = null;
            appCompatSpinner = this;
        } else {
            dVar = context;
            appCompatSpinner = this;
        }
        appCompatSpinner.QD = dVar;
        if (this.QD != null) {
            if (VERSION.SDK_INT >= 11) {
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Uh, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e) {
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.QD, attributeSet, i);
                            a = ap.a(this.QD, attributeSet, k.cL, i);
                            this.Ul = a.getLayoutDimension(k.Mm, -2);
                            bVar.setBackgroundDrawable(a.getDrawable(k.Mo));
                            bVar.Uq = a2.adM.getString(k.Mp);
                            a.adM.recycle();
                            this.Uk = bVar;
                            this.OP = new android.support.v7.widget.ListPopupWindow.b(this, this) {
                                final /* synthetic */ AppCompatSpinner Un;

                                public final ListPopupWindow dt() {
                                    return bVar;
                                }

                                public final boolean du() {
                                    if (!this.Un.Uk.Xa.isShowing()) {
                                        this.Un.Uk.show();
                                    }
                                    return true;
                                }
                            };
                        }
                        textArray = a2.adM.getTextArray(k.Mn);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, h.Ka, textArray);
                            arrayAdapter.setDropDownViewResource(h.Ka);
                            setAdapter(arrayAdapter);
                        }
                        a2.adM.recycle();
                        this.Uj = true;
                        if (this.Ui != null) {
                            setAdapter(this.Ui);
                            this.Ui = null;
                        }
                        this.Tt.a(attributeSet, i);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        typedArray = obtainStyledAttributes;
                        th = th3;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        bVar = new b(this, this.QD, attributeSet, i);
                        a = ap.a(this.QD, attributeSet, k.cL, i);
                        this.Ul = a.getLayoutDimension(k.Mm, -2);
                        bVar.setBackgroundDrawable(a.getDrawable(k.Mo));
                        bVar.Uq = a2.adM.getString(k.Mp);
                        a.adM.recycle();
                        this.Uk = bVar;
                        this.OP = /* anonymous class already generated */;
                    }
                    textArray = a2.adM.getTextArray(k.Mn);
                    if (textArray != null) {
                        arrayAdapter = new ArrayAdapter(context, h.Ka, textArray);
                        arrayAdapter.setDropDownViewResource(h.Ka);
                        setAdapter(arrayAdapter);
                    }
                    a2.adM.recycle();
                    this.Uj = true;
                    if (this.Ui != null) {
                        setAdapter(this.Ui);
                        this.Ui = null;
                    }
                    this.Tt.a(attributeSet, i);
                } catch (Throwable th4) {
                    th = th4;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                bVar = new b(this, this.QD, attributeSet, i);
                a = ap.a(this.QD, attributeSet, k.cL, i);
                this.Ul = a.getLayoutDimension(k.Mm, -2);
                bVar.setBackgroundDrawable(a.getDrawable(k.Mo));
                bVar.Uq = a2.adM.getString(k.Mp);
                a.adM.recycle();
                this.Uk = bVar;
                this.OP = /* anonymous class already generated */;
            }
        }
        textArray = a2.adM.getTextArray(k.Mn);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, h.Ka, textArray);
            arrayAdapter.setDropDownViewResource(h.Ka);
            setAdapter(arrayAdapter);
        }
        a2.adM.recycle();
        this.Uj = true;
        if (this.Ui != null) {
            setAdapter(this.Ui);
            this.Ui = null;
        }
        this.Tt.a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.Uk != null) {
            return this.QD;
        }
        if (Uf) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.Uk != null) {
            this.Uk.setBackgroundDrawable(drawable);
        } else if (Ug) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.content.a.a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.Uk != null) {
            return this.Uk.Xa.getBackground();
        }
        if (Ug) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.Uk != null) {
            ListPopupWindow listPopupWindow = this.Uk;
            listPopupWindow.Xe = i;
            listPopupWindow.Xg = true;
        } else if (Ug) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.Uk != null) {
            ListPopupWindow listPopupWindow = this.Uk;
            if (listPopupWindow.Xg) {
                return listPopupWindow.Xe;
            }
            return 0;
        } else if (Ug) {
            return super.getDropDownVerticalOffset();
        } else {
            return 0;
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.Uk != null) {
            this.Uk.Xd = i;
        } else if (Ug) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.Uk != null) {
            return this.Uk.Xd;
        }
        if (Ug) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.Uk != null) {
            this.Ul = i;
        } else if (Ug) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.Uk != null) {
            return this.Ul;
        }
        if (Ug) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.Uj) {
            super.setAdapter(spinnerAdapter);
            if (this.Uk != null) {
                this.Uk.setAdapter(new a(spinnerAdapter, (this.QD == null ? getContext() : this.QD).getTheme()));
                return;
            }
            return;
        }
        this.Ui = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Uk != null && this.Uk.Xa.isShowing()) {
            this.Uk.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OP == null || !this.OP.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Uk != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.Uk == null) {
            return super.performClick();
        }
        if (!this.Uk.Xa.isShowing()) {
            this.Uk.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.Uk != null) {
            this.Uk.Uq = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.Uk != null ? this.Uk.Uq : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Tt != null) {
            this.Tt.aI(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Tt != null) {
            this.Tt.g(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (this.Tt != null) {
            this.Tt.e(colorStateList);
        }
    }

    public final ColorStateList bO() {
        return this.Tt != null ? this.Tt.bO() : null;
    }

    public final void b(Mode mode) {
        if (this.Tt != null) {
            this.Tt.b(mode);
        }
    }

    public final Mode bP() {
        return this.Tt != null ? this.Tt.bP() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Tt != null) {
            this.Tt.eA();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.ep);
        return (this.ep.left + this.ep.right) + i;
    }
}
