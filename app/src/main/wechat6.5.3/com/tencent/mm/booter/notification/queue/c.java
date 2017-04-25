package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class c {
    public static String a(Serializable serializable) {
        long currentTimeMillis = System.currentTimeMillis();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        String encode = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        v.d("MicroMsg.NotificationQueueTool", "serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return encode;
    }

    public static Serializable df(String str) {
        if (t.kS(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InputStream byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(str, "UTF-8").getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serializable serializable = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        v.d("MicroMsg.NotificationQueueTool", "de serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return serializable;
    }
}
