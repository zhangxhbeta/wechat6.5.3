package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class DownloadTask {
    public static final String TAG = "_DownloadTask";
    protected DownloadInfo mDownloadInfo = null;
    HttpClient mHttpClient = null;
    HttpGet mHttpGet = null;
    protected final byte[] mRecvBuf = new byte[4096];
    TMAssistantFile mSaveFile;
    protected boolean mStopTask = false;
    protected final int mTaskId = GlobalUtil.getMemUUID();

    public DownloadTask(DownloadInfo downloadInfo) {
        this.mDownloadInfo = downloadInfo;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void cancel() {
        TMLog.i(TAG, "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
        this.mStopTask = true;
        if (this.mHttpGet != null && !this.mHttpGet.isAborted()) {
            this.mHttpGet.abort();
        }
    }

    public String getDownloadURI() {
        return this.mDownloadInfo.mURL;
    }

    public int getPriority() {
        return this.mDownloadInfo.mPriority;
    }

    public void exec(String str) {
        boolean z;
        boolean z2;
        this.mDownloadInfo.mTaskIsRunning = true;
        this.mDownloadInfo.updateStatus(2);
        JceStruct jceStruct = null;
        Throwable th = null;
        boolean z3 = true;
        while (z3) {
            JceStruct createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 0);
            createNewChunkLogInfo.UUID = this.mDownloadInfo.mUUID;
            createNewChunkLogInfo.currentRetryCnt = (byte) this.mDownloadInfo.mRetryCnt;
            createNewChunkLogInfo.requestUrl = getDownloadURI();
            if (this.mStopTask) {
                jceStruct = createNewChunkLogInfo;
                break;
            }
            try {
                this.mHttpClient = HttpClientUtil.createHttpClient();
                HttpClientUtil.setProxy(this.mHttpClient);
                this.mHttpGet = new HttpGet();
                this.mHttpGet.setURI(new URI(this.mDownloadInfo.mRequestURL));
                setExtraHeaderParam(this.mHttpGet, this.mDownloadInfo.getHeaderParams());
                setRangeHeader(this.mHttpGet, createNewChunkLogInfo);
                TMLog.i(TAG, "start httpGet " + Thread.currentThread().getName());
                HttpResponse execute = this.mHttpClient.execute(this.mHttpGet);
                if (execute == null) {
                    throw new StopRequestException(701, "response is null! " + Thread.currentThread().getName());
                }
                handleResponseCode(execute, createNewChunkLogInfo);
                if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                if (z && createNewChunkLogInfo != null) {
                    createNewChunkLogInfo.endTime = System.currentTimeMillis();
                    createNewChunkLogInfo.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
                    createNewChunkLogInfo.resultState = this.mDownloadInfo.mStatus;
                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                    z3 = z;
                    jceStruct = null;
                }
                z3 = z;
                jceStruct = createNewChunkLogInfo;
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
                if (this.mDownloadInfo.hasRetryChance()) {
                    DownloadInfo downloadInfo = this.mDownloadInfo;
                    downloadInfo.mRetryCnt++;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e2) {
                        th = e2;
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                        z = false;
                    }
                } else {
                    this.mDownloadInfo.mDownloadFailedErrCode = 601;
                    th = e;
                    z = false;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                if (z && createNewChunkLogInfo != null) {
                    createNewChunkLogInfo.endTime = System.currentTimeMillis();
                    createNewChunkLogInfo.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
                    createNewChunkLogInfo.resultState = this.mDownloadInfo.mStatus;
                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                    z3 = z;
                    jceStruct = null;
                }
            } catch (Throwable e3) {
                v.a(TAG, e3, "", new Object[0]);
                if (this.mDownloadInfo.hasRetryChance()) {
                    DownloadInfo downloadInfo2 = this.mDownloadInfo;
                    downloadInfo2.mRetryCnt++;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e4) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                        th = e3;
                        z = false;
                    }
                } else {
                    this.mDownloadInfo.mDownloadFailedErrCode = 602;
                    th = e3;
                    z = false;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                if (z && createNewChunkLogInfo != null) {
                    createNewChunkLogInfo.endTime = System.currentTimeMillis();
                    createNewChunkLogInfo.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
                    createNewChunkLogInfo.resultState = this.mDownloadInfo.mStatus;
                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                    z3 = z;
                    jceStruct = null;
                }
            } catch (UnknownHostException e5) {
                th = e5;
                v.a(TAG, th, "", new Object[0]);
                this.mDownloadInfo.mDownloadFailedErrCode = 603;
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                jceStruct = createNewChunkLogInfo;
                z3 = false;
            } catch (InterruptedException e6) {
                th = e6;
                v.a(TAG, th, "", new Object[0]);
                this.mDownloadInfo.mDownloadFailedErrCode = 600;
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                jceStruct = createNewChunkLogInfo;
                z3 = false;
            } catch (IOException e7) {
                th = e7;
                v.a(TAG, th, "", new Object[0]);
                this.mDownloadInfo.mDownloadFailedErrCode = 606;
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                jceStruct = createNewChunkLogInfo;
                z3 = false;
            } catch (Throwable e32) {
                v.a(TAG, e32, "", new Object[0]);
                this.mDownloadInfo.mDownloadFailedErrCode = e32.mFinalErrCode;
                if (704 == e32.mFinalErrCode) {
                    this.mDownloadInfo.setTotalSize(0);
                    new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName).deleteTempFile();
                    if (this.mDownloadInfo.hasRetryChance()) {
                        DownloadInfo downloadInfo3 = this.mDownloadInfo;
                        downloadInfo3.mRetryCnt++;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                if (!z2 || createNewChunkLogInfo == null) {
                    Throwable th2 = e32;
                    z = z2;
                    th = th2;
                } else {
                    createNewChunkLogInfo.endTime = System.currentTimeMillis();
                    createNewChunkLogInfo.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
                    createNewChunkLogInfo.resultState = this.mDownloadInfo.mStatus;
                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                    z3 = z2;
                    th = e32;
                    jceStruct = null;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
        if (!this.mStopTask) {
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                this.mDownloadInfo.updateStatus(4);
            } else {
                this.mDownloadInfo.updateStatus(5);
                onDownloadError(th);
            }
        }
        if (jceStruct != null) {
            jceStruct.endTime = System.currentTimeMillis();
            jceStruct.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
            jceStruct.resultState = this.mDownloadInfo.mStatus;
            DownloadReportManager.getInstance().addLogData(jceStruct);
        }
        TMLog.i(TAG, "download finished, finalstatus: " + this.mDownloadInfo.mStatus + " errCode: " + this.mDownloadInfo.mDownloadFailedErrCode);
        this.mDownloadInfo.mTaskIsRunning = false;
        return;
        if (this.mHttpGet != null) {
            if (!this.mHttpGet.isAborted()) {
                this.mHttpGet.abort();
            }
            this.mHttpGet = null;
        }
        if (this.mHttpClient != null) {
            this.mHttpClient.getConnectionManager().shutdown();
            this.mHttpClient = null;
        }
        if (this.mSaveFile != null) {
            this.mSaveFile.close();
            this.mSaveFile = null;
        }
        if (z && createNewChunkLogInfo != null) {
            createNewChunkLogInfo.endTime = System.currentTimeMillis();
            createNewChunkLogInfo.errorCode = this.mDownloadInfo.mDownloadFailedErrCode;
            createNewChunkLogInfo.resultState = this.mDownloadInfo.mStatus;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        throw th;
    }

    private void onDownloadError(Throwable th) {
        if (th != null) {
            v.a(TAG, th, "", new Object[0]);
        }
    }

    private void handleResponseCode(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        TMLog.i(TAG, "httpResponseCode = " + statusCode + " " + Thread.currentThread().getName());
        downloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
        downloadChunkLogInfo.responseHttpCode = statusCode;
        switch (statusCode) {
            case 200:
                Header[] headers = httpResponse.getHeaders("Content-Type");
                if (headers != null && headers.length > 0) {
                    if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                    } else {
                        Object value = headers[0].getValue();
                        if (TextUtils.isEmpty(value) || !value.startsWith("text")) {
                            renameApkFileName(httpResponse);
                        } else {
                            throw new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
                        }
                    }
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case 206:
                if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                } else {
                    renameApkFileName(httpResponse);
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case 301:
            case 302:
            case 303:
            case 307:
                if (this.mDownloadInfo.mRedirectCnt > 5) {
                    throw new StopRequestException(709, "Redirect cnt many times.");
                }
                Header firstHeader = httpResponse.getFirstHeader("location");
                if (firstHeader != null) {
                    String value2 = firstHeader.getValue();
                    if (DownloadHelper.isValidURL(value2)) {
                        this.mDownloadInfo.mRequestURL = DownloadHelper.correctURL(value2);
                        DownloadInfo downloadInfo = this.mDownloadInfo;
                        downloadInfo.mRedirectCnt++;
                        return;
                    }
                    throw new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + statusCode + " url: " + value2);
                }
                throw new StopRequestException(702, "location header is null. httpResponseCode = " + statusCode);
            case 416:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 500:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 503:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            default:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReceivedResponseData(org.apache.http.HttpResponse r11, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo r12) {
        /*
        r10 = this;
        r0 = r11.getEntity();
        r1 = r10.mDownloadInfo;
        r2 = r1.getTotalSize();
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0141;
    L_0x0010:
        r1 = r11.getStatusLine();
        r1 = r1.getStatusCode();
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x00dc;
    L_0x001c:
        r1 = r10.mDownloadInfo;
        r2 = r0.getContentLength();
        r1.setTotalSize(r2);
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPCode 200, totalBytes:";
        r2.<init>(r3);
        r3 = r10.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.i(r1, r2);
    L_0x0041:
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "first start downloadinfoTotalSize = ";
        r2.<init>(r3);
        r3 = r10.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);
        r1 = "content-range";
        r1 = r11.getFirstHeader(r1);
        if (r1 == 0) goto L_0x0082;
    L_0x0066:
        r1 = r1.getValue();
        r1 = com.tencent.tmassistantsdk.downloadservice.ByteRange.parseContentRange(r1);
        r2 = r1.getStart();
        r12.responseRangePosition = r2;
        r2 = r1.getEnd();
        r4 = r1.getStart();
        r2 = r2 - r4;
        r4 = 1;
        r2 = r2 + r4;
        r12.responseRangeLength = r2;
    L_0x0082:
        r1 = r10.mDownloadInfo;
        r2 = r1.getTotalSize();
        r12.responseContentLength = r2;
    L_0x008a:
        r1 = r10.mSaveFile;
        if (r1 != 0) goto L_0x009d;
    L_0x008e:
        r1 = new com.tencent.tmassistantsdk.storage.TMAssistantFile;
        r2 = r10.mDownloadInfo;
        r2 = r2.mTempFileName;
        r3 = r10.mDownloadInfo;
        r3 = r3.mFileName;
        r1.<init>(r2, r3);
        r10.mSaveFile = r1;
    L_0x009d:
        r2 = 0;
        r7 = r0.getContent();	 Catch:{ SocketException -> 0x03ad }
        r0 = "_DownloadTask";
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x03ad }
        r4 = "start write file, fileName: ";
        r1.<init>(r4);	 Catch:{ SocketException -> 0x03ad }
        r4 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x03ad }
        r4 = r4.mFileName;	 Catch:{ SocketException -> 0x03ad }
        r1 = r1.append(r4);	 Catch:{ SocketException -> 0x03ad }
        r1 = r1.toString();	 Catch:{ SocketException -> 0x03ad }
        com.tencent.tmassistantsdk.util.TMLog.i(r0, r1);	 Catch:{ SocketException -> 0x03ad }
        r8 = r2;
    L_0x00be:
        r0 = r10.mRecvBuf;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = r7.read(r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        if (r3 <= 0) goto L_0x00cd;
    L_0x00c6:
        r0 = r10.mStopTask;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        if (r0 == 0) goto L_0x0208;
    L_0x00ca:
        r7.close();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
    L_0x00cd:
        r0 = r10.mSaveFile;
        if (r0 == 0) goto L_0x00d9;
    L_0x00d1:
        r0 = r10.mSaveFile;
        r0.close();
        r0 = 0;
        r10.mSaveFile = r0;
    L_0x00d9:
        r12.receiveDataSize = r8;
        return;
    L_0x00dc:
        r1 = r11.getStatusLine();
        r1 = r1.getStatusCode();
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r1 != r2) goto L_0x011a;
    L_0x00e8:
        r1 = "content-range";
        r1 = r11.getFirstHeader(r1);
        r2 = r10.mDownloadInfo;
        r1 = r1.getValue();
        r4 = com.tencent.tmassistantsdk.downloadservice.ByteRange.getTotalSize(r1);
        r2.setTotalSize(r4);
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPCode 206, totalBytes:";
        r2.<init>(r3);
        r3 = r10.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.i(r1, r2);
        goto L_0x0041;
    L_0x011a:
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "statusCode=";
        r2.<init>(r3);
        r3 = r11.getStatusLine();
        r3 = r3.getStatusCode();
        r2 = r2.append(r3);
        r3 = " onReceivedResponseData error.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);
        goto L_0x0041;
    L_0x0141:
        r1 = r11.getStatusLine();
        r1 = r1.getStatusCode();
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r1 != r2) goto L_0x008a;
    L_0x014d:
        r1 = "content-range";
        r1 = r11.getFirstHeader(r1);	 Catch:{ Throwable -> 0x01b8 }
        r2 = r1.getValue();	 Catch:{ Throwable -> 0x01b8 }
        r2 = com.tencent.tmassistantsdk.downloadservice.ByteRange.parseContentRange(r2);	 Catch:{ Throwable -> 0x01b8 }
        r3 = r1.getValue();	 Catch:{ Throwable -> 0x01b8 }
        r4 = com.tencent.tmassistantsdk.downloadservice.ByteRange.getTotalSize(r3);	 Catch:{ Throwable -> 0x01b8 }
        r6 = r2.getStart();	 Catch:{ Throwable -> 0x01b8 }
        r12.responseRangePosition = r6;	 Catch:{ Throwable -> 0x01b8 }
        r6 = r2.getEnd();	 Catch:{ Throwable -> 0x01b8 }
        r8 = r2.getStart();	 Catch:{ Throwable -> 0x01b8 }
        r6 = r6 - r8;
        r8 = 1;
        r6 = r6 + r8;
        r12.responseRangeLength = r6;	 Catch:{ Throwable -> 0x01b8 }
        r12.responseContentLength = r4;	 Catch:{ Throwable -> 0x01b8 }
        r3 = "_DownloadTask";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b8 }
        r7 = "totalSize = ";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x01b8 }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x01b8 }
        r7 = "  downloadinfoTotalSize = ";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x01b8 }
        r7 = r10.mDownloadInfo;	 Catch:{ Throwable -> 0x01b8 }
        r8 = r7.getTotalSize();	 Catch:{ Throwable -> 0x01b8 }
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x01b8 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x01b8 }
        com.tencent.tmassistantsdk.util.TMLog.w(r3, r6);	 Catch:{ Throwable -> 0x01b8 }
        r2 = r2.getStart();	 Catch:{ Throwable -> 0x01b8 }
        r6 = r10.mDownloadInfo;	 Catch:{ Throwable -> 0x01b8 }
        r6 = r6.mReceivedBytes;	 Catch:{ Throwable -> 0x01b8 }
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x01cf;
    L_0x01ad:
        r0 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ Throwable -> 0x01b8 }
        r1 = 706; // 0x2c2 float:9.9E-43 double:3.49E-321;
        r2 = "The received size is not equal with ByteRange.";
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x01b8 }
        throw r0;	 Catch:{ Throwable -> 0x01b8 }
    L_0x01b8:
        r0 = move-exception;
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ all -> 0x01c1 }
        r2 = 704; // 0x2c0 float:9.87E-43 double:3.48E-321;
        r1.<init>(r2, r0);	 Catch:{ all -> 0x01c1 }
        throw r1;	 Catch:{ all -> 0x01c1 }
    L_0x01c1:
        r0 = move-exception;
        r1 = r10.mSaveFile;
        if (r1 == 0) goto L_0x01ce;
    L_0x01c6:
        r1 = r10.mSaveFile;
        r1.close();
        r1 = 0;
        r10.mSaveFile = r1;
    L_0x01ce:
        throw r0;
    L_0x01cf:
        r2 = r10.mDownloadInfo;	 Catch:{ Throwable -> 0x01b8 }
        r2 = r2.getTotalSize();	 Catch:{ Throwable -> 0x01b8 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x01e4;
    L_0x01d9:
        r0 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ Throwable -> 0x01b8 }
        r1 = 705; // 0x2c1 float:9.88E-43 double:3.483E-321;
        r2 = "The total size is not equal with ByteRange.";
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x01b8 }
        throw r0;	 Catch:{ Throwable -> 0x01b8 }
    L_0x01e4:
        r2 = "_DownloadTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b8 }
        r4 = "response ByteRange: ";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x01b8 }
        r1 = r3.append(r1);	 Catch:{ Throwable -> 0x01b8 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01b8 }
        com.tencent.tmassistantsdk.util.TMLog.d(r2, r1);	 Catch:{ Throwable -> 0x01b8 }
        r1 = r10.mSaveFile;
        if (r1 == 0) goto L_0x008a;
    L_0x01fe:
        r1 = r10.mSaveFile;
        r1.close();
        r1 = 0;
        r10.mSaveFile = r1;
        goto L_0x008a;
    L_0x0208:
        r0 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = (long) r3;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0 + r4;
        r2 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r2.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0365;
    L_0x0218:
        r2 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r2.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x02bc;
    L_0x0222:
        r6 = 1;
    L_0x0223:
        r0 = r10.mSaveFile;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mRecvBuf;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = 0;
        r4 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r4.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.write(r1, r2, r3, r4, r6);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        if (r0 != 0) goto L_0x035b;
    L_0x0232:
        r0 = com.tencent.tmassistantsdk.storage.TMAssistantFile.getSavePathRootDir();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r1.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = com.tencent.tmassistantsdk.downloadservice.DownloadHelper.isSpaceEnough(r0, r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        if (r0 == 0) goto L_0x030e;
    L_0x0242:
        r0 = com.tencent.tmassistantsdk.storage.TMAssistantFile.isSDCardExistAndCanWrite();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        if (r0 == 0) goto L_0x02bf;
    L_0x0248:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "write file failed, fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = 703; // 0x2bf float:9.85E-43 double:3.473E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        throw r1;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
    L_0x0295:
        r0 = move-exception;
        r2 = r8;
    L_0x0297:
        r1 = "_DownloadTask";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02ab }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r4, r5);	 Catch:{ all -> 0x02ab }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ all -> 0x02ab }
        r4 = 605; // 0x25d float:8.48E-43 double:2.99E-321;
        r1.<init>(r4, r0);	 Catch:{ all -> 0x02ab }
        throw r1;	 Catch:{ all -> 0x02ab }
    L_0x02ab:
        r0 = move-exception;
        r8 = r2;
    L_0x02ad:
        r1 = r10.mSaveFile;
        if (r1 == 0) goto L_0x02b9;
    L_0x02b1:
        r1 = r10.mSaveFile;
        r1.close();
        r1 = 0;
        r10.mSaveFile = r1;
    L_0x02b9:
        r12.receiveDataSize = r8;
        throw r0;
    L_0x02bc:
        r6 = 0;
        goto L_0x0223;
    L_0x02bf:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "write file failed, no sdCard! fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = 711; // 0x2c7 float:9.96E-43 double:3.513E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        throw r1;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
    L_0x030c:
        r0 = move-exception;
        goto L_0x02ad;
    L_0x030e:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "write file failed, no enough space! fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = 710; // 0x2c6 float:9.95E-43 double:3.51E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        throw r1;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
    L_0x035b:
        r0 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = (long) r3;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0.updateReceivedSize(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r0 = (long) r3;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r8 = r8 + r0;
        goto L_0x00be;
    L_0x0365:
        r0 = "write file size too long.";
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = "write file size too long.\r\nreadedLen: ";
        r2.<init>(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = "\r\nreceivedSize: ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r3.mReceivedBytes;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r2.append(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = "\r\ntotalSize: ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = r10.mDownloadInfo;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r4 = r3.getTotalSize();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r2.append(r4);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r3 = "\r\nisTheEndData: false";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        r2 = 703; // 0x2bf float:9.85E-43 double:3.473E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
        throw r1;	 Catch:{ SocketException -> 0x0295, all -> 0x030c }
    L_0x03ad:
        r0 = move-exception;
        goto L_0x0297;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadservice.DownloadTask.onReceivedResponseData(org.apache.http.HttpResponse, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo):void");
    }

    private void setRangeHeader(HttpGet httpGet, DownloadChunkLogInfo downloadChunkLogInfo) {
        String netStatus = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mNetType = netStatus;
        if (TextUtils.isEmpty(netStatus) || (!netStatus.contains("wap") && (!netStatus.contains("net") || this.mDownloadInfo.mRetryCnt <= 0))) {
            netStatus = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
            downloadChunkLogInfo.requestRanageSize = 0;
            return;
        }
        try {
            long j;
            int splitSizeInBytes = DownloadSetting.getSplitSizeInBytes(netStatus);
            long j2 = this.mDownloadInfo.mReceivedBytes;
            if (this.mDownloadInfo.getTotalSize() > 0) {
                j = (this.mDownloadInfo.mReceivedBytes + ((long) splitSizeInBytes)) - 1;
                if (j >= this.mDownloadInfo.getTotalSize()) {
                    j = this.mDownloadInfo.getTotalSize() - 1;
                }
            } else {
                j = (long) (splitSizeInBytes - 1);
            }
            netStatus = "bytes=" + j2 + "-" + j;
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = j2;
            downloadChunkLogInfo.requestRanageSize = (long) splitSizeInBytes;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
        }
    }

    private void renameApkFileName(HttpResponse httpResponse) {
        if (httpResponse != null && this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive")) {
            Object obj = null;
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            if (headers == null || headers.length <= 0) {
                obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
            } else {
                String value = headers[0].getValue();
                if (TextUtils.isEmpty(value) || !value.contains("filename=\"")) {
                    obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
                } else {
                    value = value.substring(value.indexOf("filename=\"") + 10);
                    if (!TextUtils.isEmpty(value)) {
                        obj = value.substring(0, value.indexOf("\""));
                        TMLog.i(TAG, "header file Name =" + obj);
                    }
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                this.mDownloadInfo.mFileName = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(obj));
            }
        }
    }

    private void setExtraHeaderParam(HttpGet httpGet, Map<String, String> map) {
        if (httpGet != null && map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                httpGet.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
