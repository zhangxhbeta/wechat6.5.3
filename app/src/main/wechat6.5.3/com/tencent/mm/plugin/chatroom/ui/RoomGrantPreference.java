package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    TextView eRp = null;
    String eRq = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
        setWidgetLayoutResource(2130904064);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904030, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.eRp == null) {
            this.eRp = (TextView) view.findViewById(2131757427);
        }
        this.eRp.setText(this.eRq);
        super.onBindView(view);
    }
}
