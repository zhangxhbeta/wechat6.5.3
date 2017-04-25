package com.tencent.mm.plugin.game.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    public static LinkedList<f> arg() {
        v.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList<f> linkedList = new LinkedList();
        linkedList.addAll(au.asi().ghl);
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            f fVar = (f) it.next();
            if (fVar != null) {
                v.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i == 0) {
                        v.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                        linkedList2.add(fVar);
                    }
                }
            }
            i = 0;
            if (i == 0) {
                v.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                linkedList2.add(fVar);
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        return linkedList;
    }

    public static LinkedList<String> arh() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(au.asi().ghk);
        return linkedList;
    }

    public static void R(Context context, String str) {
        if (d(context, str, null, "WX_GameCenter")) {
            au.asf();
            t.a(str, 0, 0, null, null);
        }
    }

    public static boolean d(Context context, String str, String str2, String str3) {
        if (be.kS(str)) {
            v.e("MicroMsg.GameCenterLogic", "null or nil appid");
            return false;
        }
        f aC = g.aC(str, true);
        if (aC == null || be.kS(aC.field_appId)) {
            v.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            return false;
        } else if (p.b(context, aC)) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = 587333634;
            wXMediaMessage.messageAction = str2;
            wXMediaMessage.messageExt = str3;
            a aVar = new a();
            aVar.lBj = com.tencent.mm.a.g.m((be.Ni()).getBytes());
            aVar.bfm = aC.field_openId;
            aVar.nhM = wXMediaMessage;
            aVar.cUi = u.d(context.getSharedPreferences(aa.bti(), 0));
            ak.yW();
            aVar.cJg = (String) c.vf().get(274436, null);
            v.d("MicroMsg.GameCenterLogic", "lauch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[]{aC.field_appId, aC.field_appName, aC.field_openId});
            if (be.kS(aC.field_openId)) {
                v.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[]{aC.field_appName});
                am.bnF().Ez(aC.field_appId);
            }
            Bundle bundle = new Bundle();
            aVar.t(bundle);
            p.R(bundle);
            p.S(bundle);
            com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
            aVar2.nhj = aC.field_packageName;
            aVar2.nhl = bundle;
            return com.tencent.mm.sdk.a.a.a(context, aVar2);
        } else {
            v.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[]{aC.field_appName});
            Toast.makeText(context, context.getString(2131233088, new Object[]{g.a(context, aC, null)}), 1).show();
            return false;
        }
    }

    public static String ari() {
        String buo = be.buo();
        if (be.kS(buo)) {
            buo = "CN";
        }
        return buo.toUpperCase();
    }

    public static GameRegionPreference.a bS(Context context) {
        Object bV = bV(context);
        if (be.kS(bV)) {
            bV = ari();
        }
        return (GameRegionPreference.a) a.gzB.asH().get(bV);
    }

    public static String a(GameRegionPreference.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String ma = be.ma(u.bsY());
            if ("zh_CN".equalsIgnoreCase(ma)) {
                stringBuffer.append(aVar.gwX);
            } else if ("zh_TW".equalsIgnoreCase(ma) || "zh_HK".equalsIgnoreCase(ma)) {
                stringBuffer.append(aVar.gwY);
            } else {
                stringBuffer.append(aVar.gwZ);
            }
        }
        return stringBuffer.toString();
    }

    public static String ud(String str) {
        String str2;
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = aa.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    v.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{be.e(e)});
                }
            }
        } catch (Throwable e2) {
            v.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{be.e(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (Throwable e22) {
                    v.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{be.e(e22)});
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    v.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{be.e(e3)});
                }
            }
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            v.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[]{str2});
            return "";
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            return split[0];
        } else {
            if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
                return split[1];
            }
            return split[2];
        }
    }

    public static boolean a(f fVar) {
        if (fVar == null || fVar.bxx != 3) {
            return false;
        }
        at.arX();
        v.i("MicroMsg.GameCenterLogic", "appdownload flag is download by yyb, get download status = [%d]", new Object[]{Integer.valueOf(at.uj(fVar.bxz))});
        if (at.uj(fVar.bxz) == 4) {
            return true;
        }
        return false;
    }

    public static void S(Context context, String str) {
        int i = 0;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (be.kS(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
        }
    }

    public static Set<String> bT(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    }

    public static ShapeDrawable bs(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static int bU(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getInt("game_detail_jump_type", 0);
    }

    public static String bV(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    }

    public static void T(Context context, String str) {
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
    }
}
