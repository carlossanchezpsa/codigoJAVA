package com.inetpsa.boz.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.inetpsa.boz.common.constant.BozConstants;
import com.inetpsa.boz.common.log.LoggerManager;

/**
 * Classe qui gère la connexion avec la base de donnée
 * 
 * @author e210954
 * @version 1.0.0
 */

public final class DbManager {
    /** dataSource */
    private DataSource dataSource;

    /** singleton */
    private static DbManager instance;

    /** flag d'initilisation */
    private boolean init;

    /** Connection non poolée, version single_connection */
    private Connection singleConnection;

    /**
     * Retourne l'instance unique
     * 
     * @return DbManager singleton
     */
    public static DbManager getInstance() {
        if (!instance.getInit()) {
            if (instance.getDataSource() != null)
                verify(instance.getDataSource());
            instance.setInit(true);
        }
        return instance;
    }

    /**
     * Constructeur privé
     * 
     * @param ds
     *            Datasource
     */
    private DbManager(DataSource ds) {
        dataSource = ds;
    }

    /**
     * Création d'une dataSource à partir d'un fichier properties contenant les clés suivantes :
     * <li>URL </>
     * <li>user </>
     * <li>password </>
     * 
     * @return DataSource
     * @throws SQLException
     *             db connection error
     */
    public static Connection createConnection(String dbOracleSid, String dbUser, String dbPassword)
            throws SQLException, ClassNotFoundException {

        Class.forName(System.getProperty(BozConstants.BOZ_ORACLE_DRIVER));

        Connection con = DriverManager.getConnection(dbOracleSid, dbUser, dbPassword);

        return con;
    }

    /**
     * Retourne une connection
     * 
     * @return Connection connection
     */
    public Connection getConnection() {
        try {
            if (singleConnection == null) {
                Connection con = dataSource.getConnection();
                return con;
            } else {
                return singleConnection;
            }
        } catch (SQLException e) {
            LoggerManager.getInstance().printStackTrace(e);

            return null;
        }
    }

    /**
     * Vérifie si la source de données est correctement configuré Pour cela on ouvre un statement, si on
     * détecte une erreur, on lève une exception
     * 
     * @param ds
     *            datasource
     */
    private static void verify(DataSource ds) {
        Statement stmt;
        Connection con = null;

        try {
            con = ds.getConnection();

            stmt = con.createStatement();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            LoggerManager.getInstance().printStackTrace(e);
        }
    }

    /**
     * Sets the init
     * 
     * @param init
     *            The init to set
     */
    public void setInit(boolean init) {
        this.init = init;
    }

    /**
     * Gets the init
     * 
     * @return Returns a boolean
     */
    public boolean getInit() {
        return init;
    }

    /**
     * Gets the dataSource
     * 
     * @return Returns a DataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Initialisation du DbManager à partir d'un fichier properties qui va assurer la création d'une
     * DataSource à partir des clés suivantes :
     * <li>driver</li>
     * <li>URL </>
     * <li>user </>
     * <li>password </>
     * 
     * @return instance
     */
    public static DbManager create(String dbOracleSid, String dbUser, String dbPassword) throws SQLException,
            ClassNotFoundException {
        if (instance == null) {
            synchronized (DbManager.class) {
                Connection conn = null;
                if (instance == null) {

                    conn = createConnection(dbOracleSid, dbUser, dbPassword);

                    instance = new DbManager(null);
                    instance.singleConnection = conn;

                } // end of if (instance == null)

            } // end of synchronized(DbManager .class)
        }

        return instance;
    }

    /**
     * On restitue la connection que l'on a demandé
     * 
     * @param con
     *            connection
     * @throws SQLException
     *             erreur générée à la fermeture de la connexion
     */
    public void close(Connection con) throws SQLException {
        if (con != null && con != singleConnection) {
            con.close();
        }
    }

}