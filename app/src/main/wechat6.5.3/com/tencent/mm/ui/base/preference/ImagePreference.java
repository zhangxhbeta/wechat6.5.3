package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;

public final class ImagePreference extends Preference {
    private ImageView hWm;
    private e ocI;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWm = null;
        this.ocI = new e();
        setLayoutResource(2130904046);
        setWidgetLayoutResource(2130904064);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPj);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            e eVar = this.ocI;
            eVar.kCd = resourceId;
            eVar.bitmap = null;
            this.ocI.d(this.hWm);
        }
        obtainStyledAttributes.recycle();
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131758280);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904046, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hWm = (ImageView) view.findViewById(2131756901);
        this.ocI.d(this.hWm);
    }
}
