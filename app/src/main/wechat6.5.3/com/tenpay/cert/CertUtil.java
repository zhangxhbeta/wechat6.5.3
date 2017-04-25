package com.tenpay.cert;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil {
    public static final String TAG = CertUtil.class.getSimpleName();
    private static CertUtil instance = null;
    private String cert_dir;
    private String cert_id = null;
    private byte[] certid_buf = null;
    private byte[] cipher_buf = null;
    private byte[] csr_buf = null;
    private String deskey = null;
    private String iccid = null;
    private String imei = null;
    private String imsi = null;
    private String login_ip = null;
    private Context mContext = null;
    private String mac = null;
    private String plain_buf = null;
    private byte[] plain_buf2 = null;
    private String priv_dir;
    private String publ_dir;
    private String qq_id = null;
    private byte[] sig_buf = null;
    private String sig_raw_buf = null;
    private String softid = null;
    private String svr_cert = null;
    private String token = null;
    private byte[] token_buf = null;
    private String token_dir;
    private int token_len = 0;

    private native boolean encrypt();

    private native boolean gen_cert_apply_csr();

    private native boolean gen_qrcode();

    private native boolean get_certid();

    private native int get_last_error();

    private native boolean get_token();

    private native int get_token_count(boolean z);

    private native boolean import_cert();

    private native boolean is_cert_exist();

    private native boolean set_token();

    private native boolean usr_sig();

    private CertUtil() {
    }

    public static CertUtil getInstance() {
        if (instance == null) {
            instance = new CertUtil();
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            this.imsi = telephonyManager.getSubscriberId();
            this.iccid = telephonyManager.getSimSerialNumber();
            this.imei = telephonyManager.getDeviceId();
            this.softid = System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        this.deskey = this.imei;
    }

    private String getCertDir() {
        return new StringBuilder(String.valueOf(this.mContext.getFilesDir().getParentFile().getAbsolutePath())).append("/cert").toString();
    }

    private void setAndCheckDir(String str) {
        String certDir = getCertDir();
        String stringBuilder = new StringBuilder(String.valueOf(certDir)).append("/").append(hexdigest(new StringBuilder(String.valueOf(str)).append(this.imei).toString())).toString();
        this.cert_dir = new StringBuilder(String.valueOf(stringBuilder)).append("/cert").toString();
        this.priv_dir = new StringBuilder(String.valueOf(stringBuilder)).append("/priv").toString();
        this.publ_dir = new StringBuilder(String.valueOf(stringBuilder)).append("/publ").toString();
        this.token_dir = new StringBuilder(String.valueOf(stringBuilder)).append("/auth").toString();
        checkDir(certDir);
        checkDir(this.token_dir);
    }

    private void setDir(String str) {
        String str2 = getCertDir() + "/" + hexdigest(new StringBuilder(String.valueOf(str)).append(this.imei).toString());
        this.cert_dir = new StringBuilder(String.valueOf(str2)).append("/cert").toString();
        this.priv_dir = new StringBuilder(String.valueOf(str2)).append("/priv").toString();
        this.publ_dir = new StringBuilder(String.valueOf(str2)).append("/publ").toString();
        this.token_dir = new StringBuilder(String.valueOf(str2)).append("/auth").toString();
    }

    private void checkDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
    }

    private boolean create_dir(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean del_all_files(String str) {
        int i = 0;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        String[] list = file.list();
        int i2 = 0;
        while (i < list.length) {
            File file2;
            if (str.endsWith(File.separator)) {
                file2 = new File(new StringBuilder(String.valueOf(str)).append(list[i]).toString());
            } else {
                file2 = new File(new StringBuilder(String.valueOf(str)).append(File.separator).append(list[i]).toString());
            }
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                del_all_files(new StringBuilder(String.valueOf(str)).append(File.separator).append(list[i]).toString());
                del_dir(new StringBuilder(String.valueOf(str)).append(File.separator).append(list[i]).toString(), true);
                boolean z = true;
            }
            i++;
        }
        return i2;
    }

    private void del_dir(String str, boolean z) {
        try {
            del_all_files(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean isNotEmptyDir(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            return true;
        }
        return false;
    }

    private boolean isValidDir(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return false;
    }

    private String hexdigest(String str) {
        int i = 0;
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public String getCertApplyCSR(String str) {
        String str2;
        this.qq_id = str;
        this.csr_buf = null;
        if (!gen_cert_apply_csr() || this.csr_buf == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(this.csr_buf, "ASCII");
            } catch (Exception e) {
                return null;
            }
        }
        return str2;
    }

    public boolean importCert(String str, String str2) {
        if (str2.length() <= 0) {
            return false;
        }
        try {
            this.svr_cert = new String(str2.getBytes(), "ASCII");
        } catch (Exception e) {
        }
        setAndCheckDir(str);
        del_dir(this.cert_dir, true);
        create_dir(this.cert_dir);
        del_dir(this.priv_dir, true);
        create_dir(this.priv_dir);
        del_dir(this.publ_dir, true);
        create_dir(this.publ_dir);
        return import_cert();
    }

    public boolean isCertExist(String str) {
        if (isNullOrEmpty(str)) {
            return false;
        }
        setDir(str);
        if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
            return false;
        }
        this.cert_id = str;
        return is_cert_exist();
    }

    public void clearAllCert() {
        del_dir(getCertDir(), true);
    }

    public void clearCert(String str) {
        del_dir(getCertDir() + "/" + hexdigest(new StringBuilder(String.valueOf(str)).append(this.imei).toString()), true);
    }

    public String encrypt(String str, String str2) {
        if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
            return null;
        }
        setAndCheckDir(str);
        if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
            return null;
        }
        String str3;
        this.cert_id = str;
        this.plain_buf = str2;
        this.cipher_buf = null;
        if (!encrypt() || this.cipher_buf == null) {
            str3 = null;
        } else {
            try {
                str3 = new String(this.cipher_buf, "UTF-8");
            } catch (Exception e) {
                return null;
            }
        }
        return str3;
    }

    public String genUserSig(String str, String str2) {
        if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
            return null;
        }
        setAndCheckDir(str);
        if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir) || str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
            return null;
        }
        String str3;
        this.cert_id = str;
        this.sig_raw_buf = str2;
        this.sig_buf = null;
        if (!usr_sig() || this.sig_buf == null) {
            str3 = null;
        } else {
            try {
                str3 = new String(this.sig_buf, "UTF-8");
            } catch (Exception e) {
                return null;
            }
        }
        return str3;
    }

    public byte[] genQrcode(String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        if (!(isNullOrEmpty(str) || isNullOrEmpty(str2) || bArr == null || bArr.length == 0)) {
            setAndCheckDir(str);
            if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                this.cert_id = str;
                this.plain_buf2 = bArr;
                this.cipher_buf = bArr2;
                this.token = str2;
                if (gen_qrcode() && this.cipher_buf != null) {
                    try {
                        bArr2 = this.cipher_buf;
                    } catch (Exception e) {
                    }
                }
            }
        }
        return bArr2;
    }

    public boolean setTokens(String str, String str2) {
        if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
            return false;
        }
        setAndCheckDir(str);
        if (!isValidDir(this.cert_dir) || !isValidDir(this.token_dir)) {
            return false;
        }
        this.cert_id = str;
        this.token = str2;
        this.token_len = this.token.length();
        return set_token();
    }

    public String getToken(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        setAndCheckDir(str);
        if (!isNotEmptyDir(this.token_dir)) {
            return null;
        }
        String str2;
        this.cert_id = str;
        if (!get_token() || this.token_buf == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(this.token_buf, "UTF-8");
            } catch (Exception e) {
                return null;
            }
        }
        return str2;
    }

    public void clearToken(String str) {
        if (!isNullOrEmpty(str)) {
            setDir(str);
            del_dir(this.token_dir, true);
        }
    }

    public int getTokenCount(String str, boolean z) {
        if (isNullOrEmpty(str)) {
            return 0;
        }
        setDir(str);
        this.cert_id = str;
        return get_token_count(z);
    }

    public int getLastError() {
        return get_last_error();
    }
}
