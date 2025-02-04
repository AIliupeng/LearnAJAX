package Tools.LinkDatabases;

import java.sql.SQLException;

public class SaveData {
    private LinkDatabases linkDatabases = null;

    private String sql = null;

    private boolean key = false;

    public void createLinkDatabases() throws ClassNotFoundException, SQLException {
        this.linkDatabases = new LinkDatabases();
    }

    public LinkDatabases getLinkDatabases() {
        return linkDatabases;
    }

    public void setLinkDatabases(LinkDatabases linkDatabases) {
        this.linkDatabases = linkDatabases;
    }

    public void createSQL() {
        this.sql = new String();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public void init() throws ClassNotFoundException, SQLException {
        this.createLinkDatabases();
        this.createSQL();
    }

    public SaveData(String sql) throws SQLException, ClassNotFoundException {
        this.init();
        this.setSql(sql);
        this.setKey(this.getLinkDatabases().saveData(this.getSql()));
    }
}
