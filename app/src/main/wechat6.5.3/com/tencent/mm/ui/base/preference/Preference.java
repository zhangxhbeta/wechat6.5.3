package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.q;
import java.util.List;

public class Preference implements Comparable<Preference> {
    public int OL;
    public String dnU;
    public int eNB;
    private CharSequence hXs;
    public Drawable jP;
    public final Context mContext;
    private boolean odA;
    public boolean odB;
    String odC;
    private Object odD;
    private boolean odE;
    private boolean odF;
    int odG;
    int odH;
    private boolean odI;
    private List<Preference> odJ;
    private a odu;
    private int odv;
    private int odw;
    private int odx;
    private String ody;
    boolean odz;
    private CharSequence up;
    private int[] wZ;
    private boolean zU;

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new Creator<BaseSavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public /* synthetic */ int compareTo(Object obj) {
        int i = 0;
        Preference preference = (Preference) obj;
        if (this.odv != Integer.MAX_VALUE || (this.odv == Integer.MAX_VALUE && preference.odv != Integer.MAX_VALUE)) {
            return this.odv - preference.odv;
        }
        if (this.up == null) {
            return 1;
        }
        if (preference.up == null) {
            return -1;
        }
        CharSequence charSequence = this.up;
        CharSequence charSequence2 = preference.up;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char toLowerCase = Character.toLowerCase(charSequence.charAt(i3));
            i3 = i + 1;
            i = toLowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (i != 0) {
                return i;
            }
            i = i3;
            i3 = i4;
        }
        return length - length2;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.wZ = new int[]{2130771975, 2130771974};
        this.odv = Integer.MAX_VALUE;
        this.zU = true;
        this.odz = true;
        this.odB = true;
        this.odE = true;
        this.eNB = -1;
        this.odF = true;
        this.odG = 2130903996;
        this.odI = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPx, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == 5) {
                this.OL = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == 6) {
                this.dnU = obtainStyledAttributes.getString(index);
            } else if (index == 4) {
                this.odw = obtainStyledAttributes.getResourceId(index, 0);
                this.up = obtainStyledAttributes.getString(index);
                if (this.odw != 0) {
                    this.up = context.getString(this.odw);
                }
            } else if (index == 3) {
                this.hXs = obtainStyledAttributes.getString(index);
                this.odx = obtainStyledAttributes.getResourceId(index, 0);
                if (this.odx != 0) {
                    this.hXs = context.getString(this.odx);
                }
            } else if (index == 7) {
                this.odv = obtainStyledAttributes.getInt(index, this.odv);
            } else if (index == 1) {
                this.ody = obtainStyledAttributes.getString(index);
            } else if (index == 13) {
                this.odG = obtainStyledAttributes.getResourceId(index, this.odG);
            } else if (index == 8) {
                this.odH = obtainStyledAttributes.getResourceId(index, this.odH);
            } else if (index == 0) {
                this.zU = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 9) {
                this.odz = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 2) {
                this.odB = obtainStyledAttributes.getBoolean(index, this.odB);
            } else if (index == 10) {
                this.odC = obtainStyledAttributes.getString(index);
            } else if (index == 11) {
                this.odD = null;
            } else if (index == 12) {
                this.odF = obtainStyledAttributes.getBoolean(index, this.odF);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.odI = true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final void setLayoutResource(int i) {
        if (i != this.odG) {
            this.odI = true;
        }
        this.odG = i;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.odH) {
            this.odI = true;
        }
        this.odH = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public View onCreateView(ViewGroup viewGroup) {
        LayoutInflater em = q.em(this.mContext);
        View inflate = em.inflate(this.odG, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.odH != 0) {
                em.inflate(this.odH, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onBindView(View view) {
        int i = 0;
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.eNB != -1) {
                    textView.setTextColor(this.eNB);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.OL == 0 && this.jP == null)) {
                if (this.jP == null) {
                    this.jP = this.mContext.getResources().getDrawable(this.OL);
                }
                if (this.jP != null) {
                    imageView.setImageDrawable(this.jP);
                }
            }
            if (this.jP == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        if (this.odF) {
            l(view, isEnabled());
        }
    }

    private void l(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                l(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.up != null) || (charSequence != null && !charSequence.equals(this.up))) {
            this.odw = 0;
            this.up = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.odw = i;
    }

    public CharSequence getTitle() {
        return this.up;
    }

    public CharSequence getSummary() {
        return this.hXs;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.hXs != null) || (charSequence != null && !charSequence.equals(this.hXs))) {
            this.hXs = charSequence;
            notifyChanged();
        }
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public final void setEnabled(boolean z) {
        if (this.zU != z) {
            this.zU = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public final boolean isEnabled() {
        return this.zU && this.odE;
    }

    public final void setSelectable(boolean z) {
        if (this.odz != z) {
            this.odz = z;
            notifyChanged();
        }
    }

    public final void setKey(String str) {
        this.dnU = str;
        if (this.odA) {
            if (!(!TextUtils.isEmpty(this.dnU))) {
                if (this.dnU == null) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                this.odA = true;
            }
        }
    }

    public final boolean callChangeListener(Object obj) {
        return this.odu == null ? true : this.odu.a(this, obj);
    }

    public void a(a aVar) {
        this.odu = aVar;
    }

    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        List list = this.odJ;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) list.get(i);
                if (preference.odE == z) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    preference.odE = z2;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    private boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
