package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean fJm = false;
    private LinearLayout kKu;
    private TextView lQs;
    public CharSequence lQt;
    public CharSequence lQu;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, 2130904061, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131755329).findViewById(2131758290);
        if (this.kKu == null) {
            this.kKu = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.lQs == null) {
            this.lQs = (TextView) viewGroup.findViewById(2131758293);
        }
        if (this.fJm) {
            this.kKu.setVisibility(0);
            this.lQs.setVisibility(0);
        } else {
            this.kKu.setVisibility(8);
            this.lQs.setVisibility(8);
        }
        if (this.lQu != null) {
            this.lQs.setText(this.lQu);
        }
    }
}
