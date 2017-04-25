package com.tencent.mm.pluginsdk;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.FileUtils;
import java.util.HashMap;

public final class b {

    public static final class a {
        public static final HashMap<String, Long> lxw;

        public static Long FZ(String str) {
            if (str == null) {
                return null;
            }
            return (Long) lxw.get(str.toLowerCase());
        }

        static {
            HashMap hashMap = new HashMap();
            lxw = hashMap;
            hashMap.put("doc", Long.valueOf(64));
            lxw.put("docx", Long.valueOf(128));
            lxw.put("ppt", Long.valueOf(256));
            lxw.put("pptx", Long.valueOf(512));
            lxw.put("xls", Long.valueOf(1024));
            lxw.put("xlsx", Long.valueOf(2048));
            lxw.put("pdf", Long.valueOf(4096));
            lxw.put("1", Long.valueOf(1));
            lxw.put("3", Long.valueOf(2));
            lxw.put("48", Long.valueOf(4));
            lxw.put("43", Long.valueOf(8));
            lxw.put("mp3", Long.valueOf(16));
            lxw.put("wav", Long.valueOf(16));
            lxw.put("wma", Long.valueOf(16));
            lxw.put("avi", Long.valueOf(8));
            lxw.put("rmvb", Long.valueOf(8));
            lxw.put("rm", Long.valueOf(8));
            lxw.put("mpg", Long.valueOf(8));
            lxw.put("mpeg", Long.valueOf(8));
            lxw.put("wmv", Long.valueOf(8));
            lxw.put("mp4", Long.valueOf(8));
            lxw.put("mkv", Long.valueOf(8));
        }
    }

    public static final class b {
        public static final HashMap<Integer, Integer> lxx;

        static {
            HashMap hashMap = new HashMap();
            lxx = hashMap;
            hashMap.put(Integer.valueOf(22), Integer.valueOf(64));
            lxx.put(Integer.valueOf(9), Integer.valueOf(64));
            lxx.put(Integer.valueOf(3), Integer.valueOf(64));
            lxx.put(Integer.valueOf(23), Integer.valueOf(64));
            lxx.put(Integer.valueOf(25), Integer.valueOf(64));
            lxx.put(Integer.valueOf(13), Integer.valueOf(64));
            lxx.put(Integer.valueOf(29), Integer.valueOf(FileUtils.S_IRUSR));
            lxx.put(Integer.valueOf(34), Integer.valueOf(512));
            lxx.put(Integer.valueOf(6), Integer.valueOf(512));
            lxx.put(Integer.valueOf(35), Integer.valueOf(1024));
            lxx.put(Integer.valueOf(36), Integer.valueOf(4096));
            lxx.put(Integer.valueOf(37), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            lxx.put(Integer.valueOf(38), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            lxx.put(Integer.valueOf(42), Integer.valueOf(131072));
            lxx.put(Integer.valueOf(40), Integer.valueOf(65536));
            lxx.put(Integer.valueOf(41), Integer.valueOf(65536));
        }
    }
}
