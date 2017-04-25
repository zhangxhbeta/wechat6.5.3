package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.n.d;

public final class e {
    ListView gKa;
    h gKb;
    View gKc;
    IPCallAddressUI gKd;
    boolean gKe = false;
    TextView gKf = null;
    TextView gKg = null;
    ImageView gKh = null;

    class AnonymousClass8 implements d {
        final /* synthetic */ e gKi;
        final /* synthetic */ k gKj;
        final /* synthetic */ int gKk;

        AnonymousClass8(e eVar, k kVar, int i) {
            this.gKi = eVar;
            this.gKj = kVar;
            this.gKk = i;
        }

        public final void c(MenuItem menuItem, int i) {
            if (i == 0) {
                e eVar = this.gKi;
                k kVar = this.gKj;
                int i2 = this.gKk;
                l aus;
                if (kVar.field_addressId > 0) {
                    aus = i.aus();
                    if (kVar.field_addressId > 0 && aus.cie.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                        v.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[]{Integer.valueOf(aus.cie.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4)});
                    }
                } else {
                    aus = i.aus();
                    if (!be.kS(kVar.field_phonenumber) && aus.cie.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                        v.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[]{Integer.valueOf(aus.cie.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1});
                    }
                }
                h hVar = eVar.gKb;
                hVar.gMQ.remove(i2);
                hVar.notifyDataSetChanged();
                if (eVar.gKb.getCount() > 0) {
                    eVar.gKc.setVisibility(8);
                } else {
                    eVar.gKc.setVisibility(0);
                }
            }
        }
    }

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.gKa = listView;
        this.gKd = iPCallAddressUI;
        this.gKc = view;
    }

    public final void avd() {
        ad.o(new Runnable(this) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final void run() {
                ak.yW();
                if (((Boolean) c.vf().get(a.nqx, Boolean.valueOf(false))).booleanValue()) {
                    this.gKi.gKh.setVisibility(0);
                } else {
                    this.gKi.gKh.setVisibility(8);
                }
                ak.yW();
                CharSequence charSequence = (String) c.vf().get(a.nqz, "");
                ak.yW();
                String str = (String) c.vf().get(a.nqA, "");
                if (be.kS(charSequence)) {
                    Object obj = str;
                }
                aau avE;
                if (be.kS(charSequence)) {
                    avE = com.tencent.mm.plugin.ipcall.b.c.avE();
                    if (avE != null) {
                        if (be.kS(avE.mCm)) {
                            this.gKi.gKf.setText("$");
                        } else {
                            this.gKi.gKf.setText(avE.mCm);
                        }
                        this.gKi.gKg.setText(this.gKi.gKd.getString(2131233334) + avE.mCg);
                        return;
                    }
                    this.gKi.gKg.setText("");
                    return;
                }
                this.gKi.gKg.setText(charSequence);
                avE = com.tencent.mm.plugin.ipcall.b.c.avE();
                if (avE == null) {
                    return;
                }
                if (be.kS(avE.mCm)) {
                    this.gKi.gKf.setText("$");
                } else {
                    this.gKi.gKf.setText(avE.mCm);
                }
            }
        });
    }
}
