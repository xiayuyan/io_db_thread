package com.xyy.io_db_thread;

import com.xyy.io_db_thread.utils.FTPUtil;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Map;

@SpringBootTest
class IoDbThreadApplicationTests {

    @Autowired
    private FTPUtil ftpUtil;

    @Value("${ftp.local.save.basepath}")
    private String localSavePath;
    @Value("${ftp.local.save.basefile}")
    private String localSavefile;

    @Test
    void contextLoads() {
    }
    @Test
    public void ftpDownloadTest() {
        Map<String, Object> result = ftpUtil.downLoadTableFile("", localSavePath);
        TestCase.assertEquals(true, result.get("result"));
    }

    @Test
    public void ftpUploadTest() throws FileNotFoundException, UnsupportedEncodingException {

        String str = localSavePath+"/"+localSavefile;
        InputStream fileInputStream = new FileInputStream(new File(str));

        String saveName = localSavefile;
        saveName = new String(saveName.getBytes("UTF-8"),"iso-8859-1");
        System.out.println(ftpUtil.upload("", fileInputStream, saveName));

    }
}
