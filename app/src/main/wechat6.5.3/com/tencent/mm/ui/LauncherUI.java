package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.l;
import android.support.v7.app.ActionBar;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.ae.m;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.y;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.cq;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.et;
import com.tencent.mm.e.a.gz;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.po;
import com.tencent.mm.e.a.x;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.network.b;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k.a.a.o;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.WelcomeSelectView;
import com.tencent.mm.ui.account.WelcomeView;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.ui.chatting.InitCallBackImageView;
import com.tencent.mm.ui.chatting.InitCallBackLayout;
import com.tencent.mm.ui.chatting.eg;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.v.k;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI extends MMFragmentActivity implements com.tencent.mm.app.g.a, com.tencent.mm.sdk.h.j.b {
    public static long nBA;
    private static ArrayList<LauncherUI> nBf = new ArrayList();
    private static boolean nBg = true;
    public static Boolean nBw = Boolean.valueOf(false);
    public static Boolean nBx = Boolean.valueOf(false);
    private static HashMap<String, Integer> nCq;
    private ActionBar FG;
    final HashMap<String, Object> bXL = new HashMap();
    private String bkp = null;
    private final long deb = 180000;
    private View dtW;
    private ProgressDialog dwR;
    private Intent ens = null;
    private LayoutInflater gwU;
    private View iLm;
    private TextView iLn;
    private EditText iLo;
    private h iLp;
    private boolean iLq;
    private boolean ijq = true;
    private final long jUw = 300;
    private long jUx = SystemClock.elapsedRealtime();
    private int jya = 0;
    private View lvB;
    com.tencent.mm.sdk.c.c nAE = new com.tencent.mm.sdk.c.c<hi>(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r2;
            this.nhz = hi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.nCs.nBd = true;
            ad.B(this.nCs.nBD);
            ad.o(this.nCs.nBD);
            return true;
        }
    };
    private a nBB = a.ACTIVITY_CREATE;
    private boolean nBC = u.bsU();
    private Runnable nBD = new Runnable(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r5 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
            r9 = 0;
            r3 = 1;
            r2 = 0;
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.ww();
            if (r0 != 0) goto L_0x0019;
        L_0x000f:
            r0 = "MicroMsg.LauncherUI";
            r1 = "Account not Ready!!!";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        L_0x0018:
            return;
        L_0x0019:
            r0 = r10.nCs;
            r0 = r0.nBr;
            if (r0 != 0) goto L_0x002b;
        L_0x0021:
            r0 = "MicroMsg.LauncherUI";
            r1 = "set tag job, but tab view is null";
            com.tencent.mm.sdk.platformtools.v.w(r0, r1);
            goto L_0x0018;
        L_0x002b:
            r0 = com.tencent.mm.model.ak.uz();
            if (r0 != 0) goto L_0x00a8;
        L_0x0031:
            r0 = "MicroMsg.UnreadCountHelper";
            r1 = "getFindTabUnreadCount, but mmcore not ready";
            com.tencent.mm.sdk.platformtools.v.w(r0, r1);
            r1 = r2;
        L_0x003b:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r2);
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.vs(r1);
            if (r1 > 0) goto L_0x0068;
        L_0x004f:
            r0 = com.tencent.mm.aw.a.bmn();
            if (r0 == 0) goto L_0x0068;
        L_0x0055:
            r0 = com.tencent.mm.ar.l.KE();
            r0 = r0.Kw();
            if (r0 <= 0) goto L_0x0068;
        L_0x005f:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
        L_0x0068:
            if (r1 > 0) goto L_0x00ff;
        L_0x006a:
            r0 = com.tencent.mm.model.k.xQ();
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x00ff;
        L_0x0071:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = 68384; // 0x10b20 float:9.5826E-41 double:3.3786E-319;
            r0 = r0.get(r4, r9);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.platformtools.t.a(r0, r3);
            if (r0 == 0) goto L_0x00ff;
        L_0x0087:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = 68377; // 0x10b19 float:9.5817E-41 double:3.37827E-319;
            r0 = r0.get(r4, r9);
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.platformtools.t.kS(r0);
            if (r0 != 0) goto L_0x00ff;
        L_0x009d:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
            goto L_0x0018;
        L_0x00a8:
            r0 = com.tencent.mm.model.k.xJ();
            r0 = r0 & r5;
            if (r0 != 0) goto L_0x0399;
        L_0x00af:
            r0 = com.tencent.mm.model.g.xD();
            r0 = r0 + 0;
        L_0x00b5:
            r1 = com.tencent.mm.model.k.xQ();
            r1 = r1 & 512;
            if (r1 != 0) goto L_0x0396;
        L_0x00bd:
            r1 = com.tencent.mm.aw.a.bmn();
            if (r1 != 0) goto L_0x0396;
        L_0x00c3:
            r1 = com.tencent.mm.ar.l.KE();
            r1 = r1.Kw();
            r1 = r1 + 0;
        L_0x00cd:
            r4 = com.tencent.mm.model.k.xQ();
            r4 = r4 & 256;
            if (r4 != 0) goto L_0x00e9;
        L_0x00d5:
            r4 = com.tencent.mm.ar.l.KF();
            if (r4 == 0) goto L_0x00e0;
        L_0x00db:
            r4 = r4.Kw();
            r1 = r1 + r4;
        L_0x00e0:
            r4 = com.tencent.mm.pluginsdk.j.a.bmq();
            r4 = r4.aNH();
            r1 = r1 + r4;
        L_0x00e9:
            r0 = r0 + r1;
            r1 = com.tencent.mm.model.k.xQ();
            r1 = r1 & r5;
            if (r1 != 0) goto L_0x00fc;
        L_0x00f1:
            r1 = com.tencent.mm.pluginsdk.j.ak.lyg;
            if (r1 == 0) goto L_0x00fc;
        L_0x00f5:
            r1 = com.tencent.mm.pluginsdk.j.ak.lyg;
            r1 = r1.Kw();
            r0 = r0 + r1;
        L_0x00fc:
            r1 = r0;
            goto L_0x003b;
        L_0x00ff:
            if (r1 > 0) goto L_0x01a4;
        L_0x0101:
            r0 = com.tencent.mm.h.j.sU();
            r4 = "JDEntranceConfigName";
            r0 = r0.getValue(r4);
            r4 = com.tencent.mm.h.j.sU();
            r5 = "JDEntranceConfigIconUrl";
            r4 = r4.getValue(r5);
            r5 = com.tencent.mm.h.j.sU();
            r6 = "JDEntranceConfigJumpUrl";
            r5 = r5.getValue(r6);
            r6 = "MicroMsg.LauncherUI";
            r7 = new java.lang.StringBuilder;
            r8 = "jd tryshow configName ";
            r7.<init>(r8);
            r7 = r7.append(r0);
            r8 = " iconUrl ";
            r7 = r7.append(r8);
            r7 = r7.append(r4);
            r8 = " jumpUrl ";
            r7 = r7.append(r8);
            r7 = r7.append(r5);
            r7 = r7.toString();
            com.tencent.mm.sdk.platformtools.v.i(r6, r7);
            r0 = com.tencent.mm.platformtools.t.kS(r0);
            if (r0 != 0) goto L_0x01a4;
        L_0x0154:
            r0 = com.tencent.mm.platformtools.t.kS(r4);
            if (r0 != 0) goto L_0x01a4;
        L_0x015a:
            r0 = com.tencent.mm.platformtools.t.kS(r5);
            if (r0 != 0) goto L_0x01a4;
        L_0x0160:
            r0 = com.tencent.mm.pluginsdk.j.al.lyl;
            if (r0 == 0) goto L_0x01a4;
        L_0x0164:
            r4 = r0.aZk();
            r5 = "MicroMsg.LauncherUI";
            r6 = new java.lang.StringBuilder;
            r7 = "jdshowFriend ";
            r6.<init>(r7);
            r6 = r6.append(r4);
            r6 = r6.toString();
            com.tencent.mm.sdk.platformtools.v.i(r5, r6);
            if (r4 == 0) goto L_0x01a4;
        L_0x0180:
            r0 = r0.aZs();
            r4 = r0.Iz();
            if (r4 == 0) goto L_0x019b;
        L_0x018a:
            r0 = r0.aZc();
            if (r0 != 0) goto L_0x019b;
        L_0x0190:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
            goto L_0x0018;
        L_0x019b:
            r0 = "MicroMsg.LauncherUI";
            r4 = "jd time is not start or jd time isExpire";
            com.tencent.mm.sdk.platformtools.v.i(r0, r4);
        L_0x01a4:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = 589825; // 0x90001 float:8.26521E-40 double:2.914123E-318;
            r5 = java.lang.Boolean.valueOf(r2);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x01c7;
        L_0x01be:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
        L_0x01c7:
            r0 = com.tencent.mm.h.j.sU();
            r4 = "WCOEntranceSwitch";
            r0 = r0.getInt(r4, r2);
            if (r0 <= 0) goto L_0x0352;
        L_0x01d4:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r3);
            r0.a(r4, r5);
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING;
            r5 = "";
            r0 = r0.get(r4, r5);
            r0 = (java.lang.String) r0;
            r4 = r10.nCs;
            r4 = r4.nBr;
            r4 = r4.byK();
            if (r4 != 0) goto L_0x0250;
        L_0x0202:
            if (r1 > 0) goto L_0x0250;
        L_0x0204:
            com.tencent.mm.model.ak.yW();
            r1 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT;
            r5 = java.lang.Integer.valueOf(r2);
            r1 = r1.get(r4, r5);
            r1 = (java.lang.Integer) r1;
            r1 = r1.intValue();
            r4 = com.tencent.mm.h.j.sU();
            r5 = "WCOEntranceRedDot";
            r4 = r4.getInt(r5, r2);
            if (r1 < r4) goto L_0x0247;
        L_0x0228:
            com.tencent.mm.model.ak.yW();
            r1 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r2);
            r1 = r1.get(r4, r5);
            r1 = (java.lang.Boolean) r1;
            r1 = r1.booleanValue();
            if (r1 == r3) goto L_0x0247;
        L_0x0241:
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 != 0) goto L_0x0250;
        L_0x0247:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
        L_0x0250:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r1 = com.tencent.mm.storage.t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING;
            r0 = r0.get(r1, r9);
            r0 = (java.lang.String) r0;
            r1 = "";
            r1 = com.tencent.mm.platformtools.t.ah(r0, r1);
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN;
            r0 = r0.get(r4, r9);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.platformtools.t.a(r0, r2);
            r0 = java.lang.Boolean.valueOf(r0);
            r4 = ",";
            r4 = r1.split(r4);
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x02b3;
        L_0x028a:
            r0 = com.tencent.mm.platformtools.t.kS(r1);
            if (r0 != 0) goto L_0x02b3;
        L_0x0290:
            r0 = r4.length;
            if (r0 <= r3) goto L_0x02b3;
        L_0x0293:
            r0 = r4.length;
            r0 = r0 + -1;
            r0 = r4[r0];
            r4 = "showed";
            r0 = r0.equals(r4);
            if (r0 != 0) goto L_0x02b3;
        L_0x02a1:
            r0 = r10.nCs;
            r0 = r0.nBM;
            r4 = 2;
            if (r0 == r4) goto L_0x0364;
        L_0x02aa:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
        L_0x02b3:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r1 = 40;
            r0 = r0.getInt(r1, r2);
            r1 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
            r0 = r0 & r1;
            if (r0 != 0) goto L_0x0393;
        L_0x02c5:
            r1 = r3;
        L_0x02c6:
            r0 = com.tencent.mm.h.j.sU();
            r4 = "VoiceprintEntry";
            r0 = r0.getValue(r4);
            r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r2);
            if (r0 != r3) goto L_0x0390;
        L_0x02d7:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN;
            r5 = java.lang.Boolean.valueOf(r3);
            r0 = r0.get(r4, r5);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
        L_0x02ee:
            if (r0 == 0) goto L_0x0304;
        L_0x02f0:
            if (r1 == 0) goto L_0x0304;
        L_0x02f2:
            r0 = "MicroMsg.LauncherUI";
            r1 = "show voiceprint dot";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iH(r3);
        L_0x0304:
            r0 = com.tencent.mm.model.k.yo();
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x034b;
        L_0x030e:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r1 = 340232; // 0x53108 float:4.76767E-40 double:1.68097E-318;
            r4 = java.lang.Boolean.valueOf(r2);
            r0 = r0.get(r1, r4);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x0386;
        L_0x0328:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r1 = 340231; // 0x53107 float:4.76765E-40 double:1.680964E-318;
            r4 = java.lang.Boolean.valueOf(r2);
            r0 = r0.get(r1, r4);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x0386;
        L_0x0342:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r2);
        L_0x034b:
            r0 = r10.nCs;
            r0.nBd = r2;
            goto L_0x0018;
        L_0x0352:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r1 = com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN;
            r4 = java.lang.Boolean.valueOf(r2);
            r0.a(r1, r4);
            goto L_0x0250;
        L_0x0364:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = com.tencent.mm.storage.t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING;
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r1 = r5.append(r1);
            r5 = ",showed";
            r1 = r1.append(r5);
            r1 = r1.toString();
            r0.a(r4, r1);
            goto L_0x02b3;
        L_0x0386:
            r0 = r10.nCs;
            r0 = r0.nBr;
            r0.iG(r3);
            goto L_0x034b;
        L_0x0390:
            r0 = r2;
            goto L_0x02ee;
        L_0x0393:
            r1 = r2;
            goto L_0x02c6;
        L_0x0396:
            r1 = r2;
            goto L_0x00cd;
        L_0x0399:
            r0 = r2;
            goto L_0x00b5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.23.run():void");
        }

        public final String toString() {
            return super.toString() + "|setTagRunnable";
        }
    };
    private long nBE = 0;
    private View nBF;
    private ImageView nBG;
    private View nBH;
    private MenuItem nBI;
    private MenuItem nBJ;
    private long nBK = 0;
    private b nBL = new b();
    public int nBM = -1;
    private int nBN = -1;
    public VoiceSearchLayout nBO;
    private com.tencent.mm.sdk.c.c nBP = new com.tencent.mm.sdk.c.c<bt>(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (this.nCs.nBF != null) {
                this.nCs.nBF.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass59 nCG;

                    {
                        this.nCG = r1;
                    }

                    public final void run() {
                        this.nCG.nCs.iM(true);
                    }

                    public final String toString() {
                        return super.toString() + "|updatePlusMenuNewTips";
                    }
                });
            }
            this.nCs.bzt();
            return false;
        }
    };
    private com.tencent.mm.p.a.a nBQ = new com.tencent.mm.p.a.a(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final void er(int i) {
            if (i == 262145 || i == 262156 || i == 262152) {
                this.nCs.bzy();
            }
            if (i == 262147 || i == 262149) {
                this.nCs.bzy();
            }
        }

        public final void es(int i) {
            if (i == 266241) {
                this.nCs.bzy();
            }
            if (i == 266244) {
                com.tencent.mm.p.c.us().az(262147, 266241);
                com.tencent.mm.p.c.us().az(262149, 266241);
                this.nCs.bzy();
            }
        }

        public final void a(com.tencent.mm.storage.t.a aVar) {
        }
    };
    private com.tencent.mm.sdk.h.j.b nBR = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            int az = t.az(obj);
            v.d("MicroMsg.LauncherUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(az), jVar);
            ak.yW();
            if (jVar != com.tencent.mm.model.c.vf() || az <= 0) {
                v.e("MicroMsg.LauncherUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(az), jVar);
                return;
            }
            this.nCs.bzt();
            if (az == 143618) {
                this.nCs.bzK();
            } else if (az == 204817 || az == 204820) {
                this.nCs.bzy();
            }
        }
    };
    private com.tencent.mm.sdk.c.c nBS = new com.tencent.mm.sdk.c.c<po>(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r2;
            this.nhz = po.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.v("MicroMsg.LauncherUI", "appTagUnreadChangeListener, event:%s", ((po) bVar).toString());
            this.nCs.bzt();
            return false;
        }
    };
    private String nBT;
    IdleHandler nBU = new IdleHandler(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final boolean queueIdle() {
            ak.yW();
            if (t.f((Integer) com.tencent.mm.model.c.vf().get(15, null)) == 0) {
                v.e("MicroMsg.LauncherUI", "not init finish , do not post sync task");
            } else {
                String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
                if (ak.uN() || !A.equals(SQLiteDatabase.KeyEmpty)) {
                    ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                        final /* synthetic */ AnonymousClass4 nCt;

                        {
                            this.nCt = r1;
                        }

                        public final void a(e eVar) {
                        }
                    }, "launch normal"), 0);
                }
                com.tencent.mm.sdk.i.e.a(new Runnable(new y(this.nCs)) {
                    final /* synthetic */ y bYy;

                    {
                        this.bYy = r1;
                    }

                    public final void run() {
                        String str;
                        com.tencent.mm.network.t tVar;
                        long Ni = t.Ni();
                        Process.setThreadPriority(10);
                        y yVar = this.bYy;
                        int i = f.aPW;
                        String rK = p.rK();
                        int i2 = d.lWh;
                        String str2 = "0";
                        String bsY = u.bsY();
                        int i3 = yVar.context.getSharedPreferences(aa.bti(), 0).getInt("last_reportdevice_channel", 0);
                        int i4 = yVar.context.getSharedPreferences(aa.bti(), 0).getInt("last_reportdevice_clientversion", 0);
                        if (i3 == 0 && i4 == 0) {
                            i4 = 0;
                        } else if (i3 == i && i4 == i2) {
                            str = null;
                            v.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                            if (t.kS(str)) {
                                tVar = null;
                                try {
                                    tVar = b.a(str, null);
                                    tVar.setConnectTimeout(10000);
                                    tVar.setReadTimeout(10000);
                                    tVar.connect();
                                    if (tVar.getResponseCode() == 200) {
                                        y yVar2 = this.bYy;
                                        int i5 = f.aPW;
                                        int i6 = d.lWh;
                                        SharedPreferences sharedPreferences = yVar2.context.getSharedPreferences(aa.bti(), 0);
                                        sharedPreferences.edit().putInt("last_reportdevice_channel", i5).commit();
                                        sharedPreferences.edit().putInt("last_reportdevice_clientversion", i6).commit();
                                    }
                                    v.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(t.ay(Ni)), Integer.valueOf(i), str);
                                } catch (Throwable e) {
                                    v.a("MicroMsg.StartupReport", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    v.e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                                }
                                if (tVar != null) {
                                    tVar.dmc.disconnect();
                                }
                            }
                        } else {
                            i4 = 1;
                        }
                        str = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + f.aPW + "&deviceid=" + rK + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + bsY + "&installtype=" + i4;
                        v.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                        if (t.kS(str)) {
                            tVar = null;
                            tVar = b.a(str, null);
                            tVar.setConnectTimeout(10000);
                            tVar.setReadTimeout(10000);
                            tVar.connect();
                            if (tVar.getResponseCode() == 200) {
                                y yVar22 = this.bYy;
                                int i52 = f.aPW;
                                int i62 = d.lWh;
                                SharedPreferences sharedPreferences2 = yVar22.context.getSharedPreferences(aa.bti(), 0);
                                sharedPreferences2.edit().putInt("last_reportdevice_channel", i52).commit();
                                sharedPreferences2.edit().putInt("last_reportdevice_clientversion", i62).commit();
                            }
                            v.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(t.ay(Ni)), Integer.valueOf(i), str);
                            if (tVar != null) {
                                tVar.dmc.disconnect();
                            }
                        }
                    }
                }, "StartupReport_report");
                com.tencent.mm.booter.p.onCreate(true);
                LauncherUI.bzO();
                com.tencent.mm.plugin.report.service.e.aKA();
                com.tencent.mm.ae.m.c cVar = m.Gy().cNO;
                if (cVar.cOd.size() <= 0 && cVar.cOc.size() <= 0) {
                    ak.yW();
                    A = (String) com.tencent.mm.model.c.vf().get(348177, SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    String str = (String) com.tencent.mm.model.c.vf().get(348176, SQLiteDatabase.KeyEmpty);
                    if (!be.kS(A)) {
                        synchronized (cVar) {
                            for (String ja : A.split("-")) {
                                b ja2 = com.tencent.mm.ae.m.c.ja(ja);
                                if (ja2 != null) {
                                    cVar.cOd.add(ja2);
                                }
                            }
                        }
                    }
                    if (!be.kS(str)) {
                        synchronized (cVar) {
                            for (String iZ : str.split("-")) {
                                b iZ2 = com.tencent.mm.ae.m.c.iZ(iZ);
                                if (iZ2 != null) {
                                    cVar.cOc.add(iZ2);
                                }
                            }
                        }
                    }
                    v.i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", Integer.valueOf(cVar.cOc.size()), Integer.valueOf(cVar.cOd.size()));
                }
                cVar.GB();
                Looper.myQueue().removeIdleHandler(this.nCs.nBU);
            }
            return false;
        }
    };
    private int nBV = -1;
    com.tencent.mm.sdk.c.c nBW = new com.tencent.mm.sdk.c.c<cq>(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r2;
            this.nhz = cq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.nCs.nBd = true;
            ad.B(this.nCs.nBD);
            ad.o(this.nCs.nBD);
            return true;
        }
    };
    private com.tencent.mm.protocal.b.a.b nBX = null;
    private com.tencent.mm.sdk.c.c nBY = new com.tencent.mm.sdk.c.c<gz>(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r2;
            this.nhz = gz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            gz gzVar = (gz) bVar;
            if (gzVar == null || gzVar.bgF == null || gzVar.bgF.bgG == null) {
                v.i("MicroMsg.LauncherUI", "summeralert event is illegal event[%s]", gzVar);
            } else {
                v.i("MicroMsg.LauncherUI", "summeralert event launcherUIStatus[%s], tid[%d]", this.nCs.nBB, Long.valueOf(Thread.currentThread().getId()));
                if (a.ACTIVITY_RESUME != this.nCs.nBB) {
                    this.nCs.nBX = gzVar.bgF.bgG;
                } else {
                    this.nCs.nBX = null;
                    this.nCs.a(gzVar.bgF.bgG);
                }
            }
            return false;
        }
    };
    private int nBZ = -1;
    private boolean nBb;
    private boolean nBc;
    private boolean nBd;
    boolean nBe = true;
    public boolean nBh;
    private com.tencent.mm.v.e nBi;
    private boolean nBj;
    private boolean nBk;
    private boolean nBl;
    private HashSet<i> nBm = new HashSet();
    private WelcomeView nBn = null;
    public boolean nBo = false;
    public boolean nBp = false;
    private boolean nBq = false;
    private c nBr;
    private CustomViewPager nBs;
    private c nBt;
    private t nBu;
    private boolean nBv = true;
    private final long nBy = 432000000;
    private final long nBz = 604800000;
    private int nCa = -1;
    private View nCb;
    private View nCc;
    private com.tencent.mm.ui.chatting.ChattingUI.a nCd;
    private TestTimeForChatting nCe;
    private OnLayoutChangedLinearLayout nCf;
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a nCg = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final void bzP() {
            if (this.nCs.nCn == null) {
                this.nCs.nCn = AnimationUtils.loadAnimation(this.nCs, com.tencent.mm.ui.MMFragmentActivity.a.nFE);
                this.nCs.nCn.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass25 nCz;

                    {
                        this.nCz = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        v.i("MicroMsg.LauncherUI", "klem onAnimationStart");
                        this.nCz.nCs.nCe.clU = 0;
                        LauncherUI.d(this.nCz.nCs, false);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        v.i("MicroMsg.LauncherUI", "klem animationEnd");
                        ad.o(new Runnable(this.nCz.nCs) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void run() {
                                ak.vA().btw();
                                ad.va(0);
                                this.nCs.nCe.bJw();
                                this.nCs.nCd.gYg = true;
                                this.nCs.nCd.bFj();
                                this.nCs.nCd.jL(false);
                                this.nCs.bzL();
                            }

                            public final String toString() {
                                return super.toString() + "|chattingView_onAnimationEnd";
                            }
                        });
                        this.nCz.nCs.I(1.0f);
                    }
                });
            }
            if (this.nCs.nCm) {
                this.nCs.nCd.mView.startAnimation(this.nCs.nCn);
                this.nCs.nCm = false;
            } else {
                this.nCs.nCe.clU = 0;
                ad.o(/* anonymous class already generated */);
            }
            this.nCs.nCf.obu = null;
            v.i("MicroMsg.LauncherUI", "klem CHATTING ONLAYOUT ");
        }
    };
    String nCh;
    Bundle nCi;
    Runnable nCj = new Runnable(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final void run() {
            this.nCs.nCo = false;
            if (!this.nCs.isFinishing()) {
                this.nCs.db(4, this.nCs.nBM);
                String str = "MicroMsg.LauncherUI";
                String str2 = "ashutest::startChatting, ishow:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(this.nCs.nCe == null ? false : this.nCs.nCe.isShown());
                v.i(str, str2, objArr);
                Intent putExtra = new Intent().putExtra("Chat_User", this.nCs.nCh);
                if (this.nCs.nCi != null) {
                    putExtra.putExtras(this.nCs.nCi);
                }
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                LauncherUI.a(this.nCs, putExtra);
                this.nCs.nCf.obu = this.nCs.nCg;
                this.nCs.nCe.setVisibility(0);
                this.nCs.bzF();
                com.tencent.mm.modelstat.d.a(3, "ChattingUI" + this.nCs.nCd.bFo(), this.nCs.nCd.hashCode());
                this.nCs.nBE = t.Nh();
                if (this.nCs.nCd.bAm()) {
                    com.tencent.mm.ui.widget.j.a(this.nCs);
                }
            }
        }

        public final String toString() {
            return super.toString() + "|startChattingRunnable";
        }
    };
    Runnable nCk = new Runnable(this) {
        final /* synthetic */ LauncherUI nCs;

        {
            this.nCs = r1;
        }

        public final void run() {
            if (!com.tencent.mm.as.u.bi(this.nCs) && !com.tencent.mm.ah.a.aT(this.nCs)) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                g.iuh.h(11409, new Object[0]);
                com.tencent.mm.ay.c.b(this.nCs, "scanner", ".ui.BaseScanUI", intent);
            }
        }
    };
    private Animation nCl;
    private boolean nCm = false;
    private Animation nCn;
    public boolean nCo = true;
    private LinkedList<Runnable> nCp = new LinkedList();
    public HashMap<Integer, p> nCr = new HashMap();

    public static class FitSystemWindowLayoutView extends FrameLayout {
        private Rect fu = new Rect();
        public ViewGroup nCL = null;

        public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FitSystemWindowLayoutView(Context context) {
            super(context);
        }

        @TargetApi(14)
        public boolean fitSystemWindows(Rect rect) {
            View childAt;
            boolean fitSystemWindows;
            v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s", rect.toString());
            if (this.nCL != null && (this.nCL.getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nCL.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = marginLayoutParams.rightMargin;
                v.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", Integer.valueOf(i), Integer.valueOf(i2));
                int i3 = 0;
                while (i3 < getChildCount()) {
                    childAt = getChildAt(i3);
                    if (childAt instanceof TestTimeForChatting) {
                        TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                        if (Float.compare((float) i, ((float) com.tencent.mm.bd.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i < 0) {
                            v.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", Integer.valueOf(i));
                            testTimeForChatting.oVh = 0;
                        } else {
                            testTimeForChatting.oVh = i;
                        }
                        if (Float.compare((float) i2, ((float) com.tencent.mm.bd.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i2 < 0) {
                            v.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", Integer.valueOf(i));
                            testTimeForChatting.oVi = 0;
                        } else {
                            testTimeForChatting.oVi = i2;
                        }
                        v.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", Integer.valueOf(i), Integer.valueOf(i2));
                        w.p(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    } else {
                        i3++;
                    }
                }
                w.p(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.fu.set(rect);
            if (com.tencent.mm.compatible.util.d.dW(14)) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    childAt = getChildAt(i4);
                    if (childAt instanceof TestTimeForChatting) {
                        childAt.setFitsSystemWindows(true);
                        fitSystemWindows = ((TestTimeForChatting) childAt).fitSystemWindows(rect);
                        childAt.setFitsSystemWindows(false);
                        break;
                    }
                }
            }
            fitSystemWindows = false;
            v.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT));
            v.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", Boolean.valueOf(super.fitSystemWindows(this.fu)));
            return super.fitSystemWindows(this.fu);
        }
    }

    private enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE
    }

    private class b implements Runnable {
        int aKK;
        int aZt;
        Intent aZu;
        int nCM;
        final /* synthetic */ LauncherUI nCs;

        private b(LauncherUI launcherUI) {
            this.nCs = launcherUI;
            this.nCM = 0;
        }

        public final void run() {
            if (ak.uz() && this.nCs.nBl) {
                v.i("MicroMsg.LauncherUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.nCM));
                this.nCs.a(this.nCs.nBT, null, false);
                ad.o(new Runnable(this) {
                    final /* synthetic */ b nCN;

                    {
                        this.nCN = r1;
                    }

                    public final void run() {
                        boolean z = true;
                        String str = "MicroMsg.LauncherUI";
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (this.nCN.nCs.nCd != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        v.d(str, str2, objArr);
                        if (this.nCN.nCs.nCd != null) {
                            v.d("MicroMsg.LauncherUI", "on select image ActivityResult. do post activity result");
                            this.nCN.nCs.nCd.onActivityResult(this.nCN.aZt & 65535, this.nCN.aKK, this.nCN.aZu);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|PostSelectImageJob_onActivityResult";
                    }
                });
            } else if (this.nCM >= 3) {
                v.w("MicroMsg.LauncherUI", "on post select image job, match max retry count");
            } else {
                v.w("MicroMsg.LauncherUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", Boolean.valueOf(this.nCs.nBl), Integer.valueOf(this.nCM));
                this.nCM++;
                ad.g(this, 300);
            }
        }

        public final String toString() {
            return super.toString() + "|PostSelectImageJob";
        }
    }

    public class c extends android.support.v4.app.m implements ViewPager.e, com.tencent.mm.ui.c.a {
        private int jya = 0;
        private com.tencent.mm.ui.contact.AddressUI.a nCO;
        private final WxViewPager nCP;
        private boolean nCQ = false;
        final /* synthetic */ LauncherUI nCs;

        public c(LauncherUI launcherUI, FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            this.nCs = launcherUI;
            super(fragmentActivity.aS());
            this.nCP = wxViewPager;
            this.nCP.a((android.support.v4.view.t) this);
            this.nCP.b((ViewPager.e) this);
        }

        public final int getCount() {
            return 4;
        }

        public final Fragment I(int i) {
            return this.nCs.vx(i);
        }

        public final void a(final int i, float f, int i2) {
            if (this.nCs.nBr != null) {
                this.nCs.nBr.f(i, f);
            }
            if (0.0f != f) {
                if (this.nCO == null) {
                    this.nCO = (com.tencent.mm.ui.contact.AddressUI.a) this.nCs.vx(1);
                }
                this.nCO.jT(false);
                return;
            }
            v.v("MicroMsg.LauncherUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i), Integer.valueOf(this.nCs.nBN));
            if (-1 == this.nCs.nBN) {
                this.nCs.da(this.nCs.nBN, this.nCs.nBM);
                this.nCs.vv(i);
                return;
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ c nCR;

                public final void run() {
                    this.nCR.nCs.da(this.nCR.nCs.nBN, this.nCR.nCs.nBM);
                    this.nCR.nCs.vv(i);
                }
            });
        }

        public final void W(int i) {
            v.d("MicroMsg.LauncherUI", "on page selected changed to %d", Integer.valueOf(i));
            v.v("MicroMsg.LauncherUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.jya), Integer.valueOf(i));
            if (this.jya <= 0) {
                switch (i) {
                    case 0:
                        g.iuh.Y(10957, "5");
                        break;
                    case 1:
                        g.iuh.Y(10957, "6");
                        break;
                    case 2:
                        g.iuh.Y(10957, "7");
                        break;
                    default:
                        break;
                }
            }
            this.jya--;
            switch (i) {
                case 0:
                    g.iuh.Y(10957, "1");
                    break;
                case 1:
                    g.iuh.Y(10957, "2");
                    break;
                case 2:
                    g.iuh.Y(10957, "3");
                    ak.yW();
                    String ah = t.ah((String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    Boolean valueOf = Boolean.valueOf(t.a((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                    String[] split = ah.split(",");
                    valueOf = (!valueOf.booleanValue() || t.kS(ah) || split.length <= 1 || split[split.length - 1].equals("showed") || this.nCs.nCa == 2) ? Boolean.valueOf(false) : Boolean.valueOf(true);
                    if (valueOf.booleanValue()) {
                        g.iuh.h(12653, Integer.valueOf(1), Integer.valueOf(2));
                        break;
                    }
                    break;
                case 3:
                    g.iuh.Y(10957, "4");
                    break;
            }
            this.nCQ = false;
            com.tencent.mm.sdk.c.b etVar = new et();
            etVar.bdx.aYt = 1;
            etVar.bdx.bdy = i;
            com.tencent.mm.sdk.c.a.nhr.z(etVar);
            this.nCs.nBN = this.nCs.nBM;
            this.nCs.nBM = i;
            if (this.nCs.nBr != null) {
                this.nCs.nBr.kg(i);
            }
            this.nCs.aR();
            if (this.nCs.nBN == 1 && this.nCs.nBM != 1) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (this.nCs.nBM == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                ak.yW();
                if (currentTimeMillis - t.e((Long) com.tencent.mm.model.c.vf().get(340226, null)) >= 180000) {
                    ((com.tencent.mm.ui.contact.AddressUI.a) this.nCs.vx(this.nCs.nBM)).bHp();
                }
            }
        }

        public final void X(int i) {
            v.d("MicroMsg.LauncherUI", "onPageScrollStateChanged state %d", Integer.valueOf(i));
            if (i == 0 && this.nCO != null) {
                this.nCO.jT(true);
                this.nCO = null;
            }
        }

        public final void kh(int i) {
            if (i == this.nCs.nBM) {
                v.d("MicroMsg.LauncherUI", "on click same index");
                p vx = this.nCs.vx(i);
                if (vx instanceof com.tencent.mm.ui.AbstractTabChildActivity.a) {
                    ((com.tencent.mm.ui.AbstractTabChildActivity.a) vx).byy();
                    return;
                }
                return;
            }
            this.nCQ = true;
            this.jya++;
            v.v("MicroMsg.LauncherUI", "onTabClick count:%d", Integer.valueOf(this.jya));
            this.nCP.k(i, false);
            if (i == 3) {
                com.tencent.mm.p.c.us().az(262145, 266241);
                com.tencent.mm.p.c.us().az(262156, 266241);
                com.tencent.mm.p.c.us().az(262147, 266241);
                com.tencent.mm.p.c.us().az(262149, 266241);
            }
        }
    }

    static /* synthetic */ void a(LauncherUI launcherUI, int i, int i2, int i3, String str) {
        v.i("MicroMsg.LauncherUI", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        g.iuh.h(13191, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(false));
        Intent intent;
        switch (i2) {
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                com.tencent.mm.ay.c.b((Context) launcherUI, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 3:
                if (launcherUI.iLq) {
                    launcherUI.fn(true);
                    return;
                }
                launcherUI.bzD();
                ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, launcherUI.nBi);
                final k tVar = new com.tencent.mm.modelsimple.t(1);
                ak.vy().a(tVar, 0);
                launcherUI.getString(2131231164);
                launcherUI.dwR = com.tencent.mm.ui.base.g.a((Context) launcherUI, launcherUI.getString(2131235044), true, new OnCancelListener(launcherUI) {
                    final /* synthetic */ LauncherUI nCs;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(tVar);
                    }
                });
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(launcherUI, BindMContactUI.class);
                intent2.putExtra("is_bind_for_change_mobile", true);
                String simCountryIso = ((TelephonyManager) launcherUI.getSystemService("phone")).getSimCountryIso();
                if (!t.kS(simCountryIso)) {
                    com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(launcherUI, simCountryIso, launcherUI.getString(2131232236));
                    if (g != null) {
                        intent2.putExtra("country_name", g.cQn);
                        intent2.putExtra("couttry_code", g.cQm);
                    }
                }
                MMWizardActivity.w(launcherUI, intent2);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!com.tencent.mm.as.u.bi(launcherUI) && !com.tencent.mm.ah.a.aT(launcherUI)) {
                    com.tencent.mm.ay.c.b((Context) launcherUI, "scanner", ".ui.BaseScanUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(LauncherUI launcherUI, Intent intent) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (launcherUI.nCd == null) {
            launcherUI.nCd = com.tencent.mm.ui.chatting.ChattingUI.a.bEW();
            launcherUI.nCd.d(launcherUI.nCb, launcherUI.nCc);
            launcherUI.nCb = null;
            launcherUI.nCc = null;
            z = true;
        } else {
            z = false;
        }
        final int[] iArr;
        View bzG;
        final ViewGroup viewGroup;
        if (launcherUI.nCe == null) {
            if (launcherUI.nCd.bAm()) {
                iArr = new int[2];
                launcherUI.cU().cV().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(launcherUI);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(2131755024);
                launcherUI.nBV = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final View fitSystemWindowLayoutView = new FitSystemWindowLayoutView(launcherUI);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                bzG = launcherUI.bzG();
                if (bzG == null) {
                    bzG = ((ViewGroup) launcherUI.getWindow().getDecorView()).getChildAt(0);
                }
                viewGroup = (ViewGroup) bzG;
                ((ViewGroup) launcherUI.getWindow().getDecorView()).removeView(bzG);
                bzG.setId(2131755055);
                fitSystemWindowLayoutView.addView(bzG);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) launcherUI.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                launcherUI.getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows. statusBarHeight:%d", Integer.valueOf(i));
                if (i > 0) {
                    launcherUI.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    launcherUI.cU().cV().getCustomView().post(new Runnable(launcherUI) {
                        final /* synthetic */ LauncherUI nCs;

                        public final void run() {
                            this.nCs.cU().cV().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                this.nCs.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                            } else if (com.tencent.mm.compatible.util.d.dW(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                                    final /* synthetic */ AnonymousClass26 nCD;

                                    {
                                        this.nCD = r1;
                                    }

                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        if (windowInsets != null) {
                                            v.i("MicroMsg.LauncherUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            this.nCD.nCs.a(fitSystemWindowLayoutView, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                        }
                    });
                }
                launcherUI.nCe = (TestTimeForChatting) launcherUI.findViewById(launcherUI.nBV);
                v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            } else {
                launcherUI.nCe = (TestTimeForChatting) launcherUI.findViewById(2131755642);
                launcherUI.nBV = launcherUI.nCe.getId();
            }
        } else if (launcherUI.nCd.bAm()) {
            iArr = new int[2];
            launcherUI.nCe.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                viewGroup = (ViewGroup) launcherUI.getWindow().getDecorView();
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    bzG = ((ViewGroup) launcherUI.getWindow().getDecorView()).getChildAt(i2);
                    if (bzG instanceof FitSystemWindowLayoutView) {
                        launcherUI.cU().cV().getCustomView().getLocationInWindow(iArr);
                        ((FitSystemWindowLayoutView) bzG).fitSystemWindows(new Rect(0, iArr[1], 0, 0));
                        v.i("MicroMsg.LauncherUI", "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                        break;
                    }
                    v.e("MicroMsg.LauncherUI", "on position %d, rootLayout not found!", Integer.valueOf(i2));
                }
            }
            v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (z) {
            launcherUI.nCd.cSL = true;
            launcherUI.nCd.gYg = false;
            launcherUI.nCd.setArguments(r.T(intent));
            if (launcherUI.bzH()) {
                launcherUI.aS().aW().a(launcherUI.nBV, launcherUI.nCd).commitAllowingStateLoss();
                launcherUI.aS().executePendingTransactions();
            } else {
                launcherUI.aS().aW().b(launcherUI.nBV, launcherUI.nCd).commitAllowingStateLoss();
            }
            launcherUI.nCf = (OnLayoutChangedLinearLayout) launcherUI.nCd.mView.findViewById(2131755468);
            launcherUI.nCd.jL(true);
        } else {
            launcherUI.nCd.cSL = true;
            launcherUI.nCd.gYg = false;
            launcherUI.nCd.oJ.putAll(r.T(intent));
            launcherUI.nCd.bDK();
            launcherUI.nCd.onResume();
            launcherUI.nCd.jL(true);
            com.tencent.mm.sdk.c.b etVar = new et();
            etVar.bdx.aYt = 1;
            etVar.bdx.bdy = 5;
            com.tencent.mm.sdk.c.a.nhr.z(etVar);
        }
        if (launcherUI.nCd.bAm()) {
            launcherUI.nCd.nFw.pew = false;
        }
        v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z), intent);
    }

    static /* synthetic */ void bzO() {
        if (VERSION.SDK_INT < 18) {
            aa.getContext().startService(new Intent(aa.getContext(), NotifyService.class));
        }
    }

    static /* synthetic */ void d(LauncherUI launcherUI, boolean z) {
        if (a.ACTIVITY_RESUME == launcherUI.nBB) {
            launcherUI.c(z, 0);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        nCq = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        nCq.put("tab_address", Integer.valueOf(1));
        nCq.put("tab_find_friend", Integer.valueOf(2));
        nCq.put("tab_settings", Integer.valueOf(3));
    }

    public static void ej(Context context) {
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        if (this.nCd == null || this.nCd.ouT == null || !this.nCd.bAm()) {
            return super.onWindowStartingActionMode(callback);
        }
        if (com.tencent.mm.compatible.util.d.dY(22)) {
            return super.onWindowStartingActionMode(callback);
        }
        ActionMode startActionMode = this.nCd.ouT.startActionMode(callback);
        if (startActionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return startActionMode;
    }

    private void bzq() {
        if (this.nBj) {
            this.nBj = false;
            NX("tab_main");
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        SharedPreferences sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        v.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), be.ea(this));
        NotifyReceiver.pY();
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && r.a(intent, "absolutely_exit", false)) {
            z = true;
            v.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z) {
            Iterator it = nBf.iterator();
            while (it.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it.next();
                if (launcherUI.getTaskId() != taskId) {
                    v.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId));
                    runningTaskInfo = be.U(this, taskId);
                    if (runningTaskInfo == null) {
                        v.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", Integer.valueOf(taskId));
                        finish();
                        obj = null;
                        break;
                    }
                    v.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        nBf.remove(launcherUI);
                    } else {
                        v.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (be.U(this, launcherUI.getTaskId()) != null) {
                            v.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
                            Intent intent2 = new Intent(this, LauncherUI.class);
                            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            startActivity(intent2);
                        }
                        obj = null;
                    }
                }
                runningTaskInfo = runningTaskInfo;
            }
        }
        if (!nBf.isEmpty()) {
            if (runningTaskInfo == null) {
                runningTaskInfo = be.U(this, taskId);
            }
            if (runningTaskInfo != null) {
                v.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    ej(this);
                    v.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", Integer.valueOf(nBf.size()));
                    obj = null;
                    if (obj != null) {
                        super.onCreate(bundle);
                    }
                    com.tencent.mm.pluginsdk.e.N(this);
                    super.onCreate(bundle);
                    getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
                    sharedPreferences = getSharedPreferences("system_config_prefs", 4);
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                    this.FG = cU().cV();
                    bzI();
                    if (this.FG != null) {
                        if (VERSION.SDK_INT < 11) {
                            this.FG.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131689500)));
                        }
                        this.FG.hide();
                    }
                    this.nBu = new t(this);
                    String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
                    if ((nBg || !com.tencent.mm.app.e.oj()) && (ak.uN() || !A.equals(SQLiteDatabase.KeyEmpty))) {
                        nBA = currentTimeMillis;
                        v.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                        bzr();
                    } else {
                        if (!WorkerProfile.oE().aRD || WorkerProfile.oE().oF()) {
                            nBA = currentTimeMillis;
                            v.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                        } else {
                            nBA = MMApplicationLike.sAppStartTime;
                            v.i("MicroMsg.LauncherUI", "start time check isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                        }
                        bzI();
                        adg();
                        setRequestedOrientation(1);
                        com.tencent.mm.app.g om = com.tencent.mm.app.g.om();
                        obj = (ak.uN() || !ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty).equals(SQLiteDatabase.KeyEmpty)) ? null : 1;
                        if (om.aQM) {
                            om.on();
                        }
                        eg anonymousClass1 = new com.tencent.mm.app.g.AnonymousClass1(om, this);
                        com.tencent.mm.model.be.zN().cnm.edit().putInt("MicroMsg.RegStyleStoragestyle_id", 21).commit();
                        currentTimeMillis = System.currentTimeMillis();
                        if (obj != null) {
                            InitCallBackLayout initCallBackLayout = (InitCallBackLayout) LayoutInflater.from(this).inflate(2130904713, null);
                            initCallBackLayout.oxO = anonymousClass1;
                            v.v("MicroMsg.INIT", "KEVIN initWindow  Last1: " + (System.currentTimeMillis() - currentTimeMillis));
                            om.a(this, initCallBackLayout);
                        } else {
                            View initCallBackImageView = new InitCallBackImageView((Context) this, anonymousClass1);
                            initCallBackImageView.setImageResource(2130839554);
                            initCallBackImageView.setScaleType(ScaleType.CENTER_CROP);
                            om.a(this, initCallBackImageView);
                            if (obj == null && om.aQN != null) {
                                om.aQN.setCallback(null);
                                om.aQN = null;
                            }
                        }
                        v.d("MicroMsg.INIT", "start time check initWindow  Last: " + (System.currentTimeMillis() - currentTimeMillis));
                        v.d("MicroMsg.INIT", "start time check APPCreate to Window Show Last: " + (System.currentTimeMillis() - nBA));
                        v.i("MicroMsg.LauncherUI", "start time check after initwindow time from launcherui==" + (System.currentTimeMillis() - nBA));
                    }
                    nBg = false;
                    if (be.aY(this, "android.accessibilityservice.AccessibilityService")) {
                        v.d("MicroMsg.LauncherUI", "jacks android.accessibilityservice.AccessibilityService is running!");
                    } else if (be.aY(this, "AccessibilityService")) {
                        v.d("MicroMsg.LauncherUI", "jacks android.accessibilityservice.AccessibilityService/AccessibilityService is not run!");
                    } else {
                        v.d("MicroMsg.LauncherUI", "jacks AccessibilityService is running!");
                    }
                    v.d("MicroMsg.LauncherUI", "start time check Launcerui oncreate end ==" + (System.currentTimeMillis() - nBA));
                    bb.zD();
                    bb.zE();
                    return;
                }
                v.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", Integer.valueOf(nBf.size()), Boolean.valueOf(r2));
                nBf.clear();
            } else {
                v.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", Integer.valueOf(taskId), Integer.valueOf(nBf.size()));
                nBf.clear();
            }
        }
        nBf.add(this);
        v.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", Integer.valueOf(nBf.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        obj = 1;
        if (obj != null) {
            com.tencent.mm.pluginsdk.e.N(this);
            super.onCreate(bundle);
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
            sharedPreferences = getSharedPreferences("system_config_prefs", 4);
            if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                XLogSetup.realSetupXlog();
            }
            this.FG = cU().cV();
            bzI();
            if (this.FG != null) {
                if (VERSION.SDK_INT < 11) {
                    this.FG.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131689500)));
                }
                this.FG.hide();
            }
            this.nBu = new t(this);
            String A2 = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
            if (nBg) {
            }
            nBA = currentTimeMillis;
            v.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
            bzr();
            nBg = false;
            if (be.aY(this, "android.accessibilityservice.AccessibilityService")) {
                v.d("MicroMsg.LauncherUI", "jacks android.accessibilityservice.AccessibilityService is running!");
            } else if (be.aY(this, "AccessibilityService")) {
                v.d("MicroMsg.LauncherUI", "jacks android.accessibilityservice.AccessibilityService/AccessibilityService is not run!");
            } else {
                v.d("MicroMsg.LauncherUI", "jacks AccessibilityService is running!");
            }
            v.d("MicroMsg.LauncherUI", "start time check Launcerui oncreate end ==" + (System.currentTimeMillis() - nBA));
            bb.zD();
            bb.zE();
            return;
        }
        super.onCreate(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
    }

    private void adg() {
        String string = getString(2131230720);
        if (d.lWk) {
            if (this.nBC) {
                string = string + getString(2131230892);
            } else {
                string = string + " " + getString(2131230892);
            }
        }
        if (this.nBr == null || this.nBr.byG() <= 0) {
            Object obj = string;
        } else {
            if (!this.nBC) {
                string = string + " ";
            }
            CharSequence charSequence = string + "(" + this.nBr.byG() + ")";
        }
        TextView textView = (TextView) this.FG.getCustomView().findViewById(16908308);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private void bzr() {
        if (!this.nBb) {
            NotifyReceiver.pZ();
            this.ens = getIntent();
            this.nBb = true;
            ak.oH().dB(1);
            com.tencent.mm.ui.appbrand.c.aj(this.ens);
        }
    }

    protected final void bzs() {
        this.nBd = true;
        ad.B(this.nBD);
        ad.o(this.nBD);
    }

    protected final void bzt() {
        this.nBd = true;
        ad.B(this.nBD);
        ad.g(this.nBD, 300);
    }

    private boolean bzu() {
        if (this.ens != null && (r.a(this.ens, "absolutely_exit", false) || r.a(this.ens, "absolutely_exit_pid", 0) == Process.myPid())) {
            v.w("MicroMsg.LauncherUI", "launcherOnResume exit absolutely!!!");
            boolean a = r.a(this.ens, "kill_service", true);
            finish();
            com.tencent.mm.plugin.report.service.f.oT(8);
            MMAppMgr.iX(a);
            return true;
        } else if (this.ens == null || !r.a(this.ens, "can_finish", false)) {
            return false;
        } else {
            v.i("MicroMsg.LauncherUI", "exit obviously");
            ak.vy().aQ(true);
            if (getApplicationContext().getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
                Context applicationContext = getApplicationContext();
                applicationContext.stopService(new Intent(applicationContext, CoreService.class));
            }
            com.tencent.mm.plugin.report.service.f.oT(8);
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
            finish();
            com.tencent.mm.ui.base.b.ew(this);
            return true;
        }
    }

    protected void onNewIntent(Intent intent) {
        v.i("MicroMsg.LauncherUI", "checktask onNewIntent 0x%x task:%s", Integer.valueOf(hashCode()), be.ea(this));
        this.ens = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (!WorkerProfile.oE().oF() || bzu()) {
            return;
        }
        if (this.ens == null || !r.a(this.ens, "Intro_Need_Clear_Top ", false)) {
            if ((intent.getFlags() & 67108864) == 67108864) {
                iP(false);
                this.nBj = true;
                this.nBk = r.a(intent, "Intro_Notify", false);
            }
            com.tencent.mm.ui.appbrand.c.Y(intent);
            if (this.nBh) {
                v.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                if (WorkerProfile.oE().oF()) {
                    V(intent);
                }
            }
            vw(0);
            return;
        }
        v.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
        finish();
        ej(this);
    }

    private void bzv() {
        int indexOf = nBf.indexOf(this);
        if (indexOf >= 0) {
            nBf.remove(indexOf);
        }
        v.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", Integer.valueOf(indexOf), Integer.valueOf(nBf.size()), Integer.valueOf(hashCode()));
    }

    public void onResume() {
        boolean z;
        com.tencent.mm.sdk.b.b.aR(true);
        if (this.nCd == null) {
            z = false;
        } else {
            z = this.nCd.cSL;
        }
        v.i("MicroMsg.LauncherUI", "onResume, chatting is show %B, accountHasReady %B", Boolean.valueOf(z), Boolean.valueOf(ak.uz()));
        if (!z && ak.uz()) {
            com.tencent.mm.plugin.sight.decode.a.b.wc();
        }
        v.i("MicroMsg.LauncherUI", "onResume start :%d", Integer.valueOf(this.nBM));
        if (z) {
            com.tencent.mm.modelstat.d.a(3, "ChattingUI" + this.nCd.bFo(), hashCode());
            this.nBE = t.Nh();
        } else {
            db(3, this.nBM);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.nBb && WorkerProfile.oE().oF()) {
            if (this.nCr.size() != 0) {
                ((i) ((p) this.nCr.get(Integer.valueOf(this.nBM)))).byC();
            }
            if (this.nBv && !((this.nCd != null && this.nCd.cSL) || com.tencent.mm.pluginsdk.j.a.lxP == null || t.kS(com.tencent.mm.pluginsdk.j.a.lxQ.awz()))) {
                v.i("MicroMsg.LauncherUI", "launcher onResume end track %s", com.tencent.mm.pluginsdk.j.a.lxP.awp());
                com.tencent.mm.sdk.c.b dxVar = new dx();
                dxVar.bbQ.username = com.tencent.mm.pluginsdk.j.a.lxP.awp();
                com.tencent.mm.sdk.c.a.nhr.z(dxVar);
            }
            if (this.nBn != null) {
                this.nBn.onResume();
            }
            bzA();
            if (this.nBo) {
                this.nBo = false;
                this.nBo = false;
                this.nBO.reset();
            }
            com.tencent.mm.app.j ot = com.tencent.mm.app.j.ot();
            ot.aRp = true;
            ot.aRq.removeMessages(-1999);
            ot.aRq.removeMessages(-2999);
            super.onResume();
            com.tencent.mm.ui.widget.j.b(this);
            I(1.0f);
            v.i("MicroMsg.LauncherUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - currentTimeMillis));
            this.nBv = true;
            if (this.nBr != null) {
                this.nBr.byF();
            }
            if (this.nCd != null && this.nCd.bAm()) {
                this.nCd.nFw.hVC = true;
            }
            this.nBB = a.ACTIVITY_RESUME;
            if (com.tencent.mm.model.k.yo().booleanValue()) {
                bzw();
            }
            if (this.ijq) {
                v.i("MicroMsg.LauncherUI", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    v.i("MicroMsg.LauncherUI", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 97, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 97, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                        v.i("MicroMsg.LauncherUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 70, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
                        if (!com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 70, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        v.d("MicroMsg.LauncherUI", "LauncherUI onResume : " + (System.currentTimeMillis() - currentTimeMillis));
        super.onResume();
        com.tencent.mm.ui.widget.j.b(this);
        I(1.0f);
        this.nBB = a.ACTIVITY_RESUME;
    }

    private void bzw() {
        if (ak.uz()) {
            ak.yW();
            Boolean valueOf = Boolean.valueOf(t.c((Boolean) com.tencent.mm.model.c.vf().get(340227, null)));
            if (!(valueOf.booleanValue() || com.tencent.mm.ui.contact.k.oGv.booleanValue())) {
                nBw = Boolean.valueOf(true);
                iL(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            currentTimeMillis -= t.e((Long) com.tencent.mm.model.c.vf().get(340240, null));
            ak.yW();
            Boolean valueOf2 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.model.c.vf().get(340230, null)));
            ak.yW();
            Boolean valueOf3 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.model.c.vf().get(340228, null)));
            ak.yW();
            Boolean valueOf4 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.model.c.vf().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                nBx = Boolean.valueOf(true);
                iL(false);
                return;
            }
            return;
        }
        v.e("MicroMsg.LauncherUI", "mmcore has not ready");
    }

    private void iL(final boolean z) {
        if (this.lvB != null) {
            v.e("MicroMsg.LauncherUI", "tipsView already shown");
            return;
        }
        this.lvB = View.inflate(aa.getContext(), 2130904129, null);
        TextView textView = (TextView) this.lvB.findViewById(2131758456);
        if (z) {
            textView.setText(aa.getContext().getString(2131230804));
        } else {
            textView.setText(aa.getContext().getString(2131230802));
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        this.lvB.setBackgroundResource(2130838815);
        if (this.dtW != null) {
            ((ViewGroup) this.dtW).addView(this.lvB, layoutParams);
            this.lvB.startAnimation(AnimationUtils.loadAnimation(aa.getContext(), 2130968668));
            this.lvB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                public final void onClick(View view) {
                    this.nCs.nBu.dQ();
                    if (z) {
                        this.nCs.c(Boolean.valueOf(true), Boolean.valueOf(true));
                    } else {
                        this.nCs.c(Boolean.valueOf(true), Boolean.valueOf(false));
                    }
                }
            });
        }
    }

    private void c(Boolean bool, Boolean bool2) {
        if (this.lvB != null) {
            this.lvB.clearAnimation();
            this.lvB.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340227, Boolean.valueOf(true));
                    g.iuh.a(232, 0, 1, false);
                    nBw = Boolean.valueOf(false);
                } else {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340230, Boolean.valueOf(true));
                    g.iuh.a(232, 5, 1, false);
                    nBx = Boolean.valueOf(false);
                }
            }
            this.lvB = null;
        }
    }

    private void bzx() {
        if (this.nBu != null && ak.uz()) {
            if (this.nBu.isShowing()) {
                this.nBu.dismiss();
            } else {
                this.nBu.dQ();
            }
        }
    }

    private void bzy() {
        if (ak.uz()) {
            int parseInt;
            boolean z;
            boolean ax = com.tencent.mm.p.c.us().ax(262156, 266241);
            boolean ay = com.tencent.mm.p.c.us().ay(262156, 266241);
            boolean ax2 = com.tencent.mm.p.c.us().ax(262145, 266241);
            boolean ax3 = com.tencent.mm.p.c.us().ax(262147, 266241);
            boolean ax4 = com.tencent.mm.p.c.us().ax(262149, 266241);
            boolean ay2 = com.tencent.mm.p.c.us().ay(262152, 266256);
            boolean ax5 = com.tencent.mm.p.c.us().ax(262152, 266256);
            com.tencent.mm.p.a us = com.tencent.mm.p.c.us();
            if (us.cit) {
                com.tencent.mm.p.b.a p = us.cir.p(262152, 266256, 4);
                parseInt = p == null ? 0 : com.tencent.mm.p.a.parseInt(p.value);
            } else {
                v.w("MicroMsg.NewBandage", "hasUnreadNum NewBandage has not initialized");
                parseInt = 0;
            }
            com.tencent.mm.pluginsdk.j.d dVar = com.tencent.mm.pluginsdk.j.a.lxM;
            if (dVar == null || !(dVar.ZV() || dVar.ZW())) {
                z = false;
            } else {
                z = true;
            }
            boolean z2 = z && (ay2 || ax5 || parseInt > 0);
            if (ay || ax || ax2 || z2 || ax3 || ax4) {
                this.nBr.iH(true);
                return;
            } else {
                this.nBr.iH(false);
                return;
            }
        }
        v.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
    }

    private void iM(boolean z) {
        if (this.nBu != null && this.nBF != null) {
            if (ak.uz()) {
                int i;
                this.nBu.nGF.ja(z);
                if (this.nBu.nGF.nGy > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    this.nBH.setVisibility(0);
                    return;
                } else {
                    this.nBH.setVisibility(8);
                    return;
                }
            }
            v.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.nCd != null && this.nCd.cSL) {
            return false;
        }
        int dimensionPixelSize;
        int height = cU().cV().getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(2131493014) : getResources().getDimensionPixelSize(2131493015);
        } else {
            dimensionPixelSize = height;
        }
        this.nBI = menu.add(0, 1, 0, 2131235684);
        this.nBI.setIcon(2131165207);
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 68);
        this.nBJ = menu.add(0, 2, 0, 2131235683);
        if (this.nBF == null) {
            LayoutParams layoutParams = new LayoutParams(fromDPToPix, dimensionPixelSize);
            this.nBF = View.inflate(this, 2130903081, null);
            this.nBG = (ImageView) this.nBF.findViewById(2131755225);
            this.nBH = this.nBF.findViewById(2131755290);
            this.nBF.setLayoutParams(layoutParams);
            this.nBF.setBackgroundResource(2130837603);
            this.nBF.setMinimumHeight(dimensionPixelSize);
            this.nBF.setMinimumWidth(fromDPToPix);
            this.nBG.setImageResource(2131165188);
            this.nBF.setContentDescription(getString(2131235683));
            this.nBF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void onClick(View view) {
                    g.iuh.Y(10919, "0");
                    this.nCs.bzx();
                    if (LauncherUI.nBw.booleanValue()) {
                        this.nCs.c(Boolean.valueOf(true), Boolean.valueOf(true));
                    }
                    if (LauncherUI.nBx.booleanValue()) {
                        this.nCs.c(Boolean.valueOf(true), Boolean.valueOf(false));
                    }
                    if (!com.tencent.mm.sdk.b.b.bsG()) {
                        long Ni = t.Ni();
                        if (Ni - this.nCs.nBK > 10000) {
                            this.nCs.nBK = Ni;
                            this.nCs.jya = 1;
                            return;
                        }
                        this.nCs.jya = this.nCs.jya + 1;
                        if (this.nCs.jya >= 5) {
                            v.w("MicroMsg.LauncherUI", "Switch to MonkeyEnv now.");
                            com.tencent.mm.sdk.b.b.iu(true);
                        }
                    }
                }
            });
            this.nBF.post(new Runnable(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void run() {
                    this.nCs.aR();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        iM(false);
        l.a(this.nBJ, this.nBF);
        if (this.nBI != null) {
            l.a(this.nBI, 2);
            this.nBI.setVisible(true);
        }
        if (this.nBJ != null) {
            l.a(this.nBJ, 2);
            this.nBJ.setVisible(true);
        }
        this.nBF.getLayoutParams().width = fromDPToPix;
        this.nBF.getLayoutParams().height = dimensionPixelSize;
        v.v("MicroMsg.LauncherUI", "onCreateOptionsMenu");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (bzM() != null && bzM().isShowing()) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.nCd != null && this.nCd.cSL) {
            return false;
        }
        if (menuItem.getItemId() == 2) {
            g.iuh.Y(10919, "0");
            bzx();
        } else if (menuItem.getItemId() != 1) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            v.i("MicroMsg.LauncherUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 65, null, null)));
            if (!com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 65, null, null)) {
                return true;
            }
            bzz();
        }
        return true;
    }

    private void bzz() {
        int i;
        com.tencent.mm.ay.c.b((Context) this, "search", ".ui.FTSMainUI", new Intent().putExtra("from_tab_index", this.nBM).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
        if (this.nBM == 0) {
            i = 1;
        } else if (this.nBM == 1) {
            i = 2;
        } else if (this.nBM == 2) {
            i = 3;
        } else if (this.nBM == 3) {
            i = 4;
        } else {
            i = 0;
        }
        v.v("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick:%d %s", Integer.valueOf(10991), String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)}));
        g.iuh.Y(10991, r0);
    }

    public void finish() {
        super.finish();
        bzv();
        v.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", Integer.valueOf(hashCode()), Integer.valueOf(nBf.size()), be.bur());
    }

    private void bzA() {
        this.nBc = true;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.u.m.Bi();
        if (!bzu()) {
            int myPid;
            System.currentTimeMillis();
            String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
            if ((ak.uN() || !A.equals(SQLiteDatabase.KeyEmpty)) && !ak.uz()) {
                ak.yY();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            getSharedPreferences("system_config_prefs", 4);
            Intent intent;
            if (this.ens == null || r.a(this.ens, "Intro_Switch", false) || !ak.uN() || ak.uG()) {
                com.tencent.mm.ui.MMFragmentActivity.a.bAs();
                A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
                if (ak.uN() || !A.equals(SQLiteDatabase.KeyEmpty)) {
                    com.tencent.mm.plugin.report.service.f.oT(8);
                    com.tencent.mm.kernel.b vv = com.tencent.mm.kernel.g.vv();
                    vv.cjC.a(new ay(new com.tencent.mm.model.ay.a(vv) {
                        final /* synthetic */ b cjF;

                        {
                            this.cjF = r1;
                        }

                        public final void a(e eVar) {
                            if (eVar != null && eVar.BU() != null) {
                                eVar.BU().reset();
                            }
                        }
                    }, "reset accinfo"), 0);
                    v.i("MicroMsg.LauncherUI", "launch mainTabHasCreate:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", Boolean.valueOf(this.nBh), Boolean.valueOf(this.nBj), Boolean.valueOf(this.nBk), Boolean.valueOf(ak.uG()));
                    if (!this.nBh || (this.nBj && !this.nBk)) {
                        ak.hold();
                        com.tencent.mm.sdk.c.a.nhr.z(new com.tencent.mm.e.a.u());
                        if (ak.uz()) {
                            ak.fH("[" + this.nBh + " " + this.nBj + " " + this.nBk + "]");
                        }
                        if (r.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                            this.nBq = true;
                        }
                        if (r.a(this.ens, "Intro_Switch", false) || (r0 && this.nBh)) {
                            v.appenderClose();
                            BaseEvent.onSingalCrash(0);
                            finish();
                            intent = new Intent(this, LauncherUI.class);
                            intent.addFlags(67108864);
                            startActivity(intent);
                            ak.unhold();
                            v.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
                            v.bta();
                            ak.unhold();
                            myPid = Process.myPid();
                            com.tencent.recovery.b.yH(13);
                            Process.killProcess(myPid);
                        } else {
                            if (!ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty).equals(SQLiteDatabase.KeyEmpty)) {
                                myPid = be.KL(ai.cse.A("last_login_use_voice", SQLiteDatabase.KeyEmpty));
                                v.i("MicroMsg.LauncherUI", "pluginSwitch  " + myPid);
                                if ((myPid & 131072) == 0) {
                                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginHistoryUI"));
                                } else {
                                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginVoiceUI"));
                                }
                                com.tencent.mm.ui.base.b.ev(this);
                            }
                            this.nBj = false;
                            this.nBk = false;
                            com.tencent.mm.plugin.report.service.f.oT(8);
                        }
                        ak.unhold();
                        if (this.nBk) {
                            this.nBk = false;
                        }
                    }
                }
            } else {
                LauncherUI bzB;
                com.tencent.mm.ui.MMFragmentActivity.a.bAs();
                if ("pushcontent_notification".equals(r.g(getIntent(), "nofification_type")) && !t.kS(r.g(getIntent(), "Main_FromUserName"))) {
                    v.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + r.g(getIntent(), "Main_FromUserName") + r.a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                    g.iuh.h(10856, Integer.valueOf(r1), A, Integer.valueOf(0));
                }
                A = r.g(getIntent(), "LauncherUI.Shortcut.LaunchType");
                if (A != null) {
                    if (A.equals("launch_type_voip")) {
                        v.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                        g.iuh.h(11034, Integer.valueOf(2), Integer.valueOf(0));
                    } else if (A.equals("launch_type_voip_audio")) {
                        v.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                        g.iuh.h(11034, Integer.valueOf(2), Integer.valueOf(1));
                    }
                }
                A = r.g(getIntent(), "LauncherUI.switch.tab");
                if (!t.kS(A)) {
                    NX(A);
                    getIntent().putExtra("LauncherUI.switch.tab", SQLiteDatabase.KeyEmpty);
                }
                if (r.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.nBq) {
                    this.nBq = false;
                    bzB = bzB();
                    if (bzB != null) {
                        ak.vA().btt();
                        if (bzB.nBd) {
                            v.i("MicroMsg.LauncherUI", "remove setTagRunnable");
                            ad.B(bzB.nBD);
                        }
                        ad.o(bzB.nCk);
                    }
                    getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                    getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
                }
                boolean a = r.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
                if (a) {
                    this.bkp = r.g(getIntent(), "LauncherUI.Shortcut.Username");
                } else {
                    a = r.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                    this.bkp = getIntent().getAction();
                }
                if (a) {
                    v.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + this.bkp);
                    if (!t.kS(this.bkp)) {
                        this.bkp = com.tencent.mm.plugin.base.a.c.pq(this.bkp);
                        if (!t.kS(this.bkp)) {
                            if (com.tencent.mm.model.m.eC(this.bkp)) {
                                v.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                                if (!com.tencent.mm.modelbiz.e.hz(this.bkp)) {
                                    bzB = bzB();
                                    if (bzB != null) {
                                        bzB.a(this.bkp, null, false);
                                    }
                                } else if (com.tencent.mm.modelbiz.e.hC(this.bkp)) {
                                    intent = new Intent();
                                    intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                    intent.putExtra("Contact_User", this.bkp);
                                    intent.putExtra("biz_chat_from_scene", 9);
                                    intent.addFlags(67108864);
                                    startActivity(intent);
                                } else if (com.tencent.mm.modelbiz.e.hB(this.bkp)) {
                                    intent = new Intent();
                                    intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                    intent.putExtra("enterprise_biz_name", this.bkp);
                                    intent.putExtra("enterprise_biz_display_name", com.tencent.mm.model.l.er(this.bkp));
                                    startActivity(intent);
                                } else if (com.tencent.mm.modelbiz.e.hD(this.bkp)) {
                                    BizInfo hw = com.tencent.mm.modelbiz.e.hw(this.bkp);
                                    A = hw == null ? null : hw.CD();
                                    if (A == null) {
                                        A = SQLiteDatabase.KeyEmpty;
                                    }
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("rawUrl", A);
                                    intent2.putExtra("useJs", true);
                                    intent2.putExtra("srcUsername", this.bkp);
                                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                    intent2.addFlags(67108864);
                                    com.tencent.mm.ay.c.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                                } else {
                                    bzB = bzB();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("chat_from_scene", 3);
                                    bzB.a(this.bkp, bundle, false);
                                }
                            }
                            getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                            getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                            this.bkp = null;
                        }
                    }
                }
                v.w("MicroMsg.LauncherUI", "[Launching Application]");
                com.tencent.mm.kernel.h.c(this, false);
                com.tencent.mm.kernel.h.d(this, false);
                long currentTimeMillis3 = System.currentTimeMillis();
                this.nBe = true;
                if (this.nBh) {
                    bzq();
                    bzC();
                } else {
                    v.d("MicroMsg.LauncherUI", "on main tab create");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (ak.uz()) {
                        long currentTimeMillis5 = System.currentTimeMillis();
                        MMActivity.ed(this);
                        try {
                            Set hashSet = new HashSet();
                            String[] split = getString(2131232239).split(";");
                            hashSet.add(split[0]);
                            hashSet.add(split[1]);
                            com.tencent.mm.model.l.c(hashSet);
                        } catch (Throwable e) {
                            v.a("MicroMsg.LauncherUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        com.tencent.mm.sdk.c.a.nhr.z(new aq());
                        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis5));
                        this.gwU = (LayoutInflater) getSystemService("layout_inflater");
                        if (this.nBn != null) {
                            this.nBn = null;
                        }
                        currentTimeMillis5 = System.currentTimeMillis();
                        this.dtW = q.em(this).inflate(2130903921, null);
                        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis5));
                        setContentView(this.dtW);
                        Looper.myQueue().addIdleHandler(this.nBU);
                        this.nBl = true;
                        this.nBO = (VoiceSearchLayout) findViewById(2131758016);
                        this.nBO.tR(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 100.0f));
                        this.nBs = (CustomViewPager) findViewById(2131758015);
                        this.nBs.yb(4);
                        if (this.nBr != null) {
                            this.nBr.a(null);
                            ((View) this.nBr).setVisibility(8);
                        }
                        this.nBs.CM = true;
                        this.nBt = new c(this, this, this.nBs);
                        c cVar = this.nBr;
                        if (this.nBr != null) {
                            this.nBr.a(null);
                            ((View) this.nBr).setVisibility(8);
                            ((ViewGroup) this.nBs.getParent()).removeView((View) this.nBr);
                        }
                        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        Object launcherUIBottomTabView = new LauncherUIBottomTabView(this);
                        ((ViewGroup) this.nBs.getParent()).addView(launcherUIBottomTabView, layoutParams);
                        this.nBr = launcherUIBottomTabView;
                        ((View) this.nBr).setVisibility(0);
                        this.nBr.a(this.nBt);
                        if (!(cVar == null || cVar == this.nBr)) {
                            this.nBr.iG(cVar.byK());
                            this.nBr.iH(cVar.byL());
                            this.nBr.vq(cVar.byG());
                            this.nBr.vr(cVar.byH());
                            this.nBr.vs(cVar.byI());
                            this.nBr.vt(cVar.byJ());
                            this.nBr.kg(cVar.byM());
                        }
                        vw(0);
                        v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis5));
                        long currentTimeMillis6 = System.currentTimeMillis();
                        V(getIntent());
                        v.d("MicroMsg.LauncherUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - currentTimeMillis6));
                        currentTimeMillis6 = System.currentTimeMillis();
                        if (!this.nBp && MMAppMgr.oO() && ak.uz() && ab.Ki("show_whatsnew")) {
                            v.i("MicroMsg.LauncherUI", "dz[showWhatsNewForResult from onMainTabCreate]");
                            com.tencent.mm.ay.c.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent(), 1);
                        }
                        com.tencent.mm.app.plugin.b.cJ(3);
                        v.d("MicroMsg.LauncherUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - currentTimeMillis6));
                        bzI();
                        this.FG.show();
                        this.dtW.post(new Runnable(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void run() {
                                this.nCs.adg();
                                ak.yW();
                                com.tencent.mm.model.c.vf().setInt(327947, this.nCs.FG.getHeight());
                                v.i("MicroMsg.LauncherUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", Integer.valueOf(this.nCs.dtW.getPaddingTop()));
                                com.tencent.mm.pluginsdk.e.a(this.nCs, this.nCs.dtW);
                            }

                            public final String toString() {
                                return super.toString() + "|updateTitle";
                            }
                        });
                        v.v("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis4));
                        ad.g(new Runnable(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void run() {
                                v.d("MicroMsg.LauncherUI", "onMainTabCreate, send refresh broadcast");
                                this.nCs.sendBroadcast(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
                            }

                            public final String toString() {
                                return super.toString() + "|sendBroadcast";
                            }
                        }, 2000);
                        this.dtW.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                v.i("MicroMsg.LauncherUI", "contentView.addOnLayoutChangeListener %s %s %s %s, %s %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                            }
                        });
                        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
                        this.dtW.postDelayed(new Runnable(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void run() {
                                v.i("MicroMsg.LauncherUI", "contentView.post, padding: %s", Integer.valueOf(this.nCs.dtW.getPaddingTop()));
                            }
                        }, 20);
                    } else {
                        v.e("MicroMsg.LauncherUI", "mmcore has not ready, finish launcherui");
                        finish();
                    }
                    bzq();
                    bzC();
                    this.nBh = true;
                }
                i iVar = (i) vx(this.nBM);
                if (iVar != null) {
                    iVar.byD();
                }
                v.v("MicroMsg.LauncherUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis3));
                com.tencent.mm.u.b.a(com.tencent.mm.model.k.xF(), false, -1);
                this.nBj = false;
            }
            v.d("MicroMsg.LauncherUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis2));
            myPid = r.a(getIntent(), "preferred_tab", 0);
            v.d("MicroMsg.LauncherUI", "KEVIN onNewIntent, tabIdx = %d", Integer.valueOf(myPid));
            if (myPid != 0) {
                vw(myPid);
                getIntent().putExtra("preferred_tab", 0);
            }
            v.i("MicroMsg.LauncherUI", "KEVIN onresume " + (System.currentTimeMillis() - currentTimeMillis) + "instance : " + nBf.size());
        }
    }

    protected void onPause() {
        com.tencent.mm.sdk.b.b.aR(false);
        this.nBB = a.ACTIVITY_PAUSE;
        boolean isShown = this.nCe != null ? this.nCe.isShown() : false;
        v.d("MicroMsg.LauncherUI", "edw onPause, chatting is show " + isShown);
        super.onPause();
        if (isShown) {
            com.tencent.mm.modelstat.d.a(4, "ChattingUI" + this.nCd.bFo(), this.nCd.hashCode());
            com.tencent.mm.modelstat.d.d("ChattingUI" + this.nCd.bFo(), this.nBE, t.Nh());
        } else {
            db(4, this.nBM);
        }
        if (!isFinishing()) {
            com.tencent.mm.ui.widget.j.a(this);
        }
        p bzM = bzM();
        if (this.nBb && WorkerProfile.oE().oF() && bzM == null) {
            this.nBe = false;
            if (this.nBh) {
                v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onMainTabPause");
                if (WorkerProfile.oE().oF()) {
                    bzF();
                    if (ak.uz()) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().b(this.nBR);
                        ak.yW();
                        com.tencent.mm.model.c.wK().b(this);
                        com.tencent.mm.p.c.us().b(this.nBQ);
                        com.tencent.mm.sdk.c.a.nhr.f(this.nBP);
                        com.tencent.mm.sdk.c.a.nhr.f(this.nBS);
                        com.tencent.mm.sdk.c.a.nhr.f(this.nAE);
                        com.tencent.mm.sdk.c.a.nhr.f(this.nBW);
                    }
                }
            }
            if (this.nBu != null && this.nBu.isShowing()) {
                this.nBu.dismiss();
            }
            if (this.nCd != null && this.nCd.bAm()) {
                this.nCd.nFw.hVC = false;
            }
            v.v("MicroMsg.LauncherUI", "KEVIN Launcher onPause %d", Integer.valueOf(this.nBM));
            if (this.nBi != null) {
                ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, this.nBi);
                ak.vy().b(384, this.nBi);
                this.nBi = null;
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.nBY);
        ad.B(this.nCj);
        bzv();
        v.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), be.ea(this), Integer.valueOf(nBf.size()));
        if (this.nBh) {
            Looper.myQueue().removeIdleHandler(this.nBU);
            v.v("MicroMsg.LauncherUI", "onMainTabDestroy");
        }
        if (this.nBO != null) {
            this.nBO.lIS = null;
        }
        this.nCr.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        v.v("MicroMsg.LauncherUI", "edw on activity result");
        if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && this.nCd != null) {
            this.nCd.onActivityResult(i, i2, intent);
        }
        v.w("MicroMsg.LauncherUI", "check request code %d", Integer.valueOf(65535 & i));
        switch (65535 & i) {
            case 217:
            case 218:
            case 226:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z && this.nCd == null) {
            v.i("MicroMsg.LauncherUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            ad.B(this.nBL);
            this.nBL.nCM = 0;
            this.nBL.aZt = i;
            this.nBL.aKK = i2;
            this.nBL.aZu = intent;
            ad.o(this.nBL);
        } else if (!this.nBh) {
        } else {
            if (i == 1) {
                ak.yW();
                if (!t.c((Boolean) com.tencent.mm.model.c.vf().get(12323, null))) {
                    com.tencent.mm.platformtools.l.a(this, null, false, 3);
                }
            } else if (i == 65534 && i2 == -1) {
                ab.Kj("welcome_page_show");
                com.tencent.mm.kernel.h.c(this, true);
                MMAppMgr.oz();
                MMAppMgr.a(this, true);
                finish();
            }
        }
    }

    public final void op() {
        v.d("MicroMsg.LauncherUI", "KEVIN onInit");
        ad.o(new Runnable(this) {
            final /* synthetic */ LauncherUI nCs;

            {
                this.nCs = r1;
            }

            public final void run() {
                this.nCs.iN(true);
            }

            public final String toString() {
                return super.toString() + "|onInit";
            }
        });
    }

    private void iN(boolean z) {
        boolean z2 = true;
        v.i("MicroMsg.LauncherUI", "summerper doInit hasCreate[%b] checkPermission[%b]", Boolean.valueOf(this.nBb), Boolean.valueOf(true));
        if (!this.nBb) {
            v.i("MicroMsg.LauncherUI", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 32, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 32, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                v.i("MicroMsg.LauncherUI", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 96, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 96, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    v.i("MicroMsg.LauncherUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                        v.i("MicroMsg.LauncherUI", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - nBA));
                        com.tencent.mm.plugin.report.service.f.cw(nBA);
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
        bzr();
        if (!this.nBc) {
            this.nBp = r.a(getIntent(), "LauncherUI.enter_from_reg", false);
            bzA();
        }
        boolean uN = ak.uN();
        String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        if (uN || !A.equals(SQLiteDatabase.KeyEmpty)) {
            z2 = false;
        }
        if (z2) {
            ak.vy().a(new o(), 0);
            com.tencent.mm.plugin.report.service.f.oT(8);
            this.nBn = new WelcomeSelectView(this);
            setContentView(this.nBn);
            this.nBn.bBn();
            if (f.nhZ) {
                MMAppMgr.d(this);
                return;
            } else {
                MMAppMgr.ek(this);
                return;
            }
        }
        f.nhY = false;
    }

    public static LauncherUI bzB() {
        if (!nBf.isEmpty()) {
            return (LauncherUI) nBf.get(0);
        }
        v.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", t.Nm());
        return null;
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.nBT = bundle.getString("last_restore_talker");
        v.d("MicroMsg.LauncherUI", "onRestoreInstantceState:%s", this.nBT);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nCd != null && !t.kS(this.nCd.bEn())) {
            v.d("MicroMsg.LauncherUI", "onSaveInstanceState:%s", this.nCd.bEn());
            bundle.putString("last_restore_talker", this.nCd.bEn());
        }
    }

    private void bzC() {
        if (getSharedPreferences(aa.bti(), 0).getBoolean("settings_landscape_mode", false)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (bzB() != null) {
            ak.yW();
            com.tencent.mm.model.c.wK().a(this);
            ak.yW();
            com.tencent.mm.model.c.vf().a(this.nBR);
            com.tencent.mm.p.c.us().a(this.nBQ);
            com.tencent.mm.sdk.c.a.nhr.e(this.nBY);
            com.tencent.mm.sdk.c.a.nhr.e(this.nBS);
            com.tencent.mm.sdk.c.a.nhr.e(this.nAE);
            com.tencent.mm.sdk.c.a.nhr.e(this.nBW);
            bzE();
            bzK();
            bzs();
            bzy();
            iM(false);
            com.tencent.mm.sdk.c.a.nhr.e(this.nBP);
            if (getIntent() != null) {
                String g = r.g(getIntent(), "LauncherUI.Show.Update.DialogMsg");
                if (!t.kS(g)) {
                    getIntent().putExtra("LauncherUI.Show.Update.DialogMsg", SQLiteDatabase.KeyEmpty);
                    iP(false);
                    NX("tab_main");
                    g.iuh.a(405, 33, 1, true);
                    com.tencent.mm.ui.base.g.a((Context) this, g, getString(2131235970), getString(2131235971), getString(2131235969), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.iuh.h(11584, Integer.valueOf(1));
                            g.iuh.a(405, 34, 1, true);
                            String g = r.g(this.nCs.getIntent(), "LauncherUI.Show.Update.Url");
                            if (t.kS(g)) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.mm"));
                                intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                try {
                                    this.nCs.startActivity(intent);
                                    return;
                                } catch (Exception e) {
                                    intent = new Intent();
                                    String dJ = u.dJ(this.nCs);
                                    if (t.kS(dJ)) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/en/");
                                    } else if (dJ.equals("zh_TW") || dJ.equals("zh_HK")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/");
                                    } else if (dJ.equals("ja")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/ja/");
                                    } else if (dJ.equals("ko")) {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/ko/");
                                    } else {
                                        intent.putExtra("rawUrl", "http://www.wechat.com/en/");
                                    }
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("needRedirect", false);
                                    intent.putExtra("neverGetA8Key", true);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                                    com.tencent.mm.ay.c.b(this.nCs, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", g);
                            intent2.putExtra("showShare", false);
                            intent2.putExtra("show_bottom", false);
                            intent2.putExtra("needRedirect", false);
                            intent2.putExtra("neverGetA8Key", true);
                            intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                            intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                            com.tencent.mm.ay.c.b(this.nCs, "webview", ".ui.tools.WebViewUI", intent2);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.iuh.h(11584, Integer.valueOf(2));
                            g.iuh.a(405, 35, 1, true);
                        }
                    });
                }
            } else {
                v.w("MicroMsg.LauncherUI", "dz[getIntent is null!]");
            }
            if (!a(this.nBX)) {
                ak.vA().f(new Runnable(this) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final void run() {
                        Object obj = null;
                        SharedPreferences btk = aa.btk();
                        if (t.Nl()) {
                            long j = btk.getLong("show_sdcard_full_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                                btk.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                                com.tencent.mm.ui.base.g.b(this.nCs, this.nCs.getString(2131234800), this.nCs.getString(2131234801), this.nCs.getString(2131231013), this.nCs.getString(2131231077), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass20 nCy;

                                    {
                                        this.nCy = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ak.yW();
                                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                            Intent intent = new Intent();
                                            intent.putExtra("had_detected_no_sdcard_space", true);
                                            com.tencent.mm.ay.c.b(this.nCy.nCs, "clean", ".ui.CleanUI", intent);
                                        } else {
                                            s.ey(this.nCy.nCs);
                                        }
                                        dialogInterface.dismiss();
                                        g.iuh.a(282, 1, 1, false);
                                    }
                                }, null);
                                g.iuh.a(282, 0, 1, false);
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            ak.yW();
                            if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                ak.yW();
                                if (t.kS((String) com.tencent.mm.model.c.vf().get(6, SQLiteDatabase.KeyEmpty))) {
                                    ak.yW();
                                    boolean booleanValue = ((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(false))).booleanValue();
                                    ak.yW();
                                    com.tencent.mm.storage.r vf = com.tencent.mm.model.c.vf();
                                    com.tencent.mm.storage.t.a aVar = com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING;
                                    LauncherUI launcherUI = this.nCs;
                                    String string = this.nCs.getString(2131231420);
                                    Object obj2 = launcherUI.bXL.get(string);
                                    if (obj2 instanceof String) {
                                        v.d("MicroMsg.LauncherUI", "getString(): key=" + string + ", value=" + obj2.toString());
                                        obj2 = (String) obj2;
                                    } else {
                                        obj2 = null;
                                    }
                                    final String str = (String) vf.get(aVar, obj2);
                                    v.i("MicroMsg.LauncherUI", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", Boolean.valueOf(r2), r0, Boolean.valueOf(booleanValue), str);
                                    if (booleanValue) {
                                        com.tencent.mm.ui.base.g.a(this.nCs, str, this.nCs.getString(2131231164), this.nCs.getString(2131231107), false, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 nCy;

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.setClassName(this.nCy.nCs, "com.tencent.mm.ui.account.bind.BindMobileUI");
                                                intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, SQLiteDatabase.KeyEmpty));
                                                MMWizardActivity.w(this.nCy.nCs, intent);
                                                dialogInterface.dismiss();
                                            }
                                        });
                                    } else {
                                        com.tencent.mm.ui.base.g.b(this.nCs, str, this.nCs.getString(2131231164), this.nCs.getString(2131231107), this.nCs.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 nCy;

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.setClassName(this.nCy.nCs, "com.tencent.mm.ui.account.bind.BindMobileUI");
                                                intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, SQLiteDatabase.KeyEmpty));
                                                MMWizardActivity.w(this.nCy.nCs, intent);
                                                dialogInterface.dismiss();
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass20 nCy;

                                            {
                                                this.nCy = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        });
                                    }
                                } else {
                                    v.i("MicroMsg.LauncherUI", "summerbindmobile has bind[%s]", (String) com.tencent.mm.model.c.vf().get(6, SQLiteDatabase.KeyEmpty));
                                }
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(false));
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                                ak.yW();
                                com.tencent.mm.model.c.vf().iB(true);
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|doOnResumeCheck";
                    }
                }, 500);
            }
            this.nBX = null;
            if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final boolean queueIdle() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (this.nCs.nCe == null) {
                            if (this.nCs.nCb == null) {
                                this.nCs.nCb = q.em(this.nCs).inflate(2130903279, null);
                            }
                            if (this.nCs.nCc == null) {
                                this.nCs.nCc = q.em(this.nCs).inflate(2130903073, null);
                            }
                        }
                        v.d("MicroMsg.LauncherUI", "prepare chattingUI view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                });
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final boolean queueIdle() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (this.nCs.nCe == null) {
                            LauncherUI.a(this.nCs, new Intent().putExtra("Chat_User", com.tencent.mm.model.k.xF()));
                            this.nCs.nCd.gYg = true;
                            this.nCs.nCd.bFj();
                            this.nCs.nCe.setVisibility(8);
                            this.nCs.nCd.nFv = true;
                            this.nCs.nCd.onPause();
                            this.nCs.nCd.bFg();
                            this.nCs.nCd.cSL = false;
                            this.nCs.bzE();
                            w.a(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
                        }
                        this.nCs.nCb = null;
                        this.nCs.nCc = null;
                        v.d("MicroMsg.LauncherUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                });
            }
            v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private boolean a(com.tencent.mm.protocal.b.a.b bVar) {
        if (bVar == null || bVar.lYu == null || bVar.lYu.size() == 0) {
            return false;
        }
        final int i = bVar.id;
        String str = bVar.title;
        String str2 = bVar.lcr;
        final com.tencent.mm.protocal.b.a.a aVar;
        if (bVar.lYu.size() == 1) {
            aVar = (com.tencent.mm.protocal.b.a.a) bVar.lYu.get(0);
            v.i("MicroMsg.LauncherUI", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(aVar.id), Integer.valueOf(aVar.actionType), aVar.lYs, aVar.lYt);
            com.tencent.mm.ui.base.g.a((Context) this, str2, str, aVar.lYs, false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LauncherUI.a(this.nCs, i, aVar.actionType, aVar.id, aVar.lYt);
                    dialogInterface.dismiss();
                }
            });
        } else {
            aVar = (com.tencent.mm.protocal.b.a.a) bVar.lYu.get(1);
            final com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) bVar.lYu.get(0);
            v.i("MicroMsg.LauncherUI", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(aVar.id), Integer.valueOf(aVar.actionType), aVar.lYs, aVar.lYt, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.lYs, aVar2.lYt);
            com.tencent.mm.ui.base.g.a((Context) this, str2, str, aVar.lYs, aVar2.lYs, false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LauncherUI.a(this.nCs, i, aVar.actionType, aVar.id, aVar.lYt);
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LauncherUI.a(this.nCs, i, aVar2.actionType, aVar2.id, aVar2.lYt);
                    dialogInterface.dismiss();
                }
            });
        }
        return true;
    }

    private com.tencent.mm.v.e bzD() {
        if (this.nBi == null) {
            this.nBi = new com.tencent.mm.v.e(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    v.i("MicroMsg.LauncherUI", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                    if (this.nCs.dwR != null) {
                        this.nCs.dwR.dismiss();
                        this.nCs.dwR = null;
                    }
                    if (kVar.getType() == WebView.NORMAL_MODE_ALPHA) {
                        ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, this.nCs.nBi);
                        if (i == 0 && i2 == 0) {
                            this.nCs.fn(true);
                        } else if (!com.tencent.mm.ui.o.a.a(this.nCs, i, i2, str, 4)) {
                            this.nCs.fn(false);
                        }
                    } else if (kVar.getType() != 384) {
                    } else {
                        if (i == 0 && i2 == 0) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(77830, ((ag) kVar).Fi());
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.nCs.getString(2131235066));
                            com.tencent.mm.ay.c.b(this.nCs, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                            return;
                        }
                        this.nCs.iLq = true;
                        com.tencent.mm.ui.base.g.a(this.nCs, 2131235087, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass19 nCx;

                            {
                                this.nCx = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.nCx.nCs.bzN();
                            }
                        });
                    }
                }
            };
        }
        return this.nBi;
    }

    private void fn(boolean z) {
        v.d("MicroMsg.LauncherUI", "summeralert handlePassword " + z);
        if (z) {
            bzN();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", getString(2131235066));
        com.tencent.mm.ay.c.b((Context) this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
    }

    private void bzE() {
        com.tencent.mm.ui.conversation.d dVar = (com.tencent.mm.ui.conversation.d) this.nCr.get(Integer.valueOf(0));
        if (dVar != null) {
            if (dVar.oLX != null) {
                dVar.oLX.bHn();
            }
            dVar.bIy();
            dVar.bIv();
        }
    }

    public final void bzF() {
        com.tencent.mm.ui.conversation.d dVar = (com.tencent.mm.ui.conversation.d) this.nCr.get(Integer.valueOf(0));
        if (dVar != null) {
            dVar.bIz();
            if (ak.uz() && dVar.oMf != null) {
                com.tencent.mm.ui.d.k kVar = dVar.oMf;
                v.i("MicroMsg.MassSightBanner", "call stop all sight");
                for (Entry value : kVar.nQZ.entrySet()) {
                    ((b) value.getValue()).nRe.clear();
                }
            }
        }
    }

    private void V(Intent intent) {
        v.i("MicroMsg.LauncherUI", "handleJump");
        if (!ak.uz()) {
            v.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
            startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
            finish();
        } else if ("talkroom_notification".equals(r.g(intent, "nofification_type"))) {
            r0 = r.g(intent, "enter_chat_usrname");
            if (!t.kS(r0)) {
                Intent intent2 = new Intent();
                intent2.putExtra("enter_room_username", r0);
                intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.ay.c.b((Context) this, "talkroom", ".ui.TalkRoomUI", intent2);
            }
        } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
            r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            if (!intent.getBooleanExtra("newPCBackup", true)) {
                v.d("MicroMsg.LauncherUI", "summerbak jump BakToPcUI");
                r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.topcui.BakToPcUI");
            }
            r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            MMWizardActivity.w(this, r0);
        } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
            r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.topcui.BakConnErrorUI");
            r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            MMWizardActivity.w(this, r0);
        } else {
            int a;
            boolean a2;
            LauncherUI bzB;
            Bundle bundle;
            if (r.a(intent, "show_update_dialog", false)) {
                a = r.a(intent, "update_type", -1);
                if (a == -1) {
                    v.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
                } else {
                    g.iuh.a(405, 28, 1, true);
                    if (com.tencent.mm.pluginsdk.j.ai.bmA() != null) {
                        com.tencent.mm.pluginsdk.j.ad a3 = com.tencent.mm.pluginsdk.j.ai.bmA().a(this, null);
                        if (a3 != null) {
                            g.iuh.a(405, a == 2 ? 29 : 30, 1, true);
                            a3.update(a);
                        }
                    }
                }
            }
            String g = r.g(intent, "Main_User");
            if (!(g == null || g.equals(SQLiteDatabase.KeyEmpty))) {
                ak.yW();
                af Mh = com.tencent.mm.model.c.wK().Mh(g);
                if (Mh != null) {
                    a = Mh.field_unReadCount;
                    if (a == 0) {
                        a = r.a(intent, "pushcontent_unread_count", 0);
                    }
                    MMAppMgr.oz();
                    com.tencent.mm.sdk.c.a.nhr.z(new x());
                    vw(0);
                    a2 = r.a(intent, "Intro_Is_Muti_Talker", true);
                    v.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a2), Integer.valueOf(a));
                    if (!a2 && a > 0 && r.a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                        v.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(r.a(intent, "Intro_Bottle_unread_count", 0)));
                        com.tencent.mm.ay.c.w(this, "bottle", ".ui.BottleConversationUI");
                    }
                    if (!a2 || a <= 0) {
                        if (r.a(intent, "From_fail_notify", false)) {
                            if (r.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                                vw(0);
                            } else if (bzB() != null && com.tencent.mm.modelbiz.e.hC(g)) {
                                intent.putExtra("Contact_User", g);
                                intent.addFlags(67108864);
                                com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                            }
                        } else if (!t.kS(g)) {
                            bzB = bzB();
                            if (bzB != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("Chat_Mode", r.a(intent, "resend_fail_messages", false));
                                if (com.tencent.mm.modelbiz.e.hC(g)) {
                                    bzB.a(g, bundle, false);
                                } else {
                                    intent.putExtra("Contact_User", g);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                                }
                            }
                        } else if (r.a(intent, "jump_sns_from_notify", false)) {
                            r0 = new Intent();
                            r0.addFlags(67108864);
                            r0.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                            r0.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                            r0.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                            com.tencent.mm.ay.c.b((Context) this, "sns", ".ui.SnsTimeLineUI", r0);
                        }
                    } else if (com.tencent.mm.model.m.eT(g)) {
                        v.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                        r0 = new Intent();
                        r0.addFlags(67108864);
                        r0.putExtra("type", 20);
                        com.tencent.mm.ay.c.b((Context) this, "readerapp", ".ui.ReaderAppUI", r0);
                    } else if (com.tencent.mm.model.m.fb(g)) {
                        v.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                        r0 = new Intent();
                        r0.addFlags(67108864);
                        r0.putExtra("type", 11);
                        com.tencent.mm.ay.c.b((Context) this, "readerapp", ".ui.ReaderAppUI", r0);
                    } else {
                        if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                            a = 2;
                        } else {
                            a = 1;
                        }
                        this.nBv = false;
                        bundle = new Bundle();
                        bundle.putInt("Chat_Mode", a);
                        if ("new_msg_nofification".equals(r.g(intent, "nofification_type"))) {
                            bundle.putInt("chat_from_scene", 1);
                        }
                        bzB = bzB();
                        if (bzB != null) {
                            if (com.tencent.mm.modelbiz.e.hC(g)) {
                                intent.putExtra("Contact_User", g);
                                intent.addFlags(67108864);
                                intent.putExtra("biz_chat_from_scene", 4);
                                com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                            } else if (com.tencent.mm.modelbiz.e.hD(g)) {
                                BizInfo hw = com.tencent.mm.modelbiz.e.hw(g);
                                r0 = hw == null ? null : hw.CD();
                                if (r0 == null) {
                                    r0 = SQLiteDatabase.KeyEmpty;
                                }
                                intent.putExtra("rawUrl", r0);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", g);
                                intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent.addFlags(67108864);
                                com.tencent.mm.ay.c.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                            } else if (com.tencent.mm.storage.u.dW(g)) {
                                intent.putExtra("Contact_User", g);
                                intent.addFlags(67108864);
                                intent.putExtra("app_brand_conversation_from_scene", 3);
                                intent.putExtra("finish_direct", true);
                                intent.putExtra("key_need_send_video", false);
                                com.tencent.mm.ay.c.a((Context) this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                            } else {
                                bzB.a(g, bundle, false);
                            }
                        }
                    }
                    if (r.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                        r0 = new Intent();
                        r0.setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
                        r0.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                        r0.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                        MMWizardActivity.w(this, r0);
                    }
                }
            }
            a = 0;
            if (a == 0) {
                a = r.a(intent, "pushcontent_unread_count", 0);
            }
            MMAppMgr.oz();
            com.tencent.mm.sdk.c.a.nhr.z(new x());
            vw(0);
            a2 = r.a(intent, "Intro_Is_Muti_Talker", true);
            v.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a2), Integer.valueOf(a));
            v.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(r.a(intent, "Intro_Bottle_unread_count", 0)));
            com.tencent.mm.ay.c.w(this, "bottle", ".ui.BottleConversationUI");
            if (a2) {
            }
            if (r.a(intent, "From_fail_notify", false)) {
                if (r.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                    vw(0);
                } else {
                    intent.putExtra("Contact_User", g);
                    intent.addFlags(67108864);
                    com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                }
            } else if (!t.kS(g)) {
                bzB = bzB();
                if (bzB != null) {
                    bundle = new Bundle();
                    bundle.putBoolean("Chat_Mode", r.a(intent, "resend_fail_messages", false));
                    if (com.tencent.mm.modelbiz.e.hC(g)) {
                        bzB.a(g, bundle, false);
                    } else {
                        intent.putExtra("Contact_User", g);
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_from_scene", 4);
                        com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                    }
                }
            } else if (r.a(intent, "jump_sns_from_notify", false)) {
                r0 = new Intent();
                r0.addFlags(67108864);
                r0.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                r0.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                r0.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                com.tencent.mm.ay.c.b((Context) this, "sns", ".ui.SnsTimeLineUI", r0);
            }
            if (r.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                r0 = new Intent();
                r0.setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
                r0.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                r0.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                MMWizardActivity.w(this, r0);
            }
        }
    }

    public final void da(int i, int i2) {
        if (i != i2) {
            if (i2 == 2) {
                com.tencent.mm.booter.k.run();
            }
            if (this.nBZ != i2 || this.nCa != i) {
                this.nBZ = i2;
                this.nCa = i;
                vx(i);
                p vx = vx(i2);
                if (vx != null && (vx instanceof i)) {
                    ((i) vx).bzm();
                }
                db(4, i);
                db(3, i2);
            }
        }
    }

    public final void vv(int i) {
        p vx = vx(i);
        if (vx != null && (vx instanceof i)) {
            ((i) vx).byE();
            if (this.nBO != null) {
                this.nBO.reset();
            }
        }
    }

    public final void iO(boolean z) {
        if (this.nBs != null) {
            this.nBs.CM = z;
        }
        if (this.nBr != null) {
            ((View) this.nBr).setVisibility(z ? 0 : 8);
        }
    }

    public final void a(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.LauncherUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.nCe == null ? false : this.nCe.isShown());
        v.i(str2, str3, objArr);
        this.nCi = bundle;
        this.nCh = str;
        this.nCm = z;
        ak.vA().btt();
        ad.va(-8);
        if (this.nBd) {
            v.i("MicroMsg.LauncherUI", "remove setTagRunnable");
            ad.B(this.nBD);
        }
        ad.o(this.nCj);
        if (!com.tencent.mm.model.k.yo().booleanValue()) {
            return;
        }
        if (nBw.booleanValue() || nBx.booleanValue()) {
            c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
    }

    private ViewGroup bzG() {
        ViewParent parent = this.FG.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            ViewParent viewParent3 = parent;
            parent = parent.getParent();
            viewParent = viewParent3;
        }
        return (ViewGroup) viewParent;
    }

    private boolean bzH() {
        List<Fragment> aX = aS().aX();
        if (aX == null) {
            v.i("MicroMsg.LauncherUI", "fragments is null");
            return true;
        }
        if (aX.size() >= 5) {
            v.e("MicroMsg.LauncherUI", "fragments more than 5! %s", Integer.valueOf(aX.size()));
            for (Fragment fragment : aX) {
                if (fragment instanceof com.tencent.mm.ui.chatting.ChattingUI.a) {
                    v.e("MicroMsg.LauncherUI", "fragments more than 5 and find a ChattingUIFragmet!!");
                    return false;
                }
            }
        }
        v.i("MicroMsg.LauncherUI", "fragments size %s", Integer.valueOf(aX.size()));
        return true;
    }

    private void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = cU().cV().getCustomView().getBottom();
        if (this.nBr == null || !(this.nBr instanceof View)) {
            i2 = 0;
        } else {
            i2 = bottom - (((View) this.nBr).getBottom() + (i + bottom2));
        }
        v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.nCL = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    public final void iP(boolean z) {
        String str = "MicroMsg.LauncherUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.nCe == null ? false : this.nCe.isShown());
        v.i(str, str2, objArr);
        if (this.nCd != null && this.nCd.bAm()) {
            com.tencent.mm.ui.widget.j.b(this);
        }
        if (this.nCe != null && this.nCe.getVisibility() != 8 && this.nCd != null) {
            v.i("MicroMsg.LauncherUI", "closeChatting");
            bzE();
            com.tencent.mm.modelstat.d.a(4, "ChattingUI" + this.nCd.bFo(), this.nCd.hashCode());
            com.tencent.mm.modelstat.d.d("ChattingUI" + this.nCd.bFo(), this.nBE, t.Nh());
            this.nCe.setVisibility(8);
            this.nCo = true;
            if (this.nCl == null) {
                this.nCl = AnimationUtils.loadAnimation(this, com.tencent.mm.ui.MMFragmentActivity.a.nFH);
                this.nCl.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        ak.vA().btt();
                        ad.va(-8);
                        v.i("MicroMsg.LauncherUI", "klem pop out onAnimationStart");
                        LauncherUI.d(this.nCs, true);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        ak.vA().btw();
                        ad.va(0);
                        if (this.nCs.nBd) {
                            v.i("MicroMsg.LauncherUI", "start  setAppTagUnreadNow");
                            this.nCs.bzs();
                        }
                        this.nCs.bzL();
                        v.i("MicroMsg.LauncherUI", "klem pop out onAnimationEnd");
                    }
                });
            }
            this.nCd.onPause();
            this.nCd.bFg();
            this.nCd.cSL = false;
            com.tencent.mm.sdk.c.b etVar = new et();
            etVar.bdx.aYt = 1;
            etVar.bdx.bdy = 0;
            com.tencent.mm.sdk.c.a.nhr.z(etVar);
            db(3, this.nBM);
            w.a(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
            if (z) {
                this.nCe.startAnimation(this.nCl);
            } else {
                I(1.0f);
                bzL();
            }
            if (!this.nCd.bAm()) {
                bzI();
            }
            aR();
            com.tencent.mm.ui.conversation.d dVar = (com.tencent.mm.ui.conversation.d) this.nCr.get(Integer.valueOf(0));
            if (dVar != null) {
                View view = dVar.nDR.dtW;
                if (dVar.nDR != null) {
                    dVar.nDR.onResume();
                }
            }
            if (com.tencent.mm.model.k.yo().booleanValue()) {
                bzw();
            }
        }
    }

    private void bzI() {
        if (this.nCd == null || !this.nCd.cSL) {
            this.FG.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.FG.cQ();
            this.FG.setDisplayHomeAsUpEnabled(false);
            this.FG.cP();
            this.FG.cR();
            this.FG.setCustomView(q.em(this).inflate(2130903078, new LinearLayout(this), false));
            adg();
            this.FG.getCustomView().findViewById(2131755286).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void onClick(View view) {
                    if (SystemClock.elapsedRealtime() - this.nCs.jUx < 300) {
                        Iterator it = this.nCs.nCp.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                    this.nCs.jUx = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public final void P(Runnable runnable) {
        if (!this.nCp.contains(runnable)) {
            this.nCp.add(runnable);
        }
    }

    public final void Q(Runnable runnable) {
        this.nCp.remove(runnable);
    }

    public final void NX(String str) {
        if (str != null && !str.equals(SQLiteDatabase.KeyEmpty)) {
            vw(((Integer) nCq.get(str)).intValue());
        }
    }

    private void vw(int i) {
        v.i("MicroMsg.LauncherUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", Integer.valueOf(i), Integer.valueOf(this.nBM), Boolean.valueOf(this.nBl), Integer.valueOf(this.nCr.size()));
        if (this.nBl && i >= 0) {
            if (this.nBt != null && i > this.nBt.getCount() - 1) {
                return;
            }
            if (this.nBM != i || this.nCr.size() == 0) {
                this.nBM = i;
                if (this.nBr != null) {
                    this.nBr.kg(this.nBM);
                }
                if (this.nBs != null) {
                    this.nBs.k(this.nBM, false);
                    vv(this.nBM);
                }
            }
        }
    }

    public final p vx(int i) {
        p pVar = null;
        v.i("MicroMsg.LauncherUI", "get tab %d", Integer.valueOf(i));
        if (i < 0) {
            return null;
        }
        if (this.nCr.containsKey(Integer.valueOf(i))) {
            return (p) this.nCr.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                pVar = (p) Fragment.a((Context) this, com.tencent.mm.ui.conversation.d.class.getName(), null);
                break;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                pVar = (p) Fragment.a((Context) this, com.tencent.mm.ui.contact.AddressUI.a.class.getName(), bundle);
                break;
            case 2:
                pVar = (p) Fragment.a((Context) this, g.class.getName(), null);
                break;
            case 3:
                com.tencent.mm.ay.c.brh();
                pVar = (p) Fragment.a((Context) this, r.class.getName(), null);
                break;
        }
        v.v("MicroMsg.LauncherUI", "createFragment index:%d", Integer.valueOf(i));
        if (pVar != null) {
            pVar.a(this);
        }
        this.nCr.put(Integer.valueOf(i), pVar);
        return pVar;
    }

    public final int bzJ() {
        int a;
        long currentTimeMillis = System.currentTimeMillis();
        if (ak.uz()) {
            a = n.a(com.tencent.mm.model.m.crA, x.bAI());
            v.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", Integer.valueOf(a));
        } else {
            v.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            a = 0;
        }
        vy(a);
        v.d("MicroMsg.LauncherUI", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(a));
        return a;
    }

    public final void vy(int i) {
        if (this.nBr != null) {
            this.nBr.vq(i);
            adg();
        }
    }

    private void bzK() {
        ad.o(new Runnable(this) {
            final /* synthetic */ LauncherUI nCs;

            {
                this.nCs = r1;
            }

            public final void run() {
                int f;
                if (ak.uz()) {
                    ak.yW();
                    f = t.f((Integer) com.tencent.mm.model.c.vf().get(143618, null));
                } else {
                    v.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                    f = 0;
                }
                if (this.nCs.nBr != null) {
                    this.nCs.nBr.vr(f);
                }
            }

            public final String toString() {
                return super.toString() + "|setAddressTagUnread";
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Object[] objArr;
        int i = 3;
        boolean z = true;
        v.i("MicroMsg.LauncherUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ad.B(this.nCj);
        }
        if (this.nCd == null || !this.nCd.cSL) {
            AudioManager audioManager;
            int streamMaxVolume;
            int streamVolume;
            if (keyEvent.getKeyCode() == 25 && keyEvent.getAction() == 0 && ak.uz()) {
                audioManager = (AudioManager) getSystemService("audio");
                if (!com.tencent.mm.ai.b.HC()) {
                    i = 5;
                }
                streamMaxVolume = audioManager.getStreamMaxVolume(i);
                streamVolume = audioManager.getStreamVolume(i);
                streamMaxVolume /= 7;
                if (streamMaxVolume == 0) {
                    streamMaxVolume = z;
                }
                audioManager.setStreamVolume(i, Math.max(0, streamVolume - streamMaxVolume), 5);
                return z;
            } else if (keyEvent.getKeyCode() == 24 && keyEvent.getAction() == 0 && ak.uz()) {
                audioManager = (AudioManager) getSystemService("audio");
                if (!com.tencent.mm.ai.b.HC()) {
                    i = 5;
                }
                streamVolume = audioManager.getStreamMaxVolume(i);
                int streamVolume2 = audioManager.getStreamVolume(i);
                streamMaxVolume = streamVolume / 7;
                if (streamMaxVolume == 0) {
                    streamMaxVolume = z;
                }
                if (streamVolume2 >= streamVolume) {
                    v.i("MicroMsg.LauncherUI", "has set the max volume");
                    streamMaxVolume = 0;
                }
                audioManager.setStreamVolume(i, streamMaxVolume + streamVolume2, 5);
                return z;
            } else if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == z && this.nBu != null && this.nBu.isShowing()) {
                this.nBu.dismiss();
                return z;
            } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == z) {
                bzx();
                return z;
            } else if (this.nBt != null && keyEvent.getAction() == 0 && ((p) this.nBt.I(this.nBs.xB)).onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                return z;
            } else {
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                    if (com.tencent.mm.app.g.om().aQM) {
                        return z;
                    }
                    if (this.nBO == null || this.nBO.getVisibility() != 0) {
                        if (ak.uz() && !ak.yZ() && com.tencent.mm.sdk.platformtools.ak.isWap((Context) this)) {
                            boolean z2;
                            DialogInterface.OnClickListener anonymousClass32 = new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LauncherUI nCs;

                                {
                                    this.nCs = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.nCs.byz();
                                }
                            };
                            if (ak.uz()) {
                                ak.yW();
                                streamMaxVolume = ((Integer) com.tencent.mm.model.c.vf().get(65, Integer.valueOf(0))).intValue();
                                if (streamMaxVolume >= 5) {
                                    z2 = false;
                                } else if (ab.Ki("show_wap_adviser")) {
                                    View inflate = View.inflate(this, 2130904126, null);
                                    ((TextView) inflate.findViewById(2131758446)).setText(2131234030);
                                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
                                    aVar.wm(2131231164);
                                    aVar.cC(inflate);
                                    aVar.wp(2131231107).a(new com.tencent.mm.ui.MMAppMgr.AnonymousClass9(streamMaxVolume));
                                    aVar.jk(false);
                                    aVar.wq(2131234027).b(new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            ak.yW();
                                            c.vf().set(65, Integer.valueOf(5));
                                        }
                                    });
                                    aVar.a(new com.tencent.mm.ui.MMAppMgr.AnonymousClass11(anonymousClass32));
                                    aVar.RX().show();
                                    z2 = z;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                return z;
                            }
                        }
                        i = com.tencent.mm.sdk.platformtools.ak.getBackgroundLimitType(this);
                        if (ak.uz() && !ak.yZ() && com.tencent.mm.sdk.platformtools.ak.isLimited(i)) {
                            ak.yW();
                            if (t.b((Boolean) com.tencent.mm.model.c.vf().get(16385, null)) && MMAppMgr.a(this, i, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LauncherUI nCs;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        com.tencent.mm.sdk.platformtools.ak.startSettingItent(this.nCs, i);
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.LauncherUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LauncherUI nCs;

                                {
                                    this.nCs = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.nCs.byz();
                                }
                            })) {
                                return z;
                            }
                        }
                        byz();
                    } else {
                        this.nBO.bpa();
                        return z;
                    }
                }
                try {
                    return super.dispatchKeyEvent(keyEvent);
                } catch (Throwable e) {
                    objArr = new Object[z];
                    objArr[0] = e.getMessage();
                    v.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", objArr);
                    v.a("MicroMsg.LauncherUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return 0;
                }
            }
        } else if (this.nCd.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return z;
        } else {
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e2) {
                objArr = new Object[z];
                objArr[0] = e2.getMessage();
                v.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", objArr);
                v.a("MicroMsg.LauncherUI", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                return 0;
            }
        }
    }

    private void byz() {
        moveTaskToBack(true);
        if (ak.uz()) {
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void run() {
                    if (ak.uz()) {
                        ak.yW();
                        com.tencent.mm.storage.r vf = com.tencent.mm.model.c.vf();
                        if (vf != null) {
                            vf.iB(true);
                        }
                    }
                }
            }, 500);
        }
        com.tencent.mm.app.j ot = com.tencent.mm.app.j.ot();
        ot.aRp = false;
        ot.aRq.removeMessages(-1999);
        ot.aRq.removeMessages(-2999);
        ot.aRq.sendEmptyMessageDelayed(-1999, 3000);
        ot.aRq.sendEmptyMessageDelayed(-2999, 30000);
    }

    public final void a(int i, j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.LauncherUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        ak.yW();
        if (jVar == com.tencent.mm.model.c.wK()) {
            v.d("MicroMsg.LauncherUI", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i), obj);
            if (com.tencent.mm.storage.u.ew((String) obj)) {
                bzt();
            }
        }
    }

    public final void I(float f) {
        v.v("MicroMsg.LauncherUI", "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(240), this.nBB);
        if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            if (a.ACTIVITY_RESUME != this.nBB) {
                super.I(f);
                if (Float.compare(1.0f, f) > 0) {
                    return;
                }
            }
            View findViewById = findViewById(2131755055);
            if (Float.compare(1.0f, f) <= 0) {
                com.tencent.mm.ui.tools.j.m(findViewById, 0.0f);
            } else {
                com.tencent.mm.ui.tools.j.m(findViewById, (((float) (findViewById.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            }
        }
    }

    private void bzL() {
        boolean z = true;
        if (com.tencent.mm.compatible.util.d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            String str = "MicroMsg.LauncherUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.nCd != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            if (this.nCd != null) {
                this.nCd.nFw.paQ = false;
            }
        }
    }

    public final void c(boolean z, int i) {
        long j = 120;
        v.v("MicroMsg.LauncherUI", "ashutest: on settle %B, speed %d, status %s", Boolean.valueOf(z), Integer.valueOf(i), this.nBB);
        if (!com.tencent.mm.compatible.util.d.dW(19) || !com.tencent.mm.compatible.h.a.sh()) {
            return;
        }
        if (a.ACTIVITY_RESUME != this.nBB) {
            super.c(z, i);
            return;
        }
        View findViewById = findViewById(2131755055);
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(findViewById, j, 0.0f, 0.125f);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
    }

    public final boolean Ri() {
        return true;
    }

    public void onRequestPermissionsResult(final int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            ad.g(new Runnable(this) {
                final /* synthetic */ LauncherUI nCs;

                {
                    this.nCs = r1;
                }

                public final void run() {
                    this.nCs.iN(true);
                }

                public final String toString() {
                    return super.toString() + "|onInitDelay";
                }
            }, 500);
            return;
        }
        v.i("MicroMsg.LauncherUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 16:
            case 80:
                i2 = i == 80 ? 2131234163 : 2131234160;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case android.support.v7.a.a.k.MG /*18*/:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.nCd != null) {
                    this.nCd.bGi();
                    return;
                } else {
                    return;
                }
            case 19:
            case 21:
            case android.support.v7.a.a.k.MM /*22*/:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LauncherUI nCs;

                            {
                                this.nCs = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.nCd == null) {
                    return;
                } else {
                    if (i == 19) {
                        this.nCd.aGQ();
                        return;
                    } else if (i == 21) {
                        this.nCd.bEr();
                        return;
                    } else {
                        this.nCd.bEo();
                        return;
                    }
                }
            case 20:
                if (iArr[0] == 0) {
                    this.nCd.bEt();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            case FileUtils.S_IRGRP /*32*/:
            case FileUtils.S_IXUSR /*64*/:
            case 96:
                i2 = 2131234165;
                if (i == 96) {
                    i2 = 2131234164;
                } else if (i == 64) {
                    i2 = 2131234162;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        com.tencent.mm.plugin.report.b.itm.a(462, 0, 1, true);
                    } else if (i == 96) {
                        com.tencent.mm.plugin.report.b.itm.a(462, 1, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.b.itm.a(462, 2, 1, true);
                    }
                    iN(true);
                    return;
                }
                com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LauncherUI nCs;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 32) {
                            com.tencent.mm.plugin.report.b.itm.a(462, 3, 1, true);
                        } else if (i == 96) {
                            com.tencent.mm.plugin.report.b.itm.a(462, 4, 1, true);
                        } else {
                            com.tencent.mm.plugin.report.b.itm.a(462, 5, 1, true);
                        }
                        Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.nCs.startActivity(intent);
                        dialogInterface.dismiss();
                        MMAppMgr.a(this.nCs, true);
                        this.nCs.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LauncherUI nCs;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 32) {
                            com.tencent.mm.plugin.report.b.itm.a(462, 6, 1, true);
                        } else if (i == 96) {
                            com.tencent.mm.plugin.report.b.itm.a(462, 7, 1, true);
                        } else {
                            com.tencent.mm.plugin.report.b.itm.a(462, 8, 1, true);
                        }
                        dialogInterface.dismiss();
                        MMAppMgr.a(this.nCs, true);
                        this.nCs.finish();
                    }
                });
                return;
            case 33:
            case 70:
            case 97:
                i2 = 2131234165;
                if (i == 97) {
                    i2 = 2131234164;
                } else if (i == 70) {
                    i2 = 2131234162;
                }
                if (iArr[0] != 0) {
                    this.ijq = false;
                    com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 33) {
                                com.tencent.mm.plugin.report.b.itm.a(462, 12, 1, true);
                            } else if (i == 97) {
                                com.tencent.mm.plugin.report.b.itm.a(462, 13, 1, true);
                            } else {
                                com.tencent.mm.plugin.report.b.itm.a(462, 14, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            this.nCs.startActivity(intent);
                            dialogInterface.dismiss();
                            this.nCs.ijq = true;
                            MMAppMgr.a(this.nCs, true);
                            this.nCs.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 33) {
                                com.tencent.mm.plugin.report.b.itm.a(462, 15, 1, true);
                            } else if (i == 97) {
                                com.tencent.mm.plugin.report.b.itm.a(462, 16, 1, true);
                            } else {
                                com.tencent.mm.plugin.report.b.itm.a(462, 17, 1, true);
                            }
                            dialogInterface.dismiss();
                            this.nCs.ijq = true;
                            MMAppMgr.a(this.nCs, true);
                            this.nCs.finish();
                        }
                    });
                    return;
                } else if (i == 33) {
                    com.tencent.mm.plugin.report.b.itm.a(462, 9, 1, true);
                    return;
                } else if (i == 97) {
                    com.tencent.mm.plugin.report.b.itm.a(462, 10, 1, true);
                    return;
                } else {
                    com.tencent.mm.plugin.report.b.itm.a(462, 11, 1, true);
                    return;
                }
            case 65:
                if (iArr[0] == 0) {
                    bzz();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            case 66:
                if (iArr[0] == 0) {
                    p vx = vx(this.nBM);
                    if (vx instanceof g) {
                        ((g) vx).bzk();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            case 67:
            case 68:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (i == 67) {
                    this.nCd.bFO();
                    return;
                } else {
                    this.nCd.bFP();
                    return;
                }
            case 81:
                if (iArr[0] == 0) {
                    this.nCd.bEs();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nCs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (i == 82) {
                    this.nCd.aGP();
                    return;
                } else {
                    this.nCd.bEq();
                    return;
                }
            default:
                return;
        }
    }

    private void db(int i, int i2) {
        v.v("MicroMsg.LauncherUI", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i2), Integer.valueOf(i), t.Nm());
        if (i2 >= 0) {
            String str = "MainUI";
            if (i2 == 1) {
                str = "AddressUI";
            }
            if (i2 == 2) {
                str = "FindMoreFriendUI";
            }
            if (i2 == 3) {
                str = "MoreTabUI";
            }
            com.tencent.mm.modelstat.d.a(i, str, ((hashCode() / 16) * 16) + i2);
        }
    }

    public final p bzM() {
        if (this.nCo) {
            return super.bzM();
        }
        return this.nCd;
    }

    private void bzN() {
        if (this.iLp != null) {
            this.iLp.show();
            return;
        }
        if (this.iLm == null) {
            this.iLm = View.inflate(this, 2130904345, null);
            this.iLn = (TextView) this.iLm.findViewById(2131759061);
            this.iLn.setText(getString(2131235028));
            this.iLo = (EditText) this.iLm.findViewById(2131759062);
            this.iLo.setInputType(129);
        }
        this.iLp = com.tencent.mm.ui.base.g.a((Context) this, null, this.iLm, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ LauncherUI nCs;

            {
                this.nCs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                String obj = this.nCs.iLo.getText().toString();
                this.nCs.iLo.setText(SQLiteDatabase.KeyEmpty);
                this.nCs.iLo.clearFocus();
                t.a(this.nCs, this.nCs.iLo);
                if (obj == null || obj.equals(SQLiteDatabase.KeyEmpty)) {
                    com.tencent.mm.ui.base.g.a(this.nCs, 2131235780, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass55 nCF;

                        {
                            this.nCF = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                this.nCs.bzD();
                ak.vy().a(384, this.nCs.nBi);
                final k agVar = new ag(obj, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                ak.vy().a(agVar, 0);
                LauncherUI launcherUI = this.nCs;
                Context context = this.nCs;
                this.nCs.getString(2131231164);
                launcherUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nCs.getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass55 nCF;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().b(384, this.nCF.nCs.nBi);
                        this.nCF.nCs.nBi = null;
                        ak.vy().c(agVar);
                    }
                });
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ LauncherUI nCs;

            {
                this.nCs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.nCs.iLo.setText(SQLiteDatabase.KeyEmpty);
                this.nCs.iLp.dismiss();
            }
        });
    }
}
