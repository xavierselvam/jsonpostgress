package test;

import data.coinData;
import org.junit.Test;
import persist.coinDao;

public class coinDaoTest {
    coinData cd=new coinData("BTC","xx","xx","xx", "xx","xx" );
   @Test
    public void testDataInsert() {
       coinDao dao=new coinDao();
       dao.insertcoinDao(cd);
    }
}
