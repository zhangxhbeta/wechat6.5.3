package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements e {
    private String bCl = "";
    private OnClickListener gsK = new OnClickListener(this) {
        final /* synthetic */ CheckInLifeUI hHk;

        {
            this.hHk = r1;
        }

        public final void onClick(View view) {
            CheckInLifeUI.a(this.hHk, view, false);
        }
    };
    private String hGV = "";
    private b hHd;
    private b hHe;
    private ArrayList<LatLongData> hHf;
    private b hHg = null;
    private aft hHh;
    private OnClickListener hHi = new OnClickListener(this) {
        final /* synthetic */ CheckInLifeUI hHk;

        {
            this.hHk = r1;
        }

        public final void onClick(View view) {
            CheckInLifeUI.a(this.hHk, view, true);
        }
    };
    private a hHj = new a(this) {
        final /* synthetic */ CheckInLifeUI hHk;

        {
            this.hHk = r1;
        }

        public final void b(Addr addr) {
            v.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[]{addr.toString()});
            if (be.kS(this.hHk.bCl)) {
                this.hHk.bCl = addr.cJi;
                this.hHk.hHd.xi(this.hHk.bCl);
            }
        }
    };

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        v.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof a) {
            LatLongData xg;
            int xh;
            a aVar = (a) view.getTag();
            aft com_tencent_mm_protocal_c_aft = aVar.hGX;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", com_tencent_mm_protocal_c_aft.toByteArray());
                intent.putExtra("location_ctx", com_tencent_mm_protocal_c_aft.mFJ.mQw.lVU);
            } catch (Throwable e) {
                v.a("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                xg = checkInLifeUI.hHe.xg(aVar.hHb);
                xh = checkInLifeUI.hHe.xh(aVar.hHb);
                checkInLifeUI.a(xh, true, aVar.hHb);
            } else {
                xg = checkInLifeUI.hHd.xg(aVar.hHb);
                xh = checkInLifeUI.hHd.xh(aVar.hHb);
                checkInLifeUI.a(xh, false, aVar.hHb);
            }
            intent.putExtra("report_index", xh);
            intent.putExtra("first_start_time", checkInLifeUI.hGH);
            intent.putExtra("lastSuccStamp", checkInLifeUI.hGJ);
            intent.putExtra("firstSuccStamp", checkInLifeUI.hGI);
            intent.putExtra("reqLoadCnt", checkInLifeUI.hGK);
            intent.putExtra("entry_time", checkInLifeUI.gYq);
            intent.putExtra("search_id", checkInLifeUI.bpB);
            if (xg == null) {
                xg = checkInLifeUI.hGC == null ? new LatLongData(-1000.0f, -1000.0f) : new LatLongData(checkInLifeUI.hGC.mjN, checkInLifeUI.hGC.mjM);
            }
            v.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aft.efm)});
            switch (aVar.type) {
                case 0:
                    if (xg != null) {
                        intent.putExtra("get_lat", xg.bhs);
                        intent.putExtra("get_lng", xg.cNt);
                    }
                    if (!be.kS(checkInLifeUI.bCl)) {
                        intent.putExtra("get_city", checkInLifeUI.bCl);
                    }
                    intent.putExtra("get_poi_classify_type", com_tencent_mm_protocal_c_aft.efm);
                    intent.putExtra("get_poi_address", a.aR(com_tencent_mm_protocal_c_aft.mFG));
                    intent.putExtra("get_poi_classify_id", com_tencent_mm_protocal_c_aft.hHb);
                    intent.putExtra("get_poi_name", com_tencent_mm_protocal_c_aft.aXz);
                    break;
                case 1:
                    if (xg != null) {
                        intent.putExtra("get_lat", xg.bhs);
                        intent.putExtra("get_lng", xg.cNt);
                    }
                    intent.putExtra("get_city", com_tencent_mm_protocal_c_aft.aXz);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.hGD);
            intent.putExtra("get_cur_lng", checkInLifeUI.hGE);
            intent.putExtra("get_accuracy", checkInLifeUI.hGG);
            intent.putExtra("get_loctype", checkInLifeUI.hGF);
            intent.putExtra("get_is_mars", checkInLifeUI.cJA);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233973);
        this.hHg = b.FW();
        this.hHh = new aft();
        this.hGV = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.hHh = (aft) this.hHh.az(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.hHh != null) {
                this.hGV = this.hHh.hHb;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.hHh = null;
        }
        if (be.kS(this.hGV)) {
            this.bCl = getIntent().getStringExtra("get_city");
        }
        if (!be.kS(this.bCl)) {
            this.hGV = this.hHd.xi(this.bCl).hHb;
        }
        this.hHd.hGV = this.hGV;
        if (this.hHh != null && !be.kS(this.hHh.hHb)) {
            b bVar = this.hHd;
            aft com_tencent_mm_protocal_c_aft = this.hHh;
            if (com_tencent_mm_protocal_c_aft == null) {
                return;
            }
            if (bVar.hGT == null) {
                bVar.a(com_tencent_mm_protocal_c_aft, 1);
            } else {
                bVar.a(com_tencent_mm_protocal_c_aft, 2);
            }
        }
    }

    public final void aDM() {
        super.aDM();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.hHg != null) {
            this.hHg.a(this.hHj);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130904112;
    }

    public final a aDK() {
        if (this.hHf == null) {
            this.hHf = J(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.hHd != null) {
            return this.hHd;
        }
        this.hHd = new b(this, this.gsK, "viewlist", false);
        if (!(this.hHf == null || this.hHf.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.hHf.get(this.hHf.size() - 1));
            this.hHd.I(arrayList);
            this.hHd.hGp = false;
        }
        return this.hHd;
    }

    public final a aDL() {
        if (this.hHf == null) {
            this.hHf = J(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.hHe != null) {
            return this.hHe;
        }
        this.hHe = new b(this, this.hHi, "searchlist", true);
        this.hHe.I(this.hHf);
        this.hHe.hGp = true;
        return this.hHe;
    }

    public final void j(double d, double d2) {
        v.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        if (this.hHg != null && be.kS(this.bCl)) {
            this.hHg.a(d, d2, this.hHj);
        }
    }

    private static ArrayList<LatLongData> J(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<LatLongData> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (2 == split.length) {
                try {
                    arrayList2.add(new LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e) {
                }
            }
        }
        v.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        return arrayList2;
    }
}
