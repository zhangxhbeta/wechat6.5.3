package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<a> jS = new ArrayList();
    private Context mContext;
    private int oY;
    private k qI;
    private OnTabChangeListener qN;
    private a qO;
    private boolean qP;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String qQ;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.qQ = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.qQ);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.qQ + "}";
        }
    }

    static final class a {
        Fragment og;
        final Class<?> qR;
        final Bundle qS;
        final String tag;
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.oY = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.qN = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        n nVar = null;
        for (int i = 0; i < this.jS.size(); i++) {
            a aVar = (a) this.jS.get(i);
            aVar.og = this.qI.k(aVar.tag);
            if (!(aVar.og == null || aVar.og.pb)) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.qO = aVar;
                } else {
                    if (nVar == null) {
                        nVar = this.qI.aW();
                    }
                    nVar.b(aVar.og);
                }
            }
        }
        this.qP = true;
        n a = a(currentTabTag, nVar);
        if (a != null) {
            a.commit();
            this.qI.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qP = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.qQ = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.qQ);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.qP) {
            n a = a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.qN != null) {
            this.qN.onTabChanged(str);
        }
    }

    private n a(String str, n nVar) {
        a aVar = null;
        int i = 0;
        while (i < this.jS.size()) {
            a aVar2 = (a) this.jS.get(i);
            if (!aVar2.tag.equals(str)) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.qO != aVar) {
            if (nVar == null) {
                nVar = this.qI.aW();
            }
            if (!(this.qO == null || this.qO.og == null)) {
                nVar.b(this.qO.og);
            }
            if (aVar != null) {
                if (aVar.og == null) {
                    aVar.og = Fragment.a(this.mContext, aVar.qR.getName(), aVar.qS);
                    nVar.a(this.oY, aVar.og, aVar.tag);
                } else {
                    nVar.c(aVar.og);
                }
            }
            this.qO = aVar;
        }
        return nVar;
    }
}
