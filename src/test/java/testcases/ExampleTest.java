package testcases;

import annotations.ReportAnnotation;
import static enums.Category.EXAMPLE;
import org.testng.annotations.Test;
import pages.DashboardPage;

public final class ExampleTest extends BaseTest {
    private final DashboardPage dashboard = new DashboardPage();

    private ExampleTest() {
    }

    @ReportAnnotation(author = "vertonepa", category = EXAMPLE)
    @Test(description = "Validar redireccionar al dashboard al iniciar sesion")
    public void testcase() {
        String header = dashboard.getHeaderText();

        soft.assertThat(header).isEqualTo("Dashboard");
        soft.assertAll();
    }
}
