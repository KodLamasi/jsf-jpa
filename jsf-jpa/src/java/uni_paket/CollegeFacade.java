/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_paket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ftastemur
 */
@Stateless
public class CollegeFacade extends AbstractFacade<College> {
    @PersistenceContext(unitName = "jsf-jpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollegeFacade() {
        super(College.class);
    }
    
}
