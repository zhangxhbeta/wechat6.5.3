package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class AppChooserUI extends MMActivity {
    private OnDismissListener Ff = new OnDismissListener(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.lSr.finish();
        }
    };
    private PackageManager aHB;
    a lRU;
    private Intent lRV = null;
    private int lRW;
    private String lRX = null;
    private Bundle lRY = null;
    private s lRZ = null;
    private ArrayList<String> lSa = null;
    private c lSb = null;
    private c lSc = new c(this);
    private List<c> lSd;
    private String lSe;
    private int lSf;
    private int lSg;
    private boolean lSh = false;
    private boolean lSi = false;
    private boolean lSj = false;
    private long lSk;
    private e lSl;
    private OnItemClickListener lSm = new OnItemClickListener(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.lSr.lRU != null) {
                this.lSr.lSb = this.lSr.lRU.uv(i);
                this.lSr.lRU.notifyDataSetChanged();
                if (this.lSr.lSl != null && this.lSr.lSl.isShowing()) {
                    if (this.lSr.lSb == null || !this.lSr.lSb.lSy || (this.lSr.lSb.gEb && (this.lSr.lSb.koh || this.lSr.lSf >= this.lSr.lSg))) {
                        this.lSr.lSl.in(true);
                    } else {
                        this.lSr.lSl.in(false);
                    }
                }
                if ((this.lSr.scene == 6 || this.lSr.lRW == 2) && this.lSr.lSb != null && this.lSr.lSb.lSv != null) {
                    this.lSr.h(-1, this.lSr.lSb.lSv.activityInfo.packageName, false);
                    g.iuh.h(12809, Integer.valueOf(4), this.lSr.lSb.lSv.activityInfo.packageName);
                }
            }
        }
    };
    private OnClickListener lSn = new OnClickListener(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onClick(View view) {
            if (this.lSr.lSb != null && this.lSr.lSb.lSv != null) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(this.lSr.uu(274528), this.lSr.lSb.lSv.activityInfo.packageName);
                this.lSr.h(-1, this.lSr.lSb.lSv.activityInfo.packageName, true);
            }
        }
    };
    private OnClickListener lSo = new OnClickListener(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onClick(View view) {
            if (this.lSr.lSb != null && this.lSr.lSb.lSv != null) {
                this.lSr.h(-1, this.lSr.lSb.lSv.activityInfo.packageName, false);
            }
        }
    };
    private OnClickListener lSp = new OnClickListener(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (this.lSr.lRU != null) {
                int i = this.lSr.lRU.lSs;
                if (i == f.lSG) {
                    if (this.lSr.lSl != null && this.lSr.lSl.isShowing()) {
                        this.lSr.lRU.lSs = f.lSH;
                        this.lSr.lRU.notifyDataSetChanged();
                    }
                    com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                    if (this.lSr.scene == 1) {
                        aVar.GQ("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
                    } else {
                        aVar.GQ(this.lSr.lRZ.MV());
                    }
                    aVar.GR(this.lSr.lRZ.bmO());
                    aVar.tE(1);
                    aVar.hO(true);
                    com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn);
                    t.bmX();
                    t.tC(this.lSr.lRW);
                    if (this.lSr.lRW == 0) {
                        if (this.lSr.lSi) {
                            g.iuh.h(11168, Integer.valueOf(4), Integer.valueOf(this.lSr.scene));
                        } else {
                            g.iuh.h(11168, Integer.valueOf(3), Integer.valueOf(this.lSr.scene));
                        }
                    }
                    if (this.lSr.lRW == 1) {
                        g.iuh.h(12809, Integer.valueOf(5), SQLiteDatabase.KeyEmpty);
                    }
                } else if (i == f.lSI) {
                    MMActivity mMActivity = this.lSr;
                    long j = this.lSr.lSk;
                    v.i("MicroMsg.AppChooserUI", "installRecommendApp");
                    v.d("MicroMsg.AppChooserUI", "filepath:%s", com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(j).path);
                    if (!p.c(mMActivity.nDR.nEl, Uri.fromFile(new File(r1)))) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(mMActivity.uu(274560), Long.valueOf(0));
                        if (mMActivity.lRU != null) {
                            mMActivity.lRU.lSs = f.lSG;
                            mMActivity.lRU.notifyDataSetChanged();
                        }
                    } else if (mMActivity.lRU != null) {
                        mMActivity.lRU.lSs = f.lSI;
                        mMActivity.lRU.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private l lSq = new l(this) {
        final /* synthetic */ AppChooserUI lSr;

        {
            this.lSr = r1;
        }

        public final void onTaskStarted(long j, String str) {
            this.lSr.lSk = j;
            ak.yW();
            com.tencent.mm.model.c.vf().set(this.lSr.uu(274560), Long.valueOf(this.lSr.lSk));
            v.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            v.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
        }

        public final void g(long j, String str) {
            v.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!be.kS(str) && com.tencent.mm.a.e.aR(str)) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(this.lSr.uu(274560), Long.valueOf(this.lSr.lSk));
                if (this.lSr.lRU != null && this.lSr.lSk == j) {
                    this.lSr.lRU.lSs = f.lSI;
                    this.lSr.lRU.notifyDataSetChanged();
                }
            }
        }

        public final void q(long j, int i) {
            v.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            ak.yW();
            com.tencent.mm.model.c.vf().set(this.lSr.uu(274560), Long.valueOf(0));
            if (this.lSr.lRU != null) {
                this.lSr.lRU.lSs = f.lSG;
                this.lSr.lRU.notifyDataSetChanged();
            }
        }

        public final void onTaskPaused(long j) {
            v.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            ak.yW();
            com.tencent.mm.model.c.vf().set(this.lSr.uu(274560), Long.valueOf(0));
            if (this.lSr.lRU != null) {
                this.lSr.lRU.lSs = f.lSG;
                this.lSr.lRU.notifyDataSetChanged();
            }
        }

        public final void bV(long j) {
        }

        public final void bW(long j) {
        }
    };
    private String mimeType = null;
    private int scene = 0;

    class a extends BaseAdapter {
        List<c> eZk = new ArrayList();
        final /* synthetic */ AppChooserUI lSr;
        int lSs = f.lSG;

        public final /* synthetic */ Object getItem(int i) {
            return uv(i);
        }

        public a(AppChooserUI appChooserUI) {
            this.lSr = appChooserUI;
            appChooserUI.aHB = appChooserUI.getPackageManager();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.lSr.nDR.nEl).inflate(2130903120, null);
                b bVar2 = new b(this.lSr, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            c uv = uv(i);
            if (uv.lSx == null) {
                new d(this.lSr).execute(new c[]{uv});
            }
            bVar.gxq.setImageDrawable(uv.lSx);
            bVar.gxr.setText(uv.lSw);
            if (uv == null || (!(!uv.lSy || uv.koh || (uv.lSy && uv.gEb && this.lSr.lSf >= this.lSr.lSg)) || uv.lSz)) {
                bVar.lSt.setVisibility(0);
                bVar.lSu.setVisibility(8);
                bVar.lSt.setOnClickListener(this.lSr.lSp);
                if (this.lSs == f.lSG) {
                    if (uv.lSz) {
                        bVar.lSt.setText(2131231101);
                    } else {
                        bVar.lSt.setText(2131231024);
                    }
                    bVar.lSt.setEnabled(true);
                } else if (this.lSs == f.lSH) {
                    bVar.lSt.setText(2131231029);
                    bVar.lSt.setEnabled(false);
                } else if (this.lSs == f.lSI) {
                    if (uv.lSz) {
                        bVar.lSt.setText(2131231166);
                    } else {
                        bVar.lSt.setText(2131231165);
                    }
                    bVar.lSt.setEnabled(true);
                }
            } else {
                boolean z;
                bVar.lSt.setVisibility(8);
                bVar.lSu.setVisibility(0);
                RadioButton radioButton = bVar.lSu;
                c c = this.lSr.lSb;
                if (c instanceof c) {
                    c = c;
                    if (!(c.lSv == null || uv.lSv == null || !c.lSv.activityInfo.packageName.equals(uv.lSv.activityInfo.packageName)) || (c.lSy && uv.lSy)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (uv.lSy) {
                if (this.lSr.scene == 4) {
                    bVar.gxt.setText(2131234260);
                } else {
                    bVar.gxt.setText(be.ma(this.lSr.lRX));
                }
                TextView textView = bVar.gxt;
                if (be.kS(this.lSr.lRX)) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            } else {
                bVar.gxt.setVisibility(8);
            }
            if (!(this.lSr.scene == 6 || this.lSr.lSb == null || !this.lSr.lSb.equals(uv))) {
                bVar.lSu.setChecked(true);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final c uv(int i) {
            return this.eZk == null ? null : (c) this.eZk.get(i);
        }

        public final int getCount() {
            return this.eZk == null ? 0 : this.eZk.size();
        }
    }

    class b {
        ImageView gxq;
        TextView gxr;
        TextView gxt;
        final /* synthetic */ AppChooserUI lSr;
        TextView lSt;
        RadioButton lSu;

        public b(AppChooserUI appChooserUI, View view) {
            this.lSr = appChooserUI;
            this.gxq = (ImageView) view.findViewById(2131755418);
            this.gxr = (TextView) view.findViewById(2131755419);
            this.gxt = (TextView) view.findViewById(2131755420);
            this.lSt = (TextView) view.findViewById(2131755421);
            this.lSu = (RadioButton) view.findViewById(2131755422);
        }
    }

    class c {
        boolean gEb;
        boolean koh;
        final /* synthetic */ AppChooserUI lSr;
        ResolveInfo lSv;
        CharSequence lSw;
        Drawable lSx;
        boolean lSy;
        boolean lSz;

        public c(AppChooserUI appChooserUI) {
            this.lSr = appChooserUI;
        }

        public c(AppChooserUI appChooserUI, ResolveInfo resolveInfo, CharSequence charSequence) {
            this.lSr = appChooserUI;
            this.lSv = resolveInfo;
            this.lSw = charSequence;
            this.lSy = false;
            this.koh = true;
            this.lSz = false;
        }
    }

    class d extends AsyncTask<c, Void, c> {
        final /* synthetic */ AppChooserUI lSr;

        d(AppChooserUI appChooserUI) {
            this.lSr = appChooserUI;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            c cVar = ((c[]) objArr)[0];
            if (cVar.lSx == null) {
                cVar.lSx = this.lSr.b(cVar.lSv);
            }
            return cVar;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.lSr.lRU.notifyDataSetChanged();
        }
    }

    public enum f {
        ;

        static {
            lSG = 1;
            lSH = 2;
            lSI = 3;
            lSJ = new int[]{lSG, lSH, lSI};
        }
    }

    class e extends i {
        private TextView EI = ((TextView) this.eEX.findViewById(2131755411));
        private View eEX = View.inflate(this.mContext, 2130903119, null);
        BaseAdapter eGK;
        private ListView lSA = ((ListView) this.eEX.findViewById(2131755413));
        private Button lSB = ((Button) this.eEX.findViewById(2131755415));
        private Button lSC = ((Button) this.eEX.findViewById(2131755417));
        private View lSD = this.eEX.findViewById(2131755412);
        OnItemClickListener lSE;
        OnClickListener lSF;
        OnClickListener lSo;
        final /* synthetic */ AppChooserUI lSr;
        private Context mContext;
        private String mTitle;

        public e(AppChooserUI appChooserUI, Context context) {
            this.lSr = appChooserUI;
            super(context, 2131559263);
            this.mContext = context;
            if (this.lSr.scene == 6 || this.lSr.lRW == 2) {
                this.eEX.findViewById(2131755414).setVisibility(8);
            }
        }

        protected final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(this.eEX);
        }

        public final void setTitle(CharSequence charSequence) {
            if (charSequence != null) {
                this.mTitle = charSequence.toString();
            } else {
                this.mTitle = null;
            }
        }

        public final void in(boolean z) {
            if (this.lSB != null) {
                this.lSB.setEnabled(z);
            }
            if (this.lSC != null) {
                this.lSC.setEnabled(z);
            }
        }

        public final void onBackPressed() {
            this.lSr.finish();
        }

        public final void show() {
            if (be.kS(this.mTitle)) {
                this.lSD.setVisibility(8);
                this.EI.setVisibility(8);
            } else {
                this.lSD.setVisibility(0);
                this.EI.setVisibility(0);
                this.EI.setText(this.mTitle);
            }
            if (this.lSE != null) {
                this.lSA.setOnItemClickListener(this.lSE);
            }
            if (this.eGK != null) {
                this.lSA.setAdapter(this.eGK);
            }
            if (this.lSB != null) {
                this.lSB.setOnClickListener(this.lSF);
            }
            if (this.lSC != null) {
                this.lSC.setOnClickListener(this.lSo);
            }
            super.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.bmX();
        t.tz(this.lRW);
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.lRV = (Intent) parcelableExtra;
            CharSequence stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
            this.lRW = intent.getIntExtra("type", 0);
            this.lRY = intent.getBundleExtra("transferback");
            this.lSa = intent.getStringArrayListExtra("targetwhitelist");
            this.lSi = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (ak.uz()) {
                boolean z;
                ak.yW();
                this.lSe = (String) com.tencent.mm.model.c.vf().get(uu(274528), SQLiteDatabase.KeyEmpty);
                if (!TextUtils.isEmpty(this.lSe) && p.o(this.nDR.nEl, this.lSe) && (this.lSa == null || this.lSa.isEmpty() || this.lSa.contains(this.lSe))) {
                    Intent intent2 = new Intent(this.lRV);
                    intent2.setPackage(this.lSe);
                    if (be.m(this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    this.aHB = getPackageManager();
                    this.lRU = new a(this);
                    t.bmX();
                    this.lRZ = t.o(this.lRW, intent.getBundleExtra("key_recommend_params"));
                    this.lSh = this.lRZ.dc(this.nDR.nEl);
                    ak.yW();
                    this.lSf = ((Integer) com.tencent.mm.model.c.vf().get(bqM(), Integer.valueOf(0))).intValue();
                    t.bmX();
                    this.lSg = t.ty(this.lRW);
                    v.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.lSh), Integer.valueOf(this.lSf));
                    this.lSj = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.lSf >= this.lSg) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.lSd = a(this.lRV, bqN(), this.lSa);
                    if (!(z2 || this.lSh)) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(bqM(), Integer.valueOf(this.lSf + 1));
                    }
                    if (this.lSh) {
                        t.bmX();
                        t.tB(this.lRW);
                    } else if (!z2) {
                        t.bmX();
                        t.tA(this.lRW);
                    }
                    if (this.lSd == null || this.lSd.size() != 1 || (bqN() && !this.lSh)) {
                        vB(8);
                        if (this.lSd == null || this.lSd.isEmpty()) {
                            h(4097, null, false);
                            return;
                        }
                        this.lRU.eZk = this.lSd;
                        ak.yW();
                        this.lSk = ((Long) com.tencent.mm.model.c.vf().get(uu(274560), Long.valueOf(0))).longValue();
                        com.tencent.mm.pluginsdk.model.downloader.f dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(this.lSk);
                        v.d("MicroMsg.AppChooserUI", "downloadId:" + this.lSk + ", status:" + dn.status);
                        if (3 == dn.status && com.tencent.mm.a.e.aR(dn.path) && this.lRU != null) {
                            this.lRU.lSs = f.lSI;
                            this.lRU.notifyDataSetChanged();
                        }
                        this.lSl = new e(this, this.nDR.nEl);
                        this.lSl.setTitle(stringExtra);
                        this.lSl.lSE = this.lSm;
                        this.lSl.lSo = this.lSo;
                        this.lSl.lSF = this.lSn;
                        this.lSl.eGK = this.lRU;
                        this.lSl.setOnDismissListener(this.Ff);
                        this.lSl.show();
                        if (!(this.lSi || !this.lSh || z2)) {
                            this.lSb = this.lSc;
                            this.lSl.in(true);
                        }
                        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
                        com.tencent.mm.pluginsdk.model.downloader.a.a(this.lSq);
                        return;
                    }
                    c cVar = (c) this.lSd.get(0);
                    if (cVar == null) {
                        h(4097, null, false);
                        return;
                    } else if (cVar.lSv != null) {
                        h(-1, cVar.lSv.activityInfo.packageName, false);
                        return;
                    } else {
                        h(4098, null, false);
                        return;
                    }
                }
                h(-1, this.lSe, true);
                return;
            }
            v.e("MicroMsg.AppChooserUI", "acc not ready");
            h(4097, null, false);
            return;
        }
        v.w("ChooseActivity", "Target is not an intent: " + parcelableExtra);
        h(0, null, false);
    }

    protected void onResume() {
        super.onResume();
        if (this.lSi && this.lRV != null && this.lRZ.t(this, this.lRV)) {
            v.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.lSi = false;
            this.lSc.lSz = false;
        }
        this.lSh = this.lRZ.dc(this.nDR.nEl);
        this.lSd = a(this.lRV, bqN(), this.lSa);
        if (this.lSh && this.lSb == null) {
            this.lSb = this.lSc;
            this.lSl.in(true);
        }
        if (this.lRU != null) {
            this.lRU.eZk = this.lSd;
            this.lRU.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.b(this.lSq);
        if (this.lSl != null) {
            this.lSl.dismiss();
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        super.onBackPressed();
        h(0, null, false);
    }

    final int uu(int i) {
        if (this.mimeType != null) {
            return (this.lRW + i) + this.mimeType.hashCode();
        }
        return this.lRW + i;
    }

    private int bqM() {
        return 274496 + this.lRW;
    }

    private void h(int i, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.lRY);
        setResult(i, intent);
        finish();
    }

    private boolean bqN() {
        v.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.lSj), Integer.valueOf(this.lSf), Integer.valueOf(this.lSg), Boolean.valueOf(be.He()));
        if (!this.lSj || this.lSf >= this.lSg || be.He() || com.tencent.mm.sdk.platformtools.f.aPW == 1) {
            return false;
        }
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        List<c> arrayList2 = new ArrayList();
        List queryIntentActivities = this.aHB.queryIntentActivities(intent, 65536);
        com.tencent.mm.pluginsdk.model.t.a bmP = this.lRZ.bmP();
        if (!be.kS(bmP.lzX)) {
            this.lRX = bmP.lzX;
        } else if (bmP.lzW > 0) {
            this.lRX = getResources().getString(bmP.lzW);
        }
        if (bmP.lzV > 0) {
            this.lSc.lSx = getResources().getDrawable(bmP.lzV);
        }
        if (bmP.lzY > 0) {
            this.lSc.lSw = getResources().getString(bmP.lzY);
        } else {
            this.lSc.lSw = bmP.lzZ;
        }
        this.lSc.lSy = true;
        this.lSc.koh = this.lSh;
        if (this.lSh) {
            this.lSc.gEb = true;
        }
        if (this.lSi) {
            this.lSc.lSz = true;
        }
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                v.d("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.lRZ.Gn(str)) {
                            this.lSc.lSv = resolveInfo;
                            this.lSc.gEb = true;
                            if ((!z && this.lSh) || (!z && this.lSc.gEb)) {
                                arrayList2.add(0, this.lSc);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(this, resolveInfo, this.lRZ.a(this.nDR.nEl, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && r1 == null) {
            if (this.lRW != 0 || this.mimeType == null) {
                arrayList2.add(0, this.lSc);
            } else {
                arrayList2.add(0, this.lSc);
                if (this.lSi) {
                    g.iuh.h(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    g.iuh.h(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.lSv != null) {
                String str2 = cVar.lSv.activityInfo.packageName;
                if (!(be.kS(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        return arrayList2;
    }

    private static Drawable a(Resources resources, int i) {
        try {
            return com.tencent.mm.be.a.b(resources, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private Drawable b(ResolveInfo resolveInfo) {
        try {
            Drawable a;
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                a = a(this.aHB.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (a != null) {
                    return a;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                a = a(this.aHB.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (a != null) {
                    return a;
                }
            }
        } catch (NameNotFoundException e) {
            v.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        return resolveInfo.loadIcon(this.aHB);
    }
}
