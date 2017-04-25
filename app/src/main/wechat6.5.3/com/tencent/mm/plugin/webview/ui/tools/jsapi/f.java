package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f implements d {
    private static final int lou = (d.dX(19) ? 200 : 20);
    public int lhu;
    public com.tencent.mm.plugin.webview.stub.d liH;
    public Map<String, Object> loA;
    public boolean loB = false;
    private e loC;
    public boolean loD = false;
    public String loE = "";
    private final List<String> loF = new LinkedList();
    volatile String loG = null;
    private JSONObject loH = new JSONObject();
    private JSONArray loI = new JSONArray();
    private List<String> loJ = new LinkedList();
    private ah loK = new ah(new a(this) {
        final /* synthetic */ f loM;

        {
            this.loM = r1;
        }

        public final boolean oU() {
            this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + k.a.a("onBeaconsInRange", this.loM.loH, this.loM.loD, this.loM.loE) + ")", null);
            this.loM.loJ.clear();
            this.loM.loH = new JSONObject();
            this.loM.loI = new JSONArray();
            return false;
        }
    }, false);
    public long loL = 0;
    public MMWebView lov;
    private final List<String> low = new LinkedList();
    private final LinkedList<k> lox = new LinkedList();
    private ac loy = null;
    Map<String, Object> loz;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass11(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onNfcTouch fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass13(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass14 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass14(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass15 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass15(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass20 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass20(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass23 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass23(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass24 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass24(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass25 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass25(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass26 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass26(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass27 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass27(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass28 implements Runnable {
        final /* synthetic */ f loM;
        final /* synthetic */ String loQ;

        public AnonymousClass28(f fVar, String str) {
            this.loM = fVar;
            this.loQ = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript(this.loQ, null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass29 implements Runnable {
        final /* synthetic */ f loM;
        final /* synthetic */ String loQ;

        public AnonymousClass29(f fVar, String str) {
            this.loM = fVar;
            this.loQ = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript(this.loQ, null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass2(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass30 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass30(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass33 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass33(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass40 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass40(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass41 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass41(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass42 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass42(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "onWXDeviceBluetoothStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass43 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass43(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String dEP;
        final /* synthetic */ f loM;

        public AnonymousClass5(f fVar, String str) {
            this.loM = fVar;
            this.dEP = str;
        }

        public final void run() {
            try {
                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.dEP + ")", null);
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    static /* synthetic */ void b(f fVar) {
        if (fVar.low.size() <= 0) {
            v.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            return;
        }
        v.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + (fVar.lox == null ? "0" : Integer.valueOf(fVar.lox.size())));
        Collection d = k.a.d((String) fVar.low.remove(0), fVar.loD, fVar.loE);
        if (!be.bP(d)) {
            fVar.lox.addAll(d);
            v.i("MicroMsg.JsApiHandler", "now msg list size : %d", new Object[]{Integer.valueOf(fVar.lox.size())});
        }
        v.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + (fVar.lox == null ? "0" : Integer.valueOf(fVar.lox.size())));
        fVar.ble();
        if (fVar.loy != null) {
            fVar.loy.post(new Runnable(fVar) {
                final /* synthetic */ f loM;

                {
                    this.loM = r1;
                }

                public final void run() {
                    f.b(this.loM);
                }
            });
        }
    }

    static /* synthetic */ void j(f fVar) {
        do {
        } while (fVar.blf());
    }

    public f(MMWebView mMWebView, e eVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        this.lov = mMWebView;
        this.loC = eVar;
        this.loy = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ f loM;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!be.kS(str)) {
                            this.loM.low.add(str);
                        }
                        f.b(this.loM);
                        return;
                    case 2:
                        v.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.liH = dVar;
        this.loz = map;
        this.lhu = i;
    }

    public final void ay(String str, boolean z) {
        try {
            this.liH.g(str, z, this.lhu);
        } catch (Exception e) {
            v.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + e);
        }
    }

    public final boolean Fs(String str) {
        if (be.kS(str)) {
            return false;
        }
        return s.ds(str, "weixin://dispatch_message/");
    }

    public final boolean Fj(String str) {
        this.lov.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", null);
        return true;
    }

    public final void bld() {
        v.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[]{Boolean.valueOf(this.loB)});
        if (this.lov != null && this.loB) {
            MMWebView mMWebView = this.lov;
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            Map hashMap = new HashMap();
            JsapiPermissionWrapper bjS = this.loC.bjS();
            Collection linkedList = new LinkedList();
            if (bjS != null) {
                if (bjS.uC(88)) {
                    linkedList.add("menu:share:timeline");
                }
                if (bjS.uC(89)) {
                    linkedList.add("menu:share:appmessage");
                }
                if (bjS.uC(94)) {
                    linkedList.add("menu:share:qq");
                }
                if (bjS.uC(109)) {
                    linkedList.add("menu:share:weiboApp");
                }
                if (bjS.uC(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX)) {
                    linkedList.add("menu:share:QZone");
                }
                linkedList.add("onVoiceRecordEnd");
                linkedList.add("onVoicePlayBegin");
                linkedList.add("onVoicePlayEnd");
                linkedList.add("onLocalImageUploadProgress");
                linkedList.add("onImageDownloadProgress");
                linkedList.add("onVoiceUploadProgress");
                linkedList.add("onVoiceDownloadProgress");
                linkedList.add("onVideoUploadProgress");
                linkedList.add("onMediaFileUploadProgress");
                linkedList.add("menu:setfont");
                linkedList.add("menu:share:weibo");
                linkedList.add("menu:share:email");
                linkedList.add("wxdownload:state_change");
                linkedList.add("wxdownload:progress_change");
                linkedList.add("hdOnDeviceStateChanged");
                linkedList.add("activity:state_change");
                linkedList.add("onWXDeviceBluetoothStateChange");
                linkedList.add("onWXDeviceLanStateChange");
                linkedList.add("onWXDeviceBindStateChange");
                linkedList.add("onReceiveDataFromWXDevice");
                linkedList.add("onScanWXDeviceResult");
                linkedList.add("onWXDeviceStateChange");
                linkedList.add("onNfcTouch");
                linkedList.add("onBeaconMonitoring");
                linkedList.add("onBeaconsInRange");
                linkedList.add("menu:custom");
                linkedList.add("onSearchDataReady");
                linkedList.add("onSearchImageListReady");
                linkedList.add("onTeachSearchDataReady");
                linkedList.add("onSearchInputChange");
                linkedList.add("onSearchInputConfirm");
                linkedList.add("onSearchSuggestionDataReady");
                linkedList.add("onMusicStatusChanged");
                linkedList.add("onPullDownRefresh");
                linkedList.add("onPageStateChange");
                linkedList.add("onGetKeyboardHeight");
                linkedList.add("onGetSmiley");
                linkedList.add("onGetA8KeyUrl");
                linkedList.add("deleteAccountSuccess");
                linkedList.add("onGetMsgProofItems");
                linkedList.add("WNJSHandlerInsert");
                linkedList.add("WNJSHandlerMultiInsert");
                linkedList.add("WNJSHandlerExportData");
                linkedList.add("WNJSHandlerHeaderAndFooterChange");
                linkedList.add("WNJSHandlerEditableChange");
                linkedList.add("WNJSHandlerEditingChange");
                linkedList.add("WNJSHandlerSaveSelectionRange");
                linkedList.add("WNJSHandlerLoadSelectionRange");
                linkedList.add("showLoading");
                linkedList.add("getSearchEmotionDataCallBack");
                linkedList.add("onNavigationBarRightButtonClick");
                if (!be.bP(null)) {
                    linkedList.addAll(null);
                }
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.evaluateJavascript(stringBuilder.append(k.a.a(str, hashMap, this.loD, this.loE)).append(")").toString(), null);
        }
    }

    private void ble() {
        do {
        } while (blf());
    }

    private boolean blf() {
        if (be.bP(this.lox)) {
            v.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            return false;
        }
        boolean sO;
        try {
            sO = this.liH.sO(this.lhu);
        } catch (Exception e) {
            v.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            sO = false;
        }
        if (sO) {
            v.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            return false;
        } else if (this.lox.size() == 0) {
            v.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            return false;
        } else {
            k kVar = (k) this.lox.remove(0);
            if (kVar == null) {
                v.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                return true;
            } else if (kVar.lqZ == null || kVar.iaJ == null || kVar.type == null || this.lov == null) {
                v.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + kVar.lqZ + ", params = " + kVar.iaJ + ", type = " + kVar.type + ", wv = " + this.lov);
                return true;
            } else {
                if (!(this.loA == null || this.loA.get("srcUsername") == null || be.kS(this.loA.get("srcUsername").toString()))) {
                    kVar.iaJ.put("src_username", this.loA.get("srcUsername").toString());
                }
                if (!(this.loA == null || this.loA.get("srcDisplayname") == null || be.kS(this.loA.get("srcDisplayname").toString()))) {
                    kVar.iaJ.put("src_displayname", this.loA.get("srcDisplayname").toString());
                }
                if (!(this.loA == null || this.loA.get("KTemplateId") == null || be.kS(this.loA.get("KTemplateId").toString()))) {
                    kVar.iaJ.put("tempalate_id", this.loA.get("KTemplateId").toString());
                }
                if (this.loA != null) {
                    kVar.iaJ.put("message_id", this.loA.get("message_id"));
                    kVar.iaJ.put("message_index", this.loA.get("message_index"));
                    kVar.iaJ.put("webview_scene", this.loA.get("scene"));
                    kVar.iaJ.put("pay_channel", this.loA.get("pay_channel"));
                    kVar.iaJ.put("stastic_scene", this.loA.get("stastic_scene"));
                }
                if (!(kVar.lqZ.equals("addEmoticon") || kVar.lqZ.equals("hasEmoticon") || kVar.lqZ.equals("cancelAddEmoticon") || kVar.lqZ.equals("shareWeibo") || kVar.lqZ.equals("openUrlByExtBrowser") || kVar.lqZ.equals("openUrlWithExtraWebview") || kVar.lqZ.equals("openCustomWebview"))) {
                    kVar.iaJ.put("url", this.lov.getUrl());
                    v.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.lov.getUrl());
                }
                if (kVar.lqZ.equalsIgnoreCase("openDesignerEmojiView") || kVar.lqZ.equalsIgnoreCase("openEmotionDetailViewLocal") || kVar.lqZ.equalsIgnoreCase("openDesignerEmojiView") || kVar.lqZ.equalsIgnoreCase("openDesignerEmojiViewLocal") || kVar.lqZ.equalsIgnoreCase("openDesignerEmojiView") || kVar.lqZ.equalsIgnoreCase("openDesignerProfile") || kVar.lqZ.equalsIgnoreCase("openDesignerProfileLocal") || kVar.lqZ.equalsIgnoreCase("getSearchEmotionData")) {
                    kVar.iaJ.put("searchID", Long.valueOf(blk()));
                    v.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[]{Long.valueOf(blk())});
                }
                try {
                    JsapiPermissionWrapper bjS = this.loC.bjS();
                    Bundle bundle = new Bundle();
                    if (bjS != null) {
                        bjS.t(bundle);
                    }
                    sO = this.liH.a(kVar.type, kVar.lqZ, kVar.lqX, bundle, k.O(kVar.iaJ), this.lhu);
                } catch (Throwable e2) {
                    v.a("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    v.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                    sO = false;
                }
                v.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[]{kVar.lqZ, Boolean.valueOf(sO)});
                if (sO) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void detach() {
        this.loB = false;
        this.lox.clear();
        this.low.clear();
        this.loy = null;
    }

    public final void keep_setReturnValue(String str, String str2) {
        v.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        v.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.loy != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.loy.sendMessage(obtain);
        }
    }

    public final void blg() {
        if (this.loB) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "friend");
            this.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + k.a.a("menu:share:appmessage", hashMap, this.loD, this.loE) + ")", null);
            try {
                this.liH.w("scene", "friend", this.lhu);
                return;
            } catch (Exception e) {
                v.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        v.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
    }

    public final void c(String str, long j, String str2) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str2);
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("state", str2);
            final String a = k.a.a("wxdownload:state_change", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void g(String str, long j, int i) {
        if (this.loB) {
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            final String a = k.a.a("wxdownload:progress_change", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void bo(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[]{str, Integer.valueOf(i)});
            if (be.kS(str)) {
                v.e("MicroMsg.JsApiHandler", "parameter error!!!");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            final String a = k.a.a("onWXDeviceStateChange", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
    }

    public final void M(Map<String, Object> map) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String a = k.a.a("onVoicePlayEnd", (Map) map, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
    }

    public final void N(Map<String, Object> map) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            final String a = k.a.a("onVoiceRecordEnd", (Map) map, this.loD, this.loE);
            v.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[]{a});
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
    }

    public final void bp(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = k.a.a("onImageUploadProgress", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
    }

    public final void bq(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = k.a.a("onImageDownloadProgress", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
    }

    public final void br(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = k.a.a("onVoiceUploadProgress", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
    }

    public final void bs(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = k.a.a("onVoiceDownloadProgress", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
    }

    public final void bt(String str, int i) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = k.a.a("onVideoUploadProgress", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
    }

    public final void Fv(String str) {
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper bjS = this.loC.bjS();
            if (bjS != null) {
                bjS.t(bundle);
            }
            this.liH.a(str, bundle, this.lhu);
        } catch (Exception e) {
            v.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
        }
    }

    public final void Fw(final String str) {
        v.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[]{str});
        if (!be.kS(str)) {
            this.loG = str;
            final String Fx = Fx(str);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                        this.loM.lov.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        if (this.loM.loB) {
                            this.loM.lov.evaluateJavascript(Fx, null);
                            this.loM.loG = null;
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
    }

    final String Fx(String str) {
        Map hashMap = new HashMap(1);
        hashMap.put("url", str);
        return Fy(k.a.a("onGetA8KeyUrl", hashMap, this.loD, this.loE));
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        int i3 = 1;
        synchronized (this) {
            if (this.loK.btC()) {
                this.loK.ea(1000);
            }
            JSONObject jSONObject = new JSONObject();
            if (d <= 0.0d || d >= 0.5d) {
                i3 = 0;
            }
            try {
                if (!this.loJ.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                    this.loJ.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                    jSONObject.put("uuid", String.valueOf(str));
                    jSONObject.put("major", String.valueOf(i));
                    jSONObject.put("minor", String.valueOf(i2));
                    jSONObject.put("accuracy", String.valueOf(d));
                    jSONObject.put("rssi", String.valueOf(d2));
                    jSONObject.put("heading", String.valueOf(f));
                    jSONObject.put("proximity", String.valueOf(i3));
                    this.loI.put(jSONObject);
                    this.loH.put("beacons", this.loI);
                    this.loH.put("err_msg", "onBeaconsInRange:ok");
                }
            } catch (Exception e) {
                v.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[]{e.getMessage()});
            }
            k.a.a("onBeaconsInRange", this.loH, this.loD, this.loE);
        }
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        if (!be.kS(str)) {
            if (str2 == null || str2.length() == 0 || str == null) {
                v.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + str2);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("err_msg", str2);
                if (map != null && map.size() > 0) {
                    v.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                    hashMap.putAll(map);
                }
                final String a = k.a.a("callback", str, hashMap, null, this.loD, this.loE);
                v.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
                if (!(a == null || this.lov == null)) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ f loM;

                        public final void run() {
                            try {
                                this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                            } catch (Exception e) {
                                v.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[]{e.getMessage()});
                            }
                        }
                    });
                }
            }
        }
        if (z) {
            bjr();
        }
    }

    public final void bjr() {
        if (this.loy != null) {
            this.loy.post(new Runnable(this) {
                final /* synthetic */ f loM;

                {
                    this.loM = r1;
                }

                public final void run() {
                    f.j(this.loM);
                }
            });
        }
    }

    public final void bjq() {
        if (this.lox != null) {
            this.lox.clear();
        }
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            final String a = k.a.a("onSearchInputChange", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
    }

    public static String Fy(String str) {
        return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{be.ma(str)});
    }

    public final void hF(boolean z) {
        v.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[]{Boolean.valueOf(this.loB)});
        if (this.lov != null && this.liH != null && this.loB) {
            if (z) {
                this.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + k.a.a("sys:get_html_content", new HashMap(), this.loD, this.loE) + ")", null);
                return;
            }
            List bjF;
            try {
                bjF = this.liH.bjF();
            } catch (Throwable e) {
                v.a("MicroMsg.JsApiHandler", e, "", new Object[0]);
                bjF = null;
            }
            Uri parse = Uri.parse(this.lov.getUrl());
            if (parse != null) {
                v.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (bjF != null && parse != null && bjF.contains(parse.getHost())) {
                this.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + k.a.a("sys:get_html_content", new HashMap(), this.loD, this.loE) + ")", null);
            }
        }
    }

    public final void blh() {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            Map hashMap = new HashMap();
            hashMap.put("needShow", Boolean.valueOf(true));
            final String a = k.a.a("showLoading", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
    }

    public final void G(final JSONObject jSONObject) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "WNNote:ready, do WNJSHandlerInsert :%s", new Object[]{jSONObject.toString()});
            this.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + k.a.a("WNJSHandlerInsert", jSONObject, this.loD, this.loE) + ")", new u<String>(this) {
                final /* synthetic */ f loM;

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    try {
                        switch (jSONObject.getInt(Columns.TYPE)) {
                            case 2:
                            case 3:
                            case 5:
                                try {
                                    this.loM.liH.i(70, null);
                                    return;
                                } catch (Throwable e) {
                                    v.a("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                    return;
                                }
                            default:
                                return;
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    }
                    v.a("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "WNNote:WNJSHandlerInsert fail, not ready");
    }

    public final void hG(final boolean z) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "WNJSHandlerExportData success, ready");
            Map hashMap = new HashMap();
            hashMap.put("isInsert", Boolean.valueOf(z));
            hashMap.put("isSave", Boolean.valueOf(true));
            final String a = k.a.a("WNJSHandlerExportData", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", new u<String>(this) {
                            final /* synthetic */ AnonymousClass35 loT;

                            {
                                this.loT = r1;
                            }

                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                v.i("MicroMsg.JsApiHandler", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                                Bundle bundle = new Bundle();
                                bundle.putString("ExportData", r5);
                                bundle.putBoolean("isInsert", z);
                                try {
                                    this.loT.loM.liH.i(52, bundle);
                                } catch (Throwable e) {
                                    v.a("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            }
                        });
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "WNJSHandlerExportData fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "WNJSHandlerExportData fail, not ready");
    }

    public final void bli() {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus success, ready");
            Map hashMap = new HashMap();
            hashMap.put("isInsert", Boolean.valueOf(true));
            hashMap.put("isSave", Boolean.valueOf(false));
            final String a = k.a.a("WNJSHandlerExportData", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", new u<String>(this) {
                            final /* synthetic */ AnonymousClass36 loU;

                            {
                                this.loU = r1;
                            }

                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                v.i("MicroMsg.JsApiHandler", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                                Bundle bundle = new Bundle();
                                bundle.putString("ExportData", r5);
                                try {
                                    this.loU.loM.liH.i(69, bundle);
                                } catch (Throwable e) {
                                    v.a("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            }
                        });
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "WNJSHandlerNotifyFinishBtnStatus fail, not ready");
    }

    public final void hH(boolean z) {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("editable", Boolean.valueOf(z));
            final String a = k.a.a("WNJSHandlerEditableChange", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "WNJSHandlerEditableChange fail, not ready");
    }

    public final void blj() {
        if (this.loB) {
            v.i("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("editing", Boolean.valueOf(false));
            final String a = k.a.a("WNJSHandlerEditingChange", hashMap, this.loD, this.loE);
            ad.o(new Runnable(this) {
                final /* synthetic */ f loM;

                public final void run() {
                    try {
                        this.loM.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        v.e("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        v.e("MicroMsg.JsApiHandler", "WNJSHandlerEditingChange fail, not ready");
    }

    public final long blk() {
        v.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[]{Long.valueOf(this.loL)});
        return this.loL;
    }
}
