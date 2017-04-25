package com.tencent.mm.z;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import org.json.JSONObject;

public final class a {
    public static int cGy = 1;
    private static String cnh = SQLiteDatabase.KeyEmpty;

    private static String Eq() {
        if (be.kS(cnh)) {
            cnh = e.cnh.replace("/data/user/0", "/data/data");
        }
        return cnh;
    }

    public static String Er() {
        File file = new File(Eq(), "emoji/res");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String Es() {
        return Eq() + "emoji/newemoji";
    }

    public static int Et() {
        InputStream fileInputStream;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(new File(Er(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = SQLiteDatabase.KeyEmpty;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        v.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        com.tencent.mm.a.e.c(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
            v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.c(fileInputStream);
            throw e;
        }
    }

    private static int Eu() {
        Reader inputStreamReader;
        Reader bufferedReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        InputStream open;
        try {
            open = aa.getContext().getAssets().open("emoji_config.conf");
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
                        v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
                    String str = SQLiteDatabase.KeyEmpty;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            v.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
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
                    v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
                v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
            v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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

    private static boolean ix(String str) {
        InputStream open;
        try {
            open = aa.getContext().getAssets().open("emoji_template.zip");
        } catch (Throwable e) {
            v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            open = null;
        }
        if (open == null) {
            v.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            v.a("MicroMsg.emoji.EmojiStoreExportLogic", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                v.a("MicroMsg.emoji.EmojiStoreExportLogic", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            } finally {
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(fileOutputStream);
            }
        } else {
            com.tencent.mm.a.e.c(open);
            return false;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void aZ(boolean z) {
        File file = new File(Er());
        v.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", file.getAbsoluteFile());
        if (d.lWk || d.lWl) {
            v.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            com.tencent.mm.a.e.e(file);
            k(file);
        } else {
            cGy = Et();
            if (z) {
                v.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(Eu()), Integer.valueOf(cGy));
                if (cGy < Eu()) {
                    com.tencent.mm.a.e.e(file);
                    k(file);
                }
            } else if (cGy == 1) {
                v.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(cGy));
                com.tencent.mm.a.e.e(file);
                k(file);
            }
        }
        com.tencent.mm.a.e.e(new File(e.cnj, "emoji"));
    }

    private static void k(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "emoji_template.zip");
        if (ix(file2.getAbsolutePath())) {
            int dB = be.dB(file2.getAbsolutePath(), file2.getParent());
            if (dB < 0) {
                v.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + dB + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            cGy = Et();
            v.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file2.getParent(), Integer.valueOf(cGy));
            return;
        }
        v.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", file2.getAbsolutePath());
    }

    public static void l(File file) {
        File file2 = new File(Er());
        com.tencent.mm.a.e.e(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                v.a("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(file2, "emoji_template.zip");
        com.tencent.mm.a.e.p(file.getAbsolutePath(), file3.getAbsolutePath());
        int dB = be.dB(file3.getAbsolutePath(), file3.getParent());
        if (dB < 0) {
            v.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + dB + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        cGy = Et();
        v.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file3.getParent(), Integer.valueOf(cGy));
    }
}
