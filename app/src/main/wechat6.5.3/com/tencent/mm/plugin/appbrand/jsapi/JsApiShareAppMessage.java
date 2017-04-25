package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class JsApiShareAppMessage extends a {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";
    private static volatile boolean dIl = false;
    private Bitmap mBitmap;

    private static class SendAppMessageTask extends MainProcessTask {
        public static final Creator<SendAppMessageTask> CREATOR = new Creator<SendAppMessageTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendAppMessageTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendAppMessageTask[i];
            }
        };
        String appId;
        String cID;
        int cUv;
        String dIt;
        String dIu;
        String dIv;
        String description;
        String iconUrl;
        String lqb;
        String path;
        String title;
        String toUser;
        int type;
        String url;
        String userName;
        int version;

        public final void OL() {
            Bitmap bitmap;
            v.i("MicroMsg.JsApiShareAppMessage", "username = %s, thumbIconUrl = %s", new Object[]{this.userName, this.dIu});
            byte[] bArr = new byte[0];
            if (be.kS(this.lqb)) {
                bitmap = null;
            } else {
                bitmap = d.JV(this.lqb);
                boolean deleteFile = b.deleteFile(this.lqb);
                v.v("MicroMsg.JsApiShareAppMessage", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{this.lqb, Boolean.valueOf(deleteFile)});
            }
            if (bitmap == null || bitmap.isRecycled()) {
                v.e("MicroMsg.JsApiShareAppMessage", "thumb image is null");
            } else {
                v.i("MicroMsg.JsApiShareAppMessage", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            v.i("MicroMsg.JsApiShareAppMessage", "doSendMessage, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[]{this.title, this.description, this.userName, this.path, this.dIu});
            v.d("MicroMsg.JsApiShareAppMessage", "report, appId : %s, path: %s", new Object[]{this.appId, this.path});
            o.yx().n(o.fz("wxapp_" + this.appId + this.path), true).l("prePublishId", "wxapp_" + this.appId + this.path);
            a aVar = new a();
            aVar.title = this.title;
            aVar.description = this.description;
            aVar.type = 33;
            aVar.cqp = this.userName;
            aVar.cqo = this.path;
            aVar.cqq = this.appId;
            aVar.cqt = this.cUv;
            aVar.cqu = this.version;
            aVar.cqs = this.dIv;
            aVar.cqr = this.type;
            aVar.url = this.url;
            aVar.bnX = "wxapp_" + this.appId + this.path;
            aVar.bnR = this.userName;
            aVar.bnS = this.cID;
            l.a(aVar, this.appId, this.title, this.toUser, null, bArr);
            if (!be.kS(this.dIt)) {
                mr mrVar = new mr();
                mrVar.boa.bob = this.toUser;
                mrVar.boa.content = this.dIt;
                mrVar.boa.type = m.fp(this.toUser);
                mrVar.boa.flags = 0;
                com.tencent.mm.sdk.c.a.nhr.z(mrVar);
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.userName = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.dIt = parcel.readString();
            this.toUser = parcel.readString();
            this.url = parcel.readString();
            this.path = parcel.readString();
            this.type = parcel.readInt();
            this.dIu = parcel.readString();
            this.iconUrl = parcel.readString();
            this.lqb = parcel.readString();
            this.cUv = parcel.readInt();
            this.dIv = parcel.readString();
            this.version = parcel.readInt();
            this.cID = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.appId);
            parcel.writeString(this.userName);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.dIt);
            parcel.writeString(this.toUser);
            parcel.writeString(this.url);
            parcel.writeString(this.path);
            parcel.writeInt(this.type);
            parcel.writeString(this.dIu);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.lqb);
            parcel.writeInt(this.cUv);
            parcel.writeString(this.dIv);
            parcel.writeInt(this.version);
            parcel.writeString(this.cID);
        }

        protected SendAppMessageTask(Parcel parcel) {
            f(parcel);
        }
    }

    static /* synthetic */ Bitmap o(h hVar) {
        View view = hVar.dNn.getView();
        int width = view.getWidth();
        int height = view.getHeight();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        view.scrollTo(0, 0);
        Bitmap cv = d.cv(view);
        Bitmap createBitmap = Bitmap.createBitmap(cv, 0, 0, width, height);
        cv.recycle();
        view.scrollTo(scrollX, scrollY);
        v.v("MicroMsg.JsApiShareAppMessage", "crop cover(w : %s, h : %s, x : %s, y : %s)", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(scrollX), Integer.valueOf(scrollY)});
        return createBitmap;
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        v.i("MicroMsg.JsApiShareAppMessage", "invoke share app message(%s)", new Object[]{Boolean.valueOf(dIl)});
        if (dIl) {
            dIl = false;
            if (jSONObject != null) {
                final AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
                final MMActivity nt = d.nt(fVar.dzg);
                if (nt == null) {
                    v.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                    fVar.y(i, c("fail: page context is null", null));
                    return;
                }
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        v.i("MicroMsg.JsApiShareAppMessage", "%s, %s", new Object[]{str, jSONObject.get(str)});
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.JsApiShareAppMessage", e, "", new Object[0]);
                }
                final h a = d.a(fVar);
                final f fVar2 = fVar;
                c.a(fVar.dzg, new c.a(this) {
                    final /* synthetic */ JsApiShareAppMessage dIs;

                    public final void gW(int i) {
                        c.b(fVar2.dzg, this);
                        this.dIs.mBitmap = JsApiShareAppMessage.o(a);
                    }
                });
                final int optInt = jSONObject.optInt(Columns.TYPE, 2);
                final String optString = jSONObject.optString("title");
                final String optString2 = jSONObject.optString("desc", "");
                final String optString3 = jSONObject.optString("path");
                jSONObject.optString("dataUrl");
                final String optString4 = jSONObject.optString("imgUrl");
                final String str2 = fVar.dzg;
                final String str3 = mr.aWH;
                if (2 != optInt) {
                    v.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not support share type(%s)", new Object[]{Integer.valueOf(optInt)});
                    fVar.y(i, c("fail:not support share type", null));
                    return;
                }
                final String mI = g.mI(fVar.dzg);
                Serializable hashMap = new HashMap();
                hashMap.put("desc", optString2);
                hashMap.put("title", optString);
                hashMap.put("img_url", optString4);
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("scene_from", 3);
                intent.putExtra("appbrand_params", hashMap);
                intent.putExtra("Retr_Msg_Type", 2);
                final f fVar3 = fVar;
                final int i2 = i;
                com.tencent.mm.ay.c.a(nt, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a(this) {
                    final /* synthetic */ JsApiShareAppMessage dIs;

                    public final void a(int i, int i2, Intent intent) {
                        int i3 = 2;
                        if (i != 1) {
                            return;
                        }
                        if (i2 == -1) {
                            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                            if (stringExtra == null || stringExtra.length() == 0) {
                                v.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                                v.i("MicroMsg.JsApiShareAppMessage", "result is fail");
                                fVar3.y(i2, this.dIs.c("fail", null));
                                com.tencent.mm.plugin.appbrand.report.a.a(str2, optString3, 2, "", be.Nh(), 2, i2);
                                return;
                            }
                            String str;
                            v.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", new Object[]{stringExtra});
                            if (intent == null) {
                                str = null;
                            } else {
                                str = intent.getStringExtra("custom_send_text");
                            }
                            MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                            sendAppMessageTask.dIt = str;
                            sendAppMessageTask.toUser = stringExtra;
                            sendAppMessageTask.appId = str2;
                            sendAppMessageTask.userName = str3;
                            sendAppMessageTask.title = optString;
                            sendAppMessageTask.description = optString2;
                            sendAppMessageTask.url = mI;
                            sendAppMessageTask.path = optString3;
                            sendAppMessageTask.type = optInt;
                            sendAppMessageTask.dIu = optString4;
                            sendAppMessageTask.iconUrl = mr.dDo;
                            sendAppMessageTask.cUv = mr.dDB.dBr;
                            sendAppMessageTask.dIv = mr.dDB.dBv;
                            sendAppMessageTask.version = mr.dDB.dBs;
                            sendAppMessageTask.cID = mr.aZU;
                            String av = com.tencent.mm.plugin.appbrand.appstorage.c.av(str2, "share_" + System.currentTimeMillis());
                            try {
                                d.a(this.dIs.mBitmap, 100, CompressFormat.PNG, av, true);
                                sendAppMessageTask.lqb = av;
                            } catch (IOException e) {
                                v.w("MicroMsg.JsApiShareAppMessage", "save temp bitmap to file failed, . exception : %s", new Object[]{e});
                            } catch (Exception e2) {
                                v.w("MicroMsg.JsApiShareAppMessage", "save temp bitmap to file failed, . exception : %s", new Object[]{e2});
                            } finally {
                                if (!(this.dIs.mBitmap == null || this.dIs.mBitmap.isRecycled())) {
                                    this.dIs.mBitmap.recycle();
                                }
                                av = this.dIs;
                                av.mBitmap = null;
                            }
                            AppBrandMainProcessService.a(sendAppMessageTask);
                            if (nt != null) {
                                com.tencent.mm.ui.base.g.bf(nt, nt.getResources().getString(2131231155));
                            }
                            fVar3.y(i2, this.dIs.c("success", null));
                            if (stringExtra.endsWith("@chatroom")) {
                                i3 = 9;
                            }
                            com.tencent.mm.plugin.appbrand.report.a.a(str2, av, i3, "", be.Nh(), 1, i2);
                            return;
                        }
                        fVar3.y(i2, this.dIs.c("fail", null));
                        com.tencent.mm.plugin.appbrand.report.a.a(str2, optString3, 2, "", be.Nh(), 3, i2);
                    }
                });
                return;
            }
            v.i("MicroMsg.JsApiShareAppMessage", "data is null");
            fVar.y(i, c("fail", null));
            return;
        }
        v.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        fVar.y(i, c("fail:not allow to share", null));
    }

    public static void Ql() {
        v.i("MicroMsg.JsApiShareAppMessage", "set can share true.");
        dIl = true;
    }
}
