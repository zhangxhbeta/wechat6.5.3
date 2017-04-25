package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public final class p {
    private static p pzv = null;
    private Context mContext = null;
    public String pzA = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    public String pzB = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String pzC = "http://mqqad.html5.qq.com/adjs";
    private String pzD = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    private File pzu = null;
    public String pzw = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    public String pzx = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String pzy = "http://wup.imtt.qq.com:8080";
    public String pzz = "http://log.tbs.qq.com/ajax?c=dl&k=";

    @TargetApi(11)
    private p(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.mContext = context.getApplicationContext();
        bOg();
    }

    public static synchronized p bOf() {
        p pVar;
        synchronized (p.class) {
            pVar = pzv;
        }
        return pVar;
    }

    private synchronized void bOg() {
        try {
            File bOh = bOh();
            if (bOh == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
            } else {
                InputStream fileInputStream = new FileInputStream(bOh);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                String property = properties.getProperty("pv_post_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzw = property;
                }
                property = properties.getProperty("wup_proxy_domain", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzy = property;
                }
                property = properties.getProperty("tbs_download_stat_post_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzz = property;
                }
                property = properties.getProperty("tbs_downloader_post_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzA = property;
                }
                property = properties.getProperty("tbs_log_post_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzB = property;
                }
                property = properties.getProperty("tips_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzC = property;
                }
                property = properties.getProperty("tbs_cmd_post_url", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property)) {
                    this.pzD = property;
                }
                String property2 = properties.getProperty("pv_post_url_tk", SQLiteDatabase.KeyEmpty);
                if (!SQLiteDatabase.KeyEmpty.equals(property2)) {
                    this.pzx = property2;
                }
                fileInputStream.close();
            }
        } catch (Throwable th) {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
        }
    }

    private File bOh() {
        File file;
        Throwable th;
        Writer stringWriter;
        try {
            if (this.pzu == null) {
                this.pzu = new File(e.ae(this.mContext, 5));
                if (this.pzu == null || !this.pzu.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.pzu, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    return file;
                }
            }
            TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            file = null;
            th = th4;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    public static synchronized p ge(Context context) {
        p pVar;
        synchronized (p.class) {
            if (pzv == null) {
                pzv = new p(context);
            }
            pVar = pzv;
        }
        return pVar;
    }
}
