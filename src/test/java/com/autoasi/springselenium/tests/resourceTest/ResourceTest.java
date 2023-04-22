package com.autoasi.springselenium.tests.resourceTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:/data/testdata.csv")
    private Resource csvResource;

    @Value("https://www.google.com")
    private Resource urlResource;

    @Value("https://www.w3.org/TR/WCAG10/wai-pageauth.txt")
    private Resource downloadResource;

    @Value("${screenshots.path}/FileFromUrl.txt")
    private Path path;

    @Test
    public void printLocalFileContentTest() throws IOException {
        Files.readAllLines(csvResource.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void printWebPageContentTest() throws IOException {
        System.out.println(new String(urlResource.getInputStream().readAllBytes()));
    }

    @Test
    public void downloadFileFromUrlTest() throws IOException {
        FileCopyUtils.copy(downloadResource.getInputStream(),Files.newOutputStream(path));
    }
}
