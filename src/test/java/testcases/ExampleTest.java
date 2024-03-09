package testcases;

import annotations.ReportAnnotation;
import enums.Category;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public final class ExampleTest extends BaseTest {
    DashboardPage dp = new DashboardPage();

    private ExampleTest() {
    }

    @ReportAnnotation(author = "vertonepa", category = Category.EXAMPLE)
    @Test(description = "Validar que al logearse se redireccione al dashboard")
    public void testcase() {
        String header = dp.getHeaderText();

        soft.assertThat(header).isEqualTo("Dashboard");
    }
}
