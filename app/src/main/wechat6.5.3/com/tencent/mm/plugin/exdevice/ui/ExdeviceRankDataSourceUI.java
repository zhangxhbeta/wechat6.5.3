package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI extends MMActivity implements e {
    private ListView Eq;
    private b fDF;

    private static class a {
        bdb fDI;
        com.tencent.mm.plugin.exdevice.h.b fDJ;
        String mac;

        private a() {
        }
    }

    private static final class b extends BaseAdapter {
        List<a> fDK = new LinkedList();
        private c fzb;

        private static class a {
            TextView eVA;
            ImageView eZn;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kA(i);
        }

        public b() {
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPH = 2130838188;
            this.fzb = aVar.GU();
        }

        public final synchronized a sB(String str) {
            a aVar;
            if (!be.kS(str)) {
                for (a aVar2 : this.fDK) {
                    if (str.equals(aVar2.mac)) {
                        break;
                    }
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final synchronized a bw(String str, String str2) {
            a aVar;
            for (a aVar2 : this.fDK) {
                if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.fDI)) {
                    break;
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final int getCount() {
            return this.fDK.size();
        }

        private a kA(int i) {
            return (a) this.fDK.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a kA = kA(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), 2130903567, null);
                aVar2.eVA = (TextView) view.findViewById(2131756776);
                aVar2.eZn = (ImageView) view.findViewById(2131756775);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            v.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), ExdeviceRankDataSourceUI.a(kA), kA.mac});
            aVar.eVA.setText(r1);
            n.GL().a(kA.fDI.gnp, aVar.eZn, this.fzb);
            return view;
        }
    }

    static /* synthetic */ a a(bdb com_tencent_mm_protocal_c_bdb) {
        a aVar = new a();
        aVar.fDJ = null;
        if (com_tencent_mm_protocal_c_bdb == null) {
            aVar.fDI = null;
        } else {
            aVar.fDI = com_tencent_mm_protocal_c_bdb;
        }
        return aVar;
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar == null || aVar.fDI == null) {
            return "";
        }
        if (!be.kS(aVar.fDI.eeA)) {
            return aVar.fDI.eeA;
        }
        com.tencent.mm.plugin.exdevice.h.b bVar = aVar.fDJ;
        String str = null;
        if (bVar == null) {
            return "";
        }
        if (!be.kS(bVar.bLc)) {
            str = bVar.bLc;
        } else if (!be.kS(bVar.bLd)) {
            str = bVar.bLd;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.br(bVar.field_mac);
        } else if (!be.kS(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return be.ma(str);
    }

    static /* synthetic */ boolean a(String str, String str2, bdb com_tencent_mm_protocal_c_bdb) {
        return (com_tencent_mm_protocal_c_bdb == null || str == null || str2 == null || !str.equals(com_tencent_mm_protocal_c_bdb.mnR) || !str2.equals(com_tencent_mm_protocal_c_bdb.meq)) ? false : true;
    }

    protected final int getLayoutId() {
        return 2130903568;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI fDG;

            {
                this.fDG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fDG.finish();
                return true;
            }
        });
        vD(2131232138);
        ak.vy().a(1267, this);
        NI();
        ak.vy().a(new q(), 0);
    }

    protected final void NI() {
        this.Eq = (ListView) findViewById(2131755705);
        View inflate = View.inflate(this, 2130903570, null);
        View inflate2 = View.inflate(this, 2130903569, null);
        this.Eq.addHeaderView(inflate, null, false);
        this.Eq.addFooterView(inflate2, null, false);
        this.fDF = new b();
        this.Eq.setAdapter(this.fDF);
        ((ScrollView) findViewById(2131756513)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI fDG;

            {
                this.fDG = r1;
            }

            public final void onClick(View view) {
                this.fDG.startActivityForResult(new Intent(this.fDG.nDR.nEl, ExdeviceAddDataSourceUI.class), 1);
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1267, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                v.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                return;
            }
            String br = com.tencent.mm.plugin.exdevice.j.b.br(longExtra);
            if (br == null) {
                v.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", new Object[]{br});
            } else if (this.fDF.sB(br) != null) {
                v.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
            } else {
                com.tencent.mm.plugin.exdevice.h.b bq = ac.ajq().bq(longExtra);
                if (bq == null) {
                    v.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", new Object[]{Long.valueOf(longExtra)});
                } else if (this.fDF.bw(bq.field_deviceID, bq.field_deviceType) != null) {
                    v.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                } else {
                    ak.vy().a(1267, this);
                    ak.vy().a(new q(), 0);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            v.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
        } else if (kVar instanceof q) {
            ak.vy().b(1267, this);
            if (i == 0 && i2 == 0) {
                int size;
                zh zhVar = (zh) ((q) kVar).cif.czl.czs;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                if (zhVar.mwQ != null) {
                    size = zhVar.mwQ.size();
                } else {
                    size = 0;
                }
                objArr[0] = Integer.valueOf(size);
                v.d(str2, str3, objArr);
                final List list = zhVar.mwQ;
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceRankDataSourceUI fDG;

                    public final void run() {
                        b b = this.fDG.fDF;
                        List<bdb> list = list;
                        b.fDK.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (bdb com_tencent_mm_protocal_c_bdb : list) {
                                if (com_tencent_mm_protocal_c_bdb != null) {
                                    b.fDK.add(ExdeviceRankDataSourceUI.a(com_tencent_mm_protocal_c_bdb));
                                }
                            }
                        }
                        this.fDG.fDF.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}
