package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    protected final HashMap<CharSequence, c> bXL = new HashMap();
    private final Context context;
    protected int hRS = -1;
    protected CharSequence[] oci;
    protected CharSequence[] ocj;
    private final int style;
    protected String value;

    static class a {
        TextView hRT;
        CheckBox hRU;
        RadioButton hRV;

        a() {
        }
    }

    public d(Context context) {
        this.context = context;
        this.style = 1;
    }

    protected final void bDb() {
        boolean z;
        int i = 0;
        if (this.oci == null) {
            this.oci = new CharSequence[0];
        }
        if (this.ocj == null) {
            this.ocj = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.oci.length == this.ocj.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.bXL.clear();
        while (i < this.ocj.length) {
            this.bXL.put(this.ocj[i], new c(this.oci[i], 1048576 + i));
            i++;
        }
    }

    public final int getCount() {
        return this.ocj.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = q.em(this.context).inflate(2130904039, null);
            a aVar = new a();
            aVar.hRT = (TextView) view.findViewById(2131755098);
            aVar.hRU = (CheckBox) view.findViewById(2131758278);
            aVar.hRV = (RadioButton) view.findViewById(c.pfg);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.hRT.setText(this.oci[i]);
        switch (this.style) {
            case 1:
                aVar2.hRU.setVisibility(8);
                aVar2.hRV.setVisibility(0);
                aVar2.hRV.setChecked(this.ocj[i].equals(this.value));
                break;
            case 2:
                aVar2.hRU.setVisibility(0);
                aVar2.hRV.setVisibility(8);
                aVar2.hRU.setChecked(this.ocj[i].equals(this.value));
                break;
            default:
                aVar2.hRU.setVisibility(8);
                aVar2.hRV.setVisibility(8);
                break;
        }
        return view;
    }
}
