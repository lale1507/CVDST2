package edu.eci.pdsw.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.pdsw.persistence.CommentsDao;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisCommentsDao;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.persistence.BlogDAO;
import edu.eci.pdsw.persistence.UserDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisBlogDAO;
import edu.eci.pdsw.persistence.mybatisimpl.MyBatisUserDAO;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.impl.BlogServicesImpl;


public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.MySQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

				// Blog
                bind(BlogServices.class).to(BlogServicesImpl.class);
                bind(BlogDAO.class).to(MyBatisBlogDAO.class);
				// Users
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(CommentsDao.class).to(MyBatisCommentsDao.class);
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}