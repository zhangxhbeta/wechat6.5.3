package com.tencent.mm.plugin.card.ui.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.ne;
import java.util.LinkedList;

public final class i extends f {
    View eMJ;
    LinearLayout eMK;
    boolean eML = false;

    public final void NI() {
    }

    public final void update() {
        if (this.eMJ == null) {
            this.eMJ = ((ViewStub) findViewById(2131755813)).inflate();
        }
        final ne neVar = this.eMF.abq().Zw().mkx;
        ((TextView) this.eMJ.findViewById(2131755794)).setText(neVar.title);
        if (neVar.mpe != null && neVar.mpe.size() > 0) {
            this.eMK = (LinearLayout) this.eMJ.findViewById(2131755795);
            this.eMK.removeAllViews();
            final LinkedList linkedList = neVar.mpe;
            final LayoutInflater layoutInflater = (LayoutInflater) this.eMF.abt().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (neVar.mpd >= linkedList.size() || this.eML) {
                this.eMJ.findViewById(2131755796).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(2130903262, null, false);
                    textView.setText(((ld) linkedList.get(i)).title);
                    this.eMK.addView(textView);
                }
                this.eMK.invalidate();
                return;
            }
            for (i = 0; i < neVar.mpd; i++) {
                textView = (TextView) layoutInflater.inflate(2130903262, null, false);
                textView.setText(((ld) linkedList.get(i)).title);
                this.eMK.addView(textView);
            }
            this.eMK.invalidate();
            this.eMJ.findViewById(2131755796).setVisibility(0);
            this.eMJ.findViewById(2131755796).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ i eMP;

                public final void onClick(View view) {
                    this.eMP.eML = true;
                    this.eMP.eMJ.findViewById(2131755796).setVisibility(8);
                    for (int i = neVar.mpd; i < linkedList.size(); i++) {
                        TextView textView = (TextView) layoutInflater.inflate(2130903262, null, false);
                        textView.setText(((ld) linkedList.get(i)).title);
                        this.eMP.eMK.addView(textView);
                    }
                    this.eMP.eMK.invalidate();
                }
            });
        }
    }

    public final void acF() {
        if (this.eMJ != null) {
            this.eMJ.setVisibility(8);
        }
    }
}
