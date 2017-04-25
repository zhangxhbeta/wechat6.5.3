package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView dtB;
    public ViewGroup gUN;
    public MMImageButton gUO;
    public MMImageButton gUP;
    private Context mContext;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, 2130904378, this);
        this.gUN = (ViewGroup) inflate.findViewById(2131758187);
        this.gUO = (MMImageButton) inflate.findViewById(2131759182);
        this.gUP = (MMImageButton) inflate.findViewById(2131759184);
        this.dtB = (TextView) inflate.findViewById(2131755226);
    }
}
