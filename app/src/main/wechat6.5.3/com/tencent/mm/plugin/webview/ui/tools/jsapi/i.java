package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.DatePicker;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.u;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.ch;
import com.tencent.mm.e.a.ck;
import com.tencent.mm.e.a.cl;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.e.a.co;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.cs;
import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.de;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.e.a.dh;
import com.tencent.mm.e.a.dk;
import com.tencent.mm.e.a.du;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.e.a.en;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.fr;
import com.tencent.mm.e.a.fs;
import com.tencent.mm.e.a.ft;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.e.a.gk;
import com.tencent.mm.e.a.hm;
import com.tencent.mm.e.a.jn;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.e.a.jy;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.a.lm;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.e.a.nq;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.e.a.op;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.e.a.rd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.webview.d.ab;
import com.tencent.mm.plugin.webview.d.ae;
import com.tencent.mm.plugin.webview.d.ag;
import com.tencent.mm.plugin.webview.d.ah;
import com.tencent.mm.plugin.webview.d.aj;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.q;
import com.tencent.mm.plugin.webview.d.t;
import com.tencent.mm.plugin.webview.d.w;
import com.tencent.mm.plugin.webview.d.x;
import com.tencent.mm.plugin.webview.d.z;
import com.tencent.mm.plugin.webview.e.d;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.acu;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.protocal.c.bai;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class i implements com.tencent.mm.ui.MMActivity.a {
    private static final HashSet<String> dGF;
    private static final char[] dSF = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] dSG = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    public static Context lpq;
    public static int lpr = -1;
    private Map<String, acr> bYi = new ConcurrentHashMap();
    private WXMediaMessage bhh;
    public final int bkE;
    private Context context;
    private com.tencent.mm.modelgeo.a dGN = null;
    private com.tencent.mm.modelgeo.a.a dGO = null;
    private ac dGP;
    private ProgressDialog dwR = null;
    private String ezn = null;
    public boolean fHM = false;
    private ProgressDialog gKB;
    private float iBQ = 0.0f;
    private c iSD = new c<cs>(this) {
        final /* synthetic */ i lpR;

        {
            this.lpR = r2;
            this.nhz = cs.class.getName().hashCode();
        }

        private boolean a(cs csVar) {
            if (csVar != null && (csVar instanceof cs)) {
                System.currentTimeMillis();
                this.lpR.lpB;
                if (i.lpr != -1) {
                    this.lpR.lpf = this.lpR.th(i.lpr).lpf;
                    this.lpR.leB = this.lpR.th(i.lpr).leB;
                }
                this.lpR.lpB = System.currentTimeMillis();
                String str = csVar.baG.baE;
                int i = csVar.baG.baH;
                int i2 = csVar.baG.baI & 65535;
                double d = csVar.baG.baK;
                double d2 = csVar.baG.baJ;
                v.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[]{str + "," + i + "," + i2 + "," + d});
                String str2 = str + "," + i + "," + i2;
                boolean z = false;
                List<acs> list;
                Iterator it;
                acu com_tencent_mm_protocal_c_acu;
                if (this.lpR.bYi.containsKey(str2)) {
                    list = (List) this.lpR.lpy.get(str + "," + i);
                    if (list != null) {
                        for (acs com_tencent_mm_protocal_c_acs : list) {
                            if (com_tencent_mm_protocal_c_acs != null && com_tencent_mm_protocal_c_acs.mDM != null && !com_tencent_mm_protocal_c_acs.mDM.isEmpty()) {
                                it = com_tencent_mm_protocal_c_acs.mDM.iterator();
                                while (it.hasNext()) {
                                    com_tencent_mm_protocal_c_acu = (acu) it.next();
                                    if (i2 >= com_tencent_mm_protocal_c_acu.mDN && i2 <= com_tencent_mm_protocal_c_acu.mDO) {
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                } else {
                    acr com_tencent_mm_protocal_c_acr = new acr();
                    com_tencent_mm_protocal_c_acr.gjT = str;
                    com_tencent_mm_protocal_c_acr.major = i;
                    com_tencent_mm_protocal_c_acr.minor = i2;
                    this.lpR.bYi.put(str2, com_tencent_mm_protocal_c_acr);
                    if (this.lpR.lpy.containsKey(str + "," + i)) {
                        list = (List) this.lpR.lpy.get(str + "," + i);
                        if (list != null) {
                            for (acs com_tencent_mm_protocal_c_acs2 : list) {
                                boolean z2;
                                if (!(com_tencent_mm_protocal_c_acs2 == null || com_tencent_mm_protocal_c_acs2.mDM == null || com_tencent_mm_protocal_c_acs2.mDM.isEmpty())) {
                                    Iterator it2 = com_tencent_mm_protocal_c_acs2.mDM.iterator();
                                    while (it2.hasNext()) {
                                        com_tencent_mm_protocal_c_acu = (acu) it2.next();
                                        if (i2 >= com_tencent_mm_protocal_c_acu.mDN && i2 <= com_tencent_mm_protocal_c_acu.mDO) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = z;
                                if (z2) {
                                    z = z2;
                                    break;
                                }
                                z = z2;
                            }
                        }
                    }
                    if (!z) {
                        this.lpR.lpz.add(com_tencent_mm_protocal_c_acr);
                        String str3 = null;
                        if (!(this.lpR.lpf == null || this.lpR.lpf.iaJ == null)) {
                            Object obj = this.lpR.lpf.iaJ.get("url");
                            str3 = be.ma(this.lpR.lps.Fu(obj != null ? obj.toString() : ""));
                        }
                        if (!this.lpR.lpA) {
                            this.lpR.lpA = true;
                            final h hVar = new h(this.lpR.lpz, be.ma(str3));
                            this.lpR.lpz.clear();
                            ak.vy().a(1704, new e(this) {
                                final /* synthetic */ AnonymousClass10 pPX;

                                public final void a(int i, int i2, String str, k kVar) {
                                    if (i == 0 && i2 == 0) {
                                        ta taVar = (ta) hVar.cQA.czl.czs;
                                        if (taVar.fvC == 0) {
                                            List<acs> list = taVar.mwx;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            for (acs com_tencent_mm_protocal_c_acs : list) {
                                                List list2;
                                                String str2 = com_tencent_mm_protocal_c_acs.gjT + "," + com_tencent_mm_protocal_c_acs.major;
                                                if (this.pPX.lpR.lpy.containsKey(str2)) {
                                                    list2 = (List) this.pPX.lpR.lpy.get(str2);
                                                } else {
                                                    list2 = new ArrayList();
                                                    this.pPX.lpR.lpy.put(str2, list2);
                                                }
                                                list2.add(com_tencent_mm_protocal_c_acs);
                                                stringBuilder.append("{uuid:" + com_tencent_mm_protocal_c_acs.gjT + ",major:" + com_tencent_mm_protocal_c_acs.major + ",minors:[");
                                                Iterator it = com_tencent_mm_protocal_c_acs.mDM.iterator();
                                                while (it.hasNext()) {
                                                    acu com_tencent_mm_protocal_c_acu = (acu) it.next();
                                                    stringBuilder.append(com_tencent_mm_protocal_c_acu.mDN + "-" + com_tencent_mm_protocal_c_acu.mDO + ",");
                                                }
                                                stringBuilder.append("]},");
                                            }
                                            v.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
                                        }
                                    }
                                    ak.vy().b(1704, this);
                                    this.pPX.lpR.lpA = false;
                                }
                            });
                            ak.vy().a(hVar, 0);
                        }
                    }
                }
                v.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[]{String.valueOf(z) + "," + str2});
                try {
                    if (this.lpR.leB != null && z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uuid", str);
                        bundle.putInt("major", i);
                        bundle.putInt("minor", i2);
                        bundle.putDouble("accuracy", d2);
                        bundle.putDouble("rssi", d);
                        bundle.putFloat("heading", this.lpR.iBQ);
                        this.lpR.leB.g(40002, bundle);
                    }
                } catch (RemoteException e) {
                    v.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[]{e.getMessage()});
                }
                v.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[]{this.lpR.bYi.get(str2), Integer.valueOf(this.lpR.bYi.size())});
            }
            return false;
        }
    };
    public c iSE = new c<cy>(this) {
        final /* synthetic */ i lpR;

        {
            this.lpR = r2;
            this.nhz = cy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cy cyVar = (cy) bVar;
            if (cyVar != null && (cyVar instanceof cy)) {
                v.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(cyVar.baW.baX)});
                if (cyVar.baW.baX != 10 && cyVar.baW.baX == 12 && this.lpR.lpF) {
                    this.lpR.a(this.lpR.lpg, 1);
                }
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.webview.stub.e leB;
    private boolean lpA = false;
    private long lpB = 0;
    LocationManager lpC = null;
    private String lpD = "-1000.0";
    private String lpE = "-1000.0";
    private boolean lpF = false;
    private SensorEventListener lpG = new SensorEventListener(this) {
        final /* synthetic */ i lpR;

        {
            this.lpR = r1;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                this.lpR.iBQ = sensorEvent.values[0];
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    public k lpH;
    public c lpI = new c<op>(this) {
        final /* synthetic */ i lpR;

        {
            this.lpR = r2;
            this.nhz = op.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            op opVar = (op) bVar;
            if (opVar != null && (opVar instanceof op)) {
                v.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", new Object[]{Integer.valueOf(opVar.bpV.status)});
                i.b(this.lpR, opVar.bpV.status);
            }
            return false;
        }
    };
    public final Map<String, a> lpJ = new HashMap();
    public String lpK;
    public final List<String> lpL = new LinkedList();
    public final Map<Integer, b> lpM = new HashMap();
    public volatile k lpN = null;
    public k lpf;
    public k lpg;
    public HashSet<String> lph;
    public HashSet<String> lpi;
    public Bundle lpj;
    private String lpk = null;
    public HashMap<String, String> lpl = null;
    public HashMap<String, String> lpm = null;
    public String lpn = null;
    public com.tencent.mm.plugin.webview.stub.e lpo;
    private com.tencent.mm.plugin.webview.stub.e lpp;
    private e lps = null;
    public boolean lpt = false;
    private final l lpu;
    private final d lpv;
    private int lpw = -1;
    private Map<String, String> lpx = new ConcurrentHashMap();
    private Map<String, List<acs>> lpy = new ConcurrentHashMap();
    private List<acr> lpz = new CopyOnWriteArrayList();
    private Map<String, c> map;

    class AnonymousClass32 implements Runnable {
        final /* synthetic */ i lpR;
        final /* synthetic */ x lqo;

        public AnonymousClass32(i iVar, x xVar) {
            this.lpR = iVar;
            this.lqo = xVar;
        }

        public final void run() {
            ek ekVar = new ek();
            ekVar.bcM.op = 2;
            ekVar.bcM.filePath = this.lqo.lel;
            com.tencent.mm.sdk.c.a.nhr.z(ekVar);
            this.lpR.lpK = null;
        }
    }

    class AnonymousClass61 implements com.tencent.mm.pluginsdk.ui.applet.c.a {
        final /* synthetic */ String aSc;
        final /* synthetic */ String cMy;
        final /* synthetic */ String fDg;
        final /* synthetic */ String gct;
        final /* synthetic */ i lpR;
        final /* synthetic */ f lqD;
        final /* synthetic */ String pQB;
        final /* synthetic */ String pQC;
        final /* synthetic */ boolean pQD = true;
        final /* synthetic */ String pQE;
        final /* synthetic */ String pQF;

        AnonymousClass61(i iVar, f fVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
            this.lpR = iVar;
            this.lqD = fVar;
            this.gct = str;
            this.aSc = str2;
            this.cMy = str3;
            this.fDg = str4;
            this.pQB = str5;
            this.pQC = str6;
            this.pQE = str7;
            this.pQF = str8;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                this.lpR.a(this.lqD, this.gct, this.aSc, this.cMy, this.fDg, this.pQB, str, this.pQC);
                if (this.pQD) {
                    com.tencent.mm.ay.c.a(this.lpR.context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.aSc));
                } else if (this.lpR.context != null) {
                    g.bf(this.lpR.context, this.lpR.context.getResources().getString(2131231155));
                }
                this.lpR.cP(1, 1);
                this.lpR.a(this.lpR.lpf, this.pQE, null);
                return;
            }
            this.lpR.cP(1, 3);
            this.lpR.a(this.lpR.lpf, this.pQF, null);
        }
    }

    private static final class a {
        public k lpf;
        public com.tencent.mm.plugin.webview.d.c.b lqU;

        private a() {
        }
    }

    private class b {
        public com.tencent.mm.plugin.webview.stub.e leB;
        final /* synthetic */ i lpR;
        public k lpf;

        public b(i iVar, k kVar, com.tencent.mm.plugin.webview.stub.e eVar) {
            this.lpR = iVar;
            this.lpf = kVar;
            this.leB = eVar;
        }
    }

    static /* synthetic */ void A(i iVar) {
        try {
            iVar.leB.i(12, new Bundle(0));
            iVar.leB.i(11, new Bundle(0));
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "clearCloseWindowConfirmDialogInfo, exception = %s", new Object[]{e});
        }
    }

    static /* synthetic */ boolean A(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("specificview");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            iVar.a(kVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(268435456);
            Bundle bundle = new Bundle();
            String str2 = (String) kVar.iaJ.get("url");
            String str3 = (String) kVar.iaJ.get("extinfo");
            bundle.putInt("webview_scene", be.getInt((String) kVar.iaJ.get("webview_scene"), 0));
            bundle.putString("url", str2);
            bundle.putString("extinfo", str3);
            v.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", new Object[]{str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.drp.a(iVar.context, str, new Object[]{bundle}))});
            if (com.tencent.mm.plugin.webview.a.a.drp.a(iVar.context, str, new Object[]{bundle})) {
                iVar.a(kVar, "specific_view:ok", null);
            } else {
                v.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                iVar.a(kVar, "specific_view:not_supported", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean C(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("funcId");
        String str3 = (String) kVar.iaJ.get("url");
        m.a(kVar.lqY, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        return true;
    }

    static /* synthetic */ boolean D(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get(DownloadInfoColumns.PACKAGENAME);
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
        } else {
            String str2 = (String) kVar.iaJ.get("data");
            boolean commit = iVar.context.getSharedPreferences(aa.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(str2 == null ? 0 : str2.length());
            v.i(str3, str4, objArr);
            if (commit) {
                iVar.a(kVar, "write_comm_data:ok", null);
                return true;
            }
        }
        iVar.a(kVar, "write_comm_data:fail", null);
        return true;
    }

    static /* synthetic */ boolean G(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) kVar.iaJ.get("pid");
        String str2 = (String) kVar.iaJ.get("url");
        Integer valueOf = Integer.valueOf(be.getInt((String) kVar.iaJ.get(Columns.TYPE), 0));
        int i = be.getInt((String) kVar.iaJ.get("view_type"), 0);
        String str3 = (String) kVar.iaJ.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        return iVar.a(valueOf, 8, i, str3, intent);
    }

    static /* synthetic */ boolean H(i iVar, k kVar) {
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        v.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            dVar.bkr = 4;
            com.tencent.mm.pluginsdk.wallet.e.b((MMActivity) iVar.context, dVar, 7, iVar);
        }
        return true;
    }

    static /* synthetic */ boolean I(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get(Columns.TYPE);
        v.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", new Object[]{str});
        if (be.kS(str) || dGF.contains(str)) {
            iVar.dGN = com.tencent.mm.modelgeo.c.FY();
            if (iVar.dGN == null) {
                v.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
                iVar.a(kVar, "geo_location:fail", null);
            } else {
                str = (String) iVar.lpf.iaJ.get(Columns.TYPE);
                if (iVar.dGO == null) {
                    iVar.dGO = new com.tencent.mm.modelgeo.a.a(iVar) {
                        final /* synthetic */ i lpR;

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
                            if (!z) {
                                return true;
                            }
                            v.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
                            if (this.lpR.dGN != null) {
                                this.lpR.dGN.c(this.lpR.dGO);
                            }
                            if (this.lpR.dGO == null) {
                                v.w("MicroMsg.MsgHandler", "already callback");
                                return false;
                            }
                            this.lpR.dGO = null;
                            Map hashMap = new HashMap();
                            hashMap.put("longitude", Float.valueOf(f));
                            this.lpR.lpE = String.valueOf(f);
                            hashMap.put("latitude", Float.valueOf(f2));
                            this.lpR.lpD = String.valueOf(f2);
                            hashMap.put("speed", Double.valueOf(d));
                            hashMap.put("accuracy", Double.valueOf(d2));
                            hashMap.put(Columns.TYPE, str);
                            this.lpR.a(this.lpR.lpf, "geo_location:ok", hashMap);
                            return false;
                        }
                    };
                }
                if (iVar.dGP == null) {
                    iVar.dGP = new ac(Looper.getMainLooper());
                }
                iVar.dGP.postDelayed(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    {
                        this.lpR = r1;
                    }

                    public final void run() {
                        if (this.lpR.dGN != null) {
                            this.lpR.dGN.c(this.lpR.dGO);
                        }
                        if (this.lpR.dGO == null) {
                            v.w("MicroMsg.MsgHandler", "already callback");
                            return;
                        }
                        this.lpR.dGO = null;
                        this.lpR.a(this.lpR.lpf, "geo_location:fail_timeout", null);
                    }
                }, 20000);
                if (be.kS(str) || str.equalsIgnoreCase("gcj02")) {
                    iVar.dGN.a(iVar.dGO);
                } else if (str.equalsIgnoreCase("wgs84")) {
                    iVar.dGN.b(iVar.dGO);
                } else {
                    v.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
                    iVar.dGO = null;
                    iVar.a(iVar.lpf, "geo_location:fail_unsupported_type_startgeo", null);
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", new Object[]{str});
            iVar.a(kVar, "geo_location:fail_unsupported_type", null);
        }
        return true;
    }

    static /* synthetic */ boolean N(i iVar, k kVar) {
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        v.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            dVar.bkr = 6;
            com.tencent.mm.pluginsdk.wallet.e.b((MMActivity) iVar.context, dVar, 9, iVar);
        }
        return true;
    }

    static /* synthetic */ boolean O(i iVar, final k kVar) {
        if (iVar.lpj == null) {
            v.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            iVar.a(kVar, "send_service_app_msg:fail", null);
        } else if (iVar.lpj.getBoolean("isFromService", false)) {
            String string = iVar.lpj.getString("jsapi_args_appid");
            String string2 = iVar.lpj.getString("sendAppMsgToUserName");
            m.a(kVar.lqY, false, null, string);
            iVar.bhh = g(kVar);
            if (iVar.bhh == null) {
                v.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                iVar.a(kVar, "send_service_app_msg:fail", null);
            } else {
                f aC = com.tencent.mm.pluginsdk.model.app.g.aC(string, true);
                if (be.kS(string2)) {
                    v.e("MicroMsg.MsgHandler", "toUser is null");
                    iVar.a(kVar, "send_service_app_msg:fail", null);
                } else {
                    final String str = (String) kVar.iaJ.get("img_url");
                    com.tencent.mm.plugin.report.service.g.iuh.h(10923, new Object[]{Integer.valueOf(13), aC.field_appId, Integer.valueOf(1)});
                    if (be.kS(str)) {
                        iVar.a(aC, "", string2, str, null, null, null, null);
                        g.bf(iVar.context, iVar.context.getString(2131231147));
                        iVar.a(kVar, "send_service_app_msg:ok", null);
                        iVar.aI(kVar);
                    } else {
                        final p a = g.a(iVar.context, iVar.context.getResources().getString(2131231151), true, new OnCancelListener(iVar) {
                            final /* synthetic */ i lpR;

                            public final void onCancel(DialogInterface dialogInterface) {
                                n.GG().iO(str);
                                this.lpR.a(kVar, "send_service_app_msg:fail", null);
                            }
                        });
                        final f fVar = aC;
                        final String str2 = string2;
                        final String str3 = str;
                        final k kVar2 = kVar;
                        n.GG().a(str, new com.tencent.mm.ae.b.c(iVar) {
                            final /* synthetic */ i lpR;

                            public final void j(Bitmap bitmap) {
                                if (a != null) {
                                    a.dismiss();
                                }
                                this.lpR.a(fVar, "", str2, str3, null, null, null, null);
                                this.lpR.a(kVar2, "send_service_app_msg:ok", null);
                                this.lpR.aI(kVar2);
                            }
                        });
                    }
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            iVar.a(kVar, "send_service_app_msg:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean Q(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("title");
        String str2 = (String) kVar.iaJ.get("singer");
        String str3 = (String) kVar.iaJ.get("epname");
        String str4 = (String) kVar.iaJ.get("coverImgUrl");
        String str5 = (String) kVar.iaJ.get("dataUrl");
        String str6 = (String) kVar.iaJ.get("lowbandUrl");
        String str7 = (String) kVar.iaJ.get("webUrl");
        String str8 = (String) kVar.iaJ.get("appId");
        m.a(kVar.lqY, false, null, str8);
        v.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str, str2, str3, str4, str5, str6, str7, str8});
        if (be.kS(str) || be.kS(str2) || be.kS(str3) || be.kS(str4) || be.kS(str6) || be.kS(str5) || be.kS(str7)) {
            iVar.a(kVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.ai.b.HB();
            String str9 = str5.hashCode();
            String str10 = com.tencent.mm.compatible.util.e.cnj;
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            com.tencent.mm.ai.b.b(com.tencent.mm.ai.b.a(7, str4, str, str2, str7, str6, str5, str9, str10, stringBuilder.append(com.tencent.mm.model.c.wP()).append(str4.hashCode()).toString(), str8));
            iVar.a(kVar, "playMusic:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean R(i iVar, k kVar) {
        boolean z = false;
        final String str = (String) kVar.iaJ.get("ssid");
        final String str2 = (String) kVar.iaJ.get("password");
        v.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", new Object[]{str, str2, (String) kVar.iaJ.get(Columns.TYPE), (String) kVar.iaJ.get("isHidden")});
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "ssid is null");
            iVar.a(kVar, "connecttowifi:failed_ssid_invalid", null);
        } else {
            final int i = be.getInt(r0, 0);
            if (i == 0 || !be.kS(str2)) {
                if (be.getInt(r1, 0) == 1) {
                    z = true;
                }
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ssid", str);
                        intent.putExtra("free_wifi_source", 3);
                        intent.putExtra("free_wifi_passowrd", str2);
                        intent.putExtra("free_wifi_hide_ssid", z);
                        intent.putExtra("free_wifi_encrypt_type", i);
                        intent.addFlags(67108864);
                        com.tencent.mm.ay.c.b(this.lpR.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                iVar.a(kVar, "connecttowifi:ok", null);
            } else {
                v.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                iVar.a(kVar, "connecttowifi:failed_password_invalid", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean S(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.b(iVar.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        return true;
    }

    static /* synthetic */ boolean T(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        return true;
    }

    static /* synthetic */ boolean U(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) kVar.iaJ.get("app_id");
        int i = be.getInt((String) kVar.iaJ.get("location_id"), 0);
        String str2 = (String) kVar.iaJ.get("sign_type");
        String str3 = (String) kVar.iaJ.get("card_sign");
        int i2 = be.getInt((String) kVar.iaJ.get("time_stamp"), 0);
        String str4 = (String) kVar.iaJ.get("nonce_str");
        String str5 = (String) kVar.iaJ.get("card_id");
        String str6 = (String) kVar.iaJ.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            iVar.a(kVar, "choose_card:fail", new HashMap());
            return false;
        }
        int i3 = be.getInt((String) kVar.iaJ.get("can_multi_select"), 0);
        m.a(kVar.lqY, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        return true;
    }

    static /* synthetic */ boolean V(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("signType");
        String str3 = (String) kVar.iaJ.get("cardSign");
        int i = be.getInt((String) kVar.iaJ.get("timestamp"), 0);
        String str4 = (String) kVar.iaJ.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        return true;
    }

    static /* synthetic */ boolean W(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("card_list");
        String str2 = (String) kVar.iaJ.get("src_username");
        String str3 = (String) kVar.iaJ.get("url");
        String str4 = (String) kVar.iaJ.get("tempalate_id");
        v.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", new Object[]{(String) kVar.iaJ.get("consumedCardId")});
        v.i("MicroMsg.MsgHandler", "doBatchAddCard %s", new Object[]{kVar.iaJ.toString()});
        v.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", new Object[]{str2, Integer.valueOf(be.getInt((String) kVar.iaJ.get("webview_scene"), 0) == 25 ? 16 : 7), Integer.valueOf(be.getInt((String) kVar.iaJ.get("stastic_scene"), 0))});
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", r6);
        intent.putExtra("key_stastic_scene", r7);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        return true;
    }

    static /* synthetic */ com.tencent.mm.ui.base.h a(i iVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (iVar.context == null || iVar.context.getResources() == null) {
            v.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
            return null;
        } else if (iVar.context instanceof Activity) {
            String blr = iVar.blr();
            f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, true);
            return com.tencent.mm.pluginsdk.ui.applet.c.a(((MMActivity) iVar.context).nDR, str2, str3, str5, true, iVar.context.getResources().getString(2131231149), new AnonymousClass61(iVar, aC, str, str4, str3, str6, str7, blr, true, str8, str9));
        } else {
            v.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
            return null;
        }
    }

    static /* synthetic */ void a(i iVar, com.tencent.mm.plugin.webview.stub.e eVar, k kVar, String str) {
        String str2 = null;
        iVar.fHM = false;
        if (kVar != null) {
            str2 = kVar.lqX;
        }
        try {
            eVar.a(str2, str, k.O(null), true);
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
        l.unlock();
    }

    static /* synthetic */ boolean a(i iVar, k kVar, boolean z) {
        v.i("MicroMsg.MsgHandler", "openDesignerProfile");
        String str = (String) kVar.iaJ.get("designerId");
        v.d("MicroMsg.MsgHandler", "cpan emoji openDesignerProfile:%d", new Object[]{Long.valueOf(be.getLong((String) kVar.iaJ.get("searchID"), 0))});
        if (be.kS(str)) {
            v.w("MicroMsg.MsgHandler", "openDesignerProfile failed designer id is null.");
            iVar.a(kVar, "openDesignerProfile", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("id", str);
        intent.putExtra("extra_scence", 12);
        intent.putExtra("searchID", r4);
        com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        iVar.a(kVar, "openDesignerProfile", null);
        if (z) {
            com.tencent.mm.plugin.report.service.g.iuh.h(13055, new Object[]{Integer.valueOf(3), "", str, "", Integer.valueOf(com.tencent.mm.z.a.Et()), Long.valueOf(r4)});
        }
        return true;
    }

    static /* synthetic */ boolean a(i iVar, String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT >= 18 && defaultAdapter != null) {
            com.tencent.mm.sdk.c.a.nhr.e(iVar.iSD);
            String ma = be.ma(str);
            iVar.lpx.put(ma, ma);
            v.i("MicroMsg.MsgHandler", "[MsgHandler][doStartIBeaconRange]op=true,iBeacon = %s", new Object[]{ma});
            Editor edit = aa.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", true);
            edit.commit();
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrq, Boolean.valueOf(true));
            }
            cr crVar = new cr();
            crVar.baC.baE = ma;
            crVar.baC.baB = true;
            com.tencent.mm.sdk.c.a.nhr.z(crVar);
        }
        return true;
    }

    static /* synthetic */ boolean aK(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("gameId");
        if (be.kS(str)) {
            str = (String) kVar.iaJ.get("appId");
        }
        v.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", new Object[]{str});
        if (be.kS(str)) {
            iVar.a(kVar, "openGameDetail:fail", null);
        } else {
            fq fqVar = new fq();
            fqVar.beY.appId = str;
            fqVar.beY.scene = 5;
            fqVar.beY.actionCode = 2;
            fqVar.beY.context = iVar.context;
            com.tencent.mm.sdk.c.a.nhr.z(fqVar);
            iVar.a(kVar, "openGameDetail:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aL(i iVar, k kVar) {
        int i = be.getInt((String) kVar.iaJ.get("jumpView"), 0);
        int i2 = be.getInt((String) kVar.iaJ.get("jumpType"), 0);
        String str = (String) kVar.iaJ.get("extInfo");
        jn jnVar = new jn();
        jnVar.bjW.bjX = i;
        jnVar.bjW.jumpType = i2;
        jnVar.bjW.extraInfo = str;
        jnVar.bjW.context = iVar.context;
        com.tencent.mm.sdk.c.a.nhr.z(jnVar);
        iVar.a(kVar, "gameCenterJump:ok", null);
        return true;
    }

    static /* synthetic */ boolean aM(i iVar, k kVar) {
        int i = be.getInt((String) kVar.iaJ.get("downloaderType"), 0);
        String str = (String) kVar.iaJ.get("countryCode");
        int i2 = be.getInt((String) kVar.iaJ.get("showAllLog"), 0);
        fr frVar = new fr();
        frVar.bfa.bfb = i;
        frVar.bfa.bfc = i2;
        frVar.bfa.bfd = str;
        com.tencent.mm.sdk.c.a.nhr.z(frVar);
        iVar.a(kVar, "setGameDebugConfig:ok", null);
        return true;
    }

    static /* synthetic */ boolean aO(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.b(iVar.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        return true;
    }

    static /* synthetic */ boolean aP(i iVar, k kVar) {
        v.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (iVar.context != null) {
            String str = (String) kVar.iaJ.get("deviceType");
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "deviceType is null");
                iVar.a(kVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) kVar.iaJ.get("deviceId");
                if (be.kS(str2)) {
                    v.e("MicroMsg.MsgHandler", "deviceId is null");
                    iVar.a(kVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(iVar.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.ay.c.b(iVar.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    iVar.a(kVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "context is null");
            iVar.a(kVar, "openMyDeviceProfile:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean aQ(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            dVar.lVM = 2;
            com.tencent.mm.pluginsdk.wallet.e.a((MMActivity) iVar.context, dVar, 27, iVar);
            long j = be.getLong((String) kVar.iaJ.get("message_id"), 0);
            int i = be.getInt((String) kVar.iaJ.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.iuh.h(10593, new Object[]{dVar.bkp, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.bkq), dVar.url});
            iVar.lpw = iVar.aJ(kVar);
        }
        return true;
    }

    static /* synthetic */ boolean aR(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            MMActivity mMActivity = (MMActivity) iVar.context;
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            mMActivity.nDS = iVar;
            com.tencent.mm.ay.c.a(mMActivity, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent, 25, true);
            long j = be.getLong((String) kVar.iaJ.get("message_id"), 0);
            int i = be.getInt((String) kVar.iaJ.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.iuh.h(10593, new Object[]{dVar.bkp, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.bkq), dVar.url});
        }
        return true;
    }

    static /* synthetic */ boolean aS(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.ay.c.a(iVar.context, "mall", ".ui.MallIndexUI", intent, false);
            iVar.a(kVar, "jump_to_wx_wallet:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aT(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doScanCover");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (u.bi(iVar.context) || com.tencent.mm.ah.a.aT(iVar.context)) {
            v.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            iVar.a(kVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.ay.c.a(iVar.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            iVar.a(kVar, "sacnCover:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aU(i iVar, k kVar) {
        if (iVar.b("nfcIsConnect", 4001, new Bundle())) {
            iVar.a(kVar, "nfcIsConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aV(i iVar, k kVar) {
        if (iVar.b("nfcConnect", 4002, new Bundle())) {
            iVar.a(kVar, "nfcConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aW(i iVar, k kVar) {
        if (iVar.b("nfcTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) kVar.iaJ.get("apdu"));
            Bundle a = iVar.a("nfcTransceive", 4003, bundle);
            if (a != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", a.getString("result"));
                v.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + a.getString("result"));
                iVar.a(kVar, "nfcTransceive:ok", hashMap);
            } else {
                v.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                iVar.a(kVar, "nfcTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aX(i iVar, k kVar) {
        if (iVar.b("nfcBatchTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) kVar.iaJ.get("apdus"));
            bundle.putBoolean("breakIfFail", be.getInt((String) kVar.iaJ.get("breakIfFail"), 1) == 1);
            Bundle a = iVar.a("nfcBatchTransceive", 4004, bundle);
            if (a != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", a.getString("result"));
                v.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + a.getString("result"));
                iVar.a(kVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                v.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                iVar.a(kVar, "nfcBatchTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aY(i iVar, k kVar) {
        Bundle bundle = new Bundle();
        if (iVar.b("nfcGetId", 4002, bundle)) {
            bundle = iVar.a("nfcGetId", 4005, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("id", bundle.getString("id"));
                v.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString("id"));
                iVar.a(kVar, "nfcGetId:ok", hashMap);
            } else {
                v.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                iVar.a(kVar, "nfcGetId:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aZ(i iVar, k kVar) {
        Bundle bundle = new Bundle();
        if (iVar.b("nfcGetInfo", 4002, bundle)) {
            bundle = iVar.a("nfcGetInfo", 4008, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                iVar.a(kVar, "nfcGetInfo:ok", hashMap);
            } else {
                v.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                iVar.a(kVar, "nfcGetInfo:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aa(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("appId");
        final String str2 = (String) kVar.iaJ.get("localId");
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (be.kS(str) || be.kS(str2)) {
            iVar.a(kVar, "playVoice:fail_missing arguments", null);
        } else {
            final x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
            if (DW != null) {
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        eh ehVar = new eh();
                        ehVar.bcF.op = 1;
                        ehVar.bcF.aST = DW.aST;
                        ehVar.bcF.aTe = true;
                        ehVar.bcF.bcI = new com.tencent.mm.v.g.a(this) {
                            final /* synthetic */ AnonymousClass35 pQm;

                            {
                                this.pQm = r1;
                            }

                            public final void pa() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:ok");
                                    bundle.putString("localId", str2);
                                    this.pQm.lpR.leB.g(2002, bundle);
                                } catch (Exception e) {
                                    v.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                        };
                        ehVar.bcF.bcJ = new com.tencent.mm.v.g.b(this) {
                            final /* synthetic */ AnonymousClass35 pQm;

                            {
                                this.pQm = r1;
                            }

                            public final void onError() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:fail");
                                    bundle.putString("localId", str2);
                                    this.pQm.lpR.leB.g(2002, bundle);
                                } catch (Exception e) {
                                    v.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                        };
                        com.tencent.mm.sdk.c.a.nhr.z(ehVar);
                    }
                });
                iVar.a(kVar, "playVoice:ok", null);
            } else {
                iVar.a(kVar, "playVoice:fail_arguments error", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean ab(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (be.kS(str) || be.kS(str2)) {
            iVar.a(kVar, "pauseVoice:fail_missing arguments", null);
        } else {
            final x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
            if (DW != null) {
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        eh ehVar = new eh();
                        ehVar.bcF.op = 4;
                        ehVar.bcF.aST = DW.aST;
                        com.tencent.mm.sdk.c.a.nhr.z(ehVar);
                    }
                });
                iVar.a(kVar, "pauseVoice:ok", null);
            } else {
                iVar.a(kVar, "pauseVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean ac(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        v.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        m.a(kVar.lqY, false, null, str);
        if (be.kS(str) || be.kS(str2)) {
            iVar.a(kVar, "stopVoice:fail_missing arguments", null);
        } else {
            final x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
            if (DW != null) {
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        eh ehVar = new eh();
                        ehVar.bcF.op = 2;
                        ehVar.bcF.aST = DW.aST;
                        com.tencent.mm.sdk.c.a.nhr.z(ehVar);
                    }
                });
                iVar.a(kVar, "stopVoice:ok", null);
            } else {
                iVar.a(kVar, "stopVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aq(i iVar, k kVar) {
        if (iVar.context instanceof MMActivity) {
            String str = (String) kVar.iaJ.get("key");
            int i = be.getInt((String) kVar.iaJ.get("procint"), 0);
            int i2 = be.getInt((String) kVar.iaJ.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.b(iVar.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            iVar.a(kVar, "configWXDeviceWiFi:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean at(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            intent.putExtra("scene", 1);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        return true;
    }

    static /* synthetic */ boolean au(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        return true;
    }

    static /* synthetic */ boolean av(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) kVar.iaJ.get("card_list");
        String str2 = (String) kVar.iaJ.get("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        }
        iVar.fHM = false;
        return false;
    }

    static /* synthetic */ boolean aw(i iVar, k kVar) {
        Object obj = kVar.iaJ.get(Columns.TYPE);
        final String obj2 = obj == null ? "0" : obj.toString();
        v.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", new Object[]{obj2});
        final String str = (String) kVar.iaJ.get("src_username");
        if (obj2.equals("0") || obj2.equals("1") || obj2.equals("2")) {
            String str2 = (String) kVar.iaJ.get("apKey");
            v.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", new Object[]{str2});
            final String str3 = be.kS(str2) ? "" : str2;
            if (obj2.equals("0") && be.kS(str3)) {
                iVar.a(kVar, "connectToFreeWifi:failed_invaildParam", null);
            } else {
                final String str4 = (String) kVar.iaJ.get("sessionKey");
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_jsapi_param_type", obj2);
                        intent.putExtra("free_wifi_ap_key", str3);
                        intent.putExtra("free_wifi_jsapi_param_username", str);
                        intent.putExtra("free_wifi_sessionkey", str4);
                        intent.putExtra("free_wifi_source", 4);
                        intent.addFlags(67108864);
                        if (!(be.kS(obj2) || !obj2.equalsIgnoreCase("2") || be.kS(str3))) {
                            Uri parse = Uri.parse(str3);
                            String host = parse.getHost();
                            String query = parse.getQuery();
                            if (!be.kS(host) && "connectToFreeWifi".equals(host) && !be.kS(query) && query.startsWith("apKey=")) {
                                host = parse.getQueryParameter("apKey");
                                v.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", new Object[]{host});
                                query = parse.getQueryParameter("ticket");
                                if (!be.kS(host) && host.length() < 1024) {
                                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                                    intent.putExtra("free_wifi_ap_key", host);
                                    intent.putExtra("free_wifi_source", 5);
                                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                                    if (!be.kS(query)) {
                                        intent.putExtra("free_wifi_schema_ticket", query);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.ay.c.b(this.lpR.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                iVar.a(kVar, "connectToFreeWifi:ok", null);
            }
        } else {
            iVar.a(kVar, "connectToFreeWifi:failed_invaildParam", null);
        }
        return true;
    }

    static /* synthetic */ void b(i iVar, int i) {
        if (i == 1) {
            iVar.a(iVar.lpH, "startVoipCall:cancel", null);
        } else if (i == 2) {
            iVar.a(iVar.lpH, "startVoipCall:hangup", null);
        } else if (i == 3) {
            iVar.a(iVar.lpH, "startVoipCall:network error", null);
        } else if (i == 4) {
            iVar.a(iVar.lpH, "startVoipCall:param not match", null);
        } else {
            iVar.a(iVar.lpH, "startVoipCall:unknow", null);
        }
    }

    static /* synthetic */ boolean b(i iVar, k kVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) kVar.iaJ.get("username");
        iVar.FB((String) kVar.iaJ.get("scene"));
        return iVar.FE(str);
    }

    static /* synthetic */ boolean b(i iVar, k kVar, boolean z) {
        String str = (String) kVar.iaJ.get("designerId");
        int i = be.getInt((String) kVar.iaJ.get("designerUin"), 0);
        String str2 = (String) kVar.iaJ.get("tagId");
        String str3 = (String) kVar.iaJ.get("tagDesc");
        String str4 = (String) kVar.iaJ.get("keyword");
        int i2 = be.getInt((String) kVar.iaJ.get("tid"), 0);
        String ah = be.ah((String) kVar.iaJ.get("title"), "");
        String ah2 = be.ah((String) kVar.iaJ.get("desc"), "");
        String ah3 = be.ah((String) kVar.iaJ.get("iconUrl"), "");
        String ah4 = be.ah((String) kVar.iaJ.get("secondUrl"), "");
        int i3 = be.getInt((String) kVar.iaJ.get("pageType"), 0);
        long j = be.getLong((String) kVar.iaJ.get("searchID"), 0);
        v.d("MicroMsg.MsgHandler", "cpan emoji openDesignerEmojiView:%d", new Object[]{Long.valueOf(j)});
        Intent intent = new Intent();
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
        intent.putExtra("headurl", ah4);
        intent.putExtra("set_iconURL", ah3);
        intent.putExtra("set_desc", ah2);
        intent.putExtra("pageType", i3);
        intent.putExtra("set_title", ah);
        intent.putExtra("set_id", i2);
        v.i("MicroMsg.MsgHandler", "openDesignerEmojiView event: designerID:%s tagID:%s tagDesc:%s keyword:%s", new Object[]{str, str2, str3, str4});
        if (!be.kS(str4)) {
            intent.putExtra("keyword", str4);
            intent.putExtra("searchID", j);
            com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            iVar.a(kVar, "openDesignerEmojiView:ok" + str4, null);
            if (z) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13055, new Object[]{Integer.valueOf(2), "", "", "", Integer.valueOf(com.tencent.mm.z.a.Et()), Long.valueOf(j)});
            }
            return true;
        } else if (!be.kS(str)) {
            intent.putExtra("id", str);
            intent.putExtra("searchID", j);
            com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            iVar.a(kVar, "openDesignerEmojiView:ok" + str, null);
            return true;
        } else if (be.kS(str2)) {
            com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            iVar.a(kVar, "openDesignerEmojiView:ok", null);
            return true;
        } else {
            intent.putExtra("tag_id", str2);
            intent.putExtra("tag_desc", str3);
            com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            iVar.a(kVar, "openDesignerEmojiView:ok" + str2, null);
            return true;
        }
    }

    static /* synthetic */ boolean bJ(i iVar, final k kVar) {
        final String str = (String) kVar.iaJ.get("cardType");
        if (be.kS(str) || iVar.context == null) {
            iVar.a(kVar, "scanLicence:fail", null);
        } else {
            if (!iVar.lpv.a(str, iVar.context, new com.tencent.mm.plugin.webview.e.d.a(iVar) {
                final /* synthetic */ i lpR;

                public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                    if (!be.ma(str).equalsIgnoreCase(str)) {
                        v.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", new Object[]{str, str});
                    } else if (jSONObject == null) {
                        v.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", new Object[]{str});
                        Bj(str);
                    } else {
                        Map hashMap = new HashMap(2);
                        hashMap.put("cardType", str);
                        hashMap.put("cardInfo", jSONObject);
                        this.lpR.a(kVar, "scanLicence:ok", hashMap);
                    }
                }

                public final void Ex(String str) {
                    if (be.ma(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        this.lpR.a(kVar, "scanLicence:cancel", hashMap);
                    }
                }

                public final void Bj(String str) {
                    if (be.ma(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        this.lpR.a(kVar, "scanLicence:fail", hashMap);
                    }
                }
            })) {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                iVar.a(kVar, "scanLicence:type not supported", hashMap);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bR(i iVar, final k kVar) {
        String str = (String) kVar.iaJ.get("username");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "user name is null or nil");
            iVar.a(kVar, "add_contact:fail", null);
            return false;
        }
        v.i("MicroMsg.MsgHandler", "get scene = %s", new Object[]{(String) kVar.iaJ.get("scene")});
        final com.tencent.mm.pluginsdk.ui.applet.b bVar = new com.tencent.mm.pluginsdk.ui.applet.b(iVar.context, str, be.getInt(r0, 91), new com.tencent.mm.pluginsdk.ui.applet.b.a(iVar) {
            final /* synthetic */ i lpR;

            public final void mH(int i) {
                switch (i) {
                    case ai.CTRL_INDEX /*-2*/:
                        this.lpR.a(kVar, "quickly_add_contact:added", null);
                        return;
                    case -1:
                        this.lpR.a(kVar, "quickly_add_contact:fail", null);
                        return;
                    case 0:
                        this.lpR.a(kVar, "quickly_add_contact:cancel", null);
                        return;
                    case 1:
                        this.lpR.a(kVar, "quickly_add_contact:ok", null);
                        return;
                    default:
                        this.lpR.a(kVar, "quickly_add_contact:fail", null);
                        return;
                }
            }
        }, false);
        ad.o(new Runnable(iVar) {
            final /* synthetic */ i lpR;

            public final void run() {
                bVar.show();
            }
        });
        return true;
    }

    static /* synthetic */ boolean bS(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("consumedCardId");
        String str2 = (String) kVar.iaJ.get("consumedCode");
        v.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is " + str);
        if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", new Object[]{str, str2});
            iVar.a(kVar, "consumedShareCard:fail", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) iVar.context).nDS = iVar;
        com.tencent.mm.ay.c.b(iVar.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        return true;
    }

    static /* synthetic */ boolean bT(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("url");
        String str2 = (String) kVar.iaJ.get("open_game_webview");
        v.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s", new Object[]{str});
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "url is null or nil");
            iVar.a(kVar, "openUrlWithExtraWebview:fail_invalid_url", null);
        } else {
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            if (be.ma(str2).equals("1")) {
                com.tencent.mm.ay.c.b(iVar.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", iVar.leB, new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        com.tencent.mm.ay.c.b(this.lpR.context, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
            iVar.a(kVar, "openUrlWithExtraWebview:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean bY(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", new Object[]{Integer.valueOf(be.getInt((String) kVar.iaJ.get("selectMode"), 0))});
        Intent intent = new Intent();
        if (be.getInt((String) kVar.iaJ.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", 263);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", 259);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", com.tencent.mm.model.k.xF());
        intent.putExtra("scene_from", 4);
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.ay.c.a((MMActivity) iVar.context, ".ui.transmit.SelectConversationUI", intent, 30, iVar);
        }
        return true;
    }

    static /* synthetic */ boolean ba(i iVar, final k kVar) {
        int i = 0;
        boolean z = be.getInt((String) kVar.iaJ.get("isShowNfcSwitchGuide"), 1) == 1;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(iVar.context);
        if (defaultAdapter == null) {
            iVar.a(kVar, "nfcCheckState:nfc_not_support", null);
        } else {
            ak.yW();
            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqm, Integer.valueOf(0))).intValue();
            ak.yW();
            int intValue2 = ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqn, Integer.valueOf(0))).intValue();
            if (intValue == 2 || (intValue == 0 && intValue2 != 1)) {
                i = 1;
            }
            if (i != 0) {
                if (z) {
                    ad.o(new Runnable(iVar) {
                        final /* synthetic */ i lpR;

                        public final void run() {
                            g.b(this.lpR.context, this.lpR.context.getString(2131234035), "", this.lpR.context.getString(2131234037), this.lpR.context.getString(2131231010), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass46 lqy;

                                {
                                    this.lqy = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.ay.c.w(this.lqy.lpR.context, "setting", ".ui.setting.SettingsAboutSystemUI");
                                    this.lqy.lpR.a(kVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass46 lqy;

                                {
                                    this.lqy = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.lqy.lpR.a(kVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            });
                        }
                    });
                } else {
                    iVar.a(kVar, "nfcCheckState:nfc_wechat_setting_off", null);
                }
            } else if (defaultAdapter.isEnabled()) {
                iVar.a(kVar, "nfcCheckState:nfc_ok", null);
            } else if (z) {
                ad.o(new Runnable(iVar) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        g.b(this.lpR.context, this.lpR.context.getString(2131234036), "", this.lpR.context.getString(2131234037), this.lpR.context.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass47 pQs;

                            {
                                this.pQs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.pQs.lpR.context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                                this.pQs.lpR.a(kVar, "nfcCheckState:nfc_off", null);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass47 pQs;

                            {
                                this.pQs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.pQs.lpR.a(kVar, "nfcCheckState:nfc_off", null);
                            }
                        });
                    }
                });
            } else {
                iVar.a(kVar, "nfcCheckState:nfc_off", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bk(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biZ();
        return com.tencent.mm.plugin.webview.c.b.H(kVar.iaJ);
    }

    static /* synthetic */ boolean bn(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biZ();
        Map map = kVar.iaJ;
        v.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[]{map.toString()});
        com.tencent.mm.modelsearch.l.r(com.tencent.mm.plugin.webview.c.c.c(map, "logId", 0), com.tencent.mm.plugin.webview.c.c.n(map, "logString"));
        return false;
    }

    static /* synthetic */ boolean bp(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.c.b biZ = com.tencent.mm.plugin.webview.e.e.biZ();
        Map map = kVar.iaJ;
        boolean b = com.tencent.mm.plugin.webview.c.c.b(map, "hasResult", false);
        String n = com.tencent.mm.plugin.webview.c.c.n(map, "query");
        int c = com.tencent.mm.plugin.webview.c.c.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.c.c.c(map, "scene", 0);
        v.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", new Object[]{Boolean.valueOf(b), n, Integer.valueOf(c)});
        com.tencent.mm.plugin.webview.c.b.e eVar = biZ.ldr;
        if (eVar.scene == c2 && eVar.bkC != null && eVar.bkC.equals(n) && eVar.iHC == c) {
            eVar.aWL = b;
        } else {
            v.w("MicroMsg.FTS.FTSWebViewLogic", "setHahResultNotSame: %s VS %s | %d VS %d | %d VS %d", new Object[]{eVar.bkC, n, Integer.valueOf(eVar.iHC), Integer.valueOf(c), Integer.valueOf(eVar.scene), Integer.valueOf(c2)});
        }
        return false;
    }

    static /* synthetic */ boolean br(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biZ();
        Map map = kVar.iaJ;
        v.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", new Object[]{map});
        int c = com.tencent.mm.plugin.webview.c.c.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.c.c.c(map, "scene", 0);
        String n = com.tencent.mm.plugin.webview.c.c.n(map, "searchId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("extra_scence", c2);
        intent.putExtra("extra_type", c);
        intent.putExtra("searchID", n);
        intent.putExtra("docID", com.tencent.mm.plugin.webview.c.c.n(map, "docID"));
        switch (c) {
            case 1:
                intent.putExtra("extra_id", com.tencent.mm.plugin.webview.c.c.n(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", be.getLong(n, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.c.n(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.c.c.n(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.c.c.n(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.c.n(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.c.n(map, "thumb"));
                intent.putExtra("id", com.tencent.mm.plugin.webview.c.c.n(map, "designerId"));
                intent.putExtra("extra_product_id", com.tencent.mm.plugin.webview.c.c.n(map, "productID"));
                intent.putExtra("productUrl", com.tencent.mm.plugin.webview.c.c.n(map, "productUrl"));
                intent.putExtra("extra_product_name", com.tencent.mm.plugin.webview.c.c.n(map, "productName"));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.c.n(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.c.c.n(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.c.c.n(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.c.n(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.c.n(map, "thumb"));
                intent.putExtra("id", com.tencent.mm.plugin.webview.c.c.n(map, "designerId"));
                intent.putExtra("name", com.tencent.mm.plugin.webview.c.c.n(map, "designerName"));
                intent.putExtra("headurl", com.tencent.mm.plugin.webview.c.c.n(map, "designerThumb"));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.c.n(map, "express"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.c.n(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.c.n(map, "thumb"));
                intent.putExtra("extra_article_name", com.tencent.mm.plugin.webview.c.c.n(map, "sourceTitle"));
                intent.putExtra("extra_article_url", com.tencent.mm.plugin.webview.c.c.n(map, "articleSource"));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!be.kS(str)) {
            com.tencent.mm.ay.c.b(aa.getContext(), "emoji", str, intent);
        }
        return false;
    }

    static /* synthetic */ boolean bs(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biZ();
        return com.tencent.mm.plugin.webview.c.b.L(kVar.iaJ);
    }

    static /* synthetic */ boolean bv(i iVar, k kVar) {
        int i = be.getInt((String) kVar.iaJ.get("cmd"), 0);
        String str = (String) kVar.iaJ.get("param");
        ft ftVar = new ft();
        ftVar.bff.of = i;
        ftVar.bff.bfh = str;
        com.tencent.mm.sdk.c.a.nhr.z(ftVar);
        Map hashMap = new HashMap();
        hashMap.put("result", ftVar.bfg.bfi);
        iVar.a(kVar, "getGameMessages:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean bw(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.bkm);
        intent.putExtra("nonceStr", dVar.bkl);
        intent.putExtra("packageExt", dVar.bkn);
        intent.putExtra("signtype", dVar.bkk);
        intent.putExtra("paySignature", dVar.bko);
        intent.putExtra("url", dVar.url);
        ((MMActivity) iVar.context).nDS = iVar;
        com.tencent.mm.ay.c.a(iVar.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        return true;
    }

    static /* synthetic */ boolean bx(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.c.b biZ = com.tencent.mm.plugin.webview.e.e.biZ();
        Map map = kVar.iaJ;
        v.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String n = com.tencent.mm.plugin.webview.c.c.n(map, "data");
        boolean b = com.tencent.mm.plugin.webview.c.c.b(map, "append", false);
        Runnable aVar = new a();
        aVar.data = n;
        aVar.ldv = b;
        com.tencent.mm.sdk.i.e.a(aVar, "append_music_list_task");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean by(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r12, com.tencent.mm.plugin.webview.ui.tools.jsapi.k r13) {
        /*
        r11 = 9;
        r10 = 1;
        r9 = 0;
        r12.fHM = r9;
        r0 = com.tencent.mm.plugin.webview.e.e.biZ();
        r1 = r13.iaJ;
        r2 = "MicroMsg.FTS.FTSWebViewLogic";
        r3 = "clickSnsMusicPlayButton %s";
        r4 = new java.lang.Object[r10];
        r5 = r1.toString();
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = "isLoop";
        r2 = com.tencent.mm.plugin.webview.c.c.b(r1, r2, r9);
        r3 = "needStartMusicUI";
        r3 = com.tencent.mm.plugin.webview.c.c.b(r1, r3, r9);
        r4 = "snsid";
        r4 = com.tencent.mm.plugin.webview.c.c.n(r1, r4);
        r5 = "webview_instance_id";
        r5 = r1.get(r5);
        r6 = -1;
        r5 = com.tencent.mm.sdk.platformtools.be.n(r5, r6);
        r6 = com.tencent.mm.ai.b.HC();
        if (r6 == 0) goto L_0x005a;
    L_0x0044:
        r6 = com.tencent.mm.ai.b.HE();
        r7 = r6.mJV;
        if (r7 != r11) goto L_0x005a;
    L_0x004c:
        r6 = r6.mJW;
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        com.tencent.mm.ai.b.HB();
        if (r3 != 0) goto L_0x005a;
    L_0x0059:
        return r9;
    L_0x005a:
        if (r3 == 0) goto L_0x0079;
    L_0x005c:
        r4 = r0.lds;
        if (r4 == 0) goto L_0x0079;
    L_0x0060:
        r4 = r0.lds;
        r6 = new com.tencent.mm.e.a.ic;
        r6.<init>();
        r7 = r6.bhZ;
        r8 = 5;
        r7.action = r8;
        r7 = r6.bhZ;
        r7.bed = r4;
        r4 = r6.bhZ;
        r4.bid = r10;
        r4 = com.tencent.mm.sdk.c.a.nhr;
        r4.z(r6);
    L_0x0079:
        r4 = "objectXmlDesc";
        r1 = com.tencent.mm.plugin.webview.c.c.n(r1, r4);
        r1 = com.tencent.mm.modelsns.d.ko(r1);
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.xq();
        r1 = com.tencent.mm.ai.b.a(r4, r1, r11);
        r1.mKo = r2;
        com.tencent.mm.ai.b.a(r1);
        if (r3 == 0) goto L_0x00b4;
    L_0x0096:
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "key_scene";
        r3 = 4;
        r1.putExtra(r2, r3);
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r1.setFlags(r2);
        r2 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r3 = "music";
        r4 = ".ui.MusicMainUI";
        com.tencent.mm.ay.c.b(r2, r3, r4, r1);
    L_0x00b4:
        r0 = r0.ldn;
        r1 = java.lang.Integer.valueOf(r5);
        r0.add(r1);
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.by(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, com.tencent.mm.plugin.webview.ui.tools.jsapi.k):boolean");
    }

    static /* synthetic */ boolean cB(i iVar, k kVar) {
        v.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) kVar.iaJ.get("sendId");
        int parseInt = Integer.parseInt((String) kVar.iaJ.get("hbKind"));
        if (be.kS(str)) {
            iVar.a(kVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            v.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", new Object[]{str, Integer.valueOf(parseInt)});
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (parseInt == 2) {
                com.tencent.mm.ay.c.b(iVar.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.ay.c.b(iVar.context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            }
            iVar.a(kVar, "openLuckyMoneyDetailView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cC(i iVar, final k kVar) {
        v.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        final String str = (String) kVar.iaJ.get("transactionId");
        final String str2 = (String) kVar.iaJ.get("receiverName");
        if (be.kS(str) || be.kS(str2)) {
            iVar.a(kVar, "doResendRemittanceMsg:fail", null);
        } else {
            g.a(iVar.context, 2131234483, 2131231139, 2131234537, 2131231010, new OnClickListener(iVar) {
                final /* synthetic */ i lpR;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("transaction_id", str);
                    intent.putExtra("receiver_name", str2);
                    com.tencent.mm.ay.c.b(this.lpR.context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                    this.lpR.a(kVar, "doResendRemittanceMsg:ok", null);
                }
            }, new OnClickListener(iVar) {
                final /* synthetic */ i lpR;

                {
                    this.lpR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    static /* synthetic */ boolean cF(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", new Object[]{(String) kVar.iaJ.get("localId")});
        x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(r0);
        if (DW == null || TextUtils.isEmpty(DW.lel)) {
            v.e("MicroMsg.MsgHandler", "the item is null or the File item not exist for localId:%s", new Object[]{DW.bde});
            iVar.a(kVar, "previewVideo:fail", null);
        } else if (new File(DW.lel).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", DW.lel);
            if (iVar.context instanceof MMActivity) {
                ((MMActivity) iVar.context).nDS = iVar;
                com.tencent.mm.ay.c.b(iVar.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", new Object[]{DW.lel});
            iVar.a(kVar, "previewVideo:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean cH(i iVar, k kVar) {
        boolean z = false;
        String str = (String) kVar.iaJ.get("url");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "url is null or nil");
            iVar.a(kVar, "openCunstonWebview:fail_invalid_url", null);
        } else {
            int i;
            boolean z2;
            boolean z3;
            Intent intent;
            String ma = be.ma((String) kVar.iaJ.get("orientation"));
            if (!be.kS(ma)) {
                if (ma.equals("horizontal")) {
                    i = 0;
                } else if (ma.equals("vertical")) {
                    i = 1;
                }
                z2 = be.ma((String) kVar.iaJ.get("fullscreen")).equals("true");
                z3 = be.ma((String) kVar.iaJ.get("finish_recent_webview")).equals("1");
                if (be.ma((String) kVar.iaJ.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                com.tencent.mm.ay.c.b(iVar.context, "webview", ".ui.tools.WebViewUI", intent);
                if (z3) {
                    ad.g(new Runnable(iVar) {
                        final /* synthetic */ i lpR;

                        {
                            this.lpR = r1;
                        }

                        public final void run() {
                            this.lpR.l(new k());
                        }
                    }, 200);
                }
                iVar.a(kVar, "openCunstonWebview:ok", null);
            }
            i = -1;
            if (be.ma((String) kVar.iaJ.get("fullscreen")).equals("true")) {
            }
            if (be.ma((String) kVar.iaJ.get("finish_recent_webview")).equals("1")) {
            }
            if (be.ma((String) kVar.iaJ.get("disable_swipe_back")).equals("1")) {
                z = true;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            com.tencent.mm.ay.c.b(iVar.context, "webview", ".ui.tools.WebViewUI", intent);
            if (z3) {
                ad.g(/* anonymous class already generated */, 200);
            }
            iVar.a(kVar, "openCunstonWebview:ok", null);
        }
        return true;
    }

    static /* synthetic */ void cK(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(3)});
        v.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) iVar.context, "android.permission.CAMERA", 113, "", ""))});
        if (com.tencent.mm.pluginsdk.i.a.a((Activity) iVar.context, "android.permission.CAMERA", 113, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_capture", 3);
            intent.putExtra("key_pick_local_pic_query_source_type", 8);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_pick_local_pic_count", 1);
            v.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
            if (iVar.context instanceof MMActivity) {
                ((MMActivity) iVar.context).nDS = iVar;
                com.tencent.mm.ay.c.a(iVar.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
                return;
            }
            return;
        }
        iVar.a(kVar, "chooseIdCard:fail", null);
    }

    static /* synthetic */ void cL(i iVar, final k kVar) {
        if (iVar.context == null) {
            iVar.a(kVar, "chooseIdCard:fail", null);
            return;
        }
        if (!iVar.lpv.a("identity_pay_auth", iVar.context, new com.tencent.mm.plugin.webview.e.d.a(iVar) {
            final /* synthetic */ i lpR;

            public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                if (bitmap == null) {
                    this.lpR.a(kVar, "chooseIdCard:fail", null);
                    return;
                }
                try {
                    String str2 = com.tencent.mm.compatible.util.e.cng + "tmpScanLicense/";
                    v.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[]{str2});
                    if (FileOp.aR(str2)) {
                        FileOp.B(str2, true);
                    }
                    FileOp.jS(str2);
                    FileOp.jU(str2);
                    str2 = str2 + System.currentTimeMillis() + ".jpg";
                    v.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[]{str2});
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, str2, true);
                    x DT = x.DT(str2);
                    com.tencent.mm.plugin.webview.e.e.bjd().b(DT);
                    Map hashMap = new HashMap();
                    hashMap.put("sourceType", "scan");
                    hashMap.put("localId", DT.bde);
                    this.lpR.a(kVar, "chooseIdCard:ok", hashMap);
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[]{e.getMessage()});
                    this.lpR.a(kVar, "chooseIdCard:fail", null);
                }
            }

            public final void Ex(String str) {
                this.lpR.a(kVar, "chooseIdCard:cancel", null);
            }

            public final void Bj(String str) {
                this.lpR.a(kVar, "chooseIdCard:fail", null);
            }
        })) {
            iVar.a(kVar, "chooseIdCard:fail", null);
        }
    }

    static /* synthetic */ boolean cd(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = be.getInt((String) kVar.iaJ.get("tid"), 0);
        String str = (String) kVar.iaJ.get("title");
        String str2 = (String) kVar.iaJ.get("desc");
        String str3 = (String) kVar.iaJ.get("iconUrl");
        String str4 = (String) kVar.iaJ.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        iVar.a(kVar, "openEmoticonTopicList", null);
        return true;
    }

    static /* synthetic */ boolean ce(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) kVar.iaJ.get("ProductId");
        v.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", new Object[]{Long.valueOf(be.getLong((String) kVar.iaJ.get("searchID"), 0))});
        if (be.kS(str)) {
            v.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            iVar.a(kVar, "openEmotionDetailView", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (iVar.lpt) {
            v.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.ay.c.b(iVar.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            iVar.lpt = true;
        }
        iVar.a(kVar, "openEmotionDetailView", null);
        com.tencent.mm.plugin.report.service.g.iuh.h(13055, new Object[]{Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.z.a.Et()), Long.valueOf(r4)});
        return true;
    }

    static /* synthetic */ boolean cf(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biY();
        Map map = kVar.iaJ;
        String Er = com.tencent.mm.z.a.Er();
        if (be.kS(Er)) {
            v.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            return false;
        }
        int o = com.tencent.mm.plugin.webview.b.a.o(map, Columns.TYPE);
        String n = com.tencent.mm.plugin.webview.b.a.n(map, "pageName");
        String n2 = com.tencent.mm.plugin.webview.b.a.n(map, "keyword");
        int o2 = com.tencent.mm.plugin.webview.b.a.o(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + Er + "/" + n + "?type=" + o + "&keyword=" + n2 + "&scene=" + o2 + "&lang=" + com.tencent.mm.sdk.platformtools.u.dJ(aa.getContext()) + "&clientType=1&version=" + com.tencent.mm.z.a.Et());
        intent.putExtra("keyword", n2);
        intent.putExtra(Columns.TYPE, o);
        intent.putExtra("sence", o2);
        com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.iuh.h(13055, new Object[]{Integer.valueOf(1), "", "", Integer.valueOf(o), Integer.valueOf(com.tencent.mm.z.a.Et()), Long.valueOf(0)});
        jy jyVar = new jy();
        jyVar.bkB.type = o;
        jyVar.bkB.bkC = n2;
        jyVar.bkB.bkD = "";
        com.tencent.mm.sdk.c.a.nhr.z(jyVar);
        return true;
    }

    static /* synthetic */ boolean ch(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.biY();
        String n = com.tencent.mm.plugin.webview.b.a.n(kVar.iaJ, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", n);
        com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return false;
    }

    static /* synthetic */ boolean ci(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "Note:doWNNoteOnClick");
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.bjb();
        return com.tencent.mm.plugin.webview.f.b.Q(kVar.iaJ);
    }

    static /* synthetic */ boolean cj(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.bjb();
        return true;
    }

    static /* synthetic */ boolean ck(i iVar, k kVar) {
        iVar.fHM = false;
        ak.vA().f(new Runnable(com.tencent.mm.plugin.webview.e.e.bjb()) {
            final /* synthetic */ b lsG;

            {
                this.lsG = r1;
            }

            public final void run() {
                Bundle bundle = new Bundle();
                bundle.putInt("operation_type", 7);
                j.tl(b.lsB).O(bundle);
            }
        }, 20);
        return false;
    }

    static /* synthetic */ boolean cm(i iVar, k kVar) {
        iVar.fHM = false;
        com.tencent.mm.plugin.webview.e.e.bjb();
        return com.tencent.mm.plugin.webview.f.b.blR();
    }

    static /* synthetic */ boolean cq(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) iVar.context).nDS = iVar;
        Bundle O = k.O(kVar.iaJ);
        Intent intent = new Intent();
        intent.putExtras(O);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        com.tencent.mm.ay.c.b(iVar.context, "soter_mp", ".ui.SoterAuthenticationUI", intent, 38);
        return true;
    }

    static /* synthetic */ boolean cr(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "hy: do get soter support");
        gk gkVar = new gk();
        com.tencent.mm.sdk.c.a.nhr.z(gkVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(gkVar.bfV.bfW));
        iVar.a(kVar, "getSupportSoter", hashMap);
        a(kVar, 0, gkVar.bfV.bfW == 1 ? 1 : 0);
        return true;
    }

    static /* synthetic */ boolean cs(i iVar, k kVar) {
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
        Intent intent = new Intent();
        String str = (String) kVar.iaJ.get("appId");
        if (iVar.lpj != null) {
            if (TextUtils.isEmpty(str)) {
                str = iVar.lpj.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = iVar.lps.Fu(iVar.Ra());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", dVar.bkm);
        intent.putExtra("nonceStr", dVar.bkl);
        intent.putExtra("packageExt", dVar.bkn);
        intent.putExtra("signtype", dVar.bkk);
        intent.putExtra("paySignature", dVar.bko);
        intent.putExtra("url", iVar.Ra());
        ((MMActivity) iVar.context).nDS = iVar;
        com.tencent.mm.ay.c.a(iVar.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        return true;
    }

    static /* synthetic */ boolean cu(i iVar, k kVar) {
        iVar.fHM = false;
        switch (be.getInt(kVar.iaJ.get("scene").toString().trim(), 0)) {
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case y.CTRL_INDEX /*39*/:
                String obj = kVar.iaJ.get("chat_username").toString();
                Intent intent = new Intent();
                intent.putExtra("Chat_User", obj);
                intent.putExtra("finish_direct", true);
                intent.putExtra("expose_edit_mode", true);
                intent.setFlags(536870912);
                if (iVar.context instanceof MMActivity) {
                    com.tencent.mm.ay.c.a((MMActivity) iVar.context, ".ui.chatting.ChattingUI", intent, 40, iVar);
                    break;
                }
                break;
        }
        return true;
    }

    static /* synthetic */ boolean cx(i iVar, k kVar) {
        String ma = be.ma((String) kVar.iaJ.get("toUsername"));
        String ma2 = be.ma((String) kVar.iaJ.get("scene"));
        String ma3 = be.ma((String) kVar.iaJ.get(Columns.TYPE));
        String ma4 = be.ma((String) kVar.iaJ.get("allowBackCamera"));
        String ma5 = be.ma((String) kVar.iaJ.get("showOther"));
        String ma6 = be.ma((String) kVar.iaJ.get("avatarUrl"));
        String ma7 = be.ma((String) kVar.iaJ.get("context"));
        v.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + ma + ",scene:" + ma2 + ",type:" + ma3 + ",allowBackCamera:" + ma4 + ",showOther:" + ma5 + ",avatarUrl:" + ma6 + ",voipCSContext:" + ma7);
        String str = (String) kVar.iaJ.get("appId");
        if (str == null || str.equals("") || ma == null || ma.equals("")) {
            iVar.a(kVar, "startVoipCall:param invalid", null);
        } else {
            iVar.lpH = kVar;
            com.tencent.mm.sdk.c.a.nhr.e(iVar.lpI);
            if (ma.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.ay.c.b(aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", ma);
                intent2.putExtra("voipCSScene", ma2);
                intent2.putExtra("voipCSType", ma3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", ma4);
                intent2.putExtra("voipCSShowOther", ma5);
                intent2.putExtra("voipCSAvatarUrl", ma6);
                intent2.putExtra("voipCSContext", ma7);
                com.tencent.mm.ay.c.b(aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
            }
        }
        return true;
    }

    static /* synthetic */ boolean d(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doGoVideoPlayerUI");
        String str = (String) kVar.iaJ.get("streamingUrl");
        int i = (int) be.getDouble((String) kVar.iaJ.get("streamingVideoTime"), 0.0d);
        String str2 = (String) kVar.iaJ.get("btnTitle");
        String str3 = (String) kVar.iaJ.get("jumpUrl");
        String str4 = (String) kVar.iaJ.get("shareTitle");
        String str5 = (String) kVar.iaJ.get("shareThumbUrl");
        int i2 = be.getInt((String) kVar.iaJ.get("shareBtnHidden"), 0);
        String str6 = (String) kVar.iaJ.get("reportArgs");
        int i3 = be.getInt((String) kVar.iaJ.get("needReportData"), 0);
        Intent intent = new Intent();
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", str);
        intent.putExtra("StreamWording", str2);
        intent.putExtra("StremWebUrl", str3);
        intent.putExtra("KThumUrl", str5);
        intent.putExtra("KMediaId", "fakeid_" + str5.hashCode());
        intent.putExtra("KMediaVideoTime", i);
        intent.putExtra("KMediaTitle", str4);
        intent.putExtra("ShareBtnHidden", i2);
        intent.putExtra("ReportArgs", str6);
        intent.putExtra("NeedReportData", i3);
        com.tencent.mm.ay.c.b(iVar.context, "sns", ".ui.VideoAdPlayerUI", intent);
        iVar.a(kVar, "playStreamingVideo:ok", null);
        return true;
    }

    static /* synthetic */ void e(i iVar) {
        com.tencent.mm.sdk.c.a.nhr.e(iVar.iSE);
        iVar.lpC = (LocationManager) iVar.context.getSystemService("location");
        lpr = iVar.aJ(iVar.lpf);
        iVar.lpo = iVar.leB;
        lpq = iVar.context;
        iVar.lpg = iVar.lpf;
    }

    static /* synthetic */ boolean e(i iVar, final k kVar) {
        String str = (String) kVar.iaJ.get("webtype");
        String str2 = (String) kVar.iaJ.get("username");
        String str3 = (String) kVar.iaJ.get("scene");
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            iVar.FB(str3);
            int i = be.getInt(str, -1);
            if (i != -1) {
                m.a(kVar.lqY, false, str2, null);
                switch (i) {
                    case 1:
                        new com.tencent.mm.pluginsdk.ui.applet.b(iVar.context, str2, iVar.lpj == null ? 33 : iVar.lpj.getInt("Contact_Scene", 33), new com.tencent.mm.pluginsdk.ui.applet.b.a(iVar) {
                            final /* synthetic */ i lpR;

                            public final void mH(int i) {
                                switch (i) {
                                    case ai.CTRL_INDEX /*-2*/:
                                        this.lpR.a(kVar, "add_contact:added", null);
                                        return;
                                    case -1:
                                        this.lpR.a(kVar, "add_contact:fail", null);
                                        return;
                                    case 0:
                                        this.lpR.a(kVar, "add_contact:cancel", null);
                                        return;
                                    case 1:
                                        this.lpR.a(kVar, "add_contact:ok", null);
                                        return;
                                    default:
                                        this.lpR.a(kVar, "add_contact:fail", null);
                                        return;
                                }
                            }
                        }).show();
                        break;
                    default:
                        v.e("MicroMsg.MsgHandler", "unknown addScene = " + i);
                        iVar.a(kVar, "add_contact:fail", null);
                        break;
                }
            }
            v.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = " + str);
            iVar.a(kVar, "add_contact:fail", null);
        } else {
            v.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            iVar.a(kVar, "add_contact:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean g(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "jslog : " + kVar.iaJ.get("msg"));
        iVar.fHM = false;
        return false;
    }

    static /* synthetic */ boolean h(i iVar, final k kVar) {
        if (com.tencent.mm.pluginsdk.j.a.bmr().aeZ()) {
            g.a(iVar.context, iVar.context.getString(2131232444), "", null).setOnDismissListener(new OnDismissListener(iVar) {
                final /* synthetic */ i lpR;

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.lpR.a(kVar, "add_emoticon:download_failed", null);
                }
            });
            return true;
        }
        final String str = (String) kVar.iaJ.get("url");
        String str2 = (String) kVar.iaJ.get("thumb_url");
        String str3 = (String) kVar.iaJ.get("appid");
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.MsgHandler", "doAddEmotIcon fail,invalid arguments,no EmotUrl or thumb_url");
            iVar.a(kVar, "add_emoticon:no_url", null);
            return true;
        } else if (iVar.map == null || !iVar.map.containsKey(str)) {
            v.v("MicroMsg.MsgHandler", "doAddEmotIcon begin");
            if (iVar.map == null) {
                iVar.map = new HashMap();
            }
            m.a(kVar.lqY, false, null, str3);
            c cVar = new c(iVar.leB, kVar, str, str2, str3, iVar);
            cVar.loi = new com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a(iVar) {
                final /* synthetic */ i lpR;

                public final void remove() {
                    this.lpR.map.remove(str);
                }
            };
            cVar.start();
            iVar.map.put(str, cVar);
            iVar.fHM = false;
            return false;
        } else {
            v.v("MicroMsg.MsgHandler", "doAddEmotIcon ing,wait emotUrl : " + str);
            iVar.fHM = false;
            return false;
        }
    }

    static /* synthetic */ boolean i(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("url");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doHasEmotIcon fail,invalid arguments,EmotUrl =" + str);
            iVar.fHM = false;
            return false;
        } else if (com.tencent.mm.pluginsdk.j.a.bmr().ri(str)) {
            v.v("MicroMsg.MsgHandler", "has_emoticon:yes url : " + str);
            iVar.a(kVar, "has_emoticon:yes", null);
            return true;
        } else {
            v.v("MicroMsg.MsgHandler", "has_emoticon:no url : " + str);
            iVar.a(kVar, "has_emoticon:no", null);
            return true;
        }
    }

    static /* synthetic */ boolean j(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("url");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doCancelEmoticon fail,invalid arguments,EmotUrl =" + str);
            iVar.a(kVar, "cancel_add_emoticon:no_url", null);
        } else {
            v.v("MicroMsg.MsgHandler", "cancel_add_emoticon:try...emotUrl is " + str);
            if (com.tencent.mm.pluginsdk.j.a.bmr().ri(str)) {
                v.v("MicroMsg.MsgHandler", "cancel_add_emoticon:added");
                iVar.a(kVar, "cancel_add_emoticon:added", null);
            } else if (iVar.map == null || !iVar.map.containsKey(str)) {
                v.v("MicroMsg.MsgHandler", "cancel_add_emoticon:fail");
                iVar.a(kVar, "cancel_add_emoticon:fail", null);
            } else {
                ((c) iVar.map.get(str)).interrupt();
            }
        }
        return true;
    }

    static /* synthetic */ boolean k(i iVar, k kVar) {
        if (com.tencent.mm.sdk.platformtools.ak.isConnected(iVar.context)) {
            v.i("MicroMsg.MsgHandler", "getNetworkType, type = " + com.tencent.mm.sdk.platformtools.ak.getNetType(iVar.context));
            Map hashMap = new HashMap();
            if (com.tencent.mm.sdk.platformtools.ak.is2G(iVar.context)) {
                v.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                iVar.a(kVar, "network_type:wwan", hashMap);
            } else if (com.tencent.mm.sdk.platformtools.ak.is3G(iVar.context)) {
                v.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                iVar.a(kVar, "network_type:wwan", hashMap);
            } else if (com.tencent.mm.sdk.platformtools.ak.is4G(iVar.context)) {
                v.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                iVar.a(kVar, "network_type:wwan", hashMap);
            } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(iVar.context)) {
                v.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                iVar.a(kVar, "network_type:wifi", null);
            } else {
                v.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                iVar.a(kVar, "network_type:fail", null);
            }
        } else {
            v.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            iVar.a(kVar, "network_type:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean p(i iVar, k kVar) {
        v.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) kVar.iaJ.get("url");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (be.m(iVar.context, intent)) {
                iVar.context.startActivity(intent);
            }
        }
        iVar.fHM = false;
        return false;
    }

    static /* synthetic */ boolean q(i iVar, k kVar) {
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        v.i("MicroMsg.MsgHandler", "doPay");
        if (iVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            dVar.lVM = 1;
            com.tencent.mm.pluginsdk.wallet.e.a((MMActivity) iVar.context, dVar, 4, iVar);
            long j = be.getLong((String) kVar.iaJ.get("message_id"), 0);
            int i = be.getInt((String) kVar.iaJ.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.iuh.h(10593, new Object[]{dVar.bkp, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.bkq), dVar.url});
            iVar.lpw = iVar.aJ(kVar);
        }
        return true;
    }

    static /* synthetic */ boolean r(i iVar, k kVar) {
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        v.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) kVar.iaJ.get("url"));
        intent.putExtra("req_app_id", (String) kVar.iaJ.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (iVar.context instanceof MMActivity) {
            ((MMActivity) iVar.context).nDS = iVar;
            com.tencent.mm.ay.c.a(iVar.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        return true;
    }

    static /* synthetic */ boolean s(i iVar, k kVar) {
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.e.lTi == null) {
            v.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = new com.tencent.mm.pluginsdk.ui.tools.e();
            r.a(eVar);
            com.tencent.mm.pluginsdk.ui.tools.e.lTi = eVar;
            eVar.dm(iVar.context);
            com.tencent.mm.pluginsdk.ui.tools.e.lTi = eVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.lTi.bqP()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.lTi.getPitch()));
        v.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.lTi.bqP()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.lTi.getPitch())});
        iVar.a(kVar, "get_heading_and_pitch:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean u(i iVar, k kVar) {
        String str = (String) kVar.iaJ.get("task_name");
        String str2 = (String) kVar.iaJ.get("task_url");
        String str3 = (String) kVar.iaJ.get("file_md5");
        String str4 = (String) kVar.iaJ.get("extInfo");
        String str5 = (String) kVar.iaJ.get("fileType");
        String str6 = (String) kVar.iaJ.get("appid");
        String str7 = (String) kVar.iaJ.get("package_name");
        v.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str3 + ", url = " + str2 + ", extinfo = " + str4 + ", fileType = " + str5);
        ak.yW();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            iVar.a(kVar, "add_download_task:fail_sdcard_not_ready", null);
            n(str6, com.tencent.mm.pluginsdk.model.downloader.b.lBS, str4);
        } else if (be.kS(str2)) {
            v.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
            iVar.a(kVar, "add_download_task:fail_invalid_url", null);
            n(str6, com.tencent.mm.pluginsdk.model.downloader.b.DOWNLOAD_ERR_URL_INVALID, str4);
        } else {
            fs fsVar = new fs();
            fsVar.bfe.url = str2;
            fsVar.bfe.aZy = str3;
            fsVar.bfe.extInfo = str4;
            fsVar.bfe.appId = str6;
            com.tencent.mm.sdk.c.a.nhr.z(fsVar);
            com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
            aVar.GQ(str2);
            aVar.GR(str);
            aVar.GS(str3);
            aVar.setAppId(str6);
            aVar.GT(str7);
            aVar.hO(true);
            aVar.tE(be.getInt(str5, 1));
            long a = com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn);
            v.i("MicroMsg.MsgHandler", "doAddDownloadTask, downloadId = " + a);
            if (a <= 0) {
                v.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, downloadId = " + a);
                iVar.a(kVar, "add_download_task:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(a));
                iVar.a(kVar, "add_download_task:ok", hashMap);
            }
        }
        return true;
    }

    static /* synthetic */ boolean v(i iVar, k kVar) {
        long j = be.getLong((String) kVar.iaJ.get("download_id"), -1);
        v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            v.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            iVar.a(kVar, "cancel_download_task:fail", null);
        } else {
            int dm = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(j);
            v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + dm);
            if (dm <= 0) {
                iVar.a(kVar, "cancel_download_task:fail", null);
            } else {
                iVar.a(kVar, "cancel_download_task:ok", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean w(i iVar, k kVar) {
        long j = be.getLong((String) kVar.iaJ.get("download_id"), -1);
        v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            v.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            iVar.a(kVar, "pause_download_task:fail", null);
        } else {
            boolean z = com.tencent.mm.pluginsdk.model.downloader.d.bnK().do(j);
            v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + z);
            if (z) {
                iVar.a(kVar, "pause_download_task:ok", null);
            } else {
                iVar.a(kVar, "pause_download_task:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean x(i iVar, k kVar) {
        long j = be.getLong((String) kVar.iaJ.get("download_id"), -1);
        v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            v.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            iVar.a(kVar, "resume_download_task:fail", null);
        } else {
            boolean dp = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dp(j);
            v.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + dp);
            if (dp) {
                iVar.a(kVar, "resume_download_task:ok", null);
            } else {
                iVar.a(kVar, "resume_download_task:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean y(i iVar, k kVar) {
        long j = be.getLong((String) kVar.iaJ.get("download_id"), -1);
        String str = (String) kVar.iaJ.get("appid");
        String str2 = (String) kVar.iaJ.get("appIdArray");
        v.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
        if (!be.kS(str2)) {
            return iVar.a(str2, kVar);
        }
        com.tencent.mm.pluginsdk.model.downloader.f dn;
        if (j > 0) {
            dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(j);
        } else if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
            iVar.a(kVar, "query_download_task:fail", null);
            return true;
        } else {
            dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(str);
        }
        switch (dn.status) {
            case -1:
                v.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                iVar.a(kVar, "query_download_task:fail_apilevel_too_low", null);
                return true;
            case 1:
                str2 = "downloading";
                break;
            case 2:
                str2 = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.aR(dn.path)) {
                    str2 = "default";
                    break;
                }
                str2 = "download_succ";
                break;
            case 4:
                str2 = "download_fail";
                break;
            default:
                str2 = "default";
                break;
        }
        v.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str2);
        Map hashMap = new HashMap();
        hashMap.put("state", str2);
        hashMap.put("download_id", Long.valueOf(dn.id));
        if (str2 == "downloading" && dn.beE != 0) {
            hashMap.put("progress", Long.valueOf((long) ((((float) dn.beD) / ((float) dn.beE)) * 100.0f)));
        }
        iVar.a(kVar, "query_download_task:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean z(i iVar, k kVar) {
        long j = be.getLong((String) kVar.iaJ.get("download_id"), -1);
        v.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = " + j);
        if (j <= 0) {
            v.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = " + j);
        } else {
            com.tencent.mm.pluginsdk.model.downloader.f dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(j);
            if (dn.status == -1) {
                v.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                iVar.a(kVar, "install_download_task:fail_apilevel_too_low", null);
            } else if (dn.status != 3) {
                v.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + dn.status);
            } else if (com.tencent.mm.a.e.aR(dn.path)) {
                iVar.a(kVar, com.tencent.mm.pluginsdk.model.app.p.c(iVar.context, Uri.fromFile(new File(dn.path))) ? "install_download_task:ok" : "install_download_task:fail", null);
            }
            return true;
        }
        iVar.a(kVar, "install_download_task:fail", null);
        return true;
    }

    static {
        HashSet hashSet = new HashSet();
        dGF = hashSet;
        hashSet.add("gcj02");
        dGF.add("wgs84");
    }

    i(int i) {
        this.bkE = i;
        this.fHM = false;
        this.lph = new HashSet();
        this.lpi = new HashSet();
        this.lps = new e(this.bkE);
        this.lpu = new l();
        this.lpv = new d();
    }

    public final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        v.i("MicroMsg.MsgHandler", "set context and callbacker");
        this.context = context;
        if (this.lps != null) {
            this.lps.context = context;
        }
        this.leB = eVar;
    }

    public final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar, com.tencent.mm.plugin.webview.stub.e eVar2) {
        v.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.lps != null) {
            this.lps.context = context;
        }
        this.leB = eVar;
        this.lpp = eVar2;
    }

    public final Bundle blp() {
        if (this.lpj == null) {
            this.lpj = new Bundle();
        }
        return this.lpj;
    }

    public final String FA(String str) {
        if (this.lps != null) {
            return this.lps.Fu(str);
        }
        v.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
        return null;
    }

    private void FB(String str) {
        if (this.lpj == null) {
            this.lpj = new Bundle();
        }
        int i = be.getInt(str, 33);
        if (this.lpj.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.lpj.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.lpj.putInt("Contact_Scene", i);
    }

    private boolean FC(String str) {
        v.i("MicroMsg.MsgHandler", "getFromMenu, functionName = " + str);
        if (!this.lph.contains(str)) {
            return false;
        }
        this.lph.remove(str);
        return true;
    }

    public final boolean FD(String str) {
        v.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", new Object[]{str, Boolean.valueOf(this.lpi.remove(str))});
        return this.lpi.remove(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.k r21, com.tencent.mm.protocal.JsapiPermissionWrapper r22) {
        /*
        r20 = this;
        r0 = r20;
        r4 = r0.fHM;
        if (r4 == 0) goto L_0x000f;
    L_0x0006:
        r4 = "MicroMsg.MsgHandler";
        r5 = "handleMsg, MsgHandler is busy, old msg will be overrided";
        com.tencent.mm.sdk.platformtools.v.w(r4, r5);
    L_0x000f:
        r0 = r20;
        r4 = r0.lpj;
        if (r4 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r20;
        r4 = r0.lpj;
        r5 = r20.getClass();
        r5 = r5.getClassLoader();
        r4.setClassLoader(r5);
    L_0x0024:
        r0 = r21;
        r1 = r20;
        r1.lpf = r0;
        r4 = 1;
        r0 = r20;
        r0.fHM = r4;
        r0 = r21;
        r4 = r0.type;
        r5 = "call";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0160;
    L_0x003c:
        r0 = r21;
        r4 = r0.lqZ;
        r0 = r20;
        r0.lpn = r4;
        r0 = r21;
        r4 = r0.lqZ;
        r4 = com.tencent.mm.plugin.webview.ui.tools.a.EP(r4);
        r5 = -1;
        if (r5 == r4) goto L_0x005a;
    L_0x004f:
        r5 = com.tencent.mm.plugin.report.service.g.iuh;
        r6 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r8 = (long) r4;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);
    L_0x005a:
        r0 = r20;
        r4 = r0.lpn;
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r4);
        r5 = com.tencent.mm.protocal.c.Is(r4);
        if (r5 != 0) goto L_0x008a;
    L_0x0068:
        r4 = "MicroMsg.MsgHandler";
        r5 = "unknown function = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r20;
        r8 = r0.lpn;
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
        r6 = "system:function_not_exist";
        r7 = 0;
        r8 = 1;
        r9 = 0;
        r4 = r20;
        r5 = r21;
        r4.a(r5, r6, r7, r8, r9);
        r4 = 1;
    L_0x0089:
        return r4;
    L_0x008a:
        r4 = r5.getName();
        r0 = r20;
        r6 = r0.lpi;
        r4 = r6.contains(r4);
        if (r4 != 0) goto L_0x00c6;
    L_0x0098:
        r4 = r5.brs();
        r0 = r22;
        r4 = r0.uB(r4);
        if (r4 != 0) goto L_0x00c6;
    L_0x00a4:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.v.e(r4, r6, r7);
        r6 = "system:access_denied";
        r7 = 0;
        r8 = 1;
        r9 = 0;
        r4 = r20;
        r5 = r21;
        r4.a(r5, r6, r7, r8, r9);
        r4 = 1;
        goto L_0x0089;
    L_0x00c6:
        r4 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i$1;	 Catch:{ Exception -> 0x0140 }
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r4.<init>(r0, r1, r5, r2);	 Catch:{ Exception -> 0x0140 }
        r0 = r20;
        r0 = r0.lps;	 Catch:{ Exception -> 0x0140 }
        r18 = r0;
        r0 = r20;
        r6 = r0.leB;	 Catch:{ Exception -> 0x0140 }
        r7 = r6.Ra();	 Catch:{ Exception -> 0x0140 }
        r5 = r5.brs();	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r9 = r0.lqZ;	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r9);	 Catch:{ Exception -> 0x0140 }
        if (r6 == 0) goto L_0x010a;
    L_0x00ed:
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "jsapi is null, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0140 }
        r9 = 0;
        r8[r9] = r7;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r6, r8);	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
    L_0x0105:
        r4 = r4.blc();	 Catch:{ Exception -> 0x0140 }
        goto L_0x0089;
    L_0x010a:
        if (r22 == 0) goto L_0x0118;
    L_0x010c:
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r7);	 Catch:{ Exception -> 0x0140 }
        if (r6 != 0) goto L_0x0118;
    L_0x0112:
        r0 = r22;
        r6 = r0.lWx;	 Catch:{ Exception -> 0x0140 }
        if (r6 != 0) goto L_0x0184;
    L_0x0118:
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
        r5 = 3;
        r10 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0140 }
        r5 = 0;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0140 }
        r5 = 1;
        r10[r5] = r9;	 Catch:{ Exception -> 0x0140 }
        r7 = 2;
        if (r22 == 0) goto L_0x0182;
    L_0x012a:
        r5 = 1;
    L_0x012b:
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0140 }
        r10[r7] = r5;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r8, r10);	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0140 }
        r6 = "localParameters";
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0140:
        r4 = move-exception;
        r5 = "MicroMsg.MsgHandler";
        r6 = "handleMsg excpetion %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.getMessage();
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.v.e(r5, r6, r7);
        r5 = "MicroMsg.MsgHandler";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r5, r4, r6, r7);
    L_0x0160:
        r4 = "MicroMsg.MsgHandler";
        r5 = new java.lang.StringBuilder;
        r6 = "unknown type = ";
        r5.<init>(r6);
        r0 = r21;
        r6 = r0.type;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.e(r4, r5);
        r4 = 0;
        r0 = r20;
        r0.fHM = r4;
        r4 = 0;
        goto L_0x0089;
    L_0x0182:
        r5 = 0;
        goto L_0x012b;
    L_0x0184:
        r0 = r22;
        r17 = r0.uB(r5);	 Catch:{ Exception -> 0x0140 }
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "handleJSVerify jsApi = %s, permission = %s currentUrl = %s";
        r8 = 3;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0140 }
        r10 = 0;
        r8[r10] = r9;	 Catch:{ Exception -> 0x0140 }
        r10 = 1;
        r11 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0140 }
        r8[r10] = r11;	 Catch:{ Exception -> 0x0140 }
        r10 = 2;
        r8[r10] = r7;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r8);	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r5 = r0.lok;	 Catch:{ Exception -> 0x0140 }
        r5 = r5.get(r7);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r5);	 Catch:{ Exception -> 0x0140 }
        if (r6 == 0) goto L_0x0383;
    L_0x01b3:
        r0 = r21;
        r5 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r6 = "verifyAppId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r12 = r5;
    L_0x01c1:
        r0 = r21;
        r5 = r0.lqY;	 Catch:{ Exception -> 0x0140 }
        r6 = "permissionValue";
        r8 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0140 }
        r5.put(r6, r8);	 Catch:{ Exception -> 0x0140 }
        r6 = "appId";
        r5.put(r6, r12);	 Catch:{ Exception -> 0x0140 }
        switch(r17) {
            case 0: goto L_0x0227;
            case 1: goto L_0x01fd;
            case 2: goto L_0x0208;
            case 3: goto L_0x025f;
            case 4: goto L_0x0232;
            default: goto L_0x01d8;
        };	 Catch:{ Exception -> 0x0140 }
    L_0x01d8:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0140 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0140 }
        r7 = "unkonwPermission_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0140 }
        r0 = r17;
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "unknow permission";
        com.tencent.mm.sdk.platformtools.v.e(r5, r6);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x01fd:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0208:
        r5 = "preVerifyJSAPI";
        r5 = r9.equals(r5);	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x021c;
    L_0x0211:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x021c:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0227:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0232:
        r0 = r18;
        r5 = r0.loj;	 Catch:{ Exception -> 0x0140 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0140 }
        r6.<init>();	 Catch:{ Exception -> 0x0140 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0140 }
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (com.tencent.mm.protocal.c.adp) r5;	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x025f;
    L_0x024f:
        r5 = r5.mEq;	 Catch:{ Exception -> 0x0140 }
        r6 = 1;
        if (r5 != r6) goto L_0x025f;
    L_0x0254:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x025f:
        r0 = r21;
        r5 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r6 = "verifySignature";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r6 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r8 = "verifyNonceStr";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0140 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r8 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r10 = "verifyTimestamp";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0140 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r10 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r11 = "verifySignType";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0140 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r13 = "scope";
        r16 = r11.get(r13);	 Catch:{ Exception -> 0x0140 }
        r16 = (java.lang.String) r16;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r13 = "addrSign";
        r11 = r11.get(r13);	 Catch:{ Exception -> 0x0140 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0140 }
        r13 = "MicroMsg.webview.JSVerifyHelper";
        r14 = "handleJSVerify addrSign = %s, signature = %s";
        r15 = 2;
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x0140 }
        r19 = 0;
        r15[r19] = r11;	 Catch:{ Exception -> 0x0140 }
        r19 = 1;
        r15[r19] = r5;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.v.i(r13, r14, r15);	 Catch:{ Exception -> 0x0140 }
        r15 = 0;
        r13 = com.tencent.mm.sdk.platformtools.be.kS(r5);	 Catch:{ Exception -> 0x0140 }
        if (r13 == 0) goto L_0x034c;
    L_0x02c8:
        r11 = com.tencent.mm.sdk.platformtools.be.kS(r11);	 Catch:{ Exception -> 0x0140 }
        if (r11 != 0) goto L_0x034c;
    L_0x02ce:
        r15 = 1;
        r0 = r21;
        r5 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r6 = "appId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r6 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r8 = "addrSign";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0140 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r8 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r10 = "signType";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0140 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r10 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r11 = "timeStamp";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0140 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r12 = "nonceStr";
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x0140 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0140 }
        r13 = r8;
        r12 = r6;
        r8 = r5;
    L_0x0313:
        r14 = 0;
        r0 = r21;
        r5 = r0.iaJ;	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.P(r5);	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x0326;
    L_0x031e:
        r5 = r5.toString();	 Catch:{ Exception -> 0x0140 }
        r14 = r5.getBytes();	 Catch:{ Exception -> 0x0140 }
    L_0x0326:
        r5 = 4;
        r0 = r17;
        if (r0 != r5) goto L_0x0359;
    L_0x032b:
        r5 = new com.tencent.mm.plugin.webview.d.l;	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r0 = r0.ldX;	 Catch:{ Exception -> 0x0140 }
        r17 = r0;
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.model.ak.vy();	 Catch:{ Exception -> 0x0140 }
        r7 = 1095; // 0x447 float:1.534E-42 double:5.41E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.model.ak.vy();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x034c:
        r11 = com.tencent.mm.sdk.platformtools.be.kS(r5);	 Catch:{ Exception -> 0x0140 }
        if (r11 != 0) goto L_0x037d;
    L_0x0352:
        r15 = 2;
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x0313;
    L_0x0359:
        r5 = 3;
        r0 = r17;
        if (r0 != r5) goto L_0x01d8;
    L_0x035e:
        r5 = new com.tencent.mm.plugin.webview.d.n;	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r15 = r0.ldX;	 Catch:{ Exception -> 0x0140 }
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.model.ak.vy();	 Catch:{ Exception -> 0x0140 }
        r7 = 1094; // 0x446 float:1.533E-42 double:5.405E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.model.ak.vy();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x037d:
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x0313;
    L_0x0383:
        r12 = r5;
        goto L_0x01c1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.k, com.tencent.mm.protocal.JsapiPermissionWrapper):boolean");
    }

    private boolean b(final k kVar) {
        v.d("MicroMsg.MsgHandler", "doShowDatePicker");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str;
            String str2;
            String str3;
            String str4 = (String) kVar.iaJ.get("current");
            if (be.kS(str4)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str4;
            }
            str4 = (String) kVar.iaJ.get("range");
            if (be.kS(str4)) {
                str = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str4);
                String optString = jSONObject.optString("start", "2013-01-01");
                str = jSONObject.optString("end", format);
                str2 = optString;
            }
            str4 = (String) kVar.iaJ.get("fields");
            if (be.kS(str4)) {
                str3 = "month";
            } else {
                str3 = str4;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                v.e("MicroMsg.MsgHandler", "context error!");
                return false;
            }
            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.context, new OnDateSetListener(this) {
                final /* synthetic */ i lpR;

                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    v.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)});
                    Map hashMap = new HashMap();
                    hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}));
                    this.lpR.a(kVar, "showDatePickerView:ok", hashMap);
                }
            }, instance.get(1), instance.get(2), instance.get(5), simpleDateFormat.parse(str2).getTime(), str3);
            gVar.setOnCancelListener(new OnCancelListener(this) {
                final /* synthetic */ i lpR;

                public final void onCancel(DialogInterface dialogInterface) {
                    v.i("MicroMsg.MsgHandler", "cancel date set");
                    this.lpR.a(kVar, "showDatePickerView:cancel", null);
                }
            });
            if (!be.kS(str2)) {
                v.d("MicroMsg.MsgHandler", "min date: %s", new Object[]{str2});
                gVar.getDatePicker().setMinDate(simpleDateFormat.parse(str2).getTime());
            }
            if (!be.kS(str)) {
                v.d("MicroMsg.MsgHandler", "max date: %s", new Object[]{str});
                gVar.getDatePicker().setMaxDate(simpleDateFormat.parse(str).getTime());
            }
            gVar.show();
            return true;
        } catch (JSONException e) {
        } catch (ParseException e2) {
        }
    }

    private boolean c(k kVar) {
        try {
            String str = (String) this.lpf.iaJ.get("link");
            m.a(this.lpf.lqY, FC(bk.NAME), str, null);
            if (str == null || str.length() == 0) {
                v.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.lpf, "timeline_check_in:fail", null);
                return true;
            }
            int intValue;
            truncate((String) this.lpf.iaJ.get("desc"));
            v.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.lpf.iaJ.get("img_url")) + ", title = " + ((String) this.lpf.iaJ.get("title")) + ", desc = " + ((String) this.lpf.iaJ.get("desc")));
            str = (String) this.lpf.iaJ.get("img_width");
            String str2 = (String) this.lpf.iaJ.get("img_height");
            v.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", new Object[]{(String) this.lpf.iaJ.get("link"), aj.Ec((String) this.lpf.iaJ.get("link"))});
            String str3 = (String) this.lpf.iaJ.get(Columns.TYPE);
            this.lpf.iaJ.get("desc");
            String str4 = (String) this.lpf.iaJ.get("title");
            String str5 = (String) this.lpf.iaJ.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!be.kS(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!be.kS(str3) && str3.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.lpf.iaJ.get("poiId");
            str2 = (String) this.lpf.iaJ.get("poiName");
            str3 = (String) this.lpf.iaJ.get("poiAddress");
            float f = be.getFloat((String) kVar.iaJ.get("latitude"), 0.0f);
            float f2 = be.getFloat((String) kVar.iaJ.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.ay.c.b(this.context, "sns", ".ui.SnsUploadUI", intent);
            this.fHM = false;
            return false;
        } catch (Exception e3) {
            return true;
        }
    }

    private boolean d(k kVar) {
        int i = 0;
        try {
            float f = be.getFloat((String) kVar.iaJ.get("latitude"), 0.0f);
            float f2 = be.getFloat((String) kVar.iaJ.get("longitude"), 0.0f);
            String ou = ou((String) kVar.iaJ.get("name"));
            String ou2 = ou((String) kVar.iaJ.get("address"));
            String ou3 = ou((String) kVar.iaJ.get("infoUrl"));
            try {
                i = be.getInt((String) kVar.iaJ.get("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (be.getInt((String) this.lpf.iaJ.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", ou3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", ou);
            intent.putExtra("Kwebmap_locaion", ou2);
            com.tencent.mm.ay.c.b(this.context, "location", ".ui.RedirectUI", intent);
            a(this.lpf, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.lpf, "open_location:invalid_coordinate", null);
        }
        return true;
    }

    private static String ou(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < dSF.length) {
                String str2 = dSG[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != dSF.length) {
                stringBuffer.append(dSF[i2]);
                i = dSG[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    private boolean e(k kVar) {
        try {
            String str = (String) kVar.iaJ.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.ay.c.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.lpf, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        return true;
    }

    private boolean f(k kVar) {
        boolean z = false;
        this.bhh = g(kVar);
        if (this.bhh == null) {
            v.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(kVar, "send_app_msg:fail", null);
        } else {
            String string = blp().getString("scene");
            blp().remove("scene");
            if (!"friend".equals(string)) {
                m.a(kVar.lqY, FC("sendAppMessage"), null, (String) kVar.iaJ.get("appid"));
            }
            v.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", new Object[]{string});
            String string2;
            if ("connector".equals(string)) {
                v.i("MicroMsg.MsgHandler", "directly send to %s", new Object[]{blq()});
                a(1, -1, new Intent().putExtra("Select_Conv_User", string2));
            } else if ("favorite".equals(string)) {
                v.i("MicroMsg.MsgHandler", "favorite url");
                bp bpVar = new bp();
                com.tencent.mm.plugin.webview.d.b.a aVar = new com.tencent.mm.plugin.webview.d.b.a();
                v.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{(String) this.lpf.iaJ.get("link"), aj.Ec((String) this.lpf.iaJ.get("link"))});
                aVar.url = r4;
                aVar.bea = (String) this.lpf.iaJ.get("img_url");
                aVar.title = (String) this.lpf.iaJ.get("title");
                aVar.desc = (String) this.lpf.iaJ.get("desc");
                aVar.bmJ = (String) this.lpf.iaJ.get("appid");
                if (this.lpj != null) {
                    string2 = this.lpj.getString("key_snsad_statextstr");
                    aVar.bnY = string2;
                } else {
                    string2 = null;
                }
                try {
                    Bundle i = this.leB.i(18, null);
                    if (i != null) {
                        String fz = o.fz(be.ma(i.getString("KPublisherId")));
                        com.tencent.mm.model.o.b n = o.yx().n(fz, true);
                        n.l("sendAppMsgScene", Integer.valueOf(2));
                        n.l("preChatName", i.getString("preChatName"));
                        n.l("preMsgIndex", Integer.valueOf(i.getInt("preMsgIndex")));
                        n.l("prePublishId", i.getString("prePublishId"));
                        n.l("preUsername", i.getString("preUsername"));
                        n.l("getA8KeyScene", Integer.valueOf(i.getInt("getA8KeyScene")));
                        n.l("referUrl", i.getString("referUrl"));
                        if (!be.kS(string2)) {
                            n.l("adExtStr", string2);
                        }
                        bpVar.aZd.aZj = fz;
                    }
                } catch (RemoteException e) {
                    v.e("MicroMsg.MsgHandler", "try to report error, %s", new Object[]{e});
                }
                if (this.context instanceof Activity) {
                    bpVar.aZd.aXH = (Activity) this.context;
                    bpVar.aZd.aZl = 36;
                }
                if (!be.kS(aVar.url)) {
                    z = true;
                }
                if (z) {
                    qf qfVar = new qf();
                    qg qgVar = new qg();
                    pw pwVar = new pw();
                    pwVar.IC(aVar.url);
                    pwVar.Iw(aVar.title);
                    pwVar.Ix(aVar.desc);
                    pwVar.IF(aVar.bea);
                    pwVar.IU(aVar.bnY);
                    pwVar.io(true);
                    pwVar.ip(true);
                    pwVar.uG(5);
                    qp qpVar = new qp();
                    qpVar.JD(aVar.bea);
                    qfVar.b(qpVar);
                    qgVar.Jn(com.tencent.mm.model.k.xF());
                    qgVar.Jo(com.tencent.mm.model.k.xF());
                    qgVar.uN(3);
                    qgVar.dV(be.Ni());
                    qgVar.Jt(aVar.bmJ);
                    qgVar.Ju(aVar.url);
                    bpVar.aZd.title = pwVar.title;
                    bpVar.aZd.aZf = qfVar;
                    bpVar.aZd.type = 5;
                    qfVar.a(qgVar);
                    qfVar.mtR.add(pwVar);
                } else {
                    v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
                    bpVar.aZd.aZk = 2131232653;
                }
                bpVar.aZd.aZn = new com.tencent.mm.ui.snackbar.b.c(this) {
                    final /* synthetic */ i lpR;

                    {
                        this.lpR = r1;
                    }

                    public final void aEU() {
                    }

                    public final void onHide() {
                        this.lpR.a(this.lpR.lpf, "send_app_msg:ok", null);
                    }

                    public final void blD() {
                    }
                };
                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                if (bpVar.aZe.ret == 0) {
                    cP(3, 1);
                } else {
                    cP(3, 2);
                    a(this.lpf, "send_fav_msg:fail", null);
                }
            } else if ("enterprise".equals(string)) {
                String blq = blq();
                Serializable hashMap = new HashMap();
                hashMap.put("img_url", (String) kVar.iaJ.get("img_url"));
                hashMap.put("desc", (String) kVar.iaJ.get("desc"));
                hashMap.put("title", (String) kVar.iaJ.get("title"));
                hashMap.put("src_username", (String) kVar.iaJ.get("src_username"));
                hashMap.put("src_displayname", (String) kVar.iaJ.get("src_displayname"));
                Intent intent;
                if (com.tencent.mm.modelbiz.e.hC(blq)) {
                    intent = new Intent();
                    intent.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                    intent.putExtra("enterprise_biz_name", blq);
                    intent.putExtra("biz_chat_scene", 1);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).nDS = this;
                        ((MMActivity) this.context).a(this, intent, 37);
                    }
                } else if (com.tencent.mm.modelbiz.e.hB(blq)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", blq);
                    intent.putExtra("enterprise_scene", 3);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).nDS = this;
                        com.tencent.mm.ay.c.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 37);
                    }
                }
            } else if ("wework".equals(string)) {
                Z(kVar);
            } else if ("qq".equals(string)) {
                aa(kVar);
            } else {
                v.i("MicroMsg.MsgHandler", "select user to send");
                Serializable hashMap2 = new HashMap();
                hashMap2.put("img_url", (String) kVar.iaJ.get("img_url"));
                hashMap2.put("desc", (String) kVar.iaJ.get("desc"));
                hashMap2.put("title", (String) kVar.iaJ.get("title"));
                com.tencent.mm.plugin.report.service.g.iuh.a(157, 5, 1, false);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 3);
                intent2.putExtra("scene_from", 2);
                intent2.putExtra("send_to_biz", true);
                intent2.putExtra("mutil_select_is_ret", true);
                intent2.putExtra("webview_params", hashMap2);
                intent2.putExtra("Retr_Msg_Type", 2);
                if (this.context instanceof MMActivity) {
                    kVar.lqY.put("Internal@AsyncReport", Boolean.valueOf(true));
                    com.tencent.mm.ay.c.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent2, 1, this);
                }
            }
        }
        return true;
    }

    private String blq() {
        String string = blp().getString("connector_local_send");
        blp().remove("connector_local_send");
        blp().putString("connector_local_report", string);
        return string;
    }

    private String blr() {
        String string = blp().getString("connector_local_report");
        blp().remove("connector_local_report");
        return string;
    }

    private static WXMediaMessage g(k kVar) {
        String str = (String) kVar.iaJ.get("link");
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgHandler", "convert fail, link is null");
            return null;
        }
        v.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{str, aj.Ec(str)});
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) kVar.iaJ.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) kVar.iaJ.get("title");
        wXMediaMessage.description = (String) kVar.iaJ.get("desc");
        return wXMediaMessage;
    }

    public final boolean FE(final String str) {
        int i = 42;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.fHM = false;
            return false;
        } else if (be.kS(str)) {
            Toast.makeText(aa.getContext(), this.context.getString(2131232922, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.fHM = false;
            return false;
        } else {
            if (this.lpf != null) {
                m.a(this.lpf.lqY, FC("profile"), str, null);
            }
            if (ak.uN()) {
                ak.yW();
                com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(str);
                if (LX == null || ((int) LX.chr) <= 0) {
                    ak.yW();
                    LX = com.tencent.mm.model.c.wH().LU(str);
                }
                final Intent intent = new Intent();
                if (this.lpj != null && this.lpj.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.lpj.getBundle("KBizSearchExtArgs"));
                }
                if (LX == null || ((int) LX.chr) <= 0) {
                    com.tencent.mm.model.ab.a.crZ.a(str, "", new com.tencent.mm.model.ab.c.a(this) {
                        final /* synthetic */ i lpR;

                        public final void p(String str, boolean z) {
                            int i = 42;
                            if (this.lpR.context == null) {
                                v.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
                                this.lpR.a(this.lpR.lpf, "profile:fail", null);
                                return;
                            }
                            if (this.lpR.dwR != null) {
                                this.lpR.dwR.dismiss();
                            }
                            ak.yW();
                            com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(str);
                            if (LX == null || ((int) LX.chr) <= 0) {
                                ak.yW();
                                LX = com.tencent.mm.model.c.wH().LU(str);
                            }
                            if (LX == null || ((int) LX.chr) <= 0) {
                                z = false;
                            } else {
                                str = LX.field_username;
                            }
                            if (z) {
                                com.tencent.mm.u.b.r(str, 3);
                                com.tencent.mm.u.n.Bq().gD(str);
                                intent.addFlags(268435456);
                                intent.putExtra("Contact_User", str);
                                if (LX.bvm()) {
                                    if (this.lpR.lpj != null) {
                                        i = this.lpR.lpj.getInt("Contact_Scene", 42);
                                    }
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, LX.field_username + "," + i);
                                    intent.putExtra("Contact_Scene", i);
                                }
                                this.lpR.ai(intent);
                                this.lpR.a(this.lpR.lpf, "profile:ok", null);
                                return;
                            }
                            Toast.makeText(aa.getContext(), this.lpR.context.getString(2131232922, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            this.lpR.a(this.lpR.lpf, "profile:fail", null);
                        }
                    });
                    Context context = this.context;
                    this.context.getString(2131231164);
                    this.dwR = g.a(context, this.context.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ i lpR;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.model.ab.a.crZ.fD(str);
                            this.lpR.a(this.lpR.lpf, "profile:cancel", null);
                        }
                    });
                    return true;
                }
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", LX.field_username);
                if (LX.bvm()) {
                    if (this.lpj != null) {
                        i = this.lpj.getInt("Contact_Scene", 42);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, LX.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.i.a.ei(LX.field_type)) {
                    mv mvVar = new mv();
                    mvVar.bof.intent = intent;
                    mvVar.bof.username = LX.field_username;
                    com.tencent.mm.sdk.c.a.nhr.z(mvVar);
                }
                ai(intent);
                a(this.lpf, "profile:ok", null);
                return false;
            }
            v.e("MicroMsg.MsgHandler", "doProfile, MMCore.hasCfgDefaultUin() is false");
            this.fHM = false;
            return false;
        }
    }

    private void ai(final Intent intent) {
        com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "profile", ".ui.ContactInfoUI", this.leB, new Runnable(this) {
            final /* synthetic */ i lpR;

            public final void run() {
                com.tencent.mm.plugin.webview.a.a.drp.d(intent, this.lpR.context);
            }
        });
    }

    private boolean h(final k kVar) {
        com.tencent.mm.ui.base.h a;
        if (com.tencent.mm.model.k.yn()) {
            ak.yW();
            ax Nr = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
            if (Nr == null || be.ma(Nr.name).length() == 0) {
                a = g.a(this.context, 2131236663, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ i lpR;

                    {
                        this.lpR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                a.setCancelable(false);
                a.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ i lpR;

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.lpR.a(kVar, "share_weibo:no_weibo", null);
                    }
                });
            } else {
                int i;
                int i2;
                String ah = be.ah((String) kVar.iaJ.get(Columns.TYPE), "40");
                if (ah == null || ah.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = be.getInt(ah, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                ah = (String) kVar.iaJ.get("content");
                String str = (String) kVar.iaJ.get("url");
                if (ah == null || ah.trim().length() == 0) {
                    ah = "";
                }
                if (str == null || str.length() == 0) {
                    v.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + ah + ", url = " + str);
                    a(kVar, "share_weibo:fail_-2", null);
                } else {
                    m.a(kVar.lqY, FC("shareWeibo"), null, null);
                    str = aj.Ec(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra(Columns.TYPE, i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("content", ah);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).a(this, intent, 2);
                    }
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = g.a(this.context, 2131236665, 2131231164, new OnClickListener(this) {
                final /* synthetic */ i lpR;

                {
                    this.lpR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.webview.a.a.drp.h(new Intent(), this.lpR.context);
                }
            }, null);
            a.setCancelable(false);
            a.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ i lpR;

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.lpR.a(kVar, "share_weibo:not_bind_qq", null);
                }
            });
        }
        return true;
    }

    private boolean i(k kVar) {
        this.bhh = g(kVar);
        if (this.bhh == null) {
            v.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) kVar.iaJ.get("link");
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            a(kVar, "share_timeline:fail", null);
            return true;
        }
        String str2;
        truncate((String) kVar.iaJ.get("desc"));
        v.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) kVar.iaJ.get("img_url")) + ", title = " + ((String) kVar.iaJ.get("title")) + ", desc = " + ((String) kVar.iaJ.get("desc")));
        int i = 1;
        String str3 = "";
        int i2 = 0;
        if (this.lpj != null) {
            this.lpj.setClassLoader(getClass().getClassLoader());
            i = this.lpj.getInt("snsWebSource", 1);
            str3 = this.lpj.getString("jsapi_args_appid");
            i2 = be.getInt(this.lpj.getString("urlAttribute"), 0);
            this.lpj.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        String str4 = str3;
        if (be.kS(str4)) {
            str2 = (String) kVar.iaJ.get("appid");
        } else {
            str2 = str4;
        }
        m.a(kVar.lqY, FC(bk.NAME), str, str2);
        str4 = (String) kVar.iaJ.get("img_width");
        str3 = (String) kVar.iaJ.get("img_height");
        String Ec = aj.Ec((String) kVar.iaJ.get("link"));
        v.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{r3, Ec});
        String str5 = (String) kVar.iaJ.get(Columns.TYPE);
        kVar.iaJ.get("desc");
        String str6 = (String) kVar.iaJ.get("title");
        String str7 = (String) kVar.iaJ.get("img_url");
        String str8 = (String) kVar.iaJ.get("src_username");
        String str9 = (String) kVar.iaJ.get("src_displayname");
        try {
            i2 = Integer.valueOf(str4).intValue();
            try {
                Integer.valueOf(str3);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            i2 = -1;
        }
        v.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", Ec);
        intent.putExtra("Ksnsupload_title", str6);
        intent.putExtra("Ksnsupload_imgurl", str7);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (m.eD(str8)) {
            intent.putExtra("src_username", str8);
            intent.putExtra("src_displayname", str9);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (!be.kS(str5) && str5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!be.kS(str5) && str5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str3 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.lpj == null);
        v.i(str3, str5, objArr);
        str4 = null;
        if (this.lpj != null) {
            str3 = this.lpj.getString("K_sns_thumb_url");
            str5 = this.lpj.getString("K_sns_raw_url");
            str6 = be.ah(this.lpj.getString("KSnsStrId"), "");
            str7 = be.ah(this.lpj.getString("KSnsLocalId"), "");
            str4 = this.lpj.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str4);
            v.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{str, str5, str3});
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str3);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.lpj.getParcelable("KSnsAdTag");
            v.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", new Object[]{parcelable});
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.lpj.getBoolean("KFromTimeline", false)) {
                nq nqVar = new nq();
                nqVar.boJ.boC = str6;
                nqVar.boJ.bap = str7;
                com.tencent.mm.sdk.c.a.nhr.z(nqVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.leB.bjo());
            Bundle i5 = this.leB.i(18, null);
            intent.putExtra("KPublisherId", i5 == null ? "" : be.ma(i5.getString("KPublisherId")));
            str = this.leB.Ra();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.lps.Fu(str));
        } catch (Throwable e3) {
            v.a("MicroMsg.MsgHandler", e3, "", new Object[0]);
        }
        v.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                i5 = this.leB.i(18, null);
                if (i5 != null) {
                    str3 = o.fz(be.ma(i5.getString("KPublisherId")));
                    com.tencent.mm.model.o.b n = o.yx().n(str3, true);
                    n.l("sendAppMsgScene", Integer.valueOf(2));
                    n.l("preChatName", i5.getString("preChatName"));
                    n.l("preMsgIndex", Integer.valueOf(i5.getInt("preMsgIndex")));
                    n.l("prePublishId", i5.getString("prePublishId"));
                    n.l("preUsername", i5.getString("preUsername"));
                    n.l("url", Ec);
                    n.l("getA8KeyScene", Integer.valueOf(i5.getInt("getA8KeyScene")));
                    n.l("referUrl", i5.getString("referUrl"));
                    if (!be.kS(str4)) {
                        n.l("adExtStr", str4);
                    }
                    intent.putExtra("reportSessionId", str3);
                }
            } catch (RemoteException e4) {
                v.e("MicroMsg.MsgHandler", "try to attach report args error, %s", new Object[]{e4});
            }
            ((MMActivity) this.context).nDS = this;
            com.tencent.mm.ay.c.a(this.context, "sns", ".ui.SnsUploadUI", intent, 24, false);
        }
        return true;
    }

    private boolean j(k kVar) {
        String str = (String) kVar.iaJ.get("ad_info");
        String str2 = str + ",";
        String xF = com.tencent.mm.model.k.xF();
        try {
            Bundle i = this.leB.i(18, null);
            if (i != null) {
                String string = i.getString("prePublishId");
                String string2 = i.getString("preChatName");
                String string3 = i.getString("preUsername");
                String str3 = str2 + string + "," + string2 + "," + string3 + "," + i.getInt("getA8KeyScene") + ",";
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            long parseLong = Long.parseLong(string.substring(4));
                            ak.yW();
                            at S = com.tencent.mm.model.c.wJ().S(string2, parseLong);
                            str3 = str3 + S.field_type + "," + com.tencent.mm.model.i.el(S.field_talker) + "," + com.tencent.mm.model.n.F(string3, string2) + "," + com.tencent.mm.plugin.webview.d.ai.bip() + ",";
                            str2 = str3 + xF;
                        }
                    } catch (Throwable e) {
                        Throwable th = e;
                        str2 = str3;
                        v.a("MicroMsg.MsgHandler", th, "", new Object[0]);
                    }
                }
                str3 = str3 + ",,,,";
                str2 = str3 + xF;
            }
            ak.vy().a(new com.tencent.mm.modelstat.h(13297, str2, (int) be.Nh()), 0);
            if (Integer.parseInt(be.ah((String) kVar.iaJ.get("need_record_page_operation"), "0")) != 0) {
                Bundle bundle = new Bundle();
                bundle.putString("traceid", str);
                bundle.putString("username", xF);
                try {
                    this.leB.i(90002, bundle);
                } catch (RemoteException e2) {
                }
            }
            a(kVar, "adDataReport：ok", null);
        } catch (Throwable e3) {
            v.a("MicroMsg.MsgHandler", e3, "", new Object[0]);
            a(kVar, "adDataReport：fail", null);
        }
        return true;
    }

    private static String truncate(String str) {
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        if (str.startsWith("https://")) {
            return str.substring(8);
        }
        return str;
    }

    private boolean k(k kVar) {
        String str = (String) kVar.iaJ.get("current");
        String[] strArr = (String[]) kVar.iaJ.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            v.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.fHM = false;
        } else {
            v.d("MicroMsg.MsgHandler", "doImgPreview ok");
            int i = 0;
            while (i < strArr.length) {
                if (be.kS(strArr[i]) || strArr[i].equalsIgnoreCase("null")) {
                    v.e("MicroMsg.MsgHandler", "null url, i = %d", new Object[]{Integer.valueOf(i)});
                } else {
                    if (be.ma(strArr[i]).startsWith("weixin://resourceid/")) {
                        strArr[i] = com.tencent.mm.plugin.webview.e.e.bjd().DW(strArr[i]).lel;
                    }
                    arrayList.add(strArr[i]);
                }
                i++;
            }
            strArr = (String[]) arrayList.toArray(strArr);
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (be.kS(str)) {
                str = strArr[0];
            } else if (str.startsWith("weixin://resourceid/")) {
                str = com.tencent.mm.plugin.webview.e.e.bjd().DW(str).lel;
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr2);
            intent.putExtra(Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            try {
                Bundle i2 = this.leB.i(90001, new Bundle());
                if (i2 != null) {
                    str = i2.getString("cookie", null);
                    if (!be.kS(str)) {
                        intent.putExtra("cookie", str);
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "getCookie fail : %s", new Object[]{e.getMessage()});
            }
            if (this.context instanceof Service) {
                intent.addFlags(268435456);
            }
            com.tencent.mm.plugin.webview.a.a.drp.u(intent, this.context);
            this.fHM = false;
        }
        return false;
    }

    private boolean l(k kVar) {
        try {
            Bundle O = k.O(kVar.iaJ);
            this.leB.bjq();
            this.leB.B(O);
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(kVar, "close_window:ok", null);
        return true;
    }

    private static void a(k kVar, int i, int i2) {
        String str = kVar.lqZ;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String str2 = (String) kVar.iaJ.get("appId");
            com.tencent.mm.pluginsdk.l.k kVar2 = com.tencent.mm.pluginsdk.l.k.lEU;
            com.tencent.mm.pluginsdk.l.k.k(str, str2, i, i2);
        }
    }

    private boolean m(k kVar) {
        String str = (String) kVar.iaJ.get(DownloadInfoColumns.PACKAGENAME);
        if (be.kS(str)) {
            v.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(kVar, "get_install_state:no", null);
            return true;
        }
        m.a(kVar.lqY, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    PackageInfo av = com.tencent.mm.pluginsdk.model.app.p.av(this.context, string);
                    int i2 = av == null ? 0 : av.versionCode;
                    String str2 = av == null ? "null" : av.versionName;
                    v.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + av + ", version = " + i2 + ", versionName = " + str2);
                    if (obj == null && i2 > 0) {
                        obj = 1;
                    }
                    jSONObject.put(string, i2);
                    jSONObject2.put(string, str2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (obj != null) {
                    a(kVar, "get_install_state:yes", hashMap);
                } else {
                    a(kVar, "get_install_state:no", null);
                }
                return true;
            }
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo av2 = com.tencent.mm.pluginsdk.model.app.p.av(this.context, str);
        int i3 = av2 == null ? 0 : av2.versionCode;
        String str3 = av2 == null ? "null" : av2.versionName;
        v.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + av2 + ", version = " + i3 + ", versionName = " + str3);
        if (av2 == null) {
            a(kVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(kVar, "get_install_state:yes_" + i3, hashMap2);
        }
        return true;
    }

    private boolean n(k kVar) {
        boolean z;
        boolean z2;
        int i;
        Intent intent;
        String str = (String) kVar.iaJ.get("desc");
        int i2 = be.getInt((String) kVar.iaJ.get("needResult"), 1);
        String str2 = (String) kVar.iaJ.get("scanType");
        v.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", new Object[]{str, Integer.valueOf(i2), str2});
        if (be.kS(str2)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        boolean z3;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                z3 = z;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    try {
                        str = (String) jSONArray.get(i3);
                        if (str.equalsIgnoreCase("qrCode")) {
                            z = z3;
                            z3 = true;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            z = true;
                            z3 = z2;
                        } else {
                            z = z3;
                            z3 = z2;
                        }
                        i3++;
                        z2 = z3;
                        z3 = z;
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                z3 = z;
                v.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                if (!z2) {
                }
                if (!z2) {
                }
                i = 1;
                if (i2 == 0) {
                    v.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    com.tencent.mm.ay.c.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
                    a(kVar, "scanQRCode:ok", null);
                } else if (i2 != 1) {
                    v.e("MicroMsg.MsgHandler", "unkown scene");
                    a(kVar, "scanQRCode:fail_invalid_scene", null);
                } else {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    intent.putExtra("key_is_finish_on_scanned", true);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
                    WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.bkE);
                }
                return true;
            }
        }
        z3 = z;
        if (!z2 && !r1) {
            i = 8;
        } else if (z2 || !r1) {
            i = 1;
        } else {
            i = 4;
        }
        if (i2 == 0) {
            v.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(u.bi(this.context) || com.tencent.mm.ah.a.aT(this.context))) {
                com.tencent.mm.ay.c.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            }
            a(kVar, "scanQRCode:ok", null);
        } else if (i2 != 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(u.bi(this.context) || com.tencent.mm.ah.a.aT(this.context))) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.bkE);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "unkown scene");
            a(kVar, "scanQRCode:fail_invalid_scene", null);
        }
        return true;
    }

    private boolean o(k kVar) {
        String str = (String) kVar.iaJ.get("fontSize");
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.fHM = false;
        } else {
            v.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = " + str);
            try {
                this.leB.EB(str);
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.fHM = false;
        }
        return false;
    }

    private boolean p(k kVar) {
        v.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
            jt jtVar = new jt();
            jtVar.bki.appId = dVar.appId;
            jtVar.bki.bkj = dVar.bkj;
            jtVar.bki.bkk = dVar.bkk;
            jtVar.bki.bkl = dVar.bkl;
            jtVar.bki.bkm = dVar.bkm;
            jtVar.bki.bkn = dVar.bkn;
            jtVar.bki.bko = dVar.bko;
            jtVar.bki.url = dVar.url;
            jtVar.bki.bkp = dVar.bkp;
            jtVar.bki.bkq = dVar.bkq;
            jtVar.bki.bks = dVar.bks;
            jtVar.bki.bkr = dVar.bkr;
            com.tencent.mm.sdk.c.a.nhr.z(jtVar);
            a(21, -1, null);
        }
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        return true;
    }

    private boolean q(k kVar) {
        v.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) kVar.iaJ.get("productInfo");
        String str2 = (String) kVar.iaJ.get("url");
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 3, 0, null, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.Integer r7, int r8, int r9, java.lang.String r10, android.content.Intent r11) {
        /*
        r6 = this;
        r3 = 0;
        r5 = 1;
        r4 = 0;
        r0 = "key_product_scene";
        r11.putExtra(r0, r8);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        r0 = r6.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x005a;
    L_0x001c:
        r0 = r6.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.nDS = r6;
        r0 = r7.intValue();
        switch(r0) {
            case 0: goto L_0x0043;
            case 10000: goto L_0x0092;
            case 20000: goto L_0x0092;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        r0 = 8;
        if (r8 != r0) goto L_0x00a6;
    L_0x003a:
        r0 = r6.lpf;
        r1 = "open_product_view_with_id:fail";
        r6.a(r0, r1, r4);
    L_0x0042:
        return r5;
    L_0x0043:
        switch(r9) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0077;
            default: goto L_0x0046;
        };
    L_0x0046:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d, viewType = %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r2[r3] = r7;
        r3 = java.lang.Integer.valueOf(r9);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
    L_0x005a:
        r0 = r6.lpf;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0063:
        r0 = r6.context;
        r1 = "product";
        r2 = ".ui.MallProductUI";
        com.tencent.mm.ay.c.b(r0, r1, r2, r11);
        r0 = r6.lpf;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0077:
        r0 = "key_Qrcode_Url";
        r11.putExtra(r0, r10);
        r0 = "key_ProductUI_getProductInfoScene";
        r1 = 4;
        r11.putExtra(r0, r1);
        r0 = r6.context;
        r1 = "scanner";
        r2 = ".ui.ProductUI";
        r3 = 10;
        com.tencent.mm.ay.c.b(r0, r1, r2, r11, r3);
        goto L_0x0042;
    L_0x0092:
        r0 = r6.context;
        r1 = "card";
        r2 = ".ui.CardProductUI";
        com.tencent.mm.ay.c.b(r0, r1, r2, r11);
        r0 = r6.lpf;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x00a6:
        r0 = r6.lpf;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a(java.lang.Integer, int, int, java.lang.String, android.content.Intent):boolean");
    }

    private boolean a(final k kVar, int... iArr) {
        if (lpr != -1) {
            this.lpf = th(lpr).lpf;
            this.leB = th(lpr).leB;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(kVar, "startMonitoringBeacons:system unsupported", null);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(kVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(kVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr == null || iArr.length == 0) {
                if (!this.lpC.isProviderEnabled("gps")) {
                    a(kVar, "startMonitoringBeacons:location service disable", null);
                }
                SensorManager sensorManager = (SensorManager) lpq.getSystemService("sensor");
                sensorManager.registerListener(this.lpG, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.lpF) {
                a(kVar, "startMonitoringBeacons:already started", null);
            } else {
                this.lpF = true;
                a(kVar, "startMonitoringBeacons:ok", null);
            }
            if (!(kVar == null || kVar.iaJ == null)) {
                Object obj = kVar.iaJ.get("uuid");
                Object obj2 = kVar.iaJ.get("url");
                Object obj3 = kVar.iaJ.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                com.tencent.mm.plugin.report.service.g.iuh.h(12101, new Object[]{be.ma(this.lps.Fu(obj4)), obj4, this.lpD, this.lpE, obj3 != null ? obj3.toString() : ""});
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0").append("}");
                final t tVar = new t(obj4, r4, r1);
                ak.vy().a(1702, new e(this) {
                    final /* synthetic */ i lpR;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            bdf com_tencent_mm_protocal_c_bdf = (bdf) tVar.cQA.czl.czs;
                            if (com_tencent_mm_protocal_c_bdf.fvC == 0) {
                                List<String> list = com_tencent_mm_protocal_c_bdf.mZh;
                                if (list == null || list.isEmpty()) {
                                    this.lpR.a(kVar, "startMonitoringBeacons:no uuids", null);
                                } else {
                                    for (String a : list) {
                                        i.a(this.lpR, a);
                                    }
                                }
                            } else {
                                this.lpR.a(kVar, "startMonitoringBeacons:system error", null);
                                v.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[]{com_tencent_mm_protocal_c_bdf.fvD});
                            }
                            ak.vy().b(1702, this);
                        }
                    }
                });
                ak.vy().a(tVar, 0);
            }
        }
        return true;
    }

    public final boolean b(k kVar, int... iArr) {
        if (lpr != -1) {
            this.lpf = th(lpr).lpf;
            this.leB = th(lpr).leB;
        }
        if (VERSION.SDK_INT >= 18) {
            boolean a;
            com.tencent.mm.sdk.c.a.nhr.f(this.iSD);
            if (ak.uz()) {
                ak.yW();
                a = be.a((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrv, null), false);
            } else {
                a = false;
            }
            for (String str : this.lpx.keySet()) {
                cr crVar = new cr();
                v.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", new Object[]{str});
                crVar.baC.baE = str;
                crVar.baC.baB = false;
                if (!a) {
                    com.tencent.mm.sdk.c.a.nhr.z(crVar);
                }
            }
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrq, Boolean.valueOf(false));
            }
            Editor edit = aa.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.lpx.clear();
            this.bYi.clear();
            this.lpy.clear();
            this.lpz.clear();
            this.lpF = false;
            if (iArr == null || iArr.length == 0) {
                a(kVar, "stopMonitoringBeacons:ok", null);
                this.lpF = false;
            }
        }
        if (!(lpq == null || this.lpG == null)) {
            ((SensorManager) lpq.getSystemService("sensor")).unregisterListener(this.lpG);
        }
        return true;
    }

    private boolean bls() {
        String Ra;
        v.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            Ra = this.leB.Ra();
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            Ra = str;
        }
        final String str2 = "get_recently_used_address:";
        if (Ra == null) {
            a(this.lpf, str2 + "fail", null);
        } else {
            final kk kkVar = new kk();
            kkVar.bly.appId = (String) this.lpf.iaJ.get("appId");
            kkVar.bly.url = Ra;
            kkVar.blz.errCode = -119;
            kkVar.bpT = new Runnable(this) {
                final /* synthetic */ i lpR;

                public final void run() {
                    v.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(kkVar.blz.errCode), Boolean.valueOf(kkVar.blz.blA)});
                    if (kkVar.blz.errCode != -119) {
                        if (kkVar.blz.errCode != 0) {
                            this.lpR.a(this.lpR.lpf, str2 + "fail", null);
                        } else if (kkVar.blz.blA) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", kkVar.blz.blB);
                            hashMap.put("userName", kkVar.blz.userName);
                            hashMap.put("telNumber", kkVar.blz.blC);
                            hashMap.put("addressPostalCode", kkVar.blz.blD);
                            hashMap.put("proviceFirstStageName", kkVar.blz.blE);
                            hashMap.put("addressCitySecondStageName", kkVar.blz.blF);
                            hashMap.put("addressCountiesThirdStageName", kkVar.blz.blG);
                            hashMap.put("addressDetailInfo", kkVar.blz.blH);
                            this.lpR.a(this.lpR.lpf, str2 + "ok", hashMap);
                        } else {
                            this.lpR.a(this.lpR.lpf, str2 + "cancel", null);
                        }
                    }
                }
            };
            com.tencent.mm.sdk.c.a.nhr.a(kkVar, Looper.getMainLooper());
        }
        return true;
    }

    private boolean bm(k kVar) {
        m.a(kVar.lqY, FC("sendEmail"), null, null);
        String str = (String) kVar.iaJ.get("title");
        String str2 = "";
        try {
            str2 = aj.Ec(this.leB.Ra());
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.ay.c.a(this.context, "qqmail", ".ui.ComposeUI", intent, false);
        a(kVar, "send_email:ok", null);
        return true;
    }

    private static void n(String str, int i, String str2) {
        fv fvVar = new fv();
        fvVar.bfk.appId = str;
        fvVar.bfk.opType = 2;
        fvVar.bfk.bfl = i;
        fvVar.bfk.aZh = str2;
        com.tencent.mm.sdk.c.a.nhr.z(fvVar);
    }

    private boolean a(String str, k kVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2;
                    String string = jSONArray.getString(i);
                    com.tencent.mm.pluginsdk.model.downloader.f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(string);
                    JSONObject jSONObject2 = new JSONObject();
                    switch (GN.status) {
                        case -1:
                            str2 = "api_not_support";
                            break;
                        case 1:
                            str2 = "downloading";
                            break;
                        case 2:
                            str2 = "download_pause";
                            break;
                        case 3:
                            if (!com.tencent.mm.a.e.aR(GN.path)) {
                                str2 = "default";
                                break;
                            }
                            str2 = "download_succ";
                            break;
                        case 4:
                            str2 = "download_fail";
                            break;
                        default:
                            str2 = "default";
                            break;
                    }
                    jSONObject2.put("download_id", GN.id);
                    jSONObject2.put("state", str2);
                    if (str2 == "downloading" && GN.beE != 0) {
                        jSONObject2.put("progress", (GN.beD / GN.beE) * 100);
                    }
                    jSONObject.put(string, jSONObject2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                a(kVar, "query_download_task:ok", hashMap);
            } else {
                a(kVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            v.e("MicroMsg.MsgHandler", e.getMessage());
            a(kVar, "query_download_task:fail", null);
        }
        return true;
    }

    private boolean r(k kVar) {
        int i;
        String str = (String) kVar.iaJ.get(Columns.TYPE);
        String str2 = (String) kVar.iaJ.get("appID");
        m.a(kVar.lqY, false, null, str2);
        if (!be.kS(str)) {
            try {
                i = be.getInt(str, 0);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "invalid type", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
            if (i == 0) {
                str = (String) kVar.iaJ.get("extInfo");
                v.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
                if (be.kS(str2)) {
                    v.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(kVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.drq.o(aa.getContext(), str2)) {
                    v.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                    a(kVar, "launch_3rdApp:fail", null);
                } else {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 587333634;
                    wXMediaMessage.messageExt = str;
                    hm hmVar = new hm();
                    hmVar.bhg.bhh = wXMediaMessage;
                    hmVar.bhg.appId = str2;
                    com.tencent.mm.sdk.c.a.nhr.z(hmVar);
                    a(kVar, "launch_3rdApp:ok", null);
                }
            } else if (i != 1) {
                str = (String) kVar.iaJ.get("signature");
                str2 = (String) kVar.iaJ.get(DownloadInfoColumns.PACKAGENAME);
                v.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) kVar.iaJ.get("param")});
                if (!be.kS(str) || be.kS(str2)) {
                    v.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                    a(kVar, "launch_3rdApp:fail_invalid_args", null);
                } else if (com.tencent.mm.pluginsdk.model.app.p.o(this.context, str2)) {
                    Signature[] aN = com.tencent.mm.pluginsdk.model.app.p.aN(this.context, str2);
                    if (!(aN == null || aN[0] == null)) {
                        String m = com.tencent.mm.a.g.m(aN[0].toByteArray());
                        if (m != null && m.equalsIgnoreCase(str)) {
                            try {
                                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str2);
                                if (launchIntentForPackage != null) {
                                    Bundle bundle = new Bundle();
                                    com.tencent.mm.pluginsdk.model.app.p.b(bundle, r2);
                                    launchIntentForPackage.putExtras(bundle);
                                    launchIntentForPackage.addFlags(268435456);
                                    this.context.startActivity(launchIntentForPackage);
                                    a(kVar, "launch_3rdApp:ok", null);
                                }
                            } catch (Exception e2) {
                                v.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e2.getMessage()});
                            }
                            a(kVar, "launch_3rdApp:fail", null);
                        }
                    }
                    v.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                    a(kVar, "launch_3rdApp:fail_signature_mismatch", null);
                } else {
                    v.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                    a(kVar, "launch_3rdApp:fail_not_install", null);
                }
            } else {
                a(kVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        i = 0;
        v.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
        if (i == 0) {
            str = (String) kVar.iaJ.get("extInfo");
            v.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
            if (be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "appid is null or nil");
                a(kVar, "launch_3rdApp:fail", null);
            } else if (com.tencent.mm.plugin.webview.a.a.drq.o(aa.getContext(), str2)) {
                WXAppExtendObject wXAppExtendObject2 = new WXAppExtendObject();
                wXAppExtendObject2.extInfo = str;
                WXMediaMessage wXMediaMessage2 = new WXMediaMessage(wXAppExtendObject2);
                wXMediaMessage2.sdkVer = 587333634;
                wXMediaMessage2.messageExt = str;
                hm hmVar2 = new hm();
                hmVar2.bhg.bhh = wXMediaMessage2;
                hmVar2.bhg.appId = str2;
                com.tencent.mm.sdk.c.a.nhr.z(hmVar2);
                a(kVar, "launch_3rdApp:ok", null);
            } else {
                v.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                a(kVar, "launch_3rdApp:fail", null);
            }
        } else if (i != 1) {
            a(kVar, "launch_3rdApp:fail_invalid_type", null);
        } else {
            str = (String) kVar.iaJ.get("signature");
            str2 = (String) kVar.iaJ.get(DownloadInfoColumns.PACKAGENAME);
            v.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) kVar.iaJ.get("param")});
            if (be.kS(str)) {
            }
            v.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
            a(kVar, "launch_3rdApp:fail_invalid_args", null);
        }
        return true;
    }

    private boolean s(k kVar) {
        String str = (String) kVar.iaJ.get("url");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(kVar, "open_url_by_ext_browser:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                this.context.startActivity(intent);
                a(kVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(kVar, "open_url_by_ext_browser:fail", null);
            }
        }
        return true;
    }

    private static byte[] blt() {
        try {
            com.tencent.mm.sdk.platformtools.g gVar = new com.tencent.mm.sdk.platformtools.g("softtype");
            v.d("MicroMsg.AndroidDevicesReport", "cpu %s", new Object[]{be.ah((String) com.tencent.mm.compatible.d.m.rB().get("Processor"), "")});
            gVar.aY("cpu", r0);
            gVar.aY("radio", com.tencent.mm.compatible.d.p.rR());
            gVar.aY("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.d.p.getDeviceID(aa.getContext());
            String rT = com.tencent.mm.compatible.d.p.rT();
            String rU = com.tencent.mm.compatible.d.p.rU();
            gVar.aY("deviceId", deviceID);
            gVar.aY("imsi", rT);
            gVar.aY("iccid", rU);
            gVar.aY("androidid", com.tencent.mm.compatible.d.p.getAndroidId());
            gVar.aY("serial", com.tencent.mm.compatible.d.p.rV());
            gVar.aY("model", com.tencent.mm.compatible.d.p.rO());
            gVar.aY("core_count", com.tencent.mm.compatible.d.m.rG());
            gVar.aY("cpuhardware", be.ah((String) com.tencent.mm.compatible.d.m.rH().get("Hardware"), ""));
            gVar.aY("cpureversion", be.ah((String) com.tencent.mm.compatible.d.m.rH().get("CPU revision"), ""));
            gVar.aY("cpuserial", be.ah((String) com.tencent.mm.compatible.d.m.rH().get("Serial"), ""));
            gVar.aY("Features", be.ah((String) com.tencent.mm.compatible.d.m.rH().get("Features"), ""));
            gVar.aY("wifi-mac", be.ah(com.tencent.mm.compatible.d.p.rL(), ""));
            gVar.aY("bluetooth", be.ah(com.tencent.mm.compatible.d.p.rM(), ""));
            if (!be.kS(gVar.nib)) {
                gVar.oU(gVar.nib);
                gVar.nib = "";
            }
            v.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", new Object[]{gVar.eid.toString()});
            v.i("MicroMsg.MsgHandler", "xml %s", new Object[]{deviceID});
            bai com_tencent_mm_protocal_c_bai = new bai();
            com_tencent_mm_protocal_c_bai.mWV = com.tencent.mm.ba.b.aT(com.tencent.mm.compatible.d.p.rK().getBytes()).uz(16);
            v.i("MicroMsg.MsgHandler", be.bn(com_tencent_mm_protocal_c_bai.mWV.lVU));
            com_tencent_mm_protocal_c_bai.mWW = deviceID;
            SharedPreferences zc = al.zc();
            v.d("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", new Object[]{be.bn(r2), com.tencent.mm.a.g.m(be.KG(zc.getString("_auth_key", ""))), Integer.valueOf(zc.getInt("_auth_uin", 0))});
            v.d("MicroMsg.MsgHandler", "aat len:%d", new Object[]{Integer.valueOf(r2.length)});
            com_tencent_mm_protocal_c_bai.mWX = com.tencent.mm.ba.b.aT(r2);
            com_tencent_mm_protocal_c_bai.uin = r0;
            com.tencent.mm.protocal.ad brG = com.tencent.mm.protocal.ad.brG();
            byte[] toByteArray = com_tencent_mm_protocal_c_bai.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, brG.lXA.getBytes(), brG.lXB.getBytes())) {
                toByteArray = pByteArray.value;
            }
            v.d("MicroMsg.MsgHandler", "cpan buf string:%s ", new Object[]{be.bn(toByteArray)});
            baj com_tencent_mm_protocal_c_baj = new baj();
            com_tencent_mm_protocal_c_baj.mWZ = brG.ver;
            com_tencent_mm_protocal_c_baj.mWY = com.tencent.mm.protocal.d.lWh;
            com_tencent_mm_protocal_c_baj.mXa = com.tencent.mm.protocal.d.cmW;
            com_tencent_mm_protocal_c_baj.mXb = com.tencent.mm.ba.b.aT(toByteArray);
            v.i("MicroMsg.MsgHandler", "getdevice done");
            return com_tencent_mm_protocal_c_baj.toByteArray();
        } catch (Throwable e) {
            v.e("MicroMsg.MsgHandler", "report error");
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
            return null;
        }
    }

    private boolean t(k kVar) {
        String str = "";
        try {
            str = this.leB.Ra();
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        v.i("MicroMsg.MsgHandler", "currentUrl %s", new Object[]{str});
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                v.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(blt(), 0);
            } catch (Throwable e2) {
                v.e("MicroMsg.MsgHandler", "device info get error %s", new Object[]{e2.getMessage()});
                v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(kVar, "mmsf0001:ok", hashMap);
        } else {
            a(kVar, "system:access_denied", null);
        }
        return true;
    }

    private boolean u(k kVar) {
        Map map = null;
        if (this.context instanceof MMActivity) {
            String Ra;
            v.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", new Object[]{(String) kVar.iaJ.get("tousername"), (String) kVar.iaJ.get("extmsg")});
            try {
                Ra = this.leB.Ra();
            } catch (RemoteException e) {
                v.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra("extInfo", r1);
            intent.putExtra("fromURL", Ra);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.drp.a(intent, this, (MMActivity) this.context);
        } else {
            a(kVar, "jump_to_biz_profile:fail", map);
        }
        return true;
    }

    private boolean v(k kVar) {
        v.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", new Object[]{(String) kVar.iaJ.get("switch"), (String) kVar.iaJ.get("title_cn"), (String) kVar.iaJ.get("title_eng"), (String) kVar.iaJ.get("ok_cn"), (String) kVar.iaJ.get("ok_eng"), (String) kVar.iaJ.get("cancel_cn"), (String) kVar.iaJ.get("cancel_eng")});
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.leB.g(13, bundle);
        } catch (RemoteException e) {
            v.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
        }
        a(kVar, "setCloseWindowConfirmDialogInfo:ok", null);
        return true;
    }

    private boolean b(final k kVar, final JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) kVar.iaJ.get("verifyAppId");
        String str2 = (String) kVar.iaJ.get("verifyJsApiList");
        v.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", new Object[]{str, (String) kVar.iaJ.get("verifySignature"), (String) kVar.iaJ.get("verifyNonceStr"), (String) kVar.iaJ.get("verifyTimestamp"), (String) kVar.iaJ.get("verifySignType")});
        m.a(kVar.lqY, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            v.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", new Object[]{Integer.valueOf(jSONArray.length())});
            if (jSONArray.length() == 0) {
                a(kVar, "checkJsApi:param is empty", null);
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!be.kS(string)) {
                    linkedList.add(string);
                }
            }
            String Ra = this.leB.Ra();
            e eVar = this.lps;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a anonymousClass17 = new e.c(this) {
                final /* synthetic */ i lpR;

                public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a aVar, String str, LinkedList<bdg> linkedList, int i, int i2) {
                    if (aVar == com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_OK && jsapiPermissionWrapper.lWx != null) {
                        Object obj = null;
                        if (linkedList != null && linkedList.size() > 0) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                bdg com_tencent_mm_protocal_c_bdg = (bdg) it.next();
                                com.tencent.mm.protocal.c.g Is = com.tencent.mm.protocal.c.Is(be.ma(com_tencent_mm_protocal_c_bdg.mEp));
                                if (Is != null) {
                                    Object obj2;
                                    if (jsapiPermissionWrapper.uB(Is.brs()) != com_tencent_mm_protocal_c_bdg.state) {
                                        JsapiPermissionWrapper jsapiPermissionWrapper = jsapiPermissionWrapper;
                                        int brs = Is.brs();
                                        byte b = (byte) com_tencent_mm_protocal_c_bdg.state;
                                        if (jsapiPermissionWrapper.lWx == null || brs < 0 || brs >= jsapiPermissionWrapper.lWx.length) {
                                            String str2 = "MicroMsg.JsapiPermissionWrapper";
                                            String str3 = "setPermission pos out of range, %s, %s";
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Integer.valueOf(brs);
                                            objArr[1] = Integer.valueOf(jsapiPermissionWrapper.lWx == null ? 0 : jsapiPermissionWrapper.lWx.length);
                                            v.e(str2, str3, objArr);
                                        } else {
                                            jsapiPermissionWrapper.lWx[brs] = b;
                                        }
                                        obj2 = 1;
                                    } else {
                                        obj2 = obj;
                                    }
                                    obj = obj2;
                                }
                            }
                        }
                        if (!(obj == null || this.lpR.leB == null)) {
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper.lWx);
                            try {
                                String str4 = "MicroMsg.MsgHandler";
                                String str5 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = Integer.valueOf(jsapiPermissionWrapper.lWx == null ? 0 : jsapiPermissionWrapper.lWx.length);
                                objArr2[1] = jsapiPermissionWrapper;
                                v.i(str4, str5, objArr2);
                                this.lpR.leB.g(1006, bundle);
                            } catch (Exception e) {
                                v.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e.getMessage()});
                            }
                        }
                        this.lpR.a(kVar, "pre_verify_jsapi:ok", null);
                    } else if (be.kS(str)) {
                        this.lpR.a(kVar, "pre_verify_jsapi:fail", null);
                    } else {
                        this.lpR.a(kVar, "pre_verify_jsapi:fail_" + str, null);
                    }
                }

                public final boolean blc() {
                    return this.lot;
                }
            };
            if (be.kS(str) || linkedList.size() <= 0) {
                v.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", new Object[]{str});
                anonymousClass17.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.e.a.a.RET_FAIL, null, null, 0, 0);
            } else {
                ak.vy().a(1093, eVar);
                ak.vy().a(new com.tencent.mm.plugin.webview.d.m(anonymousClass17, Ra, str, linkedList, r6, r7, r8, r9, eVar.ldX), 0);
            }
            return true;
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "exception occur " + e.getMessage());
            a(kVar, "pre_verify_jsapi:fail", null);
            return true;
        }
    }

    private boolean w(k kVar) {
        Map hashMap = new HashMap();
        try {
            ck ckVar = new ck();
            ckVar.bae.aZV = true;
            com.tencent.mm.sdk.c.a.nhr.z(ckVar);
            if (ckVar.baf.aZW) {
                hashMap.put("currentSSID", ckVar.baf.bag);
                a(kVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(kVar, "getCurrentSSID:fail", hashMap);
            }
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(kVar, "getCurrentSSID:fail", hashMap);
        }
        return true;
    }

    private boolean x(k kVar) {
        int bjG = bjG();
        int aLC = aLC();
        String blu = blu();
        v.i("MicroMsg.MsgHandler", "Key Scene(%d)", new Object[]{Integer.valueOf(aLC)});
        if (aLC == 27) {
            this.lpk = (String) kVar.iaJ.get("brandUserName");
            v.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", new Object[]{this.lpk});
        } else if (!(bjG == 8 || bjG == -1)) {
            this.ezn = (String) kVar.iaJ.get("brandUserName");
            v.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", new Object[]{this.ezn});
            if (!(be.kS(blu) || be.kS(this.ezn))) {
                v.i("MicroMsg.MsgHandler", "Chat name(%s)", new Object[]{blu});
                BizInfo hw = com.tencent.mm.modelbiz.e.hw(blu);
                if (hw != null) {
                    ExtInfo aX = hw.aX(false);
                    if (!(aX == null || aX.CR() == null || !aX.CR().Da() || blu.equals(this.ezn))) {
                        a(kVar, "openWXDeviceLib:fail_UsernameError", null);
                        return true;
                    }
                }
            }
        }
        blu = H(kVar);
        v.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{blu});
        if (be.kS(blu)) {
            a(kVar, "openWXDeviceLib:fail_UsernameError", null);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{blu, "openWXDeviceLib"});
            String str = "";
            if (kVar.iaJ.containsKey("connType")) {
                str = (String) kVar.iaJ.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.lpm == null) {
                    this.lpm = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a bkN = com.tencent.mm.plugin.webview.ui.tools.a.a.bkN();
                    com.tencent.mm.plugin.webview.stub.e eVar = this.leB;
                    v.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (bkN.lno == null) {
                        bkN.lno = new com.tencent.mm.plugin.webview.ui.tools.a.a.a(eVar, blu);
                        com.tencent.mm.sdk.c.a.nhr.e(bkN.lno.lnt);
                        com.tencent.mm.sdk.c.a.nhr.e(bkN.lno.lnu);
                        com.tencent.mm.sdk.c.a.nhr.e(bkN.lno.lnw);
                        com.tencent.mm.sdk.c.a.nhr.e(bkN.lno.lnv);
                        com.tencent.mm.sdk.c.a.nhr.e(bkN.lno.lnx);
                    }
                    dd ddVar = new dd();
                    ddVar.bbc.aZV = true;
                    com.tencent.mm.sdk.c.a.nhr.z(ddVar);
                    bkN.hasInit = true;
                    bkN.aZU = blu;
                    bkN.lnq = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.a.bkN());
                    if (com.tencent.mm.sdk.platformtools.ak.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(kVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                    a(kVar, "openWXDeviceLib:fail_exception", null);
                }
            } else {
                if (this.lpl == null) {
                    this.lpl = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b bkQ = com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ();
                    com.tencent.mm.plugin.webview.stub.e eVar2 = this.leB;
                    v.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (bkQ.lnz == null) {
                        bkQ.lnz = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, blu);
                        com.tencent.mm.sdk.c.a.nhr.e(bkQ.lnz.lnD);
                        com.tencent.mm.sdk.c.a.nhr.e(bkQ.lnz.lnE);
                        com.tencent.mm.sdk.c.a.nhr.e(bkQ.lnz.lnF);
                        com.tencent.mm.sdk.c.a.nhr.e(bkQ.lnz.lnt);
                        com.tencent.mm.sdk.c.a.nhr.e(bkQ.lnz.iSE);
                    }
                    cx cxVar = new cx();
                    cxVar.baV.op = 1;
                    com.tencent.mm.sdk.c.a.nhr.z(cxVar);
                    bkQ.hasInit = true;
                    bkQ.aZU = blu;
                    bkQ.lnq = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                            default:
                                break;
                        }
                    }
                    obj = "unknow";
                    v.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(aa.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", aa.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (bjG == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(kVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    v.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                    a(kVar, "openWXDeviceLib:fail_exception", null);
                }
            }
        }
        return true;
    }

    private boolean y(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().bkO();
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                a(kVar, "closeWXDeviceLib:fail_exception", null);
            }
        } else {
            try {
                str = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().bkO();
            } catch (Exception e2) {
                v.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                a(kVar, "closeWXDeviceLib:fail_exception", null);
            }
        }
        a(kVar, "closeWXDeviceLib:ok", null);
        return true;
    }

    private boolean z(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                try {
                    v.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{H(kVar)});
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "startScanWXDevice"});
                    if (be.kS(H(kVar))) {
                        a(kVar, "startScanWXDevice:fail_UsernameError", null);
                    } else {
                        du duVar = new du();
                        duVar.bbN.aZV = true;
                        com.tencent.mm.sdk.c.a.nhr.z(duVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().lns = true;
                        a(kVar, "startScanWXDevice:ok", null);
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(kVar, "startScanWXDevice:fail_exception", null);
                }
            } else {
                v.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(kVar, "startScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.compatible.util.f.dW(23) && !((LocationManager) this.context.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            v.d("MicroMsg.MsgHandler", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
            v.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(kVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            try {
                String H = H(kVar);
                str = (String) kVar.iaJ.get("btVersion");
                v.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", new Object[]{str, H});
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "startScanWXDevice"});
                if (be.kS(H)) {
                    a(kVar, "startScanWXDevice:fail_UsernameError", null);
                } else {
                    de deVar = new de();
                    deVar.bbd.aZV = true;
                    deVar.bbd.aZU = H;
                    if (be.ma(str).equals("ble")) {
                        deVar.bbd.bbf = 0;
                    } else if (be.ma(str).equals("bc")) {
                        deVar.bbd.bbf = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().lnB = deVar.bbd.bbf;
                    com.tencent.mm.sdk.c.a.nhr.z(deVar);
                    if (deVar.bbe.aZW) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().lns = true;
                        a(kVar, "startScanWXDevice:ok", null);
                    } else {
                        a(kVar, "startScanWXDevice:fail", null);
                    }
                }
            } catch (Exception e2) {
                v.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(kVar, "startScanWXDevice:fail_exception", null);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(kVar, "startScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean A(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                try {
                    str = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "stopScanWXDevice"});
                    if (be.kS(str)) {
                        a(kVar, "stopScanWXDevice:fail_UsernameError", null);
                    } else {
                        du duVar = new du();
                        duVar.bbN.aZV = false;
                        com.tencent.mm.sdk.c.a.nhr.z(duVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().lns = false;
                        a(kVar, "stopScanWXDevice:ok", null);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
                    v.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(kVar, "stopScanWXDevice:fail_exception", null);
                }
            } else {
                v.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(kVar, "stopScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            try {
                str = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "stopScanWXDevice"});
                if (be.kS(str)) {
                    a(kVar, "stopScanWXDevice:fail_UsernameError", null);
                } else {
                    de deVar = new de();
                    deVar.bbd.aZV = false;
                    deVar.bbd.aZU = str;
                    deVar.bbd.bbf = com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().lnB;
                    com.tencent.mm.sdk.c.a.nhr.z(deVar);
                    if (deVar.bbe.aZW) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().lns = false;
                        a(kVar, "stopScanWXDevice:ok", null);
                    } else {
                        v.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(kVar, "stopScanWXDevice:fail", null);
                    }
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
                v.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(kVar, "stopScanWXDevice:fail_exception", null);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(kVar, "stopScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean B(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        String H;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                str = (String) kVar.iaJ.get("deviceId");
                v.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
                if (be.kS(str)) {
                    v.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(kVar, "connectWXDevice:fail_noDeviceId", null);
                } else {
                    H = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "connectWXDevice"});
                    if (be.kS(H)) {
                        a(kVar, "connectWXDevice:fail_UsernameError", null);
                    } else {
                        if (!(this.lpm == null || this.lpm.containsKey(H))) {
                            this.lpm.put(H, str);
                        }
                        try {
                            ch chVar = new ch();
                            chVar.aZX.aZV = true;
                            chVar.aZX.aZU = H;
                            chVar.aZX.aRh = str;
                            com.tencent.mm.sdk.c.a.nhr.z(chVar);
                            if (chVar.aZY.aZW) {
                                a(kVar, "connectWXDevice:ok", null);
                            } else {
                                a(kVar, "connectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(kVar, "connectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                v.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(kVar, "connectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            str = (String) kVar.iaJ.get("deviceId");
            v.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "deviceId is null");
                a(kVar, "connectWXDevice:fail_noDeviceId", null);
            } else {
                H = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "connectWXDevice"});
                if (be.kS(H)) {
                    a(kVar, "connectWXDevice:fail_UsernameError", null);
                } else {
                    if (!(this.lpl == null || this.lpl.containsValue(str))) {
                        this.lpl.put(H, str);
                    }
                    try {
                        cg cgVar = new cg();
                        cgVar.aZS.aZV = true;
                        cgVar.aZS.aZU = H;
                        cgVar.aZS.aRh = str;
                        com.tencent.mm.sdk.c.a.nhr.z(cgVar);
                        if (cgVar.aZT.aZW) {
                            a(kVar, "connectWXDevice:ok", null);
                        } else {
                            a(kVar, "connectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        v.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(kVar, "connectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(kVar, "connectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean C(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        String H;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                str = (String) kVar.iaJ.get("deviceId");
                v.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
                if (be.kS(str)) {
                    v.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(kVar, "disconnectWXDevice:fail_noDeviceId", null);
                } else {
                    H = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "disconnectWXDevice"});
                    if (be.kS(H)) {
                        a(kVar, "disconnectWXDevice:fail_UsernameError", null);
                    } else {
                        try {
                            ch chVar = new ch();
                            chVar.aZX.aZV = false;
                            chVar.aZX.aZU = H;
                            chVar.aZX.aRh = str;
                            com.tencent.mm.sdk.c.a.nhr.z(chVar);
                            if (chVar.aZY.aZW) {
                                a(kVar, "disconnectWXDevice:ok", null);
                                if (this.lpm != null && this.lpm.containsKey(H)) {
                                    this.lpm.remove(H);
                                }
                            } else {
                                a(kVar, "disconnectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(kVar, "disconnectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                v.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(kVar, "disconnectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            str = (String) kVar.iaJ.get("deviceId");
            v.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "deviceId is null");
                a(kVar, "disconnectWXDevice:fail_noDeviceId", null);
            } else {
                H = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "disconnectWXDevice"});
                if (be.kS(H)) {
                    a(kVar, "disconnectWXDevice:fail_UsernameError", null);
                } else {
                    try {
                        cg cgVar = new cg();
                        cgVar.aZS.aZV = false;
                        cgVar.aZS.aZU = H;
                        cgVar.aZS.aRh = str;
                        com.tencent.mm.sdk.c.a.nhr.z(cgVar);
                        if (cgVar.aZT.aZW) {
                            a(kVar, "disconnectWXDevice:ok", null);
                            if (this.lpl != null && this.lpl.containsKey(H)) {
                                this.lpl.remove(H);
                            }
                        } else {
                            a(kVar, "disconnectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        v.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(kVar, "disconnectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(kVar, "disconnectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean D(final k kVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
            String str = (String) kVar.iaJ.get("deviceId");
            String str2 = (String) kVar.iaJ.get(Columns.TYPE);
            v.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", new Object[]{str, str2});
            if (be.kS(str) || be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(kVar, "getWXDeviceTicket:fail_wrongParams", null);
            } else {
                try {
                    String H = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "getWXDeviceTicket"});
                    if (be.kS(H)) {
                        a(kVar, "getWXDeviceTicket:fail_UsernameError", null);
                    } else {
                        final co coVar = new co();
                        coVar.bat.type = be.getInt(str2, 0);
                        coVar.bat.aZU = H;
                        coVar.bat.aRh = str;
                        coVar.bat.bav = kVar.lqX;
                        coVar.bpT = new Runnable(this) {
                            final /* synthetic */ i lpR;

                            public final void run() {
                                v.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[]{Boolean.valueOf(coVar.bau.baw), coVar.bau.bax});
                                if (!coVar.bau.baw) {
                                    return;
                                }
                                if (be.kS(coVar.bau.bax)) {
                                    this.lpR.a(kVar, "getWXDeviceTicket:fail", null);
                                    return;
                                }
                                Map hashMap = new HashMap();
                                v.i("MicroMsg.MsgHandler", "ticket %s", new Object[]{coVar.bau.bax});
                                hashMap.put("ticket", coVar.bau.bax);
                                this.lpR.a(kVar, "getWXDeviceTicket:ok", hashMap);
                            }
                        };
                        com.tencent.mm.sdk.c.a.nhr.a(coVar, Looper.getMainLooper());
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", new Object[]{e.getMessage()});
                    a(kVar, "getWXDeviceTicket:fail_exception", null);
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(kVar, "getWXDeviceTicket:fail_notInit", null);
        }
        return true;
    }

    private boolean E(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                try {
                    str = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "getWXDeviceInfos"});
                    v.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                    if (be.kS(str)) {
                        a(kVar, "getWXDeviceInfos:fail_UsernameError", null);
                    } else {
                        cm cmVar = new cm();
                        cmVar.bak.aZU = str;
                        cmVar.bak.context = this.context;
                        com.tencent.mm.sdk.c.a.nhr.z(cmVar);
                        if (!cmVar.bal.aZW || cmVar.bal.baj == null) {
                            a(kVar, "getWXDeviceInfos:fail", null);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", cmVar.bal.baj.toString());
                            a(kVar, "getWXDeviceInfos:ok", hashMap);
                        }
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e.getMessage()});
                    a(kVar, "getWXDeviceInfos:fail_exception", null);
                }
            } else {
                v.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(kVar, "getWXDeviceInfos:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            try {
                str = H(kVar);
                com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{str, "getWXDeviceInfos"});
                v.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                if (be.kS(str)) {
                    a(kVar, "getWXDeviceInfos:fail_UsernameError", null);
                } else {
                    cl clVar = new cl();
                    clVar.bah.aZU = str;
                    clVar.bah.context = this.context;
                    com.tencent.mm.sdk.c.a.nhr.z(clVar);
                    if (!clVar.bai.aZW || clVar.bai.baj == null) {
                        a(kVar, "getWXDeviceInfos:fail", null);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", clVar.bai.baj.toString());
                        a(kVar, "getWXDeviceInfos:ok", hashMap);
                    }
                }
            } catch (Exception e2) {
                v.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e2.getMessage()});
                a(kVar, "getWXDeviceInfos:fail_exception", null);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(kVar, "getWXDeviceInfos:fail_notInit", null);
        }
        return true;
    }

    private boolean F(k kVar) {
        String str = "";
        if (kVar.iaJ.containsKey("connType")) {
            str = (String) kVar.iaJ.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        boolean z;
        String H;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bkN().hasInit) {
                str = (String) kVar.iaJ.get("deviceId");
                str2 = (String) kVar.iaJ.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                if (be.kS(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                v.i(str3, str4, objArr);
                if (be.kS(str) || str2 == null) {
                    v.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(kVar, "sendDataToWXDevice:fail_wrongParams", null);
                } else {
                    try {
                        H = H(kVar);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "sendDataToWXDevice"});
                        if (be.kS(H)) {
                            a(kVar, "sendDataToWXDevice:fail_UsernameError", null);
                        } else {
                            dh dhVar = new dh();
                            dhVar.bbk.aZU = H;
                            dhVar.bbk.data = str2;
                            dhVar.bbk.aRh = str;
                            com.tencent.mm.sdk.c.a.nhr.z(dhVar);
                            if (dhVar.bbl.aZW) {
                                a(kVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(kVar, "sendDataToWXDevice:fail", null);
                            }
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e.getMessage()});
                        a(kVar, "sendDataToWXDevice:fail_exception", null);
                    }
                }
            } else {
                v.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(kVar, "sendDataToWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            str = (String) kVar.iaJ.get("deviceId");
            str2 = (String) kVar.iaJ.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            if (be.kS(str2)) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.i(str3, str4, objArr);
            if (be.kS(str) || str2 == null) {
                v.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(kVar, "sendDataToWXDevice:fail_wrongParams", null);
            } else {
                try {
                    H = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "sendDataToWXDevice"});
                    if (be.kS(H)) {
                        a(kVar, "sendDataToWXDevice:fail_UsernameError", null);
                    } else {
                        dg dgVar = new dg();
                        dgVar.bbi.aZU = H;
                        dgVar.bbi.data = Base64.decode(str2, 0);
                        dgVar.bbi.aRh = str;
                        com.tencent.mm.sdk.c.a.nhr.z(dgVar);
                        if (dgVar.bbj.aZW) {
                            a(kVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(kVar, "sendDataToWXDevice:fail", null);
                        }
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e2.getMessage()});
                    a(kVar, "sendDataToWXDevice:fail_exception", null);
                }
            }
        } else {
            v.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(kVar, "sendDataToWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean G(k kVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().hasInit) {
            try {
                String str = (String) kVar.iaJ.get("deviceId");
                String str2 = (String) kVar.iaJ.get("direction");
                v.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", new Object[]{str, str2});
                if (be.kS(str) || be.kS(str2)) {
                    v.e("MicroMsg.MsgHandler", "wrong args");
                    a(kVar, "setSendDataDirection:fail_wrongParams", null);
                } else {
                    int i = be.getInt(str2, 0);
                    String H = H(kVar);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11533, new Object[]{H, "setSendDataDirection"});
                    if (be.kS(H)) {
                        a(kVar, "setSendDataDirection:fail_UsernameError", null);
                    } else {
                        dk dkVar = new dk();
                        dkVar.bbu.aRh = str;
                        dkVar.bbu.direction = i;
                        dkVar.bbu.bbw = false;
                        com.tencent.mm.sdk.c.a.nhr.z(dkVar);
                        if (dkVar.bbv.aZW) {
                            a(kVar, "setSendDataDirection:ok", null);
                        } else {
                            a(kVar, "setSendDataDirection:fail", null);
                        }
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", new Object[]{e.getMessage()});
                a(kVar, "setSendDataDirection:fail_exception", null);
            }
        } else {
            v.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(kVar, "setSendDataDirection:fail_notInit", null);
        }
        return true;
    }

    public String blu() {
        String str = null;
        try {
            if (this.leB != null) {
                Bundle i = this.leB.i(18, null);
                if (i != null) {
                    str = i.getString("preChatName");
                }
            }
        } catch (RemoteException e) {
            v.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return str;
    }

    public int bjG() {
        int i = -1;
        try {
            if (this.leB != null) {
                Bundle i2 = this.leB.i(22, null);
                if (i2 != null) {
                    i = i2.getInt("pay_channel");
                }
            }
        } catch (RemoteException e) {
            v.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return i;
    }

    public int aLC() {
        int i = -1;
        try {
            if (this.leB != null) {
                Bundle i2 = this.leB.i(25, null);
                if (i2 != null) {
                    i = i2.getInt("scene");
                }
            }
        } catch (RemoteException e) {
            v.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return i;
    }

    private String H(k kVar) {
        String blu = blu();
        if (aLC() == 27) {
            return this.lpk;
        }
        String str;
        if (bjG() == 8 || bjG() == -1) {
            if (kVar == null) {
                return null;
            }
            str = (String) kVar.iaJ.get("src_username");
            v.i("MicroMsg.MsgHandler", "key_src_username(%s)", new Object[]{(String) kVar.iaJ.get("src_username")});
            return str;
        } else if (this.ezn != null) {
            return this.ezn;
        } else {
            if (be.kS(blu)) {
                return null;
            }
            v.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            BizInfo hw = com.tencent.mm.modelbiz.e.hw(blu);
            if (hw == null) {
                return null;
            }
            ExtInfo aX = hw.aX(false);
            if (aX == null || aX.CR() == null || !aX.CR().Da()) {
                return null;
            }
            str = (String) kVar.iaJ.get("src_username");
            v.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", new Object[]{(String) kVar.iaJ.get("src_username")});
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean I(com.tencent.mm.plugin.webview.ui.tools.jsapi.k r14) {
        /*
        r13 = this;
        r6 = 7;
        r12 = 2;
        r2 = 3;
        r11 = 1;
        r5 = 0;
        r0 = r14.iaJ;
        r1 = "sourceType";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = "MicroMsg.MsgHandler";
        r3 = "source Type = %s";
        r4 = new java.lang.Object[r11];
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r1, r3, r4);
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 != 0) goto L_0x019c;
    L_0x0023:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0052 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0052 }
        r1 = r5;
        r0 = r5;
    L_0x002a:
        r4 = r3.length();	 Catch:{ Exception -> 0x0192 }
        if (r1 >= r4) goto L_0x005d;
    L_0x0030:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "album";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x0042;
    L_0x003d:
        r0 = r0 | 1;
    L_0x003f:
        r1 = r1 + 1;
        goto L_0x002a;
    L_0x0042:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "camera";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x003f;
    L_0x004f:
        r0 = r0 | 2;
        goto L_0x003f;
    L_0x0052:
        r0 = move-exception;
        r0 = r5;
    L_0x0054:
        r1 = "MicroMsg.MsgHandler";
        r3 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.v.e(r1, r3);
    L_0x005d:
        if (r0 != 0) goto L_0x0199;
    L_0x005f:
        r1 = r2;
    L_0x0060:
        r0 = "MicroMsg.MsgHandler";
        r3 = "real scene = %d";
        r4 = new java.lang.Object[r11];
        r7 = java.lang.Integer.valueOf(r1);
        r4[r5] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        if (r1 == r12) goto L_0x0075;
    L_0x0073:
        if (r1 != r2) goto L_0x009c;
    L_0x0075:
        r0 = r13.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r7 = "";
        r8 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r7, r8);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r7 = new java.lang.Object[r11];
        r8 = java.lang.Boolean.valueOf(r0);
        r7[r5] = r8;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r7);
        if (r0 != 0) goto L_0x009c;
    L_0x009b:
        return r11;
    L_0x009c:
        r0 = r14.iaJ;
        r3 = "count";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r7 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r5);
        r0 = r14.iaJ;
        r3 = "sizeType";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r4 = java.lang.Boolean.valueOf(r5);
        r3 = java.lang.Boolean.valueOf(r5);
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r8 != 0) goto L_0x0195;
    L_0x00c4:
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00fa }
        r8.<init>(r0);	 Catch:{ Exception -> 0x00fa }
        r0 = r3;
        r3 = r4;
        r4 = r5;
    L_0x00cc:
        r9 = r8.length();	 Catch:{ Exception -> 0x018f }
        if (r4 >= r9) goto L_0x0106;
    L_0x00d2:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "original";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e7;
    L_0x00df:
        r9 = 1;
        r3 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
    L_0x00e4:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x00e7:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "compressed";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e4;
    L_0x00f4:
        r9 = 1;
        r0 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
        goto L_0x00e4;
    L_0x00fa:
        r0 = move-exception;
        r0 = r3;
        r3 = r4;
    L_0x00fd:
        r4 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.v.e(r4, r8);
    L_0x0106:
        r4 = r3.booleanValue();
        if (r4 == 0) goto L_0x0175;
    L_0x010c:
        r4 = r0.booleanValue();
        if (r4 != 0) goto L_0x0175;
    L_0x0112:
        r0 = java.lang.Boolean.valueOf(r11);
        r4 = r6;
    L_0x0117:
        r3 = new android.content.Intent;
        r3.<init>();
        r6 = "key_pick_local_pic_capture";
        r3.putExtra(r6, r1);
        r6 = "key_pick_local_pic_count";
        r3.putExtra(r6, r7);
        r6 = "key_pick_local_pic_query_source_type";
        r3.putExtra(r6, r4);
        r6 = "key_pick_local_pic_send_raw";
        r3.putExtra(r6, r0);
        r6 = "query_media_type";
        r3.putExtra(r6, r11);
        r6 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r1 = java.lang.Integer.valueOf(r1);
        r9[r5] = r1;
        r1 = java.lang.Integer.valueOf(r7);
        r9[r11] = r1;
        r1 = java.lang.Integer.valueOf(r4);
        r9[r12] = r1;
        r9[r2] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r6, r8, r9);
        r0 = r13.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x009b;
    L_0x0160:
        r0 = r13.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.nDS = r13;
        r0 = r13.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 14;
        com.tencent.mm.ay.c.a(r0, r1, r2, r3, r4, r5);
        goto L_0x009b;
    L_0x0175:
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0187;
    L_0x017b:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0187;
    L_0x0181:
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r6;
        goto L_0x0117;
    L_0x0187:
        r3 = 8;
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r3;
        goto L_0x0117;
    L_0x018f:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x0192:
        r1 = move-exception;
        goto L_0x0054;
    L_0x0195:
        r0 = r3;
        r3 = r4;
        goto L_0x0106;
    L_0x0199:
        r1 = r0;
        goto L_0x0060;
    L_0x019c:
        r0 = r5;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.I(com.tencent.mm.plugin.webview.ui.tools.jsapi.k):boolean");
    }

    private boolean J(k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            m.a(kVar.lqY, false, null, str);
            v.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!be.kS(str) || be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(kVar, "uploadImage:fail_missing arguments", null);
            } else {
                a(kVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadImage", z);
            }
            return true;
        }
        z = true;
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str)) {
        }
        v.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(kVar, "uploadImage:fail_missing arguments", null);
        return true;
    }

    private boolean K(final k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        final String str2 = (String) kVar.iaJ.get("serverId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            m.a(kVar.lqY, false, null, str);
            v.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
            if (!be.kS(str) || be.kS(str2)) {
                a(kVar, "downloadImage:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.d.c.b anonymousClass20 = new com.tencent.mm.plugin.webview.d.c.b(this) {
                    final /* synthetic */ i lpR;

                    public final void a(boolean z, String str, String str2, String str3) {
                        v.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (!be.kS(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a((com.tencent.mm.plugin.webview.d.c.b) this);
                            if (this.lpR.dwR != null) {
                                this.lpR.dwR.dismiss();
                                this.lpR.dwR = null;
                            }
                            if (z) {
                                x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
                                if ((DW instanceof z) && be.kS(DW.lek)) {
                                    ((z) DW).bil();
                                }
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                this.lpR.a(kVar, "downloadImage:ok", hashMap);
                                return;
                            }
                            this.lpR.a(kVar, "downloadImage:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, anonymousClass20);
                v.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(2131231164);
                    this.dwR = g.a(context, this.context.getString(2131236673), true, new OnCancelListener(this) {
                        final /* synthetic */ i lpR;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a(anonymousClass20);
                            com.tencent.mm.plugin.webview.e.e.bjc();
                            w.DS(str2);
                            this.lpR.a(kVar, "downloadImage:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
        if (be.kS(str)) {
        }
        a(kVar, "downloadImage:fail_missing arguments", null);
        return true;
    }

    private boolean L(k kVar) {
        boolean z;
        v.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (be.kS(str) && !be.kS(str2)) {
                m.a(kVar.lqY, false, null, str);
                x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
                if (DW != null) {
                    switch (DW.bcp) {
                        case 1:
                            a(kVar, str, str2, com.tencent.mm.modelcdntran.b.cED, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(kVar, str, str2, com.tencent.mm.modelcdntran.b.cED, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(kVar, str, str2, com.tencent.mm.modelcdntran.b.cED, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                }
                v.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", new Object[]{str2});
                a(kVar, "uploadEncryptMediaFile:file_not_exist", null);
            } else {
                v.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(kVar, "uploadEncryptMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        v.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str)) {
        }
        v.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(kVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.k r13, int r14) {
        /*
        r12 = this;
        r1 = 60;
        r11 = 3;
        r10 = 2;
        r5 = 0;
        r6 = 1;
        r0 = r13.iaJ;
        r2 = "sourceType";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.be.ma(r0);
        r0 = r13.iaJ;
        r2 = "camera";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r0);
        r0 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d";
        r7 = new java.lang.Object[r11];
        r7[r5] = r3;
        r7[r6] = r4;
        r8 = java.lang.Integer.valueOf(r14);
        r7[r10] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r7);
        r0 = r13.iaJ;
        r2 = "maxDuration";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r1);
        r0 = "album";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x01cd;
    L_0x0051:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x0053:
        r7 = "camera";
        r3 = r3.contains(r7);
        if (r3 == 0) goto L_0x0071;
    L_0x005c:
        if (r2 > 0) goto L_0x0066;
    L_0x005e:
        r0 = "chooseVideo:fail";
        r1 = 0;
        r12.a(r13, r0, r1);
    L_0x0065:
        return r6;
    L_0x0066:
        r3 = "front";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0178;
    L_0x006f:
        r0 = r0 | 16;
    L_0x0071:
        if (r0 != 0) goto L_0x01ca;
    L_0x0073:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        r7 = r0;
    L_0x0076:
        r0 = 16;
        if (r7 == r0) goto L_0x0082;
    L_0x007a:
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r7 == r0) goto L_0x0082;
    L_0x007e:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        if (r7 != r0) goto L_0x00d2;
    L_0x0082:
        if (r14 == r6) goto L_0x0086;
    L_0x0084:
        if (r14 != r10) goto L_0x017c;
    L_0x0086:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00ac:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.RECORD_AUDIO";
        r4 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkMicroPhone[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00d2:
        r0 = r13.iaJ;
        r3 = "quality";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r6);
        if (r0 == 0) goto L_0x01c7;
    L_0x00e3:
        if (r0 == r6) goto L_0x01c7;
    L_0x00e5:
        r4 = r6;
    L_0x00e6:
        if (r2 <= r1) goto L_0x01c4;
    L_0x00e8:
        r0 = r1;
    L_0x00e9:
        r1 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r8 = java.lang.Integer.valueOf(r7);
        r3[r5] = r8;
        r8 = java.lang.Integer.valueOf(r6);
        r3[r6] = r8;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r10] = r8;
        r8 = java.lang.Integer.valueOf(r0);
        r3[r11] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r3 = new android.content.Intent;
        r3.<init>();
        r1 = "key_pick_local_pic_capture";
        r3.putExtra(r1, r7);
        r1 = "key_pick_local_pic_count";
        r3.putExtra(r1, r6);
        r1 = "key_pick_local_pic_query_source_type";
        r2 = 7;
        r3.putExtra(r1, r2);
        r1 = "key_pick_local_media_quality";
        r3.putExtra(r1, r4);
        r1 = "key_pick_local_media_duration";
        r3.putExtra(r1, r0);
        r0 = "query_media_type";
        r3.putExtra(r0, r10);
        r0 = "key_pick_local_media_video_type";
        r3.putExtra(r0, r14);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doChooseVideo: realScene: %d, count: %d, querySourceType: %d";
        r2 = new java.lang.Object[r11];
        r4 = java.lang.Integer.valueOf(r7);
        r2[r5] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r2[r6] = r4;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r10] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r12.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x0065;
    L_0x0161:
        r0 = r12.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.nDS = r12;
        if (r14 != r6) goto L_0x01a4;
    L_0x0169:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 45;
        com.tencent.mm.ay.c.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x0178:
        r0 = r0 | 256;
        goto L_0x0071;
    L_0x017c:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r8);
        if (r0 != 0) goto L_0x00d2;
    L_0x01a2:
        goto L_0x0065;
    L_0x01a4:
        if (r14 != r10) goto L_0x01b5;
    L_0x01a6:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 47;
        com.tencent.mm.ay.c.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x01b5:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 32;
        com.tencent.mm.ay.c.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x01c4:
        r0 = r2;
        goto L_0x00e9;
    L_0x01c7:
        r4 = r0;
        goto L_0x00e6;
    L_0x01ca:
        r7 = r0;
        goto L_0x0076;
    L_0x01cd:
        r0 = r5;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.k, int):boolean");
    }

    private boolean M(k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (be.kS(str) && !be.kS(str2)) {
                m.a(kVar.lqY, false, null, str);
                switch (com.tencent.mm.plugin.webview.e.e.bjd().DW(str2).bcp) {
                    case 1:
                        a(kVar, str, str2, com.tencent.mm.modelcdntran.b.cEF, 202, 2, "uploadMediaFile", z);
                        break;
                    case 4:
                        b(kVar, str, str2, com.tencent.mm.modelcdntran.b.cEG, 202, 2, "uploadMediaFile", z);
                        break;
                    default:
                        b(kVar, str, str2, com.tencent.mm.modelcdntran.b.cEI, 202, 2, "uploadMediaFile", z);
                        break;
                }
            }
            v.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
            a(kVar, "uploadMediaFile:fail_missing arguments", null);
            return true;
        }
        z = true;
        v.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str)) {
        }
        v.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(kVar, "uploadMediaFile:fail_missing arguments", null);
        return true;
    }

    private void a(final k kVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final String str5 = str2;
        AnonymousClass24 anonymousClass24 = new com.tencent.mm.plugin.webview.d.c.b(this) {
            final /* synthetic */ i lpR;

            public final void a(boolean z, String str, String str2, String str3) {
                v.i("MicroMsg.MsgHandler", str4 + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!be.kS(str) && str.equals(str5)) {
                    com.tencent.mm.plugin.webview.e.e.bjc().a((com.tencent.mm.plugin.webview.d.c.b) this);
                    if (this.lpR.dwR != null) {
                        this.lpR.dwR.dismiss();
                        this.lpR.dwR = null;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        this.lpR.a(kVar, str4 + ":ok", hashMap);
                        return;
                    }
                    this.lpR.a(kVar, str4 + ":fail", null);
                }
            }
        };
        x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
        if (DW == null) {
            a(kVar, str3 + ":fail", null);
            return;
        }
        com.tencent.mm.ae.d b = n.GH().b(Long.valueOf(n.GH().a(DW.lel, DW.lep ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str6 = DW.lel;
        DW.lel = n.GH().l(b.cLv, "", "");
        v.i("MicroMsg.MsgHandler", "Image Inserted: %s", new Object[]{r2});
        v.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, i, i2, i3, anonymousClass24))});
        if (!com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, i, i2, i3, anonymousClass24)) {
            a(kVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(2131231164);
            final AnonymousClass24 anonymousClass242 = anonymousClass24;
            final String str7 = str2;
            final k kVar2 = kVar;
            final String str8 = str3;
            this.dwR = g.a(context, this.context.getString(2131236692), true, new OnCancelListener(this) {
                final /* synthetic */ i lpR;

                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.plugin.webview.e.e.bjc().a(anonymousClass242);
                    com.tencent.mm.plugin.webview.e.e.bjc();
                    w.DR(str7);
                    this.lpR.a(kVar2, str8 + ":fail", null);
                }
            });
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.leB = this.lpp;
        }
        DW.lel = str6;
    }

    private void b(k kVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
        if (DW == null || be.kS(DW.lel) || !com.tencent.mm.a.e.aR(DW.lel)) {
            a(kVar, str3 + ":fail_file not exist", null);
        } else if (com.tencent.mm.network.aa.bk(this.context)) {
            c(kVar, str, str2, i, i2, i3, str3, z);
        } else {
            String ed = be.ed((long) com.tencent.mm.a.e.aQ(DW.lel));
            final k kVar2 = kVar;
            final String str4 = str;
            final String str5 = str2;
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str6 = str3;
            final boolean z2 = z;
            final k kVar3 = kVar;
            final String str7 = str3;
            g.a(this.context, this.context.getString(2131236609, new Object[]{ed}), this.context.getString(2131231164), new OnClickListener(this) {
                final /* synthetic */ i lpR;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lpR.c(kVar2, str4, str5, i4, i5, i6, str6, z2);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ i lpR;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lpR.a(kVar3, str7 + ":cancel", null);
                }
            });
        }
    }

    private void c(final k kVar, String str, final String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final com.tencent.mm.plugin.webview.d.c.b anonymousClass28 = new com.tencent.mm.plugin.webview.d.c.b(this) {
            final /* synthetic */ i lpR;

            public final void a(boolean z, String str, String str2, String str3) {
                v.i("MicroMsg.MsgHandler", str4 + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!be.kS(str) && str.equals(str2)) {
                    this.lpR.lpJ.remove(str2);
                    com.tencent.mm.plugin.webview.e.e.bjc().a((com.tencent.mm.plugin.webview.d.c.b) this);
                    if (this.lpR.dwR != null) {
                        this.lpR.dwR.dismiss();
                        this.lpR.dwR = null;
                    }
                    i.A(this.lpR);
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        this.lpR.a(kVar, str4 + ":ok", hashMap);
                        return;
                    }
                    this.lpR.a(kVar, str4 + ":fail", null);
                }
            }
        };
        boolean a = com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, i, i2, i3, anonymousClass28);
        v.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(a)});
        if (a) {
            a aVar = new a();
            aVar.lpf = kVar;
            aVar.lqU = anonymousClass28;
            this.lpJ.put(str2, aVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(2131236610));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(2131236610));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(2131236607));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(2131236607));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(2131236608));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(2131236608));
            try {
                this.leB.g(13, bundle);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
            }
            if (z) {
                Context context = this.context;
                this.context.getString(2131231164);
                final String str5 = str2;
                final k kVar2 = kVar;
                final String str6 = str3;
                this.dwR = g.a(context, this.context.getString(2131236692), true, new OnCancelListener(this) {
                    final /* synthetic */ i lpR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.webview.e.e.bjc().a(anonymousClass28);
                        com.tencent.mm.plugin.webview.e.e.bjc();
                        w.DR(str5);
                        i.A(this.lpR);
                        this.lpR.a(kVar2, str6 + ":cancel", null);
                    }
                });
                this.dwR.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ i lpR;

                    {
                        this.lpR = r1;
                    }

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        g.a(this.lpR.context, true, this.lpR.context.getString(2131236610), "", this.lpR.context.getString(2131236607), this.lpR.context.getString(2131236608), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass30 lqq;

                            {
                                this.lqq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.lqq.lpR.dwR.cancel();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass30 lqq;

                            {
                                this.lqq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return true;
                    }
                });
                return;
            } else if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.leB = this.lpp;
                return;
            } else {
                return;
            }
        }
        a(kVar, str3 + ":fail", null);
    }

    private boolean N(k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occurred : %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!be.kS(str) || be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(kVar, "uploadVideo:fail_missing arguments", null);
            } else {
                b(kVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadVideo", z);
            }
            return true;
        }
        z = true;
        v.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str)) {
        }
        v.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(kVar, "uploadVideo:fail_missing arguments", null);
        return true;
    }

    public final boolean blv() {
        boolean z = !be.kS(this.lpK);
        if (z) {
            v.e("MicroMsg.MsgHandler", "in recording state.");
        }
        return z;
    }

    private boolean O(k kVar) {
        if (blv()) {
            try {
                this.leB.g(2007, null);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(kVar, "startRecord:fail_recording", null);
        } else {
            String str = (String) kVar.iaJ.get("appId");
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(kVar, "startRecord:fail_missing arguments", null);
            } else {
                m.a(kVar.lqY, false, null, str);
                if (com.tencent.mm.pluginsdk.i.a.aP(this.context, "android.permission.RECORD_AUDIO")) {
                    final x DU = x.DU(ah.Eb(str));
                    DU.appId = str;
                    com.tencent.mm.plugin.webview.e.e.bjd().b(DU);
                    v.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", new Object[]{str, r1, DU.lel});
                    this.lpK = DU.bde;
                    ad.o(new Runnable(this) {
                        final /* synthetic */ i lpR;

                        public final void run() {
                            final ek ekVar = new ek();
                            ekVar.bcM.op = 1;
                            ekVar.bcM.filePath = DU.lel;
                            ekVar.bcM.aTb = new Runnable(this) {
                                final /* synthetic */ AnonymousClass31 pQl;

                                public final void run() {
                                    v.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[]{DU.bde});
                                    try {
                                        this.pQl.lpR.lpK = null;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("localId", DU.bde);
                                        String str = "recordResult";
                                        StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
                                        String str2 = (ekVar.bcN.bcO != 2 || ekVar.bcN.bcO == 3) ? "ok" : "fail";
                                        bundle.putString(str, stringBuilder.append(str2).toString());
                                        if (this.pQl.lpR.leB != null) {
                                            this.pQl.lpR.leB.g(2008, bundle);
                                        } else {
                                            v.e("MicroMsg.MsgHandler", "callbacker is null");
                                        }
                                    } catch (Exception e) {
                                        v.e("MicroMsg.MsgHandler", "callback stop record failed");
                                    }
                                }
                            };
                            com.tencent.mm.sdk.c.a.nhr.z(ekVar);
                        }
                    });
                    try {
                        this.leB.g(2007, null);
                    } catch (Exception e2) {
                        v.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(kVar, "startRecord:ok", null);
                } else {
                    WebViewStubTempUI.a(this.context, new String[]{"android.permission.RECORD_AUDIO"}, this.bkE);
                }
            }
        }
        return true;
    }

    private boolean P(k kVar) {
        if (blv()) {
            String str = (String) kVar.iaJ.get("appId");
            v.i("MicroMsg.MsgHandler", "stop record appId : %s", new Object[]{str});
            m.a(kVar.lqY, false, null, str);
            final x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(this.lpK);
            if (DW == null || !str.equals(DW.appId)) {
                v.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", new Object[]{str});
                a(kVar, "stopRecord:fail", null);
            } else {
                ad.o(new Runnable(this) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        ek ekVar = new ek();
                        ekVar.bcM.op = 2;
                        ekVar.bcM.filePath = DW.lel;
                        com.tencent.mm.sdk.c.a.nhr.z(ekVar);
                        this.lpR.lpK = null;
                    }
                });
                v.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", new Object[]{DW.aST, DW.lel, DW.bde});
                Map hashMap = new HashMap();
                hashMap.put("localId", DW.bde);
                try {
                    this.leB.g(2009, null);
                } catch (RemoteException e) {
                    v.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(kVar, "stopRecord:ok", hashMap);
            }
        } else {
            v.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(kVar, "stopRecord:fail", null);
        }
        return true;
    }

    private boolean Q(final k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        final String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            m.a(kVar.lqY, false, null, str);
            v.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!be.kS(str) || be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(kVar, "uploadVoice:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.d.c.b anonymousClass38 = new com.tencent.mm.plugin.webview.d.c.b(this) {
                    final /* synthetic */ i lpR;

                    public final void a(boolean z, String str, String str2, String str3) {
                        v.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", new Object[]{Boolean.valueOf(z), str2, str});
                        if (!be.kS(str) && str.equals(str2)) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a((com.tencent.mm.plugin.webview.d.c.b) this);
                            if (this.lpR.dwR != null) {
                                this.lpR.dwR.dismiss();
                                this.lpR.dwR = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("serverId", str2);
                                this.lpR.a(kVar, "uploadVoice:ok", hashMap);
                                return;
                            }
                            this.lpR.a(kVar, "uploadVoice:fail", null);
                        }
                    }
                };
                v.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.e.e.bjc().b(str, str2, anonymousClass38))});
                if (!com.tencent.mm.plugin.webview.e.e.bjc().b(str, str2, anonymousClass38)) {
                    a(kVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(2131231164);
                    this.dwR = g.a(context, this.context.getString(2131236692), true, new OnCancelListener(this) {
                        final /* synthetic */ i lpR;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a(anonymousClass38);
                            com.tencent.mm.plugin.webview.e.e.bjc();
                            w.DR(str2);
                            this.lpR.a(kVar, "uploadVoice:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str)) {
        }
        v.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(kVar, "uploadVoice:fail_missing arguments", null);
        return true;
    }

    private boolean R(final k kVar) {
        boolean z;
        final com.tencent.mm.plugin.webview.d.c.b anonymousClass40;
        String str = (String) kVar.iaJ.get("appId");
        final String str2 = (String) kVar.iaJ.get("serverId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            m.a(kVar.lqY, false, null, str);
            v.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (be.kS(str2)) {
                anonymousClass40 = new com.tencent.mm.plugin.webview.d.c.b(this) {
                    final /* synthetic */ i lpR;

                    public final void a(boolean z, String str, String str2, String str3) {
                        v.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (!be.kS(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a((com.tencent.mm.plugin.webview.d.c.b) this);
                            if (this.lpR.dwR != null) {
                                this.lpR.dwR.dismiss();
                                this.lpR.dwR = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                this.lpR.a(kVar, "downloadVoice:ok", hashMap);
                                return;
                            }
                            this.lpR.a(kVar, "downloadVoice:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, anonymousClass40);
                v.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(2131231164);
                    this.dwR = g.a(context, this.context.getString(2131236673), true, new OnCancelListener(this) {
                        final /* synthetic */ i lpR;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a(anonymousClass40);
                            com.tencent.mm.plugin.webview.e.e.bjc();
                            w.DS(str2);
                            this.lpR.a(kVar, "downloadVoice:fail", null);
                        }
                    });
                }
            } else {
                a(kVar, "downloadVoice:fail_invaild_serverId", null);
            }
            return true;
        }
        z = true;
        m.a(kVar.lqY, false, null, str);
        v.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str2)) {
            anonymousClass40 = /* anonymous class already generated */;
            com.tencent.mm.plugin.webview.e.e.bjc().a(str, str2, anonymousClass40);
            v.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
            if (z) {
                Context context2 = this.context;
                this.context.getString(2131231164);
                this.dwR = g.a(context2, this.context.getString(2131236673), true, /* anonymous class already generated */);
            }
        } else {
            a(kVar, "downloadVoice:fail_invaild_serverId", null);
        }
        return true;
    }

    private boolean S(k kVar) {
        String str = (String) kVar.iaJ.get("menuList");
        if (be.kS(str)) {
            a(kVar, "hideMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.leB.h(3001, bundle);
                a(kVar, "hideMenuItems:ok", null);
            } catch (JSONException e) {
                v.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(kVar, "hideMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                a(kVar, "hideMenuItems:param is empty", null);
            }
        }
        return true;
    }

    private boolean T(k kVar) {
        String str = (String) kVar.iaJ.get("menuList");
        if (be.kS(str)) {
            a(kVar, "showMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.leB.h(3002, bundle);
            } catch (JSONException e) {
                v.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(kVar, "showMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                v.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e2.getMessage()});
                a(kVar, "showMenuItems:param is empty", null);
            }
            a(kVar, "showMenuItems:ok", null);
        }
        return true;
    }

    private boolean blw() {
        try {
            this.leB.h(3003, null);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.fHM = false;
        return false;
    }

    private boolean blx() {
        try {
            this.leB.h(3004, null);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.fHM = false;
        return false;
    }

    private boolean U(k kVar) {
        try {
            this.leB.h(3003, null);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(kVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(kVar, "hideAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean V(k kVar) {
        try {
            this.leB.h(3004, null);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(kVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(kVar, "showAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean W(k kVar) {
        String str = (String) kVar.iaJ.get("jsApiList");
        if (be.kS(str)) {
            a(kVar, "checkJsApi:param is empty", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(kVar, "checkJsApi:param is empty", null);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.Is(string) == null) {
                            if (ic.lVZ == null) {
                                Set hashSet = new HashSet();
                                ic.lVZ = hashSet;
                                hashSet.add("menu:share:QZone");
                                ic.lVZ.add("onImageDownloadProgress");
                                ic.lVZ.add("onVoiceUploadProgress");
                                ic.lVZ.add("onVoiceDownloadProgress");
                                ic.lVZ.add("onVoiceRecordEnd");
                                ic.lVZ.add("onVoicePlayBegin");
                                ic.lVZ.add("onVoicePlayEnd");
                                ic.lVZ.add("onLocalImageUploadProgress");
                                ic.lVZ.add("wxdownload:state_change");
                                ic.lVZ.add("wxdownload:progress_change");
                                ic.lVZ.add("hdOnDeviceStateChanged");
                                ic.lVZ.add("activity:state_change");
                                ic.lVZ.add("onWXDeviceBluetoothStateChange");
                                ic.lVZ.add("onWXDeviceLanStateChange");
                                ic.lVZ.add("onWXDeviceBindStateChange");
                                ic.lVZ.add("onReceiveDataFromWXDevice");
                                ic.lVZ.add("onScanWXDeviceResult");
                                ic.lVZ.add("onWXDeviceStateChange");
                                ic.lVZ.add("onGetKeyboardHeight");
                                ic.lVZ.add("onGetSmiley");
                                ic.lVZ.add("onMediaFileUploadProgess");
                                ic.lVZ.add("onGetA8KeyUrl");
                                ic.lVZ.add("onPageStateChange");
                                ic.lVZ.add("onGetMsgProofItems");
                            }
                            if (!ic.lVZ.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(kVar, "checkJsApi:ok", hashMap);
                }
            } catch (JSONException e) {
                v.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(kVar, "checkJsApi:param is empty", null);
            }
        }
        return true;
    }

    private boolean X(k kVar) {
        try {
            int intValue;
            String str = (String) kVar.iaJ.get("userName");
            try {
                intValue = ((Integer) kVar.iaJ.get(Columns.TYPE)).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(kVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.ay.c.a(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent, false);
        } catch (Exception e2) {
            v.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", new Object[]{e2.getMessage()});
        }
        return false;
    }

    private boolean Y(k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("appId");
        final String str2 = (String) kVar.iaJ.get("localId");
        Object obj = kVar.iaJ.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = be.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                v.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
            m.a(kVar.lqY, false, null, str);
            if (!be.kS(str) || be.kS(str2)) {
                v.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
                a(kVar, "translateVoice:fail_missing arguments", null);
            } else {
                final x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str2);
                if (DW != null) {
                    final k kVar2 = kVar;
                    ad.o(new Runnable(this) {
                        final /* synthetic */ i lpR;

                        public final void run() {
                            if (z) {
                                i iVar = this.lpR;
                                Context h = this.lpR.context;
                                this.lpR.context.getString(2131231164);
                                iVar.dwR = g.a(h, this.lpR.context.getString(2131236691), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass43 pQq;

                                    {
                                        this.pQq = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        en enVar = new en();
                                        enVar.bdc.bdf = 1;
                                        com.tencent.mm.sdk.c.a.nhr.z(enVar);
                                        this.pQq.lpR.a(kVar2, "translateVoice:fail", null);
                                    }
                                });
                            }
                            final en enVar = new en();
                            enVar.bdc.bde = str2;
                            enVar.bdc.aST = DW.aST;
                            enVar.bdc.bdf = 0;
                            enVar.bdc.bdg = new Runnable(this) {
                                final /* synthetic */ AnonymousClass43 pQq;

                                public final void run() {
                                    if (enVar.bdd.baS) {
                                        if (this.pQq.lpR.dwR != null) {
                                            this.pQq.lpR.dwR.dismiss();
                                            this.pQq.lpR.dwR = null;
                                        }
                                        if (be.kS(enVar.bdd.content)) {
                                            this.pQq.lpR.a(kVar2, "translateVoice:fail", null);
                                            return;
                                        }
                                        Map hashMap = new HashMap();
                                        hashMap.put("translateResult", enVar.bdd.content);
                                        this.pQq.lpR.a(kVar2, "translateVoice:ok", hashMap);
                                    }
                                }
                            };
                            com.tencent.mm.sdk.c.a.nhr.z(enVar);
                        }
                    });
                } else {
                    a(kVar, "translateVoice:fail_arguments error", null);
                }
            }
            return true;
        }
        z = true;
        v.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
        m.a(kVar.lqY, false, null, str);
        if (be.kS(str)) {
        }
        v.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
        a(kVar, "translateVoice:fail_missing arguments", null);
        return true;
    }

    private boolean Z(k kVar) {
        WWMediaLink wWMediaLink = new WWMediaLink();
        wWMediaLink.bea = (String) kVar.iaJ.get("img_url");
        try {
            wWMediaLink.webpageUrl = aj.Ec(this.leB.Ra());
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) kVar.iaJ.get("link");
        }
        wWMediaLink.title = (String) kVar.iaJ.get("title");
        wWMediaLink.description = (String) kVar.iaJ.get("desc");
        WWAPIFactory.gC(this.context).a(wWMediaLink);
        a(kVar, "shareWeWork:ok", null);
        return true;
    }

    private boolean aa(k kVar) {
        if (com.tencent.mm.plugin.webview.stub.a.cO(this.context)) {
            String str = (String) kVar.iaJ.get("img_url");
            String str2 = (String) kVar.iaJ.get("title");
            String str3 = (String) kVar.iaJ.get("desc");
            String string = this.context.getResources().getString(2131230720);
            String str4 = (String) kVar.iaJ.get("link");
            try {
                if (be.kS(str4)) {
                    str4 = this.leB.Ra();
                }
            } catch (RemoteException e) {
                v.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
            }
            str4 = aj.Ec(str4);
            if (be.kS(str4) || be.kS(str2) || be.kS(str3)) {
                v.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", new Object[]{str4, str2, str3});
                a(kVar, "shareQQ:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("image_url", s.Ib(str));
                hashMap.put("title", s.Ib(str2));
                hashMap.put("description", s.Ib(str3));
                hashMap.put("url", s.Ib(str4));
                hashMap.put("app_name", s.Ib(string));
                hashMap.put("req_type", s.Ib("1"));
                if (kVar.lqZ.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", s.Ib("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(s.S(hashMap));
                v.d("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(268435456);
                if (be.m(this.context, intent) && (this.context instanceof Activity)) {
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(kVar, kVar.lqZ + ":ok", null);
                } else {
                    a(kVar, kVar.lqZ + ":fail", null);
                }
            }
        } else {
            v.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(kVar, "shareQQ:fail", null);
        }
        return true;
    }

    private boolean ab(k kVar) {
        String str = (String) kVar.iaJ.get("desc");
        String str2 = (String) kVar.iaJ.get("img_url");
        String str3 = (String) kVar.iaJ.get("link");
        try {
            if (be.kS(str3)) {
                str3 = this.leB.Ra();
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
        }
        str3 = aj.Ec(str3);
        if (be.kS(str3)) {
            v.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(kVar, "shareWeiboApp:fail", null);
        } else {
            if (be.kS(str)) {
                str = ((String) kVar.iaJ.get("title")) + " " + str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(Columns.TYPE, Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put("content", s.Ia(str));
            hashMap.put("url", s.Ia(str2));
            hashMap.put("thumbnailurl", s.Ia(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(s.S(hashMap));
            v.i("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(268435456);
            if (be.m(this.context, intent)) {
                this.context.startActivity(intent);
                a(kVar, "shareWeiboApp:ok", null);
            } else {
                a(kVar, "shareWeiboApp:fail", null);
            }
        }
        return true;
    }

    private boolean ac(k kVar) {
        String str = (String) kVar.iaJ.get("sessionFrom");
        if (be.kS((String) kVar.iaJ.get("sessionId"))) {
            a(kVar, "startTempSession:fail_missing arguments", null);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = kVar.iaJ.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = be.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = be.getInt(be.ma((String) kVar.iaJ.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.lps.Fu(this.leB.Ra()), be.ma(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(kVar, "startTempSession:ok", null);
            }
            intValue = 0;
            i = be.getInt(be.ma((String) kVar.iaJ.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.lps.Fu(this.leB.Ra()), be.ma(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", 4);
                } else {
                    intent.putExtra("translate_link_scene", i);
                }
                this.context.startActivity(intent);
                a(kVar, "startTempSession:ok", null);
            } catch (Throwable e3) {
                v.a("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(kVar, "startTempSession:fail_exception", null);
            }
        }
        return true;
    }

    private boolean ad(k kVar) {
        try {
            String str = (String) kVar.iaJ.get("userName");
            String str2 = (String) kVar.iaJ.get("nickName");
            if (be.kS(str)) {
                a(kVar, "setPageOwner:missing_arguments", null);
            } else {
                this.leB.da(str, str2);
                a(kVar, "setPageOwner:ok", null);
            }
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    private boolean ae(final k kVar) {
        try {
            String str = (String) kVar.iaJ.get("appId");
            String str2 = (String) kVar.iaJ.get("signature");
            m.a(kVar.lqY, false, null, str);
            if (be.kS(str)) {
                a(kVar, "get_wechat_verify_ticket:fail ticket", null);
            } else {
                ak.vy().a(1097, new e(this) {
                    final /* synthetic */ i lpR;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.webview.d.g gVar = (com.tencent.mm.plugin.webview.d.g) kVar;
                            Map hashMap = new HashMap();
                            hashMap.put("ticket", ((sm) gVar.fut.czl.czs).bax);
                            this.lpR.a(kVar, "get_wechat_verify_ticket:ok ticket", hashMap);
                        } else {
                            v.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
                            this.lpR.a(kVar, "get_wechat_verify_ticket:fail ticket", null);
                        }
                        ak.vy().b(1097, this);
                    }
                });
                ak.vy().a(new com.tencent.mm.plugin.webview.d.g(str, str2), 0);
            }
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    public final boolean af(k kVar) {
        v.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            v.e("MicroMsg.MsgHandler", "context is null");
            a(kVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).nDS = this;
            com.tencent.mm.ay.c.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        return true;
    }

    private Bundle a(String str, int i, Bundle bundle) {
        try {
            return this.leB.i(i, bundle);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.lang.String r6, int r7, android.os.Bundle r8) {
        /*
        r5 = this;
        r0 = -1;
        r4 = 0;
        r1 = r5.a(r6, r7, r8);
        if (r1 == 0) goto L_0x004e;
    L_0x0008:
        r2 = "status";
        r0 = r1.getInt(r2, r0);
    L_0x000f:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " result status : ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x0086;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00b9;
            case 4: goto L_0x00bb;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r5.lpf;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":fail";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x004c:
        r0 = 0;
    L_0x004d:
        return r0;
    L_0x004e:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " callback fail!";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.w(r1, r2);
        goto L_0x000f;
    L_0x006c:
        r0 = r5.lpf;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x0086:
        r0 = r5.lpf;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_off";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x00a0:
        r0 = r5.lpf;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":disconnect";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x00b9:
        r0 = 1;
        goto L_0x004d;
    L_0x00bb:
        r0 = r5.lpf;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":card_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.i.b(java.lang.String, int, android.os.Bundle):boolean");
    }

    private boolean ag(k kVar) {
        try {
            Bundle i = this.leB.i(5001, null);
            if (i != null) {
                int i2 = i.getInt("webview_video_proxy_init");
                v.i("MicroMsg.MsgHandler", "int webview video proxy : %d", new Object[]{Integer.valueOf(i2)});
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i2));
                if (i2 == 0) {
                    ag bim = ag.bim();
                    bim.leB = this.leB;
                    bim.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    com.tencent.mm.plugin.report.service.g.d(arrayList, false);
                    a(kVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.a.sT(i2));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.iuh;
                    com.tencent.mm.plugin.report.service.g.d(arrayList2, false);
                    a(kVar, "videoProxyInit:fail", hashMap);
                }
                return false;
            }
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", new Object[]{e.getMessage()});
        }
        a(kVar, "videoProxyInit:fail", null);
        return false;
    }

    private boolean ah(k kVar) {
        if (ag.bim().hasInit) {
            String str = (String) kVar.iaJ.get("webviewVideoProxyCdnUrls");
            v.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", new Object[]{str, (String) kVar.iaJ.get("webviewVideoProxyFileId"), Integer.valueOf(be.getInt((String) kVar.iaJ.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(be.getInt((String) kVar.iaJ.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(be.getInt((String) kVar.iaJ.get("webviewVideoProxyFileType"), 1))});
            if (be.kS(str)) {
                a(kVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
            } else {
                com.tencent.mm.plugin.report.service.g gVar;
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle i = this.leB.i(5002, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (i != null) {
                        int i2 = i.getInt("webview_video_proxy_play_data_id");
                        str = i.getString("webview_video_proxy_local_url");
                        v.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", new Object[]{Integer.valueOf(i2), str});
                        if (i2 > 0 && !be.kS(str)) {
                            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.iuh;
                            com.tencent.mm.plugin.report.service.g.d(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i2));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(kVar, "videoProxyStartPlay:ok", hashMap);
                            gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            com.tencent.mm.plugin.report.service.g.d(arrayList, false);
                        }
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "proxy start play failed : %s", new Object[]{e.getMessage()});
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(142);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                gVar = com.tencent.mm.plugin.report.service.g.iuh;
                com.tencent.mm.plugin.report.service.g.d(arrayList, false);
                a(kVar, "videoProxyStartPlay:fail", null);
            }
        } else {
            a(kVar, "videoProxyStartPlay:fail_has_not_init", null);
        }
        return false;
    }

    private boolean ai(k kVar) {
        if (ag.bim().hasInit) {
            int i = be.getInt((String) kVar.iaJ.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.leB.i(5003, bundle);
                    a(kVar, "videoProxyStopPlay:ok", null);
                    return false;
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", new Object[]{e.getMessage()});
                }
            }
            a(kVar, "videoProxyStopPlay:fail", null);
            return false;
        }
        a(kVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean aj(k kVar) {
        if (ag.bim().hasInit) {
            String str = (String) kVar.iaJ.get("webviewVideoProxyPlayState");
            v.i("MicroMsg.MsgHandler", "set player state : %s", new Object[]{str});
            if (be.kS(str)) {
                a(kVar, "videoProxySetPlayerState:fail", null);
                return true;
            }
            int i = be.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.leB.i(5004, bundle);
                a(kVar, "videoProxySetPlayerState:ok", null);
                return false;
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "set player state failed : %s", new Object[]{e.getMessage()});
                a(kVar, "videoProxySetPlayerState:fail", null);
                return false;
            }
        }
        a(kVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean ak(k kVar) {
        if (ag.bim().hasInit) {
            int i = be.getInt((String) kVar.iaJ.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = be.getInt((String) kVar.iaJ.get("webviewVideoProxyRemainTime"), 0);
            v.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", new Object[]{r0, r1});
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.leB.i(5006, bundle);
                a(kVar, "videoProxySetRemainTime:ok", null);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "set remain time faild : %s", new Object[]{e.getMessage()});
                a(kVar, "videoProxySetRemainTime:fail", null);
            }
        } else {
            a(kVar, "videoProxySetRemainTime:fail_has_not_init", null);
        }
        return false;
    }

    private boolean al(k kVar) {
        if (ag.bim().hasInit) {
            String str = (String) kVar.iaJ.get("webviewVideoProxyPlaydataId");
            v.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", new Object[]{str, Integer.valueOf(be.getInt((String) kVar.iaJ.get("webviewVideoProxyPreloadTime"), 0))});
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(kVar, "videoProxyPreload:fail_invaild_play_data_id", null);
            } else {
                try {
                    int i = be.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    v.i("MicroMsg.MsgHandler", "preload video result = %d", new Object[]{Integer.valueOf(this.leB.i(5007, bundle).getInt("webview_video_proxy_pre_load_result"))});
                    if (this.leB.i(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(kVar, "videoProxyPreload:ok", null);
                    } else {
                        a(kVar, "videoProxyPreload:fail", null);
                    }
                } catch (Exception e) {
                    a(kVar, "videoProxyPreload:fail", null);
                }
            }
        } else {
            a(kVar, "videoProxyPreload:fail_has_not_init", null);
        }
        return false;
    }

    public final void x(int i, String str, String str2) {
        b th = th(i);
        if (th == null) {
            v.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            return;
        }
        k kVar = th.lpf;
        ti(i);
        if (!be.ma(str2).equalsIgnoreCase("ok")) {
            int a = com.tencent.mm.plugin.webview.modelcache.v.a(kVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.s.sK(a);
            }
        }
        if (this.leB != null) {
            a(this.leB, kVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
    }

    private boolean am(k kVar) {
        if (com.tencent.mm.plugin.webview.modelcache.c.biH()) {
            String str = (String) kVar.iaJ.get("src");
            v.i("MicroMsg.MsgHandler", "doWebViewPublicCache, src =  %s", new Object[]{str});
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "doWebViewPublicCache, src is null");
                a(this.leB, kVar, "publicCache:fail", null, true, false);
                return true;
            }
            int aJ = aJ(kVar);
            com.tencent.mm.plugin.webview.modelcache.l biO = b.lgu.biO();
            int i = this.bkE;
            if (!com.tencent.mm.plugin.webview.modelcache.l.biJ()) {
                j.tl(i).x(aJ, "publicCache", "fail");
            } else if (be.kS(str)) {
                v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicCache, null configURL");
                j.tl(i).x(aJ, "publicCache", "fail");
            } else {
                b.lgu.vA().x(new com.tencent.mm.plugin.webview.modelcache.l.AnonymousClass2(biO, str, i, aJ));
            }
            this.fHM = false;
            return false;
        }
        a(kVar, "publicCache:not in white list", null);
        return true;
    }

    private boolean an(k kVar) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        String str = (String) kVar.iaJ.get("actionKey");
        String str2 = (String) kVar.iaJ.get("actionValue");
        v.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{str, str2});
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(kVar, "reportActionInfo:fail", null);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > 1024) {
            v.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(kVar, "reportActionInfo:fail", null);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle i = this.leB.i(77, null);
                if (i != null) {
                    str3 = be.ma(i.getString("KSessionId"));
                    str4 = be.ma(i.getString("KUserAgent"));
                    str5 = be.ma(i.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        v.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(kVar, "reportActionInfo:fail", null);
                        return true;
                    }
                    v.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", new Object[]{str3, str4, str5});
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
            }
            if (TextUtils.isEmpty(FA(str5))) {
                v.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(kVar, "reportActionInfo:fail", null);
                return true;
            }
            v.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", new Object[]{FA(str5)});
            int i2 = 0;
            if (com.tencent.mm.sdk.platformtools.ak.isConnected(this.context)) {
                if (com.tencent.mm.sdk.platformtools.ak.isWifi(this.context)) {
                    i2 = 1;
                } else if (com.tencent.mm.sdk.platformtools.ak.is4G(this.context)) {
                    i2 = 4;
                } else if (com.tencent.mm.sdk.platformtools.ak.is3G(this.context)) {
                    i2 = 3;
                } else if (com.tencent.mm.sdk.platformtools.ak.is2G(this.context)) {
                    i2 = 2;
                }
                v.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
            }
            long Nh = be.Nh();
            v.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Integer.valueOf(13379), Long.valueOf(Nh), r10, Integer.valueOf(i2), str4, str5, str3, str, str2});
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(be.ma(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (Throwable e2) {
                    str2 = str4;
                    str5 = str6;
                    th = e2;
                    str = str8;
                    v.a("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.iuh.h(13379, new Object[]{Long.valueOf(Nh), r10, Integer.valueOf(i2), obj, obj2, str3, obj3, str});
                    a(kVar, "reportActionInfo:ok", null);
                    return true;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj3 = str5;
                    obj2 = str4;
                    obj = str6;
                } catch (Throwable e22) {
                    str2 = str4;
                    th = e22;
                    str = str5;
                    str5 = str6;
                    v.a("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.iuh.h(13379, new Object[]{Long.valueOf(Nh), r10, Integer.valueOf(i2), obj, obj2, str3, obj3, str});
                    a(kVar, "reportActionInfo:ok", null);
                    return true;
                }
            } catch (Throwable e222) {
                th = e222;
                str2 = str7;
                str5 = str6;
                str = str8;
                v.a("MicroMsg.MsgHandler", th, "", new Object[0]);
                str4 = str5;
                str5 = str2;
                str2 = str;
                str = str9;
                com.tencent.mm.plugin.report.service.g.iuh.h(13379, new Object[]{Long.valueOf(Nh), r10, Integer.valueOf(i2), obj, obj2, str3, obj3, str});
                a(kVar, "reportActionInfo:ok", null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(13379, new Object[]{Long.valueOf(Nh), r10, Integer.valueOf(i2), obj, obj2, str3, obj3, str});
            a(kVar, "reportActionInfo:ok", null);
            return true;
        }
    }

    private boolean ao(k kVar) {
        int a = com.tencent.mm.plugin.webview.modelcache.v.a(kVar);
        if (-1 == a) {
            a(this.leB, kVar, "cache:fail", null, true, false);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            com.tencent.mm.plugin.report.service.g.iuh.a(238, (long) i, 1, false);
        }
        if (com.tencent.mm.plugin.webview.modelcache.c.biH()) {
            String str = (String) kVar.iaJ.get("async");
            try {
                String Ra = this.leB.Ra();
                v.i("MicroMsg.MsgHandler", "doWebViewCache, async = %s, url = %s", new Object[]{str, Ra});
                if (be.kS(Ra)) {
                    v.i("MicroMsg.MsgHandler", "doWebViewCache, getWebViewURL is null");
                    com.tencent.mm.plugin.webview.modelcache.s.sK(a);
                    a(this.leB, kVar, "cache:fail", null, true, false);
                    return true;
                }
                this.lpL.add(Ra);
                String Fu;
                String str2;
                if (2 == a) {
                    Fu = this.lps.Fu(Ra);
                    if (be.kS(Fu)) {
                        Fu = (String) kVar.iaJ.get("appId");
                    }
                    if (be.kS(Fu)) {
                        com.tencent.mm.plugin.webview.modelcache.s.sK(2);
                        a(this.leB, kVar, "cache:fail", null, true, false);
                        return true;
                    }
                    str2 = (String) kVar.iaJ.get("src");
                    b.lgu.biO().a(Fu, Ra, str2, this.bkE, aJ(kVar), true);
                    com.tencent.mm.plugin.webview.modelcache.w biP = b.lgu;
                    int i2 = this.bkE;
                    if (!(be.kS(Fu) || be.kS(Ra) || be.kS(str2))) {
                        synchronized (biP.lgj) {
                            Set set = (Set) biP.lgk.get(i2);
                            if (set == null) {
                                set = new HashSet();
                                biP.lgk.put(i2, set);
                            }
                            set.add(new a(Fu, Ra, str2));
                        }
                    }
                    this.fHM = false;
                    return false;
                }
                v.d("MicroMsg.MsgHandler", "doWebviewCacheSyncType");
                str = (String) kVar.iaJ.get("page");
                Fu = !be.kS(str) ? this.lps.Fu(str) : this.lps.Fu(Ra);
                String str3 = be.kS(Fu) ? (String) kVar.iaJ.get("appId") : Fu;
                if (be.kS(str3)) {
                    com.tencent.mm.plugin.webview.modelcache.s.sK(1);
                    a(this.leB, kVar, "cache:fail", null, true, false);
                    return true;
                }
                v.d("MicroMsg.MsgHandler", "doWebViewCacheSyncType, disable = %b", new Object[]{Boolean.valueOf(Boolean.parseBoolean((String) kVar.iaJ.get("disable")))});
                a = aJ(kVar);
                String str4 = (String) kVar.iaJ.get("base");
                String str5 = (String) kVar.iaJ.get("resourceList");
                com.tencent.mm.plugin.webview.modelcache.l biO = b.lgu.biO();
                int i3 = this.bkE;
                if (com.tencent.mm.plugin.webview.modelcache.l.biJ()) {
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, appId = %s, mainDocument url = %s, base = %s, page = %s, disable = %b, resourceList = %s", new Object[]{str3, Ra, str4, str, Boolean.valueOf(r3), str5});
                    if (be.kS(str3) || ((be.kS(Ra) && be.kS(str)) || be.kS(str5))) {
                        v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, params invalid");
                    } else if (r3) {
                        com.tencent.mm.plugin.webview.modelcache.d dVar = b.lgu.lgh;
                        r5 = com.tencent.mm.sdk.platformtools.z.Kg(Ra);
                        com.tencent.mm.plugin.webview.modelcache.p biL = com.tencent.mm.plugin.webview.modelcache.p.biL();
                        List h = !biL.lfs ? null : be.kS(r5) ? null : biL.h(String.format("select * from %s where %s=?", new Object[]{"WebViewResourceCache", "packageId"}), r5);
                        dVar.bF(h);
                        com.tencent.mm.plugin.webview.modelcache.i iVar = new com.tencent.mm.plugin.webview.modelcache.i();
                        iVar.field_packageId = r5;
                        com.tencent.mm.plugin.webview.modelcache.p.biL().c(iVar, new String[]{"packageId"});
                        j.tl(i3).x(a, "cache", "ok");
                        v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, sync cache disabled, appId = %s, mainDocument url = %s, base = %s, page = %s, resourceList = %s", new Object[]{str3, Ra, str4, str, str5});
                    } else {
                        str2 = !be.kS(str) ? str : Ra;
                        r5 = com.tencent.mm.plugin.webview.modelcache.v.Em(str2);
                        if (be.kS(r5)) {
                            v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, get null or nil domain from mainDocumentURL");
                            j.tl(i3).x(a, "cache", "fail");
                        } else {
                            b.lgu.vA().x(new com.tencent.mm.plugin.webview.modelcache.l.AnonymousClass1(biO, str3, str2, be.ma(str4), r5, com.tencent.mm.sdk.platformtools.z.Kg(str2), str5, i3, a));
                        }
                    }
                } else {
                    j.tl(i3).x(a, "cache", "fail");
                }
                this.fHM = false;
                return false;
            } catch (RemoteException e) {
                v.e("MicroMsg.MsgHandler", "doWebViewCache, getWebViewURL failed, e = %s", new Object[]{e.getMessage()});
                com.tencent.mm.plugin.webview.modelcache.s.sK(a);
                a(this.leB, kVar, "cache:fail", null, true, false);
                return true;
            }
        }
        v.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.s.sK(a);
        a(this.leB, kVar, "cache:not in white list", null, true, false);
        return true;
    }

    private boolean ap(k kVar) {
        v.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (kVar.iaJ.containsKey("hideMenu")) {
            i = be.getInt((String) kVar.iaJ.get("hideMenu"), 0);
            v.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=" + i);
            if (hJ(i == 1)) {
                a(kVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(kVar, "doAddCustomMenuItems:fail", null);
            }
        } else {
            hJ(false);
            String str = (String) kVar.iaJ.get("itemList");
            if (be.kS(str)) {
                v.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(kVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (be.kS(optString) || be.kS("title")) {
                                v.e("MicroMsg.MsgHandler", "key or title is null,ignore item: " + i);
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.leB.C(bundle);
                            a(kVar, "doAddCustomMenuItems:ok", null);
                        } catch (Throwable e) {
                            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
                            v.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(kVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    v.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(kVar, "doAddCustomMenuItems:params parse error", null);
                }
            }
        }
        return true;
    }

    private boolean aq(k kVar) {
        String str = (String) kVar.iaJ.get("key");
        if (be.kS(str)) {
            a(kVar, "getLocalData:fail_key_is_null", null);
        } else {
            try {
                String Ra = this.leB.Ra();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.lps.Fu(Ra);
                ae bjh = com.tencent.mm.plugin.webview.e.e.bjh();
                String La = be.La(Ra);
                v.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", new Object[]{str2, str, La});
                if (be.kS(str2) || be.kS(str) || be.kS(Ra) || be.kS(La)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = " + ae.R(str, La, str2);
                    v.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bjh.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        v.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        v.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", new Object[]{str, str2});
                    }
                }
                if (be.kS(str)) {
                    a(kVar, "getLocalData:fail", null);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put("data", str3);
                    v.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", new Object[]{str2, str3});
                    a(kVar, "getLocalData:ok", hashMap);
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(kVar, "getLocalData:fail", null);
            }
        }
        return true;
    }

    private boolean ar(k kVar) {
        String str = (String) kVar.iaJ.get("key");
        String str2 = (String) kVar.iaJ.get("data");
        v.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", new Object[]{str, str2});
        if (be.kS(str) || be.kS(str2)) {
            a(kVar, "setLocalData:fail_param_should_not_null", null);
            return true;
        } else if (str.length() > 1024 || str2.length() > 1024) {
            a(kVar, "setLocalData:fail_param_lenght_too_long", null);
            return true;
        } else {
            try {
                String Ra = this.leB.Ra();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.lps.Fu(Ra);
                ae bjh = com.tencent.mm.plugin.webview.e.e.bjh();
                String La = be.La(Ra);
                v.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", new Object[]{str3, str4, Ra, str2, La});
                if (be.kS(str3) || be.kS(Ra) || be.kS(str2) || be.kS(La)) {
                    str = "fail_params_invalid";
                } else {
                    int R = ae.R(str2, La, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + La + "'";
                    v.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bjh.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            v.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                str = "fail_exceed_max_count";
                            } else {
                                rawQuery = bjh.rawQuery("select count(*) from WebviewLocalData where recordId =" + R, new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        v.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", new Object[]{r7, Integer.valueOf(rawQuery.getInt(0))});
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            v.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", new Object[]{"update WebviewLocalData set value = '" + str4 + "' where recordId =" + R, Boolean.valueOf(bjh.dF("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + R))});
                                            str = bjh.dF("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + R) ? "ok" : "fail";
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    com.tencent.mm.plugin.webview.d.ad adVar = new com.tencent.mm.plugin.webview.d.ad();
                    adVar.field_appId = str2;
                    adVar.field_domin = La;
                    adVar.field_key = str3;
                    adVar.field_value = str4;
                    adVar.field_recordId = R;
                    v.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", new Object[]{Boolean.valueOf(bjh.b(adVar))});
                    str = "ok";
                }
                v.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", new Object[]{str});
                a(kVar, "setLocalData:" + str, null);
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(kVar, "setLocalData:fail", null);
                return true;
            }
        }
    }

    private boolean as(k kVar) {
        try {
            String Ra = this.leB.Ra();
            ae bjh = com.tencent.mm.plugin.webview.e.e.bjh();
            String Fu = this.lps.Fu(Ra);
            String La = be.La(Ra);
            v.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", new Object[]{Fu, Ra, La});
            if (be.kS(Fu) || be.kS(Ra) || be.kS(La)) {
                Ra = "fail";
            } else {
                Ra = bjh.dF("WebviewLocalData", new StringBuilder("delete from WebviewLocalData where appId = '").append(Fu).append("' and domin = '").append(La).append("'").toString()) ? "ok" : "fail";
            }
            v.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", new Object[]{Ra});
            a(kVar, "clearLocalData:" + Ra, null);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
            a(kVar, "clearLocalData:fail", null);
        }
        return true;
    }

    private boolean at(final k kVar) {
        String Ra;
        String str = (String) kVar.iaJ.get("useridlist");
        String str2 = (String) kVar.iaJ.get("chatname");
        final String str3 = (String) kVar.iaJ.get("chatscene");
        try {
            Ra = this.leB.Ra();
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            Ra = null;
        }
        Ra = be.ma(this.lps.Fu(Ra));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(kVar, "openEnterpriseChat:fail", null);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        com.tencent.mm.modelbiz.u.DE();
        ak.vy().a(new com.tencent.mm.modelbiz.a.t(Ra, str2, linkedList, new com.tencent.mm.modelbiz.k(this) {
            final /* synthetic */ i lpR;

            public final void a(int i, k kVar) {
                if (i != 0) {
                    this.lpR.a(kVar, "openEnterpriseChat:fail", null);
                    return;
                }
                add DT = ((com.tencent.mm.modelbiz.a.t) kVar).DT();
                String str;
                if (DT != null && DT.mhP != null && DT.mhP.ret == 0) {
                    str = DT.mhJ;
                    String str2 = ((com.tencent.mm.modelbiz.a.t) kVar).cEj;
                    if (str2 == null) {
                        this.lpR.a(kVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.modelbiz.a.c hR = com.tencent.mm.modelbiz.u.DA().hR(str2);
                    if (hR == null || be.kS(str)) {
                        this.lpR.a(kVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    Intent intent;
                    if (be.kS(str3) || !str3.equals("long")) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("key_biz_chat_id", hR.field_bizChatLocalId);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.ay.c.a(this.lpR.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                        intent.putExtra("Main_User", str);
                        intent.putExtra("biz_chat_chat_id", hR.field_bizChatLocalId);
                        intent.putExtra("biz_chat_from_scene", 8);
                        com.tencent.mm.ay.c.a(this.lpR.context, ".ui.LauncherUI", intent);
                    }
                    Map hashMap = new HashMap();
                    if (!(be.kS(DT.moq) || be.kS(DT.mor))) {
                        hashMap.put("chat_type", DT.moq);
                        hashMap.put("chat_id", DT.mor);
                    }
                    this.lpR.a(kVar, "openEnterpriseChat:ok", hashMap);
                } else if (DT == null || DT.mhP == null) {
                    this.lpR.a(kVar, "openEnterpriseChat:fail", null);
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("err_code", Integer.valueOf(DT.mhP.ret));
                    str = "openEnterpriseChat:fail";
                    if (DT.mhP.bce != null) {
                        str = DT.mhP.bce;
                    }
                    this.lpR.a(kVar, str, hashMap2);
                }
            }
        }), 0);
        return true;
    }

    private boolean au(final k kVar) {
        String Ra;
        String str = (String) kVar.iaJ.get("chatId");
        String str2 = (String) kVar.iaJ.get("chatType");
        try {
            Ra = this.leB.Ra();
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            Ra = null;
        }
        Ra = be.ma(this.lps.Fu(Ra));
        if (be.kS(str) || be.kS(str2) || be.kS(Ra)) {
            a(kVar, "enterEnterpriseChat:fail_params error", null);
        } else {
            com.tencent.mm.modelbiz.u.DE();
            ak.vy().a(new com.tencent.mm.modelbiz.a.m(Ra, str, str2, new com.tencent.mm.modelbiz.k(this) {
                final /* synthetic */ i lpR;

                public final void a(int i, k kVar) {
                    if (i != 0) {
                        this.lpR.a(kVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    ls DQ = ((com.tencent.mm.modelbiz.a.m) kVar).DQ();
                    String str = "enterEnterpriseChat:fail";
                    if (i < 0) {
                        if (!(DQ == null || DQ.mhP == null || !be.kS(DQ.mhP.bce))) {
                            str = "enterEnterpriseChat:fail_" + DQ.mhP.bce;
                        }
                        this.lpR.a(kVar, str, null);
                        return;
                    }
                    String str2 = DQ.mhJ;
                    String str3 = ((com.tencent.mm.modelbiz.a.m) kVar).cEj;
                    if (str3 == null) {
                        this.lpR.a(kVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.modelbiz.a.c hR = com.tencent.mm.modelbiz.u.DA().hR(str3);
                    if (hR == null || be.kS(str2)) {
                        this.lpR.a(kVar, str, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    intent.putExtra("key_biz_chat_id", hR.field_bizChatLocalId);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    intent.putExtra("key_is_biz_chat", true);
                    com.tencent.mm.ay.c.a(this.lpR.context, ".ui.chatting.ChattingUI", intent);
                    this.lpR.a(kVar, "enterEnterpriseChat:ok", null);
                }
            }), 0);
        }
        return true;
    }

    private boolean av(final k kVar) {
        try {
            String ma = be.ma(this.lps.Fu(this.leB.Ra()));
            if (be.kS(ma)) {
                a(kVar, "getEnterpriseChat:fail", null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.leB.i(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String ac = com.tencent.mm.modelbiz.a.e.ac(bundle.getLong("enterprise_context_bizchatid", -1));
                if (be.kS(string) || be.kS(ac)) {
                    a(kVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                } else {
                    AnonymousClass50 anonymousClass50 = new e(this) {
                        final /* synthetic */ i lpR;

                        public final void a(int i, int i2, String str, k kVar) {
                            String str2;
                            tq tqVar;
                            int i3;
                            com.tencent.mm.modelbiz.p.a(this);
                            String str3 = "getEnterpriseChat:fail";
                            if (i == 0 && i2 == 0) {
                                tq tqVar2;
                                com.tencent.mm.modelbiz.p pVar = (com.tencent.mm.modelbiz.p) kVar;
                                if (pVar.cif == null || pVar.cif.czl.czs == null) {
                                    tqVar2 = null;
                                } else {
                                    tqVar2 = (tq) pVar.cif.czl.czs;
                                }
                                if (tqVar2 == null || tqVar2.mhP == null) {
                                    str2 = str3;
                                    tqVar = tqVar2;
                                    i3 = -1;
                                } else {
                                    int i4 = tqVar2.mhP.ret;
                                    if (tqVar2.mhP.bce == null || tqVar2.mhP.bce.length() <= 0) {
                                        str2 = str3;
                                        tqVar = tqVar2;
                                        i3 = i4;
                                    } else {
                                        str2 = "getEnterpriseChat:fail_" + tqVar2.mhP.bce;
                                        tqVar = tqVar2;
                                        i3 = i4;
                                    }
                                }
                            } else {
                                str2 = str3;
                                i3 = -1;
                                tqVar = null;
                            }
                            if (i3 != 0) {
                                this.lpR.a(kVar, str2, null);
                                return;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("result", tqVar.bfz);
                            this.lpR.a(kVar, "getEnterpriseChat:ok", hashMap);
                        }
                    };
                    ak.vy().a(1285, anonymousClass50);
                    if (!com.tencent.mm.modelbiz.p.k(ma, string, ac)) {
                        com.tencent.mm.modelbiz.p.a(anonymousClass50);
                        a(kVar, "getEnterpriseChat:fail", null);
                    }
                }
            }
        } catch (Exception e) {
            a(kVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    private boolean aw(final k kVar) {
        String Ra;
        try {
            Ra = this.leB.Ra();
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            Ra = null;
        }
        String ma = be.ma(this.lps.Fu(Ra));
        if (be.kS(ma)) {
            a(kVar, "openEnterpriseContact:fail", null);
        }
        final com.tencent.mm.plugin.webview.d.i iVar = new com.tencent.mm.plugin.webview.d.i(ma, Ra, kVar.iaJ);
        ak.vy().a(1393, new e(this) {
            final /* synthetic */ i lpR;

            public final void a(int i, int i2, String str, k kVar) {
                String str2;
                to toVar;
                int i3;
                if (this.lpR.dwR != null && this.lpR.dwR.isShowing()) {
                    this.lpR.dwR.dismiss();
                    this.lpR.dwR = null;
                }
                ak.vy().b(1393, this);
                String str3 = "openEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    to toVar2;
                    com.tencent.mm.plugin.webview.d.i iVar = (com.tencent.mm.plugin.webview.d.i) kVar;
                    if (iVar.cif == null || iVar.cif.czl.czs == null) {
                        toVar2 = null;
                    } else {
                        toVar2 = (to) iVar.cif.czl.czs;
                    }
                    if (toVar2 == null || toVar2.mhP == null) {
                        str2 = str3;
                        toVar = toVar2;
                        i3 = -1;
                    } else {
                        int i4 = toVar2.mhP.ret;
                        if (toVar2.mhP.bce == null || toVar2.mhP.bce.length() <= 0) {
                            str2 = str3;
                            toVar = toVar2;
                            i3 = i4;
                        } else {
                            str2 = toVar2.mhP.bce;
                            toVar = toVar2;
                            i3 = i4;
                        }
                    }
                } else {
                    str2 = str3;
                    i3 = -1;
                    toVar = null;
                }
                if (i3 != 0) {
                    this.lpR.a(kVar, str2, null);
                    return;
                }
                str2 = toVar.mlU;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) this.lpR.context).nDS = this;
                com.tencent.mm.ay.c.b(this.lpR.context, "webview", ".ui.tools.WebViewUI", intent, 31);
            }
        });
        ak.vy().a(iVar, 0);
        Context context = this.context;
        this.context.getString(2131231164);
        this.dwR = g.a(context, this.context.getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ i lpR;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(iVar);
            }
        });
        return true;
    }

    private boolean ax(k kVar) {
        if (this.leB == null) {
            a(kVar, "sendEnterpriseChat:fail", null);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.leB.i(71, bundle);
            final String string = bundle.getString("enterprise_context_biz");
            final long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (be.kS(string) || j < 0) {
                a(kVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                return true;
            }
            String str = (String) kVar.iaJ.get(Columns.TYPE);
            if ("text".equals(str)) {
                return a(kVar, string, j);
            }
            if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) kVar.iaJ.get("data"));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                final String optString3 = jSONObject.optString("imgUrl");
                if (be.kS(optString) && be.kS(optString2)) {
                    a(kVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else if (be.kS(str)) {
                    a(kVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else {
                    String str2;
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.bhh = new WXMediaMessage();
                    this.bhh.mediaObject = wXWebpageObject;
                    this.bhh.title = optString;
                    this.bhh.description = optString2;
                    str = (String) kVar.iaJ.get("appid");
                    if (this.lpj == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.lpj.getString("jsapi_args_appid");
                    }
                    final f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        v.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(kVar, "sendEnterpriseChat:fail", null);
                        return true;
                    } else if (this.context instanceof Activity) {
                        final k kVar2 = kVar;
                        com.tencent.mm.pluginsdk.ui.applet.c.a(((MMActivity) this.context).nDR, optString, optString3, optString2, true, this.context.getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                            final /* synthetic */ i lpR;

                            public final void a(boolean z, final String str, int i) {
                                if (!z) {
                                    this.lpR.a(kVar2, "sendEnterpriseChat:cancel", null);
                                } else if (be.kS(optString3)) {
                                    com.tencent.mm.modelbiz.a.c Z = com.tencent.mm.modelbiz.u.DA().Z(j);
                                    synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                                        String zr = com.tencent.mm.modelbiz.a.e.zr();
                                        com.tencent.mm.modelbiz.a.e.e(Z);
                                        this.lpR.a(aC, str2, string, optString3, null, null, str, null);
                                        com.tencent.mm.modelbiz.a.e.hZ(zr);
                                    }
                                    this.lpR.a(kVar2, "sendEnterpriseChat:ok", null);
                                    if (this.lpR.context != null) {
                                        g.bf(this.lpR.context, this.lpR.context.getResources().getString(2131231155));
                                    }
                                } else {
                                    n.GG().a(optString3, new com.tencent.mm.ae.b.c(this) {
                                        final /* synthetic */ AnonymousClass53 pQy;

                                        public final void j(Bitmap bitmap) {
                                            if (this.pQy.lpR.gKB != null) {
                                                this.pQy.lpR.gKB.dismiss();
                                            }
                                            com.tencent.mm.modelbiz.a.c Z = com.tencent.mm.modelbiz.u.DA().Z(j);
                                            synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                                                String zr = com.tencent.mm.modelbiz.a.e.zr();
                                                com.tencent.mm.modelbiz.a.e.e(Z);
                                                this.pQy.lpR.a(aC, str2, string, optString3, null, null, str, null);
                                                com.tencent.mm.modelbiz.a.e.hZ(zr);
                                            }
                                            this.pQy.lpR.a(kVar2, "sendEnterpriseChat:ok", null);
                                            if (this.pQy.lpR.context != null) {
                                                g.bf(this.pQy.lpR.context, this.pQy.lpR.context.getResources().getString(2131231155));
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    } else {
                        v.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(kVar, "sendEnterpriseChat:fail", null);
                        return true;
                    }
                }
            }
            a(kVar, "sendEnterpriseChat:fail_params error", null);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
            a(kVar, "sendEnterpriseChat:fail", null);
            return true;
        }
    }

    private boolean a(k kVar, String str, long j) {
        String optString = new JSONObject((String) kVar.iaJ.get("data")).optString("content");
        if (be.kS(optString)) {
            a(kVar, "sendEnterpriseChat:fail_params error", null);
        } else {
            boolean z;
            com.tencent.mm.modelbiz.a.c Z = com.tencent.mm.modelbiz.u.DA().Z(j);
            synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                String zr = com.tencent.mm.modelbiz.a.e.zr();
                com.tencent.mm.modelbiz.a.e.e(Z);
                mr mrVar = new mr();
                mrVar.boa.bob = str;
                mrVar.boa.content = optString;
                mrVar.boa.type = m.fp(str);
                mrVar.boa.flags = 0;
                z = com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                com.tencent.mm.modelbiz.a.e.hZ(zr);
            }
            if (z) {
                a(kVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    g.bf(this.context, this.context.getResources().getString(2131231155));
                }
            } else {
                a(kVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    private boolean ay(k kVar) {
        v.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.e.a.ag agVar = new com.tencent.mm.e.a.ag();
        String str = (String) kVar.iaJ.get("showInfo");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(kVar, "changePayActivityView:fail", null);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            agVar.aXL.aXN = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            v.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            agVar.aXL.aXO = be.getInt(str, 0) > 0;
            com.tencent.mm.e.a.ag.a aVar = agVar.aXL;
            if (be.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.aXP = z;
            com.tencent.mm.e.a.ag.a aVar2 = agVar.aXL;
            if (be.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.aXQ = z;
            com.tencent.mm.sdk.c.a.nhr.z(agVar);
            if (agVar.aXM.aXR) {
                v.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(kVar, "changePayActivityView:ok", null);
            } else {
                v.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(kVar, "changePayActivityView:fail", null);
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(kVar, "changePayActivityView:fail", null);
            return false;
        }
    }

    private boolean az(k kVar) {
        String str = (String) kVar.iaJ.get("idKeyDataInfo");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "idkey data is null");
            a(kVar, "reportIDKey:fail_invaild_parms", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(be.getInt(optJSONObject.optString("id"), 0));
                    iDKey.SetKey(be.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue(be.getInt(optJSONObject.optString(Columns.VALUE), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    com.tencent.mm.plugin.report.service.g.d(arrayList, true);
                    a(kVar, "reportIDKey:ok", null);
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "parse json array faild : %s", new Object[]{e.getMessage()});
            }
            a(kVar, "reportIDKey:fail", null);
        }
        return false;
    }

    private boolean aA(k kVar) {
        v.i("MicroMsg.MsgHandler", "setNavigationBarColor");
        boolean equals = "1".equals((String) kVar.iaJ.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) kVar.iaJ.get("color")) | -16777216;
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (be.getFloat((String) kVar.iaJ.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                v.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.leB.i(53, bundle);
            a(kVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            v.e("MicroMsg.MsgHandler", e22.getMessage());
            a(kVar, "setNavigationBarColor:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        v.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", new Object[]{Long.valueOf(j)});
        try {
            if (this.leB != null) {
                this.leB.g(80001, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
        }
    }

    private boolean hJ(boolean z) {
        v.e("MicroMsg.MsgHandler", "hideMenuEntry:" + z);
        try {
            this.leB.hw(z);
            v.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
            v.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            v.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return false;
        } catch (Throwable th) {
            v.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        }
    }

    private boolean aB(final k kVar) {
        v.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) kVar.iaJ.get("openid");
        if (be.kS(str)) {
            v.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(kVar, "sendAppMessageToSpecifiedContact:fail", null);
        } else {
            String str2 = (String) kVar.iaJ.get("appId");
            if (this.lpj != null && TextUtils.isEmpty(str2)) {
                str2 = this.lpj.getString("jsapi_args_appid");
            }
            if (be.kS(str2)) {
                v.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(kVar, "sendAppMessageToSpecifiedContact:fail", null);
            } else {
                this.bhh = g(kVar);
                final com.tencent.mm.plugin.webview.d.r rVar = new com.tencent.mm.plugin.webview.d.r(str2, str);
                ak.vy().a(1142, new e(this) {
                    final /* synthetic */ i lpR;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (this.lpR.dwR != null && this.lpR.dwR.isShowing()) {
                            this.lpR.dwR.dismiss();
                            this.lpR.dwR = null;
                        }
                        if (i == 0 && i2 == 0) {
                            azx com_tencent_mm_protocal_c_azx;
                            com.tencent.mm.plugin.webview.d.r rVar = (com.tencent.mm.plugin.webview.d.r) kVar;
                            if (rVar.cif == null) {
                                com_tencent_mm_protocal_c_azx = null;
                            } else {
                                com_tencent_mm_protocal_c_azx = (azx) rVar.cif.czl.czs;
                            }
                            if (com_tencent_mm_protocal_c_azx != null) {
                                String str2 = com_tencent_mm_protocal_c_azx.username;
                                if (be.kS(str2)) {
                                    v.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                                } else if (this.lpR.context instanceof MMActivity) {
                                    if (i.a(this.lpR, str2, (String) kVar.iaJ.get("title"), (String) kVar.iaJ.get("img_url"), str2, (String) kVar.iaJ.get("desc"), (String) kVar.iaJ.get("src_username"), (String) kVar.iaJ.get("src_displayname"), "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") == null) {
                                        v.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                                        this.lpR.a(kVar, "sendAppMessageToSpecifiedContact:fail", null);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            v.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
                        } else {
                            v.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
                        }
                        this.lpR.a(kVar, "sendAppMessageToSpecifiedContact:fail", null);
                    }
                });
                ak.vy().a(rVar, 0);
                Context context = this.context;
                this.context.getString(2131231164);
                this.dwR = g.a(context, this.context.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ i lpR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(rVar);
                    }
                });
            }
        }
        return true;
    }

    private boolean bly() {
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.leB.bjq();
            this.leB.B(bundle);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean aC(k kVar) {
        v.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.leB.Ra();
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!be.kS(str)) {
            intent.putExtra("appId", this.lps.Fu(str));
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            try {
                intent.putExtra("url", this.leB.Ra());
            } catch (Throwable e2) {
                v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(536870912);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).nDS = this;
            com.tencent.mm.ay.c.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        return true;
    }

    public final boolean blz() {
        v.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).nDS = this;
        com.tencent.mm.ay.c.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        return true;
    }

    private boolean aD(k kVar) {
        boolean z;
        String str = (String) kVar.iaJ.get("clearCookie");
        v.i("MicroMsg.MsgHandler", "clearflag = %s", new Object[]{str});
        if (be.kS(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) kVar.iaJ.get("url");
        if (!be.kS(str)) {
            str = com.tencent.mm.plugin.webview.modelcache.v.Em(str);
            if (!be.kS(str)) {
                b.lgu.vA().x(new Runnable(this) {
                    final /* synthetic */ i lpR;

                    public final void run() {
                        List list = null;
                        b.lgu;
                        String str = str;
                        if (!be.kS(str)) {
                            com.tencent.mm.plugin.webview.modelcache.p biL = com.tencent.mm.plugin.webview.modelcache.p.biL();
                            if (biL.lfs && !be.kS(str)) {
                                list = biL.h(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), str);
                            }
                            if (!be.bP(r0)) {
                                for (com.tencent.mm.plugin.webview.modelcache.i a : r0) {
                                    com.tencent.mm.plugin.webview.modelcache.d.a(a);
                                }
                                com.tencent.mm.plugin.webview.modelcache.p biL2 = com.tencent.mm.plugin.webview.modelcache.p.biL();
                                if (biL2.lfs && !be.kS(str)) {
                                    com.tencent.mm.plugin.webview.modelcache.i iVar = new com.tencent.mm.plugin.webview.modelcache.i();
                                    iVar.field_domain = str;
                                    biL2.c(iVar, new String[]{"domain"});
                                }
                            }
                        }
                        WebViewCacheDownloadHelper.biR();
                    }
                });
            }
        }
        if (this.leB != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.leB.i(6001, bundle);
                a(kVar, "clearWebviewCache:ok", null);
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
                a(kVar, "clearWebviewCache:fail", null);
            }
        } else {
            a(kVar, "clearWebviewCache:fail", null);
        }
        return true;
    }

    public final boolean aE(k kVar) {
        v.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(kVar.iaJ);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.leB.Ra();
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!be.kS(str)) {
            intent.putExtra("appId", this.lps.Fu(str));
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            try {
                intent.putExtra("url", this.leB.Ra());
            } catch (Throwable e2) {
                v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(536870912);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).nDS = this;
            com.tencent.mm.ay.c.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        return true;
    }

    public final boolean aF(k kVar) {
        a(kVar, "uploadIdCardSuccess:ok", null);
        v.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        qt qtVar = new qt();
        qtVar.bsm.bpc = -1;
        com.tencent.mm.sdk.c.a.nhr.z(qtVar);
        return true;
    }

    public final boolean aG(k kVar) {
        v.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = be.getInt((String) kVar.iaJ.get("cmd"), 0);
        String str = (String) kVar.iaJ.get("param");
        gi giVar = new gi();
        giVar.bfS.of = i;
        giVar.bfS.bfh = str;
        giVar.bfS.context = this.context;
        com.tencent.mm.sdk.c.a.nhr.z(giVar);
        Map hashMap = new HashMap();
        hashMap.put("gameRegionName", giVar.bfT.bfi);
        a(kVar, "getGameCommInfo:ok", hashMap);
        return true;
    }

    public final boolean blA() {
        v.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).nDS = this;
            com.tencent.mm.ay.c.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        return true;
    }

    public final boolean aH(final k kVar) {
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.context);
        lVar.b(null, new OnCreateContextMenuListener(this) {
            final /* synthetic */ i lpR;

            {
                this.lpR = r1;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 1, 0, this.lpR.context.getString(2131234747));
                contextMenu.add(0, 2, 1, this.lpR.context.getString(2131234742));
            }
        }, new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ i lpR;

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        i.cL(this.lpR, kVar);
                        return;
                    case 2:
                        i.cK(this.lpR, kVar);
                        return;
                    default:
                        return;
                }
            }
        });
        lVar.d(new OnCancelListener(this) {
            final /* synthetic */ i lpR;

            public final void onCancel(DialogInterface dialogInterface) {
                this.lpR.a(kVar, "chooseIdCard:cancel", null);
            }
        });
        lVar.aXZ();
        return true;
    }

    public final void cP(int i, int i2) {
        String str = "";
        String str2 = " ";
        try {
            Bundle i3 = this.leB.i(77, null);
            if (i3 != null) {
                str = i3.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    v.e("MicroMsg.MsgHandler", "url is empty");
                    return;
                }
                v.i("MicroMsg.MsgHandler", "sessionId %s", new Object[]{be.ma(i3.getString("KSessionId"))});
                if (!i3.getBoolean("KReportPage", false)) {
                    v.i("MicroMsg.MsgHandler", "not enable report page event control bytes");
                    return;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
        }
        if (TextUtils.isEmpty(FA(str))) {
            v.i("MicroMsg.MsgHandler", "appId is null or empty");
            return;
        }
        v.i("MicroMsg.MsgHandler", "appId %s", new Object[]{FA(str)});
        v.i("MicroMsg.MsgHandler", "type %d", new Object[]{Integer.valueOf(this.bhh.mediaObject.type())});
        if (this.bhh.mediaObject.type() == 5) {
            long Nh = be.Nh();
            v.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Nh), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
            String str3 = "";
            try {
                str = URLEncoder.encode(be.ma(str), "UTF-8");
            } catch (Throwable e2) {
                v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str3;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(13377, new Object[]{Long.valueOf(Nh), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void a(int i, int i2, Intent intent) {
        v.i("MicroMsg.MsgHandler", "mmOnActivityResult, requestCode = " + i + ", resultCode = " + i2);
        String str;
        SnsAdClick snsAdClick;
        String string;
        Object obj;
        f Gh;
        String stringExtra;
        final String str2;
        String str3;
        String str4;
        String blr;
        String str5;
        final String str6;
        final String str7;
        final String str8;
        final String str9;
        if (i == 1) {
            if (this.bhh == null) {
                v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.lpf, "send_app_msg:fail", null);
                return;
            }
            str = (String) this.lpf.iaJ.get("appid");
            snsAdClick = null;
            if (this.lpj != null) {
                snsAdClick = (SnsAdClick) this.lpj.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.lpj.getString("jsapi_args_appid");
                    obj = this.lpf.blF().get("Internal@AsyncReport");
                    this.lpf.iaJ.get("link");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.gg(7);
                            }
                            Gh = com.tencent.mm.pluginsdk.model.app.g.Gh(string);
                            stringExtra = intent != null ? null : intent.getStringExtra("Select_Conv_User");
                            if (stringExtra != null || stringExtra.length() == 0) {
                                v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                a(this.lpf, "send_app_msg:fail", null);
                                return;
                            }
                            str2 = (String) this.lpf.iaJ.get("img_url");
                            this.lpf.iaJ.get("desc");
                            str3 = (String) this.lpf.iaJ.get("src_username");
                            str4 = (String) this.lpf.iaJ.get("src_displayname");
                            blr = blr();
                            m.a(this.lpf.blF(), FC("sendAppMessage"), stringExtra, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                a(this.lpf, true);
                            }
                            if (be.kS(blr)) {
                                if (intent == null) {
                                    str5 = null;
                                } else {
                                    str5 = intent.getStringExtra("custom_send_text");
                                }
                                a(Gh, string, stringExtra, str2, str3, str4, str5, blr);
                                if (this.context != null) {
                                    g.bd(this.context, this.context.getResources().getString(2131231155));
                                }
                                cP(1, 1);
                                a(this.lpf, "send_app_msg:ok", null);
                                return;
                            } else if (be.kS(str2)) {
                                a(Gh, string, stringExtra, str2, str3, str4, null, blr);
                                g.bd(this.context, this.context.getString(2131231147));
                                a(this.lpf, "send_app_msg:ok", null);
                                return;
                            } else {
                                final p a = g.a(this.context, this.context.getResources().getString(2131231151), true, new OnCancelListener(this) {
                                    final /* synthetic */ i lpR;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        n.GG().iO(str2);
                                        this.lpR.a(this.lpR.lpf, "send_app_msg:cancel", null);
                                    }
                                });
                                final f fVar = Gh;
                                final String str10 = string;
                                final String str11 = stringExtra;
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                str9 = blr;
                                n.GG().a(str2, new com.tencent.mm.ae.b.c(this) {
                                    final /* synthetic */ i lpR;

                                    public final void j(Bitmap bitmap) {
                                        if (a != null) {
                                            a.dismiss();
                                        }
                                        this.lpR.a(fVar, str10, str11, str6, str7, str8, null, str9);
                                        if (this.lpR.context != null) {
                                            g.bf(this.lpR.context, this.lpR.context.getString(2131231147));
                                        }
                                        this.lpR.a(this.lpR.lpf, "send_app_msg:ok", null);
                                    }
                                });
                                return;
                            }
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.gg(8);
                            }
                            m.a(this.lpf.blF(), FC("sendAppMessage"), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                a(this.lpf, true);
                            }
                            cP(1, 3);
                            a(this.lpf, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.lpf.blF().get("Internal@AsyncReport");
            this.lpf.iaJ.get("link");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.gg(7);
                    }
                    Gh = com.tencent.mm.pluginsdk.model.app.g.Gh(string);
                    if (intent != null) {
                    }
                    if (stringExtra != null) {
                        break;
                    }
                    v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                    a(this.lpf, "send_app_msg:fail", null);
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.gg(8);
                    }
                    m.a(this.lpf.blF(), FC("sendAppMessage"), null, string);
                    a(this.lpf, true);
                    cP(1, 3);
                    a(this.lpf, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    g.bd(this.context, this.context.getResources().getString(2131231155));
                    a(this.lpf, "share_weibo:ok", null);
                    return;
                case 0:
                    a(this.lpf, "share_weibo:cancel", null);
                    return;
                case 1:
                    a(this.lpf, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    return;
                default:
                    a(this.lpf, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    v.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 3) {
            v.i("MicroMsg.MsgHandler", "get callback address, result code = %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1 && intent != null) {
                str = be.ah(intent.getStringExtra("nationalCode"), "");
                r3 = be.ah(intent.getStringExtra("userName"), "");
                string = be.ah(intent.getStringExtra("telNumber"), "");
                stringExtra = be.ah(intent.getStringExtra("addressPostalCode"), "");
                str2 = be.ah(intent.getStringExtra("proviceFirstStageName"), "");
                str3 = be.ah(intent.getStringExtra("addressCitySecondStageName"), "");
                str4 = be.ah(intent.getStringExtra("addressCountiesThirdStageName"), "");
                str5 = be.ah(intent.getStringExtra("addressDetailInfo"), "");
                v.i("MicroMsg.MsgHandler", "first =  " + str2 + " ; detail =" + str5 + "; second = " + str3 + " ; tel = " + string + "; third = " + str4);
                if (!be.kS(r3)) {
                    Map hashMap = new HashMap();
                    hashMap.put("nationalCode", str);
                    hashMap.put("userName", r3);
                    hashMap.put("telNumber", string);
                    hashMap.put("addressPostalCode", stringExtra);
                    hashMap.put("proviceFirstStageName", str2);
                    hashMap.put("addressCitySecondStageName", str3);
                    hashMap.put("addressCountiesThirdStageName", str4);
                    hashMap.put("addressDetailInfo", str5);
                    a(this.lpf, "edit_address:ok", hashMap);
                    return;
                }
            }
            if (i2 == 0) {
                a(this.lpf, "edit_address:cancel", null);
            } else {
                a(this.lpf, "edit_address:fail", null);
            }
        } else if (i == 4) {
            v.i("MicroMsg.MsgHandler", "request pay, resultCode = " + i2);
            if (this.lpw != -1) {
                v.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.lpf = th(this.lpw).lpf;
                this.leB = th(this.lpw).leB;
                this.lpw = -1;
            }
            if (i2 == -1) {
                a(this.lpf, "get_brand_wcpay_request:ok", null);
            } else if (i2 == 5) {
                r2 = new HashMap();
                r3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                string = be.ma(intent.getStringExtra("key_jsapi_pay_err_msg"));
                r2.put("err_code", Integer.valueOf(r3));
                r2.put("err_desc", string);
                v.e("MicroMsg.MsgHandler", "hy: pay jsapi failed. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(r3), string});
                a(this.lpf, "get_brand_wcpay_request:fail", r2);
            } else {
                a(this.lpf, "get_brand_wcpay_request:cancel", null);
            }
        } else if (i == 27) {
            v.i("MicroMsg.MsgHandler", "request ibg prepay request, resultCode = " + i2);
            if (this.lpw != -1) {
                v.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.lpf = th(this.lpw).lpf;
                this.leB = th(this.lpw).leB;
                this.lpw = -1;
            }
            if (i2 == -1) {
                a(this.lpf, "get_h5_prepay_request:ok", null);
            } else {
                a(this.lpf, "get_h5_prepay_request:cancel", null);
            }
        } else if (i == 5) {
            v.i("MicroMsg.MsgHandler", "request jump to mall, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "jump_wcmall:ok", null);
            } else {
                a(this.lpf, "jump_wcmall:fail", null);
            }
        } else if (i == 6) {
            v.i("MicroMsg.MsgHandler", "request jump to product view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "open_product_view:ok", null);
            } else {
                a(this.lpf, "open_product_view:fail", null);
            }
        } else if (i == 7) {
            v.i("MicroMsg.MsgHandler", "request bind card, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "get_brand_wcpay_bind_card_request:ok", null);
            } else {
                a(this.lpf, "get_brand_wcpay_bind_card_request:fail", null);
            }
        } else if (i == 9) {
            v.i("MicroMsg.MsgHandler", "request open wxcredit, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "get_wcpay_create_credit_card_request:ok", null);
            } else {
                a(this.lpf, "get_wcpay_create_credit_card_request:fail", null);
            }
        } else if (i == 8) {
            v.i("MicroMsg.MsgHandler", "request jumpToBizProfile, resultCode = " + i2);
            switch (i2) {
                case -1:
                    a(this.lpf, "jump_to_biz_profile:ok", null);
                    return;
                case 0:
                    a(this.lpf, "jump_to_biz_profile:cancel", null);
                    return;
                case 2:
                case 3:
                    a(this.lpf, "jump_to_biz_profile:check_fail", null);
                    return;
                default:
                    a(this.lpf, "jump_to_biz_profile:fail", null);
                    v.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 10) {
            if (i2 == 0) {
                v.i("MicroMsg.MsgHandler", "open scan product ui back");
                a(this.lpf, "open_scan_product_view:ok", null);
            }
        } else if (i == 11) {
            v.i("MicroMsg.MsgHandler", "request transfer_money, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "get_transfer_money_request:ok", null);
            } else {
                a(this.lpf, "get_transfer_money_request:fail", null);
            }
        } else if (i == 17) {
            v.i("MicroMsg.MsgHandler", "request open_wcpay_specific_view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "open_wcpay_specific_view:ok", null);
            } else {
                a(this.lpf, "open_wcpay_specific_view:fail", null);
            }
        } else if (i == 18) {
            v.i("MicroMsg.MsgHandler", "request request_wcpay_send_c2c_msg, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "get_send_c2c_message_request:ok", null);
            } else if (i2 == 0) {
                a(this.lpf, "get_send_c2c_message_request:cancel", null);
            } else {
                a(this.lpf, "get_send_c2c_message_request:fail", null);
            }
        } else if (i == 13) {
            v.d("MicroMsg.MsgHandler", "request choose card, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_card_info", be.ah(intent.getStringExtra("choose_card_info"), ""));
                }
                a(this.lpf, "choose_card:ok", r2);
                return;
            }
            a(this.lpf, "choose_card:fail", r2);
        } else if (i == 36) {
            v.d("MicroMsg.MsgHandler", "request choose invoice, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_invoice_info", be.ah(intent.getStringExtra("choose_invoice_info"), ""));
                }
                a(this.lpf, "choose_invoice:ok", r2);
                return;
            }
            a(this.lpf, "choose_invoice:fail", r2);
        } else if (i == 16) {
            v.d("MicroMsg.MsgHandler", "request batch add card, resultCode = " + i2);
            r3 = new HashMap();
            if (intent != null) {
                r3.put("card_list", be.ah(intent.getStringExtra("card_list"), ""));
            }
            if (i2 == -1) {
                a(this.lpf, "batch_add_card:ok", r3);
                return;
            }
            r2 = 2;
            if (intent != null) {
                r2 = intent.getIntExtra("result_code", 2);
            }
            if (r2 == 2) {
                a(this.lpf, "batch_add_card:fail", r3);
            } else {
                a(this.lpf, "batch_add_card:cancel", r3);
            }
        } else if (i == 23) {
            if (i2 == -1) {
                a(this.lpf, "batch_view_card:ok", null);
            } else {
                a(this.lpf, "batch_view_card:fail", null);
            }
        } else if (i == 15) {
            if (this.lpf == null || be.kS(this.lpf.lqZ)) {
                v.e("MicroMsg.MsgHandler", "msg is null");
                return;
            }
            v.i("MicroMsg.MsgHandler", "request to scan qr code, result code = %d, function is %s", new Object[]{Integer.valueOf(i2), this.lpf.lqZ});
            if (this.lpf.lqZ.equals("scanQRCode")) {
                switch (i2) {
                    case -1:
                        r2 = new HashMap();
                        if (intent != null) {
                            r2.put("resultStr", intent.getStringExtra("key_scan_result"));
                        }
                        a(this.lpf, "scanQRCode:ok", r2);
                        return;
                    case 0:
                        a(this.lpf, "scanQRCode:cancel", null);
                        return;
                    default:
                        a(this.lpf, "scanQRCode:fail", null);
                        return;
                }
            }
        } else if (i == 14) {
            v.i("MicroMsg.MsgHandler", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false))});
            r3 = new HashMap();
            if (intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)) {
                r3.put("memoryWarning", Boolean.valueOf(true));
            }
            switch (i2) {
                case -1:
                    str = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    v.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{str});
                    if (!be.kS(str)) {
                        r3.put("localIds", str);
                        str = intent.getStringExtra("key_pick_local_pic_source_type");
                        if (str != null) {
                            r3.put("sourceType", str);
                        }
                        a(this.lpf, "chooseImage:ok", r3);
                        return;
                    }
                    break;
                case 0:
                    a(this.lpf, "chooseImage:cancel", r3);
                    return;
            }
            a(this.lpf, "chooseImage:fail", r3);
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!be.kS(r3)) {
                        r2 = com.tencent.mm.plugin.webview.e.e.bjd().DW(r3);
                        if (r2 != null && (r2 instanceof ab)) {
                            r2 = (ab) r2;
                            Map hashMap2 = new HashMap();
                            hashMap2.put("localId", r3);
                            hashMap2.put("duration", Integer.valueOf(r2.duration));
                            hashMap2.put("height", Integer.valueOf(r2.height));
                            hashMap2.put("size", Integer.valueOf(r2.size));
                            hashMap2.put("width", Integer.valueOf(r2.width));
                            a(this.lpf, "chooseVideo:ok", hashMap2);
                            return;
                        }
                    }
                    a(this.lpf, "chooseVideo:fail", null);
                    return;
                case 0:
                    a(this.lpf, "chooseVideo:cancel", null);
                    return;
                default:
                    a(this.lpf, "chooseVideo:fail", null);
                    return;
            }
        } else if (i == 45) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    string = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    v.i("MicroMsg.MsgHandler", "localId:%s", new Object[]{r3});
                    v.i("MicroMsg.MsgHandler", "thumbLocalId:%s", new Object[]{string});
                    if (!be.kS(r3)) {
                        r2 = com.tencent.mm.plugin.webview.e.e.bjd().DW(r3);
                        if (r2 != null && (r2 instanceof ab)) {
                            r2 = (ab) r2;
                            r5 = new HashMap();
                            r5.put("localId", r3);
                            r5.put("duration", Integer.valueOf(r2.duration));
                            r5.put("height", Integer.valueOf(r2.height));
                            r5.put("size", Integer.valueOf(r2.size));
                            r5.put("width", Integer.valueOf(r2.width));
                            r5.put("thumbLocalId", string);
                            a(this.lpf, "recordVideo:ok", r5);
                            return;
                        }
                    }
                    a(this.lpf, "recordVideo:fail", null);
                    return;
                case 0:
                    a(this.lpf, "recordVideo:cancel", null);
                    return;
                default:
                    a(this.lpf, "recordVideo:fail", null);
                    return;
            }
        } else if (i == 47) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        v.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,");
                        a(this.lpf, "chooseMedia:fail", null);
                        return;
                    }
                    r2 = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                    if (r2 == 1) {
                        r3 = intent.getStringExtra("key_pick_local_media_local_id");
                        string = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        v.i("MicroMsg.MsgHandler", "video localId:%s", new Object[]{r3});
                        v.i("MicroMsg.MsgHandler", "video thumbLocalId:%s", new Object[]{string});
                        if (!be.kS(r3)) {
                            r2 = com.tencent.mm.plugin.webview.e.e.bjd().DW(r3);
                            if (r2 != null && (r2 instanceof ab)) {
                                r2 = (ab) r2;
                                r5 = new HashMap();
                                r5.put(Columns.TYPE, Integer.valueOf(1));
                                r5.put("localId", r3);
                                r5.put("duration", Integer.valueOf(r2.duration));
                                r5.put("height", Integer.valueOf(r2.height));
                                r5.put("size", Integer.valueOf(r2.size));
                                r5.put("width", Integer.valueOf(r2.width));
                                r5.put("thumbLocalId", string);
                                a(this.lpf, "chooseMedia:ok", r5);
                                return;
                            }
                        }
                        a(this.lpf, "chooseMedia:fail", null);
                        return;
                    } else if (r2 == 2) {
                        str = intent.getStringExtra("key_pick_local_media_local_id");
                        v.i("MicroMsg.MsgHandler", "video localId:%s", new Object[]{str});
                        if (!be.kS(str)) {
                            x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
                            if (DW != null && (DW instanceof z)) {
                                r3 = new HashMap();
                                r3.put(Columns.TYPE, Integer.valueOf(2));
                                r3.put("localId", str);
                                a(this.lpf, "chooseMedia:ok", r3);
                                return;
                            }
                        }
                        a(this.lpf, "chooseMedia:fail", null);
                        return;
                    } else {
                        v.e("MicroMsg.MsgHandler", "type:%d is error", new Object[]{Integer.valueOf(r2)});
                        a(this.lpf, "chooseMedia:fail", null);
                        return;
                    }
                case 0:
                    a(this.lpf, "chooseMedia:cancel", null);
                    return;
                default:
                    a(this.lpf, "chooseMedia:fail", null);
                    return;
            }
        } else if (i == 46) {
            switch (i2) {
                case -1:
                    a(this.lpf, "previewVideo:ok", null);
                    return;
                case 0:
                    a(this.lpf, "previewVideo:cancel", null);
                    return;
                default:
                    a(this.lpf, "previewVideo:fail", null);
                    return;
            }
        } else if (i == 19) {
            v.i("MicroMsg.MsgHandler", "request to config exdevice wifi connection, result code = " + i2);
            switch (i2) {
                case -1:
                    a(this.lpf, "configWXDeviceWiFi:ok", null);
                    return;
                case 0:
                    r2 = null;
                    if (intent != null) {
                        if (!intent.getBooleanExtra("is_wifi_connected", true)) {
                            r2 = new HashMap();
                            r2.put("desc", "wifi_not_connected");
                        }
                    }
                    a(this.lpf, "configWXDeviceWiFi:cancel", r2);
                    return;
                case 1:
                    a(this.lpf, "configWXDeviceWiFi:fail", null);
                    return;
                default:
                    return;
            }
        } else if (i == 20) {
            v.i("MicroMsg.MsgHandler", "request request_verify_wcpay_password, resultCode = " + i2);
            r3 = new HashMap();
            if (i2 == -1) {
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = be.ah(intent.getStringExtra("token"), "");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    v.i("MicroMsg.MsgHandler", "checkPwdToken is empty, verifyWCPayPassword:fail");
                    a(this.lpf, "verifyWCPayPassword:fail", null);
                    return;
                }
                r3.put("token", charSequence);
                a(this.lpf, "verifyWCPayPassword:ok", r3);
                v.i("MicroMsg.MsgHandler", "checkPwdToken is valid, verifyWCPayPassword:ok");
                return;
            }
            v.i("MicroMsg.MsgHandler", "resultCode is canlcel, verifyWCPayPassword:fail");
            a(this.lpf, "verifyWCPayPassword:fail", null);
        } else if (21 == i) {
            v.d("MicroMsg.MsgHandler", "hy: callback to see order. directly finish");
            a(this.lpf, "see_order_ok", null);
        } else if (i == 22) {
            v.i("MicroMsg.MsgHandler", "request get_recevie_biz_hongbao_request, resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "get_recevie_biz_hongbao_request:ok", null);
            } else {
                a(this.lpf, "get_recevie_biz_hongbao_request:fail", null);
            }
        } else if (i == 24) {
            if (i2 == -1) {
                cP(2, 1);
                a(this.lpf, "share_timeline:ok", null);
                return;
            }
            cP(2, 3);
            a(this.lpf, "share_timeline:cancel", null);
        } else if (i == 26) {
            v.d("MicroMsg.MsgHandler", "select pedometer source resultCode = " + i2);
            if (i2 == -1) {
                a(this.lpf, "selectPedometerSource:ok", null);
            } else if (i2 == 0) {
                v.i("MicroMsg.MsgHandler", "selectPedometerSource result cancel");
                a(this.lpf, "selectPedometerSource:cancel", null);
            } else {
                v.e("MicroMsg.MsgHandler", "selectPedometerSource result fail");
                a(this.lpf, "selectPedometerSource:fail", null);
            }
        } else if (i == 25) {
            v.i("MicroMsg.MsgHandler", "hy: get ibg order finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.lpf, "get_h5_transaction_request:ok", null);
            } else {
                a(this.lpf, "get_h5_transaction_request:cancel", null);
            }
        } else if (i == 28) {
            v.i("MicroMsg.MsgHandler", "get web pay checkout counter request finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                r2 = new HashMap();
                r3 = be.ah(intent.getStringExtra("token"), "");
                string = be.ah(intent.getStringExtra("bind_serial"), "");
                r2.put("token", r3);
                r2.put("bind_serial", string);
                a(this.lpf, "getWebPayCheckoutCounterRequst:ok", r2);
                return;
            }
            a(this.lpf, "getWebPayCheckoutCounterRequst:fail", null);
        } else if (i == 31) {
            if (i2 != -1) {
                a(this.lpf, "openEnterpriseContact:ok", null);
                return;
            }
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null) {
                str = bundleExtra.getString("result");
                r3 = new HashMap();
                r3.put("result", str);
                a(this.lpf, "openEnterpriseContact:ok", r3);
                return;
            }
            a(this.lpf, "openEnterpriseContact:ok", null);
        } else if (i == 29) {
            r3 = "MicroMsg.MsgHandler";
            string = "consumedShareCard:ok(r : %b)";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i2 == -1);
            v.d(r3, string, objArr);
            if (i2 == -1) {
                a(this.lpf, "consumedShareCard:ok", null);
            } else {
                a(this.lpf, "consumedShareCard:fail", null);
            }
        } else if (i == 113) {
            if (i2 == -1) {
                I(this.lpf);
            } else {
                a(this.lpf, "chooseImage:fail_android_permission_denied", null);
            }
        } else if (i == 116) {
            if (i2 == -1) {
                O(this.lpf);
            } else {
                a(this.lpf, "startRecord:fail_android_permission_denied", null);
            }
        } else if (i == 115) {
            if (i2 == -1) {
                a(this.lpf, 0);
            } else {
                a(this.lpf, "chooseVideo:fail_android_permission_denied", null);
            }
        } else if (i == 117) {
            if (i2 == -1) {
                a(this.lpf, 1);
            } else {
                a(this.lpf, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 118) {
            if (i2 == -1) {
                a(this.lpf, 1);
            } else {
                a(this.lpf, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 30) {
            v.i("MicroMsg.MsgHandler", "doSelectSingleContact activtiy callback");
            str = (String) this.lpf.iaJ.get("appId");
            if (this.lpj == null || !TextUtils.isEmpty(str)) {
                r3 = str;
            } else {
                r3 = this.lpj.getString("jsapi_args_appid");
            }
            int i3 = be.getInt((String) this.lpf.iaJ.get("selectMode"), 0);
            v.i("MicroMsg.MsgHandler", "select single contact : appId:%s, busiId:%s, selectedMode:%d", new Object[]{r3, (String) this.lpf.iaJ.get("busiId"), Integer.valueOf(i3)});
            switch (i2) {
                case -1:
                    string = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (string == null || string.length() == 0) {
                        v.e("MicroMsg.MsgHandler", "mmOnActivityResult,selectSingleContact fail, user is null");
                        a(this.lpf, "selectSingleContact:fail", null);
                        return;
                    } else if (i3 == 0) {
                        final com.tencent.mm.plugin.webview.d.k kVar = new com.tencent.mm.plugin.webview.d.k(r3, string);
                        ak.vy().a(1566, new e(this) {
                            final /* synthetic */ i lpR;

                            {
                                this.lpR = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                if (this.lpR.dwR != null && this.lpR.dwR.isShowing()) {
                                    this.lpR.dwR.dismiss();
                                    this.lpR.dwR = null;
                                }
                                ak.vy().b(1566, this);
                                if (i == 0 && i2 == 0) {
                                    int i3;
                                    v.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
                                    com.tencent.mm.plugin.webview.d.k kVar2 = (com.tencent.mm.plugin.webview.d.k) kVar;
                                    adu com_tencent_mm_protocal_c_adu = kVar2.cif == null ? null : (adu) kVar2.cif.czl.czs;
                                    Object obj = this.lpR.lpf.iaJ.get("result_sign_type");
                                    if (obj != null) {
                                        i3 = be.getInt((String) obj, 0);
                                    } else {
                                        i3 = 0;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("package", com_tencent_mm_protocal_c_adu.mmU);
                                    hashMap.put("sign", com_tencent_mm_protocal_c_adu.mmV);
                                    if (i3 == 1) {
                                        hashMap.put("signType", com_tencent_mm_protocal_c_adu.mmW);
                                    }
                                    hashMap.put("timestamp", com_tencent_mm_protocal_c_adu.mgs);
                                    hashMap.put("noncestr", com_tencent_mm_protocal_c_adu.mmT);
                                    v.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[]{com_tencent_mm_protocal_c_adu.mmU, com_tencent_mm_protocal_c_adu.mmV});
                                    this.lpR.a(this.lpR.lpf, "selectSingleContact:ok", hashMap);
                                    return;
                                }
                                v.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
                                this.lpR.a(this.lpR.lpf, "selectSingleContact:fail", null);
                            }
                        });
                        ak.vy().d(kVar);
                        Context context = this.context;
                        this.context.getString(2131231164);
                        this.dwR = g.a(context, this.context.getString(2131231182), true, new OnCancelListener(this) {
                            final /* synthetic */ i lpR;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(kVar);
                            }
                        });
                        return;
                    } else if (i3 == 1) {
                        final q qVar = new q(r3, str, string);
                        ak.vy().a(1177, new e(this) {
                            final /* synthetic */ i lpR;

                            {
                                this.lpR = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                if (this.lpR.dwR != null && this.lpR.dwR.isShowing()) {
                                    this.lpR.dwR.dismiss();
                                    this.lpR.dwR = null;
                                }
                                ak.vy().b(1177, this);
                                if (i == 0 && i2 == 0) {
                                    v.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
                                    q qVar = (q) kVar;
                                    Map hashMap = new HashMap();
                                    hashMap.put("package", qVar.lea);
                                    hashMap.put("sign", qVar.fZW);
                                    hashMap.put("headImgUrl", qVar.leb);
                                    hashMap.put("nickName", qVar.lec);
                                    hashMap.put("friendRelation", Integer.valueOf(qVar.led));
                                    v.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", new Object[]{qVar.lea, qVar.fZW, qVar.lec, Integer.valueOf(qVar.led)});
                                    this.lpR.a(this.lpR.lpf, "selectSingleContact:ok", hashMap);
                                    return;
                                }
                                v.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
                                this.lpR.a(this.lpR.lpf, "selectSingleContact:fail", null);
                            }
                        });
                        ak.vy().d(qVar);
                        Context context2 = this.context;
                        this.context.getString(2131231164);
                        this.dwR = g.a(context2, this.context.getString(2131231182), true, new OnCancelListener(this) {
                            final /* synthetic */ i lpR;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(qVar);
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 0:
                    a(this.lpf, "selectSingleContact:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 34) {
            if (i2 == -1) {
                a(this.lpf, "get_wcpay_realname_verify:ok", null);
            } else if (i2 == 1) {
                a(this.lpf, "get_wcpay_realname_verify:fail", null);
            } else {
                a(this.lpf, "get_wcpay_realname_verify:cancel", null);
            }
        } else if (i == 35) {
            if (i2 == -1) {
                lm lmVar = new lm();
                lmVar.bmR.context = this.context;
                com.tencent.mm.sdk.c.a.nhr.z(lmVar);
                try {
                    this.leB.bjq();
                    this.leB.B(null);
                    return;
                } catch (Throwable e) {
                    v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
                    return;
                }
            }
            a(this.lpf, "selectWalletCurrency:cancel", null);
        } else if (i == 37) {
            if (this.bhh == null) {
                v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.lpf, "send_app_msg:fail", null);
                return;
            }
            final long longExtra;
            str = (String) this.lpf.iaJ.get("appid");
            snsAdClick = null;
            if (this.lpj != null) {
                snsAdClick = (SnsAdClick) this.lpj.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.lpj.getString("jsapi_args_appid");
                    obj = this.lpf.blF().get("Internal@AsyncReport");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.gg(7);
                            }
                            Gh = com.tencent.mm.pluginsdk.model.app.g.Gh(string);
                            if (intent != null) {
                                stringExtra = intent.getStringExtra("enterprise_biz_name");
                                longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                str5 = intent.getStringExtra("enterprise_share_append_text");
                                if (stringExtra != null || stringExtra.length() == 0) {
                                    v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                    a(this.lpf, "send_app_msg:fail", null);
                                    return;
                                }
                                str2 = (String) this.lpf.iaJ.get("img_url");
                                this.lpf.iaJ.get("desc");
                                str3 = (String) this.lpf.iaJ.get("src_username");
                                str4 = (String) this.lpf.iaJ.get("src_displayname");
                                blr = blr();
                                m.a(this.lpf.blF(), FC("sendAppMessage"), stringExtra, string);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    a(this.lpf, true);
                                }
                                if (be.kS(str2)) {
                                    if (longExtra >= 0) {
                                        com.tencent.mm.modelbiz.a.c Z = com.tencent.mm.modelbiz.u.DA().Z(longExtra);
                                        synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                                            String zr = com.tencent.mm.modelbiz.a.e.zr();
                                            com.tencent.mm.modelbiz.a.e.e(Z);
                                            a(Gh, string, stringExtra, str2, str3, str4, str5, blr);
                                            com.tencent.mm.modelbiz.a.e.hZ(zr);
                                        }
                                    } else {
                                        a(Gh, string, stringExtra, str2, str3, str4, str5, blr);
                                    }
                                    g.bd(this.context, this.context.getString(2131231978));
                                    a(this.lpf, "send_app_msg:ok", null);
                                    return;
                                }
                                final f fVar2 = Gh;
                                str6 = string;
                                str7 = stringExtra;
                                str8 = str2;
                                str9 = str3;
                                final String str12 = str4;
                                final String str13 = str5;
                                final String str14 = blr;
                                n.GG().a(str2, new com.tencent.mm.ae.b.c(this) {
                                    final /* synthetic */ i lpR;

                                    public final void j(Bitmap bitmap) {
                                        if (this.lpR.gKB != null) {
                                            this.lpR.gKB.dismiss();
                                        }
                                        if (longExtra >= 0) {
                                            com.tencent.mm.modelbiz.a.c Z = com.tencent.mm.modelbiz.u.DA().Z(longExtra);
                                            synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                                                String zr = com.tencent.mm.modelbiz.a.e.zr();
                                                com.tencent.mm.modelbiz.a.e.e(Z);
                                                this.lpR.a(fVar2, str6, str7, str8, str9, str12, str13, str14);
                                                com.tencent.mm.modelbiz.a.e.hZ(zr);
                                            }
                                        } else {
                                            this.lpR.a(fVar2, str6, str7, str8, str9, str12, str13, str14);
                                        }
                                        if (this.lpR.context != null) {
                                            g.bf(this.lpR.context, this.lpR.context.getString(2131231978));
                                        }
                                        this.lpR.a(this.lpR.lpf, "send_app_msg:ok", null);
                                    }
                                });
                                return;
                            }
                            return;
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.gg(8);
                            }
                            m.a(this.lpf.blF(), FC("sendAppMessage"), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                a(this.lpf, true);
                            }
                            a(this.lpf, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.lpf.blF().get("Internal@AsyncReport");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.gg(7);
                    }
                    Gh = com.tencent.mm.pluginsdk.model.app.g.Gh(string);
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("enterprise_biz_name");
                        longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                        str5 = intent.getStringExtra("enterprise_share_append_text");
                        if (stringExtra != null) {
                            break;
                        }
                        v.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.lpf, "send_app_msg:fail", null);
                        return;
                    }
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.gg(8);
                    }
                    m.a(this.lpf.blF(), FC("sendAppMessage"), null, string);
                    a(this.lpf, true);
                    a(this.lpf, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 38) {
            if (i2 == -1) {
                v.i("MicroMsg.MsgHandler", "hy: soter auth ok");
                a(this.lpf, "soter_biometric_authentication:ok", k.P(intent.getExtras()));
            } else if (i2 == 1) {
                v.w("MicroMsg.MsgHandler", "hy: soter auth failed");
                a(this.lpf, "soter_biometric_authentication:fail", k.P(intent.getExtras()));
            } else {
                v.e("MicroMsg.MsgHandler", "hy: soter user cancelled");
                a(this.lpf, "soter_biometric_authentication:cancel", k.P(intent.getExtras()));
            }
        } else if (i == 39) {
            if (i2 == -1) {
                a(this.lpf, "unbind_bank_card:ok", null);
            } else if (i2 == 1) {
                a(this.lpf, "unbind_bank_card:fail", null);
            } else {
                a(this.lpf, "unbind_bank_card:cancel", null);
            }
        } else if (i == 40) {
            if (i2 == -1) {
                Bundle bundle = new Bundle();
                if (intent != null) {
                    ArrayList b = com.tencent.mm.ar.a.b(intent.getLongArrayExtra("k_outside_expose_proof_item_list"));
                    int size = b.size();
                    String[] strArr = new String[size];
                    String[] strArr2 = new String[size];
                    String[] strArr3 = new String[size];
                    int[] iArr = new int[size];
                    int[] iArr2 = new int[size];
                    for (r3 = 0; r3 < size; r3++) {
                        at atVar = (at) b.get(r3);
                        strArr[r3] = String.valueOf(atVar.pK());
                        if (intent.getBooleanExtra("k_is_group_chat", false)) {
                            strArr2[r3] = aw.fM(atVar.pO());
                            strArr3[r3] = aw.fL(atVar.pO());
                        } else {
                            strArr2[r3] = atVar.pO();
                            strArr3[r3] = atVar.pN();
                        }
                        if (atVar.pL() == 1) {
                            strArr3[r3] = com.tencent.mm.model.k.xF();
                        }
                        if (strArr2[r3] == null) {
                            strArr2[r3] = "";
                        }
                        if (strArr3[r3] == null) {
                            strArr3[r3] = "";
                        }
                        if (atVar.bvY()) {
                            iArr[r3] = 49;
                        } else {
                            iArr[r3] = atVar.getType();
                        }
                        iArr2[r3] = (int) (atVar.pM() / 1000);
                    }
                    bundle.putStringArray("msgIds", strArr);
                    bundle.putStringArray("contents", strArr2);
                    bundle.putStringArray("senders", strArr3);
                    bundle.putIntArray("msgTypes", iArr);
                    bundle.putIntArray("msgTimes", iArr2);
                    try {
                        if (this.leB != null) {
                            this.leB.g(48, bundle);
                        }
                        a(this.lpf, "select chat record:ok", null);
                        return;
                    } catch (RemoteException e2) {
                        v.w("MicroMsg.MsgHandler", "onGetMsgProofItems exception" + e2.getMessage());
                        a(this.lpf, "select chat record:fail", null);
                        return;
                    }
                }
                a(this.lpf, "select chat record:fail", null);
                return;
            }
            a(this.lpf, "select chat record:cancel", null);
        } else if (i == 41) {
            if (i2 == -1) {
                a(this.lpf, "id_card_realname_verify:ok", null);
            } else if (i2 == 1) {
                a(this.lpf, "id_card_realname_verify:fail", null);
            } else {
                a(this.lpf, "id_card_realname_verify:cancel", null);
            }
        } else if (i == 42) {
            if (i2 == -1) {
                if (intent != null) {
                    str = be.ah(intent.getStringExtra("gameRegionName"), "");
                    r3 = new HashMap();
                    r3.put("gameRegionName", str);
                    a(this.lpf, "get game region:ok", r3);
                    return;
                }
                a(this.lpf, "get game region:fail", null);
            } else if (i2 == 1) {
                a(this.lpf, "get game region:fail", null);
            } else {
                a(this.lpf, "get game region:cancel", null);
            }
        } else if (i == 43) {
            v.i("MicroMsg.MsgHandler", "request to open file chooser for id card image, result code = " + i2);
            switch (i2) {
                case -1:
                    r2 = new HashMap();
                    r3 = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    v.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{r3});
                    if (!be.kS(r3)) {
                        try {
                            JSONArray jSONArray = new JSONArray(r3);
                            if (jSONArray.length() > 0) {
                                r2.put("localId", jSONArray.get(0).toString());
                                if (intent.getStringExtra("key_pick_local_pic_source_type") != null) {
                                    r2.put("sourceType", "album");
                                }
                                a(this.lpf, "chooseIdCard:ok", r2);
                                return;
                            }
                            a(this.lpf, "chooseImage:fail", null);
                            return;
                        } catch (Throwable e3) {
                            v.a("MicroMsg.MsgHandler", e3, "", new Object[0]);
                            break;
                        }
                    }
                    a(this.lpf, "chooseIdCard:fail", null);
                    return;
                case 0:
                    a(this.lpf, "chooseIdCard:cancel", null);
                    return;
            }
            a(this.lpf, "chooseImage:fail", null);
        }
    }

    private void aI(k kVar) {
        Bundle O = k.O(kVar.iaJ);
        try {
            this.leB.bjq();
            this.leB.B(O);
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
        }
    }

    private boolean a(f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.bhh == null) {
            v.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            return false;
        }
        n.GG();
        Bitmap gu = com.tencent.mm.ae.b.gu(str3);
        if (!(gu == null || gu.isRecycled())) {
            v.i("MicroMsg.MsgHandler", "thumb image is not null");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gu.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.bhh.thumbData = byteArrayOutputStream.toByteArray();
        }
        mp mpVar = new mp();
        mpVar.bnP.bhh = this.bhh;
        mpVar.bnP.appId = str;
        mpVar.bnP.appName = fVar == null ? "" : fVar.field_appName;
        mpVar.bnP.toUser = str2;
        mpVar.bnP.bnQ = 2;
        if (be.kS(str4)) {
            mpVar.bnP.bnT = null;
        } else {
            mpVar.bnP.bnR = str4;
            mpVar.bnP.bnS = str5;
        }
        try {
            String string = this.lpj.getString("key_snsad_statextstr");
            mpVar.bnP.bnY = string;
            mpVar.bnP.bnU = this.leB.bjo();
            Bundle i = this.leB.i(18, null);
            if (i != null) {
                com.tencent.mm.e.a.mp.a aVar = mpVar.bnP;
                String ma = be.ma(i.getString("KPublisherId"));
                aVar.bnX = ma;
                String fz = o.fz(ma);
                com.tencent.mm.model.o.b n = o.yx().n(fz, true);
                n.l("sendAppMsgScene", Integer.valueOf(2));
                n.l("preChatName", i.getString("preChatName"));
                n.l("preMsgIndex", Integer.valueOf(i.getInt("preMsgIndex")));
                n.l("prePublishId", i.getString("prePublishId"));
                n.l("preUsername", i.getString("preUsername"));
                n.l("getA8KeyScene", Integer.valueOf(i.getInt("getA8KeyScene")));
                n.l("referUrl", i.getString("referUrl"));
                if (!be.kS(string)) {
                    n.l("adExtStr", string);
                }
                mpVar.bnP.aZj = fz;
            }
            string = this.leB.Ra();
            mpVar.bnP.bnV = string;
            mpVar.bnP.bnW = this.lps.Fu(string);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "init bunddata failed : %s", new Object[]{e.getMessage()});
        }
        boolean z = com.tencent.mm.sdk.c.a.nhr.z(mpVar);
        if (!be.kS(str6)) {
            mr mrVar = new mr();
            mrVar.boa.bob = str2;
            mrVar.boa.content = str6;
            mrVar.boa.type = m.fp(str2);
            mrVar.boa.flags = 0;
            com.tencent.mm.sdk.c.a.nhr.z(mrVar);
        }
        if (be.kS(str7)) {
            return z;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(128), str7});
        return z;
    }

    private void a(k kVar, String str, Map<String, Object> map) {
        a(kVar, str, (Map) map, true, true);
    }

    public final void a(k kVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        this.fHM = false;
        try {
            this.leB.a(kVar == null ? null : kVar.lqX, str, k.O(map), z);
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
        if (z2) {
            l.unlock();
        }
    }

    public final void a(com.tencent.mm.plugin.webview.stub.e eVar, k kVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        if (!z2) {
            this.fHM = false;
        }
        try {
            eVar.a(kVar == null ? null : kVar.lqX, str, k.O(map), z);
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    private void a(k kVar, boolean z) {
        if (kVar == null) {
            v.e("MicroMsg.MsgHandler", "msg is null when report.");
            return;
        }
        String str = kVar.lqZ;
        Map map = kVar.lqY;
        map.put("isSuccess", Boolean.valueOf(z));
        com.tencent.mm.plugin.webview.stub.e eVar = this.leB;
        if (be.kS(str)) {
            v.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
            return;
        }
        String str2;
        String str3;
        boolean c;
        String ma;
        boolean c2;
        int f;
        int f2;
        int i = eVar == null ? 1 : 0;
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        if (i != 0) {
            try {
                str4 = "";
            } catch (Exception e) {
                v.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e.getMessage());
                str2 = str5;
                str3 = str4;
            }
        } else {
            str4 = eVar.bjo();
        }
        str6 = i != 0 ? "" : eVar.bjp();
        str2 = i != 0 ? "" : eVar.Ra();
        str3 = str4;
        if (map != null) {
            c = be.c((Boolean) map.get("fromMenu"));
            ma = be.ma((String) map.get("keyParam"));
            str4 = be.ah((String) map.get("appId"), "");
            c2 = be.c((Boolean) map.get("isSuccess"));
            f = be.f((Integer) map.get("permissionValue"));
            f2 = be.f((Integer) map.get("baseErrorCode"));
            i = be.f((Integer) map.get("jsapiErrorCode"));
        } else {
            i = 0;
            c2 = false;
            str4 = str7;
            ma = null;
            c = false;
            f2 = 0;
            f = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URLEncoder.encode(be.ma(str3)));
        stringBuilder.append(",");
        stringBuilder.append(URLEncoder.encode(be.ma(str2)));
        stringBuilder.append(",");
        if (str6 == null) {
            str6 = "";
        }
        stringBuilder.append(str6);
        stringBuilder.append(",");
        stringBuilder.append(str == null ? "" : str);
        stringBuilder.append(",");
        stringBuilder.append(c ? "1" : "0");
        stringBuilder.append(",");
        if (ma == null) {
            ma = "";
        }
        stringBuilder.append(ma);
        stringBuilder.append(",");
        stringBuilder.append(str4);
        stringBuilder.append(",");
        stringBuilder.append(c2 ? "1" : "0");
        stringBuilder.append(",");
        stringBuilder.append(f);
        if (!c2) {
            stringBuilder.append(",");
            stringBuilder.append(0);
            stringBuilder.append(",");
            stringBuilder.append(f2);
            stringBuilder.append(",");
            stringBuilder.append(i);
        }
        String stringBuilder2 = stringBuilder.toString();
        v.d("MicroMsg.WebViewSecurityUtil", "report: " + stringBuilder2);
        com.tencent.mm.plugin.report.service.g.iuh.Y(10417, stringBuilder2);
    }

    private int aJ(k kVar) {
        int hashCode = kVar.hashCode();
        this.lpM.put(Integer.valueOf(hashCode), new b(this, kVar, this.leB));
        this.fHM = false;
        try {
            this.leB.bjr();
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", new Object[]{e.getMessage()});
        }
        return hashCode;
    }

    public final b th(int i) {
        return (b) this.lpM.get(Integer.valueOf(i));
    }

    private void ti(int i) {
        b bVar = (b) this.lpM.remove(Integer.valueOf(i));
        if (bVar != null) {
            bVar.lpf = null;
            bVar.leB = null;
        }
    }

    private boolean aK(k kVar) {
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.e.e.biZ();
        com.tencent.mm.plugin.webview.c.b.b(kVar.iaJ, hashMap);
        a(kVar, "getSearchDisplayName:ok", hashMap);
        return true;
    }

    private boolean aL(k kVar) {
        this.fHM = false;
        ok okVar = new ok();
        okVar.bpu.userName = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "userName");
        okVar.bpu.appId = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "appId");
        okVar.bpu.bpw = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "relativeURL");
        okVar.bpu.bpy = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "appVersion", 0);
        okVar.bpu.scene = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "scene", 1018);
        okVar.bpu.beq = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "downloadURL");
        okVar.bpu.bpx = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "openType", 0);
        okVar.bpu.bpz = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "checkSumMd5");
        okVar.bpu.dAl = false;
        com.tencent.mm.sdk.c.a.nhr.z(okVar);
        if (okVar.bpv.bpI) {
            a(kVar, "openWeApp:ok", null);
        } else {
            a(kVar, "openWeApp:fail:" + be.ma(okVar.bpv.bpJ), null);
        }
        return true;
    }

    private boolean aM(k kVar) {
        this.fHM = false;
        v.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", new Object[]{kVar.iaJ});
        String n = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "userName");
        String n2 = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "relativeURL");
        int c = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "appVersion", 0);
        String n3 = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "searchId");
        String n4 = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "docId");
        int c2 = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "position", 1);
        int c3 = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "scene", BaseReportManager.MAX_READ_COUNT);
        ok okVar = new ok();
        if (c3 == 201) {
            okVar.bpu.scene = 1006;
        } else if (c3 == 3) {
            okVar.bpu.scene = 1005;
        } else {
            okVar.bpu.scene = BaseReportManager.MAX_READ_COUNT;
        }
        okVar.bpu.userName = n;
        okVar.bpu.bpw = n2;
        okVar.bpu.bpy = c;
        okVar.bpu.bpB = n3;
        okVar.bpu.bpC = n4;
        okVar.bpu.position = c2;
        okVar.bpu.bpD = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "versionType", 0);
        okVar.bpu.bpE = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "statSessionId");
        okVar.bpu.bpF = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "statKeywordId");
        okVar.bpu.bpG = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "adBuffer");
        okVar.bpu.bpH = com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "clickExtInfo");
        okVar.bpu.dAl = false;
        okVar.bpu.aWP = okVar.bpu.bpE + ":" + okVar.bpu.bpF + ":" + n3 + ":" + n4 + ":" + c2;
        com.tencent.mm.sdk.c.a.nhr.z(okVar);
        if (okVar.bpv.bpI) {
            a(kVar, "openWeAppPage:ok", null);
        } else {
            a(kVar, "openWeAppPage:fail:" + be.ma(okVar.bpv.bpJ), null);
        }
        return true;
    }

    private boolean aN(k kVar) {
        int c = com.tencent.mm.plugin.webview.c.c.c(kVar.iaJ, "logId", 0);
        v.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", new Object[]{Integer.valueOf(c), com.tencent.mm.plugin.webview.c.c.n(kVar.iaJ, "logString"), kVar.iaJ});
        afi com_tencent_mm_protocal_c_afi = new afi();
        com_tencent_mm_protocal_c_afi.mFd = c;
        com_tencent_mm_protocal_c_afi.mFl = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_afi.eet = 1;
        com_tencent_mm_protocal_c_afi.mFe = new com.tencent.mm.ba.b(r1.getBytes());
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ay();
        aVar.czo = new az();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.czm = 1802;
        com.tencent.mm.v.b Bv = aVar.Bv();
        ay ayVar = (ay) Bv.czk.czs;
        afh com_tencent_mm_protocal_c_afh = new afh();
        com_tencent_mm_protocal_c_afh.mio = com.tencent.mm.protocal.d.lWb;
        com_tencent_mm_protocal_c_afh.mip = com.tencent.mm.protocal.d.lWa;
        com_tencent_mm_protocal_c_afh.miq = com.tencent.mm.protocal.d.lWd;
        com_tencent_mm_protocal_c_afh.mir = com.tencent.mm.protocal.d.lWe;
        com_tencent_mm_protocal_c_afh.mis = com.tencent.mm.sdk.platformtools.u.bsY();
        com_tencent_mm_protocal_c_afh.mFk = (int) (System.currentTimeMillis() / 1000);
        ayVar.mbx = com_tencent_mm_protocal_c_afh;
        ayVar.mby.add(com_tencent_mm_protocal_c_afi);
        com.tencent.mm.v.u.a(Bv, new com.tencent.mm.v.u.a(this) {
            final /* synthetic */ i lpR;

            {
                this.lpR = r1;
            }

            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                v.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (!(i == 0 && i2 == 0)) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(457, 1, 1, false);
                }
                return 0;
            }
        });
        a(kVar, "reportWeAppSearchRealtime:ok", null);
        return true;
    }

    public final void az(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putBoolean("fts_key_new_query", z);
        try {
            if (this.leB != null) {
                this.leB.g(19, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void FF(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.leB != null) {
                this.leB.g(24, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }

    public final void bu(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.leB != null) {
                this.leB.g(25, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
        }
    }

    public final void FG(String str) {
        v.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", new Object[]{Integer.valueOf(0), str});
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", 0);
        bundle.putString("fts_key_data", str);
        try {
            if (this.leB != null) {
                this.leB.g(20, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
        }
    }

    public final void b(int i, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        try {
            if (this.leB != null) {
                this.leB.g(21, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
        }
    }

    public final boolean aO(k kVar) {
        boolean z = false;
        int i = be.getInt(be.be(kVar.iaJ.get("id")), 0);
        if (i <= 0) {
            a(kVar, "kvReport:fail", null);
        } else {
            boolean z2;
            String be = be.be(kVar.iaJ.get(Columns.VALUE));
            if (be.getInt(be.be(kVar.iaJ.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (be.getInt(be.be(kVar.iaJ.get("is_report_now")), 0) > 0) {
                z = true;
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(i, be, z, z2);
            a(kVar, "kvReport:ok", null);
        }
        return true;
    }

    private String Ra() {
        String str = null;
        if (this.leB == null) {
            v.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
        } else {
            try {
                str = this.leB.Ra();
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", new Object[]{e});
            }
        }
        return str;
    }

    private boolean bn(k kVar) {
        String str = (String) kVar.iaJ.get("username");
        if (!be.kS(str)) {
            rd rdVar = new rd();
            rdVar.dDS.username = str;
            com.tencent.mm.sdk.c.a.nhr.z(rdVar);
        }
        a(kVar, "forceUpdateWxaAttr:ok", null);
        return true;
    }

    private boolean aP(k kVar) {
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) kVar.iaJ.get("title"));
        bundle.putString("set_page_title_color", (String) kVar.iaJ.get("color"));
        try {
            this.leB.i(43, bundle);
            a(kVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", new Object[]{e});
            a(kVar, "setPageTitle:fail", null);
        }
        return true;
    }

    @Deprecated
    private boolean aQ(k kVar) {
        String str = (String) kVar.iaJ.get("color");
        if (be.kS(str)) {
            v.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(kVar, "setStatusBarStyle:fail", null);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.leB.i(i, Bundle.EMPTY);
                    a(kVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    v.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", new Object[]{e});
                    a(kVar, "setStatusBarStyle:fail", null);
                }
            } else {
                v.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(kVar, "setStatusBarStyle:fail", null);
            }
        }
        return true;
    }

    private boolean aR(k kVar) {
        try {
            this.leB.i(45, Bundle.EMPTY);
            a(kVar, "enableFullScreen:ok", null);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", new Object[]{e});
            a(kVar, "enableFullScreen:fail", null);
        }
        return true;
    }

    private boolean aS(k kVar) {
        String str = (String) kVar.iaJ.get("right");
        if (be.kS(str)) {
            a(kVar, "setNavigationBarButtons:fail", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String ma = be.ma(s.Ic(jSONObject.optString("iconData", "")));
                String optString2 = jSONObject.optString("color", "");
                Bundle bundle = new Bundle();
                if (!optBoolean) {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", ma);
                    bundle.putString("set_navigation_bar_buttons_text_color", optString2);
                }
                this.leB.i(44, bundle);
                a(kVar, "setNavigationBarButtons:ok", null);
            } catch (JSONException e) {
                v.e("MicroMsg.MsgHandler", "doSetNavigationBarButtons, get jsonObj from 'right', exception = %s, jsonString = %s", new Object[]{e, str});
                a(kVar, "setNavigationBarButtons:fail", null);
            } catch (Exception e2) {
                v.e("MicroMsg.MsgHandler", "doSetNavigationBarButtons, exception = %s", new Object[]{e2});
            }
        }
        return true;
    }

    public final boolean aT(k kVar) {
        try {
            this.leB.i(34, Bundle.EMPTY);
            a(kVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", new Object[]{e});
            a(kVar, "enablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean aU(k kVar) {
        try {
            this.leB.i(35, Bundle.EMPTY);
            a(kVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", new Object[]{e});
            a(kVar, "startPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean aV(k kVar) {
        try {
            this.leB.i(36, Bundle.EMPTY);
            a(kVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", new Object[]{e});
            a(kVar, "stopPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean blB() {
        try {
            this.leB.i(47, Bundle.EMPTY);
            a(this.lpf, "disablePullDownRefresh:ok", null);
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.lpf, "disablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean aW(k kVar) {
        this.fHM = false;
        String ma = be.ma((String) kVar.iaJ.get("placeholder"));
        int i = be.getInt((String) kVar.iaJ.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", ma);
            bundle.putInt("show_kb_max_length", i);
            this.leB.i(37, bundle);
            this.lpN = kVar;
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", new Object[]{e});
            a(this.leB, kVar, "showKeyboard:fail", null, true, true);
        }
        return true;
    }

    public final boolean aX(k kVar) {
        this.fHM = false;
        try {
            Bundle i = this.leB.i(79, new Bundle());
            Map hashMap = new HashMap();
            int i2 = i.getInt("height", 0);
            if (i2 > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bd.a.P(aa.getContext(), i2)));
                a(this.leB, kVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.leB, kVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e) {
            v.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", new Object[]{e});
            a(this.leB, kVar, "showSmileyPanel:fail", null, true, true);
        }
        return true;
    }

    public final boolean aY(k kVar) {
        String str = (String) kVar.iaJ.get("place");
        if (be.kS(str)) {
            a(kVar, "disableBounceScroll:fail", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(kVar, "disableBounceScroll:ok", null);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.leB.i(38, bundle);
                        a(kVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        v.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", new Object[]{e});
                        a(kVar, "disableBounceScroll:fail", null);
                    }
                }
            } catch (JSONException e2) {
                v.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", new Object[]{str});
                a(kVar, "disableBounceScroll:fail", null);
            }
        }
        return true;
    }

    public final boolean aZ(k kVar) {
        try {
            this.leB.i(39, new Bundle(0));
            a(kVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", new Object[]{e});
            a(kVar, "clearBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean ba(k kVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) kVar.iaJ.get("backgroundColor"));
        try {
            this.leB.i(72, bundle);
            a(kVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", new Object[]{e});
            a(kVar, "setBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bb(k kVar) {
        int i = be.getInt(be.be(kVar.iaJ.get("id")), 0);
        if (i <= 0) {
            a(kVar, "realtimeReport:fail", null);
            return true;
        }
        Object obj;
        String be = be.be(kVar.iaJ.get(Columns.VALUE));
        int i2 = be.getInt(be.be(kVar.iaJ.get(Columns.TYPE)), 0);
        com.tencent.mm.plugin.webview.d.e bib = a.ldT;
        if (ak.uz()) {
            long longValue;
            com.tencent.mm.plugin.webview.d.d bjf = com.tencent.mm.plugin.webview.e.e.bjf();
            Long l = (Long) bjf.ldL.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor rawQuery = bjf.cuX.rawQuery(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)});
                if (rawQuery == null) {
                    longValue = 0;
                } else if (rawQuery.getCount() <= 0 || !rawQuery.moveToFirst()) {
                    rawQuery.close();
                    longValue = 0;
                } else {
                    longValue = rawQuery.getLong(0);
                    rawQuery.close();
                }
            }
            if (longValue != 0 && longValue < be.Nh()) {
                ar arVar = bjf.ldL;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    throw new NullPointerException("key == null");
                }
                if (arVar.get(valueOf) != null) {
                    arVar.q(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < be.Nh()) {
                afi com_tencent_mm_protocal_c_afi = new afi();
                com_tencent_mm_protocal_c_afi.mFd = i;
                com_tencent_mm_protocal_c_afi.mFe = com.tencent.mm.ba.b.Ir(be);
                com_tencent_mm_protocal_c_afi.mFm = i2;
                bib.ldQ.add(com_tencent_mm_protocal_c_afi);
                obj = 1;
                if (obj == null) {
                    a(kVar, "realtimeReport:ok", null);
                } else {
                    a(kVar, "realtimeReport:fail", null);
                }
                return true;
            }
        }
        v.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
            a(kVar, "realtimeReport:fail", null);
        } else {
            a(kVar, "realtimeReport:ok", null);
        }
        return true;
    }

    public final boolean bc(k kVar) {
        String str = (String) kVar.iaJ.get("latitude");
        String str2 = (String) kVar.iaJ.get("longitude");
        final String str3 = (String) kVar.iaJ.get("destinationName");
        if (be.kS(str) || be.kS(str2)) {
            a(kVar, "openMapNavigateMenu:fail", null);
        } else {
            try {
                final double parseDouble = Double.parseDouble(str);
                final double parseDouble2 = Double.parseDouble(str2);
                final int i = be.getInt((String) kVar.iaJ.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.lyV.aJW);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(kVar, "openMapNavigateMenu:fail", null);
                } else {
                    final int aJ = aJ(kVar);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ i lpR;

                        public final void run() {
                            byte b = (byte) 0;
                            if (!(this.lpR.context == null || !(this.lpR.context instanceof Activity) || ((Activity) this.lpR.context).isFinishing())) {
                                l D = this.lpR.lpu;
                                Context h = this.lpR.context;
                                int i = i;
                                double d = parseDouble;
                                double d2 = parseDouble2;
                                String str = str3;
                                int i2 = aJ;
                                d anonymousClass1 = new d(this) {
                                    final /* synthetic */ AnonymousClass81 pQM;

                                    {
                                        this.pQM = r1;
                                    }

                                    public final void tj(int i) {
                                        an(i, "cancel");
                                    }

                                    public final void kR(int i) {
                                        an(i, "fail");
                                    }

                                    public final void hm(int i) {
                                        an(i, "ok");
                                    }

                                    private void an(int i, String str) {
                                        b a = this.pQM.lpR.th(i);
                                        if (a != null && a.lpf != null && a.leB != null) {
                                            i.a(this.pQM.lpR, this.pQM.lpR.leB, this.pQM.lpR.lpf, "openMapNavigateMenu:" + be.ah(str, "fail"));
                                        }
                                    }

                                    public final void tk(int i) {
                                        this.pQM.lpR.ti(i);
                                    }
                                };
                                if (!(h == null || !(h instanceof MMActivity) || ((MMActivity) h).isFinishing())) {
                                    D.lfB = i2;
                                    D.lra = true;
                                    D.lrb = i;
                                    D.lrd = new e(d, d2);
                                    D.lre = str;
                                    D.lrf = new WeakReference(h);
                                    D.lrg = anonymousClass1;
                                    D.cCR = null;
                                    if (D.cCR == null) {
                                        D.blG();
                                    } else {
                                        D.lrj = new com.tencent.mm.modelgeo.a.a(D) {
                                            final /* synthetic */ l lrl;

                                            {
                                                this.lrl = r1;
                                            }

                                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
                                                if (this.lrl.cCR != null) {
                                                    this.lrl.cCR.c(this);
                                                }
                                                if (z) {
                                                    this.lrl.lrc = new e((double) f2, (double) f);
                                                    if (this.lrl.gXm != null) {
                                                        this.lrl.lrh = new com.tencent.mm.modelgeo.b.a(this) {
                                                            final /* synthetic */ AnonymousClass2 lrm;

                                                            {
                                                                this.lrm = r1;
                                                            }

                                                            public final void b(Addr addr) {
                                                                if (this.lrm.lrl.lrc != null && this.lrm.lrl.lrh != null) {
                                                                    this.lrm.lrl.lrc.lrn = addr.FV();
                                                                    this.lrm.lrl.blG();
                                                                }
                                                            }
                                                        };
                                                        this.lrl.gXm.a((double) f2, (double) f, this.lrl.lrh);
                                                        return false;
                                                    }
                                                }
                                                this.lrl.blG();
                                                return false;
                                            }
                                        };
                                        if (D.gXm != null) {
                                            D.lri = new com.tencent.mm.modelgeo.b.a(D) {
                                                final /* synthetic */ l lrl;

                                                {
                                                    this.lrl = r1;
                                                }

                                                public final void b(Addr addr) {
                                                    if (this.lrl.lrd != null && this.lrl.lri != null) {
                                                        this.lrl.lrd.lrn = addr.FV();
                                                    }
                                                }
                                            };
                                            D.gXm.a(D.lrd.latitude, D.lrd.longitude, D.lri);
                                        }
                                        ad.o(new Runnable(D) {
                                            final /* synthetic */ l lrl;

                                            {
                                                this.lrl = r1;
                                            }

                                            public final void run() {
                                                if (this.lrl.lrf != null && this.lrl.lrf.get() != null) {
                                                    Toast.makeText((Context) this.lrl.lrf.get(), 2131234959, 0).show();
                                                }
                                            }
                                        });
                                        D.cCR.b(D.lrj);
                                        ad.g(D.lrk, 4000);
                                    }
                                    b = (byte) 1;
                                }
                            }
                            if (b == (byte) 0) {
                                b a = this.lpR.th(aJ);
                                if (a.leB != null && a.lpf != null) {
                                    i.a(this.lpR, a.leB, a.lpf, "openMapNavigateMenu:fail");
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(kVar, "openMapNavigateMenu:fail", null);
            }
        }
        return true;
    }

    public final Bundle blC() {
        Bundle bundle = null;
        try {
            bundle = this.leB.i(33, null);
        } catch (Throwable e) {
            v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        v.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", new Object[]{bundle});
        return bundle;
    }

    private boolean bd(k kVar) {
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        hashMap.put("callbackid", Integer.valueOf(123123));
        a(kVar, "ok", hashMap);
        return true;
    }

    private boolean be(k kVar) {
        boolean z = false;
        String str = (String) kVar.iaJ.get("operationType");
        String str2 = (String) kVar.iaJ.get("dataUrl");
        m.a(kVar.lqY, false, null, "");
        if (be.kS(str) || be.kS(str2)) {
            a(kVar, "operateMusicPlayer:fail", null);
        } else if (str.equalsIgnoreCase("play")) {
            String str3 = (String) kVar.iaJ.get("title");
            String str4 = (String) kVar.iaJ.get("singer");
            String str5 = (String) kVar.iaJ.get("epname");
            str = (String) kVar.iaJ.get("coverImgUrl");
            String str6 = (String) kVar.iaJ.get("lowbandUrl");
            String str7 = (String) kVar.iaJ.get("webUrl");
            kVar.iaJ.get("lyric");
            v.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str3, str4, str5, str, str2, str6, str7, ""});
            if (be.kS(str3) || be.kS(str4) || be.kS(str5) || be.kS(str) || be.kS(str6) || be.kS(str2) || be.kS(str7)) {
                a(kVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.ai.b.HB();
                str5 = str2.hashCode();
                String str8 = com.tencent.mm.compatible.util.e.cnj;
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                com.tencent.mm.ai.b.b(com.tencent.mm.ai.b.a(7, str, str3, str4, str7, str6, str2, str5, str8, stringBuilder.append(com.tencent.mm.model.c.wP()).append(str.hashCode()).toString(), ""));
                a(kVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.ai.c.js(str2) && com.tencent.mm.ai.b.HD() && !com.tencent.mm.ai.b.HC()) {
                com.tencent.mm.ai.b.rc();
                z = true;
            }
            if (z) {
                a(kVar, "operateMusicPlayer:ok", null);
            } else {
                a(kVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.ai.c.js(str2) && com.tencent.mm.ai.b.HC()) {
                com.tencent.mm.ai.b.rb();
                z = true;
            }
            if (z) {
                a(kVar, "operateMusicPlayer:ok", null);
            } else {
                a(kVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            int i = be.getInt(be.be(kVar.iaJ.get("position")), -1) * BaseReportManager.MAX_READ_COUNT;
            if (com.tencent.mm.ai.c.js(str2)) {
                z = com.tencent.mm.ai.b.fR(i);
            }
            if (z) {
                a(kVar, "operateMusicPlayer:ok", null);
            } else {
                a(kVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            boolean z2;
            if (com.tencent.mm.ai.c.js(str2) && com.tencent.mm.ai.b.HD()) {
                com.tencent.mm.ai.b.HB();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                a(kVar, "operateMusicPlayer:ok", null);
            } else {
                a(kVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(kVar, "operateMusicPlayer:fail", null);
        }
        return true;
    }

    private boolean bf(k kVar) {
        String str = (String) kVar.iaJ.get("dataUrl");
        m.a(kVar.lqY, false, null, (String) kVar.iaJ.get("appId"));
        if (be.kS(str)) {
            a(kVar, "getMusicPlayerState:fail_dataUrl_null", null);
        } else {
            v.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", new Object[]{str, r1});
            ajr HE = com.tencent.mm.ai.b.HE();
            if (HE == null || !HE.mKc.equals(str)) {
                a(kVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                int i2;
                com.tencent.mm.ai.d HF = com.tencent.mm.ai.b.HF();
                if (HF != null) {
                    i = HF.lr;
                    i2 = HF.kB;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (HF == null || i < 0 || i2 < 0) {
                    a(kVar, "getMusicPlayerState:fail", null);
                } else {
                    i /= BaseReportManager.MAX_READ_COUNT;
                    i2 /= BaseReportManager.MAX_READ_COUNT;
                    int i3 = HF.mStatus;
                    int i4 = HF.cSU;
                    Map hashMap = new HashMap();
                    hashMap.put("duration", Integer.valueOf(i));
                    hashMap.put("currentPosition", Integer.valueOf(i2));
                    hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(kVar, "getMusicPlayerState:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bg(k kVar) {
        String str = (String) kVar.iaJ.get("localId");
        if (be.kS(str)) {
            a(kVar, "getLocalImgData:fail_invaild_localid", null);
        } else {
            x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
            if (!(DW == null || DW.lek == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(DW.lek);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    v.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", new Object[]{Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length())});
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(kVar, "getLocalImgData:ok", hashMap);
                    decodeFile.recycle();
                }
            }
            a(kVar, "getLocalImgData:fail", null);
        }
        return true;
    }

    private boolean bh(k kVar) {
        int i = 0;
        this.fHM = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = be.getInt(kVar.iaJ.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            v.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", new Object[]{Integer.valueOf(i2)});
            if (-1 == bundle.getInt("scene")) {
                a(kVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.leB.i(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(kVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                        case JsApiChooseVideo.CTRL_INDEX /*36*/:
                        case JsApiGetLocation.CTRL_INDEX /*37*/:
                        case aq.CTRL_INDEX /*38*/:
                        case y.CTRL_INDEX /*39*/:
                        case 45:
                            break;
                        case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            a(kVar, "doExposePreparation fail:unknown scene", null);
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("content");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    hashMap.put("content", jSONArray.toString());
                    a(kVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            v.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(kVar, "doExposePreparation fail", null);
        }
        return true;
    }

    private boolean bi(k kVar) {
        this.fHM = false;
        String trim = kVar.iaJ.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(kVar, "openSecurityView fail, scene error : " + trim, null);
        } else if (kVar.iaJ.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(kVar.iaJ.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(536870912);
                com.tencent.mm.ay.c.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(kVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                v.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(kVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(kVar, "openSecurityView fail, no userData", null);
        }
        return true;
    }

    private boolean bj(k kVar) {
        String FA = FA(Ra());
        String rJ = com.tencent.mm.compatible.d.p.rJ();
        if (be.kS(rJ) || be.kS(FA)) {
            a(kVar, "getOpenDeviceId:fail", null);
        } else {
            FA = com.tencent.mm.sdk.platformtools.z.Kg(com.tencent.mm.sdk.platformtools.z.Kg(FA + rJ));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", FA);
            a(kVar, "getOpenDeviceId:ok", hashMap);
        }
        return true;
    }

    private boolean bk(k kVar) {
        try {
            Bundle i = this.leB.i(90000, null);
            if (i != null) {
                String[] stringArray = i.getStringArray("webview_get_route_url_list");
                int i2 = i.getInt("webview_get_route_url_geta8key_scene");
                String str = "MicroMsg.MsgHandler";
                String str2 = "routeUrl length = %d, scene = %d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(stringArray != null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i2);
                v.i(str, str2, objArr);
                if (stringArray != null && stringArray.length > 0) {
                    Map hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray();
                    for (Object put : stringArray) {
                        jSONArray.put(put);
                    }
                    hashMap.put("urls", jSONArray.toString());
                    hashMap.put("scene", Integer.valueOf(i2));
                    a(kVar, "getRouteUrl:ok", hashMap);
                    return true;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", new Object[]{e.getMessage()});
        }
        a(kVar, "getRouteUrl:fail", null);
        return true;
    }

    public final synchronized boolean bl(k kVar) {
        v.i("MicroMsg.MsgHandler", "doWNNoteInitData");
        com.tencent.mm.plugin.webview.f.b.lsB = be.n(kVar.iaJ.get("webview_instance_id"), -1);
        Map hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Bundle bundle = new Bundle();
        hashMap.put("html", "");
        if (com.tencent.mm.plugin.webview.e.e.bjb().lsA) {
            hashMap.put("title", "");
            hashMap.put("data", jSONArray);
            a(kVar, "ok", hashMap);
            try {
                if (this.leB != null) {
                    bundle.putBoolean("showVKB", true);
                    this.leB.g(42, bundle);
                }
            } catch (RemoteException e) {
                v.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart exception" + e.getMessage());
            }
        } else {
            hashMap.put("ret", Integer.valueOf(0));
            if (com.tencent.mm.plugin.webview.e.e.bjb().lsx != null) {
                com.tencent.mm.plugin.webview.e.e.bjb().lsy = null;
                com.tencent.mm.plugin.webview.e.e.bjb().lsC = false;
                v.i("MicroMsg.MsgHandler", "WNNote:htmldata = %s", new Object[]{com.tencent.mm.plugin.webview.e.e.bjb().lsx.toString()});
                hashMap.put("html", com.tencent.mm.plugin.webview.e.e.bjb().lsw);
                hashMap.put("data", com.tencent.mm.plugin.webview.e.e.bjb().lsx);
                a(kVar, "ok", hashMap);
                try {
                    if (this.leB != null) {
                        this.leB.g(45, null);
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("showVKB", false);
                        bundle2.putString("maxhtmlid", com.tencent.mm.plugin.webview.e.e.bjb().bjI);
                        this.leB.g(42, bundle2);
                    }
                } catch (RemoteException e2) {
                    v.w("MicroMsg.MsgHandler", "InitData_ChangeSatusEdited exception" + e2.getMessage());
                }
            } else {
                com.tencent.mm.plugin.webview.e.e.bjb().lsy = kVar;
            }
            try {
                if (this.leB != null) {
                    this.leB.g(41, null);
                }
            } catch (RemoteException e22) {
                v.w("MicroMsg.MsgHandler", "InitData_AC_ON_WNNOTE_CHANGE_STATUS_EDITING exception" + e22.getMessage());
            }
        }
        return true;
    }

    public final void M(Bundle bundle) {
        v.i("MicroMsg.MsgHandler", "WNNote:WNJSHandlerInsert bundle: %s", new Object[]{bundle.toString()});
        try {
            if (this.leB != null) {
                this.leB.g(26, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "WNJSHandlerInsert exception" + e.getMessage());
        }
    }

    public final void N(Bundle bundle) {
        v.i("MicroMsg.MsgHandler", "WNJSHandlerLoadingFinish");
        try {
            if (this.leB != null) {
                this.leB.g(45, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "WNJSHandlerLoadingFinish exception" + e.getMessage());
        }
    }

    public final void O(Bundle bundle) {
        v.i("MicroMsg.MsgHandler", "WNJSHandlerOperation");
        try {
            if (this.leB != null) {
                this.leB.g(46, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "WNJSHandlerOperation exception" + e.getMessage());
        }
    }
}
