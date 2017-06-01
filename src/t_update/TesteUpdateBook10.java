/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_update;

import Conn.Connection;
import entities.Books;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import t_files.OpenTestFiles;

/**
 *
 * @author lucas
 */
public class TesteUpdateBook10 extends AbstractJavaSamplerClient implements Serializable {

    private boolean conn = Connection.setCon();
    OpenTestFiles openTestFiles = new OpenTestFiles();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private final String testSize = "10";
    
    Books books;
    
    List<String[]> updates = new ArrayList<>();

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();

        Connection.closeCon();
        return result;
    }

    public void testMethod() {
        SampleResult result = new SampleResult();
        updates = openTestFiles.open("update\\updateBooks", testSize);
        
        //precisa fazer a pesquisa do arquivo que será atualizado e setar os novos valores
        
        
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);

        Connection.closeCon();
    }
}
