package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private ImageView dQZ;
    private int height;
    private Bitmap lPE;
    public OnClickListener lwQ;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904014, viewGroup2);
        this.dQZ = (ImageView) onCreateView.findViewById(2131758252);
        return onCreateView;
    }

    public final void C(Bitmap bitmap) {
        this.lPE = null;
        if (this.dQZ != null) {
            this.dQZ.setImageBitmap(bitmap);
        } else {
            this.lPE = bitmap;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.dQZ == null) {
            this.dQZ = (ImageView) view.findViewById(2131758252);
        }
        if (this.lwQ != null) {
            this.dQZ.setOnClickListener(this.lwQ);
        }
        if (this.lPE != null) {
            this.dQZ.setImageBitmap(this.lPE);
            this.lPE = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758240);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
    }
}
