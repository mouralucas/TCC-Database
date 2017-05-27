/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_retrieve;

import java.io.Serializable;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 *
 * @author lucas
 */
public class testRetrieveBook extends AbstractJavaSamplerClient implements Serializable {

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();

        return result;
    }

    public void retrieveBookByTitleOrAuthorOrSeriesOrPublisherOrISBN() {
        //isbn
        //title
        //author
        //serie
        //publisher

    }

}
