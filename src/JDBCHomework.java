import java.sql.*;

/**
 * Created by Csongor on 12/26/2016.
 */
public class JDBCHomework {
    	/*
create table utilizatori
(
id_utilizatori bigserial not null,
nume character (35),
parola character (25),
constraint pk_utilizatori primary key (id_utilizatori)
)

insert into utilizatori (nume, parola) values
('ionescu', 'tralala'),
('popescu', 'lalala'),
('alexandrescu', '3343290'),
('cristescu', 'dadada')
  */
	/*
create table cos
(
id_cos bigserial not null,
fkutilizatori bigint, fkproduse) values
('1', '1,3'),
fkproduse bigint,
constraint pk_cos primary key (id_cos),
foreign key (fkutilizatori) references utilizatori (id_utilizatori)
)

insert into cos (fkutilizatori,
('3', '5'),
('4', '2'),
('2', '4')

        */

	/*
create table produse
(
id_produse bigserial not null,
nume_produs character (35),
pret character (10),
id_utilizatori bigint,
id_cos bigint,
constraint pk_produse primary key (id_produse),
foreign key (id_utilizatori) references utilizatori(id_utilizatori),
foreign key (id_cos) references cos(id_cos)
)

insert into produse (nume_produs, pret) values
('telefon', '500'),
('tableta', '700'),
('laptop', '1500'),
('televizor', '1200'),
('aparat de barbierit', '250')
	 */

/*
insert into utilizatori (nume, parola) values
('ionescu', 'tralala'),
('popescu', 'lalala'),
('alexandrescu', '1111')
	 */

/* vizualizare cosul lui ionescu

select id_cos, id_produse from cos where id_utilizatori in( select id_utilizatori from utilizatori where nume = 'ionescu')
 */

/* sa se afiseze cosul lui ionescu/popescu....
select id_cos, id_produse from cos where id_utilizatori in( select id_utilizatori from utilizatori where nume = 'popescu')
 */

/* sa se afiseze cosul cu cele mai multe produse

 */


/*  lista userilor ordonata dupa numarul de produse din cos
select nume
from utilizatori
join cos
on utilizatori.id_utilizatori = cos.fkproduse
group by nume
order by count(*) asc
limit 5
 */




    public static void main(String[] args) {

        try {

            homeworkCreate();
            // homeworkUpdate();
            //  homeworkDelete();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void homeworkCreate() throws ClassNotFoundException, SQLException {

        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection parameters to database
        final String URL = "jdbc:postgresql://54.93.65.5:5432/5csongor";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement createLine = conn.prepareStatement("INSERT INTO utilizatori (NUME, PAROLA) VALUES (?,?)");
        createLine.setString(1, "ionescu");
        createLine.setString(2, "tralala");

        // 5. execute the prepared statement
        int rowsUpdate = createLine.executeUpdate();

        // 6. close connections
        createLine.close();
        conn.close();
    }

private static void homeworkUpdate() throws ClassNotFoundException, SQLException {
    // 1. load driver
    Class.forName("org.postgresgl.Driver");

    // 2. define connection to database
    final String URL = "jdbc:postgresql://54.93.65.5:5432/5csongor";
    final String USERNAME = "fasttrackit_dev";
    final String PASSWORD = "fasttrackit_dev";

    // 3. obtain a connection
    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    // 4. create a query statement
    PreparedStatement pst = conn.prepareStatement("UPDATE utilizatori SET NAME=? WHERE NAME=?");
    pst.setString(1, "");
    pst.setString(2, "");

    // 5. execute a prepared statement
    int rowsUpdate = pst.executeUpdate();

    // 6. close connections
    pst.close();
    conn.close();
}

private static void homeworkDelete() throws ClassNotFoundException, SQLException {

    // 1. load the driver
    Class.forName("org.postgresql.Driver");

    // 2. define connection parameters
    final String URL = "jdbc:postgresql://54.93.65.5:5432/5csongor";
    final String USERNAME = "fasttrackit_dev";
    final String PASSWORD = "fasttrackit_dev";

    // 3. obtain a connection
    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    // 4. create a query statement
    PreparedStatement pst = conn.prepareStatement("DELETE FROM utilizatori  WHERE nume=?");
    pst.setLong(1, 3);

    // 5. execute prepared statement
    int rowsDelete = pst.executeUpdate();
    System.out.println(rowsDelete + "rows wewre deleted.");

    // 6. close the objects
    pst.close();
    conn.close();
}




    }














