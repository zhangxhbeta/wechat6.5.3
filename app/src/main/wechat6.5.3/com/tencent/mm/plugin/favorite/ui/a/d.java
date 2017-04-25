package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String fPD;
    public List<String> fPE = new LinkedList();
    public SparseArray<SpannableString> fPF = new SparseArray();

    public abstract void sC(String str);

    public /* synthetic */ Object getItem(int i) {
        return hd(i);
    }

    public d(Context context) {
        this.context = context;
    }

    public int getCount() {
        return this.fPE.size();
    }

    private String hd(int i) {
        return (String) this.fPE.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, 2130903619, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(2131756993);
        Object ah = be.ah(hd(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = ah.hashCode();
        CharSequence charSequence = (SpannableString) this.fPF.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(e.a(this.context, ah, textSize));
            textSize = ah.indexOf(this.fPD);
            if (-1 == textSize) {
                v.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[]{ah});
            } else {
                int length = this.fPD.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131690123)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.fPF.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        v.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[]{((TextView) view.findViewById(2131756993)).getText().toString()});
        sC(r0);
    }
}
