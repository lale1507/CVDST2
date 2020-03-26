package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.entities.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;


import java.util.List;

public interface ComentMapper {

    List<Comment> loadAll(@Param("titulo") String title);

}
