package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.plugin.emoji.d.j;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.z.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class b extends c<ar> {
    public b() {
        this.nhz = ar.class.getName().hashCode();
    }

    private static boolean a(ar arVar) {
        InputStream fileInputStream;
        Reader reader;
        Throwable th;
        Throwable e;
        int i;
        if (arVar instanceof ar) {
            String readLine;
            if (arVar.aYn.aYo == 33) {
                File file = new File(arVar.aYn.filePath);
                if (file.exists()) {
                    v.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(a.Er(), "temp");
                    File file3 = new File(file2, "emoji_template.zip");
                    file2.mkdirs();
                    e.p(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (be.dB(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        Reader inputStreamReader;
                        try {
                            String str;
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                            } catch (Throwable e2) {
                                reader = null;
                                inputStreamReader = null;
                                th = e2;
                                i = 1;
                                try {
                                    v.a("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.e(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.cGy >= i) {
                                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                    } else {
                                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                        a.l(file);
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    e2 = th2;
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    throw e2;
                                }
                            } catch (Throwable th3) {
                                e2 = th3;
                                reader = null;
                                inputStreamReader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e2;
                            }
                            try {
                                reader = new BufferedReader(inputStreamReader);
                                try {
                                    str = "";
                                    while (true) {
                                        readLine = reader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        str = str + readLine;
                                    }
                                    i = new JSONObject(str).getInt("version");
                                } catch (Throwable e22) {
                                    th = e22;
                                    i = 1;
                                    v.a("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.e(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.cGy >= i) {
                                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                        a.l(file);
                                    } else {
                                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                    }
                                    return false;
                                }
                            } catch (Throwable e222) {
                                reader = null;
                                th = e222;
                                i = 1;
                                v.a("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.e(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.cGy >= i) {
                                    v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                } else {
                                    v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                    a.l(file);
                                }
                                return false;
                            } catch (Throwable th4) {
                                e222 = th4;
                                reader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e222;
                            }
                            try {
                                v.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                            } catch (Exception e3) {
                                th = e3;
                                v.a("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.e(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.cGy >= i) {
                                    v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                    a.l(file);
                                } else {
                                    v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                }
                                return false;
                            }
                        } catch (Throwable e2222) {
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            th = e2222;
                            i = 1;
                            v.a("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            e.e(file2);
                            com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                            if (a.cGy >= i) {
                                v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                            } else {
                                v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                                a.l(file);
                            }
                            return false;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            throw e2222;
                        }
                    }
                    i = 1;
                    e.e(file2);
                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                    if (a.cGy >= i) {
                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                        a.l(file);
                    } else {
                        v.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.cGy), Integer.valueOf(i)});
                    }
                } else {
                    v.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (arVar.aYn.aYo == 37) {
                File file4;
                if (arVar.aYn.aYp == 1) {
                    if (!j.aff().a(arVar, j.a.EMOJI)) {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
                    } else if (j.a(arVar, j.a.EMOJI, j.fbj)) {
                        file4 = new File(new File(j.afg(), j.fbj), j.fbu);
                        if (file4.exists()) {
                            j.q(file4);
                        } else {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
                        }
                    } else {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
                    }
                } else if (arVar.aYn.aYp == 2) {
                    if (!j.aff().a(arVar, j.a.PANEL)) {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                    } else if (j.a(arVar, j.a.PANEL, j.fbk)) {
                        File file5 = new File(j.afg(), j.fbk);
                        readLine = com.tencent.mm.h.j.sU().getValue("EmotionPanelConfigName");
                        if (be.kS(readLine)) {
                            readLine = j.fbv;
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
                        } else {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", new Object[]{readLine});
                        }
                        file4 = new File(file5, readLine);
                        if (file4.exists()) {
                            j.r(file4);
                        } else {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
                        }
                    } else {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
                    }
                } else if (arVar.aYn.aYp == 3) {
                    if (!j.aff().a(arVar, j.a.SUGGEST)) {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (j.a(arVar, j.a.SUGGEST, j.fbl)) {
                        file4 = new File(new File(j.afg(), j.fbl), j.fbw);
                        if (file4.exists()) {
                            j.s(file4);
                        } else {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (arVar.aYn.aYp == 5) {
                    if (j.aff().a(arVar, j.a.EGG)) {
                        if (j.a(arVar, j.a.EGG, j.fbm)) {
                            file4 = new File(new File(j.afg(), j.fbm), j.fbx);
                            if (file4.exists()) {
                                j.t(file4);
                            } else {
                                v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (arVar.aYn.aYp == 4) {
                    j.aff();
                    v.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (j.b(arVar)) {
                        com.tencent.mm.bf.b.buL();
                        readLine = arVar.aYn.filePath;
                        com.tencent.mm.bf.b.buM();
                        com.tencent.mm.sdk.platformtools.j.dz(readLine, com.tencent.mm.bf.b.nmV);
                        com.tencent.mm.bf.b.buL().init();
                    }
                }
            }
        }
        return false;
    }
}
