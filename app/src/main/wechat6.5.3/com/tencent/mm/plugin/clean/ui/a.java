package com.tencent.mm.plugin.clean.ui;

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
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    CleanChattingUI eVj;
    HashSet<Integer> edo = new HashSet();

    class a {
        ImageView dtX;
        TextView dtY;
        TextView dtZ;
        CheckBox dua;
        final /* synthetic */ a eVk;
        RelativeLayout edr;

        a(a aVar) {
            this.eVk = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ju(i);
    }

    public a(CleanChattingUI cleanChattingUI) {
        this.eVj = cleanChattingUI;
    }

    public final int getCount() {
        ArrayList Tu = d.Tu();
        if (Tu != null) {
            return Tu.size();
        }
        return 0;
    }

    private static b ju(int i) {
        return (b) d.Tu().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.eVj.getLayoutInflater().inflate(2130903380, viewGroup, false);
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
            final /* synthetic */ a eVk;

            public final void onClick(View view) {
                if (this.eVk.edo.contains(Integer.valueOf(i))) {
                    this.eVk.edo.remove(Integer.valueOf(i));
                } else {
                    this.eVk.edo.add(Integer.valueOf(i));
                }
                this.eVk.notifyDataSetChanged();
                this.eVk.eVj.a(this.eVk.edo);
            }
        });
        b ju = ju(i);
        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.dtX, ju.username);
        aVar.dtY.setText(be.aw(ju.beE));
        if (m.dE(ju.username)) {
            aVar.dtZ.setText(e.a(this.eVj, l.D(ju.username, ju.username), aVar.dtZ.getTextSize()));
        } else {
            aVar.dtZ.setText(e.a(this.eVj, l.er(ju.username), aVar.dtZ.getTextSize()));
        }
        if (this.edo.contains(Integer.valueOf(i))) {
            aVar.dua.setChecked(true);
        } else {
            aVar.dua.setChecked(false);
        }
        return view;
    }

    public final void adV() {
        this.edo.clear();
        this.eVj.a(this.edo);
    }
}
