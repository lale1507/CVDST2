package edu.eci.pdsw.managedbeans;


import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "commentBean")
public class CommentBean extends BasePageBean {

    @ManagedProperty(value = "#{param.title}")
    private String title;

    @Inject
    private BlogServices blogServices;

    public List<Blog> getData() throws Exception {
        try {
            if (title == null) {
                return blogServices.listAll();
            } else {
                return blogServices.searchByUser(title);
            }
        } catch (ServicesException ex) {

            throw ex;
        }


    }
    /**
     * @return the tittle
     */
    public String getTitle(){
        return title;
    }

    /**
     * @return the tittle
     */
    public void setTitle(String title) {
        this.title = title;
    }



}
