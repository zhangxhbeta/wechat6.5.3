package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends f {
    private View eMV;
    private View eMW;

    public final void NI() {
    }

    public final void update() {
        b abq = this.eMF.abq();
        g abv = this.eMF.abv();
        ld ldVar;
        if (abq.Zw().mko != null && abq.Zw().mko.size() > 1) {
            if (this.eMV == null) {
                this.eMV = ((ViewStub) findViewById(2131755809)).inflate();
            }
            MMActivity abt = this.eMF.abt();
            View view = this.eMV;
            OnClickListener abu = this.eMF.abu();
            LinkedList linkedList = abq.Zw().mko;
            int qv = j.qv(abq.Zv().coN);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ldVar = (ld) it.next();
                View inflate = q.em(abt).inflate(2130903245, (ViewGroup) view, false);
                inflate.setId(2131755954);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(ldVar)));
                inflate.setOnClickListener(abu);
                if (TextUtils.isEmpty(ldVar.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(2131755955)).setText(ldVar.title);
                TextView textView = (TextView) inflate.findViewById(2131755956);
                textView.setText(ldVar.eBN);
                textView.setTextColor(qv);
                ((ViewGroup) view).addView(inflate);
                if (linkedList.indexOf(ldVar) + 1 != linkedList.size()) {
                    ((ViewGroup) view).addView(q.em(abt).inflate(2130903246, (ViewGroup) view, false));
                }
            }
            if (!(!abq.Zc() || abq.Zw().mkv == null || TextUtils.isEmpty(abq.Zw().mkv.title))) {
                this.eMV.setBackgroundResource(2130838689);
            }
            if (!abq.Zc() && abv.acs()) {
                this.eMV.setBackgroundResource(2130838689);
            }
        } else if (abq.Zw().mko == null || abq.Zw().mko.size() != 1) {
            if (this.eMV != null) {
                this.eMV.setVisibility(8);
            }
            if (this.eMW != null) {
                this.eMW.setVisibility(8);
            }
        } else {
            if (this.eMW == null) {
                this.eMW = ((ViewStub) findViewById(2131755810)).inflate();
            }
            View view2 = this.eMW;
            OnClickListener abu2 = this.eMF.abu();
            LinkedList linkedList2 = abq.Zw().mko;
            if (linkedList2.size() == 1) {
                view2.findViewById(2131755957).setVisibility(0);
                ldVar = (ld) linkedList2.get(0);
                ((TextView) view2.findViewById(2131755958)).setText(ldVar.title);
                ((TextView) view2.findViewById(2131755959)).setText(ldVar.eBN);
                ((TextView) view2.findViewById(2131755959)).setTextColor(j.qv(abq.Zv().coN));
                view2.findViewById(2131755957).setOnClickListener(abu2);
                if (TextUtils.isEmpty(ldVar.url)) {
                    view2.findViewById(2131755957).setEnabled(false);
                }
            }
            if (!(!abq.Zc() || abq.Zw().mkv == null || TextUtils.isEmpty(abq.Zw().mkv.title))) {
                this.eMW.setBackgroundResource(2130838689);
            }
            if (!abq.Zc() && abv.acs()) {
                this.eMW.setBackgroundResource(2130838689);
            }
        }
    }

    public final void acF() {
        if (this.eMV != null) {
            this.eMV.setVisibility(8);
        }
        if (this.eMW != null) {
            this.eMW.setVisibility(8);
        }
    }
}
