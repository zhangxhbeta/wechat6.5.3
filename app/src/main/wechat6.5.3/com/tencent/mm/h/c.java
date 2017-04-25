package com.tencent.mm.h;

import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static final String cgM = (t.cng + "configlist/");
    public SparseArray<d> cgL = new SparseArray();

    public static String dZ(int i) {
        return cgM + "config_" + i + ".xml";
    }

    final boolean renameTo(File file, File file2) {
        Throwable e;
        InputStream inputStream = null;
        int i = 0;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            boolean z = false;
            while (i < listFiles.length) {
                File file3 = listFiles[i];
                z = renameTo(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
            return z;
        }
        OutputStream fileOutputStream;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    file.delete();
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e2));
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e22));
                    }
                    return true;
                } catch (Exception e3) {
                    e22 = e3;
                    inputStream = fileInputStream;
                    try {
                        v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e22));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e222));
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e2222));
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e4));
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e5));
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                inputStream = fileInputStream;
                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e2222));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e2222));
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    public final void init() {
        for (int load : d.cgN) {
            load(load);
        }
    }

    public final void m(int i, String str) {
        d dVar = new d(i);
        dVar.cgP = bf.q(str, "ConfigList");
        if (dVar.cgP.containsKey(".ConfigList.$version")) {
            dVar.version = Integer.valueOf((String) dVar.cgP.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i2));
            if (dVar.cgP.get(str2 + ".$name") != null) {
                String str3 = (String) dVar.cgP.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i3)) + ".$lang";
                        if (!dVar.cgP.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) dVar.cgP.get(str5);
                        str4 = (String) dVar.cgP.get(str4);
                        str5 = (String) dVar.cgP.get(str6);
                        v.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || d.dx(str5)) {
                            if (!dVar.cgO.containsKey(str3)) {
                                dVar.cgO.put(str3, new HashMap());
                            }
                            ((HashMap) dVar.cgO.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.cgL.put(Integer.valueOf(i).intValue(), dVar);
                return;
            }
        }
    }

    public final String z(String str, String str2) {
        d ea = ea(1);
        if (ea != null && ea.cgO.containsKey(str)) {
            return (String) ((HashMap) ea.cgO.get(str)).get(str2);
        }
        return null;
    }

    private d ea(int i) {
        if (this.cgL.get(1) == null) {
            load(1);
        }
        return (d) this.cgL.get(1);
    }

    private void load(int i) {
        InputStream fileInputStream;
        Throwable e;
        try {
            File file = new File(dZ(i));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    m(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e3) {
                                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e3));
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e4));
                            }
                        }
                        throw e3;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e32) {
                    v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e32));
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileInputStream = null;
            v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e32));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            e32 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e32;
        }
    }

    public final int sM() {
        int i = -1;
        String bun = be.bun();
        if (!be.kS(bun)) {
            bun = z("VoipInviteTimeLimit", bun);
            if (!be.kS(bun)) {
                try {
                    i = be.getInt(bun, -1);
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    public static int sN() {
        int i;
        String value = ((h) g.f(h.class)).sU().getValue("VoiceVOIPSwitch");
        v.d("MicroMsg.ConfigListDecoder", "voip is " + value);
        try {
            i = be.getInt(value, 0);
        } catch (Throwable e) {
            v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e));
            i = 0;
        }
        v.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is " + i);
        return i;
    }

    public final String[] sO() {
        String z = z("WebViewConfig", "removeJavascriptInterface");
        if (be.kS(z)) {
            return null;
        }
        return z.split(";");
    }

    public final String sP() {
        v.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", z("FreeWiFiConfig", "CheckURL"));
        return z("FreeWiFiConfig", "CheckURL");
    }

    public final boolean sQ() {
        boolean z = true;
        if (be.getInt(z("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        v.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : " + z);
        return z;
    }

    public final List<String> sR() {
        List<String> list = null;
        String z = z("IBeacon", "Content");
        if (!be.kS(z)) {
            list = new ArrayList();
            try {
                Iterator keys = new JSONObject(z.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null) {
                        list.add(next.toString());
                    }
                }
            } catch (JSONException e) {
                v.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        return list;
    }

    public final String sS() {
        return z("MailApp", "MailAppRedirectUrAndroid");
    }

    public final String getMailAppEnterUlAndroid() {
        return z("MailApp", "MailAppEnterMailAppUrlAndroid");
    }

    public final Map<String, String> sT() {
        d ea = ea(1);
        if (ea == null) {
            return null;
        }
        return ea.cgP;
    }
}
