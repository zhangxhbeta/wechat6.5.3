package com.tencent.mm.console;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.console.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.aw;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.bn;
import com.tencent.mm.e.a.bq;
import com.tencent.mm.e.a.br;
import com.tencent.mm.e.a.bs;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.ni;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.e.a.oa;
import com.tencent.mm.e.a.rh;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.h.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.pluginsdk.j.am;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.SightForwardUI;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static {
        com.tencent.mm.console.a.b.init();
        f.init();
        g.init();
        e.init();
        c.init();
        d.init();
        a.init();
    }

    private static int dH(String str) {
        if (!str.startsWith("//") || str.length() <= 2) {
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = be.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.lWh % FileUtils.S_IRUSR;
            if (indexOf < i || indexOf % i != 0) {
                return 0;
            }
            return indexOf / i;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String dI(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str.substring(indexOf).trim();
    }

    public static boolean w(Context context, String str) {
        if (!str.startsWith("//")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.a.b.aK(context, str)) {
            return true;
        }
        if (str.startsWith("//clearWXSNSDB")) {
            com.tencent.mm.sdk.c.a.nhr.z(new ni());
            return true;
        }
        if (str.startsWith("//verifytokenerror")) {
            q.dre = true;
            return true;
        }
        StringBuilder stringBuilder;
        if (str.equalsIgnoreCase("//ftsmsbiz")) {
            ajo Ik = i.Ik();
            stringBuilder = new StringBuilder();
            Iterator it = Ik.eeu.iterator();
            while (it.hasNext()) {
                ajn com_tencent_mm_protocal_c_ajn = (ajn) it.next();
                stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{l.er(com_tencent_mm_protocal_c_ajn.mdw), Double.valueOf(com_tencent_mm_protocal_c_ajn.mJT), o.F("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_ajn.mJU / 1000)}));
                stringBuilder.append("\n");
            }
            View textView = new TextView(context);
            textView.setText(stringBuilder.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493135);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            com.tencent.mm.ui.base.g.a(context, null, textView, null);
            return true;
        }
        if (am.bmC() != null) {
            if (str.equalsIgnoreCase("//wearversion")) {
                textView = new TextView(context);
                textView.setText(am.bmC().bhJ());
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16711936);
                textView.setTypeface(Typeface.MONOSPACE);
                dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493135);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                com.tencent.mm.ui.base.g.a(context, null, textView, null);
                return true;
            }
            if (str.equalsIgnoreCase("//wearlog")) {
                am.bmC().bhK();
                return true;
            }
            if (str.equalsIgnoreCase("//wearreconnect")) {
                return true;
            }
        }
        if (str.startsWith("//appbrandtest")) {
            com.tencent.mm.sdk.c.b oVar = new com.tencent.mm.e.a.o();
            oVar.aWV.aWW = str;
            com.tencent.mm.sdk.c.a.nhr.z(oVar);
            return true;
        }
        if (str.startsWith("//wxafts")) {
            oVar = new rh();
            oVar.enc.aWW = str;
            com.tencent.mm.sdk.c.a.nhr.z(oVar);
            return true;
        }
        if (str.startsWith("//testsightwidget")) {
            Intent intent = new Intent();
            intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
            intent.putExtra("KSightThumbPath", SQLiteDatabase.KeyEmpty);
            intent.putExtra("sight_md5", com.tencent.mm.a.g.aX("/mnt/sdcard/tencent/tempvideo4.mp4"));
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", be.Nh());
            intent.putExtra("Ksnsupload_type", 14);
            com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsUploadUI", intent);
            return true;
        }
        if (str.startsWith("//ftstemplatetest")) {
            oVar = new ar();
            oVar.aYn.aYo = 27;
            oVar.aYn.aYo = 1;
            oVar.aYn.filePath = "/sdcard/fts_template.zip";
            com.tencent.mm.sdk.c.a.nhr.z(oVar);
        }
        if (str.startsWith("//sightforward")) {
            context.startActivity(new Intent(context, SightForwardUI.class));
            return true;
        }
        String str2;
        String[] split;
        if (str.startsWith("//uplog")) {
            str2 = "weixin";
            if (ak.uz()) {
                str2 = k.xF();
            }
            split = str.split(" ");
            dimensionPixelSize = 0;
            if (split != null) {
                if (split.length > 1) {
                    dimensionPixelSize = be.getInt(split[1], 0);
                }
                if (split.length > 2) {
                    str2 = split[2];
                }
            }
            ak.vy().d(new ay(new ay.a() {
                public final void a(com.tencent.mm.network.e eVar) {
                    ak.vy().a(1, SQLiteDatabase.KeyEmpty, 0, false);
                    v.bta();
                    ak.vy().a(2, str2, dimensionPixelSize, ak.uz());
                }
            }));
            context.getString(2131231164);
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, context.getString(2131236692), false, null);
            final Context context2 = context;
            ak.a(new y() {
                public final void eh(int i) {
                    v.i("MicroMsg.CommandProcessor", "ipxx progress:%d", Integer.valueOf(i));
                    if (i < 0) {
                        ak.a(null);
                        a.dismiss();
                        com.tencent.mm.ui.base.g.f(context2, 2131235726, 2131231164);
                    } else if (i >= 100) {
                        ak.a(null);
                        a.dismiss();
                        com.tencent.mm.ui.base.g.f(context2, 2131235730, 2131231164);
                    } else {
                        a.setMessage(context2.getString(2131235727) + i + "%");
                    }
                }
            });
            return true;
        }
        if (str.startsWith("//upcrash")) {
            str2 = "weixin";
            if (ak.uz()) {
                str2 = k.xF();
            }
            split = str.split(" ");
            dimensionPixelSize = 0;
            if (split != null) {
                if (split.length > 1) {
                    dimensionPixelSize = be.getInt(split[1], 0);
                }
                if (split.length > 2) {
                    str2 = split[2];
                }
            }
            ak.vy().d(new ay(new ay.a() {
                public final void a(com.tencent.mm.network.e eVar) {
                    ak.vy().a(3, str2, dimensionPixelSize, ak.uz());
                }
            }));
            return true;
        }
        if (str.startsWith("//switchnotificationstatus")) {
            com.tencent.mm.h.i.aC(!com.tencent.mm.h.a.ss());
            return true;
        }
        if (str.startsWith("//fixError0831")) {
            v.i("MicroMsg.CommandProcessor", "fixError0831");
            com.tencent.mm.sdk.c.a.nhr.z(new aw());
            return true;
        }
        if (str.startsWith("//cleanpaycn")) {
            v.i("MicroMsg.CommandProcessor", "cleanpaycn");
            com.tencent.mm.sdk.c.a.nhr.z(new az());
            return true;
        }
        if (str.startsWith("//busiluck ")) {
            str2 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + str.replace("//busiluck ", SQLiteDatabase.KeyEmpty);
            Intent intent2 = new Intent();
            intent2.putExtra("key_way", 5);
            intent2.putExtra("key_native_url", str2);
            com.tencent.mm.ay.c.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
            return true;
        }
        if (str.startsWith("//testsoter")) {
            com.tencent.mm.ay.c.w(context, "soter", ".test.SoterTestUI");
            return true;
        }
        if (str.startsWith("//newyearsw ")) {
            ak.yW();
            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
            return true;
        }
        if (str.startsWith("//commitxlog")) {
            ak.vy().a(1, SQLiteDatabase.KeyEmpty, 0, false);
            v.bta();
            return true;
        }
        if (str.startsWith("//netstatus")) {
            final String dN = com.tencent.mm.sdk.platformtools.ak.dN(aa.getContext());
            context2 = context;
            com.tencent.mm.ui.base.g.b(context, dN, "netstatus", context.getString(2131235913), context.getString(2131231975), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((ClipboardManager) context2.getSystemService("clipboard")).setText(dN);
                }
            }, null);
            return true;
        }
        long j;
        if (str.startsWith("//scaninterval ")) {
            j = -1;
            try {
                j = be.getLong(str.split(" ")[1], -1);
            } catch (Exception e) {
            }
            if (j > 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                v.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                return true;
            }
        }
        if (str.startsWith("//scanwait ")) {
            j = -1;
            try {
                j = be.getLong(str.split(" ")[1], -1);
            } catch (Exception e2) {
            }
            if (j > 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                v.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                return true;
            }
        }
        if (str.equalsIgnoreCase("//swipe")) {
            SharedPreferences btk = aa.btk();
            btk.edit().putBoolean("settings_support_swipe", !btk.getBoolean("settings_support_swipe", true)).commit();
            return true;
        }
        if (str.equalsIgnoreCase("//multiwebview")) {
            btk = LauncherUI.bzB().getSharedPreferences(aa.bti(), 0);
            btk.edit().putBoolean("settings_multi_webview", !btk.getBoolean("settings_multi_webview", false)).commit();
            return true;
        }
        if (str.equalsIgnoreCase("//sightinfo")) {
            ak.yW();
            boolean booleanValue = ((Boolean) com.tencent.mm.model.c.vf().get(344065, Boolean.valueOf(false))).booleanValue();
            ak.yW();
            com.tencent.mm.model.c.vf().set(344065, Boolean.valueOf(!booleanValue));
            ak.yW();
            com.tencent.mm.model.c.vf().iB(true);
            return true;
        }
        if (str.startsWith("//sighttest")) {
            intValue = be.KL(str.replace("//sighttest ", SQLiteDatabase.KeyEmpty));
            ak.yW();
            com.tencent.mm.model.c.vf().set(344066, Integer.valueOf(intValue));
            ak.yW();
            com.tencent.mm.model.c.vf().iB(true);
            return true;
        }
        if (str.startsWith("//wxcamera")) {
            v.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(be.KL(str.replace("//wxcamera ", SQLiteDatabase.KeyEmpty))));
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(intValue));
            return true;
        }
        if (str.startsWith("//printcrash")) {
            str2 = str.replace("//printcrash ", SQLiteDatabase.KeyEmpty);
            View textView2 = new TextView(context);
            textView2.setText(ee(be.getInt(str2, 0)));
            textView2.setGravity(19);
            textView2.setTextSize(1, 8.0f);
            textView2.setLayoutParams(new LayoutParams(-1, -2));
            textView2.setTextColor(-16711936);
            textView2.setTypeface(Typeface.MONOSPACE);
            intValue = context.getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peR);
            textView2.setPadding(intValue, intValue, intValue, intValue);
            textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
            com.tencent.mm.ui.base.g.a(context, null, textView2, null);
            return true;
        }
        if (str.equals("//testrsa")) {
            ad.y("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
            return true;
        }
        if (str.equals("//testrsabad")) {
            ad.y("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
            return true;
        }
        if (str.equals("//walletofflinetest")) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
            return false;
        }
        if (str.startsWith("//makemsgdata ")) {
            intValue = be.getInt(str.split(" ")[1], 0);
            ak.yW();
            com.tencent.mm.model.c.wJ().R(ChattingUI.a.osT, (long) intValue);
            return true;
        }
        if (str.startsWith("//pullappservice")) {
            an.bnG().dj(aa.getContext());
            return true;
        }
        if (str.startsWith("//boundaryconfig")) {
            v.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitSessionTextMsg"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitSNSObjectText"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("SnsCommentMaxSize"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitFavText"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitSendEmotionBufSize"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitSendEmotionWidth"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitFavImageSize"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitFavVoiceLength"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitSessionShortVideoBufSize"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitVideoSize"), 0)));
            v.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(be.getInt(j.sU().getValue("InputLimitFileSize"), 0)));
            return true;
        }
        if (str.startsWith("//whatsnew")) {
            MMAppMgr.X((Activity) context);
            return true;
        }
        u LX;
        if (str.startsWith("//profile ")) {
            ak.yW();
            LX = com.tencent.mm.model.c.wH().LX(str.replace("//profile ", SQLiteDatabase.KeyEmpty).trim());
            if (!(LX == null || LX.tS() == 0)) {
                intent2 = new Intent();
                intent2.putExtra("Contact_User", LX.getUsername());
                com.tencent.mm.ay.c.b(context, "profile", ".ui.ContactInfoUI", intent2);
            }
            return true;
        }
        if (str.startsWith("//cs")) {
            intent = new Intent();
            intent.putExtra("voipCSBizId", "gh_b35727b00b78");
            intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
            com.tencent.mm.ay.c.b(aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            return true;
        }
        if (str.startsWith("//acs")) {
            intent = new Intent();
            intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
            intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
            com.tencent.mm.ay.c.b(aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            return true;
        }
        if (str.startsWith("//bcs")) {
            intent = new Intent();
            intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
            intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
            intent.putExtra("voipCSAllowBackCamera", "1");
            intent.putExtra("voipCSShowOther", "1");
            intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
            intent.putExtra("voipCSContext", "test");
            com.tencent.mm.ay.c.b(aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            return true;
        }
        if (str.startsWith("//getfpkey")) {
            dN = com.tencent.mm.storage.az.bxj();
            context2 = context;
            com.tencent.mm.ui.base.g.b(context, dN, "Fingerprint Key", context.getString(2131235913), context.getString(2131231975), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((ClipboardManager) context2.getSystemService("clipboard")).setText(dN);
                    Toast.makeText(context2, 2131235914, 0).show();
                }
            }, null);
            return true;
        }
        if (str.startsWith("//commitwd")) {
            WatchDogPushReceiver.Kn();
            return true;
        }
        String str3;
        String str4;
        if (str.startsWith("//setsnstestenv")) {
            String[] split2 = str.split(" +");
            if (split2.length > 1) {
                str3 = split2[1];
                if (p.isIPv4Address(str3) || p.isIPv6Address(str3)) {
                    if (split2.length > 2) {
                        str4 = split2[2];
                        if (p.isIPv4Address(str4) || p.isIPv6Address(str4)) {
                            dN = split2.length > 3 ? split2[3] : null;
                            q.dqC = str3 != null;
                            q.dqt = str3;
                            q.dqY = str4;
                            q.dqZ = dN;
                            ak.vy().d(new com.tencent.mm.modelcdntran.e());
                            Toast.makeText(context, String.format("%s %s %s", new Object[]{q.dqt, q.dqY, q.dqZ}), 1).show();
                            return true;
                        }
                    }
                    str4 = null;
                    dN = null;
                    if (str3 != null) {
                    }
                    q.dqC = str3 != null;
                    q.dqt = str3;
                    q.dqY = str4;
                    q.dqZ = dN;
                    ak.vy().d(new com.tencent.mm.modelcdntran.e());
                    Toast.makeText(context, String.format("%s %s %s", new Object[]{q.dqt, q.dqY, q.dqZ}), 1).show();
                    return true;
                }
            }
            str3 = null;
            str4 = null;
            dN = null;
            if (str3 != null) {
            }
            q.dqC = str3 != null;
            q.dqt = str3;
            q.dqY = str4;
            q.dqZ = dN;
            ak.vy().d(new com.tencent.mm.modelcdntran.e());
            Toast.makeText(context, String.format("%s %s %s", new Object[]{q.dqt, q.dqY, q.dqZ}), 1).show();
            return true;
        }
        String[] split3;
        if (str.startsWith("//snsvcodec")) {
            split3 = str.split(" +");
            if (split3.length > 1) {
                str2 = split3[1];
                if ("on".equalsIgnoreCase(str2)) {
                    ef(1);
                    v.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                } else if ("off".equalsIgnoreCase(str2)) {
                    ef(0);
                    v.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                }
            } else {
                ef(-1);
                v.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
            }
            return true;
        }
        if (str.startsWith("//snswxpc")) {
            split3 = str.split(" +");
            if (split3.length > 1) {
                str2 = split3[1];
                if ("on".equalsIgnoreCase(str2)) {
                    eg(1);
                    v.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                } else if ("off".equalsIgnoreCase(str2)) {
                    eg(0);
                    v.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                }
            } else {
                eg(-1);
                v.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
            }
            return true;
        }
        if (str.startsWith("//mmdumpsys")) {
            ak.vA().x(new Runnable() {
                public final void run() {
                    new ah(new ah.a(this) {
                        final /* synthetic */ AnonymousClass12 chl;

                        {
                            this.chl = r1;
                        }

                        public final boolean oU() {
                            LineNumberReader lineNumberReader;
                            Exception e;
                            Throwable th;
                            if (com.tencent.mm.compatible.util.d.dW(23)) {
                                v.i("MicroMsg.CommandProcessor", "gcCount: %s", Debug.getRuntimeStats());
                            } else {
                                int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
                                int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
                                v.i("MicroMsg.CommandProcessor", "gcCount: %d %d", Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount));
                            }
                            long pss = Debug.getPss();
                            Debug.getMemoryInfo(new MemoryInfo());
                            if (com.tencent.mm.compatible.util.d.dW(23)) {
                                v.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", Long.valueOf(pss), r2.getMemoryStats());
                            } else {
                                v.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", Long.valueOf(pss), Integer.valueOf(r2.nativePss));
                            }
                            try {
                                Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
                                lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
                                while (true) {
                                    try {
                                        String readLine = lineNumberReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else if (readLine.length() > 0) {
                                            v.i("MicroMsg.CommandProcessor", readLine);
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                }
                                exec.waitFor();
                                exec.destroy();
                                try {
                                    lineNumberReader.close();
                                } catch (Exception e3) {
                                    v.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                                }
                            } catch (Exception e4) {
                                e3 = e4;
                                lineNumberReader = null;
                                try {
                                    v.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e3.getMessage());
                                    if (lineNumberReader != null) {
                                        try {
                                            lineNumberReader.close();
                                        } catch (Exception e32) {
                                            v.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
                                        }
                                    }
                                    v.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                    for (Thread name : Thread.getAllStackTraces().keySet()) {
                                        if (name.getState() == State.RUNNABLE) {
                                            v.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", name.getName(), af.b((StackTraceElement[]) r1.get((Thread) r2.next())));
                                        }
                                    }
                                    return true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (lineNumberReader != null) {
                                        try {
                                            lineNumberReader.close();
                                        } catch (Exception e5) {
                                            v.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e5.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                lineNumberReader = null;
                                if (lineNumberReader != null) {
                                    lineNumberReader.close();
                                }
                                throw th;
                            }
                            v.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                            for (Thread name2 : Thread.getAllStackTraces().keySet()) {
                                if (name2.getState() == State.RUNNABLE) {
                                    v.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", name2.getName(), af.b((StackTraceElement[]) r1.get((Thread) r2.next())));
                                }
                            }
                            return true;
                        }
                    }, true).ea(10000);
                }
            });
            return true;
        }
        if (str.startsWith("//remittance reset")) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(327729, "0");
            return true;
        }
        if (str.startsWith("//wv ")) {
            str2 = str.replace("//wv ", SQLiteDatabase.KeyEmpty);
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str2);
            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            return true;
        }
        if (str.startsWith("//wvjsapi ")) {
            str2 = str.replace("//wvjsapi ", SQLiteDatabase.KeyEmpty);
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str2);
            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewTestUI", intent2);
            return true;
        }
        if (!str.startsWith("//setibeacontabuinopen")) {
            if (!str.startsWith("//setibeacontabuinclose")) {
                if (!str.startsWith("//setibeaconpushopen")) {
                    if (!str.startsWith("//setibeaconpushclose")) {
                        boolean z;
                        if (str.startsWith("//ibeacon")) {
                            booleanValue = false;
                            boolean z2 = false;
                            if (VERSION.SDK_INT >= 18) {
                                booleanValue = true;
                            }
                            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                            if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                                z2 = true;
                            }
                            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                            z = booleanValue && z2 && hasSystemFeature;
                            dN = "isNowSupportedIbeacon:" + z + "\n\nisSystemSupported:" + booleanValue + "\nisBlueStateOn:" + z2 + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.d.p.rO() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.d.p.rS();
                            context2 = context;
                            com.tencent.mm.ui.base.g.b(context, dN, "TestResult", context.getString(2131231773), context.getString(2131231975), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context2.getSystemService("clipboard")).setText(dN);
                                }
                            }, null);
                            return true;
                        }
                        Editor edit;
                        if (str.startsWith("//settbs")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            String[] split4 = str.replace("//settbs", SQLiteDatabase.KeyEmpty).trim().split(" ");
                            if (split4 == null || split4.length != 3) {
                                return true;
                            }
                            edit.putString("tbs_download", split4[0]);
                            edit.putString("tbs_enable", split4[1]);
                            edit.putString("tbs_supported_ver_sec", split4[2]);
                            edit.apply();
                            return true;
                        }
                        SharedPreferences sharedPreferences;
                        int tbsCoreVersion;
                        if (str.startsWith("//gettbs")) {
                            booleanValue = com.tencent.mm.compatible.d.p.ceD.cfy;
                            sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                            str4 = sharedPreferences.getString("tbs_download", null);
                            str3 = sharedPreferences.getString("tbs_enable", null);
                            dN = sharedPreferences.getString("tbs_supported_ver_sec", null);
                            tbsCoreVersion = WebView.getTbsCoreVersion(context);
                            int tbsSDKVersion = WebView.getTbsSDKVersion(context);
                            Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_enable:%s\ntbs_support_ver_sec:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", new Object[]{Boolean.valueOf(booleanValue), str4, str3, dN, Integer.valueOf(tbsCoreVersion), Integer.valueOf(tbsSDKVersion)}), 1).show();
                            return true;
                        }
                        if (str.startsWith("//deletetbs")) {
                            intent = new Intent();
                            intent.setComponent(new ComponentName(aa.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            context.sendBroadcast(intent);
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            edit.putLong("last_check_ts", 0);
                            edit.apply();
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(t.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false));
                            return true;
                        }
                        Editor edit2;
                        if (str.startsWith("//tbsDisableOverScroll")) {
                            edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str2 = str.substring(str.indexOf(":") + 1);
                            } catch (IndexOutOfBoundsException e3) {
                                str2 = SQLiteDatabase.KeyEmpty;
                            }
                            edit2.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(str2));
                            edit2.apply();
                            return true;
                        }
                        if (str.startsWith("//enabletbs")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            edit.putString("tbs_enable", str.replace("//enabletbs ", SQLiteDatabase.KeyEmpty));
                            edit.apply();
                            return true;
                        }
                        if (str.startsWith("//wvsha1")) {
                            edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str2 = str.substring(str.indexOf(":") + 1);
                            } catch (IndexOutOfBoundsException e4) {
                                str2 = SQLiteDatabase.KeyEmpty;
                            }
                            edit2.putBoolean("wvsha1", Boolean.parseBoolean(str2));
                            edit2.apply();
                            return true;
                        }
                        if (str.startsWith("//channelId")) {
                            com.tencent.mm.ui.base.g.z(context, com.tencent.mm.sdk.platformtools.f.aPW, "channelId");
                        }
                        if (str.startsWith("//traceroute")) {
                            com.tencent.mm.ay.c.w(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                            return true;
                        }
                        if (str.startsWith("//qzone ")) {
                            new com.tencent.mm.pluginsdk.ui.applet.k(context).HB(str.replace("//qzone ", SQLiteDatabase.KeyEmpty));
                        }
                        if (str.startsWith("//dumpcrash")) {
                            com.tencent.mm.sdk.platformtools.j.n(com.tencent.mm.compatible.util.e.cng + "crash/", com.tencent.mm.compatible.util.e.cnk, false);
                            return true;
                        }
                        if (str.startsWith("//dumpanr")) {
                            com.tencent.mm.sdk.platformtools.j.n("/data/anr/", com.tencent.mm.compatible.util.e.cnk, false);
                            return true;
                        }
                        if (str.startsWith("//testanr")) {
                            try {
                                Thread.sleep(10000);
                            } catch (Throwable e5) {
                                v.a("MicroMsg.CommandProcessor", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                            return true;
                        }
                        if (str.startsWith("//opensnsadRightbar")) {
                            q.dqs = true;
                            return true;
                        }
                        if (str.startsWith("//setlocation ")) {
                            split3 = str.split(" ");
                            if (split3 == null || !com.tencent.mm.sdk.b.b.bsI()) {
                                return false;
                            }
                            q.dpI = true;
                            if (split3.length > 0) {
                                q.lat = be.getDouble(split3[1], 0.0d);
                            }
                            if (split3.length > 1) {
                                q.lng = be.getDouble(split3[2], 0.0d);
                            }
                            return true;
                        }
                        int i;
                        if (str.startsWith("//switchsdcard")) {
                            String str5;
                            ArrayList btT = at.btT();
                            tbsCoreVersion = btT.size();
                            v.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + tbsCoreVersion);
                            if (!(tbsCoreVersion <= 0 || btT.get(0) == null || be.kS(((at.a) btT.get(0)).nkX))) {
                                for (intValue = 0; intValue < tbsCoreVersion; intValue++) {
                                    v.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + intValue + " StatMountParse: " + btT.get(intValue));
                                }
                            }
                            for (i = 0; i < tbsCoreVersion; i++) {
                                if (!((at.a) btT.get(i)).nkX.equals(com.tencent.mm.compatible.util.e.cni)) {
                                    str5 = ((at.a) btT.get(i)).nkX;
                                    break;
                                }
                            }
                            str5 = null;
                            final Activity activity = (Activity) context;
                            v.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + str5);
                            if (be.kS(str5)) {
                                com.tencent.mm.ui.base.g.be(context, context.getString(2131235605));
                                return true;
                            }
                            context2 = context;
                            com.tencent.mm.ui.base.g.b(context, context.getString(2131235606), SQLiteDatabase.KeyEmpty, context.getString(2131231107), context.getString(2131231010), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.storage.q qVar = new com.tencent.mm.storage.q(t.cng + "SdcardInfo.cfg");
                                    qVar.set(1, str5);
                                    v.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + qVar.get(1));
                                    ab.Kj("welcome_page_show");
                                    h.c(context2, true);
                                    com.tencent.mm.sdk.c.b vVar = new com.tencent.mm.e.a.v();
                                    vVar.aXi.aXj = false;
                                    com.tencent.mm.sdk.c.a.nhr.z(vVar);
                                    WorkerProfile.oE().aRO.oz();
                                    ak.oH().qs();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                                    aa.getContext().sendBroadcast(intent);
                                    if (com.tencent.mm.pluginsdk.j.a.lxI != null) {
                                        com.tencent.mm.pluginsdk.j.a.lxI.ai(activity);
                                    }
                                    activity.finish();
                                }
                            }, null);
                            return true;
                        }
                        if (str.startsWith("//getip")) {
                            ak.vy().d(new ay(new ay.a() {
                                public final void a(com.tencent.mm.network.e eVar) {
                                    if (eVar != null) {
                                        int i;
                                        String[] iPsString = eVar.getIPsString(true);
                                        for (i = 0; i < iPsString.length; i++) {
                                            v.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", Integer.valueOf(i), iPsString[i]);
                                            v.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.lN(iPsString[i]).toString());
                                        }
                                        iPsString = eVar.getIPsString(false);
                                        for (i = 0; i < iPsString.length; i++) {
                                            v.d("MicroMsg.CommandProcessor", "dkip short:%d %s", Integer.valueOf(i), iPsString[i]);
                                            v.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.lN(iPsString[i]).toString());
                                        }
                                    }
                                }
                            }));
                            return true;
                        }
                        if (str.startsWith("//localjsapi")) {
                            str2 = "file://" + com.tencent.mm.compatible.util.e.cnj + "test_jsapi.html";
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str2);
                            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            return true;
                        }
                        if (str.startsWith("//getlocalkey")) {
                            dN = com.tencent.mm.storage.az.bxi();
                            context2 = context;
                            com.tencent.mm.ui.base.g.b(context, dN, "Fingerprint Key", context.getString(2131235913), context.getString(2131231975), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context2.getSystemService("clipboard")).setText(dN);
                                    Toast.makeText(context2, 2131235914, 0).show();
                                }
                            }, null);
                            return true;
                        }
                        if (str.startsWith("//getdevid")) {
                            dN = com.tencent.mm.compatible.d.p.rK();
                            context2 = context;
                            com.tencent.mm.ui.base.g.b(context, dN, "devid", context.getString(2131231773), context.getString(2131231975), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context2.getSystemService("clipboard")).setText(dN);
                                }
                            }, null);
                            return true;
                        }
                        if (str.startsWith("//testhtml")) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                            return true;
                        }
                        if (str.startsWith("//testlocalhtml ")) {
                            str2 = str.replace("//testlocalhtml ", SQLiteDatabase.KeyEmpty);
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", "file://" + str2);
                            intent2.putExtra("neverGetA8Key", true);
                            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            return true;
                        }
                        if (str.startsWith("//setkey")) {
                            if (com.tencent.mm.storage.az.Nu(str.replace("//setkey", SQLiteDatabase.KeyEmpty))) {
                                Toast.makeText(context, 2131235875, 0).show();
                            }
                            return true;
                        }
                        if (str.startsWith("//checkspell")) {
                            dN = str.replace("//checkspell ", SQLiteDatabase.KeyEmpty);
                            if (be.kS(dN)) {
                                return true;
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            for (intValue = 0; intValue < dN.length(); intValue++) {
                                stringBuilder2.append("[" + dN.charAt(intValue) + ":" + SpellMap.f(dN.charAt(intValue)) + "]");
                            }
                            com.tencent.mm.ui.base.g.z(context, stringBuilder2.toString(), "Check Spell");
                            return true;
                        }
                        if (str.startsWith("//gallery ")) {
                            str2 = str.replace("//gallery ", SQLiteDatabase.KeyEmpty);
                            if (be.kS(str2)) {
                                return true;
                            }
                            context.getSharedPreferences(aa.bti(), 0).edit().putString("gallery", str2).commit();
                            return true;
                        }
                        if (str.startsWith("//svgtag")) {
                            str2 = str.replace("//svgtag ", SQLiteDatabase.KeyEmpty);
                            if (str2.equals("on")) {
                                com.tencent.mm.be.c.iq(true);
                            } else if (str2.equals("off")) {
                                com.tencent.mm.be.c.iq(false);
                            }
                            return true;
                        }
                        if (str.startsWith("//svgcode")) {
                            try {
                                str2 = str.replace("//svgcode ", SQLiteDatabase.KeyEmpty);
                                if (!str2.equals("on")) {
                                    str2.equals("off");
                                }
                                Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                Field declaredField = cls.getDeclaredField("SVGCode");
                                declaredField.setAccessible(true);
                                booleanValue = declaredField.getBoolean(cls);
                                try {
                                    Toast.makeText(aa.getContext(), "Using SVG Code : " + booleanValue + " " + com.tencent.mm.svg.c.b.byi(), 1).show();
                                } catch (Exception e6) {
                                }
                            } catch (Throwable e52) {
                                v.a("MicroMsg.CommandProcessor", e52, SQLiteDatabase.KeyEmpty, new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e522) {
                                v.a("MicroMsg.CommandProcessor", e522, SQLiteDatabase.KeyEmpty, new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e5222) {
                                v.a("MicroMsg.CommandProcessor", e5222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e52222) {
                                v.a("MicroMsg.CommandProcessor", e52222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                booleanValue = false;
                            }
                            return true;
                        }
                        if (str.startsWith("//testMbanner")) {
                            try {
                                split3 = str.replace("//testMbanner ", SQLiteDatabase.KeyEmpty).split(",");
                                if (split3.length >= 2) {
                                    av.zh().a(new au(Integer.valueOf(split3[0]).intValue(), Integer.valueOf(split3[1]).intValue(), null));
                                }
                            } catch (Exception e7) {
                            }
                            return true;
                        }
                        if (str.startsWith("//testrsa")) {
                            ad.y("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                        }
                        if (str.startsWith("//recomT")) {
                            try {
                                ak.yW().xt().a(str.replace("//recomT ", SQLiteDatabase.KeyEmpty), true, null);
                            } catch (Exception e8) {
                            }
                            return true;
                        }
                        if (str.startsWith("//recomF")) {
                            try {
                                ak.yW().xt().a(str.replace("//recomF ", SQLiteDatabase.KeyEmpty), false, null);
                            } catch (Exception e9) {
                            }
                            return true;
                        }
                        if (str.startsWith("//testgetreg")) {
                            try {
                                split3 = str.replace("//testgetreg ", SQLiteDatabase.KeyEmpty).split(",");
                                if (split3.length > 2) {
                                    new com.tencent.mm.model.be.a().eT(Integer.valueOf(split3[0]).intValue()).eV(Integer.valueOf(split3[1]).intValue()).eU(Integer.valueOf(split3[2]).intValue()).commit();
                                }
                            } catch (Exception e10) {
                            }
                            return true;
                        }
                        if (str.startsWith("//ffmpeg")) {
                            try {
                                intValue = str.indexOf("-r ");
                                dimensionPixelSize = str.indexOf("-b ");
                                str2 = str.substring(intValue + 3, dimensionPixelSize);
                                dN = str.substring(dimensionPixelSize + 3);
                                float f = be.getFloat(str2.trim(), 0.0f);
                                dimensionPixelSize = be.getInt(dN.trim(), 0);
                                com.tencent.mm.plugin.sight.base.b.iTu = dimensionPixelSize;
                                com.tencent.mm.plugin.sight.base.b.iTv = f;
                                Toast.makeText(aa.getContext(), "set C2C video encode frame rate " + f + " bitrate " + dimensionPixelSize, 0).show();
                            } catch (Exception e11) {
                                Toast.makeText(aa.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                            }
                            return true;
                        }
                        if (str.startsWith("//onlinevideo")) {
                            try {
                                intValue = be.getInt(str.replace("//onlinevideo ", SQLiteDatabase.KeyEmpty), 0);
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(intValue));
                                Toast.makeText(aa.getContext(), intValue > 0 ? "online video" : "offline video", 0).show();
                            } catch (Throwable e522222) {
                                v.a("MicroMsg.CommandProcessor", e522222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                Toast.makeText(aa.getContext(), "set online video fail, please ensure your command.", 1).show();
                            }
                            return true;
                        }
                        if (str.startsWith("//switchpaytype")) {
                            split3 = str.split(" ");
                            if (split3 == null || split3.length < 2) {
                                return false;
                            }
                            try {
                                intValue = be.getInt(split3[1], 0);
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(339975, Integer.valueOf(intValue));
                                return true;
                            } catch (Exception e12) {
                                v.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                return false;
                            }
                        }
                        if (str.startsWith("//setNfcOpenUrl ")) {
                            str2 = str.replace("//setNfcOpenUrl ", SQLiteDatabase.KeyEmpty);
                            edit2 = aa.btl().edit();
                            edit2.putString("nfc_open_url", str2);
                            edit2.commit();
                            return true;
                        }
                        if (str.startsWith("//snskvtest ")) {
                            str2 = str.replace("//snskvtest", SQLiteDatabase.KeyEmpty).trim();
                            if (str2.equals("0")) {
                                q.dqP = false;
                            } else if (str2.equals("1")) {
                                q.dqP = true;
                            }
                            return true;
                        }
                        if (str.startsWith("//emoji ")) {
                            com.tencent.mm.pluginsdk.j.a.bmr().rr(str.replace("//emoji ", SQLiteDatabase.KeyEmpty));
                            return true;
                        }
                        if (str.startsWith("//share ")) {
                            intValue = Integer.valueOf(str.replace("//share ", SQLiteDatabase.KeyEmpty)).intValue();
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(229635, Integer.valueOf(intValue));
                            return true;
                        }
                        if (str.startsWith("//dumpappinfoblob ")) {
                            com.tencent.mm.pluginsdk.model.app.f Gz = com.tencent.mm.pluginsdk.model.app.am.bnB().Gz(str.replace("//dumpappinfoblob ", SQLiteDatabase.KeyEmpty));
                            com.tencent.mm.ui.base.g.z(context, Gz.pA() + "\n" + Gz.pB() + "\n" + Gz.pC(), SQLiteDatabase.KeyEmpty);
                            return true;
                        }
                        CharSequence replace;
                        if (str.startsWith("//googleauth ")) {
                            replace = str.replace("//googleauth ", SQLiteDatabase.KeyEmpty);
                            if (!TextUtils.isEmpty(replace)) {
                                if ("webview".equals(replace)) {
                                    context.getSharedPreferences(aa.bti(), 0).edit().putBoolean("googleauth", true).commit();
                                } else if ("local".equals(replace)) {
                                    context.getSharedPreferences(aa.bti(), 0).edit().putBoolean("googleauth", false).commit();
                                }
                            }
                            return true;
                        }
                        if (str.startsWith("//clrgamecache")) {
                            r bms = com.tencent.mm.pluginsdk.j.a.bms();
                            if (bms != null) {
                                bms.bZ(context);
                            }
                            return true;
                        }
                        if (str.startsWith("//googlemap")) {
                            q.dqr = true;
                            return true;
                        }
                        if (str.startsWith("//sosomap")) {
                            q.dqr = false;
                            return true;
                        }
                        if (str.startsWith("//opentrace")) {
                            com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                            com.tencent.mm.ui.applet.d.et(aa.getContext());
                            return true;
                        }
                        if (str.startsWith("//updateConversation")) {
                            v.i("MicroMsg.CommandProcessor", "update all conversation start");
                            ak.yW();
                            for (String str22 : com.tencent.mm.model.c.wK().bvK()) {
                                ak.yW();
                                com.tencent.mm.storage.at dL = com.tencent.mm.model.c.wJ().dL(str22, " and not ( type = 10000 and isSend != 2 ) ");
                                ak.yW();
                                com.tencent.mm.model.c.wK().N(dL);
                            }
                            v.i("MicroMsg.CommandProcessor", "update all conversation end");
                            return true;
                        }
                        if (str.startsWith("//setshakecarddata")) {
                            com.tencent.mm.pluginsdk.j.a.bmq().aNK();
                            return true;
                        }
                        if (str.startsWith("//clearshakecarddata")) {
                            com.tencent.mm.pluginsdk.j.a.bmq().aNL();
                            return true;
                        }
                        if (str.startsWith("//pageSize")) {
                            Context context3 = aa.getContext();
                            stringBuilder = new StringBuilder("pageSize is ");
                            ak.yW();
                            Toast.makeText(context3, stringBuilder.append(com.tencent.mm.model.c.wE().getPageSize()).toString(), 1).show();
                            return true;
                        }
                        if (str.startsWith("//resetDBStatus")) {
                            ak.yW();
                            File file = new File(com.tencent.mm.model.c.xo());
                            try {
                                stringBuilder = new StringBuilder();
                                ak.yW();
                                com.tencent.mm.ui.tools.e.d(new File(stringBuilder.append(com.tencent.mm.model.c.xp()).append(file.getName().replace(".db", ".db.backup")).toString()), file);
                                v.i("MicroMsg.CommandProcessor", "backupPath db path is %s", dN);
                                com.tencent.mm.a.e.renameTo(file, new File(file.getAbsolutePath() + "err" + System.currentTimeMillis()));
                                Toast.makeText(aa.getContext(), "db状态已重置,请重启微信", 1).show();
                            } catch (Exception e13) {
                                v.w("MicroMsg.CommandProcessor", "delete failed: " + e13.getMessage());
                            }
                            return true;
                        }
                        if (!str.startsWith("//recover ")) {
                            if (!str.equals("//recover")) {
                                if (str.startsWith("//makesnsdata ")) {
                                    com.tencent.mm.pluginsdk.j.ak.bmB().dc((long) be.getInt(str.replace("//makesnsdata ", SQLiteDatabase.KeyEmpty), 0));
                                    return true;
                                }
                                if (str.startsWith("//setsnsupload ")) {
                                    q.dqB = be.getInt(str.replace("//setsnsupload ", SQLiteDatabase.KeyEmpty), 0);
                                    return true;
                                }
                                if (str.startsWith("//logsnstable")) {
                                    com.tencent.mm.sdk.c.a.nhr.z(new bs());
                                    return true;
                                }
                                if (str.startsWith("//resetsnstip")) {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().set(327776, Integer.valueOf(0));
                                    return true;
                                }
                                if (str.startsWith("//checkcount")) {
                                    ak.yW();
                                    intValue = com.tencent.mm.model.c.wJ().MY(ChattingUI.a.osT);
                                    ak.yW();
                                    Toast.makeText(context, "current count :" + intValue + " countAuto :" + com.tencent.mm.model.c.wJ().MW(ChattingUI.a.osT), 1).show();
                                    return true;
                                }
                                if (str.startsWith("//changeframe ")) {
                                    aa.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", SQLiteDatabase.KeyEmpty)).floatValue()).commit();
                                    return true;
                                }
                                if (str.startsWith("//opendumpview")) {
                                    com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                                    com.tencent.mm.ui.applet.c.es(aa.getContext());
                                    return true;
                                }
                                if (str.startsWith("//dumpmemory")) {
                                    System.gc();
                                    System.gc();
                                    com.tencent.mm.bh.a.byn();
                                    return true;
                                }
                                if (str.startsWith("//dumpsnsfile")) {
                                    com.tencent.mm.sdk.c.a.nhr.z(new nl());
                                    return true;
                                }
                                if (str.startsWith("//coverage")) {
                                    com.tencent.mm.plugin.report.b.e.yK(str.trim().substring(10));
                                    return true;
                                }
                                if (str.startsWith("//dumpthreadpool")) {
                                    com.tencent.mm.sdk.i.e.buI();
                                    return true;
                                }
                                if (str.startsWith("//testverifypsw ")) {
                                    str22 = str.replace("//testverifypsw ", SQLiteDatabase.KeyEmpty).trim();
                                    if (str22.equals("0")) {
                                        q.dqR = false;
                                    } else if (str22.equals("1")) {
                                        q.dqR = true;
                                    }
                                    v.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(q.dqR));
                                    return true;
                                }
                                if (str.startsWith("//pickpoi")) {
                                    intent = new Intent();
                                    intent.putExtra("map_view_type", 8);
                                    com.tencent.mm.ay.c.b(context, "location", ".ui.RedirectUI", intent);
                                    return true;
                                }
                                if (str.startsWith("//configlist")) {
                                    if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                        List ai = com.tencent.mm.platformtools.t.ai(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                        if (ai != null && ai.size() == 2) {
                                            j.sU().put((String) ai.get(0), (String) ai.get(1));
                                            com.tencent.mm.sdk.c.a.nhr.z(new bt());
                                        }
                                    } else {
                                        if (str.matches("^//configlist get ([\\S]*)$")) {
                                            List ai2 = com.tencent.mm.platformtools.t.ai(str, "^//configlist get ([\\S]*)$");
                                            if (ai2 != null && ai2.size() == 1) {
                                                str22 = (String) ai2.get(0);
                                                Toast.makeText(context, str22 + "=" + j.sU().getValue(str22), 0).show();
                                            }
                                        } else {
                                            ak.yW();
                                            str22 = (String) com.tencent.mm.model.c.vf().get(278530, SQLiteDatabase.KeyEmpty);
                                            ak.yW();
                                            dN = (String) com.tencent.mm.model.c.vf().get(278529, SQLiteDatabase.KeyEmpty);
                                            str4 = com.tencent.mm.compatible.util.e.cnj + "dynacfg.xml";
                                            be.p(str4, (str22 + dN).getBytes());
                                            Toast.makeText(context, "output dynacfg xml to " + str4, 0).show();
                                        }
                                    }
                                    return true;
                                }
                                if (str.startsWith("//security")) {
                                    try {
                                        ak.yW().xu().a(str.replace("//security ", SQLiteDatabase.KeyEmpty), true, null);
                                    } catch (Exception e14) {
                                    }
                                    return true;
                                }
                                if (str.startsWith("//updatepackage")) {
                                    try {
                                        ak.vy().d(new com.tencent.mm.al.k(be.getInt(str.replace("//updatepackage ", SQLiteDatabase.KeyEmpty).trim(), 0)));
                                    } catch (Exception e15) {
                                    }
                                    return true;
                                }
                                final ArrayList btT2;
                                final int size;
                                if (str.startsWith("//copypackage")) {
                                    v.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                    btT2 = at.btT();
                                    size = btT2.size();
                                    v.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(size));
                                    if (size < 2) {
                                        com.tencent.mm.ui.base.g.be(context, context.getString(2131232233));
                                    } else {
                                        context2 = context;
                                        com.tencent.mm.ui.base.g.b(context, context.getString(2131232235), SQLiteDatabase.KeyEmpty, context.getString(2131231107), context.getString(2131231010), new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                                                    final /* synthetic */ AnonymousClass5 che;

                                                    {
                                                        this.che = r1;
                                                    }

                                                    public final void run() {
                                                        try {
                                                            String str = com.tencent.mm.compatible.util.e.cni;
                                                            ak.yW();
                                                            String xb = com.tencent.mm.model.c.xb();
                                                            ak.yW();
                                                            String wx = com.tencent.mm.model.c.wx();
                                                            v.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", Integer.valueOf(size), str, xb, wx, xb.substring(str.length()));
                                                            for (int i = 0; i < size; i++) {
                                                                Object obj = ((at.a) btT2.get(i)).nkX;
                                                                if (!(be.kS(obj) || str.contains(obj))) {
                                                                    File file = new File(obj + r5);
                                                                    if (file.exists() && file.isDirectory()) {
                                                                        v.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", xb, file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.j.n(file.getAbsolutePath(), xb, false)));
                                                                        if (com.tencent.mm.sdk.platformtools.j.n(file.getAbsolutePath(), xb, false)) {
                                                                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                                                                final /* synthetic */ AnonymousClass1 chf;

                                                                                {
                                                                                    this.chf = r1;
                                                                                }

                                                                                public final void run() {
                                                                                    com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232234));
                                                                                }
                                                                            });
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                                                final /* synthetic */ AnonymousClass1 chf;

                                                                {
                                                                    this.chf = r1;
                                                                }

                                                                public final void run() {
                                                                    com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232233));
                                                                }
                                                            });
                                                        } catch (Exception e) {
                                                            v.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", e.getMessage());
                                                        }
                                                    }
                                                }, "copypackage");
                                            }
                                        }, null);
                                    }
                                    return true;
                                }
                                final String str6;
                                if (str.startsWith("//copy -n ")) {
                                    v.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                    btT2 = at.btT();
                                    size = btT2.size();
                                    v.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(size));
                                    if (size < 2) {
                                        com.tencent.mm.ui.base.g.be(context, context.getString(2131232233));
                                    } else {
                                        str6 = str;
                                        final Context context4 = context;
                                        com.tencent.mm.ui.base.g.b(context, context.getString(2131232235), SQLiteDatabase.KeyEmpty, context.getString(2131231107), context.getString(2131231010), new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                                                    final /* synthetic */ AnonymousClass6 chb;

                                                    {
                                                        this.chb = r1;
                                                    }

                                                    public final void run() {
                                                        try {
                                                            String substring = str6.substring(10);
                                                            String str = com.tencent.mm.compatible.util.e.cni;
                                                            ak.yW();
                                                            String str2 = com.tencent.mm.model.c.xq() + substring;
                                                            v.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                            for (int i = 0; i < size; i++) {
                                                                Object obj = ((at.a) btT2.get(i)).nkX;
                                                                if (!(be.kS(obj) || str.contains(obj))) {
                                                                    File file = new File(obj + r5);
                                                                    if (file.exists() && file.isDirectory()) {
                                                                        File file2 = new File(str2);
                                                                        if (!file2.exists()) {
                                                                            file2.mkdir();
                                                                        }
                                                                        v.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", file2.getAbsolutePath(), file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.j.n(file.getAbsolutePath(), file2.getAbsolutePath(), false)));
                                                                        if (com.tencent.mm.sdk.platformtools.j.n(file.getAbsolutePath(), file2.getAbsolutePath(), false)) {
                                                                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                                                                final /* synthetic */ AnonymousClass1 chc;

                                                                                {
                                                                                    this.chc = r1;
                                                                                }

                                                                                public final void run() {
                                                                                    com.tencent.mm.ui.base.g.bf(context4, context4.getString(2131232234));
                                                                                }
                                                                            });
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                                                final /* synthetic */ AnonymousClass1 chc;

                                                                {
                                                                    this.chc = r1;
                                                                }

                                                                public final void run() {
                                                                    com.tencent.mm.ui.base.g.bf(context4, context4.getString(2131232233));
                                                                }
                                                            });
                                                        } catch (Exception e) {
                                                            v.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                        }
                                                    }
                                                }, "copy -n");
                                            }
                                        }, null);
                                    }
                                    return true;
                                }
                                if (str.startsWith("//deletepackage")) {
                                    try {
                                        str22 = str.replace("//deletepackage ", SQLiteDatabase.KeyEmpty);
                                        com.tencent.mm.sdk.c.b bnVar = new bn();
                                        bnVar.aZb.aZc = be.getInt(str22, 0);
                                        com.tencent.mm.sdk.c.a.nhr.z(bnVar);
                                    } catch (Exception e16) {
                                    }
                                    return true;
                                }
                                if (str.startsWith("//audiowritetofile")) {
                                    com.tencent.mm.compatible.d.p.ceB.cbV = true;
                                    return true;
                                }
                                if (str.startsWith("//bankcard")) {
                                    intent = new Intent();
                                    intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                    intent.putExtra("bank_card_owner", "test");
                                    if (!(com.tencent.mm.as.u.bi(context) || com.tencent.mm.ah.a.aT(context))) {
                                        com.tencent.mm.ay.c.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                    }
                                    return true;
                                }
                                if (str.startsWith("//banner")) {
                                    Map q = bf.q("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                    str22 = (String) q.get(".sysmsg.mainframebanner.$type");
                                    dN = (String) q.get(".sysmsg.mainframebanner.showtype");
                                    str4 = (String) q.get(".sysmsg.mainframebanner.data");
                                    v.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str22, dN, str4);
                                }
                                if (str.startsWith("//gamemsg")) {
                                    oVar = new kg();
                                    oVar.blk.content = str;
                                    com.tencent.mm.sdk.c.a.nhr.z(oVar);
                                    return true;
                                }
                                if (str.startsWith("//gallerytype")) {
                                    com.tencent.mm.ui.chatting.ac.onf = !com.tencent.mm.ui.chatting.ac.onf;
                                    return true;
                                }
                                context.getString(2131236724);
                                if (str.startsWith("//fullexit")) {
                                    ab.Kj("show_whatsnew");
                                    com.tencent.mm.protocal.e.c(context, true);
                                    MMAppMgr.ai(context);
                                    ak.hold();
                                    ak.fH(SQLiteDatabase.KeyEmpty);
                                    MMAppMgr.bAl();
                                    return true;
                                }
                                if (str.startsWith("//cleardldb")) {
                                    ak.yW().wL().bvW();
                                    return true;
                                }
                                if (str.startsWith("//setcardlayouttestdata")) {
                                    Object replace2 = str.replace("//setcardlayouttestdata ", SQLiteDatabase.KeyEmpty);
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace2);
                                    return true;
                                }
                                if (str.startsWith("//delchatroomsysmsg")) {
                                    str22 = str.replace("//delchatroomsysmsg ", SQLiteDatabase.KeyEmpty);
                                    dimensionPixelSize = str22.indexOf(" ");
                                    str4 = str22.substring(0, dimensionPixelSize);
                                    str22 = str22.substring(dimensionPixelSize);
                                    if (be.kS(str4)) {
                                        return false;
                                    }
                                    if (!str22.startsWith("<")) {
                                        return false;
                                    }
                                    com.tencent.mm.storage.at atVar = new com.tencent.mm.storage.at();
                                    atVar.z(System.currentTimeMillis());
                                    atVar.setType(CdnLogic.MediaType_FAVORITE_VIDEO);
                                    atVar.setContent(str22);
                                    atVar.di(0);
                                    atVar.cH(str4);
                                    com.tencent.mm.model.aw.e(atVar);
                                    return true;
                                }
                                if (str.startsWith("//printchatroominfo")) {
                                    str22 = ChattingUI.a.osT;
                                    if (!m.dE(str22)) {
                                        return false;
                                    }
                                    final com.tencent.mm.storage.o LC = ak.yW().wO().LC(str22);
                                    if (LC == null) {
                                        v.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str22);
                                        return false;
                                    }
                                    str6 = str;
                                    ak.vA().x(new Runnable() {
                                        public final void run() {
                                            int bvc = LC.bvc();
                                            int i = LC.field_chatroomdataflag;
                                            int bvf = LC.bvf();
                                            com.tencent.mm.storage.o oVar = LC;
                                            if (oVar.b(oVar.nnW)) {
                                                oVar.bvb();
                                            }
                                            int i2 = oVar.nnW.status;
                                            int bvg = LC.bvg();
                                            oVar = LC;
                                            if (oVar.b(oVar.nnW)) {
                                                oVar.bvb();
                                            }
                                            String str = oVar.nnW.caH;
                                            List DM = LC.DM();
                                            ak.yW();
                                            bx dL = com.tencent.mm.model.c.wJ().dL(str22, " and flag != 0 and msgSeq != 0");
                                            boolean z = dL != null && dL.field_msgId > 0;
                                            ak.yW();
                                            v.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str22, Integer.valueOf(bvc), Integer.valueOf(i), Integer.valueOf(bvf), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.model.c.wJ().MW(str22)), Integer.valueOf(bvg), str, Integer.valueOf(DM.size()));
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("---chatroominfo---\nid:").append(str22).append("\nver:").append(bvc).append("\nflag:").append(i).append("\ntype:").append(bvf).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(bvg).append("\nupgrader:").append(str).append("\nmembersize:").append(DM.size());
                                            int i3 = -1;
                                            try {
                                                i3 = be.getInt(str6.split(" ")[1], 0);
                                            } catch (Exception e) {
                                            }
                                            if (i3 == -1) {
                                                i3 = DM.size();
                                            }
                                            if (i3 > DM.size()) {
                                                i3 = DM.size();
                                            }
                                            if (i3 > 10) {
                                                i = 10;
                                            } else {
                                                i = i3;
                                            }
                                            if (i > 0) {
                                                stringBuilder.append("\nmember:");
                                            }
                                            for (bvc = 0; bvc < i; bvc++) {
                                                stringBuilder.append("\n").append((String) DM.get(bvc));
                                            }
                                            com.tencent.mm.storage.at atVar = new com.tencent.mm.storage.at();
                                            atVar.cH(str22);
                                            atVar.di(2);
                                            atVar.setType(1);
                                            atVar.z(System.currentTimeMillis());
                                            atVar.setContent(stringBuilder.toString());
                                            com.tencent.mm.model.aw.e(atVar);
                                        }
                                    });
                                    return true;
                                }
                                if (str.equals("//testupdate")) {
                                    str22 = SQLiteDatabase.KeyEmpty;
                                    try {
                                        str22 = be.e(context.getAssets().open("aplha_update_info.xml"));
                                    } catch (Throwable e17) {
                                        v.a("MicroMsg.CommandProcessor", e17, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().set(352273, str22);
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().set(352274, Long.valueOf(System.currentTimeMillis()));
                                    new com.tencent.mm.pluginsdk.model.app.a(str22).bni();
                                    return true;
                                }
                                if (!str.equals("//checkUpdate0")) {
                                    if (!str.equals("//checkUpdate1")) {
                                        if (str.equals("//debugsnstimelinestat")) {
                                            q.dqK = !q.dqK;
                                            Toast.makeText(aa.getContext(), "debugSnsTimelineStat: " + q.dqK, 0).show();
                                            return true;
                                        }
                                        if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.b.b.bsI()) {
                                            com.tencent.mm.model.c.a.a gi = com.tencent.mm.model.c.a.gi(str.replace("//abtestmsg", SQLiteDatabase.KeyEmpty));
                                            com.tencent.mm.model.c.c.Au().bQ(gi.cwd);
                                            com.tencent.mm.model.c.c.Av().bQ(gi.cwe);
                                            return true;
                                        }
                                        if (str.startsWith("//triggergetabtest")) {
                                            ak.yW();
                                            com.tencent.mm.model.c.vf().a(t.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                            return true;
                                        }
                                        if (str.startsWith("//vad")) {
                                            btk = aa.btk();
                                            if (btk == null) {
                                                return false;
                                            }
                                            if (str.startsWith("//vad get")) {
                                                com.tencent.mm.ui.base.g.z(context, com.tencent.mm.at.a.c.LV(), "VAD PARAMS").show();
                                                return true;
                                            }
                                            edit = btk.edit();
                                            if (str.startsWith("//vad sd")) {
                                                edit.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad st")) {
                                                edit.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad snr")) {
                                                edit.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                            }
                                            if (str.startsWith("//vad sw")) {
                                                edit.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad sl")) {
                                                edit.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            edit.apply();
                                            return true;
                                        }
                                        if (!str.startsWith("//dumpabtestrecords")) {
                                            if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                                return true;
                                            }
                                            if (str.startsWith("//cleanwebcache")) {
                                                com.tencent.mm.sdk.c.a.nhr.z(new com.tencent.mm.e.a.ay());
                                                return true;
                                            }
                                            if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                                intent = new Intent();
                                                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                context.sendBroadcast(intent);
                                                return true;
                                            }
                                            if (str.startsWith("//dumpsnsabtest")) {
                                                com.tencent.mm.sdk.c.a.nhr.z(new bq());
                                                return true;
                                            }
                                            if (str.startsWith("//dumpsilkvoicefile")) {
                                                q.dqO = true;
                                                return true;
                                            }
                                            if (str.startsWith("//fucktit")) {
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(true));
                                                return true;
                                            }
                                            if (str.startsWith("//clog ")) {
                                                com.tencent.mm.plugin.report.service.g.iuh.cq(str.substring(7), "test cLog " + System.currentTimeMillis());
                                                return true;
                                            }
                                            if (str.startsWith("//testformsg") && com.tencent.mm.sdk.b.b.bsI()) {
                                                str22 = str.substring(12).trim();
                                                v.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + ak.yU());
                                                bm bmVar = new bm();
                                                bmVar.mbW = com.tencent.mm.platformtools.m.lY(str22);
                                                bmVar.gll = CdnLogic.MediaType_FAVORITE_VIDEO;
                                                ak.yU().b(new com.tencent.mm.v.d.a(bmVar, false, false, false));
                                                return true;
                                            }
                                            if (str.startsWith("//canwebviewcachedownload")) {
                                                booleanValue = be.getInt(be.ma(str.substring(25)).trim(), 1) > 0;
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                return true;
                                            }
                                            if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                                booleanValue = be.getInt(be.ma(str.substring(32)).trim(), 1) > 0;
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                return true;
                                            }
                                            if (str.startsWith("//resetsnslukcy")) {
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.valueOf(false));
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                                ak.yW();
                                                com.tencent.mm.model.c.vf().a(t.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                                com.tencent.mm.sdk.c.a.nhr.z(new oa());
                                                return true;
                                            }
                                            if (str.startsWith("//mmimgdec ")) {
                                                str22 = str.substring(11);
                                                if ("on".equalsIgnoreCase(str22)) {
                                                    MMBitmapFactory.setUseMMBitmapFactory(true);
                                                    Toast.makeText(context, "内置图片(png)解析库开启", 0).show();
                                                } else if ("off".equalsIgnoreCase(str22)) {
                                                    MMBitmapFactory.setUseMMBitmapFactory(false);
                                                    Toast.makeText(context, "内置图片(png)解析库关闭", 0).show();
                                                }
                                                return true;
                                            }
                                            if (str.startsWith("//enablempsp")) {
                                                aj.a.iw(false);
                                                Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                return true;
                                            }
                                            if (str.startsWith("//disablempsp")) {
                                                aj.a.iw(true);
                                                Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                return true;
                                            }
                                            if (str.startsWith("//soterpay")) {
                                                com.tencent.mm.ay.c.w(context, "fingerprint", ".ui.SoterPayTestUI");
                                                return true;
                                            }
                                            context.getString(2131236723);
                                            if (str.startsWith("//getdltaskinfo")) {
                                                str22 = str.replace("//getdltaskinfo ", SQLiteDatabase.KeyEmpty);
                                                try {
                                                    if (com.tencent.mm.pluginsdk.model.downloader.c.dG(be.getLong(str22, 0)) != null) {
                                                        v.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.pluginsdk.model.downloader.c.dG(be.getLong(str22, 0)).field_downloadId), com.tencent.mm.pluginsdk.model.downloader.c.dG(be.getLong(str22, 0)).field_downloadUrl, com.tencent.mm.pluginsdk.model.downloader.c.dG(be.getLong(str22, 0)).field_filePath, com.tencent.mm.pluginsdk.model.downloader.c.dG(be.getLong(str22, 0)).field_md5);
                                                    } else {
                                                        v.i("getdltaskinfo", "infoID null");
                                                    }
                                                } catch (Exception e18) {
                                                    if (com.tencent.mm.pluginsdk.model.downloader.c.GM(str22) != null) {
                                                        v.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.pluginsdk.model.downloader.c.GM(str22).field_downloadId), com.tencent.mm.pluginsdk.model.downloader.c.GM(str22).field_downloadUrl, com.tencent.mm.pluginsdk.model.downloader.c.GM(str22).field_filePath, com.tencent.mm.pluginsdk.model.downloader.c.GM(str22).field_md5);
                                                    } else {
                                                        v.i("getdltaskinfo", "infoURL null");
                                                    }
                                                }
                                                return true;
                                            }
                                            if (str.startsWith("//testscan ")) {
                                                q.dqT = !q.dqT;
                                                q.dqV = be.getInt(str.replace("//testscan", SQLiteDatabase.KeyEmpty).trim(), 0);
                                                q.dqW = 0;
                                                return true;
                                            }
                                            if (str.startsWith("//switchrecordmode")) {
                                                sharedPreferences = aa.btk();
                                                z = sharedPreferences.getBoolean("settings_voicerecorder_mode", false);
                                                sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", !z).commit();
                                                if (z) {
                                                    Toast.makeText(aa.getContext(), "Turn off silk record", 1).show();
                                                } else {
                                                    Toast.makeText(aa.getContext(), "Turn on silk record", 1).show();
                                                }
                                                return true;
                                            }
                                            if (str.startsWith("//indoorsensorconfig ")) {
                                                com.tencent.mm.modelstat.e.JZ().kv(str.replace("//indoorsensorconfig ", SQLiteDatabase.KeyEmpty));
                                                return true;
                                            }
                                            if (str.startsWith("//testindoorsensor ")) {
                                                String[] split5 = str.replace("//testindoorsensor ", SQLiteDatabase.KeyEmpty).split(",");
                                                com.tencent.mm.modelstat.e.JZ().a(12345, false, split5[0].equals("1"), be.getFloat(split5[1], 0.0f), be.getFloat(split5[2], 0.0f), 12);
                                                return true;
                                            }
                                            v.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(dH(str)));
                                            switch (dH(str)) {
                                                case 0:
                                                    return false;
                                                case 568:
                                                    Assert.assertTrue("test errlog", false);
                                                    return true;
                                                case 569:
                                                    ak.yW().xr();
                                                    return true;
                                                case 570:
                                                    if (com.tencent.mm.storage.az.Nu(dI(str))) {
                                                        Toast.makeText(context, 2131235875, 0).show();
                                                    }
                                                    return true;
                                                case 571:
                                                    str22 = dI(str);
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().set(8195, str22);
                                                    return true;
                                                case 572:
                                                    com.tencent.mm.sdk.platformtools.f.aPY = Integer.valueOf(dI(str)).intValue();
                                                    return true;
                                                case 574:
                                                    StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.d.p.rJ());
                                                    ak.yW();
                                                    com.tencent.mm.ui.base.g.z(context, com.tencent.mm.a.g.m(append.append(com.tencent.mm.model.c.ww()).toString().getBytes()), "md5");
                                                    return true;
                                                case 579:
                                                    com.tencent.mm.model.ab.a.yF().I(dI(str), SQLiteDatabase.KeyEmpty);
                                                    return true;
                                                case 580:
                                                    ak.vy().d(new ay(new ay.a() {
                                                        public final void a(com.tencent.mm.network.e eVar) {
                                                            if (eVar != null) {
                                                                com.tencent.mm.network.c BU = eVar.BU();
                                                                byte[] bArr = new byte[0];
                                                                ak.yW();
                                                                BU.i(bArr, com.tencent.mm.model.c.ww());
                                                            }
                                                        }
                                                    }));
                                                    return true;
                                                case 581:
                                                    com.tencent.mm.pluginsdk.model.app.am.bnA().Gx(dI(str));
                                                    return true;
                                                case 582:
                                                    str22 = dI(str);
                                                    ak.yW();
                                                    LX = com.tencent.mm.model.c.wH().LX(str22);
                                                    if (LX == null || LX.tS() == 0) {
                                                        return false;
                                                    }
                                                    LX.tp();
                                                    m.r(LX);
                                                    return true;
                                                case 583:
                                                    ak.yW();
                                                    com.tencent.mm.model.c.xs();
                                                    return true;
                                                case 584:
                                                case 585:
                                                    ax.fR(dI(str));
                                                    return true;
                                                case 586:
                                                    split3 = str.split(" ");
                                                    if (split3 != null && split3.length == 3) {
                                                        com.tencent.mm.modelmulti.r.aJ(be.getInt(split3[1], 0), be.getInt(split3[2], 0));
                                                    }
                                                    return true;
                                                case 587:
                                                    com.tencent.mm.sdk.c.a.nhr.z(new br());
                                                    return true;
                                                case 588:
                                                    com.tencent.mm.a.e.aU("/sdcard/tencent/MicroMsg/back");
                                                    ak.yW();
                                                    com.tencent.mm.sdk.platformtools.j.n(com.tencent.mm.model.c.xp(), "/sdcard/tencent/MicroMsg/back", false);
                                                    return true;
                                                case 590:
                                                    btk = aa.btm();
                                                    com.tencent.mm.compatible.d.r.ar(201, btk.getInt("com.tencent.mm_device_today_step", com.tencent.mm.compatible.d.r.getInt(201, 0)));
                                                    com.tencent.mm.compatible.d.r.i(202, btk.getLong("com.tencent.mm_device_today_time", com.tencent.mm.compatible.d.r.getLong(202, 0)));
                                                    com.tencent.mm.compatible.d.r.ar(203, btk.getInt("com.tencent.mm_device_previous_step", com.tencent.mm.compatible.d.r.getInt(203, 0)));
                                                    com.tencent.mm.compatible.d.r.i(204, btk.getLong("com.tencent.mm_device_last_step_time", com.tencent.mm.compatible.d.r.getLong(204, 0)));
                                                    v.i("MicroMsg.CommandProcessor", "step data migration succ.(tStepCfg:%s, tStepSp:%s, tTimeCfg:%s, tTimeSp:%s, pStepCfg:%s, pStepSp:%s, lStepCfg:%s, lStepSp:%s)", Integer.valueOf(dimensionPixelSize), Integer.valueOf(i), Long.valueOf(r6), Long.valueOf(r8), Integer.valueOf(r5), Integer.valueOf(r10), Long.valueOf(r12), Long.valueOf(r14));
                                                    Toast.makeText(context, String.format("step data migration succ.(tStepCfg:%s, tStepSp:%s, tTimeCfg:%s, tTimeSp:%s, pStepCfg:%s, pStepSp:%s, lStepCfg:%s, lStepSp:%s)", new Object[]{Integer.valueOf(dimensionPixelSize), Integer.valueOf(i), Long.valueOf(r6), Long.valueOf(r8), Integer.valueOf(r5), Integer.valueOf(r10), Long.valueOf(r12), Long.valueOf(r14)}), 1).show();
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        } else if (2 < v.getLogLevel()) {
                                            return false;
                                        } else {
                                            replace = com.tencent.mm.model.c.c.Au().buY();
                                            textView2 = new TextView(context);
                                            textView2.setText(replace);
                                            textView2.setGravity(8388627);
                                            textView2.setTextSize(1, 10.0f);
                                            textView2.setLayoutParams(new LayoutParams(-1, -2));
                                            textView2.setTextColor(-16744704);
                                            textView2.setTypeface(Typeface.MONOSPACE);
                                            textView2.setMovementMethod(new ScrollingMovementMethod());
                                            intValue = context.getResources().getDimensionPixelSize(2131493135);
                                            textView2.setPadding(intValue, intValue, intValue, intValue);
                                            com.tencent.mm.ui.base.g.a(context, null, textView2, null);
                                            return true;
                                        }
                                    }
                                }
                                ai.bmA().fg(str.equals("//checkUpdate1"));
                                ai.lyb = true;
                                return true;
                            }
                        }
                        com.tencent.mm.ui.tools.e.a(str.replace("//recover", SQLiteDatabase.KeyEmpty), new com.tencent.mm.ui.tools.e.a() {
                        });
                        return true;
                    } else if (!ak.uz()) {
                        return false;
                    } else {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                        return true;
                    }
                } else if (!ak.uz()) {
                    return false;
                } else {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
                    return true;
                }
            } else if (!ak.uz()) {
                return false;
            } else {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                return true;
            }
        } else if (!ak.uz()) {
            return false;
        } else {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
            return true;
        }
    }

    private static StringBuilder ee(int i) {
        BufferedReader bufferedReader;
        Throwable e;
        Date date = new Date(be.Ni() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.cnk + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        if (!new File(str).exists()) {
            return new StringBuilder(" day -" + i + " no crash.");
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                if (be.kS(bufferedReader.readLine())) {
                    bufferedReader.close();
                    StringBuilder stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (Exception e2) {
                        return stringBuilder2;
                    }
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            try {
                v.a("MicroMsg.CommandProcessor", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static void ef(int i) {
        SharedPreferences aX = aj.aX(aa.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                aX.edit().remove("st_sw_use_vcodec_img").commit();
                return;
            case 0:
                aX.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                return;
            case 1:
                aX.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }

    private static void eg(int i) {
        SharedPreferences aX = aj.aX(aa.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                aX.edit().remove("st_sw_use_wxpc_img").commit();
                return;
            case 0:
                aX.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                return;
            case 1:
                aX.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }
}
