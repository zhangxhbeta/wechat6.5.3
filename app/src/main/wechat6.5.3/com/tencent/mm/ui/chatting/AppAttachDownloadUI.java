package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppAttachDownloadUI extends MMActivity implements a, g.a, e {
    private String aST;
    private long bao;
    private String bhM;
    private String bhP;
    private String blu;
    private at bmk;
    private String cop;
    private String dCf;
    private ProgressBar elJ;
    private Button fQE;
    private View fQI;
    private f ffv;
    private Button gbX;
    private MMImageView icy;
    private ImageView icz;
    private int lAU;
    private String mediaId;
    private TextView nOf;
    private boolean nQK;
    private View ojm;
    private TextView ojn;
    private TextView ojo;
    private aa ojp;
    private com.tencent.mm.q.a.a ojq;
    private boolean ojr = false;
    private boolean ojs = false;
    private boolean ojt = true;
    private int oju = 5000;
    private LinearLayout ojv;
    private LinearLayout ojw;

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (z) {
            b cpVar = new cp();
            cpVar.bay.bao = appAttachDownloadUI.bao;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            switch (appAttachDownloadUI.lAU) {
                case 0:
                    arrayList.add(appAttachDownloadUI.getString(2131234555));
                    arrayList.add(appAttachDownloadUI.getString(2131232298));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    arrayList2.add(Integer.valueOf(3));
                    if (cpVar.baz.aZW) {
                        arrayList.add(appAttachDownloadUI.getString(2131232303));
                        arrayList2.add(Integer.valueOf(4));
                        break;
                    }
                    break;
                case 6:
                    arrayList.add(appAttachDownloadUI.getString(2131234555));
                    arrayList.add(appAttachDownloadUI.getString(2131232298));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    Long FZ = com.tencent.mm.pluginsdk.b.a.FZ(appAttachDownloadUI.dCf);
                    if (cpVar.baz.aZW || (FZ != null && com.tencent.mm.pluginsdk.model.app.g.l(appAttachDownloadUI.nDR.nEl, FZ.longValue()))) {
                        arrayList.add(appAttachDownloadUI.getString(2131232303));
                        arrayList2.add(Integer.valueOf(4));
                    }
                    if (c.EH("favorite")) {
                        arrayList.add(appAttachDownloadUI.getString(2131234180));
                        arrayList2.add(Integer.valueOf(2));
                        break;
                    }
                    break;
                default:
                    arrayList.add(appAttachDownloadUI.getString(2131234555));
                    arrayList2.add(Integer.valueOf(0));
                    break;
            }
        } else if (c.EH("favorite")) {
            arrayList.add(appAttachDownloadUI.getString(2131234180));
            arrayList2.add(Integer.valueOf(2));
        }
        com.tencent.mm.ui.base.g.a((Context) appAttachDownloadUI, null, arrayList, arrayList2, null, false, new d(appAttachDownloadUI) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final void bw(int i, int i2) {
                switch (i2) {
                    case 0:
                        AppAttachDownloadUI.c(this.ojx);
                        return;
                    case 2:
                        AppAttachDownloadUI.d(this.ojx);
                        return;
                    case 3:
                        AppAttachDownloadUI.e(this.ojx);
                        return;
                    case 4:
                        AppAttachDownloadUI.f(this.ojx);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void c(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z = false;
        if (appAttachDownloadUI.ojq != null && (appAttachDownloadUI.ojq.cof != 0 || appAttachDownloadUI.ojq.cob > 26214400)) {
            z = true;
        }
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.blu);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.bmk.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void d(AppAttachDownloadUI appAttachDownloadUI) {
        bp bpVar = new bp();
        com.tencent.mm.pluginsdk.model.d.a(bpVar, appAttachDownloadUI.bmk);
        bpVar.aZd.aXH = appAttachDownloadUI;
        bpVar.aZd.aZl = 39;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        com.tencent.mm.plugin.report.service.g.iuh.h(11168, Integer.valueOf(6), Integer.valueOf(1));
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.bmk.field_msgId);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void q(AppAttachDownloadUI appAttachDownloadUI) {
        com.tencent.mm.pluginsdk.model.app.b bDH = appAttachDownloadUI.bDH();
        if (bDH == null) {
            v.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
        } else if (bDH.field_fileFullPath == null || bDH.field_fileFullPath.length() == 0) {
            v.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.c(appAttachDownloadUI, bDH.field_fileFullPath, appAttachDownloadUI.dCf, 1);
            appAttachDownloadUI.fQE.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        boolean z;
        boolean z2 = false;
        vD(2131232307);
        this.bao = getIntent().getLongExtra("app_msg_id", -1);
        if (this.bao == -1) {
            z = false;
        } else {
            ak.yW();
            this.bmk = com.tencent.mm.model.c.wJ().ek(this.bao);
            if (this.bmk == null || this.bmk.field_msgId == 0 || this.bmk.field_content == null) {
                z = false;
            } else {
                this.nQK = m.dE(this.bmk.field_talker);
                this.blu = this.bmk.field_content;
                if (this.nQK && this.bmk.field_isSend == 0) {
                    String str = this.bmk.field_content;
                    if (this.nQK && str != null) {
                        str = aw.fM(str);
                    }
                    this.blu = str;
                }
                this.ojq = com.tencent.mm.q.a.a.dV(this.blu);
                if (this.ojq == null) {
                    v.e("MicroMsg.AppAttachDownloadUI", "summerbig parse msgContent error, %s", this.blu);
                    z = false;
                } else {
                    File file;
                    if (t.kS(this.ojq.aXa) && !t.kS(this.ojq.coi)) {
                        v.e("MicroMsg.AppAttachDownloadUI", "summerbig msgContent format error, %s", this.blu);
                        this.ojq.aXa = this.ojq.coi.hashCode();
                    }
                    this.lAU = this.ojq.type;
                    this.mediaId = this.ojq.aXa;
                    this.aST = t.ma(this.ojq.title);
                    this.dCf = t.ma(this.ojq.coc).toLowerCase();
                    this.bhP = t.ma(this.ojq.filemd5);
                    this.bhM = t.ma(this.ojq.bhM);
                    this.cop = t.ma(this.ojq.cop);
                    v.i("MicroMsg.AppAttachDownloadUI", "summerbig initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", Long.valueOf(this.bao), Integer.valueOf(this.bmk.field_isSend), this.blu, Integer.valueOf(this.lAU), this.mediaId, this.aST);
                    com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
                    if (bDH == null) {
                        v.i("MicroMsg.AppAttachDownloadUI", "summerbig initParams attInfo is null");
                        this.ojs = false;
                    } else {
                        file = new File(bDH.field_fileFullPath);
                        if (bDH.field_offset > 0) {
                            this.ojs = true;
                        } else {
                            this.ojs = false;
                        }
                        v.i("MicroMsg.AppAttachDownloadUI", "summerbig initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", bDH.field_fileFullPath, Long.valueOf(bDH.field_offset), Boolean.valueOf(this.ojs));
                    }
                    if (bDH != null) {
                        file = new File(bDH.field_fileFullPath);
                        if (file.exists() && file.length() == bDH.field_totalLen) {
                            z2 = true;
                        }
                    }
                    z = z2 ? com.tencent.mm.pluginsdk.ui.tools.a.b(this, bDH.field_fileFullPath, this.dCf, 1) : true;
                }
            }
        }
        if (z) {
            File file2 = new File(com.tencent.mm.compatible.util.e.cge);
            if (!file2.exists()) {
                file2.mkdir();
            }
            am.Wf().c(this);
            NI();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        am.Wf().d(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(221, (e) this);
        ak.vy().a(728, (e) this);
        b jrVar = new jr();
        jrVar.bkd.bke = true;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, getMainLooper());
        v.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.fQE.setEnabled(true);
    }

    protected void onPause() {
        ak.vy().b(221, (e) this);
        ak.vy().b(728, (e) this);
        super.onPause();
        b jrVar = new jr();
        jrVar.bkd.bke = false;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, getMainLooper());
        v.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void NI() {
        this.icy = (MMImageView) findViewById(2131755470);
        this.fQI = findViewById(2131755471);
        this.elJ = (ProgressBar) findViewById(2131755472);
        this.icz = (ImageView) findViewById(2131755473);
        this.gbX = (Button) findViewById(2131756618);
        this.fQE = (Button) findViewById(2131756619);
        this.ojm = findViewById(2131756620);
        this.nOf = (TextView) findViewById(2131756622);
        this.ojn = (TextView) findViewById(2131756621);
        this.ojo = (TextView) findViewById(2131756617);
        this.ojv = (LinearLayout) findViewById(2131756616);
        this.ojw = (LinearLayout) findViewById(2131756623);
        this.icz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final void onClick(View view) {
                this.ojx.fQI.setVisibility(8);
                this.ojx.gbX.setVisibility(0);
                this.ojx.ojm.setVisibility(8);
                v.i("MicroMsg.AppAttachDownloadUI", "summerbig stopBtn downloadAppAttachScene[%s]", this.ojx.ojp);
                if (this.ojx.ojp != null) {
                    aa a = this.ojx.ojp;
                    a aVar = this.ojx;
                    if (!a.lAL) {
                        com.tencent.mm.modelcdntran.g.DZ().iq(a.cMU);
                        a.lAG = am.Wf().Gu(a.mediaId);
                    }
                    v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", aVar, a.lAG, Boolean.valueOf(a.lAL), be.bur());
                    if (a.lAG != null) {
                        if (a.lAG.field_status == 101 && aVar != null) {
                            aVar.bnw();
                        }
                        a.lAG.field_status = 102;
                        if (!a.lAL) {
                            am.Wf().a(a.lAG, new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.tencent.mm.sdk.h.c k = this.ojx.bDH();
                if (k != null && k.field_status != 199) {
                    v.i("MicroMsg.AppAttachDownloadUI", "summerbig stopBtn onClick but scene is null and set status[%d] paused", Long.valueOf(k.field_status));
                    k.field_status = 102;
                    am.Wf().a(k, new String[0]);
                }
            }
        });
        this.gbX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final void onClick(View view) {
                this.ojx.fQI.setVisibility(0);
                this.ojx.gbX.setVisibility(8);
                this.ojx.ojm.setVisibility(0);
                if (this.ojx.bDG()) {
                    com.tencent.mm.sdk.h.c k = this.ojx.bDH();
                    if (k != null) {
                        k.field_status = 101;
                        k.field_lastModifyTime = be.Nh();
                        am.Wf().a(k, new String[0]);
                    }
                    this.ojx.ojp = new aa(this.ojx.bao, this.ojx.mediaId, this.ojx.ffv);
                    ak.vy().a(this.ojx.ojp, 0);
                }
            }
        });
        this.fQE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final void onClick(View view) {
                this.ojx.ojt = true;
                AppAttachDownloadUI.q(this.ojx);
            }
        });
        switch (this.lAU) {
            case 0:
            case 7:
                if (!be.KY(this.dCf)) {
                    this.icy.setImageResource(2131165241);
                    break;
                } else {
                    this.icy.setImageResource(2130837647);
                    break;
                }
            case 2:
                this.icy.setImageResource(2130837647);
                break;
            case 4:
                this.icy.setImageResource(2131165244);
                break;
            case 6:
                this.icy.setImageResource(p.Gt(this.dCf));
                break;
            default:
                this.icy.setImageResource(2131165241);
                break;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ojx.ojp != null) {
                    ak.vy().c(this.ojx.ojp);
                }
                this.ojx.finish();
                return true;
            }
        });
        a(0, 2131165201, new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI ojx;

            {
                this.ojx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppAttachDownloadUI.a(this.ojx, this.ojx.ojr);
                return false;
            }
        });
        this.ojr = false;
        com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
        boolean z = (bDH == null || !new File(bDH.field_fileFullPath).exists()) ? false : bDH.bnj() || (this.bmk.field_isSend == 1 && bDH.field_isUpload);
        if (z) {
            v.i("MicroMsg.AppAttachDownloadUI", "summerbig isCanOpenFile");
            this.ojr = true;
            bDI();
        } else if (bDH != null && bDH.bnj() && !new File(bDH.field_fileFullPath).exists()) {
            v.i("MicroMsg.AppAttachDownloadUI", "summerbig set fail info[%s]", bDH);
            this.ojv.setVisibility(8);
            this.ojw.setVisibility(0);
        } else if (!this.ojr) {
            this.ffv = new f(this) {
                final /* synthetic */ AppAttachDownloadUI ojx;

                {
                    this.ojx = r1;
                }

                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    if (i < i2 && this.ojx.fQI.getVisibility() != 0) {
                        this.ojx.fQI.setVisibility(0);
                        this.ojx.gbX.setVisibility(8);
                        this.ojx.ojm.setVisibility(0);
                    }
                    this.ojx.elJ.setProgress((int) f);
                }
            };
            switch (this.lAU) {
                case 0:
                case 6:
                    if (this.ojs) {
                        this.gbX.setVisibility(0);
                    } else {
                        this.gbX.setVisibility(8);
                    }
                    this.fQI.setVisibility(8);
                    this.ojm.setVisibility(8);
                    this.fQE.setVisibility(8);
                    this.nOf.setVisibility(8);
                    this.ojo.setVisibility(0);
                    if (this.aST.equals(SQLiteDatabase.KeyEmpty)) {
                        this.ojo.setText(getString(2131234136));
                    } else {
                        this.ojo.setText(this.aST);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals(SQLiteDatabase.KeyEmpty)) {
                        this.nOf.setText(getString(2131232293));
                    } else {
                        this.nOf.setText(getString(2131232294));
                    }
                    if (be.KY(this.dCf)) {
                        this.nOf.setVisibility(8);
                        break;
                    }
                    break;
                case 2:
                    this.fQI.setVisibility(0);
                    this.ojm.setVisibility(0);
                    this.gbX.setVisibility(8);
                    this.fQE.setVisibility(8);
                    this.ojo.setVisibility(8);
                    this.nOf.setVisibility(8);
                    if (bDG()) {
                        this.ojp = new aa(this.bao, this.mediaId, this.ffv);
                        ak.vy().a(this.ojp, 0);
                        break;
                    }
                    break;
                case 7:
                    if (this.ojs) {
                        this.gbX.setVisibility(0);
                    } else {
                        this.gbX.setVisibility(8);
                    }
                    this.fQI.setVisibility(8);
                    this.ojm.setVisibility(8);
                    this.fQE.setVisibility(8);
                    this.ojo.setVisibility(8);
                    this.nOf.setVisibility(8);
                    this.nOf.setText(getString(2131232294));
                    break;
            }
            v.i("MicroMsg.AppAttachDownloadUI", "summerbig progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", this.ffv, Boolean.valueOf(this.ojr), Boolean.valueOf(this.ojs));
            if (!this.ojr && !this.ojs) {
                this.fQI.setVisibility(0);
                this.gbX.setVisibility(8);
                this.ojm.setVisibility(0);
                if (bDG()) {
                    this.ojp = new aa(this.bao, this.mediaId, this.ffv);
                    ak.vy().a(this.ojp, 0);
                }
            }
        }
    }

    private boolean bDG() {
        com.tencent.mm.pluginsdk.model.app.b bVar;
        boolean z;
        int i = -1;
        com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
        String str;
        if (bDH == null) {
            l.b(this.bao, this.blu, null);
            bDH = bDH();
            if (bDH != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(bDH.nmb);
                objArr[1] = Long.valueOf(bDH.field_totalLen);
                objArr[2] = bDH.field_fileFullPath;
                objArr[3] = Long.valueOf(bDH.field_type);
                objArr[4] = bDH.field_mediaId;
                objArr[5] = Long.valueOf(bDH.field_msgInfoId);
                objArr[6] = Boolean.valueOf(bDH.field_isUpload);
                if (bDH.field_signature != null) {
                    i = bDH.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                v.i(str2, str, objArr);
                if (this.ojq.cof != 0 || this.ojq.cob > 26214400) {
                    boolean z2;
                    if (t.kS(bDH.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    bVar = bDH;
                    z = z2;
                }
            }
            z = true;
            bVar = bDH;
        } else {
            File file = new File(bDH.field_fileFullPath);
            if (bDH.field_status == 199 && !file.exists()) {
                v.i("MicroMsg.AppAttachDownloadUI", "summerbig tryInitAttachInfo info exist but file not!");
                l.b(this.bao, this.blu, null);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(bDH.nmb);
            objArr2[1] = Long.valueOf(bDH.field_totalLen);
            objArr2[2] = bDH.field_fileFullPath;
            objArr2[3] = Long.valueOf(bDH.field_type);
            objArr2[4] = bDH.field_mediaId;
            objArr2[5] = Long.valueOf(bDH.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(bDH.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(bDH.field_status);
            if (bDH.field_signature != null) {
                i = bDH.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            v.i(str, str3, objArr2);
            z = true;
            bVar = bDH;
        }
        if (!z) {
            ak.vy().a(new x(bVar, this.cop, this.bhP, this.aST, this.dCf, this.bhM), 0);
        }
        return z;
    }

    private String getMimeType() {
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.blu);
        String str = null;
        if (dV.coc != null && dV.coc.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(dV.coc);
        }
        if (str != null && str.length() != 0) {
            return str;
        }
        v.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + dV.coc;
    }

    private com.tencent.mm.pluginsdk.model.app.b bDH() {
        com.tencent.mm.pluginsdk.model.app.b GD = l.GD(this.mediaId);
        if (GD == null) {
            GD = am.Wf().dy(this.bao);
        }
        if (GD != null) {
            v.i("MicroMsg.AppAttachDownloadUI", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", GD, Long.valueOf(GD.nmb), Boolean.valueOf(GD.field_isUpload), GD.field_fileFullPath, Long.valueOf(GD.field_totalLen), Long.valueOf(GD.field_offset), GD.field_mediaSvrId, GD.field_mediaId, Long.valueOf(GD.field_msgInfoId), Long.valueOf(GD.field_type), t.Nm());
        } else {
            v.w("MicroMsg.AppAttachDownloadUI", "summerbig getAppAttachInfo is null stack[%s]", t.Nm());
        }
        return GD;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.ojt, 1);
    }

    public final void a(String str, i iVar) {
        com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
        if (bDH != null) {
            long j = bDH.field_totalLen;
            this.ojn.setText(getString(2131232296, new Object[]{t.aw(bDH.field_offset), t.aw(j)}));
            int i = bDH.field_totalLen == 0 ? 0 : (int) ((bDH.field_offset * 100) / bDH.field_totalLen);
            v.v("MicroMsg.AppAttachDownloadUI", "summerbig attach progress:" + i + " offset:" + r4 + " totallen:" + j);
            this.elJ.setProgress(i);
            if (bDH.field_status == 199 && i >= 100 && !this.ojr) {
                this.ojr = true;
                if (bDH != null) {
                    Toast.makeText(this, getString(2131232306) + " : " + bDH.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.cni, com.tencent.mm.compatible.util.e.cgd), this.oju).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.b(this, bDH.field_fileFullPath, this.dCf, 1);
                }
                ad.g(new Runnable(this) {
                    final /* synthetic */ AppAttachDownloadUI ojx;

                    {
                        this.ojx = r1;
                    }

                    public final void run() {
                        this.ojx.bDI();
                    }
                }, 200);
            }
            if (this.fQI.getVisibility() != 0 && i < 100 && !bDH.field_isUpload && bDH.field_status == 101) {
                v.i("MicroMsg.AppAttachDownloadUI", "summerbig still downloading updateProgress progress[%d]", Integer.valueOf(i));
                this.fQI.setVisibility(0);
                this.gbX.setVisibility(8);
                this.ojm.setVisibility(0);
            }
        }
    }

    private void bDI() {
        Intent intent;
        switch (this.lAU) {
            case 0:
            case 6:
                if (!bDJ()) {
                    return;
                }
                if (be.KY(this.dCf)) {
                    com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
                    Intent intent2 = new Intent(this, ShowImageUI.class);
                    intent2.putExtra("key_message_id", this.bmk.field_msgId);
                    intent2.putExtra("key_image_path", bDH.field_fileFullPath);
                    intent2.putExtra("key_favorite", true);
                    startActivity(intent2);
                    finish();
                    return;
                }
                String mimeType = getMimeType();
                this.nOf.setVisibility(0);
                this.fQI.setVisibility(8);
                this.ojm.setVisibility(8);
                this.gbX.setVisibility(8);
                this.ojo.setVisibility(0);
                if (this.aST.equals(SQLiteDatabase.KeyEmpty)) {
                    this.ojo.setText(getString(2131234136));
                } else {
                    this.ojo.setText(this.aST);
                }
                if (mimeType == null || mimeType.equals(SQLiteDatabase.KeyEmpty)) {
                    this.fQE.setVisibility(8);
                    this.nOf.setText(getString(2131232293));
                    return;
                }
                this.fQE.setVisibility(0);
                this.nOf.setText(getString(2131232294));
                return;
            case 2:
                if (bDJ()) {
                    intent = new Intent(this, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", this.bmk.field_msgId);
                    intent.putExtra("img_gallery_talker", this.bmk.field_talker);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("App_MsgId", this.bao);
                setResult(-1, intent);
                finish();
                return;
            default:
                this.fQE.setVisibility(0);
                this.fQI.setVisibility(8);
                this.ojm.setVisibility(8);
                return;
        }
    }

    private boolean bDJ() {
        com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
        if (bDH == null) {
            return true;
        }
        if (com.tencent.mm.a.e.aR(bDH.field_fileFullPath)) {
            this.fQI.setVisibility(8);
            this.ojm.setVisibility(8);
            this.gbX.setVisibility(8);
            return true;
        }
        this.ojv.setVisibility(8);
        this.ojw.setVisibility(0);
        return false;
    }

    protected final int getLayoutId() {
        return 2130903468;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.AppAttachDownloadUI", "summerbig onSceneEnd type[%d], [%d, %d, %s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() != 221 && kVar.getType() != 728) {
            return;
        }
        if (kVar.getType() == 728 && i == 0 && i2 == 0) {
            com.tencent.mm.pluginsdk.model.app.b bDH = bDH();
            String str2 = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerbig onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bDH.field_signature == null ? -1 : bDH.field_signature.length());
            v.i(str2, str3, objArr);
            this.ojp = new aa(this.bao, this.mediaId, this.ffv);
            ak.vy().a(this.ojp, 0);
            return;
        }
        if (this.ojp == null && (kVar instanceof aa)) {
            aa aaVar = (aa) kVar;
            com.tencent.mm.pluginsdk.model.app.b bDH2 = bDH();
            if (!(bDH2 == null || t.kS(bDH2.field_mediaSvrId) || !bDH2.field_mediaSvrId.equals(aaVar.getMediaId()))) {
                this.ojp = aaVar;
                v.i("MicroMsg.AppAttachDownloadUI", "summerbig onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", this.ojp, bDH2.field_mediaSvrId);
            }
        }
        if (i != 0 || i2 != 0) {
            if (i2 != 0 && com.tencent.mm.sdk.b.b.bsI()) {
                Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
            }
            if (i2 == -5103059) {
                this.ojw.setVisibility(0);
                this.ojv.setVisibility(8);
                return;
            }
            this.fQI.setVisibility(8);
            this.gbX.setVisibility(0);
            this.ojm.setVisibility(8);
            v.e("MicroMsg.AppAttachDownloadUI", "summerbig onSceneEnd, download fail, type = " + kVar.getType() + " errType = " + i + ", errCode = " + i2);
        }
    }

    public final void bnw() {
        Toast.makeText(this, 2131232304, 0).show();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }
}
