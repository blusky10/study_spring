package com.polpid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("server1")
public class SpringPropertiesTest {

    @Autowired
    private MyProperties myProperties;

    @Test
    public void applicationNameTest(){
        String applicationName = myProperties.getApplicationName();

        Assert.assertEquals("spring-test-properties", applicationName);
    }


}
