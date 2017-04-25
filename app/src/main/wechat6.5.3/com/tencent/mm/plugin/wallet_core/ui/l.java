package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.s;
import java.util.ArrayList;

public final class l extends BaseAdapter {
    s kVY = null;
    private Context mContext;
    ArrayList<s> mData = null;

    private class a {
        TextView dID;
        ImageView kVZ;
        final /* synthetic */ l kWa;

        private a(l lVar) {
            this.kWa = lVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return sv(i);
    }

    public l(Context context, ArrayList<s> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    public final s sv(int i) {
        if (this.mData == null || getCount() <= i) {
            return null;
        }
        return (s) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, 2130904688, null);
            a aVar2 = new a();
            aVar2.dID = (TextView) view.findViewById(2131755226);
            aVar2.kVZ = (ImageView) view.findViewById(2131760021);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        s sv = sv(i);
        if (sv != null) {
            aVar.dID.setText(sv.field_wallet_name);
            if (sv.field_wallet_selected == 1) {
                this.kVY = sv;
                aVar.kVZ.setImageResource(2131165878);
            } else {
                aVar.kVZ.setImageResource(2131165881);
            }
        }
        return view;
    }
}
