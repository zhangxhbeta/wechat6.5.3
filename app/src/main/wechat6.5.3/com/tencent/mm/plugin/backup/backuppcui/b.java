package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.plugin.backup.backupmodel.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import java.util.HashSet;
import java.util.LinkedList;

public final class b extends BaseAdapter {
    static boolean edp = false;
    BackupPcChooseUI edn;
    HashSet<Integer> edo = new HashSet();

    class a {
        ImageView dtX;
        TextView dtY;
        CheckBox dua;
        final /* synthetic */ b edq;
        RelativeLayout edr;

        a(b bVar) {
            this.edq = bVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hd(i);
    }

    public b(BackupPcChooseUI backupPcChooseUI) {
        this.edn = backupPcChooseUI;
    }

    public final int getCount() {
        LinkedList Tw = c.Tw();
        if (Tw != null) {
            return Tw.size();
        }
        return 0;
    }

    private static String hd(int i) {
        return (String) c.Tw().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.edn.getLayoutInflater().inflate(2130903147, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.dtX = (ImageView) view.findViewById(2131755508);
            aVar2.dtY = (TextView) view.findViewById(2131755456);
            aVar2.dua = (CheckBox) view.findViewById(2131755510);
            aVar2.edr = (RelativeLayout) view.findViewById(2131755509);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.edr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b edq;

            public final void onClick(View view) {
                if (this.edq.edo.contains(Integer.valueOf(i))) {
                    this.edq.edo.remove(Integer.valueOf(i));
                } else {
                    this.edq.edo.add(Integer.valueOf(i));
                }
                this.edq.notifyDataSetChanged();
                this.edq.edn.a(this.edq.edo);
            }
        });
        String hd = hd(i);
        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.dtX, hd);
        if (m.dE(hd)) {
            aVar.dtY.setText(e.a(this.edn, l.D(hd, hd), aVar.dtY.getTextSize()));
        } else {
            aVar.dtY.setText(e.a(this.edn, l.er(hd), aVar.dtY.getTextSize()));
        }
        if (this.edo.contains(Integer.valueOf(i))) {
            aVar.dua.setChecked(true);
        } else {
            aVar.dua.setChecked(false);
        }
        return view;
    }

    public static boolean ET() {
        return edp;
    }
}
