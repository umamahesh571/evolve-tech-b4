package com.evolve;

import com.evolve.controller.HomeController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeControllerTest {

    @Test
    public void testIndexContent() {
        HomeController controller = new HomeController();
        String response = controller.index();
        assertTrue(response.contains("DevOps course"));
    }
}