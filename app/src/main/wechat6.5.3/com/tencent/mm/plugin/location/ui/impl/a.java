package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.e.a {
    public Activity aXH;
    protected ProgressDialog dwR = null;
    protected float euH = 0.0f;
    protected String gTQ;
    protected String gTc = "";
    protected String gUr = "";
    public String gXc = "";
    protected boolean gXd = false;
    public boolean gXe = false;
    protected Addr gXf = null;
    protected d gXg;
    protected LocationInfo gXh = new LocationInfo((byte) 0);
    protected LocationInfo gXi = new LocationInfo((byte) 0);
    protected a gXj;
    protected boolean gXk = false;
    protected HashMap<String, c> gXl = new HashMap();
    protected b gXm;
    protected boolean gXn = false;
    protected int gXo = 0;
    protected ArrayList<String> gXp = new ArrayList();
    protected boolean gXq = false;
    protected boolean gXr = false;
    protected com.tencent.mm.plugin.location.model.c gXs = null;
    protected com.tencent.mm.modelgeo.c gXt;
    public com.tencent.mm.modelgeo.b.a gXu = new com.tencent.mm.modelgeo.b.a(this) {
        final /* synthetic */ a gXv;

        {
            this.gXv = r1;
        }

        public final void b(Addr addr) {
            v.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[]{addr.toString()});
            this.gXv.gXf = addr;
            String str = addr.cJi;
            String FV = addr.FV();
            this.gXv.gXi.bkV = this.gXv.aXH.getResources().getString(2131233523);
            if (addr.tag != null && addr.tag.equals(this.gXv.gXi.gRJ)) {
                this.gXv.gXi.gRM = FV;
            } else if (!be.kS(addr.cJf)) {
                this.gXv.gXj.gXx.setVisibility(0);
            }
            if (addr.tag != null && this.gXv.gXl.containsKey(addr.tag)) {
                c cVar = (c) this.gXv.gXl.get(addr.tag);
                cVar.setText(cVar.awA() + FV);
            }
            float f = addr.cJr;
            f = addr.cJq;
        }
    };
    protected float gpD = 0.0f;
    DisplayMetrics guo = null;
    ac handler = new ac(Looper.getMainLooper());
    protected int type = 0;
    int zoom;

    class a {
        com.tencent.mm.plugin.e.d gUq;
        View gXA;
        TextView gXB;
        TextView gXC;
        TextView gXD;
        TextView gXE;
        TextView gXF;
        final /* synthetic */ a gXv;
        FrameLayout gXw;
        RelativeLayout gXx;
        View gXy;
        ImageButton gXz;
        TextView titleView;

        a(a aVar) {
            this.gXv = aVar;
        }
    }

    protected abstract String NK();

    protected abstract void axe();

    abstract void axf();

    public a(Activity activity) {
        this.aXH = activity;
        this.gXm = b.FW();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.aXH.finish();
    }

    protected final void a(n nVar) {
        this.gXj.gUq.addLocationPin(nVar.gUp);
    }

    public void onCreate(Bundle bundle) {
        this.gXt = com.tencent.mm.modelgeo.c.FY();
        LocationInfo locationInfo = this.gXi;
        LocationInfo locationInfo2 = this.gXh;
        String d = u.d(aa.btk());
        v.d("MicroMsg.BaseMapUI", " initLanguage " + d);
        if (d.equals("language_default")) {
            u.a(this.aXH, Locale.ENGLISH);
            d = "en";
        } else {
            u.a(this.aXH, u.Ke(d));
        }
        locationInfo2.gRN = d;
        locationInfo.gRN = d;
        v.d("MicroMsg.BaseMapUI", "sosomap " + this.gXh.gRN);
        this.aXH.requestWindowFeature(1);
        this.aXH.setContentView(2130903773);
        ((FrameLayout) findViewById(2131757406)).addView(d.ce(this.aXH));
        this.gXg = new d(this.aXH);
        this.gXj = new a(this);
        this.gTQ = this.aXH.getIntent().getStringExtra("kRemark");
        this.gXp = this.aXH.getIntent().getStringArrayListExtra("kTags");
        this.type = this.aXH.getIntent().getIntExtra("map_view_type", 0);
        this.gXe = this.aXH.getIntent().getBooleanExtra("kIs_pick_poi", false);
        v.i("MicroMsg.BaseMapUI", "isPickPoi " + this.gXe);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        v.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        axe();
        this.aXH.finish();
        return true;
    }

    public void onResume() {
        w.a(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        w.a(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.gXm.a(this.gXu);
        v.d("MicroMsg.BaseMapUI", "destory");
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        System.gc();
    }

    public final String getString(int i) {
        return this.aXH.getString(i);
    }

    protected final void axb() {
        if (this.gXj.gXD != null && this.gXj.gXE != null) {
            this.gXj.gXD.setText(e.a(this.gXj.gXD.getContext(), this.gTQ, this.gXj.gXD.getTextSize()));
            if (this.gXp == null || this.gXp.isEmpty()) {
                this.gXj.gXE.setText("");
                return;
            }
            CharSequence charSequence = (String) this.gXp.get(0);
            String string = this.aXH.getResources().getString(2131232743);
            int i = 1;
            while (i < this.gXp.size()) {
                String str = charSequence + string + ((String) this.gXp.get(i));
                i++;
                Object obj = str;
            }
            this.gXj.gXE.setText(e.a(this.gXj.gXE.getContext(), charSequence, this.gXj.gXE.getTextSize()));
        }
    }

    protected final void axc() {
        this.gXj.gXx.removeAllViews();
        View inflate = View.inflate(this.aXH, 2130903866, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.gXj.gXx.addView(inflate, layoutParams);
        this.gXj.gXD = (TextView) inflate.findViewById(2131757710);
        this.gXj.gXD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a gXv;

            {
                this.gXv = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.gXv.aXH, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", this.gXv.axd());
                intent.putExtra("key_hint", this.gXv.getString(2131233534));
                intent.putExtra("Kwebmap_locaion", this.gXv.gXh.gRM);
                intent.putExtra("kFavInfoLocalId", this.gXv.aXH.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", this.gXv.aXH.getIntent().getStringExtra("kRemark"));
                this.gXv.aXH.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
            }
        });
        this.gXj.gXE = (TextView) inflate.findViewById(2131757711);
        this.gXj.gXE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a gXv;

            {
                this.gXv = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_item_id", this.gXv.aXH.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("key_fav_result_list", this.gXv.aXH.getIntent().getStringArrayListExtra("kTags"));
                com.tencent.mm.ay.c.b(this.gXv.aXH, "favorite", ".ui.FavTagEditUI", intent, 4100);
            }
        });
        axb();
    }

    protected final String axd() {
        return be.ah(this.gTQ, "");
    }

    protected final boolean c(LocationInfo locationInfo) {
        if (this.gXj.gUq.getIController() == null || !com.tencent.mm.plugin.location.model.e.f(locationInfo.gRK, locationInfo.gRL)) {
            return false;
        }
        this.gXj.gUq.getIController().animateTo(locationInfo.gRK, locationInfo.gRL);
        return true;
    }

    public final View findViewById(int i) {
        return this.aXH.findViewById(i);
    }

    protected final void NI() {
        v.d("MicroMsg.BaseMapUI", "initView");
        this.gXj.gUq = (com.tencent.mm.plugin.e.d) findViewById(2131755380);
        this.gXj.gXw = (FrameLayout) findViewById(2131757407);
        this.gXj.gXx = (RelativeLayout) findViewById(2131757408);
        this.gXj.gXy = findViewById(2131758188);
        this.gXj.gXz = (ImageButton) findViewById(2131758193);
        this.gXj.gXA = findViewById(2131758194);
        this.gXj.gXB = (TextView) findViewById(2131755265);
        this.gXj.titleView = (TextView) findViewById(2131758190);
        this.gXj.gXF = (TextView) findViewById(2131757412);
        this.gXj.titleView.setText(NK());
        this.gXj.gUq.getIController().setZoom(d.dV(false));
        if (!(this.type == 0 || this.type == 3)) {
            this.gXj.gXz.setVisibility(0);
            this.gXj.gXA.setVisibility(8);
            this.gXj.gXz.setEnabled(false);
            this.gXj.gXz.setImageResource(2130838681);
        }
        this.gXj.gUq.setBuiltInZoomControls(false);
        this.gXj.gXy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a gXv;

            {
                this.gXv = r1;
            }

            public final void onClick(View view) {
                this.gXv.axe();
                this.gXv.axg();
                this.gXv.aXH.finish();
            }
        });
        this.gXj.gXB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a gXv;

            {
                this.gXv = r1;
            }

            public final void onClick(View view) {
            }
        });
        axf();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            if (Downloads.RECV_BUFFER_SIZE == i) {
                if (this.gXj.gXD != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.gTQ = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    axb();
                }
            } else if (4100 == i && this.gXj.gXE != null) {
                this.gXp = intent.getStringArrayListExtra("key_fav_result_list");
                axb();
            }
        }
    }

    protected final void axg() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.aXH.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.aXH.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public boolean axh() {
        return true;
    }
}
