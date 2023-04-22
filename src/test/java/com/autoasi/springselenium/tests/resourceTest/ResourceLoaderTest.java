package com.autoasi.springselenium.tests.resourceTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLoaderTest extends SpringBaseTestNGTest {
    @Value("classpath:data/loadtestdata.csv")
    private Resource resource;

    @Value("${screenshots.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test(dataProvider = "getData")
    public void downloadMultipleResourcesFomUrlTest(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }
}
