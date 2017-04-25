package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.a.c.j;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.d.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.e.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileySubGrid;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, com.tencent.mm.sdk.h.g.a, e {
    private View dZV;
    private int eTx;
    private ProgressBar eYR;
    private ProgressDialog eZg;
    private int eZz;
    private String fdU;
    private String fdV;
    private String fdW;
    private long fdd = 0;
    private String fde = "";
    private com.tencent.mm.plugin.emoji.h.b fdh;
    private int ffU;
    private com.tencent.mm.sdk.c.c ffY = new com.tencent.mm.sdk.c.c<cb>(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r2;
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            if (!(this.fjh.fdU == null || cbVar.aZC.aZD == null || !cbVar.aZC.aZD.equals(this.fjh.fdU))) {
                this.fjh.e(cbVar.aZC.aZD, cbVar.aZC.status, cbVar.aZC.progress, cbVar.aZC.aZE);
            }
            return false;
        }
    };
    private oh fgm = new oh();
    private String fgn = "";
    private int fhZ;
    private ProgressBar fiA;
    private View fiB;
    private ImageView fiC;
    private TextView fiD;
    private View fiE;
    private View fiF;
    private MMCopiableTextView fiG;
    private Button fiH;
    private DonorsAvatarView fiI;
    private TextView fiJ;
    private int fiK;
    private int fiL;
    private int fiM;
    private String fiN;
    private boolean fiO;
    private int fiP;
    private int fiQ = -1;
    private String fiR;
    private String[] fiS = new String[1];
    private boolean fiT = false;
    private View fiU;
    private boolean fiV = true;
    private vn fiW;
    private boolean fiX = false;
    private boolean fiY = true;
    private OnClickListener fiZ = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void onClick(View view) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + u.bsY());
            String str = this.fjh.getString(2131232353) + u.bsY();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            com.tencent.mm.ay.c.b(this.fjh, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private String fia;
    private boolean fib;
    private boolean fic = false;
    private int fid = -1;
    private k fie;
    private g fif;
    private n fig;
    private a fih;
    private vv fii = null;
    private boolean fij;
    private TextView fik;
    private View fil;
    private EmojiDetailScrollView fim;
    private BannerEmojiView fin;
    private TextView fio;
    private MMAutoSizeTextView fip;
    private TextView fiq;
    private TextView fir;
    private TextView fis;
    private EmojiDetailGridView fit;
    private ImageView fiu;
    private View fiv;
    private TextView fiw;
    private TextView fix;
    private int fiy;
    private View fiz;
    private OnClickListener fja = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void onClick(View view) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + u.bsY());
            String str = this.fjh.getString(2131232333) + u.bsY();
            Intent intent = new Intent();
            intent.putExtra("title", this.fjh.getString(2131232370));
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            com.tencent.mm.ay.c.b(this.fjh, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private OnClickListener fjb = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.fjh, EmojiStoreV2RewardUI.class);
            intent.putExtra("extra_id", this.fjh.fdU);
            intent.putExtra("extra_name", this.fjh.fgm.mqd);
            if (!(this.fjh.fgm == null || this.fjh.fgm.mqy == null)) {
                intent.putExtra("name", this.fjh.fgm.mqy.gkB);
            }
            intent.putExtra("scene", this.fjh.fiM);
            intent.putExtra("pageType", 1);
            intent.putExtra("searchID", this.fjh.fdd);
            this.fjh.startActivity(intent);
            com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fjh.fdU, Integer.valueOf(1), Integer.valueOf(this.fjh.fiM), Integer.valueOf(0)});
        }
    };
    private OnClickListener fjc = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.fjh, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", this.fjh.fdU);
            intent.putExtra("extra_iconurl", this.fjh.fgm.gnp);
            intent.putExtra("extra_name", this.fjh.fgm.mqd);
            if (this.fjh.fgm.mqy != null) {
                intent.putExtra("name", this.fjh.fgm.mqy.gkB);
            }
            this.fjh.startActivity(intent);
        }
    };
    private i fjd = new i(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[]{str});
            if (bitmap != null) {
                this.fjh.jQ(1006);
            }
        }
    };
    private i fje = new i(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && this.fjh.mHandler != null) {
                Object obj;
                int intValue = ((Integer) objArr[0]).intValue();
                ak.yW();
                String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), this.fjh.fdU, str);
                String a = this.fjh.fdU;
                String str2 = ((alh) this.fjh.fgm.mqt.get(intValue)).mMg;
                com.tencent.mm.bd.a.getDensity(this.fjh.mContext);
                com.tencent.mm.storage.a.c a2 = EmojiLogic.a(a, 8, str2, true);
                f aeV = f.aeV();
                if (com.tencent.mm.a.e.aR(z)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int aQ = com.tencent.mm.a.e.aQ(z);
                    int i = aQ > 1024 ? 1024 : aQ;
                    Object c = com.tencent.mm.a.e.c(z, 0, aQ);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.c(z, 0, i), aeV.aeW().getBytes(), true, false);
                    if (be.bl(aesCryptEcb) || be.bl(c)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, c, 0, i);
                        i = com.tencent.mm.a.e.b(z, c, aQ);
                    }
                    if (i == 0) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 6, 1, false);
                        v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(c.length), Long.valueOf(r10)});
                        obj = 1;
                    } else {
                        v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 3, 1, false);
                        obj = null;
                    }
                } else {
                    v.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file do no exsit.");
                    obj = null;
                }
                if (a2 != null) {
                    if (obj != null) {
                        a2.field_reserved4 = com.tencent.mm.storage.a.c.nxh;
                    } else {
                        a2.field_reserved4 = 0;
                    }
                    final com.tencent.mm.storage.a.c cVar = a2;
                    final int i2 = intValue;
                    this.fjh.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass21 fji;

                        public final void run() {
                            SmileySubGrid q = this.fji.fjh.fit;
                            com.tencent.mm.storage.a.c cVar = cVar;
                            if (q.fnc == i2 && q.fnd) {
                                q.m(cVar);
                                return;
                            }
                            v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "not show:%d, needData: %B, so do not refresh", new Object[]{Integer.valueOf(r2), Boolean.valueOf(q.fnd)});
                        }
                    });
                    return;
                }
                v.i("MicroMsg.emoji.EmojiStoreDetailUI", "ignore no call back preview loader. ");
            }
        }
    };
    private j fjf = new j(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void am(long j) {
            com.tencent.mm.plugin.report.service.g.iuh.Y(10930, this.fjh.fdU + "," + j);
        }
    };
    private com.tencent.mm.pluginsdk.model.f.a fjg = new com.tencent.mm.pluginsdk.model.f.a(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void y(ArrayList<o> arrayList) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
            this.fjh.fiP = 12;
            if (arrayList != null && arrayList.size() > 0) {
                o oVar = (o) arrayList.get(0);
                if (oVar.lzM == 10232) {
                    this.fjh.fid = 4;
                    this.fjh.fiR = oVar.lzJ;
                } else {
                    this.fjh.fid = 10;
                    this.fjh.fiQ = oVar.lzM;
                }
                this.fjh.jQ(1002);
            }
        }
    };
    private Context mContext;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        {
            this.fjh = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(this.fjh);
                    return;
                case 1002:
                    this.fjh.agW();
                    return;
                case 1003:
                    this.fjh.agZ();
                    return;
                case 1004:
                    if (this.fjh.fir.getVisibility() == 0) {
                        this.fjh.fir.setVisibility(8);
                        this.fjh.fiv.setVisibility(0);
                        this.fjh.fiu.setVisibility(0);
                    }
                    this.fjh.eYR.setProgress(this.fjh.rT);
                    return;
                case 1005:
                    this.fjh.fim.scrollTo(0, 0);
                    return;
                case 1006:
                    this.fjh.cx(false);
                    return;
                case 1007:
                    this.fjh.agX();
                    return;
                default:
                    v.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    private int rT;

    class a extends BaseAdapter {
        final /* synthetic */ EmojiStoreDetailUI fjh;

        public a(EmojiStoreDetailUI emojiStoreDetailUI) {
            this.fjh = emojiStoreDetailUI;
        }

        public int getCount() {
            return this.fjh.fgm == null ? 0 : this.fjh.fgm.mqj;
        }

        public Object getItem(int i) {
            if (this.fjh.fgm == null || this.fjh.fgm.mqt == null || this.fjh.fgm.mqt.size() <= 0 || this.fjh.fgm.mqt.get(i) == null || ((alh) this.fjh.fgm.mqt.get(i)).mMg == null) {
                return null;
            }
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[]{Integer.valueOf(i)});
            String a = this.fjh.fdU;
            String str = ((alh) this.fjh.fgm.mqt.get(i)).mMg;
            com.tencent.mm.bd.a.getDensity(this.fjh.mContext);
            com.tencent.mm.storage.a.c a2 = EmojiLogic.a(a, 8, str, false);
            if (a2 == null) {
                v.d("MicroMsg.emoji.EmojiStoreDetailUI", "detail preview emoji is null.");
                com.tencent.mm.ae.n.GL().a(((alh) this.fjh.fgm.mqt.get(i)).mMg, null, com.tencent.mm.plugin.emoji.d.g.a(this.fjh.fdU, ((alh) this.fjh.fgm.mqt.get(i)).mMg, Integer.valueOf(i)), this.fjh.fje, this.fjh.fjf, null, null, null);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.Y(10930, this.fjh.fdU + ",0");
                if (f.aeV().aeX()) {
                    a2.field_reserved4 = com.tencent.mm.storage.a.c.nxh;
                }
            }
            jR(i);
            return a2;
        }

        private void jR(int i) {
            int[] iArr = new int[]{i - 1, i + 1, i - 4, i + 4};
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = iArr[i2];
                if (this.fjh.fgm != null && i3 >= 0 && i3 < this.fjh.fgm.mqs) {
                    ak.yW();
                    if (!com.tencent.mm.a.e.aR(EmojiLogic.z(com.tencent.mm.model.c.wY(), this.fjh.fdU, ((alh) this.fjh.fgm.mqt.get(i3)).mMg))) {
                        com.tencent.mm.ae.n.GL().a(((alh) this.fjh.fgm.mqt.get(i3)).mMg, null, com.tencent.mm.plugin.emoji.d.g.a(this.fjh.fdU, ((alh) this.fjh.fgm.mqt.get(i3)).mMg, Integer.valueOf(i3)), this.fjh.fje, this.fjh.fjf, null, null, null);
                    }
                }
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.fjh.mContext).inflate(2130903485, null);
                c cVar2 = new c(this.fjh, view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (this.fjh.fit.fne) {
                cVar.fjk.setBackgroundResource(2130839193);
            } else {
                cVar.fjk.setBackgroundDrawable(null);
            }
            String str = "";
            if (this.fjh.fgm.mqk != null) {
                str = m.a((arf) this.fjh.fgm.mqk.get(i));
            }
            com.tencent.mm.ae.n.GL().a(str, cVar.fjk, com.tencent.mm.plugin.emoji.d.g.bl(this.fjh.fdU, str));
            return view;
        }
    }

    class c {
        final /* synthetic */ EmojiStoreDetailUI fjh;
        SquareImageView fjk;

        public c(EmojiStoreDetailUI emojiStoreDetailUI, View view) {
            this.fjh = emojiStoreDetailUI;
            this.fjk = (SquareImageView) view.findViewById(2131756682);
            this.fjk.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    class b extends a {
        final /* synthetic */ EmojiStoreDetailUI fjh;
        private ArrayList<com.tencent.mm.storage.a.c> fjj;

        public final /* synthetic */ Object getItem(int i) {
            return jP(i);
        }

        public b(EmojiStoreDetailUI emojiStoreDetailUI) {
            this.fjh = emojiStoreDetailUI;
            super(emojiStoreDetailUI);
            this.fjj = new ArrayList();
            this.fjj = (ArrayList) com.tencent.mm.plugin.emoji.model.g.afx().fch.rj(com.tencent.mm.plugin.emoji.h.a.ail());
        }

        public final int getCount() {
            return this.fjj == null ? 0 : this.fjj.size();
        }

        private com.tencent.mm.storage.a.c jP(int i) {
            return this.fjj == null ? null : (com.tencent.mm.storage.a.c) this.fjj.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.fjh.mContext).inflate(2130903485, null);
                cVar = new c(this.fjh, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.fjk.setBackgroundResource(2130839193);
            com.tencent.mm.storage.a.c jP = jP(i);
            com.tencent.mm.ae.n.GL().a((be.kS(jP.pO()) ? jP.getName() : jP.pO()).split("\\.")[0], cVar.fjk, com.tencent.mm.plugin.emoji.d.g.aeY());
            return view;
        }
    }

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        if (!com.tencent.mm.plugin.emoji.h.a.rX(emojiStoreDetailUI.fdU)) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.g.afx().fci.Nz(emojiStoreDetailUI.fdU)) {
                if (com.tencent.mm.plugin.emoji.model.g.afx().fch.NB(emojiStoreDetailUI.fdU) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    File file = new File(stringBuilder.append(com.tencent.mm.model.c.wY()).append(emojiStoreDetailUI.fdU).toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            com.tencent.mm.plugin.emoji.model.g.afx().fci.NA(emojiStoreDetailUI.fdU);
                            com.tencent.mm.plugin.emoji.model.g.afx().fch.NH(emojiStoreDetailUI.fdU);
                        } else {
                            emojiStoreDetailUI.fij = true;
                            emojiStoreDetailUI.fid = 7;
                            emojiStoreDetailUI.agZ();
                            return;
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.g.afx().fch.NH(emojiStoreDetailUI.fdU);
            }
            emojiStoreDetailUI.fij = false;
        }
    }

    static /* synthetic */ void u(EmojiStoreDetailUI emojiStoreDetailUI) {
        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(emojiStoreDetailUI.mContext, com.tencent.mm.ui.widget.f.pbS, false);
        fVar.jXn = new com.tencent.mm.ui.base.n.c(emojiStoreDetailUI) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final void a(l lVar) {
                lVar.a(1001, this.fjh.getString(2131236669), 2131165344);
                lVar.a(BaseReportManager.MAX_READ_COUNT, this.fjh.getString(2131236668), 2131165334);
            }
        };
        fVar.jXo = new d(emojiStoreDetailUI) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case BaseReportManager.MAX_READ_COUNT /*1000*/:
                        com.tencent.mm.plugin.emoji.d.l.a(this.fjh.nDR.nEl, this.fjh.fgm.mqd + this.fjh.getString(2131232412), this.fjh.fgm.mqe, this.fjh.fgm.gnp, this.fjh.fgm.mqw, EmojiLogic.rs(this.fjh.fdU), 4);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(1), this.fjh.fdU, ""});
                        return;
                    case 1001:
                        com.tencent.mm.plugin.emoji.d.l.bB(this.fjh.nDR.nEl);
                        this.fjh.nDR.nEl.overridePendingTransition(2130968646, 2130968623);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(2), this.fjh.fdU, ""});
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", ""});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fiO = com.tencent.mm.model.k.xS();
        this.fdh = new com.tencent.mm.plugin.emoji.h.b(2003);
        Intent intent = getIntent();
        this.fdU = getIntent().getStringExtra("extra_id");
        this.ffU = getIntent().getIntExtra("preceding_scence", -1);
        this.fdV = getIntent().getStringExtra("extra_name");
        this.fhZ = getIntent().getIntExtra("call_by", -1);
        Object stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fdU = EmojiLogic.ro(stringExtra);
            this.ffU = 0;
            this.ffU = 10;
            com.tencent.mm.plugin.report.service.g.iuh.h(10993, new Object[]{Integer.valueOf(3), this.fdU});
        }
        if (TextUtils.isEmpty(this.fdU)) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.ffU == -1) {
            v.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.fiV = intent.getBooleanExtra("check_clickflag", true);
        this.fiN = intent.getStringExtra("cdn_client_id");
        this.fiM = intent.getIntExtra("download_entrance_scene", 0);
        this.fdd = intent.getLongExtra("searchID", 0);
        this.fde = be.ah(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mqn = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mql = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mqe = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mqg = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.fgm.mqh = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.fgm.mqi = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mqp = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgm.mqo = stringExtra;
        }
        if (this.fiO) {
            this.fiR = intent.getStringExtra("google_price");
            if (TextUtils.isEmpty(this.fiR)) {
                this.fiP = 11;
                com.tencent.mm.pluginsdk.model.f.a(this, this.fiS, this.fjg);
            }
        }
        this.fib = intent.getBooleanExtra("reward_tip", false);
        this.fiS[0] = this.fdU;
        this.fgm.mdM = this.fdU;
        this.fgm.mqd = this.fdV;
        this.fgm.mqv = this.fia;
        this.fgm.efl = -1;
        this.mContext = this;
        NI();
        if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU)) {
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            oh ohVar = new oh();
            ohVar.mdM = com.tencent.mm.storage.a.a.nwJ;
            ohVar.mqd = actionBarActivity.getString(2131232422);
            ohVar.mqe = actionBarActivity.getString(2131232420);
            ohVar.mqf = actionBarActivity.getString(2131232418);
            ohVar.mqg = "";
            ohVar.mqh = 0;
            ohVar.mqi = 1;
            ohVar.mql = "";
            ohVar.mqm = 0;
            ohVar.mqn = actionBarActivity.getString(2131232419);
            ohVar.mqq = "";
            ohVar.mqo = "";
            ohVar.mqp = "";
            ohVar.mqu = actionBarActivity.getString(2131232421);
            this.fgm = ohVar;
            this.fiX = true;
            this.fiW = EmojiLogic.afl();
            agV();
        } else {
            com.tencent.mm.storage.a.k NK = com.tencent.mm.plugin.emoji.model.g.afx().fcl.NK(this.fdU);
            if (!(NK == null || NK.field_content == null)) {
                vp vpVar = new vp();
                try {
                    vpVar.az(NK.field_content);
                    this.fgm = vpVar.myd;
                    this.fgn = NK.field_lan;
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmojiStoreDetailUI", "exception:%s", new Object[]{be.e(e)});
                }
            }
            if (this.fgm == null) {
                this.fie = new k(this.fdU, this.ffU);
            } else if (be.kS(this.fgn) || !this.fgn.equalsIgnoreCase(u.dJ(this.mContext))) {
                this.fie = new k(this.fdU, this.ffU);
            } else {
                this.fie = new k(this.fdU, this.ffU, this.fgm.efl);
            }
            ak.vy().a(this.fie, 0);
            if (this.fhZ == -1 || this.fhZ == 3) {
                this.fil.setVisibility(8);
                this.dZV.setVisibility(8);
                getString(2131231164);
                this.eZg = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ EmojiStoreDetailUI fjh;

                    {
                        this.fjh = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(this.fjh.fie);
                        this.fjh.fik.setText(2131232383);
                        this.fjh.agS();
                    }
                });
            }
            agT();
            if (this.fiV) {
                ak.vy().a(new com.tencent.mm.plugin.emoji.e.j(this.fdU), 0);
            } else {
                this.fiX = true;
                this.fiW = EmojiLogic.afl();
            }
        }
        agW();
        com.tencent.mm.plugin.emoji.model.g.afx().fci.c(this);
        com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
        ak.vy().a(423, this);
        ak.vy().a(822, this);
        e(this.fdU, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.fiN);
        this.fiY = true;
        com.tencent.mm.plugin.report.service.g.iuh.h(12740, new Object[]{Integer.valueOf(1), "", this.fdU, "", Integer.valueOf(this.fiM)});
        if (this.fib && this.fim != null) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ EmojiStoreDetailUI fjh;

                {
                    this.fjh = r1;
                }

                public final void run() {
                    this.fjh.fim.fullScroll(130);
                }
            }, 0);
        }
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903483;
    }

    protected final void NI() {
        if (!be.kS(this.fdV)) {
            Fd(this.fdV);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fjh.finish();
                return true;
            }
        });
        this.eTx = com.tencent.mm.bd.a.N(this.mContext, 2131493423);
        this.fiK = getResources().getDimensionPixelSize(2131493422);
        this.fiK = com.tencent.mm.bd.a.N(this.mContext, 2131493422);
        this.eZz = 4;
        this.fim = (EmojiDetailScrollView) findViewById(2131756513);
        this.dZV = findViewById(2131755597);
        this.fik = (TextView) this.dZV.findViewById(2131756681);
        this.fil = findViewById(2131756662);
        this.fin = (BannerEmojiView) findViewById(2131756663);
        this.fin.setMinimumHeight((int) (((float) (((this.fin.getRight() - this.fin.getLeft()) - this.fin.getPaddingRight()) - this.fin.getPaddingLeft())) * 0.56f));
        this.fio = (TextView) findViewById(2131756666);
        this.fip = (MMAutoSizeTextView) findViewById(2131756665);
        this.fiq = (TextView) findViewById(2131756678);
        this.fir = (TextView) findViewById(2131756668);
        this.fis = (TextView) findViewById(2131756673);
        this.fiy = com.tencent.mm.bd.a.dv(this.nDR.nEl);
        this.fiz = findViewById(2131756667);
        this.fit = (EmojiDetailGridView) findViewById(2131756675);
        if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU)) {
            this.fih = new b(this);
        } else {
            this.fih = new a(this);
        }
        this.fiv = findViewById(2131756669);
        this.eYR = (ProgressBar) findViewById(2131756670);
        this.fiu = (ImageView) findViewById(2131756671);
        this.fiu.setOnClickListener(this);
        this.fiv.setVisibility(8);
        this.fiu.setVisibility(8);
        this.eYR.setProgress(0);
        this.fit.setAdapter(this.fih);
        this.fit.setColumnWidth(this.fiK);
        this.fit.setNumColumns(this.eZz);
        this.fit.setHorizontalSpacing(this.eTx);
        this.fit.setVerticalSpacing(this.eTx);
        this.fit.fhI = this.fim;
        this.fit.fnb = true;
        this.fir.setOnClickListener(this);
        this.fiw = (TextView) findViewById(2131756679);
        this.fix = (TextView) findViewById(2131756680);
        this.fiw.setOnClickListener(this.fiZ);
        this.fix.setOnClickListener(this.fja);
        this.fiA = (ProgressBar) findViewById(2131756672);
        this.fiA.setVisibility(this.fiO ? 0 : 8);
        this.fiU = findViewById(2131756674);
        this.fiE = findViewById(2131756676);
        this.fiB = findViewById(2131756686);
        this.fiC = (ImageView) findViewById(2131756687);
        this.fiD = (TextView) findViewById(2131756688);
        this.fiF = findViewById(2131756677);
        this.fiG = (MMCopiableTextView) findViewById(2131756714);
        this.fiH = (Button) findViewById(2131756715);
        this.fiJ = (TextView) findViewById(2131756716);
        this.fiI = (DonorsAvatarView) findViewById(2131756717);
        this.fiH.setOnClickListener(this.fjb);
        this.fiJ.setOnClickListener(this.fjc);
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(412, this);
        ak.vy().a(521, this);
        this.fiT = false;
        if (!this.fiY) {
            agT();
            jQ(1007);
        }
        agU();
        this.fiY = false;
        jQ(1001);
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(412, this);
        ak.vy().b(521, this);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.g.afx().fci.d(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ffY);
        ak.vy().b(423, this);
        ak.vy().b(822, this);
        if (this.fit != null) {
            this.fit.release();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(DownloadInfo.STATUS, this.fid);
        bundle.putInt("progress", this.rT);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.fid = bundle.getInt(DownloadInfo.STATUS);
        this.rT = bundle.getInt("progress");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131756668) {
            String stringExtra;
            if (this.fid == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (be.kS(stringExtra) || !this.fic) {
                    this.fdh.q(this);
                    com.tencent.mm.plugin.report.service.g.iuh.h(12069, new Object[]{Integer.valueOf(2), this.fdU});
                } else {
                    com.tencent.mm.plugin.emoji.h.b.a(stringExtra, this.fdU, (Activity) this);
                }
                v.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                com.tencent.mm.plugin.report.service.g.iuh.Y(11076, "0, ");
                return;
            }
            switch (this.fid) {
                case -1:
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                case 0:
                case 3:
                    ahc();
                    this.fid = 6;
                    agZ();
                    com.tencent.mm.plugin.report.service.g.iuh.h(12066, new Object[]{Integer.valueOf(1), Integer.valueOf(this.fiM), "", this.fdU, Long.valueOf(this.fdd), this.fde});
                    return;
                case 4:
                    if (!this.fiT) {
                        v.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[]{this.fdU, this.fgm.mqg, this.fgm.mqp});
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.fdU);
                        if (this.fiO) {
                            intent.putExtra("key_currency_type", "");
                            intent.putExtra("key_price", this.fiR);
                        } else {
                            intent.putExtra("key_currency_type", this.fgm.mqp);
                            intent.putExtra("key_price", this.fgm.mqo);
                        }
                        com.tencent.mm.ay.c.b(this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        com.tencent.mm.plugin.report.service.g.iuh.h(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.fiM), "", this.fdU, Long.valueOf(this.fdd), this.fde});
                        this.fiT = true;
                        return;
                    }
                    return;
                case 5:
                    this.fid = 3;
                    agZ();
                    return;
                case 10:
                case 12:
                    switch (this.fiQ) {
                        case 10233:
                            stringExtra = getString(2131232348);
                            break;
                        case 10234:
                            stringExtra = getString(2131232344);
                            break;
                        case 10235:
                            stringExtra = getString(2131232438);
                            break;
                        default:
                            stringExtra = getString(2131232443);
                            break;
                    }
                    com.tencent.mm.ui.base.g.A(this, stringExtra, null);
                    return;
                case 11:
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                default:
                    v.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[]{Integer.valueOf(this.fid)});
                    return;
            }
        } else if (id == 2131756670) {
            ahb();
        } else if (id == 2131756671) {
            ahb();
        } else {
            v.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
        switch (kVar.getType()) {
            case 412:
                v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                k kVar2 = (k) kVar;
                if (kVar2 == null || be.kS(kVar2.fdU) || !kVar2.fdU.equalsIgnoreCase(this.fdU)) {
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0) {
                    if (i2 == 0) {
                        this.fgm = kVar2.afN();
                        jQ(1002);
                        return;
                    } else if (i2 == 1) {
                        agR();
                        return;
                    } else {
                        this.fik.setText(2131232382);
                        agS();
                        return;
                    }
                } else if (i2 == 5) {
                    if (!(kVar2 == null || kVar2.afN() == null)) {
                        this.fgm.mqi = kVar2.afN().mqi;
                    }
                    jQ(1002);
                    return;
                } else if (i2 == 1) {
                    agR();
                    return;
                } else {
                    this.fim.setVisibility(8);
                    this.dZV.setVisibility(0);
                    this.fik.setText(2131232383);
                    agS();
                    return;
                }
            case 423:
                v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                g gVar = (g) kVar;
                if (gVar == null || be.kS(gVar.fdU) || !gVar.fdU.equalsIgnoreCase(this.fdU)) {
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.fiN = gVar.cMU;
                    this.fid = 6;
                    agZ();
                    return;
                } else {
                    this.fid = -1;
                    agZ();
                    String str2 = this.fdV;
                    com.tencent.mm.ui.base.g.a(this, String.format(getString(2131232377), new Object[]{str2}), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ EmojiStoreDetailUI fjh;

                        {
                            this.fjh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.fjh.fif = new g(this.fjh.fdU, this.fjh.fdW, this.fjh.fdV);
                            this.fjh.ahc();
                            this.fjh.fid = 6;
                            this.fjh.agZ();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ EmojiStoreDetailUI fjh;

                        {
                            this.fjh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            case 521:
                v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                com.tencent.mm.plugin.emoji.e.j jVar = (com.tencent.mm.plugin.emoji.e.j) kVar;
                if (jVar == null || be.kS(jVar.fdK) || !jVar.fdK.equalsIgnoreCase(this.fdU)) {
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.fiW = (vn) jVar.cif.czl.czs;
                    } else {
                        this.fiW = null;
                    }
                    this.fiX = true;
                    aha();
                }
                this.fiX = true;
                aha();
                return;
            case 822:
                v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                if (i == 0 && i2 == 0) {
                    this.fii = ((n) kVar).afR();
                    jQ(1007);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void agR() {
        this.dZV.setVisibility(0);
        this.fil.setVisibility(8);
        this.fim.setVisibility(8);
        this.fik.setText(2131232347);
    }

    private void agS() {
        v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.fgm == null || this.fgm.mqi == 0) {
            this.dZV.setVisibility(0);
            this.fil.setVisibility(8);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String str;
        String stringExtra;
        if (i == 2001) {
            str = "";
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                v.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + intExtra);
                stringExtra = intent.getStringExtra("key_err_msg");
                v.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + stringExtra);
            } else {
                stringExtra = str;
                intExtra = 0;
            }
            this.fiT = false;
            if (i2 != -1) {
                this.fid = -1;
                agZ();
                if (com.tencent.mm.model.k.xS()) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 2, 1, false);
                }
            } else if (intent != null && r0 == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.fdU)) {
                    this.fid = -1;
                    agZ();
                    rC(stringExtra);
                    return;
                }
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    if (this.fdU.equals(stringArrayListExtra.get(i3))) {
                        this.fdW = (String) stringArrayListExtra2.get(i3);
                    }
                }
                this.fgm.mqi = 1;
                ahc();
                this.fid = 6;
                com.tencent.mm.ui.base.g.bf(this, stringExtra);
                if (com.tencent.mm.model.k.xS()) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 4, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 0, 1, false);
                }
            } else if (intent != null && r0 == 103) {
                ahc();
                this.fid = 6;
                this.fih.notifyDataSetChanged();
                if (com.tencent.mm.model.k.xS()) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 7, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 3, 1, false);
                }
            } else if (intent == null || r0 != 100000000) {
                this.fid = -1;
                agZ();
                rC(stringExtra);
                if (com.tencent.mm.model.k.xS()) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 5, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 1, 1, false);
                }
            } else {
                this.fid = -1;
                agZ();
                if (com.tencent.mm.model.k.xS()) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(166, 2, 1, false);
                }
            }
        } else if (i == 2002) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                if (!be.kS(stringExtra)) {
                    v.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + stringExtra);
                    String str2 = this.fdU;
                    String str3 = this.fgm.mqd;
                    String str4 = this.fgm.mqe;
                    String str5 = this.fgm.gnp;
                    String str6 = this.fgm.mqw;
                    int i4 = this.fgm.mqi;
                    str = new StringBuffer(getResources().getString(2131231033)).append(str3).toString();
                    com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(this);
                    cVar.ba(stringExtra).Hw(str).tS(2131231149);
                    cVar.Hx(str5).bpi();
                    cVar.Hz(getString(2131231976)).a(new com.tencent.mm.plugin.emoji.d.l.AnonymousClass1(stringExtra, str2, str3, str4, str5, str6, i4, this)).iji.show();
                }
            }
        } else if (i == this.fdh.dRo && i2 == -1) {
            v.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[]{intent.getStringExtra("Select_Conv_User")});
            com.tencent.mm.plugin.emoji.h.b.a(intent, this.fdU, (Activity) this);
            com.tencent.mm.plugin.report.service.g.iuh.h(12069, new Object[]{Integer.valueOf(3), this.fdU});
        }
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        jQ(1001);
    }

    private void rC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(2131232352);
        }
        com.tencent.mm.ui.base.g.a(this, str, "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void agT() {
        this.fii = com.tencent.mm.plugin.emoji.model.g.afx().fcm.NL(this.fdU);
    }

    private void agU() {
        if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqi, 64) && com.tencent.mm.plugin.emoji.d.o.afj()) {
            this.fig = new n(this.fdU, n.fep);
            ak.vy().a(this.fig, 0);
        }
    }

    private boolean agV() {
        boolean agV = com.tencent.mm.plugin.emoji.h.a.agV();
        this.fij = agV;
        this.fid = agV ? 7 : 3;
        return agV;
    }

    private void agW() {
        if (!be.kS(this.fgm.mqd)) {
            Fd(this.fgm.mqd);
        }
        v.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[]{this.fgm.mqq});
        this.fil.setVisibility(0);
        this.dZV.setVisibility(8);
        cx(true);
        this.fip.setText(this.fgm.mqd);
        this.fiq.setText(this.fgm.mqn);
        this.fis.setText(this.fgm.mqe);
        if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqh, 1)) {
            this.fio.setVisibility(8);
        } else {
            this.fio.setVisibility(0);
            this.fio.setText(2131232442);
        }
        agY();
        agZ();
        aha();
        if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU) || !(this.fgm.mqt == null || this.fgm.mqt.size() <= 0 || ((alh) this.fgm.mqt.get(0)).mMg == null)) {
            this.fit.fne = true;
            this.fiU.setVisibility(0);
        } else {
            this.fiU.setVisibility(8);
            this.fit.fne = false;
        }
        this.fit.fdU = this.fdU;
        if (this.fih != null) {
            this.fih.notifyDataSetInvalidated();
        }
        v.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[]{this.fgm.mqi});
        if ((this.fgm.mqi & 16) == 16) {
            a(0, 2131165801, new OnMenuItemClickListener(this) {
                final /* synthetic */ EmojiStoreDetailUI fjh;

                {
                    this.fjh = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    v.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
                    EmojiStoreDetailUI.u(this.fjh);
                    return true;
                }
            });
        }
        this.fip.setMaxWidth((((this.fiy - this.fiz.getWidth()) - (com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493168) * 2)) - this.fio.getWidth()) - (com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493143) * 2));
        this.fip.setVisibility(8);
        this.fip.setVisibility(0);
        if (this.fgm.mqy == null || this.fgm.mqy.mxS == 0 || this.fiM == 6) {
            this.fiE.setVisibility(8);
            this.fiB.setVisibility(8);
        } else {
            this.fiE.setVisibility(0);
            this.fiB.setVisibility(0);
            com.tencent.mm.ae.n.GL().a(this.fgm.mqy.mqz, this.fiC, com.tencent.mm.plugin.emoji.d.g.bm(this.fdU, this.fgm.mqy.mqz));
            this.fiD.setText(this.fgm.mqy.gkB);
            this.fiB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EmojiStoreDetailUI fjh;

                {
                    this.fjh = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(this.fjh.nDR.nEl, EmojiStoreV2DesignerUI.class);
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, this.fjh.fgm.mqy.mxS);
                    intent.putExtra("name", this.fjh.fgm.mqy.gkB);
                    intent.putExtra("headurl", this.fjh.fgm.mqy.mqz);
                    intent.putExtra("rediret_url", this.fjh.fgm.mqw);
                    intent.putExtra("searchID", this.fjh.fdd);
                    intent.putExtra("extra_scence", 26);
                    this.fjh.nDR.nEl.startActivity(intent);
                }
            });
        }
        LayoutParams layoutParams;
        if ((this.fgm.mqi & 32) == 32) {
            layoutParams = (LayoutParams) this.fix.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.fiw.getLayoutParams();
            this.fix.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493168);
            this.fix.setLayoutParams(layoutParams);
            this.fix.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493168);
            this.fiw.setLayoutParams(layoutParams2);
            this.fiw.setGravity(5);
        } else {
            layoutParams = (LayoutParams) this.fiw.getLayoutParams();
            layoutParams.gravity = 17;
            this.fiw.setLayoutParams(layoutParams);
            this.fiw.setGravity(17);
            this.fix.setVisibility(8);
        }
        agX();
    }

    private void cx(boolean z) {
        com.tencent.mm.storage.a.c cVar;
        if (be.kS(this.fgm.mql)) {
            cVar = null;
        } else if (z) {
            r0 = this.fdU;
            String str = this.fgm.mql;
            com.tencent.mm.bd.a.getDensity(this.mContext);
            cVar = EmojiLogic.a(r0, str, this.fjd);
        } else {
            r0 = this.fdU;
            String str2 = this.fgm.mql;
            com.tencent.mm.bd.a.getDensity(this.mContext);
            cVar = EmojiLogic.a(r0, 4, str2, true);
        }
        if (!(cVar == null || this.fin == null)) {
            this.fin.bN(cVar.dR(cVar.field_groupId, cVar.EB()), null);
        }
        if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU)) {
            this.fin.setImageResource(2130839351);
        }
    }

    public final void agX() {
        if (!com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqi, 64) || !com.tencent.mm.plugin.emoji.d.o.afj()) {
            this.fiF.setVisibility(8);
        } else if (this.fii != null) {
            this.fiF.setVisibility(0);
            this.fiH.setText(2131232395);
            this.fiG.setText(this.fii.myv.mqC);
            this.fiG.setLongClickable(false);
            if (this.fii.mye > 0) {
                this.fiJ.setVisibility(0);
                String valueOf = String.valueOf(this.fii.mye);
                Object format = String.format(getString(2131232398), new Object[]{Integer.valueOf(this.fii.mye)});
                CharSequence spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131689687)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.fiJ.setText(spannableString);
            } else {
                this.fiJ.setVisibility(8);
            }
            if (this.fii.myf == null || this.fii.myf.size() <= 0) {
                this.fiI.setVisibility(8);
                return;
            }
            this.fiI.setVisibility(0);
            this.fiI.b(this.fdU, this.fii.myf);
        } else {
            this.fiF.setVisibility(8);
            agU();
        }
    }

    private void agY() {
        if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqh, 8)) {
            this.fiL = 0;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqh, 4)) {
            this.fiL = 0;
        } else if (this.fiO || !TextUtils.isEmpty(this.fgm.mqg)) {
            this.fiL = 1;
        } else {
            this.fiL = 0;
        }
        v.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[]{Integer.valueOf(this.fgm.mqi)});
        if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqi, 8) && com.tencent.mm.plugin.emoji.a.a.e.jL(this.fgm.mqh)) {
            this.fid = 8;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqi, 1) || com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqh, 8)) {
            this.fid = 3;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.jL(this.fgm.mqh)) {
            this.fid = 0;
        } else if (!this.fiO && (TextUtils.isEmpty(this.fgm.mqo) || this.fgm.mqo.equals("0"))) {
            this.fid = 0;
        } else if (!this.fiO) {
            this.fid = 4;
        } else if (TextUtils.isEmpty(this.fiR)) {
            this.fid = this.fiP;
        } else {
            this.fid = 4;
        }
        if (this.fij) {
            this.fid = 7;
        }
    }

    private void agZ() {
        while (true) {
            if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU)) {
                agV();
            }
            switch (this.fid) {
                case -1:
                    agY();
                case 0:
                    this.fiA.setVisibility(8);
                    this.fir.setTextColor(getResources().getColorStateList(2131690182));
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setText(2131232376);
                    this.fir.setEnabled(true);
                    return;
                case 3:
                    this.fiA.setVisibility(8);
                    this.fir.setTextColor(getResources().getColorStateList(2131690182));
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setText(2131232376);
                    this.fir.setEnabled(true);
                    return;
                case 4:
                    this.fiA.setVisibility(8);
                    this.fir.setTextColor(getResources().getColorStateList(2131690182));
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setEnabled(true);
                    if (!this.fiO) {
                        this.fir.setText(this.fgm.mqg);
                        this.fid = 4;
                        return;
                    } else if (be.kS(this.fiR)) {
                        this.fir.setText("");
                        return;
                    } else {
                        this.fir.setText(this.fiR);
                        return;
                    }
                case 5:
                    this.fiA.setVisibility(8);
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setText(2131232376);
                    this.fir.setEnabled(true);
                    break;
                case 6:
                    this.fiA.setVisibility(8);
                    this.fir.setEnabled(false);
                    this.fiv.setVisibility(0);
                    this.fiu.setVisibility(0);
                    this.fir.setVisibility(4);
                    if (this.fhZ == 3) {
                        return;
                    }
                    return;
                case 7:
                    this.fiA.setVisibility(8);
                    this.fir.setEnabled(true);
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setText(2131232425);
                    this.fiv.setVisibility(8);
                    this.eYR.setProgress(0);
                    this.fiu.setVisibility(4);
                    this.fir.setVisibility(0);
                    if (this.fhZ == 3) {
                        return;
                    }
                    return;
                case 8:
                    this.fiA.setVisibility(8);
                    this.fir.setTextColor(getResources().getColorStateList(2131689683));
                    this.fir.setBackgroundResource(2130837802);
                    this.fir.setText(2131232379);
                    this.fir.setEnabled(false);
                    return;
                case 10:
                case 12:
                    this.fiA.setVisibility(8);
                    this.fir.setVisibility(0);
                    this.fir.setBackgroundResource(2130837799);
                    this.fir.setText(2131232390);
                    this.fir.setEnabled(true);
                    this.fiv.setVisibility(8);
                    this.eYR.setProgress(0);
                    this.fiu.setVisibility(4);
                    return;
                case 11:
                    break;
                default:
                    v.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[]{Integer.valueOf(this.fid)});
                    return;
            }
            this.fiA.setVisibility(0);
            this.fir.setVisibility(0);
            this.fir.setBackgroundResource(2130839565);
            this.fir.setText("");
            this.fir.setEnabled(false);
            this.fiv.setVisibility(8);
            this.eYR.setProgress(0);
            this.fiu.setVisibility(4);
            return;
        }
    }

    private void aha() {
        if (!this.fiX) {
            return;
        }
        if (this.fiW != null && (this.fiW.myc & 1) == 1) {
            return;
        }
        if ((this.fgm == null || !com.tencent.mm.plugin.emoji.a.a.e.bx(this.fgm.mqi, 1)) && this.fiW != null && !TextUtils.isEmpty(this.fiW.myb)) {
            this.fir.setText(this.fiW.myb);
            this.fir.setTextColor(this.nDR.nEl.getResources().getColor(2131689781));
            this.fir.setBackgroundDrawable(null);
            this.fir.setEnabled(false);
        }
    }

    private void ahb() {
        com.tencent.mm.ui.base.g.a(this, 2131232369, 0, 2131232413, 2131232371, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (com.tencent.mm.plugin.emoji.h.a.rX(this.fjh.fdU)) {
                    v.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                    com.tencent.mm.plugin.emoji.e.a.afC().afE();
                } else {
                    ak.vy().c(this.fjh.fif);
                }
                if (!TextUtils.isEmpty(this.fjh.fiN)) {
                    com.tencent.mm.modelcdntran.g.DZ().iq(this.fjh.fiN);
                    v.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[]{this.fjh.fiN});
                }
                if (com.tencent.mm.plugin.emoji.a.a.e.bx(this.fjh.fgm.mqi, 1) || com.tencent.mm.plugin.emoji.a.a.e.jL(this.fjh.fgm.mqh)) {
                    this.fjh.fid = 3;
                } else {
                    this.fjh.fid = -1;
                }
                com.tencent.mm.plugin.emoji.model.g.afz().d(this.fjh.fdU, this.fjh.fid, 0, this.fjh.fiN);
                this.fjh.fiv.setVisibility(8);
                this.fjh.eYR.setProgress(0);
                this.fjh.fiu.setVisibility(4);
                this.fjh.fir.setVisibility(0);
                this.fjh.agZ();
                ak.vy().a(new p(this.fjh.fdU, 2), 0);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreDetailUI fjh;

            {
                this.fjh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void e(String str, int i, int i2, String str2) {
        v.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (!be.kS(str) && str.equals(this.fdU)) {
            if (!TextUtils.isEmpty(str2)) {
                this.fiN = str2;
            }
            if (i == -1) {
                if (this.fid != -1) {
                    this.fid = -1;
                    jQ(1003);
                }
            } else if (i == 7) {
                this.fid = 7;
                jQ(1003);
            } else if (i != 6) {
                v.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
            } else if (!TextUtils.isEmpty(str) && str.equals(this.fdU)) {
                this.fid = 6;
                this.rT = i2;
                jQ(1004);
            }
        }
    }

    private void ahc() {
        if (com.tencent.mm.plugin.emoji.h.a.rX(this.fdU)) {
            com.tencent.mm.plugin.emoji.e.a.afC();
            com.tencent.mm.plugin.emoji.e.a.afD();
            return;
        }
        this.fif = new g(this.fdU, this.fdW, this.fdV);
        ak.vy().a(this.fif, 0);
        switch (this.ffU) {
            case 9:
                com.tencent.mm.plugin.report.service.g.iuh.h(11598, new Object[]{Integer.valueOf(2), this.fdU});
                return;
            case 10:
                com.tencent.mm.plugin.report.service.g.iuh.h(11598, new Object[]{Integer.valueOf(1), this.fdU});
                return;
            case 11:
                com.tencent.mm.plugin.report.service.g.iuh.h(11598, new Object[]{Integer.valueOf(3), this.fdU});
                return;
            default:
                return;
        }
    }

    public final void jQ(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
    }
}
