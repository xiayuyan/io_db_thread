package com.xyy.io_db_thread;

import com.xyy.io_db_thread.utils.FTPUtil;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

@SpringBootTest
class IoDbThreadApplicationTests {

    @Autowired
    private FTPUtil ftpUtil;

    @Value("${ftp.local.save.basepath}")
    private String localSavePath;

    @Test
    void contextLoads() {
    }
    @Test
    public void ftpDownloadTest() {
        Map<String, Object> result = ftpUtil.downLoadTableFile("", localSavePath);
        TestCase.assertEquals(true, result.get("result"));
    }

    @Test
    public void ftpUploadTest() throws FileNotFoundException {

//        String workingPath = "/home/lvhaibao/";
        String str = localSavePath+"/"+"待办.txt";
        InputStream fileInputStream = new FileInputStream(new File(str));
        String saveName = "待办.txt";
        System.out.println(ftpUtil.upload("", fileInputStream, saveName));

    }

}
