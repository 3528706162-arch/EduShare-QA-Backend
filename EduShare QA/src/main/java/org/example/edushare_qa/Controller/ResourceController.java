package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.ResourcesParam;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resource")
@Slf4j
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * 上传资源
     *
     * @param ResourcesParam
     */
    @PostMapping("/upload")
    public Result upload(@RequestBody ResourcesParam ResourcesParam) {
        resourceService.add(ResourcesParam);
        return Result.success();
    }

    /**
     * 查询所有资源
     */
    @GetMapping("/findall")
    public Result findAll() {
        log.info("查询所有资源");
        List<ResourcesParam> list = resourceService.findAll();
        return Result.success(list);
    }

    /**
     * 增加下载数
     */
    @GetMapping("/addDownloadCount/{id}")
    public Result addDownloadCount(@PathVariable Long id) {
        log.info("增加下载数");
        resourceService.addDownloadCount(id);
        return Result.success();
    }

    /**
     * 查询当前用户上传资源数
     */
    @GetMapping("/findUploadCount/{username}")
    public Result findUploadCount(@PathVariable String username) {
        log.info("查询当前用户上传资源数");
        int count = resourceService.findUploadCount(username);
        return Result.success(count);
    }

    /**
     * 分类查询资源
     */
    @PostMapping("/findByItem")
    public Result findByClassBelong(@RequestBody ResourcesParam resourceQueryParam) {
        log.info("分类查询资源");
        List<ResourcesParam> list = resourceService.findByClassBelong(resourceQueryParam);
        return Result.success(list);
    }

    /**
     * 修改资源
     */
    @PutMapping
    public Result update(@RequestBody ResourcesParam resourcesParam) {
        log.info("修改资源,参数:{}", resourcesParam);
        resourceService.update(resourcesParam);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询回显,参数:{}", id);
        ResourcesParam resourcesParam = resourceService.getInfo(id);
        return Result.success(resourcesParam);
    }

    /**
     * 删除资源
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除资源,参数:{}", id);
        resourceService.delete(id);
        return Result.success();
    }
    /**
     * 基于课程所属设置资源不公开
     */
     @PostMapping("/setPrivate/{classBelong}")
    public Result setPublic(@PathVariable String classBelong) {
        log.info("基于课程所属设置资源不公开,参数:{}", classBelong);
        resourceService.setPublic(classBelong);
        return Result.success();
    }
    /**
     * 基于课程所属设置资源公开
     */
    @PostMapping("/setPublic/{classBelong}")
    public Result setPrivate(@PathVariable String classBelong) {
        log.info("基于课程所属设置资源公开,参数:{}", classBelong);
        resourceService.setPrivate(classBelong);
        return Result.success();
    }
}
