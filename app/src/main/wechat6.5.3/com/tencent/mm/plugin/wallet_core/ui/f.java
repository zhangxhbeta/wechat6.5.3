package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

public class f extends BaseAdapter {
    private Orders ith = null;
    public ArrayList<Bankcard> kFq;
    private com.tencent.mm.plugin.wallet_core.d.a kGr;
    private int kIy;
    private int kTl = -1;
    public String kTm = "";
    private Context mContext;

    class a {
        public TextView dtB;
        public TextView hWl;
        final /* synthetic */ f kTn;
        public TextView kTo;
        public CheckedTextView kTp;
        public ImageView kTq;

        a(f fVar) {
            this.kTn = fVar;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return sh(i);
    }

    public f(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        this.mContext = context;
        this.kFq = arrayList;
        this.kIy = i;
        this.ith = orders;
        this.kGr = new com.tencent.mm.plugin.wallet_core.d.a();
        this.kGr.b(this.mContext, this.kFq);
    }

    public int getCount() {
        int i = 1;
        if (this.ith != null && this.ith.kPi.equals("CFT")) {
            i = 0;
        }
        return this.kFq != null ? i + this.kFq.size() : i;
    }

    public Bankcard sh(int i) {
        int count = getCount();
        if (this.ith == null || !this.ith.kPi.equals("CFT")) {
            count--;
        }
        if (i < count) {
            return (Bankcard) this.kFq.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        Bankcard sh = sh(i);
        if (sh == null || sh.a(this.kIy, this.ith) == 0) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, 2130904632, null);
            a aVar2 = new a(this);
            aVar2.dtB = (TextView) view.findViewById(2131755226);
            aVar2.hWl = (TextView) view.findViewById(2131756108);
            aVar2.kTp = (CheckedTextView) view.findViewById(2131758278);
            aVar2.kTq = (ImageView) view.findViewById(2131759803);
            aVar2.kTo = (TextView) view.findViewById(2131759878);
            aVar2.hWl.setText("");
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Bankcard sh = sh(i);
        if (sh == null) {
            aVar.kTp.setVisibility(4);
            aVar.hWl.setVisibility(8);
            aVar.dtB.setText(2131236326);
            aVar.kTq.setVisibility(8);
        } else {
            aVar.kTq.setVisibility(0);
            aVar.kTp.setVisibility(0);
            aVar.hWl.setVisibility(0);
            aVar.dtB.setText(sh.field_desc);
            if (sh.bfG()) {
                Bankcard bankcard = k.bga().kFU;
                if (!be.kS(bankcard.kNw)) {
                    aVar.dtB.setText(bankcard.kNw);
                } else if (bankcard.kNv >= 0.0d) {
                    aVar.dtB.setText(this.mContext.getString(com.tencent.mm.model.k.xT() ? 2131236135 : 2131236134, new Object[]{e.l(bankcard.kNv)}));
                } else {
                    aVar.dtB.setText(this.mContext.getText(2131236194));
                }
            }
            aVar.hWl.setVisibility(0);
            switch (sh.a(this.kIy, this.ith)) {
                case 1:
                    aVar.hWl.setText(2131236329);
                    break;
                case 2:
                    aVar.hWl.setText(2131236335);
                    break;
                case 3:
                    aVar.hWl.setText(2131236340);
                    break;
                case 4:
                    aVar.hWl.setText(2131236331);
                    break;
                case 5:
                    aVar.hWl.setText(2131236327);
                    break;
                case 6:
                    aVar.hWl.setText(2131236333);
                    break;
                case 7:
                    aVar.hWl.setText(2131236338);
                    break;
                case 8:
                    aVar.hWl.setText(sh.field_forbidWord);
                    break;
                default:
                    if (!be.kS(sh.field_tips)) {
                        aVar.hWl.setText(sh.field_tips);
                        break;
                    }
                    aVar.hWl.setVisibility(8);
                    break;
            }
            aVar.dtB.setTextColor(this.mContext.getResources().getColor(2131689909));
            if (this.kTm.equalsIgnoreCase(sh.field_bindSerial)) {
                aVar.kTp.setChecked(true);
                aVar.kTp.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.kTp.setChecked(false);
                aVar.kTp.setEnabled(true);
            } else {
                aVar.kTp.setEnabled(false);
                aVar.kTp.setChecked(false);
                aVar.dtB.setTextColor(this.mContext.getResources().getColor(2131689792));
            }
            aVar.kTq.setImageDrawable(null);
            aVar.kTo.setVisibility(8);
            if (sh.bfG()) {
                ImageView imageView = aVar.kTq;
                if (imageView != null) {
                    imageView.setTag(2131755078, null);
                    imageView.setImageResource(2130839490);
                }
                if (!(be.kS(sh.field_forbid_title) || be.kS(sh.field_forbid_url))) {
                    aVar.kTo.setVisibility(0);
                    aVar.kTo.setText(sh.field_forbid_title);
                    aVar.kTo.setTag(sh.field_forbid_url);
                    aVar.kTo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ f kTn;

                        {
                            this.kTn = r1;
                        }

                        public final void onClick(View view) {
                            if (view.getTag() instanceof String) {
                                Intent intent = new Intent();
                                v.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[]{(String) view.getTag()});
                                intent.putExtra("rawUrl", r0);
                                intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                                intent.putExtra("pay_channel", 1);
                                c.b(this.kTn.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.kIv);
                            }
                        }
                    });
                }
            } else {
                this.kGr.a(this.mContext, sh, aVar.kTq);
            }
        }
        return view;
    }

    public final void R(ArrayList<Bankcard> arrayList) {
        if (arrayList == null) {
            this.kFq = new ArrayList();
        } else {
            this.kFq = arrayList;
        }
        if (this.kFq.size() > 0) {
            this.kGr.b(this.mContext, this.kFq);
        }
        notifyDataSetChanged();
    }
}
