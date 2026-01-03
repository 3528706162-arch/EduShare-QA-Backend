package org.example.edushare_qa.Service;

import org.example.edushare_qa.Pojo.ResourcesParam;

import java.util.List;

public interface ResourceService {
    void add(ResourcesParam resourcesParam);

    List<ResourcesParam> findAll();

    void addDownloadCount(Long id);

    int findUploadCount(String username);

    List<ResourcesParam> findByClassBelong(ResourcesParam resourceQueryParam);

    void update(ResourcesParam resourcesParam);

    ResourcesParam getInfo(Integer id);

    void delete(Integer id);

    void setPublic(String classBelong);

    void setPrivate(String classBelong);
}
