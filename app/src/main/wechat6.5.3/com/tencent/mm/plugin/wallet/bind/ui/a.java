package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import java.util.ArrayList;

public class a extends BaseAdapter {
    private ArrayList<Bankcard> kGp;
    private int kGq;
    com.tencent.mm.plugin.wallet_core.d.a kGr;
    private final Context mContext;
    private int mCount = 0;

    class a {
        public TextView kGA = null;
        public ImageView kGB = null;
        public ImageView kGC = null;
        public ImageView kGD = null;
        final /* synthetic */ a kGE;
        public TextView kGs = null;
        public TextView kGt = null;
        public TextView kGu = null;
        public RelativeLayout kGv = null;
        public ImageView kGw = null;
        public ImageView kGx = null;
        public TextView kGy = null;
        public TextView kGz = null;

        a(a aVar) {
            this.kGE = aVar;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return sh(i);
    }

    public a(Context context, ArrayList<Bankcard> arrayList) {
        this.mContext = context;
        this.kGp = arrayList;
        this.kGq = 0;
        this.kGr = new com.tencent.mm.plugin.wallet_core.d.a();
        this.kGr.b(this.mContext, this.kGp);
    }

    public final void P(ArrayList<Bankcard> arrayList) {
        this.kGp = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.kGr.b(this.mContext, this.kGp);
        }
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard sh(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return (Bankcard) this.kGp.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        Bankcard sh = sh(i);
        if (sh == null) {
            return 4;
        }
        if (sh.field_bankcardState == 9) {
            if (sh.field_wxcreditState == 0) {
                return 2;
            }
            return 3;
        } else if (sh.bfF() && "CITIC_CREDIT".equals(sh.field_bankcardType)) {
            return 5;
        } else {
            if (!sh.bfI() || k.xT()) {
                return 1;
            }
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 6;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Bankcard sh = sh(i);
        a aVar;
        a aVar2;
        switch (getItemViewType(i)) {
            case 0:
                return b.a(this.mContext, view, sh, 2130904613, this.kGr);
            case 1:
                return b.a(this.mContext, view, sh, 2130904619, this.kGr);
            case 2:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, 2130904622, null);
                    aVar = new a(this);
                    aVar.kGx = (ImageView) view.findViewById(2131759803);
                    aVar.kGt = (TextView) view.findViewById(2131759804);
                    aVar.kGA = (TextView) view.findViewById(2131759843);
                    aVar.kGB = (ImageView) view.findViewById(2131759807);
                    aVar.kGC = (ImageView) view.findViewById(2131759808);
                    aVar.kGD = (ImageView) view.findViewById(2131759809);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                aVar2.kGt.setText(this.mContext.getString(2131236200, new Object[]{sh.field_bankName}));
                if (b.a(sh)) {
                    aVar2.kGA.setVisibility(0);
                    return view;
                }
                aVar2.kGA.setVisibility(8);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, 2130904625, null);
                    aVar = new a(this);
                    aVar.kGx = (ImageView) view.findViewById(2131759803);
                    aVar.kGt = (TextView) view.findViewById(2131759804);
                    aVar.kGy = (TextView) view.findViewById(2131759810);
                    aVar.kGB = (ImageView) view.findViewById(2131759807);
                    aVar.kGC = (ImageView) view.findViewById(2131759808);
                    aVar.kGD = (ImageView) view.findViewById(2131759809);
                    view.setTag(aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = (a) view.getTag();
                }
                switch (sh.field_wxcreditState) {
                    case 1:
                        aVar2.kGy.setBackgroundResource(2130839506);
                        aVar2.kGy.setVisibility(0);
                        break;
                    case 3:
                        aVar2.kGy.setBackgroundResource(2130839498);
                        aVar2.kGy.setVisibility(0);
                        break;
                    default:
                        aVar2.kGy.setVisibility(8);
                        break;
                }
                aVar2.kGt.setText(sh.field_bankName);
                this.kGr.a(this.mContext, sh, aVar2.kGx);
                return view;
            case 4:
                return View.inflate(this.mContext, 2130904614, null);
            case 5:
                return b.a(this.mContext, view, sh, 2130904623, this.kGr);
            default:
                return view;
        }
    }
}
