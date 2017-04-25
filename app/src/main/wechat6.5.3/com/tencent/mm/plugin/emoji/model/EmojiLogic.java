package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.emoji.d.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static final String fcI = File.separator;

    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int ae(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return c.nwI;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return c.nwS;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return c.nwT;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return c.nwU;
        }
        return c.nwI;
    }

    public static String rh(String str) {
        String str2 = null;
        if (!be.kS(str)) {
            int aQ = e.aQ(str);
            if (aQ > 0) {
                byte[] c = e.c(str, 0, aQ);
                str2 = g.m(c);
                if (!(str2 == null && c == null)) {
                    ak.yW();
                    e.b(com.tencent.mm.model.c.wY() + str2, c, c.length);
                    if (o.be(c)) {
                        g.afx().fch.a(str2, "", c.nwM, c.nwT, c.length, "", "");
                    } else {
                        g.afx().fch.a(str2, "", c.nwM, c.nwS, c.length, "", "");
                    }
                }
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        if (wXMediaMessage.getType() != 8) {
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!be.bl(wXEmojiObject.emojiData)) {
            v.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String m = g.m(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, m, wXEmojiObject.emojiData, str);
            return m;
        } else if (be.kS(wXEmojiObject.emojiPath)) {
            return null;
        } else {
            int aQ = e.aQ(wXEmojiObject.emojiPath);
            if (aQ <= 0) {
                return null;
            }
            byte[] c = e.c(wXEmojiObject.emojiPath, 0, aQ);
            String m2 = g.m(c);
            a(context, wXMediaMessage.thumbData, m2, c, str);
            return m2;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        if (str != null || bArr2 != null) {
            c a;
            ak.yW();
            String wY = com.tencent.mm.model.c.wY();
            e.b(wY + str, bArr2, bArr2.length);
            if (o.be(bArr2)) {
                a = g.afx().fch.a(str, "", c.nwM, c.nwW, bArr2.length, str2, "");
            } else {
                a = g.afx().fch.a(str, "", c.nwM, c.nwX, bArr2.length, str2, "");
            }
            a(context, bArr, str, wY, a);
        }
    }

    public static void a(Context context, byte[] bArr, String str, String str2, c cVar) {
        Bitmap bitmap;
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cVar == null);
            v.d(str3, str4, objArr);
            if (cVar != null) {
                Bitmap eg = cVar.eg(context);
            } else {
                return;
            }
        }
        eg = d.bc(bArr);
        if (eg == null || (eg.getWidth() <= 300 && eg.getHeight() <= 300)) {
            bitmap = eg;
        } else {
            int width = eg.getWidth();
            int height = eg.getHeight();
            v.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", new Object[]{Integer.valueOf(width), Integer.valueOf(height)});
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            v.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", new Object[]{Integer.valueOf(height), Integer.valueOf(width)});
            bitmap = d.a(eg, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > 32768) {
                    d.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    v.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
                    return;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                v.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
            } catch (Throwable e) {
                v.a("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
            }
        }
    }

    public static c a(String str, String str2, i iVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            c a = a(str, 4, str2, true);
            if (a == null) {
                n.GL().a(str2, null, com.tencent.mm.plugin.emoji.d.g.a(str, str2, new Object[0]), iVar);
                v.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", new Object[]{str2});
            }
            return a;
        } else if (aa.getContext() == null || aa.getContext().getResources() == null) {
            return null;
        } else {
            new c().field_type = c.nwS;
            return null;
        }
    }

    public static c a(String str, int i, String str2, boolean z) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            v.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            return null;
        }
        int i3;
        c cVar = new c();
        if (z) {
            ak.yW();
            String z2 = z(com.tencent.mm.model.c.wY(), str, str2);
            if (e.aR(z2)) {
                File file = new File(z2);
                if (file.exists()) {
                    if (file.length() < 1) {
                        file.delete();
                    } else {
                        cVar.field_type = ae(e.c(z2, 0, 10));
                        i2 = 1;
                    }
                }
            }
            if (i2 == 0) {
                v.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + z2 + "...., icon type:" + i);
                return null;
            }
        }
        ak.yW();
        if (!e.aR(z(com.tencent.mm.model.c.wY(), str, str2))) {
            v.d("MicroMsg.emoji.EmojiLogic", "icon file no exist. path:%s type:%d, url:%s", new Object[]{z(com.tencent.mm.model.c.wY(), str, str2), Integer.valueOf(i), str2});
            return null;
        }
        cVar.field_md5 = bp(str, str2);
        switch (i) {
            case 2:
                i3 = 82;
                break;
            case 4:
                i3 = 83;
                break;
            case 8:
                i3 = 84;
                break;
            default:
                i3 = c.nwN;
                break;
        }
        cVar.field_catalog = i3;
        cVar.field_groupId = str;
        cVar.field_temp = 1;
        return cVar;
    }

    public static boolean a(String str, String str2, a aVar) {
        ZipFile zipFile;
        InputStream inputStream;
        OutputStream outputStream;
        Exception e;
        OutputStream outputStream2;
        Throwable th;
        OutputStream outputStream3;
        String str3 = com.tencent.mm.compatible.util.e.cge + str;
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wY()).append(str).toString();
        InputStream inputStream2 = null;
        ZipFile zipFile2 = null;
        HashMap hashMap = new HashMap();
        Object arrayList = new ArrayList();
        OutputStream outputStream4;
        try {
            zipFile = new ZipFile(str3);
            try {
                ZipEntry zipEntry;
                InputStream inputStream3;
                byte[] bArr;
                int read;
                c NF;
                Enumeration entries = zipFile.entries();
                int i = 0;
                outputStream4 = null;
                inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.isDirectory()) {
                            inputStream3 = inputStream;
                            outputStream = outputStream4;
                        } else {
                            inputStream2 = zipFile.getInputStream(zipEntry);
                            try {
                                String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                                File file = new File(stringBuilder2 + "/" + zipEntry.getName());
                                if (file.isFile()) {
                                    file.delete();
                                }
                                file.getParentFile().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream = new FileOutputStream(stringBuilder2 + File.separator + toLowerCase);
                                        try {
                                            int i2;
                                            bArr = new byte[131072];
                                            while (true) {
                                                read = inputStream2.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream.write(bArr, 0, read);
                                            }
                                            outputStream.close();
                                            outputStream4 = null;
                                            String aX = g.aX(stringBuilder2 + File.separator + toLowerCase);
                                            v.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", new Object[]{aX, Integer.valueOf(i)});
                                            File file2 = new File(stringBuilder2 + File.separator + toLowerCase);
                                            File file3 = new File(stringBuilder2 + File.separator + aX);
                                            if (o.JZ(file2.getPath())) {
                                                i2 = c.nwT;
                                            } else {
                                                i2 = c.nwS;
                                            }
                                            NF = g.afx().fch.NF(aX);
                                            if (NF == null) {
                                                NF = new c();
                                                NF.field_catalog = 0;
                                            }
                                            NF.field_name = toLowerCase;
                                            NF.field_md5 = aX;
                                            NF.field_size = (int) file2.length();
                                            NF.field_type = i2;
                                            NF.field_groupId = str;
                                            NF.field_idx = i;
                                            arrayList.add(NF);
                                            file2.renameTo(file3);
                                            hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), aX);
                                            outputStream = null;
                                            inputStream3 = inputStream2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            zipFile2 = zipFile;
                                            outputStream2 = outputStream;
                                            inputStream = inputStream2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            outputStream4 = outputStream;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream = new FileOutputStream(stringBuilder2 + File.separator + (g.m(str.getBytes()) + "_panel_enable"));
                                        try {
                                            bArr = new byte[131072];
                                            while (true) {
                                                read = inputStream2.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream.write(bArr, 0, read);
                                            }
                                            outputStream.close();
                                            outputStream = null;
                                            inputStream3 = inputStream2;
                                        } catch (Exception e3) {
                                            e = e3;
                                            zipFile2 = zipFile;
                                            outputStream2 = outputStream;
                                            inputStream = inputStream2;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream4 = outputStream;
                                        }
                                    }
                                }
                                outputStream = outputStream4;
                                inputStream3 = inputStream2;
                            } catch (Exception e4) {
                                e = e4;
                                inputStream = inputStream2;
                                outputStream3 = outputStream4;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream3;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                                inputStream3 = null;
                            } catch (Exception e5) {
                                Exception exception = e5;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream;
                                inputStream = inputStream3;
                                e = exception;
                            } catch (Throwable th5) {
                                inputStream2 = inputStream3;
                                th = th5;
                                outputStream4 = outputStream;
                            }
                        }
                        i++;
                        outputStream4 = outputStream;
                        inputStream = inputStream3;
                    } catch (Exception e6) {
                        e = e6;
                        ZipFile zipFile3 = zipFile;
                        outputStream2 = outputStream4;
                        zipFile2 = zipFile3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream2 = inputStream;
                    }
                }
                Enumeration entries2 = zipFile.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (zipEntry.isDirectory()) {
                        inputStream3 = inputStream;
                        outputStream = outputStream4;
                    } else {
                        inputStream2 = zipFile.getInputStream(zipEntry);
                        String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                        File file4 = new File(stringBuilder2 + "/" + zipEntry.getName());
                        if (file4.isFile()) {
                            file4.delete();
                        }
                        file4.getParentFile().mkdirs();
                        if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                            int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                            String str4 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                            outputStream = new FileOutputStream(stringBuilder2 + File.separator + str4);
                            try {
                                bArr = new byte[131072];
                                while (true) {
                                    read = inputStream2.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    outputStream.write(bArr, 0, read);
                                }
                                outputStream.close();
                                outputStream4 = null;
                                String substring = str4.substring(0, str4.lastIndexOf("_cover."));
                                if (hashMap.containsKey(substring)) {
                                    substring = (String) hashMap.get(substring);
                                    new File(stringBuilder2 + File.separator + str4).renameTo(new File(stringBuilder2 + File.separator + substring + "_cover"));
                                    hashMap.put(str4, substring);
                                }
                                outputStream = null;
                                inputStream3 = inputStream2;
                            } catch (Exception e7) {
                                e = e7;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream;
                                inputStream = inputStream2;
                            } catch (Throwable th7) {
                                th = th7;
                                outputStream4 = outputStream;
                            }
                        } else {
                            outputStream = outputStream4;
                            inputStream3 = inputStream2;
                        }
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                        inputStream3 = null;
                    }
                    outputStream4 = outputStream;
                    inputStream = inputStream3;
                }
                hashMap.clear();
                if (aVar == null) {
                    aVar = g.afx().fci.aI(str, false);
                }
                aVar.field_productID = str;
                if (!be.kS(str2)) {
                    aVar.field_packName = str2;
                }
                aVar.field_lastUseTime = System.currentTimeMillis();
                aVar.field_status = 7;
                aVar.field_packStatus = 1;
                aVar.field_type = a.nwG;
                aVar.field_recommand = 0;
                aVar.field_sync = 2;
                aVar.field_count = arrayList.size();
                if (g.afx().fch.h(arrayList, str)) {
                    boolean c = g.afx().fci.c(aVar);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        NF = (c) it.next();
                        NF.field_reserved4 = 0;
                        f.aeV().c(NF, true);
                    }
                    v.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", new Object[]{Boolean.valueOf(c), Boolean.valueOf(r6)});
                } else {
                    v.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", new Object[]{Boolean.valueOf(g.afx().fch.h(arrayList, str))});
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                return true;
            } catch (Exception e8) {
                e = e8;
                zipFile2 = zipFile;
                outputStream2 = null;
                inputStream = null;
                try {
                    v.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                    return false;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream2 = inputStream;
                    outputStream3 = outputStream2;
                    zipFile = zipFile2;
                    outputStream4 = outputStream3;
                    if (outputStream4 != null) {
                        outputStream4.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                outputStream4 = null;
                if (outputStream4 != null) {
                    outputStream4.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            outputStream2 = null;
            inputStream = null;
            v.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            zipFile = null;
            outputStream4 = null;
            if (outputStream4 != null) {
                outputStream4.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static boolean aeZ() {
        return g.afx().fch.iC(false) >= com.tencent.mm.plugin.emoji.d.o.afk();
    }

    public static vn afl() {
        vn vnVar = new vn();
        vnVar.mya = 1;
        vnVar.myc = 1;
        return vnVar;
    }

    public static String rs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        v.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static String k(int i, String str, String str2) {
        if (i == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<designeruin>" + i + "</designeruin>");
        stringBuilder.append("<designername>" + str + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
        stringBuilder.append("</xml>");
        v.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int rp(String str) {
        int ba;
        Exception e;
        try {
            ba = com.tencent.mm.a.o.ba((String) bf.q(str, "xml").get(".xml.designeruin"));
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{Integer.valueOf(ba)});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
                return ba;
            }
        } catch (Exception e3) {
            e = e3;
            ba = 0;
            v.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
            return ba;
        }
        return ba;
    }

    public static String rq(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.designername");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String rt(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.designerrediretcturl");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String ro(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.productid");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "productId:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String rn(String str) {
        v.d("MicroMsg.emoji.EmojiLogic", "url:%s", new Object[]{str});
        String str2 = "";
        if (TextUtils.isEmpty(str) || !str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            return str2;
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<tid>" + i + "</tid>");
        stringBuilder.append("<title>" + str + "</title>");
        stringBuilder.append("<desc>" + str2 + "</desc>");
        stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
        stringBuilder.append("<pageType>" + i2 + "</pageType>");
        stringBuilder.append("</xml>");
        v.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int ru(String str) {
        int KL;
        Exception e;
        try {
            KL = be.KL((String) bf.q(str, "xml").get(".xml.tid"));
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "tid:%s", new Object[]{Integer.valueOf(KL)});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
                return KL;
            }
        } catch (Exception e3) {
            e = e3;
            KL = 0;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
            return KL;
        }
        return KL;
    }

    public static String rv(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.title");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "title:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String rw(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.desc");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "desc:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String rx(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bf.q(str, "xml").get(".xml.iconUrl");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String ry(String str) {
        String ah;
        Exception e;
        String str2 = "";
        try {
            ah = be.ah((String) bf.q(str, "xml").get(".xml.secondUrl"), "");
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", new Object[]{ah});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
                return ah;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            ah = str2;
            e = exception;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
            return ah;
        }
        return ah;
    }

    public static int rz(String str) {
        int KL;
        Exception e;
        try {
            KL = be.KL((String) bf.q(str, "xml").get(".xml.pageType"));
            try {
                v.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", new Object[]{Integer.valueOf(KL)});
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
                return KL;
            }
        } catch (Exception e3) {
            e = e3;
            KL = 0;
            v.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
            return KL;
        }
        return KL;
    }

    public static String z(String str, String str2, String str3) {
        if (be.kS(str2) && be.kS(str3)) {
            v.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String bp = bp(str2, str3);
        if (be.kS(bp)) {
            return null;
        }
        if (be.kS(str2)) {
            return str + bp;
        }
        return str + str2 + fcI + bp;
    }

    public static String A(String str, String str2, String str3) {
        String str4 = null;
        if (be.kS(str2) && be.kS(str3)) {
            v.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
        } else {
            if (!be.kS(str3)) {
                if (be.kS(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + fcI + str3;
                }
            }
            v.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", new Object[]{str2, str3, str4});
        }
        return str4;
    }

    private static String bp(String str, String str2) {
        if (be.kS(str) && be.kS(str2)) {
            v.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            return null;
        } else if (be.kS(str2)) {
            return g.m(str.getBytes());
        } else {
            return g.m(str2.getBytes());
        }
    }

    public static boolean rA(String str) {
        if (!be.kS(str)) {
            try {
                if (b.iu(str)) {
                    v.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", new Object[]{str});
                    return true;
                }
            } catch (Throwable e) {
                v.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", new Object[]{be.e(e)});
            }
        }
        return false;
    }
}
