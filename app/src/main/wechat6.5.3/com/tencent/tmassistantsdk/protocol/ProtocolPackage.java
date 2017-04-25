package com.tencent.tmassistantsdk.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReqHead;
import com.tencent.tmassistantsdk.protocol.jce.Request;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.protocol.jce.Terminal;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;

public class ProtocolPackage {
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    static final byte FLAG_CRYPT = (byte) 2;
    static final byte FLAG_ZIP = (byte) 1;
    public static final String ServerEncoding = "utf-8";
    private static final String TAG = "ProtocolPackage";
    static final int ZIP_TRIGGER = 256;

    public static JceStruct buildReportRequest(byte b, List<byte[]> list, String str, int i, String str2) {
        JceStruct reportLogRequest = new ReportLogRequest();
        reportLogRequest.logType = b;
        reportLogRequest.logData = formatLogData(list);
        reportLogRequest.hostAppPackageName = str;
        reportLogRequest.hostAppVersion = i;
        reportLogRequest.hostUserId = str2;
        return reportLogRequest;
    }

    public static ReqHead getReqHead(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        ReqHead reqHead = new ReqHead();
        reqHead.requestId = GlobalUtil.getMemUUID();
        String simpleName = jceStruct.getClass().getSimpleName();
        reqHead.cmdId = GlobalUtil.getInstance().getJceCmdIdByClassName(simpleName.substring(0, simpleName.length() - 7));
        reqHead.qua = GlobalUtil.getInstance().mQUA;
        reqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
        Terminal terminal = new Terminal();
        terminal.androidId = GlobalUtil.getInstance().getAndroidIdInPhone();
        terminal.androidIdSdCard = GlobalUtil.getInstance().getPhoneGuid();
        terminal.imei = GlobalUtil.getInstance().getImei();
        terminal.imsi = GlobalUtil.getInstance().getImsi();
        terminal.macAdress = GlobalUtil.getInstance().getMacAddress();
        reqHead.terminal = terminal;
        reqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        reqHead.assistantVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        return reqHead;
    }

    public static Request buildRequest(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        Request request = new Request();
        request.head = getReqHead(jceStruct);
        request.body = jceStructToUTF8Byte(jceStruct);
        return request;
    }

    public static byte[] buildPostData(Request request) {
        if (request == null) {
            return null;
        }
        request.head.encryptWithPack = (byte) 0;
        if (request.body.length > ZIP_TRIGGER) {
            request.body = ZipUtils.zip(request.body);
            request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 1);
        }
        request.body = encrypt(request.body, CRYPT_KEY.getBytes());
        request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 2);
        return jceStructToUTF8Byte(request);
    }

    public static Response unpackPackage(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return null;
        }
        Response response = new Response();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            response.readFrom(jceInputStream);
            if (response.head.ret != 0) {
                return response;
            }
            if ((response.head.encryptWithPack & 2) == 2) {
                response.body = decrypt(response.body, CRYPT_KEY.getBytes());
            }
            if ((response.head.encryptWithPack & 1) == 1) {
                response.body = ZipUtils.unzip(response.body);
            }
            GlobalUtil.getInstance().setPhoneGuid(response.head.phoneGuid);
            return response;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return null;
        }
    }

    public static JceStruct unpageageJceResponse(JceStruct jceStruct, byte[] bArr) {
        if (!(jceStruct == null || bArr == null)) {
            JceStruct createFromRequest = createFromRequest(jceStruct);
            if (createFromRequest != null) {
                try {
                    JceInputStream jceInputStream = new JceInputStream(bArr);
                    jceInputStream.setServerEncoding(ServerEncoding);
                    createFromRequest.readFrom(jceInputStream);
                    return createFromRequest;
                } catch (Throwable e) {
                    v.a(TAG, e, "", new Object[0]);
                    return null;
                }
            }
        }
        return null;
    }

    private static JceStruct createFromRequest(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        JceStruct jceStruct2;
        String name = jceStruct.getClass().getName();
        try {
            jceStruct2 = (JceStruct) Class.forName(name.substring(0, name.length() - 7) + "Response").newInstance();
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            jceStruct2 = null;
        } catch (Throwable e2) {
            v.a(TAG, e2, "", new Object[0]);
            jceStruct2 = null;
        } catch (Throwable e22) {
            v.a(TAG, e22, "", new Object[0]);
            jceStruct2 = null;
        }
        return jceStruct2;
    }

    public static byte[] jceStructToUTF8Byte(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(ServerEncoding);
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public static JceStruct bytes2JceObj(byte[] bArr, Class<? extends JceStruct> cls) {
        if (bArr == null) {
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            JceStruct jceStruct = (JceStruct) cls.newInstance();
            jceStruct.readFrom(jceInputStream);
            return jceStruct;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] formatLogData(List<byte[]> list) {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Throwable e;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    for (byte[] bArr : list) {
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                    }
                    byte[] bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        v.a(TAG, e2, "", new Object[0]);
                    }
                    try {
                        dataOutputStream.close();
                        return bArr2;
                    } catch (Throwable e22) {
                        v.a(TAG, e22, "", new Object[0]);
                        return bArr2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        v.a(TAG, e, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e4) {
                                v.a(TAG, e4, "", new Object[0]);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable e42) {
                                v.a(TAG, e42, "", new Object[0]);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e42 = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e222) {
                                v.a(TAG, e222, "", new Object[0]);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable e2222) {
                                v.a(TAG, e2222, "", new Object[0]);
                            }
                        }
                        throw e42;
                    }
                }
            } catch (Exception e5) {
                e42 = e5;
                dataOutputStream = null;
                v.a(TAG, e42, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                e42 = th2;
                dataOutputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw e42;
            }
        } catch (Exception e6) {
            e42 = e6;
            dataOutputStream = null;
            byteArrayOutputStream = null;
            v.a(TAG, e42, "", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            e42 = th3;
            dataOutputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            throw e42;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return new Cryptor().encrypt(bArr, bArr2);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return new Cryptor().decrypt(bArr, bArr2);
    }
}
