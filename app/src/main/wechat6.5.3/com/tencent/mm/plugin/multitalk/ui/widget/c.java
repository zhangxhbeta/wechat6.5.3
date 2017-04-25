package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c implements OnClickListener {
    private TextView exI;
    private MultiTalkMainUI hBh;
    private View hBi;
    private TextView hBj;
    private ImageView hBk;
    private LinearLayout hBl;
    private ImageButton hBm;
    private ImageButton hBn;

    public c(MultiTalkMainUI multiTalkMainUI) {
        this.hBh = multiTalkMainUI;
        this.hBi = multiTalkMainUI.findViewById(2131758338);
        this.hBj = (TextView) multiTalkMainUI.findViewById(2131758340);
        this.hBk = (ImageView) multiTalkMainUI.findViewById(2131758339);
        this.hBl = (LinearLayout) multiTalkMainUI.findViewById(2131758342);
        this.exI = (TextView) multiTalkMainUI.findViewById(2131758341);
        this.hBm = (ImageButton) multiTalkMainUI.findViewById(2131758344);
        this.hBn = (ImageButton) multiTalkMainUI.findViewById(2131758343);
        this.hBm.setOnClickListener(this);
        this.hBn.setOnClickListener(this);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i;
        this.hBi.setVisibility(0);
        String aCx = i.aCx();
        List arrayList = new ArrayList();
        if (!be.kS(aCx)) {
            for (i = 0; i < multiTalkGroup.pte.size(); i++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.pte.get(i)).ptf.equals(aCx)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.pte.get(i)).ptf);
                }
            }
            this.hBj.setText(e.a(this.hBh, l.er(aCx)));
            b.a(this.hBk, aCx, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.exI.setVisibility(0);
            this.exI.setText(2131233941);
            this.hBl.setVisibility(0);
            this.hBl.removeAllViews();
            for (i = 0; i < arrayList.size(); i++) {
                View imageView = new ImageView(this.hBh.nDR.nEl);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(b.hBa, b.hBa);
                if (i != 0) {
                    layoutParams.leftMargin = b.hAY;
                }
                imageView.setLayoutParams(layoutParams);
                this.hBl.addView(imageView);
                b.a(imageView, (String) arrayList.get(i), 0.1f, false);
            }
            return;
        }
        this.exI.setVisibility(8);
        this.hBl.setVisibility(8);
    }

    public final void aCL() {
        this.hBi.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view.getId() == 2131758343) {
            o.aCG().c(true, false, false);
        } else if (view.getId() == 2131758344) {
            com.tencent.mm.plugin.multitalk.a.e aCG = o.aCG();
            if (aCG.aCc()) {
                v.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[]{i.h(aCG.hzq)});
                o.aCF().hyY.cp(aCG.hzq.pta, aCG.hzq.ppl);
                return;
            }
            v.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
    }
}
