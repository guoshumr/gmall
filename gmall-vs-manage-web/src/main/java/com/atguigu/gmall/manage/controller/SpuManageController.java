package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.sku.SkuInfo;
import com.atguigu.gmall.bean.spu.BaseSaleAttr;
import com.atguigu.gmall.bean.spu.SpuImage;
import com.atguigu.gmall.bean.spu.SpuInfo;
import com.atguigu.gmall.bean.spu.SpuSaleAttr;
import com.atguigu.gmall.service.BaseSaleAttrService;
import com.atguigu.gmall.service.SpuService;
import com.atguigu.gmall.utilweb.utils.FdfsFileUpload;
import org.csource.common.MyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/8 20:31
 */
@RestController
@CrossOrigin
public class SpuManageController {

    @Reference
    private SpuService spuService;

    @Reference
    private BaseSaleAttrService baseSaleAttrService;

    @GetMapping("spuList")
    public List<SpuInfo> spuList(String catalog3Id){
        return spuService.spuList(catalog3Id);
    }

    @PostMapping("baseSaleAttrList")
    public List<BaseSaleAttr> baseSaleAttrList(){
        return baseSaleAttrService.baseSaleAttrList();
    }

    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file){
        String imgUrl = null;
        FdfsFileUpload fdfsFileUpload = new FdfsFileUpload();
        try {
            imgUrl = fdfsFileUpload.fileUpload(file);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return imgUrl;
    }


    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        System.out.println("spuInfo:" + spuInfo);
        spuService.saveSpuInfo(spuInfo);
        return "ok";
    }


    @GetMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        return spuService.spuSaleAttrList(spuId);
    }

    @GetMapping("spuImageList")
    public List<SpuImage> spuImageList(String spuId){
        return spuService.spuImageList(spuId);
    }

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody SkuInfo skuInfo){
        spuService.saveSkuInfo(skuInfo);
        return "ok";
    }
}
