
package edu.eci.pdsw.managedbeans;

import java.util.List;

import javax.inject.Inject;

import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.ServicesException;



public class searchOffensiveUsers extends BasePageBean{

    @Inject
    private BlogServices blogServices;

    public List<Comment> getComments() throws Exception{
        try {
            return blogServices.searchOffensiveLanguageComments();
        } catch (ServicesException ex) {

            throw ex;
        }

    }
}
