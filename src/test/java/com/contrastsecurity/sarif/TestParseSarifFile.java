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
    public void testScan_2023jan15_1615_unifiedcli_juiceshop() throws IOException {
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

    @Test
    public void testScan_2023jan15_1613_unifiedcli_easybuggy() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Message res = objectMapper.readValue(
                new File("src/test/resources/scan_2023jan15_1613_unifiedcli_easybuggy.sarif"),
                Message.class);

        //run.getProperties().getTags().stream().forEach(s -> System.out.println("hello:"+s));
        assertEquals(1, res.getRuns().size());
        Run run = res.getRuns().get(0);
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


    @Test
    public void testScan_2023jan10_0927_webgoat() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Message res = objectMapper.readValue(
                new File("src/test/resources/scan_2023jan10_0927_webgoat.sarif"),
                Message.class);

        //run.getProperties().getTags().stream().forEach(s -> System.out.println("hello:"+s));
        assertEquals(2, res.getRuns().size());
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
