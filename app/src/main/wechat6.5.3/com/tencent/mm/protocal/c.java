package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> lVV = null;

    public static abstract class g {
        protected String NAME = "noName";
        protected String lVW = "";
        protected int lVX = -1;
        protected boolean lVY = false;

        public g(String str, String str2, int i, boolean z) {
            this.NAME = str;
            this.lVW = str2;
            this.lVX = i;
            this.lVY = z;
        }

        public final String getName() {
            return this.NAME;
        }

        public final String brr() {
            return this.lVW;
        }

        public final int brs() {
            return this.lVX;
        }

        public final boolean brt() {
            return this.lVY;
        }
    }

    public static final class ic {
        public static Set<String> lVZ;
    }

    public static class a extends g {
        public a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, 210, false);
        }
    }

    public static class aa extends g {
        public aa() {
            super("clearWebviewCache", "clearWebviewCache", 208, false);
        }
    }

    public static class ab extends g {
        public ab() {
            super("clickSnsMusicPlayButton", "", 10000, false);
        }
    }

    public static class ac extends g {
        public ac() {
            super("closeWindow", "close_window", 17, false);
        }
    }

    public static class ad extends g {
        public ad() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    public static class ae extends g {
        public ae() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class af extends g {
        public af() {
            super("connectToFreeWifi", "connectToFreeWifi", 95, false);
        }
    }

    public static class ag extends g {
        public ag() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    public static class ah extends g {
        public ah() {
            super("connectWXDevice", "connectWXDevice", com.tencent.mm.plugin.appbrand.jsapi.au.CTRL_INDEX, true);
        }
    }

    public static class ai extends g {
        public ai() {
            super("consumedShareCard", "consumedShareCard", 177, true);
        }
    }

    public static class aj extends g {
        public aj() {
            super("deleteAccountSuccess", "deleteAccountSuccess", com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX, false);
        }
    }

    public static class ak extends g {
        public ak() {
            super("disableBounceScroll", "disableBounceScroll", 188, false);
        }
    }

    public static class al extends g {
        public al() {
            super("disablePullDownRefresh", "disablePullDownRefresh", 205, false);
        }
    }

    public static class am extends g {
        public am() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    public static class an extends g {
        public an() {
            super("downloadImage", "downloadImage", 106, true);
        }
    }

    public static class ao extends g {
        public ao() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    public static class ap extends g {
        public ap() {
            super("doExposePreparation", "doExposePreparation", 225, false);
        }
    }

    public static class aq extends g {
        public aq() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    public static class ar extends g {
        public ar() {
            super("openEmotionUrl", "openEmotionUrl", 20000, false);
        }
    }

    public static class as extends g {
        public as() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class at extends g {
        public at() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    public static class au extends g {
        public au() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    public static class av extends g {
        public av() {
            super("openEmotionPage", "", 10000, false);
        }
    }

    public static class aw extends g {
        public aw() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    public static class ax extends g {
        public ax() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    public static class ay extends g {
        public ay() {
            super("getBrandWCPayRequest", "get_brand_wcpay_request", 28, true);
        }
    }

    public static class az extends g {
        public az() {
            super("getCurrentSSID", "getCurrentSSID", 176, true);
        }
    }

    public static class b extends g {
        public b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, 211, false);
        }
    }

    public static class ba extends g {
        public ba() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    public static class bb extends g {
        public bb() {
            super("getEnterpriseChat", "getEnterpriseChat", 244, false);
        }
    }

    public static class bc extends g {
        public bc() {
            super("getGameCommInfo", "getGameCommInfo", 241, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    public static class be extends g {
        public be() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class bf extends g {
        public bf() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class bg extends g {
        public bg() {
            super("getInstallState", "get_install_state", 25, false);
        }
    }

    public static class bh extends g {
        public bh() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    public static class bi extends g {
        public bi() {
            super("getMsgProofItems", "getMsgProofItems", 226, true);
        }
    }

    public static class bj extends g {
        public bj() {
            super(com.tencent.mm.plugin.appbrand.jsapi.y.NAME, "network_type", 16, false);
        }
    }

    public static class bk extends g {
        public bk() {
            super("getOpenDeviceId", "getOpenDeviceId", 227, false);
        }
    }

    public static class bl extends g {
        public bl() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    public static class bm extends g {
        public bm() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    public static class bn extends g {
        public bn() {
            super("getRouteUrl", "getRouteUrl", 235, false);
        }
    }

    public static class bo extends g {
        public bo() {
            super("getSearchAvatarList", "", 10000, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("getSearchData", "", 10000, false);
        }
    }

    public static class bq extends g {
        public bq() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", 10000, false);
        }
    }

    public static class br extends g {
        public br() {
            super("getSearchEmotionData", "getSearchEmotionData", 20000, false);
        }
    }

    public static class bs extends g {
        public bs() {
            super("getSearchImageList", "", 10000, false);
        }
    }

    public static class bt extends g {
        public bt() {
            super("getSearchSnsImageList", "", 10000, false);
        }
    }

    public static class bu extends g {
        public bu() {
            super("getSearchSuggestionData", "", 10000, false);
        }
    }

    public static class bv extends g {
        public bv() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    public static class bw extends g {
        public bw() {
            super("getTeachSearchData", "", 10000, false);
        }
    }

    public static class bx extends g {
        public bx() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    public static class by extends g {
        public by() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", 194, true);
        }
    }

    public static class bz extends g {
        public bz() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", 112, false);
        }
    }

    public static class c extends g {
        public c() {
            super("getLocalImgData", "getLocalImgData", 249, false);
        }
    }

    public static class ca extends g {
        public ca() {
            super("getWXDeviceInfos", "getWXDeviceInfos", 119, true);
        }
    }

    public static class cb extends g {
        public cb() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class cc extends g {
        public cc() {
            super("hasEmoticon", "has_emoticon", 9, false);
        }
    }

    public static class cd extends g {
        public cd() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class ce extends g {
        public ce() {
            super("hideMenuItems", "hideMenuItems", 85, false);
        }
    }

    public static class cf extends g {
        public cf() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ag.NAME, com.tencent.mm.plugin.appbrand.jsapi.ag.NAME, 198, false);
        }
    }

    public static class cg extends g {
        public cg() {
            super("hideOptionMenu", "", 14, false);
        }
    }

    public static class ch extends g {
        public ch() {
            super("idCardRealnameVerify", "idCardRealnameVerify", 235, true);
        }
    }

    public static class ci extends g {
        public ci() {
            super("imagePreview", "", 1, false);
        }
    }

    public static class cj extends g {
        public cj() {
            super("installDownloadTask", "install_download_task", 41, false);
        }
    }

    public static class ck extends g {
        public ck() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    public static class cm extends g {
        public cm() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    public static class cn extends g {
        public cn() {
            super("jumpToWXWallet", "jumpToWXWallet", 147, true);
        }
    }

    public static class co extends g {
        public co() {
            super("kvReport", "kvReport", 170, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super("launch3rdApp", "launch_3rdApp", 52, false);
        }
    }

    public static class cq extends g {
        public cq() {
            super("launchApp", "", 27, false);
        }
    }

    public static class cr extends g {
        public cr() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", 161, true);
        }
    }

    public static class cs extends g {
        public cs() {
            super("log", "", 0, false);
        }
    }

    public static class ct extends g {
        public ct() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class cu extends g {
        public cu() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class cv extends g {
        public cv() {
            super(com.tencent.mm.plugin.appbrand.jsapi.aq.NAME, "open_location", 63, false);
        }
    }

    public static class cw extends g {
        public cw() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    public static class cx extends g {
        public cx() {
            super("nfcBatchTransceive", "nfcBatchTransceive", 142, false);
        }
    }

    public static class cy extends g {
        public cy() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    public static class cz extends g {
        public cz() {
            super("nfcConnect", "nfcConnect", com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, false);
        }
    }

    public static class d extends g {
        public d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", 20000, false);
        }
    }

    public static class da extends g {
        public da() {
            super("nfcGetId", "nfcGetId", 143, false);
        }
    }

    public static class db extends g {
        public db() {
            super("nfcGetInfo", "nfcGetInfo", JsApiScanCode.CTRL_INDEX, false);
        }
    }

    public static class dc extends g {
        public dc() {
            super("nfcIsConnect", "nfcIsConnect", 139, true);
        }
    }

    public static class dd extends g {
        public dd() {
            super("nfcTransceive", "nfcTransceive", com.tencent.mm.plugin.appbrand.jsapi.map.i.CTRL_INDEX, false);
        }
    }

    private static final class de extends g {
        de() {
            super("openCustomWebview", "openCustomWebview", 256, false);
        }
    }

    public static class df extends g {
        public df() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    public static class dg extends g {
        public dg() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", 20000, false);
        }
    }

    public static class dh extends g {
        public dh() {
            super("openDesignerProfile", "openDesignerProfile", 193, true);
        }
    }

    public static class di extends g {
        public di() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", 20000, false);
        }
    }

    public static class dj extends g {
        public dj() {
            super("openEmoticonTopicList", "openEmoticonTopicList", 212, true);
        }
    }

    public static class dk extends g {
        public dk() {
            super("openEnterpriseChat", "openEnterpriseChat", 165, false);
        }
    }

    public static class dl extends g {
        public dl() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    public static class dm extends g {
        public dm() {
            super("openGameCenter", "openGameCenter", 175, true);
        }
    }

    public static class dn extends g {
        public dn() {
            super("openGameDetail", "openGameDetail", 131, true);
        }
    }

    public static class do extends g {
        public do() {
            super("openGameRegion", "openGameRegion", 242, true);
        }
    }

    public static class dp extends g {
        public dp() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", 245, false);
        }
    }

    public static class dq extends g {
        public dq() {
            super("openMapNavigateMenu", "openMapNavigateMenu", 184, true);
        }
    }

    public static class dr extends g {
        public dr() {
            super("openMyDeviceProfile", "openMyDeviceProfile", com.tencent.mm.plugin.appbrand.jsapi.t.CTRL_INDEX, false);
        }
    }

    public static class ds extends g {
        public ds() {
            super("openNewPage", "openNewPage", 20000, false);
        }
    }

    public static class dt extends g {
        public dt() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    public static class du extends g {
        public du() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    public static class dv extends g {
        public dv() {
            super("openSecurityView", "openSecurityView", 229, false);
        }
    }

    public static class dw extends g {
        public dw() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    public static class dx extends g {
        public dx() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static class dy extends g {
        public dy() {
            super("openUrlWithExtraWebview", "openUrlWithExtraWebview", 173, false);
        }
    }

    public static class dz extends g {
        public dz() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    public static class e extends g {
        public e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, true);
        }
    }

    private static final class ea extends g {
        ea() {
            super("openWeApp", "openWeApp", 250, false);
        }
    }

    public static class eb extends g {
        public eb() {
            super("openWeAppPage", "", 10000, false);
        }
    }

    public static class ec extends g {
        public ec() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    public static class ed extends g {
        public ed() {
            super("openWXDeviceLib", "openWXDeviceLib", 117, false);
        }
    }

    public static class ee extends g {
        public ee() {
            super("operateGameCenterMsg", "operateGameCenterMsg", 174, false);
        }
    }

    public static class ef extends g {
        public ef() {
            super("pauseDownloadTask", "cancel_download_task", 239, false);
        }
    }

    public static class eg extends g {
        public eg() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    public static class eh extends g {
        public eh() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    private static final class ei extends g {
        ei() {
            super("previewVideo", "previewVideo", 252, true);
        }
    }

    public static class ej extends g {
        public ej() {
            super("preVerifyJSAPI", "pre_verify_jsapi", -3, false);
        }
    }

    public static class ek extends g {
        public ek() {
            super("profile", "profile", 2, true);
        }
    }

    public static class el extends g {
        public el() {
            super("queryDownloadTask", "query_download_task", 40, false);
        }
    }

    public static class em extends g {
        public em() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", 166, true);
        }
    }

    public static class en extends g {
        public en() {
            super("realtimeReport", "realtimeReport", 171, false);
        }
    }

    private static final class eo extends g {
        eo() {
            super("recordVideo", "recordVideo", 251, true);
        }
    }

    public static class ep extends g {
        public ep() {
            super("reportActionInfo", "reportActionInfo", 234, false);
        }
    }

    public static class eq extends g {
        public eq() {
            super("reportIDKey", "reportIDKey", 163, false);
        }
    }

    public static class er extends g {
        public er() {
            super("reportSearchRealTimeStatistics", "", 10000, false);
        }
    }

    public static class es extends g {
        public es() {
            super("reportSearchStatistics", "", 10000, false);
        }
    }

    public static class et extends g {
        public et() {
            super("resendRemittanceMsg", "resendRemittanceMsg", 246, true);
        }
    }

    public static class eu extends g {
        public eu() {
            super("resumeDownloadTask", "cancel_download_task", 240, false);
        }
    }

    public static class ev extends g {
        public ev() {
            super("scanLicence", "scanLicence", 203, false);
        }
    }

    public static class ew extends g {
        public ew() {
            super("scanQRCode", "scanQRCode", 7, false);
        }
    }

    public static class ex extends g {
        public ex() {
            super("searchDataHasResult", "", 10000, false);
        }
    }

    public static class ey extends g {
        public ey() {
            super("selectPedometerSource", "selectPedometerSource", com.tencent.mm.plugin.appbrand.jsapi.bo.CTRL_INDEX, true);
        }
    }

    public static class ez extends g {
        public ez() {
            super("selectSingleContact", "selectSingleContact", 167, true);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.map.g.CTRL_INDEX, true);
        }
    }

    public static class fa extends g {
        public fa() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", 168, true);
        }
    }

    public static class fb extends g {
        public fb() {
            super("sendAppMessage", "send_app_msg", 6, true);
        }
    }

    public static class fc extends g {
        public fc() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    public static class fd extends g {
        public fd() {
            super("sendEnterpriseChat", "sendEnterpriseChat", 222, true);
        }
    }

    public static class fe extends g {
        public fe() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    public static class ff extends g {
        public ff() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    public static class fg extends g {
        public fg() {
            super("setBounceBackground", "setBounceBackground", 218, false);
        }
    }

    public static class fh extends g {
        public fh() {
            super("setCloseWindowConfirmDialogInfo", "setCloseWindowConfirmDialogInfo", 77, false);
        }
    }

    public static class fi extends g {
        public fi() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    public static class fj extends g {
        public fj() {
            super("setFreeWifiOwner", "setFreeWifiOwner", 169, false);
        }
    }

    public static class fk extends g {
        public fk() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    public static class fl extends g {
        public fl() {
            super("setLocalData", "setLocalData", 180, false);
        }
    }

    public static class fm extends g {
        public fm() {
            super("setNavigationBarButtons", "setNavigationBarButtons", 195, false);
        }
    }

    public static class fn extends g {
        public fn() {
            super("setNavigationBarColor", "setNavigationBarColor", 182, false);
        }
    }

    public static class fo extends g {
        public fo() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    public static class fp extends g {
        public fp() {
            super("setPageTitle", "setPageTitle", 1202, false);
        }
    }

    public static class fq extends g {
        public fq() {
            super("setSearchInputWord", "", 10000, false);
        }
    }

    public static class fr extends g {
        public fr() {
            super("setSendDataDirection", "setSendDataDirection", 127, false);
        }
    }

    public static class fs extends g {
        public fs() {
            super("setSnsObjectXmlDescList", "", 10000, false);
        }
    }

    public static class ft extends g {
        public ft() {
            super("setStatusBarStyle", "setStatusBarStyle", 206, false);
        }
    }

    public static class fu extends g {
        public fu() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    public static class fv extends g {
        public fv() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class fw extends g {
        public fw() {
            super("shareWeiboApp", "shareWeiboApp", 107, false);
        }
    }

    public static class fx extends g {
        public fx() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    public static class fy extends g {
        public fy() {
            super(com.tencent.mm.plugin.appbrand.jsapi.b.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.b.c.NAME, 248, true);
        }
    }

    public static class fz extends g {
        public fz() {
            super("showKeyboard", "showKeyboard", 187, false);
        }
    }

    public static class ga extends g {
        public ga() {
            super("showMenuItems", "showMenuItems", 86, false);
        }
    }

    public static class gb extends g {
        public gb() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bn.NAME, com.tencent.mm.plugin.appbrand.jsapi.bn.NAME, 197, false);
        }
    }

    public static class gc extends g {
        public gc() {
            super("showOptionMenu", "", 14, false);
        }
    }

    public static class gd extends g {
        public gd() {
            super("showSmileyPanel", "showSmileyPanel", 238, false);
        }
    }

    public static class ge extends g {
        public ge() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", 214, true);
        }
    }

    public static class gf extends g {
        public gf() {
            super("getSupportSoter", "getSupportSoter", 213, true);
        }
    }

    public static class gg extends g {
        public gg() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, true);
        }
    }

    public static class gh extends g {
        public gh() {
            super("startPullDownRefresh", "startPullDownRefresh", 204, false);
        }
    }

    public static class gi extends g {
        public gi() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    public static class gj extends g {
        public gj() {
            super("startScanWXDevice", "startScanWXDevice", com.tencent.mm.plugin.appbrand.jsapi.ak.CTRL_INDEX, true);
        }
    }

    public static class gk extends g {
        public gk() {
            super("startSearchItemDetailPage", "", 10000, false);
        }
    }

    public static class gl extends g {
        public gl() {
            super("startTempSession", "startTempSession", 128, true);
        }
    }

    public static class gm extends g {
        public gm() {
            super("startVoipCall", "startVoipCall", 230, false);
        }
    }

    public static class gn extends g {
        public gn() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, false);
        }
    }

    public static class go extends g {
        public go() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bq.NAME, com.tencent.mm.plugin.appbrand.jsapi.bq.NAME, 200, false);
        }
    }

    public static class gp extends g {
        public gp() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    public static class gq extends g {
        public gq() {
            super("stopScanWXDevice", "stopScanWXDevice", com.tencent.mm.plugin.appbrand.jsapi.bu.CTRL_INDEX, true);
        }
    }

    public static class gr extends g {
        public gr() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    public static class gs extends g {
        public gs() {
            super("streamingVideoPlay", "playStreamingVideo", 209, false);
        }
    }

    public static class gt extends g {
        public gt() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    public static class gu extends g {
        public gu() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bk.NAME, "share_timeline", 4, true);
        }
    }

    public static class gv extends g {
        public gv() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    public static class gw extends g {
        public gw() {
            super("unbindBankCard", "unbindBankCard", 216, true);
        }
    }

    private static final class gx extends g {
        gx() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", 253, false);
        }
    }

    public static class gy extends g {
        public gy() {
            super("uploadImage", "uploadImage", 105, true);
        }
    }

    public static class gz extends g {
        public gz() {
            super("uploadMediaFile", "uploadMediaFile", 237, true);
        }
    }

    public static class h extends g {
        public h() {
            super("addEmoticon", "add_emoticon", 8, true);
        }
    }

    public static class ha extends g {
        public ha() {
            super("uploadVideo", "uploadVideo", 192, true);
        }
    }

    public static class hb extends g {
        public hb() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    public static class hc extends g {
        public hc() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    public static class hd extends g {
        public hd() {
            super("cache", "cache", com.tencent.mm.plugin.appbrand.jsapi.br.CTRL_INDEX, false);
        }
    }

    public static class he extends g {
        public he() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    public static class hf extends g {
        public hf() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 159, false);
        }
    }

    public static class hg extends g {
        public hg() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 160, false);
        }
    }

    public static class hh extends g {
        public hh() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class hi extends g {
        public hi() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class hj extends g {
        public hj() {
            super("publicCache", "publicCache", 149, false);
        }
    }

    public static class hk extends g {
        public hk() {
            super("videoProxyPreload", "videoProxyPreload", 172, false);
        }
    }

    public static class hl extends g {
        public hl() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    public static class hm extends g {
        public hm() {
            super("reportWeAppSearchRealtime", "", 10000, false);
        }
    }

    public static class hn extends g {
        public hn() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    public static class ho extends g {
        public ho() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    public static class hp extends g {
        public hp() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    public static class hq extends g {
        public hq() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    public static class hr extends g {
        public hr() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    public static class hs extends g {
        public hs() {
            super("writeCommData", "write_comm_data", 53, false);
        }
    }

    public static class ht extends g {
        public ht() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    public static class hu extends g {
        public hu() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    public static class hv extends g {
        public hv() {
            super("menu:setfont", "", 129, false);
        }
    }

    public static class hw extends g {
        public hw() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class hx extends g {
        public hx() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class hy extends g {
        public hy() {
            super("menu:share:QZone", "", com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, false);
        }
    }

    public static class hz extends g {
        public hz() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class i extends g {
        public i() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class ia extends g {
        public ia() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    public static class ib extends g {
        public ib() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", 233, false);
        }
    }

    private static final class id extends g {
        id() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", 257, false);
        }
    }

    public static class j extends g {
        public j() {
            super("addCustomMenuItems", "addCustomMenuItems", 164, false);
        }
    }

    public static class k extends g {
        public k() {
            super("addDownloadTask", "add_download_task", 38, false);
        }
    }

    public static class l extends g {
        public l() {
            super("adDataReport", "ad_data_report", 221, false);
        }
    }

    public static class m extends g {
        public m() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    public static class n extends g {
        public n() {
            super("batchViewCard", "batchViewCard", 111, true);
        }
    }

    public static class o extends g {
        public o() {
            super("cancelDownloadTask", "cancel_download_task", 39, false);
        }
    }

    public static class p extends g {
        public p() {
            super("cancelAddEmoticon", "cancel_add_emoticon", 10, false);
        }
    }

    public static class q extends g {
        public q() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    public static class r extends g {
        public r() {
            super("checkJsApi", "checkJsApi", 84, false);
        }
    }

    public static class s extends g {
        public s() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    public static class t extends g {
        public t() {
            super("chooseIdCard", "chooseIdCard", 247, true);
        }
    }

    public static class u extends g {
        public u() {
            super(JsApiChooseImage.NAME, JsApiChooseImage.NAME, UpdateLogConst.ACTION_POP_INSTALL_DIALOG, true);
        }
    }

    public static class v extends g {
        public v() {
            super("chooseInvoice", "chooseInvoice", 202, true);
        }
    }

    private static final class w extends g {
        w() {
            super("chooseMedia", "chooseMedia", 254, true);
        }
    }

    public static class x extends g {
        public x() {
            super(JsApiChooseVideo.NAME, JsApiChooseVideo.NAME, 191, true);
        }
    }

    public static class y extends g {
        public y() {
            super("clearBounceBackground", "clearBounceBackground", 189, false);
        }
    }

    public static class z extends g {
        public z() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static g Is(String str) {
        if (lVV == null || lVV.size() <= 0) {
            Map hashMap = new HashMap(128);
            lVV = hashMap;
            hashMap.put("log", new cs());
            lVV.put("imagePreview", new ci());
            lVV.put("profile", new ek());
            lVV.put("shareWeibo", new hl());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.bk.NAME, new gu());
            lVV.put("adDataReport", new l());
            lVV.put("streamingVideoPlay", new gs());
            lVV.put("addContact", new i());
            lVV.put("sendAppMessage", new fb());
            lVV.put("scanQRCode", new ew());
            lVV.put("addEmoticon", new h());
            lVV.put("hasEmoticon", new cc());
            lVV.put("cancelAddEmoticon", new p());
            lVV.put("hideOptionMenu", new cg());
            lVV.put("showOptionMenu", new gc());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.y.NAME, new bj());
            lVV.put("closeWindow", new ac());
            lVV.put("getInstallState", new bg());
            lVV.put("setFontSizeCallback", new fi());
            lVV.put("jumpToInstallUrl", new ck());
            lVV.put("launchApp", new cq());
            lVV.put("getBrandWCPayRequest", new ay());
            lVV.put("editAddress", new aq());
            lVV.put("getHeadingAndPitch", new bd());
            lVV.put("sendEmail", new fe());
            lVV.put("addDownloadTask", new k());
            lVV.put("cancelDownloadTask", new o());
            lVV.put("pauseDownloadTask", new ef());
            lVV.put("resumeDownloadTask", new eu());
            lVV.put("queryDownloadTask", new el());
            lVV.put("installDownloadTask", new cj());
            lVV.put("getLatestAddress", new bm());
            lVV.put("openSpecificView", new dw());
            lVV.put("jumpWCMall", new cm());
            lVV.put("launch3rdApp", new cp());
            lVV.put("writeCommData", new hs());
            lVV.put("openUrlByExtBrowser", new dx());
            lVV.put("geoLocation", new aw());
            lVV.put("getBrandWCPayBindCardRequest", new ax());
            lVV.put("openProductView", new dt());
            lVV.put("openProductViewWithPid", new du());
            lVV.put("jumpToBizProfile", new cl());
            lVV.put("openTimelineCheckInList", new cw());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.aq.NAME, new cv());
            lVV.put("timelineCheckIn", new cu());
            lVV.put("getBrandWCPayCreateCreditCardRequest", new ec());
            lVV.put("chooseCard", new s());
            lVV.put("chooseInvoice", new v());
            lVV.put("sendServiceAppMessage", new ff());
            lVV.put("musicPlay", new ct());
            lVV.put("mmsf0001", new ba());
            lVV.put("connectToWiFi", new ag());
            lVV.put("getTransferMoneyRequest", new bx());
            lVV.put("openWCPaySpecificView", new dz());
            lVV.put("setCloseWindowConfirmDialogInfo", new fh());
            lVV.put("batchAddCard", new m());
            lVV.put("preVerifyJSAPI", new ej());
            lVV.put(JsApiStartRecordVoice.NAME, new gi());
            lVV.put(JsApiStopRecordVoice.NAME, new gp());
            lVV.put(JsApiStartPlayVoice.NAME, new eh());
            lVV.put(JsApiPausePlayVoice.NAME, new eg());
            lVV.put(JsApiStopPlayVoice.NAME, new gr());
            lVV.put("uploadVoice", new hb());
            lVV.put("downloadVoice", new ao());
            lVV.put(JsApiChooseImage.NAME, new u());
            lVV.put("uploadImage", new gy());
            lVV.put("downloadImage", new an());
            lVV.put("uploadMediaFile", new gz());
            lVV.put("hideMenuItems", new ce());
            lVV.put("showMenuItems", new ga());
            lVV.put("hideAllNonBaseMenuItem", new cd());
            lVV.put("showAllNonBaseMenuItem", new fx());
            lVV.put("checkJsApi", new r());
            lVV.put("translateVoice", new gv());
            lVV.put("shareQQ", new fu());
            lVV.put("shareWeiboApp", new fw());
            lVV.put("shareQZone", new fv());
            lVV.put("connectToFreeWifi", new af());
            lVV.put("getSendC2CMessageRequest", new bv());
            lVV.put("batchViewCard", new n());
            lVV.put("configWXDeviceWiFi", new ae());
            lVV.put("getCurrentSSID", new az());
            lVV.put("setPageOwner", new fo());
            lVV.put("getWechatVerifyTicket", new bz());
            lVV.put("openWXDeviceLib", new ed());
            lVV.put("startScanWXDevice", new gj());
            lVV.put("stopScanWXDevice", new gq());
            lVV.put("connectWXDevice", new ah());
            lVV.put("disconnectWXDevice", new am());
            lVV.put("getWXDeviceTicket", new cb());
            lVV.put("getWXDeviceInfos", new ca());
            lVV.put("sendDataToWXDevice", new fc());
            lVV.put("closeWXDeviceLib", new ad());
            lVV.put("setSendDataDirection", new fr());
            lVV.put("verifyWCPayPassword", new hc());
            lVV.put("getPaymentOrderRequest", new bl());
            lVV.put("openGameDetail", new dn());
            lVV.put("openGameCenter", new dm());
            lVV.put("setGameDebugConfig", new fk());
            lVV.put("startTempSession", new gl());
            lVV.put("getH5PrepayRequest", new be());
            lVV.put("getH5TransactionRequest", new bf());
            lVV.put("menu:share:timeline", new hz());
            lVV.put("menu:share:appmessage", new hw());
            lVV.put("menu:share:qq", new hx());
            lVV.put("menu:share:weiboApp", new ia());
            lVV.put("menu:setfont", new hv());
            lVV.put("menu:share:weibo", new ia());
            lVV.put("menu:share:QZone", new hy());
            lVV.put("getRecevieBizHongBaoRequest", new e());
            lVV.put("getSearchData", new bp());
            lVV.put("getTeachSearchData", new bw());
            lVV.put("getSearchAvatarList", new bo());
            lVV.put("getSearchSnsImageList", new bt());
            lVV.put("getSearchImageList", new bs());
            lVV.put("getSearchDisplayNameList", new bq());
            lVV.put("startSearchItemDetailPage", new gk());
            lVV.put("reportSearchStatistics", new es());
            lVV.put("reportSearchRealTimeStatistics", new er());
            lVV.put("searchDataHasResult", new ex());
            lVV.put("openEmotionPage", new av());
            lVV.put("getSearchSuggestionData", new bu());
            lVV.put("setSearchInputWord", new fq());
            lVV.put("setSnsObjectXmlDescList", new fs());
            lVV.put("clickSnsMusicPlayButton", new ab());
            lVV.put("openWeAppPage", new eb());
            lVV.put("reportWeAppSearchRealtime", new hm());
            lVV.put("jumpToWXWallet", new cn());
            lVV.put("scanCover", new f());
            lVV.put("reportActionInfo", new ep());
            lVV.put("openMyDeviceProfile", new dr());
            lVV.put("selectPedometerSource", new ey());
            lVV.put("nfcIsConnect", new dc());
            lVV.put("nfcConnect", new cz());
            lVV.put("nfcTransceive", new dd());
            lVV.put("nfcBatchTransceive", new cx());
            lVV.put("nfcGetId", new da());
            lVV.put("nfcGetInfo", new db());
            lVV.put("startMonitoringBeacons", new gg());
            lVV.put("stopMonitoringBeacons", new gn());
            lVV.put("nfcCheckState", new cy());
            lVV.put("videoProxyInit", new he());
            lVV.put("videoProxyStartPlay", new hh());
            lVV.put("videoProxyStopPlay", new hi());
            lVV.put("videoProxySetPlayerState", new hf());
            lVV.put("videoProxySetRemainTime", new hg());
            lVV.put("videoProxyPreload", new hk());
            lVV.put("getWebPayCheckoutCounterRequst", new cr());
            lVV.put("addCustomMenuItems", new j());
            lVV.put("operateGameCenterMsg", new ee());
            lVV.put("openEnterpriseChat", new dk());
            lVV.put("enterEnterpriseChat", new au());
            lVV.put("openEnterpriseContact", new dl());
            lVV.put("getEnterpriseChat", new bb());
            lVV.put("reportIDKey", new eq());
            lVV.put("quicklyAddBrandContact", new em());
            lVV.put("consumedShareCard", new ai());
            lVV.put("cache", new hd());
            lVV.put("publicCache", new hj());
            lVV.put("kvReport", new co());
            lVV.put("realtimeReport", new en());
            lVV.put("openUrlWithExtraWebview", new dy());
            lVV.put("setFreeWifiOwner", new fj());
            lVV.put("selectSingleContact", new ez());
            lVV.put("sendAppMessageToSpecifiedContact", new fa());
            lVV.put("setLocalData", new fl());
            lVV.put("getLocalData", new bh());
            lVV.put("clearLocalData", new z());
            lVV.put("showKeyboard", new fz());
            lVV.put("showSmileyPanel", new gd());
            lVV.put("disableBounceScroll", new ak());
            lVV.put("clearBounceBackground", new y());
            lVV.put("setNavigationBarButtons", new fm());
            lVV.put("enableFullScreen", new as());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.bn.NAME, new gb());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.ag.NAME, new cf());
            lVV.put("enablePullDownRefresh", new at());
            lVV.put("startPullDownRefresh", new gh());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.bq.NAME, new go());
            lVV.put("disablePullDownRefresh", new al());
            lVV.put("setPageTitle", new fp());
            lVV.put("setStatusBarStyle", new ft());
            lVV.put("deleteAccountSuccess", new aj());
            lVV.put(JsApiChooseVideo.NAME, new x());
            lVV.put("uploadVideo", new ha());
            lVV.put("openMapNavigateMenu", new dq());
            lVV.put("setNavigationBarColor", new fn());
            lVV.put("getWCPayRealnameVerify", new by());
            lVV.put("openDesignerEmojiView", new df());
            lVV.put("openDesignerProfile", new dh());
            lVV.put("openEmoticonTopicList", new dj());
            lVV.put("openDesignerEmojiViewLocal", new dg());
            lVV.put("openDesignerProfileLocal", new di());
            lVV.put("openEmotionDetailViewLocal", new d());
            lVV.put("openNewPage", new ds());
            lVV.put("getSearchEmotionData", new br());
            lVV.put("openEmotionUrl", new ar());
            lVV.put("WNNativeCallbackOnClick", new hq());
            lVV.put("WNNativeCallbackOnLongClick", new hr());
            lVV.put("WNNativeCallbackOnCaretChange", new hp());
            lVV.put("WNNativeCallbackInitData", new ho());
            lVV.put("WNNativeAsyncCallback", new hn());
            lVV.put("WNNativeCallbackOnBecomeEditing", new ht());
            lVV.put("WNNativeCallbackOnBecomeEdited", new hu());
            lVV.put("changePayActivityView", new q());
            lVV.put("selectWalletCurrency", new gt());
            lVV.put("scanLicence", new ev());
            lVV.put(JsApiOperateMusicPlayer.NAME, new b());
            lVV.put(JsApiGetMusicPlayerState.NAME, new a());
            lVV.put("clearWebviewCache", new aa());
            lVV.put("requireSoterBiometricAuthentication", new ge());
            lVV.put("getSupportSoter", new gf());
            lVV.put("unbindBankCard", new gw());
            lVV.put("setBounceBackground", new fg());
            lVV.put("sendEnterpriseChat", new fd());
            lVV.put("doExposePreparation", new ap());
            lVV.put("getMsgProofItems", new bi());
            lVV.put("openSecurityView", new dv());
            lVV.put("startVoipCall", new gm());
            lVV.put("getOpenDeviceId", new bk());
            lVV.put("getRouteUrl", new bn());
            lVV.put("idCardRealnameVerify", new ch());
            lVV.put("uploadIdCardSuccess", new ib());
            lVV.put(com.tencent.mm.plugin.appbrand.jsapi.b.c.NAME, new fy());
            lVV.put("openLuckyMoneyDetailView", new dp());
            lVV.put("resendRemittanceMsg", new et());
            lVV.put("getGameCommInfo", new bc());
            lVV.put("openGameRegion", new do());
            lVV.put("chooseIdCard", new t());
            lVV.put("getLocalImgData", new c());
            lVV.put("openWeApp", new ea());
            lVV.put("recordVideo", new eo());
            lVV.put("previewVideo", new ei());
            lVV.put("uploadEncryptMediaFile", new gx());
            lVV.put("chooseMedia", new w());
            lVV.put("openCustomWebview", new de());
            lVV.put("forceUpdateWxaAttr", new id());
        }
        return (g) lVV.get(str);
    }
}
