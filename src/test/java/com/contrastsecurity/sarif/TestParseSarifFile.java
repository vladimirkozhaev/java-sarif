package com.contrastsecurity.sarif;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TestParseSarifFile {
    @Test
    public void testSARIFParse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Message res = objectMapper.readValue(
                new File("src/test/resources/scan_2023jan15_1615_unifiedcli_juiceshop.sarif"),
                Message.class);

        //run.getProperties().getTags().stream().forEach(s -> System.out.println("hello:"+s));
        assertEquals(3, res.getRuns().size());
        Run run = res.getRuns().get(1);
        Tool tool = run.getTool();
        assertNotNull(tool);
        assertNotNull(run.getResults());
        for (Result result : run.getResults()
        ) {
            System.out.println("-------------- result:" + result.getMessage().getText());
            for (Location location : result.getLocations()) {
                System.out.println("location uri:" + location.getPhysicalLocation().getArtifactLocation().getUri());
                Region region = location.getPhysicalLocation().getRegion();
                System.out.println("location region, startLine:" + region.getStartLine() +
                        ", startColumn:" + region.getStartColumn() +
                        ", endLine:" + region.getEndLine() + ", endColumn:" + region.getEndColumn());
            }
        }


    }
}
