package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    String gQQ;
    ArrayList<String> gQR = new ArrayList();
    SparseArray<SpannableString> gQS = new SparseArray();
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return hd(i);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.gQR == null ? 0 : this.gQR.size();
    }

    public final String hd(int i) {
        return (this.gQR == null || i >= getCount()) ? null : (String) this.gQR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130903418, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.gRs;
        Object ah = be.ah(hd(i), "");
        int textSize = (int) cVar.gRs.getTextSize();
        int hashCode = ah.hashCode();
        CharSequence charSequence = (SpannableString) this.gQS.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(e.a(this.mContext, ah, textSize));
            textSize = ah.indexOf(this.gQQ);
            if (textSize == -1) {
                v.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[]{ah});
            } else {
                int length = this.gQQ.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131690123)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.gQS.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        return view;
    }
}
