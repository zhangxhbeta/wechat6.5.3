package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ay.c;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.el;
import com.tencent.mm.ui.chatting.em;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

@a(7)
public class UIEntryStub extends Activity {
    private int enr;
    private Intent ens;
    private String tX;

    static /* synthetic */ void a(UIEntryStub uIEntryStub, final Bundle bundle) {
        uIEntryStub.tX = bundle.getString("_mmessage_appPackage");
        uIEntryStub.enr = bundle.getInt("_mmessage_sdkVersion");
        String queryParameter = Uri.parse(bundle.getString("_mmessage_content")).getQueryParameter("appid");
        v.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = " + queryParameter);
        if (g.bp(queryParameter)) {
            r rVar = j.a.lxN;
            if (rVar != null) {
                rVar.m(uIEntryStub, queryParameter, uIEntryStub.tX);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        v.d("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.tX + ", sdkver=" + uIEntryStub.enr + ", cmd=" + i);
        switch (i) {
            case 1:
                Intent putExtras = new Intent().putExtras(bundle);
                putExtras.putExtra("mode", 1);
                putExtras.putExtra("forceHideShare", true);
                putExtras.putExtra("neverGetA8Key", true);
                putExtras.putExtra("geta8key_scene", 6);
                putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                if (ak.uz() && !ak.uG()) {
                    c.b((Context) uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                    break;
                } else {
                    v.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
            case 2:
                final com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a(bundle);
                if (aVar.nhM != null && aVar.nhM.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) aVar.nhM.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        v.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.a((Context) uIEntryStub, ReportUtil.a(uIEntryStub.getIntent().getExtras(), -5));
                        uIEntryStub.finish();
                        return;
                    }
                }
                if (aVar.scene == 1) {
                    v.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                    if (aVar.nhM.getType() == 8) {
                        v.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                        ReportUtil.a((Context) uIEntryStub, ReportUtil.a(uIEntryStub.getIntent().getExtras(), -5));
                    } else {
                        new d(uIEntryStub, queryParameter, aVar.bfm, new d.a(uIEntryStub) {
                            final /* synthetic */ UIEntryStub ent;

                            public final void bV(boolean z) {
                                boolean isFinishing = this.ent.isFinishing();
                                v.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                if (z && !isFinishing) {
                                    Intent intent = new Intent(this.ent, SendAppMessageWrapperUI.class);
                                    intent.putExtras(bundle);
                                    intent.putExtra("Select_Conv_User", "weixinfile");
                                    intent.putExtra("SendAppMessageWrapper_Scene", aVar.scene);
                                    this.ent.startActivity(intent);
                                }
                                this.ent.finish();
                            }
                        }).WK();
                        return;
                    }
                }
                Parcelable a = ReportUtil.a(bundle, -2);
                Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                intent.putExtra("Select_Report_Args", a);
                intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", aVar.scene).putExtra("animation_pop_in", true));
                intent.putExtra("Select_App_Id", queryParameter);
                intent.putExtra("Select_Open_Id", aVar.bfm);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                if (!ak.uz() || ak.uG()) {
                    v.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                } else {
                    uIEntryStub.startActivity(intent);
                }
                uIEntryStub.finish();
                return;
            case 3:
                if (ak.uz() && !ak.uG()) {
                    el.V(bundle);
                    break;
                } else {
                    v.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 4:
                if (ak.uz() && !ak.uG()) {
                    em.V(bundle);
                    break;
                } else {
                    v.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
        }
        uIEntryStub.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotifyReceiver.pZ();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.ens = intent;
    }

    public void onResume() {
        super.onResume();
        if (this.ens == null) {
            this.ens = getIntent();
        }
        ak.vy().a(new ay(new ay.a(this) {
            final /* synthetic */ UIEntryStub ent;

            {
                this.ent = r1;
            }

            public final void a(e eVar) {
                if (eVar == null) {
                    this.ent.finish();
                } else {
                    UIEntryStub.a(this.ent, this.ent.ens.getExtras());
                }
            }
        }), 0);
    }
}
