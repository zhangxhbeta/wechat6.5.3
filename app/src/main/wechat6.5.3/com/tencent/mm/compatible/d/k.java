package com.tencent.mm.compatible.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class k {
    private static k cem = null;
    private boolean cel = false;
    private String filePath = SQLiteDatabase.KeyEmpty;
    private Map<Integer, Object> values;

    public static synchronized k rv() {
        k kVar;
        synchronized (k.class) {
            if (cem == null) {
                cem = new k(e.cng + "CompatibleInfo.cfg");
            }
            kVar = cem;
        }
        return kVar;
    }

    private k(String str) {
        this.filePath = str;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() == 0) {
                this.values = new HashMap();
            } else {
                InputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                this.values = (Map) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (Throwable e) {
            this.values = new HashMap();
            v.a("MicroMsg.CompatibleFileStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        this.cel = false;
    }

    public final synchronized void set(int i, Object obj) {
        this.values.put(Integer.valueOf(i), obj);
        if (!this.cel) {
            rw();
        }
    }

    public final Object get(int i) {
        return this.values.get(Integer.valueOf(i));
    }

    public final Object dQ(int i) {
        Object obj = this.values.get(Integer.valueOf(i));
        if (obj == null) {
            return null;
        }
        return obj;
    }

    private synchronized void rw() {
        try {
            OutputStream fileOutputStream = new FileOutputStream(this.filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.values);
            objectOutputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.CompatibleFileStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
