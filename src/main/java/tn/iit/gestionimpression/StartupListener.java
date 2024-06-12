package tn.iit.gestionimpression;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import tn.iit.gestionimpression.configuration.HibernateUtil;
import org.hibernate.Session;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try (Session session = HibernateUtil.getSession()) {
            System.out.println("Database connection successful");
        } catch (Exception e) {
            System.err.println("Error opening session. " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // This will be invoked when the application is shutting down
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            // MySQL driver leaves around a thread. This static method cleanup should be called on contextDestroyed.
            AbandonedConnectionCleanupThread.checkedShutdown();
        });

        executorService.shutdown();
        try {
            // Wait for the task to finish. If it doesn't finish in 10 seconds, continue with the shutdown process.
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("AbandonedConnectionCleanupThread did not finish within 10 seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}