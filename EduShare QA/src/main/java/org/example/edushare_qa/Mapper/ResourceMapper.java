package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.edushare_qa.Pojo.ResourcesParam;

import java.util.List;

@Mapper
public interface ResourceMapper {
    @Insert("insert into resources(title,description,file_type,file_url,class_belong,uploader_name,download_count,tags,created_at) values(#{title},#{description},#{fileType},#{fileUrl},#{classBelong},#{uploaderName},#{downloadCount},#{tags},#{createdAt})")
    void add(ResourcesParam resourcesParam);

    @Select("select * from resources")
    List<ResourcesParam> findAll();

    @Update("update resources set download_count=download_count+1 where id=#{id}")
    void addDownloadCount(Long id);

    @Select("select count(*) from resources where uploader_name=#{username}")
    int findUploadCount(String username);

    List<ResourcesParam> findByClassBelong(ResourcesParam resourceQueryParam);

    void update(ResourcesParam resourcesParam);

    @Select("select * from resources where id=#{id}")
    ResourcesParam selectById(Integer id);

    @Update("delete from resources where id=#{id}")
    void delete(Integer id);

    @Update("update resources set is_public=0 where class_belong=#{classBelong}")
    void setPublic(String classBelong);

    @Update("update resources set is_public=1 where class_belong= #{classBelong}")
    void setPrivate(String classBelong);
}
