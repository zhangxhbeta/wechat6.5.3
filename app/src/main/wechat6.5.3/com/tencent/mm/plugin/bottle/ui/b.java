package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ui.base.i;

public final class b extends i {
    TextView eux = ((TextView) this.view.findViewById(2131755661));
    private Button euy = ((Button) this.view.findViewById(2131755662));
    private View view;

    public b(Context context) {
        super(context, 2131559273);
        this.view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130903187, null);
        setContentView(this.view, new LayoutParams(-2, -2));
        this.euy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b euz;

            {
                this.euz = r1;
            }

            public final void onClick(View view) {
                this.euz.dismiss();
            }
        });
    }
}
