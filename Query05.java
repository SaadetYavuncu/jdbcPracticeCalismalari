package jdbcPractice;

import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                "kemal1310beyza");

        Statement st = con.createStatement();

        //PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?, ?, ?, ?)");

        // ogrenciler tablosuna yeni bir kayıt ekleyin(300, 'Sena Can', 12 ,'K')

        //int s1 = st.executeUpdate("insert into ogrenciler values (302, 'Sena Can', 12 ,'K')");
        //System.out.println(s1 +" satir database'e eklendi");

        //Soru: Öğrenciler tablosuna birden fazla veri ekleyin
        //(400, 'Sena Can', 12 ,'K') (401, 'Sena Can', 12 ,'K') (402, 'Sena Can', 12 ,'K')



        //1. Yol
           /*
        for (int i = 500; i <504 ; i++) {
    st.executeUpdate("insert into ogrenciler values("+i+", 'Sena Can', 12, 'K')");
}
         */

        /*
        String [] veri ={"insert into ogrenciler values (400, 'Sena Can', 12 ,'K')",

                "insert into ogrenciler values (401, 'Sena Can', 12 ,'K')",
                "insert into ogrenciler values (402, 'Sena Can', 12 ,'K')"};




        int count=0;
        for(String each:veri){
            count = count + st.executeUpdate(each); //foreach ile arraydeki her bir query'i sırayla calistirip calisma
                                                       // sayisini count'a atiyoruz


        }
        System.out.println(count + "satir Eklendi");*/




        //2. Yol
        String [] veri2={"insert into ogrenciler values (500, 'Sena Can', 12 ,'K')",
                "insert into ogrenciler values (501, 'Sena Can', 12 ,'K')",
                "insert into ogrenciler values (502, 'Sena Can', 12 ,'K')"};

        for (String each:veri2) {
            st.addBatch(each);  //yukarıdaki dataların hepsini birleştiriyor

        }
        st.executeBatch();  //dataları tek sefer de gönderiyor


    }
}
