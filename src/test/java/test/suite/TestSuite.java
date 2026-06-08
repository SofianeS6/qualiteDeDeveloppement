package test.suite;


import com.example.demo.data.VoitureTest;
import com.example.demo.service.StatistiqueImplTest;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;



@Suite
@SelectClasses({VoitureTest.class, StatistiqueImplTest.class})
public class TestSuite {


}