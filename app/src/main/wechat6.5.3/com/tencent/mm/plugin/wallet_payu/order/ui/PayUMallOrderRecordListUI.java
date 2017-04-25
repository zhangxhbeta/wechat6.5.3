package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    protected final void aFS() {
        gQ(1519);
        gQ(1544);
    }

    protected final void aFT() {
        gR(1519);
        gR(1544);
    }

    protected final void cl(String str, String str2) {
        j(new b(str));
    }

    protected final void aFU() {
        j(new a(this.vI));
    }

    protected final String nX(int i) {
        return e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Iterator it;
        if (kVar instanceof a) {
            if (this.fUq != null) {
                this.fUq.dismiss();
                this.fUq = null;
            }
            a aVar = (a) kVar;
            LinkedList linkedList = ((amf) aVar.cif.czl.czs).mNc;
            List linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                amp com_tencent_mm_protocal_c_amp = (amp) it.next();
                i iVar = new i();
                iVar.hNZ = com_tencent_mm_protocal_c_amp.hNZ;
                iVar.hOa = com_tencent_mm_protocal_c_amp.hOa;
                iVar.hOb = com_tencent_mm_protocal_c_amp.hOb;
                iVar.hNS = com_tencent_mm_protocal_c_amp.hNS;
                iVar.hNV = com_tencent_mm_protocal_c_amp.hNV;
                iVar.hNR = com_tencent_mm_protocal_c_amp.hNR;
                iVar.hNY = "0";
                iVar.hNU = com_tencent_mm_protocal_c_amp.hNU;
                iVar.hNX = com_tencent_mm_protocal_c_amp.hNX;
                iVar.hOe = 1;
                iVar.hOd = com_tencent_mm_protocal_c_amp.hOd;
                iVar.hOc = com_tencent_mm_protocal_c_amp.hOc;
                iVar.hNW = com_tencent_mm_protocal_c_amp.hNW;
                iVar.hNQ = (double) com_tencent_mm_protocal_c_amp.mMU;
                iVar.hNT = com_tencent_mm_protocal_c_amp.hNT;
                iVar.hNP = com_tencent_mm_protocal_c_amp.hNP;
                linkedList2.add(iVar);
            }
            aT(linkedList2);
            aU(null);
            this.mCount = this.hPb.size();
            this.heg = aVar.bhE() > this.mCount;
            this.hPa.notifyDataSetChanged();
            v.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            v.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.bhE());
            v.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.heg);
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ PayUMallOrderRecordListUI kZD;

                {
                    this.kZD = r1;
                }

                public final void run() {
                    if (this.kZD.heg) {
                        v.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                        if (!this.kZD.hPd) {
                            this.kZD.eSX.bCi();
                            this.kZD.eSX.setAdapter(this.kZD.hPa);
                            this.kZD.hPd = true;
                        }
                    } else {
                        v.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                        this.kZD.eSX.bCj();
                    }
                    this.kZD.hPa.notifyDataSetChanged();
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
                v.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + aFP);
                if (!be.kS(aFP)) {
                    for (i iVar2 : this.hPb) {
                        if (aFP.equals(iVar2.hNP)) {
                            this.hPb.remove(iVar2);
                            this.mCount = this.hPb.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ PayUMallOrderRecordListUI kZD;

                {
                    this.kZD = r1;
                }

                public final void run() {
                    this.kZD.hPa.notifyDataSetChanged();
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
