package com.tencent.mm.pluginsdk;

import java.util.HashMap;

public final class c {
    private static HashMap<String, Integer> lxy = null;

    public static int Ga(String str) {
        if (lxy == null) {
            HashMap hashMap = new HashMap();
            lxy = hashMap;
            hashMap.put("avi", Integer.valueOf(2131165244));
            lxy.put("m4v", Integer.valueOf(2131165244));
            lxy.put("vob", Integer.valueOf(2131165244));
            lxy.put("mpeg", Integer.valueOf(2131165244));
            lxy.put("mpe", Integer.valueOf(2131165244));
            lxy.put("asx", Integer.valueOf(2131165244));
            lxy.put("asf", Integer.valueOf(2131165244));
            lxy.put("f4v", Integer.valueOf(2131165244));
            lxy.put("flv", Integer.valueOf(2131165244));
            lxy.put("mkv", Integer.valueOf(2131165244));
            lxy.put("wmv", Integer.valueOf(2131165244));
            lxy.put("wm", Integer.valueOf(2131165244));
            lxy.put("3gp", Integer.valueOf(2131165244));
            lxy.put("mp4", Integer.valueOf(2131165244));
            lxy.put("rmvb", Integer.valueOf(2131165244));
            lxy.put("rm", Integer.valueOf(2131165244));
            lxy.put("ra", Integer.valueOf(2131165244));
            lxy.put("ram", Integer.valueOf(2131165244));
            lxy.put("mp3pro", Integer.valueOf(2131165232));
            lxy.put("vqf", Integer.valueOf(2131165232));
            lxy.put("cd", Integer.valueOf(2131165232));
            lxy.put("md", Integer.valueOf(2131165232));
            lxy.put("mod", Integer.valueOf(2131165232));
            lxy.put("vorbis", Integer.valueOf(2131165232));
            lxy.put("au", Integer.valueOf(2131165232));
            lxy.put("amr", Integer.valueOf(2131165232));
            lxy.put("silk", Integer.valueOf(2131165232));
            lxy.put("wma", Integer.valueOf(2131165232));
            lxy.put("mmf", Integer.valueOf(2131165232));
            lxy.put("mid", Integer.valueOf(2131165232));
            lxy.put("midi", Integer.valueOf(2131165232));
            lxy.put("mp3", Integer.valueOf(2131165232));
            lxy.put("aac", Integer.valueOf(2131165232));
            lxy.put("ape", Integer.valueOf(2131165232));
            lxy.put("aiff", Integer.valueOf(2131165232));
            lxy.put("aif", Integer.valueOf(2131165232));
            lxy.put("jfif", Integer.valueOf(2130837647));
            lxy.put("tiff", Integer.valueOf(2130837647));
            lxy.put("tif", Integer.valueOf(2130837647));
            lxy.put("jpe", Integer.valueOf(2130837647));
            lxy.put("dib", Integer.valueOf(2130837647));
            lxy.put("jpeg", Integer.valueOf(2130837647));
            lxy.put("jpg", Integer.valueOf(2130837647));
            lxy.put("png", Integer.valueOf(2130837647));
            lxy.put("bmp", Integer.valueOf(2130837647));
            lxy.put("gif", Integer.valueOf(2130837647));
            lxy.put("rar", Integer.valueOf(2131165238));
            lxy.put("zip", Integer.valueOf(2131165238));
            lxy.put("7z", Integer.valueOf(2131165238));
            lxy.put("iso", Integer.valueOf(2131165238));
            lxy.put("cab", Integer.valueOf(2131165238));
            lxy.put("doc", Integer.valueOf(2131165248));
            lxy.put("docx", Integer.valueOf(2131165248));
            lxy.put("ppt", Integer.valueOf(2131165236));
            lxy.put("pptx", Integer.valueOf(2131165236));
            lxy.put("xls", Integer.valueOf(2131165228));
            lxy.put("xlsx", Integer.valueOf(2131165228));
            lxy.put("txt", Integer.valueOf(2131165240));
            lxy.put("rtf", Integer.valueOf(2131165240));
            lxy.put("pdf", Integer.valueOf(2131165234));
        }
        Integer num = (Integer) lxy.get(str);
        if (num == null) {
            return 2131165241;
        }
        return num.intValue();
    }
}
