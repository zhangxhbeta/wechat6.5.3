package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends RelativeLayout {
    float aJp = 0.0f;
    private String bCl;
    private boolean cJA = true;
    private float cJq = -1000.0f;
    private float cJr = -1000.0f;
    private View dtW;
    private com.tencent.mm.modelgeo.b.a gRR = new com.tencent.mm.modelgeo.b.a(this) {
        final /* synthetic */ LocationWidget jGZ;

        {
            this.jGZ = r1;
        }

        public final void b(Addr addr) {
            v.i("MicroMsg.LocationWidget", "get info %s", new Object[]{addr.toString()});
            if (this.jGZ.jGX) {
                this.jGZ.aVK();
                if (be.kS(this.jGZ.bCl)) {
                    this.jGZ.bCl = addr.cJi;
                    this.jGZ.aVK();
                }
            }
        }
    };
    private String gUr;
    private com.tencent.mm.modelgeo.b gXm;
    private Activity gZX;
    float hGE = 0.0f;
    private com.tencent.mm.modelgeo.a.a hGR = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ LocationWidget jGZ;

        {
            this.jGZ = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            v.d("MicroMsg.LocationWidget", "get location %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            e.JZ().a(2003, i != 0, this.jGZ.hGy == null ? false : this.jGZ.hGy.cJA, f, f2, (int) d2);
            n.a(2003, f, f2, 0);
            if (!this.jGZ.jGX) {
                return false;
            }
            if (this.jGZ.cJq == -1000.0f || this.jGZ.cJr == -1000.0f) {
                this.jGZ.cJq = f2;
                this.jGZ.cJr = f;
            }
            return false;
        }
    };
    private c hGy = c.FY();
    private aft hHh = null;
    private ImageView jEe;
    private TextView jFb;
    private TextView jGP;
    private byte[] jGQ;
    private String jGR;
    private String jGS;
    private int jGT = 0;
    float jGU = 0.0f;
    int jGV = -1;
    a jGW = null;
    private boolean jGX = false;
    private b jGY = null;

    public interface a {
        ArrayList<com.tencent.mm.compatible.util.Exif.a> aVP();

        boolean aVQ();
    }

    class b {
        String bpB = "";
        int gYq = 0;
        long hGH = -1;
        long hGI = -1;
        long hGJ = -1;
        int hGK = 0;
        int index;
        final /* synthetic */ LocationWidget jGZ;

        b(LocationWidget locationWidget) {
            this.jGZ = locationWidget;
        }
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e((MMActivity) context);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e((MMActivity) context);
    }

    private void e(MMActivity mMActivity) {
        this.gZX = mMActivity;
        this.dtW = View.inflate(mMActivity, getLayoutResource(), this);
        this.jGP = (TextView) this.dtW.findViewById(2131757716);
        this.jFb = (TextView) this.dtW.findViewById(2131757718);
        this.jEe = (ImageView) this.dtW.findViewById(2131757717);
        this.gXm = com.tencent.mm.modelgeo.b.FW();
        this.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationWidget jGZ;

            {
                this.jGZ = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.jGZ.gZX, "android.permission.ACCESS_COARSE_LOCATION", 64, "", ""))});
                if (com.tencent.mm.pluginsdk.i.a.a(this.jGZ.gZX, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    this.jGZ.aVJ();
                }
            }
        });
        this.jGS = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!be.kS(this.jGS)) {
            this.cJq = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.cJr = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.gUr = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.jGR = mMActivity.getIntent().getStringExtra("Kpoi_address");
            aVK();
        }
    }

    public final void aVJ() {
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.hHh.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!be.kS(this.jGS)) {
            intent.putExtra("get_poi_classify_id", this.jGS);
        } else if (!be.kS(this.bCl)) {
            intent.putExtra("get_city", this.bCl);
        }
        intent.putExtra("get_lat", this.cJq);
        intent.putExtra("get_lng", this.cJr);
        if (this.jGW != null) {
            ArrayList aVP = this.jGW.aVP();
            if (aVP != null) {
                N(aVP);
                ArrayList arrayList = new ArrayList();
                Iterator it = aVP.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        com.tencent.mm.ay.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
    }

    private void N(ArrayList<com.tencent.mm.compatible.util.Exif.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            com.tencent.mm.compatible.util.Exif.a aVar;
            g.iuh.Y(11139, "1");
            if (((double) Math.abs(-1000.0f - this.cJq)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.cJr)) > 1.0E-6d) {
                aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(arrayList.size() - 1);
                if (b(aVar.latitude, aVar.longitude, (double) this.cJq, (double) this.cJr)) {
                    g.iuh.Y(11139, "2");
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object obj;
                for (int i2 = i + 1; i2 < arrayList.size(); i2++) {
                    aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i);
                    com.tencent.mm.compatible.util.Exif.a aVar2 = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i2);
                    if (b(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                        g.iuh.Y(11139, "3");
                        obj = null;
                        break;
                    }
                }
                int i3 = 1;
                if (obj != null) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean b(double d, double d2, double d3, double d4) {
        return k.c(d, d2, d3, d4) > 1000.0d;
    }

    public final void stop() {
        if (this.hGy != null) {
            this.hGy.c(this.hGR);
        }
        if (this.gXm != null) {
            this.gXm.a(this.gRR);
        }
    }

    public final boolean G(Intent intent) {
        if (intent != null) {
            this.jGT = intent.getIntExtra("get_poi_classify_type", 0);
            v.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[]{Integer.valueOf(this.jGT)});
            this.gUr = be.ah(intent.getStringExtra("get_poi_name"), "");
            this.bCl = be.ah(intent.getStringExtra("get_city"), "");
            this.cJq = intent.getFloatExtra("get_lat", -1000.0f);
            this.cJr = intent.getFloatExtra("get_lng", -1000.0f);
            v.i("MicroMsg.LocationWidget", "check cur lat " + this.jGU + " " + this.hGE);
            this.jGU = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.hGE = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.jGV = intent.getIntExtra("get_loctype", -1);
            this.aJp = intent.getFloatExtra("get_accuracy", 0.0f);
            this.cJA = intent.getBooleanExtra("get_is_mars", true);
            e.JZ().a(2003, this.jGV != 0, this.cJA, this.cJr, this.cJq, (int) this.aJp);
            this.jGQ = intent.getByteArrayExtra("location_ctx");
            if (!be.kS(this.gUr)) {
                this.jGR = be.ah(intent.getStringExtra("get_poi_address"), "");
                this.jGS = be.ah(intent.getStringExtra("get_poi_classify_id"), "");
                this.hHh = new aft();
                try {
                    this.hHh = (aft) this.hHh.az(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Throwable e) {
                    v.a("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.hHh = null;
                }
                if (!be.kS(this.jGS)) {
                    this.hHh = new aft();
                    this.hHh.hHb = this.jGS;
                    this.hHh.efm = this.jGT;
                    this.hHh.aXz = this.gUr;
                    this.hHh.mFG.add(new arf().JF(this.jGR));
                }
            } else if (be.kS(this.bCl)) {
                this.cJq = -1000.0f;
                this.cJr = -1000.0f;
                this.gUr = "";
                this.jGR = "";
                this.bCl = "";
                this.jGS = "";
                this.hHh = null;
            } else {
                this.gUr = "";
                this.jGR = "";
                this.jGS = "";
                this.hHh = null;
            }
            v.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[]{this.jGR, this.gUr});
            aVK();
            this.jGY = new b(this);
            b bVar = this.jGY;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.hGH = intent.getLongExtra("first_start_time", 0);
                bVar.hGI = intent.getLongExtra("lastSuccStamp", 0);
                bVar.hGJ = intent.getLongExtra("firstSuccStamp", 0);
                bVar.hGK = intent.getIntExtra("reqLoadCnt", 0);
                bVar.gYq = intent.getIntExtra("entry_time", 0);
                bVar.bpB = intent.getStringExtra("search_id");
            }
        }
        return true;
    }

    private void aVK() {
        if (!(this.jGP == null || this.jFb == null)) {
            if (!be.kS(this.gUr)) {
                this.jGP.setText(this.gUr);
                this.jFb.setVisibility(8);
            } else if (be.kS(this.bCl)) {
                this.jGP.setText(2131235463);
                this.jFb.setVisibility(8);
            } else {
                this.jGP.setText(this.bCl);
                this.jFb.setVisibility(8);
            }
        }
        if (be.kS(this.gUr) && be.kS(this.bCl)) {
            this.jEe.setImageResource(aVL());
        } else {
            this.jEe.setImageResource(aVM());
        }
    }

    protected int aVL() {
        return 2131165949;
    }

    protected int aVM() {
        return 2131165950;
    }

    public final agp aVN() {
        agp com_tencent_mm_protocal_c_agp = new agp();
        com_tencent_mm_protocal_c_agp.mjN = this.cJq;
        com_tencent_mm_protocal_c_agp.mjM = this.cJr;
        com_tencent_mm_protocal_c_agp.mGl = 0;
        if (this.jGQ != null) {
            com_tencent_mm_protocal_c_agp.mGm = new com.tencent.mm.ba.b(this.jGQ);
        }
        if (!be.kS(this.gUr)) {
            com_tencent_mm_protocal_c_agp.jGR = this.jGR;
            com_tencent_mm_protocal_c_agp.gUr = this.gUr;
            com_tencent_mm_protocal_c_agp.mGi = this.jGS;
            com_tencent_mm_protocal_c_agp.cHe = this.bCl;
            if (this.jGT == 0 || this.jGT != 1) {
                com_tencent_mm_protocal_c_agp.jGT = 1;
            } else {
                com_tencent_mm_protocal_c_agp.jGT = 2;
            }
            v.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_agp.jGT)});
        } else if (!be.kS(this.bCl)) {
            com_tencent_mm_protocal_c_agp.cHe = this.bCl;
        }
        if (this.jGY != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_agp.mjN), Float.valueOf(com_tencent_mm_protocal_c_agp.mjM)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.jGY.index);
            stringBuffer.append("firstStartStamp " + this.jGY.hGH);
            stringBuffer.append("lastSuccStamp " + this.jGY.hGJ);
            stringBuffer.append("firstSuccStamp " + this.jGY.hGI);
            stringBuffer.append("reqLoadCnt " + this.jGY.hGK);
            stringBuffer.append("classifyId " + this.jGS);
            stringBuffer.append("entryTime " + this.jGY.gYq);
            stringBuffer.append("searchId" + this.jGY.bpB);
            v.d("MicroMsg.LocationWidget", "report %s", new Object[]{stringBuffer.toString()});
            g.iuh.h(11135, new Object[]{Integer.valueOf(5), Integer.valueOf(this.jGY.index + 1), Long.valueOf(this.jGY.hGH), Long.valueOf(this.jGY.hGJ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.jGY.hGI), Integer.valueOf(this.jGY.hGK), format, this.jGS, Integer.valueOf(this.jGY.gYq), this.jGY.bpB, p.rJ()});
        }
        aVO();
        return com_tencent_mm_protocal_c_agp;
    }

    private void aVO() {
        if (this.jGW != null) {
            boolean aVQ = this.jGW.aVQ();
            ArrayList aVP = this.jGW.aVP();
            if (aVP != null && aVP.size() != 0) {
                Iterator it = aVP.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    v.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)});
                    g gVar = g.iuh;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                    objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                    objArr[2] = Integer.valueOf(aVQ ? 1 : 2);
                    objArr[3] = Integer.valueOf(2);
                    gVar.h(11345, objArr);
                }
            }
        }
    }

    protected int getLayoutResource() {
        return 2130903870;
    }
}
