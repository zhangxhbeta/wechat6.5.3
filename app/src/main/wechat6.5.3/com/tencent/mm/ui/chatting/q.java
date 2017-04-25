package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;
import java.util.ArrayList;
import java.util.List;

final class q extends a {
    LinearLayout ihk;
    List<p> ilV = new ArrayList();
    ChattingItemFooter okI;
    TextView oks;
    s olD = new s();

    public q(int i) {
        super(i);
    }

    public final a cL(View view) {
        ViewGroup viewGroup = (ViewGroup) this.olD.ilI.getParent();
        p pVar = new p();
        pVar.ilI = view;
        pVar.dID = (TextView) view.findViewById(2131755226);
        pVar.olC = (TextView) view.findViewById(2131756108);
        pVar.ilJ = view.findViewById(2131756109);
        pVar.ilK = (ImageView) view.findViewById(2131756093);
        pVar.ilM = (ProgressBar) view.findViewById(2131756110);
        pVar.ilN = view.findViewById(2131756111);
        viewGroup.addView(view, viewGroup.getChildCount() - 1);
        this.ilV.add(pVar);
        return this;
    }
}
