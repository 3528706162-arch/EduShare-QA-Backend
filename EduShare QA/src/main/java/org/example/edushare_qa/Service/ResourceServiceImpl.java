package org.example.edushare_qa.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Mapper.ResourceMapper;
import org.example.edushare_qa.Pojo.ResourcesParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void add(ResourcesParam resourcesParam) {
        resourcesParam.setCreatedAt(LocalDateTime.now());
        resourceMapper.add(resourcesParam);
    }

    @Override
    public List<ResourcesParam> findAll() {
        List<ResourcesParam> resourcesParams = resourceMapper.findAll();
        return resourcesParams;
    }

    @Override
    public void addDownloadCount(Long id) {
        resourceMapper.addDownloadCount(id);
    }

    @Override
    public int findUploadCount(String username) {
        return resourceMapper.findUploadCount(username);
    }

    @Override
    public List<ResourcesParam> findByClassBelong(ResourcesParam resourceQueryParam) {
        List<ResourcesParam> resourcesParams = resourceMapper.findByClassBelong(resourceQueryParam);
        return resourcesParams;
    }

    @Override
    public void update(ResourcesParam resourcesParam) {
        resourceMapper.update(resourcesParam);
    }

    @Override
    public ResourcesParam getInfo(Integer id) {
        ResourcesParam resourcesParam = resourceMapper.selectById(id);
        return resourcesParam;
    }

    @Override
    public void delete(Integer id) {
        resourceMapper.delete(id);
    }

    @Override
    public void setPublic(String classBelong) {
        resourceMapper.setPublic(classBelong);
    }

    @Override
    public void setPrivate(String classBelong) {
        resourceMapper.setPrivate(classBelong);
    }
}
