package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class i extends com.tencent.mm.ui.base.i {
    private LayoutInflater CE;
    private View eEX;
    private a kJf;
    private MaxListView kTD = ((MaxListView) this.eEX.findViewById(2131759900));
    private TextView kTE = ((TextView) this.eEX.findViewById(2131759899));
    private a kTF = new a(this);
    private b kTG;

    class a extends BaseAdapter {
        final /* synthetic */ i kTH;
        int kTI = -1;
        List<l> kTJ = new LinkedList();
        e kTK = null;
        j<String> kTL = new j<String>(this) {
            final /* synthetic */ a kTM;

            {
                this.kTM = r1;
            }

            public final String a(Vector<com.tencent.mm.plugin.wallet_core.model.j.b> vector, int i) {
                if (vector == null) {
                    v.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    return "";
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    int i3 = ((com.tencent.mm.plugin.wallet_core.model.j.b) vector.get(i2)).kOR;
                    if (i2 == i || i3 == com.tencent.mm.plugin.wallet_core.model.j.a.kON) {
                        stringBuilder.append(((String) ((com.tencent.mm.plugin.wallet_core.model.j.b) vector.get(i2)).kOQ) + "-");
                    }
                }
                if (stringBuilder.length() == 0) {
                    return "0";
                }
                if (stringBuilder.length() > 1) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString();
            }
        };

        public a(i iVar) {
            this.kTH = iVar;
        }

        public final int getCount() {
            return this.kTJ.size();
        }

        public final Object getItem(int i) {
            return this.kTJ.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            com.tencent.mm.plugin.wallet.a.b bVar;
            if (view == null) {
                view = this.kTH.CE.inflate(2130904636, viewGroup, false);
                c cVar2 = new c();
                cVar2.kTN = view.findViewById(2131759882);
                cVar2.eXB = (TextView) view.findViewById(2131759884);
                cVar2.kTP = (TextView) view.findViewById(2131759885);
                cVar2.gNg = (TextView) view.findViewById(2131759886);
                cVar2.kTQ = (CheckBox) view.findViewById(2131759887);
                cVar2.kTO = (ImageView) view.findViewById(2131759883);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            l lVar = (l) getItem(i);
            if (i != this.kTI || this.kTI <= 0) {
                cVar.kTN.setVisibility(8);
                cVar.kTO.setVisibility(0);
            } else {
                cVar.kTN.setVisibility(0);
                cVar.kTO.setVisibility(8);
            }
            if (be.kS(lVar.kIg)) {
                cVar.eXB.setVisibility(8);
            } else {
                cVar.eXB.setText(lVar.kIg);
                cVar.eXB.setVisibility(0);
            }
            String str = lVar.kHv;
            if (!(this.kTK == null || this.kTK.kHQ == null)) {
                List list = this.kTK.kHQ;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str.equals(((com.tencent.mm.plugin.wallet.a.b) list.get(i2)).kHv)) {
                        bVar = (com.tencent.mm.plugin.wallet.a.b) list.get(i2);
                        break;
                    }
                }
            }
            bVar = null;
            String str2 = lVar.kHw;
            String str3 = lVar.kHx;
            if (bVar != null) {
                CharSequence charSequence = bVar.kHw;
                CharSequence charSequence2 = bVar.kHx;
            } else {
                Object obj = str3;
                Object obj2 = str2;
            }
            if (be.kS(charSequence)) {
                cVar.kTP.setVisibility(8);
            } else {
                cVar.kTP.setText(charSequence);
                cVar.kTP.setVisibility(0);
            }
            if (be.kS(charSequence2)) {
                cVar.gNg.setVisibility(8);
            } else {
                cVar.gNg.setText(charSequence2);
                cVar.gNg.setVisibility(0);
            }
            int i3 = ((com.tencent.mm.plugin.wallet_core.model.j.b) this.kTL.kOJ.get(i)).kOR;
            if (i3 == com.tencent.mm.plugin.wallet_core.model.j.a.kOM) {
                cVar.kTQ.setChecked(false);
                cVar.kTQ.setEnabled(false);
            } else {
                cVar.kTQ.setEnabled(true);
                if (i3 == com.tencent.mm.plugin.wallet_core.model.j.a.kON) {
                    cVar.kTQ.setChecked(true);
                } else {
                    cVar.kTQ.setChecked(false);
                }
            }
            return view;
        }
    }

    public interface b {
        void a(FavorPayInfo favorPayInfo);
    }

    static final class c {
        TextView eXB;
        TextView gNg;
        View kTN;
        ImageView kTO;
        TextView kTP;
        CheckBox kTQ;

        c() {
        }
    }

    private i(Context context) {
        super(context, 2131559267);
        this.CE = LayoutInflater.from(context);
        this.eEX = LayoutInflater.from(context).inflate(2130904639, null);
        this.kTD.setAdapter(this.kTF);
        this.eEX.findViewById(2131759901).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ i kTH;

            {
                this.kTH = r1;
            }

            public final void onClick(View view) {
                this.kTH.bgZ();
                this.kTH.dismiss();
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.eEX);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    public static i a(Context context, Orders orders, String str, b bVar) {
        i iVar = new i(context);
        iVar.setOnCancelListener(null);
        iVar.setCancelable(true);
        iVar.kJf = b.kRN.a(orders);
        if (iVar.kJf == null) {
            v.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            iVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = iVar.kTF;
            com.tencent.mm.plugin.wallet.a.c cVar = aVar.kTH.kJf.kRH;
            String Dr = aVar.kTH.kJf.Dr(str);
            aVar.kTJ = aVar.kTH.kJf.bgU();
            aVar.kTK = aVar.kTH.kJf.Dn(Dr);
            aVar.kTI = -1;
            for (i = 0; i < aVar.kTJ.size(); i++) {
                if ((((l) aVar.kTJ.get(i)).kIk != 0 ? 1 : null) != null) {
                    aVar.kTI = i;
                    break;
                }
            }
            List linkedList = new LinkedList();
            if (aVar.kTJ != null) {
                for (i = 0; i < aVar.kTJ.size(); i++) {
                    linkedList.add(((l) aVar.kTJ.get(i)).kHv);
                }
                List linkedList2 = new LinkedList();
                if (!(cVar == null || cVar.kHC == null)) {
                    for (i = 0; i < cVar.kHC.size(); i++) {
                        String str2 = ((l) cVar.kHC.get(i)).kHv;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                    }
                }
                List linkedList3 = new LinkedList();
                if (cVar == null || cVar.kHD == null || cVar.kHD.kHM == null) {
                    v.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    List list = cVar.kHD.kHM;
                    for (i = 0; i < list.size(); i++) {
                        String str3 = ((e) list.get(i)).kHO;
                        for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                            if (str3.contains((CharSequence) linkedList2.get(i2))) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                    }
                    List linkedList4 = new LinkedList();
                    if (!(be.kS(Dr) || Dr.equals("0"))) {
                        String[] split = Dr.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList4.add(add);
                            }
                        } else {
                            v.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.kTL.c(linkedList, linkedList4, linkedList3);
                    obj = 1;
                }
            } else {
                v.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                v.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                iVar.dismiss();
            } else {
                iVar.kTE.setText(2131236177);
                iVar.kTD.setOnItemClickListener(new OnItemClickListener(iVar) {
                    final /* synthetic */ i kTH;

                    {
                        this.kTH = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        a b = this.kTH.kTF;
                        j jVar = b.kTL;
                        if (i < jVar.kOJ.size()) {
                            int i2 = ((com.tencent.mm.plugin.wallet_core.model.j.b) jVar.kOJ.get(i)).kOR;
                            int i3 = com.tencent.mm.plugin.wallet_core.model.j.a.kON;
                            switch (com.tencent.mm.plugin.wallet_core.model.j.AnonymousClass1.kOL[i2 - 1]) {
                                case 1:
                                    jVar.cJ(i, com.tencent.mm.plugin.wallet_core.model.j.a.kON);
                                    break;
                                case 2:
                                    jVar.cJ(i, com.tencent.mm.plugin.wallet_core.model.j.a.kOO);
                                    break;
                            }
                            jVar.bfU();
                        }
                        b.notifyDataSetChanged();
                    }
                });
            }
        }
        iVar.kTG = bVar;
        iVar.show();
        g.a(context, iVar);
        return iVar;
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    private void bgZ() {
        v.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.kTF != null) {
            j jVar = this.kTF.kTL;
            this.kTG.a(this.kJf.Dq(jVar.a(jVar.kOJ, -1)));
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bgZ();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
