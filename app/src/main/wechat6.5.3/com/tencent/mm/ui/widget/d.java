package com.tencent.mm.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public final class d extends LinearLayout {
    private View gXy = findViewById(2131755276);
    public a pbA;
    public FTSEditTextView pbz;

    public interface a {
        void bkT();
    }

    public interface b extends Comparable {
        String getTagName();
    }

    public d(Context context) {
        super(context);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903673, this, true);
        this.gXy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d pbB;

            {
                this.pbB = r1;
            }

            public final void onClick(View view) {
                if (this.pbB.pbA != null) {
                    this.pbB.pbA.bkT();
                }
            }
        });
        this.pbz = (FTSEditTextView) findViewById(2131757140);
    }
}
