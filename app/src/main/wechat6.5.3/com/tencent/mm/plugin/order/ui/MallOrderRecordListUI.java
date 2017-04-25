package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public MMLoadMoreListView eSX;
    public Dialog fUq = null;
    public boolean foB = false;
    public a hPa = null;
    public List<i> hPb = new ArrayList();
    protected String hPc = null;
    public boolean hPd = false;
    protected Map<String, String> hPe = new HashMap();
    public boolean heg = true;
    public int mCount = 0;
    public ac mHandler = null;
    public int vI = 0;

    protected class a extends BaseAdapter {
        final /* synthetic */ MallOrderRecordListUI hPf;

        protected a(MallOrderRecordListUI mallOrderRecordListUI) {
            this.hPf = mallOrderRecordListUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return nY(i);
        }

        public final int getCount() {
            return this.hPf.hPb.size();
        }

        private i nY(int i) {
            return (i) this.hPf.hPb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            Object obj;
            String ce;
            int i2;
            if (view == null) {
                view = View.inflate(this.hPf, 2130903942, null);
                bVar = new b();
                bVar.hPh = (TextView) view.findViewById(2131758093);
                bVar.hPj = (TextView) view.findViewById(2131758095);
                bVar.hPi = (TextView) view.findViewById(2131758094);
                bVar.hPk = (TextView) view.findViewById(2131758097);
                bVar.hPm = view.findViewById(2131758090);
                bVar.hPn = (TextView) view.findViewById(2131758091);
                bVar.hPo = (TextView) view.findViewById(2131758092);
                bVar.hPl = (TextView) view.findViewById(2131758096);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i nY = nY(i);
            if (i == 0) {
                i nY2 = nY(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) nY2.hNS) * 1000);
                obj = 1;
                ce = MallOrderRecordListUI.cd(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i nY3 = nY(i);
                i nY4 = nY(i - 1);
                if (nY3.hNS > 0 && nY4.hNS > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) nY4.hNS) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) nY3.hNS) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        i2 = 1;
                        ce = MallOrderRecordListUI.cd(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                obj = null;
                ce = null;
            }
            if (obj != null) {
                bVar.hPn.setText(new SimpleDateFormat(this.hPf.getString(2131232939, new Object[]{""})).format(new Date(((long) nY(i).hNS) * 1000)));
                if (!(be.kS(ce) || be.kS((String) this.hPf.hPe.get(ce)))) {
                    bVar.hPo.setText((CharSequence) this.hPf.hPe.get(ce));
                }
                bVar.hPm.setVisibility(0);
            } else {
                bVar.hPm.setVisibility(8);
            }
            bVar.hPh.setText(nY.hNR);
            bVar.hPi.setText(nY.hNT);
            i2 = this.hPf.nDR.nEl.getResources().getColor(2131689861);
            if (!be.kS(nY.hOg)) {
                try {
                    i2 = Color.parseColor(nY.hOg);
                } catch (Exception e) {
                    v.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + be.ma(nY.hOg));
                }
            }
            bVar.hPi.setTextColor(i2);
            bVar.hPj.setText(this.hPf.nX(nY.hNS));
            i2 = this.hPf.nDR.nEl.getResources().getColor(2131689863);
            if (!be.kS(nY.hOh)) {
                try {
                    i2 = Color.parseColor(nY.hOh);
                } catch (Exception e2) {
                    v.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + be.ma(nY.hOh));
                }
            }
            if (nY.hNQ != nY.hOi) {
                Object d = e.d(nY.hNQ / 100.0d, nY.hNV);
                CharSequence spannableString = new SpannableString(d);
                spannableString.setSpan(new StrikethroughSpan(), 0, d.length(), 33);
                bVar.hPk.setText(spannableString);
            } else {
                bVar.hPk.setText("");
            }
            bVar.hPl.setTextColor(i2);
            bVar.hPl.setText(e.d(nY.hOi / 100.0d, nY.hNV));
            return view;
        }
    }

    private class b {
        final /* synthetic */ MallOrderRecordListUI hPf;
        TextView hPh;
        TextView hPi;
        TextView hPj;
        TextView hPk;
        TextView hPl;
        View hPm;
        TextView hPn;
        TextView hPo;

        private b(MallOrderRecordListUI mallOrderRecordListUI) {
            this.hPf = mallOrderRecordListUI;
        }
    }

    protected final int getLayoutId() {
        return 2130903941;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ac();
        aFS();
        NI();
        this.vI = 0;
        this.hPc = null;
    }

    public void aFS() {
        gQ(388);
        gQ(389);
    }

    public void aFT() {
        gR(388);
        gR(389);
    }

    public void onResume() {
        super.onResume();
        if (this.hPa != null) {
            this.hPa.notifyDataSetChanged();
        }
    }

    public void cl(String str, String str2) {
        j(new g(str, str2, 1));
    }

    public void aFU() {
        j(new com.tencent.mm.plugin.order.model.e(this.vI, this.hPc));
    }

    protected final void NI() {
        if (com.tencent.mm.wallet_core.a.ae(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.foB = true;
            aFU();
        }
        vD(2131233735);
        this.eSX = (MMLoadMoreListView) findViewById(2131758088);
        this.hPa = new a(this);
        this.eSX.setAdapter(this.hPa);
        this.eSX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderRecordListUI hPf;

            {
                this.hPf = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MallOrderRecordListUI mallOrderRecordListUI = this.hPf;
                if (i < mallOrderRecordListUI.hPb.size()) {
                    i iVar = (i) mallOrderRecordListUI.hPb.get(i);
                    if (iVar != null) {
                        Bundle bundle = mallOrderRecordListUI.uA;
                        bundle.putString("key_trans_id", iVar.hNP);
                        bundle.putInt("key_pay_type", iVar.hNX);
                        bundle.putString("bill_id", iVar.hOj);
                        com.tencent.mm.wallet_core.a.k(mallOrderRecordListUI, bundle);
                    }
                }
                e.yD(26);
            }
        });
        this.eSX.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ MallOrderRecordListUI hPf;

            {
                this.hPf = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (i < this.hPf.hPb.size()) {
                    com.tencent.mm.ui.base.g.a(this.hPf, this.hPf.getResources().getString(2131236272), null, this.hPf.getResources().getString(2131231020), new c(this) {
                        final /* synthetic */ AnonymousClass2 hPg;

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    i iVar = (i) this.hPg.hPf.hPb.get(i);
                                    if (iVar != null) {
                                        this.hPg.hPf.cl(iVar.hNP, iVar.hOj);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.eSX.nWA = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ MallOrderRecordListUI hPf;

            {
                this.hPf = r1;
            }

            public final void adB() {
                if (!this.hPf.foB) {
                    this.hPf.foB = true;
                    MallOrderRecordListUI mallOrderRecordListUI = this.hPf;
                    mallOrderRecordListUI.vI += 10;
                    this.hPf.aFU();
                }
            }
        };
        final qk qkVar = new qk();
        qkVar.brG.brI = "6";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ MallOrderRecordListUI hPf;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.WalletOrderListUI", "no bulletin data");
                } else {
                    e.a((TextView) this.hPf.findViewById(2131756367), qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
        com.tencent.mm.plugin.order.a.b.aFF().Yj();
        this.hPa.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.aFF();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.aFI().aFN());
        gVar.h(11036, objArr);
    }

    public final void aT(List<i> list) {
        if (list != null && list.size() != 0) {
            if (this.hPb == null) {
                this.hPb = new ArrayList();
            }
            for (int i = 0; i < list.size(); i++) {
                i iVar = (i) list.get(i);
                if (!xE(iVar.hNP)) {
                    this.hPb.add(iVar);
                }
            }
        }
    }

    private boolean xE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.hPb.size(); i++) {
            i iVar = (i) this.hPb.get(i);
            if (iVar != null && str.equals(iVar.hNP)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        aFT();
        super.onDestroy();
    }

    public String nX(int i) {
        return e.yC(i);
    }

    public final void aU(List<d> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                if (dVar != null) {
                    this.hPe.put(cd(dVar.year, dVar.month), dVar.hNJ);
                }
            }
        }
    }

    private static String cd(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.order.model.e) {
            if (this.fUq != null) {
                this.fUq.dismiss();
                this.fUq = null;
            }
            com.tencent.mm.plugin.order.model.e eVar = (com.tencent.mm.plugin.order.model.e) kVar;
            this.hPc = eVar.hNM;
            aT(eVar.hNK);
            aU(eVar.hNL);
            this.mCount = this.hPb.size();
            this.heg = eVar.haG > this.mCount;
            this.hPa.notifyDataSetChanged();
            v.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            v.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.haG);
            v.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.heg);
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI hPf;

                {
                    this.hPf = r1;
                }

                public final void run() {
                    if (this.hPf.heg) {
                        v.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!this.hPf.hPd) {
                            this.hPf.eSX.bCi();
                            this.hPf.eSX.setAdapter(this.hPf.hPa);
                            this.hPf.hPd = true;
                        }
                    } else {
                        v.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        this.hPf.eSX.bCj();
                    }
                    this.hPf.hPa.notifyDataSetChanged();
                }
            });
            this.foB = false;
        } else if (kVar instanceof g) {
            if (this.fUq != null) {
                this.fUq.dismiss();
                this.fUq = null;
            }
            g gVar = (g) kVar;
            if (gVar.aFO() == 2) {
                if (this.hPb != null) {
                    this.hPb.clear();
                }
                this.mCount = 0;
                this.heg = false;
                this.eSX.bCj();
            } else {
                String aFP = gVar.aFP();
                v.d("MicroMsg.WalletOrderListUI", "delete transId:" + aFP);
                if (!be.kS(aFP)) {
                    for (i iVar : this.hPb) {
                        if (aFP.equals(iVar.hNP)) {
                            this.hPb.remove(iVar);
                            this.mCount = this.hPb.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ MallOrderRecordListUI hPf;

                {
                    this.hPf = r1;
                }

                public final void run() {
                    this.hPf.hPa.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.hPb.size() != 0) {
            iU(true);
            findViewById(2131758089).setVisibility(8);
        } else {
            iU(false);
            findViewById(2131758089).setVisibility(0);
        }
        return true;
    }
}
