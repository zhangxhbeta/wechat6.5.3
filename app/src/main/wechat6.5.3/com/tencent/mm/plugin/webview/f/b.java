package com.tencent.mm.plugin.webview.f;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.jsapi.file.d;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int lsB = -1;
    public long bjH;
    public String bjI = "WeNote_";
    private String bmh = null;
    private c iqr = null;
    public int lcO = 0;
    public boolean lsA = false;
    public boolean lsC = false;
    private String lsD = "WeNote_";
    public String lsE = "";
    public boolean lsF = false;
    public String lsv = "";
    public String lsw = "";
    public JSONArray lsx = null;
    public k lsy = null;
    private HashMap<String, String> lsz = new HashMap();

    static /* synthetic */ void a(b bVar, String str) {
        String FK = bVar.FK(str);
        if (!be.kS(bVar.lsw)) {
            if (be.kS(bVar.lsE)) {
                String[] split = FK.split("#WNNoteNode#");
                String FK2 = bVar.FK(bVar.lsw);
                if (split.length > FK2.split("#WNNoteNode#").length) {
                    bVar.lsE = FK2;
                } else {
                    bVar.lsE = FK;
                }
            }
            if (FK.equals(bVar.lsE)) {
                FK = "";
            } else if (be.kS(FK)) {
                FK = "&nbsp;";
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("operation_type", 5);
        bundle.putString("htmlStr", FK);
        j.tl(lsB).O(bundle);
    }

    public static boolean blR() {
        i tl = j.tl(lsB);
        v.i("MicroMsg.MsgHandler", "WNJSHandlerBecomeEditing");
        try {
            if (tl.leB != null) {
                tl.leB.g(43, null);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "WNJSHandlerBecomeEditing exception" + e.getMessage());
        }
        return false;
    }

    public static boolean Q(Map<String, Object> map) {
        ja jaVar = new ja();
        jaVar.bjr.bjt = map.get("localEditorId").toString();
        jaVar.bjr.type = 0;
        a.nhr.z(jaVar);
        return false;
    }

    private String FK(String str) {
        if (be.kS(str) || str.length() == 0) {
            return str;
        }
        String str2;
        CharSequence replaceAll;
        Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
        CharSequence charSequence = "";
        int i = 0;
        while (matcher.find()) {
            str2 = charSequence + str.substring(i, matcher.start());
            int indexOf = matcher.group().indexOf("\"WeNote_");
            charSequence = str2 + "#WNNoteNode#[ThisisNoteNodeObj]_" + matcher.group().substring(indexOf + 1, (matcher.group().substring(indexOf + 1).indexOf("\"") + indexOf) + 1) + "_#WNNoteNode#";
            i = matcher.end();
        }
        if (i < str.length()) {
            charSequence = charSequence + str.substring(i, str.length());
        }
        Matcher matcher2 = Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(Pattern.compile("<span>.</span>", 2).matcher(Pattern.compile("<img[^>]*>", 2).matcher(charSequence).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#")).replaceAll("")).replaceAll(""));
        if (be.kS(this.lsw)) {
            replaceAll = matcher2.replaceAll("");
        } else {
            replaceAll = matcher2.replaceAll("\n");
        }
        str2 = Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(replaceAll).replaceAll("")).replaceAll("")).replaceAll("");
        if (be.kS(this.lsw)) {
            str2 = Pattern.compile("&nbsp;", 2).matcher(str2).replaceAll("");
        }
        if (be.kS(this.lsw)) {
            return str2.trim();
        }
        return str2;
    }

    public final void n(int i, Bundle bundle) {
        while (true) {
            String FL;
            ja jaVar;
            ez ezVar;
            i tl;
            switch (i) {
                case d.CTRL_INDEX /*51*/:
                    this.lsz.clear();
                    blS();
                    this.lsF = false;
                    return;
                case JsApiLogin.CTRL_INDEX /*52*/:
                    if (bundle == null) {
                        v.e("MicroMsg.WNNoteWebViewLogic", "handleWNNoteAction,but data is null");
                        return;
                    }
                    FL = FL(bundle.getString("ExportData"));
                    if (be.kS(FL)) {
                        v.e("MicroMsg.WNNoteWebViewLogic", "exportJsonData is null or nil");
                        return;
                    }
                    boolean contains = FL.contains("\"isSave\":true");
                    boolean contains2 = FL.contains("\"isInsert\":true");
                    if (contains) {
                        bundle.putBoolean("isInsert", contains2);
                        contains = bundle.getBoolean("isInsert");
                        ja jaVar2 = new ja();
                        jaVar2.bjr.type = 5;
                        jaVar2.bjr.bjv = FL;
                        jaVar2.bjr.bjw = contains;
                        a.nhr.z(jaVar2);
                        return;
                    }
                    i = 69;
                case 53:
                    FL = bundle.getString("insertJsonString");
                    ja jaVar3 = new ja();
                    jaVar3.bjr.type = 4;
                    jaVar3.bjr.bju = FL;
                    a.nhr.z(jaVar3);
                    return;
                case 54:
                    jaVar = new ja();
                    jaVar.bjr.type = 6;
                    jaVar.bjr.bjx = bundle;
                    jaVar.bjr.context = aa.getContext();
                    a.nhr.z(jaVar);
                    return;
                case 55:
                    ezVar = new ez();
                    ezVar.bdQ.type = 26;
                    a.nhr.z(ezVar);
                    bundle.putString("path", ezVar.bdR.path);
                    bundle.putBoolean("isPlay", ezVar.bdR.bee);
                    bundle.putBoolean("resumePlay", ezVar.bdR.bef);
                    bundle.putBoolean("isPause", ezVar.bdR.beg);
                    bundle.putDouble("getProgress", ezVar.bdR.beh);
                    tl = j.tl(lsB);
                    v.i("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStatus");
                    try {
                        if (tl.leB != null) {
                            tl.leB.g(38, bundle);
                            return;
                        }
                        return;
                    } catch (RemoteException e) {
                        v.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStatus exception" + e.getMessage());
                        return;
                    }
                case 56:
                    ezVar = new ez();
                    ezVar.bdQ.type = 25;
                    a.nhr.z(ezVar);
                    return;
                case 57:
                    ezVar = new ez();
                    ezVar.bdQ.type = 23;
                    a.nhr.z(ezVar);
                    return;
                case 58:
                    ezVar = new ez();
                    ezVar.bdQ.type = 24;
                    ezVar.bdQ.path = bundle.getString("path");
                    ezVar.bdQ.bdW = bundle.getInt("voicetype");
                    ezVar.bdQ.bdX = bundle.getInt("position");
                    a.nhr.z(ezVar);
                    bundle.putBoolean("result", ezVar.bdR.bee);
                    tl = j.tl(lsB);
                    v.i("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart");
                    try {
                        if (tl.leB != null) {
                            tl.leB.g(39, bundle);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        v.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart exception" + e2.getMessage());
                        return;
                    }
                case 59:
                    ezVar = new ez();
                    ezVar.bdQ.type = 22;
                    a.nhr.z(ezVar);
                    return;
                case EncrptType.VERIFY_CODE /*60*/:
                    final long j = bundle.getLong("localId");
                    ez ezVar2 = new ez();
                    ezVar2.bdQ.type = 12;
                    ezVar2.bdQ.aZa = bundle.getLong("localId");
                    ezVar2.bdQ.bdU = new Runnable(this) {
                        final /* synthetic */ b lsG;

                        public final void run() {
                            v.d("MicroMsg.WNNoteWebViewLogic", "do del, local id %d", new Object[]{Long.valueOf(j)});
                            i tl = j.tl(b.lsB);
                            v.i("MicroMsg.MsgHandler", "WNJSHandlerFinishActivity");
                            try {
                                if (tl.leB != null) {
                                    tl.leB.g(34, new Bundle());
                                }
                            } catch (RemoteException e) {
                                v.w("MicroMsg.MsgHandler", "WNJSHandlerFinishActivity exception" + e.getMessage());
                            }
                        }
                    };
                    a.nhr.z(ezVar2);
                    return;
                case 61:
                    if (this.lsz.containsValue("WeNoteHtmlFile")) {
                        tl = j.tl(lsB);
                        v.i("MicroMsg.MsgHandler", "WNJSHandlerLoadingStart");
                        try {
                            if (tl.leB != null) {
                                tl.leB.g(44, null);
                                return;
                            }
                            return;
                        } catch (RemoteException e22) {
                            v.w("MicroMsg.MsgHandler", "WNJSHandlerLoadingStart exception" + e22.getMessage());
                            return;
                        }
                    }
                    return;
                case ao.CTRL_INDEX /*62*/:
                    FL = bundle.getString("username");
                    final String string = bundle.getString("customText");
                    if (Boolean.valueOf(bundle.getBoolean("fromsession", false)).booleanValue()) {
                        long j2 = bundle.getLong("msgId", -1);
                        ak.yW();
                        final at ek = com.tencent.mm.model.c.wJ().ek(j2);
                        if (ek.field_msgId != j2) {
                            v.w("MicroMsg.WNNoteWebViewLogic", "want to send note msg, but message info is null");
                            return;
                        } else {
                            ak.vA().x(new Runnable(this) {
                                final /* synthetic */ b lsG;

                                public final void run() {
                                    kw kwVar = new kw();
                                    kwVar.bmf.type = 4;
                                    kwVar.bmf.bmk = ek;
                                    kwVar.bmf.toUser = FL;
                                    kwVar.bmf.bdV = string;
                                    a.nhr.z(kwVar);
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass3 lsI;

                                        {
                                            this.lsI = r1;
                                        }

                                        public final void run() {
                                            Bundle bundle = new Bundle();
                                            bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", true);
                                            j.tl(b.lsB).N(bundle);
                                        }
                                    });
                                }

                                public final String toString() {
                                    return super.toString() + "|onActivityResult";
                                }
                            });
                            return;
                        }
                    }
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ b lsG;

                        public final void run() {
                            ez ezVar = new ez();
                            ezVar.bdQ.type = 32;
                            ezVar.bdQ.aZa = this.lsG.bjH;
                            a.nhr.z(ezVar);
                            if (ezVar.bdR.ret != 0) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", false);
                                bundle.putBoolean("AC_WNNOTE_SEND_TO_USER_FAILE_REASON", ezVar.bdR.beg);
                                j.tl(b.lsB).N(bundle);
                                return;
                            }
                            ezVar = new ez();
                            ezVar.bdQ.type = 13;
                            ezVar.bdQ.context = aa.getContext();
                            ezVar.bdQ.toUser = FL;
                            ezVar.bdQ.bdV = string;
                            ezVar.bdQ.aZa = this.lsG.bjH;
                            ezVar.bdQ.bdU = new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 lsJ;

                                {
                                    this.lsJ = r1;
                                }

                                public final void run() {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", true);
                                    j.tl(b.lsB).N(bundle);
                                }
                            };
                            a.nhr.z(ezVar);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult";
                        }
                    });
                    return;
                case 64:
                    jaVar = new ja();
                    jaVar.bjr.type = 7;
                    jaVar.bjr.bjy = 4;
                    jaVar.bjr.path = bundle.getString("voicepath");
                    jaVar.bjr.bjz = bundle.getInt("duration");
                    a.nhr.z(jaVar);
                    return;
                case bs.CTRL_INDEX /*65*/:
                    jaVar = new ja();
                    jaVar.bjr.type = 7;
                    jaVar.bjr.bjy = 2;
                    jaVar.bjr.bjA = bundle.getStringArrayList("items");
                    a.nhr.z(jaVar);
                    return;
                case bb.CTRL_INDEX /*66*/:
                    jaVar = new ja();
                    jaVar.bjr.type = 7;
                    jaVar.bjr.bjy = 3;
                    jaVar.bjr.bju = bundle.getString("locationData");
                    jaVar.bjr.context = aa.getContext();
                    a.nhr.z(jaVar);
                    return;
                case aj.CTRL_INDEX /*67*/:
                    jaVar = new ja();
                    jaVar.bjr.type = 7;
                    jaVar.bjr.bjy = 5;
                    jaVar.bjr.path = bundle.getString("path");
                    a.nhr.z(jaVar);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.at.CTRL_INDEX /*68*/:
                    jaVar = new ja();
                    jaVar.bjr.type = 8;
                    jaVar.bjr.path = bundle.getString("voicepath");
                    jaVar.bjr.context = aa.getContext();
                    a.nhr.z(jaVar);
                    return;
                case q.CTRL_INDEX /*69*/:
                    FL = null;
                    try {
                        FL = new JSONObject(FL(bundle.getString("ExportData", ""))).getString("html");
                    } catch (JSONException e3) {
                        v.e("MicroMsg.WNNoteWebViewLogic", "notify_ui_finishbutton crash, error is %s", new Object[]{e3.getMessage()});
                    }
                    if (be.kS(FL)) {
                        v.e("MicroMsg.WNNoteWebViewLogic", "AC_WNNOTE_JS_NOTIFY_UI_FINISHBUTTON,but htmlStr is null or nil");
                        return;
                    } else {
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ b lsG;

                            public final void run() {
                                String str = FL;
                                ArrayList arrayList = new ArrayList();
                                Set hashSet = new HashSet();
                                int i = 0;
                                while (i < str.length()) {
                                    i = str.indexOf(this.lsG.lsD, i + 1);
                                    if (i == -1) {
                                        break;
                                    }
                                    int indexOf = str.indexOf("\"", i + 1);
                                    if (indexOf == -1) {
                                        break;
                                    }
                                    int indexOf2 = str.indexOf(" ", i + 1);
                                    if (indexOf2 == -1) {
                                        break;
                                    }
                                    if (indexOf >= indexOf2) {
                                        indexOf = indexOf2;
                                    }
                                    String substring = str.substring(i, indexOf);
                                    if (hashSet.add(substring)) {
                                        arrayList.add(substring);
                                    }
                                }
                                hashSet.clear();
                                b.a(this.lsG, FL);
                                ja jaVar = new ja();
                                jaVar.bjr.type = 11;
                                jaVar.bjr.bjA = arrayList;
                                a.nhr.z(jaVar);
                            }
                        });
                        return;
                    }
                case g.CTRL_INDEX /*70*/:
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("operation_type", 6);
                    j.tl(lsB).O(bundle2);
                    return;
                default:
                    return;
            }
        }
    }

    private static String FL(String str) {
        if (!str.startsWith("{\"")) {
            str = str.substring(1, str.length() - 1);
        }
        if (str.startsWith("{\"")) {
            return str;
        }
        return str.replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\u003C", "<");
    }

    public final synchronized void blS() {
        String str = "MicroMsg.WNNoteWebViewLogic";
        String str2 = "WNNote:initWebviewLogicData hasAreadyInit = %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.lsF ? "true" : "false";
        v.i(str, str2, objArr);
        if (!this.lsF) {
            this.lsF = true;
            this.lsA = false;
            this.lsE = "";
            this.lsx = null;
            this.lsw = "";
            this.lsy = null;
            this.bjH = -1;
            v.i("MicroMsg.WNNoteWebViewLogic", "WNNote:initWebviewLogicData mNoteJsonArray is null");
        }
    }
}
