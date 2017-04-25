package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class j extends a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    j() {
    }

    public final void a(final f fVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        final MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            v.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", new Object[]{fVar.dzg});
            fVar.y(i, c("fail", null));
            return;
        }
        a.a(fVar.dzg, new android.support.v4.app.a.a(this) {
            final /* synthetic */ j dFv;

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 48) {
                    if (iArr[0] == 0) {
                        this.dFv.a(fVar, jSONObject, i);
                    } else {
                        fVar.y(i, this.dFv.c("permission_denied", null));
                    }
                }
            }
        });
        MMActivity nt2 = d.nt(fVar.dzg);
        if (nt2 == null) {
            fVar.y(i, c("fail", null));
        } else {
            i2 = com.tencent.mm.pluginsdk.i.a.a(nt2, "android.permission.READ_CONTACTS", 48, "", "");
            if (i2 != 0) {
                a.mq(fVar.dzg);
            }
        }
        if (i2 == 0) {
            v.i("MicroMsg.JsApiChooseContact", "check permission");
            return;
        }
        nt.nDS = new MMActivity.a(this) {
            final /* synthetic */ j dFv;

            public final void a(int i, int i2, Intent intent) {
                if (100 != i) {
                    v.e("MicroMsg.JsApiChooseContact", "requestcode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    fVar.y(i, this.dFv.c("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    fVar.y(i, this.dFv.c("cancel", null));
                } else if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        v.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                        fVar.y(i, this.dFv.c("fail", null));
                    } else if (com.tencent.mm.pluginsdk.i.a.aP(nt, "android.permission.READ_CONTACTS")) {
                        try {
                            Object obj;
                            String str;
                            Map hashMap;
                            Cursor query = nt.getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    String string = query.getString(query.getColumnIndex("_id"));
                                    Cursor query2 = nt.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                    v.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", new Object[]{query});
                                    if (query2 == null) {
                                        fVar.y(i, this.dFv.c("fail", null));
                                        return;
                                    }
                                    if (query2.moveToFirst()) {
                                        obj = null;
                                        str = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex("display_name");
                                            String string2 = query2.getString(columnIndex);
                                            string = query2.getString(columnIndex2);
                                            v.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : " + string);
                                            if (string2 != null) {
                                                v.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (string2 == null) {
                                                    string2 = null;
                                                } else {
                                                    string2 = string2.replaceAll("\\D", "");
                                                    if (string2.startsWith("86")) {
                                                        string2 = string2.substring(2);
                                                    }
                                                }
                                                v.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                    string2 = str;
                                                }
                                                v.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : " + string2);
                                            } else {
                                                string2 = str;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            string2 = string;
                                        }
                                    } else {
                                        obj = null;
                                        str = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (be.kS(str)) {
                                        hashMap = new HashMap(1);
                                        hashMap.put("phoneNumber", str);
                                        str = "displayName";
                                        if (obj == null) {
                                            obj = "";
                                        }
                                        hashMap.put(str, obj);
                                        fVar.y(i, this.dFv.c("ok", hashMap));
                                    }
                                    fVar.y(i, this.dFv.c("fail", null));
                                    Toast.makeText(nt, 2131233801, 0).show();
                                    return;
                                }
                            }
                            obj = null;
                            str = null;
                            query.close();
                            if (be.kS(str)) {
                                fVar.y(i, this.dFv.c("fail", null));
                                Toast.makeText(nt, 2131233801, 0).show();
                                return;
                            }
                            hashMap = new HashMap(1);
                            hashMap.put("phoneNumber", str);
                            str = "displayName";
                            if (obj == null) {
                                obj = "";
                            }
                            hashMap.put(str, obj);
                            fVar.y(i, this.dFv.c("ok", hashMap));
                        } catch (SecurityException e) {
                            v.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", new Object[]{e.toString()});
                            g.A(nt, aa.getResources().getString(2131233803), "");
                            fVar.y(i, this.dFv.c("fail:system permission denied", null));
                        }
                    } else {
                        v.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                        fVar.y(i, this.dFv.c("fail:system permission denied", null));
                    }
                }
            }
        };
        nt.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 100);
    }
}
