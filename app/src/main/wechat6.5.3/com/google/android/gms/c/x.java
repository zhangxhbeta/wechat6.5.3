package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x {
    private static final Pattern ayA = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    private static final Pattern ayz = Pattern.compile("\\\\.");

    public static String ag(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = ayA.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case '\b':
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case '\t':
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case '\n':
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case '\f':
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case as.CTRL_INDEX /*13*/:
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case r.CTRL_INDEX /*92*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
