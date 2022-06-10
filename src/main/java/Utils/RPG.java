package Utils;

import java.sql.Connection;

public class RPG {
    public static void main(String[] args) {
        Connection con = DBUtil.createConnectionFromProperties("res/db.properties");

    }
}
