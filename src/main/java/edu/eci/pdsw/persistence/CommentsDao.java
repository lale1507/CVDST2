package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.Comment;

import java.util.List;

public interface CommentsDao {
    List<Comment> loadAll(String title) throws PersistenceException;
}
