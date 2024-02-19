/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author N.Maliki
 */
public class FactoryConnection {
    
    private SessionFactory factory = null;
	
	
	public SessionFactory getSessionFactory (){
		
		
		if(this.factory == null){
			Configuration conf = new AnnotationConfiguration().configure();
			this.factory = conf.buildSessionFactory();
		}
		
		return this.factory;
		
	}
}

