package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.v4.os.c;
import android.support.v4.view.y;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] dM = new int[]{16842912};
    private static final int[] iJ = new int[]{-16842910};
    private final android.support.design.internal.a iK;
    private final b iL;
    private a iM;
    private int iN;
    private MenuInflater iO;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        public Bundle iQ;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.iQ = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.iQ);
        }
    }

    public interface a {
        boolean ai();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        boolean z;
        super(context, attributeSet, i);
        this.iL = new b();
        t.g(context);
        this.iK = new android.support.design.internal.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.co, i, h.aR);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.cp));
        if (obtainStyledAttributes.hasValue(i.cs)) {
            y.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(i.cs, 0));
        }
        y.a((View) this, obtainStyledAttributes.getBoolean(i.cq, false));
        this.iN = obtainStyledAttributes.getDimensionPixelSize(i.cr, 0);
        if (obtainStyledAttributes.hasValue(i.cv)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i.cv);
        } else {
            colorStateList = v(16842808);
        }
        if (obtainStyledAttributes.hasValue(i.cw)) {
            resourceId = obtainStyledAttributes.getResourceId(i.cw, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(i.cx)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(i.cx);
        }
        if (!z && r5 == null) {
            colorStateList2 = v(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cu);
        this.iK.a(new android.support.v7.view.menu.f.a(this) {
            final /* synthetic */ NavigationView iP;

            {
                this.iP = r1;
            }

            public final boolean a(f fVar, MenuItem menuItem) {
                return this.iP.iM != null && this.iP.iM.ai();
            }

            public final void b(f fVar) {
            }
        });
        this.iL.dW = 1;
        this.iL.a(context, this.iK);
        this.iL.a(colorStateList);
        if (z) {
            this.iL.e(resourceId);
        }
        this.iL.b(colorStateList2);
        this.iL.a(drawable);
        this.iK.a(this.iL);
        b bVar = this.iL;
        if (bVar.dS == null) {
            bVar.dS = (NavigationMenuView) bVar.dY.inflate(android.support.design.a.f.aF, this, false);
            if (bVar.dX == null) {
                bVar.dX = new b(bVar);
            }
            bVar.dT = (LinearLayout) bVar.dY.inflate(android.support.design.a.f.aC, bVar.dS, false);
            bVar.dS.a(bVar.dX);
        }
        addView(bVar.dS);
        if (obtainStyledAttributes.hasValue(i.cy)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i.cy, 0);
            this.iL.g(true);
            if (this.iO == null) {
                this.iO = new g(getContext());
            }
            this.iO.inflate(resourceId2, this.iK);
            this.iL.g(false);
            this.iL.f(false);
        }
        if (obtainStyledAttributes.hasValue(i.ct)) {
            resourceId2 = obtainStyledAttributes.getResourceId(i.ct, 0);
            bVar = this.iL;
            bVar.dT.addView(bVar.dY.inflate(resourceId2, bVar.dT, false));
            bVar.dS.setPadding(0, 0, 0, bVar.dS.getPaddingBottom());
        }
        obtainStyledAttributes.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.iQ = new Bundle();
        this.iK.dispatchSaveInstanceState(savedState.iQ);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            f fVar = this.iK;
            SparseArray sparseParcelableArray = savedState.iQ.getSparseParcelableArray("android:menu:presenters");
            if (sparseParcelableArray != null && !fVar.PN.isEmpty()) {
                Iterator it = fVar.PN.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar = (l) weakReference.get();
                    if (lVar == null) {
                        fVar.PN.remove(weakReference);
                    } else {
                        int id = lVar.getId();
                        if (id > 0) {
                            Parcelable parcelable2 = (Parcelable) sparseParcelableArray.get(id);
                            if (parcelable2 != null) {
                                lVar.onRestoreInstanceState(parcelable2);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.iN), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.iN, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected final void a(Rect rect) {
        b bVar = this.iL;
        int i = rect.top;
        if (bVar.ed != i) {
            bVar.ed = i;
            if (bVar.dT.getChildCount() == 0) {
                bVar.dS.setPadding(0, bVar.ed, 0, bVar.dS.getPaddingBottom());
            }
        }
    }

    private ColorStateList v(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.design.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{iJ, dM, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iJ, defaultColor), i2, defaultColor});
    }
}
