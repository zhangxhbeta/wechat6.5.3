package com.tencent.mm.plugin.webview.d;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;

public final class ah {
    public static String DX(String str) {
        File file = new File(e.cgg);
        if (!file.mkdirs()) {
            v.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            v.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[]{e.cgg});
        }
        v.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[]{str, file.getAbsolutePath() + File.separator + str + ".jpg"});
        return file.getAbsolutePath() + File.separator + str + ".jpg";
    }

    public static Intent DY(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(DX(str))));
        return intent;
    }

    public static Intent bin() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public static Intent bio() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public static String DZ(String str) {
        v.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[]{str});
        if (be.kS(str)) {
            return null;
        }
        v.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[]{str, "weixin://resourceid/" + z.Kg(str)});
        return "weixin://resourceid/" + z.Kg(str);
    }

    public static String T(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            v.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put((String) arrayList.get(i));
        }
        return jSONArray.toString();
    }

    static InputStream Ea(String str) {
        v.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[]{str});
        if (be.kS(str) || be.kS(str) || !com.tencent.mm.a.e.aR(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            v.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String Eb(String str) {
        return "_USER_FOR_WEBVIEW_JSAPI" + j.f(str, be.Ni());
    }
}
