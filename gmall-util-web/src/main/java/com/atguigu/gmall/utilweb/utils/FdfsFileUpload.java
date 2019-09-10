package com.atguigu.gmall.utilweb.utils;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author goolearn
 * @date 2019/9/9 0:02
 */

public class FdfsFileUpload {


    public String fileUpload(MultipartFile file) throws IOException, MyException {

        StringBuilder imgUrl = new StringBuilder(ConstantPropertiesUtils.SERVER_URL);
        String configFile = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(configFile);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String orginalFilename = file.getOriginalFilename();
        String extName = StringUtils.substringAfterLast(orginalFilename,".");

        String[] uploadFile = storageClient.upload_file(file.getBytes(), extName, null);

        for (String s : uploadFile) {
            imgUrl.append("/").append(s);
        }
        //http://47.103.143.137/group1/M00/00/00/rBPTY111JI2ACru9AAAl_GXv6Z4513.jpg
        System.out.println("imgUrl:" + imgUrl);
        return imgUrl.toString();
    }
}
