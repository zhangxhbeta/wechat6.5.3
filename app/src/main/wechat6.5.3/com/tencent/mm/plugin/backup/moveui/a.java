package com.tencent.mm.plugin.backup.moveui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.backup.movemodel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> edo = new HashSet();
    BakMoveChooseUI elM;

    class a {
        ImageView dtX;
        TextView dtY;
        TextView dtZ;
        CheckBox dua;
        RelativeLayout edr;
        final /* synthetic */ a elN;

        a(a aVar) {
            this.elN = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return in(i);
    }

    public a(BakMoveChooseUI bakMoveChooseUI) {
        this.elM = bakMoveChooseUI;
    }

    public final int getCount() {
        ArrayList Tu = g.Tu();
        if (Tu != null) {
            return Tu.size();
        }
        return 0;
    }

    private static com.tencent.mm.plugin.backup.movemodel.a in(int i) {
        return (com.tencent.mm.plugin.backup.movemodel.a) g.Tu().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.elM.getLayoutInflater().inflate(2130903152, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.dtX = (ImageView) view.findViewById(2131755508);
            aVar2.dtY = (TextView) view.findViewById(2131755456);
            aVar2.dtZ = (TextView) view.findViewById(2131755458);
            aVar2.dua = (CheckBox) view.findViewById(2131755510);
            aVar2.edr = (RelativeLayout) view.findViewById(2131755509);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.edr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a elN;

            public final void onClick(View view) {
                if (this.elN.edo.contains(Integer.valueOf(i))) {
                    this.elN.edo.remove(Integer.valueOf(i));
                } else {
                    this.elN.edo.add(Integer.valueOf(i));
                }
                this.elN.notifyDataSetChanged();
                this.elN.elM.a(this.elN.edo);
            }
        });
        com.tencent.mm.plugin.backup.movemodel.a in = in(i);
        b.m(aVar.dtX, in.username);
        aVar.dtY.setText(be.aw(in.beE));
        if (m.dE(in.username)) {
            aVar.dtZ.setText(e.a(this.elM, l.D(in.username, in.username), aVar.dtZ.getTextSize()));
        } else {
            aVar.dtZ.setText(e.a(this.elM, l.er(in.username), aVar.dtZ.getTextSize()));
        }
        if (this.edo.contains(Integer.valueOf(i))) {
            aVar.dua.setChecked(true);
        } else {
            aVar.dua.setChecked(false);
        }
        return view;
    }
}
