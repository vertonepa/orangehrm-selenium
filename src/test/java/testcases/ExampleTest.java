package testcases;

import annotations.ReportAnnotation;
import enums.Category;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.LoginPage;

public final class ExampleTest extends BaseTest {
    LoginPage lp = new LoginPage();

    private ExampleTest() {
    }

    @ReportAnnotation(author = "vertonepa", category = Category.EXAMPLE)
    @Test(description = "Validar que al logearse se redireccione al dashboard")
    public void testcase() {
        String header = lp.login("Admin", "admin123").getHeaderText();

        Assertions.assertThat(header).isEqualTo("Dashboard");
    }
}
