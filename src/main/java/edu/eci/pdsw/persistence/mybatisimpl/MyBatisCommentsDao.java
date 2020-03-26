package edu.eci.pdsw.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.CommentsDao;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.ComentMapper;

import java.util.List;

public class MyBatisCommentsDao implements CommentsDao {

    @Inject
    ComentMapper comentMapper;

    @Override
    public List<Comment> loadAll(String title) throws PersistenceException {
        try{
            return comentMapper.loadAll(title);
        }catch (Exception e){
            e.printStackTrace();
            throw new org.apache.ibatis.exceptions.PersistenceException("Load all persistence error");
        }

    }
}
