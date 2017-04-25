package com.tencent.mm.bj;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class a {
    private static String cnh = "";
    public static int pkr = 1;

    private static String Eq() {
        if (be.kS(cnh)) {
            cnh = e.cnh.replace("/data/user/0", "/data/data");
        }
        return cnh;
    }

    public static String bLM() {
        File file;
        if (at.btU() > 1048576) {
            file = new File(Eq(), "wenote/res");
        } else {
            file = new File(e.cnj, "wenote/res");
        }
        return file.getAbsolutePath();
    }

    public static String bLN() {
        File file = new File(Eq(), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        file = new File(e.cnj, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String bLO() {
        File file = new File(Eq(), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String bLP() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(Eq(), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
    }

    public static String bLQ() {
        File file = new File(Eq(), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String bLR() {
        File file = new File(Eq(), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int Et() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(bLN(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        v.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                        com.tencent.mm.a.e.c(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(fileInputStream);
                    return 1;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.c(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.c(fileInputStream);
            throw e;
        }
    }

    public static int Eu() {
        Reader bufferedReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        InputStream open;
        Reader inputStreamReader;
        try {
            open = aa.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    reader = inputStreamReader;
                    inputStream = open;
                    try {
                        v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        return 1;
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        inputStreamReader = reader;
                        com.tencent.mm.a.e.c(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
                try {
                    String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            v.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                            com.tencent.mm.a.e.c(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = inputStreamReader;
                    inputStream = open;
                    v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                } catch (Throwable th3) {
                    e = th3;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStream = open;
                v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader);
                com.tencent.mm.a.e.a(bufferedReader);
                return 1;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                inputStreamReader = null;
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            inputStream = null;
            v.a("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(inputStream);
            com.tencent.mm.a.e.a(reader);
            com.tencent.mm.a.e.a(bufferedReader);
            return 1;
        } catch (Throwable th5) {
            e = th5;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
            com.tencent.mm.a.e.c(open);
            com.tencent.mm.a.e.a(inputStreamReader);
            com.tencent.mm.a.e.a(bufferedReader);
            throw e;
        }
    }
}
