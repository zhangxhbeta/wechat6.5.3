package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.mm.a.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class g implements d {
    private MMWebView jyU;
    private d loV;
    private int loW;
    private f loX;

    public g(MMWebView mMWebView, d dVar, int i, f fVar) {
        this.jyU = mMWebView;
        this.loV = dVar;
        this.loW = i;
        this.loX = fVar;
    }

    public final boolean Fs(String str) {
        if (be.kS(str)) {
            return false;
        }
        return s.ds(str, "weixin://private/setresult/");
    }

    public final boolean Fj(String str) {
        String str2 = null;
        if (this.jyU != null) {
            this.jyU.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (be.kS(substring)) {
            v.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            v.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[]{Integer.valueOf(indexOf)});
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            v.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        substring = decode == null ? null : new String(decode);
        v.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[]{substring2, substring});
        if ("SCENE_HANDLEMSGFROMWX".equals(substring2) && substring != null) {
            String substring3;
            if (substring.startsWith("wxGetAllHosts:")) {
                substring3 = substring.substring(14);
            } else if (substring.startsWith("\"wxGetAllHosts:")) {
                substring3 = substring.substring(15, substring.length() - 1);
            } else {
                substring3 = null;
            }
            if (substring3 != null) {
                Map z = z(substring3.split("\\,"));
                String Fz = Fz("hosts");
                if (!i(Fz, z)) {
                    v.e("MicroMsg.JsApiResultHandler", "failed to write Hosts file");
                } else if (!(this.loV == null || this.jyU == null)) {
                    try {
                        this.loV.w(0, this.jyU.getUrl(), Fz);
                    } catch (RemoteException e2) {
                        v.e("MicroMsg.JsApiResultHandler", "uploadFileToCDN error ", new Object[]{e2.getMessage()});
                    }
                }
            }
            if (substring.startsWith("wxGetHtmlContent:")) {
                str2 = substring.substring(17);
            } else if (substring.startsWith("\"wxGetHtmlContent:")) {
                str2 = substring.substring(18, substring.length() - 1);
            }
            if (str2 != null) {
                substring3 = Fz("html");
                if (!de(substring3, str2)) {
                    v.e("MicroMsg.JsApiResultHandler", "failed to write Html file");
                } else if (!(this.loV == null || this.jyU == null)) {
                    try {
                        this.loV.w(1, this.jyU.getUrl(), substring3);
                    } catch (RemoteException e3) {
                        v.e("MicroMsg.JsApiResultHandler", "uploadFileToCDN error ", new Object[]{e3.getMessage()});
                    }
                }
            }
            if (!(this.loV == null || this.jyU == null || this.jyU.pdG || com.tencent.mm.compatible.util.d.dW(19) || !substring.contains("isWNNoteValueResult"))) {
                v.i("MicroMsg.JsApiResultHandler", "WNNoteValueResult dispos, value = %s", new Object[]{substring});
                Bundle bundle = new Bundle();
                bundle.putString("ExportData", substring);
                try {
                    this.loV.i(52, bundle);
                } catch (Exception e4) {
                    v.w("MicroMsg.JsApiResultHandler", "WNNoteValueResult dispos error ", new Object[]{e4.getMessage()});
                }
            }
        }
        this.loX.keep_setReturnValue(substring2, substring);
        return true;
    }

    private static Map<String, Integer> z(String[] strArr) {
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            return null;
        }
        Map<String, Integer> hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        return hashMap;
    }

    private String Fz(String str) {
        if (this.jyU == null) {
            return null;
        }
        String url = this.jyU.getUrl();
        try {
            v.i("MicroMsg.JsApiResultHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[]{url, str, e.cgk + m.aZ(url + str)});
            return e.cgk + m.aZ(url + str);
        } catch (Throwable e) {
            v.e("MicroMsg.JsApiResultHandler", "generating temp file name failed, url is " + url);
            v.a("MicroMsg.JsApiResultHandler", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean i(String str, Map<String, Integer> map) {
        Throwable e;
        if (be.kS(str) || map == null) {
            v.w("MicroMsg.JsApiResultHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                v.e("MicroMsg.JsApiResultHandler", "creating file failed, filePath is " + str);
                v.a("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e22) {
                    v.a("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                }
                v.d("MicroMsg.JsApiResultHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e3) {
                e22 = e3;
                outputStream = bufferedOutputStream;
                try {
                    v.a("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                    v.w("MicroMsg.JsApiResultHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e222) {
                            v.a("MicroMsg.JsApiResultHandler", e222, "", new Object[0]);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e222 = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.JsApiResultHandler", e4, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            v.a("MicroMsg.JsApiResultHandler", e222, "", new Object[0]);
            v.w("MicroMsg.JsApiResultHandler", "write to file error");
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e222 = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e222;
        }
    }

    private static boolean de(String str, String str2) {
        Throwable e;
        if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.JsApiResultHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                v.e("MicroMsg.JsApiResultHandler", "creating file failed, filePath is " + str);
                v.a("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.JsApiResultHandler", e3, "", new Object[0]);
                }
                v.d("MicroMsg.JsApiResultHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e4) {
                e2 = e4;
                outputStream = bufferedOutputStream;
                try {
                    v.a("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                    v.w("MicroMsg.JsApiResultHandler", "write to file error");
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e32) {
                            v.a("MicroMsg.JsApiResultHandler", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            v.a("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
            v.w("MicroMsg.JsApiResultHandler", "write to file error");
            if (outputStream != null) {
                return false;
            }
            outputStream.close();
            return false;
        }
    }
}
